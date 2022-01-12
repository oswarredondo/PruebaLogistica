package ar.com.unisolutions.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ar.com.unisolutions.dto.MercanciaSat;

public class MercanciaRowMapper implements RowMapper<MercanciaSat> {

	@Override
	public MercanciaSat mapRow(ResultSet arg0, int arg1) throws SQLException {
		
		MercanciaSat mercanciaSat = new MercanciaSat();
		
		mercanciaSat.setClavemcia(arg0.getString("clavemcia"));
		mercanciaSat.setDescripcionmcia(arg0.getString("descripcionmcia"));
		mercanciaSat.setSimilares(arg0.getString("similares"));
		
		return mercanciaSat;
	}

}
