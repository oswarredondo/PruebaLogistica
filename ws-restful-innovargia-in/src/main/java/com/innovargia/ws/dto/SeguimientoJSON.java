package com.innovargia.ws.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeguimientoJSON implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected Seguimiento seguimiento=new Seguimiento();
	protected EntregaWS entrega=new EntregaWS();
	protected DatosEtiqueta datosEtiqueta=new DatosEtiqueta();
	protected FirmaFoto firmaFoto =new FirmaFoto();
	protected Direccion direccion =new Direccion();
	protected Recoleccion recoleccion =new  Recoleccion();
	protected OrdenRecoleccion ordenRecoleccion=new OrdenRecoleccion();
	protected Movimiento movimiento=new Movimiento();
	protected RutaUbicacion rutaUbicacion=new RutaUbicacion();
	
	
	public Seguimiento getSeguimiento() {
		return seguimiento;
	}
	public void setSeguimiento(Seguimiento seguimiento) {
		this.seguimiento = seguimiento;
	}
	public EntregaWS getEntrega() {
		return entrega;
	}
	public void setEntrega(EntregaWS entrega) {
		this.entrega = entrega;
	}
	public DatosEtiqueta getDatosEtiqueta() {
		return datosEtiqueta;
	}
	public void setDatosEtiqueta(DatosEtiqueta datosEtiqueta) {
		this.datosEtiqueta = datosEtiqueta;
	}
	public FirmaFoto getFirmaFoto() {
		return firmaFoto;
	}
	public void setFirmaFoto(FirmaFoto firmaFoto) {
		this.firmaFoto = firmaFoto;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public Recoleccion getRecoleccion() {
		return recoleccion;
	}
	public void setRecoleccion(Recoleccion recoleccion) {
		this.recoleccion = recoleccion;
	}
	public OrdenRecoleccion getOrdenRecoleccion() {
		return ordenRecoleccion;
	}
	public void setOrdenRecoleccion(OrdenRecoleccion ordenRecoleccion) {
		this.ordenRecoleccion = ordenRecoleccion;
	}
	public Movimiento getMovimiento() {
		return movimiento;
	}
	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}
	public RutaUbicacion getRutaUbicacion() {
		return rutaUbicacion;
	}
	public void setRutaUbicacion(RutaUbicacion rutaUbicacion) {
		this.rutaUbicacion = rutaUbicacion;
	}
	
	

}
