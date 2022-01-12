/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author aruaro
 *
 */
public class NivelUsuarioDTO {
	int identificador ;
	int idnivelusuario ;
	String descripcion ;
	int visiblesiempre ;
	float maxdescadicional ;
	float maxdesctarifas;
	int idagrupamiento ;

	/**
	 * 
	 */
	public NivelUsuarioDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idnivelusuario
	 */
	public int getIdnivelusuario() {
		return idnivelusuario;
	}

	/**
	 * @param idnivelusuario the idnivelusuario to set
	 */
	public void setIdnivelusuario(int idnivelusuario) {
		this.idnivelusuario = idnivelusuario;
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
	 * @return the visiblesiempre
	 */
	public int getVisiblesiempre() {
		return visiblesiempre;
	}

	/**
	 * @param visiblesiempre the visiblesiempre to set
	 */
	public void setVisiblesiempre(int visiblesiempre) {
		this.visiblesiempre = visiblesiempre;
	}

	/**
	 * @return the maxdescadicional
	 */
	public float getMaxdescadicional() {
		return maxdescadicional;
	}

	/**
	 * @param maxdescadicional the maxdescadicional to set
	 */
	public void setMaxdescadicional(float maxdescadicional) {
		this.maxdescadicional = maxdescadicional;
	}

	/**
	 * @return the maxdesctarifas
	 */
	public float getMaxdesctarifas() {
		return maxdesctarifas;
	}

	/**
	 * @param maxdesctarifas the maxdesctarifas to set
	 */
	public void setMaxdesctarifas(float maxdesctarifas) {
		this.maxdesctarifas = maxdesctarifas;
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
	
	public void setIdagrupamiento(String idagrupamiento) {
		try{
			this.idagrupamiento = Integer.parseInt(idagrupamiento);
		}catch(Exception e){
			this.idagrupamiento=-1;
		}
		
	}

}
