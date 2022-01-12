/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author aruaro
 *
 */
public class TarifaAdicionalDTO {
	int idtarifa;
	int idconvenio;
	int idadicionaldetalle;
	int idadicional;
	float descuento ;
	float precio ;
	int estatus;
	String descripcion;
	String claveadicional;
	int tipoincremento;
	
	/**
	 * 
	 */
	public TarifaAdicionalDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the idtarifa
	 */
	public int getIdtarifa() {
		return idtarifa;
	}
	/**
	 * @param idtarifa the idtarifa to set
	 */
	public void setIdtarifa(int idtarifa) {
		this.idtarifa = idtarifa;
	}
	
	/**
	 * @param idtarifa the idtarifa to set
	 */
	public void setIdtarifa(String idtarifa) {
		try{
			this.idtarifa = Integer.parseInt(idtarifa);	
		}catch(Exception e){
			this.idtarifa=-1;
		}
		
	}
	
	/**
	 * @return the idadicionaldetalle
	 */
	public int getIdadicionaldetalle() {
		return idadicionaldetalle;
	}
	/**
	 * @param idadicionaldetalle the idadicionaldetalle to set
	 */
	public void setIdadicionaldetalle(int idadicionaldetalle) {
		this.idadicionaldetalle = idadicionaldetalle;
	}
	/**
	 * @return the idadicional
	 */
	public int getIdadicional() {
		return idadicional;
	}
	/**
	 * @param idadicional the idadicional to set
	 */
	public void setIdadicional(int idadicional) {
		this.idadicional = idadicional;
	}
	/**
	 * @return the descuento
	 */
	public float getDescuento() {
		return descuento;
	}
	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	/**
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
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
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		
		try{
			this.estatus = Integer.parseInt(estatus);
		}catch(Exception e){
			
		}
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
	 * @return the claveadicional
	 */
	public String getClaveadicional() {
		return claveadicional;
	}
	/**
	 * @param claveadicional the claveadicional to set
	 */
	public void setClaveadicional(String claveadicional) {
		this.claveadicional = claveadicional;
	}
	/**
	 * @return the idconvenio
	 */
	public int getIdconvenio() {
		return idconvenio;
	}
	/**
	 * @param idconvenio the idconvenio to set
	 */
	public void setIdconvenio(int idconvenio) {
		this.idconvenio = idconvenio;
	}
	
	/**
	 * @param idconvenio the idconvenio to set
	 */
	public void setIdconvenio(String idconvenio) {
		try{
			this.idconvenio = Integer.parseInt(idconvenio);	
		}catch(Exception e){
			this.idconvenio=-1;
		}
		
	}
	/**
	 * @return the tipoincremento
	 */
	public int getTipoincremento() {
		return tipoincremento;
	}
	/**
	 * @param tipoincremento the tipoincremento to set
	 */
	public void setTipoincremento(int tipoincremento) {
		this.tipoincremento = tipoincremento;
	}

}
