package com.innovargia.ws.dto;

public class Caexcepcion {

	String idExcepcion;
    String descripcion;
    String imputable;

    public Caexcepcion(String idExcepcion, String descripcion, String imputable) {
        this.idExcepcion = idExcepcion;
        this.descripcion = descripcion;
        this.imputable = imputable;
    }

    public Caexcepcion() {
    }

    public String getIdExcepcion() {
        return idExcepcion;
    }

    public void setIdExcepcion(String idExcepcion) {
        this.idExcepcion = idExcepcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImputable() {
        return imputable;
    }

    public void setImputable(String imputable) {
        this.imputable = imputable;
    }

}
