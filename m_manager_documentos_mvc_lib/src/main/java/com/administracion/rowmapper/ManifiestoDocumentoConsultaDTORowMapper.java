
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.utils.FechasTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.DocumentoDTO;
import com.servicio.dtos.Zona;

public class ManifiestoDocumentoConsultaDTORowMapper implements RowMapper<DocumentoConsultaDTO>{

	String formatofecha = "dd-MM-yyyy HH:mm:ss";
	public ManifiestoDocumentoConsultaDTORowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DocumentoConsultaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DocumentoConsultaDTO cartaPorDto  =new DocumentoConsultaDTO();
		
		 cartaPorDto.setIdServicio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idservicio", rs))); 
		  
		  cartaPorDto.setIdentidad(ResultSetUtils.getRSInt("identidad", rs));
		  
		  cartaPorDto.setIdorganizacion(ResultSetUtils.getRSInt("idorganizacion", rs)); 
		  cartaPorDto.setIdDocumento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("iddocumento", rs))); 
		  cartaPorDto.setNumCliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numcliente", rs))); 
		  cartaPorDto.setIdTipoDocumento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idtipodocumento", rs))); 
		  cartaPorDto.setIdDocumento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("iddocumento", rs))); 
		  cartaPorDto.setIdEnvio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("iddocumento", rs))); 
		  cartaPorDto.setReferencia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("referencia", rs))); 
		  cartaPorDto.setFecharecoleccion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fecharecoleccion", rs))); 
		  
		  cartaPorDto.setIdDocumentoPadre(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("iddocumentopadre", rs))); 
		  
		  cartaPorDto.setAlto(ResultSetUtils.getRSInt("alto",rs)); 
		  cartaPorDto.setAncho(ResultSetUtils.getRSInt("ancho",rs)); 
		  cartaPorDto.setLargo(ResultSetUtils.getRSInt("largo",rs)); 
		  cartaPorDto.setEstatus(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("est", rs))); 
		  cartaPorDto.setIdTerminalDestino(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idterminaldes", rs))); 

		  cartaPorDto.setContenidoDeclarado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("contenido", rs))); 
		  cartaPorDto.setFactura(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("factura", rs))); 
		  cartaPorDto.setIsfactura(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("isfacturada", rs))); 
		  cartaPorDto.setReferencia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("referencia", rs))); 
		  
		  cartaPorDto.setPedimento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("pedimento", rs))); 
		  cartaPorDto.setAduana(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("aduana", rs))); 
		  cartaPorDto.setNumPiezas(ResultSetUtils.getRSInt("numpiezas", rs)); 
		  cartaPorDto.setPesoBruto(ResultSetUtils.getRSFloat("pesofisico", rs)); 
		  cartaPorDto.setPesoVolumetrico(ResultSetUtils.getRSFloat("pesovolumetrico", rs)); 
		  cartaPorDto.setValorDeclarado(ResultSetUtils.getRSFloat("valordeclarado", rs)); 

		  cartaPorDto.setTipoEmbalaje(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tipodeembalaje", rs))); 
		  cartaPorDto.setObservaciones(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("observacion", rs))); 
		  
		  cartaPorDto.setDelivery(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("delivery", rs))); 
		  cartaPorDto.setEmbarque(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("shipment", rs))); 

		  cartaPorDto.setFechaCreacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fechacreacion", rs))); 
		  cartaPorDto.setFechaCita(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fechacita", rs))); 

		  cartaPorDto.setHoraCita(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("horacita", rs))); 
		  
		  cartaPorDto.setLogin(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("login", rs))); 
		  cartaPorDto.setRuta(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("ruta", rs))); 
		  cartaPorDto.setManifiesto(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("manifiesto", rs))); 
		  
		  // Datos de confirmacion
		  cartaPorDto.setQuienRecibe(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("conombre", rs))); 
		  cartaPorDto.setFechaConfirmacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("formatofecha", rs))); 
		  
		  cartaPorDto.setFechaLimite(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fechaLimite", rs))); 
 
		  cartaPorDto.setOrigenEmbarque(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("origenEmbarque", rs))); 
		  cartaPorDto.setCossDock(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cossdock",rs))); 
		  cartaPorDto.setOrderNumberSAP(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("ordernumbersap", rs))); 

		  cartaPorDto.setPurcharseOrder(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("purcharseorder", rs))); 
		  cartaPorDto.setShmtDocD(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("shmtdocd", rs))); 
		  cartaPorDto.setSoldParty(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("soldparty", rs))); 
		  cartaPorDto.setSoldtoPartyDesc(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("soldtopartydesc", rs))); 
		  cartaPorDto.setShipmentCreationDate(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("shipmentcreationdate", rs))); 
		  cartaPorDto.setRouteNumber(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("routenumber", rs))); 
		  cartaPorDto.setDeliveryCreationDate(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("deliverycreationdate", rs))); 
		 
		  cartaPorDto.setShippingPointCP(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("shippingpointcp", rs))); 
		  cartaPorDto.setCarrierNumber(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("carriernumber", rs))); 
		  cartaPorDto.setCarrierDescription(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("carrierdescription", rs))); 
		  cartaPorDto.setFechaSalidaMX33(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fechasalidamx33", rs))); 
		  cartaPorDto.setFechaLlegadaL1(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fechallegadal1", rs))); 
		  cartaPorDto.setFolioCita(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("foliocita", rs))); 

		  cartaPorDto.setClaverechazo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("claverechazo", rs))); 
		  cartaPorDto.setFoliorechazo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("foliorechazo", rs))); 
		  cartaPorDto.setCantidadrechazo(ResultSetUtils.getRSInt("cantidadrechazo", rs) );
		  cartaPorDto.setTiporechazo(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tiporechazo", rs))); 
		  
		  
		  //Ajusta guia de devolucion y casamiento
		  cartaPorDto.setIdGuiaDevolucion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("iddevolucion", rs))); 
		  cartaPorDto.setIdGuiaCasamiento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idcasamiento", rs))); 

		  
		  //Agrega los datos de remitente y destino 
		  cartaPorDto.remitente.setIdDocumento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idDocumento",rs))); 
		  cartaPorDto.remitente.setRazonSocial(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("razonsocialorigen", rs))); 
		  cartaPorDto.remitente.setAtencion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("atencionorigen", rs)) );
		  cartaPorDto.remitente.setCalle(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("direccionorigen", rs)) );
		  cartaPorDto.remitente.setDireccion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("direccionorigen", rs)) );
		  cartaPorDto.remitente.setColonia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("coloniaorigen", rs)) );
		  cartaPorDto.remitente.setMunicipio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("municipioorigen", rs)) );
		  cartaPorDto.remitente.setEstado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estadoorigen", rs)) );
		  cartaPorDto.remitente.setCp(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cporigen", rs)) );
		  cartaPorDto.remitente.setTelefono(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("telefonoorigen", rs)) );

		  
		  cartaPorDto.destinatario.setIdDocumento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idDocumento",rs))); 
		  cartaPorDto.destinatario.setRazonSocial(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("razonsocialdes",  rs))); 
		  cartaPorDto.destinatario.setAtencion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("atenciondes", rs)) );
		  cartaPorDto.destinatario.setCalle(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("direcciondes", rs)) );
		  cartaPorDto.destinatario.setDireccion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("direcciondes", rs)) );
		  cartaPorDto.destinatario.setColonia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("coloniades", rs)) );
		  cartaPorDto.destinatario.setMunicipio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("municipiodes", rs)) );
		  cartaPorDto.destinatario.setEstado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estadodes", rs)) );
		  cartaPorDto.destinatario.setCp(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cpdes", rs)) );
		  cartaPorDto.destinatario.setTelefono(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("telefonodes", rs)) );
		  cartaPorDto.destinatario.setRfc(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("rfcdes", rs)) );
		  cartaPorDto.destinatario.setCorreoe(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("emaildes", rs)) );
		  cartaPorDto.destinatario.setContrato(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("contratodes", rs)) ); 
		  
		  
		  cartaPorDto.setIdDocumento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("iddocumento", rs)) ); 
	      	cartaPorDto.setRuta(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("ruta", rs)) ); 
	      	cartaPorDto.setFactura(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("factura", rs)) ); 
	      	cartaPorDto.setTipoEmbalaje(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("factura", rs)) ); 
	      	cartaPorDto.setNumCliente(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("numcliente", rs)) ); 
	      	cartaPorDto.setFechaCita(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fechacita", rs)) ); 
	      	cartaPorDto.setHoraCita(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("horacita", rs)) ); 
	      	cartaPorDto.setPesoBruto(ResultSetUtils.getRSFloat("pesofisico", rs)) ; 
	      	cartaPorDto.setVolumen(ResultSetUtils.getRSFloat("volumen", rs)) ; 
	      	cartaPorDto.setPesoVolumetrico(ResultSetUtils.getRSFloat("pesovolumetrico", rs)) ; 
	      	cartaPorDto.setFechaAsignacion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fechaAsignacion", rs)) );
	      	cartaPorDto.setTiporecepcion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tiporecepcion", rs)) );
	      	 

	      	String cita  = UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cita",rs)); 
	      	cartaPorDto.setCita("T".equals(cita)?"SI":"NO"); 
	      	
	      	cartaPorDto.setTipoEmbalaje(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("tipodeembalaje", rs)) ); 
	      	
	      	//fechalimite,largo,ancho,alto,pesovolumetrico
		  cartaPorDto.setFechaLimite(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("fechaLimite", rs)) ); 
		  
	      	cartaPorDto.setPesoVolumetrico(ResultSetUtils.getRSFloat("pesovolumetrico", rs)) ; 


		  return cartaPorDto;
	}

}
