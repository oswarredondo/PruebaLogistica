package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Emisor {
    private String rfc;
    private String nombre;
    private String regimenFiscal;

    @JsonProperty("Rfc")
    public String getRFC() { return rfc; }
    @JsonProperty("Rfc")
    public void setRFC(String value) { this.rfc = value; }

    @JsonProperty("Nombre")
    public String getNombre() { return nombre; }
    @JsonProperty("Nombre")
    public void setNombre(String value) { this.nombre = value; }

    @JsonProperty("RegimenFiscal")
    public String getRegimenFiscal() { return regimenFiscal; }
    @JsonProperty("RegimenFiscal")
    public void setRegimenFiscal(String value) { this.regimenFiscal = value; }
}
