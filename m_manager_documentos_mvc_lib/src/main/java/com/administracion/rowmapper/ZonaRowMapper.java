/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class ZonaRowMapper implements RowMapper<Zona>{

	/**
	 * 
	 */
	public ZonaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Zona mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Zona obj  =new Zona();
		obj.setZonaOrigen(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("zonaorigen",rs))); 
		obj.setZonaDestino(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("zonadestino",rs)));
		obj.setIdRuta(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("enrutamiento",rs))); 

		return obj;
	}

}
