/**
 * 
 */
package com.innovargia.administracion.controller;

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

import com.administracion.dto.AdicionalDTO;
import com.administracion.idao.IParamsSistemaDAO;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.json.CatalogoDTOJSON;
import com.innovargia.utils.sql.ExcepcionMessage;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.search.ibo.IBusquedaAdicionalBO;

/**
 * @author Adri�n
 *
 */
@RequestMapping("/catalogo/adicionales/")
@Controller
public class AdicionalesController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AdicionalesController.class);
	 
	@Autowired
	IBusquedaAdicionalBO idAdicionalBO;
	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;

	 
	/**
	 * 
	 */
	public AdicionalesController() {
		// TODO Auto-generated constructor stub
	}
	

	@RequestMapping(value="/getDatos", method = { RequestMethod.GET, RequestMethod.POST })
//			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> getDatos(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiquetaDTO,  
			HttpServletRequest request)throws Exception {
		boolean showAll = false;
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CatalogoDTO objeto = new CatalogoDTO();
		objeto.setEstatus(-1);
		List<AdicionalDTO> lista =null;
		try {
			
			String manejo_por_folios_o_convenios = iParamsSistemaDAO.getValorPropiedad(
					ConstantesGenerales.MANEJO_POR_FOLIOS_O_CONVENIOS,ConstantesGenerales.ID_SKY4SOL);
			if (!ConstantesGenerales.MANEJO_FOLIOS.equals( manejo_por_folios_o_convenios)){
				//Obtiene todos los adicionales
				lista = idAdicionalBO.getRegistrosSeleccionados(etiquetaDTO.getUuid(),etiquetaDTO.getIdregistrodatos());
			}else{
				//Obtiene solo los adicionales del convenio
				lista = idAdicionalBO.getRegistrosSeleccionados(etiquetaDTO.getUuid(),etiquetaDTO.getIdregistrodatos());
			}
			
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
	
	@RequestMapping(value="/getDatosPreFacturacion", method = { RequestMethod.GET, RequestMethod.POST })
	//	consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
		public @ResponseBody
		Map<String, ? extends Object> getDatosPreFacturacion(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiquetaDTO,  
			HttpServletRequest request)throws Exception {
		boolean showAll = false;
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CatalogoDTO objeto = new CatalogoDTO();
		objeto.setEstatus(-1);
		List<AdicionalDTO> lista =null;
		
		try {
			
			String iddocumento = String.valueOf(etiquetaDTO.getIddocumento());

		    lista = idAdicionalBO.getRegistrosSeleccionadosPorGuia(iddocumento);
			
			
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
	
	@RequestMapping(value="/getDatosDisponibles", method = { RequestMethod.GET, RequestMethod.POST })//,
//			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> getDatosDisponibles(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiquetaDTO,  
			HttpServletRequest request)throws Exception {
		boolean showAll = false;
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CatalogoDTO objeto = new CatalogoDTO();
		objeto.setEstatus(-1);
		List<AdicionalDTO> lista =null;
		try {
			
			String manejo_por_folios_o_convenios = iParamsSistemaDAO.getValorPropiedad(
					ConstantesGenerales.MANEJO_POR_FOLIOS_O_CONVENIOS,ConstantesGenerales.ID_SKY4SOL);
			if (!manejo_por_folios_o_convenios.equals(ConstantesGenerales.MANEJO_FOLIOS)){
				//Obtiene todos los adicionales
				lista = idAdicionalBO.getRegistrosDisponiblesConvenio(etiquetaDTO.getIdconvenio(),etiquetaDTO.getUuid(),etiquetaDTO.getIdregistrodatos());
			}else{
				//Obtiene solo los adicionales del convenio
				lista = idAdicionalBO.getRegistrosDisponiblesFolios(etiquetaDTO.getUuid(),etiquetaDTO.getIdregistrodatos());
			}
			
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
	
	
	@RequestMapping(value="/insert", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> insert(
			@RequestParam(value = "idregistros", required = true) String idregistros,
			@RequestParam(value = "uuid", required = true) String uuid,
			@RequestParam(value = "idregistrodatos", required = true) int idregistrodatos,
			
			HttpServletRequest request)	throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

   
		try {
			if (idregistros!=null){
				AdicionalDTO adicional =null;
				String[] arr_idregistros =idregistros.split(",");
				for (String idregistro : arr_idregistros) {
					adicional = idAdicionalBO.getRegistroIdAdicionalConvenio(Integer.parseInt(idregistro));
					adicional.setUuid(uuid);
					adicional.setIddregistrodatos(idregistrodatos);
					if (adicional!=null){
						idAdicionalBO.insert(adicional);
					}
				}
			}
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
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
	@RequestMapping(value="/update", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> getDatos(
			@ModelAttribute("adicional") AdicionalDTO adicionalDTO,  
			HttpServletRequest request)throws Exception {
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();


		try {
			idAdicionalBO.update(adicionalDTO);
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}

		}
		return modelMap;
	}
	
	@RequestMapping(value="/updatePorGuia", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> updatePorGuia(
			@ModelAttribute("adicional") AdicionalDTO adicionalDTO, 
			HttpServletRequest request)throws Exception {
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		try {
			
			idAdicionalBO.updatePorGuia(adicionalDTO);
			
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
			
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
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
	@RequestMapping(value="/delete", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody
	Map<String, ? extends Object> delete(
			@RequestParam(value = "idregistros", required = true) String idregistros,
			HttpServletRequest request)	throws Exception {


		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		try {
			if (idregistros!=null){
				AdicionalDTO adicional =null;
				String[] arr_idregistros =idregistros.split(",");
				for (String idregistro : arr_idregistros) {
					adicional = new AdicionalDTO();
					adicional.setIdregistro(idregistro);  
					idAdicionalBO.delete(adicional);
				}  
			}
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message",ExcepcionMessage.getMessageExcepcion(dae.getMessage()));

		}
		return modelMap;
	}
	
	/***
	 * INserta un registro o registros que vienen de un JSON
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/insertJson", method = { RequestMethod.GET, RequestMethod.POST },
			consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
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
				//bo.delete(listaregistros.get(i));
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
	
}
