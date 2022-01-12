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

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.ITarifaPesoBO;
import com.innovargia.salesmanager.json.TarifasDTOJSON;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adri�n
 * 
 */
@RequestMapping("/tarifapeso")
@Controller
public class TarifasPesoController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(TarifasPesoController.class);

	@Autowired 
	ITarifaPesoBO bo;
	/**
	 * 
	 */
	public TarifasPesoController() {
		// TODO Auto-generated constructor stub
	}

	/***
	 * Obtiene los datos de las tarifas sevicios atadas a la 
	 * tarifa seleccionada
	 * @param idtarifa
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDatosPesosDisponibles")
	public @ResponseBody
	Map<String, ? extends Object> getDatosPesosDisponibles(
			HttpServletRequest request)throws Exception {
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		TarifaDTO busquedaDTO = new TarifaDTO();
		List<TarifaDTO>   lista = new ArrayList<TarifaDTO>();
		
		UtilsRequest.displayParametros(request);
		try {
		
			if (request.getParameter("idrangoenvios")!=null){ 
				busquedaDTO.setEstatus(-1);
				busquedaDTO.setIdrangoenvios(Integer.parseInt(request.getParameter("idrangoenvios")));
				lista = bo.getRegistrosPesoDisponibles(busquedaDTO,null);
			}
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
		} catch (Exception dae) {
		
				modelMap.put("success", success);
				modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	/***
	 * Obtiene los datos de las tarifas sevicios atadas a la 
	 * tarifa seleccionada
	 * @param idtarifa
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDatos")
	public @ResponseBody
	Map<String, ? extends Object> getDatos(
			HttpServletRequest request)throws Exception {
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		BusquedaDTO busquedaDTO = new BusquedaDTO();
		List<TarifaDTO>   lista = new ArrayList<TarifaDTO>();
		
		UtilsRequest.displayParametros(request);
		try {
		
			if (request.getParameter("idrangoenvios")!=null){ 
				busquedaDTO.setEstatus(-1);
				String idrangoenvios = request.getParameter("idrangoenvios");
				busquedaDTO.setIdentificador(Integer.parseInt(idrangoenvios));
				lista = bo.getRegistros(busquedaDTO);
			}
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
		} catch (Exception dae) {
		
				modelMap.put("success", success);
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
			@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			@RequestParam(value = "fechainicial" , required = false) String fechainicial,
			@RequestParam(value = "fechafinal" , required = false) String fechafinal,
			@RequestParam(value = "idservicio" , required = false) String idservicio,
			@RequestParam(value = "idformapago" , required = false) String idformapago,
			HttpServletRequest request)	throws Exception {
		
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		TarifaDTO tarifa = new TarifaDTO();

		try {

			bo.insert(tarifa);
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
			@RequestParam(value = "idtarifa", required = true) int idtarifa,
			@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			@RequestParam(value = "fechainicial" , required = false) String fechainicial,
			@RequestParam(value = "fechafinal" , required = false) String fechafinal,
			@RequestParam(value = "idservicio" , required = false) String idservicio,
			@RequestParam(value = "idformapago" , required = false) String idformapago,

			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		TarifaDTO tarifa = new TarifaDTO();

		try {
		
			bo.update(tarifa);
			modelMap.put("success", true);
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
	Map<String, ? extends Object> insertJson(@RequestBody String json,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<TarifaDTO> listaregistros = new ArrayList<TarifaDTO>();
		String mensaje = "";
		TarifasDTOJSON dtoJSON = new TarifasDTOJSON();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if(usuario==null){
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
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
				mensaje += ". Los cambios ser�n deshechos, verifique.";
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
	Map<String, ? extends Object> updateJson(@RequestBody String json,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<TarifaDTO> listaregistros = new ArrayList<TarifaDTO>();
		String mensaje = "";
		TarifasDTOJSON dtoJSON = new TarifasDTOJSON();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			if(usuario==null){
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
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
				mensaje += ". Los cambios ser�n deshechos, verifique.";
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
	Map<String, ? extends Object> deleteJson(@RequestBody String json,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<TarifaDTO> listaregistros = new ArrayList<TarifaDTO>();
		String mensaje = "";
		TarifasDTOJSON dtoJSON = new TarifasDTOJSON();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			if(usuario==null){
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
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
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}
		}

		dtoJSON.clearData();
		
		
		result.put("message", mensaje);
		result.put("mensaje", mensaje);
		listaregistros.clear();
		return result;
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
			@RequestParam(value = "idstarifas", required = true) String idstarifas,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		TarifaDTO tarifa= null;


		try {
			if (idstarifas!=null){
				String[] arr_idstarifas = idstarifas.trim().split("\\|");
				for (String id : arr_idstarifas) {
					
					tarifa = new TarifaDTO();
					try{
						tarifa.setIdtarifa(Integer.parseInt(id));
						tarifa.setEstatus(0);
						bo.updateEstatus(tarifa);
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
			@RequestParam(value = "idstarifas", required = true) String idstarifas,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		TarifaDTO tarifa= null;

		try {
			if (idstarifas!=null){
				String[] arr_idstarifas = idstarifas.trim().split("\\|");
				for (String id : arr_idstarifas) {
					
					tarifa = new TarifaDTO();
					try{
						tarifa.setIdtarifa(Integer.parseInt(id));
						tarifa.setEstatus(1);
						bo.updateEstatus(tarifa);
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
	 * Obtiene el sobre peso para una linea de cotizacion
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSobrePeso")
	public @ResponseBody
	Map<String, ? extends Object> getSobrePeso(
			@RequestParam(value = "peso", required = true) int peso,
			@RequestParam(value = "idrangoenvios", required = true) int idrangoenvios,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		

		try {
			TarifaDTO tarifa= new TarifaDTO();
			tarifa.setPesoamparado(peso);
			tarifa.setIdrangoenvios(idrangoenvios);
			float sobrepeso = bo.getSobrePeso(tarifa);
			
			if (sobrepeso>=0){
				modelMap.put("sobrepeso", sobrepeso);
			}
			modelMap.put("success", true);
			modelMap.put("message", "Registros seleccionados fueron activados");
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
		}
		return modelMap;
	}
}
