package com.innovargia.autodoc.dto;

public class MedicionCumplimientoGarantias {
	
	String grupo;
	float si_cumplio;
	float no_cumplio;
	
	public MedicionCumplimientoGarantias() {
		super();
	}

	public MedicionCumplimientoGarantias(String grupo, float si_cumplio, float no_cumplio) {
		super();
		this.grupo = grupo;
		this.si_cumplio = si_cumplio;
		this.no_cumplio = no_cumplio;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public float getSi_cumplio() {
		return si_cumplio;
	}

	public void setSi_cumplio(float si_cumplio) {
		this.si_cumplio = si_cumplio;
	}

	public float getNo_cumplio() {
		return no_cumplio;
	}

	public void setNo_cumplio(float no_cumplio) {
		this.no_cumplio = no_cumplio;
	}

}
