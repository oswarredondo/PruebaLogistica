package com.innovargia.ws.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RegistroDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String idMovimiento;
	String ri;
	String idGuia;
	List<RegistroDto> lista = new ArrayList<RegistroDto>();
	
	
	
	/**
	 * 
	 */
	public RegistroDto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idMovimiento
	 */
	public synchronized String getIdMovimiento() {
		return idMovimiento;
	}

	/**
	 * @param idMovimiento the idMovimiento to set
	 */
	public synchronized void setIdMovimiento(String idMovimiento) {
		this.idMovimiento = idMovimiento;
	}


	/**
	 * @return the ri
	 */
	public synchronized String getRi() {
		return ri;
	}

	/**
	 * @param ri the ri to set
	 */
	public synchronized void setRi(String ri) {
		this.ri = ri;
	}


	public synchronized void setIdGuia(String idGuia) {
		this.idGuia = idGuia;
	}


	public synchronized String getIdGuia() {
		return idGuia;
	}

	public List<RegistroDto> getLista() {
		return lista;
	}

	public void setLista(List<RegistroDto> lista) {
		this.lista = lista;
	}

}
