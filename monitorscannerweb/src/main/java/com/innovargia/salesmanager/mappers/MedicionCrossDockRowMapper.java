package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.autodoc.dto.MedicionCrossDock;
import com.innovargia.utils.sql.ResultSetUtils;

public class MedicionCrossDockRowMapper implements RowMapper<MedicionCrossDock> {

	@Override
	public MedicionCrossDock mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MedicionCrossDock obj = new MedicionCrossDock();
		
		obj.setCentro_operativo(ResultSetUtils.getRSString("centro_operativo", rs));
		obj.setCross_dock(ResultSetUtils.getRSFloat("crossdock", rs));

		return obj;
	}
	
}
