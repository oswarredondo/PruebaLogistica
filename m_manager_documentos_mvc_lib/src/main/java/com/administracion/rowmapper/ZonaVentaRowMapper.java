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
public class ZonaVentaRowMapper implements RowMapper<Zona>{

	/**
	 * 
	 */
	public ZonaVentaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Zona mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Zona obj  =new Zona();
		obj.setZonaOrigen(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idzonaventaori",rs))); 
		obj.setZonaDestino(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idzonaventades",rs)));
		obj.setIdRuta(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("enrutamiento",rs))); 
    	obj.setZonaVenta(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idzonaventa",rs))); 
    	
		return obj;
	}

}
