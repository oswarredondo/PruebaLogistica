/* $Id: $
 * Nombre del Proyecto:
 * Nombre del Programa: Confirmacion.java
 * Responsable: Adrián Morales Ruaro
 * Descripcion: contiene los datos de una confirmacion
 *
 *$Log:$
 */
package com.innovargia.salesmanager.dtos;

//Imports
import java.io.Serializable;

/**
 *<CODE>
 * Contiene la historia de un envio
 *</CODE>
 * 
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
public class ConfirmacionDTO implements Serializable, Cloneable {
    
    /** Contiene el nombre de la persona que recibe  */
    private String quienRecibe;
    /** Contiene la fecha de confirmacion*/
    private String fechaConfirmacion;
    /** Contiene el identificador de la ruta */
    private String ruta;
    /** Contiene las siglas de la plaza destino */
    private String siglas;
    /** Contiene las siglas de la plaza que origino el registro*/
    private String origenRegistro;
    /** Contiene la fecha de insercion del registro  */
    private String fechaInsercion;
    
    /** Contiene la fecha de insercion del registro  */
    private String fechaentregapod;
    /**
     * Contiene la hora en formato 00-12
     */
    private String horaCorta;
    /**
     * Contiene los minutos en formato 00-59
     */
    private String minutosCorta;
    
    /**
     * Contiene la hora en formato dd/mm/aaaa
     */
    private String fechaCorta;
    
    /**
     * Constructor por default
     */ 
    public ConfirmacionDTO() { ; }
    
    /**
     * Constructor por default con parametros
     *
     */
    public ConfirmacionDTO(String quienRecibe, String fechaConfirmacion,
    String ruta, String siglas, String origenRegistro, String fechaInsercion){
        
        this.quienRecibe = quienRecibe;
        this.fechaConfirmacion = fechaConfirmacion;
        this.ruta = ruta;
        this.siglas = siglas;
        this.origenRegistro = origenRegistro;
        this.fechaInsercion = fechaInsercion;
    }
    
    /**
     * Obtiene el valor de la propiedad de  quienRecibe.
     * @return Value of property quienRecibe.
     */
    public java.lang.String getQuienRecibe() {
        if (quienRecibe!=null)
            return quienRecibe.toUpperCase();
        
        return quienRecibe;
    }
    
    /**
     * Ajusta el valor de la propiedad de  quienRecibe.
     * @param quienRecibe New value of property quienRecibe.
     */
    public void setQuienRecibe(java.lang.String quienRecibe) {
        this.quienRecibe = quienRecibe;
    }
    
    /**
     * Obtiene el valor de la propiedad de  fechaConfirmacion.
     * @return Value of property fechaConfirmacion.
     */
    public java.lang.String getFechaConfirmacion() {
        return fechaConfirmacion;
    }
    
    /**
     * Ajusta el valor de la propiedad de  fechaConfirmacion.
     * @param fechaConfirmacion New value of property fechaConfirmacion.
     */
    public void setFechaConfirmacion(java.lang.String fechaConfirmacion) {
        this.fechaConfirmacion = fechaConfirmacion;
    }
    
    /**
     * Obtiene el valor de la propiedad de  ruta.
     * @return Value of property ruta.
     */
    public java.lang.String getRuta() {
        if (ruta!=null)
            return ruta.toUpperCase();
        
        return ruta;
    }
    
    /**
     * Ajusta el valor de la propiedad de  ruta.
     * @param ruta New value of property ruta.
     */
    public void setRuta(java.lang.String ruta) {
        this.ruta = ruta;
    }
    
    /**
     * Obtiene el valor de la propiedad de  siglas.
     * @return Value of property siglas.
     */
    public java.lang.String getSiglas() {
        if (siglas!=null)
            return siglas.toUpperCase();
        
        return siglas;
    }
    
    /**
     * Ajusta el valor de la propiedad de  siglas.
     * @param siglas New value of property siglas.
     */
    public void setSiglas(java.lang.String siglas) {
        this.siglas = siglas;
    }
    
    /**
     * Obtiene el valor de la propiedad de  origenRegistro.
     * @return Value of property origenRegistro.
     */
    public java.lang.String getOrigenRegistro() {
        if (origenRegistro!=null)
            return origenRegistro.toUpperCase();
        
        return origenRegistro;
    }
    
    /**
     * Ajusta el valor de la propiedad de  origenRegistro.
     * @param origenRegistro New value of property origenRegistro.
     */
    public void setOrigenRegistro(java.lang.String origenRegistro) {
        this.origenRegistro = origenRegistro;
    }
    
    /**
     * Obtiene el valor de la propiedad de  fechaInsercion.
     * @return Value of property fechaInsercion.
     */
    public java.lang.String getFechaInsercion() {
        return fechaInsercion;
    }
    
    /**
     * Ajusta el valor de la propiedad de  fechaInsercion.
     * @param fechaInsercion New value of property fechaInsercion.
     */
    public void setFechaInsercion(java.lang.String fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }
    
    /**
     * Getter for property horaCorta.
     * @return Value of property horaCorta.
     */
    public java.lang.String getHoraCorta() {
        if (this.quienRecibe==null)
            return "";
        if (horaCorta==null) horaCorta="";
        
        while (horaCorta.length()<2){
            horaCorta=0+horaCorta;
        }
        return horaCorta;
    }
    
    /**
     * Setter for property horaCorta.
     * @param horaCorta New value of property horaCorta.
     */
    public void setHoraCorta(java.lang.String horaCorta) {
        this.horaCorta = horaCorta;
    }
     
    /**
     * Getter for property minutosCorta.
     * @return Value of property minutosCorta.
     */
    public java.lang.String getMinutosCorta() {
        if ((this.quienRecibe==null) || (this.quienRecibe.trim().length()<=0)) return "";
        if (minutosCorta==null) minutosCorta="";
        
        while (minutosCorta.length()<2){
            minutosCorta=0+minutosCorta;
        }
        return minutosCorta;
    } 
    
    /**
     * Setter for property minutosCorta.
     * @param minutosCorta New value of property minutosCorta.
     */
    public void setMinutosCorta(java.lang.String minutosCorta) {
        this.minutosCorta = minutosCorta;
    }
    
    /**
     * Getter for property fechaCorta.
     * @return Value of property fechaCorta.
     */
    public java.lang.String getFechaCorta() {
        if (this.quienRecibe==null){
            return "";
        }
        return fechaCorta;
    }
    
    /**
     * Setter for property fechaCorta.
     * @param fechaCorta New value of property fechaCorta.
     */
    public void setFechaCorta(java.lang.String fechaCorta) {
        this.fechaCorta = fechaCorta;
    }
    
    public boolean isConfirmada() {
		if (this.quienRecibe == null)  {
			return false;
		}
		return true;

	}

	/**
	 * @return the fechaentregapod
	 */
	public String getFechaentregapod() {
		return fechaentregapod;
	}

	/**
	 * @param fechaentregapod the fechaentregapod to set
	 */
	public void setFechaentregapod(String fechaentregapod) {
		this.fechaentregapod = fechaentregapod;
	}
    
} // fin Historia
