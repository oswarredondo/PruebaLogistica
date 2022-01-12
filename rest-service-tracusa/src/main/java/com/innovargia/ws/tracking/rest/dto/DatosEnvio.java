/**
 * 
 */
package com.innovargia.ws.tracking.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author aruaro
 *
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class DatosEnvio {
    String numeroCliente;
	String referencia;
	String contenido;
	String observacion;
	String quienGenera;
	String plazaOrigen;
	String plazaDestino;
	String empaque;
	String guiaMultipleMadre;
	int consecutivo_multiple;
	int alto;
	int ancho;
	int largo;
	float peso;
	

	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}
	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}
	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}
	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	/**
	 * @return the quienGenera
	 */
	public String getQuienGenera() {
		return quienGenera;
	}
	/**
	 * @param quienGenera the quienGenera to set
	 */
	public void setQuienGenera(String quienGenera) {
		this.quienGenera = quienGenera;
	}
	/**
	 * @return the plazaOrigen
	 */
	public String getPlazaOrigen() {
		return plazaOrigen;
	}
	/**
	 * @param plazaOrigen the plazaOrigen to set
	 */
	public void setPlazaOrigen(String plazaOrigen) {
		this.plazaOrigen = plazaOrigen;
	}
	/**
	 * @return the plazaDestino
	 */
	public String getPlazaDestino() {
		return plazaDestino;
	}
	/**
	 * @param plazaDestino the plazaDestino to set
	 */
	public void setPlazaDestino(String plazaDestino) {
		this.plazaDestino = plazaDestino;
	}
	/**
	 * @return the empaque
	 */
	public String getEmpaque() {
		return empaque;
	}
	/**
	 * @param empaque the empaque to set
	 */
	public void setEmpaque(String empaque) {
		this.empaque = empaque;
	}
	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}
	/**
	 * @param alto the alto to set
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}
	/**
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}
	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	/**
	 * @return the largo
	 */
	public int getLargo() {
		return largo;
	}
	/**
	 * @param largo the largo to set
	 */
	public void setLargo(int largo) {
		this.largo = largo;
	}
	/**
	 * @return the peso
	 */
	public float getPeso() {
		return peso;
	}
	/**
	 * @param peso the peso to set
	 */
	public void setPeso(float peso) {
		this.peso = peso;
	}
	/**
	 * @return the guiaMultipleMadre
	 */
	public String getGuiaMultipleMadre() {
		return guiaMultipleMadre;
	}
	/**
	 * @param guiaMultipleMadre the guiaMultipleMadre to set
	 */
	public void setGuiaMultipleMadre(String guiaMultipleMadre) {
		this.guiaMultipleMadre = guiaMultipleMadre;
	}
	/**
	 * @return the consecutivo_multiple
	 */
	public int getConsecutivo_multiple() {
		return consecutivo_multiple;
	}
	/**
	 * @param consecutivo_multiple the consecutivo_multiple to set
	 */
	public void setConsecutivo_multiple(int consecutivo_multiple) {
		this.consecutivo_multiple = consecutivo_multiple;
	}
	/**
	 * @return the numeroCliente
	 */
	public String getNumeroCliente() {
		return numeroCliente;
	}
	/**
	 * @param numeroCliente the numeroCliente to set
	 */
	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	
}
