package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Propietario {
    private Domicilio domicilio;
    private String rfcPropietario;
    private String numLicencia;
    private String nombrePropietario;
    private String numRegIDTribPropietario;
    private String residenciaFiscalPropietario;

    @JsonProperty("Domicilio")
    public Domicilio getDomicilio() { return domicilio; }
    @JsonProperty("Domicilio")
    public void setDomicilio(Domicilio value) { this.domicilio = value; }

    @JsonProperty("RFCPropietario")
    public String getRFCPropietario() { return rfcPropietario; }
    @JsonProperty("RFCPropietario")
    public void setRFCPropietario(String value) { this.rfcPropietario = value; }

    @JsonProperty("NumLicencia")
    public String getNumLicencia() { return numLicencia; }
    @JsonProperty("NumLicencia")
    public void setNumLicencia(String value) { this.numLicencia = value; }

    @JsonProperty("NombrePropietario")
    public String getNombrePropietario() { return nombrePropietario; }
    @JsonProperty("NombrePropietario")
    public void setNombrePropietario(String value) { this.nombrePropietario = value; }

    @JsonProperty("NumRegIdTribPropietario")
    public String getNumRegIDTribPropietario() { return numRegIDTribPropietario; }
    @JsonProperty("NumRegIdTribPropietario")
    public void setNumRegIDTribPropietario(String value) { this.numRegIDTribPropietario = value; }

    @JsonProperty("ResidenciaFiscalPropietario")
    public String getResidenciaFiscalPropietario() { return residenciaFiscalPropietario; }
    @JsonProperty("ResidenciaFiscalPropietario")
    public void setResidenciaFiscalPropietario(String value) { this.residenciaFiscalPropietario = value; }
}
