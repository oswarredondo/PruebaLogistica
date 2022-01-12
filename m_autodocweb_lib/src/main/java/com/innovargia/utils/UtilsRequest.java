package com.innovargia.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilsRequest {

	private static final Logger logger = LoggerFactory
			.getLogger(UtilsRequest.class);
	
	public static void displayParametros(HttpServletRequest request) {

		Enumeration enumera = request.getParameterNames();

		while (enumera.hasMoreElements()) {
			String attribute = (String) enumera.nextElement();
			logger.info("" + attribute + "=" + request.getParameter(attribute));
		}

	}
	
	
	
	
}
