/**
 * 
 */
package com.innovargia.ws.tracking.rest.rowmaps;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.innovargia.ws.tracking.rest.dto.DatosEnvio;
import com.innovargia.ws.tracking.rest.dto.Entrega;
import com.innovargia.ws.tracking.rest.dto.Envio;

/**
 * @author aruaro
 *
 */
public class EnvioRowMapper implements RowMapper<Envio>{

	/**
	 * 
	 */
	public EnvioRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Envio mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Envio obj = new Envio();     
		obj.setIdguia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("iddocumento", rs)));  
		DatosEnvio datosEnvio = new DatosEnvio();   
		
		datosEnvio.setReferencia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("referencia", rs)));   
		datosEnvio.setContenido(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("contenido", rs)));   
		datosEnvio.setObservacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("observacion", rs)));  
		datosEnvio.setAlto(ResultSetUtils.getRSInt("alto", rs) ); 
		datosEnvio.setAncho(ResultSetUtils.getRSInt("ancho", rs) ); 
		datosEnvio.setEmpaque(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tipoempaque", rs))); 
		datosEnvio.setNumeroCliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numcliente", rs)));  
		datosEnvio.setPeso(ResultSetUtils.getRSFloat("pesofisico", rs) );
		datosEnvio.setPlazaDestino(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("zonades", rs))); 
		datosEnvio.setPlazaOrigen(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("zonaori", rs)));  
		datosEnvio.setQuienGenera(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("login", rs))); 
		obj.setDatosEnvio(datosEnvio);
		
		Entrega entrega = new Entrega();
		entrega.setLatitud(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("latitud", rs)));  
		entrega.setLongitud(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("longitud", rs)));
		entrega.setPlaza(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("plsiglasplaza", rs)));
		entrega.setFecha(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cofecha", rs))); 
		entrega.setQuienRecibe(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("conombre", rs)));  
		obj.setEntrega(entrega);

		return obj;
	}

}
