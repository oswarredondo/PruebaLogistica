/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.TarifaDTO;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class TarifaPesoRowMapper implements RowMapper<TarifaDTO>{

	/**
	 * 
	 */
	public TarifaPesoRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TarifaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TarifaDTO obj = new TarifaDTO();
		obj.setIdtarifa(ResultSetUtils.getRSInt("idtarifa", rs) );
		obj.setIdrangoenvios(ResultSetUtils.getRSInt("idrangoenvios", rs) );
		obj.setIdserviciotarifazona(ResultSetUtils.getRSInt("idserviciotarifazona", rs) );
		
		obj.setIdtarifapeso(ResultSetUtils.getRSInt("idtarifapeso", rs) );
		
		obj.setIdserviciotarifa(ResultSetUtils.getRSInt("idserviciotarifa", rs) );
		obj.setEstatus(	ResultSetUtils.getRSInt("estatus", rs) );
		obj.setIdrangoinicial(ResultSetUtils.getRSInt("idrangoinicial", rs) );
		obj.setIdrangofinal(ResultSetUtils.getRSInt("idrangofinal", rs) );
		
		obj.setPesoamparado(ResultSetUtils.getRSFloat("pesoamparado", rs) );
		obj.setKminicial(ResultSetUtils.getRSFloat("kminicial", rs));
		obj.setKmfinal(ResultSetUtils.getRSFloat("kmfinal", rs));
		obj.setPrecio(ResultSetUtils.getRSFloat("precio", rs));
		obj.setVolumen(ResultSetUtils.getRSFloat("volumen", rs));
		obj.setPreciokgsp(ResultSetUtils.getRSFloat("preciokgsp", rs)); 
		
		obj.setPesovolumetrico(ResultSetUtils.getRSFloat("pesovolumetrico", rs));  
		
		
		obj.setPesoinicial(ResultSetUtils.getRSFloat("pesoinicial", rs));
		obj.setPesofinal(ResultSetUtils.getRSFloat("pesofinal", rs));
		obj.setSobrepeso(ResultSetUtils.getRSFloat("sobrepeso", rs));
		
		obj.setDescripcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion", rs)));
		obj.setNombre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombre", rs)));
		obj.setZona(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("zona", rs)));
		
		
		obj.setDescripciontarifa(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripciontarifa", rs)));
		
		obj.setFechainicial(FechasDateTimeStamp.formatoFecha( ResultSetUtils.getRSDate("fechainicial", rs),"dd-MM-yyyy") );
		obj.setFechafinal(FechasDateTimeStamp.formatoFecha( ResultSetUtils.getRSDate("fechafinal", rs),"dd-MM-yyyy") );

		
		obj.setIdservicio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idservicio", rs))); 
		obj.setDescripcionservicio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionservicio", rs)));
		obj.setIdformapago(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idformapago", rs))); 
		obj.setDescripcionformapago(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionformapago", rs))); 
		
		obj.setEs_visible_pdv(ResultSetUtils.getRSInt("es_visible_pdv", rs) );
		obj.setEs_default(ResultSetUtils.getRSBoolean("es_default", rs) );
		
		// TODO Auto-generated method stub
		return obj;
	}

}
