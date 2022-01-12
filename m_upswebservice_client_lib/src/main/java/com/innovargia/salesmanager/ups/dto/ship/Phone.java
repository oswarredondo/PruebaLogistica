package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Phone {
	String Number;
	String Extension;
	/**
	 * @return the number
	 */
	public String getNumber() {
		return Number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		Number = number;
	}
	/**
	 * @return the extension
	 */
	public String getExtension() {
		return Extension;
	}
	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		Extension = extension;
	}
}
