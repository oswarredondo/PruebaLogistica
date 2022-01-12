/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.SQLColumn;

/**
 * @author aruaro
 *
 */
public class SQLColumnRowMapper implements RowMapper<SQLColumn>{

	/**
	 * 
	 */
	public SQLColumnRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SQLColumn mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
