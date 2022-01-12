package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.autodoc.dto.MedicionPendientesCO;
import com.innovargia.utils.sql.ResultSetUtils;

public class MedicionPendientesCORowMapper implements RowMapper<MedicionPendientesCO>  {

	@Override
	public MedicionPendientesCO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MedicionPendientesCO obj = new MedicionPendientesCO();
		
		obj.setEstatus(ResultSetUtils.getRSString("estatus", rs));
		obj.setAlmacen(ResultSetUtils.getRSInt("almacen", rs));
		obj.setRuta(ResultSetUtils.getRSInt("ruta", rs));
		obj.setRutaForanea(ResultSetUtils.getRSInt("rutaForanea", rs));
		obj.setConfirmaActualiza(ResultSetUtils.getRSInt("confirmaActualiza", rs));
		obj.setInvestigacion(ResultSetUtils.getRSInt("investigacion", rs));
		obj.setEntrega(ResultSetUtils.getRSInt("entrega", rs));
		obj.setSinMovimientos(ResultSetUtils.getRSInt("sinMovimientos", rs));
		
		return obj;
	}

}
