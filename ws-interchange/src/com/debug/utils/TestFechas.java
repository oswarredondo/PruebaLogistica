/**
 * 
 */
package com.debug.utils;

import com.google.gson.Gson;

import mensajeria.forms.Seguimiento;
import mensajeria.forms.SeguimientoJSON;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class TestFechas {

	/**
	 * 
	 */
	public TestFechas() {
		// TODO Auto-generated constructor stub
	}
	
	final static String uri = "http://localhost:8089/autodocweb/rest/andrea/";

	static mensajeria.forms.Seguimiento  seguimiento = new Seguimiento();
	
	static String login = "AUT1234567";
	static String pass = "AUT1234567";
	public static void consultaEntrega() {
		
		SeguimientoJSON seguimientoJSON = new SeguimientoJSON();
		Gson gson = new Gson();
		seguimientoJSON.setSeguimiento(seguimiento);
		seguimientoJSON.setEntrega(null);
		String json = gson.toJson(seguimientoJSON);
		System.out.println("JSON¨:" +  json);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		consultaEntrega();
		/*System.out.println(Fechas.formateaFecha("20130314105609"));
		System.out.println(Fechas.formateaFecha("2013031410560988"));
		System.out.println(Fechas.formateaFecha("20130314105609100"));
		System.out.println(Fechas.formateaFecha("201303141056091"));
		System.out.println(Fechas.formateaFecha("201303141056091000"));
		
		System.out.println(FechasTimeStamp.convertFechaToTimeStamp( Fechas.formateaFecha("20130314105609")));
		System.out.println(FechasTimeStamp.convertFechaToTimeStamp( Fechas.formateaFecha("2013031410560988")));
		System.out.println(FechasTimeStamp.convertFechaToTimeStamp( Fechas.formateaFecha("20130314105609100")));
		System.out.println(FechasTimeStamp.convertFechaToTimeStamp( Fechas.formateaFecha("201303141056091")));
		System.out.println(FechasTimeStamp.convertFechaToTimeStamp( Fechas.formateaFecha("201303141056091000")));
		*/
	}

}
