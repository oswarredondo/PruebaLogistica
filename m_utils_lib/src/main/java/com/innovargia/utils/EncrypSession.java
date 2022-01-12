/**
 * Encriptar.java
 *
 * Utilidad para codificar y decodificar textos mediante una palabra clave
 *
 * @author jdelgado
 * @version 0.0.0.1 - 6 de Marzo 2007
 *
 * usa Java Simplified Encryption (http://www.jasypt.org/getting-started-easy.html)
 *
 */
package com.innovargia.utils;

import java.util.Calendar;



//import org.jasypt.util.text.TextEncryptor;

public class EncrypSession {
	String _decodifica ="-abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789_";
	String _codifica   ="-O1MqRUaFzV2wNsIxZT3ePdGc4LrHfvE5tAgYbC6yXhKnB7uÑjSm8iDk9Jol0pñQW_";


	public EncrypSession() {
	};
	

	
	/**
	 * Obtiene el caracter de que le correspon de de la cadena codificada
	 **/
	public char getCharCodificado(char caracter){
		//obtiene el indice del caracter en la cadena decodificada
		int indice = _decodifica.indexOf(caracter);
		//Devuelve la misma posición en la cadena codificada
		return  _codifica.charAt(indice);
	}
	
	/**
	 * Obtiene el caracter de que le correspon de de la cadena codificada
	 **/
	public char getCharDeCodificado(char caracter){
		//obtiene el indice del caracter en la cadena decodificada
		int indice = _codifica.indexOf(caracter);
		//Devuelve la misma posición en la cadena codificada
		return  _decodifica.charAt(indice);
	}
	
	/**
	 *  Invierte el orden de una cadena 
	 **/
	public String getInvertida(String cadena){
		String tmp_string ="";
		
		for (int i=cadena.length()-1;i>=0;i--){
			tmp_string = tmp_string.trim() +cadena.charAt(i);
		}
		return tmp_string;
	}

	/**
	 * Codifica un texto mediante una palabra clave, esta pertenece al numero de
	 * identificación creado para cada cliente cuando es dado de alta, y es
	 * irrepetible, si acaso cambio entonces los datos del usuario cambiaran lo
	 * que origina
	 * 
	 * @param claveunica
	 *            clave unica identificador
	 * @param cadena
	 *            palabra o mensaje a codificar
	 * @return el texto codificado o null
	 * @throws Exception
	 *             excepcion levantada en caso de error
	 */
	public String codifica(String claveunica, String cadena)
			throws Exception {
	
		String cadena_tmp=null;
		
		if(claveunica==null){
			return null;
		}
		
		if (cadena==null){
			return null;
		}
		try {
			
			//Suma las dos cadenas
			cadena_tmp=cadena;
			String tmp="";
			
			//Obtiene la cadena transpuesta con los caracteres codificados
			String caracter ="";
			int indice =0;
			for (int i=0;i<cadena_tmp.length();i++){
				//obtiene el caracter
				tmp = tmp.trim() + getCharCodificado(cadena_tmp.charAt(i));
			}
			
			cadena_tmp=getInvertida(tmp);
			
		} catch (Exception e) {
			throw e;
		}
		
		return cadena_tmp;
	}

	// —-
	/**
	 * Decodifica un texto mediante una palabra clave
	 * 
	 * @param mensaje
	 *            el texto a decodificar
	 * @param password
	 *            la palabra clave
	 * @return el texto decodificado
	 * @throws Exception
	 *             excepcion levantada en caso de error
	 */
	public String decodifica(String mensaje) {
		
		String cadena_tmp = getInvertida(mensaje);
		
		String tmp="";
		for (int i=0;i<cadena_tmp.length();i++){
			tmp = tmp.trim() + getCharDeCodificado(cadena_tmp.charAt(i));
		}
		
		return tmp;
	}

}