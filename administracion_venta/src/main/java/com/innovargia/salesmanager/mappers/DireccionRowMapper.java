/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.DireccionDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class DireccionRowMapper implements RowMapper<DireccionDTO>{

	/**
	 * 
	 */
	public DireccionRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DireccionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		DireccionDTO obj = new DireccionDTO();
		
		
		obj.setIddireccion(ResultSetUtils.getRSInt("iddireccion", rs));
		obj.setIdcliente(ResultSetUtils.getRSInt("idcliente", rs));
		
		obj.setNumcliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numcliente", rs)));
		obj.setDescripcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion", rs)));
		obj.setCp(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cp", rs)));
		obj.setCalle(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("calle", rs)));
		obj.setNuminterior(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numinterior", rs)));
		obj.setNumexterior(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numexterior", rs)));
		obj.setColonia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("colonia", rs)));
		obj.setMunicipio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("municipio", rs)));
		obj.setEstado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estado", rs)));
		obj.setEmail(UtilsStringFechas.changeNULL(ResultSetUtils.getRSString("email", rs)));
		obj.setTelefono(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("telefono", rs)));
		obj.setMovil(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("movil", rs)));
		obj.setDirdefault(ResultSetUtils.getRSInt("dirdefault", rs));
		obj.setRfc(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("rfc", rs)));
		obj.setObservacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("observacion", rs)));
		obj.setClasificacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("clasificacion", rs)));
		
		
		obj.setAtencion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("atencion", rs)));
		obj.setRazonSocial(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("razonsocial", rs)));
		obj.setReferencia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("referencia", rs)));
		
		
		
		return obj;
	}

}
