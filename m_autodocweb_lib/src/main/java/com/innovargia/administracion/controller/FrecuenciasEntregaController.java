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

import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.documentos.dtos.GuiaMadre;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.ConstantesAutoDoc;
import com.innovargia.utils.UtilsRequest;
import com.servicio.search.ibo.IBusquedaFrecuenciasBO;

/**
 * @author Adri�n
 *frecuenciasentrega/getFrecuenciasEntregaCP
 */
@RequestMapping("/catalogo/frecuenciasentrega")
@Controller
public class FrecuenciasEntregaController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(FrecuenciasEntregaController.class);
	
	@Autowired
	IBusquedaFrecuenciasBO bo;
	
	/**
	 * 
	 */
	public FrecuenciasEntregaController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/getFrecuenciasEntregaCP", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getFrecuenciasEntrega(HttpServletRequest request)throws Exception {
	
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CatalogoDTO objeto = new CatalogoDTO();
		objeto.setEstatus(-1);
		
//		GuiaMadre guiaMadre = new GuiaMadre();
		
		List<Frecuencias> lista =null;
//		List<GuiaMadre> lista =null;
//		lista = new ArrayList<>();
		
		
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		
		try {
			
/**
* @author Oswaldo
 *Pruebas decoigo para Guia Madre
*/
			
//			String gm = request.getParameter("guiaMadre");
//			String ids = request.getParameter("idServicio");
//			String np = request.getParameter("numpiezas");
//			String ref = request.getParameter("referencia");
//			String emp = request.getParameter("tipoEmpaque");
//			String peso = request.getParameter("pesoFisico");
//			
//			System.out.println("guia: " + gm.length() );
////			System.out.println("guia: " + gm + " Servico: " + ids + " NumPaquetes: " + np + " Referencia: " + ref + " EMPAQUETADO: "  + emp + " Peso: " + peso );
//			
//			if (gm.length() != 0){
//				
//				System.out.println("guia: " + gm + " Servico: " + ids + " NumPaquetes: " + np + " Referencia: " + ref + " EMPAQUETADO: "  + emp + " Peso: " + peso );
//
//				
//				guiaMadre.setGuiaMadre(gm);
//				guiaMadre.setidservicio(ids);
//				guiaMadre.setNumpiezas(np);
//				guiaMadre.setReferencia(ref);
//				guiaMadre.settipoempaque(emp);
//				guiaMadre.setpesofisico(peso);
//				
//				lista.add(guiaMadre);
//				
//			}
			
			String tipobusqueda = request.getParameter("tipobusqueda")==null?"":
				request.getParameter("tipobusqueda").trim().toLowerCase();
			String cpdestino = request.getParameter("cpdestino");
			String cporigen = request.getParameter("cporigen");
			String idgarantia = request.getParameter("idgarantia");
			
			if ("1".equals(tipobusqueda)){
				lista  = bo.getFrecuenciasCP(cpdestino, idgarantia ,usuario) ;
			}else if ("2".equals(tipobusqueda)){
				lista  = bo.getFrecuenciasCP(cpdestino, idgarantia, usuario);
			}

			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
			if (lista!=null){
				modelMap.put("totalCount", lista.size());
				modelMap.put("proxiArray", lista);
				
			}
			
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
		}
		return modelMap;
		
	}
	
	
	
}
