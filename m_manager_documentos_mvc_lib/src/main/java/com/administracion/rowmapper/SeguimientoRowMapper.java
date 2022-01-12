/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Movimiento;

/**
 * @author aruaro
 *
 */
public class SeguimientoRowMapper implements RowMapper<Movimiento>{

	/**
	 * 
	 */
	public SeguimientoRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Movimiento mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Movimiento obj  =new Movimiento();
		
		obj.setClaveLogistica(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("exclave",rs)));
		obj.setEmpleado(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("empleado",rs)));
		obj.setFecha(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechaevento",rs)));
		obj.setGuia(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idguia",rs)));
		obj.setOrigenRegistro(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("ceorigenregistro",rs)));
		obj.setRuta(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("ruta",rs)));
		obj.setSiglasPlaza(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("plsiglasplaza",rs)));
		obj.setTipoRegistro(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tiregistro",rs)));
		obj.setTiDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("registrodescripcion",rs)));
		obj.setDescripcionclave(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcionexcepcion",rs)));
		
		
		obj.setIdsolicitud(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idsolicitud",rs)));
		obj.setQuienrechaza(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("quienrechaza",rs)));
		obj.setMotivo(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("motivo",rs)));

		return obj;
	}

}
