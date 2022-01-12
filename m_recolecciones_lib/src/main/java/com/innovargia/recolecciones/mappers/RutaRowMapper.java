/**
 * 
 */
package com.innovargia.recolecciones.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Ruta;

/**
 * @author aruaro
 *
 */
public class RutaRowMapper implements RowMapper<Ruta>{

	/**
	 * 
	 */
	public RutaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Ruta mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Ruta ruta =  new Ruta();
		ruta.setRuta(ResultSetUtils.getRSString("rutaasignada", rs));
		ruta.setIdruta(ResultSetUtils.getRSString("rutaasignada", rs)); 
		
		
		
		return ruta;
	}

}
