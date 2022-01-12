/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author aruaro
 *
 */
public class AttachmentDTO {
	String identificador;
	String iddocumento;
	String nombre_archivo;
	String idtipodocumento;
	String descripcion;
	String fecha;
	String login;
	String extension;
	int folio;
	int identidad = 0;
	int idorganizacion = 0;
	int idregistro = 0;
	String base64;

	/**
	 * 
	 */
	public AttachmentDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador
	 *            the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	/**
	 * @return the nombre_archivo
	 */
	public String getNombre_archivo() {
		return nombre_archivo;
	}

	/**
	 * @param nombre_archivo
	 *            the nombre_archivo to set
	 */
	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the extension
	 */
	public String getExtension() {
		if (this.nombre_archivo != null && !this.nombre_archivo.isEmpty()) {
			return com.innovargia.utils.MimeTypes.getExtencion(this.nombre_archivo);
		} else {
			return this.extension;
		}
	}

	/**
	 * @param extension
	 *            the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @return the idtipodocumento
	 */
	public String getIdtipodocumento() {
		return idtipodocumento;
	}

	/**
	 * @param idtipodocumento
	 *            the idtipodocumento to set
	 */
	public void setIdtipodocumento(String idtipodocumento) {
		this.idtipodocumento = idtipodocumento;
	}

	/**
	 * @return the identidad
	 */
	public int getIdentidad() {
		return identidad;
	}

	/**
	 * @param identidad
	 *            the identidad to set
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
	 * @param idorganizacion
	 *            the idorganizacion to set
	 */
	public void setIdorganizacion(int idorganizacion) {
		this.idorganizacion = idorganizacion;
	}

	/**
	 * @return the iddocumento
	 */
	public String getIddocumento() {
		return iddocumento;
	}

	/**
	 * @param iddocumento
	 *            the iddocumento to set
	 */
	public void setIddocumento(String iddocumento) {
		this.iddocumento = iddocumento;
	}

	/**
	 * @return the folio
	 */
	public int getFolio() {
		return folio;
	}

	/**
	 * @param folio
	 *            the folio to set
	 */
	public void setFolio(int folio) {
		this.folio = folio;
	}

	public void setFolio(String folio) {
		try {
			this.folio = Integer.parseInt(folio);
		} catch (Exception e) {
			this.folio = -1;
		}

	}

	/**
	 * @return the base64
	 */
	public String getBase64() {
		return base64;
	}

	/**
	 * @param base64
	 *            the base64 to set
	 */
	public void setBase64(String base64) {
		this.base64 = base64;
	}

	/**
	 * @return the idregistro
	 */
	public int getIdregistro() {
		return idregistro;
	}

	/**
	 * @param idregistro
	 *            the idregistro to set
	 */
	public void setIdregistro(int idregistro) {
		this.idregistro = idregistro;
	}

}
