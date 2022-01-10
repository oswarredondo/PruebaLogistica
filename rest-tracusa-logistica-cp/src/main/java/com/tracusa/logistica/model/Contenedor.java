package com.tracusa.logistica.model;

public class Contenedor {

	String MatriculaContenedor;
	String TipoContenedor;
	String NumPrecinto;
	String PesoContenedorVacio;
	String PesoNetoMercancia;
	
	public Contenedor() {
		super();
	}

	public String getMatriculaContenedor() {
		return MatriculaContenedor;
	}

	public void setMatriculaContenedor(String matriculaContenedor) {
		MatriculaContenedor = matriculaContenedor;
	}

	public String getTipoContenedor() {
		return TipoContenedor;
	}

	public void setTipoContenedor(String tipoContenedor) {
		TipoContenedor = tipoContenedor;
	}

	public String getNumPrecinto() {
		return NumPrecinto;
	}

	public void setNumPrecinto(String numPrecinto) {
		NumPrecinto = numPrecinto;
	}

	public String getPesoContenedorVacio() {
		return PesoContenedorVacio;
	}

	public void setPesoContenedorVacio(String pesoContenedorVacio) {
		PesoContenedorVacio = pesoContenedorVacio;
	}

	public String getPesoNetoMercancia() {
		return PesoNetoMercancia;
	}

	public void setPesoNetoMercancia(String pesoNetoMercancia) {
		PesoNetoMercancia = pesoNetoMercancia;
	}
}
