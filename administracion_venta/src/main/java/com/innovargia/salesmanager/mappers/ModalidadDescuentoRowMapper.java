/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.ModalidadDescuentoDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class ModalidadDescuentoRowMapper implements RowMapper<ModalidadDescuentoDTO>{

	/**
	 * 
	 */
	public ModalidadDescuentoRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ModalidadDescuentoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ModalidadDescuentoDTO obj = new ModalidadDescuentoDTO();
		obj.setIdentificador(ResultSetUtils.getRSInt("identificador", rs));
		obj.setIddescuento(ResultSetUtils.getRSInt("iddescuento", rs));
		obj.setNombre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombre", rs)));
		
		
		return obj;
	}

}
