/**
 * 
 */
package com.administracion.utils;

import java.io.File;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class Log4jUtil {
	private static Logger logger = null;
	private static Logger loggerRI = null;
	
	private static final String DEFAULT_LOG4J_CONFIG_LOCATION = "/tmp/logs/log4j/";
	private static final Long DEFAULT_LOG4J_CONFIG_DELTA = new Long("10000");

	public static void initLog4J(String moduleName, String confLocation, Long delta) {
		if (logger == null) {
			initLog4j(confLocation, delta);
			logger = Logger.getLogger(moduleName);
			logger.info("Log4J para " + moduleName + " se inicializo correctamente");
		}
	}
	
	public static void debug(String msj) {
		logger.debug(msj);
	}
	
	public static void info(String msj) {
		logger.info(msj);
	}

	public static void warn(String msj) {
		logger.warn(msj);
	}

	public static void error(String msj) {
		logger.error(msj);
	}

	public static void fatal(String msj) {
		logger.fatal(msj);
	}

	public static void debug(String msj, Throwable th) {
		logger.debug(msj, th);
	}

	public static void info(String msj, Throwable th) {
		logger.info(msj, th);
	}

	public static void warn(String msj, Throwable th) {
		logger.warn(msj, th);
	}

	public static void error(String msj, Throwable th) {
		logger.error(msj, th);
	}

	public static void fatal(String msj, Throwable th) {
		logger.fatal(msj, th);
	}
	
	public static void error(String loggerName, String msj) {
	    Logger.getLogger(loggerName).error(msj);
	}

	private static void initLog4j(String confLocation, Long confDelta) {

		try {
			if (confLocation == null) {
				confLocation = DEFAULT_LOG4J_CONFIG_LOCATION;
			}
			if (confDelta == null) {
				confDelta = DEFAULT_LOG4J_CONFIG_DELTA;
			}

			File configFile = new File(confLocation);
			System.out.println("Cargando archivo de configuracion para ws-infointerchange-cte-Log4J:" + configFile.getAbsolutePath());
			String msg = "";
			if (configFile.exists() && configFile.isFile()) {
				msg = configFile.getAbsolutePath() + " as a configuration file an it is being verified every " + confDelta
						+ " ms";
				DOMConfigurator.configureAndWatch(configFile.getAbsolutePath(), confDelta.longValue());
			}
			else {
				System.out.println("Archivo de configuracion de Log4J no encontrado");
				msg = "Archivo de configuracion de Log4J no encontrado " + configFile.getAbsolutePath() ;
				BasicConfigurator.configure();
			}
			System.out.println(msg);
			System.out.println("Log4jConfigurator Listo.");
		}
		catch (Throwable e) {
			e.printStackTrace();
			throw new Error(
					"Exiten problemas al iniciar la aplicacion base, verifique su log y verifique que los datos de configuracion existan");
		}

	}
}

