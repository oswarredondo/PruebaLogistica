/**
 * 
 */
package com.administracion.dto;

import java.util.ArrayList;

import com.innovargia.documentos.dtos.Confirmacion;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.utils.Utils;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class SolicitudProductosDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public static String ESTATUS_CREADA = "CREADA";
	public static String ESTATUS_ENPROCESOAUTORIZACION= "SOLICITUD_AUTORIZACION";
	public static String ESTATUS_AUTORIZADA= "AUTORIZADA";
	public static String ESTATUS_ENPROCESO = "EN_PROCESO _DESPACHO";
	public static String ESTATUS_DESPACHADA = "DESPACHADA";
	public static String ESTATUS_CANCELADA = "CANCELADA";
	public static String ESTATUS_CONFIRMADA = "CONFIRMADA";	
	public static String ENTRADA_MERCANCIA ="EM";
	public static String ORDEN_DE_SALIDA ="OS";
	public static String DEVOLUCION ="DE";
	public static String SALIDA_DE_MERCANCIA ="SM";
	public static String MOVIMIENTO_REUBICA_ENTRADA ="MRUE";
	public static String MOVIMIENTO_REUBICA_SALIDA ="MRUS";
	
	private int idorganizacion;
	private int idalmacen;
	private String idTipoDocumento;
	private String tipoDocumento;
	//private String numcliente;
	//private String razonSocial;
	private String foliorecibo;
	private String login;
	private String idDocumento;
	private String estuatus;
	private String fechaCompromiso;
	private String fechaProgramada;
	private String fechaGeneracion;
	private String fechaSolicitud;
	
	private int consecutivo;
	private String idunidad;        	
	private String fechaservicio;
	private int cantidad;
	private String iddocumentopadre;	
	private int peso;
	private int volumen;
	private int quiensolicita;
	private int referencia;  
	private String observacion;
	
	
	public RemDes solicita = new RemDes();
	public RemDes destino = new RemDes();
	
	public ArrayList detalle_productos = new ArrayList();
	
	public Confirmacion confirmacion = new Confirmacion();
	 
	/* @return the fechaSolicitud
	 */
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * 
	 */
	public SolicitudProductosDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the numcliente
	 */
	public String getNumcliente() {
		return solicita.getNumCliente();
	}

	/**
	 * @param numcliente the numcliente to set
	 */
	public void setNumcliente(String numcliente) {
		solicita.setNumCliente(numcliente);
	}

	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return solicita.getRazonSocial();
	}

	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		solicita.setRazonSocial(razonSocial);
	}

	/**
	 * @return the foliorecibo
	 */
	public String getFoliorecibo() {
		return Utils.nullChange(foliorecibo);
	}

	/**
	 * @param foliorecibo the foliorecibo to set
	 */
	public void setFoliorecibo(String foliorecibo) {
		this.foliorecibo = foliorecibo;
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
	 * @return the estuatus
	 */
	public String getEstuatus() {
		return estuatus;
	}

	/**
	 * @param estuatus the estuatus to set
	 */
	public void setEstuatus(String estuatus) {
		this.estuatus = estuatus;
	}

	/**
	 * @return the fechaCompromiso
	 */
	public String getFechaCompromiso() {
		return fechaCompromiso;
	}

	/**
	 * @param fechaCompromiso the fechaCompromiso to set
	 */
	public void setFechaCompromiso(String fechaCompromiso) {
		this.fechaCompromiso = fechaCompromiso;
	}

	/**
	 * @return the fechaProgramada
	 */
	public String getFechaProgramada() {
		return fechaProgramada;
	}

	/**
	 * @param fechaProgramada the fechaProgramada to set
	 */
	public void setFechaProgramada(String fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}

	/**
	 * @return the fechaGeneracion
	 */
	public String getFechaGeneracion() {
		return fechaGeneracion;
	}

	/**
	 * @param fechaGeneracion the fechaGeneracion to set
	 */
	public void setFechaGeneracion(String fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
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
	 * @return the idunidad
	 */
	public String getIdunidad() {
		return idunidad;
	}

	/**
	 * @param idunidad the idunidad to set
	 */
	public void setIdunidad(String idunidad) {
		this.idunidad = idunidad;
	}

	/**
	 * @return the fechaservicio
	 */
	public String getFechaservicio() {
		return fechaservicio;
	}

	/**
	 * @param fechaservicio the fechaservicio to set
	 */
	public void setFechaservicio(String fechaservicio) {
		this.fechaservicio = fechaservicio;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the iddocumentopadre
	 */
	public String getIddocumentopadre() {
		return iddocumentopadre;
	}

	/**
	 * @param iddocumentopadre the iddocumentopadre to set
	 */
	public void setIddocumentopadre(String iddocumentopadre) {
		this.iddocumentopadre = iddocumentopadre;
	}

	/**
	 * @return the peso
	 */
	public int getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(int peso) {
		this.peso = peso;
	}

	/**
	 * @return the volumen
	 */
	public int getVolumen() {
		return volumen;
	}

	/**
	 * @param volumen the volumen to set
	 */
	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}

	/**
	 * @return the quiensolicita
	 */
	public int getQuiensolicita() {
		return quiensolicita;
	}

	/**
	 * @param quiensolicita the quiensolicita to set
	 */
	public void setQuiensolicita(int quiensolicita) {
		this.quiensolicita = quiensolicita;
	}

	/**
	 * @return the referencia
	 */
	public int getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}

	/**
	 * @return the solicita
	 */
	public RemDes getSolicita() {
		return solicita;
	}

	/**
	 * @param solicita the solicita to set
	 */
	public void setSolicita(RemDes solicita) {
		this.solicita = solicita;
	}

	/**
	 * @return the destino
	 */
	public RemDes getDestino() {
		return destino;
	}

	/**
	 * @param destino the destino to set
	 */
	public void setDestino(RemDes destino) {
		this.destino = destino;
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
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
	 * @return the idalmacen
	 */
	public int getIdalmacen() {
		return idalmacen;
	}

	/**
	 * @param idalmacen the idalmacen to set
	 */
	public void setIdalmacen(int idalmacen) {
		this.idalmacen = idalmacen;
	}

}
