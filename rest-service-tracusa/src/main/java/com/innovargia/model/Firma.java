package com.innovargia.model;

public class Firma extends Confirmacion {

	private static final long serialVersionUID = 1L;
	String base64firma;
	
	String extension;
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
	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}
	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
}
