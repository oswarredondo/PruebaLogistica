/* $Id:  $
 *
 * Nombre del Proyecto:  Captura de Confirmaciones
 * Nombre del Programa: EntregaForm.java
 * Responsable: Adri�n Morales Ruaro
 * Descripcion:  controla los datos de la forma de confirmaciones
 *
 * $Log: $
 */
package com.innovargia.ws.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Contiene las propiedades de la forma de entregas
 * @author amorales
 * @version
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntregaWS   implements Serializable   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombreObjeto="EntregaForm";
	   /**NUmero de empleado**/
    public String numEmpleado;
    /**NUmero de empleado**/
    public String idFirma;

    /**Contiene las siglas de la plaza donde se origina la informacion*/
    private String  siglasPlaza;
    /**Siglas de la plaza origen del envio*/ 
    private String  origen;
    /**Indnca el nombre de la persona que recibe*/
    private String quienRecibe;
    /**Indica la fecha de salida a ruta */
    private String fecha;
     
    /**Fecha final de consulta*/
    private String fechafin;
    
    /**Indica la hora en que se recibio el envio*/
    private int hora;
    /**Indica el identificador del envio entregado*/
    private String idGuia;
    /**Guia de enlace de una mensajeria externa*/
    private String idGuiaEnlace;
    /**Indica los minutos en la hora*/
    private  int minutos;
    /**Contiene el identificador de la ruta*/
    private String idRuta;
    /**Contiene de la fecha de las confirmaciones a buscar*/
    private String fechaConfirmaciones;
    /**Destino de  los envios*/
    private String destino;
    /**Centro operativo de captura*/
    private String cencap;
    /**usuario*/
    private String usuario;
    /**Accion que se esta realizando*/
    private String accion;
    
    
    private String latitud;
    private String longitud;
    
    
    /**La cabecera por omision es la de la guia*/
    private int cabecera_incluye;
    
    /**Contador de registros*/
    private int contador_registros=0;
    /** bandera para verificar cuando se deben cargar los datos a la lista
     * cuando son capturas solas
     */
    private boolean cargaDatos = false;
    
    /**
     * Contiene el numero de factura que se le va asignar al envio
     */
    private String factura;
    
    /** Creates a new instance of Entrega */
    public EntregaWS() {
    }

	public String getNombreObjeto() {
		return nombreObjeto;
	}

	public void setNombreObjeto(String nombreObjeto) {
		this.nombreObjeto = nombreObjeto;
	}

	public String getNumEmpleado() {
		return numEmpleado;
	}

	public void setNumEmpleado(String numEmpleado) {
		this.numEmpleado = numEmpleado;
	}

	public String getIdFirma() {
		return idFirma;
	}

	public void setIdFirma(String idFirma) {
		this.idFirma = idFirma;
	}

	public String getSiglasPlaza() {
		return siglasPlaza;
	}

	public void setSiglasPlaza(String siglasPlaza) {
		this.siglasPlaza = siglasPlaza;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getQuienRecibe() {
		return quienRecibe;
	}

	public void setQuienRecibe(String quienRecibe) {
		this.quienRecibe = quienRecibe;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFechafin() {
		return fechafin;
	}

	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public String getIdGuia() {
		return idGuia;
	}

	public void setIdGuia(String idGuia) {
		this.idGuia = idGuia;
	}

	public String getIdGuiaEnlace() {
		return idGuiaEnlace;
	}

	public void setIdGuiaEnlace(String idGuiaEnlace) {
		this.idGuiaEnlace = idGuiaEnlace;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public String getIdRuta() {
		return idRuta;
	}

	public void setIdRuta(String idRuta) {
		this.idRuta = idRuta;
	}

	public String getFechaConfirmaciones() {
		return fechaConfirmaciones;
	}

	public void setFechaConfirmaciones(String fechaConfirmaciones) {
		this.fechaConfirmaciones = fechaConfirmaciones;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getCencap() {
		return cencap;
	}

	public void setCencap(String cencap) {
		this.cencap = cencap;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

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

	public int getCabecera_incluye() {
		return cabecera_incluye;
	}

	public void setCabecera_incluye(int cabecera_incluye) {
		this.cabecera_incluye = cabecera_incluye;
	}

	public int getContador_registros() {
		return contador_registros;
	}

	public void setContador_registros(int contador_registros) {
		this.contador_registros = contador_registros;
	}

	public boolean isCargaDatos() {
		return cargaDatos;
	}

	public void setCargaDatos(boolean cargaDatos) {
		this.cargaDatos = cargaDatos;
	}

	public String getFactura() {
		return factura;
	}

	public void setFactura(String factura) {
		this.factura = factura;
	}

    
  
}//fin de Entrega
