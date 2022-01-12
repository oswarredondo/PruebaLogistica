package com.administracion.dto;

import java.io.Serializable;

public class DocumentoPesoKMMaximo implements Serializable {

    String iddocumento;
    int tipo; // ver constantes
    String tipo_contrato_convenio;
    String siglasplaza;
    String idoficina;
    String login;
    String idservicio;
    String fechacreacion;

    int idconvenio;
    int idtarifa;
    int idconveniodetalle;
    int idrangotarifa;
    int idpesotarifa;
    int idzonatarifa;

    float max_amparado_km;
    float max_amparado_peso;
    float  max_amparado_volumen;
    
    float precio;
    float precio_kg_sp;

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public DocumentoPesoKMMaximo() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @return the iddocumento
     */
    public String getIddocumento() {
        return iddocumento;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
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
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @return the idservicio
     */
    public String getIdservicio() {
        return idservicio;
    }

    /**
     * @return the fechacreacion
     */
    public String getFechacreacion() {
        return fechacreacion;
    }

    /**
     * @return the idconvenio
     */
    public int getIdconvenio() {
        return idconvenio;
    }

    /**
     * @return the idtarifa
     */
    public int getIdtarifa() {
        return idtarifa;
    }

    /**
     * @return the idconveniodetalle
     */
    public int getIdconveniodetalle() {
        return idconveniodetalle;
    }

    /**
     * @return the idrangotarifa
     */
    public int getIdrangotarifa() {
        return idrangotarifa;
    }

    /**
     * @return the idpesotarifa
     */
    public int getIdpesotarifa() {
        return idpesotarifa;
    }

    /**
     * @return the idzonatarifa
     */
    public int getIdzonatarifa() {
        return idzonatarifa;
    }

    /**
     * @return the max_amparado_km
     */
    public float getMax_amparado_km() {
        return max_amparado_km;
    }

    /**
     * @return the max_amparado_peso
     */
    public float getMax_amparado_peso() {
        return max_amparado_peso;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param iddocumento the iddocumento to set
     */
    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
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
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @param idservicio the idservicio to set
     */
    public void setIdservicio(String idservicio) {
        this.idservicio = idservicio;
    }

    /**
     * @param fechacreacion the fechacreacion to set
     */
    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    /**
     * @param idconvenio the idconvenio to set
     */
    public void setIdconvenio(int idconvenio) {
        this.idconvenio = idconvenio;
    }

    /**
     * @param idtarifa the idtarifa to set
     */
    public void setIdtarifa(int idtarifa) {
        this.idtarifa = idtarifa;
    }

    /**
     * @param idconveniodetalle the idconveniodetalle to set
     */
    public void setIdconveniodetalle(int idconveniodetalle) {
        this.idconveniodetalle = idconveniodetalle;
    }

    /**
     * @param idrangotarifa the idrangotarifa to set
     */
    public void setIdrangotarifa(int idrangotarifa) {
        this.idrangotarifa = idrangotarifa;
    }

    /**
     * @param idpesotarifa the idpesotarifa to set
     */
    public void setIdpesotarifa(int idpesotarifa) {
        this.idpesotarifa = idpesotarifa;
    }

    /**
     * @param idzonatarifa the idzonatarifa to set
     */
    public void setIdzonatarifa(int idzonatarifa) {
        this.idzonatarifa = idzonatarifa;
    }

    /**
     * @param max_amparado_km the max_amparado_km to set
     */
    public void setMax_amparado_km(float max_amparado_km) {
        this.max_amparado_km = max_amparado_km;
    }

    /**
     * @param max_amparado_peso the max_amparado_peso to set
     */
    public void setMax_amparado_peso(float max_amparado_peso) {
        this.max_amparado_peso = max_amparado_peso;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the precio_kg_sp
     */
    public float getPrecio_kg_sp() {
        return precio_kg_sp;
    }

    /**
     * @param precio_kg_sp the precio_kg_sp to set
     */
    public void setPrecio_kg_sp(float precio_kg_sp) {
        this.precio_kg_sp = precio_kg_sp;
    }

    /**
     * @return the tipo_contrato_convenio
     */
    public String getTipo_contrato_convenio() {
        return tipo_contrato_convenio;
    }

    /**
     * @param tipo_contrato_convenio the tipo_contrato_convenio to set
     */
    public void setTipo_contrato_convenio(String tipo_contrato_convenio) {
        this.tipo_contrato_convenio = tipo_contrato_convenio;
    }

	public float getMax_amparado_volumen() {
		return max_amparado_volumen;
	}

	public void setMax_amparado_volumen(float max_amparado_volumen) {
		this.max_amparado_volumen = max_amparado_volumen;
	}

	

}
