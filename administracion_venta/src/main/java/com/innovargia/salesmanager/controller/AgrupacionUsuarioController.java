/**
 * 
 */
package com.innovargia.salesmanager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import com.innovargia.salesmanager.dtos.AgrupamientoDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IAdicionalesBO;
import com.innovargia.salesmanager.ibo.IAgrupamientoJerarquiaBO;
import com.innovargia.salesmanager.ibo.IUsuarioBO;
import com.innovargia.salesmanager.json.AgrupacionDTOJSON;
import com.innovargia.salesmanager.json.CatalogoDTOJSON;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adrián
 *
 */
@RequestMapping("/usuario/agrupacion")
@Controller
public class AgrupacionUsuarioController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AgrupacionUsuarioController.class);
	
	@Autowired
	IUsuarioBO bo;
	
	@Autowired
	IAgrupamientoJerarquiaBO iAgrupamientoJerarquiaBO;
	/**
	 * 
	 */
	public AgrupacionUsuarioController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Obtiene los datos de las agrupaciones para un usuario
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getAgrupaciones")
	public @ResponseBody
	Map<String, ? extends Object> getAgrupaciones(
			@RequestParam(value = "identidad", required = false) String identidad,
			@RequestParam(value = "idorganizacion", required = false) String idorganizacion,
			@RequestParam(value = "numCliente", required = false) String numcliente,
			@RequestParam(value = "login", required = false) String login,
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = new UsuarioDTO();
			List<AgrupamientoDTO> lista = new ArrayList<AgrupamientoDTO>();
		try {
			UtilsRequest.displayParametros(request);
			usuario.entidad.setIdentidad(identidad);
			usuario.organizacion.setIdorganizacion(idorganizacion);
			usuario.setNumCliente(numcliente);
			usuario.setLogin(login);
			
			if (login!=null){
				lista = bo.getAgrupaciones(usuario);
			}
			
			
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
	
	/**
	 * Obtiene los datos de las agrupaciones para un usuario
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDatosAgrupacionesDeUsuario")
	public @ResponseBody
	Map<String, ? extends Object> getDatosAgrupacionesDeUsuario(
			@RequestParam(value = "identidad", required = false) String identidad,
			@RequestParam(value = "idorganizacion", required = false) String idorganizacion,
			@RequestParam(value = "numCliente", required = false) String numcliente,
			@RequestParam(value = "login", required = false) String login,
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = new UsuarioDTO();
			List<AgrupamientoDTO> lista = new ArrayList<AgrupamientoDTO>();
			UsuarioDTO usuariosesion = ConstantesAdminSale.getSession(request.getSession(true));
		try {
			UtilsRequest.displayParametros(request);
			usuario.setLogin(login);
			
			if (login!=null){
				lista = iAgrupamientoJerarquiaBO.getRegistrosAgrupamientosUsuario(login);
			}else{
				lista = iAgrupamientoJerarquiaBO.getRegistrosAgrupamientosUsuario(usuariosesion.getLogin());
			}
			
			
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
	 * INserta un registro o registros que vienen de un JSON
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/insertJson", method = RequestMethod.POST, headers = { "content-type=application/json" })
	public @ResponseBody
	Map<String, ? extends Object> insertJson(@RequestBody String json,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<AgrupamientoDTO> listaregistros = new ArrayList<AgrupamientoDTO>();
		String mensaje = "";
		AgrupacionDTOJSON dtoJSON = new AgrupacionDTOJSON();


		try {
			// Trata de machear la lista de registos
			dtoJSON.runJSONParser(json);
			if (dtoJSON.getData().size() == 0) {
				// sustituye data por registro y vuelve hacer el parseo
				json = json.replaceAll("proxiArray", "registro");
				dtoJSON.runJSONParser(json);
				listaregistros.add(dtoJSON.getRegistro());
			} else {
				listaregistros = dtoJSON.getData(); 
			}

			for (int i = 0; i < listaregistros.size(); i++) {
				bo.insertAgrupamiento(listaregistros.get(i));
			}
			mensaje = "Se Actualizo el registro con exito";
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(e.getMessage());
			if (e.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
			}

		}

		dtoJSON.clearData();
		
		
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
		List<CatalogoDTO> listaregistros = new ArrayList<CatalogoDTO>();
		String mensaje = "";
		CatalogoDTOJSON dtoJSON = new CatalogoDTOJSON();


		try {
			// Trata de machear la lista de registos
			dtoJSON.runJSONParser(json);
			if (dtoJSON.getData().size() == 0) {
				// sustituye data por registro y vuelve hacer el parseo
				json = json.replaceAll("proxiArray", "registro");
				dtoJSON.runJSONParser(json);
				listaregistros.add(dtoJSON.getRegistro());
			} else {
				listaregistros = dtoJSON.getData();
			}

			for (int i = 0; i < listaregistros.size(); i++) {
				//bo.update(listaregistros.get(i));
			}
			mensaje = "Se Actualizo el registro con exito";
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(e.getMessage());
			if (e.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
			}

		}

		dtoJSON.clearData();

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
		List<AgrupamientoDTO> listaregistros = new ArrayList<AgrupamientoDTO>();
		String mensaje = "";
		AgrupacionDTOJSON dtoJSON = new AgrupacionDTOJSON();


		try {
			// Trata de machear la lista de registos
			dtoJSON.runJSONParser(json);
			if (dtoJSON.getData().size() == 0) {
				// sustituye data por registro y vuelve hacer el parseo
				json = json.replaceAll("proxiArray", "registro");
				dtoJSON.runJSONParser(json);
				listaregistros.add(dtoJSON.getRegistro());
			} else {
				listaregistros = dtoJSON.getData();
			}

			for (int i = 0; i < listaregistros.size(); i++) {
				bo.deleteAgrupamiento(listaregistros.get(i));
			}
			mensaje = "Se Actualizo el registro con exito";
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(e.getMessage());
			if (e.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
			}

		}

		dtoJSON.clearData();

		result.put("message", mensaje);
		result.put("mensaje", mensaje);
		listaregistros.clear();
		return result;
	}
	
	
}
