package com.administracion.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DetalleVenta  implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    int iddetalleventa ;
    int idventa ;
    int idtarifa ;
    int idrangotarifa ;
    int idpesotarifa ;
    int idzonatarifa ;
    int idconveniodetalle;
    int idconvenio;
    
    String idadicional ;
    int cantidad ;
    float precio_unitario ;
    float descuento ;
    float pesokg ;
    float pesovol ;
    float km ;
	float volumenamparado=0;
	float pesoamparado=0; 
    
    String descripcion ;
    String idproducto;
    String origen ;
    String destino ;
    String iddocumento;
    String idguiainternacional;
    float tipocambio;
    String tipoventa; //FXC, CONTADO, COD, PREGAGADO
    String siglasplaza;
    String login;
    String idoficina;
    String idservicio;
    
    float precio_seguro;
    float valor_declarado;

    
    public DetalleVenta() {
	// TODO Auto-generated constructor stub
    }



    /**
     * @return the iddetalleventa
     */
    public int getIddetalleventa() {
        return iddetalleventa;
    }



    /**
     * @param iddetalleventa the iddetalleventa to set
     */
    public void setIddetalleventa(int iddetalleventa) {
        this.iddetalleventa = iddetalleventa;
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
     * @return the idrangotarifa
     */
    public int getIdrangotarifa() {
        return idrangotarifa;
    }



    /**
     * @param idrangotarifa the idrangotarifa to set
     */
    public void setIdrangotarifa(int idrangotarifa) {
        this.idrangotarifa = idrangotarifa;
    }



    /**
     * @return the idpesotarifa
     */
    public int getIdpesotarifa() {
        return idpesotarifa;
    }



    /**
     * @param idpesotarifa the idpesotarifa to set
     */
    public void setIdpesotarifa(int idpesotarifa) {
        this.idpesotarifa = idpesotarifa;
    }



    /**
     * @return the idzonatarifa
     */
    public int getIdzonatarifa() {
        return idzonatarifa;
    }



    /**
     * @param idzonatarifa the idzonatarifa to set
     */
    public void setIdzonatarifa(int idzonatarifa) {
        this.idzonatarifa = idzonatarifa;
    }



    /**
     * @return the idadicional
     */
    public String getIdadicional() {
        return idadicional;
    }



    /**
     * @param idadicional the idadicional to set
     */
    public void setIdadicional(String idadicional) {
        this.idadicional = idadicional;
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



    /**
     * @return the pesokm
     */
    public float getPesokg() {
        return pesokg;
    }



    /**
     * @param pesokm the pesokm to set
     */
    public void setPesokg(float pesokg) {
        this.pesokg = pesokg;
    }



    /**
     * @return the pesovol
     */
    public float getPesovol() {
        return pesovol;
    }



    /**
     * @param pesovol the pesovol to set
     */
    public void setPesovol(float pesovol) {
        this.pesovol = pesovol;
    }

    /**
     * @param pesovol the pesovol to set
     */
    public void setPesovol(String pesovol) {
	try{
	    this.pesovol = Float.parseFloat(pesovol);
	}catch(Exception e){
	    this.pesovol = 0;
	}
       
    }


    /**
     * @return the km
     */
    public float getKm() {
        return km;
    }



    /**
     * @param km the km to set
     */
    public void setKm(float km) {
        this.km = km;
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
        this.descripcion = descripcion;
    }



    /**
     * @return the idproducto
     */
    public String getIdproducto() {
        return idproducto;
    }



    /**
     * @param idproducto the idproducto to set
     */
    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }



    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }



    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }



    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }



    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }



    /**
     * @return the idguiainternacional
     */
    public String getIdguiainternacional() {
        return idguiainternacional;
    }



    /**
     * @param idguiainternacional the idguiainternacional to set
     */
    public void setIdguiainternacional(String idguiainternacional) {
        this.idguiainternacional = idguiainternacional;
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
     * @return the idconvenio
     */
    public int getIdconvenio() {
        return idconvenio;
    }



    /**
     * @param idconvenio the idconvenio to set
     */
    public void setIdconvenio(int idconvenio) {
        this.idconvenio = idconvenio;
    }



    /**
     * @return the siglasplaza
     */
    public String getSiglasplaza() {
        return siglasplaza;
    }



    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }



    /**
     * @return the idoficina
     */
    public String getIdoficina() {
        return idoficina;
    }



    /**
     * @param siglasplaza the siglasplaza to set
     */
    public void setSiglasplaza(String siglasplaza) {
        this.siglasplaza = siglasplaza;
    }



    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }



    /**
     * @param idoficina the idoficina to set
     */
    public void setIdoficina(String idoficina) {
        this.idoficina = idoficina;
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



	public float getPrecio_seguro() {
		return precio_seguro;
	}



	public void setPrecio_seguro(float precio_seguro) {
		this.precio_seguro = precio_seguro;
	}



	public float getValor_declarado() {
		return valor_declarado;
	}



	public void setValor_declarado(float valor_declarado) {
		this.valor_declarado = valor_declarado;
	}
	
	public void setValor_declarado(String valor_declarado) {
		
		try{
			this.valor_declarado = Float.parseFloat(valor_declarado);
		}catch(Exception e){
			
		}
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
