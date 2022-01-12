package com.innovargia.autodoc.dto;

public class DesgloceCumplimientoDiasTotal {

	String cop;
	float porcentaje;
	
	public DesgloceCumplimientoDiasTotal(String cop, float porcentaje) {
		super();
		this.cop = cop;
		this.porcentaje = porcentaje;
	}

	public DesgloceCumplimientoDiasTotal() {
		super();
	}
	
	public String getCop() {
		return cop;
	}

	public void setCop(String cop) {
		this.cop = cop;
	}

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	
}
