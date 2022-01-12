/**
 * 
 */
package com.administracion.dto;

/**
 * @author Adrián
 *
 */
public class DiasSemanaMes {
    	private int idregistro;
	private String idsolicitud;
	private int diasemanames;
	private String observacion;
	/**
	 * 
	 */
	public DiasSemanaMes() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the idsolicitud
	 */
	public String getIdsolicitud() {
		return idsolicitud;
	}
	/**
	 * @param idsolicitud the idsolicitud to set
	 */
	public void setIdsolicitud(String idsolicitud) {
		this.idsolicitud = idsolicitud;
	}
	/**
	 * @return the diasemanames
	 */
	public int getDiasemanames() {
		return diasemanames;
	}
	/**
	 * @param diasemanames the diasemanames to set
	 */
	public void setDiasemanames(int diasemanames) {
		
		this.diasemanames = diasemanames;
	}
	public void setDiasemanames(String diasemanames) {
		try {
			this.diasemanames  = Integer.parseInt(diasemanames);
		} catch (Exception e) {
		}

	}
	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}
	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
