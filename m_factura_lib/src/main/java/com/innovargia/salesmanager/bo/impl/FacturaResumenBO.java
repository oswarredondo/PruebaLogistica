/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.holders.StringHolder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.consecutivos.bo.AdminConsecutivosBO;
import com.administracion.dto.Factura;
import com.administracion.dto.FacturaDetalle;
import com.administracion.dto.FacturaGuia;
import com.administracion.idao.IConexionDAOJDBC;
import com.administracion.idao.IParamsSistemaDAO;
import com.administracion.jasperreport.IPrintReport;
import com.administracion.jasperreport.utils.ConstantesIReport;
import com.google.gson.JsonObject;
import com.innovargia.administracion.dto.LineaFacturaSAP;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IFacturaResumenBO;
import com.innovargia.salesmanager.idao.IFacturaResumenDAO;
import com.innovargia.utils.UtilsStrings;
import com.servicio.constantes.ConstantesGenerales;

import mc_style.functions.soap.sap.document.sap_com.Tvkot;
import mc_style.functions.soap.sap.document.sap_com.Tvstt;
import mc_style.functions.soap.sap.document.sap_com.ZDATOSVTASLOGISTICA_ServiceLocator;
import mc_style.functions.soap.sap.document.sap_com.ZVTASLOGISTICA_ServiceLocator;
import mc_style.functions.soap.sap.document.sap_com.ZsdAuart;
import mc_style.functions.soap.sap.document.sap_com.ZsdBaseCto;
import mc_style.functions.soap.sap.document.sap_com.ZsdWerks;
import mc_style.functions.soap.sap.document.sap_com.ZwsvtaslogisticaLocator;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfTlineHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfTvkotHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfTvsttHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdAuartHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdBaseCtoHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdVovPedidoHolder;
import mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdWerksHolder;

/**
 * @author aruaro
 * 
 */
@Service
public class FacturaResumenBO implements IFacturaResumenBO {

	private final int FACTURAR_CREAR = 1;
	private final int FACTURAR_CANCELAR = 2;
	private final int FACTURAR_NOTACREDITO = 3;
	
	private final String FACTURAR_CONTRATO = "CONTRATO";
	private final String FACTURAR_CONSUMO= "CONSUMO";
	private final String FACTURAR_PREPAGO= "PREPAGO";
	
	public static String ws_user = "";
	
	public static String ws_password = "";
	
	private static final Logger logger = LoggerFactory.getLogger(FacturaResumenBO.class);

	@Autowired
	IFacturaResumenDAO iFacturaResumenDAO;

	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;

	@Autowired
	AdminConsecutivosBO boConsecutivo;

	@Autowired
	IConexionDAOJDBC iReportesDAOJDBC;

	@Autowired
	IPrintReport iPrintReport;

	public FacturaResumenBO() {
	}

	@Override
	public int insert(Factura obj) throws Exception {
		
		int cant_registros =  iFacturaResumenDAO.cantidadRegistrosAMarcar(obj);
		
		if (cant_registros<=0){
			throw new Exception("No existen pendientes documentos a facturas del cliente [" + obj.getCliente()+ "]");
		}
		obj.setTipo(FACTURAR_CONTRATO);
		int idcontrol = iFacturaResumenDAO.insert(obj);
		obj.setIdcontrolenvio(UtilsStrings.completa(idcontrol + "", '0', 6, 1));
		obj.setIdcontrol(idcontrol);

		// Marca los documentos
		updateMarcaFacturaEnDocumento(obj);
		return idcontrol;
	}
	
	@Override
	public int insertConsumo(Factura obj) throws Exception {
		
		List<FacturaDetalle> lista=  iFacturaResumenDAO.cantidadRegistrosAMarcarConsumo(obj);
		
		if (lista.size()<=0){
			throw new Exception("No existen pendientes documentos de consumo a facturas del cliente [" + obj.getCliente()+ "]");
		}
		// TODO Auto-generated method stub
		obj.setTipo(FACTURAR_CONSUMO);		
		int idcontrol = iFacturaResumenDAO.insert(obj);
		obj.setIdcontrolenvio(UtilsStrings.completa(idcontrol + "", '0', 6, 1));
		obj.setIdcontrol(idcontrol);

		//Para cada convenio calcula el precio y actualiza los documentos
		List<FacturaDetalle> lista_a_facturar= new ArrayList<FacturaDetalle>();
		for (FacturaDetalle facturaDetalle : lista) {
			if (facturaDetalle.getCantidad()>0){
				obj.setIdconvenio(facturaDetalle.getIdconvenio());
				obj.setCantidad(facturaDetalle.getCantidad());
				// Marca los documentos
				updateMarcaFacturaEnDocumentoConsumo(obj);
				facturaDetalle.setIdfactura(idcontrol);
				//Agrega el detalle de la factura
				iFacturaResumenDAO.insert(facturaDetalle);
			}
		}
		return idcontrol;
	}

	@Override
	public void updateCancela(Factura obj) throws Exception {
		obj.setT_txt_head("CANCELADA POR " + obj.getLogin());
		obj.setT_txt_oper("");
		
		String factura = updateDesmarcaFacturaEnDocumento(obj);
		iFacturaResumenDAO.updateCancela(obj);

	}	

