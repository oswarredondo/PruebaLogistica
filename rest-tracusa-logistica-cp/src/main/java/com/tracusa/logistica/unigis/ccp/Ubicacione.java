package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Ubicacione {
    private Origen origen;
    private Destino destino;
    private String tipoEstacion;
    private double distanciaRecorrida;

    @JsonProperty("Origen")
    public Origen getOrigen() { return origen; }
    @JsonProperty("Origen")
    public void setOrigen(Origen value) { this.origen = value; }

    @JsonProperty("Destino")
    public Destino getDestino() { return destino; }
    @JsonProperty("Destino")
    public void setDestino(Destino value) { this.destino = value; }

    @JsonProperty("TipoEstacion")
    public String getTipoEstacion() { return tipoEstacion; }
    @JsonProperty("TipoEstacion")
    public void setTipoEstacion(String value) { this.tipoEstacion = value; }

    @JsonProperty("DistanciaRecorrida")
    public double getDistanciaRecorrida() { return distanciaRecorrida; }
    @JsonProperty("DistanciaRecorrida")
    public void setDistanciaRecorrida(double value) { this.distanciaRecorrida = value; }
}
