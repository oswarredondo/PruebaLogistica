/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class SistemaRowMapper implements RowMapper<SistemaDTO>{

	/**
	 * 
	 */
	public SistemaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SistemaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SistemaDTO sistema = new SistemaDTO();
		sistema.setIdSistema(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("IdSistema",rs)));
		sistema.setPathImagenReportes(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("PathImaReportes",rs)));
		sistema.setPathImagenGeneral(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("PathImaGeneral",rs)));
		sistema.setPathImagenManifiestos(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("PathImaManif",rs)));
		sistema.setPathDocsPDFs(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("PathDocsPDFs",rs)));
		sistema.setNumCliente(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("NumCliente",rs)));
		
		sistema.setValor(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("valor",rs)));
		sistema.setIdpropertie(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idpropertie",rs)));
		
		
		
		return sistema;
	}

}
