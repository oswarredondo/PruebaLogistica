/**
 * 
 */
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.administracion.dto.DocumentoJson;
import com.innovargia.utils.FechasTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.DocumentoDTO;
import com.servicio.dtos.Zona;

/**
 * @author aruaro
 *
 */
public class DocumentoDTOMapper implements RowMapper<DocumentoDTO>{

	/**
	 * 
	 */
	String formatofecha = "dd-MM-yyyy HH:mm:ss";
	
	public DocumentoDTOMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public DocumentoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		DocumentoDTO documento  =new DocumentoDTO();
		
		 documento.setIdServicio(rs.getString("idservicio"));
		  
		  documento.entidad.setIdentidad(rs.getInt("identidad"));
		  documento.organizacion.setIdorganizacion(rs
		  .getInt("idorganizacion"));
		  documento.setIdDocumento(rs.getString("iddocumento"));
		  documento.setNumCliente(rs.getString("numcliente"));
		  documento.setIdTipoDocumento(rs.getString("idtipodocumento"));
		  documento.datosCarta.setIdEnvio(rs.getString("iddocumento"));
		  documento.setIdEnvio(rs.getString("iddocumento"));
		  documento.setReferencia(rs.getString("referencia"));
		  documento.setFecharecoleccion(FechasTimeStamp
		  .formatoTimeStamp(rs.getTimestamp("fecharecoleccion"),
		  this.formatofecha));
		  
		  documento.setIdDocumentoPadre(rs .getString("iddocumentopadre"));
		  
		  documento.setAlto(rs.getInt("alto"));
		  documento.setAncho(rs.getInt("ancho"));
		  documento.setLargo(rs.getInt("largo"));
		  documento.setEstatus(rs.getString("estatus"));
		  documento.setIdTerminalDestino(rs.getString("idterminaldes"));

		  documento.setContenidoDeclarado(rs.getString("contenido"));
		  documento.setFactura(rs.getString("factura"));
		  documento.setIsfactura(rs.getString("isfacturada"));
		  documento.setReferencia(rs.getString("referencia"));
		  
		  documento.setPedimento(rs.getString("pedimento"));
		  documento.setAduana(rs.getString("aduana"));
		  documento.setNumPiezas(rs.getString("numpiezas"));
		  documento.setPesoBruto(rs.getString("pesofisico"));
		  documento.setPesoVolumetrico(rs.getString("pesovolumetrico"));
		  documento.setValorDeclarado(rs.getString("valordeclarado"));
		  documento
		  .datosCarta.setCantAsegurada(rs.getFloat("cantasegurada"));
		  
		  documento.setTipoEmbalaje(rs.getString("tipodeembalaje"));
		  documento.setObservaciones(rs.getString("observacion"));
		  
		  documento.setDelivery(rs.getString("delivery"));
		  documento.setEmbarque(rs.getString("shipment"));
		  
		  documento.cruceZonas = new Zona();
		  documento.cruceZonas.setPrecio(rs.getFloat("preciozona"));
		  documento.cruceZonas.setZonaOrigen(rs.getString("zonaori"));
		  documento.cruceZonas.setZonaDestino(rs.getString("zonades"));
		  documento.setSiglasOrigen(rs.getString("zonaori"));
		  documento.setSiglasDestino(rs.getString("zonades"));
		  
		  documento.datosCarta.setFechaCreacion(FechasTimeStamp
		  .formatoTimeStamp(rs.getTimestamp("fechacreacion"),
		  this.formatofecha));
		  documento.setFechaCita(FechasTimeStamp.formatoFecha(
		  rs.getDate("fechacita"), "dd-MM-yyyy"));
		  documento.setHoraCita(rs.getString("horacita"));
		  
		  documento.datosCarta.setLogin(rs.getString("login"));
		  documento.setRuta(rs.getString("ruta"));
		  documento.setManifiesto(rs.getString("manifiesto"));
		  
		  /* Datos de confirmacion
		  documento.datosCarta.confirmacion.setQuienRecibe(rs
		  .getString("conombre")); documento.datosCarta.confirmacion
		  .setFechaConfirmacion(FechasTimeStamp.formatoTimeStamp(
		  rs.getTimestamp("cofecha"), this.formatofecha));
		  documento.datosCarta.confirmacion
		  .setFechaentregapod(FechasTimeStamp.formatoTimeStamp(
		  rs.getTimestamp("fechaentregapod"), this.formatofecha));
		  */
		  
		  // Ajusta los datos de Estatus de documentos
		  
		  documento.setIsdevolucion(rs.getString("isdevolucion"));
		  documento.setIsenviadocte(rs.getString("isenviadocte"));
		  documento.setIsliberado(rs.getString("isliberado"));
		  documento.setIsrechazado(rs.getString("isrechazado"));
		  documento.setIsrevisado(rs.getString("isrevisado"));

