/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class LogHistorialRowMapper implements RowMapper<LogHistoriaDTO>{

	/**
	 * 
	 */
	public LogHistorialRowMapper() {
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
		obj.setFecha(UtilsStringFechas.convierteCadenaNULL(FechasDateTimeStamp.formatoTimeStamp(ResultSetUtils.getRSTimestamp("fecha", rs), "dd-MM-yyyy hh:mm aaa")));

		return obj;
	}

}
