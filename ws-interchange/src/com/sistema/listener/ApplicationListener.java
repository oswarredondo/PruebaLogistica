package com.sistema.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.administracion.utils.Log4jUtil;
import com.jdbc.interchange.SistemaDao;

public class ApplicationListener implements ServletContextListener{
	private boolean aplicacioninicializada = false;
	
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Iniciando aplicacion ws-infointerchange ");
		System.out.println("Inicializandon  ws-infointerchange->Log4J");
		
		SistemaDao daoSistema = new SistemaDao("TRANSPORTE");
		
		 if(!aplicacioninicializada){
			   	String log4jLocation=daoSistema.getValorPropiedad("INFOINTERCHANGE",
						"path.log4j.ws.infointerchange.file.config");
				Long log4jDelta = null;
				try {  
				
					//log4jLocation = "/opt/log4j_file_config/ws-interchange.log4j.configure.xml";
					log4jDelta = new Long(5000);
					Log4jUtil.initLog4J("ws-infointerchange", log4jLocation, log4jDelta);
				}
				catch (NumberFormatException e) {
					e.printStackTrace();
				}
				aplicacioninicializada = true;
		 }	
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
		try{
			Log4jUtil.info("Deteniendo ws-infointerchange ...");
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
