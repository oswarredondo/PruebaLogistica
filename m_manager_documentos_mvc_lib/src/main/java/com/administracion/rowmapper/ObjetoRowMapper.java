/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.documentos.dtos.Objeto;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class ObjetoRowMapper implements RowMapper<Objeto>{

	/**
	 * 
	 */
	public ObjetoRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Objeto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Objeto obj  =new Objeto();
		obj.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion",rs))); 
		
		return obj;
	}

}
