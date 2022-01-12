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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.DireccionDTO;
import com.innovargia.salesmanager.dtos.PlazaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.ConstantesAutoDoc;
import com.innovargia.utils.UtilsRequest;
import com.servicio.search.ibo.IBusquedaCPBO;
import com.servicio.search.ibo.IBusquedaPlazaBO;

/**
 * @author Adri�n
 *
 */
@RequestMapping("/catalogo/pais")
@Controller
public class CatalogoPaisController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CatalogoPaisController.class);
	
	@Autowired
	IBusquedaPlazaBO bo;
	@Autowired
	IBusquedaCPBO iBusquedaCPBO;
	
	/**
	 * 
	 */
	public CatalogoPaisController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/getPaises", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getFrecuenciasEntrega(HttpServletRequest request)throws Exception {
	
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<PlazaDTO> lista =null;
		
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		
		try {
			
			
			lista  = bo.getRegistrosPais();

			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
		}
		return modelMap;
		
	}
	
	/**
	 * Obtiene los datos que se buscan de codigos postales
	 * 
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getDatosCodigoPostal", 
			method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getDatosCodigoPostal(HttpServletRequest request)throws Exception {
		
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		String tipo_str = request.getParameter("tipobusqueda");
		String patron_busqueda = request.getParameter("patron");
		BusquedaDTO busquedaDTO = new BusquedaDTO();
		List<DireccionDTO>   lista = new ArrayList<DireccionDTO>(); 
		

		try {
			if ((tipo_str!=null) && (tipo_str.length()>0)){
				busquedaDTO.setTipo_str(tipo_str);
				busquedaDTO.setPatron_busqueda(patron_busqueda);
					lista = iBusquedaCPBO.getDatosDireccionCP(busquedaDTO);
			}
			
			
			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
		} catch (Exception dae) {
		
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}
	
}
