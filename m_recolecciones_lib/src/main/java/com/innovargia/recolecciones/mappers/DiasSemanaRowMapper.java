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
public class DiasSemanaRowMapper implements RowMapper<DiasSemanaMes>{

	/**
	 * 
	 */
	public DiasSemanaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DiasSemanaMes mapRow(ResultSet rs, int rowNum) throws SQLException {
		DiasSemanaMes diasmes = new DiasSemanaMes();
		diasmes.setDiasemanames(ResultSetUtils.getRSString("diasemana",rs));
		diasmes.setIdregistro(ResultSetUtils.getRSInt("idregistro",rs));
		diasmes.setObservacion(ResultSetUtils.getRSString("observacion",rs)); 
		diasmes.setIdsolicitud(ResultSetUtils.getRSString("idsolicitud",rs));  
		return diasmes;
	}

}
