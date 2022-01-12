/**
 * 
 */
package com.administracion.dto;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class DocumentoJson implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String iddocumento ;
	String fechaevento ;
	String jsondata ;
	String login ;
	  

	/**
	 * 
	 */
	public DocumentoJson() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the iddocumento
	 */
	public String getIddocumento() {
		return iddocumento;
	}


	/**
	 * @param iddocumento the iddocumento to set
	 */
	public void setIddocumento(String iddocumento) {
		this.iddocumento = iddocumento;
	}


	/**
	 * @return the fechaevento
	 */
	public String getFechaevento() {
		return fechaevento;
	}


	/**
	 * @param fechaevento the fechaevento to set
	 */
	public void setFechaevento(String fechaevento) {
		this.fechaevento = fechaevento;
	}


	/**
	 * @return the jsondata
	 */
	public String getJsondata() {
		return jsondata;
	}


	/**
	 * @param jsondata the jsondata to set
	 */
	public void setJsondata(String jsondata) {
		this.jsondata = jsondata;
	}


	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}


	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

}
