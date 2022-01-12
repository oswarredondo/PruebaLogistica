/**
 * 
 */
package com.administracion.dto;

import java.util.ArrayList;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class Organizacion implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int identidad ;
	private int   idorganizacion ;
	private String  descripcion ;
	private String  fechacreacion ;
	private String  logo ;
	private String  estatus;
	public ArrayList<Cuentas> arr_cuentas= new ArrayList<Cuentas>();
	
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
	 * @return the fechacreacion
	 */
	public String getFechacreacion() {
		return fechacreacion;
	}
	/**
	 * @param fechacreacion the fechacreacion to set
	 */
	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
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
	
	
	  

}
