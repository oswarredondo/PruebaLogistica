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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovargia.constantes.ConstantesUtils;
import com.innovargia.mail.EmailProperties;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IClientesBO;
import com.innovargia.salesmanager.ibo.IConvenioContratoBO;
import com.innovargia.salesmanager.ibo.ICotizacionPreConvenioBO;
import com.innovargia.salesmanager.ibo.ILogHistoriaBO;
import com.innovargia.salesmanager.json.ConvenioContratoDTOJSON;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.MimeTypes;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adri�n
 * 
 */
@RequestMapping("/cotizacionpreconvenio")
@Controller
public class CotizacionPreConvenioController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CotizacionPreConvenioController.class);
	

	@Autowired 
	ICotizacionPreConvenioBO bo;
	@Autowired
	IConvenioContratoBO iConvenioContratoBO;
	@Autowired 
	ILogHistoriaBO iLogHistoriaBO;
	@Autowired
	IClientesBO iClientesBO;
	/**
	 * 
	 */
	public CotizacionPreConvenioController() {
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
				bo.updateUsuarioCreador(documento);
				
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
	
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<ConvenioContratoDTO> lista = new ArrayList<ConvenioContratoDTO>();;
		BusquedaDTO busquedaDTO = new BusquedaDTO();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		String restringe_datos_a_solo_estatus="";
		try {
			if (usuario==null){
				throw new Exception(mensaje=ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			busquedaDTO.setUsuario(usuario); 
			//Verifica que privilegios tiene para la consulta
			if (usuario.opcionAsignadaPerfiles("solo.cotizacion.en.transformado")){
			    restringe_datos_a_solo_estatus = ConstantesUtils.ESTATUS_TRANSFORMACION_CONVENIO+" ";
			}
			if (usuario.opcionAsignadaPerfiles("solo.cotizacion.en.cerrado")){
			    restringe_datos_a_solo_estatus += ConstantesUtils.ESTATUS_CERRADO+" ";
			}
			if (usuario.opcionAsignadaPerfiles("solo.cotizacion.en.desactivado")){
			    restringe_datos_a_solo_estatus += ConstantesUtils.ESTATUS_INACTIVA+" ";
			}
			if (usuario.opcionAsignadaPerfiles("solo.cotizacion.en.estatus.activo")){
			    restringe_datos_a_solo_estatus += ConstantesUtils.ESTATUS_ACTIVA+" ";
			}
			
			if (!restringe_datos_a_solo_estatus.isEmpty()){
			    restringe_datos_a_solo_estatus = restringe_datos_a_solo_estatus.trim().replaceAll(" ", ",");
				busquedaDTO.setRestringe_datos_a_solo_estatus(restringe_datos_a_solo_estatus);
				
				
				if ((request.getParameter("tipobusqueda") !=null) && 
						(request.getParameter("tipobusqueda").trim().length()>0)){

					int tipo = Integer.parseInt(request
							.getParameter("tipobusqueda"));
					busquedaDTO.setTipo(tipo);
					busquedaDTO.setPatron_busqueda(request.getParameter("patron"));
					busquedaDTO.setEstatus(1);
					busquedaDTO.setMes(request.getParameter("mes"));
					busquedaDTO.setFechainicial(UtilsStringFechas.formatoStrFecha(
							request.getParameter("fecha"), "dd-MM-yyyy",
							"yyyy-MM-dd"));

					lista = bo.getRegistros(busquedaDTO);
				}

			}else{
			    lista = new ArrayList<ConvenioContratoDTO>(); 
			}
			

		
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
	
	/***
	 *Transforma la cotizacion a un convenio
	 *Toma los datos de la cotizacion, adicionales y renglones
	 *estos ya solo seran de tipo consulta
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/transformaAConvenio")
	public @ResponseBody
	Map<String, ? extends Object> transformaAConvenio(	HttpServletRequest request) throws Exception {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ConvenioContratoDTO documento = new ConvenioContratoDTO();
		
		UtilsRequest.displayParametros(request);
		documento.setIdconvenio(request.getParameter("idconvenio"));
		int idcotizacion = documento.getIdconvenio();
		LogHistoriaDTO historia = new LogHistoriaDTO();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		try{
			ConvenioContratoDTO convenio = bo.get(documento);
			convenio.setIdcotizacionorigen(documento.getIdconvenio());
			
			if (convenio==null){
				throw new Exception("No existe cotizacion selecionda");
			}
			int idconvenio = iConvenioContratoBO.transformaCotizacion(convenio);
			
			//Agrega la historia
			historia.setIdregistro(idcotizacion);
			historia.setTipomovimiento(ConstantesAdminSale.MOV_TRANSFORMA);
			historia.setLogin(usuario.getLogin());
			historia.setRegistro("SE CONVIRTIO LA COTIZACION " + idcotizacion  + 
					" AL CONVENIO:" + idconvenio);
			iLogHistoriaBO.insertHistoriaConvenio(historia);
			
			modelMap.put("idconvenio", idconvenio);
			modelMap.put("success", true);
			modelMap.put("message", "SE CONVIRTIO LA COTIZACION " + idcotizacion  + 
					" AL CONVENIO:" + idconvenio);
		} catch (Exception dae) {
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
	@RequestMapping("/insert")
	public @ResponseBody
	Map<String, ? extends Object> insert(
			@RequestParam(value = "tipo_precios", required = false) String tipo_precios,
			@RequestParam(value = "idcliente", required = false) String idcliente,
			@RequestParam(value = "numcliente", required = false) String numcliente,
			@RequestParam(value = "iddescuento", required = false) int iddescuento, //es true
			@RequestParam(value = "descripcionDescuento", required = false) String descripcionDescuento,
			@RequestParam(value = "idtarifa", required = true) int idtarifa,
			@RequestParam(value = "descripcionTarifarango=", required = false) String descripcionTarifarango,
			@RequestParam(value = "estado_cte", required = true) String estado_cte,
			@RequestParam(value = "municipio_cte", required = true) String municipio_cte,
			@RequestParam(value = "colonia_cte", required = true) String colonia_cte,
			@RequestParam(value = "cp_cte", required = true) String cp_cte,
			@RequestParam(value = "numinterior_cte", required = true) String numinterior_cte,
			@RequestParam(value = "numexterior_cte", required = true) String numexterior_cte,
			@RequestParam(value = "calle_cte", required = true) String calle_cte,
			@RequestParam(value = "contacto_cte", required = true) String contacto_cte,
			@RequestParam(value = "fechadocumento", required = false) String fechadocumento,
			@RequestParam(value = "rangoenvios", required = false) String rangoenvios,
			@RequestParam(value = "idrangoenvios", required = false) String idrangoenvios,
			@RequestParam(value = "idconvenio", required = false) String idconvenio,
			@RequestParam(value = "razonsocial_cte", required = true) String razonsocial_cte,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "telefono_cte", required = true) String telefono_cte,
			@RequestParam(value = "movil_cte", required = true) String movil_cte,
			@RequestParam(value = "email_cte", required = true) String email_cte,
			@RequestParam(value = "rfc", required = true) String rfc,
			@RequestParam(value = "asegura", required = false) String tiene_seguro,
			@RequestParam(value = "porcentaje_seguro", required = false) String valor_asegurado,
			@RequestParam(value = "nombre_seguro", required = false) String ciaseguro,
			HttpServletRequest request) throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ConvenioContratoDTO documento = new ConvenioContratoDTO();
		
		UtilsRequest.displayParametros(request);

		documento.setNombre(nombre==null?"":nombre);
		documento.setIdcliente(idcliente);
		documento.setNumcliente(numcliente);
		documento.setEstatus(ConstantesUtils.ESTATUS_ACTIVA);
		documento.setIdtarifa(idtarifa);
		documento.setIddescuento(iddescuento);
		documento.setTipo_precios(tipo_precios); 
		documento.setDescripcionDescuento(descripcionDescuento);
		documento.setDescripcionTarifarango(descripcionTarifarango);
		documento.setRazonsocial_cte(razonsocial_cte);
		documento.setEmail_cte(email_cte);
		documento.setTelefono_cte(telefono_cte);
		documento.setMovil_cte(movil_cte);
		documento.setEstado_cte(estado_cte);
		documento.setMunicipio_cte(municipio_cte);
		documento.setColonia_cte(colonia_cte);
		documento.setCp_cte(cp_cte);
		documento.setNuminterior_cte(numinterior_cte);
		documento.setNumexterior_cte(numexterior_cte);
		documento.setCalle_cte(calle_cte);
		documento.setContacto_cte(contacto_cte);
		documento.setRfc(rfc);
		documento.setRangoenvios(rangoenvios);
		documento.setIdrangoenvios(idrangoenvios);
		documento.setEstatus(ConstantesUtils.ESTATUS_ACTIVA);
		//documento.setFechadocumento(UtilsStringFechas.formatoStrFecha(fechadocumento, "dd-MM-yyyy", "yyyy-MM-dd") );
		documento.setEstadoactualdoc(ConstantesAdminSale.DOC_COTIZACION);
		
		/* DATOS SEGURO */
		if(tiene_seguro != null && tiene_seguro.equals("on")){
			
			documento.setAsegura(1);
			documento.setNombre_seguro(ciaseguro);
			documento.setPorcentaje_seguro(valor_asegurado);
			
		}else{
			
			documento.setAsegura(0);
			documento.setPorcentaje_seguro("");
			
		}

		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		LogHistoriaDTO historia = new LogHistoriaDTO();
		
		try {
			int cotizacion=0;
			if (usuario!=null){
				documento.setLogin(usuario.getLogin());
				cotizacion= bo.insert(documento);
				//Agrega la historia
				historia.setIdregistro(cotizacion);
				historia.setTipomovimiento(ConstantesAdminSale.MOV_INSERT);
				historia.setLogin(usuario.getLogin());
				historia.setRegistro("SE CREA DOCUMENTO DE " + ConstantesAdminSale.DOC_COTIZACION);
				iLogHistoriaBO.insertHistoriaConvenio(historia);
				
				success = true;
				mensaje="Se agrega registro correctamente";
				modelMap.put("cotizacion", cotizacion);
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
	
	/***
	 * Envia el correo y ata el archivo de cotizacion
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/sendMail")
	public @ResponseBody
	Map<String, ? extends Object> sendMail(
			HttpServletRequest request) throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
	
		
		UtilsRequest.displayParametros(request);
	
		
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		LogHistoriaDTO historia = new LogHistoriaDTO();
		
		try {
			//idconvenio idcotizacion idcliente sender subject body
			int cotizacion=0;
			if (usuario!=null){
				ConvenioContratoDTO documento = new ConvenioContratoDTO();
				
				documento.setIdconvenio(request.getParameter("idconvenio"));
				documento.setTipo_contrato(ConstantesAdminSale.DOC_COTIZACION);
				
				EmailProperties send_email = new EmailProperties();
				send_email.setSubject(request.getParameter("subject"));
			
				send_email.addTo_Address(request.getParameter("para"));
				send_email.addTo_AddressCC(request.getParameter("concopia"));
				send_email.setBody(request.getParameter("body"));

				bo.sendMail(documento, send_email);
				documento.setLogin(usuario.getLogin());
				
				//Agrega la historia
				historia.setIdregistro(documento.getIdconvenio());
				historia.setTipomovimiento(ConstantesAdminSale.MOV_SENDMAIL);
				historia.setLogin(usuario.getLogin());
				historia.setRegistro("SE ENVIO CORREO NOTIFICACION AL CLIENTE ");
				iLogHistoriaBO.insertHistoriaConvenio(historia);
				

				mensaje="Se envio correctamente correo al cliente";
			
			}else{
				mensaje=ConstantesAdminSale.MSG_SESSION_FINISH;
			}
			
			modelMap.put("success", true);
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
			@RequestParam(value = "tipo_precios", required = false) String tipo_precios,
			@RequestParam(value = "idcliente", required = false) String idcliente,
			@RequestParam(value = "numcliente", required = false) String numcliente,
			@RequestParam(value = "iddescuento", required = true) int iddescuento,
			@RequestParam(value = "descripcionDescuento", required = false) String descripcionDescuento,
			@RequestParam(value = "idtarifa", required = true) int idtarifa,
			@RequestParam(value = "descripcionTarifarango=", required = false) String descripcionTarifarango,
			@RequestParam(value = "estado_cte", required = true) String estado_cte,
			@RequestParam(value = "municipio_cte", required = true) String municipio_cte,
			@RequestParam(value = "colonia_cte", required = true) String colonia_cte,
			@RequestParam(value = "cp_cte", required = true) String cp_cte,
			@RequestParam(value = "numinterior_cte", required = true) String numinterior_cte,
			@RequestParam(value = "numexterior_cte", required = true) String numexterior_cte,
			@RequestParam(value = "calle_cte", required = true) String calle_cte,
			@RequestParam(value = "contacto_cte", required = true) String contacto_cte,
			@RequestParam(value = "fechadocumento", required = false) String fechadocumento,
			@RequestParam(value = "rangoenvios", required = false) String rangoenvios,
			@RequestParam(value = "idrangoenvios", required = false) String idrangoenvios,
			@RequestParam(value = "idconvenio", required = true) String idconvenio,
			@RequestParam(value = "razonsocial_cte", required = true) String razonsocial_cte,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "telefono_cte", required = true) String telefono_cte,
			@RequestParam(value = "movil_cte", required = true) String movil_cte,
			@RequestParam(value = "email_cte", required = true) String email_cte,
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
		
		documento.setIdtarifa(idtarifa);
		documento.setIddescuento(iddescuento);
		documento.setTipo_precios(tipo_precios); 
		documento.setDescripcionDescuento(descripcionDescuento);
		documento.setDescripcionTarifarango(descripcionTarifarango);
		
		documento.setRazonsocial_cte(razonsocial_cte);
		documento.setEmail_cte(email_cte);
		documento.setTelefono_cte(telefono_cte);
		documento.setMovil_cte(movil_cte);
		documento.setEstado_cte(estado_cte);
		documento.setMunicipio_cte(municipio_cte);
		documento.setColonia_cte(colonia_cte);
		documento.setCp_cte(cp_cte);
		documento.setNuminterior_cte(numinterior_cte);
		documento.setNumexterior_cte(numexterior_cte);
		documento.setCalle_cte(calle_cte);
		documento.setContacto_cte(contacto_cte);
		documento.setRazonsocial_cte(razonsocial_cte);
		documento.setTelefono_cte(telefono_cte);
		documento.setMovil_cte(movil_cte);
		documento.setEmail_cte(email_cte);
		
		
		documento.setRangoenvios(rangoenvios);
		documento.setIdrangoenvios(idrangoenvios); 
		
		//documento.setFechadocumento(UtilsStringFechas.formatoStrFecha(fechadocumento, "dd-MM-yyyy", "yyyy-MM-dd") );
		documento.setEstadoactualdoc(ConstantesAdminSale.DOC_COTIZACION);
		
		/* DATOS SEGURO */
		if(tiene_seguro != null && tiene_seguro.equals("on")){
			
			documento.setAsegura(1);
			documento.setNombre_seguro(ciaseguro);
			documento.setPorcentaje_seguro(valor_asegurado);
			
		}else{
			
			documento.setAsegura(0);
			documento.setPorcentaje_seguro("");
		}
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		LogHistoriaDTO historia = new LogHistoriaDTO();
		
		try {
			int cotizacion=0;
			if (usuario!=null){
				documento.setLogin(usuario.getLogin());
				bo.update(documento);
				//Agrega la historia
				historia.setIdregistro(documento.getIdconvenio());
				historia.setTipomovimiento(ConstantesAdminSale.MOV_UPDATE);
				historia.setLogin(usuario.getLogin());
				historia.setRegistro("SE MODIFICO DOCUMENTO DE " + ConstantesAdminSale.DOC_COTIZACION);
				iLogHistoriaBO.insertHistoriaConvenio(historia);
				
				success = true;
				mensaje="Se modifico el documento:" + documento.getIdconvenio() + ".";
				
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
	/**
	 * Borra un registro
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public @ResponseBody
	Map<String, ? extends Object> delete(
			@RequestParam(value = "identificador", required = true) int identificador,HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();


		try {
			success = true;
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
	
	/***
	 * INserta un registro o registros que vienen de un JSON
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/insertJson", method = RequestMethod.POST, headers = { "content-type=application/json" })
	public @ResponseBody
	Map<String, ? extends Object> insertJson(@RequestBody String json,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ConvenioContratoDTO> listaregistros = new ArrayList<ConvenioContratoDTO>();
		String mensaje = "";
		ConvenioContratoDTOJSON dtoJSON = new ConvenioContratoDTOJSON();


		try {
			// Trata de machear la lista de registos
			dtoJSON.runJSONParser(json);
			if (dtoJSON.getData().size() == 0) {
				// sustituye data por registro y vuelve hacer el parseo
				json = json.replaceAll("data", "registro");
				dtoJSON.runJSONParser(json);
				listaregistros.add(dtoJSON.getRegistro());
			} else {
				listaregistros = dtoJSON.getData();
			}

			for (int i = 0; i < listaregistros.size(); i++) {
				bo.update(listaregistros.get(i));
			}
			mensaje = "Se Actualizo el registro con exito";
		} catch (Exception e) {
			String[] arr_err = null;
			mensaje += e.getMessage();
			mensaje = mensaje.substring(0, mensaje.length() - 1);
			if (mensaje.contains("duplicate key")) {
				arr_err = mensaje.split("\\.");
				mensaje = arr_err[arr_err.length - 1];
				mensaje = mensaje
						.replaceAll("The duplicate key value is",
								"Registro duplicado, verifique");
			}

		}

		dtoJSON.clearData();
		
		result.put("success", true);
		result.put("message", mensaje);
		result.put("mensaje", mensaje);
		listaregistros.clear();
		return result;
	}
	
	/***
	 * Actualiza un registro o registros que vienen de un JSON
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/updateJson", method = RequestMethod.POST, headers = { "content-type=application/json" })
	public @ResponseBody
	Map<String, ? extends Object> updateJson(@RequestBody String json,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ConvenioContratoDTO> listaregistros = new ArrayList<ConvenioContratoDTO>();
		String mensaje = "";
		ConvenioContratoDTOJSON dtoJSON = new ConvenioContratoDTOJSON();


		try {
			// Trata de machear la lista de registos
			dtoJSON.runJSONParser(json);
			if (dtoJSON.getData().size() == 0) {
				// sustituye data por registro y vuelve hacer el parseo
				json = json.replaceAll("data", "registro");
				dtoJSON.runJSONParser(json);
				listaregistros.add(dtoJSON.getRegistro());
			} else {
				listaregistros = dtoJSON.getData();
			}

			for (int i = 0; i < listaregistros.size(); i++) {
				bo.update(listaregistros.get(i));
			}
			mensaje = "Se Actualizo el registro con exito";
		} catch (Exception e) {
			String[] arr_err = null;
			mensaje += e.getMessage();
			mensaje = mensaje.substring(0, mensaje.length() - 1);
			if (mensaje.contains("duplicate key")) {
				arr_err = mensaje.split("\\.");
				mensaje = arr_err[arr_err.length - 1];
				mensaje = mensaje
						.replaceAll("The duplicate key value is",
								"Registro duplicado, verifique");
			}

		}

		dtoJSON.clearData();
		
		result.put("success", true);
		result.put("message", mensaje);
		result.put("mensaje", mensaje);
		listaregistros.clear();
		return result;
	}
	
	
	/***
	 * INserta un registro o registros que vienen de un JSON
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/deleteJson", method = RequestMethod.POST, headers = { "content-type=application/json" })
	public @ResponseBody
	Map<String, ? extends Object> deleteJson(@RequestBody String json,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ConvenioContratoDTO> listaregistros = new ArrayList<ConvenioContratoDTO>();
		String mensaje = "";
		ConvenioContratoDTOJSON dtoJSON = new ConvenioContratoDTOJSON();


		try {
			// Trata de machear la lista de registos
			dtoJSON.runJSONParser(json);
			if (dtoJSON.getData().size() == 0) {
				// sustituye data por registro y vuelve hacer el parseo
				json = json.replaceAll("data", "registro");
				dtoJSON.runJSONParser(json);
				listaregistros.add(dtoJSON.getRegistro());
			} else {
				listaregistros = dtoJSON.getData();
			}

			for (int i = 0; i < listaregistros.size(); i++) {
				bo.update(listaregistros.get(i));
			}
			mensaje = "Se Actualizo el registro con exito";
		} catch (Exception e) {
			String[] arr_err = null;
			mensaje += e.getMessage();
			mensaje = mensaje.substring(0, mensaje.length() - 1);
			if (mensaje.contains("duplicate key")) {
				arr_err = mensaje.split("\\.");
				mensaje = arr_err[arr_err.length - 1];
				mensaje = mensaje
						.replaceAll("The duplicate key value is",
								"Registro duplicado, verifique");
			}

		}

		dtoJSON.clearData();
		
		result.put("success", true);
		result.put("message", mensaje);
		result.put("mensaje", mensaje);
		listaregistros.clear();
		return result;
	}
	
	/**
	 * Desactivan o Activa un registro 
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
			@RequestParam(value = "tipocierre", required = false) String tipocierre,
			@RequestParam(value = "descripciontipocierre", required = false) String descripciontipocierre,
			
			
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ConvenioContratoDTO documento = null;
		LogHistoriaDTO historia = null;
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {

			if (usuario != null) {
				if (ids!=null){
					String[] arr_idstarifas = ids.trim().split("\\|");
					for (String id : arr_idstarifas) {
						
						documento = new ConvenioContratoDTO();
						try{
							documento.setIdconvenio(id);
							documento.setEstatus(estatus);
							documento.setTipocierre(tipocierre);
							documento.setDescripciontipocierre(descripciontipocierre);
							bo.updateEstatus(documento);
							//Agrega la historia
							historia = new LogHistoriaDTO();
							historia.setIdregistro(documento.getIdconvenio());
							historia.setLogin(usuario.getLogin());
							if (tipocierre==null){
								
								if (estatus==1){
									historia.setTipomovimiento(ConstantesAdminSale.MOV_ACTIVAR);
								}else if (estatus==90){
									historia.setTipomovimiento(ConstantesAdminSale.MOV_CERRADO);
								}else{
									historia.setTipomovimiento(ConstantesAdminSale.MOV_DESACTIVAR);
								}
								historia.setRegistro("Se cambia estatus del documento.");
								
							}else{
								bo.updateTipoCierre(documento);
								historia.setTipomovimiento(ConstantesAdminSale.MOV_CERRADO);
								historia.setRegistro("["+ tipocierre + "] " + descripciontipocierre);
							}
							iLogHistoriaBO.insertHistoriaConvenio(historia);
							
						}catch(Exception e){
							logger.error("Error:" + e.getMessage());
						}
						
					}
				}
				modelMap.put("success", true);
				modelMap.put("message", "Se cambio el estatus de los registros seleccionados.");
			} else {
				modelMap.put("success", true);
				modelMap.put("message", ConstantesAdminSale.MSG_SESSION_FINISH);
			}

		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}
		
			
		
		return modelMap;
	}
	
	 
	/**
	 * Muestra el archivo solo para tipos de pdf, png, gif, jpg, texto, cvs
	 * 
	 * @param fileName
	 *            FileName includes path information if file is not in the root
	 *            log directory.
	 * @return file found
	 */
	@RequestMapping(value = "/viewPDFArchivo")
	public void viewPDFArchivo(HttpServletRequest request,
			HttpServletResponse response) {

		ConvenioContratoDTO documento = new ConvenioContratoDTO();
		byte[] bytes=null;
		try {


			documento.setIdconvenio(request.getParameter("idconvenio"));
			documento.setEstadoactualdoc(ConstantesAdminSale.DOC_COTIZACION);
			String error= "<p>No se pudo crear archivo PDF del documento.<p>";
			try{
				 bytes=  bo.getPDFCotizacion(documento);

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
	
	
}
