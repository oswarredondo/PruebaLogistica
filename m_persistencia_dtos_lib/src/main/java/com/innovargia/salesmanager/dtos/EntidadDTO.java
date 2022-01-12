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
public class EntidadDTO implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int identidad;
	private String descripcion;
	private String estatus;//Estatus A=activo I=Inactivo 
	public ArrayList<OrganizacionDTO> arr_organizacion= new ArrayList<OrganizacionDTO>();

	/**
	 * 
	 */
	public EntidadDTO() {
		// TODO Auto-generated constructor stub
	}

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
	 * @param identidad the identidad to set
	 */
	public void setIdentidad(String identidad) {
		try{
			this.identidad = Integer.parseInt(identidad);
		}catch(Exception e){
			this.identidad=-1;
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
