package com.innovargia.ws.tracking.rest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Movimiento implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    String tipoMovimiento;
    String idguia;
    String ruta;
    String fecha;
    String oriReg;
    String plaza;
    String empleado;
    String latitud;
    String longitud;
    String cveLog;
    String guiaCasamiento;
    String tipo;
    String idclavelog;
   

    public Movimiento() {
	// TODO Auto-generated constructor stub
    }



    /**
     * @return the tipoMovimiento
     */
    public String getTipoMovimiento() {
        return tipoMovimiento;
    }



    /**
     * @param tipoMovimiento the tipoMovimiento to set
     */
    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
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
        return oriReg;
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
        return plaza;
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
     * @return the cveLog
     */
    public String getCveLog() {
        return cveLog;
    }



    /**
     * @param cveLog the cveLog to set
     */
    public void setCveLog(String cveLog) {
        this.cveLog = cveLog;
    }



    /**
     * @return the guiaCasamiento
     */
    public String getGuiaCasamiento() {
        return guiaCasamiento;
    }



    /**
     * @param guiaCasamiento the guiaCasamiento to set
     */
    public void setGuiaCasamiento(String guiaCasamiento) {
        this.guiaCasamiento = guiaCasamiento;
    }



	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}



	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	/**
	 * @return the idclavelog
	 */
	public String getIdclavelog() {
		return idclavelog;
	}



	/**
	 * @param idclavelog the idclavelog to set
	 */
	public void setIdclavelog(String idclavelog) {
		this.idclavelog = idclavelog;
	}

}
