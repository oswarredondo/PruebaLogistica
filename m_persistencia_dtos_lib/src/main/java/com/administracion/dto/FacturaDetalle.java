package com.administracion.dto;

import java.io.Serializable;

public class FacturaDetalle implements Serializable {

	private static final long serialVersionUID = 1L;
	int idfactura;
	int idconvenio;
	int cantidad ;
	float precio ;
	String numcliente;
	
	/**
	 * @return the idfactura
	 */
	public int getIdfactura() {
		return idfactura;
	}
	/**
	 * @param idfactura the idfactura to set
	 */
	public void setIdfactura(int idfactura) {
		this.idfactura = idfactura;
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
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
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
