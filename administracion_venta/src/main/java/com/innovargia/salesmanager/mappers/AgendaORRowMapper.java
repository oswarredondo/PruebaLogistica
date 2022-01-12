/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.AgendaOR;
import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class AgendaORRowMapper implements RowMapper<AgendaOR>{

	/**
	 * 
	 */
	public AgendaORRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AgendaOR mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	    AgendaOR obj = new AgendaOR();
	    
	    obj.setFolio(ResultSetUtils.getRSInt("folio", rs) ); 
	    obj.setQuiencaptura(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("quiencaptura", rs)));
	    
	    obj.setFechacaptura(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechacaptura", rs))); 
	    obj.setQuiensolicita(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("quiensolicita", rs))); 
	    obj.setNombresolicita(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("nombresolicita", rs))); 
	    obj.setTelefonosolicita(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("telefonosolicita", rs))); 
	    obj.setIddocumento(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("iddocumento", rs))); 
	    obj.setDatosorigen(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("datosorigen", rs))); 
	    obj.setDatosdestino(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("datosdestino", rs)));  
	    obj.setTipoproblema(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tipoproblema", rs))); 
	    obj.setDepto_que_atiende(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("depto_que_atiende", rs)));  
	    obj.setNombre_quien_atiende(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("nombre_quien_atiende", rs))); 
	    obj.setTiposolucion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tiposolucion", rs))); 
	    obj.setFechacierre(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechacierre", rs))); 
	    obj.setEstatus(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("estatus", rs))); 
	    obj.setComentariocierre(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("comentariocierre", rs))); 
	    obj.setPrioridad(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("prioridad", rs)));  
	    
		return obj;
	}

}
