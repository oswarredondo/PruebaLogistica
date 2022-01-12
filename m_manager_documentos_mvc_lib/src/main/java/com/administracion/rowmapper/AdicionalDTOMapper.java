/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.AdicionalDTO;
import com.innovargia.documentos.dtos.CPs;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class AdicionalDTOMapper implements RowMapper<AdicionalDTO>{

	/**
	 * 
	 */
	public AdicionalDTOMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public AdicionalDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		AdicionalDTO obj  =new AdicionalDTO();
		  
		obj.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion",rs)));
		obj.setUuid(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("uuid",rs)));  
		obj.setFechacreacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechacreacion",rs)));
		
		obj.setDescuento(ResultSetUtils.getRSFloat("descuento", rs) );  
//		obj.setIdadicional(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idadicional", rs))); 
		obj.setIdadicional(ResultSetUtils.getRSInt("idadicional", rs) );  
		obj.setIdadicionaldetalle(ResultSetUtils.getRSInt("idadicionaldetalle", rs) );   
		obj.setIddregistrodatos(ResultSetUtils.getRSInt("iddregistrodatos", rs) );    
		obj.setIdentificador(ResultSetUtils.getRSInt("identificador", rs) );
		obj.setIdregistro(ResultSetUtils.getRSInt("idregistro", rs) ); 
		obj.setIdregistroadicional(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idregistroadicional", rs) )); 
		obj.setTipo(ResultSetUtils.getRSInt("tipo", rs) ); 
		obj.setTipoincremento(ResultSetUtils.getRSInt("tipoincremento", rs) );  
		obj.setPrecio(ResultSetUtils.getRSFloat("precio", rs) );  
		
		return obj;
	}

}
