/**
 * 
 */
package com.servicio.dtos;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class Terminal implements java.io.Serializable {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private String  idterminal;
	 private String  c_estado;
	 private String  c_mnpio;
	 private String  reexpedicion_e;
	 private String  reexpedicion_r;
	 private String  rutalocal;
	  
	/**
	 * 
	 */
	public Terminal() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idterminal
	 */
	public String getIdterminal() {
		return idterminal;
	}

	/**
	 * @param idterminal the idterminal to set
	 */
	public void setIdterminal(String idterminal) {
		this.idterminal = idterminal;
	}

	/**
	 * @return the c_estado
	 */
	public String getC_estado() {
		return c_estado;
	}

	/**
	 * @param c_estado the c_estado to set
	 */
	public void setC_estado(String c_estado) {
		this.c_estado = c_estado;
	}

	/**
	 * @return the c_mnpio
	 */
	public String getC_mnpio() {
		return c_mnpio;
	}

	/**
	 * @param c_mnpio the c_mnpio to set
	 */
	public void setC_mnpio(String c_mnpio) {
		this.c_mnpio = c_mnpio;
	}

	/**
	 * @return the reexpedicion_e
	 */
	public String getReexpedicion_e() {
		return reexpedicion_e;
	}

	/**
	 * @param reexpedicion_e the reexpedicion_e to set
	 */
	public void setReexpedicion_e(String reexpedicion_e) {
		this.reexpedicion_e = reexpedicion_e;
	}

	/**
	 * @return the reexpedicion_r
	 */
	public String getReexpedicion_r() {
		return reexpedicion_r;
	}

	/**
	 * @param reexpedicion_r the reexpedicion_r to set
	 */
	public void setReexpedicion_r(String reexpedicion_r) {
		this.reexpedicion_r = reexpedicion_r;
	}

	/**
	 * @return the rutalocal
	 */
	public String getRutalocal() {
		return rutalocal;
	}

	/**
	 * @param rutalocal the rutalocal to set
	 */
	public void setRutalocal(String rutalocal) {
		this.rutalocal = rutalocal;
	}

}
