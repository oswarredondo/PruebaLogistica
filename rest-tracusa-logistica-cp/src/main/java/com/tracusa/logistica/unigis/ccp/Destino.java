package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Destino {
    private String idDestino;
    private String rfcDestinatario;
    private String nombreDestinatario;
    private String fechaHoraProgLlegada;
    private String numRegIDTrib;
    private String residenciaFiscal;
    private String numEstacion;
    private String nombreEstacion;
    private String tipoUbicacion;
    private Domicilio domicilio;

    @JsonProperty("IdDestino")
    public String getIDDestino() { return idDestino; }
    @JsonProperty("IdDestino")
    public void setIDDestino(String value) { this.idDestino = value; }

    @JsonProperty("RFCDestinatario")
    public String getRFCDestinatario() { return rfcDestinatario; }
    @JsonProperty("RFCDestinatario")
    public void setRFCDestinatario(String value) { this.rfcDestinatario = value; }

    @JsonProperty("NombreDestinatario")
    public String getNombreDestinatario() { return nombreDestinatario; }
    @JsonProperty("NombreDestinatario")
    public void setNombreDestinatario(String value) { this.nombreDestinatario = value; }

    @JsonProperty("FechaHoraProgLlegada")
    public String getFechaHoraProgLlegada() { return fechaHoraProgLlegada; }
    @JsonProperty("FechaHoraProgLlegada")
    public void setFechaHoraProgLlegada(String value) { this.fechaHoraProgLlegada = value; }

    @JsonProperty("NumRegIdTrib")
    public String getNumRegIDTrib() { return numRegIDTrib; }
    @JsonProperty("NumRegIdTrib")
    public void setNumRegIDTrib(String value) { this.numRegIDTrib = value; }

    @JsonProperty("ResidenciaFiscal")
    public String getResidenciaFiscal() { return residenciaFiscal; }
    @JsonProperty("ResidenciaFiscal")
    public void setResidenciaFiscal(String value) { this.residenciaFiscal = value; }

    @JsonProperty("NumEstacion")
    public String getNumEstacion() { return numEstacion; }
    @JsonProperty("NumEstacion")
    public void setNumEstacion(String value) { this.numEstacion = value; }

    @JsonProperty("NombreEstacion")
    public String getNombreEstacion() { return nombreEstacion; }
    @JsonProperty("NombreEstacion")
    public void setNombreEstacion(String value) { this.nombreEstacion = value; }

    @JsonProperty("TipoUbicacion")
    public String getTipoUbicacion() { return tipoUbicacion; }
    @JsonProperty("TipoUbicacion")
    public void setTipoUbicacion(String value) { this.tipoUbicacion = value; }

    @JsonProperty("Domicilio")
    public Domicilio getDomicilio() { return domicilio; }
    @JsonProperty("Domicilio")
    public void setDomicilio(Domicilio value) { this.domicilio = value; }
}
