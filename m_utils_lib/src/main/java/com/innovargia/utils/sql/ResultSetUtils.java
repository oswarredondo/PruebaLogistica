/**
 * 
 */
package com.innovargia.utils.sql;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author aruaro
 * 
 */
public class ResultSetUtils {
	/***
	 * Verifica si existe un campo en el resulset devuelto
	 * 
	 * @param campo
	 * @return true si existe el campo, false en caso contrario
	 */
	public static String getRSString(String campo, ResultSet rs) {
		try {
			rs.findColumn(campo);
			String valor =  rs.getString(campo);
			//aplica reglas para modificar 
			if (valor!=null){
				valor  = valor.trim();
						valor = valor.replace("<script>", "<-cript>").replaceAll("</script>", "</-cript>").
								replaceAll("src", "-rc").replaceAll("eval", "-val").replaceAll("expression", "-xpression").
								replaceAll("javascript", "-avascript").replaceAll("vbscript", "-bscript").replaceAll("onload","-nload");
								
				valor = valor.replace("<SCRIPT>", "<-CRIPT>").replaceAll("</SCRIPT>", "</-CRIPT>").
								replaceAll("SRC", "-RC").replaceAll("EVAL", "-VAL").replaceAll("EXPRESSION", "-XPRESSION").
								replaceAll("JAVASCRIPT", "-AVASCRIPT").replaceAll("VBSCRIPT", "-BSCRIPT").replaceAll("ONLOAD","-NLOAD");				
			}
	
			return valor;
		} catch (Exception e) {

		}
		return null;
	}

	public static int getRSInt(String campo, ResultSet rs) {
		try {
			rs.findColumn(campo);
			return rs.getInt(campo);
		} catch (Exception e) {

		}
		return 0;
	}

	public static float getRSFloat(String campo, ResultSet rs) {
		try {
			rs.findColumn(campo);
			return rs.getFloat(campo);
		} catch (Exception e) {

		}
		return 0;
	}
	
	public static double getRSDouble(String campo, ResultSet rs) {
		try {
			rs.findColumn(campo);
			return rs.getDouble(campo);
		} catch (Exception e) {

		}
		return 0;
	}

	public static boolean getRSBoolean(String campo, ResultSet rs) {
		try {

			rs.findColumn(campo);

			return rs.getBoolean(campo);
		} catch (Exception e) {

		}
		return false;
	}

	public static Date getRSDate(String campo, ResultSet rs) {
		try {
			rs.findColumn(campo);
			return rs.getDate(campo);
		} catch (Exception e) {

		}
		return null;
	}

	public static Timestamp getRSTimestamp(String campo, ResultSet rs) {
		try {

			rs.findColumn(campo);
			String fecha = getRSString(campo, rs);

			if (fecha != null) {
				// Verifica si tiene milisegundos
				String[] partes_fecha = fecha.split("\\.");
				if (partes_fecha.length > 1) {
					fecha = partes_fecha[0];
				} else {
					partes_fecha = fecha.split("-");
					if (partes_fecha.length > 1) {
						fecha = partes_fecha[0] + "-" + partes_fecha[1] + "-" + partes_fecha[2];
					}
				}

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				Date parsedDate = dateFormat.parse(fecha);
				Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

				return timestamp;// rs.getTimestamp(campo);
			}

		} catch (Exception e) {

		}
		return null;
	}
}
