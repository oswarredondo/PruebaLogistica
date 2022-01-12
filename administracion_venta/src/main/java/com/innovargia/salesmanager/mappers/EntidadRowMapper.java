/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.EntidadDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class EntidadRowMapper implements RowMapper<EntidadDTO>{

	/**
	 * 
	 */
	public EntidadRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public EntidadDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		EntidadDTO obj = new EntidadDTO();

		obj.setIdentidad(ResultSetUtils.getRSInt("identidad", rs));
		obj.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion", rs)));
		obj.setEstatus(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("estatus", rs)));
		
		return obj;
	}

}
