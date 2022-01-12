package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.autodoc.dto.MedicionDias;
import com.innovargia.utils.sql.ResultSetUtils;

public class MedicionDiasRowMapper implements RowMapper<MedicionDias>  {

	@Override
	public MedicionDias mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MedicionDias obj = new MedicionDias();
		
		obj.setCop(ResultSetUtils.getRSString("cop", rs));
		obj.setDia(ResultSetUtils.getRSString("dia", rs));
		obj.setNumGuias(ResultSetUtils.getRSInt("numguias", rs));
        obj.setPorcentaje(ResultSetUtils.getRSFloat("porcentaje", rs));
        
		return obj;
	}
}
