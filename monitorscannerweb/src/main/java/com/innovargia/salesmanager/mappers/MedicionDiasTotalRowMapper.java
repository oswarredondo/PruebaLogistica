package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.autodoc.dto.DesgloceCumplimientoDiasTotal;
import com.innovargia.utils.sql.ResultSetUtils;

public class MedicionDiasTotalRowMapper implements RowMapper<DesgloceCumplimientoDiasTotal>{

	@Override
	public DesgloceCumplimientoDiasTotal mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DesgloceCumplimientoDiasTotal obj = new DesgloceCumplimientoDiasTotal();
		
		obj.setCop(ResultSetUtils.getRSString("cop", rs));
        obj.setPorcentaje(ResultSetUtils.getRSFloat("porcentaje", rs));
        
		return obj;
	}
	
}
