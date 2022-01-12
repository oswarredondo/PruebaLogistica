/**
 * 
 */
package com.innovargia.ws.tracking.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author aruaro
 *
 */
@JsonInclude(Include.NON_DEFAULT)  //Solo los datos que hayan sido inicializados
public class ConsultarTrackingRequest {
	
/*	Tipo Consulta
		|->1= X Guia
		|->2= X Referencia
	|->Usuario
	|->Password
	|->Cliente
	|->Guias/Referencias[] (hasta 20)
	  |->Dato
	  |->....  */

     int tipo =1;
     String usuario;
     String password;
     String cliente;
     String guias;
     String referencia;
     String[] arr_guias;
     
     String fechainicial;
     String fechafinal;
     String guiacasamiento;
     boolean obtenerHistoria=false;
     boolean muestrarTodalaHistoria=false; //true: busca toda la historia, false: regresa solo el ultimo movimiento
     boolean buscaFirma=false;
     
     private	int tipobusqueda=1;//1=referencia, 2=guiacasamiento, 3=rango fechas, 4=Guias
 	 private int infosolicitada=1; //0=Incluir Firma y evicencia,1=AIncluir Historia, 2=Incluir 
     
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getGuias() {
		return guias;
	}
	public void setGuias(String guias) {
		this.guias = guias;
	}
	/**
	 * @return the tipobusqueda
	 */
	public int getTipobusqueda() {
		return tipobusqueda;
	}
	/**
	 * @param tipobusqueda the tipobusqueda to set
	 */
	public void setTipobusqueda(int tipobusqueda) {
		this.tipobusqueda = tipobusqueda;
	}
	/**
	 * @return the infosolicitada
	 */
	public int getInfosolicitada() {
		return infosolicitada;
	}
	/**
	 * @param infosolicitada the infosolicitada to set
	 */
	public void setInfosolicitada(int infosolicitada) {
		this.infosolicitada = infosolicitada;
	}
	/**
	 * @return the arr_guias
	 */
	public String[] getArr_guias() {
		return arr_guias;
	}
	/**
	 * @param arr_guias the arr_guias to set
	 */
	public void setArr_guias(String[] arr_guias) {
		this.arr_guias = arr_guias;
	}
	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}
	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	/**
	 * @return the fechainicial
	 */
	public String getFechainicial() {
		return fechainicial;
	}
	/**
	 * @param fechainicial the fechainicial to set
	 */
	public void setFechainicial(String fechainicial) {
		this.fechainicial = fechainicial;
	}
	/**
	 * @return the fechafinal
	 */
	public String getFechafinal() {
		return fechafinal;
	}
	/**
	 * @param fechafinal the fechafinal to set
	 */
	public void setFechafinal(String fechafinal) {
		this.fechafinal = fechafinal;
	}
	/**
	 * @return the guiacasamiento
	 */
	public String getGuiacasamiento() {
		return guiacasamiento;
	}
	/**
	 * @param guiacasamiento the guiacasamiento to set
	 */
	public void setGuiacasamiento(String guiacasamiento) {
		this.guiacasamiento = guiacasamiento;
	}
	/**
	 * @return the mustrarTodalaHistoria
	 */
	public boolean isMuestrarTodalaHistoria() {
		return muestrarTodalaHistoria;
	}
	/**
	 * @param mustrarTodalaHistoria the mustrarTodalaHistoria to set
	 */
	public void setMuestrarTodalaHistoria(boolean muestrarTodalaHistoria) {
		this.muestrarTodalaHistoria = muestrarTodalaHistoria;
	}
	/**
	 * @return the buscaFirma
	 */
	public boolean isBuscaFirma() {
		return buscaFirma;
	}
	/**
	 * @param buscaFirma the buscaFirma to set
	 */
	public void setBuscaFirma(boolean buscaFirma) {
		this.buscaFirma = buscaFirma;
	}
	/**
	 * @return the obtenerHistoria
	 */
	public boolean isObtenerHistoria() {
		return obtenerHistoria;
	}
	/**
	 * @param obtenerHistoria the obtenerHistoria to set
	 */
	public void setObtenerHistoria(boolean obtenerHistoria) {
		this.obtenerHistoria = obtenerHistoria;
	}
     
     

}
