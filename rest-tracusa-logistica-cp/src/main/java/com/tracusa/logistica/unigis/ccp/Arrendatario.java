package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Arrendatario {
    private Domicilio domicilio;
    private String rfcArrendatario;
    private String numLicencia;
    private String nombreArrendatario;
    private String numRegIDTribArrendatario;
    private String residenciaFiscalArrendatario;

    @JsonProperty("Domicilio")
    public Domicilio getDomicilio() { return domicilio; }
    @JsonProperty("Domicilio")
    public void setDomicilio(Domicilio value) { this.domicilio = value; }

    @JsonProperty("RFCArrendatario")
    public String getRFCArrendatario() { return rfcArrendatario; }
    @JsonProperty("RFCArrendatario")
    public void setRFCArrendatario(String value) { this.rfcArrendatario = value; }

    @JsonProperty("NumLicencia")
    public String getNumLicencia() { return numLicencia; }
    @JsonProperty("NumLicencia")
    public void setNumLicencia(String value) { this.numLicencia = value; }

    @JsonProperty("NombreArrendatario")
    public String getNombreArrendatario() { return nombreArrendatario; }
    @JsonProperty("NombreArrendatario")
    public void setNombreArrendatario(String value) { this.nombreArrendatario = value; }

    @JsonProperty("NumRegIdTribArrendatario")
    public String getNumRegIDTribArrendatario() { return numRegIDTribArrendatario; }
    @JsonProperty("NumRegIdTribArrendatario")
    public void setNumRegIDTribArrendatario(String value) { this.numRegIDTribArrendatario = value; }

    @JsonProperty("ResidenciaFiscalArrendatario")
    public String getResidenciaFiscalArrendatario() { return residenciaFiscalArrendatario; }
    @JsonProperty("ResidenciaFiscalArrendatario")
    public void setResidenciaFiscalArrendatario(String value) { this.residenciaFiscalArrendatario = value; }
}
