/**
 * 
 */
package com.innovargia.salesmanager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jdt.internal.core.SetClasspathOperation;
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

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ClientesDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IClientesBO;
import com.innovargia.salesmanager.json.ClientesDTOJSON;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.Validaciones;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adrián
 *  /catalogo/clientes/updateUsuarioCreador
 */
@RequestMapping("/catalogo/clientes")
@Controller
public class ClientesController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ClientesController.class);


	@Autowired 
	IClientesBO bo;
	/**
	 * 
	 */
	public ClientesController() {
		// TODO Auto-generated constructor stub
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
	Map<String, ? extends Object> getDatos(
			@RequestParam(value = "tipobusqueda", required = false) String tipobusqueda,
			@RequestParam(value = "patronbusqueda", required = false) String patronbusqueda,
			HttpServletRequest request)throws Exception {
		boolean showAll = false;
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		BusquedaDTO busqueda = new BusquedaDTO();
		int i_tipobusqueda = (tipobusqueda==null) || (tipobusqueda.trim().length()<=0)?-1:Integer.parseInt(request.getParameter("tipobusqueda"));
		int estatus =  request.getParameter("estatus")==null?-1: Integer.parseInt(request.getParameter("estatus"));
		List<ClientesDTO> lista = new ArrayList<ClientesDTO>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		try {
			
			if (usuario==null){
				throw new Exception(mensaje=ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			busqueda.setTipo(i_tipobusqueda);
			busqueda.setPatron_busqueda(patronbusqueda);
			busqueda.setEstatus(estatus);
			busqueda.setUsuario(usuario);
			lista = bo.getBusquedaRegistros(busqueda);

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
	@RequestMapping("/insert")
	public @ResponseBody
	Map<String, ? extends Object> insert(
			@RequestParam(value = "idcliente", required = false) String idcliente,
			@RequestParam(value = "idgrupo", required = false) String idgrupo,
			@RequestParam(value = "numcliente", required = false) String numcliente,
			@RequestParam(value = "descripcion", required = false) String descripcion,
			@RequestParam(value = "referencia", required = false) String referencia,
			@RequestParam(value = "rfc", required = false) String rfc,
			@RequestParam(value = "observacion", required = false) String observacion,
			@RequestParam(value = "estatus" , required = false) String estatus,
			@RequestParam(value = "tipopersona" , required = false) String tipopersona,
			@RequestParam(value = "tipocliente" , required = false) String tipocliente,
			@RequestParam(value = "clasificacion" , required = false) String clasificacion,

			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ClientesDTO cliente = new ClientesDTO();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			if (usuario!=null){
				cliente.setIdgrupo(Integer.parseInt(idgrupo));
				cliente.setNumcliente(numcliente);
				cliente.setDescripcion(descripcion);
				cliente.setReferencia(referencia);
				cliente.setRfc(rfc);
				cliente.setObservacion(observacion);
				cliente.setTipopersona(tipopersona);
				cliente.setTipocliente(tipocliente);
				
				cliente.setClasificacion(clasificacion);
				cliente.setLogincreador(usuario.getLogin());
				cliente.setUsuario(usuario);
		
				
				if (!Validaciones.validarRfc(rfc, tipopersona)){
					throw new Exception("R.F.C " +  rfc + " inválido");
				}
				
				if (!Validaciones.validarFechaRfc(rfc,tipopersona)){
					throw new Exception("Fecha de R.F.C " +  rfc + " inválida");
				}
				bo.insert(cliente);
				
				
				modelMap.put("message", "Registro agregado de forma correcta.");
			}else{
				modelMap.put("message", ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			modelMap.put("success", true);
			
		} catch (Exception dae) { 
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (mensaje.contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
			}

			modelMap.put("message", mensaje);
		}
		return modelMap;
	}
	
	/**
	 * Actualiza un registro
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update")
	public @ResponseBody
	Map<String, ? extends Object> update(
			@RequestParam(value = "idcliente", required = false) String idcliente,
			@RequestParam(value = "idgrupo", required = false) String idgrupo,
			@RequestParam(value = "numcliente", required = false) String numcliente,
			@RequestParam(value = "descripcion", required = false) String descripcion,
			@RequestParam(value = "referencia", required = false) String referencia,
			@RequestParam(value = "rfc", required = false) String rfc,
			@RequestParam(value = "observacion", required = false) String observacion,
			@RequestParam(value = "estatus" , required = false) String estatus,
			@RequestParam(value = "tipopersona" , required = false) String tipopersona,
			@RequestParam(value = "tipocliente" , required = false) String tipocliente,
			@RequestParam(value = "clasificacion" , required = false) String clasificacion,		

			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ClientesDTO cliente = new ClientesDTO();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario!=null){
				cliente.setIdcliente(Integer.parseInt(idcliente));
				cliente.setIdgrupo(Integer.parseInt(idgrupo));
				cliente.setNumcliente(numcliente);
				cliente.setDescripcion(descripcion);
				cliente.setReferencia(referencia);
				cliente.setRfc(rfc);
				cliente.setObservacion(observacion);
				cliente.setUsuario(usuario);
				cliente.setTipopersona(tipopersona);
				cliente.setTipocliente(tipocliente);
				cliente.setClasificacion(clasificacion);
				
				if (!Validaciones.validarRfc(rfc, tipopersona)){
					throw new Exception("R.F.C " +  rfc + " inválido");
				}
				
				if (!Validaciones.validarFechaRfc(rfc,tipopersona)){
					throw new Exception("Fecha de R.F.C " +  rfc + " inválida");
				}
				bo.update(cliente);

				modelMap.put("message", "Registro modificado de forma correcta.");
			}else{
				modelMap.put("message", ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			modelMap.put("success", true);
			
			
		} catch (Exception dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (mensaje.contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
			}
			modelMap.put("message", mensaje);
		}
		return modelMap;
	}
	
	
	/**
	 * Actualiza un registro con el nuevo usuario creador, esto 
	 * sirve para poder reasignar un cliente
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
			@RequestParam(value = "idcliente", required = false) String idcliente,
			@RequestParam(value = "login", required = false) String logincreador,
			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ClientesDTO cliente = new ClientesDTO();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario!=null){
				cliente.setIdcliente(Integer.parseInt(idcliente));
				cliente.setLogincreador(logincreador);
				
				
				bo.updateUsuarioCreador(cliente);
				logger.error(usuario.getLogin() + " REASIGNO CLIENTE A: "+logincreador);
				modelMap.put("message", "Registro modificado de forma correcta.");
			}else{
				modelMap.put("message", ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			modelMap.put("success", true);
			
			
		} catch (Exception dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
			}
			modelMap.put("message", mensaje);
		}
		return modelMap;
	}
	
	/***
	 * Bloquea o desbloque los registros
	 * @param idsclientes
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/bloquear")
	public @ResponseBody
	Map<String, ? extends Object> bloquear(
			@RequestParam(value = "idsclientes", required = true) String idsclientes,
			@RequestParam(value = "estatus", required = true) int estatus,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ClientesDTO cliente= null;

		try {
			if (idsclientes!=null){
				String[] arr_idsclientes = idsclientes.trim().split("\\|");
				for (String id : arr_idsclientes) {
					
					cliente = new ClientesDTO();
					try{
						cliente.setIdcliente(Integer.parseInt(id));
						cliente.setEstatus(estatus);
						bo.updateEstatus(cliente);
					}catch(Exception e){
						logger.error("Identificador de cliente invalido:" + id);
					}
					
				}
			}
			modelMap.put("success", true);
			modelMap.put("message", "Registros seleccionados fueron desactivados");
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
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
	@RequestMapping("/desactivar")
	public @ResponseBody
	Map<String, ? extends Object> desactivar(
			@RequestParam(value = "idsclientes", required = true) String idsclientes,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ClientesDTO cliente= null;

		try {
			if (idsclientes!=null){
				String[] arr_idsclientes = idsclientes.trim().split("\\|");
				for (String id : arr_idsclientes) {
					
					cliente = new ClientesDTO();
					try{
						cliente.setIdcliente(Integer.parseInt(id));
						cliente.setEstatus(0);
						bo.updateEstatus(cliente);
					}catch(Exception e){
						logger.error("Identificador de cliente invalido:" + id);
					}
					
				}
			}
			modelMap.put("success", true);
			modelMap.put("message", "Registros seleccionados fueron desactivados");
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
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
	@RequestMapping("/activar")
	public @ResponseBody
	Map<String, ? extends Object> activar(
			@RequestParam(value = "idsclientes", required = true) String idsclientes,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ClientesDTO cliente= null;

		try {
			if (idsclientes!=null){
				String[] arr_idsclientes = idsclientes.trim().split("\\|");
				for (String id : arr_idsclientes) {
					
					cliente = new ClientesDTO();
					try{
						cliente.setIdcliente(Integer.parseInt(id));
						cliente.setEstatus(1);
						bo.updateEstatus(cliente);
					}catch(Exception e){
						logger.error("Identificador de cliente invalido:" + id);
					}
					
				}
			}
			modelMap.put("success", true);
			modelMap.put("message", "Registros seleccionados fueron activados");
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
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
			@RequestParam(value = "identificador", required = true) int identificador,
			HttpServletRequest request)	throws Exception {

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
		List<ClientesDTO> listaregistros = new ArrayList<ClientesDTO>();
		String mensaje = "";
		ClientesDTOJSON dtoJSON = new ClientesDTOJSON();


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
		List<ClientesDTO> listaregistros = new ArrayList<ClientesDTO>();
		String mensaje = "";
		ClientesDTOJSON dtoJSON = new ClientesDTOJSON();


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
		List<ClientesDTO> listaregistros = new ArrayList<ClientesDTO>();
		String mensaje = "";
		ClientesDTOJSON dtoJSON = new ClientesDTOJSON();


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
}
