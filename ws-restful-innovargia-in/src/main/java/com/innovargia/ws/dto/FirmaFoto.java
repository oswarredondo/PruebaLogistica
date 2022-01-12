package com.innovargia.ws.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FirmaFoto implements Serializable{
    
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    String idguia;
    String idfirma;
    String imaBase64;   //IMagen en PNG
    String nota;
    String latitud;
    String longitud;
    String idtipodocumento;


    public FirmaFoto() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @return the idguia
     */
    public String getIdguia() {
        return idguia;
    }

    /**
     * @param idguia the idguia to set
     */
    public void setIdguia(String idguia) {
        this.idguia = idguia;
    }

    /**
     * @return the idfirma
     */
    public String getIdfirma() {
        return idfirma;
    }

    /**
     * @param idfirma the idfirma to set
     */
    public void setIdfirma(String idfirma) {
        this.idfirma = idfirma;
    }

    /**
     * @return the imaBase64
     */
    public String getImaBase64() {
        return imaBase64;
    }

    /**
     * @param imaBase64 the imaBase64 to set
     */
    public void setImaBase64(String imaBase64) {
        this.imaBase64 = imaBase64;
    }

    /**
     * @return the nota
     */
    public String getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(String nota) {
        this.nota = nota;
    }

    /**
     * @return the latitud
     */
    public String getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public String getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the idtipodocumento
     */
    public String getIdtipodocumento() {
        return idtipodocumento;
    }

    /**
     * @param idtipodocumento the idtipodocumento to set
     */
    public void setIdtipodocumento(String idtipodocumento) {
        this.idtipodocumento = idtipodocumento;
    }

}
