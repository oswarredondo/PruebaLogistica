/**
 * 
 */
package com.innovargia.utils.sql;

/**
 * @author aruaro
 *
 */
public class ExcepcionMessage {

	public static String getMessageExcepcion(String msg){
		if (msg==null) return "";
		
		if (msg.contains("duplicate key") ||  msg.contains("llave duplicada") || msg.contains("Registro Duplicado")){
			return "Llave duplicada viola restricción de unicidad";
		}
		return msg;
	}

}
