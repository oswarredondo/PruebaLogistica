package com.tracusa.logistica.model;

public class Domicilio {

	String Calle;
	String NumeroExterior;
	String NumeroInterior;
	String Colonia;
	String Localidad;
	String Referencia;
	String Municipio;
	String Estado;
	String Pais;
	String CodigoPostal;
	
	public Domicilio() {
		super();
	}

	public String getCalle() {
		return Calle;
	}

	public void setCalle(String calle) {
		Calle = calle;
	}

	public String getNumeroExterior() {
		return NumeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		NumeroExterior = numeroExterior;
	}

	public String getNumeroInterior() {
		return NumeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		NumeroInterior = numeroInterior;
	}

	public String getColonia() {
		return Colonia;
	}

	public void setColonia(String colonia) {
		Colonia = colonia;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public String getReferencia() {
		return Referencia;
	}

	public void setReferencia(String referencia) {
		Referencia = referencia;
	}

	public String getMunicipio() {
		return Municipio;
	}

	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public String getCodigoPostal() {
		return CodigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		CodigoPostal = codigoPostal;
	}

}
