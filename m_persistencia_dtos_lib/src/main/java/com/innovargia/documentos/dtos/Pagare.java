/* $Id: $
 * Nombre del Proyecto: IETWeb
 * Nombre del Programa: Envio.java
 * Responsable: Adrián Morales Ruaro
 * Descripcion: Datos Pertenecientes a un envio
 *
 *$Log:$
 */
package com.innovargia.documentos.dtos;

import java.io.Serializable;

/**
 *<CODE>
 * Datos de un cliente o un remitente
 *</CODE>
 * 
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
public class Pagare implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String division;
	private String modelo;
	private String origen;
	private String area;
	private String sku;
	private String nPlan;
	private String montoMensualidad;
	private String numeroSerie;
	private String montoString;

	private String folioPaquete;
	private String ordenServicio;

	private String mesPagare;
	private String rfc;
	private String atencion;
	private String direccion;
	private String colonia;
	private String municipio;
	private String estado;
	private String cp;

	/**
	 * Getter for property division.
	 * 
	 * @return Value of property division.
	 */
	public java.lang.String getDivision() {

		return setNULL(division);

	}

	/**
	 * Setter for property division.
	 * 
	 * @param division
	 *            New value of property division.
	 */
	public void setDivision(java.lang.String division) {
		this.division = division;
	}

	/**
	 * Getter for property modelo.
	 * 
	 * @return Value of property modelo.
	 */
	public java.lang.String getModelo() {
		return setNULL(modelo);
	}

	/**
	 * Setter for property modelo.
	 * 
	 * @param modelo
	 *            New value of property modelo.
	 */
	public void setModelo(java.lang.String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Getter for property origen.
	 * 
	 * @return Value of property origen.
	 */
	public java.lang.String getOrigen() {
		return setNULL(origen);
	}

	/**
	 * Setter for property origen.
	 * 
	 * @param origen
	 *            New value of property origen.
	 */
	public void setOrigen(java.lang.String origen) {
		this.origen = origen;
	}

	/**
	 * Getter for property area.
	 * 
	 * @return Value of property area.
	 */
	public java.lang.String getArea() {
		return setNULL(area);
	}

	/**
	 * Setter for property area.
	 * 
	 * @param area
	 *            New value of property area.
	 */
	public void setArea(java.lang.String area) {
		this.area = area;
	}

	/**
	 * Getter for property sku.
	 * 
	 * @return Value of property sku.
	 */
	public java.lang.String getSku() {
		return setNULL(sku);
	}

	/**
	 * Setter for property sku.
	 * 
	 * @param sku
	 *            New value of property sku.
	 */
	public void setSku(java.lang.String sku) {
		this.sku = sku;
	}

	/**
	 * Getter for property nPlan.
	 * 
	 * @return Value of property nPlan.
	 */
	public java.lang.String getNPlan() {
		return setNULL(nPlan);
	}

	/**
	 * Setter for property nPlan.
	 * 
	 * @param nPlan
	 *            New value of property nPlan.
	 */
	public void setNPlan(java.lang.String nPlan) {
		this.nPlan = nPlan;
	}

	/**
	 * Getter for property montoMensualidad.
	 * 
	 * @return Value of property montoMensualidad.
	 */
	public java.lang.String getMontoMensualidad() {
		if (montoMensualidad == null)
			return "0";
		return setNULL(montoMensualidad.replace('$', ' '));
	}

	/**
	 * Setter for property montoMensualidad.
	 * 
	 * @param montoMensualidad
	 *            New value of property montoMensualidad.
	 */
	public void setMontoMensualidad(java.lang.String montoMensualidad) {
		if (montoMensualidad == null)
			montoMensualidad = "0";

		// Reemplaza los valores de $ por espacios
		this.montoString = montoMensualidad;
		// Quita el carater de pesos
		this.montoMensualidad = montoMensualidad.replace('$', ' ');

	}

	/**
	 * Getter for property numeroSerie.
	 * 
	 * @return Value of property numeroSerie.
	 */
	public java.lang.String getNumeroSerie() {
		return setNULL(numeroSerie);
	}

	/**
	 * Setter for property numeroSerie.
	 * 
	 * @param numeroSerie
	 *            New value of property numeroSerie.
	 */
	public void setNumeroSerie(java.lang.String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	private String setNULL(String s) {
		if (s == null) {
			return "";
		}

		return s.trim();
	}

	/**
	 * Getter for property montoString.
	 * 
	 * @return Value of property montoString.
	 */
	public java.lang.String getMontoString() {
		return montoString;
	}

	/**
	 * Setter for property montoString.
	 * 
	 * @param montoString
	 *            New value of property montoString.
	 */
	public void setMontoString(java.lang.String montoString) {
		this.montoString = montoString;
	}

	/**
	 * Getter for property folioPaquete.
	 * 
	 * @return Value of property folioPaquete.
	 */
	public java.lang.String getFolioPaquete() {
		return folioPaquete;
	}

	/**
	 * Setter for property folioPaquete.
	 * 
	 * @param folioPaquete
	 *            New value of property folioPaquete.
	 */
	public void setFolioPaquete(java.lang.String folioPaquete) {
		this.folioPaquete = folioPaquete;
	}

	/**
	 * Getter for property ordenServicio.
	 * 
	 * @return Value of property ordenServicio.
	 */
	public java.lang.String getOrdenServicio() {
		return ordenServicio;
	}

	/**
	 * Setter for property ordenServicio.
	 * 
	 * @param ordenServicio
	 *            New value of property ordenServicio.
	 */
	public void setOrdenServicio(java.lang.String ordenServicio) {
		this.ordenServicio = ordenServicio;
	}

	/**
	 * Getter for property mesPagare.
	 * 
	 * @return Value of property mesPagare.
	 */
	public java.lang.String getMesPagare() {
		return mesPagare;
	}

	/**
	 * Setter for property mesPagare.
	 * 
	 * @param mesPagare
	 *            New value of property mesPagare.
	 */
	public void setMesPagare(java.lang.String mesPagare) {
		this.mesPagare = mesPagare;
	}

	/**
	 * Getter for property rfc.
	 * 
	 * @return Value of property rfc.
	 */
	public java.lang.String getRfc() {
		return rfc;
	}

	/**
	 * Setter for property rfc.
	 * 
	 * @param rfc
	 *            New value of property rfc.
	 */
	public void setRfc(java.lang.String rfc) {
		this.rfc = rfc;
	}

	/**
	 * Getter for property atencion.
	 * 
	 * @return Value of property atencion.
	 */
	public java.lang.String getAtencion() {
		return atencion;
	}

	/**
	 * Setter for property atencion.
	 * 
	 * @param atencion
	 *            New value of property atencion.
	 */
	public void setAtencion(java.lang.String atencion) {
		this.atencion = atencion;
	}

	/**
	 * Getter for property direccion.
	 * 
	 * @return Value of property direccion.
	 */
	public java.lang.String getDireccion() {
		return direccion;
	}

	/**
	 * Setter for property direccion.
	 * 
	 * @param direccion
	 *            New value of property direccion.
	 */
	public void setDireccion(java.lang.String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Getter for property colonia.
	 * 
	 * @return Value of property colonia.
	 */
	public java.lang.String getColonia() {
		return colonia;
	}

	/**
	 * Setter for property colonia.
	 * 
	 * @param colonia
	 *            New value of property colonia.
	 */
	public void setColonia(java.lang.String colonia) {
		this.colonia = colonia;
	}

	/**
	 * Getter for property municipio.
	 * 
	 * @return Value of property municipio.
	 */
	public java.lang.String getMunicipio() {
		return municipio;
	}

	/**
	 * Setter for property municipio.
	 * 
	 * @param municipio
	 *            New value of property municipio.
	 */
	public void setMunicipio(java.lang.String municipio) {
		this.municipio = municipio;
	}

	/**
	 * Getter for property estado.
	 * 
	 * @return Value of property estado.
	 */
	public java.lang.String getEstado() {
		return estado;
	}

	/**
	 * Setter for property estado.
	 * 
	 * @param estado
	 *            New value of property estado.
	 */
	public void setEstado(java.lang.String estado) {
		this.estado = estado;
	}

	/**
	 * Getter for property cp.
	 * 
	 * @return Value of property cp.
	 */
	public java.lang.String getCp() {
		while (this.cp.trim().length() < 5) {
			this.cp = "0" + this.cp;
		}
		return cp;
	}

	/**
	 * Setter for property cp.
	 * 
	 * @param cp
	 *            New value of property cp.
	 */
	public void setCp(java.lang.String cp) {
		if (cp == null)
			this.cp = "00000";
		this.cp = cp;
		while (this.cp.trim().length() < 5) {
			this.cp = "0" + this.cp;
		}
	}

} // fin Envio
