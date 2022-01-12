/**
 * 
 */
package com.servicio.dtos;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class Ruta implements java.io.Serializable {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	 private String idruta;
	 private String ruta;
	 private String descripcion;
	 private String secuencia;
	 private int  kms ;
	 private String idtramoruta;
	 private Terminal terminalori = new Terminal();
	 private Terminal terminaldes = new Terminal();
	 private int total;
	 private String siglasplaza;
	/**
	 * 
	 */
	public Ruta() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the idruta
	 */
	public String getIdruta() {
		return idruta;
	}
	/**
	 * @param idruta the idruta to set
	 */
	public void setIdruta(String idruta) {
		this.idruta = idruta;
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
	 * @return the secuencia
	 */
	public String getSecuencia() {
		return secuencia;
	}
	/**
	 * @param secuencia the secuencia to set
	 */
	public void setSecuencia(String secuencia) {
		this.secuencia = secuencia;
	}
	/**
	 * @return the kms
	 */
	public int getKms() {
		return kms;
	}
	/**
	 * @param kms the kms to set
	 */
	public void setKms(int kms) {
		this.kms = kms;
	}
	/**
	 * @return the idtramoruta
	 */
	public String getIdtramoruta() {
		return idtramoruta;
	}
	/**
	 * @param idtramoruta the idtramoruta to set
	 */
	public void setIdtramoruta(String idtramoruta) {
		this.idtramoruta = idtramoruta;
	}
	/**
	 * @return the terminalori
	 */
	public Terminal getTerminalori() {
		return terminalori;
	}
	/**
	 * @param terminalori the terminalori to set
	 */
	public void setTerminalori(Terminal terminalori) {
		this.terminalori = terminalori;
	}
	/**
	 * @return the terminaldes
	 */
	public Terminal getTerminaldes() {
		return terminaldes;
	}
	/**
	 * @param terminaldes the terminaldes to set
	 */
	public void setTerminaldes(Terminal terminaldes) {
		this.terminaldes = terminaldes;
	}
	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}
	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
	    return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
	    this.total = total;
	}
	/**
	 * @return the siglasplaza
	 */
	public String getSiglasplaza() {
	    return siglasplaza;
	}
	/**
	 * @param siglasplaza the siglasplaza to set
	 */
	public void setSiglasplaza(String siglasplaza) {
	    this.siglasplaza = siglasplaza;
	}

}
