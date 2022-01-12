/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.PlazaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class PlazaRowMapper implements RowMapper<PlazaDTO>{

	/**
	 * 
	 */
	public PlazaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PlazaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PlazaDTO obj = new PlazaDTO();
		obj.setSiglasplaza(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("siglasplaza", rs)));
		obj.setIdcentrooperativo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idsiglasco", rs))); 
		obj.setEstatus(ResultSetUtils.getRSInt("estatus", rs));
		obj.setDescripcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion", rs)));
		
		
		
		return obj;
	}

}
