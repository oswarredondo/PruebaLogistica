package com.innovargia.autodoc.dto;

import java.io.Serializable;

public class PorcentajesChart implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    String registro;
    float cantidad;
    float porcentaje;
    float data1;
    float data2;
    float data3;
    float data4;
    float data5;
    
    public PorcentajesChart() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @return the registro
     */
    public String getRegistro() {
        return registro;
    }

    /**
     * @param registro the registro to set
     */
    public void setRegistro(String registro) {
        this.registro = registro;
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
     * @return the porcentaje
     */
    public float getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

   

    /**
     * @return the data1
     */
    public float getData1() {
        return data1;
    }

    /**
     * @param data1 the data1 to set
     */
    public void setData1(float data1) {
        this.data1 = data1;
    }

    /**
     * @return the data2
     */
    public float getData2() {
        return data2;
    }

    /**
     * @param data2 the data2 to set
     */
    public void setData2(float data2) {
        this.data2 = data2;
    }

    /**
     * @return the data3
     */
    public float getData3() {
        return data3;
    }

    /**
     * @param data3 the data3 to set
     */
    public void setData3(float data3) {
        this.data3 = data3;
    }

    /**
     * @return the data4
     */
    public float getData4() {
        return data4;
    }

    /**
     * @param data4 the data4 to set
     */
    public void setData4(float data4) {
        this.data4 = data4;
    }

    /**
     * @return the data5
     */
    public float getData5() {
        return data5;
    }

    /**
     * @param data5 the data5 to set
     */
    public void setData5(float data5) {
        this.data5 = data5;
    }

}