	@Override
	public void updateFactura(Factura obj) throws Exception {

		Factura reg = iFacturaResumenDAO.getRegistroById(obj);
		if (reg == null) {
			throw new Exception("Registro de corte no existe definido [" + obj.getIdcontrol() + "]");
		}
		reg.setFactura(reg.getFactura() == null ? "" : reg.getFactura().trim());
		if (!reg.getFactura().isEmpty()) {
			throw new Exception("Registro de corte [" + obj.getIdcontrol() + "] ya contiene una factura ["
					+ reg.getFactura() + "]");
		}
		reg.setT_txt_head(obj.getT_txt_head());
		reg.setT_txt_oper(obj.getT_txt_oper());
		reg.setPrctr(obj.getPrctr());
		
		/*DATOS DEL CATALOGO*/
		reg.setAuart(obj.getAuart());
		reg.setVkorg(obj.getVkorg());
		reg.setVstel(obj.getVstel());
		reg.setVtweg(obj.getVtweg());
		reg.setWerks(obj.getWerks());
		
		String factura =invocaWSSAP(FACTURAR_CREAR, reg);// mainOtro(); 
		reg.setFactura(factura);
		obj.setFactura(factura);
		//reg.setIdcontrolenvio(reg.getIdcontrolenvio());
		iFacturaResumenDAO.updateFactura(obj);

	}
	
	@Override
	public void notaCredito(Factura obj) throws Exception {

		Factura reg = iFacturaResumenDAO.getRegistroById(obj);
		if (reg == null) {
			throw new Exception("Registro de corte no existe definido [" + obj.getIdcontrol() + "]");
		}
		reg.setFactura(reg.getFactura() == null ? "" : reg.getFactura().trim());
		if (reg.getFactura().isEmpty()) {
			throw new Exception("Registro debe ser facturado antes de crear la nota de credito.");
		}
		reg.setT_txt_head(obj.getT_txt_head());
		reg.setT_txt_oper(obj.getT_txt_oper());
		String factura =invocaWSSAP(FACTURAR_NOTACREDITO, reg);
		reg.setFac_nota(factura);
		obj.setFac_nota(factura);
		iFacturaResumenDAO.updateNotaCredito(obj);

	}
	

	@Override
	public List<Factura> getRegistros(Factura obj) throws Exception {
		// TODO Auto-generated method stub
		return iFacturaResumenDAO.getRegistros(obj);
	}
	
	@Override
	public List<FacturaGuia> getRegistrosGuias(Factura obj) throws Exception {
		// TODO Auto-generated method stub
		return iFacturaResumenDAO.getRegistrosGuias(obj);
	}
	
	@Override
	public JsonObject generaExcel(Factura obj) throws Exception {
		// TODO Auto-generated method stub
		return iFacturaResumenDAO.generaExcel(obj);
	}
	
	@Override
	public String updateDesmarcaFacturaEnDocumento(Factura obj) throws Exception {
		Factura reg = iFacturaResumenDAO.getRegistroById(obj);
		if (reg == null) {
			throw new Exception("Registro de corte no existe definido [" + obj.getIdcontrol() + "]");
		}
		reg.setFactura(reg.getFactura() == null ? "" : reg.getFactura().trim());
		

		if (reg.getCantidad() > 0) {
			iFacturaResumenDAO.updateDesmarcaFacturaEnDocumento(obj);
		}
		
		if (!reg.getFactura().isEmpty()) {
			logger.debug("Invocando WS para cancelar factura;" + reg.getFactura());
			reg.setT_txt_head(obj.getT_txt_head());
			reg.setT_txt_oper(obj.getT_txt_oper());
			return invocaWSSAP(FACTURAR_CANCELAR,  reg);
			
			//throw new Exception("Registro de corte [" + obj.getIdcontrol() + "] ya contiene una factura ["
			//		+ reg.getFactura() + "]");
		}
		
		return null;
	}

	@Override
	public void updateMarcaFacturaEnDocumento(Factura obj) throws Exception {
		iFacturaResumenDAO.updateMarcaFacturaEnDocumento(obj);

	}
	
	@Override
	public void updateMarcaFacturaEnDocumentoConsumo(Factura obj) throws Exception {
		iFacturaResumenDAO.updateMarcaFacturaEnDocumentoConsumo(obj);

	}

