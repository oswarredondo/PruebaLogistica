package com.innovargia.salesmanager.dtos;

public class ErrorValidacion {
	boolean hayError=false;
    /**
	 * @return the hayError
	 */
	public boolean isHayError() {
		return hayError;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param hayError the hayError to set
	 */
	public void setHayError(boolean hayError) {
		this.hayError = hayError;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	//Pueden ir varios errores separados por comas
	String error;
}
