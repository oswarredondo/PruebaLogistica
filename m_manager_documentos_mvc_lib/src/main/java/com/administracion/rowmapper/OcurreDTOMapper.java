/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.AdicionalDTO;
import com.innovargia.documentos.dtos.CPs;
import com.innovargia.documentos.dtos.OcurreDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class OcurreDTOMapper implements RowMapper<OcurreDTO>{

	/**
	 * 
	 */
	public OcurreDTOMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public OcurreDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	    OcurreDTO obj  =new OcurreDTO();
	    obj.setDestino(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("destino",rs))); 
	    obj.setFechadevolucion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechadevolucion",rs)));  
	    obj.setFechaentrada(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechaentrada",rs)));  
	    obj.setFechaentrega(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechaentrega",rs)));   
	    obj.setIddocumento(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("iddocumento",rs)));  
	    obj.setIddocumentodevolucion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("iddocumentodevolucion",rs)));   
	    obj.setIdoficina(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idoficina",rs)));   
	    obj.setNumeroidentificacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("numeroidentificacion",rs)));   
	    obj.setObservacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("observacion",rs)));   
	    obj.setQuienrecibe(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("quienrecibe",rs)));  
	    obj.setRemite(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("remite",rs))); 
	    obj.setTipoidentificacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tipoidentificacion",rs))); 
	    
	    obj.setManifdevolucion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("iddocumentodevolucion",rs))); 
	    obj.setManifentrega(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("manifentrega",rs))); 
	    obj.setRutadevolucion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("rutadevolucion",rs)));
	    
	    obj.setRuta(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("ruta",rs)));
	    obj.setManifiesto_entrada_ruta(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("manifiesto_entrada_ruta",rs)));
	    obj.setFechamanifiesto(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechamanifiesto",rs)));
	    obj.setDes_ubicacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("des_ubicacion",rs)));
	    obj.setUbicacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("ubicacion",rs)));

	    
	    obj.setMonto(ResultSetUtils.getRSFloat("monto", rs));
	    obj.setCant_cobrada(ResultSetUtils.getRSFloat("cant_cobrada", rs));
	    obj.setCantidad_envios_entregada(ResultSetUtils.getRSInt("cantidad_envios_entregada", rs));
	    
	   
	    return obj;
	}

}
