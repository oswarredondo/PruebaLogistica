/**
 * 
 */
package com.administracion.dto;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class VentaDTO implements Serializable  {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    int idventa;
    int idtipoventa;
    int idclientefactura;
    String fecha;
    String fecha_cambio_estatus;
    float subtotal ;
    float iva;
    float descuento ;
    float total;
    String login;
    int estatus ;
    boolean solicita_factura ;
    String idformapago;
    String banco_tarjeta ;
    String numero_tarjeta ;
    String fecha_venc_tarjeta;
    String idoficina;
    String observacion;
    String cliente_a_facturar;
    String nacional ="NACIONAL";
    int tiene_servicio;
    float tipocambio;
    String tipoventa;
    String uuid;
    int idfoliooficina;
    
    /**
     * 
     */
    public VentaDTO() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @return the idventa
     */
    public int getIdventa() {
        return idventa;
    }

    /**
     * @param idventa the idventa to set
     */
    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }
    public void setIdventa(String idventa) {
    	try{
    		  this.idventa = Integer.parseInt(idventa);
    	}catch(Exception e){
    		 this.idventa=-1;
    	}
      
    }
  

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the subtotal
     */
    public float getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    public void setSubtotal(String subtotal) {
	   try{
	        this.subtotal = Float.parseFloat(subtotal);
	    }catch(Exception e){
	        this.subtotal = 0;
	    }
    }
    
 
    
    /**
     * @return the iva
     */
    public float getIva() {
        return iva;
    }

    /**
     * @param iva the iva to set
     */
    public void setIva(float iva) {
        this.iva = iva;
    }
    
    public void setIva(String iva) {
	   try{
	        this.iva = Float.parseFloat(iva);
	    }catch(Exception e){
	        this.iva = 0;
	    }
    }

    /**
     * @return the descuento
     */
    public float getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public void setDescuento(String descuento) {
	   try{
	        this.descuento = Float.parseFloat(descuento);
	    }catch(Exception e){
	        this.descuento = 0;
	    }
    }
    
    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
       
        try{
            this.total = Float.parseFloat(total);
        }catch(Exception e){
            this.total = 0;
        }
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
     * @return the estatus
     */
    public int getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    /**
     * @return the solicita_factura
     */
    public boolean getSolicita_factura() {
        return solicita_factura;
    }

    /**
     * @param solicita_factura the solicita_factura to set
     */
    public void setSolicita_factura(boolean solicita_factura) {
        this.solicita_factura = solicita_factura;
      
    }

    public void setSolicita_factura(String solicita_factura) {
	if (solicita_factura==null){
	    this.solicita_factura = false;
	}else{
	    String valor = solicita_factura.trim().toLowerCase();
	    if ( ("on".equals(valor)) ||
		 ("si".equals(valor)) || 
		 ("yes".equals(valor)) || 
		 ("true".equals(valor))|| 
		 ("t".equals(valor))|| 
		 ("y".equals(valor))|| 
		 ("s".equals(valor))|| 
	 	("1".equals(valor))    ){
		 this.solicita_factura = true;
	    }else{
		 this.solicita_factura = false;
	    }
	}
       
      
    }
    /**
     * @return the idformapago
     */
    public String getIdformapago() {
        return idformapago;
    }

    /**
     * @param idformapago the idformapago to set
     */
    public void setIdformapago(String idformapago) {
        this.idformapago = idformapago;
    }

    /**
     * @return the banco_tarjeta
     */
    public String getBanco_tarjeta() {
        return banco_tarjeta;
    }

    /**
     * @param banco_tarjeta the banco_tarjeta to set
     */
    public void setBanco_tarjeta(String banco_tarjeta) {
        this.banco_tarjeta = banco_tarjeta;
    }

    /**
     * @return the numero_tarjeta
     */
    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    /**
     * @param numero_tarjeta the numero_tarjeta to set
     */
    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    /**
     * @return the fecha_venc_tarjeta
     */
    public String getFecha_venc_tarjeta() {
        return fecha_venc_tarjeta;
    }

    /**
     * @param fecha_venc_tarjeta the fecha_venc_tarjeta to set
     */
    public void setFecha_venc_tarjeta(String fecha_venc_tarjeta) {
        this.fecha_venc_tarjeta = fecha_venc_tarjeta;
    }

    /**
     * @return the idoficina
     */
    public String getIdoficina() {
        return idoficina;
    }

    /**
     * @param idoficina the idoficina to set
     */
    public void setIdoficina(String idoficina) {
        this.idoficina = idoficina;
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
     * @return the fecha_cambio_estatus
     */
    public String getFecha_cambio_estatus() {
        return fecha_cambio_estatus;
    }

    /**
     * @param fecha_cambio_estatus the fecha_cambio_estatus to set
     */
    public void setFecha_cambio_estatus(String fecha_cambio_estatus) {
        this.fecha_cambio_estatus = fecha_cambio_estatus;
    }

    /**
     * @return the idclientefactura
     */
    public int getIdclientefactura() {
        return idclientefactura;
    }

    /**
     * @param idclientefactura the idclientefactura to set
     */
    public void setIdclientefactura(int idclientefactura) {
        this.idclientefactura = idclientefactura;
    }

    public void setIdclientefactura(String idclientefactura) {
	try{
	    this.idclientefactura = Integer.parseInt(idclientefactura);
	}catch(Exception e){
	    this.idclientefactura = 0;
	}
        
    }

    /**
     * @return the tiene_servicio
     */
    public int getTiene_servicio() {
        return tiene_servicio;
    }

    /**
     * @param tiene_servicio the tiene_servicio to set
     */
    public void setTiene_servicio(int tiene_servicio) {
        this.tiene_servicio = tiene_servicio;
    }

    /**
     * @return the cliente_a_facturar
     */
    public String getCliente_a_facturar() {
        return cliente_a_facturar;
    }

    /**
     * @param cliente_a_facturar the cliente_a_facturar to set
     */
    public void setCliente_a_facturar(String cliente_a_facturar) {
        this.cliente_a_facturar = cliente_a_facturar;
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
     * @return the tipocambio
     */
    public float getTipocambio() {
        return tipocambio;
    }

    /**
     * @param tipocambio the tipocambio to set
     */
    public void setTipocambio(float tipocambio) {
        this.tipocambio = tipocambio;
    }

    /**
     * @return the tipoventa
     */
    public String getTipoventa() {
        return tipoventa;
    }

    /**
     * @param tipoventa the tipoventa to set
     */
    public void setTipoventa(String tipoventa) {
        this.tipoventa = tipoventa;
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

	public int getIdtipoventa() {
		return idtipoventa;
	}

	public void setIdtipoventa(int idtipoventa) {
		this.idtipoventa = idtipoventa;
	}

	public int getIdfoliooficina() {
		return idfoliooficina;
	}

	public void setIdfoliooficina(int idfoliooficina) {
		this.idfoliooficina = idfoliooficina;
	}
	
	public void setIdfoliooficina(String idfoliooficina) {
    	try{
    		  this.idfoliooficina = Integer.parseInt(idfoliooficina);
    	}catch(Exception e){
    		 this.idfoliooficina=-1;
    	}
      
    }
    
}
