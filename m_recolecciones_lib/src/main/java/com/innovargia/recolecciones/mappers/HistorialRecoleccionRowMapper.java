/**
 * 
 */
package com.innovargia.recolecciones.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Movimiento;

/**
 * @author aruaro
 *
 */
public class HistorialRecoleccionRowMapper implements RowMapper<Movimiento>{

	/**
	 * 
	 */
	public HistorialRecoleccionRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Movimiento mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Movimiento movimiento = new Movimiento();
    	movimiento.setTipoRegistro(ResultSetUtils.getRSString("tipomovimiento", rs) );
    	movimiento.setIdsolicitud(ResultSetUtils.getRSString("idsolicitud", rs) );
    	movimiento.setFecha(ResultSetUtils.getRSString("fecha", rs) );
    	movimiento.setClaveLogistica(ResultSetUtils.getRSString("claveexc", rs) );
    	movimiento.setRuta(ResultSetUtils.getRSString("ruta", rs) ); 
    	movimiento.setEmpleado(ResultSetUtils.getRSString("empleado", rs) );            	
    	movimiento.setQuienrechaza(ResultSetUtils.getRSString("quienrechaza", rs) );            
    	movimiento.setMotivo(ResultSetUtils.getRSString("motivo", rs) ); 
    	movimiento.setTiDescripcion(ResultSetUtils.getRSString("descripcion", rs) );
    	if ((movimiento.getTiDescripcion()==null) || (movimiento.getTiDescripcion().trim().length()<=0)){
    		movimiento.setTiDescripcion(movimiento.getTipoRegistro());
    	}

		return movimiento;
	}

}
