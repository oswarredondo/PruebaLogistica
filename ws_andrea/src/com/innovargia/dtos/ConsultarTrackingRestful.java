/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovargia.dtos;

import java.io.Serializable;

/**
 *
 * @author aruaro
 */
public class ConsultarTrackingRestful implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String usuario;
	protected String contrasena;
	protected String guiasEmbarque;

	protected String numerosGuias; // Guias Separadas por comas
	protected String chofer;
	protected String placas;
	protected String camion;
	protected int numeroManifiesto;
	
	protected String convenio;
	
	protected String  codigoPostal;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getGuiasEmbarque() {
		return guiasEmbarque;
	}

	public void setGuiasEmbarque(String guiasEmbarque) {
		this.guiasEmbarque = guiasEmbarque;
	}

	public String getNumerosGuias() {
		return numerosGuias;
	}

	public void setNumerosGuias(String numerosGuias) {
		this.numerosGuias = numerosGuias;
	}

	public String getChofer() {
		return chofer;
	}

	public void setChofer(String chofer) {
		this.chofer = chofer;
	}

	public String getPlacas() {
		return placas;
	}

	public void setPlacas(String placas) {
		this.placas = placas;
	}

	public String getCamion() {
		return camion;
	}

	public void setCamion(String camion) {
		this.camion = camion;
	}

	public int getNumeroManifiesto() {
		return numeroManifiesto;
	}

	public void setNumeroManifiesto(int numeroManifiesto) {
		this.numeroManifiesto = numeroManifiesto;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

}
