package com.tracusa.logistica.model;

public class SiguienteMovimiento {
	
	int codigo;
	String movimiento;
	
	public SiguienteMovimiento() {
		super();
	}

	public SiguienteMovimiento(int codigo, String movimiento) {
		super();
		this.codigo = codigo;
		this.movimiento = movimiento;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}
	
}
