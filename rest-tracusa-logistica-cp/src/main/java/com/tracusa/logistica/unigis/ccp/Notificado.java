package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Notificado {
    private Domicilio domicilio;
    private String rfcNotificado;
    private String numLicencia;
    private String nombreNotificado;
    private String numRegIDTribNotificado;
    private String residenciaFiscalNotificado;

    @JsonProperty("Domicilio")
    public Domicilio getDomicilio() { return domicilio; }
    @JsonProperty("Domicilio")
    public void setDomicilio(Domicilio value) { this.domicilio = value; }

    @JsonProperty("RFCNotificado")
    public String getRFCNotificado() { return rfcNotificado; }
    @JsonProperty("RFCNotificado")
    public void setRFCNotificado(String value) { this.rfcNotificado = value; }

    @JsonProperty("NumLicencia")
    public String getNumLicencia() { return numLicencia; }
    @JsonProperty("NumLicencia")
    public void setNumLicencia(String value) { this.numLicencia = value; }

    @JsonProperty("NombreNotificado")
    public String getNombreNotificado() { return nombreNotificado; }
    @JsonProperty("NombreNotificado")
    public void setNombreNotificado(String value) { this.nombreNotificado = value; }

    @JsonProperty("NumRegIdTribNotificado")
    public String getNumRegIDTribNotificado() { return numRegIDTribNotificado; }
    @JsonProperty("NumRegIdTribNotificado")
    public void setNumRegIDTribNotificado(String value) { this.numRegIDTribNotificado = value; }

    @JsonProperty("ResidenciaFiscalNotificado")
    public String getResidenciaFiscalNotificado() { return residenciaFiscalNotificado; }
    @JsonProperty("ResidenciaFiscalNotificado")
    public void setResidenciaFiscalNotificado(String value) { this.residenciaFiscalNotificado = value; }
}
