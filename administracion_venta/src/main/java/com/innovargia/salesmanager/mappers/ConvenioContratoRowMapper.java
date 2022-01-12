/**
 * 
 */
package com.innovargia.salesmanager.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;

/**
 * @author aruaro
 *
 */
public class ConvenioContratoRowMapper implements RowMapper<ConvenioContratoDTO>{

	/**
	 * 
	 */
	public ConvenioContratoRowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ConvenioContratoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ConvenioContratoDTO obj = new ConvenioContratoDTO();
		
		obj.setIdconvenio(ResultSetUtils.getRSInt("idconvenio", rs));
		obj.setIdcotizacionorigen(ResultSetUtils.getRSInt("idcotizacionorigen", rs)); 
		obj.setIdcliente(ResultSetUtils.getRSInt("idcliente", rs));
		obj.setIdoficinacontrol(ResultSetUtils.getRSInt("idoficinacontrol", rs));
		obj.setIdtipoconvenio(ResultSetUtils.getRSInt("idtipoconvenio", rs));
		obj.setIdformapago(ResultSetUtils.getRSInt("idformapago", rs));
		obj.setIdmetodopago(ResultSetUtils.getRSInt("idmetodopago", rs));
		obj.setIdcliente(ResultSetUtils.getRSInt("idcliente", rs));
		obj.setIdrangoenvios(ResultSetUtils.getRSInt("idrangoenvios", rs));
		obj.setIdagrupamiento(ResultSetUtils.getRSInt("idagrupamiento", rs)); 
		
		obj.setIdpoblacionpago(ResultSetUtils.getRSInt("idpoblacionpago", rs));
		obj.setIdcondicionpago(ResultSetUtils.getRSInt("idcondicionpago", rs));
		obj.setIdtarifarango(ResultSetUtils.getRSInt("idtarifarango", rs));
		obj.setIdtarifa(ResultSetUtils.getRSInt("idtarifa", rs));
		obj.setIdunidadadm(ResultSetUtils.getRSInt("idunidadadm", rs));
		obj.setFechainicio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fechainicio", rs)));
		obj.setFechaactivacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fechaactivacion", rs)));
		obj.setFecharevision(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fecharevision", rs))); 
		obj.setFechatermino(ResultSetUtils.getRSString("fechatermino", rs));
		obj.setFechadocumento(ResultSetUtils.getRSString("fechadocumento", rs));
		obj.setFechacreacionregis(ResultSetUtils.getRSString("fechacreacionregis", rs));
		obj.setIddescuento(ResultSetUtils.getRSInt("iddescuento", rs));
		obj.setEstatus(ResultSetUtils.getRSInt("estatus", rs));
		obj.setTipo_precios(ResultSetUtils.getRSInt("tipo_precios", rs));
		obj.setCredito(ResultSetUtils.getRSInt("credito", rs));
		obj.setClientelicitacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("clientelicitacion", rs)));
		
		
		obj.setNombre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombre", rs)));
		obj.setTipo_contrato(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tipo_contrato", rs)));
		obj.setObservacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("observacion", rs)));
		obj.setDescripcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcion", rs)));
		obj.setRepresentantelegal(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("representantelegal", rs)));
		obj.setIdclientelicitacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idclientelicitacion", rs)));
		obj.setObservacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("observacion", rs)));
		
		//TODO: Estas columnas de descripcion salen de la vista que realciona los convenios con cada una de las tablas
		obj.setDescripcionCliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionCliente", rs)));
		obj.setDescripcionCondicionpago(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionCondicionpago", rs)));
		obj.setDescripcionFormapago(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionFormapago", rs)));
		obj.setDescripcionMetodopago(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionMetodopago", rs)));
		obj.setDescripcionOficinacontrol(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionOficinacontrol", rs)));
		obj.setDescripcionPoblacionpago(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionPoblacionpago", rs)));
		obj.setDescripcionTarifarango(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionTarifarango", rs)));
		obj.setDescripcionTipoconvenio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionTipoconvenio", rs)));
		obj.setDescripcionUnidadadm(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionUnidadadm", rs)));
		obj.setDescripcionDescuento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripcionDescuento", rs)));

		obj.setRazonsocial_cte(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("razonsocial_cte", rs)));  
		obj.setContacto_cte(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("contacto_cte", rs))); 
		obj.setNumcliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numcliente", rs)));
		obj.setCalle_cte(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("calle_cte", rs)));
		obj.setNuminterior_cte(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numinterior_cte", rs)));
		obj.setNumexterior_cte(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numexterior_cte", rs)));
		obj.setCp_cte(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cp_cte", rs)));
		obj.setColonia_cte(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("colonia_cte", rs)));
		obj.setMunicipio_cte(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("municipio_cte", rs)));
		obj.setEstado_cte(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estado_cte", rs)));
		obj.setTelefono_cte(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("telefono_cte", rs)));
		obj.setMovil_cte(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("movil_cte", rs)));
		obj.setEmail_cte(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("email_cte", rs)));

		
		obj.setCalle_rev(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("calle_rev", rs)));
		obj.setNuminterior_rev(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numinterior_rev", rs)));
		obj.setNumexterior_rev(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numexterior_rev", rs)));
		obj.setCp_rev(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cp_rev", rs)));
		obj.setColonia_rev(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("colonia_rev", rs)));
		obj.setMunicipio_rev(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("municipio_rev", rs)));
		obj.setEstado_rev(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estado_rev", rs)));
		obj.setResponsable_rev(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("responsable_rev", rs)));
		obj.setEmail_resp_rev(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("email_resp_rev", rs))); 
		obj.setTelefono_rev(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("telefono_rev", rs)));  
		obj.setMovil_rev(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("movil_rev", rs)));   
		
		obj.setRfc(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("rfc", rs)));
		obj.setCuentabancaria(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cuentabancaria", rs)));
		obj.setNombrebanco(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombrebanco", rs)));
		obj.setDiasrevision(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("diasrevision", rs)));
		obj.setDiaspago(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("diaspago", rs)));
		
		obj.setResponsable_pago(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("responsable_pago", rs)));
		obj.setResponsable_rev(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("responsable_rev", rs)));
		obj.setEmail_resp_pago(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("email_resp_pago", rs)));
		obj.setEmail_resp_rev(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("email_resp_rev", rs)));
		obj.setEstadoactualdoc(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estadoactualdoc", rs)));
		obj.setLogin(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("login", rs)));
		
		obj.setRangoenvios(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("rangoenvios", rs)));
		
		obj.setClientefirma(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("clientefirma", rs))); 
		obj.setGerentecomercialfirma(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("gerentecomercialfirma", rs))); 
		obj.setJefezonafirma(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("jefezonafirma", rs))); 
		obj.setCoordinadorcreditocobfirma(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("coordinadorcreditocobfirma", rs))); 
		obj.setDirectoradmfinanzasfirma(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("directoradmfinanzasfirma", rs))); 
		obj.setEjecutivoventasfirma(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("ejecutivoventasfirma", rs)));  
		
		
		obj.setTipocierre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tipocierre", rs))); 
		obj.setDescripciontipocierre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("descripciontipocierre", rs)));
		
		/* DATOS SEGURO */
		obj.setAsegura(ResultSetUtils.getRSInt("asegura", rs));
		obj.setNombre_seguro(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("nombre_seguro", rs)));
		obj.setPorcentaje_seguro(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("porcentaje_seguro", rs)));


		return obj;
	}

}
