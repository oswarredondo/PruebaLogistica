/**
 * 
 */
package com.administracion.rowmapper;

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
public class AttachmentNotaRowMapper implements RowMapper<AttachmentDTO>{

	/**
	 * 
	 */
	public AttachmentNotaRowMapper() {
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
		obj.setExtension(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("extension", rs))); 
		obj.setFolio(ResultSetUtils.getRSInt("folio", rs));
		
		//Checa la extencion del archivo
		if (obj.getExtension() == null || obj.getExtension().isEmpty()){
			if (obj.getNombre_archivo()!=null){
				String[] part_file = obj.getNombre_archivo().split(".");
				if (part_file.length>1){
					obj.setExtension(part_file[1]);
				}
			}
		}else{
			obj.setExtension(obj.getExtension());
		}
		
		obj.setIdregistro(ResultSetUtils.getRSInt("idregistro", rs));
		obj.setBase64(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("base64", rs))); 
		
		
		return obj;
	}

}
