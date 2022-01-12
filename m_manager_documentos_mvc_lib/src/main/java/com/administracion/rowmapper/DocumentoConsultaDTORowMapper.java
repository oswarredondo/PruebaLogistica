
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.utils.FechasTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.DocumentoConsultaDTO;

public class DocumentoConsultaDTORowMapper implements RowMapper<DocumentoConsultaDTO>{

	String formatofecha = "dd-MM-yyyy HH:mm:ss";
	public DocumentoConsultaDTORowMapper() {}

	@Override
	public DocumentoConsultaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DocumentoConsultaDTO cartaPorDto  =new DocumentoConsultaDTO();
		
		 cartaPorDto.setIdServicio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idservicio", rs)));  
		 cartaPorDto.setEs_nacional(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("es_nacional", rs)));  
		  cartaPorDto.setIdentidad(ResultSetUtils.getRSInt("identidad", rs));
		  
		  cartaPorDto.setIdorganizacion(ResultSetUtils.getRSInt("idorganizacion", rs));
		  cartaPorDto.setIdDocumento(ResultSetUtils.getRSString("iddocumento", rs));
		  
		  cartaPorDto.setIdDocumentoMadre(ResultSetUtils.getRSString("iddocumentomadre", rs));
		  
		  cartaPorDto.setNumCliente(ResultSetUtils.getRSString("numcliente", rs));
		  cartaPorDto.setIdTipoDocumento(ResultSetUtils.getRSString("idtipodocumento", rs));
		  cartaPorDto.setIdDocumento(ResultSetUtils.getRSString("iddocumento", rs));
		  cartaPorDto.setIdEnvio(ResultSetUtils.getRSString("iddocumento", rs));
		  cartaPorDto.setReferencia(ResultSetUtils.getRSString("referencia", rs));
		  //cartaPorDto.setFecharecoleccion(FechasTimeStamp
		  //.formatoTimeStamp(rs.getTimestamp("fecharecoleccion"),
		  //this.formatofecha));
		  cartaPorDto.setFecharecoleccion(ResultSetUtils.getRSString("fecharecoleccion", rs) );
		  cartaPorDto.setDescripcio_servicio(ResultSetUtils.getRSString("descripcionservicio", rs) );
		 
		  if (cartaPorDto.getFecharecoleccion()==null || cartaPorDto.getFecharecoleccion().isEmpty()){
			  cartaPorDto.setFecharecoleccion(ResultSetUtils.getRSString("fecharecoleccionmov", rs) );
		  }
		  
		  
		  
		  cartaPorDto.setIdDocumentoPadre(ResultSetUtils.getRSString("iddocumentopadre",rs));
		  
		  cartaPorDto.setAlto(ResultSetUtils.getRSInt("alto", rs));
		  cartaPorDto.setAncho(ResultSetUtils.getRSInt("ancho", rs));
		  cartaPorDto.setLargo(ResultSetUtils.getRSInt("largo", rs));
		  cartaPorDto.setEstatus(ResultSetUtils.getRSString("est", rs) );
		  cartaPorDto.setIdTerminalDestino(ResultSetUtils.getRSString("idterminaldes", rs));

		  cartaPorDto.setContenidoDeclarado(ResultSetUtils.getRSString("contenido", rs));
		  cartaPorDto.setFactura(ResultSetUtils.getRSString("factura", rs));
		  cartaPorDto.setIsfactura(ResultSetUtils.getRSString("isfacturada", rs));
		  cartaPorDto.setReferencia(ResultSetUtils.getRSString("referencia", rs));
		  
		  cartaPorDto.setPedimento(ResultSetUtils.getRSString("pedimento", rs));
		  cartaPorDto.setAduana(ResultSetUtils.getRSString("aduana", rs));
		  cartaPorDto.setNumPiezas(ResultSetUtils.getRSInt("numpiezas", rs));
		  cartaPorDto.setPesoBruto(ResultSetUtils.getRSFloat("pesofisico",rs));
		  cartaPorDto.setPesoVolumetrico(ResultSetUtils.getRSFloat("pesovolumetrico",rs));
		  cartaPorDto.setValorDeclarado(ResultSetUtils.getRSFloat("valordeclarado",rs));

		  cartaPorDto.setTipoEmbalaje(ResultSetUtils.getRSString("tipodeembalaje", rs));
		  cartaPorDto.setObservaciones(ResultSetUtils.getRSString("observacion", rs));
		  
		  cartaPorDto.setDelivery(ResultSetUtils.getRSString("delivery", rs));
		  cartaPorDto.setEmbarque(ResultSetUtils.getRSString("shipment", rs));

		  cartaPorDto.setFechaCreacion(ResultSetUtils.getRSString("fechacreacion",rs));

		  cartaPorDto.setHoraCita(ResultSetUtils.getRSString("horacita", rs));
		  
		  cartaPorDto.setLogin(ResultSetUtils.getRSString("login", rs));
		  cartaPorDto.setRuta(ResultSetUtils.getRSString("ruta", rs));
		  cartaPorDto.setManifiesto(ResultSetUtils.getRSString("manifiesto", rs));
		  
		  // Datos de confirmacion
		  cartaPorDto.setQuienRecibe(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("conombre", rs)) ); 
		  cartaPorDto.setPlazaEntrega(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("plsiglasplaza", rs)) ); 
		  cartaPorDto.setCopEntrega(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("ceorigenregistro", rs)) ); 
		  cartaPorDto.setRutaEntrega(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("ruta", rs)) );

		  cartaPorDto.setLatitud(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("latitud", rs)) );  
		  cartaPorDto.setLongitud(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("longitud", rs)) );   

		  
		  // Ajusta los datos de Estatus de documentos
		  
		  cartaPorDto.setIsdevolucion(ResultSetUtils.getRSString("isdevolucion", rs));
		  cartaPorDto.setIsenviadocte(ResultSetUtils.getRSString("isenviadocte", rs));
		  cartaPorDto.setIsliberado(ResultSetUtils.getRSString("isliberado", rs));
		  cartaPorDto.setIsrechazado(ResultSetUtils.getRSString("isrechazado", rs));
		  cartaPorDto.setIsrevisado(ResultSetUtils.getRSString("isrevisado", rs));

		  cartaPorDto.setOrigenEmbarque(ResultSetUtils.getRSString("origenEmbarque", rs));
		  cartaPorDto.setCossDock(ResultSetUtils.getRSString("cossdock", rs));
		  cartaPorDto.setOrderNumberSAP(ResultSetUtils.getRSString("ordernumbersap", rs));
		  cartaPorDto.setOrderCreationDate(rs .getString("ordercreationdate"));
		  cartaPorDto.setPurcharseOrder(ResultSetUtils.getRSString("purcharseorder", rs));
		  cartaPorDto.setShmtDocD(ResultSetUtils.getRSString("shmtdocd", rs));
		  cartaPorDto.setSoldParty(ResultSetUtils.getRSString("soldparty", rs));
		  cartaPorDto.setSoldtoPartyDesc(ResultSetUtils.getRSString("soldtopartydesc", rs));
		  cartaPorDto.setShipmentCreationDate(ResultSetUtils.getRSString("shipmentcreationdate", rs));
		  cartaPorDto.setRouteNumber(ResultSetUtils.getRSString("routenumber", rs));
		  cartaPorDto.setDeliveryCreationDate(ResultSetUtils.getRSString("deliverycreationdate", rs));
		 
		  cartaPorDto.setShippingPointCP(ResultSetUtils.getRSString("shippingpointcp", rs));
		  cartaPorDto.setCarrierNumber(ResultSetUtils.getRSString("carriernumber", rs));
		  cartaPorDto.setCarrierDescription(ResultSetUtils.getRSString("carrierdescription", rs));
		  cartaPorDto.setFechaSalidaMX33(ResultSetUtils.getRSString("fechasalidamx33", rs));
		  cartaPorDto.setFechaLlegadaL1(ResultSetUtils.getRSString("fechallegadal1", rs));
		  cartaPorDto.setFolioCita(ResultSetUtils.getRSString("foliocita", rs));
		  
		 
		  
		  cartaPorDto.setClaverechazo(ResultSetUtils.getRSString("claverechazo", rs));
		  cartaPorDto.setFoliorechazo(ResultSetUtils.getRSString("foliorechazo", rs));
		  cartaPorDto.setCantidadrechazo(ResultSetUtils.getRSInt("cantidadrechazo", rs));
		  cartaPorDto.setTiporechazo(ResultSetUtils.getRSString("tiporechazo", rs));
		  
		  cartaPorDto.setCita(("T".equals(ResultSetUtils.getRSString("cita", rs)) ? "SI" :
		  "NO"));
		  
		  //Ajusta guia de devolucion y casamiento
		  cartaPorDto.setIdGuiaDevolucion(ResultSetUtils.getRSString("iddevolucion", rs));
		  cartaPorDto.setIdGuiaCasamiento(ResultSetUtils.getRSString("idcasamiento", rs));

		  //Agrega los datos de remitente y destino 
		  cartaPorDto.remitente.setIdDocumento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idDocumento", rs))); 
		  cartaPorDto.setGuiainternacional(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("guiainternacional", rs)));  
		  
		  cartaPorDto.remitente.setRazonSocial(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("razonsocialrem", rs)));
		  cartaPorDto.remitente.setAtencion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("contactorem", rs)) );
		  cartaPorDto.remitente.setCalle(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("callerem", rs)) );
		  cartaPorDto.remitente.setDireccion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("direccionrem", rs)) );
		  cartaPorDto.remitente.setColonia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("coloniarem", rs)) );
		  cartaPorDto.remitente.setMunicipio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("municipiorem", rs)) );
		  cartaPorDto.remitente.setEstado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estadorem", rs)) );
		  cartaPorDto.remitente.setCp(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cprem", rs)) );
		  cartaPorDto.remitente.setTelefono(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("telefonorem", rs)) );
		  cartaPorDto.remitente.setRfc(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("rfcrem", rs)) );
		  cartaPorDto.remitente.setCorreoe(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("emailrem", rs)) );
		  cartaPorDto.remitente.setContrato(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("contratorem", rs)) ); 
		  
		  cartaPorDto.remitente.setPais(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("paisrem", rs)) ); 

		  
		  cartaPorDto.destinatario.setIdDocumento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idDocumento", rs))); 
		  cartaPorDto.destinatario.setRazonSocial(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("razonsocialdes", rs)));
		  cartaPorDto.destinatario.setAtencion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("contactodes", rs)) );
		  cartaPorDto.destinatario.setCalle(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("calledes", rs)) );
		  cartaPorDto.destinatario.setDireccion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("direcciondes", rs)) );
		  cartaPorDto.destinatario.setColonia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("coloniades", rs)) );
		  cartaPorDto.destinatario.setMunicipio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("municipiodes", rs)) );
		  cartaPorDto.destinatario.setEstado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estadodes", rs)) );
		  cartaPorDto.destinatario.setCp(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cpdes", rs)) );
		  cartaPorDto.destinatario.setTelefono(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("telefonodes", rs)) );
		  cartaPorDto.destinatario.setRfc(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("rfcdes", rs)) );
		  cartaPorDto.destinatario.setCorreoe(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("emaildes", rs)) );
		  cartaPorDto.destinatario.setContrato(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("contratodes", rs)) ); 
		  cartaPorDto.destinatario.setPais(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("paisdes", rs)) ); 
	  
		  cartaPorDto.setZonaDes(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("zonaDes", rs)) );
		  cartaPorDto.setZonaOri(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("zonaOri", rs)) );
		  
		  
		  cartaPorDto.setIdguiamadremultiple(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idguiamadremultiple", rs)) ); 

		  if (ResultSetUtils.getRSString("cofecha",rs)!=null){
			  cartaPorDto.setFechaConfirmacion(FechasTimeStamp.formatoTimeStamp(
					  rs.getTimestamp("cofecha"), this.formatofecha));
		  }
		  if (ResultSetUtils.getRSString("fechacita",rs)!=null){
			  cartaPorDto.setFechaCita(FechasTimeStamp.formatoFecha(
					  rs.getDate("fechacita"), "dd-MM-yyyy"));
		  }

		  if (ResultSetUtils.getRSString("fechaLimite",rs)!=null){
			  cartaPorDto.setFechaLimite(FechasTimeStamp.formatoFecha(
					  rs.getDate("fechaLimite"), "dd-MM-yyyy"));
		  }
		  if (ResultSetUtils.getRSString("fecharechazo",rs)!=null){
			  cartaPorDto.setFecharechazo(FechasTimeStamp.formatoFecha(
					  rs.getDate("fecharechazo"), "dd-MM-yyyy"));
		  }
		  
		  if ((ResultSetUtils.getRSString("isnota", rs)!=null) &&
				  (ResultSetUtils.getRSString("isnota", rs).trim().length()>0)){
			  cartaPorDto.setIsexistenota(ResultSetUtils.getRSString("isnota", rs)); 
		  }
		  
		  return cartaPorDto;
	}

}
