/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.AdicionalDTO;
import com.administracion.notificacionemail.dto.NotificacionEmailDTO;
import com.innovargia.documentos.dtos.CPs;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class PlantillaNotificacionDTOMapper implements RowMapper<NotificacionEmailDTO>{

	/**
	 * 
	 */
	public PlantillaNotificacionDTOMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public NotificacionEmailDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		NotificacionEmailDTO obj  =new NotificacionEmailDTO();
		obj.setMomento_notificacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("momento_notificacion",rs)) );
		obj.setNotifica_rem_confirmacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("notifica_rem_confirmacion",rs) ));
		obj.setNumcliente(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("numcliente",rs)) );
		obj.setPlatilla_notificacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("platilla_notificacion",rs)));
		obj.setTipo_notificacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tipo_notificacion",rs)));
		
		obj.setSubject(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("subject",rs))); 
		obj.setEmaill_from(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("emaill_from",rs))); 
		
		
		
		return obj;
	}

}
