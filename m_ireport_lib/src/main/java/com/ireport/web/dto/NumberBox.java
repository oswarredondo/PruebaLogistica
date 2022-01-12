/**
 * 
 */
package com.ireport.web.dto;

/**
 * @author aruaro
 *
 */
public class NumberBox extends ParameterDTO {
	
	 double maxValue= 999999.99;
	 double minValue= 0;
	 String decimalSeparator=".";

	/**
	 * 
	 */
	public NumberBox() {
		super.setXtype("numberfield");
		super.setValue("0");
	}



	/**
	 * @return the maxValue
	 */
	public double getMaxValue() {
		return maxValue;
	}

	/**
	 * @param maxValue the maxValue to set
	 */
	public void setMaxValue(double maxValue) {
		this.maxValue = maxValue;
	}

	/**
	 * @return the minValue
	 */
	public double getMinValue() {
		return minValue;
	}

	/**
	 * @param minValue the minValue to set
	 */
	public void setMinValue(double minValue) {
		this.minValue = minValue;
	}

	/**
	 * @return the decimalSeparator
	 */
	public String getDecimalSeparator() {
		return decimalSeparator;
	}

	/**
	 * @param decimalSeparator the decimalSeparator to set
	 */
	public void setDecimalSeparator(String decimalSeparator) {
		this.decimalSeparator = decimalSeparator;
	}

	

}
