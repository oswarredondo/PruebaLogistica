/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.Factura;
import com.administracion.dto.FacturaDetalle;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.utils.Fechas;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class FacturaResumenDetalleRowMapper implements RowMapper<FacturaDetalle>{

	/**
	 * 
	 */
	public FacturaResumenDetalleRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public FacturaDetalle mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		FacturaDetalle obj = new FacturaDetalle();

		obj.setIdfactura(ResultSetUtils.getRSInt("idfactura", rs));
		obj.setIdconvenio(ResultSetUtils.getRSInt("idconvenio", rs));
		obj.setCantidad(ResultSetUtils.getRSInt("cantidad", rs));
		obj.setPrecio(ResultSetUtils.getRSFloat("precio", rs));
		obj.setNumcliente(ResultSetUtils.getRSString("numcliente", rs));
				
		
		return obj;
	}

}
