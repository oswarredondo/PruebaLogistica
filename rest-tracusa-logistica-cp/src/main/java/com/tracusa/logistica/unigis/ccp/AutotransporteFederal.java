package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class AutotransporteFederal {
    private IdentificacionVehicular identificacionVehicular;
    private String permSCT;
    private String numPermisoSCT;
    private String nombreAseg;
    private String numPolizaSeguro;

    @JsonProperty("IdentificacionVehicular")
    public IdentificacionVehicular getIdentificacionVehicular() { return identificacionVehicular; }
    @JsonProperty("IdentificacionVehicular")
    public void setIdentificacionVehicular(IdentificacionVehicular value) { this.identificacionVehicular = value; }

    @JsonProperty("PermSCT")
    public String getPermSCT() { return permSCT; }
    @JsonProperty("PermSCT")
    public void setPermSCT(String value) { this.permSCT = value; }

    @JsonProperty("NumPermisoSCT")
    public String getNumPermisoSCT() { return numPermisoSCT; }
    @JsonProperty("NumPermisoSCT")
    public void setNumPermisoSCT(String value) { this.numPermisoSCT = value; }

    @JsonProperty("NombreAseg")
    public String getNombreAseg() { return nombreAseg; }
    @JsonProperty("NombreAseg")
    public void setNombreAseg(String value) { this.nombreAseg = value; }

    @JsonProperty("NumPolizaSeguro")
    public String getNumPolizaSeguro() { return numPolizaSeguro; }
    @JsonProperty("NumPolizaSeguro")
    public void setNumPolizaSeguro(String value) { this.numPolizaSeguro = value; }
}
