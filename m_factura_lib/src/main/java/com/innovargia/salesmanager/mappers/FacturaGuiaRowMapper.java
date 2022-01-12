/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.Factura;
import com.administracion.dto.FacturaGuia;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.utils.Fechas;
import com.innovargia.utils.FechasDateTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class FacturaGuiaRowMapper implements RowMapper<FacturaGuia>{

	/**
	 * 
	 */
	public FacturaGuiaRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public FacturaGuia mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		FacturaGuia obj = new FacturaGuia();

		obj.setRazonsocial(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("razonsocial", rs)));
		obj.setIddocumento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("iddocumento", rs)));
		obj.setNumcliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numcliente", rs)));
		obj.setExclave(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("exclave", rs)));
		obj.setFechaevento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fechaevento", rs)));
		obj.setDescripcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion", rs)));
		obj.setNombre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombre", rs)));
		obj.setCantidad(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cantidad", rs)));
		obj.setSubtotal(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("subtotal", rs)));
		obj.setPeso_amparado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("peso_amparado", rs)));
		obj.setPeso_max_cliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("peso_max_cliente", rs)));
		obj.setPeso_max_medido(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("peso_max_medido", rs)));
		obj.setPeso_max_calculado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("peso_max_calculado", rs)));
		obj.setPrecio_kg_sp(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("precio_kg_sp", rs)));
		obj.setKg_sobrepeso(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("kg_sobrepeso", rs)));
		obj.setMonto_sobrepeso(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("monto_sobrepeso", rs)));
		obj.setCp(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cp", rs)));
		obj.setPrecio_reexpedicion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("precio_reexpedicion", rs)));
		obj.setFecha(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fecha", rs)));
		obj.setTipo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tipo", rs)));
		obj.setReferencia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("referencia", rs)));
		obj.setFechaentrega(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fechaentrega", rs)));
		obj.setFactura(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("factura", rs)));
		obj.setIsfacturada(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("isfacturada", rs)));
		obj.setEstatus(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estatus", rs)));
		obj.setTiposervicio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tiposervicio", rs)));
		obj.setMarcafactura(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("marcafactura", rs)));
		obj.setZonaori(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("zonaori", rs)));
		obj.setZonades(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("zonades", rs)));
		obj.setZonaventa(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("zonaventa", rs)));
		obj.setLargo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("largo", rs)));
		obj.setAncho(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("ancho", rs)));
		obj.setAlto(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("alto", rs)));
		obj.setPesofisico(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("pesofisico", rs)));
		obj.setPesovolumetrico(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("pesovolumetrico", rs)));
		obj.setPrecio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("precio", rs)));
		obj.setFechacorte(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fechacorte", rs)));
		obj.setContenido(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("contenido", rs)));
		obj.setValorasegurado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("valorasegurado", rs)));
		
		return obj;
	}

}
