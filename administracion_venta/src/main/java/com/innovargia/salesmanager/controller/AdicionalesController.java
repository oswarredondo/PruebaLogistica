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

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.IAdicionalesBO;
import com.innovargia.salesmanager.json.CatalogoDTOJSON;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adrián
 *
 */
@RequestMapping("/catalogo/adicionales")
@Controller
public class AdicionalesController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AdicionalesController.class);
	
	@Autowired
	IAdicionalesBO bo;
	
	/**
	 * 
	 */
	public AdicionalesController() {
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
	Map<String, ? extends Object> getDatos(HttpServletRequest request)throws Exception {
		boolean showAll = false;
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CatalogoDTO objeto = new CatalogoDTO();
		objeto.setEstatus(-1);
		List<CatalogoDTO> lista =null;
		try {
			lista  = bo.getRegistros(objeto);  
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", success);
				modelMap.put("message", dae.getMessage());
			}

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
	@RequestMapping("/getDatosXTipo")
	public @ResponseBody
	Map<String, ? extends Object> getDatosXTipo(HttpServletRequest request)throws Exception {
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CatalogoDTO objeto = new CatalogoDTO();
		objeto.setEstatus(-1);
		List<CatalogoDTO> lista =null;
		try {
			objeto.setTipo(request.getParameter("tipo"));
			if (objeto.getTipo()==null){
				objeto.setTipo("0"); //Por default devuelve los adicionales que no son requeridos
			}
			lista  = bo.getRegistrosXTipo(objeto);  
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", success);
				modelMap.put("message", dae.getMessage());
			}

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
			@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			@RequestParam(value = "estatus" , required = false) String estatus,
			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();


		try {
			success = true;
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
			}

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
			@RequestParam(value = "identificador", required = true) int identificador,
			@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			@RequestParam(value = "estatus" , required = false) String estatus,
			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();


		try {
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
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
				bo.insert(listaregistros.get(i));
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
				bo.update(listaregistros.get(i));
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
				bo.delete(listaregistros.get(i));
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
