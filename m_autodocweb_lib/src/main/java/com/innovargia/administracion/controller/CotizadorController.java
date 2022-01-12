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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.dto.CotizacionTarifa;
import com.administracion.ibo.ICotizadorBO;
import com.administracion.idao.IParamsSistemaDAO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.servicio.constantes.ConstantesGenerales;

/**
 * @author Adri�n
 * 
 */
@RequestMapping("/cotizador/")
@Controller
public class CotizadorController {

    private static final Logger logger = LoggerFactory
	    .getLogger(CotizadorController.class);

    @Autowired
    ICotizadorBO iCotizadorBO;
    @Autowired
    IParamsSistemaDAO iParamsSistemaDAO;

    /**
	 * 
	 */
    public CotizadorController() {
	// TODO Auto-generated constructor stub
    }

    @RequestMapping(value ="/calculaprecios", method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody
    Map<String, ? extends Object> calculaprecios(
	    @ModelAttribute("cotiza") CotizacionTarifa cotiza,
	    HttpServletRequest request) throws Exception {

	String mensaje = null;
	HashMap<String, Object> modelMap = new HashMap<String, Object>();
	CatalogoDTO objeto = new CatalogoDTO();
	objeto.setEstatus(-1);
	List<CotizacionTarifa> lista = null;
	try {
	    if ((cotiza.getCporigen() == null)
		    || (cotiza.getCpdestino() == null)) {
		lista = new ArrayList<CotizacionTarifa>();
	    } else {
		String manejo_por_folios_o_convenios = iParamsSistemaDAO
			.getValorPropiedad(
				ConstantesGenerales.MANEJO_POR_FOLIOS_O_CONVENIOS,
				ConstantesGenerales.ID_SKY4SOL);

		if (!ConstantesGenerales.MANEJO_FOLIOS
			.equals(manejo_por_folios_o_convenios)) {
		    // Obtiene todos los adicionales
		    lista = iCotizadorBO.getCotizacionesTarifa(cotiza);
		} else {
		    // Obtiene solo los adicionales del convenio
		    lista = iCotizadorBO.getCotizacionesTarifa(cotiza);
		}
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
