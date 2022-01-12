/**
 * 
 */
package com.administracion.dto;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class LineaRecepcionPrepagado implements Serializable{
    
    private static final long serialVersionUID = 1L;
    float peso;
    int alto;
    int ancho;
    int largo;
    float volumen ;
    
    float peso_original;
    int alto_original;
    int ancho_original;
    int largo_original;
    float volumen_original ;
    float precio_servicio ;
    float precio_kg_sobrepeso ;
    
    float peso_elejido ;
    float kg_sobrepeso;
    
    String razonsocial_rem;
    String iddocumento;
    String razonsocial_des;
    float cobro_sobrepeso;
    float cobro_reexpedicion;
    float precio_unitario;
    float total_cobro;
    
    float volumenamparado=0;
	float pesoamparado=0; 
    
    public LineaRecepcionPrepagado(){
	
    }
    /**
     * @return the peso
     */
    public float getPeso() {
        return peso;
    }
    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }
    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }
    /**
     * @return the largo
     */
    public int getLargo() {
        return largo;
    }
    /**
     * @return the volumen
     */
    public float getVolumen() {
        return volumen;
    }
    /**
     * @return the razonsocial_rem
     */
    public String getRazonsocial_rem() {
        return razonsocial_rem;
    }
    /**
     * @return the razonsocial_des
     */
    public String getRazonsocial_des() {
        return razonsocial_des;
    }
    /**
     * @return the cobro_sobrepeso
     */
    public float getCobro_sobrepeso() {
        return cobro_sobrepeso;
    }
    /**
     * @return the cobro_reexpedicion
     */
    public float getCobro_reexpedicion() {
        return cobro_reexpedicion;
    }
    /**
     * @return the total_cobro
     */
    public float getTotal_cobro() {
        return total_cobro;
    }
    /**
     * @param peso the peso to set
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }
    /**
     * @param alto the alto to set
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }
    /**
     * @param ancho the ancho to set
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    /**
     * @param largo the largo to set
     */
    public void setLargo(int largo) {
        this.largo = largo;
    }
    /**
     * @param volumen the volumen to set
     */
    public void setVolumen(float volumen) {
        this.volumen = volumen;
    }
    /**
     * @param razonsocial_rem the razonsocial_rem to set
     */
    public void setRazonsocial_rem(String razonsocial_rem) {
        this.razonsocial_rem = razonsocial_rem;
    }
    /**
     * @param razonsocial_des the razonsocial_des to set
     */
    public void setRazonsocial_des(String razonsocial_des) {
        this.razonsocial_des = razonsocial_des;
    }
    /**
     * @param cobro_sobrepeso the cobro_sobrepeso to set
     */
    public void setCobro_sobrepeso(float cobro_sobrepeso) {
        this.cobro_sobrepeso = cobro_sobrepeso;
    }
    /**
     * @param cobro_reexpedicion the cobro_reexpedicion to set
     */
    public void setCobro_reexpedicion(float cobro_reexpedicion) {
        this.cobro_reexpedicion = cobro_reexpedicion;
    }
    /**
     * @param total_cobro the total_cobro to set
     */
    public void setTotal_cobro(float total_cobro) {
        this.total_cobro = total_cobro;
    }
    /**
     * @return the iddocumento
     */
    public String getIddocumento() {
        return iddocumento;
    }
    /**
     * @param iddocumento the iddocumento to set
     */
    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }
    /**
     * @return the precio_unitario
     */
    public float getPrecio_unitario() {
        return precio_unitario;
    }
    
    /**
     * @param precio_unitario the precio_unitario to set
     */
    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
    /**
     * @return the peso_original
     */
    public float getPeso_original() {
        return peso_original;
    }
    /**
     * @return the alto_original
     */
    public int getAlto_original() {
        return alto_original;
    }
    /**
     * @return the ancho_original
     */
    public int getAncho_original() {
        return ancho_original;
    }
    /**
     * @return the largo_original
     */
    public int getLargo_original() {
        return largo_original;
    }
    /**
     * @return the volumen_original
     */
    public float getVolumen_original() {
        return volumen_original;
    }
    /**
     * @return the precio_servicio
     */
    public float getPrecio_servicio() {
        return precio_servicio;
    }
    /**
     * @return the precio_kg_sobrepeso
     */
    public float getPrecio_kg_sobrepeso() {
        return precio_kg_sobrepeso;
    }
    /**
     * @param peso_original the peso_original to set
     */
    public void setPeso_original(float peso_original) {
        this.peso_original = peso_original;
    }
    /**
     * @param alto_original the alto_original to set
     */
    public void setAlto_original(int alto_original) {
        this.alto_original = alto_original;
    }
    /**
     * @param ancho_original the ancho_original to set
     */
    public void setAncho_original(int ancho_original) {
        this.ancho_original = ancho_original;
    }
    /**
     * @param largo_original the largo_original to set
     */
    public void setLargo_original(int largo_original) {
        this.largo_original = largo_original;
    }
    /**
     * @param volumen_original the volumen_original to set
     */
    public void setVolumen_original(float volumen_original) {
        this.volumen_original = volumen_original;
    }
    /**
     * @param precio_servicio the precio_servicio to set
     */
    public void setPrecio_servicio(float precio_servicio) {
        this.precio_servicio = precio_servicio;
    }
    /**
     * @param precio_kg_sobrepeso the precio_kg_sobrepeso to set
     */
    public void setPrecio_kg_sobrepeso(float precio_kg_sobrepeso) {
        this.precio_kg_sobrepeso = precio_kg_sobrepeso;
    }
    /**
     * @return the peso_elejido
     */
    public float getPeso_elejido() {
        return peso_elejido;
    }
    /**
     * @param peso_elejido the peso_elejido to set
     */
    public void setPeso_elejido(float peso_elejido) {
        this.peso_elejido = peso_elejido;
    }
    /**
     * @return the kg_sobrepeso
     */
    public float getKg_sobrepeso() {
        return kg_sobrepeso;
    }
    /**
     * @param kg_sobrepeso the kg_sobrepeso to set
     */
    public void setKg_sobrepeso(float kg_sobrepeso) {
        this.kg_sobrepeso = kg_sobrepeso;
    }
	public float getVolumenamparado() {
		return volumenamparado;
	}
	public void setVolumenamparado(float volumenamparado) {
		this.volumenamparado = volumenamparado;
	}
	public float getPesoamparado() {
		return pesoamparado;
	}
	public void setPesoamparado(float pesoamparado) {
		this.pesoamparado = pesoamparado;
	}
    
   
	
}
