package com.innovargia.model;

import java.io.Serializable;
import java.util.List;

public class GuiaEmbarque implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String login;
	String numcliente;
	protected String password;
	protected String idservicio;
	protected String observaciones;
	protected DetalleEnvio detalleEnvio;
	protected Direccion destinatario;
	protected Direccion remitente;
	protected Paquete paquete;
	protected String referencia;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the idservicio
	 */
	public String getIdservicio() {
		return idservicio;
	}
	/**
	 * @param idservicio the idservicio to set
	 */
	public void setIdservicio(String idservicio) {
		this.idservicio = idservicio;
	}
	/**
	 * @return the detalleEnvio
	 */
	public DetalleEnvio getDetalleEnvio() {
		return detalleEnvio;
	}
	/**
	 * @param detalleEnvio the detalleEnvio to set
	 */
	public void setDetalleEnvio(DetalleEnvio detalleEnvio) {
		this.detalleEnvio = detalleEnvio;
	}
	/**
	 * @return the destinatario
	 */
	public Direccion getDestinatario() {
		return destinatario;
	}
	/**
	 * @param destinatario the destinatario to set
	 */
	public void setDestinatario(Direccion destinatario) {
		this.destinatario = destinatario;
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
	 * @return the remitente
	 */
	public Direccion getRemitente() {
		return remitente;
	}
	/**
	 * @param remitente the remitente to set
	 */
	public void setRemitente(Direccion remitente) {
		this.remitente = remitente;
	}
	/**
	 * @return the paquete
	 */
	public Paquete getPaquete() {
		return paquete;
	}
	/**
	 * @param paquete the paquete to set
	 */
	public void setPaquete(Paquete paquete) {
		this.paquete = paquete;
	}
	/**
	 * @return the numcliente
	 */
	public String getNumcliente() {
		return numcliente;
	}
	/**
	 * @param numcliente the numcliente to set
	 */
	public void setNumcliente(String numcliente) {
		this.numcliente = numcliente;
	}

}
