package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Mercancia {
    private double pesoEnKg;
    private long cantidad;
    private String bienesTransp;
    private String claveUnidad;
    private String unidad;
    private String claveSTCC;
    private String descripcion;
    private String dimensiones;
    private String valorMercancia;
    private String moneda;
    private String fraccionArranceleria;
    private String uuidComercioEXT;
    private CantidadTransporta[] cantidadTransporta;

    @JsonProperty("PesoEnKg")
    public double getPesoEnKg() { return pesoEnKg; }
    @JsonProperty("PesoEnKg")
    public void setPesoEnKg(double value) { this.pesoEnKg = value; }

    @JsonProperty("Cantidad")
    public long getCantidad() { return cantidad; }
    @JsonProperty("Cantidad")
    public void setCantidad(long value) { this.cantidad = value; }

    @JsonProperty("BienesTransp")
    public String getBienesTransp() { return bienesTransp; }
    @JsonProperty("BienesTransp")
    public void setBienesTransp(String value) { this.bienesTransp = value; }

    @JsonProperty("ClaveUnidad")
    public String getClaveUnidad() { return claveUnidad; }
    @JsonProperty("ClaveUnidad")
    public void setClaveUnidad(String value) { this.claveUnidad = value; }

    @JsonProperty("Unidad")
    public String getUnidad() { return unidad; }
    @JsonProperty("Unidad")
    public void setUnidad(String value) { this.unidad = value; }

    @JsonProperty("ClaveSTCC")
    public String getClaveSTCC() { return claveSTCC; }
    @JsonProperty("ClaveSTCC")
    public void setClaveSTCC(String value) { this.claveSTCC = value; }

    @JsonProperty("Descripcion")
    public String getDescripcion() { return descripcion; }
    @JsonProperty("Descripcion")
    public void setDescripcion(String value) { this.descripcion = value; }

    @JsonProperty("Dimensiones")
    public String getDimensiones() { return dimensiones; }
    @JsonProperty("Dimensiones")
    public void setDimensiones(String value) { this.dimensiones = value; }

    @JsonProperty("ValorMercancia")
    public String getValorMercancia() { return valorMercancia; }
    @JsonProperty("ValorMercancia")
    public void setValorMercancia(String value) { this.valorMercancia = value; }

    @JsonProperty("Moneda")
    public String getMoneda() { return moneda; }
    @JsonProperty("Moneda")
    public void setMoneda(String value) { this.moneda = value; }

    @JsonProperty("FraccionArranceleria")
    public String getFraccionArranceleria() { return fraccionArranceleria; }
    @JsonProperty("FraccionArranceleria")
    public void setFraccionArranceleria(String value) { this.fraccionArranceleria = value; }

    @JsonProperty("UUIDComercioExt")
    public String getUUIDComercioEXT() { return uuidComercioEXT; }
    @JsonProperty("UUIDComercioExt")
    public void setUUIDComercioEXT(String value) { this.uuidComercioEXT = value; }

    @JsonProperty("CantidadTransporta")
    public CantidadTransporta[] getCantidadTransporta() { return cantidadTransporta; }
    @JsonProperty("CantidadTransporta")
    public void setCantidadTransporta(CantidadTransporta[] value) { this.cantidadTransporta = value; }
}
