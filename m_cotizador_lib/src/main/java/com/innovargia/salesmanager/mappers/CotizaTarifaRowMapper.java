/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.CotizacionTarifa;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class CotizaTarifaRowMapper implements RowMapper<CotizacionTarifa>{

	/**
	 * 
	 */
	public CotizaTarifaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CotizacionTarifa mapRow(ResultSet rs, int rowNum) throws SQLException {
	    CotizacionTarifa obj = new CotizacionTarifa();
		obj.setIdtarifa(ResultSetUtils.getRSInt("idtarifa1", rs) );
		obj.setIdconveniodetalle(ResultSetUtils.getRSInt("idconveniodetalle", rs) ); 
		obj.setIdrangoenvios(ResultSetUtils.getRSInt("idrangoenvios1", rs) );
		obj.setIdserviciotarifazona(ResultSetUtils.getRSInt("idserviciotarifazona1", rs) );
		
		obj.setIdtarifapeso(ResultSetUtils.getRSInt("idtarifapeso1", rs) );
		
		
		obj.setIdserviciotarifa(ResultSetUtils.getRSInt("idserviciotarifa1", rs) );
		obj.setEstatus(	ResultSetUtils.getRSInt("estatus1", rs) );
		obj.setIdrangoinicial(ResultSetUtils.getRSInt("idrangoinicial1", rs) );
		obj.setIdrangofinal(ResultSetUtils.getRSInt("idrangofinal1", rs) );
		obj.setPesoinicial(ResultSetUtils.getRSFloat("pesoinicial1", rs));
		obj.setPesofinal(ResultSetUtils.getRSFloat("pesofinal1", rs));
		obj.setPesoamparado(ResultSetUtils.getRSFloat("pesoamparado1", rs) );
		obj.setKminicial(ResultSetUtils.getRSFloat("kminicial1", rs));
		obj.setKmfinal(ResultSetUtils.getRSFloat("kmfinal1", rs));
		obj.setPrecio(ResultSetUtils.getRSFloat("precio1", rs));
		obj.setPreciokgsp(ResultSetUtils.getRSFloat("preciokgsp1", rs)); 
		obj.setPreciounitarioporkm(ResultSetUtils.getRSFloat("preciounitarioporkm1", rs));
		obj.setPesovolumetrico(ResultSetUtils.getRSFloat("pesovolumetrico1", rs));  
		obj.setKilometros(ResultSetUtils.getRSFloat("kilometros1", rs));  
		obj.setSobrepeso(ResultSetUtils.getRSFloat("sobrepeso1", rs));
		obj.setDescripciontarifa(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripciontarifa1", rs)));
		obj.setNombre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombre1", rs)));
		obj.setZona(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("zona1", rs)));
		obj.setIdservicio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idservicio", rs))); 
		
		obj.setPrecioadicional(ResultSetUtils.getRSFloat("precioadicional", rs));
		obj.setTotalprecioenvios(ResultSetUtils.getRSFloat("totalprecioenvios", rs));
		obj.setTotalsobrepeso( ResultSetUtils.getRSFloat("totalsobrepeso", rs));
		
		obj.setCporigen(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cporigen", rs)));
		obj.setCpdestino(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cpdestino", rs)));
		obj.setGarantia(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("garantia1", rs)));
		obj.setGarantiamaxina(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("garantia1", rs)));
		
		obj.setCantidadenvios(ResultSetUtils.getRSInt("cantidadenvios", rs));
		obj.setPesoamparado( ResultSetUtils.getRSFloat("pesoamparado", rs)); 
		
		obj.setIdconvenio(ResultSetUtils.getRSInt("idconvenio", rs));
		   

	
		
		// TODO Auto-generated method stub
		return obj;
	}

}
