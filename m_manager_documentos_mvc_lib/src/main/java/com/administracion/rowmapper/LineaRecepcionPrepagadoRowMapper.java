
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.CotizacionLineaDireccion;
import com.administracion.dto.LineaRecepcionPrepagado;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.utils.ArrayElementos;
import com.innovargia.utils.UtilsCalculoPesos;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.constantes.ConstantesGenerales;

public class LineaRecepcionPrepagadoRowMapper implements RowMapper<LineaRecepcionPrepagado>{

	String formatofecha = "dd-MM-yyyy HH:mm:ss";
	public LineaRecepcionPrepagadoRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LineaRecepcionPrepagado mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	    LineaRecepcionPrepagado obj  =new 	    LineaRecepcionPrepagado();
	    obj.setRazonsocial_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("razonsocial_rem",rs)));
	    obj.setCobro_reexpedicion(ResultSetUtils.getRSFloat("cobro_reexpedicion",rs) ); 
	    obj.setCobro_sobrepeso(ResultSetUtils.getRSFloat("cobro_sobrepeso",rs) ); 
	    obj.setIddocumento(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("iddocumento",rs)));  
	    obj.setRazonsocial_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("razonsocial_des",rs)));
	    obj.setTotal_cobro(obj.getCobro_reexpedicion() +obj.getCobro_sobrepeso() );
		
	    obj.setPeso(ResultSetUtils.getRSFloat("peso", rs) );  
	    obj.setAlto(ResultSetUtils.getRSInt("alto", rs) ); 
	    obj.setAncho(ResultSetUtils.getRSInt("ancho", rs)); 
	    obj.setLargo(ResultSetUtils.getRSInt("largo", rs));	    
	    //obj.setVolumen(ResultSetUtils.getRSFloat("volumen", rs) );	
	    
	    obj.setVolumenamparado(ResultSetUtils.getRSFloat("volumenamparado", rs) );
	    obj.setPesoamparado(ResultSetUtils.getRSFloat("pesoamparado", rs) );
	    
	    
	    obj.setVolumen(UtilsCalculoPesos.pesoVolumetrico(
		    obj.getAlto(), 
		    obj.getAncho(), 
		    obj.getLargo(), 
		    ConstantesGenerales.DEMONIMADOR_CALCULO_PESO_VOLUMEN));
	    
	    
	    obj.setPeso_original(ResultSetUtils.getRSFloat("peso_original", rs) );  
	    obj.setAlto_original(ResultSetUtils.getRSInt("alto_original", rs) ); 
	    obj.setAncho_original(ResultSetUtils.getRSInt("ancho_original", rs)); 
	    obj.setLargo_original(ResultSetUtils.getRSInt("largo_original", rs));	    
	    //obj.setVolumen_original(ResultSetUtils.getRSFloat("volumen_original", rs) );
	    
	    obj.setVolumen_original(UtilsCalculoPesos.pesoVolumetrico(
		    obj.getAlto_original(), 
		    obj.getAncho_original(), 
		    obj.getLargo_original(), 
		    ConstantesGenerales.DEMONIMADOR_CALCULO_PESO_VOLUMEN));
	    
	    obj.setPrecio_servicio(ResultSetUtils.getRSFloat("precio_servicio", rs) ); 
	    obj.setPrecio_kg_sobrepeso(ResultSetUtils.getRSFloat("precio_kg_sobrepeso", rs) ); 
	    
	    if ( obj.getPeso()> obj.getVolumen()){
		obj.setPeso_elejido(obj.getPeso());  
		
	    }else{
		obj.setPeso_elejido(obj.getVolumen());  
	    }
	    
		obj.setKg_sobrepeso(obj.getPeso_elejido() - obj.getPeso_original());
		if (obj.getKg_sobrepeso()<0){
		    obj.setKg_sobrepeso(0);
		}

		 obj.setPrecio_unitario(ResultSetUtils.getRSFloat("precio_unitario", rs) ); 
		    obj.setTotal_cobro(obj.getCobro_reexpedicion() +obj.getCobro_sobrepeso() + obj.getPrecio_unitario());

		
		 return obj;
	}

}
