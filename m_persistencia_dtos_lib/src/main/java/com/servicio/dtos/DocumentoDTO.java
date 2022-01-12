/**
 * 
 */
package com.servicio.dtos;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.administracion.dto.Precio;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.salesmanager.dtos.Entidad;
import com.innovargia.salesmanager.dtos.Organizacion;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.utils.UUIDUniqueCreator;

/**
 * Contiene los datos de un documento
 * @author Adrian Morales Ruaro
 * 
 */
public class DocumentoDTO implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Entidad entidad = new Entidad();
	public Organizacion organizacion = new Organizacion();
	private Precio precioServicio = null;
	
	private int indice;
	
	
	//Atributos
	private ArrayList arr_atributos = new ArrayList();
	
	//GUIA AMDRE
	private String esMadre;// 0=NO ES GUIA MADRE; 1= ES GUIA MADRE

	//Datos tabla
	private String idDocumento;
	private String idDocumentoPadre;
	private String idGuiaCasamiento;
	private String idGuiaDevolucion;
	
	private String numCliente;
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
	float valor_asegurado;
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
	
	private String idguiamadremultiple;
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
	
	private String ciaseguro;
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
	private String uuid=null;
	
	
	private int pesoamparado ;
	private int   idconvenio ;
	private int   idtarifa ;
	
	//Datos de tipo de direccion 
	//Datos remitente
	public RemDes remitente = new RemDes();
	// Datos del Destino
	public RemDes destinatario = new RemDes();
	// Datos del recoleccion
	public RemDes recoleccion = new RemDes();
	// Datos Facturacion
	public RemDes domicionfiscal = new RemDes();
	// Datos Envio
	public Envio datosCarta = new Envio();
	
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
	
	String oficinacontrol;
	
	
	private int vigencia=-1; //el documento tiene vigencia ilimitada
	//Cuandi tiene este valor es que no tiene indice, se pone este para que a 
	//los que no se les asigna siempre vayan al final
	private int pos_manif=32000; 
	private String unidadreparto;
	
	private String zonaVenta;
	
	private int pesoAmparadoFolios=0;
	
	private String idguiainternacional;
	
	/* DATOS SEGURO */
	private Float precio_seguro;
	
	private Float cantasegurada;
	
	/*FECHA ESTIMADA WALMART*/
	private String maxEDD;

	/* CAMBIO UNIGIS */
	int sistema;
	
	public int getSistema() {
		return sistema;
	}

	public void setSistema(int sistema) {
		this.sistema = sistema;
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
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @return the idEnvio
	 */
	public String getIdEnvio() {
		return idEnvio;
	}

	/**
	 * @return the siglasOrigen
	 */
	public String getSiglasOrigen() {
		return siglasOrigen;
	}

	/**
	 * @return the siglasDestino
	 */
	public String getSiglasDestino() {
		return siglasDestino;
	}

	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * @param idEnvio the idEnvio to set
	 */
	public void setIdEnvio(String idEnvio) {
		this.idEnvio = idEnvio;
	}

	/**
	 * @param siglasOrigen the siglasOrigen to set
	 */
	public void setSiglasOrigen(String siglasOrigen) {
		this.siglasOrigen = siglasOrigen;
	}

	/**
	 * @param siglasDestino the siglasDestino to set
	 */
	public void setSiglasDestino(String siglasDestino) {
		this.siglasDestino = siglasDestino;
	}

	private String siglasDestino;
	
	// Observaciones

	/**
	 * Contructor por omision
	 */
	public DocumentoDTO() {
		// TODO Auto-generated constructor stub
	}
	
	/**Datos del cruce de zonas de la carta*/
	public Zona cruceZonas ;

	


	/**
	 * @return the remitente
	 */
	public RemDes getRemitente() {
		return remitente;
	}

	/**
	 * @return the destinatario
	 */
	public RemDes getDestinatario() {
		return destinatario;
	}

	/**
	 * @return the recoleccion
	 */
	public RemDes getRecoleccion() {
		return recoleccion;
	}

	/**
	 * @return the domicionfiscal
	 */
	public RemDes getDomicionfiscal() {
		return domicionfiscal;
	}

	/**
	 * @return the datosCarta
	 */
	public Envio getDatosCarta() {
		return datosCarta;
	}

	/**
	 * @return the numPiezas
	 */
	public int getNumPiezas() {
		return numPiezas;
	}

	/**
	 * @return the tipoEmbalaje
	 */
	public String getTipoEmbalaje() {
		return tipoEmbalaje;
	}

	/**
	 * @return the contenidoDeclarado
	 */
	public String getContenidoDeclarado() {
		return contenidoDeclarado;
	}

	/**
	 * @return the pesoBruto
	 */
	public float getPesoBruto() {
		return pesoBruto;
	}
	
	

	/**
	 * @return the pesoVolumetrico
	 */
	public float getPesoVolumetrico() {
		return pesoVolumetrico;
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
	 * @return the pesoDeclarado
	 */
	public float getValorDeclarado() {
		return valorDeclarado;
	}

	/**
	 * @return the factura
	 */
	public String getFactura() {
		return factura;
	}

	/**
	 * @return the pedimento
	 */
	public String getPedimento() {
		return pedimento;
	}

	/**
	 * @return the aduana
	 */
	public String getAduana() {
		return aduana;
	}

	/**
	 * @param remitente
	 *            the remitente to set
	 */
	public void setRemitente(RemDes remitente) {
		this.remitente = remitente;
	}

	/**
	 * @param destinatario
	 *            the destinatario to set
	 */
	public void setDestinatario(RemDes destinatario) {
		this.destinatario = destinatario;
	}

	/**
	 * @param recoleccion
	 *            the recoleccion to set
	 */
	public void setRecoleccion(RemDes recoleccion) {
		this.recoleccion = recoleccion;
	}

	/**
	 * @param domicionfiscal
	 *            the domicionfiscal to set
	 */
	public void setDomicionfiscal(RemDes domicionfiscal) {
		this.domicionfiscal = domicionfiscal;
	}

	/**
	 * @param datosCarta
	 *            the datosCarta to set
	 */
	public void setDatosCarta(Envio datosCarta) {
		this.datosCarta = datosCarta;
	}

	/**
	 * @param numPiezas
	 *            the numPiezas to set
	 */
	public void setNumPiezas(int numPiezas) {
		this.numPiezas = numPiezas;
	}

	public void setNumPiezas(String numPiezas) {
		try {
			this.numPiezas = Integer.parseInt(numPiezas);
		} catch (Exception e) {
			this.numPiezas = 0;
		}

	}

	/**
	 * @param tipoEmbalaje
	 *            the tipoEmbalaje to set
	 */
	public void setTipoEmbalaje(String tipoEmbalaje) {
		this.tipoEmbalaje = tipoEmbalaje;
	}

	/**
	 * @param contenidoDeclarado
	 *            the contenidoDeclarado to set
	 */
	public void setContenidoDeclarado(String contenidoDeclarado) {
		this.contenidoDeclarado = contenidoDeclarado;
	}

	/**
	 * @param pesoBruto
	 *            the pesoBruto to set
	 */
	public void setPesoBruto(float pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	/**
	 * Ajusta el valor del peso bruto a float
	 * @param pesoBruto
	 */
	public void setPesoBruto(String pesoBruto) {

		try {
			this.pesoBruto = Float.parseFloat(pesoBruto);
		} catch (Exception e) {
			this.pesoBruto = 0;
		}

	}

	/**
	 * @param pesoVolumetrico
	 *            the pesoVolumetrico to set
	 */
	public void setPesoVolumetrico(float pesoVolumetrico) {
		this.pesoVolumetrico = pesoVolumetrico;
	}

	/**
	 * Ajusta el valor del peso volumetrico a float
	 * @param pesoVolumetrico
	 */
	/**
	 * @param pesoVolumetrico
	 */
	public void setPesoVolumetrico(String pesoVolumetrico) {

		try {
			this.pesoVolumetrico = Float.parseFloat(pesoVolumetrico);
		} catch (Exception e) {
			this.pesoVolumetrico = 0;
		}

	}

	/**
	 * @param pesoDeclarado
	 *            the pesoDeclarado to set
	 */
	public void setValorDeclarado(float valorDeclarado) {
		this.valorDeclarado = valorDeclarado;
	}
	
	public void setValorDeclarado(String valorDeclarado) {

		try {
			this.valorDeclarado = Float.parseFloat(valorDeclarado);
		} catch (Exception e) {
			this.valorDeclarado = 0;
		}

	}
	

	/**
	 * @param factura
	 *            the factura to set
	 */
	public void setFactura(String factura) {
		this.factura = factura;
	}

	/**
	 * @param pedimento
	 *            the pedimento to set
	 */
	public void setPedimento(String pedimento) {
		this.pedimento = pedimento;
	}

	/**
	 * @param aduana
	 *            the aduana to set
	 */
	public void setAduana(String aduana) {
		this.aduana = aduana;
	}

	
	/**
	 * Crea un edintificador unico tomando la hora y fecha en que se esta
	 * creando de documento.
	 * 
	 * @return el identificador del embarque
	 * @throws SQLException
	 */
	public String creaIdentificador() {

		// Crea el identificador de la guia con
		// AAAAMMDDMMSSmmaaaa
		Calendar fecha = Calendar.getInstance();
		// Da formato a la fecha
		SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmssS");
		java.util.Random random = new java.util.Random(10000000);

		//Obtiene el CRC32 para el numero indicado y se lo agrega
		//al identificador
		try{
			return  UUIDUniqueCreator.generateUUID(formato.format(fecha.getTime())) +
			formato.format(fecha.getTime());// + random.nextInt();
		}catch(Exception e){
			return formato.format(fecha.getTime());
		}
	
	}// fin de getIdentificador

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
	 * @return the cruceZonas
	 */
	public Zona getCruceZonas() {
		return cruceZonas;
	}

	/**
	 * @param cruceZonas the cruceZonas to set
	 */
	public void setCruceZonas(Zona cruceZonas) {
		this.cruceZonas = cruceZonas;
	}

	/**
	 * @return the servicio
	 */
	public String getServicio() {
		return servicio;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @return the enrutamiento
	 */
	public String getEnrutamiento() {
		return enrutamiento;
	}

	/**
	 * @return the datos_carta
	 */
	public String getDatos_carta() {
		return datos_carta;
	}

	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @param enrutamiento the enrutamiento to set
	 */
	public void setEnrutamiento(String enrutamiento) {
		this.enrutamiento = enrutamiento;
	}

	/**
	 * @param datosCarta the datos_carta to set
	 */
	public void setDatos_carta(String datosCarta) {
		datos_carta = datosCarta;
	}

	/**
	 * @return the descripcio_servicio
	 */
	public String getDescripcio_servicio() {
		return descripcio_servicio;
	}

	/**
	 * @param descripcioServicio the descripcio_servicio to set
	 */
	public void setDescripcio_servicio(String descripcioServicio) {
		descripcio_servicio = descripcioServicio;
	}

	/**
	 * @return the descripcion_garantia
	 */
	public String getDescripcion_garantia() {
		return descripcion_garantia;
	}

	/**
	 * @param descripcionGarantia the descripcion_garantia to set
	 */
	public void setDescripcion_garantia(String descripcionGarantia) {
		descripcion_garantia = descripcionGarantia;
	}

	public String getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getNumCliente() {
		return numCliente;
	}

	public void setNumCliente(String numCliente) {
		this.numCliente = numCliente;
	}

	public String getIdOficina() {
		return idOficina;
	}

	public void setIdOficina(String idOficina) {
		this.idOficina = idOficina;
	}

	public String getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(String idServicio) {
		this.idServicio = idServicio;
	}

	public String getIdTipoCobro() {
		return idTipoCobro;
	}

	public void setIdTipoCobro(String idTipoCobro) {
		this.idTipoCobro = idTipoCobro;
	}

	public String getIdTipoPago() {
		return idTipoPago;
	}

	public void setIdTipoPago(String idTipoPago) {
		this.idTipoPago = idTipoPago;
	}

	public String getIdAdicional() {
		return idAdicional;
	}

	public void setIdAdicional(String idAdicional) {
		this.idAdicional = idAdicional;
	}

	public String getIdTerminalOrigen() {
		return idTerminalOrigen;
	}

	public void setIdTerminalOrigen(String idTerminalOrigen) {
		this.idTerminalOrigen = idTerminalOrigen;
	}

	public String getIdTerminalDestino() {
		return idTerminalDestino;
	}

	public void setIdTerminalDestino(String idTerminalDestino) {
		this.idTerminalDestino = idTerminalDestino;
	}

	public String getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(String idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(String largo) {
		try{
			this.largo = Integer.parseInt(largo);
		}catch (Exception e) {
			this.largo = 0;
		}
	}
	public void setLargo(int largo) {
		this.largo = largo;
	}
	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	
	public void setAncho(String ancho) {
		
		try{
			this.ancho = Integer.parseInt(ancho);
		}catch (Exception e) {
			this.ancho = 0;
		}
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}
	public void setAlto(String alto) {
		try{
			this.alto = Integer.parseInt(alto);
		}catch (Exception e) {
			this.alto = 0;
		}
	
	}

	public float getIva() {
		return iva;
	}

	public void setIva(float iva) {
		this.iva = iva;
	}

	public float getPrecioZona() {
		return precioZona;
	}

	public void setPrecioZona(float precioZona) {
		this.precioZona = precioZona;
	}

	public String getMarcaFactura() {
		return marcaFactura;
	}

	public void setMarcaFactura(String marcaFactura) {
		this.marcaFactura = marcaFactura;
	}

	public String getMarcaRetornoDocumento() {
		return marcaRetornoDocumento;
	}

	public void setMarcaRetornoDocumento(String marcaRetornoDocumento) {
		this.marcaRetornoDocumento = marcaRetornoDocumento;
	}

	public String getZonaOri() {
		return zonaOri;
	}

	public void setZonaOri(String zonaOri) {
		this.zonaOri = zonaOri;
	}

	public String getZonaDes() {
		return zonaDes;
	}

	public void setZonaDes(String zonaDes) {
		this.zonaDes = zonaDes;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getManifiesto() {
		return manifiesto;
	}

	public void setManifiesto(String manifiesto) {
		this.manifiesto = manifiesto;
	}

	public String getFechaManifiesto() {
		return fechaManifiesto;
	}

	public void setFechaManifiesto(String fechaManifiesto) {
		this.fechaManifiesto = fechaManifiesto;
	}

	public String getCita() {
		return cita;
	}

	public void setCita(String cita) {
		this.cita = cita;
	}

	public ArrayList getArr_atributos() {
		return arr_atributos;
	}

	public void setArr_atributos(ArrayList arr_atributos) {
		this.arr_atributos = arr_atributos;
	}

	/**
	 * @return the ciaSeguro
	 */
	public String getCiaseguro() {
		return ciaseguro;
	}

	/**
	 * @param ciaSeguro the ciaSeguro to set
	 */
	public void setCiaseguro(String ciaSeguro) {
		this.ciaseguro = ciaSeguro;
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
	 * @param porcentajeIva the porcentajeIva to set
	 */
	public void setPorcentajeIva(String porcentajeIva) {
		try{
			this.porcentajeIva = Integer.parseInt(porcentajeIva);
		}catch (Exception e) {
			this.porcentajeIva = 0;
		}
		
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
		this.porcentajeRetencion= porcentajeRetencion;
	}
	/**
	 * @param porcentajeRetencion the porcentajeRetencion to set
	 */
	public void setPorcentajeRetencion(String  porcentajeRetencion) {
		try{
			this.porcentajeRetencion = Integer.parseInt(porcentajeRetencion);
		}catch (Exception e) {
			this.porcentajeRetencion = 0;
		}
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
	public void setVolumen(String volumen) {
		try{
			this.volumen = Float.parseFloat(volumen) ;
		}catch (Exception e) {
			this.volumen = 0;
		}

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
	
	/**
	 * @param consecutivo the consecutivo to set
	 */
	public void setConsecutivo(String  consecutivo) {
		try{
			this.consecutivo = Integer.parseInt(consecutivo);
		}catch(Exception e){
			this.consecutivo = 0;
		}
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
	 * @return the entidad
	 */
	public Entidad getEntidad() {
		return entidad;
	}

	/**
	 * @param entidad the entidad to set
	 */
	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	/**
	 * @return the organizacion
	 */
	public Organizacion getOrganizacion() {
		return organizacion;
	}

	/**
	 * @param organizacion the organizacion to set
	 */
	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
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
	public String getTPPt() {
		return tPPt;
	}

	/**
	 * @param tPPt the tPPt to set
	 */
	public void setTPPt(String TPPt) {
		this.tPPt = TPPt;
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
	 * @return the cechaLlegadaL1
	 */
	public String getFechaLlegadaL1() {
		return fechaLlegadaL1;
	}

	/**
	 * @param cechaLlegadaL1 the cechaLlegadaL1 to set
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
	 * @return the indice
	 */
	public int getIndice() {
		return indice;
	}

	/**
	 * @param indice the indice to set
	 */
	public void setIndice(int indice) {
		this.indice = indice;
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
	 * @return the isexistenota
	 */
	public String getIsexistenota() {
		if (this.isexistenota==null) return "";
		return isexistenota;
	}

	/**
	 * @param isexistenota the isexistenota to set
	 */
	public void setIsexistenota(String isexistenota) {
		this.isexistenota = isexistenota;
	}

	/**
	 * @return the precioServicio
	 */
	public Precio getPrecioServicio() {
		return precioServicio;
	}

	/**
	 * @param precioServicio the precioServicio to set
	 */
	public void setPrecioServicio(Precio precioServicio) {
		this.precioServicio = precioServicio;
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
	public void setPesoAmparadoFolios(String pesoAmparadoFolios) {
		try{
			this.pesoAmparadoFolios = Integer.parseInt(pesoAmparadoFolios);
		}catch(Exception e){
			this.pesoAmparadoFolios = 0;
		}
		
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
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the pesoamparado
	 */
	public int getPesoamparado() {
		return pesoamparado;
	}

	/**
	 * @param pesoamparado the pesoamparado to set
	 */
	public void setPesoamparado(int pesoamparado) {
		this.pesoamparado = pesoamparado;
	}

	/**
	 * @return the idconvenio
	 */
	public int getIdconvenio() {
		return idconvenio;
	}

	/**
	 * @param idconvenio the idconvenio to set
	 */
	public void setIdconvenio(int idconvenio) {
		this.idconvenio = idconvenio;
	}

	/**
	 * @return the idtarifa
	 */
	public int getIdtarifa() {
		return idtarifa;
	}

	/**
	 * @param idtarifa the idtarifa to set
	 */
	public void setIdtarifa(int idtarifa) {
		this.idtarifa = idtarifa;
	}

	/**
	 * @return the oficinacontrol
	 */
	public String getOficinacontrol() {
		return oficinacontrol;
	}

	/**
	 * @param oficinacontrol the oficinacontrol to set
	 */
	public void setOficinacontrol(String oficinacontrol) {
		this.oficinacontrol = oficinacontrol;
	}

	/**
	 * @return the valor_asegurado
	 */
	public float getValor_asegurado() {
		return valor_asegurado;
	}

	/**
	 * @param valor_asegurado the valor_asegurado to set
	 */
	public void setValor_asegurado(float valor_asegurado) {
		this.valor_asegurado = valor_asegurado;
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
	 * @return the idguiainternacional
	 */
	public String getIdguiainternacional() {
	    return idguiainternacional;
	}

	/**
	 * @param idguiainternacional the idguiainternacional to set
	 */
	public void setIdguiainternacional(String idguiainternacional) {
	    this.idguiainternacional = idguiainternacional;
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

	public String getEsMadre() {
		return esMadre;
	}

	public void setEsMadre(String esMadre) {
		this.esMadre = esMadre;
	}
	
	/* DATOS SEGURO */
	public Float getPrecio_seguro() {
		return precio_seguro;
	}

	public void setPrecio_seguro(Float precio_seguro) {
		this.precio_seguro = precio_seguro;
	}
	
	public Float getCantasegurada() {
		return cantasegurada;
	}

	public void setCantasegurada(Float cantasegurada) {
		this.cantasegurada = cantasegurada;
	}
	/*FECHA ESTIMADA WALMART IMPLEMENTADA EL 16/04/2020*/
	public String getMaxEDD() {
		return maxEDD;
	}

	public void setMaxEDD(String maxEDD) {
		this.maxEDD = maxEDD;
	}
}// fin de la clase
