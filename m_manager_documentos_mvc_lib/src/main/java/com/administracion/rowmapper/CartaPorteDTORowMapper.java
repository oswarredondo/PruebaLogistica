
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.innovargia.utils.FechasTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.DocumentoDTO;
import com.servicio.dtos.Zona;

public class CartaPorteDTORowMapper implements RowMapper<DocumentoDTO>{

	String formatofecha = "dd-MM-yyyy HH:mm:ss";
	public CartaPorteDTORowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DocumentoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DocumentoDTO cartaPorDto  =new DocumentoDTO();
		
		 cartaPorDto.setIdServicio(rs.getString("idservicio"));
		  
		  cartaPorDto.entidad.setIdentidad(rs.getInt("identidad"));
		  cartaPorDto.organizacion.setIdorganizacion(rs
		  .getInt("idorganizacion"));
		  cartaPorDto.setIdDocumento(rs.getString("iddocumento"));
		  cartaPorDto.setNumCliente(rs.getString("numcliente"));
		  cartaPorDto.setIdTipoDocumento(rs.getString("idtipodocumento"));
		  cartaPorDto.datosCarta.setIdEnvio(rs.getString("iddocumento"));
		  cartaPorDto.setIdEnvio(rs.getString("iddocumento"));
		  cartaPorDto.setReferencia(rs.getString("referencia"));
		  cartaPorDto.setFecharecoleccion(FechasTimeStamp
		  .formatoTimeStamp(rs.getTimestamp("fecharecoleccion"),
		  this.formatofecha));
		  
		  cartaPorDto.setIdDocumentoPadre(rs .getString("iddocumentopadre"));
		  
		  cartaPorDto.setAlto(rs.getInt("alto"));
		  cartaPorDto.setAncho(rs.getInt("ancho"));
		  cartaPorDto.setLargo(rs.getInt("largo"));
		  cartaPorDto.setEstatus(rs.getString("estatus"));
		  cartaPorDto.setIdTerminalDestino(rs.getString("idterminaldes"));

		  cartaPorDto.setContenidoDeclarado(rs.getString("contenido"));
		  cartaPorDto.setFactura(rs.getString("factura"));
		  cartaPorDto.setIsfactura(rs.getString("isfacturada"));
		  cartaPorDto.setReferencia(rs.getString("referencia"));
		  
		  cartaPorDto.setPedimento(rs.getString("pedimento"));
		  cartaPorDto.setAduana(rs.getString("aduana"));
		  cartaPorDto.setNumPiezas(rs.getString("numpiezas"));
		  cartaPorDto.setPesoBruto(rs.getString("pesofisico"));
		  cartaPorDto.setPesoVolumetrico(rs.getString("pesovolumetrico"));
		  cartaPorDto.setValorDeclarado(rs.getString("valordeclarado"));
		  cartaPorDto
		  .datosCarta.setCantAsegurada(rs.getFloat("cantasegurada"));
		  
		  cartaPorDto.setTipoEmbalaje(rs.getString("tipodeembalaje"));
		  cartaPorDto.setObservaciones(rs.getString("observacion"));
		  
		  cartaPorDto.setDelivery(rs.getString("delivery"));
		  cartaPorDto.setEmbarque(rs.getString("shipment"));
		  
		  cartaPorDto.cruceZonas = new Zona();
		  cartaPorDto.cruceZonas.setPrecio(rs.getFloat("preciozona"));
		  cartaPorDto.cruceZonas.setZonaOrigen(rs.getString("zonaori"));
		  cartaPorDto.cruceZonas.setZonaDestino(rs.getString("zonades"));
		  cartaPorDto.setSiglasOrigen(rs.getString("zonaori"));
		  cartaPorDto.setSiglasDestino(rs.getString("zonades"));
		  
		  cartaPorDto.datosCarta.setFechaCreacion(FechasTimeStamp
		  .formatoTimeStamp(rs.getTimestamp("fechacreacion"),
		  this.formatofecha));
		  cartaPorDto.setFechaCita(FechasTimeStamp.formatoFecha(
		  rs.getDate("fechacita"), "dd-MM-yyyy"));
		  cartaPorDto.setHoraCita(rs.getString("horacita"));
		  
