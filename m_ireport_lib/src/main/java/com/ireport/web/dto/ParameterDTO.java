/**
 * 
 */
package com.ireport.web.dto;

import java.io.Serializable;

/**
 * Contiene los atributos de un parametro de Jasper
 * @author aruaro
 *
 */
public class ParameterDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name=null;
	private String value=null;
	private String xtype;
	private String id;
	private String fieldLabel;
	private String readOnly="false";
	private String  anchor= "100%";

	/**
	 * 
	 */
	public ParameterDTO() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}


	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}


	/**
	 * @return the xtype
	 */
	public String getXtype() {
		return xtype;
	}


	/**
	 * @param xtype the xtype to set
	 */
	public void setXtype(String xtype) {
		this.xtype = xtype;
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the fieldLabel
	 */
	public String getFieldLabel() {
		return fieldLabel;
	}


	/**
	 * @param fieldLabel the fieldLabel to set
	 */
	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}


	/**
	 * @return the anchor
	 */
	public String getAnchor() {
		return anchor;
	}


	/**
	 * @param anchor the anchor to set
	 */
	public void setAnchor(String anchor) {
		this.anchor = anchor;
	}


	public String getReadOnly() {
		return readOnly;
	}


	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}


	
}
