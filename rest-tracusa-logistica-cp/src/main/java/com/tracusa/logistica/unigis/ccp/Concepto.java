package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Concepto {
    private String claveProdServ;
    private String noIdentificacion;
    private String cantidad;
    private String claveUnidad;
    private String unidad;
    private String descripcion;
    private String valorUnitario;
    private String importe;

    @JsonProperty("ClaveProdServ")
    public String getClaveProdServ() { return claveProdServ; }
    @JsonProperty("ClaveProdServ")
    public void setClaveProdServ(String value) { this.claveProdServ = value; }

    @JsonProperty("NoIdentificacion")
    public String getNoIdentificacion() { return noIdentificacion; }
    @JsonProperty("NoIdentificacion")
    public void setNoIdentificacion(String value) { this.noIdentificacion = value; }

    @JsonProperty("Cantidad")
    public String getCantidad() { return cantidad; }
    @JsonProperty("Cantidad")
    public void setCantidad(String value) { this.cantidad = value; }

    @JsonProperty("ClaveUnidad")
    public String getClaveUnidad() { return claveUnidad; }
    @JsonProperty("ClaveUnidad")
    public void setClaveUnidad(String value) { this.claveUnidad = value; }

    @JsonProperty("Unidad")
    public String getUnidad() { return unidad; }
    @JsonProperty("Unidad")
    public void setUnidad(String value) { this.unidad = value; }

    @JsonProperty("Descripcion")
    public String getDescripcion() { return descripcion; }
    @JsonProperty("Descripcion")
    public void setDescripcion(String value) { this.descripcion = value; }

    @JsonProperty("ValorUnitario")
    public String getValorUnitario() { return valorUnitario; }
    @JsonProperty("ValorUnitario")
    public void setValorUnitario(String value) { this.valorUnitario = value; }

    @JsonProperty("Importe")
    public String getImporte() { return importe; }
    @JsonProperty("Importe")
    public void setImporte(String value) { this.importe = value; }
}
