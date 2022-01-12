/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.DireccionDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class CodigoPostalRowMapper implements RowMapper<DireccionDTO>{

	/**
	 * 
	 */
	public CodigoPostalRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DireccionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		DireccionDTO obj = new DireccionDTO();
		obj.setColonia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("d_asenta", rs)));
		obj.setMunicipio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("d_mnpio", rs)));
		obj.setEstado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("d_estado", rs)));
		obj.setCp(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("d_codigo", rs)));
		obj.setCiudad(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("d_ciudad", rs)));
		

		
		return obj;
	}

}
