/**
 * 
 */
package com.administracion.dto;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class CotizacionLineaVolumen implements Serializable {

	private static final long serialVersionUID = 1L;
	int idtarifa;
	int idcotizacionlinea_volumne;
	int idcotizacionlinea;
	int idconvenio;
	int idconveniodetalle;
	int idrangotarifa;
	int idpesotarifa;
	int idzonatarifa;
	int cantidad;
	float peso;
	int alto;
	int ancho;
	int largo;
	float volumen;
	float precio_unitario;
	float precio_adicional_requerido;
	float precio_adicional_servicio;
	float valor_asegurado;
	float preciokgsp;
	float valordeclarado;
	float valor_a_cobrar_cod;
	float volumenamparado=0;
	float pesoamparado=0; 
	
	String tiene_seguro;
	String factura;
	String contenido;

	String referencia;
	String tiene_retorno;
	String es_ocurre;
	String es_multiple;
	String es_cod;
	String tipoempaque;
	String observacion;

	String descripciontarifa;
	String serviciotarifa;

	int idtipoventa; // 1=Contado, 2=Prepagado, 3=fxc

	float total;
	 float kg_sobrepeso;
	/**
	 * @return the idcotizacionlinea_volumne
	 */
	public int getIdcotizacionlinea_volumne() {
		return idcotizacionlinea_volumne;
	}

	/**
	 * @return the idcotizacionlinea
	 */
	public int getIdcotizacionlinea() {
		return idcotizacionlinea;
	}

	/**
	 * @return the idconvenio
	 */
	public int getIdconvenio() {
		return idconvenio;
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
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @return the peso
	 */
	public float getPeso() {
		return peso;
	}

	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * @return the largo
	 */
	public int getLargo() {
		return largo;
	}

	/**
	 * @return the volumen
	 */
	public float getVolumen() {
		return volumen;
	}

	/**
	 * @return the precio_unitario
	 */
	public float getPrecio_unitario() {
		return precio_unitario;
	}

	/**
	 * @return the precio_adicional_requerido
	 */
	public float getPrecio_adicional_requerido() {
		return precio_adicional_requerido;
	}

	/**
	 * @return the valor_asegurado
	 */
	public float getValor_asegurado() {
		return valor_asegurado;
	}

	/**
	 * @return the tiene_seguro
	 */
	public String getTiene_seguro() {
		return tiene_seguro;
	}

	/**
	 * @return the factura
	 */
	public String getFactura() {
		return factura;
	}

	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @return the tiene_retorno
	 */
	public String getTiene_retorno() {
		return tiene_retorno;
	}

	/**
	 * @return the es_ocurre
	 */
	public String getEs_ocurre() {
		return es_ocurre;
	}

	/**
	 * @return the es_multiple
	 */
	public String getEs_multiple() {
		return es_multiple;
	}

	/**
	 * @return the es_cod
	 */
	public String getEs_cod() {
		return es_cod;
	}

	/**
	 * @return the tipoempaque
	 */
	public String getTipoempaque() {
		return tipoempaque;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param idcotizacionlinea_volumne
	 *            the idcotizacionlinea_volumne to set
	 */
	public void setIdcotizacionlinea_volumne(int idcotizacionlinea_volumne) {
		this.idcotizacionlinea_volumne = idcotizacionlinea_volumne;
	}

	/**
	 * @param idcotizacionlinea
	 *            the idcotizacionlinea to set
	 */
	public void setIdcotizacionlinea(int idcotizacionlinea) {
		this.idcotizacionlinea = idcotizacionlinea;
	}

	/**
	 * @param idconvenio
	 *            the idconvenio to set
	 */
	public void setIdconvenio(int idconvenio) {
		this.idconvenio = idconvenio;
	}

	/**
	 * @param idconveniodetalle
	 *            the idconveniodetalle to set
	 */
	public void setIdconveniodetalle(int idconveniodetalle) {
		this.idconveniodetalle = idconveniodetalle;
	}

	/**
	 * @param idrangotarifa
	 *            the idrangotarifa to set
	 */
	public void setIdrangotarifa(int idrangotarifa) {
		this.idrangotarifa = idrangotarifa;
	}

	
	public void setIdrangotarifa(String idrangotarifa) {
		try{
			this.idrangotarifa = Integer.parseInt(idrangotarifa);
		}catch(Exception e){
			this.idrangotarifa=0;
		}
		
	}
	
	/**
	 * @param idpesotarifa
	 *            the idpesotarifa to set
	 */
	public void setIdpesotarifa(int idpesotarifa) {
		this.idpesotarifa = idpesotarifa;
	}

	/**
	 * @param idzonatarifa
	 *            the idzonatarifa to set
	 */
	public void setIdzonatarifa(int idzonatarifa) {
		this.idzonatarifa = idzonatarifa;
	}

	/**
	 * @param cantidad
	 *            the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @param peso
	 *            the peso to set
	 */
	public void setPeso(float peso) {
		this.peso = peso;
	}

	/**
	 * @param alto
	 *            the alto to set
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}

	/**
	 * @param ancho
	 *            the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	/**
	 * @param largo
	 *            the largo to set
	 */
	public void setLargo(int largo) {
		this.largo = largo;
	}

	/**
	 * @param volumen
	 *            the volumen to set
	 */
	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	/**
	 * @param precio_unitario
	 *            the precio_unitario to set
	 */
	public void setPrecio_unitario(float precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	/**
	 * @param precio_adicional_requerido
	 *            the precio_adicional_requerido to set
	 */
	public void setPrecio_adicional_requerido(float precio_adicional_requerido) {
		this.precio_adicional_requerido = precio_adicional_requerido;
	}

	/**
	 * @param valor_asegurado
	 *            the valor_asegurado to set
	 */
	public void setValor_asegurado(float valor_asegurado) {
		this.valor_asegurado = valor_asegurado;
	}

	/**
	 * @param tiene_seguro
	 *            the tiene_seguro to set
	 */
	public void setTiene_seguro(String tiene_seguro) {
		this.tiene_seguro = tiene_seguro;
	}

	/**
	 * @param factura
	 *            the factura to set
	 */
	public void setFactura(String factura) {
		this.factura = factura;
	}

	/**
	 * @param contenido
	 *            the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * @param referencia
	 *            the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * @param tiene_retorno
	 *            the tiene_retorno to set
	 */
	public void setTiene_retorno(String tiene_retorno) {
		this.tiene_retorno = tiene_retorno;
	}

	/**
	 * @param es_ocurre
	 *            the es_ocurre to set
	 */
	public void setEs_ocurre(String es_ocurre) {
		this.es_ocurre = es_ocurre;
	}

	/**
	 * @param es_multiple
	 *            the es_multiple to set
	 */
	public void setEs_multiple(String es_multiple) {
		this.es_multiple = es_multiple;
	}

	/**
	 * @param es_cod
	 *            the es_cod to set
	 */
	public void setEs_cod(String es_cod) {
		this.es_cod = es_cod;
	}

	/**
	 * @param tipoempaque
	 *            the tipoempaque to set
	 */
	public void setTipoempaque(String tipoempaque) {
		this.tipoempaque = tipoempaque;
	}

	/**
	 * @param observacion
	 *            the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the preciokgsp
	 */
	public float getPreciokgsp() {
		return preciokgsp;
	}

	/**
	 * @param preciokgsp
	 *            the preciokgsp to set
	 */
	public void setPreciokgsp(float preciokgsp) {
		this.preciokgsp = preciokgsp;
	}

	/**
	 * @return the descripciontarifa
	 */
	public String getDescripciontarifa() {
		return descripciontarifa;
	}

	/**
	 * @param descripciontarifa
	 *            the descripciontarifa to set
	 */
	public void setDescripciontarifa(String descripciontarifa) {
		this.descripciontarifa = descripciontarifa;
	}

	/**
	 * @return the total
	 */
	public float getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(float total) {
		this.total = total;
	}

	/**
	 * @return the precio_adicional_servicio
	 */
	public float getPrecio_adicional_servicio() {
		return precio_adicional_servicio;
	}

	/**
	 * @param precio_adicional_servicio
	 *            the precio_adicional_servicio to set
	 */
	public void setPrecio_adicional_servicio(float precio_adicional_servicio) {
		this.precio_adicional_servicio = precio_adicional_servicio;
	}

	/**
	 * @return the valordeclarado
	 */
	public float getValordeclarado() {
		return valordeclarado;
	}

	/**
	 * @param valordeclarado
	 *            the valordeclarado to set
	 */
	public void setValordeclarado(float valordeclarado) {
		this.valordeclarado = valordeclarado;
	}

	/**
	 * @return the valor_a_cobrar_cod
	 */
	public float getValor_a_cobrar_cod() {
		return valor_a_cobrar_cod;
	}

	/**
	 * @param valor_a_cobrar_cod
	 *            the valor_a_cobrar_cod to set
	 */
	public void setValor_a_cobrar_cod(float valor_a_cobrar_cod) {
		this.valor_a_cobrar_cod = valor_a_cobrar_cod;
	}

	/**
	 * @return the serviciotarifa
	 */
	public String getServiciotarifa() {
		return serviciotarifa;
	}

	/**
	 * @param serviciotarifa
	 *            the serviciotarifa to set
	 */
	public void setServiciotarifa(String serviciotarifa) {
		this.serviciotarifa = serviciotarifa;
	}

	/**
	 * @return the idtarifa
	 */
	public int getIdtarifa() {
		return idtarifa;
	}

	/**
	 * @param idtarifa
	 *            the idtarifa to set
	 */
	public void setIdtarifa(int idtarifa) {
		this.idtarifa = idtarifa;
	}

	public int getIdtipoventa() {
		return idtipoventa;
	}

	public void setIdtipoventa(int idtipoventa) {
		this.idtipoventa = idtipoventa;
	}

	public float getVolumenamparado() {
		return volumenamparado;
	}

	public void setVolumenamparado(float volumenamparado) {
		this.volumenamparado = volumenamparado;
	}

	public float getPesoamparado() {
		return pesoamparado;
	}

	public void setPesoamparado(float pesoamparado) {
		this.pesoamparado = pesoamparado;
	}

	public float getKg_sobrepeso() {
		return kg_sobrepeso;
	}

	public void setKg_sobrepeso(float kg_sobrepeso) {
		this.kg_sobrepeso = kg_sobrepeso;
	}

}
