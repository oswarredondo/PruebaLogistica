/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.WallPaperDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class WPRowMapper implements RowMapper<WallPaperDTO>{

	/**
	 * 
	 */
	public WPRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public WallPaperDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		WallPaperDTO obj = new WallPaperDTO();
		obj.setIdaplicacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idaplicacion", rs)));
		obj.setImage(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("image", rs)));

		
		return obj;
	}

}
