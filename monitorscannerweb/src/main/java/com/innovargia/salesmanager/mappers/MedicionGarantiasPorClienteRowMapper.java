package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.autodoc.dto.MedicionGarantiasPorCliente;
import com.innovargia.utils.sql.ResultSetUtils;

public class MedicionGarantiasPorClienteRowMapper implements RowMapper<MedicionGarantiasPorCliente> {

	@Override
	public MedicionGarantiasPorCliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MedicionGarantiasPorCliente obj = new MedicionGarantiasPorCliente();
		
		obj.setGrupo(ResultSetUtils.getRSString("nombre_cliente", rs));
		obj.setEntrega(ResultSetUtils.getRSFloat("tiempo_entrega", rs));
		obj.setTransito(ResultSetUtils.getRSFloat("transito", rs));
		obj.setDemora(ResultSetUtils.getRSFloat("dif_confirmacion", rs));

		return obj;
		
	}
	
}
