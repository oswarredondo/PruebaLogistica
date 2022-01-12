/**
 * 
 */
package com.innovargia.ws.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author aruaro
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RutaUbicacion implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    String ruta;
    String empleado;
    String temperatura;//Temperatura
    String imei;
    String celular;
    String pedido;
    String latitud;
    String longitud;
    String fechaevento;
    String tipomovimiento;  //ENTR = ENTREGA , RECO=RECOLECCION



    

    /**
     * 
     */
    public RutaUbicacion() {
	// TODO Auto-generated constructor stub
    }


    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }


    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }


    /**
     * @return the empleado
     */
    public String getEmpleado() {
        return empleado;
    }


    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }


    /**
     * @return the temperatura
     */
    public String getTemperatura() {
        return temperatura;
    }


    /**
     * @param temperatura the temperatura to set
     */
    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }


    /**
     * @return the imei
     */
    public String getImei() {
        return imei;
    }


    /**
     * @param imei the imei to set
     */
    public void setImei(String imei) {
        this.imei = imei;
    }


    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }


    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }


    /**
     * @return the pedido
     */
    public String getPedido() {
        return pedido;
    }


    /**
     * @param pedido the pedido to set
     */
    public void setPedido(String pedido) {
        this.pedido = pedido;
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
     * @return the fecha
     */
    public String getFechaevento() {
        return fechaevento;
    }


    /**
     * @param fecha the fecha to set
     */
    public void setFechaevento(String fechaevento) {
        this.fechaevento = fechaevento;
    }
    
    public String getTipomovimiento() {
        return tipomovimiento;
    }

    public void setTipomovimiento(String tipomovimiento) {
        this.tipomovimiento = tipomovimiento;
    }

}
