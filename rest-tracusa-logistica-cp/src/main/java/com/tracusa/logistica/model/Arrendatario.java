package com.tracusa.logistica.model;

public class Arrendatario {

	String RFCArrendatario;
	String NombreArrendatario;
	String NumRegIdTribArrendatario;
	String ResidenciaFiscalArrendatario;
	Domicilio Domicilio;
	
	public Arrendatario() {
		super();
	}

	public String getRFCArrendatario() {
		return RFCArrendatario;
	}

	public void setRFCArrendatario(String rFCArrendatario) {
		RFCArrendatario = rFCArrendatario;
	}

	public String getNombreArrendatario() {
		return NombreArrendatario;
	}

	public void setNombreArrendatario(String nombreArrendatario) {
		NombreArrendatario = nombreArrendatario;
	}

	public String getNumRegIdTribArrendatario() {
		return NumRegIdTribArrendatario;
	}

	public void setNumRegIdTribArrendatario(String numRegIdTribArrendatario) {
		NumRegIdTribArrendatario = numRegIdTribArrendatario;
	}

	public String getResidenciaFiscalArrendatario() {
		return ResidenciaFiscalArrendatario;
	}

	public void setResidenciaFiscalArrendatario(String residenciaFiscalArrendatario) {
		ResidenciaFiscalArrendatario = residenciaFiscalArrendatario;
	}

	public Domicilio getDomicilio() {
		return Domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		Domicilio = domicilio;
	}
	
}
