/**
 * 
 */
package com.innovargia.salesmanager.dtos;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class ConvenioDescuentoFactura implements Serializable {
    int idconveniodescfact ;
    int idconvenio;
    int rangoinicial;
    int rangofinal;
    int descuento;
    String fechaevento;
    String login; 
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public ConvenioDescuentoFactura() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @return the idconveniodescfact
     */
    public int getIdconveniodescfact() {
        return idconveniodescfact;
    }

    /**
     * @param idconveniodescfact the idconveniodescfact to set
     */
    public void setIdconveniodescfact(int idconveniodescfact) {
        this.idconveniodescfact = idconveniodescfact;
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
     * @return the rangoinicial
     */
    public int getRangoinicial() {
        return rangoinicial;
    }

    /**
     * @param rangoinicial the rangoinicial to set
     */
    public void setRangoinicial(int rangoinicial) {
        this.rangoinicial = rangoinicial;
    }

    /**
     * @return the rangofinal
     */
    public int getRangofinal() {
        return rangofinal;
    }

    /**
     * @param rangofinal the rangofinal to set
     */
    public void setRangofinal(int rangofinal) {
        this.rangofinal = rangofinal;
    }

    /**
     * @return the descuento
     */
    public int getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    /**
     * @return the fechaevento
     */
    public String getFechaevento() {
        return fechaevento;
    }

    /**
     * @param fechaevento the fechaevento to set
     */
    public void setFechaevento(String fechaevento) {
        this.fechaevento = fechaevento;
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

}
