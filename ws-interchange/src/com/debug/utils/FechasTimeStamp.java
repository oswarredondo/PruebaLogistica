/*
 * $Id:  $
 * Nombre del Proyecto: Facturación - Web
 * Nombre del Programa: Fechas.java
 * Responsable        : Adrian Morales
 * Descripcion        : funcions de fechas
 **/
package com.debug.utils;


import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Funciones utilitarias de fechas ajusta y crea TimeStamps
 * 
 * @author Tecnologia Virtual
 */
public class FechasTimeStamp extends Fechas {

	public static final int FORMATO_FECHA_MM_DD_AAAA = 1;
	public static final int FORMATO_FECHA_DD_MM_AAAA = 2;
	public static final int FORMATO_FECHA_AAAA_MM_DD = 3;
	public static final int FORMATO_FECHA_AAAA_MM_DD_HH_MM_SS= 4;
	public static final int FORMATO_FECHA_DD_MM_AAAA_HH_MM_SS = 5;
	

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private static void debug(String mensaje) {
		System.out.println("FechasTimeStamp:" + mensaje);
	}// fin de debug

	/**
	 * Obtiene el TimeStamp de la fecha actual en formato TimeStamp
	 */
	public static java.sql.Timestamp setTimestampNow() {

		Calendar cal = Calendar.getInstance();
		return new Timestamp(cal.getTime().getTime());

	}// Obtiene
	

	/**
	 * Da formato a la fecha y la envuelve en un objeto de tipo TimeStamp
	 * @param fecha
	 * @return java.sql.Timestamp  o null en caso de no poder convertirse
	 */
	public static java.sql.Timestamp convertFechaToTimeStamp(String fecha){
		if (fecha==null) return null;
		String[] fecha_array =fecha.trim().split(" "); 
		
		int anio = Integer.parseInt(fecha.substring(0, 4));
		int mes = Integer.parseInt(fecha.substring(5, 7));
		int dia = Integer.parseInt(fecha.substring(8, 10));
		
		String[] hora_min=fecha_array[1].split(":");
		 
		int hora = Integer.parseInt( hora_min[0]);
		int minutos = Integer.parseInt(hora_min[1]);
		int segundos = 0;
		int miliseg = 0;
		//Checa si la hora tiene segundos
		if (hora_min.length>2){
			//Checa si la hora tiene milisegundos
			String[] seg_mili_seg = hora_min[2].split("\\.");
			if (seg_mili_seg.length>1){
				//Tiene segundos y milisegundos
				segundos= Integer.parseInt(seg_mili_seg[0]);
				miliseg= Integer.parseInt(seg_mili_seg[1]);
			}else{
				
				//Solo tiene segundos
				segundos= Integer.parseInt(hora_min[2].replace('.', ' ').trim());
				//segundos= Integer.parseInt(hora_min[2]);
			}
			
			
		}
		
		return setTimestamp(anio, mes, dia, hora, minutos,segundos,miliseg);
		
		
		 
	}
	
	

