/**
 * 
 */
package com.administracion.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Adrián
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
	@RequestMapping(value = "/gmaps")
	public String gmaps(Locale locale, Model model,HttpServletRequest request) {
		logger.info("Iniciando administracion_gmaps", locale);
		return "administracion_gmaps";
	}
	
	
	@RequestMapping(value = "/gmapscoordenadas")
	public String gmapscoordenadas(Locale locale, Model model,HttpServletRequest request) {
		logger.info("Iniciando administracion_gmaps_coordenadas", locale);
		return "administracion_gmaps_coordenadas";
	}
}