	@Override
	public byte[] generarPDF(Factura factura, Map<String, Object> parameters, UsuarioDTO usuario) {

		byte[] bytes = null;
		Connection cnx = null;
		try {

			// Guarda el archivo
			logger.debug("Generando reporte :" + factura.getIdcontrolenvio());
			String path_formatos_reporte_jasper = iParamsSistemaDAO
					.getValorPropiedad(ConstantesGenerales.PATHIREPORTJASPER, ConstantesGenerales.ID_SKY4SOL);
			logger.debug("path_formatos_reporte_jasper :" + path_formatos_reporte_jasper);
			String tipodocumento = "FACTURADO";
			if (FACTURAR_CONSUMO.equals(factura.getTipo())){
				tipodocumento = "FACTURADO_CONSUMO";
			}

			MetaDatoCatalogoDTO metaDocumento = boConsecutivo.getMetaDatoCatalogoDTO(tipodocumento,
					usuario.entidad.getIdentidad(), usuario.organizacion.getIdorganizacion());
			logger.debug("Generando reporte tipo :" + metaDocumento.getFormatoiReport());

			if (metaDocumento != null) {
				String reportejasper = path_formatos_reporte_jasper + metaDocumento.getFormatoiReport();
				logger.debug("reportejasper :" + reportejasper);
				cnx = iReportesDAOJDBC.getConexion();
				//Tipo de Reporte 
				if(factura.getTipoB().equals("pdf"))
					bytes = iPrintReport.genera(ConstantesIReport.TIPO_PDF, parameters, reportejasper, cnx);
				else if(factura.getTipoB().equals("xls"))
					bytes = iPrintReport.genera(ConstantesIReport.TIPO_EXCEL, parameters, reportejasper, cnx);
				else
					bytes = iPrintReport.genera(ConstantesIReport.TIPO_PDF, parameters, reportejasper, cnx);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			iReportesDAOJDBC.closeConecction(cnx);
		}
		return bytes;

	}

	private String invocaWSSAP(int tipoInvocacion, Factura obj) throws Exception {
		// 1= Facturar, 2=Cancelar

		ws_user = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.user", "TRACUSA");
		ws_password = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.password", "TRACUSA");
		String ws_endpoint = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.endpoint", "TRACUSA");

		if (ws_user == null) {
			throw new Exception("Usuario del servicio web no esta definido[tracusa.sap.ws.user]");
		}

		if (ws_password == null) {
			throw new Exception("Password del servicio web no esta definido[tracusa.sap.ws.password]");
		}

		if (ws_endpoint == null) {
			throw new Exception("Endpoint del servicio web no esta definido[tracusa.sap.ws.endpoint]");
		}

		// Obtiene la linea de encabezado
		LineaFacturaSAP encabezado = null;
		if (FACTURAR_CREAR == tipoInvocacion) {
			encabezado= iFacturaResumenDAO.getParametroGeneraFactura("G", "F");
		}else if (FACTURAR_CANCELAR == tipoInvocacion) {
			encabezado= iFacturaResumenDAO.getParametroGeneraFactura("C", "F");
		}else if (FACTURAR_NOTACREDITO == tipoInvocacion) {
			encabezado= iFacturaResumenDAO.getParametroGeneraFactura("N", "F");	
			if (encabezado == null ){
				encabezado = new LineaFacturaSAP();
			}
			encabezado.setIdsapparametros(99);
			encabezado.setP_proceso("G");
			encabezado.setP_tipo("N");
			encabezado.setP_spart("15");
			encabezado.setP_zterm("D006");
		}else{
			return "";
		}
		
		if (encabezado == null) {
			String mensaje = tipoInvocacion==FACTURAR_NOTACREDITO?"Nota de credito (N)":"";
			mensaje = tipoInvocacion==FACTURAR_CREAR?"Crear factura(F)  ":"";
			mensaje = tipoInvocacion==FACTURAR_CANCELAR?"Cancelar factura(C)  ":"";
			throw new Exception("No existen datos de encabezado pra " + mensaje +" en sapparametros.");
		}
		

		CuentasDTO cliente = iFacturaResumenDAO.getDatosCliente(obj.getCliente());
		if (cliente==null){
			throw new Exception("Datos del cliente[."+obj.getCliente() + "] no definidos.");

		}
		
		int cantidaddocumentos = iFacturaResumenDAO.cantidadRegistrosMarcados(obj);
		List<LineaFacturaSAP> lineas_sap = new ArrayList<LineaFacturaSAP>();
		//Obtiene las lineas dependiendo del tipo de movimiento que se esta realizando
		if (FACTURAR_NOTACREDITO== tipoInvocacion) {
			lineas_sap = iFacturaResumenDAO.getLineasFacturadas(obj.getIdcontrolenvio());
		}else{
			lineas_sap = iFacturaResumenDAO.getLineas(obj.getIdcontrolenvio());
		}
		//Solo valida las lineas para una creacion de factura y nota de credito
		if (FACTURAR_CANCELAR!= tipoInvocacion) {
			if (lineas_sap.size() <= 0) {
				throw new Exception("No existen lineas detalle para crear factura SAP " + obj.getIdcontrolenvio());
			}
		}
		

		// Comienza el proceso de invocacion del WS
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(ws_endpoint);
//			endpoint = new java.net.URL("http://sapqas.tracusa.com.mx:8010/sap/bc/srt/rfc/sap/zvtaslogistica/300/zvtaslogistica/zvtaslogistica");
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}

//		ZwsvtaslogisticaLocator locator = new ZwsvtaslogisticaLocator();
//		mc_style.functions.soap.sap.document.sap_com.ZVTASLOGISTICA proxy = locator.getzwsvtaslogistica(endpoint);
		
		ZVTASLOGISTICA_ServiceLocator locator = new ZVTASLOGISTICA_ServiceLocator();
		mc_style.functions.soap.sap.document.sap_com.ZVTASLOGISTICA_PortType proxy = locator.getZVTASLOGISTICA(endpoint);

		java.lang.String PBstkd =   obj.getIdcontrolenvio(); //cliente.getRazonSocial()==null?"": cliente.getRazonSocial().trim();
		java.lang.String PCorreo = cliente.getCorreoe()==null?"": cliente.getCorreoe(); // falto definir
		java.lang.String PDocumento = "G";//encabezado.getPdocumento();// falto definir
		java.lang.String PKunnr = cliente.getNumCliente();//encabezado.getP_kunnr();
		java.lang.String PNumdocLog = cantidaddocumentos+""; // falto
																	// definir
		java.lang.String PProceso = encabezado.getP_proceso();
		java.lang.String PSpart = encabezado.getP_spart();
		java.lang.String PTipo = encabezado.getP_tipo();
		java.lang.String PZterm = encabezado.getP_zterm();
		
		/*DATOS DEL CATALOGO*/
		java.lang.String PAuart = obj.getAuart();
		java.lang.String PVkorg = obj.getVkorg();
		java.lang.String PVstel = obj.getVstel();
		java.lang.String PVtweg = obj.getVtweg();
		java.lang.String PWerks = obj.getWerks();
		
		mc_style.functions.soap.sap.document.sap_com.Tline[] arr_Tline = new mc_style.functions.soap.sap.document.sap_com.Tline[1];
		mc_style.functions.soap.sap.document.sap_com.Tline item1 = new mc_style.functions.soap.sap.document.sap_com.Tline();
		
		if (FACTURAR_NOTACREDITO != tipoInvocacion) {
			//item1.setTdline("FACTURACION LOGISTICA");
			item1.setTdline(obj.getT_txt_head());
			item1.setTdformat("");
		}else{
			item1.setTdline(obj.getT_txt_head());
			item1.setTdformat("");
		}
		
		arr_Tline[0] = item1;
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfTlineHolder TTxtHead = new TableOfTlineHolder(
				arr_Tline);

		mc_style.functions.soap.sap.document.sap_com.Tline[] arr_Tline2 = new mc_style.functions.soap.sap.document.sap_com.Tline[1];
		mc_style.functions.soap.sap.document.sap_com.Tline item2 = new mc_style.functions.soap.sap.document.sap_com.Tline();
		if (FACTURAR_NOTACREDITO!= tipoInvocacion) {
			//item2.setTdline("FACTURACION LOGISTICA");
			item2.setTdline(obj.getT_txt_oper());
			item2.setTdformat("");
		}else{
			item2.setTdline(obj.getT_txt_oper());
			item2.setTdformat("");
		}
		arr_Tline2[0] = item2;

		mc_style.functions.soap.sap.document.sap_com.holders.TableOfTlineHolder TTxtOper = new TableOfTlineHolder(
				arr_Tline2);
		javax.xml.rpc.holders.StringHolder PDocfi = new StringHolder("");

		javax.xml.rpc.holders.StringHolder PFactura = new StringHolder("");
		javax.xml.rpc.holders.StringHolder PMensaje = new StringHolder("");
		javax.xml.rpc.holders.StringHolder PPedido = new StringHolder("");
		javax.xml.rpc.holders.StringHolder PResultado = new StringHolder("");
		
		String resultado= "TIPO INVALIDO";
		logger.debug("TIPO DE OPERACON A REALIZAR FACTURA:" + tipoInvocacion  );
		if (FACTURAR_CREAR == tipoInvocacion) {

			mc_style.functions.soap.sap.document.sap_com.ZsdVovPedido[] ar_ZsdVovPedido = 
					new mc_style.functions.soap.sap.document.sap_com.ZsdVovPedido[lineas_sap.size()];
			mc_style.functions.soap.sap.document.sap_com.ZsdVovPedido item = null;
			int i=0;
			for (LineaFacturaSAP linea : lineas_sap) {
				item = new mc_style.functions.soap.sap.document.sap_com.ZsdVovPedido();
				item.setPosnr(linea.getRow_number() + "");
				item.setMatnr(linea.getMaterialsap());
				item.setZmeng(linea.getCantidad() + "");
				item.setZieme("SER");
				item.setPrctr(obj.getPrctr());
				item.setNetpr(linea.getImporte() + "");
				ar_ZsdVovPedido[i++] = item;
			}
			mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdVovPedidoHolder TMov = new TableOfZsdVovPedidoHolder(
					ar_ZsdVovPedido);

			
		
//			proxy.zsdVentasLogistica(Bstkd, PCorreo, PDocumento, PKunnr, PNumdocLog, PProceso, PSpart, PTipo, PZterm,
//					TMov, TTxtHead, TTxtOper, PDocfi, PFactura, PMensaje, PPedido, PResultado);
			
			proxy.zsdVentasLogistica(PAuart, PBstkd, PCorreo, PDocumento, PKunnr, PNumdocLog, PProceso, PSpart, PTipo, 
					PVkorg, PVstel, PVtweg, PWerks, PZterm, TMov, TTxtHead, TTxtOper, PDocfi, PFactura, PMensaje, PPedido, PResultado);

			logger.debug("Resultado invocacion WS SAP ----");
			logger.debug("PDocfi ----:" +PDocfi.value);
			logger.debug("PFactura ----:" + PFactura.value);
			logger.debug("PMensaje ----:" + PMensaje.value);
			logger.debug("PPedido ----:" + PPedido.value);
			logger.debug("PResultado ----:" + PResultado.value);
			
			if ((PFactura == null) || (PFactura.value.trim().isEmpty())) {
				throw new Exception("El servicio devolvio una factura vacia[" + PMensaje.value + "]");
			}

			resultado =  PFactura.value;
		}else if (FACTURAR_CANCELAR == tipoInvocacion) {
			PFactura.value = obj.getFactura();
			PDocumento = obj.getFactura();
			PTipo = "F";
			PProceso ="C";
			
			logger.debug("INVOCANDO WS CANCELAR FACTURA:" + PFactura.value  );
			logger.debug("Bstkd: " + PBstkd  );
			logger.debug("PDocumento: " + PDocumento  );
			logger.debug("PTipo: " + PTipo  );
			logger.debug("PProceso: " + PProceso  );
			
			mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdVovPedidoHolder TMov = new TableOfZsdVovPedidoHolder();
			
//			proxy.zsdVentasLogistica(Bstkd, PCorreo, PDocumento, PKunnr, PNumdocLog, PProceso, PSpart, PTipo, PZterm,
//					TMov, TTxtHead, TTxtOper, PDocfi, PFactura, PMensaje, PPedido, PResultado);
			
			proxy.zsdVentasLogistica(PAuart, PBstkd, PCorreo, PDocumento, PKunnr, PNumdocLog, PProceso, PSpart, PTipo, PVkorg, 
					PVstel, PVtweg, PWerks, PZterm, TMov, TTxtHead, TTxtOper, PDocfi, PFactura, PMensaje, PPedido, PResultado);
			
			logger.debug("Resultado invocacion WS SAP CANCELAR ---:");
			logger.debug("PDocfi ----:" +PDocfi.value);
			logger.debug("PFactura ----:" + PFactura.value);
			logger.debug("PMensaje ----:" + PMensaje.value);
			logger.debug("PPedido ----:" + PPedido.value);
			logger.debug("PResultado ----:" + PResultado.value);
			
			resultado= PResultado.value;
		}else if (FACTURAR_NOTACREDITO == tipoInvocacion) {
			PFactura.value = obj.getFactura();
			PDocumento = obj.getFactura();
			PTipo = "N";
			
			mc_style.functions.soap.sap.document.sap_com.ZsdVovPedido[] ar_ZsdVovPedido = 
					new mc_style.functions.soap.sap.document.sap_com.ZsdVovPedido[lineas_sap.size()];
			mc_style.functions.soap.sap.document.sap_com.ZsdVovPedido item = null;
			int i=0;
			for (LineaFacturaSAP linea : lineas_sap) {
				item = new mc_style.functions.soap.sap.document.sap_com.ZsdVovPedido();
				item.setPosnr(linea.getRow_number() + "");
				item.setMatnr(linea.getMaterialsap());
				item.setZmeng(linea.getCantidad() + "");
				item.setZieme("SER");
				item.setPrctr(obj.getPrctr());
				item.setNetpr(linea.getImporte() + "");
				ar_ZsdVovPedido[i++] = item;
			}
			mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdVovPedidoHolder TMov = new TableOfZsdVovPedidoHolder(
					ar_ZsdVovPedido);
			
			logger.debug("Resultado invocacion WS SAP NOTA CREDITO ---:" +
			"PFactura:" + PFactura + ",PDocumento:" + PDocumento + ",PTipo:" + PTipo +
			",TTxtHead:" + obj.getT_txt_head() + ",TTxtOper:" + obj.getT_txt_oper());

//			proxy.zsdVentasLogistica(PBstkd, PCorreo, PDocumento, PKunnr, PNumdocLog, PProceso, PSpart, PTipo, PZterm,
//					TMov, TTxtHead, TTxtOper, PDocfi, PFactura, PMensaje, PPedido, PResultado);
			
			proxy.zsdVentasLogistica(PAuart, PBstkd, PCorreo, PDocumento, PKunnr, PNumdocLog, PProceso, PSpart, PTipo, PVkorg, 
					PVstel, PVtweg, PWerks, PZterm, TMov, TTxtHead, TTxtOper, PDocfi, PFactura, PMensaje, PPedido, PResultado);

			logger.debug("PDocfi ----:" +PDocfi.value);
			logger.debug("PFactura ----:" + PFactura.value);
			logger.debug("PMensaje ----:" + PMensaje.value);
			logger.debug("PPedido ----:" + PPedido.value);
			logger.debug("PResultado ----:" + PResultado.value);
			
			resultado= PFactura.value;
		}
		
		return resultado;
	}
	
	
	private String mainOtro()throws Exception {
		
		  java.lang.String url = "http://201.175.38.103:8010/sap/bc/srt/rfc/sap/zvtaslogistica/200/zwsvtaslogistica/zwsvtaslogistica";
		
		  
		java.net.URL endpoint;
      try {
          endpoint = new java.net.URL(url);
      }
      catch (java.net.MalformedURLException e) {
          throw new javax.xml.rpc.ServiceException(e);
      }
      
      ZwsvtaslogisticaLocator locator  = new ZwsvtaslogisticaLocator();
      mc_style.functions.soap.sap.document.sap_com.ZVTASLOGISTICA proxy = 
      		locator.getzwsvtaslogistica(endpoint);
      
     /* BindingProvider provider = (BindingProvider) proxy;
		provider.getRequestContext().put(BindingProvider.USERNAME_PROPERTY,
				"lmhernandez");
		provider.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,
				"6ESTRELLAS");*/
		
      
      java.lang.String Bstkd="PRUEBA LOGISTICA10"; 
		java.lang.String PCorreo="hector@chazam.com.mx"; 
		java.lang.String PDocumento="G"; 
		java.lang.String PKunnr="0000100215"; 
		java.lang.String PNumdocLog="1"; 
		java.lang.String PProceso="G"; 
		java.lang.String PSpart="15"; 
		java.lang.String PTipo="F"; 
		java.lang.String PZterm="D006"; 
		
		mc_style.functions.soap.sap.document.sap_com.ZsdVovPedido[] ar_ZsdVovPedido = new mc_style.functions.soap.sap.document.sap_com.ZsdVovPedido[1];
		mc_style.functions.soap.sap.document.sap_com.ZsdVovPedido item = new mc_style.functions.soap.sap.document.sap_com.ZsdVovPedido();
		
		item.setPosnr("10");
       item.setMatnr("13131");
       item.setZmeng("4");
       item.setZieme("SER");
       item.setPrctr("984005");
       item.setNetpr("50");
       ar_ZsdVovPedido[0]= item;
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdVovPedidoHolder TMov= new TableOfZsdVovPedidoHolder(ar_ZsdVovPedido); 
		
		

		mc_style.functions.soap.sap.document.sap_com.Tline[] arr_Tline = new mc_style.functions.soap.sap.document.sap_com.Tline[1];
		mc_style.functions.soap.sap.document.sap_com.Tline item1 = new mc_style.functions.soap.sap.document.sap_com.Tline();
		item1.setTdline("PEDIDO DE PRUEBA");
		item1.setTdformat("");
		arr_Tline[0] = item1;
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfTlineHolder TTxtHead=new TableOfTlineHolder(arr_Tline); 
		
		mc_style.functions.soap.sap.document.sap_com.Tline[] arr_Tline2 = new mc_style.functions.soap.sap.document.sap_com.Tline[1];
		mc_style.functions.soap.sap.document.sap_com.Tline item2 = new mc_style.functions.soap.sap.document.sap_com.Tline();
		item2.setTdline("PEDIDO DE PRUEBA");
		item2.setTdformat("");
		arr_Tline2[0] = item2;

		
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfTlineHolder TTxtOper=new TableOfTlineHolder(arr_Tline2) ; 
		javax.xml.rpc.holders.StringHolder PDocfi=new StringHolder("dddddd");
		
		javax.xml.rpc.holders.StringHolder PFactura=new StringHolder("dddddd");
		javax.xml.rpc.holders.StringHolder PMensaje=new StringHolder("ddddd"); 
		javax.xml.rpc.holders.StringHolder PPedido=new StringHolder("dddddddddd"); 
		javax.xml.rpc.holders.StringHolder PResultado=new StringHolder("ddddd");
		
      proxy.zsdVentasLogistica(
      		Bstkd,
      		 PCorreo, 
      		 PDocumento, 
      		 PKunnr, 
      		 PNumdocLog, 
      		PProceso, 
      		 PSpart, 
      		PTipo, 
      		 PZterm, 
      		 TMov, 
      		 TTxtHead, 
      		 TTxtOper, 
      		 PDocfi, PFactura, 
      		PMensaje, 
      		 PPedido, 
      		 PResultado);
      
      System.out.println(PFactura.value);
      
      return "000000";

	}
	
