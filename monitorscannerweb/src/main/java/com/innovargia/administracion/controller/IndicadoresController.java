package com.innovargia.administracion.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovargia.autodoc.dto.DesgloceCumplimientoDias;
import com.innovargia.autodoc.dto.DesgloceCumplimientoDiasTotal;
import com.innovargia.autodoc.dto.FiltrosReportesIndicadores;
import com.innovargia.autodoc.dto.MedicionCrossDock;
import com.innovargia.autodoc.dto.MedicionCumplimientoGarantias;
import com.innovargia.autodoc.dto.MedicionGarantiasPorCliente;
import com.innovargia.autodoc.dto.MedicionIntentosEntrega;
import com.innovargia.autodoc.dto.MedicionPendientesCO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IndicadoresBO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsRequest;

@RequestMapping("/indicadores/")
@Controller
public class IndicadoresController {
	
	@Autowired
	IndicadoresBO indicadoresBO;
	
	private static final Logger logger = LoggerFactory.getLogger(IndicadoresController.class);

	@RequestMapping("/getMedicionGarantiaPorCliente")
	public @ResponseBody
	Map<String, ? extends Object> getMedicionGarantiaPorCliente(
			@ModelAttribute("filtros") FiltrosReportesIndicadores filtros,  
			HttpServletRequest request)throws Exception {
		
		String mensaje=null;
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		
		List<MedicionGarantiasPorCliente> lista = null;

		try {
			
			lista =  indicadoresBO.getMedicionGarantiaXCliente(filtros);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
		
	}
	
	@RequestMapping("/getMedicionCumplimientoGarantias")
	public @ResponseBody
	Map<String, ? extends Object> getMedicionCumplimientoGarantias(
			@ModelAttribute("filtros") FiltrosReportesIndicadores filtros,  
			HttpServletRequest request)throws Exception {
		
		String mensaje=null;
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		
		List<MedicionCumplimientoGarantias> lista = null;

		try {
			
			lista =  indicadoresBO.getMedicionCumplimientoGarantias(filtros);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
		
	}
	
	@RequestMapping("/getMedicionCumplimientoGarantiasCO")
	public @ResponseBody
	Map<String, ? extends Object> getMedicionCumplimientoGarantiasCO(
			@ModelAttribute("filtros") FiltrosReportesIndicadores filtros,  
			HttpServletRequest request)throws Exception {
		
		String mensaje=null;
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		
		List<MedicionCumplimientoGarantias> lista = null;

		try {
			
			lista =  indicadoresBO.getMedicionCumplimientoGarantiasXCO(filtros);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
		
	}
	
	@RequestMapping("/getTiempoEntregaPorCO")
	public @ResponseBody
	Map<String, ? extends Object> getTiempoEntregaPorCO(
			@ModelAttribute("filtros") FiltrosReportesIndicadores filtros,  
			HttpServletRequest request)throws Exception {
		
		String mensaje=null;
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		
		List<MedicionGarantiasPorCliente> lista = null;

		try {
			
			lista =  indicadoresBO.getTiempoEntregaPorCO(filtros);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
		
	}
	
	@RequestMapping("/getMedicionCrossDock")
	public @ResponseBody
	Map<String, ? extends Object> getMedicionCrossDock(
			@ModelAttribute("filtros") FiltrosReportesIndicadores filtros,  
			HttpServletRequest request)throws Exception {
		
		String mensaje=null;
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		
		List<MedicionCrossDock> lista = null;

		try {

			lista =  indicadoresBO.getMedicionCrossDock(filtros);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
		
	}
	
	@RequestMapping("/getDemoraIngresoCOFinal")
	public @ResponseBody
	Map<String, ? extends Object> getDemoraIngresoCOFinal(
			@ModelAttribute("filtros") FiltrosReportesIndicadores filtros,  
			HttpServletRequest request)throws Exception {
		
		String mensaje=null;
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		
		List<MedicionCrossDock> lista = null;

		try {
			
			lista =  indicadoresBO.getDemoraIngresoCOFinal(filtros);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
		
	}
	
	@RequestMapping("/getDesgloceCumplimientoDias")
	public @ResponseBody
	Map<String, ? extends Object> getDesgloceCumplimientoDias(
			@ModelAttribute("filtros") FiltrosReportesIndicadores filtros,  
			HttpServletRequest request)throws Exception {
		
		String mensaje=null;
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		
		List<DesgloceCumplimientoDias> lista = null;

		try {
			
			lista =  indicadoresBO.getDesgloceCumplimientoDias(filtros);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
		
	}
	
	@RequestMapping("/getDesgloceCumplimientoDiasPorcentaje")
	public @ResponseBody
	Map<String, ? extends Object> getDesgloceCumplimientoDiasPorcentaje(
			@ModelAttribute("filtros") FiltrosReportesIndicadores filtros,  
			HttpServletRequest request)throws Exception {
		
		String mensaje=null;
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		
		List<DesgloceCumplimientoDias> lista = null;

		try {
			
			lista =  indicadoresBO.getDesgloceCumplimientoDiasPorcentaje(filtros);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
		
	}
	
	@RequestMapping("/getDesgloceCumplimientoDiasTotal")
	public @ResponseBody
	Map<String, ? extends Object> getDesgloceCumplimientoDiasTotal(
			@ModelAttribute("filtros") FiltrosReportesIndicadores filtros,  
			HttpServletRequest request)throws Exception {
		
		String mensaje=null;
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		
		List<DesgloceCumplimientoDiasTotal> lista = null;

		try {
			
			lista =  indicadoresBO.getDesgloceCumplimientoDiasTotal(filtros);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
		
	}
	
	@RequestMapping("/getDesgloceCumplimientoDiasTotalNum")
	public @ResponseBody
	Map<String, ? extends Object> getDesgloceCumplimientoDiasTotalNum(
			@ModelAttribute("filtros") FiltrosReportesIndicadores filtros,  
			HttpServletRequest request)throws Exception {
		
		String mensaje=null;
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		
		List<DesgloceCumplimientoDiasTotal> lista = null;

		try {
			
			lista =  indicadoresBO.getDesgloceCumplimientoDiasTotalNum(filtros);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
		
	}
	
	@RequestMapping("/getMedicionPendientesCO")
	public @ResponseBody
	Map<String, ? extends Object> getMedicionPendientesCO(
			@ModelAttribute("filtros") FiltrosReportesIndicadores filtros,  
			HttpServletRequest request)throws Exception {
		
		String mensaje=null;
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		
		List<MedicionPendientesCO> lista = null;

		try {
			
			lista =  indicadoresBO.getMedicionPendientesCO(filtros);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
		
	}
	
	@RequestMapping("/getMedicionIntentosEntrega")
	public @ResponseBody
	Map<String, ? extends Object> getMedicionIntentosEntrega(
			@ModelAttribute("filtros") FiltrosReportesIndicadores filtros,  
			HttpServletRequest request)throws Exception {
		
		String mensaje=null;
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		
		List<MedicionIntentosEntrega> lista = null;

		try {
			
			lista =  indicadoresBO.getMedicionIntentosEntrega(filtros);
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
		
	}
}
