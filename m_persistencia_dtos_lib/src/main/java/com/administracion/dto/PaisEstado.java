package com.administracion.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaisEstado implements Serializable {

	private static final long serialVersionUID = 1L;
	String pais ;
	 String idpais ;
	 String idestado ;
	 String estado ;
	 int id;
	 
	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @return the idpais
	 */
	public String getIdpais() {
		return idpais;
	}
	/**
	 * @return the idestado
	 */
	public String getIdestado() {
		return idestado;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * @param idpais the idpais to set
	 */
	public void setIdpais(String idpais) {
		this.idpais = idpais;
	}
	/**
	 * @param idestado the idestado to set
	 */
	public void setIdestado(String idestado) {
		this.idestado = idestado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
}
