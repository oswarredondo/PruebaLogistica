/*
 * Utils.java
 *
 * Created on 6 de mayo de 2004, 02:53 PM
 */

package com.innovargia.utils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;




/**
 *
 * @author  amorales
 */
public class Utils {
    
    public static final String ATRIBUTO_SESSION = "print_usuario";
    public static final String ATRIBUTO_SESSION_ADMIN = "print_usuario_modadmin";    
    public static final String LISTA_ENVIOS_SESSION = "listaEnvios";
    public static final String VALIDA_CP_SESSION = "validaCP";
    
    /** Identifidores para las distintas listas existentes */
    public static final int FORMATOS=0;
    public static final int TIPO_ENVIO=1;
    public static final int TIPO_SERVICIO=2;
    public static final int TIPO_ADICIONAL=3;
    public static final int TIPO_GARANTIA=4;
    public static final int TIPO_EMBAJALES=100;
    public static final boolean DEBUG = true;
    public static final String SEPARADOR_REGISTROS="~";
    public static final String SEPARADOR_CAMPOS="\\|";
    
    public static final String SISTEMA_SILOT="silot";
    public static final String SISTEMA_IETWEB="SKY4SOL";
    public static final String SISTEMA_MONDRIAN="MONDRIAN";
    public static final String MODULO_ALMACEN="ALMACEN";
    public static final String SISTEMA_SIEMBAL="siembal";
    
    public static final int A_DD_MM_AAAA = 1;
    public static final int A_MM_DD_AAAA = 2;
    public static final int  A_AA_MM_AAAAGUION = 3;
    
    
    public static HashMap map_IdSistemas = new HashMap();
    //LLena los datos de los sistemas
    static {
    	map_IdSistemas.put(SISTEMA_SILOT,SISTEMA_SILOT);
    	map_IdSistemas.put(SISTEMA_IETWEB,SISTEMA_IETWEB);
    	map_IdSistemas.put(SISTEMA_SIEMBAL,SISTEMA_SIEMBAL);
    }
    
    /**Obtiene el identificador del sistema, si este no se encientra registrado regresa null*/
    public static String getIdSistema(String id){
    	if (map_IdSistemas.containsKey(id)) return (String)map_IdSistemas.get(id);
    	
    	return null;
    }
    
    //public static final String FILE_PATH="/paquetes/Tomcat_Install/jakarta-tomcat-5.0.28/webapps/sgepweb/tmp/";//"/paquetes/importar/";
    
    /**
     * Devuelve el arreglo de cadenas indicando del tipo de separador
     * @param elementos cadena que contiene los elementos
     * @param separador caracter o cadena que se utiliza como separador
     * @return
     */
    public static String[] creaArreglo(String elementos,String separador){
        if (elementos!=null){
            return elementos.split(separador);
            
        }
        return null;
    }
    
    /**
     * Completa una cadena hasta un largo determinada agregando el caracter indicado al final o al inicio
     * @param original
     * @param completa
     * @param hasta
     * @param iniciofinal 1 = INICIO , 0=FINAL
     * @return
     */
    public static  String completa(String original, char caracter, int hasta, int iniciofinal){
    	//INICIO DEL LA CADERNA
    	if (iniciofinal==1){
    		while (original.trim().length() < hasta) {
        		original = caracter + original;
    		}
    	}
    	//FINAL DE LA CADENA
    	if (iniciofinal==0){
    		while (original.trim().length() < hasta) {
        		original = original + caracter  ;
    		}
    	}
    	return original;

    }
    /**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private  static void debug(String mensaje) {
		System.out.println("Utils->" +  mensaje);
	}// fin de debug

    
    
    /**
     * Regresa la fecha en formato DD/MM/AAAA o MM/DD/AAAA, dependiendo del formato
     * deseado, Si el selecciona DD/MM/AAAA  debe indincar la fecha en formato MM/DD/AAAA
     * si el usuario selecciona MM/DD/AAAA debe indicar la fecha en formato DD/MM/AAAA
     *
     * @param fechaOriginal fecha que se va a convertir
     * @param formato al que se desea convertir
     * @return cadena con el formato deseado, null en caso de error
     */
    public static String formateaFecha(String fechaOriginal,int convertirA) {
        
    	debug("Dando formato fecha->" +fechaOriginal + " convertir a "+  convertirA );
    	try{
        if (fechaOriginal==null){
            return null;
        }
        if (fechaOriginal.trim().length()<10){
            return null;
        }
        if (convertirA== A_DD_MM_AAAA){//la fecha esta en formato MM/DD/YYYY
            //formato de la fecha en
            return fechaOriginal.substring(0,2)+ '/' + fechaOriginal.substring(3,5) + '/' + fechaOriginal.substring(6);
        }else if (convertirA== A_AA_MM_AAAAGUION){//la fecha esta en formato MM/DD/YYYY
        	 return fechaOriginal.substring(6)+ " -" + fechaOriginal.substring(0,2)+ '-' + fechaOriginal.substring(3,5);
        }else{ //la fecha esta en formato DD/MM/YYYY
            return fechaOriginal.substring(3,5) + '/' + fechaOriginal.substring(0,2) + '/' + fechaOriginal.substring(6) ;
            
        }
    	}catch (Exception e) {
			// TODO: handle exception
    		debug("Excepcion al dar formato fecha ->" +e.getMessage());
		}
    	return null;
    }//fin de formateaFecha
    
