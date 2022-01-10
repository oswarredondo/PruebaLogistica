package com.tracusa.logistica.model;

public class TransporteFerroviario {

	String TipoDeServicio;
	String NombreAseg;
	String NumPolizaSeguro;
	String Concesionario;
	DerechosDePaso DerechosDePaso;
	Carro Carro;
	
	public TransporteFerroviario() {
		super();
	}

	public String getTipoDeServicio() {
		return TipoDeServicio;
	}

	public void setTipoDeServicio(String tipoDeServicio) {
		TipoDeServicio = tipoDeServicio;
	}

	public String getNombreAseg() {
		return NombreAseg;
	}

	public void setNombreAseg(String nombreAseg) {
		NombreAseg = nombreAseg;
	}

	public String getNumPolizaSeguro() {
		return NumPolizaSeguro;
	}

	public void setNumPolizaSeguro(String numPolizaSeguro) {
		NumPolizaSeguro = numPolizaSeguro;
	}

	public String getConcesionario() {
		return Concesionario;
	}

	public void setConcesionario(String concesionario) {
		Concesionario = concesionario;
	}

	public DerechosDePaso getDerechosDePaso() {
		return DerechosDePaso;
	}

	public void setDerechosDePaso(DerechosDePaso derechosDePaso) {
		DerechosDePaso = derechosDePaso;
	}

	public Carro getCarro() {
		return Carro;
	}

	public void setCarro(Carro carro) {
		Carro = carro;
	}
	
}
