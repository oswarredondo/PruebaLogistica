
package ar.com.unisolutions.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.utils.FechasTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.DocumentoConsultaDTO;

public class DocumentoConsultaDTORowMapper implements RowMapper<DocumentoConsultaDTO>{

	String formatofecha = "dd-MM-yyyy HH:mm:ss";
	public DocumentoConsultaDTORowMapper() {}

	@Override
	public DocumentoConsultaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DocumentoConsultaDTO cartaPorDto  =new DocumentoConsultaDTO();
		  
		  cartaPorDto.setIdDocumento(ResultSetUtils.getRSString("iddocumento", rs));
		  cartaPorDto.setIdDocumentoMadre(ResultSetUtils.getRSString("iddocumentomadre", rs));
		  cartaPorDto.setNumCliente(ResultSetUtils.getRSString("numcliente", rs));
		  cartaPorDto.setReferencia(ResultSetUtils.getRSString("referencia", rs));
		  cartaPorDto.setContenidoDeclarado(ResultSetUtils.getRSString("contenido", rs));
		  cartaPorDto.setFechaCreacion(ResultSetUtils.getRSString("fechacreacion",rs));
		  cartaPorDto.setLogin(ResultSetUtils.getRSString("login", rs));
		  cartaPorDto.setDescripcionError(ResultSetUtils.getRSString("descripcionerror", rs));
		  cartaPorDto.setRazonsocial(ResultSetUtils.getRSString("razonsocial", rs));

		  return cartaPorDto;
	}

}
