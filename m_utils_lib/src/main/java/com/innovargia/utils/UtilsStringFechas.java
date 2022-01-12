/**
 * 
 */
package com.innovargia.utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author amr
 * 
 */
public class UtilsStringFechas {

	
	
	public static String convierteCadena(String s) {
		if (s != null) {
			String str_tmp = s.toUpperCase().trim();
			str_tmp = UtilsStrings.quitaCaracteresEspeciales(str_tmp);
			str_tmp = UtilsStrings.quitoAcentos(str_tmp);
			
			/*str_tmp = str_tmp.replace('Ñ','N');
			str_tmp = str_tmp.replace('ñ','n');
			str_tmp = str_tmp.replace('Á','A');
			str_tmp = str_tmp.replace('É','E');
			str_tmp = str_tmp.replace('Í','I');
			str_tmp = str_tmp.replace('Ó','O');
			str_tmp = str_tmp.replace('Ú','U');
			str_tmp = str_tmp.replace('á','a');
			str_tmp = str_tmp.replace('é','e');
			str_tmp = str_tmp.replace('í','i');
			str_tmp = str_tmp.replace('ó','o');
			str_tmp = str_tmp.replace('ú','u');
			str_tmp = str_tmp.replaceAll("#", "");
			
			str_tmp = str_tmp.replaceAll(",", " ");
			str_tmp = str_tmp.replaceAll(";", " ");
			str_tmp = str_tmp.replaceAll("&", " ");
			str_tmp = str_tmp.replaceAll("\"", " ");
			str_tmp = str_tmp.replaceAll("'", " ");
			str_tmp = str_tmp.replaceAll(">", " ");
			str_tmp = str_tmp.replaceAll("<", " ");
			str_tmp = str_tmp.replaceAll("\"", " ");
			
			str_tmp = str_tmp.replaceAll("'", " ");
			str_tmp = str_tmp.replace("\\", "/");
			str_tmp = str_tmp.replaceAll("/", " ");
			str_tmp = str_tmp.replaceAll("null"," ");*/

			return str_tmp;
		} else {
			return s;
		}
	}

	public static String convierteCadenaNULL(String s) {
		if (s == null)    
			return s;
		if ((s != null) && (s.trim().toLowerCase().equals("null")))
			return "";
		;
		return convierteCadena(s);

	}
	
	
	
	public static String convierteCadenaNULLLower(String s) {
		if (s == null)
			return s;
		if ((s != null) && (s.trim().toLowerCase().equals("null")))
			return "";
		;
		return s.trim();

	}
	
	public static String convierteCadenaTrimNULL(String s) {
		if (s == null)
			return s;
		if ((s != null) && (s.trim().toLowerCase().equals("null")))
			return "";
		s = s.trim().replaceAll("null"," ");
		return s.trim();

	}
	
	public static String limpiaCadenaToUpper(String s) {
		if (s == null)
			return s;
		if ((s != null) && (s.trim().toLowerCase().equals("null")))
			return "";
		;
		return convierteCadena(s.trim());

	}
	public static String changeNULL(String s) {
		if (s == null)
			return "";
		if ((s != null) && (s.trim().toLowerCase().equals("null")))
			return "";
		;
		return s.trim();

	}

	public static String truncaCadena(String s, int length) {
		if (s != null) {
			if (s.length() > length)
				return s.substring(0, length);
		}
		return s;
	}

	public static String convierteCadena(String s, int length) {
		if (s != null) {
			String str_tmp = s.toUpperCase().trim();
			
			
			str_tmp = convierteCadena(str_tmp);
			// Evaluar longitud
			if (s.length() > length)
				str_tmp = str_tmp.substring(0, length);

			return str_tmp;
		} else {
			return s;
		}
	}
	
	public static String convierteCadenaNULL(String s, int length) {
		if (s == null) {
			s="";
		}
		
		return convierteCadena(s, length) ;
	}

	/**
	 * Obtiene la fecha en el formato yyyy-MM-dd
	 * 
	 * @param format
	 * @return
	 */
	public static String obtenerFechaActual() {
		return obtenerFechaActual("yyyy-MM-dd");
	}

	/**
	 * Obtiene la fecha en el formato indicado
	 * 
	 * @param format
	 * @return
	 */
	public static String obtenerFechaActual(String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(new Date());
	}

