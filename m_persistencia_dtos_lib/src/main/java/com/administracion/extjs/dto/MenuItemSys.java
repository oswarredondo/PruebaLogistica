package com.administracion.extjs.dto;

import java.io.Serializable;

public class MenuItemSys implements Serializable{


	private static final long serialVersionUID = 1L;
	String windowId;
	
	public MenuItemSys(String windowId){
		this.windowId =windowId;
	}
	/**
	 * @return the windowId
	 */
	public String getWindowId() {
		return windowId;
	}
	/**
	 * @param windowId the windowId to set
	 */
	public void setWindowId(String windowId) {
		this.windowId = windowId;
	}
}
