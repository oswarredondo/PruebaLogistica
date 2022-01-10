package com.tracusa.logistica.model;

public class DetalleMercancia {

	String UnidadPeso;
	String PesoBruto;
	String PesoNeto;
	String PesoTara;
	String NumPiezas;
	
	public DetalleMercancia() {
		super();
	}
	public String getUnidadPeso() {
		return UnidadPeso;
	}
	public void setUnidadPeso(String unidadPeso) {
		UnidadPeso = unidadPeso;
	}
	public String getPesoBruto() {
		return PesoBruto;
	}
	public void setPesoBruto(String pesoBruto) {
		PesoBruto = pesoBruto;
	}
	public String getPesoNeto() {
		return PesoNeto;
	}
	public void setPesoNeto(String pesoNeto) {
		PesoNeto = pesoNeto;
	}
	public String getPesoTara() {
		return PesoTara;
	}
	public void setPesoTara(String pesoTara) {
		PesoTara = pesoTara;
	}
	public String getNumPiezas() {
		return NumPiezas;
	}
	public void setNumPiezas(String numPiezas) {
		NumPiezas = numPiezas;
	}
	
}
