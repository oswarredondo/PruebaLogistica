/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.DetalleVenta;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class DetalleVentaDTOMapper implements RowMapper<DetalleVenta>{

	/**
	 * 
	 */
	public DetalleVentaDTOMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DetalleVenta mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	    DetalleVenta obj  =new DetalleVenta();
	    
	    obj.setDestino(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("destino",rs)));
	    obj.setIdproducto(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idproducto",rs)));
	    obj.setOrigen(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("origen",rs)));
	    
	    
	    obj.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion",rs)));
	
	    obj.setIddetalleventa(ResultSetUtils.getRSInt("iddetalleventa", rs) );  
	    obj.setIdventa(ResultSetUtils.getRSInt("idventa", rs) );  
	    obj.setIdtarifa(ResultSetUtils.getRSInt("idtarifa", rs) );  
	    obj.setIdrangotarifa(ResultSetUtils.getRSInt("idrangotarifa", rs) );  
	    obj.setIdpesotarifa(ResultSetUtils.getRSInt("idpesotarifa", rs) ); 
	    obj.setIdzonatarifa(ResultSetUtils.getRSInt("idzonatarifa", rs) ); 
	   
	    obj.setIdadicional(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idadicional",rs)));

	    
	    obj.setCantidad(ResultSetUtils.getRSInt("cantidad", rs) );  
	    
	    
		obj.setPrecio_unitario(ResultSetUtils.getRSFloat("precio_unitario", rs) ); 
		obj.setDescuento(ResultSetUtils.getRSFloat("descuento", rs) );  
		obj.setPesokg(ResultSetUtils.getRSFloat("pesokg", rs) );  
		obj.setPesovol(ResultSetUtils.getRSFloat("pesovol", rs) );  
		obj.setKm(ResultSetUtils.getRSFloat("km", rs) );  

		  
	
		return obj;
	}

}
