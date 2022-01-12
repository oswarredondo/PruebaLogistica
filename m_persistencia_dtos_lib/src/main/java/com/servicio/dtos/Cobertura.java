/**
 * 
 */
package com.servicio.dtos;


/**
 * Exttiende la funcionalidad de Zona para aplicarlos en Cobertura
 * @author Adrian Morales Ruaro
 *
 */
public class Cobertura  extends Zona{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Terminal terminalOrigen = new Terminal(); 
	private Terminal terminalDestino = new Terminal(); 
	private String enrutamiento;
	
	 
	/**
	 * 
	 */
	public Cobertura() {
		// TODO Auto-generated constructor stub
	}
	public Terminal getTerminalDestino() {
		return terminalDestino;
	}
	
	public Terminal getTerminalOrigen() {
		return terminalOrigen;
	}
	public void setTerminalDestino(Terminal terminalDestino) {
		this.terminalDestino = terminalDestino;
	}
	public void setTerminalOrigen(Terminal terminalOrigen) {
		this.terminalOrigen = terminalOrigen;
	}
	/**
	 * @return the enrutamiento
	 */
	public String getEnrutamiento() {
		return enrutamiento;
	}
	/**
	 * @param enrutamiento the enrutamiento to set
	 */
	public void setEnrutamiento(String enrutamiento) {
		this.enrutamiento = enrutamiento;
		
	}

	
}
