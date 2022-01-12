/**
 * 
 */
package com.ireport.web.dto;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class IReportDTO {

	private String nombre;
	private String id;
	private String descripcion;
	private String nivel;
	private String idconexion;
	private int idregistro;
	/**
	 * 
	 */
	public IReportDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the nivel
	 */
	public String getNivel() {
		return nivel;
	}
	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	/**
	 * @return the idconexion
	 */
	public String getIdconexion() {
		return idconexion;
	}
	/**
	 * @param idconexion the idconexion to set
	 */
	public void setIdconexion(String idconexion) {
		this.idconexion = idconexion;
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