	/**
	 * Obtiene la fecha en el formato indicado
	 * 
	 * @param format
	 * @return
	 */
	public static String formatoFecha(String format, Date date) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	/***
	 * 
	 * @param format
	 * @param fecha_str
	 * @return
	 */
	public static String formatoStrFecha(String format, String fecha_str) {
		fecha_str = fecha_str.replaceAll("/", "-");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
		Date fecha = null;
		try {

			fecha = df.parse(fecha_str);
			df = new SimpleDateFormat(format);
			return df.format(fecha);
		} catch (ParseException ex) {
			

		}
		return fecha_str;

	}
	
	/***
	 * Formatea una cadena de fecha a otra ejemplo de
	 * "yyyy-MM-dd hh:mm:ss.S" a dd-MM-yyyy
	 * @param format
	 * @param fecha_str
	 * @return
	 */
	public static String formatoStrFecha(String fecha_str, String formatoactual,String format_deseado ) {

		try {
			fecha_str = fecha_str.replaceAll("/", "-");
			formatoactual = formatoactual.replaceAll("/", "-");
			
			SimpleDateFormat df = new SimpleDateFormat(formatoactual );
			Date fecha = null;
			
			fecha = df.parse(fecha_str);
			df = new SimpleDateFormat(format_deseado);
			return df.format(fecha);
		} catch (ParseException ex) {
			//System.out.println(ex.getMessage());
			//ex.printStackTrace();

		}
		return fecha_str;

	}

	public static String formatoStrFechaIni(String fecha) {
	
		String fecha_str = "";
		if (fecha.contains("T")) {
			fecha_str = fecha.split("T")[0];
			fecha_str = fecha_str + " 00:00";

		} else {
			fecha_str = fecha;
			fecha_str = fecha_str + " 00:00";
		}
		return fecha_str;
	}

	public static String formatoStrFechaFin(String fecha) {
		
		String fecha_str = "";
		if (fecha.contains("T")) {
			fecha_str = fecha.split("T")[0];
			fecha_str = fecha_str + " 23:59";

		} else {
			fecha_str = fecha;
			fecha_str = fecha_str + " 23:59";
		}
		return fecha_str;

	}

	/**
	 * Da forma a una fecha y devuelve un objeto Date, si el dato de se pasa
	 * como null se inicializa a yyyy-MM-dd hh:mm
	 * 
	 * @param parse_format
	 * @param str_date
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDate(String parse_format, String str_date) {
		if (parse_format == null) {
			parse_format = "yyyy-MM-dd hh:mm";
		}
		SimpleDateFormat format = new SimpleDateFormat(parse_format);
		try {
			return format.parse(UtilsStringFechas.formatoStrFechaIni(str_date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	/**
	 * Da forma a una fecha y devuelve un objeto Date, si el dato de se pasa
	 * como null se inicializa a yyyy-MM-dd hh:mm
	 * 
	 * @param parse_format
	 * @param str_date
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDateIni(String parse_format, String str_date) {
		if (parse_format == null) {
			parse_format = "yyyy-MM-dd hh:mm";
		}
		SimpleDateFormat format = new SimpleDateFormat(parse_format);
		try {
			return format.parse(UtilsStringFechas.formatoStrFechaIni(str_date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	/**
	 * Da forma a una fecha y devuelve un objeto Date, si el dato de se pasa
	 * como null se inicializa a yyyy-MM-dd hh:mm
	 * 
	 * @param parse_format
	 * @param str_date
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDateFin(String parse_format, String str_date) {
		if (parse_format == null) {
			parse_format = "yyyy-MM-dd hh:mm";
		}
		SimpleDateFormat format = new SimpleDateFormat(parse_format);
		try {
			return format.parse(UtilsStringFechas.formatoStrFechaFin(str_date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	/***
	 * Obtiene la lineas de un archivo de texto
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static ArrayList<String> getContenidoArhivoTexto(InputStream is)
			throws IOException {
		DataInputStream data = new DataInputStream(is);
		BufferedReader bf = new BufferedReader(new InputStreamReader(data));
		ArrayList<String> lineas = new ArrayList<String>();
		String line;
		while ((line = bf.readLine()) != null) {
			lineas.add(line);
		}
		return lineas;
	}

	/***
	 * Solo valida el archivo cuando se mandan las extenciones de las que 
	 * puede ser
	 * @param name_file
	 * @param extenciones_validas
	 * @return
	 */
	public static  boolean isValidoElArchivo(String name_file,String extenciones_validas){
	  
		boolean isValidFile=true;
		if ((extenciones_validas!=null) && (extenciones_validas.trim().length()>0)){
			String name_file_ext = name_file;
			int indice_point = name_file.indexOf(".");
			if (indice_point>-1){
				name_file_ext = name_file.substring(indice_point);
			}
			
			isValidFile = (extenciones_validas.indexOf(name_file_ext)>-1)?true:false;
		}
		return isValidFile;
	}
	/**
	 * Valida un correo electronico
	 * 
	 * @param email
	 *            email for validation
	 * @return true valid email, otherwise false
	 */
	public static boolean validateEmail(String email) {
		 String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		// Compiles the given regular expression into a pattern.
		Pattern pattern = Pattern.compile(PATTERN_EMAIL);

		// Match the given input against this pattern
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();

	}
	
