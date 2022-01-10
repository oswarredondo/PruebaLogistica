package com.tracusa.logistica.model;

public class Destino {

	String IDDestino;
	String RFCDestinatario;
	String NombreDestinatario;
	String NumRegIdTrib;
	String ResidenciaFiscal;
	String NumEstacion;
	String NombreEstacion;
	String NavegacionTrafico;
	String FechaHoraProgLlegada;
	Domicilio domicilio;

	public Destino() {
		super();
	}
	
	public String getIDDestino() {
		return IDDestino;
	}
	public void setIDDestino(String iDDestino) {
		IDDestino = iDDestino;
	}
	public String getRFCDestinatario() {
		return RFCDestinatario;
	}
	public void setRFCDestinatario(String rFCDestinatario) {
		RFCDestinatario = rFCDestinatario;
	}
	public String getNombreDestinatario() {
		return NombreDestinatario;
	}
	public void setNombreDestinatario(String nombreDestinatario) {
		NombreDestinatario = nombreDestinatario;
	}
	public String getNumRegIdTrib() {
		return NumRegIdTrib;
	}
	public void setNumRegIdTrib(String numRegIdTrib) {
		NumRegIdTrib = numRegIdTrib;
	}
	public String getResidenciaFiscal() {
		return ResidenciaFiscal;
	}
	public void setResidenciaFiscal(String residenciaFiscal) {
		ResidenciaFiscal = residenciaFiscal;
	}
	public String getNumEstacion() {
		return NumEstacion;
	}
	public void setNumEstacion(String numEstacion) {
		NumEstacion = numEstacion;
	}
	public String getNombreEstacion() {
		return NombreEstacion;
	}
	public void setNombreEstacion(String nombreEstacion) {
		NombreEstacion = nombreEstacion;
	}
	public String getNavegacionTrafico() {
		return NavegacionTrafico;
	}
	public void setNavegacionTrafico(String navegacionTrafico) {
		NavegacionTrafico = navegacionTrafico;
	}
	public String getFechaHoraProgLlegada() {
		return FechaHoraProgLlegada;
	}
	public void setFechaHoraProgLlegada(String fechaHoraProgLlegada) {
		FechaHoraProgLlegada = fechaHoraProgLlegada;
	}
	
	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
}