	@Override
	public List<ZsdAuart> getAuart() throws Exception {
		
		/* Se crea la lista de datos */
		List<ZsdAuart> itAuart = new ArrayList<ZsdAuart>();
		
		/* Se invoca el metodo que trae los datos del
		 * catalogo pero unicamente regresa los datos 
		 * de la tabla itAUART */
		itAuart = invocaWSSAPCATALOGODATOSitAuart();

		
		return itAuart;
	}
	
	@Override
	public List<Tvkot> getTvkot() throws Exception {
		
		List<Tvkot> itTvkot = new ArrayList<Tvkot>();
				
		itTvkot = invocaWSSAPCATALOGODATOSitTvkot();

		
		return itTvkot;
	}
	
	@Override
	public List<ZsdBaseCto> getVtweg() throws Exception {
		
		List<ZsdBaseCto> itVtweg = new ArrayList<ZsdBaseCto>();
				
		itVtweg = invocaWSSAPCATALOGODATOSitVtweg();

		
		return itVtweg;
	}
	
	@Override
	public List<ZsdWerks> getWerks() throws Exception {
		
		List<ZsdWerks> itWerks = new ArrayList<ZsdWerks>();
				
		itWerks = invocaWSSAPCATALOGODATOSitWerks();

		
		return itWerks;
	}
	
