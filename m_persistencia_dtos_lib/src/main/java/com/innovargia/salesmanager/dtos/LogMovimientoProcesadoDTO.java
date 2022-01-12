/**
 * 
 */
package com.innovargia.salesmanager.dtos;

import java.io.Serializable;

/**
 * @author aruaro
 * 
 */
public class LogMovimientoProcesadoDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    String plazaenvia;
    String servidor;
    String cliente;
    String archivo;
    String transmitido;
    String fechaproceso;
    String guia;
    String msgstatus;
    String tipoerror;
    String llavetransmision;
    String manifiesto;
    String ruta;
    String tramo;
    String depto;
    String viaje;
    String registro;
    String login;
    
    String tipomovimiento;
   
    int cantidad;
    
    int identificador;
    int top=100;
    
    boolean soloregistrosconerror=true;
    /**
     * @return the plazaenvia
     */
    public String getPlazaenvia() {
        return plazaenvia;
    }
    /**
     * @param plazaenvia the plazaenvia to set
     */
    public void setPlazaenvia(String plazaenvia) {
        this.plazaenvia = plazaenvia;
    }
    /**
     * @return the servidor
     */
    public String getServidor() {
        return servidor;
    }
    /**
     * @param servidor the servidor to set
     */
    public void setServidor(String servidor) {
        this.servidor = servidor;
    }
    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }
    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    /**
     * @return the archivo
     */
    public String getArchivo() {
        return archivo;
    }
    /**
     * @param archivo the archivo to set
     */
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    /**
     * @return the transmitido
     */
    public String getTransmitido() {
        return transmitido;
    }
    /**
     * @param transmitido the transmitido to set
     */
    public void setTransmitido(String transmitido) {
        this.transmitido = transmitido;
    }
    /**
     * @return the fechaproceso
     */
    public String getFechaproceso() {
        return fechaproceso;
    }
    /**
     * @param fechaproceso the fechaproceso to set
     */
    public void setFechaproceso(String fechaproceso) {
        this.fechaproceso = fechaproceso;
    }
    /**
     * @return the guia
     */
    public String getGuia() {
        return guia;
    }
    /**
     * @param guia the guia to set
     */
    public void setGuia(String guia) {
        this.guia = guia;
    }
    /**
     * @return the msgstatus
     */
    public String getMsgstatus() {
        return msgstatus;
    }
    /**
     * @param msgstatus the msgstatus to set
     */
    public void setMsgstatus(String msgstatus) {
        this.msgstatus = msgstatus;
    }
    /**
     * @return the tipoerror
     */
    public String getTipoerror() {
        return tipoerror;
    }
    /**
     * @param tipoerror the tipoerror to set
     */
    public void setTipoerror(String tipoerror) {
        this.tipoerror = tipoerror;
    }
    /**
     * @return the llavetransmision
     */
    public String getLlavetransmision() {
        return llavetransmision;
    }
    /**
     * @param llavetransmision the llavetransmision to set
     */
    public void setLlavetransmision(String llavetransmision) {
        this.llavetransmision = llavetransmision;
    }
    /**
     * @return the id
     */
    public int getIdentificador() {
        return identificador;
    }
    /**
     * @param id the id to set
     */
    public void setIdentificador(int id) {
        this.identificador = id;
    }
    /**
     * @return the top
     */
    public int getTop() {
        return top;
    }
    /**
     * @param top the top to set
     */
    public void setTop(int top) {
        this.top = top;
    }
    /**
     * @return the tipomovimiento
     */
    public String getTipomovimiento() {
        return tipomovimiento;
    }
    /**
     * @param tipomovimiento the tipomovimiento to set
     */
    public void setTipomovimiento(String tipomovimiento) {
        this.tipomovimiento = tipomovimiento;
    }
    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * @return the manifiesto
     */
    public String getManifiesto() {
        return manifiesto;
    }
    /**
     * @param manifiesto the manifiesto to set
     */
    public void setManifiesto(String manifiesto) {
        this.manifiesto = manifiesto;
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
     * @return the depto
     */
    public String getDepto() {
        return depto;
    }
    /**
     * @param depto the depto to set
     */
    public void setDepto(String depto) {
        this.depto = depto;
    }
    /**
     * @return the viaje
     */
    public String getViaje() {
        return viaje;
    }
    /**
     * @param viaje the viaje to set
     */
    public void setViaje(String viaje) {
        this.viaje = viaje;
    }
    /**
     * @return the registro
     */
    public String getRegistro() {
        return registro;
    }
    /**
     * @param registro the registro to set
     */
    public void setRegistro(String registro) {
        this.registro = registro;
    }
    /**
     * @return the tramo
     */
    public String getTramo() {
        return tramo;
    }
    /**
     * @param tramo the tramo to set
     */
    public void setTramo(String tramo) {
        this.tramo = tramo;
    }
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }
    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * @return the soloregistrosconerror
     */
    public boolean isSoloregistrosconerror() {
        return soloregistrosconerror;
    }
    /**
     * @param soloregistrosconerror the soloregistrosconerror to set
     */
    public void setSoloregistrosconerror(boolean soloregistrosconerror) {
        this.soloregistrosconerror = soloregistrosconerror;
    }
    
    

}
