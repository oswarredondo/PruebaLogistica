/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.TarifaAdicionalDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class TarifaAdicionalRowMapper implements RowMapper<TarifaAdicionalDTO>{

	/**
	 * 
	 */
	public TarifaAdicionalRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TarifaAdicionalDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TarifaAdicionalDTO obj = new TarifaAdicionalDTO();
		
		obj.setIdtarifa(ResultSetUtils.getRSInt("idtarifa", rs) );
		obj.setIdconvenio(ResultSetUtils.getRSInt("idconvenio", rs) );
		obj.setIdadicionaldetalle(ResultSetUtils.getRSInt("idadicionaldetalle", rs) );
		obj.setIdadicional(ResultSetUtils.getRSInt("idadicional", rs) );
		
		obj.setDescuento(ResultSetUtils.getRSFloat("descuento", rs) ); 
		obj.setClaveadicional(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("claveadicional", rs)));
		obj.setPrecio(ResultSetUtils.getRSFloat("precio", rs) ); 
		obj.setDescripcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion", rs)));
		obj.setEstatus(ResultSetUtils.getRSInt("estatus", rs) );
		obj.setTipoincremento(ResultSetUtils.getRSInt("tipoincremento", rs) );
		
		// TODO Auto-generated method stub
		return obj;
	}

}
