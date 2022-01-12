package com.innovargia.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.innovargia.utils.Constantes;

@JsonInclude(Include.NON_DEFAULT)  //Solo los datos que hayan sido inicializados
public class OutboundResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String guia;
	protected byte[] pdf;
	protected String codigo;
	protected String mensaje;
	protected String version = Constantes.VERSION;
	
	/**
	 * @return the guia
	 */
	public String getGuia() {
		return guia;
	}
	/**
	 * @param guia the guia to set
	 */
	public void setGuia(String guia) {
		this.guia = guia;
	}
	/**
	 * @return the pdf
	 */
	public byte[] getPdf() {
		return pdf;
	}
	/**
	 * @param pdf the pdf to set
	 */
	public void setPdf(byte[] pdf) {
		this.pdf = pdf;
	}
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
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}


}
