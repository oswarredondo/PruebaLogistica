/**
 * 
 */
package com.innovargia.utils;

/**
 * @author aruaro
 * 
 */
public class GeneradorPassword {

	public static String NUMEROS = "0123456789";
	public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";
	public static String ESPECIALES = "Ò—?#&!$&";

	public static String getPinNumber() {
		return getPassword(NUMEROS, 4);
	}

	public static String getPassword() {
		return getPassword(8);
	}

	public static String getPassword(int length) {
		return getPassword(NUMEROS + MAYUSCULAS + MINUSCULAS+ESPECIALES, length);
	}
	public static String getLogin( String cadena) {
	    	cadena = ((cadena==null) || (cadena.trim().length()<=0))
	    		? MAYUSCULAS: cadena.trim();
	    	cadena = cadena.replaceAll(" ", "Z");
	    	cadena = cadena.replaceAll("1", "X");
		cadena = cadena.replaceAll("2", "Y");
		cadena = cadena.replaceAll("3", "W");
		cadena = cadena.replaceAll("4", "V");
		cadena = cadena.replaceAll("5", "U");
		cadena = cadena.replaceAll("6", "T");
		cadena = cadena.replaceAll("7", "S");
		cadena = cadena.replaceAll("8", "R");
		cadena = cadena.replaceAll("9", "O");
		cadena = cadena.replaceAll("0", "P");
	    	String login =  getPassword(cadena, 3) + getPassword(NUMEROS, 7);
		return login;
	}
	public static String getPassword(String key, int length) {
		String pswd = "";

		for (int i = 0; i < length; i++) {
			pswd+=(key.charAt((int)(Math.random() * key.length())));
		}

		return pswd;
	}
	
	
}
