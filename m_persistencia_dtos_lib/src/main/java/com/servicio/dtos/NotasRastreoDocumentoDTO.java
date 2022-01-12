/**
 * 
 */
package com.servicio.dtos;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class NotasRastreoDocumentoDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idDocumento;
	private String idTipoDocumento; 
	private String login; 
	private int idEntidad;  
	private int idOrganizacion; 
	private String fechaEvento; 
	private String nota;  
	private String archivoAdjunto; 
	
	/**
	 * 
	 */
	public NotasRastreoDocumentoDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idDocumento
	 */
	public String getIdDocumento() {
		return idDocumento;
	}

	/**
	 * @param idDocumento the idDocumento to set
	 */
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	/**
	 * @return the idTipoDocumento
	 */
	public String getIdTipoDocumento() {
		return idTipoDocumento;
	}

	/**
	 * @param idTipoDocumento the idTipoDocumento to set
	 */
	public void setIdTipoDocumento(String idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
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
	 * @return the idEntidad
	 */
	public int getIdEntidad() {
		return idEntidad;
	}

	/**
	 * @param idEntidad the idEntidad to set
	 */
	public void setIdEntidad(int idEntidad) {
		this.idEntidad = idEntidad;
	}

	/**
	 * @return the idOrganizacion
	 */
	public int getIdOrganizacion() {
		return idOrganizacion;
	}

	/**
	 * @param idOrganizacion the idOrganizacion to set
	 */
	public void setIdOrganizacion(int idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	/**
	 * @return the fechaEvento
	 */
	public String getFechaEvento() {
		return fechaEvento;
	}

	/**
	 * @param fechaEvento the fechaEvento to set
	 */
	public void setFechaEvento(String fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	/**
	 * @return the nota
	 */
	public String getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(String nota) {
		this.nota = nota;
	}

	/**
	 * @return the archivoAdjunto
	 */
	public String getArchivoAdjunto() {
		return archivoAdjunto;
	}

	/**
	 * @param archivoAdjunto the archivoAdjunto to set
	 */
	public void setArchivoAdjunto(String archivoAdjunto) {
		this.archivoAdjunto = archivoAdjunto;
	}

}
