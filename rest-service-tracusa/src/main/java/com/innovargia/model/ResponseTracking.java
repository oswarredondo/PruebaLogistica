/**
 * 
 */
package com.innovargia.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aruaro
 *
 */
public class ResponseTracking {
	String codigo;
	String mensaje;
	String numeroguia;
	Confirmacion confimacion;
	List<Historia> historia = new ArrayList<Historia>();
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
	public Confirmacion getConfimacion() {
		return confimacion;
	}
	/**
	 * @param confimacion the confimacion to set
	 */
	public void setConfimacion(Confirmacion confimacion) {
		this.confimacion = confimacion;
	}
	/**
	 * @return the historia
	 */
	public List<Historia> getHistoria() {
		return historia;
	}
	/**
	 * @param historia the historia to set
	 */
	public void setHistoria(List<Historia> historia) {
		this.historia = historia;
	}
	
	public void addHistoria(Historia historia) {
		if (this.historia==null){
			this.historia = new ArrayList<Historia>();
		}
		this.historia.add(historia);
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
