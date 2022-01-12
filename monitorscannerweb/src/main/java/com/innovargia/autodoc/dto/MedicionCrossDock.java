package com.innovargia.autodoc.dto;

public class MedicionCrossDock {
	
	String centro_operativo;
	float cross_dock;
	
	public MedicionCrossDock() {
		super();
	}
	
	public MedicionCrossDock(String centro_operativo, float cross_dock) {
		super();
		this.centro_operativo = centro_operativo;
		this.cross_dock = cross_dock;
	}
	
	public String getCentro_operativo() {
		return centro_operativo;
	}
	public void setCentro_operativo(String centro_operativo) {
		this.centro_operativo = centro_operativo;
	}
	public float getCross_dock() {
		return cross_dock;
	}
	public void setCross_dock(float cross_dock) {
		this.cross_dock = cross_dock;
	}
}
