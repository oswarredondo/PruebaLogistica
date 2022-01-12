/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.documentos.dtos.CPs;
import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class FrecuenciaRowMapper implements RowMapper<Frecuencias>{

	/**
	 * 
	 */
	public FrecuenciaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Frecuencias mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Frecuencias frecuencia  =new Frecuencias();
		frecuencia.setCp(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("d_codigo",rs)));  
    	frecuencia.setDescripcionServicio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion",rs))); 
    	frecuencia.setGarantiamax(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("garantiamax",rs))); 
    	frecuencia.setIdterminal(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idterminal",rs))); 
    	frecuencia.setIdagrupador(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idagrupador",rs))); 
    	frecuencia.setZonaventa(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("zonaventa",rs))); 
    	frecuencia.setLunes(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("lunes",rs))); 
    	frecuencia.setMartes(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("martes",rs))); 
    	frecuencia.setMiercoles(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("miercoles",rs))); 
    	frecuencia.setJueves(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("jueves",rs))); 
    	frecuencia.setViernes(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("viernes",rs))); 
    	frecuencia.setSabado(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("sabado",rs))); 
    	frecuencia.setDomingo(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("domingo",rs))); 
     	frecuencia.setReexpedicion_e(ResultSetUtils.getRSInt("reexpedicion_e",rs));  
    	frecuencia.setReexpedicion_r(ResultSetUtils.getRSInt("reexpedicion_r",rs));
    	frecuencia.setRutaEnt(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("ruta",rs))); 
    	frecuencia.setOcurre(ResultSetUtils.getRSInt("ocurre",rs)); 
    	frecuencia.setPeriodicidad(ResultSetUtils.getRSInt("periodicidad",rs));  
    	
    	frecuencia.setComentario(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("observacion",rs)));
    	
    	
    	frecuencia.setMismodia(ResultSetUtils.getRSInt("mismodia",rs));  
    	frecuencia.setZona_extendida(ResultSetUtils.getRSBoolean("zona_extendida", rs) );
    	frecuencia.setZona_fronteriza(ResultSetUtils.getRSBoolean("zona_fronteriza", rs) );
    	

		return frecuencia;
	}

}
