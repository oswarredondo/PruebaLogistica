/**
 * 
 */
package com.administracion.recolecciones.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.dto.DiasSemanaMes;
import com.administracion.dto.SolicitudRecoleccion;
import com.innovargia.recolecciones.ibo.ISolicitudRecoleccionBO;
import com.innovargia.recolecciones.mappers.Estatus;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adri�n
 *
 */
@RequestMapping("/diassolicitud")
@Controller
public class DiasMesSemanaRecoleccionController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(DiasMesSemanaRecoleccionController.class);
	
	@Autowired
	ISolicitudRecoleccionBO iSolicitudRecoleccionBO;
	
	/**
	 * 
	 */
	public DiasMesSemanaRecoleccionController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/getDatosProgramacion")
	public @ResponseBody
	Map<String, ? extends Object> getDatosProgramacion(
		@ModelAttribute("solicitud") SolicitudRecoleccion solicitud, 
		@ModelAttribute("tiporecol") int tiporecol,  
			HttpServletRequest request)throws Exception {
		
		if (tiporecol==1){
		    return getDatosDiasSemana(solicitud,request);
		}else if (tiporecol==2){
		    return getDatosDiasMes(solicitud,request);
		}
		return null;
		
	}
	
	@RequestMapping("/getDatosDiasSemana")
	public @ResponseBody
	Map<String, ? extends Object> getDatosDiasSemana(
		@ModelAttribute("solicitud") SolicitudRecoleccion solicitud,  
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<DiasSemanaMes> lista =null;
		try {
		    solicitud.setIdtiporecol(  Estatus.RECOL_PROGRAMADA_X_DIA_MSEMANA );
		    lista = iSolicitudRecoleccionBO.getProgramacion(solicitud);

			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			logger.info("Error en el metodo de getDatosDiasSemana:" +  dae.getMessage());
		    modelMap.put("success", false);
			modelMap.put("message", "Error en el metodo de getDatosDiasSemana");

		}
		return modelMap;
	}
	
	@RequestMapping("/getDatosDiasMes")
	public @ResponseBody
	Map<String, ? extends Object> getDatosDiasMes(
		@ModelAttribute("solicitud") SolicitudRecoleccion solicitud,  
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<DiasSemanaMes> lista =null;
		try {
		    solicitud.setIdtiporecol(  Estatus.RECOL_PROGRAMADA_X_DIA_MES );
		    lista = iSolicitudRecoleccionBO.getProgramacion(solicitud);

			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			logger.info("Error en el metodo de getDatosDiasMes:" +  dae.getMessage());
		    modelMap.put("success", false);
		    modelMap.put("message","Error en el metodo de getDatosDiasMes");

		}
		return modelMap;
		
	}
	
	
	@RequestMapping("/insertDiaMes")
	public @ResponseBody
	Map<String, ? extends Object> insertDiaMes(
			@ModelAttribute("diasSemanaMes") DiasSemanaMes diasSemanaMes,  
			HttpServletRequest request)	throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

   
		try {
		    	iSolicitudRecoleccionBO.insertDiasMesSolicitudRecoleccion(diasSemanaMes);
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			logger.info("Error en el metodo de insertDiaMes:" +  dae.getMessage());
			
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}
			modelMap.put("message", "Error en el metodo de insertDiaMes");
		}
		return modelMap;
	}
	
	@RequestMapping("/insertDiaSemana")
	public @ResponseBody
	Map<String, ? extends Object> insertDiaSemana(
			@ModelAttribute("diasSemanaMes") DiasSemanaMes diasSemanaMes,  
			HttpServletRequest request)	throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

   
		try {
		    	iSolicitudRecoleccionBO.insertDiasSemanaSolicitudRecoleccion(diasSemanaMes);
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			logger.info("Error en el metodo de insertDiaSemana:" +  dae.getMessage());
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}
			modelMap.put("message", "Error en el metodo de insertDiaSemana");
		}
		return modelMap;
	}
	
	@RequestMapping("/updateDiaMes")
	public @ResponseBody
	Map<String, ? extends Object> updateDiaMes(
			@ModelAttribute("diasSemanaMes") DiasSemanaMes diasSemanaMes,  
			HttpServletRequest request)	throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

   
		try {
		    	iSolicitudRecoleccionBO.updateDiasMesSolicitudRecoleccion(diasSemanaMes);
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			logger.info("Error en el metodo de diasSemanaMes:" +  dae.getMessage());
			modelMap.put("message", "Error en el metodo de diasSemanaMes");
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}
			
		}
		return modelMap;
	}
	
	@RequestMapping("/updateDiaSemana")
	public @ResponseBody
	Map<String, ? extends Object> updateDiaSemana(
			@ModelAttribute("diasSemanaMes") DiasSemanaMes diasSemanaMes,  
			HttpServletRequest request)	throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

   
		try {
		    	iSolicitudRecoleccionBO.updateDiasSemanaSolicitudRecoleccion(diasSemanaMes);
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			logger.info("Error en el metodo de updateDiaSemana:" +  dae.getMessage());
			modelMap.put("message", "Error en el metodo de updateDiaSemana");
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}

		}
		return modelMap;
	}

	@RequestMapping("/deleteDiaMes")
	public @ResponseBody
	Map<String, ? extends Object> deleteDiaMes(
			@ModelAttribute("diasSemanaMes") DiasSemanaMes diasSemanaMes,  
			HttpServletRequest request)	throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

   
		try {

		    UtilsRequest.displayParametros(request);
		    String[] ids = diasSemanaMes.getIdsolicitud().split(",");
		      int idregistro=-1;
		      for (String identificador : ids) {
			  try{
			      idregistro = Integer.parseInt(identificador);
			      diasSemanaMes.setIdregistro(idregistro);
				iSolicitudRecoleccionBO.deleteDiasMesSolicitudRecoleccion(diasSemanaMes);
			  }catch(Exception e){
			      logger.debug("No se pudo convertir el identificador a integer:" + identificador);
			  }
			  
			  
		      }
		      
		    
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			logger.info("Error en el metodo de deleteDiaMes:" +  dae.getMessage());
			modelMap.put("message", "Error en el metodo de deleteDiaMes");
			
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}

		}
		return modelMap;
	}
	
	@RequestMapping("/deleteDiaSemana")
	public @ResponseBody
	Map<String, ? extends Object> deleteDiaSemana(
			@ModelAttribute("diasSemanaMes") DiasSemanaMes diasSemanaMes,  
			HttpServletRequest request)	throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

   
		try {
		    UtilsRequest.displayParametros(request);
		      String[] ids = diasSemanaMes.getIdsolicitud().split(",");
		      int idregistro=-1;
		      for (String identificador : ids) {
			  try{
			      idregistro = Integer.parseInt(identificador);
			      diasSemanaMes.setIdregistro(idregistro);
			      iSolicitudRecoleccionBO.deleteDiasSemanaSolicitudRecoleccion(diasSemanaMes);
			  }catch(Exception e){
			      logger.debug("No se pudo convertir el identificador a integer:" + identificador);
			  }
			  
			  
		      }
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			logger.info("Error en el metodo de deleteDiaSemana:" +  dae.getMessage());
			modelMap.put("message", "Error en el metodo de deleteDiaSemana");
			
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}

		}
		return modelMap;
	}
	

	@RequestMapping("/borrarProgramacion")
	public @ResponseBody
	Map<String, ? extends Object> borrarProgramacion(
		@ModelAttribute("solicitud") DiasSemanaMes diasSemanaMes, 
		@ModelAttribute("tiporecol") int tiporecol,  
			HttpServletRequest request)throws Exception {
		
		if (tiporecol==1){
		    return deleteDiaSemana(diasSemanaMes, request);
		}else if (tiporecol==2){
		    return deleteDiaMes(diasSemanaMes, request);
		}
		return null;
		
	}
	
	
}
