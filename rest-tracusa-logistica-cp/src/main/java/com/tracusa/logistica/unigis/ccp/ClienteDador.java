package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class ClienteDador {
    private Emisor emisor;
    private Receptor receptor;
    private Concepto[] conceptos;
    private Complemento[] complemento;

    @JsonProperty("Emisor")
    public Emisor getEmisor() { return emisor; }
    @JsonProperty("Emisor")
    public void setEmisor(Emisor value) { this.emisor = value; }

    @JsonProperty("Receptor")
    public Receptor getReceptor() { return receptor; }
    @JsonProperty("Receptor")
    public void setReceptor(Receptor value) { this.receptor = value; }

    @JsonProperty("Conceptos")
    public Concepto[] getConceptos() { return conceptos; }
    @JsonProperty("Conceptos")
    public void setConceptos(Concepto[] value) { this.conceptos = value; }

    @JsonProperty("Complemento")
    public Complemento[] getComplemento() { return complemento; }
    @JsonProperty("Complemento")
    public void setComplemento(Complemento[] value) { this.complemento = value; }
}
