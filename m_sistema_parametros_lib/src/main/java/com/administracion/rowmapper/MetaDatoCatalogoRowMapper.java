/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class MetaDatoCatalogoRowMapper implements RowMapper<MetaDatoCatalogoDTO>{

	/**
	 * 
	 */
	public MetaDatoCatalogoRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MetaDatoCatalogoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		 MetaDatoCatalogoDTO meta = new MetaDatoCatalogoDTO();
		 meta.setNombre(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion",rs))); 
         meta.setFormatoiReport(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("formatoireport",rs))); 
         meta.setIdTipoDocumento(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idtipodocumento",rs)));  
         meta.setTabla(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tablaconsecutivo",rs)));  
         meta.setLargoConsecutivo(ResultSetUtils.getRSInt("LargoConsecutivo",rs)); 
         
		
		return meta;
	}

}
