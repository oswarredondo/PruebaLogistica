/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.AdicionalDTO;
import com.innovargia.documentos.dtos.CPs;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Ruta;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 * 
 */
public class RutaPlazaTotalDTOMapper implements RowMapper<Ruta> {

    /**
	 * 
	 */
    public RutaPlazaTotalDTOMapper() {
	// TODO Auto-generated constructor stub
    }

    @Override
    public Ruta mapRow(ResultSet rs, int rowNum) throws SQLException {

	Ruta obj = new Ruta();
	obj.setTotal(ResultSetUtils.getRSInt("total", rs));
	obj.setSiglasplaza(UtilsStringFechas
		.convierteCadenaTrimNULL(ResultSetUtils.getRSString(
			"plaza", rs)));

	obj.setIdruta(UtilsStringFechas
		.convierteCadenaTrimNULL(ResultSetUtils.getRSString(
			"idruta", rs)));
	return obj;
    }

}
