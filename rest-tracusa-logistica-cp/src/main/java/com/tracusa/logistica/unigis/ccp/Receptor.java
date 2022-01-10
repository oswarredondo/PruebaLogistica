package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Receptor {
    private String rfc;
    private String nombre;
    private String usoCFDI;

    @JsonProperty("Rfc")
    public String getRFC() { return rfc; }
    @JsonProperty("Rfc")
    public void setRFC(String value) { this.rfc = value; }

    @JsonProperty("Nombre")
    public String getNombre() { return nombre; }
    @JsonProperty("Nombre")
    public void setNombre(String value) { this.nombre = value; }

    @JsonProperty("UsoCFDI")
    public String getUsoCFDI() { return usoCFDI; }
    @JsonProperty("UsoCFDI")
    public void setUsoCFDI(String value) { this.usoCFDI = value; }
}
