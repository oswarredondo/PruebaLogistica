
package com.innovargia.ws.tracking.rest.rowmaps;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.innovargia.ws.tracking.rest.dto.Movimiento;

/**
 * @author aruaro
 *
 */
public class HistorialRowMapper implements RowMapper<Movimiento>{

	/**
	 * 
	 */
	public HistorialRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Movimiento mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Movimiento obj = new Movimiento();

		obj.setTipoMovimiento(ResultSetUtils.getRSString("tiRegistro", rs));
		obj.setFecha(UtilsStringFechas.convierteCadenaNULL(FechasDateTimeStamp.formatoTimeStamp(ResultSetUtils.getRSTimestamp("FechaEvento", rs), "dd-MM-yyyy hh:mm aaa")));
		obj.setIdclavelog(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("exClave", rs)));
		obj.setRuta(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("ruta", rs)));
		obj.setPlaza(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("ceOrigenRegistro", rs)));
		obj.setCveLog(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionExcepcipon", rs))); 
		obj.setLatitud(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("latitud", rs)));  
		obj.setLongitud(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("longitud", rs)));    
		
		obj.setTipo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tipo", rs)));    

		return obj;
	}

}
