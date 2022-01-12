/**
 * 
 */
package com.innovargia.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.AgrupamientoDTO;
import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class AgrupamientoRowMapper implements RowMapper<AgrupamientoDTO>{

	/**
	 * 
	 */
	public AgrupamientoRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AgrupamientoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		AgrupamientoDTO obj = new AgrupamientoDTO();
		obj.setIdentificador( ResultSetUtils.getRSInt("identificador", rs)  );
		obj.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion", rs)));
		obj.setIdagrupamiento(ResultSetUtils.getRSInt("idagrupamiento", rs));  
		obj.setVisualizatodo(ResultSetUtils.getRSInt("visualizatodo", rs)); 
		obj.setIdrelacion(ResultSetUtils.getRSString("idrelacion", rs));  
		
		obj.setCreditocobranza(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("creditocobranza", rs)));
		obj.setDirfinanzas(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("dirfinanzas", rs)));
		obj.setGerentecomercial(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("gerentecomercial", rs)));
		obj.setJefezona(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("jefezona", rs)));

		
		return obj;
	}

}
