package com.tracusa.logistica.model;

public class Propietario {

	String RFCPropietario;
	String NombrePropietario;
	String NumRegIdTribPropietario;
	String ResidenciaFiscalPropietario;
	Domicilio domicilio;
	
	public Propietario() {
		super();
	}

	public String getRFCPropietario() {
		return RFCPropietario;
	}

	public void setRFCPropietario(String rFCPropietario) {
		RFCPropietario = rFCPropietario;
	}

	public String getNombrePropietario() {
		return NombrePropietario;
	}

	public void setNombrePropietario(String nombrePropietario) {
		NombrePropietario = nombrePropietario;
	}

	public String getNumRegIdTribPropietario() {
		return NumRegIdTribPropietario;
	}

	public void setNumRegIdTribPropietario(String numRegIdTribPropietario) {
		NumRegIdTribPropietario = numRegIdTribPropietario;
	}

	public String getResidenciaFiscalPropietario() {
		return ResidenciaFiscalPropietario;
	}

	public void setResidenciaFiscalPropietario(String residenciaFiscalPropietario) {
		ResidenciaFiscalPropietario = residenciaFiscalPropietario;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	
}
