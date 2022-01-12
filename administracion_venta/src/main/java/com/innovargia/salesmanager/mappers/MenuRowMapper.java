/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.OpcionMenu;

/**
 * @author aruaro
 *
 */
public class MenuRowMapper implements RowMapper<OpcionMenu>{

	/**
	 * 
	 */
	public MenuRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public OpcionMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
