/**
 * 
 */
package com.administracion.dto;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class CatalogoGenerico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String identificador;
	private String descripcion;
	private String formato;

	/**
	 * @return the formato
	 */
	public String getFormato() {
		return formato;
	}

	/**
	 * @param formato the formato to set
	 */
	public void setFormato(String formato) {
		this.formato = formato;
	}

	/**
	 * 
	 */
	public CatalogoGenerico() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
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
	
	

}