	/**
	 * Da formato a un tipo de dato TimeStamp dado datos e tipos de fechas Lis
	 * tipos de fechas aceptados son: FORMATO_FECHA_MM_DD_AAAA,
	 * FORMATO_FECHA_DD_MM_AAAA,FORMATO_FECHA_AAAA_MM_DD.<br>
	 * y un formato de Hora indicado como HH:MM.
	 * 
	 * Los formatos de las fechas deben estar serapados por <b>/</b> o <b>-</b> 
	 * 
	 * @param fecha
	 *            la fecha a convertir
	 * @param hora
	 *            hora y minutos
	 * @param formato
	 *            tipo de formato en el que viene la fecha.
	 */
	public static java.sql.Timestamp convertFechaToTimeStamp(String fecha,
			String hora_minutos, int formato ) {
		
		if (fecha==null) return null;

		int dia = 0;
		int mes = 0;
		int anio = 0;
		int hora = 0;
		int minutos = 0;
		int segundos = 0;
		
		int indice_anio=0 ;
		int indice_mes=0 ;
		int indice_dia=0 ;
		
		String separador = "-";
		//Detecta el sepadador de la fehca puede ser / o -
		if (fecha.indexOf('/')!=-1){
			separador = "/";
		}else if (fecha.indexOf('-')!=-1){
			separador = "-";
		}else{
			//No tiene formato de fecha valido
			debug("No existe formato de fecha valido");
			return null;
		}

		//PArte la hora en Fecha y Hora , si no existe la hora solo crea un elemento en el arreglo
		String[] datos_fecha = fecha.split(" "); 
		String[] partes_fecha =  datos_fecha[0].split(separador);
		String[] partes_hora = null;

		//Si se indica una hora la toma por default
		if (hora_minutos!=null){
			//Obtiene los datos de horas y minutos
			 partes_hora = hora_minutos.split(":");
			if (partes_hora.length<1){
				hora = 0;
				minutos = 0;
			}else{
				
				hora = Integer.parseInt(partes_hora[0]);
				minutos = Integer.parseInt(partes_hora[1]);
				if (partes_hora.length<2){
					segundos =Integer.parseInt(partes_hora[2]);
				}
			}
		}

		try {
			switch (formato) {
			case FORMATO_FECHA_MM_DD_AAAA:
				indice_anio=2 ;
				indice_mes=0 ;
				indice_dia=1; 
				break;
			case FORMATO_FECHA_DD_MM_AAAA:
			case FORMATO_FECHA_DD_MM_AAAA_HH_MM_SS:
				indice_anio=2 ;
				indice_mes=1 ;
				indice_dia=0; 
				break;
			case FORMATO_FECHA_AAAA_MM_DD:
			case FORMATO_FECHA_AAAA_MM_DD_HH_MM_SS:
				indice_anio=0 ;
				indice_mes=1 ;
				indice_dia=2; 
				
				break;
			}
		} catch (Exception e) {
			debug("FechasTimeStamp->Error al convertir la fecha->"
					+ e.getMessage());
		}
		
		if ((formato==FORMATO_FECHA_AAAA_MM_DD_HH_MM_SS ) || (formato==FORMATO_FECHA_DD_MM_AAAA_HH_MM_SS)){
			//Obtiene los datos de la hora
			if (datos_fecha.length>1){
				partes_hora = datos_fecha[1].split(":");
				
				if (partes_hora.length<1){
					hora = 0;
					minutos = 0;
				}else{
					hora = Integer.parseInt(partes_hora[0]);
					minutos = Integer.parseInt(partes_hora[1]);
					if (partes_hora.length>2){
						segundos =Integer.parseInt(partes_hora[2]);
					}
				}
			}
		}
		dia = Integer.parseInt(partes_fecha[indice_dia]);
		mes = Integer.parseInt(partes_fecha[indice_mes]);
		anio = Integer.parseInt(partes_fecha[indice_anio]);
		return setTimestamp(anio, mes, dia, hora, minutos,segundos,0);
	}// Fin de convertFechaToTimeStamp

	
	/**
	 * Ajusta los datos de un time stamp con fecha y hora, si no se indica la
	 * hora se ajusta hora=00 minutos=00
	 * 
	 * La fecha tiene que venir en el formato mm/dd/aaaa y la hora en HH:MM
	 */
	public static java.sql.Timestamp setTimestamp(int anio, int mes, int dia,
			int hora, int minutos, int segundos,int miliseg) {

		// Ajusta la fecha a la manejada por default
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, anio);
		cal.set(Calendar.MONTH, mes - 1);
		cal.set(Calendar.DATE, dia);
		cal.set(Calendar.HOUR_OF_DAY,hora);
		//cal.set(Calendar.HOUR, hora);
		cal.set(Calendar.MINUTE, minutos);
		cal.set(Calendar.SECOND, segundos);
		cal.set(Calendar.MILLISECOND, miliseg); // or other value

