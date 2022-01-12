/**
 * 
 */
package com.administracion.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Adri�n
 *
 */
@RequestMapping("/gmapscontroller")
@Controller
public class GMapsController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(GMapsController.class);
	
	/** 
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/gmaps", method = { RequestMethod.GET, RequestMethod.POST })
	public String gmaps(Locale locale, Model model,HttpServletRequest request) {
		logger.info("Iniciando administracion_gmaps", locale);
		return "administracion_gmaps";
	}
	
	
	/*@RequestMapping(value = "/gmapscoordenadas",method = { RequestMethod.GET, RequestMethod.POST })
	public String gmapscoordenadas(Locale locale, Model model,HttpServletRequest request) {
		logger.info("Iniciando administracion_gmaps_coordenadas", locale);
		return "administracion_gmaps_coordenadas";
	}*/
	
	@RequestMapping(value = "/gmapscoordenadas", method = { RequestMethod.GET, RequestMethod.POST },
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String gmapscoordenadas() {
		logger.info("Iniciando administracion_gmaps_coordenadas");
		return "administracion_gmaps_coordenadas";
	}
	
}
