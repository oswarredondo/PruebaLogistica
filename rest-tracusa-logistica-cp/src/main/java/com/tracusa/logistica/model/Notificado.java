package com.tracusa.logistica.model;

public class Notificado {

	String RFCNotificado;
	String NombreNotificado;
	String NumRegIdTribNotificado;
	String ResidenciaFiscalNotificado;
	Domicilio Domicilio;
	
	public Notificado() {
		super();
	}

	public String getRFCNotificado() {
		return RFCNotificado;
	}

	public void setRFCNotificado(String rFCNotificado) {
		RFCNotificado = rFCNotificado;
	}

	public String getNombreNotificado() {
		return NombreNotificado;
	}

	public void setNombreNotificado(String nombreNotificado) {
		NombreNotificado = nombreNotificado;
	}

	public String getNumRegIdTribNotificado() {
		return NumRegIdTribNotificado;
	}

	public void setNumRegIdTribNotificado(String numRegIdTribNotificado) {
		NumRegIdTribNotificado = numRegIdTribNotificado;
	}

	public String getResidenciaFiscalNotificado() {
		return ResidenciaFiscalNotificado;
	}

	public void setResidenciaFiscalNotificado(String residenciaFiscalNotificado) {
		ResidenciaFiscalNotificado = residenciaFiscalNotificado;
	}

	public Domicilio getDomicilio() {
		return Domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		Domicilio = domicilio;
	}
	
}
