package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Origen {
    private String idOrigen;
    private String rfcRemitente;
    private String nombreRemitente;
    private String numRegIDTrib;
    private String residenciaFiscal;
    private String numEstacion;
    private String nombreEstacion;
    private String tipoUbicacion;
    private String fechaHoraSalida;
    private Domicilio domicilio;

    @JsonProperty("IdOrigen")
    public String getIDOrigen() { return idOrigen; }
    @JsonProperty("IdOrigen")
    public void setIDOrigen(String value) { this.idOrigen = value; }

    @JsonProperty("RFCRemitente")
    public String getRFCRemitente() { return rfcRemitente; }
    @JsonProperty("RFCRemitente")
    public void setRFCRemitente(String value) { this.rfcRemitente = value; }

    @JsonProperty("NombreRemitente")
    public String getNombreRemitente() { return nombreRemitente; }
    @JsonProperty("NombreRemitente")
    public void setNombreRemitente(String value) { this.nombreRemitente = value; }

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

    @JsonProperty("FechaHoraSalida")
    public String getFechaHoraSalida() { return fechaHoraSalida; }
    @JsonProperty("FechaHoraSalida")
    public void setFechaHoraSalida(String value) { this.fechaHoraSalida = value; }

    @JsonProperty("Domicilio")
    public Domicilio getDomicilio() { return domicilio; }
    @JsonProperty("Domicilio")
    public void setDomicilio(Domicilio value) { this.domicilio = value; }
}
