package com.innovargia.ws.tracking.rest.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class UtilsString {

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
		// Primero a comas paa evitar que se pongan incompletos
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
