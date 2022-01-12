/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.LogMovimientoProcesadoDTO;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class LogMovimientoProcesadoRowMapper implements RowMapper<LogMovimientoProcesadoDTO>{

	/**
	 * 
	 */
	public LogMovimientoProcesadoRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LogMovimientoProcesadoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
	    
	    LogMovimientoProcesadoDTO obj = new LogMovimientoProcesadoDTO();

	    obj.setIdentificador(ResultSetUtils.getRSInt("identificador", rs));
	    obj.setPlazaenvia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("plazaenvia", rs)));
	    obj.setServidor(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("servidor", rs)));
	    obj.setTipoerror( UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tipoerror", rs)));
	    obj.setLlavetransmision( UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("llavetransmision", rs)));

	    obj.setCliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cliente", rs)));
	    obj.setArchivo( UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("archivo", rs)));
	    obj.setTransmitido( UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("transmitido", rs)));
	    obj.setMsgstatus( UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("msgstatus", rs)));
	    obj.setGuia( UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("guia", rs)));
	    obj.setFechaproceso(UtilsStringFechas.convierteCadenaNULL(FechasDateTimeStamp.formatoTimeStamp(ResultSetUtils.getRSTimestamp("fechaproceso", rs), "dd-MM-yyyy hh:mm aaa")));
	    
	    obj.setViaje(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("viaje", rs)));
	    obj.setRuta(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("ruta", rs)));
	    obj.setDepto(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("depto", rs)));
	    
	    obj.setRegistro(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("registro", rs)));
	    
	    //Totales
	    obj.setTop(ResultSetUtils.getRSInt("top", rs));
	    obj.setCantidad(ResultSetUtils.getRSInt("cantidad", rs));
	    
	    obj.setTipomovimiento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tipomovimiento", rs)));
	    
	    if ((obj.getTipomovimiento()==null) || (obj.getTipomovimiento().isEmpty())){
		obj.setTipomovimiento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tiporegistro", rs)));
	    }
	    
	    
	    
	    

	    return obj;
	}

}
