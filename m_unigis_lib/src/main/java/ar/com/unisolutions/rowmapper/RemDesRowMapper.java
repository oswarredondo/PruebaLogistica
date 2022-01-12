/**
 * 
 */
package ar.com.unisolutions.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class RemDesRowMapper implements RowMapper<RemDes>{

	/**
	 * 
	 */
	public RemDesRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public RemDes mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		RemDes obj  =new RemDes();
		
		obj.setContrato(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("contrato",rs))); 
		obj.setIdcliente(ResultSetUtils.getRSInt("idcliente", rs) );
		obj.setIdDocumentoPadre(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("iddocumentopadre",rs))); 
		obj.setIdregistro(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idregistro",rs)));
		
		obj.setNumCliente(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("numcliente",rs)));   
		obj.setRazonSocial(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("razonsocial",rs)));  
		obj.setAtencion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("atencion",rs)));     
		obj.setCalle(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("direccion",rs)));       
		obj.setDireccion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("calle",rs))); 
		obj.setColonia(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("colonia",rs))); 
		obj.setMunicipio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("municipio",rs))); 
		obj.setEstado(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("estado",rs))); 
		obj.setCiudad(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("ciudad",rs))); 
		obj.setCp(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cp",rs))); 
		obj.setTelefono(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("telefono",rs))); 
		obj.setRfc(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("rfc",rs))); 
		obj.setCorreoe(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("email",rs))); 
		if ((obj.getCorreoe()==null) || (obj.getCorreoe().trim().length()<=0)){
			obj.setCorreoe(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("correoe",rs)));  
		}
		
		
		obj.setEncargado(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("encargado",rs))); 
		obj.setNuminterior(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("numinterior",rs))); 
		obj.setNumexterior(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("numexterior",rs))); 
		obj.setNumcelular(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("numcelular",rs)));  
		if ((obj.getNumcelular()==null) || (obj.getNumcelular().trim().length()<=0)){
			obj.setNumcelular(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("celular",rs)));  
		}
		obj.setTipoDireccion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tipodireccion",rs)));   
		

		obj.setDepto(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("departamento",rs)));
		
		obj.setLatitud(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("latitud",rs))); 
		obj.setLongitud(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("longitud",rs)));
		
		/* CAMBIO UNIGIS PARA IDREMDES */
		obj.setIdRmDes(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idremdes",rs)));
		
		return obj;
	}

}
