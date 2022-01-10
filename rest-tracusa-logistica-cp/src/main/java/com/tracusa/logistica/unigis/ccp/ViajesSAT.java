package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class ViajesSAT {
    private ViajeUnigis viajeUnigis;
    private ClienteDador[] clienteDador;

    @JsonProperty("ViajeUnigis")
    public ViajeUnigis getViajeUnigis() { return viajeUnigis; }
    @JsonProperty("ViajeUnigis")
    public void setViajeUnigis(ViajeUnigis value) { this.viajeUnigis = value; }

    @JsonProperty("ClienteDador")
    public ClienteDador[] getClienteDador() { return clienteDador; }
    @JsonProperty("ClienteDador")
    public void setClienteDador(ClienteDador[] value) { this.clienteDador = value; }
}
