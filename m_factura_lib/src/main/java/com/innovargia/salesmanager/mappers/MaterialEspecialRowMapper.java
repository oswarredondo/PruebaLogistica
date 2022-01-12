/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.Factura;
import com.innovargia.administracion.dto.LineaFacturaSAP;
import com.innovargia.administracion.dto.MaterialEspecialFactura;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.utils.Fechas;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class MaterialEspecialRowMapper implements RowMapper<MaterialEspecialFactura>{

	/**
	 * 
	 */
	public MaterialEspecialRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public MaterialEspecialFactura mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MaterialEspecialFactura obj = new MaterialEspecialFactura();

		obj.setIdmaterial(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idmaterial", rs)) );
		obj.setDescripcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion", rs)) );
		obj.setNombre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombre", rs)) );
		obj.setObservacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("observacion", rs)) );
		
		obj.setIdcontrol(ResultSetUtils.getRSInt("idcontrol", rs)  );
		obj.setIdregistro(ResultSetUtils.getRSInt("idregistro", rs)  );
		obj.setPrecio(ResultSetUtils.getRSFloat("precio", rs));
		obj.setCantidad(ResultSetUtils.getRSInt("cantidad", rs) );
	
		return obj;
	}

}
