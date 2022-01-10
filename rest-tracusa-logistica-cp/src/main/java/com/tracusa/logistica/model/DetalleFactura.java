package com.tracusa.logistica.model;

public class DetalleFactura {

    String pdf;
    String doc_contable;
    String folio;
    String mensaje;
    
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getPdf() {
        return pdf;
    }
    public void setPdf(String pdf) {
        this.pdf = pdf;
    }
    public String getDoc_contable() {
        return doc_contable;
    }
    public void setDoc_contable(String docfi) {
        this.doc_contable = docfi;
    }
    public String getFolio() {
        return folio;
    }
    public void setFolio(String folio) {
        this.folio = folio;
    }
}
