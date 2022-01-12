/*
 * Guia.java
 *
 * Created on 3 de septiembre de 2003, 11:36
 */

package com.servicio.dtos;

/** 
 * Contiene los atributos de los numeros de Gu&iacute;a de Transportista validos
 * @author AMR, Adrian Morales Ruaro
 * @version $Id:$
 */
public class Guia implements java.io.Serializable {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * Contiene el tipo de servicio amparado por el servicio
     */
    private String tipoServicio;
    /**
     * Contiene el tipo adicional del servicio que ampara el envio
     */
    private String adicional;
    /**
     * Contiene el n&oacute;mero de cliente 
     */
    private String numeroCliente;

    /**
     * Contiene el n&uacute;merto de folio asignado a la gu&iacute;a
     */
    private String folioGuia;
    
    /**
     * Contiene el largo permitido de la guia del transportista
     */
    private static final int LARGO_GUIA=14;
    
    private String libre;    
    
    private String guia;
    
    /** Creates a new instance of Guia (defatult constructor)*/
    public Guia() { }
    
    /**
     * Crea una instancia obteniendo una guia para poder inicializar todos
     * los atributos de la guia.
     *
     * La estructura de la guia es la siguiente de izq a deracha:
     * 
     * Primeros 4 caracteres  --> Numero de Cliente(4)
     * Seguiente caracter     --> Numero adicional(1)
     * Seguientes 2 caracteres--> Tipo de Servicio(2)
     * Siguiente caracter     --> Libre(1)
     * Siguientes 7 caracteres--> Folio asigando al servicio(7)
     *
     * ejemplo : guia ABCDF0189012453
     * 
     * al descomponer la guia queda:
     * Cliente:             ABCD
     * Adicional:           F
     * Tipo de Servicio:    01
     * Caracter Libre:      8
     * Folio de la guia:    9012453
     *
     * En caso de que la cuia tenga menos de 14 caracteres no se inicialia ningun
     * atriburo de la guia
     * 
     * @param guia contiene la guia de 15 caracteres de la cual se solicita la
     * informacion
     */
    public Guia(String guia) {
        
        //Verifica si la guia es diferente de null o vacia
        if (guia==null){
            return;
        }
        //Verifica que el largo de la guia sea correcta
        if (guia.trim().length() < LARGO_GUIA){
            return;
        }  
         
        //Obtiene los valores de los atributos del envio
        setNumeroCliente(guia.substring(0,4));
        
        setAdicional(guia.substring(4,5));
        setTipoServicio(guia.substring(5,7));
        setLibre(guia.substring(7,8));
        setFolioGuia(guia.substring(9));
        
    }//fin del constructor guia con parametros
    
    /** Getter for property adicional.
     * @return Value of property adicional.
     *
     */
    public java.lang.String getAdicional() {
        return adicional;
    }
    
    /** Setter for property adicional.
     * @param adicional New value of property adicional.
     *
     */
    public void setAdicional(java.lang.String adicional) {
        this.adicional = adicional;
    }
    
    /** Getter for property folioGuia.
     * @return Value of property folioGuia.
     *
     */
    public java.lang.String getFolioGuia() {
        return folioGuia;
    }
    
    /** Setter for property folioGuia.
     * @param folioGuia New value of property folioGuia.
     *
     */
    public void setFolioGuia(java.lang.String folioGuia) {
        this.folioGuia = folioGuia;
    }
    
    /** Getter for property numeroCliente.
     * @return Value of property numeroCliente.
     *
     */
    public java.lang.String getNumeroCliente() {
        return numeroCliente;
    }
    
    /** Setter for property numeroCliente.
     * @param numeroCliente New value of property numeroCliente.
     *
     */
    public void setNumeroCliente(java.lang.String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }
    
    /** Getter for property tipoServicio.
     * @return Value of property tipoServicio.
     *
     */
    public java.lang.String getTipoServicio() {
        return tipoServicio;
    }
    
    /** Setter for property tipoServicio.
     * @param tipoServicio New value of property tipoServicio.
     *
     */
    public void setTipoServicio(java.lang.String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    
    /** Getter for property libre.
     * @return Value of property libre.
     *
     */
    public java.lang.String getLibre() {
        return libre;
    }
    
    /** Setter for property libre.
     * @param libre New value of property libre.
     *
     */
    public void setLibre(java.lang.String libre) {
        this.libre = libre;
    }
    
    /** Getter for property guia.
     * @return Value of property guia.
     *
     */
    public java.lang.String getGuia() {
        return guia;
    }
    
    /** Setter for property guia.
     * @param guia New value of property guia.
     *
     */
    public void setGuia(java.lang.String guia) {
        this.guia = guia;
    }
    
}//fin de Guia

