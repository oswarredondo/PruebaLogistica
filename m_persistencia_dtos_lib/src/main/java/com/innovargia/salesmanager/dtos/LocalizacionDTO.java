/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author aruaro
 *
 */
public class LocalizacionDTO {
	
	int idlocalizacion ;
	String telefono1   ;
	String telefono    ;
	String fax         ;
	String email;
	String twitter;
	String radio;
	String paginaweb;
	int idcliente      ; 
	

	/**
	 * 
	 */
	public LocalizacionDTO() {
		// TODO Auto-generated constructor stub
	}


	public int getIdlocalizacion() {
		return idlocalizacion;
	}


	public void setIdlocalizacion(int idlocalizacion) {
		this.idlocalizacion = idlocalizacion;
	}


	public String getTelefono1() {
		return telefono1;
	}


	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getFax() {
		return fax;
	}


	public void setFax(String fax) {
		this.fax = fax;
	}


	public int getIdcliente() {
		return idcliente;
	}


	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTwitter() {
		return twitter;
	}


	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}


	public String getRadio() {
		return radio;
	}


	public void setRadio(String radio) {
		this.radio = radio;
	}


	public String getPaginaweb() {
		return paginaweb;
	}


	public void setPaginaweb(String paginaweb) {
		this.paginaweb = paginaweb;
	}

}
