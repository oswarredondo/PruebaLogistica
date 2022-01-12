/**
 * 
 */
package com.administracion.dto;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class AgendaOR implements Serializable{

    int folio ;
    int tipo ;
    String quiencaptura;
    String fechacaptura ;
    String quiensolicita ;
    String nombresolicita ;
    String telefonosolicita;
    String iddocumento ;
    String datosorigen ;
    String datosdestino;
    String tipoproblema;
    String depto_que_atiende ;
    String nombre_quien_atiende ;
    String tiposolucion ;
    String fechacierre ;
    String estatus;
    String comentariocierre ;
    String prioridad;
    String fecha_asignado_atiende;
    
    /**
     * 
     */
    public AgendaOR() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @return the folio
     */
    public int getFolio() {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }
    
    public void setFolio(String folio) {
   	try{
   	    this.folio = Integer.parseInt(folio);
   	}catch(Exception e){
   	    this.folio = -1;
   	}
         
       }

    /**
     * @return the quiencaptura
     */
    public String getQuiencaptura() {
        return quiencaptura;
    }

    /**
     * @param quiencaptura the quiencaptura to set
     */
    public void setQuiencaptura(String quiencaptura) {
        this.quiencaptura = quiencaptura;
    }

    /**
     * @return the fechacaptura
     */
    public String getFechacaptura() {
        return fechacaptura;
    }

    /**
     * @param fechacaptura the fechacaptura to set
     */
    public void setFechacaptura(String fechacaptura) {
        this.fechacaptura = fechacaptura;
    }

    /**
     * @return the quiensolicita
     */
    public String getQuiensolicita() {
        return quiensolicita;
    }

    /**
     * @param quiensolicita the quiensolicita to set
     */
    public void setQuiensolicita(String quiensolicita) {
        this.quiensolicita = quiensolicita;
    }

    /**
     * @return the nombresolicita
     */
    public String getNombresolicita() {
        return nombresolicita;
    }

    /**
     * @param nombresolicita the nombresolicita to set
     */
    public void setNombresolicita(String nombresolicita) {
        this.nombresolicita = nombresolicita;
    }

    /**
     * @return the telefonosolicita
     */
    public String getTelefonosolicita() {
        return telefonosolicita;
    }

    /**
     * @param telefonosolicita the telefonosolicita to set
     */
    public void setTelefonosolicita(String telefonosolicita) {
        this.telefonosolicita = telefonosolicita;
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
     * @return the datosorigen
     */
    public String getDatosorigen() {
        return datosorigen;
    }

    /**
     * @param datosorigen the datosorigen to set
     */
    public void setDatosorigen(String datosorigen) {
        this.datosorigen = datosorigen;
    }

    /**
     * @return the datosdestino
     */
    public String getDatosdestino() {
        return datosdestino;
    }

    /**
     * @param datosdestino the datosdestino to set
     */
    public void setDatosdestino(String datosdestino) {
        this.datosdestino = datosdestino;
    }

    /**
     * @return the tipoproblema
     */
    public String getTipoproblema() {
        return tipoproblema;
    }

    /**
     * @param tipoproblema the tipoproblema to set
     */
    public void setTipoproblema(String tipoproblema) {
        this.tipoproblema = tipoproblema;
    }

    /**
     * @return the depto_que_atiende
     */
    public String getDepto_que_atiende() {
        return depto_que_atiende;
    }

    /**
     * @param depto_que_atiende the depto_que_atiende to set
     */
    public void setDepto_que_atiende(String depto_que_atiende) {
        this.depto_que_atiende = depto_que_atiende;
    }

    /**
     * @return the nombre_quien_atiende
     */
    public String getNombre_quien_atiende() {
        return nombre_quien_atiende;
    }

    /**
     * @param nombre_quien_atiende the nombre_quien_atiende to set
     */
    public void setNombre_quien_atiende(String nombre_quien_atiende) {
        this.nombre_quien_atiende = nombre_quien_atiende;
    }

    /**
     * @return the tiposolucion
     */
    public String getTiposolucion() {
        return tiposolucion;
    }

    /**
     * @param tiposolucion the tiposolucion to set
     */
    public void setTiposolucion(String tiposolucion) {
        this.tiposolucion = tiposolucion;
    }

    /**
     * @return the fechacierre
     */
    public String getFechacierre() {
        return fechacierre;
    }

    /**
     * @param fechacierre the fechacierre to set
     */
    public void setFechacierre(String fechacierre) {
        this.fechacierre = fechacierre;
    }

    /**
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /**
     * @return the comentariocierre
     */
    public String getComentariocierre() {
        return comentariocierre;
    }

    /**
     * @param comentariocierre the comentariocierre to set
     */
    public void setComentariocierre(String comentariocierre) {
        this.comentariocierre = comentariocierre;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
	try{
	    this.tipo = Integer.parseInt(tipo);
	}catch(Exception e){
	    this.tipo = -1;
	}
      
    }

    /**
     * @return the prioridad
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * @return the fecha_asignado_atiende
     */
    public String getFecha_asignado_atiende() {
        return fecha_asignado_atiende;
    }

    /**
     * @param fecha_asignado_atiende the fecha_asignado_atiende to set
     */
    public void setFecha_asignado_atiende(String fecha_asignado_atiende) {
        this.fecha_asignado_atiende = fecha_asignado_atiende;
    }
}
