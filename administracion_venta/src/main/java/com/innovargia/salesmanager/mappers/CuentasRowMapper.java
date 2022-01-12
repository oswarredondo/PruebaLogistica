/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class CuentasRowMapper implements RowMapper<CuentasDTO>{

	/**
	 * 
	 */
	public CuentasRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CuentasDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		CuentasDTO cuenta = new CuentasDTO();
		cuenta.setIdentificador(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("identificador", rs))); 
		cuenta.setIdentidad(ResultSetUtils.getRSInt("identidad", rs));
		cuenta.setIdorganizacion(ResultSetUtils.getRSInt("idorganizacion", rs));
		cuenta.setTipofolio(ResultSetUtils.getRSInt("tipofolio", rs));
		cuenta.setNumCliente(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("numcliente", rs)));
		cuenta.setRazonSocial(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("razonsocial", rs)));
		cuenta.setAtencion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("atencion", rs)));
		cuenta.setCalle(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("calle", rs)));
		cuenta.setColonia(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("colonia", rs)));
		cuenta.setMunicipio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("municipio", rs)));
		cuenta.setCiudad(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("ciudad", rs)));
		cuenta.setCp(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cp", rs)));
		cuenta.setTelefono(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("telefono", rs)));
		cuenta.setFax(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fax", rs)));
		cuenta.setCorreoe(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("email", rs)));
		cuenta.setDepto(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("depto", rs)));
		cuenta.setEstado(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("estado", rs)));
		cuenta.setContrato(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("contrato", rs))); 
		cuenta.setCuentaMaestra(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cuentamaestra", rs)));  
		cuenta.setCveUnica(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cveunica", rs)));   
		cuenta.setTipoCliente(ResultSetUtils.getRSInt("tipoCliente", rs));    
		
		String estatus_str = UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("estatus", rs));
		boolean estatus = (estatus_str==null) || (!"A".equals(estatus_str))?false:true;
		cuenta.setEstatus(estatus); 
		
		cuenta.setObservacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("observacion", rs)));
		cuenta.setRfc(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("rfc", rs)));
		cuenta.setVertodasdirecciones(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("vertodasdirecciones", rs)));


		
		return cuenta;
	}

}
