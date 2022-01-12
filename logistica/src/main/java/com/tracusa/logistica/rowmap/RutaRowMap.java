package com.tracusa.logistica.rowmap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.tracusa.logistica.model.RutaResponse;

public class RutaRowMap implements RowMapper<RutaResponse> {

	@Override
	public RutaResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		RutaResponse obj  = new RutaResponse();
		obj.setIdGuia(rs.getString("iddocumento"));
		obj.setDireccion(rs.getString("destino"));
		obj.setContacto(rs.getString("contacto"));
		obj.setTelefono(rs.getString("telefono"));
		return obj;

	}

}
