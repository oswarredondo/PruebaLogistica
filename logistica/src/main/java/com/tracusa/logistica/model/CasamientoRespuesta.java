package com.tracusa.logistica.model;

import java.util.List;

public class CasamientoRespuesta {
	
	String code;
	List<CodigoErrorCasamiento> lstErrores;
	
	public CasamientoRespuesta(String code, List<CodigoErrorCasamiento> lstErrores) {
		super();
		this.code = code;
		this.lstErrores = lstErrores;
	}
	
	public CasamientoRespuesta() {
		super();
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<CodigoErrorCasamiento> getLstErrores() {
		return lstErrores;
	}
	public void setLstErrores(List<CodigoErrorCasamiento> lstErrores) {
		this.lstErrores = lstErrores;
	}

}
