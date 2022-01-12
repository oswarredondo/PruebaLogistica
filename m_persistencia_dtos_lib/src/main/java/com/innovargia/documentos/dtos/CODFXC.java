/**
 * 
 */
package com.innovargia.documentos.dtos;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class CODFXC  implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    String iddocumento;
    String idservicio;
    String fechacreacion;
    String login_creo;
    String numoficina_creo;
   
    String fecha_entrega;
    String login_entrega;
    String numoficina_entrega;

    String fecha_devolucion;
    String login_devolucion;
    String numoficina_devolucion;
    
    int tipocod=0;
    float valor_a_cobrar=0;
    float valor_cobrado=0;
    boolean es_fxc=false;

    public CODFXC() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @return the iddocumento
     */
    public String getIddocumento() {
        return iddocumento;
    }

    /**
     * @return the fechacreacion
     */
    public String getFechacreacion() {
        return fechacreacion;
    }

    /**
     * @return the login_creo
     */
    public String getLogin_creo() {
        return login_creo;
    }

    /**
     * @return the numoficina_creo
     */
    public String getNumoficina_creo() {
        return numoficina_creo;
    }

    /**
     * @return the fecha_entrega
     */
    public String getFecha_entrega() {
        return fecha_entrega;
    }

    /**
     * @return the login_entrega
     */
    public String getLogin_entrega() {
        return login_entrega;
    }

    /**
     * @return the numoficina_entrega
     */
    public String getNumoficina_entrega() {
        return numoficina_entrega;
    }

    /**
     * @return the fecha_devolucion
     */
    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    /**
     * @return the login_devolucion
     */
    public String getLogin_devolucion() {
        return login_devolucion;
    }

    /**
     * @return the numoficina_devolucion
     */
    public String getNumoficina_devolucion() {
        return numoficina_devolucion;
    }

    /**
     * @return the tipocod
     */
    public int getTipocod() {
        return tipocod;
    }

    /**
     * @return the valor_a_cobrar
     */
    public float getValor_a_cobrar() {
        return valor_a_cobrar;
    }

    /**
     * @return the valor_cobrado
     */
    public float getValor_cobrado() {
        return valor_cobrado;
    }

    /**
     * @param iddocumento the iddocumento to set
     */
    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    /**
     * @param fechacreacion the fechacreacion to set
     */
    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    /**
     * @param login_creo the login_creo to set
     */
    public void setLogin_creo(String login_creo) {
        this.login_creo = login_creo;
    }

    /**
     * @param numoficina_creo the numoficina_creo to set
     */
    public void setNumoficina_creo(String numoficina_creo) {
        this.numoficina_creo = numoficina_creo;
    }

    /**
     * @param fecha_entrega the fecha_entrega to set
     */
    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    /**
     * @param login_entrega the login_entrega to set
     */
    public void setLogin_entrega(String login_entrega) {
        this.login_entrega = login_entrega;
    }

    /**
     * @param numoficina_entrega the numoficina_entrega to set
     */
    public void setNumoficina_entrega(String numoficina_entrega) {
        this.numoficina_entrega = numoficina_entrega;
    }

    /**
     * @param fecha_devolucion the fecha_devolucion to set
     */
    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    /**
     * @param login_devolucion the login_devolucion to set
     */
    public void setLogin_devolucion(String login_devolucion) {
        this.login_devolucion = login_devolucion;
    }

    /**
     * @param numoficina_devolucion the numoficina_devolucion to set
     */
    public void setNumoficina_devolucion(String numoficina_devolucion) {
        this.numoficina_devolucion = numoficina_devolucion;
    }

    /**
     * @param tipocod the tipocod to set
     */
    public void setTipocod(int tipocod) {
        this.tipocod = tipocod;
    }

    /**
     * @param valor_a_cobrar the valor_a_cobrar to set
     */
    public void setValor_a_cobrar(float valor_a_cobrar) {
        this.valor_a_cobrar = valor_a_cobrar;
    }

    /**
     * @param valor_cobrado the valor_cobrado to set
     */
    public void setValor_cobrado(float valor_cobrado) {
        this.valor_cobrado = valor_cobrado;
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

	public boolean isEs_fxc() {
		return es_fxc;
	}

	public void setEs_fxc(boolean es_fxc) {
		this.es_fxc = es_fxc;
	}

}
