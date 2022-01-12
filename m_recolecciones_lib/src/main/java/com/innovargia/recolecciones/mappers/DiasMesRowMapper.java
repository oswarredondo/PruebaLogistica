/**
 * 
 */
package com.innovargia.recolecciones.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.DiasSemanaMes;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class DiasMesRowMapper implements RowMapper<DiasSemanaMes>{

	/**
	 * 
	 */
	public DiasMesRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DiasSemanaMes mapRow(ResultSet rs, int rowNum) throws SQLException {
		DiasSemanaMes diasmes = new DiasSemanaMes();
		diasmes.setIdregistro(ResultSetUtils.getRSInt("idregistro",rs));  
		diasmes.setDiasemanames(ResultSetUtils.getRSInt("dia",rs));
		diasmes.setObservacion(ResultSetUtils.getRSString("observacion",rs)); 

		return diasmes;
	}

}
