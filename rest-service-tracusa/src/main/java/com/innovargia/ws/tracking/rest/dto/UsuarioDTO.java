/**
 * 
 */
package com.innovargia.ws.tracking.rest.dto;

import java.io.Serializable;

/**
 * @author Adri�n
 *
 */
public class UsuarioDTO implements Serializable{
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private String nombre;
	private String numcte;
	private int idorganizacion;
	private int identidad;
	

	/**
	 * 
	 */
	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}


	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
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
	 * @return the numcte
	 */
	public String getNumcte() {
		return numcte;
	}


	/**
	 * @param numcte the numcte to set
	 */
	public void setNumcte(String numcte) {
		this.numcte = numcte;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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

}
