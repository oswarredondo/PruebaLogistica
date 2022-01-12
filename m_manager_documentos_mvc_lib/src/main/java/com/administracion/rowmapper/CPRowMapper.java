/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.documentos.dtos.CPs;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class CPRowMapper implements RowMapper<CPs>{

	/**
	 * 
	 */
	public CPRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CPs mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CPs obj  =new CPs();
		obj.setCp(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("d_codigo",rs))); 
		obj.setEstado(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("d_estado",rs))); 
		obj.setMunicipio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("d_mnpio",rs))); 
		obj.setColonia(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("d_asenta",rs))); 
		
		obj.setIdEstado(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("c_estado",rs))); 
		obj.setIdMunicipio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("c_mnpio",rs)));  
		obj.setSiglasEst(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("siglas",rs)));  
		
		obj.setCiudad(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("d_ciudad",rs)));  

		return obj;
	}

}
