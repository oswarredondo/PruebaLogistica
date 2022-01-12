/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.innovargia.salesmanager.dtos.ClientesDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class ClientesRFCsRowMapper implements RowMapper<RemDes>{

	/**
	 * 
	 */
	public ClientesRFCsRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public RemDes mapRow(ResultSet rs, int rowNum) throws SQLException {
		RemDes obj = new RemDes();
		
		obj.setIdAutonumerico(ResultSetUtils.getRSInt("identificador", rs));
		obj.setRfc(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("rfc", rs)));
		obj.setNumCliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numcliente", rs)));
		obj.setRazonSocial(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("razonSocial", rs)));
		obj.setAtencion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("atencion", rs)));
		
		obj.setCalle(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("calle", rs)));
		obj.setNuminterior(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numinterior", rs)));
		obj.setNumexterior(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numexterior", rs)));
		obj.setColonia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("colonia", rs)));
		obj.setMunicipio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("municipio", rs)));
	
		obj.setEstado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estado", rs)));
		obj.setCiudad(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("ciudad", rs)));
		obj.setCp(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cp", rs)));	
		obj.setTelefono(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("telefono", rs)));	
		obj.setNumcelular(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numcelular", rs)));	 
		obj.setExtencion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("extencion", rs)));	   
		obj.setMovil(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("movil", rs)));	    
		
		obj.setCorreoe(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("correoe", rs)));	    
		obj.setRotula(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("rotula", rs)));	   
		obj.setEstatus_int(ResultSetUtils.getRSInt("estatus", rs));	   
		
		return obj;
	}

}
