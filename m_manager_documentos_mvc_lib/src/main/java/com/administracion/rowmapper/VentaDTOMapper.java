/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.AdicionalDTO;
import com.administracion.dto.VentaDTO;
import com.innovargia.documentos.dtos.CPs;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class VentaDTOMapper implements RowMapper<VentaDTO>{

	/**
	 * 
	 */
	public VentaDTOMapper() {
		// TODO Auto-generated constructor stub
	}

    @Override
    public VentaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

	VentaDTO obj = new VentaDTO();

	obj.setFecha(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils
		.getRSString("fecha", rs)));
	obj.setLogin(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils
		.getRSString("login", rs)));
	obj.setIdformapago(UtilsStringFechas
		.convierteCadenaTrimNULL(ResultSetUtils.getRSString(
			"idformapago", rs)));
	obj.setBanco_tarjeta(UtilsStringFechas
		.convierteCadenaTrimNULL(ResultSetUtils.getRSString(
			"banco_tarjeta", rs)));
	obj.setNumero_tarjeta(UtilsStringFechas
		.convierteCadenaTrimNULL(ResultSetUtils.getRSString(
			"numero_tarjeta", rs)));
	obj.setFecha_venc_tarjeta(UtilsStringFechas
		.convierteCadenaTrimNULL(ResultSetUtils.getRSString(
			"fecha_venc_tarjeta", rs)));
	obj.setIdoficina(UtilsStringFechas
		.convierteCadenaTrimNULL(ResultSetUtils.getRSString(
			"idoficina", rs)));
	obj.setObservacion(UtilsStringFechas
		.convierteCadenaTrimNULL(ResultSetUtils.getRSString(
			"observacion", rs)));
	obj.setFecha_cambio_estatus(UtilsStringFechas
		.convierteCadenaTrimNULL(ResultSetUtils.getRSString(
			"fecha_cambio_estatus", rs)));
	
	obj.setCliente_a_facturar(UtilsStringFechas
		.convierteCadenaTrimNULL(ResultSetUtils.getRSString(
			"cliente_a_facturar", rs))); 
	
	obj.setNacional(UtilsStringFechas
		.convierteCadenaTrimNULL(ResultSetUtils.getRSString(
			"nacional", rs))); 
	

	obj.setIdclientefactura(ResultSetUtils.getRSInt("idclientefactura", rs));
	obj.setIdventa(ResultSetUtils.getRSInt("idventa", rs));
	obj.setIdfoliooficina(ResultSetUtils.getRSInt("idfoliooficina", rs));
	
	obj.setEstatus(ResultSetUtils.getRSInt("estatus", rs));
	obj.setSolicita_factura(UtilsStringFechas
		.convierteCadenaTrimNULL(ResultSetUtils.getRSString(
			"solicita_factura", rs)));
	obj.setSubtotal(ResultSetUtils.getRSFloat("subtotal", rs));
	obj.setIva(ResultSetUtils.getRSFloat("iva", rs));
	obj.setDescuento(ResultSetUtils.getRSFloat("descuento", rs));
	obj.setTotal(ResultSetUtils.getRSFloat("total", rs));
	obj.setTipoventa(ResultSetUtils.getRSString("tipoventa", rs));  
	

	return obj;
    }

}
