package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.autodoc.dto.MedicionCumplimientoGarantias;
import com.innovargia.utils.sql.ResultSetUtils;

public class MedicionCumplimientoGarantiasRowMapper implements RowMapper<MedicionCumplimientoGarantias> {

	@Override
	public MedicionCumplimientoGarantias mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MedicionCumplimientoGarantias obj = new MedicionCumplimientoGarantias();
		
		obj.setGrupo(ResultSetUtils.getRSString("nombre_cliente", rs));
		obj.setSi_cumplio(ResultSetUtils.getRSFloat("si_cumplio", rs));
		obj.setNo_cumplio(ResultSetUtils.getRSFloat("no_cumplio", rs));

		return obj;
	}
	
}
