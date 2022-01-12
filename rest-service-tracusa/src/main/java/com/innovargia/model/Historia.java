package com.innovargia.model;

import java.io.Serializable;

public class Historia implements Serializable {

	private static final long serialVersionUID = 1L;
	String fecha;
	String tipomovimiento;
	String clave;
	String descripcioncve;
	String plaza;
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the tipomovimiento
	 */
	public String getTipomovimiento() {
		return tipomovimiento;
	}
	/**
	 * @param tipomovimiento the tipomovimiento to set
	 */
	public void setTipomovimiento(String tipomovimiento) {
		this.tipomovimiento = tipomovimiento;
	}
	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}
	/**
	 * @param clave the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}
	/**
	 * @return the plaza
	 */
	public String getPlaza() {
		return plaza;
	}
	/**
	 * @param plaza the plaza to set
	 */
	public void setPlaza(String plaza) {
		this.plaza = plaza;
	}
	/**
	 * @return the descripcioncve
	 */
	public String getDescripcioncve() {
		return descripcioncve;
	}
	/**
	 * @param descripcioncve the descripcioncve to set
	 */
	public void setDescripcioncve(String descripcioncve) {
		this.descripcioncve = descripcioncve;
	}

}
