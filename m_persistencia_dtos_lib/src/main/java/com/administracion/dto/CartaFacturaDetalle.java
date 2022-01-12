/**
 * 
 */
package com.administracion.dto;

import java.io.Serializable;

import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.UtilsStrings;

/**
 * @author aruaro
 *
 */
public class CartaFacturaDetalle implements  Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    int idregistro;
    int idregistrodatos ;
    int cantidad;
    float valor_unitario;
    float valor_total ;
    float voumen;
    float  peso;
    String tipo_mercancia;
    String descripcion_mercancia;
  
    String paqueteid;
    
    String uuid;
    String shipmentid ;
    String fechainsercion;
    String factura;
    String numcompra ;
    String terminosventa ;
    String razonexportacion ;
    String taxid_vat ;
    String nombrecontacto ;
    String callecontacto ;
    String coloniacontacto ;
    String cpcontacto ;
    String ciudadcontacto ;
    String paiscontacto ;
    String telefonocontacto ;
    String declaracion ;
    String instrucciones_especiales ;
    String celularcontacto ;
    String emailcontacto ;
    
   
    String unidad_medida;
    String descripcion;
    String harm_codigo;
    String c_o ;
    
    String iddocumento;
    String idguiacarrier;
  

    /**
     * 
     */
    public CartaFacturaDetalle() {
	// TODO Auto-generated constructor stub
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
    
    public void setIdregistro(String idregistro) {
  	try{
  	    this.idregistro = Integer.parseInt(idregistro);
  	}catch(Exception e){
  	    this.idregistro = 0;
  	}
         
      }

    /**
     * @return the idregistrodatos
     */
    public int getIdregistrodatos() {
        return idregistrodatos;
    }

    /**
     * @param idregistrodatos the idregistrodatos to set
     */
    public void setIdregistrodatos(int idregistrodatos) {
        this.idregistrodatos = idregistrodatos;
    }

    public void setIdregistrodatos(String idregistrodatos) {
  	try{
  	    this.idregistrodatos = Integer.parseInt(idregistrodatos);
  	}catch(Exception e){
  	    this.idregistrodatos = 0;
  	}
         
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

    /**
     * @return the shipmentid
     */
    public String getShipmentid() {
        return shipmentid;
    }

    /**
     * @param shipmentid the shipmentid to set
     */
    public void setShipmentid(String shipmentid) {
        this.shipmentid = UtilsStrings.nullChangeToUpperCase(shipmentid) ;
    }

    /**
     * @return the fechainsercion
     */
    public String getFechainsercion() {
        return fechainsercion;
    }

    /**
     * @param fechainsercion the fechainsercion to set
     */
    public void setFechainsercion(String fechainsercion) {
        this.fechainsercion =  UtilsStrings.nullChangeToUpperCase(fechainsercion) ; 
    }

    /**
     * @return the factura
     */
    public String getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(String factura) {
        this.factura =  UtilsStrings.nullChangeToUpperCase(factura) ; 
    }

    /**
     * @return the numcompra
     */
    public String getNumcompra() {
        return numcompra;
    }

    /**
     * @param numcompra the numcompra to set
     */
    public void setNumcompra(String numcompra) {
        this.numcompra =  UtilsStrings.nullChangeToUpperCase(numcompra) ; 
    }

    /**
     * @return the terminosventa
     */
    public String getTerminosventa() {
        return terminosventa;
    }

    /**
     * @param terminosventa the terminosventa to set
     */
    public void setTerminosventa(String terminosventa) {
        this.terminosventa = UtilsStrings.nullChangeToUpperCase(terminosventa) ;  
    }

    /**
     * @return the razonexportacion
     */
    public String getRazonexportacion() {
        return razonexportacion;
    }

    /**
     * @param razonexportacion the razonexportacion to set
     */
    public void setRazonexportacion(String razonexportacion) {
        this.razonexportacion = UtilsStrings.nullChangeToUpperCase(razonexportacion) ;   
    }

    /**
     * @return the taxid_vat
     */
    public String getTaxid_vat() {
        return taxid_vat;
    }

    /**
     * @param taxid_vat the taxid_vat to set
     */
    public void setTaxid_vat(String taxid_vat) {
        this.taxid_vat = UtilsStrings.nullChangeToUpperCase(taxid_vat) ;  
    }

    /**
     * @return the nombrecontacto
     */
    public String getNombrecontacto() {
        return nombrecontacto;
    }

    /**
     * @param nombrecontacto the nombrecontacto to set
     */
    public void setNombrecontacto(String nombrecontacto) {
        this.nombrecontacto = UtilsStrings.nullChangeToUpperCase(nombrecontacto) ;   
    }

    /**
     * @return the callecontacto
     */
    public String getCallecontacto() {
        return callecontacto;
    }

    /**
     * @param callecontacto the callecontacto to set
     */
    public void setCallecontacto(String callecontacto) {
        this.callecontacto =  UtilsStrings.nullChangeToUpperCase(callecontacto) ;    
    }

    /**
     * @return the coloniacontacto
     */
    public String getColoniacontacto() {
        return coloniacontacto;
    }

    /**
     * @param coloniacontacto the coloniacontacto to set
     */
    public void setColoniacontacto(String coloniacontacto) {
        this.coloniacontacto = UtilsStrings.nullChangeToUpperCase(coloniacontacto) ;     
    }

    /**
     * @return the cpcontacto
     */
    public String getCpcontacto() {
        return cpcontacto;
    }

    /**
     * @param cpcontacto the cpcontacto to set
     */
    public void setCpcontacto(String cpcontacto) {
        this.cpcontacto = UtilsStrings.nullChangeToUpperCase(cpcontacto) ;      
    }

    /**
     * @return the ciudadcontacto
     */
    public String getCiudadcontacto() {
        return ciudadcontacto;
    }

    /**
     * @param ciudadcontacto the ciudadcontacto to set
     */
    public void setCiudadcontacto(String ciudadcontacto) {
        this.ciudadcontacto = UtilsStrings.nullChangeToUpperCase(ciudadcontacto) ;       
    }

    /**
     * @return the paiscontacto
     */
    public String getPaiscontacto() {
        return paiscontacto;
    }

    /**
     * @param paiscontacto the paiscontacto to set
     */
    public void setPaiscontacto(String paiscontacto) {
        this.paiscontacto = UtilsStrings.nullChangeToUpperCase(paiscontacto) ;        
    }

    /**
     * @return the telefonocontacto
     */
    public String getTelefonocontacto() {
        return telefonocontacto;
    }

    /**
     * @param telefonocontacto the telefonocontacto to set
     */
    public void setTelefonocontacto(String telefonocontacto) {
        this.telefonocontacto = UtilsStrings.nullChangeToUpperCase(telefonocontacto) ;  
    }

    /**
     * @return the declaracion
     */
    public String getDeclaracion() {
        return declaracion;
    }

    /**
     * @param declaracion the declaracion to set
     */
    public void setDeclaracion(String declaracion) {
        this.declaracion =UtilsStrings.nullChangeToUpperCase(declaracion) ;  
    }

    /**
     * @return the instrucciones_especiales
     */
    public String getInstrucciones_especiales() {
        return instrucciones_especiales;
    }

    /**
     * @param instrucciones_especiales the instrucciones_especiales to set
     */
    public void setInstrucciones_especiales(String instrucciones_especiales) {
        this.instrucciones_especiales = UtilsStrings.nullChangeToUpperCase(instrucciones_especiales) ;   
    }

    /**
     * @return the celularcontacto
     */
    public String getCelularcontacto() {
        return celularcontacto;
    }

    /**
     * @param celularcontacto the celularcontacto to set
     */
    public void setCelularcontacto(String celularcontacto) {
        this.celularcontacto =  UtilsStrings.nullChangeToUpperCase(celularcontacto) ; 
    }

    /**
     * @return the emailcontacto
     */
    public String getEmailcontacto() {
        return emailcontacto;
    }

    /**
     * @param emailcontacto the emailcontacto to set
     */
    public void setEmailcontacto(String emailcontacto) {
        this.emailcontacto =  UtilsStrings.nullChangeToUpperCase(emailcontacto) ;  
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(String cantidad) {
  	try{
  	    this.cantidad = Integer.parseInt(cantidad);
  	}catch(Exception e){
  	    this.cantidad = 0;
  	}
         
      }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the unidad_medida
     */
    public String getUnidad_medida() {
        return unidad_medida;
    }

    /**
     * @param unidad_medida the unidad_medida to set
     */
    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida =  UtilsStrings.nullChangeToUpperCase(unidad_medida) ;   
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = UtilsStrings.nullChangeToUpperCase(descripcion) ;   
    }

    /**
     * @return the harm_codigo
     */
    public String getHarm_codigo() {
        return harm_codigo;
    }

    /**
     * @param harm_codigo the harm_codigo to set
     */
    public void setHarm_codigo(String harm_codigo) {
        this.harm_codigo = UtilsStrings.nullChangeToUpperCase(harm_codigo) ;    
    }

    /**
     * @return the c_o
     */
    public String getC_o() {
        return c_o;
    }

    /**
     * @param c_o the c_o to set
     */
    public void setC_o(String c_o) {
        this.c_o = UtilsStrings.nullChangeToUpperCase(c_o) ;  
    }

    /**
     * @return the valor_unitario
     */
    public float getValor_unitario() {
        return valor_unitario;
    }

    /**
     * @param valor_unitario the valor_unitario to set
     */
    public void setValor_unitario(float valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public void setValor_unitario(String valor_unitario) {
  	try{
  	    this.valor_unitario = Float.parseFloat(valor_unitario);
  	}catch(Exception e){
  	    this.valor_unitario = 0;
  	}
         
      }
    
    /**
     * @return the valor_total  
     */
    public float getValor_total() {
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValor_total(float valor_total) {
	
        this.valor_total = valor_total;
    }

    
    public void setValor_total(String valor_total) {
	try{
	    this.valor_total = Float.parseFloat(valor_total);
	}catch(Exception e){
	    this.valor_total = 0;
	}
       
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
     * @return the idguiacarrier
     */
    public String getIdguiacarrier() {
        return idguiacarrier;
    }

    /**
     * @param idguiacarrier the idguiacarrier to set
     */
    public void setIdguiacarrier(String idguiacarrier) {
        this.idguiacarrier = idguiacarrier;
    }

	public float getVoumen() {
		return voumen;
	}

	public void setVoumen(float voumen) {
		this.voumen = voumen;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getTipo_mercancia() {
		return tipo_mercancia;
	}

	public void setTipo_mercancia(String tipo_mercancia) {
		this.tipo_mercancia = tipo_mercancia;
	}

	public String getDescripcion_mercancia() {
		return descripcion_mercancia;
	}

	public void setDescripcion_mercancia(String descripcion_mercancia) {
		this.descripcion_mercancia = descripcion_mercancia;
	}

	public String getPaqueteid() {
		return paqueteid;
	}

	public void setPaqueteid(String paqueteid) {
		this.paqueteid = paqueteid;
	}
}
