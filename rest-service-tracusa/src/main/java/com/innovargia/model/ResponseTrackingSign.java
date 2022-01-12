/**
 * 
 */
package com.innovargia.model;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class ResponseTrackingSign implements Serializable{

	private static final long serialVersionUID = 1L;
	
	String codigo;
	String numeroguia;
	String mensaje;
	Firma confimacion;
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the numeroguia
	 */
	public String getNumeroguia() {
		return numeroguia;
	}
	/**
	 * @param numeroguia the numeroguia to set
	 */
	public void setNumeroguia(String numeroguia) {
		this.numeroguia = numeroguia;
	}
	/**
	 * @return the confimacion
	 */
	public Firma getConfimacion() {
		return confimacion;
	}
	/**
	 * @param confimacion the confimacion to set
	 */
	public void setConfimacion(Firma confimacion) {
		this.confimacion = confimacion;
	}
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
