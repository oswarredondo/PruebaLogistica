package com.tracusa.logistica.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViajeFinCarga {
    	
    	@JsonProperty("IdViaje")	
	int idViaje;
    	@JsonProperty("Estado")
	String estado;
    	@JsonProperty("ReferenciaExterna")
	String referenciaExterna;
    	@JsonProperty("TipoObjeto")
	String tipoObjeto;
    	@JsonProperty("Ambiente")
	String ambiente;
	
	public int getIdViaje() {
	    return idViaje;
	}
	public void setIdViaje(int idViaje) {
	    this.idViaje = idViaje;
	}
	public String getEstado() {
	    return estado;
	}
	public void setEstado(String estado) {
	    this.estado = estado;
	}
	public String getReferenciaExterna() {
	    return referenciaExterna;
	}
	public void setRferenciaExterna(String rferenciaExterna) {
	    this.referenciaExterna = rferenciaExterna;
	}
	public String getTipoObjeto() {
	    return tipoObjeto;
	}
	public void setTipoObjeto(String tipoObjeto) {
	    this.tipoObjeto = tipoObjeto;
	}
	public String getAmbiente() {
	    return ambiente;
	}
	public void setAmbiente(String ambiente) {
	    this.ambiente = ambiente;
	}
	

}
