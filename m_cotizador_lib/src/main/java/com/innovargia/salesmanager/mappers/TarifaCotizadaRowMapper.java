/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.CotizacionTarifa;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class TarifaCotizadaRowMapper implements RowMapper<CotizacionTarifa>{

	/**
	 * 
	 */
	public TarifaCotizadaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CotizacionTarifa mapRow(ResultSet rs, int rowNum) throws SQLException {
	    CotizacionTarifa obj = new CotizacionTarifa();
		obj.setIdtarifa(ResultSetUtils.getRSInt("idtarifa", rs) );
		obj.setDescripciontarifa(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion", rs)));
		obj.setIdservicio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idservicio", rs))); 
		
		// TODO Auto-generated method stub
		return obj;
	}

}
