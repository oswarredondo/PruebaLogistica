/*
 * $Id:  $
 * Nombre del Proyecto: IETWEB
 * Nombre del Programa: PropiedadesSistema.java
 * Responsable        : Adrian Morales
 * Descripcion        : Carga las propiedades del sistema
 **/
package com.innovargia.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PropiedadesSistema {
	/** Contexto para encontrar un recurso declarado */
	private static String COMP_ENV = "java:comp/env";
	private static final String NOMBRE_LOG_ENV = "jndi/ArchivoProperties";

	Properties prop = new Properties();

	public PropiedadesSistema() {
		super();
		cargaPropiedades(null);
		// TODO Auto-generated constructor stub
	}

	public PropiedadesSistema(String path) {
		super();
		cargaPropiedades(path);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Busca el recurso de datasource por medio del JNDI que debe estar
	 * declarado en Tomcar jdbc/Mensajeria
	 * 
	 * @throws Exception
	 *             en caso de no lograr establecer la conexion
	 */
	private String getPropertiesFile() throws Exception {

		// Obtiene el nombre del looger de la bitacora x jndi

			String path = null;
			try {
				Context init = new InitialContext();
				Context ctx = (Context) init.lookup(COMP_ENV);
				path = (String) ctx.lookup(NOMBRE_LOG_ENV);
			} catch (Exception e) {
				// manda el error a la bitácora

				return null;
			}
		return path;
	}// Fin de getPropertiesFile



	public void cargaPropiedades(String path_file) {

		InputStream is = null;

		// Obtiene los datos del
		try {
			if (path_file == null) {
				is = new FileInputStream(getPropertiesFile());

			}else{
				is = new FileInputStream(path_file);
			}
			prop.load(is);
			is.close();
		} catch (Exception e) {
			
		}
	}

	/**
	 * Obtiene los datos de la llave que se esta indicando
	 */
	public String getValueStr(String llave) {
		return prop.getProperty(llave);

	}

	/**
	 * Obtiene los datos de la llave que se esta indicando
	 */
	public int getValueInt(String llave) {
		return Integer.parseInt(prop.getProperty(llave));
	}

	/**
	 * Obtiene los datos de la llave que se esta indicando
	 */
	public boolean getValueBoolean(String llave) {
		return Boolean.valueOf(prop.getProperty(llave)).booleanValue();
	}

}// fin de PropiedadesSistema
