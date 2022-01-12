package com.administracion.dto;

public class UsuarioConvenioFolio {
    
    int idregistro ;
    int identidad ;
    int idorganizacion ;
    int idconvenio;
    String numcliente ;
    String login;
    String idservicio;
    int cantidad;
    int utilizada;
    int restante;
    
    public UsuarioConvenioFolio() {
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

    /**
     * @return the identidad
     */
    public int getIdentidad() {
        return identidad;
    }

    /**
     * @param identidad the identidad to set
     */
    public void setIdentidad(int identidad) {
        this.identidad = identidad;
    }

    /**
     * @return the idorganizacion
     */
    public int getIdorganizacion() {
        return idorganizacion;
    }

    /**
     * @param idorganizacion the idorganizacion to set
     */
    public void setIdorganizacion(int idorganizacion) {
        this.idorganizacion = idorganizacion;
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
     * @return the numcliente
     */
    public String getNumcliente() {
        return numcliente;
    }

    /**
     * @param numcliente the numcliente to set
     */
    public void setNumcliente(String numcliente) {
        this.numcliente = numcliente;
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
     * @return the utilizada
     */
    public int getUtilizada() {
        return utilizada;
    }

    /**
     * @param utilizada the utilizada to set
     */
    public void setUtilizada(int utilizada) {
        this.utilizada = utilizada;
    }

    /**
     * @return the restante
     */
    public int getRestante() {
        return restante;
    }

    /**
     * @param restante the restante to set
     */
    public void setRestante(int restante) {
        this.restante = restante;
    }

}
