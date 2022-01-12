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
import com.innovargia.salesmanager.dtos.EntidadDTO;
import com.innovargia.salesmanager.dtos.OrganizacionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IOrganizacionBO;
import com.innovargia.salesmanager.json.CatalogoDTOJSON;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adrián
 *
 */
@RequestMapping("/catalogo/entidadorganizacion")
@Controller
public class EntidadOrganizacionController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(EntidadOrganizacionController.class);
	
	@Autowired
	IOrganizacionBO iOrganizacionBO;
	
	/**
	 * 
	 */
	public EntidadOrganizacionController() {
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
	@RequestMapping("/getDatosEntidad")
	public @ResponseBody
	Map<String, ? extends Object> getDatosEntidad(HttpServletRequest request)throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CatalogoDTO objeto = new CatalogoDTO();
		objeto.setEstatus(-1);
		List<EntidadDTO> lista =null;
		boolean onlyActive= true;
		try{
			onlyActive= Boolean.parseBoolean(request.getParameter("onlyActive"));
		}catch(Exception e){
			
		}
		
		try {
			lista  = iOrganizacionBO.getEntidades(onlyActive);
			modelMap.put("success", true);
			modelMap.put("message", "Se obtivieron los datos solicitados");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

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
	@RequestMapping("/getDatosOrganizacionDeEntidad")
	public @ResponseBody
	Map<String, ? extends Object> getDatosOrganizacion(HttpServletRequest request)throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CatalogoDTO objeto = new CatalogoDTO();
		objeto.setEstatus(-1);
		List<OrganizacionDTO> lista =null;
		boolean onlyActive= true;
		try{
			onlyActive= Boolean.parseBoolean(request.getParameter("onlyActive"));
		}catch(Exception e){
			
		}
		
		try {
			if (request.getParameter("identidad")!=null){
				
				
				lista  = iOrganizacionBO.getOrganizacionEntidad(request.getParameter("identidad"),onlyActive);
			}else{
				lista= new ArrayList<OrganizacionDTO>();
			}
			
			modelMap.put("success", true);
			modelMap.put("message", "Se obtivieron los datos solicitados");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	/**
	 * Activa/Desactiva un conjunto de registros
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/activarDesactivarEntidad")
	public @ResponseBody
	Map<String, ? extends Object> activarEntidad(
			@RequestParam(value = "ids", required = true) String ids,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		try {
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			
			if (ids!=null){
				String[] arr_idstarifas = ids.trim().split("\\|");
				for (String id : arr_idstarifas) {
					try{
						iOrganizacionBO.updateEstadoEntidad(Integer.parseInt(id), request.getParameter("estatus"));
					}catch(Exception e){
						logger.error("Identificador de entidad invalido:" + id);
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
	 * Activa/Desactiva un conjunto de registros
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/activarDesactivarOrganizacion")
	public @ResponseBody
	Map<String, ? extends Object> activarDesactivarOrganizacion(
			@RequestParam(value = "ids", required = true) String ids,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		try {
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			
			if (ids!=null){
				String[] arr_idstarifas = ids.trim().split("\\|");
				for (String id : arr_idstarifas) {
					try{
						iOrganizacionBO.updateEstadoOrganizacionEntidad(
								Integer.parseInt(request.getParameter("identidad")),
								Integer.parseInt(id),
								request.getParameter("estatus") );
					}catch(Exception e){
						logger.error("Identificador de entidad invalido:" + id);
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
	
	/***
	 * Agrega un registro 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertEntidad")
	public @ResponseBody
	Map<String, ? extends Object> insert(
			
			@RequestParam(value = "descripcion" , required = true) String descripcion,
			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje = null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		try {

			UsuarioDTO usuario = ConstantesAdminSale.getSession(request
					.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			iOrganizacionBO.insertEntidad("A", descripcion.toUpperCase().trim());
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			modelMap.put("success", success);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
			}

		}

		return modelMap;
	}
	
	/***
	 * Modifica un registro 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateEntidad")
	public @ResponseBody
	Map<String, ? extends Object> updateEntidad(
			
			@RequestParam(value = "descripcion" , required = true) String descripcion,
			@RequestParam(value = "identidad" , required = true) int entidad,
			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje = null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		try {

			UsuarioDTO usuario = ConstantesAdminSale.getSession(request
					.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			iOrganizacionBO.updateDescrupcionEntidad(entidad, descripcion.toUpperCase().trim()); 
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			modelMap.put("success", success);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
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
	@RequestMapping("/insertOrganizacionDeEntidad")
	public @ResponseBody
	Map<String, ? extends Object> insertOrganizacionDeEntidad(
			
			@RequestParam(value = "descripcion" , required = true) String descripcion,
			@RequestParam(value = "identidad" , required = true) int entidad,
			HttpServletRequest request)	throws Exception {

		String mensaje = null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		try {

			UsuarioDTO usuario = ConstantesAdminSale.getSession(request
					.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			iOrganizacionBO.insertOrganizacionEntidad(entidad, "A", descripcion.toUpperCase().trim());
			modelMap.put("success", true);
			modelMap.put("message", "Se agrego registro");
			
		} catch (DataAccessException dae) {
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
	 * Modifica un registro 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateOrganizacionEntidad")
	public @ResponseBody
	Map<String, ? extends Object> updateOrganizacionEntidad(
			
			@RequestParam(value = "descripcion" , required = true) String descripcion,
			@RequestParam(value = "identidad" , required = true) int entidad,
			@RequestParam(value = "idorganizacion" , required = true) int idorganizacion,
			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje = null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		try {

			UsuarioDTO usuario = ConstantesAdminSale.getSession(request
					.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			iOrganizacionBO.updateDescripcionOrganizacionEntidad(entidad, idorganizacion, descripcion.trim().toUpperCase());
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			modelMap.put("success", success);
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
				//bo.insert(listaregistros.get(i));
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
			//	bo.delete(listaregistros.get(i));
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
