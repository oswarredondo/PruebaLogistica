/* $Id:  $
 *
 * Nombre del Proyecto:
 * Nombre del Programa: UsuarioDao.java
 * Responsable: Adrián Morales Ruaro
 * Descripcion:  Datos correspondientes a un modulo de un sistema
 *
 * $Log:$
 */
package com.innovargia.salesmanager.dtos;

/**
 * Contiene las propiedades de los modulos/opciones de un 
 * sistema a los cuales tiene acceso el usuario
 **/
public class ModuloSistemaDTO {
	
	/**Contiene el identificador del sistema*/
	private String idSistema;
	/**Contiene el nombre del modulo o de la opcion*/
	private String nombreModulo;
	/**Contiene el tipo de permiso para la opcion*/
	private String permiso="L";
	/**Contiene el identificador del modulo o de la opcion*/
	private String idModulo;
	public String getIdSistema() {
		return idSistema;
	}
	public void setIdSistema(String idSistema) {
		this.idSistema = idSistema;
	}
	public String getNombreModulo() {
		return nombreModulo;
	}
	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}
	public String getPermiso() {
		return permiso;
	}
	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}
	public String getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}
	
	
	

}//Fin de la clase ModuloSistema
