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
import com.innovargia.salesmanager.dtos.DescuentoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IDescuentoBO;
import com.innovargia.salesmanager.json.DescuentoDTOJSON;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adrián
 *
 */
@RequestMapping("/descuento")
@Controller
public class DescuentoController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(DescuentoController.class);


	@Autowired 
	IDescuentoBO bo;
	/**
	 * 
	 */
	public DescuentoController() {
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
		List<DescuentoDTO>   lista = new ArrayList<DescuentoDTO>();

		
		try {
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			busquedaDTO.setNivel(usuario.getNivelPuesto());
			if ((request.getParameter("tipobusqueda") !=null) && (request.getParameter("tipobusqueda").trim().length()>0)){
				int tipo = Integer.parseInt(request.getParameter("tipobusqueda")); 
				busquedaDTO.setTipo(tipo);
				busquedaDTO.setUsuario(usuario);
				busquedaDTO.setPatron_busqueda(request.getParameter("patron"));
					busquedaDTO.setEstatus(-1);
				
				if (tipo==10){
					
					busquedaDTO.setIdcliente(request.getParameter("fechainicial")  ); 
					busquedaDTO.setIdtarifa(request.getParameter("fechafinal")  );
				}else{
					busquedaDTO.setFechainicial(UtilsStringFechas.formatoStrFecha(request.getParameter("fechainicial"), "dd-MM-yyyy", "yyyy-MM-dd") );
					busquedaDTO.setFechafinal(UtilsStringFechas.formatoStrFecha(request.getParameter("fechafinal"), "dd-MM-yyyy", "yyyy-MM-dd") ); 

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
			@RequestParam(value = "iddescuento", required = false) String iddescuento,
			@RequestParam(value = "nombre", required = false) String nombre, 
			@RequestParam(value = "tipo", required = false) String tipo, 
			@RequestParam(value = "descripcion", required = false) String descripcion,
			@RequestParam(value = "porcentaje", required = false) String porcentaje,
			@RequestParam(value = "descuentofijo", required = false) String descuentofijo,
			@RequestParam(value = "fechaactivacion", required = false) String fechaactivacion,
			@RequestParam(value = "fechatermino", required = false) String fechatermino,
			@RequestParam(value = "nivel", required = false) String nivel,
			@RequestParam(value = "idagrupamiento", required = false) String idagrupamiento,
			
			HttpServletRequest request
	)	throws Exception {

		boolean success = false;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		DescuentoDTO descuento = new DescuentoDTO();
		String mensaje;
		try {
			
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			descuento.setNombre(nombre);
			descuento.setDescripcion(descripcion);
			descuento.setPorcentaje(porcentaje); 
			descuento.setTipo(tipo);
			descuento.setNivel(nivel);
			descuento.setIdagrupamiento(idagrupamiento);
			descuento.setDescuentofijo(descuentofijo);
			descuento.setFechaactivacion(UtilsStringFechas.formatoStrFecha(request.getParameter("fechaactivacion"), "dd-MM-yyyy", "yyyy-MM-dd") );
			descuento.setFechatermino(UtilsStringFechas.formatoStrFecha(request.getParameter("fechatermino"), "dd-MM-yyyy", "yyyy-MM-dd")); 
			descuento.setFechaalta(UtilsStringFechas.obtenerFechaActual());  
			bo.insert(descuento);
			 
			modelMap.put("success", true);
			modelMap.put("message", "Registro agregado de forma correcta.");
		} catch (Exception dae) {
			modelMap.put("success", success);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
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
			@RequestParam(value = "iddescuento", required = false) String iddescuento,
			@RequestParam(value = "nombre", required = false) String nombre, 
			@RequestParam(value = "tipo", required = false) String tipo, 
			@RequestParam(value = "descripcion", required = false) String descripcion,
			@RequestParam(value = "porcentaje", required = false) String porcentaje,
			@RequestParam(value = "descuentofijo", required = false) String descuentofijo,
			@RequestParam(value = "fechaactivacion", required = false) String fechaactivacion,
			@RequestParam(value = "fechatermino", required = false) String fechatermino,
			@RequestParam(value = "nivel", required = false) String nivel,
			@RequestParam(value = "idagrupamiento", required = false) String idagrupamiento,
			
			HttpServletRequest request
	)	throws Exception {

		boolean success = false;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		DescuentoDTO descuento = new DescuentoDTO();
		String mensaje;
		try {
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			
			descuento.setIddescuento(iddescuento);
			descuento.setNombre(nombre);
			descuento.setTipo(tipo);
			descuento.setIdagrupamiento(idagrupamiento);
			descuento.setNivel(nivel);
			descuento.setDescripcion(descripcion);
			descuento.setPorcentaje(porcentaje); 
			descuento.setDescuentofijo(descuentofijo);
			descuento.setFechaactivacion(UtilsStringFechas.formatoStrFecha(request.getParameter("fechaactivacion"), "dd-MM-yyyy", "yyyy-MM-dd") );
			descuento.setFechatermino(UtilsStringFechas.formatoStrFecha(request.getParameter("fechatermino"), "dd-MM-yyyy", "yyyy-MM-dd")); 
			descuento.setFechaalta(UtilsStringFechas.obtenerFechaActual());  
			bo.update(descuento);
			 
			modelMap.put("success", true);
			modelMap.put("message", "Registro agregado de forma correcta.");
		} catch (Exception dae) {
			modelMap.put("success", success);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
			}
			modelMap.put("message", mensaje);
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
		List<DescuentoDTO> listaregistros = new ArrayList<DescuentoDTO>();
		String mensaje = "";
		DescuentoDTOJSON dtoJSON = new DescuentoDTOJSON();


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
		List<DescuentoDTO> listaregistros = new ArrayList<DescuentoDTO>();
		String mensaje = "";
		DescuentoDTOJSON dtoJSON = new DescuentoDTOJSON();


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
		List<DescuentoDTO> listaregistros = new ArrayList<DescuentoDTO>();
		String mensaje = "";
		DescuentoDTOJSON dtoJSON = new DescuentoDTOJSON();


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
	 * Desactiva registro
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
			@RequestParam(value = "ids", required = true) String ids,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		DescuentoDTO descuento= null;


		try {
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			
			if (ids!=null){
				String[] arr_idstarifas = ids.trim().split("\\|");
				for (String id : arr_idstarifas) {
					
					descuento = new DescuentoDTO();
					try{
						descuento.setIddescuento(id);
						descuento.setEstatus(0);
						bo.updateEstatus(descuento);
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
	 *Activa registro
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
			@RequestParam(value = "ids", required = true) String ids,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		DescuentoDTO descuento= null;

		try {
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			if (ids!=null){
				String[] arr_idstarifas = ids.trim().split("\\|");
				for (String id : arr_idstarifas) {
					
					descuento = new DescuentoDTO();
					try{
						descuento.setIddescuento(id);
						descuento.setEstatus(1);
						bo.updateEstatus(descuento);
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
