/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.Factura;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.utils.Fechas;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class FacturaResumenRowMapper implements RowMapper<Factura>{

	/**
	 * 
	 */
	public FacturaResumenRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Factura mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Factura obj = new Factura();

		obj.setIdcontrol(ResultSetUtils.getRSInt("idcontrol", rs));
		obj.setMes(ResultSetUtils.getRSInt("mes", rs));
		obj.setAnio(ResultSetUtils.getRSInt("anio", rs));
		obj.setCantidad(ResultSetUtils.getRSInt("cantidad", rs));
		
		
		obj.setFac_nota(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fac_nota", rs)));
		obj.setDia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("dia", rs)));
		obj.setCliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cliente", rs)));
		obj.setLogin(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("login", rs)));
		obj.setIdcontrolenvio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idcontrolenvio", rs)));

		obj.setEstatus(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estatus", rs)));
		obj.setTipo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tipo", rs)));
		
		obj.setLogin_cancela(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("login_cancela", rs)));
		obj.setFecha_cancela(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fecha_cancela", rs)));

		obj.setFactura(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("factura", rs)));
	
		obj.setNombreMes(Fechas.getNombreMes(obj.getMes()));
		
		obj.setLogin_notacredito(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("login_notacredito", rs)));
		obj.setFecha_notacredito(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fecha_notacredito", rs)));
		
		
		return obj;
	}

}
