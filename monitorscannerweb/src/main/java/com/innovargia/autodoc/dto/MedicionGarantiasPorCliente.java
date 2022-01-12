package com.innovargia.autodoc.dto;

public class MedicionGarantiasPorCliente {

	String grupo;
	float entrega;
	float transito;
	float demora;
	
	public MedicionGarantiasPorCliente() {
		super();
	}
	
	public MedicionGarantiasPorCliente(String grupo, float entrega, float transito, float demora) {
		super();
		this.grupo = grupo;
		this.entrega = entrega;
		this.transito = transito;
		this.demora = demora;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public float getEntrega() {
		return entrega;
	}
	public void setEntrega(float entrega) {
		this.entrega = entrega;
	}
	public float getTransito() {
		return transito;
	}
	public void setTransito(float transito) {
		this.transito = transito;
	}
	public float getDemora() {
		return demora;
	}
	public void setDemora(float demora) {
		this.demora = demora;
	}
	
}
