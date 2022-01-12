/* $Id: $
 * Nombre del Proyecto:
 * Nombre del Programa: Historia.java
 * Responsable: Adri�n Morales Ruaro
 * Descripcion: contiene los datos de un registro de historia
 *
 *$Log:$
 */
package com.tracusa.logistica.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 *<CODE>
 * Contiene la historia de un envio
 *</CODE>
 *
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Seguimiento implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    protected String latitud;
    protected String longitud;
    protected String idEnvio;
   
    protected String  viaje;
    protected String  deptodestino;
    protected String  cincho;
    protected String  numeconomico;
    
   
    /**NUmero de empleado**/
    public String numEmpleado;
    /**Numero de cliente asociado al usuari oque tiene la sesion**/
    public String numCliente;
    
    /**Contiene el path del archivo que contiene la informacion consultada*/
    protected String pathFile;

    
    /** Encabezados posibles en el manifiesto*/
    public String encabezados;
    
    public String motivo;
    public String quienRechaza;

  
    // Campos
    /** Contiene el identificador del tipo de registro  */
    protected String tipoRegistro;
    /** Contiene la fecha del evento*/
    protected String fechaEvento;
    /** Contiene la clave de excepcion */
    protected String claveExce;
    /** Contiene el identificador de la ruta */
    protected String ruta;
    /** Contiene las siglas de la plaza destino */
    protected String siglas;
    /** Contiene �as siglas de la plaza que origino el registro*/
    protected String origenRegistro;
    /** Contiene la fecha de insercion del registro  */
    protected String fechaInsercion;
    /**Referencia*/
    protected String referencia;
    
    /**Contiene la fecha de inicio*/
    protected String fecinicio;
    
    /**Contiene la fecha de final*/
    protected String fecfin;
    
    /**Identificador del carrior(transportista)*/
    protected String idCarrier;
    
    /**Identificador de la guia madre cuando es una guia generada despues de una
     * carta de recoleccion*/
    protected String guiaMadre;
    
    /**Codigo postal para busquedas*/
    protected String  codigopostal;
    
    /**Colonias para busquedas*/
    protected String  colonias;
    

    
    /** Contiene los identificadores de las ubicaciones*/
    public String ubicacion;
    
    /** Contiene los identificadores de los centros de costos*/
    public String costos;
    /**Contiene los nombres de los edificios*/
    public String edificio;
    /**Contiene ls nombres de los estados*/
    public String estados;
    /**Contiene los nombres de las empresas*/
    public String empresa;
    

    
    /** Guia de casamiento */
    protected String idCasamiento;
    
    /**Login del usuario*/
    protected String login;
    
    /**identificador del proveedor*/
    protected String idProveedor;
    
    protected String documento_embarque;
    protected String factura;
    protected String serie;
    protected String placa;
   
    protected String hora_evento;
    
    protected String idAlmacen;
    
    
    //Datos de ECOP y SCOP
    protected String operador1;
    protected String operador2;
    protected String contenedor1;
    protected String contenedor2;
    protected String cartaporte;
    protected String manifiesto;
    protected String vehiculo;

    protected int cantidad=0;
    
    //Sobre peso
    protected float pesokg=0;
    protected float alto=0;
    protected float ancho=0;
    protected float largo=0;

    //Monto
    protected float monto=0;
    
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public String getIdEnvio() {
		return idEnvio;
	}
	public void setIdEnvio(String idEnvio) {
		this.idEnvio = idEnvio;
	}
	public String getViaje() {
		return viaje;
	}
	public void setViaje(String viaje) {
		this.viaje = viaje;
	}
	public String getDeptodestino() {
		return deptodestino;
	}
	public void setDeptodestino(String deptodestino) {
		this.deptodestino = deptodestino;
	}
	public String getCincho() {
		return cincho;
	}
	public void setCincho(String cincho) {
		this.cincho = cincho;
	}
	public String getNumeconomico() {
		return numeconomico;
	}
	public void setNumeconomico(String numeconomico) {
		this.numeconomico = numeconomico;
	}
	public String getNumEmpleado() {
		return numEmpleado;
	}
	public void setNumEmpleado(String numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
	public String getNumCliente() {
		return numCliente;
	}
	public void setNumCliente(String numCliente) {
		this.numCliente = numCliente;
	}
	public String getPathFile() {
		return pathFile;
	}
	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}
	public String getEncabezados() {
		return encabezados;
	}
	public void setEncabezados(String encabezados) {
		this.encabezados = encabezados;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getQuienRechaza() {
		return quienRechaza;
	}
	public void setQuienRechaza(String quienRechaza) {
		this.quienRechaza = quienRechaza;
	}
	public String getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	public String getFechaEvento() {
		return fechaEvento;
	}
	public void setFechaEvento(String fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	public String getClaveExce() {
		return claveExce;
	}
	public void setClaveExce(String claveExce) {
		this.claveExce = claveExce;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	public String getOrigenRegistro() {
		return origenRegistro;
	}
	public void setOrigenRegistro(String origenRegistro) {
		this.origenRegistro = origenRegistro;
	}
	public String getFechaInsercion() {
		return fechaInsercion;
	}
	public void setFechaInsercion(String fechaInsercion) {
		this.fechaInsercion = fechaInsercion;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getFecinicio() {
		return fecinicio;
	}
	public void setFecinicio(String fecinicio) {
		this.fecinicio = fecinicio;
	}
	public String getFecfin() {
		return fecfin;
	}
	public void setFecfin(String fecfin) {
		this.fecfin = fecfin;
	}
	public String getIdCarrier() {
		return idCarrier;
	}
	public void setIdCarrier(String idCarrier) {
		this.idCarrier = idCarrier;
	}
	public String getGuiaMadre() {
		return guiaMadre;
	}
	public void setGuiaMadre(String guiaMadre) {
		this.guiaMadre = guiaMadre;
	}
	public String getCodigopostal() {
		return codigopostal;
	}
	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}
	public String getColonias() {
		return colonias;
	}
	public void setColonias(String colonias) {
		this.colonias = colonias;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getCostos() {
		return costos;
	}
	public void setCostos(String costos) {
		this.costos = costos;
	}
	public String getEdificio() {
		return edificio;
	}
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	public String getEstados() {
		return estados;
	}
	public void setEstados(String estados) {
		this.estados = estados;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getIdCasamiento() {
		return idCasamiento;
	}
	public void setIdCasamiento(String idCasamiento) {
		this.idCasamiento = idCasamiento;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getDocumento_embarque() {
		return documento_embarque;
	}
	public void setDocumento_embarque(String documento_embarque) {
		this.documento_embarque = documento_embarque;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getHora_evento() {
		return hora_evento;
	}
	public void setHora_evento(String hora_evento) {
		this.hora_evento = hora_evento;
	}
	public String getIdAlmacen() {
		return idAlmacen;
	}
	public void setIdAlmacen(String idAlmacen) {
		this.idAlmacen = idAlmacen;
	}
	public String getOperador1() {
		return operador1;
	}
	public void setOperador1(String operador1) {
		this.operador1 = operador1;
	}
	public String getOperador2() {
		return operador2;
	}
	public void setOperador2(String operador2) {
		this.operador2 = operador2;
	}
	public String getContenedor1() {
		return contenedor1;
	}
	public void setContenedor1(String contenedor1) {
		this.contenedor1 = contenedor1;
	}
	public String getContenedor2() {
		return contenedor2;
	}
	public void setContenedor2(String contenedor2) {
		this.contenedor2 = contenedor2;
	}
	public String getCartaporte() {
		return cartaporte;
	}
	public void setCartaporte(String cartaporte) {
		this.cartaporte = cartaporte;
	}
	public String getManifiesto() {
		return manifiesto;
	}
	public void setManifiesto(String manifiesto) {
		this.manifiesto = manifiesto;
	}
	public String getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	public float getAlto() {
		return alto;
	}
	public void setAlto(float alto) {
		this.alto = alto;
	}
	public float getAncho() {
		return ancho;
	}
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}
	public float getLargo() {
		return largo;
	}
	public void setLargo(float largo) {
		this.largo = largo;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public float getPesokg() {
		return pesokg;
	}
	public void setPesokg(float pesokg) {
		this.pesokg = pesokg;
	}

    


     
} // fin Historia
