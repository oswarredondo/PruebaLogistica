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
public class FotoRowMapper implements RowMapper<FirmaFoto>{

	/**
	 * 
	 */
	public FotoRowMapper() {
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
		obj.setFoto(nombre);  
		obj.setImaBase64(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("base64", rs)));  
		obj.setLatitud(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("latitud", rs)));  
		obj.setLongitud(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("longitud", rs)));    

		return obj;
	}

}
