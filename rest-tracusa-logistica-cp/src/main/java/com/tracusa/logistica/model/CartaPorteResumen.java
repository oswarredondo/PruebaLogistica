package com.tracusa.logistica.model;

public class CartaPorteResumen {

	int idControl;
	int idViaje;
	String fecha;
	String factura;
	String cliente;
	String estatus;
	String referencia;
	
	public int getIdControl() {
		return idControl;
	}
	public void setIdControl(int idControl) {
		this.idControl = idControl;
	}
	public int getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}	public String getReferencia() {
	    return referencia;
	}
	public void setReferencia(String referencia) {
	    this.referencia = referencia;
	}
	
}
