/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.OrganizacionDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class OrganizacionRowMapper implements RowMapper<OrganizacionDTO>{

	/**
	 * 
	 */
	public OrganizacionRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public OrganizacionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		OrganizacionDTO obj = new OrganizacionDTO();

		obj.setIdentidad(ResultSetUtils.getRSInt("identidad", rs));
		obj.setIdorganizacion(ResultSetUtils.getRSInt("idorganizacion", rs));
		obj.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion", rs)));
		obj.setLogo(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("logo", rs)));
		obj.setFechacreacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechacreacion", rs)));
		obj.setEstatus(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("estatus", rs))); // A=Activo,
															// B=Baja

		

		
		return obj;
	}

}
