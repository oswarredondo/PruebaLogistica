package com.tracusa.logistica.model;

public class CodigoErrorCasamiento {
	
	String idGuia;
	int codigoError;
	String descripcionError;
	
	public CodigoErrorCasamiento(String idGuia, int codigoError, String descripcionError) {
		super();
		this.idGuia = idGuia;
		this.codigoError = codigoError;
		this.descripcionError = descripcionError;
	}
	public CodigoErrorCasamiento() {
		super();
	}
	public String getIdGuia() {
		return idGuia;
	}
	public void setIdGuia(String idGuia) {
		this.idGuia = idGuia;
	}
	public int getCodigoError() {
		return codigoError;
	}
	public void setCodigoError(int codigoError) {
		this.codigoError = codigoError;
	}
	public String getDescripcionError() {
		return descripcionError;
	}
	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}

}
