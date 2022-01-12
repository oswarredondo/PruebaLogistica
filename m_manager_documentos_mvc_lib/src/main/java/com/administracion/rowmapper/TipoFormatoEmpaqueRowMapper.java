/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.TipoEmpaqueFormato;
import com.innovargia.salesmanager.dtos.ServicioDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class TipoFormatoEmpaqueRowMapper implements RowMapper<TipoEmpaqueFormato>{

	/**
	 * 
	 */
	public TipoFormatoEmpaqueRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TipoEmpaqueFormato mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TipoEmpaqueFormato obj = new TipoEmpaqueFormato();
		obj.setAlto(ResultSetUtils.getRSInt("alto", rs)); 
		obj.setAncho(ResultSetUtils.getRSInt("ancho", rs));  
		obj.setLargo(ResultSetUtils.getRSInt("largo", rs));  
		obj.setIdformato(ResultSetUtils.getRSString("idformato", rs));  
		obj.setLargo(ResultSetUtils.getRSInt("largo", rs));  
		obj.setModificacliente(ResultSetUtils.getRSInt("modificacliente", rs));  
		obj.setPeso(ResultSetUtils.getRSInt("peso", rs));  
		obj.setVisiblepdv(ResultSetUtils.getRSInt("visiblepdv", rs));  
		
		
		return obj;
	}

}
