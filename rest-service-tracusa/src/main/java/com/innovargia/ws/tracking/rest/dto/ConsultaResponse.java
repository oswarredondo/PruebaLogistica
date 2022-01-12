/**
 * 
 */
package com.innovargia.ws.tracking.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author aruaro
 *
 */
@JsonInclude(Include.NON_DEFAULT)  //Solo los datos que hayan sido inicializados
public class ConsultaResponse {

	String codigo;
	String mensaje;
	List<Envio> envios;
	
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
	/**
	 * @return the envios
	 */
	public List<Envio> getEnvios() {
		return envios;
	}
	/**
	 * @param envios the envios to set
	 */
	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}
	
}
