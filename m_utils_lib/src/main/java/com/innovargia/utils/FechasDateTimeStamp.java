package com.innovargia.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FechasDateTimeStamp {
	public static String FORMATO_yyyy_MM_dd = "yyyy-MM-dd";

	/**
	 * Da formato a una objeto de tipo java.sql.Timestamp dada una fecha, esta
	 * debe estar en el formato de yyyy-mm-dd hh:mm:ss
	 * 
	 * @param s
	 * @return
	 */
	public static java.sql.Timestamp valueOfTimeStamp(String s){
		 java.sql.Timestamp ts = null;
		 try {
			  ts = java.sql.Timestamp.valueOf(s);
	            
	        } catch (IllegalArgumentException ie) {
	        	ie.printStackTrace();
	        }
		
		return ts;
	}

	/**
	 * Da formato a una objeto de tipo java.sql.Time dada una hora, esta debe
	 * estar en el formato de hh:mm:ss
	 * 
	 * @param s
	 * @return
	 */
	public static java.sql.Time valueOfTime(String s) {
		java.sql.Time ts = null;
		 try {
			  ts = java.sql.Time.valueOf(s);
	            
	        } catch (IllegalArgumentException ie) {
	        	ie.printStackTrace();
	        }
		
		return ts;
	}

	/**
	 * Da formato a una objeto de tipo java.util.Date dada una fecha en el
	 * formato que indique el usuario, como yyyy-MM-dd
	 * 
	 * @param s
	 * @return
	 */
	public static Date valueOfDate(String s, String format) {
		DateFormat df = new SimpleDateFormat(format);

		try {
			return df.parse(s);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Da formato a una objeto de tipo java.util.Date dada una fecha en el
	 * formato que indique el usuario, como yyyy-MM-dd
	 * 
	 * @param s
	 * @return
	 */
	public static java.sql.Date valueSQLOfDate(String s, String format) {
		DateFormat df = new SimpleDateFormat(format);
		
		try {
			java.util.Date utilDate =df.parse(s);
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    
			return sqlDate;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Da formato a una objeto de tipo java.util.Date dada una fecha en el
	 * formato que indique el usuario, como yyyy-MM-dd
	 * 
	 * @param s
	 * @return
	 */
	public static  java.util.Date stringToDate(String s, String format) {
		DateFormat df = new SimpleDateFormat(format);
		
		try {
			java.util.Date utilDate =df.parse(s);
			return utilDate;

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
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
     * Devuelve la fecha bajo un formato indicado.
     *
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
    public static String formatoFecha(Date fecha,String elFormato) {
    	
    	if (fecha==null){return null;} 
        StringBuffer sb = new StringBuffer();
        
        //Da formato a la fecha
        SimpleDateFormat formato = new SimpleDateFormat(elFormato);
        sb.append(formato.format(fecha));
        
        return sb.toString();
    }//fin de createEncabezado
	
	  /** Devuelve la fecha bajo un formato indicado, si se desea una fecha en
     * especifico se debe crear una instancia de Calendar y configurar la fecha,
     * si el parametro fecha es pasado como null se crea una instnacia de la
     * la fecha del día actual<br>
     *
     * Ejemplos:<br>
     * <br>
     *  Date and Time Pattern Result<br>
     * "yyyy.MM.dd G 'at' HH:mm:ss z"  2001.07.04 AD at 12:08:56 PDT<br>
     * "EEE, MMM d, ''yy"  Wed, Jul 4, '01<br>
     * "h:mm a"  12:08 PM<br>
     * "hh 'o''clock' a, zzzz"  12 o'clock PM, Pacific Daylight Time<br>
     * "K:mm a, z"  0:08 PM, PDT<br>
     * "yyyyy.MMMMM.dd GGG hh:mm aaa"  02001.July.04 AD 12:08 PM<br>
     * "EEE, d MMM yyyy HH:mm:ss Z"  Wed, 4 Jul 2001 12:08:56 -0700<br>
     * "yyMMddHHmmssZ"  010704120856-0700<br>
     * "yyyyMMDDhhmm" 200312180425<br>
     *
     *Letter 	Date or Time Component 	Presentation 	Examples
     * G 	Era designator 	Text 	AD
     * y 	Year 	Year 	1996; 96
     * M 	Month in year 	Month 	July; Jul; 07
     * w 	Week in year 	Number 	27
     * W 	Week in month 	Number 	2
     * D 	Day in year 	Number 	189
     * d 	Day in month 	Number 	10
     * F 	Day of week in month 	Number 	2
     * E 	Day in week 	Text 	Tuesday; Tue
     * a 	Am/pm marker 	Text 	PM
     * H 	Hour in day (0-23) 	Number 	0
     * k 	Hour in day (1-24) 	Number 	24
     * K 	Hour in am/pm (0-11) 	Number 	0
     * h 	Hour in am/pm (1-12) 	Number 	12
     * m 	Minute in hour 	Number 	30
     * s 	Second in minute 	Number 	55
     * S 	Millisecond 	Number 	978
     * z 	Time zone 	General time zone 	Pacific Standard Time; PST; GMT-08:00
     * Z 	Time zone 	RFC 822 time zone 	-0800
     * 
     * yyDmsS
     * @see SimpleDateFormat
     * @param elFormato
     * @param fecha de la cual se desea el formateo
     * @return una cadena con la fecha formateada 
     */
    public static String formatoFecha(Calendar fecha,String elFormato) {
        StringBuffer sb = new StringBuffer();
        if (fecha==null){
            //Crea la instancia de fecha actual
            fecha = Calendar.getInstance();
        }
        
        //Da formato a la fecha
        SimpleDateFormat formato = new SimpleDateFormat(elFormato);
        sb.append(formato.format(fecha.getTime()));
        
        return sb.toString();
    }//fin de formatoFecha
	
	

}
