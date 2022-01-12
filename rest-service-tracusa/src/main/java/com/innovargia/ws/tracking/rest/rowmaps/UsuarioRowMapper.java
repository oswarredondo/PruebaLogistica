/**
 * 
 */
package com.innovargia.ws.tracking.rest.rowmaps;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.innovargia.ws.tracking.rest.dto.UsuarioDTO;

/**
 * @author aruaro
 *
 */
public class UsuarioRowMapper implements RowMapper<UsuarioDTO>{

	/**
	 * 
	 */
	public UsuarioRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UsuarioDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		UsuarioDTO obj = new UsuarioDTO();
		obj = new UsuarioDTO();
		obj.setLogin(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("login", rs)));   
		obj.setPassword(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("password", rs)));    
		obj.setNumcte(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numcliente", rs)));   
		obj.setIdorganizacion(ResultSetUtils.getRSInt("idorganizacion", rs));  
		obj.setIdentidad(ResultSetUtils.getRSInt("identidad", rs)); 

		return obj;
	}

}
