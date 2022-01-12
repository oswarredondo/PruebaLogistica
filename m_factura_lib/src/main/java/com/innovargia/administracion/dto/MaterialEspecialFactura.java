/**
 * 
 */
package com.innovargia.administracion.dto;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class MaterialEspecialFactura implements Serializable{


	private static final long serialVersionUID = 1L;
	
	String idmaterial,observacion,nombre,descripcion;
	int idregistro,idcontrol,cantidad ;
	float precio;
	
	
	/**
	 * @return the idmaterial
	 */
	public String getIdmaterial() {
		return idmaterial;
	}
	/**
	 * @param idmaterial the idmaterial to set
	 */
	public void setIdmaterial(String idmaterial) {
		this.idmaterial = idmaterial;
	}
	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}
	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the idcontrol
	 */
	public int getIdcontrol() {
		return idcontrol;
	}
	/**
	 * @param idcontrol the idcontrol to set
	 */
	public void setIdcontrol(int idcontrol) {
		this.idcontrol = idcontrol;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	/**
	 * @return the idregistro
	 */
	public int getIdregistro() {
		return idregistro;
	}
	/**
	 * @param idregistro the idregistro to set
	 */
	public void setIdregistro(int idregistro) {
		this.idregistro = idregistro;
	}

}
