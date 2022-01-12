/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.innovargia.salesmanager.dtos.ClientesDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class ClientesRowMapper implements RowMapper<ClientesDTO>{

	/**
	 * 
	 */
	public ClientesRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ClientesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClientesDTO obj = new ClientesDTO();
		obj.setIdcliente(ResultSetUtils.getRSInt("idcliente", rs));
		obj.setIdgrupo(ResultSetUtils.getRSInt("idgrupo", rs));
		
		
		obj.setClasificacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("clasificacion", rs)));
		obj.setNumcliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numcliente", rs)));
		obj.setDescripcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion", rs)));
		obj.setReferencia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("referencia", rs)));
		obj.setRfc(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("rfc", rs)));
		obj.setCuentabancaria(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cuentabancaria", rs)));
		obj.setObservacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("observacion", rs)));
		obj.setRazonsocial(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("razonsocial", rs)));
		obj.setLogincreador(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("logincreador", rs)));

		obj.setEstatus(ResultSetUtils.getRSInt("estatus", rs));
		
		obj.setCreditolimite(ResultSetUtils.getRSInt("creditolimite", rs));
		obj.setCreditousado(ResultSetUtils.getRSInt("creditousado", rs));
		obj.setIdformapago(ResultSetUtils.getRSInt("idformapago", rs));
		obj.setIdterminopago(ResultSetUtils.getRSInt("idterminopago", rs)); //Termino de pago catalogo???
		obj.setIdrepventas(ResultSetUtils.getRSInt("idrepventas", rs));//Termino de pago catalogo??? es caUsuario?
		obj.setIdimpuesto(ResultSetUtils.getRSInt("idimpuesto", rs));//Termino de pago catalogo???
		obj.setIddireccion(ResultSetUtils.getRSInt("iddireccion", rs));
		
		obj.setIdplaza(ResultSetUtils.getRSInt("idplaza", rs));//Termino de pago catalogo???
		obj.setIdprogramafactura(ResultSetUtils.getRSInt("idprogramafactura", rs));//Termino de pago catalogo???
		obj.setTipo(ResultSetUtils.getRSInt("tipo", rs));
		obj.setRegimen(ResultSetUtils.getRSInt("regimen", rs));//Termino de pago catalogo???
		obj.setTipopersona(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tipopersona", rs))); 
		
		obj.setTipocliente(ResultSetUtils.getRSInt("tipocliente", rs)); 
		
		//TODO: Estas columnas sales de alguna vsita que relaciona la informacion
		//obj.setDescripcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numcliente", rs)));
		obj.setDescripcionFormapago(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionFormapago", rs)));
		obj.setDescripcionImpuesto(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionImpuesto", rs)));
		obj.setDescripcionPlaza(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionPlaza", rs)));
		obj.setDescripcionPoblacionpago(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionPoblacionpago", rs)));
		obj.setDescripcionProgramaFactura(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionProgramaFactura", rs)));
		obj.setDescripcionRegimen(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionRegimen", rs)));
		obj.setDescripcionRepresentanteVentas(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionRepresentanteVentas", rs)));
		obj.setDescripcionTerminoPago(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionTerminoPago", rs)));
		
		obj.setDescripcionGrupoCliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionGrupoCliente", rs)));
		obj.setClavegrupo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("clavegrupo", rs)));		
		
		
		
		
		
		
		return obj;
	}

}
