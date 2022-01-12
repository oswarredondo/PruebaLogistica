package com.innovargia.ws.dto;

import java.util.List;

public class MovimientoRespuesta {
	
	String idGuia;
	SiguienteMovimiento movimientoActual;
	List<SiguienteMovimiento> lstSiguienteMovimiento;
	
	public MovimientoRespuesta() {
		super();
	}

	public MovimientoRespuesta(String idGuia, SiguienteMovimiento movimientoActual, List<SiguienteMovimiento> lstSiguienteMovimiento) {
		super();
		this.idGuia = idGuia;
		this.movimientoActual = movimientoActual;
		this.lstSiguienteMovimiento = lstSiguienteMovimiento;
	}

	public String getIdGuia() {
		return idGuia;
	}

	public void setIdGuia(String idGuia) {
		this.idGuia = idGuia;
	}
	
	public SiguienteMovimiento getMovimientoActual() {
		return movimientoActual;
	}

	public void setMovimientoActual(SiguienteMovimiento movimientoActual) {
		this.movimientoActual = movimientoActual;
	}

	public List<SiguienteMovimiento> getLstSiguienteMovimiento() {
		return lstSiguienteMovimiento;
	}

	public void setLstSiguienteMovimiento(List<SiguienteMovimiento> lstSiguienteMovimiento) {
		this.lstSiguienteMovimiento = lstSiguienteMovimiento;
	}
	
}
