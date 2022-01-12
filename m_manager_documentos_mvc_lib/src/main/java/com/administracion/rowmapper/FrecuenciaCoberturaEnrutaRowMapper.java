/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.rotulacion.dtos.CoberturaEnrutamientoTranladoDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class FrecuenciaCoberturaEnrutaRowMapper implements RowMapper<CoberturaEnrutamientoTranladoDTO>{

	/**
	 * 
	 */
	public FrecuenciaCoberturaEnrutaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CoberturaEnrutamientoTranladoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	    CoberturaEnrutamientoTranladoDTO obj  =new CoberturaEnrutamientoTranladoDTO();
	    
	    Frecuencias frecuencia_origen = new Frecuencias();
	    frecuencia_origen.setCp(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cpori",rs)));  
	    frecuencia_origen.setIdterminal(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idterminalori",rs))); 
	    frecuencia_origen.setIdagrupador(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idagrupadorori",rs))); 
	    frecuencia_origen.setZonaventa(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("zonaventaori",rs))); 
	    
	    Frecuencias frecuencia_destino = new Frecuencias();
	    frecuencia_destino.setCp(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cpdes",rs)));  
	    frecuencia_destino.setIdterminal(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idterminaldes",rs))); 
	    frecuencia_destino.setIdagrupador(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idagrupadordes",rs))); 
	    frecuencia_destino.setZonaventa(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("zonaventades",rs))); 
	    	
	    
	    CruceCoberturaDTO crucecobertura = new CruceCoberturaDTO();
	    crucecobertura.setIdcodestino(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idcodestino", rs)));
	    crucecobertura.setIdcoorigen(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idcoorigen", rs))); 
	    crucecobertura.setKms(ResultSetUtils.getRSFloat("kms", rs));
		
		
	    crucecobertura.setGarantiamax(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("garantiamax", rs))); 
	    crucecobertura.setEnrutamiento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("enrutamiento", rs))); 
	    crucecobertura.setIdservicio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idservicio", rs))); 
	    crucecobertura.setTransbordo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("transbordo", rs))); 
	    crucecobertura.setTransbordo_destino(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("transbordo_destino", rs))); 
		
		
	    crucecobertura.setMismodia(ResultSetUtils.getRSInt("mismodia", rs));
	    crucecobertura.setDias_entrega_origen_destino(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("dias_entre_origen_destino", rs))); 
		
	    crucecobertura.setNivel_reexpedicion_foraneo(ResultSetUtils.getRSInt("nivel_reexpedicion_foraneo", rs));
	    crucecobertura.setDias_entrega_origen_destino(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("dias_entrega_origen_destino", rs)));
	    crucecobertura.setNivel_reexpedicion_foraneo(ResultSetUtils.getRSInt("nivel_reexpedicion_foraneo", rs));
	    crucecobertura.setTerminal_destino_aux(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("terminal_destino_aux", rs)));  
	    crucecobertura.setRutaentrega(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("rutaentrega", rs)));  
 
	    
	    
	    obj.setFrecuencia_origen(frecuencia_origen);
	    obj.setFrecuencia_destino(frecuencia_destino);
	    obj.setCruce_obertura(crucecobertura);
	    
		return obj;
	}

}
