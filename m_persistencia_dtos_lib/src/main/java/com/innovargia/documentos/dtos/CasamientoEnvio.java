/* $Id: $
 * Nombre del Proyecto: IETWeb
 * Nombre del Programa: Envio.java
 * Responsable: Adrián Morales Ruaro
 * Descripcion: Datos Pertenecientes a un casamiento de un envio
 *
 *$Log:$
 */
package com.innovargia.documentos.dtos;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *<CODE>
 * Datos del casamiento de un envio
 *</CODE>
 *
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
public class CasamientoEnvio implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**Contiene el identificador de la guia*/
    private String idGuia;
    /**Contiene el identificador dce casamiento*/
    private String idCasamiento;
    /**Contiene el identificador del transportista*/
    private String idCarrier;
    /**Contiene el identificador de la plaza o centro que origina el registro*/
    private String ceOrigenRegistro;
    /**Contiene el identificador de la plaza a la que pertenece la informacion*/
    private String plSiglasPlaza;
    /**Contiene la fecha en que se origino la informacion*/
    private String fechaEvento;
    /**Contiene el identificador de la ruta qie origina la informacion*/
    private String ruta;
    
    
    /***Contiene los folios asociados a l envio*/
    private ArrayList folios = new ArrayList();
    
    /**Constructor por defautl*/
    public CasamientoEnvio() { }
    
  
    
    /**
     * Getter for property idGuia.
     * @return Value of property idGuia.
     */
    public java.lang.String getIdGuia() {
        return idGuia;
    }
    
    /**
     * Setter for property idGuia.
     * @param idGuia New value of property idGuia.
     */
    public void setIdGuia(java.lang.String idGuia) {
        this.idGuia = idGuia;
    }
    
    /**
     * Getter for property idCasamiento.
     * @return Value of property idCasamiento.
     */
    public java.lang.String getIdCasamiento() {
        return idCasamiento;
    }
    
    /**
     * Setter for property idCasamiento.
     * @param idCasamiento New value of property idCasamiento.
     */
    public void setIdCasamiento(java.lang.String idCasamiento) {
        this.idCasamiento = idCasamiento;
    }
    
    /**
     * Getter for property idCarrier.
     * @return Value of property idCarrier.
     */
    public java.lang.String getIdCarrier() {
        return idCarrier;
    }
    
    /**
     * Setter for property idCarrier.
     * @param idCarrier New value of property idCarrier.
     */
    public void setIdCarrier(java.lang.String idCarrier) {
        this.idCarrier = idCarrier;
    }
    
    /**
     * Getter for property ceOrigenRegistro.
     * @return Value of property ceOrigenRegistro.
     */
    public java.lang.String getCeOrigenRegistro() {
        return ceOrigenRegistro;
    }
    
    /**
     * Setter for property ceOrigenRegistro.
     * @param ceOrigenRegistro New value of property ceOrigenRegistro.
     */
    public void setCeOrigenRegistro(java.lang.String ceOrigenRegistro) {
        this.ceOrigenRegistro = ceOrigenRegistro;
    }
    
    /**
     * Getter for property plSiglasPlaza.
     * @return Value of property plSiglasPlaza.
     */
    public java.lang.String getPlSiglasPlaza() {
        return plSiglasPlaza;
    }
    
    /**
     * Setter for property plSiglasPlaza.
     * @param plSiglasPlaza New value of property plSiglasPlaza.
     */
    public void setPlSiglasPlaza(java.lang.String plSiglasPlaza) {
        this.plSiglasPlaza = plSiglasPlaza;
    }
    
    /**
     * Getter for property fechaEvento.
     * @return Value of property fechaEvento.
     */
    public java.lang.String getFechaEvento() {
        return fechaEvento;
    }
    
    /**
     * Setter for property fechaEvento.
     * @param fechaEvento New value of property fechaEvento.
     */
    public void setFechaEvento(java.lang.String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }
    
    /**
     * Getter for property ruta.
     * @return Value of property ruta.
     */
    public java.lang.String getRuta() {
        return ruta;
    }
    
    /**
     * Setter for property ruta.
     * @param ruta New value of property ruta.
     */
    public void setRuta(java.lang.String ruta) {
        this.ruta = ruta;
    }
    
} // fin CasamientoEnvio
