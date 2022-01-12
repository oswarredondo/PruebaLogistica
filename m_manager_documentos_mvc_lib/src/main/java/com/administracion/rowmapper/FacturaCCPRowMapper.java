package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tracusa.ccp.FacturaCCP;

public class FacturaCCPRowMapper implements RowMapper<FacturaCCP> {

    @Override
    public FacturaCCP mapRow(ResultSet rs, int rowNum) throws SQLException {

	FacturaCCP facturaCCP = new FacturaCCP();

	facturaCCP.setIdControl(rs.getInt("idcontrol"));
	facturaCCP.setIdViaje(rs.getInt("idviaje"));
	facturaCCP.setFecha(rs.getDate("fecha"));
	facturaCCP.setCliente(rs.getString("cliente"));
	facturaCCP.setFactura(rs.getString("factura"));
	facturaCCP.setEstatus(rs.getString("estatus"));
	facturaCCP.setReferencia(rs.getString("referencia"));
	facturaCCP.setMensaje(rs.getString("mensaje"));

	return facturaCCP;

    }

}