	@Override
	public List<Tvstt> getTvstt() throws Exception {
		
		List<Tvstt> itTvstt = new ArrayList<Tvstt>();
				
		itTvstt = invocaWSSAPCATALOGODATOSitTvstt();

		
		return itTvstt;
	}
	
	private List<ZsdAuart> invocaWSSAPCATALOGODATOSitAuart() throws Exception {

		/* Se declaro al inicio de esta clase ws_user y ws_password como public static
		 * con la finalidad de usar el usuario y contraseña obtenidos mediante el sistema
		 * en las clases autogeneradas con Axis1.4 */
		
		/* Se obtiene el usuario y contraseña para el web sevice desde BD */
		ws_user = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.user", "TRACUSA");
		ws_password = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.password", "TRACUSA");
		
		/* Se obtiene La url o "ENDPOINT" para el web sevice desde BD */
		String ws_endpoint = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.catalogo.endpoint", "TRACUSA");
		
		/* Validamos que usuario, password y endpoint no vengan vacios*/
		if (ws_user == null) {
			throw new Exception("Usuario del servicio web no esta definido[tracusa.sap.ws.user]");
		}

		if (ws_password == null) {
			throw new Exception("Password del servicio web no esta definido[tracusa.sap.ws.password]");
		}

		if (ws_endpoint == null) {
			throw new Exception("Endpoint del servicio web no esta definido[tracusa.sap.ws.catalogo.endpoint]");
		}
		
		/* Apartir de este punto comienza el proceso de invocacion del WS */
		
		/* Se crea una variable tipo URL para conectarnos al WS */
		java.net.URL endpoint;
		
		try {
			
			/* La variable de tipo URL la igualamos a la URL o ENDPOINT que obtuvimos de nuestra BD */
			endpoint = new java.net.URL(ws_endpoint);
			
//			endpoint = new java.net.URL("http://SAPQAS.tracusa.com.mx:8010/sap/bc/srt/rfc/sap/zdatosvtaslogistica/300/zdatosvtaslogistica/zdatosvtaslogistica");
		
		} catch (java.net.MalformedURLException e) {
			
			throw new javax.xml.rpc.ServiceException(e);
		
		}
		
		/* Instancia de la clase creada con Axis 1.4 a partir de nuestro WSDL */
		ZDATOSVTASLOGISTICA_ServiceLocator locator = new ZDATOSVTASLOGISTICA_ServiceLocator();
		
		/* Pasamos el endpoint que contiene nuestra URL de BD a la clase autogenerada por Axis 1.4 a partir
		 * de nuestro WSDL */
		mc_style.functions.soap.sap.document.sap_com.ZDATOSVTASLOGISTICA_PortType proxy = locator.getZDATOSVTASLOGISTICA(endpoint);
		
		/* Instancia de las variables que envia y recibe nuestro WSDL */
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdAuartHolder itAuart = new TableOfZsdAuartHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfTvkotHolder itTvkot = new TableOfTvkotHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfTvsttHolder itTvstt = new TableOfTvsttHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdBaseCtoHolder itVtweg = new TableOfZsdBaseCtoHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdWerksHolder itWerks = new TableOfZsdWerksHolder();
		
		/* Aqui llamamos el metodo que se conectara al WS y nos regresara los datos
		 * para cualquier duda sobre su funcionamiento se recomienda entrar al metodo
		 * o clase y navegar por el codigo autogenerado para su mayor comprencion*/
		proxy.zsdDatosVentasLogistica(itAuart, itTvkot, itTvstt, itVtweg, itWerks);
		
		/* En este punto el WS ya debio responder y las variables que enviamos ya deben tener los datos
		 * que se obtienen en el WSDL, aqui solo creamos un arreglo y le pasamos los datos de la tabla*/
		mc_style.functions.soap.sap.document.sap_com.ZsdAuart[] itAuartARRAY = itAuart.value;
			
		
		/* Parseamos de arreglo a Lista paa poder asi regresarla al front-end y 
		 * mostrarla en el combobox */
		List<ZsdAuart> listitAuart = Arrays.asList(itAuartARRAY);
			
		logger.debug("Resultado invocacion WS SAP ----");
		logger.debug("itAuart ----:" + itAuart.value);
		logger.debug("itTvkot ----:" + itTvkot.value);
		logger.debug("itTvstt ----:" + itTvstt.value);
		logger.debug("itVtweg ----:" + itVtweg.value);
		logger.debug("itWerks ----:" + itWerks.value);
		
		return listitAuart;
	}
	
