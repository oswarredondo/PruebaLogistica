package com.administracion.dto;

import java.io.Serializable;

public class Envios_JSONDTO implements Serializable{

    private static final long serialVersionUID = 1L;
    
    int idregistro;
    int cantidad;
    int idventa;
    String fechacreacion ;
    String login ;
    String json_data ;
    String siglasplaza ;
    String idoficina;
    String tipo;
    String remite;
    String destinatario;
    String uuid;
    String nacional ;
    String manifiesto;
    
    public Envios_JSONDTO() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @return the idregistro
     */
    public int getIdregistro() {
        return idregistro;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @return the idventa
     */
    public int getIdventa() {
        return idventa;
    }

    /**
     * @return the fechacreacion
     */
    public String getFechacreacion() {
        return fechacreacion;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @return the json_data
     */
    public String getJson_data() {
        return json_data;
    }

    /**
     * @return the siglasplaza
     */
    public String getSiglasplaza() {
        return siglasplaza;
    }

    /**
     * @return the idoficina
     */
    public String getIdoficina() {
        return idoficina;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @return the remite
     */
    public String getRemite() {
        return remite;
    }

    /**
     * @return the destinatario
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @return the nacional
     */
    public String getNacional() {
        return nacional;
    }

    /**
     * @param idregistro the idregistro to set
     */
    public void setIdregistro(int idregistro) {
        this.idregistro = idregistro;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @param idventa the idventa to set
     */
    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    /**
     * @param fechacreacion the fechacreacion to set
     */
    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @param json_data the json_data to set
     */
    public void setJson_data(String json_data) {
        this.json_data = json_data;
    }

    /**
     * @param siglasplaza the siglasplaza to set
     */
    public void setSiglasplaza(String siglasplaza) {
        this.siglasplaza = siglasplaza;
    }

    /**
     * @param idoficina the idoficina to set
     */
    public void setIdoficina(String idoficina) {
        this.idoficina = idoficina;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @param remite the remite to set
     */
    public void setRemite(String remite) {
        this.remite = remite;
    }

    /**
     * @param destinatario the destinatario to set
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @param nacional the nacional to set
     */
    public void setNacional(String nacional) {
        this.nacional = nacional;
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

}
