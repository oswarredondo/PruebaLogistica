/**
 * 
 */
package com.innovargia.salesmanager.dtos;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Adrian Morales Ruaro
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrganizacionDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int identidad ;
	private int   idorganizacion ;
	private String  descripcion ;
	private String  fechacreacion ;
	private String  logo ;
	private String  estatus;
	public ArrayList<CuentasDTO> arr_cuentas= new ArrayList<CuentasDTO>();
	
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
 * @param idorganizacion the idorganizacion to set
	 */
	public void setIdorganizacion(String idorganizacion) {
		try{
			this.idorganizacion = Integer.parseInt(idorganizacion);
		}catch(Exception e){
			this.idorganizacion=-1;
		}
		
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