		  cartaPorDto.datosCarta.setLogin(rs.getString("login"));
		  cartaPorDto.setRuta(rs.getString("ruta"));
		  cartaPorDto.setManifiesto(rs.getString("manifiesto"));
		  
		  // Datos de confirmacion
		  cartaPorDto.datosCarta.confirmacion.setQuienRecibe(rs
		  .getString("conombre")); cartaPorDto.datosCarta.confirmacion
		  .setFechaConfirmacion(FechasTimeStamp.formatoTimeStamp(
		  rs.getTimestamp("cofecha"), this.formatofecha));
		  cartaPorDto.datosCarta.confirmacion
		  .setFechaentregapod(FechasTimeStamp.formatoTimeStamp(
		  rs.getTimestamp("fechaentregapod"), this.formatofecha));
		  
		  // Ajusta los datos de Estatus de documentos
		  
		  cartaPorDto.setIsdevolucion(rs.getString("isdevolucion"));
		  cartaPorDto.setIsenviadocte(rs.getString("isenviadocte"));
		  cartaPorDto.setIsliberado(rs.getString("isliberado"));
		  cartaPorDto.setIsrechazado(rs.getString("isrechazado"));
		  cartaPorDto.setIsrevisado(rs.getString("isrevisado"));

		  cartaPorDto.setFechaLimite(FechasTimeStamp.formatoFecha(
		  rs.getDate("fechaLimite"), "dd-MM-yyyy"));
		  cartaPorDto.setOrigenEmbarque(rs.getString("origenEmbarque"));
		  cartaPorDto.setCossDock(rs.getString("cossdock"));
		  cartaPorDto.setOrderNumberSAP(rs.getString("ordernumbersap"));
		  cartaPorDto.setOrderCreationDate(rs .getString("ordercreationdate"));
		  cartaPorDto.setPurcharseOrder(rs.getString("purcharseorder"));
		  cartaPorDto.setShmtDocD(rs.getString("shmtdocd"));
		  cartaPorDto.setSoldParty(rs.getString("soldparty"));
		  cartaPorDto.setSoldtoPartyDesc(rs.getString("soldtopartydesc"));
		  cartaPorDto.setShipmentCreationDate(rs.getString("shipmentcreationdate"));
		  cartaPorDto.setRouteNumber(rs.getString("routenumber"));
		  cartaPorDto.setDeliveryCreationDate(rs.getString("deliverycreationdate"));
		  cartaPorDto.setTPPt(rs.getString("tppt"));
		  cartaPorDto.setShippingPointCP(rs.getString("shippingpointcp"));
		  cartaPorDto.setCarrierNumber(rs.getString("carriernumber"));
		  cartaPorDto.setCarrierDescription(rs.getString("carrierdescription"));
		  cartaPorDto.setFechaSalidaMX33(rs.getString("fechasalidamx33"));
		  cartaPorDto.setFechaLlegadaL1(rs.getString("fechallegadal1"));
		  cartaPorDto.setFolioCita(rs.getString("foliocita"));
		  cartaPorDto.setFecharechazo(FechasTimeStamp.formatoFecha(
		  rs.getDate("fecharechazo"), "dd-MM-yyyy"));
		  cartaPorDto.setClaverechazo(rs.getString("claverechazo"));
		  cartaPorDto.setFoliorechazo(rs.getString("foliorechazo"));
		  cartaPorDto.setCantidadrechazo(rs.getInt("cantidadrechazo"));
		  cartaPorDto.setTiporechazo(rs.getString("tiporechazo"));
		  
		  cartaPorDto.setCita(("T".equals(rs.getString("cita")) ? "SI" :
		  "NO"));
		  
		  //Ajusta guia de devolucion y casamiento
		  cartaPorDto.setIdGuiaDevolucion(rs.getString("iddevolucion"));
		  cartaPorDto.setIdGuiaCasamiento(rs.getString("idcasamiento"));
		  
		  
		  if ((rs.getString("isnota")!=null) &&
				  (rs.getString("isnota").trim().length()>0)){
			  cartaPorDto.setIsexistenota(rs.getString("isnota")); 
		  }
		  
		  //Agrega los datos de remitente y destino 
		  cartaPorDto.remitente.setIdDocumento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idDocumento", rs))); 
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
		  
		  //JSON del documento
		  

		  return cartaPorDto;
	}

}
