package com.innovargia.autodoc.dto;

public class MedicionDias {

	String cop;
	String dia;
	int numGuias;
	float porcentaje;
	
	public MedicionDias() {
		super();
	}

	public MedicionDias(String cop, String dia, int numGuias, float porcentaje) {
		super();
		this.cop = cop;
		this.dia = dia;
		this.numGuias = numGuias;
		this.porcentaje = porcentaje;
	}

	public String getCop() {
		return cop;
	}

	public void setCop(String cop) {
		this.cop = cop;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public int getNumGuias() {
		return numGuias;
	}

	public void setNumGuias(int numGuias) {
		this.numGuias = numGuias;
	}

	public float getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	
}
