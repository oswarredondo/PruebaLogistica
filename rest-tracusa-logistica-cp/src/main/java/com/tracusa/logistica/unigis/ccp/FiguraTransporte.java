package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class FiguraTransporte {
    private Operadore[] operadores;
    private String cveTransporte;

    @JsonProperty("Operadores")
    public Operadore[] getOperadores() { return operadores; }
    @JsonProperty("Operadores")
    public void setOperadores(Operadore[] value) { this.operadores = value; }

    @JsonProperty("CveTransporte")
    public String getCveTransporte() { return cveTransporte; }
    @JsonProperty("CveTransporte")
    public void setCveTransporte(String value) { this.cveTransporte = value; }
}
