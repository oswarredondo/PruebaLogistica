package com.administracion.dto;

import java.io.Serializable;

public class FacturaGuia implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String razonsocial;
	String iddocumento;
	String iddocumentomadre;
	//Aseguradas
	String contenido;
	String valorasegurado;
	//Adicionales
	String numcliente;
	String exclave;
	String fechaevento;
	String descripcion;
	//Servicios especiales 
	String nombre;
	String cantidad;
	String subtotal;
	//Sobre peso
	String peso_amparado;
	String peso_max_cliente;
	String peso_max_medido;
	String peso_max_calculado;
	String precio_kg_sp;
	String kg_sobrepeso;
	String monto_sobrepeso;
	//Re expedición
	String cp;
	String precio_reexpedicion;
	
	String fecha;
	String tipo;
	String referencia;
	String fechaentrega;
	String factura;
	String isfacturada;
	String estatus;
	String tiposervicio;
	String marcafactura;
	String zonaori;
	String zonades;
	String zonaventa;
	String largo;
	String ancho;
	String alto;
	String pesofisico;
	String pesovolumetrico;
	String precio;
	String fechacorte;
	
	public String getRazonsocial() {
		return razonsocial;
	}
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}
	public String getIddocumento() {
		return iddocumento;
	}
	public void setIddocumento(String iddocumento) {
		this.iddocumento = iddocumento;
	}
	public String getIddocumentomadre() {
		return iddocumentomadre;
	}
	public void setIddocumentomadre(String iddocumentomadre) {
		this.iddocumentomadre = iddocumentomadre;
	}
	public String getNumcliente() {
		return numcliente;
	}
	public void setNumcliente(String numcliente) {
		this.numcliente = numcliente;
	}
	public String getExclave() {
		return exclave;
	}
	public void setExclave(String exclave) {
		this.exclave = exclave;
	}
	public String getFechaevento() {
		return fechaevento;
	}
	public void setFechaevento(String fechaevento) {
		this.fechaevento = fechaevento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	public String getPeso_amparado() {
		return peso_amparado;
	}
	public void setPeso_amparado(String peso_amparado) {
		this.peso_amparado = peso_amparado;
	}
	public String getPeso_max_cliente() {
		return peso_max_cliente;
	}
	public void setPeso_max_cliente(String peso_max_cliente) {
		this.peso_max_cliente = peso_max_cliente;
	}
	public String getPeso_max_medido() {
		return peso_max_medido;
	}
	public void setPeso_max_medido(String peso_max_medido) {
		this.peso_max_medido = peso_max_medido;
	}
	public String getPeso_max_calculado() {
		return peso_max_calculado;
	}
	public void setPeso_max_calculado(String peso_max_calculado) {
		this.peso_max_calculado = peso_max_calculado;
	}
	public String getPrecio_kg_sp() {
		return precio_kg_sp;
	}
	public void setPrecio_kg_sp(String precio_kg_sp) {
		this.precio_kg_sp = precio_kg_sp;
	}
	public String getKg_sobrepeso() {
		return kg_sobrepeso;
	}
	public void setKg_sobrepeso(String kg_sobrepeso) {
		this.kg_sobrepeso = kg_sobrepeso;
	}
	public String getMonto_sobrepeso() {
		return monto_sobrepeso;
	}
	public void setMonto_sobrepeso(String monto_sobrepeso) {
		this.monto_sobrepeso = monto_sobrepeso;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getPrecio_reexpedicion() {
		return precio_reexpedicion;
	}
	public void setPrecio_reexpedicion(String precio_reexpedicion) {
		this.precio_reexpedicion = precio_reexpedicion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getFechaentrega() {
		return fechaentrega;
	}
	public void setFechaentrega(String fechaentrega) {
		this.fechaentrega = fechaentrega;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public String getIsfacturada() {
		return isfacturada;
	}
	public void setIsfacturada(String isfacturada) {
		this.isfacturada = isfacturada;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getTiposervicio() {
		return tiposervicio;
	}
	public void setTiposervicio(String tiposervicio) {
		this.tiposervicio = tiposervicio;
	}
	public String getMarcafactura() {
		return marcafactura;
	}
	public void setMarcafactura(String marcafactura) {
		this.marcafactura = marcafactura;
	}
	public String getZonaori() {
		return zonaori;
	}
	public void setZonaori(String zonaori) {
		this.zonaori = zonaori;
	}
	public String getZonades() {
		return zonades;
	}
	public void setZonades(String zonades) {
		this.zonades = zonades;
	}
	public String getZonaventa() {
		return zonaventa;
	}
	public void setZonaventa(String zonaventa) {
		this.zonaventa = zonaventa;
	}
	public String getLargo() {
		return largo;
	}
	public void setLargo(String largo) {
		this.largo = largo;
	}
	public String getAncho() {
		return ancho;
	}
	public void setAncho(String ancho) {
		this.ancho = ancho;
	}
	public String getAlto() {
		return alto;
	}
	public void setAlto(String alto) {
		this.alto = alto;
	}
	public String getPesofisico() {
		return pesofisico;
	}
	public void setPesofisico(String pesofisico) {
		this.pesofisico = pesofisico;
	}
	public String getPesovolumetrico() {
		return pesovolumetrico;
	}
	public void setPesovolumetrico(String pesovolumetrico) {
		this.pesovolumetrico = pesovolumetrico;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getFechacorte() {
		return fechacorte;
	}
	public void setFechacorte(String fechacorte) {
		this.fechacorte = fechacorte;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getValorasegurado() {
		return valorasegurado;
	}
	public void setValorasegurado(String valorasegurado) {
		this.valorasegurado = valorasegurado;
	}
}
