/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.LocalizacionDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class LocalizacionRowMapper implements RowMapper<LocalizacionDTO>{

	/**
	 * 
	 */
	public LocalizacionRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LocalizacionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		LocalizacionDTO obj = new LocalizacionDTO();
		
		obj.setIdcliente(ResultSetUtils.getRSInt("idcliente", rs));
		obj.setIdlocalizacion(ResultSetUtils.getRSInt("idlocalizacion", rs));
		obj.setTelefono(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("telefono", rs)));
		obj.setTelefono1(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("telefono1", rs)));
		obj.setFax(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fax", rs)));

		
		return obj;
	}

}
