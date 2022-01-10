package com.tracusa.logistica.model;

public class Operador {

	String RFCOperador;
	String NumLicencia;
	String NombreOperador;
	String NumRegIdTribOperador;
	String ResidenciaFiscalOperador;
	Domicilio Domicilio;
	
	public Operador() {
		super();
	}

	public String getRFCOperador() {
		return RFCOperador;
	}

	public void setRFCOperador(String rFCOperador) {
		RFCOperador = rFCOperador;
	}

	public String getNumLicencia() {
		return NumLicencia;
	}

	public void setNumLicencia(String numLicencia) {
		NumLicencia = numLicencia;
	}

	public String getNombreOperador() {
		return NombreOperador;
	}

	public void setNombreOperador(String nombreOperador) {
		NombreOperador = nombreOperador;
	}

	public String getNumRegIdTribOperador() {
		return NumRegIdTribOperador;
	}

	public void setNumRegIdTribOperador(String numRegIdTribOperador) {
		NumRegIdTribOperador = numRegIdTribOperador;
	}

	public String getResidenciaFiscalOperador() {
		return ResidenciaFiscalOperador;
	}

	public void setResidenciaFiscalOperador(String residenciaFiscalOperador) {
		ResidenciaFiscalOperador = residenciaFiscalOperador;
	}

	public Domicilio getDomicilio() {
		return Domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		Domicilio = domicilio;
	}
	
}
