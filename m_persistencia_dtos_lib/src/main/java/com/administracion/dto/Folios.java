/* $Id: $
 * Nombre del Proyecto: IETWeb
 * Nombre del Programa: Folios.java
 * Responsable: Adri�n Morales Ruaro
 * Descripcion: Contiene los datos de los folios asignados a un cliente en la impresion WEB
 *
 *$Log:$
 */
package com.administracion.dto;

import java.io.Serializable;
import java.util.ArrayList;




/**
 *<CODE>
 * Datos de un folio
 *</CODE>
 *
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
public class Folios implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Entidad entidad = new Entidad();
	public Organizacion organizacion = new Organizacion();
    
    /**
     * Indica la lista de proyectos, horas, etc del usuario
     */
    public ArrayList folios = new ArrayList();
    /**Numero del cliente del que pertenecen los folios*/
    private String numCliente;
    /**Identificador del Servicio*/
    private String idServicio;
    /**Descripcion del Servicio*/
    private String descripcionServicio;
    /**Cantidad Asignada a folio*/
    private int cantidadAsignada;
    /**Cantidad Utilizada del folio*/
    private int cantidadUtilizada;
    /**Rango Encriptado del cliente*/
    private String rangoEncriptado;
    
    private String tipoRotulacion;
     
    /**Consecutivo inicial*/
    private int consecutivoInicial;
    /**Consecutivo final*/
    private int consecutivoFinal;
    
    private int idconveniodetalle;
    private String tipo_contrato;
    private String siglas_oficina_control;
    private int idoficinacontrol;
    
    /**Clave con la que fue creado el rango de la PC*/
    private String cveUnica;
    
    /**Fecha de creacion del rango*/
    private String fechaCreacion;
    
    /**Forma de pago*/
    private String formaPago;
    
    /**Descripcion forma de Pago*/
    private String descripcionFormaPago;

    /**Factura asignada o nota de credito*/
    private String factura;
    
    /**Peso asignado al rango seleccionado*/
    private int peso;
    
    
    private int idregistro;
    
    public Folios(){}
    public Folios(String numCliente,String idServicio,String descripcionServicio,int cantidadAsignada,int cantidadUtilizada){
        this.numCliente = numCliente;
        this.idServicio = idServicio;
        this.descripcionServicio = descripcionServicio;
        this.cantidadAsignada = cantidadAsignada;
        this.cantidadUtilizada = cantidadUtilizada;
    }
    public Folios(String numCliente,String idServicio,String descripcionServicio,int cantidadAsignada,int cantidadUtilizada,int peso){
        this.numCliente = numCliente;
        this.idServicio = idServicio;
        this.descripcionServicio = descripcionServicio;
        this.cantidadAsignada = cantidadAsignada;
        this.cantidadUtilizada = cantidadUtilizada;
        this.peso = peso;
    }    
    public Folios(String numCliente,String idServicio,int cantidadAsignada,int cantidadUtilizada){
        this.numCliente = numCliente;
        this.idServicio = idServicio;
        this.cantidadAsignada = cantidadAsignada;
        this.cantidadUtilizada = cantidadUtilizada;
    }
    
    public int getDisponibles(){
        return (cantidadAsignada-cantidadUtilizada);
    }
  
    
    /**
     * Getter for property folios.
     * @return Value of property folios.
     */
    public java.util.ArrayList getFolios() {
        return folios;
    }    
    
    /**
     * Setter for property folios.
     * @param folios New value of property folios.
     */
    public void setFolios(java.util.ArrayList folios) {
        this.folios = folios;
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
     * Getter for property idServicio.
     * @return Value of property idServicio.
     */
    public java.lang.String getIdServicio() {
        return idServicio;
    }
    
    /**
     * Setter for property idServicio.
     * @param idServicio New value of property idServicio.
     */
    public void setIdServicio(java.lang.String idServicio) {
        this.idServicio = idServicio;
    }
    
    /**
     * Getter for property descripcionServicio.
     * @return Value of property descripcionServicio.
     */
    public java.lang.String getDescripcionServicio() {
        return descripcionServicio;
    }
    
    /**
     * Setter for property descripcionServicio.
     * @param descripcionServicio New value of property descripcionServicio.
     */
    public void setDescripcionServicio(java.lang.String descripcionServicio) {
        this.descripcionServicio = descripcionServicio;
    }
    
    /**
     * Getter for property cantidadAsignada.
     * @return Value of property cantidadAsignada.
     */
    public int getCantidadAsignada() {
        return cantidadAsignada;
    }
    
    /**
     * Setter for property cantidadAsignada.
     * @param cantidadAsignada New value of property cantidadAsignada.
     */
    public void setCantidadAsignada(int cantidadAsignada) {
        this.cantidadAsignada = cantidadAsignada;
    }
     
    /**
     * Getter for property cantidadUtilizada.
     * @return Value of property cantidadUtilizada.
     */
    public int getCantidadUtilizada() {
        return cantidadUtilizada;
    }
    
    /**
     * Setter for property cantidadUtilizada.
     * @param cantidadUtilizada New value of property cantidadUtilizada.
     */
    public void setCantidadUtilizada(int cantidadUtilizada) {
        this.cantidadUtilizada = cantidadUtilizada;
    }
    
    /**
     * Getter for property rangoEncriptado.
     * @return Value of property rangoEncriptado.
     */
    public java.lang.String getRangoEncriptado() {
        return rangoEncriptado;
    }
    
    /**
     * Setter for property rangoEncriptado.
     * @param rangoEncriptado New value of property rangoEncriptado.
     */
    public void setRangoEncriptado(java.lang.String rangoEncriptado) {
        this.rangoEncriptado = rangoEncriptado;
    }
    
    /**
     * Getter for property peso.
     * @return Value of property peso.
     */
    public int getPeso() {
        return peso;
    }
    
    /**
     * Setter for property peso.
     * @param peso New value of property peso.
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    /**
     * Getter for property formaPago. 
     * @return Value of property formaPago.
     */
    public java.lang.String getFormaPago() {
        return formaPago;
    }
    
    /**
     * Setter for property formaPago.
     * @param formaPago New value of property formaPago.
     */
    public void setFormaPago(java.lang.String formaPago) {
        this.formaPago = formaPago;
    }
    
    /**
     * Getter for property descripcionFormaPago.
     * @return Value of property descripcionFormaPago.
     */
    public java.lang.String getDescripcionFormaPago() {
        return descripcionFormaPago;
    }
    
    /**
     * Setter for property descripcionFormaPago.
     * @param descripcionFormaPago New value of property descripcionFormaPago.
     */
    public void setDescripcionFormaPago(java.lang.String descripcionFormaPago) {
        this.descripcionFormaPago = descripcionFormaPago;
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
     * Getter for property cveUnica.
     * @return Value of property cveUnica.
     */
    public java.lang.String getCveUnica() {
        return cveUnica;
    }
    
    /**
     * Setter for property cveUnica.
     * @param cveUnica New value of property cveUnica.
     */
    public void setCveUnica(java.lang.String cveUnica) {
        this.cveUnica = cveUnica;
    } 
    
    /** 
     * Getter for property consecutivoInicial.
     * @return Value of property consecutivoInicial.
     */
    public int getConsecutivoInicial() {
        return consecutivoInicial;
    }
    
    /**
     * Setter for property consecutivoInicial.
     * @param consecutivoInicial New value of property consecutivoInicial.
     */
    public void setConsecutivoInicial(int consecutivoInicial) {
        this.consecutivoInicial = consecutivoInicial;
    }
    
    /**
     * Getter for property consecutivoFinal.
     * @return Value of property consecutivoFinal.
     */
    public int getConsecutivoFinal() {
        return consecutivoFinal;
    }
    
    /**
     * Setter for property consecutivoFinal.
     * @param consecutivoFinal New value of property consecutivoFinal.
     */
    public void setConsecutivoFinal(int consecutivoFinal) {
        this.consecutivoFinal = consecutivoFinal;
    }
    
    /**
     * Getter for property factura.
     * @return Value of property factura.
     */
    public java.lang.String getFactura() {
        return factura;
    }
    
    /**
     * Setter for property factura.
     * @param factura New value of property factura.
     */
    public void setFactura(java.lang.String factura) {
        this.factura = factura;
    }
	/**
	 * @return the tipoRotulacion
	 */
	public String getTipoRotulacion() {
		return tipoRotulacion;
	}
	/**
	 * @param tipoRotulacion the tipoRotulacion to set
	 */
	public void setTipoRotulacion(String tipoRotulacion) {
		this.tipoRotulacion = tipoRotulacion;
	}
	/**
	 * @return the idconveniodetalle
	 */
	public int getIdconveniodetalle() {
		return idconveniodetalle;
	}
	/**
	 * @param idconveniodetalle the idconveniodetalle to set
	 */
	public void setIdconveniodetalle(int idconveniodetalle) {
		this.idconveniodetalle = idconveniodetalle;
	}
	/**
	 * @return the organizacion
	 */
	public Organizacion getOrganizacion() {
	    return organizacion;
	}
	/**
	 * @return the tipo_contrato
	 */
	public String getTipo_contrato() {
	    return tipo_contrato;
	}
	/**
	 * @return the siglas_oficina_control
	 */
	public String getSiglas_oficina_control() {
	    return siglas_oficina_control;
	}
	/**
	 * @return the idoficinacontrol
	 */
	public int getIdoficinacontrol() {
	    return idoficinacontrol;
	}
	/**
	 * @param organizacion the organizacion to set
	 */
	public void setOrganizacion(Organizacion organizacion) {
	    this.organizacion = organizacion;
	}
	/**
	 * @param tipo_contrato the tipo_contrato to set
	 */
	public void setTipo_contrato(String tipo_contrato) {
	    this.tipo_contrato = tipo_contrato;
	}
	/**
	 * @param siglas_oficina_control the siglas_oficina_control to set
	 */
	public void setSiglas_oficina_control(String siglas_oficina_control) {
	    this.siglas_oficina_control = siglas_oficina_control;
	}
	/**
	 * @param idoficinacontrol the idoficinacontrol to set
	 */
	public void setIdoficinacontrol(int idoficinacontrol) {
	    this.idoficinacontrol = idoficinacontrol;
	}
	/**
	 * @return the idregistro
	 */
	public int getIdregistro() {
		return idregistro;
	}
	/**
	 * @param idregistro the idregistro to set
	 */
	public void setIdregistro(int idregistro) {
		this.idregistro = idregistro;
	}
    
} // fin Envio
