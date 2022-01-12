/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//import jxl.StringFormulaCell;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.utils.Fechas;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.FechasTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class HistorialRowMapper implements RowMapper<LogHistoriaDTO>{

	/**
	 * 
	 */
	public HistorialRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LogHistoriaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		LogHistoriaDTO obj = new LogHistoriaDTO();

		obj.setIdregistro(ResultSetUtils.getRSInt("idregistro", rs));
		obj.setRegistro(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("registro", rs)));
		obj.setTipomovimiento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tipomovimiento", rs)));
		obj.setQuienrealiza(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("quienrealiza", rs)));
		obj.setLogin(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("login", rs)));
		obj.setObservacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("observacion", rs)));
		
		/*System.out.println("getTimestamp "+ rs.getTimestamp("fecha"));
		System.out.println("getString "+ rs.getString("fecha"));
		System.out.println("Fecha/Hora "+ ResultSetUtils.getRSTimestamp("fecha", rs));
		System.out.println("formatoTimeStamp "+ FechasDateTimeStamp.formatoTimeStamp(ResultSetUtils.getRSTimestamp("fecha", rs), "dd-MM-yyyy hh:mm aaa"));
		
		System.out.println("formatoStrFecha "+ 
		UtilsStringFechas.formatoStrFecha(ResultSetUtils.getRSString("fecha", rs), "yyyy-MM-dd HH:mm:ss-05", "dd-MM-yyyy hh:mm aaa") );*/
		
		obj.setFecha(UtilsStringFechas.convierteCadenaNULL(FechasDateTimeStamp.formatoTimeStamp(ResultSetUtils.getRSTimestamp("fecha", rs), "dd-MM-yyyy hh:mm aaa")));
		
		obj.setIdenvio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idenvio", rs)));
		obj.setDescripcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion", rs)) );
		String tmp = UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("exclave", rs)) + "-" + 
				UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descricpionexcepcion", rs));
		

		obj.setExclave(tmp );
		obj.setSiglasplaza(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("plsiglasplaza", rs)) );
		obj.setPlazaorigina(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("plazaorigina", rs))  );
		obj.setEmpleado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("empleado", rs)) );
		obj.setRuta(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("ruta", rs)) );
		

		obj.setIdestatus(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idestatus", rs)) );
		obj.setDescripcion_estatus(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion_estatus", rs)) );
		obj.setImagen_css(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("imagen_css", rs)) );
		
		obj.setLatitud(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("latitud", rs)) );
		obj.setLongitud( UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("longitud", rs)) );
		

		return obj;
	}

}
