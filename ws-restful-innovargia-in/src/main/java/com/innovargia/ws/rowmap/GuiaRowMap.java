package com.innovargia.ws.rowmap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.servicio.dtos.Guia;

public class GuiaRowMap implements RowMapper<Guia> {

	@Override
	public Guia mapRow(ResultSet rs, int arg1) throws SQLException {
		Guia obj  = new Guia();
		obj.setLibre(rs.getString("idguia"));
		obj.setGuia(rs.getString("idguia"));
		return obj;
	}

}
