package com.innovargia.ws.test;

public class DatosEtiqueta {

    String contenido="";
    String observacion="";
    String referencia="";
    
   
    public Direccion remitente = new Direccion();
    public Direccion destinatario = new Direccion();
    
    public DatosEtiqueta() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @return the contenido
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * @param contenido the contenido to set
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the remitente
     */
    public Direccion getRemitente() {
        return remitente;
    }

    /**
     * @param remitente the remitente to set
     */
    public void setRemitente(Direccion remitente) {
        this.remitente = remitente;
    }

    /**
     * @return the destinatario
     */
    public Direccion getDestinatario() {
        return destinatario;
    }

    /**
     * @param destinatario the destinatario to set
     */
    public void setDestinatario(Direccion destinatario) {
        this.destinatario = destinatario;
    }

   
}
