package com.innovargia.autodoc.dto;

public class MedicionPendientesCO {
	
	String estatus;
	int almacen;
	int ruta;
	int rutaForanea;
	int confirmaActualiza;
	int investigacion;
	int entrega;
	int sinMovimientos;
	
	public MedicionPendientesCO() {
		super();
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public int getAlmacen() {
		return almacen;
	}

	public void setAlmacen(int almacen) {
		this.almacen = almacen;
	}

	public int getRuta() {
		return ruta;
	}

	public void setRuta(int ruta) {
		this.ruta = ruta;
	}

	public int getRutaForanea() {
		return rutaForanea;
	}

	public void setRutaForanea(int rutaForanea) {
		this.rutaForanea = rutaForanea;
	}

	public int getConfirmaActualiza() {
		return confirmaActualiza;
	}

	public void setConfirmaActualiza(int confirmaActualiza) {
		this.confirmaActualiza = confirmaActualiza;
	}

	public int getInvestigacion() {
		return investigacion;
	}

	public void setInvestigacion(int investigacion) {
		this.investigacion = investigacion;
	}

	public int getEntrega() {
		return entrega;
	}

	public void setEntrega(int entrega) {
		this.entrega = entrega;
	}

	public int getSinMovimientos() {
		return sinMovimientos;
	}

	public void setSinMovimientos(int sinMovimientos) {
		this.sinMovimientos = sinMovimientos;
	}
	
}
