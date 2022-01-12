package com.tracusa.logistica.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DatosEtiqueta  implements Serializable {

	private static final long serialVersionUID = 1L;
	String contenido="";
    String observacion="";
    String referencia="";
    
    String es_ocurre="NO";	
    String tiene_seguro="NO";	
    String nacional="NACIONAL";	
    String es_multiple="NO";	
    int numpiezas=1;	
    int pesofisico=1;	
    int largo=1;	
    int ancho=1;	
    int alto=1;	
    float valor_asegurado=0;
    float valordeclarado=0;																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																							

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
     * @return the es_ocurre
     */
    public String getEs_ocurre() {
        return es_ocurre;
    }

    /**
     * @param es_ocurre the es_ocurre to set
     */
    public void setEs_ocurre(String es_ocurre) {
        this.es_ocurre = es_ocurre;
    }

    /**
     * @return the tiene_seguro
     */
    public String getTiene_seguro() {
        return tiene_seguro;
    }

    /**
     * @param tiene_seguro the tiene_seguro to set
     */
    public void setTiene_seguro(String tiene_seguro) {
        this.tiene_seguro = tiene_seguro;
    }

    /**
     * @return the nacional
     */
    public String getNacional() {
        return nacional;
    }

    /**
     * @param nacional the nacional to set
     */
    public void setNacional(String nacional) {
        this.nacional = nacional;
    }

    /**
     * @return the es_multiple
     */
    public String getEs_multiple() {
        return es_multiple;
    }

    /**
     * @param es_multiple the es_multiple to set
     */
    public void setEs_multiple(String es_multiple) {
        this.es_multiple = es_multiple;
    }

    /**
     * @return the numpiezas
     */
    public int getNumpiezas() {
        return numpiezas;
    }

    /**
     * @param numpiezas the numpiezas to set
     */
    public void setNumpiezas(int numpiezas) {
        this.numpiezas = numpiezas;
    }
    
    public void setNumpiezas(String numpiezas) {
   	try{
   	    this.numpiezas = Integer.parseInt(numpiezas) ;
   	}catch(Exception e){
   	    this.numpiezas =0 ;
   	}
          
       }

    /**
     * @return the pesofisico
     */
    public int getPesofisico() {
        return pesofisico;
    }

    /**
     * @param pesofisico the pesofisico to set
     */
    public void setPesofisico(int pesofisico) {
        this.pesofisico = pesofisico;
    }
    
    public void setPesofisico(String pesofisico) {
   	try{
   	    this.pesofisico = Integer.parseInt(pesofisico) ;
   	}catch(Exception e){
   	    this.pesofisico =0 ;
   	}
          
       }

    /**
     * @return the largo
     */
    public int getLargo() {
        return largo;
    }

    /**
     * @param largo the largo to set
     */
    public void setLargo(int largo) {
        this.largo = largo;
    }
    
    public void setLargo(String largo) {
   	try{
   	    this.largo = Integer.parseInt(largo) ;
   	}catch(Exception e){
   	    this.largo =0 ;
   	}
          
       }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    public void setAncho(String ancho) {
   	try{
   	    this.ancho = Integer.parseInt(ancho) ;
   	}catch(Exception e){
   	    this.ancho =0 ;
   	}
          
       }

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setAlto(String alto) {
   	try{
   	    this.alto = Integer.parseInt(alto) ;
   	}catch(Exception e){
   	    this.alto =0 ;
   	}
          
       }
    
    /**
     * @return the valor_asegurado
     */
    public float getValor_asegurado() {
        return valor_asegurado;
    }
    
  

    /**
     * @param valor_asegurado the valor_asegurado to set
     */
    public void setValor_asegurado(float valor_asegurado) {
        this.valor_asegurado = valor_asegurado;
    }

    public void setValor_asegurado(String valor_asegurado) {
	try{
	    this.valor_asegurado = Float.parseFloat(valor_asegurado) ;
	}catch(Exception e){
	    this.valor_asegurado =0 ;
	}
       
    }
    
    /**
     * @return the valordeclarado
     */
    public float getValordeclarado() {
        return valordeclarado;
    }

    /**
     * @param valordeclarado the valordeclarado to set
     */
    public void setValordeclarado(float valordeclarado) {
        this.valordeclarado = valordeclarado;
    }
    
    public void setValordeclarado(String valordeclarado) {
   	try{
   	    this.valordeclarado = Float.parseFloat(valordeclarado) ;
   	}catch(Exception e){
   	    this.valordeclarado =0 ;
   	}
          
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
