/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author Adrián
 *
 */
public class OpcionMenu {
	private int identidad;
	private int idorganizacion;
	private String module;
	private String name;
	private String estatus;
	private String text;
	private String iconCls;
	private String windowId;
	private int quickstart=0;
	private int shortcut=0;
	/**
	 * @return the identidad
	 */
	public int getIdentidad() {
		return identidad;
	}
	/**
	 * @param identidad the identidad to set
	 */
	public void setIdentidad(int identidad) {
		this.identidad = identidad;
	}
	/**
	 * @return the idorganizacion
	 */
	public int getIdorganizacion() {
		return idorganizacion;
	}
	/**
	 * @param idorganizacion the idorganizacion to set
	 */
	public void setIdorganizacion(int idorganizacion) {
		this.idorganizacion = idorganizacion;
	}
	/**
	 * @return the module
	 */
	public String getModule() {
		return module;
	}
	/**
	 * @param module the module to set
	 */
	public void setModule(String module) {
		this.module = module;
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
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the iconCls
	 */
	public String getIconCls() {
		return iconCls;
	}
	/**
	 * @param iconCls the iconCls to set
	 */
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
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
	/**
	 * @return the quickstart
	 */
	public int getQuickstart() {
		return quickstart;
	}
	/**
	 * @param quickstart the quickstart to set
	 */
	public void setQuickstart(int quickstart) {
		this.quickstart = quickstart;
	}
	/**
	 * @return the shortcut
	 */
	public int getShortcut() {
		return shortcut;
	}
	/**
	 * @param shortcut the shortcut to set
	 */
	public void setShortcut(int shortcut) {
		this.shortcut = shortcut;
	}
}
