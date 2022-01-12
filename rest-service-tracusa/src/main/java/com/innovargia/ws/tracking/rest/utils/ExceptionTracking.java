package com.innovargia.ws.tracking.rest.utils;

public class ExceptionTracking extends Exception {
	String codigo;
	private static final long serialVersionUID = 1L;

	public ExceptionTracking(String message) {
		super(message);
	}

	public ExceptionTracking(String message, String codigo) {
		super(message);
		this.codigo = codigo;

	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
