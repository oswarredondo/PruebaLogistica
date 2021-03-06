/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class CatalogoRegistroRowMapper implements RowMapper<CatalogoDTO>{

	/**
	 * 
	 */
	public CatalogoRegistroRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CatalogoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CatalogoDTO obj = new CatalogoDTO();
		obj.setIdentificador(ResultSetUtils.getRSInt("identificador", rs));
		obj.setClave(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("clave", rs)));
		obj.setDescripcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion", rs)));
		obj.setNombre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombre", rs)));
		obj.setEstatus(ResultSetUtils.getRSInt("estatus", rs));
		obj.setPrecio(ResultSetUtils.getRSFloat("precio", rs));
		
		obj.setTipo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tipo", rs)));
		obj.setTipoincremento(ResultSetUtils.getRSInt("tipoincremento", rs));
		
		obj.setImputable(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("imputable", rs)));
		
		obj.setIdtipo(ResultSetUtils.getRSInt("idtipo", rs));
		obj.setTipomovimiento(ResultSetUtils.getRSInt("tipomovimiento", rs)); 

		
		return obj;
	}

}
