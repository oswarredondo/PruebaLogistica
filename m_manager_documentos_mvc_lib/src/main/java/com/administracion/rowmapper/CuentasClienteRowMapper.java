/**
 * 
 */
package com.administracion.rowmapper;

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
public class CuentasClienteRowMapper implements RowMapper<CuentasDTO>{

	/**
	 * 
	 */
	public CuentasClienteRowMapper() {
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
		
		if (cuenta.getCorreoe()==null || cuenta.getCorreoe().trim().isEmpty()){
			cuenta.setCorreoe(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("correoe", rs)));
		}
		
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

		cuenta.setLogin(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("login", rs)));
		cuenta.setPassword(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("password", rs))); 
		cuenta.setSuscriberid(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("suscriberid", rs)));  
		cuenta.setNumclientearrier(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("numclientearrier", rs)));   

		cuenta.setManejoporfoliosconvenio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("manejoporfoliosconvenio", rs)));   
		cuenta.setIdservicio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idservicio", rs)));   
		cuenta.setIdconvenio(ResultSetUtils.getRSInt("idconvenio", rs));    
		
		cuenta.setPeso_ampara_folio(ResultSetUtils.getRSInt("peso_ampara_folio", rs));    
		cuenta.setIdentidad_default_folio(ResultSetUtils.getRSInt("identidad_default_folio", rs));    
		cuenta.setOrganizacion_default_folio(ResultSetUtils.getRSInt("organizacion_default_folio", rs));    
		
		
		cuenta.setIdserviciocarrier(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idserviciocarrier", rs)) );
		cuenta.setLoginconsultacarrier(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("loginconsultacarrier", rs)));
		cuenta.setPasswordconsultacarrier(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("passwordconsultacarrier", rs)));
		cuenta.setNumclienteconsultacarrier(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("numclienteconsultacarrier", rs)));
		cuenta.setSuscriberidconsultacarrier(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("suscriberidconsultacarrier", rs))); 
		
		cuenta.setEndpoint_creacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("endpoint_creacion", rs)));  
		cuenta.setEndpoint_consulta(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("endpoint_consulta", rs)));
		
		cuenta.setOficina_organizacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("oficina_organizacion", rs))); 

		return cuenta;
	}

}
