/**
 * 
 */
package com.innovargia.ws.tracking.rest.rowmaps;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.innovargia.ws.tracking.rest.dto.FirmaFoto;

/**
 * @author aruaro
 *
 */
public class FirmaRowMapper implements RowMapper<FirmaFoto>{

	/**
	 * 
	 */
	public FirmaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public FirmaFoto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		FirmaFoto obj = new FirmaFoto();
		String nombre  = UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombre_archivo", rs));
		
		if (nombre!=null){
			String[] ext = nombre.split(".");
			if (ext.length>1){
				obj.setExt(ext[1]);  
			}
		}
		obj.setIdfirma(nombre);  
		
		String base64 = ResultSetUtils.getRSString("base64", rs);
		obj.setImaBase64(base64);  
		obj.setLatitud(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("latitud", rs)));  
		obj.setLongitud(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("longitud", rs)));    

		return obj;
	}

}