		  documento.setFechaLimite(FechasTimeStamp.formatoFecha(
		  rs.getDate("fechaLimite"), "dd-MM-yyyy"));
		  documento.setOrigenEmbarque(rs.getString("origenEmbarque"));
		  documento.setCossDock(rs.getString("cossdock"));
		  documento.setOrderNumberSAP(rs.getString("ordernumbersap"));
		  documento.setOrderCreationDate(rs .getString("ordercreationdate"));
		  documento.setPurcharseOrder(rs.getString("purcharseorder"));
		  documento.setShmtDocD(rs.getString("shmtdocd"));
		  documento.setSoldParty(rs.getString("soldparty"));
		  documento.setSoldtoPartyDesc(rs.getString("soldtopartydesc"));
		  documento.setShipmentCreationDate(rs.getString("shipmentcreationdate"));
		  documento.setRouteNumber(rs.getString("routenumber"));
		  documento.setDeliveryCreationDate(rs.getString("deliverycreationdate"));
		  documento.setTPPt(rs.getString("tppt"));
		  documento.setShippingPointCP(rs.getString("shippingpointcp"));
		  documento.setCarrierNumber(rs.getString("carriernumber"));
		  documento.setCarrierDescription(rs.getString("carrierdescription"));
		  documento.setFechaSalidaMX33(rs.getString("fechasalidamx33"));
		  documento.setFechaLlegadaL1(rs.getString("fechallegadal1"));
		  documento.setFolioCita(rs.getString("foliocita"));
		  documento.setFecharechazo(FechasTimeStamp.formatoFecha(
		  rs.getDate("fecharechazo"), "dd-MM-yyyy"));
		  documento.setClaverechazo(rs.getString("claverechazo"));
		  documento.setFoliorechazo(rs.getString("foliorechazo"));
		  documento.setCantidadrechazo(rs.getInt("cantidadrechazo"));
		  documento.setTiporechazo(rs.getString("tiporechazo"));
		  
		  documento.setCita(("T".equals(rs.getString("cita")) ? "SI" :
		  "NO"));
		  
		  /* Ajusta guia de devolucion y casamiento
		  documento.setIdGuiaDevolucion(rs.getString("iddevolucion"));
		  documento.setIdGuiaCasamiento(rs.getString("idcasamiento"));
		  
		  
		  if ((rs.getString("isnota")!=null) &&
				  (rs.getString("isnota").trim().length()>0)){
			  documento.setIsexistenota(rs.getString("isnota")); 
		  }
		  
		  */
		  
		  //Agrega los datos de remitente y destino 
		  documento.remitente.setIdDocumento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idDocumento", rs))); 
		  documento.remitente.setRazonSocial(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("razonsocialrem", rs)));
		  documento.remitente.setAtencion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("contactorem", rs)) );
		  documento.remitente.setCalle(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("callerem", rs)) );
		  documento.remitente.setDireccion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("direccionrem", rs)) );
		  documento.remitente.setColonia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("coloniarem", rs)) );
		  documento.remitente.setMunicipio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("municipiorem", rs)) );
		  documento.remitente.setEstado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estadorem", rs)) );
		  documento.remitente.setCp(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cprem", rs)) );
		  documento.remitente.setTelefono(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("telefonorem", rs)) );
		  documento.remitente.setRfc(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("rfcrem", rs)) );
		  documento.remitente.setCorreoe(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("emailrem", rs)) );
		  documento.remitente.setContrato(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("contratorem", rs)) ); 
		  
		  documento.destinatario.setIdDocumento(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("idDocumento", rs))); 
		  documento.destinatario.setRazonSocial(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("razonsocialdes", rs)));
		  documento.destinatario.setAtencion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("contactodes", rs)) );
		  documento.destinatario.setCalle(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("calledes", rs)) );
		  documento.destinatario.setDireccion(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("direcciondes", rs)) );
		  documento.destinatario.setColonia(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("coloniades", rs)) );
		  documento.destinatario.setMunicipio(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("municipiodes", rs)) );
		  documento.destinatario.setEstado(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("estadodes", rs)) );
		  documento.destinatario.setCp(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("cpdes", rs)) );
		  documento.destinatario.setTelefono(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("telefonodes", rs)) );
		  documento.destinatario.setRfc(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("rfcdes", rs)) );
		  documento.destinatario.setCorreoe(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("emaildes", rs)) );
		  documento.destinatario.setContrato(UtilsStringFechas.convierteCadenaNULL(ResultSetUtils.getRSString("contratodes", rs)) ); 
		  
		  //JSON del documento
		  

		  return documento;
	}

}
