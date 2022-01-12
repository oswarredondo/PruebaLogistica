/*
 * Entrega.java
 *
 * Created on 3 de septiembre de 2003, 12:22
 */

package com.servicio.dtos;

/**
 *
 * @author  root
 */
public class Entrega implements java.io.Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Contiene la guia del transportista 
     */
    private String guia;
    
    /**
     * Contiene las siglas de la plaza
     */
    private String siglasPlaza;
    /**
     * Contiene las siglas de la plaza que genera la informacion
     */
    private String origenRegistro;
    
    /**
     * Contiene el identificador de la ruta
     */
    private String ruta;
    /**
     * Contiene la fecha en que se genero el movimiento
     */
    private String fecha;
    
    /**
     * Contiene el nombre de la persona que recibe el envio
     */
    private String recibe;
    
    private String latitud;
    private String longitud;
    
    
    /** Creates a new instance of Entrega */
    public Entrega() { }
    
    /**
     * Inicializa los valores de la entrega de un envio.
     *
     * @param sigla contiene las siglas de la plaza
     * @param origen contiene las siglas de la plaza que genra la informacion
     * @param ruta contiene la ruta que realiza el movimiento de entrega
     * @param fecha contiene la fecha en que se genero el movimiento
     * @param recibe contiene el nombre de la persona que recibe el env&iacute;o
     */
    public Entrega(String siglas, String origen, String ruta, String fecha,
        String recibe) {
            
            setFecha(fecha);
            setOrigenRegistro(origen);
            setRecibe(recibe);
            setRuta(ruta);
            setSiglasPlaza(siglas);
    }//fin del constructor de Entrega
    
    /** Getter for property fecha.
     * @return Value of property fecha.
     *
     */
    public java.lang.String getFecha() {
        return fecha;
    }
    
    /** Setter for property fecha.
     * @param fecha New value of property fecha.
     *
     */
    public void setFecha(java.lang.String fecha) {
        this.fecha = fecha;
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
    
    /** Getter for property origenRegistro.
     * @return Value of property origenRegistro.
     *
     */
    public java.lang.String getOrigenRegistro() {
        return origenRegistro;
    }
    
    /** Setter for property origenRegistro.
     * @param origenRegistro New value of property origenRegistro.
     *
     */
    public void setOrigenRegistro(java.lang.String origenRegistro) {
        this.origenRegistro = origenRegistro;
    }
    
    /** Getter for property recibe.
     * @return Value of property recibe.
     *
     */
    public java.lang.String getRecibe() {
        if (recibe == null){
            return "SIN CONFIRMACION DE ENTREGA";
        }else{
            return recibe;
        }
    }
    
    /** Setter for property recibe.
     * @param recibe New value of property recibe.
     *
     */
    public void setRecibe(java.lang.String recibe) {
        this.recibe = recibe;
    }
    
    /** Getter for property ruta.
     * @return Value of property ruta.
     *
     */
    public java.lang.String getRuta() {
        return ruta;
    }
    
    /** Setter for property ruta.
     * @param ruta New value of property ruta.
     *
     */
    public void setRuta(java.lang.String ruta) {
        this.ruta = ruta;
    }
    
    /** Getter for property siglasPlaza.
     * @return Value of property siglasPlaza.
     *
     */
    public java.lang.String getSiglasPlaza() {
        return siglasPlaza;
    }
    
    /** Setter for property siglasPlaza.
     * @param siglasPlaza New value of property siglasPlaza.
     *
     */
    public void setSiglasPlaza(java.lang.String siglasPlaza) {
        this.siglasPlaza = siglasPlaza;
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
    
}
