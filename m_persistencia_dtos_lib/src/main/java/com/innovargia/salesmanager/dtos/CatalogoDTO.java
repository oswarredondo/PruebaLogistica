/**
 * 
 */
package com.innovargia.salesmanager.dtos;

import java.io.Serializable;

/**
 * Propiedades de un catalogo formas de pago, metodo de pago, GrupoCliente
 * etc
 * @author aruaro
 *
 */
public class CatalogoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int identificador;
	String clave;
	String nombre;
	String descripcion;
	int estatus;
	String tipo;  //Puede tener el valor de 0, 1, A, C, etc. dependiendo del catalogo
	float precio;
	String imputable; //Indica a quien es imputable la clave al C=Cliente, 
	int tipoincremento; //0:disminuir aumentar, 1= aumentar, 2=disminuir
	
	int idtipo ;  //Para tipo de pago de caja
	int tipomovimiento;
	int cantidad;
	  
	/**
	 * 
	 */
	public CatalogoDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	public void setIdentificador(String identificador) {
		try{
			this.identificador = Integer.parseInt(identificador);
		}catch(Exception e){
			this.identificador=-1;
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the imputable
	 */
	public String getImputable() {
		return imputable;
	}

	/**
	 * @param imputable the imputable to set
	 */
	public void setImputable(String imputable) {
		this.imputable = imputable;
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

	/**
	 * @return the idtipo
	 */
	public int getIdtipo() {
	    return idtipo;
	}

	/**
	 * @param idtipo the idtipo to set
	 */
	public void setIdtipo(int idtipo) {
	    this.idtipo = idtipo;
	}

	/**
	 * @return the tipomovimiento
	 */
	public int getTipomovimiento() {
	    return tipomovimiento;
	}

	/**
	 * @param tipomovimiento the tipomovimiento to set
	 */
	public void setTipomovimiento(int tipomovimiento) {
	    this.tipomovimiento = tipomovimiento;
	}

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
	    return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
	    this.cantidad = cantidad;
	}

}
