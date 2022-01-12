/**
 * 
 */
package com.innovargia.administracion.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.dto.Factura;
import com.administracion.idao.IParamsSistemaDAO;
import com.innovargia.administracion.dto.MaterialEspecialFactura;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IFacturaResumenBO;
import com.innovargia.salesmanager.ibo.IMaterialEspcialFacturaBO;
import com.innovargia.utils.MimeTypes;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ExcepcionMessage;
import com.servicio.constantes.ConstantesAdminSale;

/**
 * @author adrian
 * /factura/materialespecial/delete
 */
@RequestMapping("/factura/materialespecial")
@Controller
public class MaterialEspecialFacturaController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(MaterialEspecialFacturaController.class);
	
	@Autowired
	IMaterialEspcialFacturaBO iMaterialEspcialFacturaBO;
	/**
	 * 
	 */
	public MaterialEspecialFacturaController() {
		// TODO Auto-generated constructor stub
	}
	

	@RequestMapping(value="/getAdicionalesNoIncluidos", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> getAdicionalesNoIncluidos(
			@ModelAttribute("material") MaterialEspecialFactura material,  
			HttpServletRequest request)throws Exception {
	
	
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			

			 List<MaterialEspecialFactura> lista = iMaterialEspcialFacturaBO.getRegistrosNoIncluidos(material);
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			logger.debug("Error:" + dae.getMessage());  
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}

	@RequestMapping(value="/getDatos", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> getDatos(
			@ModelAttribute("material") MaterialEspecialFactura material,  
			HttpServletRequest request)throws Exception {
	
	
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		try {
			

			 List<MaterialEspecialFactura> lista = iMaterialEspcialFacturaBO.getRegistros(material);
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			logger.debug("Error:" + dae.getMessage());  
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	@RequestMapping(value="/insert", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> insert(
			@ModelAttribute("material") MaterialEspecialFactura material,  
			HttpServletRequest request)throws Exception {
	
		
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
			    throw new Exception( ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			if (material.getIdmaterial()==null || material.getIdmaterial().isEmpty()){
				 throw new Exception("Adicional Especial seleccionado invalido.");
			}
			if (material.getCantidad()<=0){
				 throw new Exception("Cantidad invalida.");
			}
			
			if (material.getPrecio()<=0){
				 throw new Exception("Precio invalida.");
			}
			iMaterialEspcialFacturaBO.insert(material);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		
			
		} catch (Exception dae) {
			logger.debug("Error:" + dae.getMessage());  
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	@RequestMapping(value="/update", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> update(
			@ModelAttribute("material") MaterialEspecialFactura material,  
			HttpServletRequest request)throws Exception {
	
		
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
			    throw new Exception( ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			iMaterialEspcialFacturaBO.update(material);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		
			
		} catch (Exception dae) {
			logger.debug("Error:" + dae.getMessage());  
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	@RequestMapping(value="/delete", method = { RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> delete(
			@ModelAttribute("material") MaterialEspecialFactura material,  
			HttpServletRequest request)throws Exception {
	
		
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
			    throw new Exception( ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			iMaterialEspcialFacturaBO.delete(material);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		
			
		} catch (Exception dae) {
			logger.debug("Error:" + dae.getMessage());  
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	@RequestMapping(value="/deleteAll" , method = { RequestMethod.GET, RequestMethod.POST} )
	public @ResponseBody
	Map<String, ? extends Object> deleteAll(
			@ModelAttribute("material") MaterialEspecialFactura material,  
			HttpServletRequest request)throws Exception {
	
		
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			
			if (usuario==null){
			    throw new Exception( ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			iMaterialEspcialFacturaBO.deleteAll(material);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		
			
		} catch (Exception dae) {
			logger.debug("Error:" + dae.getMessage());  
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	
	
}
