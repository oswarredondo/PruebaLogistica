/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.DocumentoJson;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class DocumentoJsonDTOMapper implements RowMapper<DocumentoJson>{

	/**
	 * 
	 */
	public DocumentoJsonDTOMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DocumentoJson mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DocumentoJson obj  =new DocumentoJson();
		  
		obj.setLogin(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("login",rs)) );
		obj.setFechaevento(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechaevento",rs)) ); 
		obj.setJsondata(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("jsondata",rs)) );  
		obj.setIddocumento(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("iddocumento",rs)) ); 
		
		return obj;
	}

}
