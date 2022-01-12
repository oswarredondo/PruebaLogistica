/**
 * 
 */
package com.innovargia.administracion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.dto.Folios;
import com.administracion.ibo.IFoliosBO;
import com.administracion.idao.IParamsSistemaDAO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.ConstantesAutoDoc;
import com.innovargia.utils.UtilsRequest;
import com.servicio.constantes.ConstantesGenerales;

/**
 * @author Adri�n
 * /foliosconvenios/carteraremdes/insertaRemitente
 */
@RequestMapping("/foliosconvenios/")
@Controller
public class FoliosConveniosController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(FoliosConveniosController.class);
	
	
	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;
	
	@Autowired
	IFoliosBO iFoliosBO;
	
	/**
	 * 
	 */
	public FoliosConveniosController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/getFoliosOConvenios", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody
	Map<String, ? extends Object> getFoliosOConvenios(
			@ModelAttribute("usuario") BusquedaDTO usuarioweb,  
			HttpServletRequest request)throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		List<Folios> lista =null; 
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		
			
//		String cporigen = request.getParameter("cporigen");
//			
//		String cpdestino = request.getParameter("cpdestino");
			
		String tipo_formulario = request.getParameter("tipo_formulario");
		
		try {
			
			if (usuario==null){
				throw new Exception( ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			
			if (usuario.getIdconvenio()<0){
        			    String manejo_por_folios_o_convenios = iParamsSistemaDAO.getValorPropiedad(
        					ConstantesGenerales.MANEJO_POR_FOLIOS_O_CONVENIOS,ConstantesGenerales.ID_SKY4SOL);
        			
        			if (manejo_por_folios_o_convenios==null){
        				throw new Exception("NO EXISTE PARAMETRO manejo_por_folios_o_convenios ");
        			}
        			
        			if (manejo_por_folios_o_convenios.equals(ConstantesGenerales.MANEJO_FOLIOS)){
        				lista = iFoliosBO.getFolios(usuario.getNumCliente(), usuario.entidad.getIdentidad(),
        						usuario.organizacion.getIdorganizacion(), usuario.getLogin());
        			}else{
        				lista = iFoliosBO.getConvenios(usuario.getNumCliente(), usuario.entidad.getIdentidad(),
        						usuario.organizacion.getIdorganizacion(), usuario.getLogin(),tipo_formulario);
        			}

			}else{
			    //Se realizo la llamada desde PDV
			    //Por lo que solo se buscan los convenios indicados
			    lista =  iFoliosBO.getConveniosAutoDocPDV(usuario);
			}
			
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
	
		}
		return modelMap;
		
	}

}
