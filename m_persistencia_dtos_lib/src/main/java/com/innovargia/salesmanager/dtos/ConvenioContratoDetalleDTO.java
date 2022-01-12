/**
 * 
 */
package com.innovargia.salesmanager.dtos;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class ConvenioContratoDetalleDTO implements Serializable {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int idconveniodetalle ;
	  int idconvenio;
	  int idtarifa;
	  int idtarifapeso;
	  int idrangoenvios;
	  int idserviciotarifazona;
	  String comentario;
	  String siglasori;
	  String siglasdes;
	  String cporigen;
	  String cpdestino;
	  float peso;
	  float sobrepeso;
	  float largo;
	  float alto;
	  float ancho;
	  float coberturakm;
	  float precio;
	  float preciosobrepeso;
	  float descuento;
	  float volumen;
	  float pesobase;
	  float precio_real;
	
	/**
	 * 
	 */
	public ConvenioContratoDetalleDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idconveniodetalle
	 */
	public int getIdconveniodetalle() {
		return idconveniodetalle;
	}

	/**
	 * @param idconveniodetalle the idconveniodetalle to set
	 */
	public void setIdconveniodetalle(int idconveniodetalle) {
		this.idconveniodetalle = idconveniodetalle;
	}
	
	/**
	 * @param idconveniodetalle the idconveniodetalle to set
	 */
	public void setIdconveniodetalle(String idconveniodetalle) {
		try{
			this.idconveniodetalle = Integer.parseInt(idconveniodetalle);
		}catch(Exception e){
			
		}
		
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
			
		}
		
	}

	/**
	 * @return the siglasori
	 */
	public String getSiglasori() {
		return siglasori;
	}

	/**
	 * @param siglasori the siglasori to set
	 */
	public void setSiglasori(String siglasori) {
		this.siglasori = siglasori;
	}

	/**
	 * @return the siglasdes
	 */
	public String getSiglasdes() {
		return siglasdes;
	}

	/**
	 * @param siglasdes the siglasdes to set
	 */
	public void setSiglasdes(String siglasdes) {
		this.siglasdes = siglasdes;
	}

	/**
	 * @return the peso
	 */
	public float getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	/**
	 * @param idconpesovenio the peso to set
	 */
	public void setPeso(String peso) {
		try{
			this.peso = Float.parseFloat(peso);
		}catch(Exception e){
			
		}
		
	}

	/**
	 * @return the largo
	 */
	public float getLargo() {
		return largo;
	}

	/**
	 * @param largo the largo to set
	 */
	public void setLargo(float largo) {
		this.largo = largo;
	}
	
	/**
	 * @param largo the largo to set
	 */
	public void setLargo(String largo) {
		try{
			this.largo = Float.parseFloat(largo);
		}catch(Exception e){
			
		}
		
	}

	/**
	 * @return the alto
	 */
	public float getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(float alto) {
		this.alto = alto;
	}
	
	/**
	 * @param alto the alto to set
	 */
	public void setAlto(String alto) {
		try{
			this.alto = Float.parseFloat(alto);
		}catch(Exception e){
			
		}
		
	}

	/**
	 * @return the ancho
	 */
	public float getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}
	
	/**
	 * @return the sobrepeso
	 */
	public float getSobrepeso() {
		return sobrepeso;
	}

	/**
	 * @param sobrepeso the sobrepeso to set
	 */
	public void setSobrepeso(float sobrepeso) {
		this.sobrepeso = sobrepeso;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(String ancho) {
		try{
			this.ancho = Float.parseFloat(ancho);
		}catch(Exception e){
			
		}
		
	}

	/**
	 * @return the coberturakm
	 */
	public float getCoberturakm() {
		return coberturakm;
	}

	/**
	 * @param coberturakm the coberturakm to set
	 */
	public void setCoberturakm(float coberturakm) {
		this.coberturakm = coberturakm;
	}
	
	/**
	 * @param coberturakm the coberturakm to set
	 */
	public void setCoberturakm(String coberturakm) {
		try{
			this.coberturakm = Float.parseFloat(coberturakm);
		}catch(Exception e){
			
		}
		
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
	 * @param precio the precio to set
	 */
	public void setPrecio(String precio) {
		try{
			this.precio = Float.parseFloat(precio);
		}catch(Exception e){
			
		}
		
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
	 * @param descuento the descuento to set
	 */
	public void setDescuento(String descuento) {
		try{
			this.descuento = Float.parseFloat(descuento);
		}catch(Exception e){
			
		}
		
	}

	/**
	 * @return the cporigen
	 */
	public String getCporigen() {
		return cporigen;
	}

	/**
	 * @param cporigen the cporigen to set
	 */
	public void setCporigen(String cporigen) {
		this.cporigen = cporigen;
	}

	/**
	 * @return the cpdestino
	 */
	public String getCpdestino() {
		return cpdestino;
	}

	/**
	 * @param cpdestino the cpdestino to set
	 */
	public void setCpdestino(String cpdestino) {
		this.cpdestino = cpdestino;
	}

	/**
	 * @return the volumen
	 */
	public float getVolumen() {
		return volumen;
	}

	/**
	 * @param volumen the volumen to set
	 */
	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return the preciosobrepeso
	 */
	public float getPreciosobrepeso() {
		return preciosobrepeso;
	}

	/**
	 * @param preciosobrepeso the preciosobrepeso to set
	 */
	public void setPreciosobrepeso(float preciosobrepeso) {
		this.preciosobrepeso = preciosobrepeso;
	}

	/**
	 * @return the pesobase
	 */
	public float getPesobase() {
		return pesobase;
	}

	/**
	 * @param pesobase the pesobase to set
	 */
	public void setPesobase(float pesobase) {
		this.pesobase = pesobase;
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
	 * @return the idtarifapeso
	 */
	public int getIdtarifapeso() {
	    return idtarifapeso;
	}

	/**
	 * @param idtarifapeso the idtarifapeso to set
	 */
	public void setIdtarifapeso(int idtarifapeso) {
	    this.idtarifapeso = idtarifapeso;
	}

	/**
	 * @return the idrangoenvios
	 */
	public int getIdrangoenvios() {
	    return idrangoenvios;
	}

	/**
	 * @param idrangoenvios the idrangoenvios to set
	 */
	public void setIdrangoenvios(int idrangoenvios) {
	    this.idrangoenvios = idrangoenvios;
	}

	/**
	 * @return the iddserviciotarifazona
	 */
	public int getIdserviciotarifazona() {
	    return idserviciotarifazona;
	}

	/**
	 * @param iddserviciotarifazona the iddserviciotarifazona to set
	 */
	public void setIdserviciotarifazona(int iddserviciotarifazona) {
	    this.idserviciotarifazona = iddserviciotarifazona;
	}

	/**
	 * @return the precio_real
	 */
	public float getPrecio_real() {
	    return precio_real;
	}

	/**
	 * @param precio_real the precio_real to set
	 */
	public void setPrecio_real(float precio_real) {
	    this.precio_real = precio_real;
	}

}
