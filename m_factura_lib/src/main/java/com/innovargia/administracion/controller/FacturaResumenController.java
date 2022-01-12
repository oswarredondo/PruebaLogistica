/**
 * 
 */
package com.innovargia.administracion.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.administracion.dto.Factura;
import com.administracion.dto.FacturaGuia;
import com.administracion.idao.IParamsSistemaDAO;
import com.google.gson.JsonObject;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IFacturaResumenBO;
import com.innovargia.utils.MimeTypes;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ExcepcionMessage;
import com.servicio.constantes.ConstantesAdminSale;
import com.servicio.constantes.ConstantesGenerales;

import mc_style.functions.soap.sap.document.sap_com.Tvkot;
import mc_style.functions.soap.sap.document.sap_com.Tvstt;
import mc_style.functions.soap.sap.document.sap_com.ZsdAuart;
import mc_style.functions.soap.sap.document.sap_com.ZsdBaseCto;
import mc_style.functions.soap.sap.document.sap_com.ZsdWerks;

/**
 * @author adrian
 * /facturaresumen/notacredito
 */
@RequestMapping("/facturaresumen/")
@Controller
public class FacturaResumenController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(FacturaResumenController.class);
	
	@Autowired
	IFacturaResumenBO iFacturaResumenBO;
	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;
	
	/**
	 * 
	 */
	public FacturaResumenController() {
		// TODO Auto-generated constructor stub
	}
	

	@RequestMapping(value="/getDatos", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> getDatos(
			@ModelAttribute("factura") Factura factura,  
			HttpServletRequest request)throws Exception {
	
	
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CatalogoDTO objeto = new CatalogoDTO();
		objeto.setEstatus(-1);
		try {
			
			//Obtiene el mes actual
			java.util.Date date= new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			
			if (factura.getMes()<=0){
				factura.setMes(month+1);
			}
			
			if (factura.getAnio()<=0){
				factura.setAnio(year);
			}
			List<Factura> lista = iFacturaResumenBO.getRegistros(factura);
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			logger.debug("Error:" + dae.getMessage());  
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	@RequestMapping(value="/getDatosGuias", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> getDatosGuias(@ModelAttribute("factura") Factura factura, HttpServletRequest request)throws Exception {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CatalogoDTO objeto = new CatalogoDTO();
		objeto.setEstatus(-1);
		try {
			
			//Obtiene el mes actual
			java.util.Date date= new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			
			if (factura.getMes()<=0){
				factura.setMes(month+1);
			}
			
			if (factura.getAnio()<=0){
				factura.setAnio(year);
			}
			
			/*String tipobusqueda = request.getParameter("tipobusqueda");
			factura.setTipoB(tipobusqueda == null ? "1" : tipobusqueda);
			String tipobusquedaestatus = request.getParameter("tipobusquedaestatus");
			factura.setEstatus(tipobusquedaestatus == null ? "1" : tipobusquedaestatus);
			String iddatoabuscar = request.getParameter("iddatoabuscar");
			factura.setT_txt_oper(iddatoabuscar == null ? "" : iddatoabuscar);
			//String fechacorte= request.getParameter("fechacorte");
			String tipoDocumento = request.getParameter("tipoDocumento");*/

			List<FacturaGuia> lista = iFacturaResumenBO.getRegistrosGuias(factura);
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			logger.debug("Error:" + dae.getMessage());  
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;
	}
	
	@RequestMapping(value="/marcarcorte", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> marcarcorte(
			@ModelAttribute("factura") Factura factura,  
			HttpServletRequest request)throws Exception {
	
		
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
			    throw new Exception( ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			factura.setLogin(usuario.getLogin());
			
			String fechacorte= UtilsStringFechas.formatoStrFecha(factura.getDia(), "dd/MM/yyyy", "yyyy-MM-dd");
			factura.setDia(fechacorte);
			
			//Consumo
			int idcontrol = -1;
			if (factura.getIdformapagofactura()==ConstantesGenerales.TIPO_BUSQUEDA_CLIENTE_CONSUMO){
				idcontrol = iFacturaResumenBO.insertConsumo(factura);
			}else{
				//Diferente a snsumo
				idcontrol = iFacturaResumenBO.insert(factura);
			}

			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("idcontrol", idcontrol);
			modelMap.put("failure", mensaje);
			
		} catch (Exception dae) {
			logger.debug("Error:" + dae.getMessage());  
			modelMap.put("failure",  dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	
	@RequestMapping(value="/desmarcar", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> desmarcar(
			@ModelAttribute("factura") Factura factura,  
			
			HttpServletRequest request)	throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

   
		try {
		
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		} catch (Exception dae) {
			logger.debug("Error:" + dae.getMessage());  
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}

		}
		return modelMap;
	}
	

	@RequestMapping(value="/facturar", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> facturar(
			@ModelAttribute("factura") Factura factura,  
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
			    throw new Exception( ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			factura.setLogin(usuario.getLogin());
			iFacturaResumenBO.updateFactura(factura);
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			
		} catch (Exception dae) { 
			logger.debug("Error:" + dae.getMessage());  
			
			modelMap.put("success", false);
			modelMap.put("failure", dae.getMessage());
			modelMap.put("message", dae.getMessage());
			

		}
		return modelMap;
	}
	
	@RequestMapping(value="/notacredito", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> notacredito(
			@ModelAttribute("factura") Factura factura,  
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
			    throw new Exception( ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			factura.setLogin(usuario.getLogin());
			iFacturaResumenBO.notaCredito(factura);
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			
		} catch (Exception dae) {
			logger.debug("Error:" + dae.getMessage());  
			
			modelMap.put("success", false);
			modelMap.put("failure", dae.getMessage());
			modelMap.put("message", dae.getMessage());
			

		}
		return modelMap;
	}

	@RequestMapping(value="/cancelar", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> cancelar(
			@ModelAttribute("factura") Factura factura,  
			HttpServletRequest request)	throws Exception {


		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
			    throw new Exception( ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			factura.setLogin(usuario.getLogin());
			iFacturaResumenBO.updateCancela(factura);
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
		} catch (Exception dae) {
			logger.debug("ERROR AL CANCELAR LA FACTURA " +factura.getFactura()+":" + dae.getMessage());  
			modelMap.put("success", false);
			modelMap.put("failure",dae.getMessage());
			modelMap.put("message",ExcepcionMessage.getMessageExcepcion(dae.getMessage()));

		}
		return modelMap;
	}
	
	
	
	@RequestMapping(value="/imprimirpdf", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody Map<String, ? extends Object> imprimirpdf( @ModelAttribute("factura") Factura factura,  
			HttpServletRequest request, HttpServletResponse response)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		// Verifica si el usuario tiene una sesion valida
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request
				.getSession(true));

		try {
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}		
			muestrarPDF( factura,  response,true,usuario);
		} catch (Exception dae) {
			muestrarError(dae.getMessage(),response);

		}
		return modelMap;
	}
	
	private void muestrarError(String error, HttpServletResponse response) throws IOException {

		if ((error==null) || (error.trim().length()<=0)){
			error ="No se puede mostrar el reporte solicitado, verifique con el administrador.";
		}
		byte[] bytes = error.getBytes();

		// Incializamos el array
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ServletOutputStream out = response.getOutputStream();

		bos.write(bytes);

		response.setContentType(MimeTypes.getMimeType("*.html"));
		response.setContentLength(bos.size());
		out.write(bos.toByteArray());
		out.flush();
		bos.close();
		out.close();
		response.flushBuffer();
		 

	}
	private void muestrarPDF(Factura factura,
			HttpServletResponse response, boolean isReimpresion,
			UsuarioDTO usuario) throws Exception {

			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("P_IDCONTROL", factura.getIdcontrol());
			parameters.put("P_IDCONTROLENVIO", factura.getIdcontrolenvio());
			parameters.put("P_FACTURA", factura.getFactura());
			parameters.put("P_TIPO", factura.getTipo() == null ? "CONTRATO" : factura.getTipo());
			/*parameters.put("P_TIPOB", factura.getTipoB() == null ? "1": factura.getTipoB());
			parameters.put("P_ESTATUS", factura.getEstatus()==null? "1": factura.getEstatus());
			parameters.put("P_IDDOCUMENTO", factura.getT_txt_oper() == null ? "" : factura.getT_txt_oper());*/

			byte[] bytes = iFacturaResumenBO.generarPDF(factura, parameters, usuario);

			// Incializamos el array
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ServletOutputStream out = response.getOutputStream();

			bos.write(bytes);

			if(factura.getTipoB().equals("pdf"))
				response.setContentType("application/pdf");
			else if(factura.getTipoB().equals("xls")){
				String nombrearchivo = UtilsStringFechas.getNombreArchivo(usuario.getLogin() + "_", "PreFac_", "xls");
				response.setHeader("Content-type", "application/vnd.ms-excel");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + nombrearchivo + "\"");
			}else
				response.setContentType("application/pdf");
			
			response.setContentLength(bos.size());
			out.write(bos.toByteArray());
			out.flush();
			bos.close();
			out.close();
			response.flushBuffer();
	
	}
	
	@RequestMapping(value = "/exportaConsultaExcelFA", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView exportaConsultaExcelFA(@ModelAttribute("factura") Factura factura,  
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		JsonObject jsonGuias = new JsonObject();
		
		try {
			
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			int idcontrol = factura.getIdcontrol();
			String idcontrolenvio = factura.getIdcontrolenvio();
			String fac = factura.getFactura();
			String tipo = factura.getTipo() == null ? "CONTRATO" : factura.getTipo();
			
			/*String tipob = factura.getTipoB() == null ? "1": factura.getTipoB();
			String estatus = factura.getEstatus()==null? "1": factura.getEstatus();
			String textBuscar = factura.getT_txt_oper() == null ? "" : factura.getT_txt_oper();*/
			//DocumentoDTO datos = configuraDatosConsulta(request, usuario);
			
			jsonGuias = iFacturaResumenBO.generaExcel(factura);
			
			//ModelAndView modelAndView = new ModelAndView("ExcelReportCPsNuevosView", "lista", new Gson().toJsonTree(lista));
			String nombrearchivo = UtilsStringFechas.getNombreArchivo(usuario.getLogin() + "_", "PreFac_", "xls");
			response.setHeader("Content-type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + nombrearchivo + "\"");
		} catch (Exception dae) {
			logger.debug("Error en reportes:" + dae.getMessage());
			System.out.println("Error en reportes:" + dae.getMessage());
		}

		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("ExportExcelFacturaGuiasView", "lista", jsonGuias);

	}
	
	/* LOS METODOS DESDE ESTE PUNTO HACIA ABAJO SE USAN PARA
	 * CONECTARSE AL WEB SERVICE DE TRACUSA Y OBTENER LOS DATOS
	 * DE EL CATALOGO QUE POSTERIORMENTE SERNA USADOS PARA LA
	 * FACTURACION, TODOS LOS METODOS SON IGUALES SOLO CAMBIA
	 * EL TIPO DE DATO QUE RECIBIREMOS Y MOSTRAREMOS EN EL CBOX */
	
	@RequestMapping(value="/getAuart", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> getAuart(
			@ModelAttribute("getAuart") ZsdAuart IT_Auart,  
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
			    throw new Exception( ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			/* Se crea lista de dato que retornara y mostrara el CBOX*/
			List<ZsdAuart> lista = iFacturaResumenBO.getAuart();
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) { 
			logger.debug("Error:" + dae.getMessage());  
			
			modelMap.put("success", false);
			modelMap.put("failure", dae.getMessage());
			modelMap.put("message", dae.getMessage());
			

		}
		return modelMap;
	}
	
	@RequestMapping(value="/getTvkot", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> getTvkot(
			@ModelAttribute("getTvkot") Tvkot IT_Tvkot,  
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
			    throw new Exception( ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			List<Tvkot> lista = iFacturaResumenBO.getTvkot();
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) { 
			logger.debug("Error:" + dae.getMessage());  
			
			modelMap.put("success", false);
			modelMap.put("failure", dae.getMessage());
			modelMap.put("message", dae.getMessage());
			

		}
		return modelMap;
	}
	
	@RequestMapping(value="/getVtweg", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> getVtweg(
			@ModelAttribute("getVtweg") ZsdBaseCto IT_Vtweg,  
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
			    throw new Exception( ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			List<ZsdBaseCto> lista = iFacturaResumenBO.getVtweg();
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) { 
			logger.debug("Error:" + dae.getMessage());  
			
			modelMap.put("success", false);
			modelMap.put("failure", dae.getMessage());
			modelMap.put("message", dae.getMessage());
			

		}
		return modelMap;
	}
	
	@RequestMapping(value="/getWerks", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> getWerks(
			@ModelAttribute("getWerks") ZsdWerks IT_Werks,  
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
			    throw new Exception( ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			List<ZsdWerks> lista = iFacturaResumenBO.getWerks();
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) { 
			logger.debug("Error:" + dae.getMessage());  
			
			modelMap.put("success", false);
			modelMap.put("failure", dae.getMessage());
			modelMap.put("message", dae.getMessage());
			

		}
		return modelMap;
	}
	
	@RequestMapping(value="/getTvstt", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> getTvstt(
			@ModelAttribute("getTvstt") Tvstt IT_Tvstt,  
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
			    throw new Exception( ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			List<Tvstt> lista = iFacturaResumenBO.getTvstt();
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) { 
			logger.debug("Error:" + dae.getMessage());  
			
			modelMap.put("success", false);
			modelMap.put("failure", dae.getMessage());
			modelMap.put("message", dae.getMessage());
			

		}
		return modelMap;
	}
	
	/* AQUI TEMRINAN LOS METODOS DEL CATALOGO */
	
	/* CAMBIO CITA EVIDENCIA MANIOBRA */
	@RequestMapping(value="/validarUsuario", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> validarUsuario(
			@ModelAttribute("factura") Factura factura,  
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
				
			    throw new Exception( ConstantesAdminSale.MSG_SESSION_FINISH);
			    
			}else if(usuario.getLogin().equals("PHUERTA") || usuario.getLogin().equals("CNUNEZ") ){
				
				modelMap.put("success", true);
				modelMap.put("message", "Correcto");
				
			}else{
				
				modelMap.put("success", false);
				modelMap.put("failure", "Opción no permitida para el usuario.");
				modelMap.put("message", "Opción no permitida para el usuario.");
				
			}
			
			
		} catch (Exception dae) { 
			logger.debug("Error:" + dae.getMessage());  
			
			modelMap.put("success", false);
			modelMap.put("failure", dae.getMessage());
			modelMap.put("message", dae.getMessage());
			

		}
		return modelMap;
	}
	/* FIN CAMBIO */
}
