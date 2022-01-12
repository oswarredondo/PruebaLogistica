package com.innovargia.documentos.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Regional implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Datos de regionales
	private int origen;
	private int destino;
	private String servicio; 
	private String idGarantia; 
	private String mensajeria;
	public	Objeto garantia = new  Objeto();

	/**
	 * @return the idGarantia
	 */
	public String getIdGarantia() {
		return idGarantia;
	}
	/**
	 * @param idGarantia the idGarantia to set
	 */
	public void setIdGarantia(String idGarantia) {
		this.idGarantia = idGarantia;
	}
	
	/**
	 * @return the regOri
	 */
	public int getOrigen() {
		return origen;
	}
	/**
	 * @param regOri the regOri to set
	 */
	public void setOrigen(int origen) {
		this.origen = origen;
	}
	/**
	 * @return the regDes
	 */
	public int getDestino() {
		return destino;
	}
	/**
	 * @param regDes the regDes to set
	 */
	public void setDestino(int destino) {
		this.destino = destino;
	}
	/**
	 * @return the servicio
	 */
	public String getServicio() {
		return servicio;
	}
	/**
	 * @param servicio the servicio to set
	 */
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	/**
	 * @return the mensajeria
	 */
	public String getMensajeria() {
		return mensajeria;
	}
	/**
	 * @param mensajeria the mensajeria to set
	 */
	public void setMensajeria(String mensajeria) {
		this.mensajeria = mensajeria;
	}
}//Fin de Regional
