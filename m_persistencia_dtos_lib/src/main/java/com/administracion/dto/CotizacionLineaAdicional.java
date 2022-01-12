/**
 * 
 */
package com.administracion.dto;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class CotizacionLineaAdicional implements Serializable{
    
    private static final long serialVersionUID = 1L;
    float precio;
    int tipo;
    int idcotizacionlinea_adicional ;
    int idcotizacionlinea;
    String idadicional;
    String descripcion;
    int idregistroadicional;
    
    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }
    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }
    /**
     * @return the idcotizacionlinea_adicional
     */
    public int getIdcotizacionlinea_adicional() {
        return idcotizacionlinea_adicional;
    }
    /**
     * @return the idcotizacionlinea
     */
    public int getIdcotizacionlinea() {
        return idcotizacionlinea;
    }
    /**
     * @return the idadicional
     */
    public String getIdadicional() {
        return idadicional;
    }
    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    /**
     * @param idcotizacionlinea_adicional the idcotizacionlinea_adicional to set
     */
    public void setIdcotizacionlinea_adicional(int idcotizacionlinea_adicional) {
        this.idcotizacionlinea_adicional = idcotizacionlinea_adicional;
    }
    /**
     * @param idcotizacionlinea the idcotizacionlinea to set
     */
    public void setIdcotizacionlinea(int idcotizacionlinea) {
        this.idcotizacionlinea = idcotizacionlinea;
    }
    /**
     * @param idadicional the idadicional to set
     */
    public void setIdadicional(String idadicional) {
        this.idadicional = idadicional;
    }
    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * @return the idregistroadicional
     */
    public int getIdregistroadicional() {
        return idregistroadicional;
    }
    /**
     * @param idregistroadicional the idregistroadicional to set
     */
    public void setIdregistroadicional(int idregistroadicional) {
        this.idregistroadicional = idregistroadicional;
    }
   
	
}
