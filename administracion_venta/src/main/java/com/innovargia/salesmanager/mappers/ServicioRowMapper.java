/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.ServicioDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class ServicioRowMapper implements RowMapper<ServicioDTO>{

	/**
	 * 
	 */
	public ServicioRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ServicioDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ServicioDTO obj = new ServicioDTO();
		obj.setIdentificador(ResultSetUtils.getRSInt("identificador", rs));
		obj.setDescripcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion", rs)));
		obj.setNombre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombre", rs)));
		obj.setEstatus(ResultSetUtils.getRSInt("estatus", rs));
		obj.setCodigoid(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("codigoid", rs)));
		obj.setIdservicio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idservicio", rs)));
		obj.setTipocobro(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tipocobro", rs)));	
		obj.setGeneraretorno(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("generaretorno", rs)));
		obj.setIdentidad(ResultSetUtils.getRSInt("identidad", rs));
		obj.setIdorganizacion(ResultSetUtils.getRSInt("idorganizacion", rs));
		
		
		obj.setDescripcion_tipocobro(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion_tipocobro", rs)));
		

		return obj;
	}

}
