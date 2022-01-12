/**
 * 
 */
package com.innovargia.salesmanager.dtos;


/**
 * @author aruaro
 *
 */
public class AgrupamientoDTO {
	int identificador;
	int idagrupamiento;
	String  descripcion ;
	int  visualizatodo=1 ;
	String idrelacion; //indica el identificador con el que selaciona, puede ser un id de usuario, cliente, etc.

	String jefezona;
	String dirfinanzas;
	String creditocobranza;
	String gerentecomercial;
	
	/**
	 * 
	 */
	public AgrupamientoDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idagrupamiento
	 */
	public int getIdagrupamiento() {
		return idagrupamiento;
	}

	/**
	 * @param idagrupamiento the idagrupamiento to set
	 */
	public void setIdagrupamiento(int idagrupamiento) {
		this.idagrupamiento = idagrupamiento;
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
	 * @return the visualizatodo
	 */
	public int getVisualizatodo() {
		return visualizatodo;
	}

	/**
	 * @param visualizatodo the visualizatodo to set
	 */
	public void setVisualizatodo(int visualizatodo) {
		this.visualizatodo = visualizatodo;
	}

	/**
	 * @return the idrelacion
	 */
	public String getIdrelacion() {
		return idrelacion;
	}

	/**
	 * @param idrelacion the idrelacion to set
	 */
	public void setIdrelacion(String idrelacion) {
		this.idrelacion = idrelacion;
	}

	/**
	 * @return the jefezona
	 */
	public String getJefezona() {
		return jefezona;
	}

	/**
	 * @param jefezona the jefezona to set
	 */
	public void setJefezona(String jefezona) {
		this.jefezona = jefezona;
	}

	/**
	 * @return the dirfinanzas
	 */
	public String getDirfinanzas() {
		return dirfinanzas;
	}

	/**
	 * @param dirfinanzas the dirfinanzas to set
	 */
	public void setDirfinanzas(String dirfinanzas) {
		this.dirfinanzas = dirfinanzas;
	}

	/**
	 * @return the creditocobranza
	 */
	public String getCreditocobranza() {
		return creditocobranza;
	}

	/**
	 * @param creditocobranza the creditocobranza to set
	 */
	public void setCreditocobranza(String creditocobranza) {
		this.creditocobranza = creditocobranza;
	}

	/**
	 * @return the gerentecomercial
	 */
	public String getGerentecomercial() {
		return gerentecomercial;
	}

	/**
	 * @param gerentecomercial the gerentecomercial to set
	 */
	public void setGerentecomercial(String gerentecomercial) {
		this.gerentecomercial = gerentecomercial;
	}

	/**
	 * @return the identificador
	 */
	public int getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

}
