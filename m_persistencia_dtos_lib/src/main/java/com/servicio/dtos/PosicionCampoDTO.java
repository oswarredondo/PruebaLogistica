/**
 * 
 */
package com.servicio.dtos;

/**
 * @author aruaro
 *
 */
public class PosicionCampoDTO {

	int inicio=0;
	int fin=-1;
	String campo="";
	public PosicionCampoDTO(int inicio,int fin,String campo){
		this.inicio = inicio;
		this.fin = fin;
		this.campo=campo;
	}
	/**
	 * @return the inicio
	 */
	public synchronized int getInicio() {
		return inicio;
	}
	/**
	 * @param inicio the inicio to set
	 */
	public synchronized void setInicio(int inicio) {
		this.inicio = inicio;
	}
	/**
	 * @return the fin
	 */
	public synchronized int getFin() {
		return fin;
	}
	/**
	 * @param fin the fin to set
	 */
	public synchronized void setFin(int fin) {
		this.fin = fin;
	}
	/**
	 * @return the campo
	 */
	public synchronized String getCampo() {
		return campo;
	}
	/**
	 * @param campo the campo to set
	 */
	public synchronized void setCampo(String campo) {
		this.campo = campo;
	}
	
}
