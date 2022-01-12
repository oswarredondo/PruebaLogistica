package com.innovargia.model;

import java.io.Serializable;

public class Confirmacion implements Serializable {

	private static final long serialVersionUID = 1L;
	String quienrecibe;
	String fecha;
	String latitud;
	String longitud;
	boolean tienefirma;
	
	String base64firma;
	
	/**
	 * @return the quienrecibe
	 */
	public String getQuienrecibe() {
		return quienrecibe;
	}
	/**
	 * @param quienrecibe the quienrecibe to set
	 */
	public void setQuienrecibe(String quienrecibe) {
		this.quienrecibe = quienrecibe;
	}
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the latitud
	 */
	public String getLatitud() {
		return latitud;
	}
	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	/**
	 * @return the longitud
	 */
	public String getLongitud() {
		return longitud;
	}
	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	/**
	 * @return the tienefirma
	 */
	public boolean isTienefirma() {
		return tienefirma;
	}
	/**
	 * @param tienefirma the tienefirma to set
	 */
	public void setTienefirma(boolean tienefirma) {
		this.tienefirma = tienefirma;
	}
	/**
	 * @return the base64firma
	 */
	public String getBase64firma() {
		return base64firma;
	}
	/**
	 * @param base64firma the base64firma to set
	 */
	public void setBase64firma(String base64firma) {
		this.base64firma = base64firma;
	}
}
