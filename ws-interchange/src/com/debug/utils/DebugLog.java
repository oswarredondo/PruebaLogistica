/**
 * 
 */
package com.debug.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import com.administracion.utils.Log4jUtil;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class DebugLog { 

	  private static boolean debug = true; 
	  public static String PREFIJO_DELIVERY = "DE-";
	  public static String PREFIJO_DELIVERY_SEPARADOR = "-";
	    /** Creates a new instance of DebugLog */
	    private DebugLog() {
	    }
	    
	    public static void debug(String clase,String mensaje){
	    	
	    	//PropiedadesSistema syst_pro = new PropiedadesSistema();
	    	//Despliega el debug en caso de que asi se haya configurado el sistema
	       // if (syst_pro.getValueBoolean("debug")){
	            //Calcula la fecha en que se esta enviado el mensaje a pantalla
	            Calendar fecha = Calendar.getInstance();
	            //Da formato a la fecha
	            SimpleDateFormat formato = new SimpleDateFormat("d/MM/yy hh:mm ");
	            
	            String str_fecha = formato.format(fecha.getTime());
	            
	            Log4jUtil.debug(nombreClase(clase) + "->"+mensaje);
	      //  }
	        return;
	    }
	    
	    public static void debug(Class clase,String mensaje,HttpServletRequest req){
	    	
	    	// http://hostname.com:80/mywebapp/servlet/MyServlet/a/b;c=123?d=789
	    	String scheme = req.getScheme();             // http
	        String serverName = req.getServerName();     // hostname.com
	        int serverPort = req.getServerPort();        // 80
	        String contextPath = req.getContextPath();   // /mywebapp
	        String servletPath = req.getServletPath();   // /servlet/MyServlet
	        String pathInfo = req.getPathInfo();         // /a/b;c=123
	        String queryString = req.getQueryString();          // d=789
	    
	        // Reconstruct original requesting URL
	        String url = scheme+"://"+serverName+":"+serverPort+contextPath+servletPath;
	        if (pathInfo != null) {
	            url += pathInfo;
	        }
	        if (queryString != null) {
	            url += "?"+queryString;
	        }

	        if (debug){
	            //Calcula la fecha en que se esta enviado el mensaje a pantalla
	            Calendar fecha = Calendar.getInstance();
	            //Da formato a la fecha
	            SimpleDateFormat formato = new SimpleDateFormat("d/MM/yy hh:mm ");
	            
	            String str_fecha = formato.format(fecha.getTime());
	            
	            Log4jUtil.debug(str_fecha + " " + url + 
	            		":"+ nombreClase(clase.getName()) + "->"+mensaje);
	        }
	        return;
	    }
	    
	     public static void debug(Class clase,String mensaje){
	        if (debug){
	          //debug(clase.getName(),mensaje);
	        	debug(clase.getPackage() +"." + clase.getName(),mensaje);
	        }
	        return;
	    }
	     
	     /**
	      * Regresa el nombre de la clase
	      */
	     private static String nombreClase(String nombre){
	         
	         if (nombre==null){return "";}
	         
	         
	         String[] cadena  = nombre.split("\\.");
	         
	         if (cadena.length>0){
	             return cadena[cadena.length-1];
	         }
	         
	         return nombre;
	         
	     }
}
