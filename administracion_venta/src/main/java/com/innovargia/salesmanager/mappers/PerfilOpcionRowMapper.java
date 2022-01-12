/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.PerfilOpcionDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class PerfilOpcionRowMapper implements RowMapper<PerfilOpcionDTO>{

	/**
	 * 
	 */
	public PerfilOpcionRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PerfilOpcionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		PerfilOpcionDTO obj = new PerfilOpcionDTO();
		obj.setConsecutivo(ResultSetUtils.getRSInt("consecutivo",rs));
		obj.setIdentidad(ResultSetUtils.getRSInt("identidad",rs));
		obj.setIdorganizacion(ResultSetUtils.getRSInt("idorganizacion",rs));
		obj.setDescripcion_perfil(UtilsStringFechas.convierteCadenaNULLLower(ResultSetUtils.getRSString("descripcion",rs)));
		obj.setIdperfil(UtilsStringFechas.convierteCadenaNULLLower(ResultSetUtils.getRSString("idperfil",rs)));
		obj.setNivel(UtilsStringFechas.convierteCadenaNULLLower(ResultSetUtils.getRSString("nivel",rs)));
		obj.setEstatus(UtilsStringFechas.convierteCadenaNULLLower(ResultSetUtils.getRSString("estatus",rs)));
		
		obj.setDescripcion_modulo(UtilsStringFechas.convierteCadenaNULLLower(ResultSetUtils.getRSString("descripcion",rs)));
		obj.setDescripcion_opcion(UtilsStringFechas.convierteCadenaNULLLower(ResultSetUtils.getRSString("descripcion_opcion",rs)));
		obj.setIdmodulo(UtilsStringFechas.convierteCadenaNULLLower(ResultSetUtils.getRSString("idmodulo",rs))); 
		obj.setIdopcion(UtilsStringFechas.convierteCadenaNULLLower(ResultSetUtils.getRSString("idopcion",rs)));  
		obj.setText(UtilsStringFechas.convierteCadenaNULLLower(ResultSetUtils.getRSString("descripcion_opcion",rs)));
		obj.setIdsistema(ResultSetUtils.getRSString("idsistema",rs));

		obj.setIconCls(UtilsStringFechas.convierteCadenaNULLLower(ResultSetUtils.getRSString("iconcls", rs)));
		obj.setWindowId(UtilsStringFechas.convierteCadenaNULLLower(ResultSetUtils.getRSString("windowid", rs)));
		
	
		obj.setQuickstart(ResultSetUtils.getRSInt("quickstart", rs));
		obj.setShortcut(ResultSetUtils.getRSInt("shortcut", rs));
		
		return obj;
	}

}
