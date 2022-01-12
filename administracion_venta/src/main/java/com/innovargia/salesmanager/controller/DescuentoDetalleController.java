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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.DescuentoDTO;
import com.innovargia.salesmanager.ibo.IDescuentoBO;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * Administra consulta, altas, delete del detalle de un descuento
 * @author Adrián
 *
 */
@RequestMapping("/descuentodetalle")
@Controller
public class DescuentoDetalleController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(DescuentoDetalleController.class);


	@Autowired 
	IDescuentoBO bo;
	/**
	 * 
	 */
	public DescuentoDetalleController() {
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
	@RequestMapping("/getDatosDetalleTipo")
	public @ResponseBody
	Map<String, ? extends Object> getDatosDetalleTipo(HttpServletRequest request)throws Exception {
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
	
		BusquedaDTO busquedaDTO = new BusquedaDTO();
		List<DescuentoDTO>   lista = new ArrayList<DescuentoDTO>();
		String tipo = request.getParameter("tipo") ==null?"":request.getParameter("tipo");
		String iddescuento = request.getParameter("iddescuento") ==null?"":request.getParameter("iddescuento");
		try {
			if ((tipo.trim().length()>0) && (iddescuento.trim().length()>0) ){
				
				busquedaDTO.setTipo(tipo); 
				busquedaDTO.setIdentificador(iddescuento);
				lista = bo.getRegistrosDetalle(busquedaDTO);
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
	 * Obtiene los datos disponibles posibles a agregar a un descuento
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDatosDisponibles")
	public @ResponseBody
	Map<String, ? extends Object> getDatosDisponibles(HttpServletRequest request)throws Exception {
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
	
		BusquedaDTO busquedaDTO = new BusquedaDTO();
		List<DescuentoDTO>   lista = new ArrayList<DescuentoDTO>();
		String tipo = request.getParameter("tipo") ==null?"":request.getParameter("tipo");
		String iddescuento = request.getParameter("iddescuento") ==null?"":request.getParameter("iddescuento");
		try {
			if ((tipo.trim().length()>0) && (iddescuento.trim().length()>0) ){
				
				busquedaDTO.setTipo(tipo); 
				busquedaDTO.setIdentificador(iddescuento);
				lista = bo.getRegistrosDisponibles(busquedaDTO);
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
	
	
	

	@RequestMapping("/insert")
	public @ResponseBody
	Map<String, ? extends Object> insert(
			@RequestParam(value = "iddescuento", required = false) String iddescuento,
			@RequestParam(value = "identificador", required = false) String identificador, 
			@RequestParam(value = "tipo", required = false) String tipo, 
			HttpServletRequest request
	)	throws Exception {
		
		boolean success = false;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		DescuentoDTO descuento = new DescuentoDTO();
		String mensaje;
		try {
			descuento.setIddescuento(iddescuento);
			descuento.setTipo(tipo);
			switch (descuento.getTipo()) {
			case 1://Cliente
				descuento.setIdcliente(identificador);
				break;
			case 2://Tarifa
				descuento.setIdtarifa(identificador);
				break;			
			case 3://Zona
				descuento.setZona(identificador);
				break;	

			default:
				break;
			}
			
			bo.insertDetalle(descuento);
			
		
			 
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
	
	@RequestMapping("/delete")
	public @ResponseBody
	Map<String, ? extends Object> delete(
			@RequestParam(value = "iddescuento", required = false) String iddescuento,
			@RequestParam(value = "identificador", required = false) String identificador, 
			@RequestParam(value = "tipo", required = false) String tipo, 
			HttpServletRequest request
	)	throws Exception {
		
		boolean success = false;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		DescuentoDTO descuento = new DescuentoDTO();
		String mensaje;
		try {
			descuento.setIddescuento(iddescuento);
			descuento.setTipo(tipo);
			switch (descuento.getTipo()) {
			case 1://Cliente
				descuento.setIdcliente(identificador);
				break;
			case 2://Tarifa
				descuento.setIdtarifa(identificador);
				break;			
			case 3://Zona
				descuento.setZona(identificador);
				break;	

			default:
				break;
			}
			bo.deleteDetalle(descuento);
			
		
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

	
}
