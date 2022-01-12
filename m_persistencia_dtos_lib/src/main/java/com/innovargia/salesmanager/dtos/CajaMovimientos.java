/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author aruaro
 *
 */
public class CajaMovimientos {
    
    int idcajamovimiento;
    int idcaja;
    float cantidad ;
    
    int idmovimiento;
    String fecha ;
   
    String login ;
    String descripcion ;
    String observacion ;    

    /**
     * 
     */
    public CajaMovimientos() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @return the idcajamovimiento
     */
    public int getIdcajamovimiento() {
        return idcajamovimiento;
    }

    /**
     * @param idcajamovimiento the idcajamovimiento to set
     */
    public void setIdcajamovimiento(int idcajamovimiento) {
        this.idcajamovimiento = idcajamovimiento;
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
     * @return the cantidad
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the idmovimiento
     */
    public int getIdmovimiento() {
        return idmovimiento;
    }

    /**
     * @param idmovimiento the idmovimiento to set
     */
    public void setIdmovimiento(int idmovimiento) {
        this.idmovimiento = idmovimiento;
    }
    
    
    public void setIdmovimiento(String idmovimiento) {
	try{
	    this.idmovimiento = Integer.parseInt(idmovimiento);
	}catch(Exception e){
	    this.idmovimiento =-1;
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

}
