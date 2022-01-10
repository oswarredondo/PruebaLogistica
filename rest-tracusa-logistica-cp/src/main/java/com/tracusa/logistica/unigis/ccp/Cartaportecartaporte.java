package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Cartaportecartaporte {
    private FiguraTransporte figuraTransporte;
    private Mercancias mercancias;
    private Ubicacione[] ubicaciones;
    private String version;
    private String transpInternac;
    private double totalDistRec;
    private String formaPago;
    private String tipoDeComprobante;
    private String metodoPago;
    private String moneda;
    private String total;

    @JsonProperty("FiguraTransporte")
    public FiguraTransporte getFiguraTransporte() { return figuraTransporte; }
    @JsonProperty("FiguraTransporte")
    public void setFiguraTransporte(FiguraTransporte value) { this.figuraTransporte = value; }

    @JsonProperty("Mercancias")
    public Mercancias getMercancias() { return mercancias; }
    @JsonProperty("Mercancias")
    public void setMercancias(Mercancias value) { this.mercancias = value; }

    @JsonProperty("Ubicaciones")
    public Ubicacione[] getUbicaciones() { return ubicaciones; }
    @JsonProperty("Ubicaciones")
    public void setUbicaciones(Ubicacione[] value) { this.ubicaciones = value; }

    @JsonProperty("Version")
    public String getVersion() { return version; }
    @JsonProperty("Version")
    public void setVersion(String value) { this.version = value; }

    @JsonProperty("TranspInternac")
    public String getTranspInternac() { return transpInternac; }
    @JsonProperty("TranspInternac")
    public void setTranspInternac(String value) { this.transpInternac = value; }

    @JsonProperty("TotalDistRec")
    public double getTotalDistRec() { return totalDistRec; }
    @JsonProperty("TotalDistRec")
    public void setTotalDistRec(double value) { this.totalDistRec = value; }

    @JsonProperty("FormaPago")
    public String getFormaPago() { return formaPago; }
    @JsonProperty("FormaPago")
    public void setFormaPago(String value) { this.formaPago = value; }

    @JsonProperty("TipoDeComprobante")
    public String getTipoDeComprobante() { return tipoDeComprobante; }
    @JsonProperty("TipoDeComprobante")
    public void setTipoDeComprobante(String value) { this.tipoDeComprobante = value; }

    @JsonProperty("MetodoPago")
    public String getMetodoPago() { return metodoPago; }
    @JsonProperty("MetodoPago")
    public void setMetodoPago(String value) { this.metodoPago = value; }

    @JsonProperty("Moneda")
    public String getMoneda() { return moneda; }
    @JsonProperty("Moneda")
    public void setMoneda(String value) { this.moneda = value; }

    @JsonProperty("Total")
    public String getTotal() { return total; }
    @JsonProperty("Total")
    public void setTotal(String value) { this.total = value; }
}
