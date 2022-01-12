/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.LogMovimientoProcesadoDTO;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.UtilsStrings;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class ViajeCorridasRowMapper implements RowMapper<LogMovimientoProcesadoDTO>{

	/**
	 * 
	 */
	public ViajeCorridasRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LogMovimientoProcesadoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
	    
	    LogMovimientoProcesadoDTO obj = new LogMovimientoProcesadoDTO();


	    
	    obj.setTipomovimiento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tipomovimiento", rs)));
	    obj.setTipomovimiento(UtilsStrings.completa( obj.getTipomovimiento(), '0', 10, 1));
	    obj.setViaje(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("viaje", rs)));
	    obj.setRuta(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("ruta", rs)));
	    obj.setFechaproceso(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fechaproceso", rs))) ;

	    
	    
	    

	    return obj;
	}

}
