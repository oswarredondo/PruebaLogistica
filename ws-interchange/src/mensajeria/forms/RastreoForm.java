/* $Id: $
 * Nombre del Proyecto:
 * Nombre del Programa: RemDes.java
 * Responsable: Adrián Morales Ruaro
 * Descripcion: Datos de Cliente que puedxcen ser utilizados en destinos
 * o remitentes
 *
 *$Log:$
 */
package mensajeria.forms;
 
//Imports
//import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletInputStream;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *<CODE>
 * Datos de un cliente o un remitente
 *</CODE>
 *
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
//public class RemDes implements Serializable, Cloneable {
public class RastreoForm implements Serializable  {
    
    private ArrayList lista = new ArrayList();
    /**Mensaje*/
    private String mensaje;
    /** Identificador del cliente usuario de la sesion activa*/
    private String numCliente;
    /** Identificador del envio del reporte*/
    private String idEnvio;
    /**  Nombre de la persona que reportal     */
    private String quienReporta;
    /** Creado por, login de la persona que crea el reporte */
    private String creadoPor;
    /** Login de la persona que cierra el reporte*/
    private String cerradoPOr;
    /**Fecha en que se crea el reporte   */
    private String fechaCreacion;
    /** Fecha en que se cierra el reporte*/
    private String fechaCierre;
    
    /**Login de la persona que agrega el historial de rastreo*/
    private String loginHistoria; 
    
    /**Numero de reporte*/
    private String numReporte;
    
    /**Identificador del tipo de requerimiento*/
    private int idRequerimientos;
    
    /***Descripcio n del tipo de requerimientos*/
    private String decripcionRequerimientos;
    
    /**Identificaodr de tipo de cierre*/
    private int idCierre;
    /**Decripcion del tipo de cierre*/
    private String descripcionTipoCierre;
    
    /**Historia*/
    private String historia;
    
    /**Siglas del origen*/
    private String origen;
    /**Siglas del destrino*/
    private String destino;
    
    
    
    /**
     * Getter for property descripcionTipoCierre.
     * @return Value of property descripcionTipoCierre.
     */
    public java.lang.String getDescripcionTipoCierre() {
        return descripcionTipoCierre;
    }    
    
    /**
     * Setter for property descripcionTipoCierre.
     * @param descripcionTipoCierre New value of property descripcionTipoCierre.
     */
    public void setDescripcionTipoCierre(java.lang.String descripcionTipoCierre) {
        this.descripcionTipoCierre = descripcionTipoCierre;
    }
    
    /**
     * Getter for property idCierre.
     * @return Value of property idCierre.
     */
    public int getIdCierre() {
        return idCierre;
    }
    
    /**
     * Setter for property idCierre.
     * @param idCierre New value of property idCierre.
     */
    public void setIdCierre(int idCierre) {
        this.idCierre = idCierre;
    }
    
    /**
     * Getter for property decripcionRequerimientos.
     * @return Value of property decripcionRequerimientos.
     */
    public java.lang.String getDecripcionRequerimientos() {
        return decripcionRequerimientos;
    }
    
    /**
     * Setter for property decripcionRequerimientos.
     * @param decripcionRequerimientos New value of property decripcionRequerimientos.
     */
    public void setDecripcionRequerimientos(java.lang.String decripcionRequerimientos) {
        this.decripcionRequerimientos = decripcionRequerimientos;
    }
    
    /**
     * Getter for property lista.
     * @return Value of property lista.
     */
    public java.util.ArrayList getLista() {
        return lista;
    }
    
    /**
     * Setter for property lista.
     * @param lista New value of property lista.
     */
    public void setLista(java.util.ArrayList lista) {
        this.lista = lista;
    }
    
    /**
     * Getter for property mensaje.
     * @return Value of property mensaje.
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }
    
    /**
     * Setter for property mensaje.
     * @param mensaje New value of property mensaje.
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }
    
    /**
     * Getter for property numCliente.
     * @return Value of property numCliente.
     */
    public java.lang.String getNumCliente() {
        return numCliente;
    }
    
    /**
     * Setter for property numCliente.
     * @param numCliente New value of property numCliente.
     */
    public void setNumCliente(java.lang.String numCliente) {
        this.numCliente = numCliente;
    }
    
    /**
     * Getter for property idEnvio.
     * @return Value of property idEnvio.
     */
    public java.lang.String getIdEnvio() {
        return idEnvio;
    }
    
