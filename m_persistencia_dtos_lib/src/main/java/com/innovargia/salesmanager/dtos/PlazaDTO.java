/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author aruaro
 *
 */
public class PlazaDTO {
	int identificador;
	String idcentrooperativo;
	String siglasplaza;
	String descripcion;
	int estatus=-1;
	/**
	 * 
	 */
	public PlazaDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the idcentrooperativo
	 */
	public String getIdcentrooperativo() {
		return idcentrooperativo;
	}
	/**
	 * @param idcentrooperativo the idcentrooperativo to set
	 */
	public void setIdcentrooperativo(String idcentrooperativo) {
		this.idcentrooperativo = idcentrooperativo;
	}
	/**
	 * @return the siglasplaza
	 */
	public String getSiglasplaza() {
		return siglasplaza;
	}
	/**
	 * @param siglasplaza the siglasplaza to set
	 */
	public void setSiglasplaza(String siglasplaza) {
		this.siglasplaza = siglasplaza;
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
	public int getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}
	/**
	 * @return the identificador
	 */
	public int getIdentificador() {
		return identificador;
	}
	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

}
