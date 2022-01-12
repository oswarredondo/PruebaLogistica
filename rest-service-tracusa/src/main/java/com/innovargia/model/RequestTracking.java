package com.innovargia.model;

import java.io.Serializable;

public class RequestTracking implements Serializable{

	private static final long serialVersionUID = 1L;
	String numcliente;
	String usuario;
	String contrasena;
	String numeroguia;
	int tipobusqueda;
	
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
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	/**
	 * @return the numeroguia
	 */
	public String getNumeroguia() {
		return numeroguia;
	}
	/**
	 * @param numeroguia the numeroguia to set
	 */
	public void setNumeroguia(String numeroguia) {
		this.numeroguia = numeroguia;
	}
	/**
	 * @return the tipobusqueda
	 */
	public int getTipobusqueda() {
		return tipobusqueda;
	}
	/**
	 * @param tipobusqueda the tipobusqueda to set
	 */
	public void setTipobusqueda(int tipobusqueda) {
		this.tipobusqueda = tipobusqueda;
	}
	
	
}