		return new Timestamp(cal.getTime().getTime());

	}// fin setTimestamp

	/**
	 * Ajusta los datos de un time stamp con fecha y hora, si no se indica la
	 * hora se ajusta hora=00 minutos=00
	 * 
	 * La fecha tiene que venir en el formato mm/dd/aaaa y la hora en HH:MM
	 */
	public static java.sql.Timestamp setTimestamp(String fecha,
			String hora_minutos) {

		// Ajusta la fecha a la manejada por default
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(fecha.substring(6)));
		cal.set(Calendar.MONTH, Integer.parseInt(fecha.substring(3, 5)) - 1);
		cal.set(Calendar.DATE, Integer.parseInt(fecha.substring(0, 2)));
		
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hora_minutos.substring(0, 2)));
		
		//cal.set(Calendar.HOUR, Integer.parseInt(hora_minutos.substring(0, 2)));
		cal.set(Calendar.MINUTE, Integer.parseInt(hora_minutos.substring(
						3, 2)));
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0); // or other value

		return new Timestamp(cal.getTime().getTime());

	}// fin setTimestamp
	
	/**
	 * Ajusta la fecha a un time estan de acuerdo a los formatos indicados 
	 * en los registos de intercamvbio YYYYMMddhhmm
	 */
	public static java.sql.Timestamp setTimestamp(String fechaRI, int sumadias) {

		// Ajusta la fecha a la manejada por default
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(fechaRI.substring(0,4)));
		cal.set(Calendar.MONTH, Integer.parseInt(fechaRI.substring(4, 6)) - 1);
	
		cal.set(Calendar.DATE, Integer.parseInt(fechaRI.substring(6, 8)) - sumadias);
		//cal.set(Calendar.HOUR, Integer.parseInt(fechaRI.substring(8, 10)));
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(fechaRI.substring(8, 10)));
		cal.set(Calendar.MINUTE, Integer.parseInt(fechaRI.substring(10)));
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0); // or other value
		
		
		return new Timestamp(cal.getTime().getTime());

	}// fin setTimestamp

	/**
	 * Realiza la conversion de una fecha tipo TimeStamp a un formato dado
	 * Ejemplos:<br>
     *<br>
     *  Date and Time Pattern Result<br>
     * "yyyy.MM.dd G 'at' HH:mm:ss z"  2001.07.04 AD at 12:08:56 PDT<br>
     * "EEE, MMM d, ''yy"  Wed, Jul 4, '01<br>
     * "h:mm a"  12:08 PM<br>
     * "hh 'o''clock' a, zzzz"  12 o'clock PM, Pacific Daylight Time<br>
     * "K:mm a, z"  0:08 PM, PDT<br>
     * "yyyyy.MMMMM.dd GGG hh:mm aaa"  02001.July.04 AD 12:08 PM<br>
     * "EEE, d MMM yyyy HH:mm:ss Z"  Wed, 4 Jul 2001 12:08:56 -0700<br>
     * "yyMMddHHmmssZ"  010704120856-0700<br>
     * "yyyyMMddhhmm" 200312180425<br>
     *
     * @param fecha de la cual se desea el formateo
     * @return una cadena con la fecha formateada
     * @see SimpleDateFormat
     */
	public static String formatoTimeStamp(java.sql.Timestamp timestamp,
			String elFormato) {

		if ((timestamp == null) || (elFormato == null)) {
			return null;
		}
		java.util.Date fecha = new Date(timestamp.getTime());

		return formatoFecha(fecha, elFormato);

	}// fin de formatoFecha

	/**
	 * Da formato a la hora, indicando segundos en cero si es null
	 * regresa NULL si no regresa un objeto tipo java.sql.Time
	 * @param s_time
	 * @return
	 */
	public static java.sql.Time formatoTime(String s_time ){
		if (s_time==null) return null;
		
		String[] arr_time =s_time.trim().split(":");
		if (arr_time.length<2) s_time="00:00";
		java.sql.Time jsqlT = java.sql.Time.valueOf( s_time+":00" );
		
		return jsqlT;
	}
	
	
	/**
	 * Genera un objeto java.sql.Date de una cadena en formato DD-MM-AAAA
	 * @param s_date
	 * @return
	 */
	public static java.sql.Date formatoDateDDMMAAAA(String s_date ){
		if (s_date==null) return null;
		String[] partes_fecha =  s_date.split("-");
		return  formatoDate(partes_fecha[2]+"-"+partes_fecha[1]+"-"+partes_fecha[0] );
	}
	
	/**
	 * Genera un objeto java.sql.Date de una cadena en formato MM-DD-AAAA
	 * @param s_date
	 * @return
	 */
	public static java.sql.Date formatoDateMMDDAAAA(String s_date ){
		if (s_date==null) return null;
		String[] partes_fecha =  s_date.split("-");
		
		return formatoDate(partes_fecha[2]+"-"+partes_fecha[0]+"-"+partes_fecha[1] );
	}
	
	/**
	 * Genera un objeto java.sql.Date de una cadena en formato AAAA-MM-DD
	 * @param s_date
	 * @return
	 */
	public static java.sql.Date formatoDate(String s_date ){
		if (s_date==null) return null;
		
		java.sql.Date jsqlD = java.sql.Date.valueOf(s_date);
		
		return jsqlD;
	}
	
	/**
	 * Realiza la conversion de una fecha tipo TimeStamp a un formato dado
	 */
	public static String formatoSQLFecha(java.sql.Timestamp timestamp,
			String elFormato) {

		if ((timestamp == null) || (elFormato == null)) {
			return null;
		}
		java.util.Date fecha = new Date(timestamp.getTime());

		return formatoFecha(fecha, elFormato);

	}// fin de formatoFecha

} // Fin Fechas