	private List<Tvkot> invocaWSSAPCATALOGODATOSitTvkot() throws Exception {


		ws_user = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.user", "TRACUSA");
		ws_password = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.password", "TRACUSA");
		String ws_endpoint = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.catalogo.endpoint", "TRACUSA");

		if (ws_user == null) {
			throw new Exception("Usuario del servicio web no esta definido[tracusa.sap.ws.user]");
		}

		if (ws_password == null) {
			throw new Exception("Password del servicio web no esta definido[tracusa.sap.ws.password]");
		}

		if (ws_endpoint == null) {
			throw new Exception("Endpoint del servicio web no esta definido[tracusa.sap.ws.catalogo.endpoint]");
		}
		
		// Comienza el proceso de invocacion del WS
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(ws_endpoint);
//			endpoint = new java.net.URL("http://SAPQAS.tracusa.com.mx:8010/sap/bc/srt/rfc/sap/zdatosvtaslogistica/300/zdatosvtaslogistica/zdatosvtaslogistica");
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		
		ZDATOSVTASLOGISTICA_ServiceLocator locator = new ZDATOSVTASLOGISTICA_ServiceLocator();
		mc_style.functions.soap.sap.document.sap_com.ZDATOSVTASLOGISTICA_PortType proxy = locator.getZDATOSVTASLOGISTICA(endpoint);

		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdAuartHolder itAuart = new TableOfZsdAuartHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfTvkotHolder itTvkot = new TableOfTvkotHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfTvsttHolder itTvstt = new TableOfTvsttHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdBaseCtoHolder itVtweg = new TableOfZsdBaseCtoHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdWerksHolder itWerks = new TableOfZsdWerksHolder();
		
		proxy.zsdDatosVentasLogistica(itAuart, itTvkot, itTvstt, itVtweg, itWerks);

		mc_style.functions.soap.sap.document.sap_com.Tvkot[] itTvkotARRAY = itTvkot.value;
			
		List<Tvkot> listitTvkot = Arrays.asList(itTvkotARRAY);
			
		logger.debug("Resultado invocacion WS SAP ----");
		logger.debug("itAuart ----:" + itAuart.value);
		logger.debug("itTvkot ----:" + itTvkot.value);
		logger.debug("itTvstt ----:" + itTvstt.value);
		logger.debug("itVtweg ----:" + itVtweg.value);
		logger.debug("itWerks ----:" + itWerks.value);
		
		return listitTvkot;
	}
	
