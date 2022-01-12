/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.CuentasConexionMensajeriaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class CuentasClienteConexionRowMapper implements RowMapper<CuentasConexionMensajeriaDTO>{

	/**
	 * 
	 */
	public CuentasClienteConexionRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CuentasConexionMensajeriaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		
		CuentasConexionMensajeriaDTO cuenta = new CuentasConexionMensajeriaDTO();
		cuenta.setIdregistro(ResultSetUtils.getRSInt("idregistro", rs));     
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
		cuenta.setMensajeria(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("mensajeria", rs))); 
		cuenta.setTemplateGuia(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("templateguia", rs))); 
		//Crea el map de Propiedades
		cuenta.setProperties(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("propiedades", rs))); 
		
		//Ajusta la propiedad de propiedades
		cuenta.setPropiedades(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("propiedades", rs))); 
		return cuenta;
	}

}
