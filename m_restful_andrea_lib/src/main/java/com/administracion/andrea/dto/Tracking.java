/**
 * 
 */
package com.administracion.andrea.dto;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class Tracking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	    protected String guiaEmbarque;
	    protected String fechaMovimiento;
	    protected String estatusGuia;
	    protected String ubicacion;
	    protected String personaRecibio;
	    protected String tipoIdentificacion;
	    protected String identificacionID;
	    protected String observaciones;
		public String getGuiaEmbarque() {
			return guiaEmbarque;
		}
		public void setGuiaEmbarque(String guiaEmbarque) {
			this.guiaEmbarque = guiaEmbarque;
		}
		public String getFechaMovimiento() {
			return fechaMovimiento;
		}
		public void setFechaMovimiento(String fechaMovimiento) {
			this.fechaMovimiento = fechaMovimiento;
		}
		public String getEstatusGuia() {
			return estatusGuia;
		}
		public void setEstatusGuia(String estatusGuia) {
			this.estatusGuia = estatusGuia;
		}
		public String getUbicacion() {
			return ubicacion;
		}
		public void setUbicacion(String ubicacion) {
			this.ubicacion = ubicacion;
		}
		public String getPersonaRecibio() {
			return personaRecibio;
		}
		public void setPersonaRecibio(String personaRecibio) {
			this.personaRecibio = personaRecibio;
		}
		public String getTipoIdentificacion() {
			return tipoIdentificacion;
		}
		public void setTipoIdentificacion(String tipoIdentificacion) {
			this.tipoIdentificacion = tipoIdentificacion;
		}
		public String getIdentificacionID() {
			return identificacionID;
		}
		public void setIdentificacionID(String identificacionID) {
			this.identificacionID = identificacionID;
		}
		public String getObservaciones() {
			return observaciones;
		}
		public void setObservaciones(String observaciones) {
			this.observaciones = observaciones;
		}

}
