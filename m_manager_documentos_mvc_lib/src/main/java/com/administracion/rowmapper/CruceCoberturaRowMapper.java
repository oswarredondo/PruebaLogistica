/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.PlazaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class CruceCoberturaRowMapper implements RowMapper<CruceCoberturaDTO>{

	/**
	 * 
	 */
	public CruceCoberturaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CruceCoberturaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CruceCoberturaDTO obj = new CruceCoberturaDTO();
		obj.setConvenio((ResultSetUtils.getRSInt("convenio", rs)));
		obj.setIdcodestino(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idcodestino", rs)));
		obj.setIdcoorigen(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idcoorigen", rs))); 
		obj.setKms(ResultSetUtils.getRSFloat("kms", rs));
		
		
		obj.setGarantiamax(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("garantiamax", rs))); 
		obj.setEnrutamiento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("enrutamiento", rs))); 
		obj.setIdservicio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idservicio", rs))); 
		obj.setTransbordo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("transbordo", rs))); 
		obj.setTransbordo_destino(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("transbordo_destino", rs))); 
		
		
		obj.setMismodia(ResultSetUtils.getRSInt("mismodia", rs));
		obj.setDias_entrega_origen_destino(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("dias_entre_origen_destino", rs))); 
		
		obj.setNivel_reexpedicion_foraneo(ResultSetUtils.getRSInt("nivel_reexpedicion_foraneo", rs));
		obj.setDias_entrega_origen_destino(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("dias_entrega_origen_destino", rs)));
		obj.setNivel_reexpedicion_foraneo(ResultSetUtils.getRSInt("nivel_reexpedicion_foraneo", rs));
		obj.setTerminal_destino_aux(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("terminal_destino_aux", rs)));  
		return obj;
	}

}
