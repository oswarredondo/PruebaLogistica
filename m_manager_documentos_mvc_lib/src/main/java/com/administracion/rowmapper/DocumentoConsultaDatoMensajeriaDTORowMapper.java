
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.utils.FechasTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.DocumentoDTO;
import com.servicio.dtos.Zona;

public class DocumentoConsultaDatoMensajeriaDTORowMapper implements RowMapper<DocumentoConsultaDTO>{

	String formatofecha = "dd-MM-yyyy HH:mm:ss";
	public DocumentoConsultaDatoMensajeriaDTORowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DocumentoConsultaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DocumentoConsultaDTO cartaPorDto  =new DocumentoConsultaDTO();
		
		 cartaPorDto.setIdServicio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idservicio", rs)));  
		 cartaPorDto.setEs_nacional(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("es_nacional", rs)));  
		 cartaPorDto.setIdDocumento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("iddocumento", rs)));
		 cartaPorDto.setGuiainternacional(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("guiainternacional", rs)));  
		 cartaPorDto.setCarrierNumber(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("carriernumber",rs)));
		
		  return cartaPorDto;
	}

}
