/**
 * 
 */
package com.innovargia.model;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class DetalleEnvio implements Serializable{

	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String fechaInicioRecoleccion;
    protected String fechaFinRecoleccion;
	public String getFechaInicioRecoleccion() {
		return fechaInicioRecoleccion;
	}
	public void setFechaInicioRecoleccion(String fechaInicioRecoleccion) {
		this.fechaInicioRecoleccion = fechaInicioRecoleccion;
	}
	public String getFechaFinRecoleccion() {
		return fechaFinRecoleccion;
	}
	public void setFechaFinRecoleccion(String fechaFinRecoleccion) {
		this.fechaFinRecoleccion = fechaFinRecoleccion;
	}
    
}
