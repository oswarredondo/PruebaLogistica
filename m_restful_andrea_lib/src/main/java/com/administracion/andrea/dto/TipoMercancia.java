package com.administracion.andrea.dto;

import java.util.HashMap;

public class TipoMercancia {

	private static HashMap<String, String> map_tipos = new HashMap<String, String>();

	static {
		map_tipos.put("SOBRE", "SOBRE");
		map_tipos.put("CAJA", "CAJA");
		map_tipos.put("PAQUETE", "PAQUETE");
		map_tipos.put("BOLSA", "BOLSA");
		map_tipos.put("PIEZA", "PIEZA");
		map_tipos.put("CUBETA", "CUBETA");
		map_tipos.put("BIDON", "BIDON");
		map_tipos.put("PORRON", "PORRON");
		map_tipos.put("GALON", "GALON");
		map_tipos.put("TAMBOR", "TAMBOR");
		map_tipos.put("TARIMA", "TARIMA");
		map_tipos.put("COSTAL", "COSTAL");
		map_tipos.put("CUÑETE", "CUÑETE");
		map_tipos.put("HUACAL", "HUACAL");
		map_tipos.put("TERMO", "TERMO");
		map_tipos.put("SACO", "SACO");
		map_tipos.put("ROLLOS", "ROLLOS");
		map_tipos.put("BULTO", "BULTO");
		map_tipos.put("SOBRE ANEXO", "SOBRE ANEXO");
		map_tipos.put("HIELERA", "HIELERA");
		map_tipos.put("VALIJA", "VALIJA");
	}
	
	/**
	 * Valida si existe el tipo de contenido
	 * @param tipo
	 * @return
	 */
	public static boolean isCorrect(String tipo){
		return map_tipos.containsKey(tipo);
	}
}
