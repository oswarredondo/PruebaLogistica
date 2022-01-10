package com.tracusa.logistica.model;

public class CantidadTransporta {

	String Cantidad;
	String IDOrigen;
	String IDDestino;
	String CvesTransporte;
	
	public CantidadTransporta() {
		super();
	}

	public String getCantidad() {
		return Cantidad;
	}

	public void setCantidad(String cantidad) {
		Cantidad = cantidad;
	}

	public String getIDOrigen() {
		return IDOrigen;
	}

	public void setIDOrigen(String iDOrigen) {
		IDOrigen = iDOrigen;
	}

	public String getIDDestino() {
		return IDDestino;
	}

	public void setIDDestino(String iDDestino) {
		IDDestino = iDDestino;
	}

	public String getCvesTransporte() {
		return CvesTransporte;
	}

	public void setCvesTransporte(String cvesTransporte) {
		CvesTransporte = cvesTransporte;
	}
	
}