	private List<Tvstt> invocaWSSAPCATALOGODATOSitTvstt() throws Exception {

		ws_user = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.user", "TRACUSA");
		ws_password = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.password", "TRACUSA");
		String ws_endpoint = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.catalogo.endpoint", "TRACUSA");

		if (ws_user == null) {
			throw new Exception("Usuario del servicio web no esta definido[tracusa.sap.ws.user]");
		}

		if (ws_password == null) {
			throw new Exception("Password del servicio web no esta definido[tracusa.sap.ws.password]");
		}

		if (ws_endpoint == null) {
			throw new Exception("Endpoint del servicio web no esta definido[tracusa.sap.ws.catalogo.endpoint]");
		}		
		// Comienza el proceso de invocacion del WS
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(ws_endpoint);
//			endpoint = new java.net.URL("http://SAPQAS.tracusa.com.mx:8010/sap/bc/srt/rfc/sap/zdatosvtaslogistica/300/zdatosvtaslogistica/zdatosvtaslogistica");
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		
		ZDATOSVTASLOGISTICA_ServiceLocator locator = new ZDATOSVTASLOGISTICA_ServiceLocator();
		mc_style.functions.soap.sap.document.sap_com.ZDATOSVTASLOGISTICA_PortType proxy = locator.getZDATOSVTASLOGISTICA(endpoint);

		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdAuartHolder itAuart = new TableOfZsdAuartHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfTvkotHolder itTvkot = new TableOfTvkotHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfTvsttHolder itTvstt = new TableOfTvsttHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdBaseCtoHolder itVtweg = new TableOfZsdBaseCtoHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdWerksHolder itWerks = new TableOfZsdWerksHolder();
		
		proxy.zsdDatosVentasLogistica(itAuart, itTvkot, itTvstt, itVtweg, itWerks);
			
		mc_style.functions.soap.sap.document.sap_com.Tvstt[] itTvsttARRAY = itTvstt.value;
			
		List<Tvstt> listitTvstt = Arrays.asList(itTvsttARRAY);

		logger.debug("Resultado invocacion WS SAP ----");
		logger.debug("itAuart ----:" + itAuart.value);
		logger.debug("itTvkot ----:" + itTvkot.value);
		logger.debug("itTvstt ----:" + itTvstt.value);
		logger.debug("itVtweg ----:" + itVtweg.value);
		logger.debug("itWerks ----:" + itWerks.value);
		
		return listitTvstt;
	}
	
