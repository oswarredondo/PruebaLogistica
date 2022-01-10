package com.tracusa.logistica.model;

public class AutotransporteFederal {

	String PermSCT;
	String NumPermisoSCT;
	String NombreAseg;
	String NumPolizaSeguro;
	IdentificacionVehicular IdentificacionVehicular;
	
	public AutotransporteFederal() {
		super();
	}

	public String getPermSCT() {
		return PermSCT;
	}

	public void setPermSCT(String permSCT) {
		PermSCT = permSCT;
	}

	public String getNumPermisoSCT() {
		return NumPermisoSCT;
	}

	public void setNumPermisoSCT(String numPermisoSCT) {
		NumPermisoSCT = numPermisoSCT;
	}

	public String getNombreAseg() {
		return NombreAseg;
	}

	public void setNombreAseg(String nombreAseg) {
		NombreAseg = nombreAseg;
	}

	public String getNumPolizaSeguro() {
		return NumPolizaSeguro;
	}

	public void setNumPolizaSeguro(String numPolizaSeguro) {
		NumPolizaSeguro = numPolizaSeguro;
	}

	public IdentificacionVehicular getIdentificacionVehicular() {
		return IdentificacionVehicular;
	}

	public void setIdentificacionVehicular(IdentificacionVehicular identificacionVehicular) {
		IdentificacionVehicular = identificacionVehicular;
	}
}
