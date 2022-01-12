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
import com.innovargia.salesmanager.dtos.TarifaAdicionalDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IAdicionalesBO;
import com.innovargia.salesmanager.ibo.ITarifaAdicionalBO;
import com.innovargia.salesmanager.json.TarifaAdicionalDTOJSON;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsRequest;

/**
 * @author Adrián
 * 
 */
@RequestMapping("/tarifaadicional")
@Controller
public class TarifaAdicionalController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(TarifaAdicionalController.class);
	
	@Autowired
	ITarifaAdicionalBO bo;
	@Autowired
	IAdicionalesBO iAdicionalesBO;
	/**
	 * 
	 */
	public TarifaAdicionalController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Obtiene los datos de los adicionales de una tarifa
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

		List<TarifaAdicionalDTO>   lista = new ArrayList<TarifaAdicionalDTO>();
		
		TarifaAdicionalDTO tarifa = new TarifaAdicionalDTO();
		tarifa.setEstatus(-1);
		UtilsRequest.displayParametros(request);
		try {
			
			if (request.getParameter("idconvenio")!=null){
				tarifa.setIdtarifa(request.getParameter("idconvenio"));
				tarifa.setIdconvenio(request.getParameter("idconvenio"));
				lista = bo.getRegistros(tarifa);
			}
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
		} catch (Exception dae) {
				modelMap.put("success", success);
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
	@RequestMapping("/insert")
	public @ResponseBody
	Map<String, ? extends Object> insert(
			@RequestParam(value = "ids", required = true) String ids,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		TarifaAdicionalDTO tarifaadicional= null;
		CatalogoDTO adicional = new CatalogoDTO();
		UtilsRequest.displayParametros(request);

		try {
		    UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		    if (!usuario.opcionAsignadaPerfiles("solo.actualiza.numcliente.en.convenio")){
			if (ids!=null){
				String[] arr_ids = ids.trim().split("\\|");
				for (String id : arr_ids) {
					
					tarifaadicional = new TarifaAdicionalDTO();
					try{
						tarifaadicional.setIdadicional(Integer.parseInt(id));
						tarifaadicional.setIdconvenio(Integer.parseInt(request.getParameter("idconvenio")));
						adicional.setIdentificador(id);
						adicional = iAdicionalesBO.get(adicional);
						if (adicional!=null){
							tarifaadicional.setPrecio(adicional.getPrecio());
							tarifaadicional.setClaveadicional(adicional.getClave());
							tarifaadicional.setEstatus(adicional.getTipo()); 
							bo.insert(tarifaadicional);
						}
						
					}catch(Exception e){
						logger.error("Registro duplicado:" + id);
					}
					
				}
				
				
			}else{
			    modelMap.put("message", ConstantesAdminSale.MSG_OPERACION_UPDATE_RESTRINGIDA);
			}
			modelMap.put("success", true);
			
		    }else{
			
		    }
			
			
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
			@RequestParam(value = "identificador", required = true) int identificador,
			@RequestParam(value = "nombre", required = true) String nombre,
			@RequestParam(value = "descripcion", required = true) String descripcion,
			@RequestParam(value = "estatus" , required = false) String estatus,HttpServletRequest request)	throws Exception {

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
		List<TarifaAdicionalDTO> listaregistros = new ArrayList<TarifaAdicionalDTO>();
		String mensaje = "";
		TarifaAdicionalDTOJSON dtoJSON = new TarifaAdicionalDTOJSON();


		try {
		    UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		    if (!usuario.opcionAsignadaPerfiles("solo.actualiza.numcliente.en.convenio")){
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
		    }else{
			mensaje=ConstantesAdminSale.MSG_OPERACION_UPDATE_RESTRINGIDA;
		    }
			
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
		List<TarifaAdicionalDTO> listaregistros = new ArrayList<TarifaAdicionalDTO>();
		String mensaje = "";
		TarifaAdicionalDTOJSON dtoJSON = new TarifaAdicionalDTOJSON();


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
			TarifaAdicionalDTO tarifaAdicionalDTO=null;
			for (int i = 0; i < listaregistros.size(); i++) {
				tarifaAdicionalDTO = bo.get(listaregistros.get(i));
				if (tarifaAdicionalDTO.getTipoincremento()==1){
					//El valor no puede ser menor al original ya 
					//guardado
					if (listaregistros.get(i).getPrecio()<tarifaAdicionalDTO.getPrecio()){
						throw new Exception("Configuración no permitida, para el adicional:" +
								tarifaAdicionalDTO.getDescripcion() );
					}
					
				}else if (tarifaAdicionalDTO.getTipoincremento()==2){
					//El valor no puede ser mayor al original ya 
					//guardado
					if (listaregistros.get(i).getPrecio()>tarifaAdicionalDTO.getPrecio()){
						throw new Exception("Configuración no permitida, para el adicional:" +
								tarifaAdicionalDTO.getDescripcion() );
					}
				}
				bo.update(listaregistros.get(i));
			}
			result.put("success", true);
			mensaje = "Se Actualizo el registro con exito";
		} catch (Exception e) {
			result.put("success", false);
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
		List<TarifaAdicionalDTO> listaregistros = new ArrayList<TarifaAdicionalDTO>();
		String mensaje = "";
		TarifaAdicionalDTOJSON dtoJSON = new TarifaAdicionalDTOJSON();


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
