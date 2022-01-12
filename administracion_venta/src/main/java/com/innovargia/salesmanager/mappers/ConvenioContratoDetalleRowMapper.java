/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class ConvenioContratoDetalleRowMapper implements RowMapper<ConvenioContratoDetalleDTO>{

	/**
	 * 
	 */
	public ConvenioContratoDetalleRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ConvenioContratoDetalleDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		ConvenioContratoDetalleDTO obj = new ConvenioContratoDetalleDTO();
		obj.setIdconveniodetalle(ResultSetUtils.getRSInt("idconveniodetalle", rs) );
		obj.setIdconvenio(ResultSetUtils.getRSInt("idconvenio", rs) );
		
		obj.setComentario(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("comentario", rs)));
		obj.setSiglasori(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("siglasori", rs)));
		obj.setSiglasdes(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("siglasdes", rs)));
		obj.setCporigen(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cporigen", rs)));
		obj.setCpdestino(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cpdestino", rs)));
		obj.setComentario(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("comentario", rs)));

		obj.setPeso(ResultSetUtils.getRSFloat("peso", rs) );
		obj.setLargo(ResultSetUtils.getRSFloat("largo", rs) );
		obj.setAlto(ResultSetUtils.getRSFloat("alto", rs) );
		obj.setAncho(ResultSetUtils.getRSFloat("ancho", rs) );
		obj.setCoberturakm(ResultSetUtils.getRSFloat("coberturakm", rs) );
		obj.setPrecio(ResultSetUtils.getRSFloat("precio", rs) );
		
		obj.setPrecio_real(ResultSetUtils.getRSFloat("precio_real", rs) );
		
		obj.setSobrepeso(ResultSetUtils.getRSFloat("sobrepeso", rs) );
		
		obj.setDescuento(ResultSetUtils.getRSFloat("descuento", rs) );
		
		obj.setPesobase(ResultSetUtils.getRSFloat("pesobase", rs) ); 
		
		obj.setVolumen(ResultSetUtils.getRSFloat("pesovolumetrico", rs) );
		obj.setPreciosobrepeso(ResultSetUtils.getRSFloat("preciosobrepeso", rs) );
		
		obj.setIdtarifa(ResultSetUtils.getRSInt("idtarifa", rs) );
		obj.setIdrangoenvios(ResultSetUtils.getRSInt("idrangoenvios", rs) );
		obj.setIdtarifapeso(ResultSetUtils.getRSInt("idtarifapeso", rs) );
		obj.setIdserviciotarifazona(ResultSetUtils.getRSInt("idserviciotarifazona", rs) );
		
		return obj;
	}

}
