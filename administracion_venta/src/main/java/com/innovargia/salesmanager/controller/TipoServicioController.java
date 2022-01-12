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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovargia.salesmanager.dtos.ServicioDTO;
import com.innovargia.salesmanager.ibo.ITipoServicioBO;
import com.innovargia.salesmanager.json.ServicioDTOJSON;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adrián
 * /catalogo/tiposervicio/insert
 * /catalogo/tiposervicio/delete
 *
 */
@RequestMapping("/catalogo/tiposervicio")
@Controller
public class TipoServicioController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(TipoServicioController.class);
	
	@Autowired
	ITipoServicioBO bo;
	
	
	
	/**
	 * 
	 */
	public TipoServicioController() {
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

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ServicioDTO objeto = new ServicioDTO();
		objeto.setEstatus(-1);
		List<ServicioDTO> lista =null;
		
		UtilsRequest.displayParametros(request);  
		
		try {
			objeto.setIdentidad(request.getParameter("identidad"));
			objeto.setIdorganizacion(request.getParameter("idorganizacion"));
			lista  = bo.getRegistros(objeto);  
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
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "idservicio", required = false) String idservicio,
			@RequestParam(value = "codigoid", required = false) String codigoid,
			@RequestParam(value = "identidad", required = true) int identidad,
			@RequestParam(value = "idorganizacion", required = true) int idorganizacion,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ServicioDTO objeto = new ServicioDTO();
		String mensaje="";
		try {
			objeto.setIdservicio(idservicio);
			objeto.setCodigoid(codigoid);
			objeto.setIdentidad(identidad);
			objeto.setIdorganizacion(idorganizacion);
			objeto.setDescripcion(descripcion);
			objeto.setEstatus(1);
			if (objeto.getNombre()==null){
				objeto.setNombre(descripcion);
			}
			
			bo.insert(objeto);
			
			modelMap.put("success", true);
			modelMap.put("message", "Registro agregado de forma correcta.");
		} catch (Exception dae) {
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
			@RequestParam(value = "identificador", required = false) int identificador,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "idservicio", required = false) String idservicio,
			@RequestParam(value = "codigoid", required = false) String codigoid,
			@RequestParam(value = "identidad", required = true) int identidad,
			@RequestParam(value = "idorganizacion", required = true) int idorganizacion,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ServicioDTO objeto = new ServicioDTO();
		String mensaje="";
		try {
			objeto.setIdentidad(identidad);
			objeto.setIdorganizacion(idorganizacion);
			objeto.setIdservicio(idservicio);
			objeto.setCodigoid(codigoid);


			objeto.setDescripcion(descripcion);
			if (objeto.getNombre()==null){
				objeto.setNombre(descripcion);
			}
			
			bo.insert(objeto);
			
			modelMap.put("success", true);
			modelMap.put("message", "Registro agregado de forma correcta.");
		} catch (Exception dae) {
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
			@RequestParam(value = "idservicio", required = false) String idservicio,
			@RequestParam(value = "identidad", required = true) int identidad,
			@RequestParam(value = "idorganizacion", required = true) int idorganizacion,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ServicioDTO objeto = new ServicioDTO();
		String mensaje="";
		try {
			objeto.setIdentificador(identificador);
			objeto.setIdentidad(identidad);
			objeto.setIdorganizacion(idorganizacion);
			objeto.setIdservicio(idservicio);
			
			bo.delete(objeto);
			
			modelMap.put("success", true);
			modelMap.put("message", "Registro agregado de forma correcta.");
		} catch (Exception dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
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
		List<ServicioDTO> listaregistros = new ArrayList<ServicioDTO>();
		String mensaje = "";
		ServicioDTOJSON dtoJSON = new ServicioDTOJSON();


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
		List<ServicioDTO> listaregistros = new ArrayList<ServicioDTO>();
		String mensaje = "";
		ServicioDTOJSON dtoJSON = new ServicioDTOJSON();


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
		List<ServicioDTO> listaregistros = new ArrayList<ServicioDTO>();
		String mensaje = "";
		ServicioDTOJSON dtoJSON = new ServicioDTOJSON();


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
