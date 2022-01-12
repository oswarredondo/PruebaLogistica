/**
 * 
 */
package com.ireport.web.dto;

/**
 * @author aruaro
 *
 */
public class IntegerBox extends ParameterDTO {
	
	 double maxValue= 999999;
	 double minValue= 0;
	 int decimalPrecision=0;
	 
	 /**
		 * 
		 */
		public IntegerBox() {
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
	 * @return the decimalPrecision
	 */
	public int getDecimalPrecision() {
		return decimalPrecision;
	}
	/**
	 * @param decimalPrecision the decimalPrecision to set
	 */
	public void setDecimalPrecision(int decimalPrecision) {
		this.decimalPrecision = decimalPrecision;
	}

	

	

}
