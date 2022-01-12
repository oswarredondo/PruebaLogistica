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

import com.administracion.dto.Folios;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.IAdicionalesBO;
import com.innovargia.salesmanager.ibo.IAdminFoliosBO;
import com.innovargia.salesmanager.json.CatalogoDTOJSON;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adri�n
 * /catalogo/folios/getDatos
 */
@RequestMapping("/catalogo/folios")
@Controller
public class AdminFoliosController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AdminFoliosController.class);
	
	@Autowired
	IAdminFoliosBO bo;
	
	/**
	 * 
	 */
	public AdminFoliosController() {
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
			@RequestParam(value = "numcliente", required = true) String numcliente,
			@RequestParam(value = "identidad", required = true) int identidad,
			@RequestParam(value = "idorganizacion", required = true) int idorganizacion,
			HttpServletRequest request)throws Exception {
		
		UtilsRequest.displayParametros(request);  
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
			List<Folios> lista =null;
		try {
			Folios folios =  new Folios();
			folios.entidad.setIdentidad(identidad);
			folios.organizacion.setIdorganizacion(idorganizacion);
			folios.setNumCliente(numcliente);
			
			lista  = bo.getRegistros(folios);  
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	
	@RequestMapping("/insert")
	public @ResponseBody  
	Map<String, ? extends Object> insert(
			@RequestParam(value = "identidad", required = true) int identidad,
			@RequestParam(value = "idorganizacion", required = true) int idorganizacion,
			@ModelAttribute("folios") Folios folios,  
			HttpServletRequest request)	throws Exception {

	
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UtilsRequest.displayParametros(request);  
		try {
			folios.entidad.setIdentidad(identidad);
			folios.organizacion.setIdorganizacion(idorganizacion);
			bo.insert(folios);
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message",ExcepcionMessage.getMessageExcepcion(dae.getMessage()));
			 

		}
		return modelMap;
	}
	
	@RequestMapping("/increment")
	public @ResponseBody
	Map<String, ? extends Object> increment(
			@ModelAttribute("folios") Folios folios, 
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		UtilsRequest.displayParametros(request);  
		try {
			bo.increment(folios);
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", ExcepcionMessage.getMessageExcepcion(dae.getMessage()));
		
		}
		return modelMap;
	}

	@RequestMapping("/delete")
	public @ResponseBody
	Map<String, ? extends Object> delete(
			@ModelAttribute("folios") Folios folios, 
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UtilsRequest.displayParametros(request);  

		try {
			bo.delete(folios);
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;
	}
	

	
	
}
