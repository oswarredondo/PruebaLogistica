package com.servicio.consulta.dtos;

import java.io.Serializable;

public class DireccionConsultaEtiquetasExtJS implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String latitud = null;
    private String longitud = null;
    /** Razon Social */
    private String razonSocial;
    /** Contiene la Atención */
    private String atencion;
    /** Contiene la direccion calle y numero */
    private String direccion;
    /** Contiene calle y numero */
    private String calle;

    /** Colonia */
    private String colonia;
    /** Contiene la ciudad */
    private String ciudad;

    /** Contiene el Estado */
    private String estado;
    /** Municipio o Delegarcion */
    private String municipio;
    /** Contiene el Código Postal del Domicilio */
    private String cp;
    /** Contiene el Teléfono */
    private String telefono;

    private String entrecalles;

    /*** Pais */
    private String pais;

    /** Correo Electronico */
    private String correoe;
    private String numcelular;

    public DireccionConsultaEtiquetasExtJS() {
	// TODO Auto-generated constructor stub
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
     * @return the razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * @param razonSocial the razonSocial to set
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * @return the atencion
     */
    public String getAtencion() {
        return atencion;
    }

    /**
     * @param atencion the atencion to set
     */
    public void setAtencion(String atencion) {
        this.atencion = atencion;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia the colonia to set
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the cp
     */
    public String getCp() {
        return cp;
    }

    /**
     * @param cp the cp to set
     */
    public void setCp(String cp) {
        this.cp = cp;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the entrecalles
     */
    public String getEntrecalles() {
        return entrecalles;
    }

    /**
     * @param entrecalles the entrecalles to set
     */
    public void setEntrecalles(String entrecalles) {
        this.entrecalles = entrecalles;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the correoe
     */
    public String getCorreoe() {
        return correoe;
    }

    /**
     * @param correoe the correoe to set
     */
    public void setCorreoe(String correoe) {
        this.correoe = correoe;
    }

    /**
     * @return the numcelular
     */
    public String getNumcelular() {
        return numcelular;
    }

    /**
     * @param numcelular the numcelular to set
     */
    public void setNumcelular(String numcelular) {
        this.numcelular = numcelular;
    }

}
