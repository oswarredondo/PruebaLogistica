/**
 * 
 */
package com.innovargia.salesmanager.dtos;

import java.io.Serializable;

/**
 * @author aruaro
 * 
 */
public class UsuarioCuentaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int identidad;
	private int consecutivo;
	private int idorganizacion;
	private int wallpaperstretch;
	private int nivelpuesto;
	private int visibilidad=0;

	private String numcliente;
	private String idperfil;
	private String nombre;
	private String login;
	private String password;
	private String logo;
	private String estatus;
	private String idoficina;
	private String numempleado;
	private String siglasplaza;
	private String formatoetimedia;
	private String formatoetiperso;
	private int idagrupamiento;

	private String email;

	private String wallpaper;

	public int getIdentidad() {
		return identidad;
	}

	public void setIdentidad(int identidad) {
		this.identidad = identidad;
	}

	public int getIdorganizacion() {
		return idorganizacion;
	}

	public void setIdorganizacion(int idorganizacion) {
		this.idorganizacion = idorganizacion;
	}

	public int getWallpaperstretch() {
		return wallpaperstretch;
	}

	public void setWallpaperstretch(int wallpaperstretch) {
		this.wallpaperstretch = wallpaperstretch;
	}

	public int getNivelpuesto() {
		return nivelpuesto;
	}

	public void setNivelpuesto(int nivelpuesto) {
		this.nivelpuesto = nivelpuesto;
	}

	public String getNumcliente() {
		return numcliente;
	}

	public void setNumcliente(String numcliente) {
		this.numcliente = numcliente;
	}

	public String getIdperfil() {
		return idperfil;
	}

	public void setIdperfil(String idperfil) {
		this.idperfil = idperfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getIdoficina() {
		return idoficina;
	}

	public void setIdoficina(String idoficina) {
		this.idoficina = idoficina;
	}

	public String getNumempleado() {
		return numempleado;
	}

	public void setNumempleado(String numempleado) {
		this.numempleado = numempleado;
	}

	public String getSiglasplaza() {
		return siglasplaza;
	}

	public void setSiglasplaza(String siglasplaza) {
		this.siglasplaza = siglasplaza;
	}

	public String getFormatoetimedia() {
		return formatoetimedia;
	}

	public void setFormatoetimedia(String formatoetimedia) {
		this.formatoetimedia = formatoetimedia;
	}

	public String getFormatoetiperso() {
		return formatoetiperso;
	}

	public void setFormatoetiperso(String formatoetiperso) {
		this.formatoetiperso = formatoetiperso;
	}

	public String getWallpaper() {
		return wallpaper;
	}

	public void setWallpaper(String wallpaper) {
		this.wallpaper = wallpaper;
	}

	public int getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}

	public void setConsecutivo(String consecutivo) {
		try {
			this.consecutivo = Integer.parseInt(consecutivo);
		} catch (Exception e) {

		}

	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the idagrupamiento
	 */
	public int getIdagrupamiento() {
		return idagrupamiento;
	}

	/**
	 * @param idagrupamiento
	 *            the idagrupamiento to set
	 */
	public void setIdagrupamiento(int idagrupamiento) {
		this.idagrupamiento = idagrupamiento;
	}

	public void setIdagrupamiento(String idagrupamiento) {
		try {
			this.idagrupamiento = Integer.parseInt(idagrupamiento);
		} catch (Exception e) {

		}
	}

	/**
	 * @return the visibilidad
	 */
	public int getVisibilidad() {
		return visibilidad;
	}

	/**
	 * @param visibilidad
	 *            the visibilidad to set
	 */
	public void setVisibilidad(int visibilidad) {
		this.visibilidad = visibilidad;
	}

	public void setVisibilidad(String visibilidad) {
		try {
			this.visibilidad = Integer.parseInt(visibilidad);
		} catch (Exception e) {

		}

	}

}
