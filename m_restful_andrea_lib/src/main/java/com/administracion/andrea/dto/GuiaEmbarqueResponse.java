package com.administracion.andrea.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GuiaEmbarqueResponse implements Serializable {

	/**
	* 
	*/
	String guiaReferencia = "";
	private static final long serialVersionUID = 1L;
	protected String generarGuiaEmbarqueResult;
	protected byte[] generarEtiquetaGuiaResult;
	protected String cancelarGuiaEmbarqueResult;
	protected byte[] generarManifiestoGuiaResult;

	protected boolean tieneCobetura =false;
	protected boolean convenioCorrecto =false;
	
	List<Tracking>  lista_trakings = new ArrayList<Tracking>();
	
	
	public String getGenerarGuiaEmbarqueResult() {
		return generarGuiaEmbarqueResult;
	}

	public void setGenerarGuiaEmbarqueResult(String generarGuiaEmbarqueResult) {
		this.generarGuiaEmbarqueResult = generarGuiaEmbarqueResult;
	}

	public byte[] getGenerarEtiquetaGuiaResult() {
		return generarEtiquetaGuiaResult;
	}

	public void setGenerarEtiquetaGuiaResult(byte[] generarEtiquetaGuiaResult) {
		this.generarEtiquetaGuiaResult = generarEtiquetaGuiaResult;
	}

	public String getCancelarGuiaEmbarqueResult() {
		return cancelarGuiaEmbarqueResult;
	}

	public void setCancelarGuiaEmbarqueResult(String cancelarGuiaEmbarqueResult) {
		this.cancelarGuiaEmbarqueResult = cancelarGuiaEmbarqueResult;
	}

	public byte[] getGenerarManifiestoGuiaResult() {
		return generarManifiestoGuiaResult;
	}

	public void setGenerarManifiestoGuiaResult(byte[] generarManifiestoGuiaResult) {
		this.generarManifiestoGuiaResult = generarManifiestoGuiaResult;
	}

	public boolean isTieneCobetura() {
		return tieneCobetura;
	}

	public void setTieneCobetura(boolean tieneCobetura) {
		this.tieneCobetura = tieneCobetura;
	}

	public boolean isConvenioCorrecto() {
		return convenioCorrecto;
	}

	public void setConvenioCorrecto(boolean convenioCorrecto) {
		this.convenioCorrecto = convenioCorrecto;
	}

	public String getGuiaReferencia() {
		return guiaReferencia;
	}

	public void setGuiaReferencia(String guiaReferencia) {
		this.guiaReferencia = guiaReferencia;
	}

	public List<Tracking> getLista_trakings() {
		return lista_trakings;
	}

	public void setLista_trakings(List<Tracking> lista_trakings) {
		this.lista_trakings = lista_trakings;
	}

}
