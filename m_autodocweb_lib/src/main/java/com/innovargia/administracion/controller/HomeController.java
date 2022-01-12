package com.innovargia.administracion.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/reiniciapassword")
	public String reiniciapassword(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Iniciando Menu", locale);
		return "reiniciapassword";
	}
	
	@RequestMapping(value = "/caducapassword")
	public String caducapassword(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Iniciando Menu", locale);
		return "caducapassword";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String errorPage() {
		return "error";
	}
	
	@RequestMapping(value = "/menuwin", method = RequestMethod.GET)
	public String loading() {
		return "menuwin";
	}
	
	@RequestMapping(value = "/mapsg", method = RequestMethod.GET)
	public String mapsg() {
		return "administracion_gmaps_coordenadas";
	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "login";
	}
	
	

	
}
