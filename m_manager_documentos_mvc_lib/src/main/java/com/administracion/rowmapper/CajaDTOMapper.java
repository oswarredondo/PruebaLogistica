/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.AdicionalDTO;
import com.administracion.dto.VentaDTO;
import com.innovargia.documentos.dtos.CPs;
import com.innovargia.salesmanager.dtos.CajaDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class CajaDTOMapper implements RowMapper<CajaDTO>{

	/**
	 * 
	 */
	public CajaDTOMapper() {
		// TODO Auto-generated constructor stub
	}

    @Override
    public CajaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

	CajaDTO obj = new CajaDTO();

	obj.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils
		.getRSString("descripcion", rs)) );
	obj.setFecha(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils
		.getRSString("fecha", rs)) );
	obj.setIdcajaapercierre(ResultSetUtils.getRSInt("idcajaapercierre", rs));  
	obj.setIdcaja(ResultSetUtils.getRSInt("idcaja", rs)); 
	obj.setIdoficina(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils
		.getRSString("idoficina", rs)) );

	
	

	return obj;
    }

}
