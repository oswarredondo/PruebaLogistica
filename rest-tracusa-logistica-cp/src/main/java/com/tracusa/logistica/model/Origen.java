package com.tracusa.logistica.model;

public class Origen {

	String IDOrigen;
	String RFCRemitente;
	String NombreRemitente;
	String NumRegIdTrib;
	String ResidenciaFiscal;
	String NumEstacion;
	String NombreEstacion;
	String NavegacionTrafico;
	String FechaHoraSalida;
	Domicilio domicilio;
	
	public Origen() {
		super();
	}

	public String getIDOrigen() {
		return IDOrigen;
	}

	public void setIDOrigen(String iDOrigen) {
		IDOrigen = iDOrigen;
	}

	public String getRFCRemitente() {
		return RFCRemitente;
	}

	public void setRFCRemitente(String rFCRemitente) {
		RFCRemitente = rFCRemitente;
	}

	public String getNombreRemitente() {
		return NombreRemitente;
	}

	public void setNombreRemitente(String nombreRemitente) {
		NombreRemitente = nombreRemitente;
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

	public String getFechaHoraSalida() {
		return FechaHoraSalida;
	}

	public void setFechaHoraSalida(String fechaHoraSalida) {
		FechaHoraSalida = fechaHoraSalida;
	}
	
	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

}
