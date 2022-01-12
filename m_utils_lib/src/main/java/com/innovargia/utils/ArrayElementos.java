/**
 * 
 */
package com.innovargia.utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author aruaro
 * 
 */
public class ArrayElementos {

	public static float getFloat(String[] elem, int indice) {
		if (elem == null) {
			return 0;
		}

		try {
			return Float.parseFloat(elem[indice]);
		} catch (Exception e) {
			return 0;
		}

	}

	public static float getFloat(String cadema, String separador, int indice) {
		String[] elems = null;
		if ("|".equals(separador)){
			elems = cadema.split("\\|");
		}else{
			elems = cadema.split(separador);
		}
		return  getFloat(elems, indice);
		
	}
	
	public static String getString(String cadema, String separador, int indice) {
		String[] elems = null;
		if ("|".equals(separador)){
			elems = cadema.split("\\|");
		}else{
			elems = cadema.split(separador);
		}
		return  getString(elems, indice);
		
	}
	
	public static int getInt(String cadema, String separador, int indice) {
		String[] elems = null;
		if ("|".equals(separador)){
			elems = cadema.split("\\|");
		}else{
			elems = cadema.split(separador);
		}
		return  getInt(elems, indice);
		
	}
	
	
	public static String getString(String[] elem, int indice) {
		if (elem == null) {
			return "";
		}

		try {
			return elem[indice] + "";
		} catch (Exception e) {
			return "";
		}

	}

	public static int getInt(String[] elem, int indice) {
		if (elem == null) {
			return 0;
		}

		try {
			return Integer.parseInt(elem[indice]);
		} catch (Exception e) {
			return 0;
		}

	}
	
	/**
	 * Busca una cadena en otra cadena separada un caracter en especial
	 * @param cadena
	 * @param separador
	 * @param elem_buscado
	 * @return
	 */
	public static boolean existeElemento(String cadena, String separador, String elem_buscado) {
		
		try {
			String[] arr = cadena.split(separador);
			for (String elem : arr) {
				elem = elem==null?"":elem.trim();
				if (elem.equals(elem_buscado)){
					return true;
				}
			}
			
		} catch (Exception e) {
			
		}

		return false;
	}
	
	/***
	 * Da formato a una cadena envuelta entre comillas y separada por comas Si
	 * entra 123,123 devuelve '123','123' Si entra 123','123 devuelve
	 * '123','123' Si entra '123,123' devuelve '123','123' Si entra '123',123'
	 * devuelve '123','123'
	 * 
	 * @param value
	 * @return
	 */
	public static String formateaCadenaComillas(String value) {
		value = value.replace(',', ' ').trim().replace(' ', ',').trim();
		
		// Limpia la cadena para evitar incompletos
		value = value.replaceAll("','", ",");
		if (!value.contains("','")) {
			value = value.replaceAll("'", "");
			// Formate correctamente la separaci�n con comillas
			value = value.replace(",", "','");

		}
		if (!"'".equals(value.charAt(0) + "")) {
			value = "'" + value;
		}
		if (!"'".equals(value.charAt(value.length() - 1) + "")) {
			value = value + "'";
		}

		return value;

	}
	
	public static String[] formateaCadenaComillas(String cadena, String separador) {
		
		if ("|".equals(separador)){
			return cadena.split("\\|",-1);
		}else{
			return cadena.split(",",-1);
		}
	}

	public static String formateaArregloCadenaComillas(String[] mi_arr_) {
		String[] arr_ = eliminaDuplicados(mi_arr_);
		String guias = "";

		for (String guia : arr_) {
			guias = guias + guia + ",";
		}

		guias = guias.replace(',', ' ').trim().replace(' ', ',').trim();

		guias = formateaCadenaComillas(guias);

		return guias;
	}

	public static String[] eliminaDuplicados(String[] arr_) {
		HashMap<String, String> map = new HashMap<String, String>();
		ArrayList<String> arr_final = new ArrayList<String>();
		for (String string : arr_) {
			if (!map.containsKey(string)) {
				arr_final.add(string);
				map.put(string, string);
			}
		}

		String list2[] = new String[arr_final.size()];
		list2 = arr_final.toArray(list2);

		return list2;

	}
}
