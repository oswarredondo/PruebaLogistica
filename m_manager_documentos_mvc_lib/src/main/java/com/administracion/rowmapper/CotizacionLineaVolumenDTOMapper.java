/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.CotizacionLineaVolumen;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class CotizacionLineaVolumenDTOMapper implements RowMapper<CotizacionLineaVolumen>{

	/**
	 * 
	 */
	public CotizacionLineaVolumenDTOMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CotizacionLineaVolumen mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	    CotizacionLineaVolumen obj  =new CotizacionLineaVolumen();
	    obj.setIdcotizacionlinea_volumne(ResultSetUtils.getRSInt("idcotizacionlinea_volumne", rs) );
	    obj.setIdcotizacionlinea(ResultSetUtils.getRSInt("idcotizacionlinea", rs) ); 
	    obj.setIdconvenio(ResultSetUtils.getRSInt("idconvenio", rs) );   
	    obj.setIdcotizacionlinea(ResultSetUtils.getRSInt("idcotizacionlinea", rs) );    
	    
	 
	    obj.setIdconveniodetalle(ResultSetUtils.getRSInt("idcotizacionlinea", rs) );
	    obj.setIdrangotarifa(ResultSetUtils.getRSInt("idcotizacionlinea", rs)); 
	    obj.setIdpesotarifa(ResultSetUtils.getRSInt("idpesotarifa", rs)); 
	    obj.setIdzonatarifa(ResultSetUtils.getRSInt("idzonatarifa", rs)); 
	    obj.setCantidad(ResultSetUtils.getRSInt("cantidad", rs) ); 
	    obj.setValordeclarado(ResultSetUtils.getRSFloat("valordeclarado", rs) );  
	    obj.setPeso(ResultSetUtils.getRSFloat("peso", rs) );  
	    obj.setAlto(ResultSetUtils.getRSInt("alto", rs) ); 
	    obj.setAncho(ResultSetUtils.getRSInt("ancho", rs)); 
	    obj.setLargo(ResultSetUtils.getRSInt("largo", rs));	    
	    obj.setVolumen(ResultSetUtils.getRSFloat("volumen", rs) );
	    
	    obj.setVolumenamparado(ResultSetUtils.getRSFloat("volumenamparado", rs) );
	    obj.setPesoamparado(ResultSetUtils.getRSFloat("pesoamparado", rs) );
	    
	    obj.setPrecio_unitario(ResultSetUtils.getRSFloat("precio_unitario", rs)  );
	    obj.setPrecio_adicional_requerido(ResultSetUtils.getRSFloat("precio_adicional_requerido", rs) ); 
	    obj.setPrecio_adicional_servicio(ResultSetUtils.getRSFloat("precio_adicional_servicio", rs) ); 
	    
	   
	    obj.setTiene_seguro(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tiene_seguro",rs)));
	    obj.setValor_asegurado(ResultSetUtils.getRSFloat("valor_asegurado", rs) ); 
	    obj.setFactura(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("factura",rs)));
	    obj.setContenido(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("contenido",rs)));
	    obj.setReferencia(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("referencia",rs)));
	    obj.setTiene_retorno(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tiene_retorno",rs)));
	    obj.setEs_ocurre(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("es_ocurre",rs)));
	    obj.setEs_multiple(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("es_multiple",rs)));
	    obj.setEs_cod(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("es_cod",rs))); 
	    obj.setTipoempaque(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tipoempaque",rs)));
	    obj.setObservacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("observacion",rs)));
	    
	    obj.setValor_a_cobrar_cod(ResultSetUtils.getRSFloat("valor_a_cobrar_cod", rs) ); 
		  
	    obj.setTotal(obj.getPrecio_unitario() * obj.getCantidad());
	    
	  
		return obj;
	}

}
