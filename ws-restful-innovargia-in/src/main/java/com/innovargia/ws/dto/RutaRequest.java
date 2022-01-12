package com.innovargia.ws.dto;

public class RutaRequest {

	String operador;
	
	String viaje;

	public RutaRequest() {
		super();
	}

	public RutaRequest(String operador, String viaje) {
		super();
		this.operador = operador;
		this.viaje = viaje;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public String getViaje() {
		return viaje;
	}

	public void setViaje(String viaje) {
		this.viaje = viaje;
	}
	
	
}
