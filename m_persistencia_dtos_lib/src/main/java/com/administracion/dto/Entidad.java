/**
 * 
 */
package com.administracion.dto;

import java.util.ArrayList;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class Entidad implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int identidad;
	private String descripcion;
	private String estatus;//Estatus A=activo I=Inactivo 
	public ArrayList<Organizacion> arr_organizacion= new ArrayList<Organizacion>();

	/**
	 * 
	 */
	public Entidad() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the identidad
	 */
	public int getIdentidad() {
		return identidad;
	}

	/**
	 * @param identidad the identidad to set
	 */
	public void setIdentidad(int identidad) {
		this.identidad = identidad;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

}
