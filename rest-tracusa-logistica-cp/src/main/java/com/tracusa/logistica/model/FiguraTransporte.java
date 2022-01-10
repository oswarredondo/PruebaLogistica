package com.tracusa.logistica.model;

public class FiguraTransporte {

	String CveTransporte;
	Operadores Operadores;	
	Propietario Propietario;
	Arrendatario Arrendatario;
	Notificado Notificado;
	
	public FiguraTransporte() {
		super();
	}

	public String getCveTransporte() {
		return CveTransporte;
	}

	public void setCveTransporte(String cveTransporte) {
		CveTransporte = cveTransporte;
	}

	public Operadores getOperadores() {
		return Operadores;
	}

	public void setOperadores(Operadores operadores) {
		Operadores = operadores;
	}

	public Propietario getPropietario() {
		return Propietario;
	}

	public void setPropietario(Propietario propietario) {
		Propietario = propietario;
	}

	public Arrendatario getArrendatario() {
		return Arrendatario;
	}

	public void setArrendatario(Arrendatario arrendatario) {
		Arrendatario = arrendatario;
	}

	public Notificado getNotificado() {
		return Notificado;
	}

	public void setNotificado(Notificado notificado) {
		Notificado = notificado;
	}
	
}
