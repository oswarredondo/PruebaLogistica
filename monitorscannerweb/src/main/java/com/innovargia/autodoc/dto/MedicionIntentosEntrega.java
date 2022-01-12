package com.innovargia.autodoc.dto;

public class MedicionIntentosEntrega {

	String semana;
	float intento1;
	float intento2;
	float masDe3;
	
	public MedicionIntentosEntrega() {
		super();
	}

	public String getSemana() {
		return semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public float getIntento1() {
		return intento1;
	}

	public void setIntento1(float intento1) {
		this.intento1 = intento1;
	}

	public float getIntento2() {
		return intento2;
	}

	public void setIntento2(float intento2) {
		this.intento2 = intento2;
	}

	public float getMasDe3() {
		return masDe3;
	}

	public void setMasDe3(float masDe3) {
		this.masDe3 = masDe3;
	}
	
}
