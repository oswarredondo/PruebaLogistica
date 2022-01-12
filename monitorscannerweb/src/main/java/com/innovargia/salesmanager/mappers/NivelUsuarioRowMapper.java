/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.NivelUsuarioDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class NivelUsuarioRowMapper implements RowMapper<NivelUsuarioDTO>{

	/**
	 * 
	 */
	public NivelUsuarioRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public NivelUsuarioDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		NivelUsuarioDTO obj = new NivelUsuarioDTO();
		
		obj.setIdentificador(ResultSetUtils.getRSInt("identificador", rs) );
		obj.setIdnivelusuario(ResultSetUtils.getRSInt("idnivelusuario", rs) );
		obj.setVisiblesiempre(ResultSetUtils.getRSInt("visiblesiempre", rs) );
		obj.setMaxdescadicional(ResultSetUtils.getRSFloat("maxdescadicional", rs) );
		obj.setMaxdesctarifas(ResultSetUtils.getRSFloat("maxdesctarifas", rs) ); 
		obj.setDescripcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion", rs)));

		// TODO Auto-generated method stub
		return obj;
	}

}
