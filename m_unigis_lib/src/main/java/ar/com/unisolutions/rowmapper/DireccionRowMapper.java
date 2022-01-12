package ar.com.unisolutions.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.unisolutions.dto.Direccion;

public class DireccionRowMapper implements RowMapper<Direccion>{

	@Override
	public Direccion mapRow(ResultSet arg0, int arg1) throws SQLException {
		
		Direccion direccion = new Direccion();
		
		direccion.setCodigoPostal(arg0.getString("c_cp"));
		direccion.setEstado(arg0.getString("estado"));
		direccion.setMunicipio(arg0.getString("municipio"));
		
		return direccion;
	}

}
