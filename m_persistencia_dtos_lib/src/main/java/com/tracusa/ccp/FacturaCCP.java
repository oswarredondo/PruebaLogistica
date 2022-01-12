package com.tracusa.ccp;

import java.util.Date;

public class FacturaCCP {

    int idControl;
    int idViaje;
    Date fecha;
    String cliente;
    String factura;
    String estatus;
    String referencia;
    String mensaje;
    
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public int getIdControl() {
        return idControl;
    }
    public String getReferencia() {
        return referencia;
    }
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    public void setIdControl(int idControl) {
        this.idControl = idControl;
    }
    public int getIdViaje() {
        return idViaje;
    }
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getFactura() {
        return factura;
    }
    public void setFactura(String factura) {
        this.factura = factura;
    }
    public String getEstatus() {
        return estatus;
    }
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