	private List<ZsdBaseCto> invocaWSSAPCATALOGODATOSitVtweg() throws Exception {

		ws_user = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.user", "TRACUSA");
		ws_password = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.password", "TRACUSA");
		String ws_endpoint = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.catalogo.endpoint", "TRACUSA");

		if (ws_user == null) {
			throw new Exception("Usuario del servicio web no esta definido[tracusa.sap.ws.user]");
		}

		if (ws_password == null) {
			throw new Exception("Password del servicio web no esta definido[tracusa.sap.ws.password]");
		}

		if (ws_endpoint == null) {
			throw new Exception("Endpoint del servicio web no esta definido[tracusa.sap.ws.catalogo.endpoint]");
		}
		
		// Comienza el proceso de invocacion del WS
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(ws_endpoint);
//			endpoint = new java.net.URL("http://SAPQAS.tracusa.com.mx:8010/sap/bc/srt/rfc/sap/zdatosvtaslogistica/300/zdatosvtaslogistica/zdatosvtaslogistica");
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		
		ZDATOSVTASLOGISTICA_ServiceLocator locator = new ZDATOSVTASLOGISTICA_ServiceLocator();
		mc_style.functions.soap.sap.document.sap_com.ZDATOSVTASLOGISTICA_PortType proxy = locator.getZDATOSVTASLOGISTICA(endpoint);

		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdAuartHolder itAuart = new TableOfZsdAuartHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfTvkotHolder itTvkot = new TableOfTvkotHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfTvsttHolder itTvstt = new TableOfTvsttHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdBaseCtoHolder itVtweg = new TableOfZsdBaseCtoHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdWerksHolder itWerks = new TableOfZsdWerksHolder();
		
		proxy.zsdDatosVentasLogistica(itAuart, itTvkot, itTvstt, itVtweg, itWerks);

		mc_style.functions.soap.sap.document.sap_com.ZsdBaseCto[] itVtwegARRAY = itVtweg.value;
			
		List<ZsdBaseCto> listitVtweg = Arrays.asList(itVtwegARRAY);

		logger.debug("Resultado invocacion WS SAP ----");
		logger.debug("itAuart ----:" + itAuart.value);
		logger.debug("itTvkot ----:" + itTvkot.value);
		logger.debug("itTvstt ----:" + itTvstt.value);
		logger.debug("itVtweg ----:" + itVtweg.value);
		logger.debug("itWerks ----:" + itWerks.value);
		
		return listitVtweg;
	}
	
	private List<ZsdWerks> invocaWSSAPCATALOGODATOSitWerks() throws Exception {

		ws_user = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.user", "TRACUSA");
		ws_password = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.password", "TRACUSA");
		String ws_endpoint = iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.catalogo.endpoint", "TRACUSA");

		if (ws_user == null) {
			throw new Exception("Usuario del servicio web no esta definido[tracusa.sap.ws.user]");
		}

		if (ws_password == null) {
			throw new Exception("Password del servicio web no esta definido[tracusa.sap.ws.password]");
		}

		if (ws_endpoint == null) {
			throw new Exception("Endpoint del servicio web no esta definido[tracusa.sap.ws.catalogo.endpoint]");
		}
		
		// Comienza el proceso de invocacion del WS
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(ws_endpoint);
//			endpoint = new java.net.URL("http://SAPQAS.tracusa.com.mx:8010/sap/bc/srt/rfc/sap/zdatosvtaslogistica/300/zdatosvtaslogistica/zdatosvtaslogistica");
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		
		ZDATOSVTASLOGISTICA_ServiceLocator locator = new ZDATOSVTASLOGISTICA_ServiceLocator();
		mc_style.functions.soap.sap.document.sap_com.ZDATOSVTASLOGISTICA_PortType proxy = locator.getZDATOSVTASLOGISTICA(endpoint);

		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdAuartHolder itAuart = new TableOfZsdAuartHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfTvkotHolder itTvkot = new TableOfTvkotHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfTvsttHolder itTvstt = new TableOfTvsttHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdBaseCtoHolder itVtweg = new TableOfZsdBaseCtoHolder();
		mc_style.functions.soap.sap.document.sap_com.holders.TableOfZsdWerksHolder itWerks = new TableOfZsdWerksHolder();
		
		proxy.zsdDatosVentasLogistica(itAuart, itTvkot, itTvstt, itVtweg, itWerks);
		
		mc_style.functions.soap.sap.document.sap_com.ZsdWerks[] itWerksARRAY = itWerks.value;
			
		List<ZsdWerks> listitWerks = Arrays.asList(itWerksARRAY);
			
		logger.debug("Resultado invocacion WS SAP ----");
		logger.debug("itAuart ----:" + itAuart.value);
		logger.debug("itTvkot ----:" + itTvkot.value);
		logger.debug("itTvstt ----:" + itTvstt.value);
		logger.debug("itVtweg ----:" + itVtweg.value);
		logger.debug("itWerks ----:" + itWerks.value);
		
		return listitWerks;
	}
	
}