    /**
     * Setter for property idEnvio.
     * @param idEnvio New value of property idEnvio.
     */
    public void setIdEnvio(java.lang.String idEnvio) {
        this.idEnvio = idEnvio;
    }
    
    /**
     * Getter for property quienReporta.
     * @return Value of property quienReporta.
     */
    public java.lang.String getQuienReporta() {
        return quienReporta;
    }
    
    /**
     * Setter for property quienReporta.
     * @param quienReporta New value of property quienReporta.
     */
    public void setQuienReporta(java.lang.String quienReporta) {
        this.quienReporta = quienReporta;
    }
    
    /**
     * Getter for property creadoPor.
     * @return Value of property creadoPor.
     */
    public java.lang.String getCreadoPor() {
        return creadoPor;
    }
    
    /**
     * Setter for property creadoPor.
     * @param creadoPor New value of property creadoPor.
     */
    public void setCreadoPor(java.lang.String creadoPor) {
        this.creadoPor = creadoPor;
    }
    
    /**
     * Getter for property cerradoPOr.
     * @return Value of property cerradoPOr.
     */
    public java.lang.String getCerradoPOr() {
        return cerradoPOr;
    }
    
    /**
     * Setter for property cerradoPOr.
     * @param cerradoPOr New value of property cerradoPOr.
     */
    public void setCerradoPOr(java.lang.String cerradoPOr) {
        this.cerradoPOr = cerradoPOr;
    }
    
    /**
     * Getter for property fechaCreacion.
     * @return Value of property fechaCreacion.
     */
    public java.lang.String getFechaCreacion() {
        return fechaCreacion;
    }
    
    /**
     * Setter for property fechaCreacion.
     * @param fechaCreacion New value of property fechaCreacion.
     */
    public void setFechaCreacion(java.lang.String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    /**
     * Getter for property fechaCierre.
     * @return Value of property fechaCierre.
     */
    public java.lang.String getFechaCierre() {
        return fechaCierre;
    }
    
    /**
     * Setter for property fechaCierre.
     * @param fechaCierre New value of property fechaCierre.
     */
    public void setFechaCierre(java.lang.String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
    
    /**
     * Getter for property idRequerimientos.
     * @return Value of property idRequerimientos.
     */
    public int getIdRequerimientos() {
        return idRequerimientos;
    }
    
    /**
     * Setter for property idRequerimientos.
     * @param idRequerimientos New value of property idRequerimientos.
     */
    public void setIdRequerimientos(int idRequerimientos) {
        this.idRequerimientos = idRequerimientos;
    }
    
    /**
     * Getter for property historia.
     * @return Value of property historia.
     */
    public java.lang.String getHistoria() {
        return historia;
    }
    
    /**
     * Setter for property historia.
     * @param historia New value of property historia.
     */
    public void setHistoria(java.lang.String historia) {
        this.historia = historia;
    }
    
    /**
     * Getter for property numReporte.
     * @return Value of property numReporte.
     */
    public java.lang.String getNumReporte() {
        return numReporte;
    }
    
    /**
     * Setter for property numReporte.
     * @param numReporte New value of property numReporte.
     */
    public void setNumReporte(java.lang.String numReporte) {
        this.numReporte = numReporte;
    }
    
    /**
     * Getter for property origen.
     * @return Value of property origen.
     */
    public java.lang.String getOrigen() {
        return origen;
    }
    
    /**
     * Setter for property origen.
     * @param origen New value of property origen.
     */
    public void setOrigen(java.lang.String origen) {
        this.origen = origen;
    }
    
    /**
     * Getter for property destino.
     * @return Value of property destino.
     */
    public java.lang.String getDestino() {
        return destino;
    }
    
    /**
     * Setter for property destino.
     * @param destino New value of property destino.
     */
    public void setDestino(java.lang.String destino) {
        this.destino = destino;
    }
    
    /**
     * Getter for property loginHistoria.
     * @return Value of property loginHistoria.
     */
    public java.lang.String getLoginHistoria() {
        return loginHistoria;
    }
    
    /**
     * Setter for property loginHistoria.
     * @param loginHistoria New value of property loginHistoria.
     */
    public void setLoginHistoria(java.lang.String loginHistoria) {
        this.loginHistoria = loginHistoria;
    }
    
} // fin RastreoForm
