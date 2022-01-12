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
import com.innovargia.salesmanager.dtos.CajaMovimientos;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class MovimientoCajaDTOMapper implements RowMapper<CajaMovimientos>{

	/**
	 * 
	 */
	public MovimientoCajaDTOMapper() {
		// TODO Auto-generated constructor stub
	}

    @Override
    public CajaMovimientos mapRow(ResultSet rs, int rowNum) throws SQLException {

	CajaMovimientos obj = new CajaMovimientos();

	obj.setObservacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils
		.getRSString("observacion", rs)) );
	
	obj.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils
		.getRSString("descripcion", rs)) );
	
	obj.setFecha(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils
		.getRSString("fecha", rs)) );
	
	obj.setLogin(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils
		.getRSString("login", rs)) );
	
	obj.setIdmovimiento(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils
		.getRSString("idmovimiento", rs)) );
	
	obj.setIdcajamovimiento(ResultSetUtils.getRSInt("idcajamovimiento", rs));  
	obj.setIdcaja(ResultSetUtils.getRSInt("idcaja", rs)); 

	obj.setCantidad(ResultSetUtils.getRSFloat("cantidad", rs));
	

	return obj;
    }

}
