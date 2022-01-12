/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.PlazaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class CruceCoberturaRowMapper implements RowMapper<CruceCoberturaDTO>{

	/**
	 * 
	 */
	public CruceCoberturaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CruceCoberturaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CruceCoberturaDTO obj = new CruceCoberturaDTO();
		obj.setIdcodestino(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idcodestino", rs)));
		obj.setIdcoorigen(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idcoorigen", rs))); 
		obj.setKms(ResultSetUtils.getRSFloat("kms", rs));
		
		return obj;
	}

}
