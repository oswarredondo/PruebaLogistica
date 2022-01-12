package com.administracion.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.administracion.utils.Log4jUtil;
import com.ws.replica.dao.SistemaDao;

public class ApplicationListener implements ServletContextListener{
	private boolean aplicacioninicializada = false;
	 ReplicaThread replicaThread = null;
	 ReplicaThread[] arr_replicaThread = new ReplicaThread[5];
	 Thread[] arr_thread = new Thread[5];
	 
	 ReplicaThread replicaThread1 = null;
	 ReplicaThread replicaThread2 = null;
	 ReplicaThread replicaThread3 = null;
	 ReplicaThread replicaThread4 = null;
	 
	 ThreadGroup pGroup = null;
	 
	 Thread thread = null;
	 Thread thread1 = null;
	 Thread thread2 = null;
	 Thread thread3 = null;
	 Thread thread4 = null;
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Iniciando aplicacion ws-interchangeClient ");
		System.out.println("Inicializandon  ws-interchangeClient->Log4J");
		
		SistemaDao daoSistema = new SistemaDao("ClienteReplicacion");
		String db_replicacion=null;
		 if(!aplicacioninicializada){
			   	String log4jLocation=daoSistema.getValorPropiedad("INFOINTERCHANGECTE",
						"path.log4j.ws.infointerchange.cte.file.config");
			   	
			 	db_replicacion=daoSistema.getValorPropiedad("INFOINTERCHANGECTE",
			 		"cte.db.servidor.replicacion");
			 	
				Long log4jDelta = null;
				try {  
				
					//log4jLocation = "/opt/log4j_file_config/ws-interchange.log4j.configure.xml";
					log4jDelta = new Long(5000);
					Log4jUtil.initLog4J("ws-infointerchange-cte", log4jLocation, log4jDelta);
				}
				catch (NumberFormatException e) {
					e.printStackTrace();
				}
				aplicacioninicializada = true;
		 }	
		 
		 //Inicializa el thead de replicacion
		 Log4jUtil.info("Inicia creacion de hilos de ws-infointerchange cte ...");
		 pGroup = new ThreadGroup("Contenedor de Threads");
		 if ((db_replicacion==null) || (db_replicacion.trim().length()<=0)){
			 Log4jUtil.info("No existe base de datos de replicacion configurada, asegurese "
			 		+ "de configurar el parametro path.log4j.ws.infointerchange.cte.db.replicacion y crear"
			 		+ " el datasource con el mismo nombre,"
			 		+ " ejemplo: path.log4j.ws.infointerchange.cte.db.replicacion=TRANSPORTE debera existir un DS"
			 		+ "jdbc/TRANSPORTE"); 
		 }else{
			 long milisecons = 5000;
			 for (int i=0;i<10;i++){
				 if (i!=0){
					 milisecons = milisecons + 5000;;
				 }else{
					 milisecons=0;
				 }
			 
				 replicaThread = new ReplicaThread("THREAD REPLICACION ", 0, db_replicacion,milisecons,"Proceso " + i);
				 thread = new Thread(pGroup, replicaThread);
				 thread.start();
			
				 
			 }
			 Log4jUtil.info("Creacion de hilos de ws-infointerchange cte terminada");
		 }
		
		
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
		try{
			 Log4jUtil.info("Deteniendo hilos de ws-infointerchange cte ...");
			 if (pGroup!=null){
				 pGroup.destroy();
			 }
			
			Log4jUtil.info("Deteniendo hilos de ws-infointerchange cte ...");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Log4jUtil.info("Deteniendo ws-infointerchange cte ...");

	}
}
