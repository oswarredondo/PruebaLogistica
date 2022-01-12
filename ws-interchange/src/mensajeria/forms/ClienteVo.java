/*
 * ClienteVo.java
 *
 * Created on 19 de septiembre de 2003, 03:42 PM
 */

package mensajeria.forms;

import java.io.Serializable; 

/**
 *
 * @author  amorales
 */
public class ClienteVo  implements Serializable {
    
    private String numCliente;
    
    private String razonSocial;
    
    private String atencion;
    
    private String calle;
    
    private String calle1;
    
    private String colonia;
    
    private String ciudad;
    
    private String cp;
    
    private String telefono;
    
    private String municipio;
    
    private String password;
    
    private String claveUnica;
    
    /** Creates a new instance of ClienteVo */
    public ClienteVo() {
    }
    
    /** Getter for property atencion.
     * @return Value of property atencion.
     */
    public java.lang.String getAtencion() {
                if ( this.atencion!=null){
             this.atencion =  this.atencion.toUpperCase();
        }

        return atencion;
    }
    
    /** Setter for property atencion.
     * @param atencion New value of property atencion.
     */
    public void setAtencion(java.lang.String atencion) {
        this.atencion = atencion;
    }
    
    /** Getter for property calle.
     * @return Value of property calle.
     */
    public java.lang.String getCalle() {
                if ( this.calle!=null){
             this.calle =  this.calle.toUpperCase();
        }

        return calle;
    }
    
    /** Setter for property calle.
     * @param calle New value of property calle.
     */
    public void setCalle(java.lang.String calle) {
        this.calle = calle;
    }
    
    /** Getter for property calle1.
     * @return Value of property calle1.
     */
    public java.lang.String getCalle1() {
                if ( this.calle1!=null){
             this.calle1 =  this.calle1.toUpperCase();
        }

        return calle1;
    }
    
    /** Setter for property calle1.
     * @param calle1 New value of property calle1.
     */
    public void setCalle1(java.lang.String calle1) {
        this.calle1 = calle1;
    }
    
    /** Getter for property ciudad.
     * @return Value of property ciudad.
     */
    public java.lang.String getCiudad() {
                if ( this.ciudad!=null){
             this.ciudad =  this.ciudad.toUpperCase();
        }

        return ciudad;
    }
    
    /** Setter for property ciudad.
     * @param ciudad New value of property ciudad.
     */
    public void setCiudad(java.lang.String ciudad) {
        this.ciudad = ciudad;
    }
    
    /** Getter for property colonia.
     * @return Value of property colonia.
     */
    public java.lang.String getColonia() {
                if ( this.colonia!=null){
             this.colonia =  this.colonia.toUpperCase();
        }

        return colonia;
    }
    
    /** Setter for property colonia.
     * @param colonia New value of property colonia.
     */
    public void setColonia(java.lang.String colonia) {
        this.colonia = colonia;
    }
    
    /** Getter for property cp.
     * @return Value of property cp.
     */
    public java.lang.String getCp() {
        return cp;
    }
    
    /** Setter for property cp.
     * @param cp New value of property cp.
     */
    public void setCp(java.lang.String cp) {
        this.cp = cp;
    }
    
    /** Getter for property numCliente.
     * @return Value of property numCliente.
     */
    public java.lang.String getNumCliente() {
        return numCliente;
    }
    
    /** Setter for property numCliente.
     * @param numCliente New value of property numCliente.
     */
    public void setNumCliente(java.lang.String numCliente) {
        this.numCliente = numCliente;
    }
    
    /** Getter for property razonSocial.
     * @return Value of property razonSocial.
     */
    public java.lang.String getRazonSocial() {
                if ( this.razonSocial!=null){
             this.razonSocial =  this.razonSocial.toUpperCase();
        }

        return razonSocial;
    }
    
    /** Setter for property razonSocial.
     * @param razonSocial New value of property razonSocial.
     */
    public void setRazonSocial(java.lang.String razonSocial) {
        this.razonSocial = razonSocial;
    }
    
    /** Getter for property telefono.
     * @return Value of property telefono.
     */
    public java.lang.String getTelefono() {
        return telefono;
    }
    
    /** Setter for property telefono. 
     * @param telefono New value of property telefono.
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Getter for property municipio.
     * @return Value of property municipio.
     */
    public java.lang.String getMunicipio() {
                if ( this.municipio!=null){
             this.municipio =  this.municipio.toUpperCase();
        }

        return municipio;
    }
    
    /**
     * Setter for property municipio.
     * @param municipio New value of property municipio.
     */
    public void setMunicipio(java.lang.String municipio) {
        this.municipio = municipio;
    }
    
    /**
     * Getter for property password.
     * @return Value of property password.
     */
    public java.lang.String getPassword() {
        return password;
    }
    
    /**
     * Setter for property password.
     * @param password New value of property password.
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }
    
    /**
     * Getter for property claveUnica.
     * @return Value of property claveUnica.
     */
    public java.lang.String getClaveUnica() {
        return claveUnica;
    }
    
    /**
     * Setter for property claveUnica.
     * @param claveUnica New value of property claveUnica.
     */
    public void setClaveUnica(java.lang.String claveUnica) {
        this.claveUnica = claveUnica;
    }
    
}
