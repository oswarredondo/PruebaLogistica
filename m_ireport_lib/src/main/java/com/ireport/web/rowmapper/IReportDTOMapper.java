/**
 * 
 */
package com.ireport.web.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.AdicionalDTO;
import com.innovargia.documentos.dtos.CPs;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.ireport.web.dto.IReportDTO;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class IReportDTOMapper implements RowMapper<IReportDTO>{

	/**
	 * 
	 */
	public IReportDTOMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IReportDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		IReportDTO 	obj  = new IReportDTO();
		obj.setIdregistro(ResultSetUtils.getRSInt("idregistro",rs));
		obj.setId(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idrereportejaspert",rs)));
		obj.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion",rs)));
		obj.setNombre(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("nombre",rs)));
		obj.setNivel(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("nivel",rs)));
		obj.setIdconexion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idconexion",rs)));

		
		return obj;
	}

}
