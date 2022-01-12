/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.ContactoDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class ContactoRowMapper implements RowMapper<ContactoDTO>{

	/**
	 * 
	 */
	public ContactoRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ContactoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ContactoDTO obj = new ContactoDTO();
		obj.setIdcliente(ResultSetUtils.getRSInt("idcliente", rs));
		obj.setIdcontacto(ResultSetUtils.getRSInt("idcontacto", rs));
		obj.setUtilizadircliente(ResultSetUtils.getRSInt("utilizadircliente", rs));
		
		obj.setNombre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombre", rs)));
		obj.setApellido(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("apellido", rs)));
		obj.setEmail(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("email", rs)));
		obj.setTelefono(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("telefono", rs)));
		obj.setTelefono2(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("telefono2", rs)));
		obj.setMovil(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("movil", rs)));
		obj.setExtencion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("extencion", rs))); 
		
		obj.setPuesto(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("puesto", rs)));
		obj.setComentario(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("comentario", rs)));
		obj.setClasificacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("clasificacion", rs)));
		
		return obj;
	}

}
