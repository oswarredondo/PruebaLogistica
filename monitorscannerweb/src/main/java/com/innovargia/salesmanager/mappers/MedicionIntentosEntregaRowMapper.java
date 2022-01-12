package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.autodoc.dto.MedicionIntentosEntrega;
import com.innovargia.utils.sql.ResultSetUtils;

public class MedicionIntentosEntregaRowMapper implements RowMapper<MedicionIntentosEntrega> {
	
	@Override
	public MedicionIntentosEntrega mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MedicionIntentosEntrega obj = new MedicionIntentosEntrega();
		
		obj.setSemana(ResultSetUtils.getRSString("semana", rs));
		obj.setIntento1(ResultSetUtils.getRSFloat("intento_1", rs));
		obj.setIntento2(ResultSetUtils.getRSFloat("intento_2", rs));
		obj.setMasDe3(ResultSetUtils.getRSFloat("mas_de_3", rs));

		return obj;
	}

}
