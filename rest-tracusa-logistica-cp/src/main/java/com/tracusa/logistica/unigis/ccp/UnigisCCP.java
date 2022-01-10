package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class UnigisCCP {
    private long codigo;
    private String mensaje;
    private ViajesSAT[] viajesSAT;

    @JsonProperty("Codigo")
    public long getCodigo() { return codigo; }
    @JsonProperty("Codigo")
    public void setCodigo(long value) { this.codigo = value; }

    @JsonProperty("mensaje")
    public String getMensaje() { return mensaje; }
    @JsonProperty("mensaje")
    public void setMensaje(String value) { this.mensaje = value; }

    @JsonProperty("viajesSAT")
    public ViajesSAT[] getViajesSAT() { return viajesSAT; }
    @JsonProperty("viajesSAT")
    public void setViajesSAT(ViajesSAT[] value) { this.viajesSAT = value; }
}
