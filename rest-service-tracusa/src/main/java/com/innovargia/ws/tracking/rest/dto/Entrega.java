package com.innovargia.ws.tracking.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)  //Solo los datos que hayan sido inicializados
public class Entrega implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    String idguia;
    String ruta;
    String fecha;
    String oriReg;
    String plaza;
    String quienRecibe;
    String empleado;
    String latitud;
    String longitud;
    String tipoIdentificacion;
    String numeroIdentificacion;
    
    FirmaFoto firma;
	FirmaFoto evidencia;

    //String idfirma;
    //String imaBase64;   //IMagen en PNG

    public Entrega() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @return the idguia
     */
    public String getIdguia() {
        return idguia;
    }

    /**
     * @param idguia the idguia to set
     */
    public void setIdguia(String idguia) {
        this.idguia = idguia;
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
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the oriReg
     */
    public String getOriReg() {
        return this.oriReg;
    }

    /**
     * @param oriReg the oriReg to set
     */
    public void setOriReg(String oriReg) {
        this.oriReg = oriReg;
    }

    /**
     * @return the plaza
     */
    public String getPlaza() {
        return this.plaza;
    }

    /**
     * @param plaza the plaza to set
     */
    public void setPlaza(String plaza) {
        this.plaza = plaza;
    }

   

    /**
     * @return the empleado
     */
    public String getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the latitud
     */
    public String getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public String getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the tipoIdentificacion
     */
    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    /**
     * @param tipoIdentificacion the tipoIdentificacion to set
     */
    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    /**
     * @return the numeroIdentificacion
     */
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /**
     * @param numeroIdentificacion the numeroIdentificacion to set
     */
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

   
	/**
	 * @return the quienRecibe
	 */
	public String getQuienRecibe() {
		return quienRecibe;
	}

	/**
	 * @param quienRecibe the quienRecibe to set
	 */
	public void setQuienRecibe(String quienRecibe) {
		this.quienRecibe = quienRecibe;
	}

	/**
	 * @return the firma
	 */
	public FirmaFoto getFirma() {
		return firma;
	}

	/**
	 * @param firma the firma to set
	 */
	public void setFirma(FirmaFoto firma) {
		this.firma = firma;
	}

	/**
	 * @return the evidencia
	 */
	public FirmaFoto getEvidencia() {
		return evidencia;
	}

	/**
	 * @param evidencia the evidencia to set
	 */
	public void setEvidencia(FirmaFoto evidencia) {
		this.evidencia = evidencia;
	}

}
