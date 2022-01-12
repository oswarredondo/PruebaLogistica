/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.Folios;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class FoliosRowMapper implements RowMapper<Folios>{

	/**
	 * 
	 */
	public FoliosRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Folios mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Folios folio  =new Folios();
		
		 folio.setNumCliente(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("numcliente",rs)));
         folio.setIdServicio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idservicio",rs))); 
         folio.setDescripcionServicio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion",rs)));  
         folio.setCantidadAsignada(ResultSetUtils.getRSInt("cantidadasiganda",rs) ); 
         folio.setCantidadUtilizada(ResultSetUtils.getRSInt("cantidadutilizada",rs) );
         folio.setIdregistro(ResultSetUtils.getRSInt("idregistro",rs) );
         folio.setPeso(ResultSetUtils.getRSInt("peso",rs) );
         
         folio.setTipoRotulacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tiporotulacion",rs)));   
         folio.entidad.setIdentidad(ResultSetUtils.getRSInt("identidad",rs) );
         folio.organizacion.setIdentidad(ResultSetUtils.getRSInt("idorganizacion",rs) );
         folio.setIdconveniodetalle( ResultSetUtils.getRSInt("idconveniodetalle",rs) ); 
         
         folio.setTipo_contrato(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tipo_contrato",rs)));     
         folio.setSiglas_oficina_control(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("siglas_oficina_control",rs)));    
         folio.setIdoficinacontrol(ResultSetUtils.getRSInt("idoficinacontrol",rs) );  
         
        // folio.setDescripcionServicio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcionservicio",rs))); 
        

		return folio;
	}

}
