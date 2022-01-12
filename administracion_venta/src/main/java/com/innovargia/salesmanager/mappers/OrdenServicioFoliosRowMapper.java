/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.OrdenServicioFoliosDTO;

/**
 * @author aruaro
 *
 */
public class OrdenServicioFoliosRowMapper implements RowMapper<OrdenServicioFoliosDTO>{

	/**
	 * 
	 */
	public OrdenServicioFoliosRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public OrdenServicioFoliosDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		OrdenServicioFoliosDTO obj = new OrdenServicioFoliosDTO();
		
		// TODO Auto-generated method stub
		return obj;
	}

}
