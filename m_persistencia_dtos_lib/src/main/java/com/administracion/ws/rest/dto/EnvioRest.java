/**
 * 
 */
package com.administracion.ws.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.innovargia.salesmanager.dtos.RemDes;

/**
 * @author aruaro
 *
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT) 
public class EnvioRest {
	
	private String idDocumento = "";
	private String contenido = "";
	private String comentario = "";
	private String referencia = "";
	private String factura = "";
	private String idservicio;
	private String descripcion_servicio;
	private int cantidad = 0;
	private int alto = 0;
	private int ancho = 0;
	private int largo = 0;
	private int pesofis = 0;
	private String tipoMedidaDimensiones;
	private String tipoMedidaPeso;
	private String tipoServicioEntrega;
	private String tipoServicioRecoleccion;
	
	public RemDesRest remitente = new RemDesRest();
	public RemDesRest destinatario = new RemDesRest();
	private double montoAsegurado;
	private String tipoMoneda;
	/**
	 * @return the idDocumento
	 */
	public String getIdDocumento() {
		return idDocumento;
	}
	/**
	 * @param idDocumento the idDocumento to set
	 */
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}
	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}
	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}
	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}
	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}
	/**
	 * @param alto the alto to set
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}
	/**
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}
	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	/**
	 * @return the largo
	 */
	public int getLargo() {
		return largo;
	}
	/**
	 * @param largo the largo to set
	 */
	public void setLargo(int largo) {
		this.largo = largo;
	}
	/**
	 * @return the pesofis
	 */
	public int getPesofis() {
		return pesofis;
	}
	/**
	 * @param pesofis the pesofis to set
	 */
	public void setPesofis(int pesofis) {
		this.pesofis = pesofis;
	}
	/**
	 * @return the remitente
	 */
	public RemDesRest getRemitente() {
		return remitente;
	}
	/**
	 * @param remitente the remitente to set
	 */
	public void setRemitente(RemDesRest remitente) {
		this.remitente = remitente;
	}
	/**
	 * @return the destinatario
	 */
	public RemDesRest getDestinatario() {
		return destinatario;
	}
	/**
	 * @param destinatario the destinatario to set
	 */
	public void setDestinatario(RemDesRest destinatario) {
		this.destinatario = destinatario;
	}
	/**
	 * @return the montoAsegurado
	 */
	public double getMontoAsegurado() {
		return montoAsegurado;
	}
	/**
	 * @param montoAsegurado the montoAsegurado to set
	 */
	public void setMontoAsegurado(double montoAsegurado) {
		this.montoAsegurado = montoAsegurado;
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
	 * @return the descripcion_servicio
	 */
	public String getDescripcion_servicio() {
		return descripcion_servicio;
	}
	/**
	 * @param descripcion_servicio the descripcion_servicio to set
	 */
	public void setDescripcion_servicio(String descripcion_servicio) {
		this.descripcion_servicio = descripcion_servicio;
	}
	/**
	 * @return the factura
	 */
	public String getFactura() {
		return factura;
	}
	/**
	 * @param factura the factura to set
	 */
	public void setFactura(String factura) {
		this.factura = factura;
	}
	/**
	 * @return the tipoMedidaDimensiones
	 */
	public String getTipoMedidaDimensiones() {
		return tipoMedidaDimensiones;
	}
	/**
	 * @param tipoMedidaDimensiones the tipoMedidaDimensiones to set
	 */
	public void setTipoMedidaDimensiones(String tipoMedidaDimensiones) {
		this.tipoMedidaDimensiones = tipoMedidaDimensiones;
	}
	/**
	 * @return the tipoMedidaPeso
	 */
	public String getTipoMedidaPeso() {
		return tipoMedidaPeso;
	}
	/**
	 * @param tipoMedidaPeso the tipoMedidaPeso to set
	 */
	public void setTipoMedidaPeso(String tipoMedidaPeso) {
		this.tipoMedidaPeso = tipoMedidaPeso;
	}
	/**
	 * @return the tipoMoneda
	 */
	public String getTipoMoneda() {
		return tipoMoneda;
	}
	/**
	 * @param tipoMoneda the tipoMoneda to set
	 */
	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	/**
	 * @return the tipoServicioEntrega
	 */
	public String getTipoServicioEntrega() {
		return tipoServicioEntrega;
	}
	/**
	 * @param tipoServicioEntrega the tipoServicioEntrega to set
	 */
	public void setTipoServicioEntrega(String tipoServicioEntrega) {
		this.tipoServicioEntrega = tipoServicioEntrega;
	}
	/**
	 * @return the tipoServicioRecoleccion
	 */
	public String getTipoServicioRecoleccion() {
		return tipoServicioRecoleccion;
	}
	/**
	 * @param tipoServicioRecoleccion the tipoServicioRecoleccion to set
	 */
	public void setTipoServicioRecoleccion(String tipoServicioRecoleccion) {
		this.tipoServicioRecoleccion = tipoServicioRecoleccion;
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
}
