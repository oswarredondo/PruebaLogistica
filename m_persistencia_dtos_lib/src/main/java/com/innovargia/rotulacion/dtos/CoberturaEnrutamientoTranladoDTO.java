package com.innovargia.rotulacion.dtos;

import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;

public class CoberturaEnrutamientoTranladoDTO  implements java.io.Serializable{
    
    CruceCoberturaDTO cruce_obertura = new CruceCoberturaDTO();
    Frecuencias frecuencia_origen  =new Frecuencias();
    Frecuencias frecuencia_destino  =new Frecuencias();

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public CoberturaEnrutamientoTranladoDTO() {
	// TODO Auto-generated constructor stub
    }

  

    /**
     * @return the frecuencia_origen
     */
    public Frecuencias getFrecuencia_origen() {
        return frecuencia_origen;
    }

    /**
     * @param frecuencia_origen the frecuencia_origen to set
     */
    public void setFrecuencia_origen(Frecuencias frecuencia_origen) {
        this.frecuencia_origen = frecuencia_origen;
    }

    /**
     * @return the frecuencia_destino
     */
    public Frecuencias getFrecuencia_destino() {
        return frecuencia_destino;
    }

    /**
     * @param frecuencia_destino the frecuencia_destino to set
     */
    public void setFrecuencia_destino(Frecuencias frecuencia_destino) {
        this.frecuencia_destino = frecuencia_destino;
    }



    /**
     * @return the cruce_obertura
     */
    public CruceCoberturaDTO getCruce_obertura() {
        return cruce_obertura;
    }



    /**
     * @param cruce_obertura the cruce_obertura to set
     */
    public void setCruce_obertura(CruceCoberturaDTO cruce_obertura) {
        this.cruce_obertura = cruce_obertura;
    }

}
