/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class LogHistorialRowMapper implements RowMapper<LogHistoriaDTO>{

	/**
	 * 
	 */
	public LogHistorialRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LogHistoriaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		LogHistoriaDTO obj = new LogHistoriaDTO();

		
		obj.setNumeconomico(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numeconomico", rs))); 
		obj.setCincho(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cincho", rs)));  
		obj.setDeptodestino(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("deptodestino", rs)));   
		
		
		obj.setIdenvio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idguia", rs)));   
		obj.setPlazaorigina(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("plsiglasplaza", rs)));   
		obj.setRuta(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("ruta", rs))); 
		obj.setViaje(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("viaje", rs))); 
		obj.setEmpleado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("empleado", rs)));  
		obj.setManifiesto(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("manifiesto", rs)));   
		obj.setExclave(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("exclave", rs)));   
		obj.setFecha(UtilsStringFechas.convierteCadenaNULL(FechasDateTimeStamp.formatoTimeStamp(ResultSetUtils.getRSTimestamp("fechaevento", rs), "dd-MM-yyyy hh:mm aaa")));
		
		obj.setFechaManifiesto(UtilsStringFechas.convierteCadenaNULL(FechasDateTimeStamp.formatoTimeStamp(ResultSetUtils.getRSTimestamp("fechamanifestado", rs), "dd-MM-yyyy hh:mm aaa")));
		obj.setMonto(ResultSetUtils.getRSFloat("monto", rs));
		obj.setIdregistro(ResultSetUtils.getRSInt("idregistro", rs));
		obj.setCantidad(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cantidad", rs)));
		obj.setIddocumentomadre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("iddocumentomadre", rs)));
		
		/*Cambio RUTA MANIFIESTO 06/10/2020*/
		obj.setEstado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estado", rs)));
		obj.setCiudad(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("ciudad", rs)));
		obj.setCalle(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("calle", rs)));
		obj.setColonia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("colonia", rs)));
		obj.setMunicipio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("municipio", rs)));
		obj.setNuminterior(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numinterior", rs)));
		obj.setNumexterior(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numexterior", rs)));
		obj.setCp(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cp", rs)));
		
		return obj;

	}
	
	

}
