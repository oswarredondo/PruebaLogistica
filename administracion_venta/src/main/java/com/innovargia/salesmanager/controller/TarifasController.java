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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;
import com.innovargia.salesmanager.ibo.ITarifasBO;
import com.innovargia.salesmanager.json.TarifasDTOJSON;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.UtilsStringFechas;

/**
 * @author Adrián
 *
 */
@RequestMapping("/tarifas")
@Controller
public class TarifasController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(TarifasController.class);

	@Autowired 
	ITarifasBO bo;

	/**
	 * 
	 */
	public TarifasController() {
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
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		//tipobusqueda:tipobusqueda,fechainicial:fechainicial,fechafinal:fechafinal,patron:patron
		BusquedaDTO busquedaDTO = new BusquedaDTO();
		List<TarifaDTO>   lista = new ArrayList<TarifaDTO>();
		
		TarifaDTO tarifa = new TarifaDTO();
		tarifa.setEstatus(-1);
		UtilsRequest.displayParametros(request);
		//
		try {
		   
			if ((request.getParameter("tipobusqueda") !=null) && (request.getParameter("tipobusqueda").trim().length()>0)){
				int tipo = Integer.parseInt(request.getParameter("tipobusqueda")); 
				busquedaDTO.setTipo(tipo);
				busquedaDTO.setPatron_busqueda(request.getParameter("patron"));
				busquedaDTO.setFechainicial(UtilsStringFechas.formatoStrFecha(request.getParameter("fechainicial"), "dd-MM-yyyy", "yyyy-MM-dd") );
				busquedaDTO.setFechafinal(UtilsStringFechas.formatoStrFecha(request.getParameter("fechafinal"), "dd-MM-yyyy", "yyyy-MM-dd") ); 
				if (tipo==10){
					//SSolo los activos
					busquedaDTO.setEstatus(1);
				}else{
					busquedaDTO.setEstatus(-1);
				}
				
				 if (request.getParameter("soloactivos")!=null){
				     busquedaDTO.setEstatus(1);
				 }
				
				lista = bo.getRegistros(busquedaDTO);
						success = true;
			}
			
			
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
			//@ModelAttribute("tarifa") TarifaDTO tarifa,  
			@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			@RequestParam(value = "fechainicial" , required = false) String fechainicial,
			@RequestParam(value = "fechafinal" , required = false) String fechafinal,
			@RequestParam(value = "idservicio" , required = false) String idservicio,
			@RequestParam(value = "idformapago" , required = false) String idformapago,
			@RequestParam(value = "es_visible_pdv" , required = false) String es_visible_pdv,
			@RequestParam(value = "es_default" , required = false) boolean es_default, 
			HttpServletRequest request)	throws Exception {
	    
	    UtilsRequest.displayParametros(request);
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
			TarifaDTO tarifa = new TarifaDTO();

		try {
			tarifa.setNombre(nombre);
			tarifa.setDescripcion(descripcion);
			tarifa.setIdservicio(idservicio);
			tarifa.setIdformapago(idformapago);
			tarifa.setEs_visible_pdv(es_visible_pdv);
			tarifa.setEs_default(es_default);
		    
			tarifa.setFechainicial(UtilsStringFechas.formatoStrFecha(fechainicial, "dd-MM-yyyy", "yyyy-MM-dd") );
			tarifa.setFechafinal(UtilsStringFechas.formatoStrFecha(fechafinal, "dd-MM-yyyy", "yyyy-MM-dd") );
			bo.insert(tarifa);
			modelMap.put("success", true);
			modelMap.put("message", "Se agrego correctamente la tarifa, realiza  consulta.");
		} catch (DataAccessException dae) {
		
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());


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
		//@ModelAttribute("tarifa") TarifaDTO tarifa,  
			@RequestParam(value = "idtarifa", required = true) int idtarifa,
			@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			@RequestParam(value = "fechainicial" , required = false) String fechainicial,
			@RequestParam(value = "fechafinal" , required = false) String fechafinal,
			@RequestParam(value = "idservicio" , required = false) String idservicio,
			@RequestParam(value = "idformapago" , required = false) String idformapago,
			@RequestParam(value = "es_visible_pdv" , required = false) String es_visible_pdv,
			@RequestParam(value = "es_default" , required = false) boolean es_default, 
			HttpServletRequest request)	throws Exception {

	
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		TarifaDTO tarifa = new TarifaDTO();

		try {
			tarifa.setIdtarifa(idtarifa);
			tarifa.setNombre(nombre);
			tarifa.setDescripcion(descripcion);
			tarifa.setIdservicio(idservicio);
			tarifa.setIdformapago(idformapago);
			tarifa.setEs_visible_pdv(es_visible_pdv);
			tarifa.setEs_default(es_default);
			
			tarifa.setFechainicial(UtilsStringFechas.formatoStrFecha(fechainicial, "dd-MM-yyyy", "yyyy-MM-dd") );
			tarifa.setFechafinal(UtilsStringFechas.formatoStrFecha(fechafinal, "dd-MM-yyyy", "yyyy-MM-dd") );
			
			bo.update(tarifa);
			modelMap.put("success", true);
			modelMap.put("message", "La información fue actualizada de forma correcta. ");
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}
	

	@RequestMapping("/clonar")
	public @ResponseBody
	Map<String, ? extends Object> clonar(
		//@ModelAttribute("tarifa") TarifaDTO tarifa,  
			@RequestParam(value = "idtarifa", required = true) int idtarifa,
			@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			@RequestParam(value = "fechainicial" , required = false) String fechainicial,
			@RequestParam(value = "fechafinal" , required = false) String fechafinal,
			@RequestParam(value = "idservicio" , required = false) String idservicio,
			@RequestParam(value = "idformapago" , required = false) String idformapago,
			@RequestParam(value = "es_visible_pdv" , required = false) String es_visible_pdv,
			@RequestParam(value = "porcentaje_incremento_precio", required = true) int porcentaje_incremento_precio,
			@RequestParam(value = "porcentaje_incremento_kgsobrepeso", required = true) int porcentaje_incremento_kgsobrepeso,
			HttpServletRequest request)	throws Exception {
	
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		TarifaDTO tarifa = new TarifaDTO();

		try {
			tarifa.setIdtarifa(idtarifa);
			tarifa.setNombre(nombre);
			tarifa.setDescripcion(descripcion);
			tarifa.setIdservicio(idservicio);
			tarifa.setIdformapago(idformapago);
			tarifa.setEs_visible_pdv(es_visible_pdv);
			tarifa.setFechainicial(UtilsStringFechas.formatoStrFecha(fechainicial, "dd-MM-yyyy", "yyyy-MM-dd") );
			tarifa.setFechafinal(UtilsStringFechas.formatoStrFecha(fechafinal, "dd-MM-yyyy", "yyyy-MM-dd") );
			
			bo.clonarTarifa(tarifa, fechainicial, fechafinal, porcentaje_incremento_precio, porcentaje_incremento_kgsobrepeso);
			modelMap.put("success", true);
			modelMap.put("message", "La información fue actualizada de forma correcta");
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
		    TarifaDTO tarifa= new TarifaDTO();
		    tarifa.setIdtarifa(identificador);
		    bo.deleteTarifa(tarifa);
		    modelMap.put("success", true);
		    modelMap.put("message", "Tarifa fue eliminada");
		} catch (Exception dae) {
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
	Map<String, ? extends Object> insertJson(@RequestBody String json,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<TarifaDTO> listaregistros = new ArrayList<TarifaDTO>();
		String mensaje = "";
		TarifasDTOJSON dtoJSON = new TarifasDTOJSON();


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
	Map<String, ? extends Object> updateJson(@RequestBody String json,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<TarifaDTO> listaregistros = new ArrayList<TarifaDTO>();
		String mensaje = "";
		TarifasDTOJSON dtoJSON = new TarifasDTOJSON();


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
	Map<String, ? extends Object> deleteJson(@RequestBody String json,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<TarifaDTO> listaregistros = new ArrayList<TarifaDTO>();
		String mensaje = "";
		TarifasDTOJSON dtoJSON = new TarifasDTOJSON();


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
}
