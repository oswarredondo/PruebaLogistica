package com.innovargia.model;

import java.io.Serializable;

public class Paquete implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	String paqueteID;
	int cantidad; //Cantidad de producto en el paquete
	float peso;
	float valor;
	String tipoMercancia;
	String tipoEmpaque;
	String descripcionMercancia;
	String factura;
	boolean asegurarlo=false;
	boolean esmultiple=false;
	float volumen;
	
	
	public String getPaqueteID() {
		return paqueteID;
	}
	public void setPaqueteID(String paqueteID) {
		this.paqueteID = paqueteID;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getTipoMercancia() {
		return tipoMercancia;
	}
	public void setTipoMercancia(String tipoMercancia) {
		this.tipoMercancia = tipoMercancia;
	}
	public String getDescripcionMercancia() {
		return descripcionMercancia;
	}
	public void setDescripcionMercancia(String descripcionMercancia) {
		this.descripcionMercancia = descripcionMercancia;
	}
	public float getVolumen() {
		return volumen;
	}
	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}
	/**
	 * @return the tipoEmpaque
	 */
	public String getTipoEmpaque() {
		return tipoEmpaque;
	}
	/**
	 * @param tipoEmpaque the tipoEmpaque to set
	 */
	public void setTipoEmpaque(String tipoEmpaque) {
		this.tipoEmpaque = tipoEmpaque;
	}
	/**
	 * @return the asegurarlo
	 */
	public boolean isAsegurarlo() {
		return asegurarlo;
	}
	/**
	 * @param asegurarlo the asegurarlo to set
	 */
	public void setAsegurarlo(boolean asegurarlo) {
		this.asegurarlo = asegurarlo;
	}
	/**
	 * @return the esmultiple
	 */
	public boolean isEsmultiple() {
		return esmultiple;
	}
	/**
	 * @param esmultiple the esmultiple to set
	 */
	public void setEsmultiple(boolean esmultiple) {
		this.esmultiple = esmultiple;
	}
	/**
	 * @return the factura
	 */
	public String getFactura() {
		return factura;
	}
	/**
	 * @param factura the factura to set
	 */
	public void setFactura(String factura) {
		this.factura = factura;
	}

	


}
