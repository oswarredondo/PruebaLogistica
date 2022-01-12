/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author aruaro
 *
 */
public class ModalidadDescuentoDTO {
	
	int iddescuento   ;      
	int identificador; //se refiere al identificador del registro
	String nombre         ; //Puede ser nombre de la modalidad, tarifa, cliente, etc
	
	
	public int getIddescuento() {
		return iddescuento;
	}
	public void setIddescuento(int iddescuento) {
		this.iddescuento = iddescuento;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
