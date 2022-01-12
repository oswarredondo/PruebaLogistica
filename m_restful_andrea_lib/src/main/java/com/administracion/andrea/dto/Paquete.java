package com.administracion.andrea.dto;

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
	String descripcionMercancia;
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
	


}
