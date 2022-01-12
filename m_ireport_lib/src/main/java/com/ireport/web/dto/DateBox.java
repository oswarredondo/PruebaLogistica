/**
 * 
 */
package com.ireport.web.dto;

/**
 * @author aruaro
 *
 */
public class DateBox extends ParameterDTO {
	
	String format="Y-m-d";
	 
	 /**
		 * 
		 */
		public DateBox() {
			super.setXtype("datefield");
			super.setValue("");
		}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	
}