	/**
	 * Valida un correo electronico que tenga dominio Estafeta
	 * 
	 * @param email
	 *            email for validation
	 * @return true valid email, otherwise false
	 */
	public static boolean validateEmailEstafeta(String email) {
		 String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@estafeta.com$";

		// Compiles the given regular expression into a pattern.
		Pattern pattern = Pattern.compile(PATTERN_EMAIL);

		// Match the given input against this pattern
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();

	}
	
	
	 public static boolean isDate(String fechax) {
	        try {
	        	Calendar date =Calendar.getInstance();
	        	int anio = date.get(Calendar.YEAR);
	        	fechax = fechax.replaceAll("-", "/");
	        	String[] arr_fecha =  fechax.split("/");
	        	if (arr_fecha.length<3){
	        		System.out.println("Estructura de fecha invalida:" +fechax);
	        		return false;
	        	}
	        	int dia_elem = Integer.parseInt(arr_fecha[0]);
	        	int mes_elem = Integer.parseInt(arr_fecha[1]);
	        	int anio_elem = Integer.parseInt(arr_fecha[2]);
	        	
	        	if ((dia_elem<=0) || (dia_elem>31)){
	        		System.out.println("Numero de dias invalido:" +dia_elem);
	        		return false;
	        	}
	        	
	        	if ((mes_elem<=0) || (mes_elem>12)){
	        		System.out.println("Numero de mes invalido:"+mes_elem);
	        		return false;
	        	}
	        	if (anio_elem<anio){
	        		System.out.println("Anio menor al Anio actual:"+anio_elem);
	        		return false;
	        	}
		            
	        	//Veerifica si la cantidad de dias indicando en el mes no es mayor 
	        	//a la cantidad de dias que debe tener, es decir si Nov tiene 30 el usuario 
	        	//no debe indicar 31-11-2013, lo mismo sucederia en el caso de ferero en a�os 
	        	//bisiestos
	        	// Create a calendar object of the desired month 
	    		Calendar cal = new GregorianCalendar(anio_elem,mes_elem-1, 1); 
	    		
	    		//Obtiene los d�as del mes 
	    		int dias = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
	    		
	    		if (dia_elem>dias){
	    			System.out.println("Cantidad de dias del mes invalido se indico " + dia_elem +" y solo puede tener " + dias);
	    			return false;
	    		}
	    		
	        } catch (Exception e) {
	            return false;
	        }
	        
    		System.out.println("Fecha " + fechax + " valida....!!" );
	        return true;
	 }
	 public static String getNombreArchivo(String login, String nombrearchivo, String extencion_archivo){
			
			//Obtiene la fecha
			String fecha_hora = obtenerFechaActual("yyyyMMdd_hhmmss");
			//Verifica si el usuario es diferente de null
			String nombre_usuario = "";
			if (login!=null){
				nombre_usuario =  convierteCadenaNULL(login);
			}
			
			//return nombrearchivo+nombre_usuario+fecha_hora+"."+extencion_archivo;
			return nombrearchivo+fecha_hora+"."+extencion_archivo;
		}
	
}
