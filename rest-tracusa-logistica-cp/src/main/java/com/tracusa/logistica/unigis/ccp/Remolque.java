package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Remolque {
    private String subTipoRem;
    private String placa;

    @JsonProperty("SubTipoRem")
    public String getSubTipoRem() { return subTipoRem; }
    @JsonProperty("SubTipoRem")
    public void setSubTipoRem(String value) { this.subTipoRem = value; }

    @JsonProperty("Placa")
    public String getPlaca() { return placa; }
    @JsonProperty("Placa")
    public void setPlaca(String value) { this.placa = value; }
}
