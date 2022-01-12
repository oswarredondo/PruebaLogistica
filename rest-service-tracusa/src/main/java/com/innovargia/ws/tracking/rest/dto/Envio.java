/**
 * 
 */
package com.innovargia.ws.tracking.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author aruaro
 *
 */
@JsonInclude(Include.NON_DEFAULT)  //Solo los datos que hayan sido inicializados
public class Envio {
    String idguia;

    String estatus;
    DatosEnvio datosEnvio;
	Entrega entrega;
	
	List<Movimiento> movimientos;
	
	/**
	 * @return the idguia
	 */
	public String getIdguia() {
		return idguia;
	}
	/**
	 * @param idguia the idguia to set
	 */
	public void setIdguia(String idguia) {
		this.idguia = idguia;
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
	/**
	 * @return the entrega
	 */
	public Entrega getEntrega() {
		return entrega;
	}
	/**
	 * @param entrega the entrega to set
	 */
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	/**
	 * @return the movimientos
	 */
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}
	/**
	 * @param movimientos the movimientos to set
	 */
	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	/**
	 * @return the datosEnvio
	 */
	public DatosEnvio getDatosEnvio() {
		return datosEnvio;
	}
	/**
	 * @param datosEnvio the datosEnvio to set
	 */
	public void setDatosEnvio(DatosEnvio datosEnvio) {
		this.datosEnvio = datosEnvio;
	}
}
