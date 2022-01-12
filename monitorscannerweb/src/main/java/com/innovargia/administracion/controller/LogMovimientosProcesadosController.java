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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.idao.IParamsSistemaDAO;
import com.innovargia.autodoc.dto.PorcentajesChart;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.LogMovimientoProcesadoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.ILogMovimientosProcesadosBO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsCalculoPesos;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.UtilsStrings;

/**
 * @author Adri�n
 * /logproceso/getViajes
 */
@RequestMapping("/logproceso/")
@Controller
public class LogMovimientosProcesadosController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(LogMovimientosProcesadosController.class);
	
	@Autowired
	ILogMovimientosProcesadosBO iLogMovimientosProcesadosBO;
	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;
	
	/**
	 * 
	 */
	public LogMovimientosProcesadosController() {
		// TODO Auto-generated constructor stub
	}
	

	@RequestMapping("/getContadores")
	public @ResponseBody
	Map<String, ? extends Object> getContadores(
			HttpServletRequest request)throws Exception {
	  
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		
		try {
			int counter_entradas=0;
			int counter_salidas=0;
			int counter_confirmaciones=0;
			int counter_movlocal=0;
			int counter_varios=0;
			UtilsRequest.displayParametros(request);
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			
			 List<LogMovimientoProcesadoDTO> contadores = 
				 iLogMovimientosProcesadosBO.getTotalesPlazaRegistro(usuario!=null?usuario.getPlaza():null);
			 
			 for (LogMovimientoProcesadoDTO logMovimientoProcesadoDTO : contadores) {
			    if (logMovimientoProcesadoDTO!=null){
				if ( ("01".equals(logMovimientoProcesadoDTO.getTipomovimiento()))  ||  
				     ("1".equals(logMovimientoProcesadoDTO.getTipomovimiento()))
					){
				    counter_entradas = counter_entradas + logMovimientoProcesadoDTO.getCantidad();
				}else if (("02".equals(logMovimientoProcesadoDTO.getTipomovimiento()))
					|| ("2".equals(logMovimientoProcesadoDTO.getTipomovimiento()))
					){
				    counter_salidas = counter_salidas + logMovimientoProcesadoDTO.getCantidad();
				}else if (("03".equals(logMovimientoProcesadoDTO.getTipomovimiento())) 
					|| ("3".equals(logMovimientoProcesadoDTO.getTipomovimiento()))
					){
				    counter_movlocal = counter_movlocal + logMovimientoProcesadoDTO.getCantidad();
				}else if (("05".equals(logMovimientoProcesadoDTO.getTipomovimiento())) 
					|| ("5".equals(logMovimientoProcesadoDTO.getTipomovimiento()))
					) {
				    counter_confirmaciones = counter_confirmaciones + logMovimientoProcesadoDTO.getCantidad();
				
                		    
                		}else{
                		    counter_varios = counter_varios + logMovimientoProcesadoDTO.getCantidad(); 
                		}
			    }
			}
			
		
			modelMap.put("counter_entradas", counter_entradas);
			modelMap.put("counter_salidas", counter_salidas);
			modelMap.put("counter_confirmaciones", counter_confirmaciones);
			modelMap.put("counter_movlocal", counter_movlocal);
			modelMap.put("counter_varios", counter_varios);
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

			
		} catch (Exception dae) {
		    modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	@RequestMapping("/getContadoresPorcentajes")
	public @ResponseBody
	Map<String, ? extends Object> getContadoresPorcentajes(
			HttpServletRequest request)throws Exception {
	  
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		
		try {

			//UtilsRequest.displayParametros(request);
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			
			 List<LogMovimientoProcesadoDTO> contadores = new ArrayList<LogMovimientoProcesadoDTO>();
				 //iLogMovimientosProcesadosBO.getTotalesPlazaRegistro(usuario!=null?usuario.getPlaza():null);
			
			
			 int tipoconsulta = 
					request.getParameter("tipoconsulta")!=null  &&
					!request.getParameter("tipoconsulta").isEmpty() ?
						Integer.parseInt(request.getParameter("tipoconsulta")):0;  
				  
					if (tipoconsulta==1){
					    //Registros Procesados
					    contadores = iLogMovimientosProcesadosBO.getTotalPorTipoRegistro(null);
					}else if (tipoconsulta==2){
					    //Tipos Errores
					    contadores = iLogMovimientosProcesadosBO.getTotalesTipoErroreProcesados(null);
					}else if (tipoconsulta==3){
					    //Plazas que envian
					    contadores = iLogMovimientosProcesadosBO.getTotalesPorPlaza(null);
					}else if (tipoconsulta==4){
					    
					}else{
					    
					}
					    
				
			int total= 0;
			 for (LogMovimientoProcesadoDTO logMovimientoProcesadoDTO : contadores) {
			    if (logMovimientoProcesadoDTO!=null){
				 total += logMovimientoProcesadoDTO.getCantidad();
			    }
			}
			 
			//Obtiene los porcentales
			List<PorcentajesChart> porcentales = new ArrayList<PorcentajesChart>();
				
			 for (LogMovimientoProcesadoDTO logMovimientoProcesadoDTO : contadores) {
				    if (logMovimientoProcesadoDTO!=null){
					PorcentajesChart obj = new PorcentajesChart();
					obj.setRegistro(logMovimientoProcesadoDTO.getTipomovimiento());
					obj.setCantidad(logMovimientoProcesadoDTO.getCantidad());
					obj.setData1(logMovimientoProcesadoDTO.getCantidad());
					obj.setPorcentaje(UtilsCalculoPesos.porcentaje(total, obj.getCantidad())); 
					porcentales.add(obj);
				    }
			 }
			
			modelMap.put("proxiArray", porcentales);
			modelMap.put("totalCount", porcentales.size());
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

			
		} catch (Exception dae) {
		    modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	@RequestMapping("/getContadoresTotalesConcepto")
	public @ResponseBody
	Map<String, ? extends Object> getContadoresTotalesConcepto(
			HttpServletRequest request)throws Exception {
	  
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		
		try {

			//UtilsRequest.displayParametros(request);
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			int tipoconsulta = 
				request.getParameter("tipoconsulta")!=null  &&
				!request.getParameter("tipoconsulta").isEmpty() ?
					Integer.parseInt(request.getParameter("tipoconsulta")):
					    0;
			List<LogMovimientoProcesadoDTO> contadores =new ArrayList<LogMovimientoProcesadoDTO>();
					 
			if (tipoconsulta==1){
			    //Registros Procesados
			    contadores = iLogMovimientosProcesadosBO.getTotalPorTipoRegistro(null);
			}else if (tipoconsulta==2){
			    //Tipos Errores
			    contadores = iLogMovimientosProcesadosBO.getTotalesTipoErroreProcesados(null);
			}else if (tipoconsulta==3){
			    //Plazas que envian
			    contadores = iLogMovimientosProcesadosBO.getTotalesPorPlaza(null);
			}else if (tipoconsulta==4){
			    
			}else{
			    
			}

			int total= 0;
			 for (LogMovimientoProcesadoDTO logMovimientoProcesadoDTO : contadores) {
			    if (logMovimientoProcesadoDTO!=null){
				 total += logMovimientoProcesadoDTO.getCantidad();
			    }
			}
			 
			//Obtiene los porcentales
			List<PorcentajesChart> porcentales = new ArrayList<PorcentajesChart>();
				
			 for (LogMovimientoProcesadoDTO logMovimientoProcesadoDTO : contadores) {
				    if (logMovimientoProcesadoDTO!=null){
					PorcentajesChart obj = new PorcentajesChart();
					obj.setRegistro(logMovimientoProcesadoDTO.getTipomovimiento());
					obj.setData1(logMovimientoProcesadoDTO.getCantidad());
					
					porcentales.add(obj);
				    }
			 }
			
			modelMap.put("proxiArray", porcentales);
			modelMap.put("totalCount", porcentales.size());
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

			
		} catch (Exception dae) {
		    modelMap.put("message", dae.getMessage());

		}
		return modelMap;
		
	}
	
	@RequestMapping("/getRegistrosProcesados")
	public @ResponseBody
	Map<String, ? extends Object> getRegistrosProcesados(
			HttpServletRequest request)throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		
		try {

			//UtilsRequest.displayParametros(request);
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			LogMovimientoProcesadoDTO obj = new LogMovimientoProcesadoDTO();
			
			obj.setSoloregistrosconerror(Boolean.parseBoolean(request.getParameter("soloregistrosconerror")));

			List<LogMovimientoProcesadoDTO> contadores = iLogMovimientosProcesadosBO.getRegistros(obj);
			
			modelMap.put("proxiArray", contadores);
			modelMap.put("totalCount", contadores.size());
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

			
		} catch (Exception dae) {
		    modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}
	
	
	@RequestMapping("/getViajes")
	public @ResponseBody
	Map<String, ? extends Object> getViajes(
			HttpServletRequest request)throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UtilsRequest.displayParametros(request);
		
		try {

			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			
		    	String tipotranslado = "A";//request.getParameter("tipotranslado");
		    	String plaza = request.getParameter("plaza");
		    	plaza =   UtilsStrings.formateaCadenaComillas(plaza);
		    	
		    	String tiporegistro = request.getParameter("tiporegistro");
		    	//if (tipotranslado==null){
		    	//    tipotranslado="F"; //Default Foraneo
		    	//}
		    	//Solo cuando es ambas se setea a null
		    	if ("A".equals(tipotranslado)){
		    	    tipotranslado=null;
		    	}
		    	List<LogMovimientoProcesadoDTO> 
		    		contadores = iLogMovimientosProcesadosBO.getViajesEntradas(tipotranslado,
		    			plaza,tiporegistro);

			
			modelMap.put("proxiArray", contadores);
			modelMap.put("totalCount", contadores.size());
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

			
		} catch (Exception dae) {
		    modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}
	
	@RequestMapping("/getPlazas")
	public @ResponseBody
	Map<String, ? extends Object> getPlazas(
			HttpServletRequest request)throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UtilsRequest.displayParametros(request);
		
		try {

			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			
		    	String tipotranslado = "A";//request.getParameter("tipotranslado");
		    	String tiporegistro = request.getParameter("tiporegistro");
		    	//if (tipotranslado==null){
		    	//    tipotranslado="F"; //Default Foraneo
		    	//}
		    	//Solo cuando es ambas se setea a null
		    	if ("A".equals(tipotranslado)){
		    	    tipotranslado=null;
		    	}
		    	List<LogMovimientoProcesadoDTO> 
		    		contadores = iLogMovimientosProcesadosBO.getPlazas(tipotranslado,
		    			null,tiporegistro);

			modelMap.put("proxiArray", contadores);
			modelMap.put("totalCount", contadores.size());
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

			
		} catch (Exception dae) {
		    modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}
	@RequestMapping("/getViajeCorridas")
	public @ResponseBody
	Map<String, ? extends Object> getViajeCorridas(
			HttpServletRequest request)throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UtilsRequest.displayParametros(request);
		
		try {
   
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			
		    	String viaje_corrida = request.getParameter("viaje");
		    
		    	List<LogMovimientoProcesadoDTO> 
		    		contadores = iLogMovimientosProcesadosBO.getViajesEntradas(viaje_corrida,
		    			"VC","VC");

			
			modelMap.put("proxiArray", contadores);
			modelMap.put("totalCount", contadores.size());
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

			
		} catch (Exception dae) {
		    modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}
	
	@RequestMapping("/getTramosViajes")
		public @ResponseBody
		Map<String, ? extends Object> getTramosViajes(
				HttpServletRequest request)throws Exception {

			HashMap<String, Object> modelMap = new HashMap<String, Object>();

			
			try {

				UtilsRequest.displayParametros(request);
				String tipotranslado = "A";//request.getParameter("tipotranslado");
				String viaje = request.getParameter("viaje");
				String plaza = request.getParameter("plaza");
			    	plaza =   UtilsStrings.formateaCadenaComillas(plaza);
				String tiporegistro = request.getParameter("tiporegistro");
				
				//if (tipotranslado==null){
				//    tipotranslado="F"; //Default Foraneo
				//}
				//Solo cuando es ambas se setea a null
			    	if ("A".equals(tipotranslado)){
			    	    tipotranslado=null;
			    	}
			    	
				UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
				List<LogMovimientoProcesadoDTO> contadores = 
					iLogMovimientosProcesadosBO.getTotalesViajeRutaEntradas(viaje,
						tipotranslado,plaza,tiporegistro);
				
				modelMap.put("proxiArray", contadores);
				modelMap.put("totalCount", contadores.size());
				modelMap.put("success", true);
				modelMap.put("message", "Correcto");

				
			} catch (Exception dae) {
			    modelMap.put("message", dae.getMessage());

			}
			return modelMap;
		}
	
	@RequestMapping("/getGuiasTramosViajes")
	public @ResponseBody
	Map<String, ? extends Object> getGuiasTramosViajes(
			HttpServletRequest request)throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		
		try {

			UtilsRequest.displayParametros(request);
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			String tipotranslado = "A";//request.getParameter("tipotranslado");
			String viaje = request.getParameter("viaje");
			String tramo = request.getParameter("tramo");
			String plaza = request.getParameter("plaza");
			String madre = request.getParameter("madre");
			plaza =   UtilsStrings.formateaCadenaComillas(plaza);
			
			String tiporegistro = request.getParameter("tiporegistro");
			String verSoloLasNoManifiestadas_str = request.getParameter("verSoloLasNoManifiestadas");
			
			String manifiesto = request.getParameter("manifiesto");
			
			boolean consultaGuiasManifiesto =Boolean.parseBoolean(
				request.getParameter("consultaGuiasManifiesto")==null?"false":request.getParameter("consultaGuiasManifiesto"));
			
				
			boolean verSoloLasNoManifiestadas=
				verSoloLasNoManifiestadas_str==null?false:Boolean.parseBoolean(verSoloLasNoManifiestadas_str);
			
			List<LogHistoriaDTO> contadores = new ArrayList<LogHistoriaDTO>();
			if ("A".equals(tipotranslado)){
		    	    tipotranslado=null;
		    	}
			if (consultaGuiasManifiesto){
			    if  ("FX".equals(tiporegistro)){
				contadores =
					iLogMovimientosProcesadosBO.getGuiasPosiblesManifiestoFXC(manifiesto);
			    }else{
				contadores =
					iLogMovimientosProcesadosBO.getGuiasManifiesto(manifiesto);
			    }
			    
			}else{
			    contadores = iLogMovimientosProcesadosBO.getGuiasViajeRutaEntradas(viaje, tramo, 
					tipotranslado, verSoloLasNoManifiestadas,plaza,tiporegistro);
			   
			}
			
			
			modelMap.put("proxiArray", contadores);
			modelMap.put("totalCount", contadores.size());
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

			
		} catch (Exception dae) {
		    modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}
	
	
	
	
}
