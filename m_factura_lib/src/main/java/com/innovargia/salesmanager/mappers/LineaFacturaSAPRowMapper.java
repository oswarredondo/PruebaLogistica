/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.Factura;
import com.innovargia.administracion.dto.LineaFacturaSAP;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.utils.Fechas;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class LineaFacturaSAPRowMapper implements RowMapper<LineaFacturaSAP>{

	/**
	 * 
	 */
	public LineaFacturaSAPRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LineaFacturaSAP mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		LineaFacturaSAP obj = new LineaFacturaSAP();
		
		obj.setRow_number(ResultSetUtils.getRSInt("row_number", rs));

		obj.setCantidad(ResultSetUtils.getRSInt("cantidad", rs));
		obj.setImporte(ResultSetUtils.getRSFloat("importe", rs));
		
		obj.setMaterialsap(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("materialsap", rs)));
		obj.setUnidad(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("unidad", rs)));
		obj.setCebe(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cebe", rs)));
		obj.setTdformat1(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tdformat1", rs)));
		obj.setTdformat2(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tdformat2", rs)));
		obj.setTdline1(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tdline1", rs)));
		obj.setTdline2(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tdline2", rs)));
		obj.setServicio_nombre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombre", rs)));
		obj.setIdservicio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idservicio", rs)));
		obj.setNumcliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numcliente", rs)));
		obj.setRazonsocial(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("razonsocial", rs)));
		obj.setZonaori(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("zonaori", rs)));
		obj.setZonades(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("zonades", rs)));
		obj.setEstatus(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estatus", rs)));
		
		obj.setMarcafactura(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("marcafactura", rs)));

		obj.setIdsapparametros(ResultSetUtils.getRSInt("idsapparametros", rs));
		obj.setP_proceso(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("p_proceso", rs)));
		obj.setP_tipo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("p_tipo", rs)));
		obj.setP_spart(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("p_spart", rs)));
		obj.setP_kunnr(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("p_kunnr", rs)));
		obj.setP_zterm(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("p_zterm", rs)));
		
		obj.setPcorreo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("pcorreo", rs)));
		obj.setPdocumento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("pdocumento", rs)));
		obj.setPnumdocLog(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("pnumdocLog", rs)));
		
		return obj;
	}

}
