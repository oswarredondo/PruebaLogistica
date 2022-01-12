/**
 * 
 */
package com.innovargia.salesmanager.controller;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.dto.UsuarioConvenioFolio;
import com.innovargia.constantes.ConstantesUtils;
import com.innovargia.salesmanager.bo.impl.CotizacionPreConvenioBO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ClientesDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IClientesBO;
import com.innovargia.salesmanager.ibo.IConvenioContratoBO;
import com.innovargia.salesmanager.ibo.ICotizacionPreConvenioBO;
import com.innovargia.salesmanager.ibo.ILogHistoriaBO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.MimeTypes;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.UtilsStrings;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adri�n
 * 
 */
@RequestMapping("/convenio")
@Controller
public class ConvenioController {

	@Autowired 
	IConvenioContratoBO iConvenioContratoBO;
	
	@Autowired 
	ICotizacionPreConvenioBO iCotizacionPreConvenioBO;
	
	@Autowired 
	IClientesBO iClientesBO;
	

	
	@Autowired 
	ILogHistoriaBO iLogHistoriaBO;
	private static final Logger logger = LoggerFactory
			.getLogger(CotizacionPreConvenioBO.class);

	
	
	/**
	 * 
	 */
	public ConvenioController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Actualiza un registro con el nuevo usuario creador, esto 
	 * sirve para poder reasignar un documento
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateUsuarioCreador")
	public @ResponseBody
	Map<String, ? extends Object> updateUsuarioCreador(
			@RequestParam(value = "idconvenio", required = false) String idconvenio,
			@RequestParam(value = "login", required = false) String logincreador,
			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ConvenioContratoDTO documento = new ConvenioContratoDTO();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario!=null){
			    
			    
				documento.setLogin(logincreador);
				documento.setIdconvenio(idconvenio);
				iConvenioContratoBO.updateUsuarioCreador(documento);
				
				//Agrega la historia
				LogHistoriaDTO historia = new LogHistoriaDTO();
				historia.setIdregistro(documento.getIdconvenio());
				historia.setTipomovimiento(ConstantesAdminSale.MOV_TRANSFORMA);
				historia.setLogin(usuario.getLogin());
				historia.setRegistro(usuario.getLogin() + " REASIGNO DOCUMENTO A: "+documento.getLogin());
				iLogHistoriaBO.insertHistoriaConvenio(historia);

				modelMap.put("message", "Registro modificado de forma correcta.");
			}else{
				modelMap.put("message", ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			modelMap.put("success", true);
			
			
		} catch (Exception dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}
			modelMap.put("message", mensaje);
		}
		return modelMap;
	}
	
	/**
	 * Obtiene los datos de un catalogo, solo los registros que estan activos
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDatos")
	public @ResponseBody
	Map<String, ? extends Object> getDatos(HttpServletRequest request)throws Exception {
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<ConvenioContratoDTO> lista = new ArrayList<ConvenioContratoDTO>();;
		BusquedaDTO busquedaDTO = new BusquedaDTO();
		try {
			
			UtilsRequest.displayParametros(request);
			
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuario==null){
				throw new Exception(mensaje=ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			if ((request.getParameter("tipobusqueda") !=null) && 
					(request.getParameter("tipobusqueda").trim().length()>0)){

				busquedaDTO.setUsuario(usuario); 
				
				int tipo = Integer.parseInt(request
						.getParameter("tipobusqueda"));
				busquedaDTO.setTipo(tipo);
				busquedaDTO.setPatron_busqueda(request.getParameter("patron"));
				
				String restringe_datos_a_solo_estatus="";
				//Verifica que privilegios tiene para la consulta
				if (usuario.opcionAsignadaPerfiles("solo.convenios.en.estatus.activo")){
				    restringe_datos_a_solo_estatus = ConstantesUtils.ESTATUS_ACTIVA+" ";
				}
				if (usuario.opcionAsignadaPerfiles("solo.convenios.en.estatus.inactivo")){
				    restringe_datos_a_solo_estatus += ConstantesUtils.ESTATUS_INACTIVA+" ";
				}
				if (usuario.opcionAsignadaPerfiles("solo.convenios.en.estatus.transformacion.convenio")){
				    restringe_datos_a_solo_estatus += ConstantesUtils.ESTATUS_TRANSFORMACION_CONVENIO+" ";
				}
				if (usuario.opcionAsignadaPerfiles("solo.convenios.en.estatus.documentacion")){
				    restringe_datos_a_solo_estatus += ConstantesUtils.ESTATUS_EN_DOCUMENTACION+" ";
				}
				
				if (usuario.opcionAsignadaPerfiles("convenios.en.estatus.documentacion")){
				    restringe_datos_a_solo_estatus += ConstantesUtils.ESTATUS_EN_DOCUMENTACION+" ";
				}
				
				if (usuario.opcionAsignadaPerfiles("solo.convenios.en.estatus.revision")){
				    restringe_datos_a_solo_estatus += ConstantesUtils.ESTATUS_REVISION+" ";
				}
				
				if (usuario.opcionAsignadaPerfiles("solo.convenios.en.estatus.autorizado")){
				    restringe_datos_a_solo_estatus += ConstantesUtils.ESTATUS_AUTORIZADO+" ";
				}
				
				if (usuario.opcionAsignadaPerfiles("solo.convenios.en.estatus.cerrado")){
				    restringe_datos_a_solo_estatus += ConstantesUtils.ESTATUS_CERRADO+" ";
				}
				if (usuario.opcionAsignadaPerfiles("solo.convenios.en.estatus.cancelado")){
				    restringe_datos_a_solo_estatus += ConstantesUtils.ESTATUS_CANCELADO+" ";
				}
				
				if (!restringe_datos_a_solo_estatus.isEmpty()){
				    restringe_datos_a_solo_estatus = restringe_datos_a_solo_estatus.trim().replaceAll(" ", ",");
				    busquedaDTO.setRestringe_datos_a_solo_estatus(restringe_datos_a_solo_estatus);
					
				    /*if ((request.getParameter("solo_en_revision")!=null) && 
					("true".equals( request.getParameter("solo_en_revision"))) ){
					   busquedaDTO.setEstatus(ConstantesUtils.ESTATUS_REVISION);
				      }else{
					   busquedaDTO.setEstatus(-1);
				      }*/
					
				      busquedaDTO.setEstatus(1);
				      busquedaDTO.setMes(request.getParameter("mes"));
				      busquedaDTO.setFechainicial(UtilsStringFechas.formatoStrFecha(
							request.getParameter("fecha"), "dd-MM-yyyy",
							"yyyy-MM-dd"));

				      lista = iConvenioContratoBO.getRegistros(busquedaDTO);
				}else{
				    lista = new ArrayList<ConvenioContratoDTO>(); 
				}
				
				
			}


			success = true;
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;
		
	}
	
	/***
	 * Agrega un registro 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateFirmas")
	public @ResponseBody
	Map<String, ? extends Object> updateFirmas( 	 
			@RequestParam(value = "idconvenio", required = true) String idconvenio,
			@RequestParam(value = "clientefirma", required = false) String clientefirma,
			@RequestParam(value = "gerentecomercialfirma", required = false) String gerentecomercialfirma,
			@RequestParam(value = "jefezonafirma", required = false) String jefezonafirma,
			@RequestParam(value = "coordinadorcreditocobfirma", required = false) String coordinadorcreditocobfirma,
			@RequestParam(value = "directoradmfinanzasfirma", required = false) String directoradmfinanzasfirma,
			@RequestParam(value = "ejecutivoventasfirma", required = false) String ejecutivoventasfirma,
			
			HttpServletRequest request) throws Exception {
		
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ConvenioContratoDTO documento = new ConvenioContratoDTO();

		
		UtilsRequest.displayParametros(request);
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		LogHistoriaDTO historia = new LogHistoriaDTO();
		documento.setIdconvenio(idconvenio);
		documento.setClientefirma(clientefirma);
		documento.setGerentecomercialfirma(gerentecomercialfirma);
		documento.setJefezonafirma(jefezonafirma);
		documento.setCoordinadorcreditocobfirma(coordinadorcreditocobfirma);
		documento.setDirectoradmfinanzasfirma(directoradmfinanzasfirma);
		documento.setEjecutivoventasfirma(ejecutivoventasfirma);
		
		try {
			if (usuario!=null){
			    if (!usuario.opcionAsignadaPerfiles("solo.actualiza.numcliente.en.convenio")){
				documento.setLogin(usuario.getLogin());
				iConvenioContratoBO.updateFirmas(documento);
				//Agrega la historia
				historia.setIdregistro(documento.getIdconvenio());
				historia.setTipomovimiento("FIRMAS");
				historia.setLogin(usuario.getLogin());
				historia.setRegistro("SE MODIFICO DOCUMENTO DE " + ConstantesAdminSale.DOC_CONVENIO);
				iLogHistoriaBO.insertHistoriaConvenio(historia);
				
				
				mensaje="Se modifico el documento:" + documento.getIdconvenio() + ".";
			    }else{
				mensaje=ConstantesAdminSale.MSG_OPERACION_UPDATE_RESTRINGIDA;
			    }
				
			    success = true;
			    
			}else{
				mensaje=ConstantesAdminSale.MSG_SESSION_FINISH;
			}
			
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
		
	}

		
	
	/***
	 * Agrega un registro 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateDirRevision")
	public @ResponseBody
	Map<String, ? extends Object> updateDirRevision( 	 
			@RequestParam(value = "idconvenio", required = true) String idconvenio,
			@RequestParam(value = "calle_rev", required = false) String calle_rev,
			@RequestParam(value = "numinterior_rev", required = false) String numinterior_rev,
			@RequestParam(value = "numexterior_rev", required = false) String numexterior_rev,
			@RequestParam(value = "cp_rev", required = false) String cp_rev,
			@RequestParam(value = "colonia_rev", required = false) String colonia_rev,
			@RequestParam(value = "municipio_rev", required = false) String municipio_rev,
			@RequestParam(value = "estado_rev", required = false) String estado_rev,
			@RequestParam(value = "responsable_rev", required = false) String responsable_rev,
			@RequestParam(value = "email_resp_rev", required = false) String email_resp_rev,
			@RequestParam(value = "telefono_rev", required = false) String telefono_rev,
			@RequestParam(value = "movil_rev", required = false) String movil_rev,
			@RequestParam(value = "diasrevision", required = false) String diasrevision,
			  
			
			HttpServletRequest request) throws Exception {
		
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ConvenioContratoDTO documento = new ConvenioContratoDTO();

		
		UtilsRequest.displayParametros(request);
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		LogHistoriaDTO historia = new LogHistoriaDTO();
		documento.setIdconvenio(idconvenio);
		documento.setCalle_rev(calle_rev);
		documento.setNuminterior_rev(numinterior_rev);
		documento.setNumexterior_rev(numexterior_rev);
		documento.setCp_rev(cp_rev);
		documento.setColonia_rev(colonia_rev);
		documento.setMunicipio_rev(municipio_rev);
		documento.setEstado_rev(estado_rev);
		documento.setResponsable_rev(responsable_rev);
		documento.setEmail_resp_rev(email_resp_rev);
		documento.setTelefono_rev(telefono_rev);
		documento.setMovil_rev(movil_rev);
	
		documento.setDiasrevision(diasrevision);
		
		try {
			if (usuario!=null){
			    if (!usuario.opcionAsignadaPerfiles("solo.actualiza.numcliente.en.convenio")){
				documento.setLogin(usuario.getLogin());
				iConvenioContratoBO.updateDatosRevision(documento);
				//Agrega la historia
				historia.setIdregistro(documento.getIdconvenio());
				historia.setTipomovimiento("FIRMAS");
				historia.setLogin(usuario.getLogin());
				historia.setRegistro("SE MODIFICO DOCUMENTO DE " + ConstantesAdminSale.DOC_CONVENIO);
				iLogHistoriaBO.insertHistoriaConvenio(historia);
				mensaje="Se modifico el documento:" + documento.getIdconvenio() + ".";
				
			    }else{
				mensaje=ConstantesAdminSale.MSG_OPERACION_UPDATE_RESTRINGIDA;
			    }
			    success = true;
				
				
			}else{
				mensaje=ConstantesAdminSale.MSG_SESSION_FINISH;
			}
			
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			
			modelMap.put("message", dae.getMessage());
				

		}
		return modelMap;
		
		
	}
			
	/***
	 * Agrega un registro 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update")
	public @ResponseBody
	Map<String, ? extends Object> update( 	
		
			@RequestParam(value = "idconvenio", required = true) String idconvenio,
			@RequestParam(value = "tipo_precios", required = false) String tipo_precios,
			@RequestParam(value = "idcliente", required = false) String idcliente,
			@RequestParam(value = "numcliente", required = false) String numcliente,
			@RequestParam(value = "iddescuento", required = false) int iddescuento,
			@RequestParam(value = "descripcionDescuento", required = false) String descripcionDescuento,
			@RequestParam(value = "idtarifa", required = false) int idtarifa,
			@RequestParam(value = "descripcionTarifarango=", required = false) String descripcionTarifarango,
			@RequestParam(value = "estado_cte", required = false) String estado_cte,
			@RequestParam(value = "municipio_cte", required = false) String municipio_cte,
			@RequestParam(value = "colonia_cte", required = false) String colonia_cte,
			@RequestParam(value = "cp_cte", required = false) String cp_cte,
			@RequestParam(value = "numinterior_cte", required = false) String numinterior_cte,
			@RequestParam(value = "numexterior_cte", required = false) String numexterior_cte,
			@RequestParam(value = "calle_cte", required = false) String calle_cte,
			@RequestParam(value = "contacto_cte", required = false) String contacto_cte,
			@RequestParam(value = "fechadocumento", required = false) String fechadocumento,
			@RequestParam(value = "rangoenvios", required = false) String rangoenvios,
			@RequestParam(value = "idrangoenvios", required = false) String idrangoenvios,
			
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "idpoblacionpago", required = false) String idpoblacionpago,
			@RequestParam(value = "idformapago", required = false) String idformapago,
			@RequestParam(value = "idcondicionpago", required = false) String idcondicionpago,
			@RequestParam(value = "idunidadadm", required = false) String idunidadadm,
			@RequestParam(value = "idoficinacontrol", required = false) String idoficinacontrol,
			@RequestParam(value = "idmetodopago", required = false) String idmetodopago,
			@RequestParam(value = "credito", required = false) String credito,
			@RequestParam(value = "tipo_contrato", required = false) String tipo_contrato,
			@RequestParam(value = "fechainicio", required = false) String fechainicio,
			@RequestParam(value = "fechaactivacion", required = false) String fechaactivacion,
			@RequestParam(value = "fechatermino", required = false) String fechatermino,
			@RequestParam(value = "razonsocial_cte", required = false) String razonsocial_cte,
			@RequestParam(value = "telefono_cte", required = false) String telefono_cte,
			@RequestParam(value = "movil_cte", required = false) String movil_cte,
			@RequestParam(value = "email_cte", required = false) String email_cte,
			
			@RequestParam(value = "diaspago", required = false) String diaspago,
			
			
			
			@RequestParam(value = "clientelicitacion", required = false) String clientelicitacion,
			@RequestParam(value = "responsable_pago", required = false) String responsable_pago,
			@RequestParam(value = "email_resp_pago", required = false) String email_resp_pago,
			@RequestParam(value = "fecharevision", required = false) String fecharevision,
			@RequestParam(value = "nombrebanco", required = false) String nombrebanco,
			@RequestParam(value = "cuentabancaria", required = false) String cuentabancaria,
			@RequestParam(value = "representantelegal", required = false) String representantelegal,
			@RequestParam(value = "rfc", required = false) String rfc,
			
			/* DATOS SEGURO */
			@RequestParam(value = "asegura", required = false) String tiene_seguro,
			@RequestParam(value = "porcentaje_seguro", required = false) String valor_asegurado,
			@RequestParam(value = "nombre_seguro", required = false) String ciaseguro,
			
			HttpServletRequest request) throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ConvenioContratoDTO documento = new ConvenioContratoDTO();

		
		UtilsRequest.displayParametros(request);
		
		documento.setIdconvenio(idconvenio);
		documento.setNombre(nombre==null?"":nombre);
		documento.setIdcliente(idcliente);
		documento.setNumcliente(numcliente);
		documento.setRepresentantelegal(representantelegal);
		
		documento.setIdtarifa(idtarifa);
		documento.setIddescuento(iddescuento);
		documento.setTipo_precios(tipo_precios); 
		documento.setDescripcionDescuento(descripcionDescuento);
		documento.setDescripcionTarifarango(descripcionTarifarango);
		
		documento.setEstado_cte(estado_cte);
		documento.setMunicipio_cte(municipio_cte);
		documento.setColonia_cte(colonia_cte);
		documento.setCp_cte(cp_cte);
		documento.setNuminterior_cte(numinterior_cte);
		documento.setNumexterior_cte(numexterior_cte);
		documento.setCalle_cte(calle_cte);
		documento.setContacto_cte(contacto_cte);
		documento.setIdformapago(idformapago); 
		
		documento.setRangoenvios(rangoenvios);
		documento.setIdrangoenvios(idrangoenvios);
		documento.setIdpoblacionpago(idpoblacionpago);
		documento.setIdcondicionpago(idcondicionpago);
		documento.setIdunidadadm(idunidadadm);
		documento.setIdoficinacontrol(idoficinacontrol);
		documento.setIdmetodopago(idmetodopago);
		documento.setCredito(credito);
		documento.setTipo_contrato(tipo_contrato);
		documento.setRazonsocial_cte(razonsocial_cte);
		documento.setTelefono_cte(telefono_cte);
		documento.setMovil_cte(movil_cte);
		documento.setEmail_cte(email_cte);
		documento.setClientelicitacion(clientelicitacion);
		
		documento.setDiaspago(diaspago);
		documento.setResponsable_pago(responsable_pago);
		
		documento.setEmail_resp_pago(email_resp_pago);
		
		
		documento.setNombrebanco(nombrebanco);
		documento.setCuentabancaria(cuentabancaria);
		documento.setFecharevision(fecharevision);
		documento.setRfc(rfc);
		
		tiene_seguro = tiene_seguro==null?"":tiene_seguro;
		
		/* DATOS SEGURO */
		if(tiene_seguro.equals("on")){
			
			documento.setAsegura(1);
			documento.setNombre_seguro(ciaseguro);
			documento.setPorcentaje_seguro(valor_asegurado);
			
		}else{
			
			documento.setAsegura(0);
			documento.setPorcentaje_seguro("");
			
		}
		
		if (fechainicio!=null){
			documento.setFechainicio(UtilsStringFechas.formatoStrFecha(fechainicio, "dd-MM-yyyy", "yyyy-MM-dd")  );
		}
		
		if (fechaactivacion!=null){
			documento.setFechaactivacion(UtilsStringFechas.formatoStrFecha(fechaactivacion, "dd-MM-yyyy", "yyyy-MM-dd")  ); 
		}
		
		if (fechatermino!=null){
			documento.setFechatermino(UtilsStringFechas.formatoStrFecha(fechatermino, "dd-MM-yyyy", "yyyy-MM-dd")  );
		}
		
		if (fecharevision!=null){
			documento.setFecharevision(UtilsStringFechas.formatoStrFecha(fecharevision, "dd-MM-yyyy", "yyyy-MM-dd")  );
		}
		
		documento.setFechadocumento(UtilsStringFechas.formatoStrFecha(fechadocumento, "dd-MM-yyyy", "yyyy-MM-dd") );
		documento.setEstadoactualdoc(ConstantesAdminSale.DOC_CONVENIO);
		
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		LogHistoriaDTO historia = new LogHistoriaDTO();
		
		try {
			int cotizacion=0;
			if (usuario!=null){
			        
				documento.setLogin(usuario.getLogin());
				
				if (usuario.opcionAsignadaPerfiles("solo.actualiza.numcliente.en.convenio")){
				    //Obtiene todos los datos del convenio y 
				    //solo ajusta el numero de 
				    documento = iConvenioContratoBO.get(documento);
				    documento.setNumcliente(numcliente);
				    iConvenioContratoBO.update(documento);
				    
				    //Agrega la historia
				    historia.setRegistro("SE MODIFICO NUMERO DE CLIENTE " + 
				    ConstantesAdminSale.DOC_CONVENIO);
				    
				    mensaje="Se modifico numero de cliente del convenio :" + 
				    documento.getIdconvenio() + ", actualice su consulta.";

				}else{
				    //Actualiza todos los datos
				    iConvenioContratoBO.update(documento);
				    
				    //Agrega la historia
				    historia.setRegistro("SE MODIFICO DOCUMENTO DE " + ConstantesAdminSale.DOC_CONVENIO);
				    mensaje="Se modifico el documento:" + documento.getIdconvenio() + ", actualice su consulta.";
				  
				}
				
				historia.setIdregistro(documento.getIdconvenio());
				historia.setTipomovimiento(ConstantesAdminSale.MOV_UPDATE);
				historia.setLogin(usuario.getLogin());
				iLogHistoriaBO.insertHistoriaConvenio(historia);

				success = true;
				
				
				
				
			}else{
				mensaje=ConstantesAdminSale.MSG_SESSION_FINISH;
			}
			
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", success);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
	}
	
	@RequestMapping(value = "/viewPDFArchivo")
	public void viewPDFArchivo(HttpServletRequest request,
			HttpServletResponse response) {

		ConvenioContratoDTO documento = new ConvenioContratoDTO();
		byte[] bytes=null;
		try {


			documento.setIdconvenio(request.getParameter("idconvenio"));
			documento.setEstadoactualdoc(ConstantesAdminSale.DOC_CONVENIO);
			String error= "<p>No se pudo crear archivo PDF del documento.<p>";
			try{
				 bytes=  iCotizacionPreConvenioBO.getPDFCotizacion(documento);

			}catch(Exception e){
				error=e.getMessage();
			}
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ServletOutputStream out = response.getOutputStream();

			//Verifica el tipo de documento a desplegar
			if (bytes!=null){
				response.setContentType(MimeTypes.getMimeType("*.pdf"));
			}else{
				response.setContentType(MimeTypes.getMimeType("*.html"));
				bytes = error.getBytes();
			}
			
			bos.write(bytes);
			
			response.setContentLength(bos.size());
			out.write(bos.toByteArray());
			out.flush();
			bos.close();
			out.close();
			response.flushBuffer();

		} catch (Exception e) {
			logger.error("Error:", e);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	/**
	 * Autoriza un documento
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cambiarestatus")
	public @ResponseBody
	Map<String, ? extends Object> cambiarestatus(
			@RequestParam(value = "ids", required = true) String ids,
			@RequestParam(value = "estatus", required = true) int estatus,
			@RequestParam(value = "observacion", required = false) String observacion,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ConvenioContratoDTO documento = null;
		LogHistoriaDTO historia = null;
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		observacion = UtilsStrings.nullChangeToUpperCase(observacion);

		try {

			if (usuario != null) {
				if (ids!=null){
					String[] arr_idstarifas = ids.trim().split("\\|");
					for (String id : arr_idstarifas) {
						
						documento = new ConvenioContratoDTO();
						//try{
							//Estatus a acutorizado
							documento.setIdconvenio(id);
							documento.setEstatus(estatus);
							
							//Autorizar
							if (estatus==ConstantesUtils.ESTATUS_AUTORIZADO){
								//Cambia el estatus del cliente a 1=Cliente
								ConvenioContratoDTO convenio = iConvenioContratoBO.get(documento);
								if (convenio.getIdcliente()==-1){
									throw new Exception("No se ha asignado un cliente existen al Convenio.");
								}
								//Cambia el tipo de cliente a activo
								ClientesDTO cliente = new ClientesDTO();
								cliente.setTipocliente(1);
								cliente.setIdcliente(convenio.getIdcliente());
								iClientesBO.setTipoCliente(cliente);
								//Crea las cuentas y envia el correo 
								iConvenioContratoBO.creaCuentaAutoDoc(convenio);
							}
							//Actualiza el estatus
							iCotizacionPreConvenioBO.updateEstatus(documento);
							 
							//Agrega la historia
							historia = new LogHistoriaDTO();
							historia.setIdregistro(documento.getIdconvenio());
							if (estatus==ConstantesUtils.ESTATUS_ACTIVA){
								historia.setTipomovimiento(ConstantesUtils.MOV_ACTIVAR);
							}else if (estatus==ConstantesUtils.ESTATUS_INACTIVA){
								historia.setTipomovimiento(ConstantesUtils.MOV_DESACTIVAR);
							}else if (estatus==ConstantesUtils.ESTATUS_AUTORIZADO){
								historia.setTipomovimiento(ConstantesUtils.MOV_AUTORIZAR);
							}else if (estatus==ConstantesUtils.ESTATUS_CERRADO){
								historia.setTipomovimiento(ConstantesUtils.MOV_CERRADO);	
							}else if (estatus==ConstantesUtils.ESTATUS_CANCELADO){
								historia.setTipomovimiento(ConstantesUtils.MOV_CANCELADO);		
							}else if (estatus==ConstantesUtils.ESTATUS_REVISION){
								historia.setTipomovimiento(ConstantesUtils.MOV_REVISION + "-" + 
									observacion);	
								
							}else if (estatus==ConstantesUtils.ESTATUS_EN_DOCUMENTACION){
								historia.setTipomovimiento(ConstantesAdminSale.MOV_DOCUMENTACION + 
									 "-" + observacion);		
							}else{
								historia.setTipomovimiento(ConstantesAdminSale.MOV_OTRO
									+ "-" + observacion);
							}
							
							historia.setLogin(usuario.getLogin());
							historia.setRegistro("Se cambia estatus del documento.");
							iLogHistoriaBO.insertHistoriaConvenio(historia);
							
						//}catch(Exception e){
						//	logger.error("Error:" + e.getMessage());
						//}
						
					}
				}
				modelMap.put("success", true);
				modelMap.put("message", "Se cambio el estatus de los registros seleccionados.");
			} else {
				modelMap.put("success", true);
				modelMap.put("message", ConstantesAdminSale.MSG_SESSION_FINISH);
			}

		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}
		
			
		
		return modelMap;
	}
	
	@RequestMapping("/getUsuarioConvenios")
	public @ResponseBody
	Map<String, ? extends Object> getUsuarioConvenios(
			@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "numcliente", required = false) String numcliente,
			@RequestParam(value = "identidad", required = false) int identidad,
			@RequestParam(value = "idorganizacion", required = false) int idorganizacion,
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		List<UsuarioConvenioFolio> lista = new ArrayList<UsuarioConvenioFolio>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		try {
			UtilsRequest.displayParametros(request);
			UsuarioDTO usuario_cuenta = new UsuarioDTO();
			usuario_cuenta.setNumCliente(numcliente);
			usuario_cuenta.entidad.setIdentidad(identidad);
			usuario_cuenta.organizacion.setIdorganizacion(idorganizacion);
			usuario_cuenta.setLogin(login);
			
			lista = iConvenioContratoBO.getConveniosUsuario(usuario_cuenta);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;
		
	}
	 
	@RequestMapping("/insertUsuarioConvenios")
	public @ResponseBody
	Map<String, ? extends Object> insertUsuarioConvenios(
			@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "numcliente", required = false) String numcliente,
			@RequestParam(value = "identidad", required = false) int identidad,
			@RequestParam(value = "idconvenio", required = false) String idconvenio,
			@RequestParam(value = "idorganizacion", required = false) int idorganizacion,
			HttpServletRequest request)throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		List<UsuarioConvenioFolio> lista = new ArrayList<UsuarioConvenioFolio>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		String convenio_noasignados ="";
		try {
			UtilsRequest.displayParametros(request);
			UsuarioCuentaDTO usuario_cuenta = new UsuarioCuentaDTO();
			usuario_cuenta.setNumcliente(numcliente==null?"":numcliente);
			usuario_cuenta.setIdentidad(identidad);
			usuario_cuenta.setIdorganizacion(idorganizacion);
			usuario_cuenta.setLogin(login);
			String[] convenios = idconvenio.trim().split(",");
			ConvenioContratoDTO convenioContratoDTO = new ConvenioContratoDTO();
			
			for (String miconvenio : convenios) {
			    try {
				int convenio = Integer.parseInt(miconvenio);
				convenioContratoDTO = new ConvenioContratoDTO();
				convenioContratoDTO.setIdconvenio(convenio);
				
				convenioContratoDTO = iConvenioContratoBO.get(convenioContratoDTO);
				if (convenioContratoDTO!=null){
				    if (usuario_cuenta.getNumcliente().equals(convenioContratoDTO.getNumcliente())){
					iConvenioContratoBO.asignarConvenioAUsuario(usuario_cuenta, convenio);
				    }else{
					convenio_noasignados =convenio + " ";
				    }
				}
				
				
			    } catch (Exception e) {
				logger.error("Error al asignar convenio[" + miconvenio
					+"] a usuario:" + e.getMessage());
			    }
			}
			
			
			modelMap.put("success", true);
			if (convenio_noasignados.trim().length()<=0){
			    modelMap.put("message", "Se asignaron los convenios");
			}else{
			    modelMap.put("message", "Se asignaron los convenios. "
			    	+ "Los siguientes convenios [" +  convenio_noasignados.trim()
			    	+" ] no pertenecen al numero de cuenta del usuario seleccionado.");  
			}
			
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;
		
	}
	
	@RequestMapping("/deleteUsuarioConvenios")
	public @ResponseBody
	Map<String, ? extends Object> deleteUsuarioConvenios(
			@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "numcliente", required = false) String numcliente,
			@RequestParam(value = "identidad", required = false) int identidad,
			@RequestParam(value = "idconvenio", required = false) String idconvenio,
			@RequestParam(value = "idorganizacion", required = false) int idorganizacion,
			@RequestParam(value = "idregistro", required = false) int idregistro,
			
			HttpServletRequest request)throws Exception {


		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		List<UsuarioConvenioFolio> lista = new ArrayList<UsuarioConvenioFolio>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		try {
			UtilsRequest.displayParametros(request);
			UsuarioConvenioFolio usuario_folio = new UsuarioConvenioFolio();
			usuario_folio.setNumcliente(numcliente);
			usuario_folio.setIdentidad(identidad);
			usuario_folio.setIdorganizacion(idorganizacion);
			usuario_folio.setLogin(login);
			usuario_folio.setIdregistro(idregistro);
			iConvenioContratoBO.deleteUsuarioConvenioFolio(usuario_folio);

			modelMap.put("success", true);
			modelMap.put("message", "Se asignaron los convenios");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;
		
	}

}
