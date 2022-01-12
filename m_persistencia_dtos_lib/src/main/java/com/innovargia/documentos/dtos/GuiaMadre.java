/* $Id: $
 * Nombre del Proyecto:
 * Nombre del Programa: Frecuencias.java
 * Responsable: Adri�n Morales Ruaro
 * Descripcion: Contiene datos de frecuencias de entrega, con esto se puede
 * consultar los datos de una frecuencia de entrega indicando un origen y un destino
 *
 *$Log:$
 */
package com.innovargia.documentos.dtos;

//Imports
import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;



//import org.apache.struts.validator.ValidatorForm;

/**
 *<CODE>
 * Datos para el desplegado de frecuencias de entrega
 *</CODE>
 * 
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GuiaMadre implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/** Guia Madre */
	private String guiaMadre;
	
	/** Identificador del idservicio */
	private String idservicio;
	
	/** Descripcion del idservicio */
	//private String descripcionidservicio;
	
	/** Identificador Numero de piezas */	
	private String numpiezas;
	
	/** Identificador Referencias */
	private String referencia;
	
	/** Identificador Tipo Empaque */
	private String tipoempaque;
	
	/** Peso */
	private String pesofisico;

	private GuiaMadre(String guiaMadre, String idservicio, String numpiezas, String referencia, String tipoempaque,
			String pesofisico) {
		super();
		this.guiaMadre = guiaMadre;
		this.idservicio = idservicio;
		this.numpiezas = numpiezas;
		this.referencia = referencia;
		this.tipoempaque = tipoempaque;
		this.pesofisico = pesofisico;
	}

	public GuiaMadre() {
		super();
	}

	public String getGuiaMadre() {
		return guiaMadre;
	}

	public void setGuiaMadre(String guiaMadre) {
		this.guiaMadre = guiaMadre;
	}

	public String getidservicio() {
		return idservicio;
	}

	public void setidservicio(String idservicio) {
		this.idservicio = idservicio;
	}

	public String getNumpiezas() {
		return numpiezas;
	}

	public void setNumpiezas(String numpiezas) {
		this.numpiezas = numpiezas;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String gettipoempaque() {
		return tipoempaque;
	}

	public void settipoempaque(String tipoempaque) {
		this.tipoempaque = tipoempaque;
	}

	public String getpesofisico() {
		return pesofisico;
	}

	public void setpesofisico(String pesofisico) {
		this.pesofisico = pesofisico;
	}
	
} // fin Frecuencias
