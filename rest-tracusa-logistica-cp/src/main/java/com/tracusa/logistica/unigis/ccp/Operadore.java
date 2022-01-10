package com.tracusa.logistica.unigis.ccp;

import com.fasterxml.jackson.annotation.*;

public class Operadore {
    private Operador operador;
    private Propietario propietario;
    private Arrendatario arrendatario;
    private Notificado notificado;

    @JsonProperty("Operador")
    public Operador getOperador() { return operador; }
    @JsonProperty("Operador")
    public void setOperador(Operador value) { this.operador = value; }

    @JsonProperty("Propietario")
    public Propietario getPropietario() { return propietario; }
    @JsonProperty("Propietario")
    public void setPropietario(Propietario value) { this.propietario = value; }

    @JsonProperty("Arrendatario")
    public Arrendatario getArrendatario() { return arrendatario; }
    @JsonProperty("Arrendatario")
    public void setArrendatario(Arrendatario value) { this.arrendatario = value; }

    @JsonProperty("Notificado")
    public Notificado getNotificado() { return notificado; }
    @JsonProperty("Notificado")
    public void setNotificado(Notificado value) { this.notificado = value; }
}
