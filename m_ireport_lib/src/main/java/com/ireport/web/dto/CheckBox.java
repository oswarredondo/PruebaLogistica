/**
 * 
 */
package com.ireport.web.dto;

/**
 * @author aruaro
 *
 */
public class CheckBox extends ParameterDTO {
	
	
	boolean checked= false;

	/**
	 * 
	 */
	public CheckBox() {
		super.setXtype("checkboxfield");
	}

	/**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}

	/**
	 * @param checked the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
