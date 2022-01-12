package com.innovargia.salesmanager.dtos;

import java.io.Serializable;

public class CajaDTO implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    int idcaja;
    int idcajaapercierre;
    String estatus;
    
    String idoficina ;
    String descripcion ;
    String fechaapertura;
    String login ;
    String fechacierre;
    String logincierre;
    String fecha ;
    
    

    

    public CajaDTO() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @return the idcaja
     */
    public int getIdcaja() {
        return idcaja;
    }

    /**
     * @param idcaja the idcaja to set
     */
    public void setIdcaja(int idcaja) {
        this.idcaja = idcaja;
    }

    /**
     * @return the idcajaapercierre
     */
    public int getIdcajaapercierre() {
        return idcajaapercierre;
    }

    /**
     * @param idcajaapercierre the idcajaapercierre to set
     */
    public void setIdcajaapercierre(int idcajaapercierre) {
        this.idcajaapercierre = idcajaapercierre;
    }

    /**
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
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
     * @return the fechaapertura
     */
    public String getFechaapertura() {
        return fechaapertura;
    }

    /**
     * @param fechaapertura the fechaapertura to set
     */
    public void setFechaapertura(String fechaapertura) {
        this.fechaapertura = fechaapertura;
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
     * @return the fechacierre
     */
    public String getFechacierre() {
        return fechacierre;
    }

    /**
     * @param fechacierre the fechacierre to set
     */
    public void setFechacierre(String fechacierre) {
        this.fechacierre = fechacierre;
    }

    /**
     * @return the logincierre
     */
    public String getLogincierre() {
        return logincierre;
    }

    /**
     * @param logincierre the logincierre to set
     */
    public void setLogincierre(String logincierre) {
        this.logincierre = logincierre;
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

}
