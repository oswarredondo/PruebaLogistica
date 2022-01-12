/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.UsuarioConvenioFolio;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 * 
 */
public class UsuarioConvenioRowMapper implements RowMapper<UsuarioConvenioFolio> {

    /**
	 * 
	 */
    public UsuarioConvenioRowMapper() {
	// TODO Auto-generated constructor stub
    }

    @Override
    public UsuarioConvenioFolio mapRow(ResultSet rs, int rowNum) throws SQLException {
	UsuarioConvenioFolio obj = new UsuarioConvenioFolio();

	obj.setIdorganizacion(ResultSetUtils.getRSInt("idorganizacion", rs));
	obj.setIdentidad(ResultSetUtils.getRSInt("identidad", rs));
	obj.setCantidad(ResultSetUtils.getRSInt("cantidad", rs));
	obj.setUtilizada(ResultSetUtils.getRSInt("utilizada", rs)); 
	obj.setRestante(ResultSetUtils.getRSInt("restante", rs));   
	obj.setIdconvenio(ResultSetUtils.getRSInt("idconvenio", rs)); 
	obj.setIdregistro(ResultSetUtils.getRSInt("idregistro", rs)); 
	
	
	obj.setNumcliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils
		.getRSString("numcliente", rs)));
	
	obj.setIdservicio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils
		.getRSString("idservicio", rs)));

	
	return obj;
    }

}
