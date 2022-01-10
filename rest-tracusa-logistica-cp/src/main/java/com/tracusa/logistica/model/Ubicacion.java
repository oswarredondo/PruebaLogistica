package com.tracusa.logistica.model;

public class Ubicacion {

	String TipoEstacion;
    String DistanciaRecorrida;
    Origen Origen;
    Destino Destino;
    
	public Ubicacion() {
		super();
	}

	public String getTipoEstacion() {
		return TipoEstacion;
	}

	public void setTipoEstacion(String tipoEstacion) {
		TipoEstacion = tipoEstacion;
	}

	public String getDistanciaRecorrida() {
		return DistanciaRecorrida;
	}

	public void setDistanciaRecorrida(String distanciaRecorrida) {
		DistanciaRecorrida = distanciaRecorrida;
	}

	public Origen getOrigen() {
		return Origen;
	}

	public void setOrigen(Origen origen) {
		Origen = origen;
	}

	public Destino getDestino() {
		return Destino;
	}

	public void setDestino(Destino destino) {
		Destino = destino;
	}

}
