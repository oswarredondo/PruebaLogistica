package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class CantidadTransporta {
    private long cantidad;
    private String idOrigen;
    private String idDestino;
    private String cvesTransporte;

    @JsonProperty("Cantidad")
    public long getCantidad() { return cantidad; }
    @JsonProperty("Cantidad")
    public void setCantidad(long value) { this.cantidad = value; }

    @JsonProperty("IdOrigen")
    public String getIDOrigen() { return idOrigen; }
    @JsonProperty("IdOrigen")
    public void setIDOrigen(String value) { this.idOrigen = value; }

    @JsonProperty("IdDestino")
    public String getIDDestino() { return idDestino; }
    @JsonProperty("IdDestino")
    public void setIDDestino(String value) { this.idDestino = value; }

    @JsonProperty("CvesTransporte")
    public String getCvesTransporte() { return cvesTransporte; }
    @JsonProperty("CvesTransporte")
    public void setCvesTransporte(String value) { this.cvesTransporte = value; }
}
