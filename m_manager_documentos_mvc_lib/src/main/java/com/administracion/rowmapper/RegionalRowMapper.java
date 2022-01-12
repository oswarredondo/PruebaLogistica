/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.documentos.dtos.Regional;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class RegionalRowMapper implements RowMapper<Regional>{

	/**
	 * 
	 */
	public RegionalRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Regional mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		Regional regional = new Regional();
		regional.setOrigen(ResultSetUtils.getRSInt("IdRegionalOri",rs)); 
		regional.setDestino(ResultSetUtils.getRSInt("IdRegionalDes",rs)); 
		regional.setMensajeria(ResultSetUtils.getRSString("Mensajeria",rs)); 
		regional.setIdGarantia(ResultSetUtils.getRSString("IdGarantia",rs)); 
	
		return regional;
	}

}
