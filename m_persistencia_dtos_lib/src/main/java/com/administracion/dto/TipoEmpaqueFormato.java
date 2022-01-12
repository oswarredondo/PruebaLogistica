/**
 * 
 */
package com.administracion.dto;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class TipoEmpaqueFormato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String idformato;
	String descripcion;
	float largo=0;
	float ancho=0;
	float alto=0;
	float peso=0;
	int modificacliente=0;
	int visiblepdv=0;
	
	
	public String getIdformato() {
		return idformato;
	}
	public void setIdformato(String idformato) {
		this.idformato = idformato;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getLargo() {
		return largo;
	}
	public void setLargo(float largo) {
		this.largo = largo;
	}
	public float getAncho() {
		return ancho;
	}
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}
	public float getAlto() {
		return alto;
	}
	public void setAlto(float alto) {
		this.alto = alto;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public int getModificacliente() {
		return modificacliente;
	}
	public void setModificacliente(int modificacliente) {
		this.modificacliente = modificacliente;
	}
	public int getVisiblepdv() {
		return visiblepdv;
	}
	public void setVisiblepdv(int visiblepdv) {
		this.visiblepdv = visiblepdv;
	}

}
