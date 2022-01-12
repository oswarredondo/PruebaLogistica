/**
 * 
 */
package com.servicio.dtos;

import java.io.Serializable;

import com.innovargia.salesmanager.dtos.RemDes;

/**
 * @author aruaro
 *
 */
public class DocumentoConsultaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		//Datos tabla
		private String idDocumento;
		
		private String idDocumentoMadre;
		
		public String getIdDocumentoMadre() {
			return idDocumentoMadre;
		}

		public void setIdDocumentoMadre(String idDocumentoMadre) {
			this.idDocumentoMadre = idDocumentoMadre;
		}

		private String guiainternacional;
		private String idDocumentoPadre;
		private String idGuiaCasamiento;
		private String idGuiaDevolucion;
		private int identidad;
		private int idorganizacion;
		
		private String es_nacional;
		private String idguiamadremultiple;
		
		private String numCliente;
		private String fechaConfirmacion;
		private String quienRecibe;
		private String plazaEntrega;
		private String copEntrega;
		private String rutaEntrega;
		
		private String login;
		private String idOficina;
		private String idServicio;
		private String idTipoCobro;
		private String idTipoPago;
		private String idAdicional;
		private String idTerminalOrigen;
		private String idTerminalDestino;
		private String idTipoDocumento;
		private String fechaCreacion;
		private String comentario;
		private String estatus;
		private String referencia;
		private float valorDeclarado;
		private float pesoBruto;
		private float pesoVolumetrico;
		private float volumen;
		private float sobrePeso;
		private int largo;
		private int ancho;
		private int alto;
		private float iva;
		private float precioZona;
		private String factura;
		private String isfactura;
		private String pedimento;
		private String aduana;
		private String tipoEmbalaje;
		private String contenidoDeclarado;
		private String enrutamiento;
		private String marcaFactura;
		private String marcaRetornoDocumento;
		private int consecutivo;
		private int numPiezas = 0;
		private int porcentajeIva;
		private int porcentajeRetencion;
		private String observaciones;
		private String zonaOri;
		private String zonaDes;
		private String ruta;
		private String manifiesto;
		private String fechaManifiesto;
		private String cita;
		private String horaCita;
		private String fechaCita;
		private String embarque; //Shipment
		private String delivery; 
		private String fecharecoleccion;
		
		//Datos adicionales
		private String servicio;
		private String descripcio_servicio;
		private String datos_carta;
		private String descripcion_garantia;
		private String idEnvio;
		private String siglasOrigen;
		private String razonSocialDestino;
		private String razonSocialRemitente;
		private String razonSocialFacturacion;
		private String razonSocialRecoleccion;
		
		private String ciaSeguro;
		private String numPoliza;
		private String inciso;
		
		private String fechaAsignacion;
		private String fechaLimite;
		
		//Solicitante
		private String quienSolcita;
		private String telefonoQuienSolicita;
		private String emailQuienSolicita;
		private String flejado;
		private String transportista;
		
		//Datos de estatus de documentos
		private String isdevolucion =null;
		private String isrevisado=null;
		private String isenviadocte =null;
		private String isrechazado =null;
		private String isliberado =null;
		private String isexistenota=null;
		
		//Datos de tipo de direccion 
		//Datos remitente
		public RemDes remitente = new RemDes();
		// Datos del Destino
		public RemDes destinatario = new RemDes();
		// Datos del recoleccion
		public RemDes recoleccion = new RemDes();
		// Datos Facturacion
		public RemDes domicionfiscal = new RemDes();
		
		private String origenEmbarque=null;
		
		private String cossDock=null;
		private String orderNumberSAP=null;
		private String orderCreationDate=null;
		private String purcharseOrder=null;
		private String shmtDocD=null;
		private String soldParty=null;
		private String soldtoPartyDesc=null;
		private String soldtoPartyData;
		private String shipmentCreationDate=null;
		private String routeNumber=null;
		private String deliveryCreationDate=null;
		private String tPPt=null;
		private String shippingPointCP=null;
		private String carrierNumber=null;
		private String carrierDescription=null;
		private String fechaSalidaMX33=null;
		private String fechaLlegadaL1=null;
		private String folioCita=null;
		
		private String fecharechazo;
		private String claverechazo ;
		private String foliorechazo ;
		private int   cantidadrechazo;
		private float billValue =0;
		private String proofDate;

		//Datos de materiales
		private String planta;
		private String idMaterial;
		private float pesoToneladas;
		private String creadoPor;
		private float cantidadEnPallet;
		private int cantidadCasos;
		private String descripcionmaterial;
		private String tiporechazo;
		private String baseUnit;
		private boolean soloConCita=false;
		
		private int vigencia=-1; //el documento tiene vigencia ilimitada
		//Cuandi tiene este valor es que no tiene indice, se pone este para que a 
		//los que no se les asigna siempre vayan al final
		private int pos_manif=32000; 
		private String unidadreparto;
		
		private String zonaVenta;
		
		private int pesoAmparadoFolios=0;
		
		private String tiporecepcion;
		private String latitud;
		private String longitud;
		
		private String descripcionError;
		
		private String razonsocial;
		
	/**
	 * 
	 */
	public DocumentoConsultaDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idDocumento
	 */
	public String getIdDocumento() {
		return idDocumento;
	}

	/**
	 * @param idDocumento the idDocumento to set
	 */
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	/**
	 * @return the idDocumentoPadre
	 */
	public String getIdDocumentoPadre() {
		return idDocumentoPadre;
	}

	/**
	 * @param idDocumentoPadre the idDocumentoPadre to set
	 */
	public void setIdDocumentoPadre(String idDocumentoPadre) {
		this.idDocumentoPadre = idDocumentoPadre;
	}

	/**
	 * @return the idGuiaCasamiento
	 */
	public String getIdGuiaCasamiento() {
		return idGuiaCasamiento;
	}

	/**
	 * @param idGuiaCasamiento the idGuiaCasamiento to set
	 */
	public void setIdGuiaCasamiento(String idGuiaCasamiento) {
		this.idGuiaCasamiento = idGuiaCasamiento;
	}

	/**
	 * @return the idGuiaDevolucion
	 */
	public String getIdGuiaDevolucion() {
		return idGuiaDevolucion;
	}

	/**
	 * @param idGuiaDevolucion the idGuiaDevolucion to set
	 */
	public void setIdGuiaDevolucion(String idGuiaDevolucion) {
		this.idGuiaDevolucion = idGuiaDevolucion;
	}

	/**
	 * @return the numCliente
	 */
	public String getNumCliente() {
		return numCliente;
	}

	/**
	 * @param numCliente the numCliente to set
	 */
	public void setNumCliente(String numCliente) {
		this.numCliente = numCliente;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the idOficina
	 */
	public String getIdOficina() {
		return idOficina;
	}

	/**
	 * @param idOficina the idOficina to set
	 */
	public void setIdOficina(String idOficina) {
		this.idOficina = idOficina;
	}

	/**
	 * @return the idServicio
	 */
	public String getIdServicio() {
		return idServicio;
	}

	/**
	 * @param idServicio the idServicio to set
	 */
	public void setIdServicio(String idServicio) {
		this.idServicio = idServicio;
	}

	/**
	 * @return the idTipoCobro
	 */
	public String getIdTipoCobro() {
		return idTipoCobro;
	}

	/**
	 * @param idTipoCobro the idTipoCobro to set
	 */
	public void setIdTipoCobro(String idTipoCobro) {
		this.idTipoCobro = idTipoCobro;
	}

	/**
	 * @return the idTipoPago
	 */
	public String getIdTipoPago() {
		return idTipoPago;
	}

	/**
	 * @param idTipoPago the idTipoPago to set
	 */
	public void setIdTipoPago(String idTipoPago) {
		this.idTipoPago = idTipoPago;
	}

	/**
	 * @return the idAdicional
	 */
	public String getIdAdicional() {
		return idAdicional;
	}

	/**
	 * @param idAdicional the idAdicional to set
	 */
	public void setIdAdicional(String idAdicional) {
		this.idAdicional = idAdicional;
	}

	/**
	 * @return the idTerminalOrigen
	 */
	public String getIdTerminalOrigen() {
		return idTerminalOrigen;
	}

	/**
	 * @param idTerminalOrigen the idTerminalOrigen to set
	 */
	public void setIdTerminalOrigen(String idTerminalOrigen) {
		this.idTerminalOrigen = idTerminalOrigen;
	}

	/**
	 * @return the idTerminalDestino
	 */
	public String getIdTerminalDestino() {
		return idTerminalDestino;
	}

	/**
	 * @param idTerminalDestino the idTerminalDestino to set
	 */
	public void setIdTerminalDestino(String idTerminalDestino) {
		this.idTerminalDestino = idTerminalDestino;
	}

	/**
	 * @return the idTipoDocumento
	 */
	public String getIdTipoDocumento() {
		return idTipoDocumento;
	}

	/**
	 * @param idTipoDocumento the idTipoDocumento to set
	 */
	public void setIdTipoDocumento(String idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	/**
	 * @return the fechaCreacion
	 */
	public String getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * @return the valorDeclarado
	 */
	public float getValorDeclarado() {
		return valorDeclarado;
	}

	/**
	 * @param valorDeclarado the valorDeclarado to set
	 */
	public void setValorDeclarado(float valorDeclarado) {
		this.valorDeclarado = valorDeclarado;
	}

	/**
	 * @return the pesoBruto
	 */
	public float getPesoBruto() {
		return pesoBruto;
	}

	/**
	 * @param pesoBruto the pesoBruto to set
	 */
	public void setPesoBruto(float pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	/**
	 * @return the pesoVolumetrico
	 */
	public float getPesoVolumetrico() {
		return pesoVolumetrico;
	}

	/**
	 * @param pesoVolumetrico the pesoVolumetrico to set
	 */
	public void setPesoVolumetrico(float pesoVolumetrico) {
		this.pesoVolumetrico = pesoVolumetrico;
	}

	/**
	 * @return the volumen
	 */
	public float getVolumen() {
		return volumen;
	}

	/**
	 * @param volumen the volumen to set
	 */
	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	/**
	 * @return the sobrePeso
	 */
	public float getSobrePeso() {
		return sobrePeso;
	}

	/**
	 * @param sobrePeso the sobrePeso to set
	 */
	public void setSobrePeso(float sobrePeso) {
		this.sobrePeso = sobrePeso;
	}

	/**
	 * @return the largo
	 */
	public int getLargo() {
		return largo;
	}

	/**
	 * @param largo the largo to set
	 */
	public void setLargo(int largo) {
		this.largo = largo;
	}

	/**
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}

	/**
	 * @return the iva
	 */
	public float getIva() {
		return iva;
	}

	/**
	 * @param iva the iva to set
	 */
	public void setIva(float iva) {
		this.iva = iva;
	}

	/**
	 * @return the precioZona
	 */
	public float getPrecioZona() {
		return precioZona;
	}

	/**
	 * @param precioZona the precioZona to set
	 */
	public void setPrecioZona(float precioZona) {
		this.precioZona = precioZona;
	}

	/**
	 * @return the factura
	 */
	public String getFactura() {
		return factura;
	}

	/**
	 * @param factura the factura to set
	 */
	public void setFactura(String factura) {
		this.factura = factura;
	}

	/**
	 * @return the isfactura
	 */
	public String getIsfactura() {
		return isfactura;
	}

	/**
	 * @param isfactura the isfactura to set
	 */
	public void setIsfactura(String isfactura) {
		this.isfactura = isfactura;
	}

	/**
	 * @return the pedimento
	 */
	public String getPedimento() {
		return pedimento;
	}

	/**
	 * @param pedimento the pedimento to set
	 */
	public void setPedimento(String pedimento) {
		this.pedimento = pedimento;
	}

	/**
	 * @return the aduana
	 */
	public String getAduana() {
		return aduana;
	}

	/**
	 * @param aduana the aduana to set
	 */
	public void setAduana(String aduana) {
		this.aduana = aduana;
	}

	/**
	 * @return the tipoEmbalaje
	 */
	public String getTipoEmbalaje() {
		return tipoEmbalaje;
	}

	/**
	 * @param tipoEmbalaje the tipoEmbalaje to set
	 */
	public void setTipoEmbalaje(String tipoEmbalaje) {
		this.tipoEmbalaje = tipoEmbalaje;
	}

	/**
	 * @return the contenidoDeclarado
	 */
	public String getContenidoDeclarado() {
		return contenidoDeclarado;
	}

	/**
	 * @param contenidoDeclarado the contenidoDeclarado to set
	 */
	public void setContenidoDeclarado(String contenidoDeclarado) {
		this.contenidoDeclarado = contenidoDeclarado;
	}

	/**
	 * @return the enrutamiento
	 */
	public String getEnrutamiento() {
		return enrutamiento;
	}

	/**
	 * @param enrutamiento the enrutamiento to set
	 */
	public void setEnrutamiento(String enrutamiento) {
		this.enrutamiento = enrutamiento;
	}

	/**
	 * @return the marcaFactura
	 */
	public String getMarcaFactura() {
		return marcaFactura;
	}

	/**
	 * @param marcaFactura the marcaFactura to set
	 */
	public void setMarcaFactura(String marcaFactura) {
		this.marcaFactura = marcaFactura;
	}

	/**
	 * @return the marcaRetornoDocumento
	 */
	public String getMarcaRetornoDocumento() {
		return marcaRetornoDocumento;
	}

	/**
	 * @param marcaRetornoDocumento the marcaRetornoDocumento to set
	 */
	public void setMarcaRetornoDocumento(String marcaRetornoDocumento) {
		this.marcaRetornoDocumento = marcaRetornoDocumento;
	}

	/**
	 * @return the consecutivo
	 */
	public int getConsecutivo() {
		return consecutivo;
	}

	/**
	 * @param consecutivo the consecutivo to set
	 */
	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}

	
	public void setConsecutivo(String consecutivo) {
		try{
			this.consecutivo = Integer.parseInt(consecutivo);
		}catch(Exception e){
			this.consecutivo =0;
		}
		
	}

	/**
	 * @return the numPiezas
	 */
	public int getNumPiezas() {
		return numPiezas;
	}

	/**
	 * @param numPiezas the numPiezas to set
	 */
	public void setNumPiezas(int numPiezas) {
		this.numPiezas = numPiezas;
	}

	/**
	 * @return the porcentajeIva
	 */
	public int getPorcentajeIva() {
		return porcentajeIva;
	}

	/**
	 * @param porcentajeIva the porcentajeIva to set
	 */
	public void setPorcentajeIva(int porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}

	/**
	 * @return the porcentajeRetencion
	 */
	public int getPorcentajeRetencion() {
		return porcentajeRetencion;
	}

	/**
	 * @param porcentajeRetencion the porcentajeRetencion to set
	 */
	public void setPorcentajeRetencion(int porcentajeRetencion) {
		this.porcentajeRetencion = porcentajeRetencion;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * @return the zonaOri
	 */
	public String getZonaOri() {
		return zonaOri;
	}

	/**
	 * @param zonaOri the zonaOri to set
	 */
	public void setZonaOri(String zonaOri) {
		this.zonaOri = zonaOri;
	}

	/**
	 * @return the zonaDes
	 */
	public String getZonaDes() {
		return zonaDes;
	}

	/**
	 * @param zonaDes the zonaDes to set
	 */
	public void setZonaDes(String zonaDes) {
		this.zonaDes = zonaDes;
	}

	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}

	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * @return the manifiesto
	 */
	public String getManifiesto() {
		return manifiesto;
	}

	/**
	 * @param manifiesto the manifiesto to set
	 */
	public void setManifiesto(String manifiesto) {
		this.manifiesto = manifiesto;
	}

	/**
	 * @return the fechaManifiesto
	 */
	public String getFechaManifiesto() {
		return fechaManifiesto;
	}

	/**
	 * @param fechaManifiesto the fechaManifiesto to set
	 */
	public void setFechaManifiesto(String fechaManifiesto) {
		this.fechaManifiesto = fechaManifiesto;
	}

	/**
	 * @return the cita
	 */
	public String getCita() {
		return cita;
	}

	/**
	 * @param cita the cita to set
	 */
	public void setCita(String cita) {
		this.cita = cita;
	}

	/**
	 * @return the horaCita
	 */
	public String getHoraCita() {
		return horaCita;
	}

	/**
	 * @param horaCita the horaCita to set
	 */
	public void setHoraCita(String horaCita) {
		this.horaCita = horaCita;
	}

	/**
	 * @return the fechaCita
	 */
	public String getFechaCita() {
		return fechaCita;
	}

	/**
	 * @param fechaCita the fechaCita to set
	 */
	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}

	/**
	 * @return the embarque
	 */
	public String getEmbarque() {
		return embarque;
	}

	/**
	 * @param embarque the embarque to set
	 */
	public void setEmbarque(String embarque) {
		this.embarque = embarque;
	}

	/**
	 * @return the delivery
	 */
	public String getDelivery() {
		return delivery;
	}

	/**
	 * @param delivery the delivery to set
	 */
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	/**
	 * @return the fecharecoleccion
	 */
	public String getFecharecoleccion() {
		return fecharecoleccion;
	}

	/**
	 * @param fecharecoleccion the fecharecoleccion to set
	 */
	public void setFecharecoleccion(String fecharecoleccion) {
		this.fecharecoleccion = fecharecoleccion;
	}

	/**
	 * @return the servicio
	 */
	public String getServicio() {
		return servicio;
	}

	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	/**
	 * @return the descripcio_servicio
	 */
	public String getDescripcio_servicio() {
		return descripcio_servicio;
	}

	/**
	 * @param descripcio_servicio the descripcio_servicio to set
	 */
	public void setDescripcio_servicio(String descripcio_servicio) {
		this.descripcio_servicio = descripcio_servicio;
	}

	/**
	 * @return the datos_carta
	 */
	public String getDatos_carta() {
		return datos_carta;
	}

	/**
	 * @param datos_carta the datos_carta to set
	 */
	public void setDatos_carta(String datos_carta) {
		this.datos_carta = datos_carta;
	}

	/**
	 * @return the descripcion_garantia
	 */
	public String getDescripcion_garantia() {
		return descripcion_garantia;
	}

	/**
	 * @param descripcion_garantia the descripcion_garantia to set
	 */
	public void setDescripcion_garantia(String descripcion_garantia) {
		this.descripcion_garantia = descripcion_garantia;
	}

	/**
	 * @return the idEnvio
	 */
	public String getIdEnvio() {
		return idEnvio;
	}

	/**
	 * @param idEnvio the idEnvio to set
	 */
	public void setIdEnvio(String idEnvio) {
		this.idEnvio = idEnvio;
	}

	/**
	 * @return the siglasOrigen
	 */
	public String getSiglasOrigen() {
		return siglasOrigen;
	}

	/**
	 * @param siglasOrigen the siglasOrigen to set
	 */
	public void setSiglasOrigen(String siglasOrigen) {
		this.siglasOrigen = siglasOrigen;
	}

	/**
	 * @return the razonSocialDestino
	 */
	public String getRazonSocialDestino() {
		return razonSocialDestino;
	}

	/**
	 * @param razonSocialDestino the razonSocialDestino to set
	 */
	public void setRazonSocialDestino(String razonSocialDestino) {
		this.razonSocialDestino = razonSocialDestino;
	}

	/**
	 * @return the razonSocialRemitente
	 */
	public String getRazonSocialRemitente() {
		return razonSocialRemitente;
	}

	/**
	 * @param razonSocialRemitente the razonSocialRemitente to set
	 */
	public void setRazonSocialRemitente(String razonSocialRemitente) {
		this.razonSocialRemitente = razonSocialRemitente;
	}

	/**
	 * @return the razonSocialFacturacion
	 */
	public String getRazonSocialFacturacion() {
		return razonSocialFacturacion;
	}

	/**
	 * @param razonSocialFacturacion the razonSocialFacturacion to set
	 */
	public void setRazonSocialFacturacion(String razonSocialFacturacion) {
		this.razonSocialFacturacion = razonSocialFacturacion;
	}

	/**
	 * @return the razonSocialRecoleccion
	 */
	public String getRazonSocialRecoleccion() {
		return razonSocialRecoleccion;
	}

	/**
	 * @param razonSocialRecoleccion the razonSocialRecoleccion to set
	 */
	public void setRazonSocialRecoleccion(String razonSocialRecoleccion) {
		this.razonSocialRecoleccion = razonSocialRecoleccion;
	}

	/**
	 * @return the ciaSeguro
	 */
	public String getCiaSeguro() {
		return ciaSeguro;
	}

	/**
	 * @param ciaSeguro the ciaSeguro to set
	 */
	public void setCiaSeguro(String ciaSeguro) {
		this.ciaSeguro = ciaSeguro;
	}

	/**
	 * @return the numPoliza
	 */
	public String getNumPoliza() {
		return numPoliza;
	}

	/**
	 * @param numPoliza the numPoliza to set
	 */
	public void setNumPoliza(String numPoliza) {
		this.numPoliza = numPoliza;
	}

	/**
	 * @return the inciso
	 */
	public String getInciso() {
		return inciso;
	}

	/**
	 * @param inciso the inciso to set
	 */
	public void setInciso(String inciso) {
		this.inciso = inciso;
	}

	/**
	 * @return the fechaAsignacion
	 */
	public String getFechaAsignacion() {
		return fechaAsignacion;
	}

	/**
	 * @param fechaAsignacion the fechaAsignacion to set
	 */
	public void setFechaAsignacion(String fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	/**
	 * @return the fechaLimite
	 */
	public String getFechaLimite() {
		return fechaLimite;
	}

	/**
	 * @param fechaLimite the fechaLimite to set
	 */
	public void setFechaLimite(String fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	/**
	 * @return the quienSolcita
	 */
	public String getQuienSolcita() {
		return quienSolcita;
	}

	/**
	 * @param quienSolcita the quienSolcita to set
	 */
	public void setQuienSolcita(String quienSolcita) {
		this.quienSolcita = quienSolcita;
	}

	/**
	 * @return the telefonoQuienSolicita
	 */
	public String getTelefonoQuienSolicita() {
		return telefonoQuienSolicita;
	}

	/**
	 * @param telefonoQuienSolicita the telefonoQuienSolicita to set
	 */
	public void setTelefonoQuienSolicita(String telefonoQuienSolicita) {
		this.telefonoQuienSolicita = telefonoQuienSolicita;
	}

	/**
	 * @return the emailQuienSolicita
	 */
	public String getEmailQuienSolicita() {
		return emailQuienSolicita;
	}

	/**
	 * @param emailQuienSolicita the emailQuienSolicita to set
	 */
	public void setEmailQuienSolicita(String emailQuienSolicita) {
		this.emailQuienSolicita = emailQuienSolicita;
	}

	/**
	 * @return the flejado
	 */
	public String getFlejado() {
		return flejado;
	}

	/**
	 * @param flejado the flejado to set
	 */
	public void setFlejado(String flejado) {
		this.flejado = flejado;
	}

	/**
	 * @return the transportista
	 */
	public String getTransportista() {
		return transportista;
	}

	/**
	 * @param transportista the transportista to set
	 */
	public void setTransportista(String transportista) {
		this.transportista = transportista;
	}

	/**
	 * @return the isdevolucion
	 */
	public String getIsdevolucion() {
		return isdevolucion;
	}

	/**
	 * @param isdevolucion the isdevolucion to set
	 */
	public void setIsdevolucion(String isdevolucion) {
		this.isdevolucion = isdevolucion;
	}

	/**
	 * @return the isrevisado
	 */
	public String getIsrevisado() {
		return isrevisado;
	}

	/**
	 * @param isrevisado the isrevisado to set
	 */
	public void setIsrevisado(String isrevisado) {
		this.isrevisado = isrevisado;
	}

	/**
	 * @return the isenviadocte
	 */
	public String getIsenviadocte() {
		return isenviadocte;
	}

	/**
	 * @param isenviadocte the isenviadocte to set
	 */
	public void setIsenviadocte(String isenviadocte) {
		this.isenviadocte = isenviadocte;
	}

	/**
	 * @return the isrechazado
	 */
	public String getIsrechazado() {
		return isrechazado;
	}

	/**
	 * @param isrechazado the isrechazado to set
	 */
	public void setIsrechazado(String isrechazado) {
		this.isrechazado = isrechazado;
	}

	/**
	 * @return the isliberado
	 */
	public String getIsliberado() {
		return isliberado;
	}

	/**
	 * @param isliberado the isliberado to set
	 */
	public void setIsliberado(String isliberado) {
		this.isliberado = isliberado;
	}

	/**
	 * @return the isexistenota
	 */
	public String getIsexistenota() {
		return isexistenota;
	}

	/**
	 * @param isexistenota the isexistenota to set
	 */
	public void setIsexistenota(String isexistenota) {
		this.isexistenota = isexistenota;
	}

	/**
	 * @return the remitente
	 */
	public RemDes getRemitente() {
		return remitente;
	}

	/**
	 * @param remitente the remitente to set
	 */
	public void setRemitente(RemDes remitente) {
		this.remitente = remitente;
	}

	/**
	 * @return the destinatario
	 */
	public RemDes getDestinatario() {
		return destinatario;
	}

	/**
	 * @param destinatario the destinatario to set
	 */
	public void setDestinatario(RemDes destinatario) {
		this.destinatario = destinatario;
	}

	/**
	 * @return the recoleccion
	 */
	public RemDes getRecoleccion() {
		return recoleccion;
	}

	/**
	 * @param recoleccion the recoleccion to set
	 */
	public void setRecoleccion(RemDes recoleccion) {
		this.recoleccion = recoleccion;
	}

	/**
	 * @return the domicionfiscal
	 */
	public RemDes getDomicionfiscal() {
		return domicionfiscal;
	}

	/**
	 * @param domicionfiscal the domicionfiscal to set
	 */
	public void setDomicionfiscal(RemDes domicionfiscal) {
		this.domicionfiscal = domicionfiscal;
	}

	/**
	 * @return the origenEmbarque
	 */
	public String getOrigenEmbarque() {
		return origenEmbarque;
	}

	/**
	 * @param origenEmbarque the origenEmbarque to set
	 */
	public void setOrigenEmbarque(String origenEmbarque) {
		this.origenEmbarque = origenEmbarque;
	}

	/**
	 * @return the cossDock
	 */
	public String getCossDock() {
		return cossDock;
	}

	/**
	 * @param cossDock the cossDock to set
	 */
	public void setCossDock(String cossDock) {
		this.cossDock = cossDock;
	}

	/**
	 * @return the orderNumberSAP
	 */
	public String getOrderNumberSAP() {
		return orderNumberSAP;
	}

	/**
	 * @param orderNumberSAP the orderNumberSAP to set
	 */
	public void setOrderNumberSAP(String orderNumberSAP) {
		this.orderNumberSAP = orderNumberSAP;
	}

	/**
	 * @return the orderCreationDate
	 */
	public String getOrderCreationDate() {
		return orderCreationDate;
	}

	/**
	 * @param orderCreationDate the orderCreationDate to set
	 */
	public void setOrderCreationDate(String orderCreationDate) {
		this.orderCreationDate = orderCreationDate;
	}

	/**
	 * @return the purcharseOrder
	 */
	public String getPurcharseOrder() {
		return purcharseOrder;
	}

	/**
	 * @param purcharseOrder the purcharseOrder to set
	 */
	public void setPurcharseOrder(String purcharseOrder) {
		this.purcharseOrder = purcharseOrder;
	}

	/**
	 * @return the shmtDocD
	 */
	public String getShmtDocD() {
		return shmtDocD;
	}

	/**
	 * @param shmtDocD the shmtDocD to set
	 */
	public void setShmtDocD(String shmtDocD) {
		this.shmtDocD = shmtDocD;
	}

	/**
	 * @return the soldParty
	 */
	public String getSoldParty() {
		return soldParty;
	}

	/**
	 * @param soldParty the soldParty to set
	 */
	public void setSoldParty(String soldParty) {
		this.soldParty = soldParty;
	}

	/**
	 * @return the soldtoPartyDesc
	 */
	public String getSoldtoPartyDesc() {
		return soldtoPartyDesc;
	}

	/**
	 * @param soldtoPartyDesc the soldtoPartyDesc to set
	 */
	public void setSoldtoPartyDesc(String soldtoPartyDesc) {
		this.soldtoPartyDesc = soldtoPartyDesc;
	}

	/**
	 * @return the soldtoPartyData
	 */
	public String getSoldtoPartyData() {
		return soldtoPartyData;
	}

	/**
	 * @param soldtoPartyData the soldtoPartyData to set
	 */
	public void setSoldtoPartyData(String soldtoPartyData) {
		this.soldtoPartyData = soldtoPartyData;
	}

	/**
	 * @return the shipmentCreationDate
	 */
	public String getShipmentCreationDate() {
		return shipmentCreationDate;
	}

	/**
	 * @param shipmentCreationDate the shipmentCreationDate to set
	 */
	public void setShipmentCreationDate(String shipmentCreationDate) {
		this.shipmentCreationDate = shipmentCreationDate;
	}

	/**
	 * @return the routeNumber
	 */
	public String getRouteNumber() {
		return routeNumber;
	}

	/**
	 * @param routeNumber the routeNumber to set
	 */
	public void setRouteNumber(String routeNumber) {
		this.routeNumber = routeNumber;
	}

	/**
	 * @return the deliveryCreationDate
	 */
	public String getDeliveryCreationDate() {
		return deliveryCreationDate;
	}

	/**
	 * @param deliveryCreationDate the deliveryCreationDate to set
	 */
	public void setDeliveryCreationDate(String deliveryCreationDate) {
		this.deliveryCreationDate = deliveryCreationDate;
	}

	/**
	 * @return the tPPt
	 */
	public String gettPPt() {
		return tPPt;
	}

	/**
	 * @param tPPt the tPPt to set
	 */
	public void settPPt(String tPPt) {
		this.tPPt = tPPt;
	}

	/**
	 * @return the shippingPointCP
	 */
	public String getShippingPointCP() {
		return shippingPointCP;
	}

	/**
	 * @param shippingPointCP the shippingPointCP to set
	 */
	public void setShippingPointCP(String shippingPointCP) {
		this.shippingPointCP = shippingPointCP;
	}

	/**
	 * @return the carrierNumber
	 */
	public String getCarrierNumber() {
		return carrierNumber;
	}

	/**
	 * @param carrierNumber the carrierNumber to set
	 */
	public void setCarrierNumber(String carrierNumber) {
		this.carrierNumber = carrierNumber;
	}

	/**
	 * @return the carrierDescription
	 */
	public String getCarrierDescription() {
		return carrierDescription;
	}

	/**
	 * @param carrierDescription the carrierDescription to set
	 */
	public void setCarrierDescription(String carrierDescription) {
		this.carrierDescription = carrierDescription;
	}

	/**
	 * @return the fechaSalidaMX33
	 */
	public String getFechaSalidaMX33() {
		return fechaSalidaMX33;
	}

	/**
	 * @param fechaSalidaMX33 the fechaSalidaMX33 to set
	 */
	public void setFechaSalidaMX33(String fechaSalidaMX33) {
		this.fechaSalidaMX33 = fechaSalidaMX33;
	}

	/**
	 * @return the fechaLlegadaL1
	 */
	public String getFechaLlegadaL1() {
		return fechaLlegadaL1;
	}

	/**
	 * @param fechaLlegadaL1 the fechaLlegadaL1 to set
	 */
	public void setFechaLlegadaL1(String fechaLlegadaL1) {
		this.fechaLlegadaL1 = fechaLlegadaL1;
	}

	/**
	 * @return the folioCita
	 */
	public String getFolioCita() {
		return folioCita;
	}

	/**
	 * @param folioCita the folioCita to set
	 */
	public void setFolioCita(String folioCita) {
		this.folioCita = folioCita;
	}

	/**
	 * @return the fecharechazo
	 */
	public String getFecharechazo() {
		return fecharechazo;
	}

	/**
	 * @param fecharechazo the fecharechazo to set
	 */
	public void setFecharechazo(String fecharechazo) {
		this.fecharechazo = fecharechazo;
	}

	/**
	 * @return the claverechazo
	 */
	public String getClaverechazo() {
		return claverechazo;
	}

	/**
	 * @param claverechazo the claverechazo to set
	 */
	public void setClaverechazo(String claverechazo) {
		this.claverechazo = claverechazo;
	}

	/**
	 * @return the foliorechazo
	 */
	public String getFoliorechazo() {
		return foliorechazo;
	}

	/**
	 * @param foliorechazo the foliorechazo to set
	 */
	public void setFoliorechazo(String foliorechazo) {
		this.foliorechazo = foliorechazo;
	}

	/**
	 * @return the cantidadrechazo
	 */
	public int getCantidadrechazo() {
		return cantidadrechazo;
	}

	/**
	 * @param cantidadrechazo the cantidadrechazo to set
	 */
	public void setCantidadrechazo(int cantidadrechazo) {
		this.cantidadrechazo = cantidadrechazo;
	}

	/**
	 * @return the billValue
	 */
	public float getBillValue() {
		return billValue;
	}

	/**
	 * @param billValue the billValue to set
	 */
	public void setBillValue(float billValue) {
		this.billValue = billValue;
	}

	/**
	 * @return the proofDate
	 */
	public String getProofDate() {
		return proofDate;
	}

	/**
	 * @param proofDate the proofDate to set
	 */
	public void setProofDate(String proofDate) {
		this.proofDate = proofDate;
	}

	/**
	 * @return the planta
	 */
	public String getPlanta() {
		return planta;
	}

	/**
	 * @param planta the planta to set
	 */
	public void setPlanta(String planta) {
		this.planta = planta;
	}

	/**
	 * @return the idMaterial
	 */
	public String getIdMaterial() {
		return idMaterial;
	}

	/**
	 * @param idMaterial the idMaterial to set
	 */
	public void setIdMaterial(String idMaterial) {
		this.idMaterial = idMaterial;
	}

	/**
	 * @return the pesoToneladas
	 */
	public float getPesoToneladas() {
		return pesoToneladas;
	}

	/**
	 * @param pesoToneladas the pesoToneladas to set
	 */
	public void setPesoToneladas(float pesoToneladas) {
		this.pesoToneladas = pesoToneladas;
	}

	/**
	 * @return the creadoPor
	 */
	public String getCreadoPor() {
		return creadoPor;
	}

	/**
	 * @param creadoPor the creadoPor to set
	 */
	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	/**
	 * @return the cantidadEnPallet
	 */
	public float getCantidadEnPallet() {
		return cantidadEnPallet;
	}

	/**
	 * @param cantidadEnPallet the cantidadEnPallet to set
	 */
	public void setCantidadEnPallet(float cantidadEnPallet) {
		this.cantidadEnPallet = cantidadEnPallet;
	}

	/**
	 * @return the cantidadCasos
	 */
	public int getCantidadCasos() {
		return cantidadCasos;
	}

	/**
	 * @param cantidadCasos the cantidadCasos to set
	 */
	public void setCantidadCasos(int cantidadCasos) {
		this.cantidadCasos = cantidadCasos;
	}

	/**
	 * @return the descripcionmaterial
	 */
	public String getDescripcionmaterial() {
		return descripcionmaterial;
	}

	/**
	 * @param descripcionmaterial the descripcionmaterial to set
	 */
	public void setDescripcionmaterial(String descripcionmaterial) {
		this.descripcionmaterial = descripcionmaterial;
	}

	/**
	 * @return the tiporechazo
	 */
	public String getTiporechazo() {
		return tiporechazo;
	}

	/**
	 * @param tiporechazo the tiporechazo to set
	 */
	public void setTiporechazo(String tiporechazo) {
		this.tiporechazo = tiporechazo;
	}

	/**
	 * @return the baseUnit
	 */
	public String getBaseUnit() {
		return baseUnit;
	}

	/**
	 * @param baseUnit the baseUnit to set
	 */
	public void setBaseUnit(String baseUnit) {
		this.baseUnit = baseUnit;
	}

	/**
	 * @return the soloConCita
	 */
	public boolean isSoloConCita() {
		return soloConCita;
	}

	/**
	 * @param soloConCita the soloConCita to set
	 */
	public void setSoloConCita(boolean soloConCita) {
		this.soloConCita = soloConCita;
	}

	/**
	 * @return the vigencia
	 */
	public int getVigencia() {
		return vigencia;
	}

	/**
	 * @param vigencia the vigencia to set
	 */
	public void setVigencia(int vigencia) {
		this.vigencia = vigencia;
	}

	/**
	 * @return the pos_manif
	 */
	public int getPos_manif() {
		return pos_manif;
	}

	/**
	 * @param pos_manif the pos_manif to set
	 */
	public void setPos_manif(int pos_manif) {
		this.pos_manif = pos_manif;
	}

	/**
	 * @return the unidadreparto
	 */
	public String getUnidadreparto() {
		return unidadreparto;
	}

	/**
	 * @param unidadreparto the unidadreparto to set
	 */
	public void setUnidadreparto(String unidadreparto) {
		this.unidadreparto = unidadreparto;
	}

	/**
	 * @return the zonaVenta
	 */
	public String getZonaVenta() {
		return zonaVenta;
	}

	/**
	 * @param zonaVenta the zonaVenta to set
	 */
	public void setZonaVenta(String zonaVenta) {
		this.zonaVenta = zonaVenta;
	}

	/**
	 * @return the pesoAmparadoFolios
	 */
	public int getPesoAmparadoFolios() {
		return pesoAmparadoFolios;
	}

	/**
	 * @param pesoAmparadoFolios the pesoAmparadoFolios to set
	 */
	public void setPesoAmparadoFolios(int pesoAmparadoFolios) {
		this.pesoAmparadoFolios = pesoAmparadoFolios;
	}

	/**
	 * @return the identidad
	 */
	public int getIdentidad() {
		return identidad;
	}

	/**
	 * @param identidad the identidad to set
	 */
	public void setIdentidad(int identidad) {
		this.identidad = identidad;
	}

	/**
	 * @return the idorganizacion
	 */
	public int getIdorganizacion() {
		return idorganizacion;
	}

	/**
	 * @param idorganizacion the idorganizacion to set
	 */
	public void setIdorganizacion(int idorganizacion) {
		this.idorganizacion = idorganizacion;
	}

	/**
	 * @return the quienRecibe
	 */
	public String getQuienRecibe() {
		return quienRecibe;
	}

	/**
	 * @param quienRecibe the quienRecibe to set
	 */
	public void setQuienRecibe(String quienRecibe) {
		this.quienRecibe = quienRecibe;
	}

	/**
	 * @return the fechaConfirmacion
	 */
	public String getFechaConfirmacion() {
		return fechaConfirmacion;
	}

	/**
	 * @param fechaConfirmacion the fechaConfirmacion to set
	 */
	public void setFechaConfirmacion(String fechaConfirmacion) {
		this.fechaConfirmacion = fechaConfirmacion;
	}

	/**
	 * @return the guiainternacional
	 */
	public String getGuiainternacional() {
	    return guiainternacional;
	}

	/**
	 * @param guiainternacional the guiainternacional to set
	 */
	public void setGuiainternacional(String guiainternacional) {
	    this.guiainternacional = guiainternacional;
	}

	/**
	 * @return the es_nacional
	 */
	public String getEs_nacional() {
	    return es_nacional;
	}

	/**
	 * @param es_nacional the es_nacional to set
	 */
	public void setEs_nacional(String es_nacional) {
	    this.es_nacional = es_nacional;
	}

	/**
	 * @return the tiporecepcion
	 */
	public String getTiporecepcion() {
	    return tiporecepcion;
	}

	/**
	 * @param tiporecepcion the tiporecepcion to set
	 */
	public void setTiporecepcion(String tiporecepcion) {
	    this.tiporecepcion = tiporecepcion;
	}

	/**
	 * @return the latitud
	 */
	public String getLatitud() {
	    return latitud;
	}

	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(String latitud) {
	    this.latitud = latitud;
	}

	/**
	 * @return the longitud
	 */
	public String getLongitud() {
	    return longitud;
	}

	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(String longitud) {
	    this.longitud = longitud;
	}

	/**
	 * @return the idguiamadremultiple
	 */
	public String getIdguiamadremultiple() {
	    return idguiamadremultiple;
	}

	/**
	 * @param idguiamadremultiple the idguiamadremultiple to set
	 */
	public void setIdguiamadremultiple(String idguiamadremultiple) {
	    this.idguiamadremultiple = idguiamadremultiple;
	}

	public String getPlazaEntrega() {
		return plazaEntrega;
	}

	public void setPlazaEntrega(String plazaEntrega) {
		this.plazaEntrega = plazaEntrega;
	}

	public String getCopEntrega() {
		return copEntrega;
	}

	public void setCopEntrega(String copEntrega) {
		this.copEntrega = copEntrega;
	}

	public String getRutaEntrega() {
		return rutaEntrega;
	}

	public void setRutaEntrega(String rutaEntrega) {
		this.rutaEntrega = rutaEntrega;
	}

	public String getDescripcionError() {
		return descripcionError;
	}

	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}
	
	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

}
