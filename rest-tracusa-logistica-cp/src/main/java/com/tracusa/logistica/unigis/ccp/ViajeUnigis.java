package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class ViajeUnigis {
    private long idViaje;
    private String referenciaExterna;
    private String fechaViaje;
    private long idJornada;
    private String fechaJornada;
    private String tipoJornada;
    private String operacion;
    private String transportista;
    private String tipoFlota;

    @JsonProperty("IdViaje")
    public long getIDViaje() { return idViaje; }
    @JsonProperty("IdViaje")
    public void setIDViaje(long value) { this.idViaje = value; }

    @JsonProperty("ReferenciaExterna")
    public String getReferenciaExterna() { return referenciaExterna; }
    @JsonProperty("ReferenciaExterna")
    public void setReferenciaExterna(String value) { this.referenciaExterna = value; }

    @JsonProperty("FechaViaje")
    public String getFechaViaje() { return fechaViaje; }
    @JsonProperty("FechaViaje")
    public void setFechaViaje(String value) { this.fechaViaje = value; }

    @JsonProperty("IdJornada")
    public long getIDJornada() { return idJornada; }
    @JsonProperty("IdJornada")
    public void setIDJornada(long value) { this.idJornada = value; }

    @JsonProperty("FechaJornada")
    public String getFechaJornada() { return fechaJornada; }
    @JsonProperty("FechaJornada")
    public void setFechaJornada(String value) { this.fechaJornada = value; }

    @JsonProperty("TipoJornada")
    public String getTipoJornada() { return tipoJornada; }
    @JsonProperty("TipoJornada")
    public void setTipoJornada(String value) { this.tipoJornada = value; }

    @JsonProperty("Operacion")
    public String getOperacion() { return operacion; }
    @JsonProperty("Operacion")
    public void setOperacion(String value) { this.operacion = value; }

    @JsonProperty("Transportista")
    public String getTransportista() { return transportista; }
    @JsonProperty("Transportista")
    public void setTransportista(String value) { this.transportista = value; }

    @JsonProperty("TipoFlota")
    public String getTipoFlota() { return tipoFlota; }
    @JsonProperty("TipoFlota")
    public void setTipoFlota(String value) { this.tipoFlota = value; }
}
