package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Domicilio {
    private String calle;
    private String numeroExterior;
    private String numeroInterior;
    private String colonia;
    private String localidad;
    private String municipio;
    private String estado;
    private String pais;
    private String codigoPostal;

    @JsonProperty("Calle")
    public String getCalle() { return calle; }
    @JsonProperty("Calle")
    public void setCalle(String value) { this.calle = value; }

    @JsonProperty("NumeroExterior")
    public String getNumeroExterior() { return numeroExterior; }
    @JsonProperty("NumeroExterior")
    public void setNumeroExterior(String value) { this.numeroExterior = value; }

    @JsonProperty("NumeroInterior")
    public String getNumeroInterior() { return numeroInterior; }
    @JsonProperty("NumeroInterior")
    public void setNumeroInterior(String value) { this.numeroInterior = value; }

    @JsonProperty("Colonia")
    public String getColonia() { return colonia; }
    @JsonProperty("Colonia")
    public void setColonia(String value) { this.colonia = value; }

    @JsonProperty("Localidad")
    public String getLocalidad() { return localidad; }
    @JsonProperty("Localidad")
    public void setLocalidad(String value) { this.localidad = value; }

    @JsonProperty("Municipio")
    public String getMunicipio() { return municipio; }
    @JsonProperty("Municipio")
    public void setMunicipio(String value) { this.municipio = value; }

    @JsonProperty("Estado")
    public String getEstado() { return estado; }
    @JsonProperty("Estado")
    public void setEstado(String value) { this.estado = value; }

    @JsonProperty("Pais")
    public String getPais() { return pais; }
    @JsonProperty("Pais")
    public void setPais(String value) { this.pais = value; }

    @JsonProperty("CodigoPostal")
    public String getCodigoPostal() { return codigoPostal; }
    @JsonProperty("CodigoPostal")
    public void setCodigoPostal(String value) { this.codigoPostal = value; }
}
