/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.DescuentoDTO;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class DescuentoRowMapper implements RowMapper<DescuentoDTO>{

	/**
	 * 
	 */
	public DescuentoRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DescuentoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		DescuentoDTO obj = new DescuentoDTO();
		
		obj.setIddescuento(ResultSetUtils.getRSInt("iddescuento", rs));
		obj.setNombre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombre", rs)));
		obj.setDescripcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion", rs)));
		obj.setDescuentofijo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descuentofijo", rs)));
		obj.setPorcentaje(ResultSetUtils.getRSFloat("porcentaje", rs));
		obj.setTipo(ResultSetUtils.getRSInt("tipo", rs));
		obj.setIdagrupamiento(ResultSetUtils.getRSInt("idagrupamiento", rs));
		
		obj.setFechaactivacion(FechasDateTimeStamp.formatoFecha( ResultSetUtils.getRSDate("fechaactivacion", rs),"dd-MM-yyyy") );
		obj.setFechatermino(FechasDateTimeStamp.formatoFecha( ResultSetUtils.getRSDate("fechatermino", rs),"dd-MM-yyyy") );
		obj.setFechaalta(FechasDateTimeStamp.formatoFecha( ResultSetUtils.getRSDate("fechaalta", rs),"dd-MM-yyyy") );
		obj.setEstatus(ResultSetUtils.getRSInt("estatus", rs)); 
		
		obj.setNivel(ResultSetUtils.getRSInt("nivel", rs)); 
		//TODO: estos datos salen de la relacion de las vistas cuando 
		//se trata de datos de tipos de descuento
		obj.setIdadicional(ResultSetUtils.getRSInt("idadicional", rs));
		obj.setIdcliente(ResultSetUtils.getRSInt("idcliente", rs));
		obj.setIdrangoenvios(ResultSetUtils.getRSInt("idrangoenvios", rs));
		obj.setIdserviciotarifa(ResultSetUtils.getRSInt("idserviciotarifa", rs));
		obj.setIdtarifa(ResultSetUtils.getRSInt("idtarifa", rs));
		
		
		obj.setDescripcionAdicional(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionAdicional", rs)));
		obj.setDescripcionCliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionCliente", rs)));
		obj.setDescripcionRangoenvios(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionRangoenvios", rs)));
		obj.setDescripcionServiciotarifa(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionServiciotarifa", rs)));
		obj.setDescripcionTarifa(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionTarifa", rs)));
		
		//Campos utilizados para Detalle de Descuentos
		obj.setIdentificador(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("identificador", rs)));
		obj.setDescripcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion", rs)));
		
		return obj;
	}

}