    /**
     * Obtiene el valor de una variable de contexto definida donde java:comp/env
     * en caso de no encontrar el contexto devuelve NULL
     * @param jndi variable de contexto buscada
     * @return el valor encontrado o null en caso de no encontrarlo
     */
    public static String getJNDI(String jndi){
        String COMP_ENV = "java:comp/env";
        try {
            Context init = new InitialContext();
            Context ctx = (Context) init.lookup(COMP_ENV);
            return (String) ctx.lookup(jndi);
            
        } catch(Exception e) {
            //manda el error a la bitácora
            System.out.println("Error al obtener el URL del WebService:" + e.toString());
            return null;
        }
        
    }//Fin de getJNDI
    /* Vvariable en formato "dd/MM/yyyy*/        
    public static String FORMATO_DIA_MES_ANIO = "dd/MM/yyyy";
    /* Vvariable en formato "MM/dd/yyyy*/        
    public static String FORMATO_MES_DIA_ANIO = "MM/dd/yyyy";
    /* Variable en formato "yyyy/MM/dd*/        
    public static String FORMATO_ANIO_MES_DIA = "yyyy/MM/dd";
    /* Vvariable en formato "yyyy/MM/dd hh:mm*/    
    public static String FORMATO_ANIO_MES_DIA_HORA = "yyyy/MM/dd hh:mm";
    /* Vvariable en formato "MM/dd/yyyy hh:mm*/    
    public static String FORMATO_MES_DIA_ANIO_HORA = "MM/dd/yyyy hh:mm";
    /* Vvariable en formato "yyyy/MM/dd hh:mm*/
    public static String FORMATO_DIA_MES_ANIO_HORA = "yyyy/MM/dd hh:mm";
    /* Vvariable en formato "yyyy-MM-dd hh:mm:ss*/
    public static String FORMATO_DIA_MES_ANIO_HORA_MIN_SEG = "yyyy-MM-dd hh:mm:ss";
    /* Vvariable en formato "MM/dd/yyyy HH:mm:ss z*/
    public static String FORMATO_MES_DIA_ANIO_HORA_MM_SS_Z ="MM/dd/yyyy HH:mm:ss z";
    
    /**
     * Obtiene los datos de la fecha bajo el formato especificado, los
     * formatos que se encuentran por default son:<br>
     * FORMATO_DIA_MES_ANIO = "dd/MM/yyyy"<b>
     * FORMATO_MES_DIA_ANIO = "MM/dd/yyyy"<b>
     * FORMATO_ANIO_MES_DIA = "yyyy/MM/dd"<b>
     * FORMATO_ANIO_MES_DIA_HORA = "yyyy/MM/dd hh:mm"<b>
     * FORMATO_MES_DIA_ANIO_HORA = "MM/dd/yyyy hh:mm"<b>
     * FORMATO_DIA_MES_ANIO_HORA = "yyyy/MM/dd hh:mm"
     */
    public static String getFechaSistema(String formato_fecha){
        //Crea el identificador de la guia con
        //AAAAMMDDMMSSmmaaaa
        Calendar fecha = Calendar.getInstance();
        //Da formato a la fecha
        SimpleDateFormat formato = new SimpleDateFormat(formato_fecha);
        return formato.format(fecha.getTime());
    }
    
    /**
     * Da formato a una fecha en una cadena en formato AAAAMMDDhhmm y devuelve
     * un objeto de tipo java.sql.Timestamp conteniendo estos datos
     */
    public static String setFecha(String s){
        if ((s==null) || (s.trim().trim().length()<12))return "";
        
        return s.substring(0,4) + "/" + s.substring(4,6) + "/" +
        s.substring(6,8) + " " + s.substring(8,10) + ":" + s.substring(10,12) + ":00";
        
    }//fin de setFecha}
    
   
  
    
    /**Devuelve una cadena vacia en caso de que sea null*/
    public static String nullChange(String s){
    	if (s == null) return "";
    	
    	return s.trim();
    }
    
    public static boolean expiro(){
    	
    	int annio = Integer.parseInt(getFechaSistema("yyyy"));
    	int mes = Integer.parseInt(getFechaSistema("MM"));
    	//System.out.println("li a"+ annio+" m"+mes);
    	//Verifica si la fecha es mayor a la  indicada como limite
    	/*if ( (annio>=2013)  && (mes>=01 ) ){
    		System.out.println("fli a"+ getFechaSistema("yy")+" m"+mes); 
    		return true;
    	}*/
    	return false;
    }
    
       
}//fin de Utils