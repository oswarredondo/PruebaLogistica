/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.DireccionIndicadorCita;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class DireccionIndicadorCitaRowMapper implements RowMapper<DireccionIndicadorCita>{

	/**
	 * 
	 */
	public DireccionIndicadorCitaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DireccionIndicadorCita mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DireccionIndicadorCita remDes = new DireccionIndicadorCita();
		remDes.setIdentidad(ResultSetUtils.getRSInt("identidad",rs) );
		remDes.setIdorganizacion(ResultSetUtils.getRSInt("idorganizacion",rs) );
		remDes.setNumCliente(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("numcliente",rs))); 
		remDes.setRazonSocial(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion1",rs))); 
		remDes.setIdRmDes(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("customer",rs))); 
		remDes.setCiudad(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("poblacion",rs))); 
		remDes.setMunicipio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("poblacion",rs))); 
		
		
		remDes.setRuta(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("ruta",rs))); 
		remDes.setTypo(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("typo",rs))); 
		remDes.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion",rs))); 
		remDes.setPoblacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("poblacion",rs))); 
		remDes.setCustomer(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("customer",rs))); 
		remDes.setDescripcion1(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion1",rs))); 
		remDes.setTerr(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("terr",rs))); 
		remDes.setEjecutivocuenta(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("ejecutivocuenta",rs))); 
		remDes.setTelmovilejecutivocuenta(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("telmovilejecutivocuenta",rs))); 
		remDes.setGerente(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("gerente",rs))); 
		remDes.setTelmovilgerente(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("telmovilgerente",rs))); 
		remDes.setPropietariocuenta(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("propietariocuenta",rs))); 
				
		remDes.setTelmovilpropietario(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("telmovilpropietario",rs))); 
		remDes.setNextel(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("nextel",rs))); 
		remDes.setObservacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("obervacion",rs))); 
		remDes.setTelefonocliente(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("telefonocliente",rs))); 
		remDes.setFecuencia(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fecuencia",rs))); 
		remDes.setDiasentrega(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("diasentrega",rs))); 
		remDes.setDiasdefactura(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("diasdefactura",rs))); 
		remDes.setDiasentregalinea1(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("diasentregalinea1",rs))); 
		remDes.setRddcliente(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("rddcliente",rs))); 
		remDes.setMad(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("mad",rs))); 
		remDes.setTtxdockcte(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("ttxdockcte",rs))); 
		remDes.setSalidaslinea1(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("salidaslinea1",rs))) ;
		
		remDes.setEstado(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("estado",rs))); 
		remDes.setOpcionxd(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("opcionxd",rs))); 
		remDes.setCp(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cp",rs))); 
		remDes.setIndicadorcita(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("indicadorcita",rs))); 
		remDes.setRuta1(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("ruta1",rs))); 
		return remDes;
	}

}
