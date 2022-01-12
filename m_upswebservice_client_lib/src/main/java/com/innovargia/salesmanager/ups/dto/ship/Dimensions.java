package com.innovargia.salesmanager.ups.dto.ship;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Dimensions {
	String Length;
	String Width;
	String Height;
	UnitOfMeasurement UnitOfMeasurement;
	/**
	 * @return the length
	 */
	public String getLength() {
		return Length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(String length) {
		Length = length;
	}
	/**
	 * @return the width
	 */
	public String getWidth() {
		return Width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(String width) {
		Width = width;
	}
	/**
	 * @return the height
	 */
	public String getHeight() {
		return Height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		Height = height;
	}
	/**
	 * @return the unitOfMeasurement
	 */
	public UnitOfMeasurement getUnitOfMeasurement() {
		return UnitOfMeasurement;
	}
	/**
	 * @param unitOfMeasurement the unitOfMeasurement to set
	 */
	public void setUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
		UnitOfMeasurement = unitOfMeasurement;
	}
}
