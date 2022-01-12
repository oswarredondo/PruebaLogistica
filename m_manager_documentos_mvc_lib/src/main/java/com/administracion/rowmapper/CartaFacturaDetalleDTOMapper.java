/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.AdicionalDTO;
import com.administracion.dto.CartaFacturaDetalle;
import com.innovargia.documentos.dtos.CPs;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class CartaFacturaDetalleDTOMapper implements RowMapper<CartaFacturaDetalle>{

	/**
	 * 
	 */
	public CartaFacturaDetalleDTOMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CartaFacturaDetalle mapRow(ResultSet rs, int rowNum) throws SQLException {
		
	    CartaFacturaDetalle obj  =new CartaFacturaDetalle();
	    obj.setIdregistro(ResultSetUtils.getRSInt("idregistro", rs) ); 
	    obj.setIdregistrodatos(ResultSetUtils.getRSInt("idregistrodatos", rs) );  
	    obj.setCantidad(ResultSetUtils.getRSInt("cantidad", rs) );  
	    obj.setValor_unitario(ResultSetUtils.getRSFloat("valor_unitario", rs) ); 
	    obj.setValor_total(ResultSetUtils.getRSFloat("valor_total", rs) );  
		
		obj.setUuid(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("uuid",rs)));  
		obj.setDescripcion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion",rs)));
	    
		obj.setShipmentid(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("shipmentid",rs)));
		obj.setFechainsercion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechainsercion",rs)));
		obj.setFactura(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("factura",rs)));
		obj.setNumcompra(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("numcompra",rs)));
		obj.setTerminosventa(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("terminosventa",rs)));
		obj.setRazonexportacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("razonexportacion",rs)));
		obj.setTaxid_vat(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("taxid_vat",rs)));
		obj.setNombrecontacto(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("nombrecontacto",rs)));
		obj.setCallecontacto(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("callecontacto",rs)));
		obj.setColoniacontacto(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("coloniacontacto",rs)));
		obj.setCpcontacto(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("cpcontacto",rs)));
		obj.setCiudadcontacto(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("ciudadcontacto",rs)));
		obj.setPaiscontacto(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("paiscontacto",rs)));
		obj.setTelefonocontacto(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("telefonocontacto",rs)));
		obj.setDeclaracion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("declaracion",rs)));
		obj.setInstrucciones_especiales(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("instrucciones_especiales",rs)));
		obj.setCelularcontacto(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("celularcontacto",rs)));
		obj.setEmailcontacto(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("emailcontacto",rs)));
		obj.setUnidad_medida(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("unidad_medida",rs)));
		obj.setHarm_codigo(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("harm_codigo",rs)));
		obj.setC_o(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("c_o",rs)));

		
		return obj;
	}

}
