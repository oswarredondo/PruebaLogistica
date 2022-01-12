/**
 * 
 */
package com.administracion.dto;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class CotizacionTarifa implements Serializable{
    	/**
     * 
     */
    private static final long serialVersionUID = 1L;
	int idtarifa ;
	int idconvenio ;
	int idtarifapeso  ;
	int idserviciotarifa ;
	int idserviciotarifazona;
	int idrangoenvios;
	int idconveniodetalle;
	
	float volumenamparado;
	float pesoamparado; 
	float pesoinicial;
	float pesofinal;
	int estatus  ;
	int idrangoinicial;
	int idrangofinal;
	float kminicial;
	float kmfinal;
	float precio;
	float sobrepeso;
	float preciokgsp;
	float pesovolumetrico;
	float precioadicional;
	float preciodolares;
	float tipocambiodolar;
	float totalprecioenvios;
	float totalsobrepeso;

	
	String descripciontarifa;
	String garantiamaxina;
	String nombre;
	String descripciongarantiamaxima;
	String formapago;
	String idtipoventa;
	String cporigen; 
	String cpdestino;
	String garantia;
	float kilometros;
	String zona;
	float preciounitarioporkm;
	int cantidadenvios; 
	String esinternacional="NO";
	String idservicio;
	String contrato;


    /**
     * 
     */
    public CotizacionTarifa() {
	// TODO Auto-generated constructor stub
    }



    /**
     * @return the idtarifa
     */
    public int getIdtarifa() {
        return idtarifa;
    }



    /**
     * @param idtarifa the idtarifa to set
     */
    public void setIdtarifa(int idtarifa) {
        this.idtarifa = idtarifa;
    }



    /**
     * @return the idtarifapeso
     */
    public int getIdtarifapeso() {
        return idtarifapeso;
    }



    /**
     * @param idtarifapeso the idtarifapeso to set
     */
    public void setIdtarifapeso(int idtarifapeso) {
        this.idtarifapeso = idtarifapeso;
    }



    /**
     * @return the idserviciotarifa
     */
    public int getIdserviciotarifa() {
        return idserviciotarifa;
    }



    /**
     * @param idserviciotarifa the idserviciotarifa to set
     */
    public void setIdserviciotarifa(int idserviciotarifa) {
        this.idserviciotarifa = idserviciotarifa;
    }



    /**
     * @return the idserviciotarifazona
     */
    public int getIdserviciotarifazona() {
        return idserviciotarifazona;
    }



    /**
     * @param idserviciotarifazona the idserviciotarifazona to set
     */
    public void setIdserviciotarifazona(int idserviciotarifazona) {
        this.idserviciotarifazona = idserviciotarifazona;
    }



    /**
     * @return the idrangoenvios
     */
    public int getIdrangoenvios() {
        return idrangoenvios;
    }



    /**
     * @param idrangoenvios the idrangoenvios to set
     */
    public void setIdrangoenvios(int idrangoenvios) {
        this.idrangoenvios = idrangoenvios;
    }



    /**
     * @return the pesoamparado
     */
    public float getPesoamparado() {
        return pesoamparado;
    }



    /**
     * @param pesoamparado the pesoamparado to set
     */
    public void setPesoamparado(float pesoamparado) {
        this.pesoamparado = pesoamparado;
    }



    /**
     * @return the pesoinicial
     */
    public float getPesoinicial() {
        return pesoinicial;
    }



    /**
     * @param pesoinicial the pesoinicial to set
     */
    public void setPesoinicial(float pesoinicial) {
        this.pesoinicial = pesoinicial;
    }



    /**
     * @return the pesofinal
     */
    public float getPesofinal() {
        return pesofinal;
    }



    /**
     * @param pesofinal the pesofinal to set
     */
    public void setPesofinal(float pesofinal) {
        this.pesofinal = pesofinal;
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
     * @return the idrangoinicial
     */
    public int getIdrangoinicial() {
        return idrangoinicial;
    }



    /**
     * @param idrangoinicial the idrangoinicial to set
     */
    public void setIdrangoinicial(int idrangoinicial) {
        this.idrangoinicial = idrangoinicial;
    }



    /**
     * @return the idrangofinal
     */
    public int getIdrangofinal() {
        return idrangofinal;
    }



    /**
     * @param idrangofinal the idrangofinal to set
     */
    public void setIdrangofinal(int idrangofinal) {
        this.idrangofinal = idrangofinal;
    }



    /**
     * @return the kminicial
     */
    public float getKminicial() {
        return kminicial;
    }



    /**
     * @param kminicial the kminicial to set
     */
    public void setKminicial(float kminicial) {
        this.kminicial = kminicial;
    }



    /**
     * @return the kmfinal
     */
    public float getKmfinal() {
        return kmfinal;
    }



    /**
     * @param kmfinal the kmfinal to set
     */
    public void setKmfinal(float kmfinal) {
        this.kmfinal = kmfinal;
    }



    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }



    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public void setPrecio(String precio) {
	try{
	    this.precio = Float.parseFloat(precio);
	}catch(Exception e){
	    this.precio = 0;
	}
      
    }



    /**
     * @return the sobrepeso
     */
    public float getSobrepeso() {
        return sobrepeso;
    }



    /**
     * @param sobrepeso the sobrepeso to set
     */
    public void setSobrepeso(float sobrepeso) {
        this.sobrepeso = sobrepeso;
    }



    /**
     * @return the preciokgsp
     */
    public float getPreciokgsp() {
        return preciokgsp;
    }



    /**
     * @param preciokgsp the preciokgsp to set
     */
    public void setPreciokgsp(float preciokgsp) {
        this.preciokgsp = preciokgsp;
    }



    /**
     * @return the pesovolumetrico
     */
    public float getPesovolumetrico() {
        return pesovolumetrico;
    }



    /**
     * @param pesovolumetrico the pesovolumetrico to set
     */
    public void setPesovolumetrico(float pesovolumetrico) {
        this.pesovolumetrico = pesovolumetrico;
    }



    /**
     * @return the descripciontarifa
     */
    public String getDescripciontarifa() {
        return descripciontarifa;
    }



    /**
     * @param descripciontarifa the descripciontarifa to set
     */
    public void setDescripciontarifa(String descripciontarifa) {
        this.descripciontarifa = descripciontarifa;
    }



    /**
     * @return the garantiamaxina
     */
    public String getGarantiamaxina() {
        return garantiamaxina;
    }



    /**
     * @param garantiamaxina the garantiamaxina to set
     */
    public void setGarantiamaxina(String garantiamaxina) {
        this.garantiamaxina = garantiamaxina;
    }



    /**
     * @return the descripciongarantiamaxima
     */
    public String getDescripciongarantiamaxima() {
        return descripciongarantiamaxima;
    }



    /**
     * @param descripciongarantiamaxima the descripciongarantiamaxima to set
     */
    public void setDescripciongarantiamaxima(String descripciongarantiamaxima) {
        this.descripciongarantiamaxima = descripciongarantiamaxima;
    }



    /**
     * @return the formapago
     */
    public String getFormapago() {
        return formapago;
    }



    /**
     * @param formapago the formapago to set
     */
    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }



    /**
     * @return the cporigen
     */
    public String getCporigen() {
        return cporigen;
    }



    /**
     * @param cporigen the cporigen to set
     */
    public void setCporigen(String cporigen) {
        this.cporigen = cporigen;
    }



    /**
     * @return the cpdesgtino
     */
    public String getCpdestino() {
        return cpdestino;
    }



    /**
     * @param cpdesgtino the cpdesgtino to set
     */
    public void setCpdestino(String cpdesgtino) {
        this.cpdestino = cpdesgtino;
    }



    /**
     * @return the kilometros
     */
    public float getKilometros() {
        return kilometros;
    }



    /**
     * @param kilometros the kilometros to set
     */
    public void setKilometros(float kilometros) {
        this.kilometros = kilometros;
    }



    /**
     * @return the zona
     */
    public String getZona() {
        return zona;
    }



    /**
     * @param zona the zona to set
     */
    public void setZona(String zona) {
        this.zona = zona;
    }



    /**
     * @return the preciounitarioporkm
     */
    public float getPreciounitarioporkm() {
        return preciounitarioporkm;
    }



    /**
     * @param preciounitarioporkm the preciounitarioporkm to set
     */
    public void setPreciounitarioporkm(float preciounitarioporkm) {
        this.preciounitarioporkm = preciounitarioporkm;
    }



    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }



    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    /**
     * @return the cantidadenvios
     */
    public int getCantidadenvios() {
        return cantidadenvios;   
    }



    /**
     * @param cantidadenvios the cantidadenvios to set
     */
    public void setCantidadenvios(int cantidadenvios) {
        this.cantidadenvios = cantidadenvios;
    }



    /**
     * @return the precioadicional
     */
    public float getPrecioadicional() {
        return precioadicional;
    }



    /**
     * @param precioadicional the precioadicional to set
     */
    public void setPrecioadicional(float precioadicional) {
        this.precioadicional = precioadicional;
    }



    /**
     * @return the totalprecioenvios
     */
    public float getTotalprecioenvios() {
        return totalprecioenvios;
    }



    /**
     * @param totalprecioenvios the totalprecioenvios to set
     */
    public void setTotalprecioenvios(float totalprecioenvios) {
        this.totalprecioenvios = totalprecioenvios;
    }



    /**
     * @return the totalsobrepeso
     */
    public float getTotalsobrepeso() {
        return totalsobrepeso;
    }



    /**
     * @param totalsobrepeso the totalsobrepeso to set
     */
    public void setTotalsobrepeso(float totalsobrepeso) {
        this.totalsobrepeso = totalsobrepeso;
    }



    /**
     * @return the garantia
     */
    public String getGarantia() {
        return garantia;
    }



    /**
     * @param garantia the garantia to set
     */
    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }



    /**
     * @return the esinternacional
     */
    public String getEsinternacional() {
        return esinternacional;
    }



    /**
     * @param esinternacional the esinternacional to set
     */
    public void setEsinternacional(String esinternacional) {
        this.esinternacional = esinternacional;
    }



    /**
     * @return the preciodolares
     */
    public float getPreciodolares() {
        return preciodolares;
    }



    /**
     * @param preciodolares the preciodolares to set
     */
    public void setPreciodolares(float preciodolares) {
        this.preciodolares = preciodolares;
    }



    /**
     * @return the tipocambiodolar
     */
    public float getTipocambiodolar() {
        return tipocambiodolar;
    }



    /**
     * @param tipocambiodolar the tipocambiodolar to set
     */
    public void setTipocambiodolar(float tipocambiodolar) {
        this.tipocambiodolar = tipocambiodolar;
    }

    public void setPreciodolares(String precio) {
  	try{
  	    this.preciodolares = Float.parseFloat(precio);
  	}catch(Exception e){
  	    this.preciodolares = 0;
  	}
        
      }



    /**
     * @return the idservicio
     */
    public String getIdservicio() {
        return idservicio;
    }



    /**
     * @param idservicio the idservicio to set
     */
    public void setIdservicio(String idservicio) {
        this.idservicio = idservicio;
    }



	public String getIdtipoventa() {
		return idtipoventa;
	}



	public void setIdtipoventa(String idtipoventa) {
		this.idtipoventa = idtipoventa;
	}



	public int getIdconvenio() {
		return idconvenio;
	}



	public void setIdconvenio(int idconvenio) {
		this.idconvenio = idconvenio;
	}



	public String getContrato() {
		return contrato;
	}



	public void setContrato(String contrato) {
		this.contrato = contrato;
	}



	public int getIdconveniodetalle() {
		return idconveniodetalle;
	}



	public void setIdconveniodetalle(int idconveniodetalle) {
		this.idconveniodetalle = idconveniodetalle;
	}



	public float getVolumenamparado() {
		return volumenamparado;
	}



	public void setVolumenamparado(float volumenamparado) {
		this.volumenamparado = volumenamparado;
	}


  

}
