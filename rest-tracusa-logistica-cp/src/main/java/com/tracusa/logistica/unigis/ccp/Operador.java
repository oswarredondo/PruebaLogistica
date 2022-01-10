package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Operador {
    private Domicilio domicilio;
    private String rfcOperador;
    private String numLicencia;
    private String nombreOperador;
    private String numRegIDTribOperador;
    private String residenciaFiscalOperador;

    @JsonProperty("Domicilio")
    public Domicilio getDomicilio() { return domicilio; }
    @JsonProperty("Domicilio")
    public void setDomicilio(Domicilio value) { this.domicilio = value; }

    @JsonProperty("RFCOperador")
    public String getRFCOperador() { return rfcOperador; }
    @JsonProperty("RFCOperador")
    public void setRFCOperador(String value) { this.rfcOperador = value; }

    @JsonProperty("NumLicencia")
    public String getNumLicencia() { return numLicencia; }
    @JsonProperty("NumLicencia")
    public void setNumLicencia(String value) { this.numLicencia = value; }

    @JsonProperty("NombreOperador")
    public String getNombreOperador() { return nombreOperador; }
    @JsonProperty("NombreOperador")
    public void setNombreOperador(String value) { this.nombreOperador = value; }

    @JsonProperty("NumRegIdTribOperador")
    public String getNumRegIDTribOperador() { return numRegIDTribOperador; }
    @JsonProperty("NumRegIdTribOperador")
    public void setNumRegIDTribOperador(String value) { this.numRegIDTribOperador = value; }

    @JsonProperty("ResidenciaFiscalOperador")
    public String getResidenciaFiscalOperador() { return residenciaFiscalOperador; }
    @JsonProperty("ResidenciaFiscalOperador")
    public void setResidenciaFiscalOperador(String value) { this.residenciaFiscalOperador = value; }
}
