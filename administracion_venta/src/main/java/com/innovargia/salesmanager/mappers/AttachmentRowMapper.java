/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class AttachmentRowMapper implements RowMapper<AttachmentDTO>{

	/**
	 * 
	 */
	public AttachmentRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AttachmentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		AttachmentDTO obj = new AttachmentDTO();
		obj.setIdentificador(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("identificador", rs)));
		obj.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion", rs))); 
		obj.setFecha(UtilsStringFechas.convierteCadenaNULL(FechasDateTimeStamp.formatoTimeStamp(ResultSetUtils.getRSTimestamp("fecha", rs), "dd-MM-yyyy hh:mm aaa")));
		obj.setIdtipodocumento(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idtipodocumento", rs))); 
		obj.setLogin(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("login", rs))); 
		obj.setNombre_archivo(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("nombre_archivo", rs)));
		
		obj.setIdentidad(ResultSetUtils.getRSInt("identidad", rs) );
		obj.setIdorganizacion(ResultSetUtils.getRSInt("idorganizacion", rs) );
		
		return obj;
	}

}
