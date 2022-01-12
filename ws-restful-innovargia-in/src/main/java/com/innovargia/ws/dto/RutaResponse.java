package com.innovargia.ws.dto;


public class RutaResponse {
	
	String idGuia;
	String direccion;
	String telefono;
	String contacto;
	
	public RutaResponse() {
		super();
	}
	
	public RutaResponse(String idGuia, String direccion, String telefono, String contacto) {
		super();
		this.idGuia = idGuia;
		this.direccion = direccion;
		this.telefono = telefono;
		this.contacto = contacto;
	}
	
	public String getIdGuia() {
		return idGuia;
	}
	public void setIdGuia(String idGuia) {
		this.idGuia = idGuia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	
	

}