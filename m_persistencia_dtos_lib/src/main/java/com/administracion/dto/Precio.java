/**
 * 
 */
package com.administracion.dto;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class Precio implements Serializable {

	private static final long serialVersionUID = 1L;
	private double  precioServicio=0;
	private double  costoadicionales=0;
	private double seguro=0;
	private double  costosobrepeso=0;
	private double  costoflete=0;
	private double  costoentregadom=0;
	private double  costorecoleccion=0;
	private double  costoacuse=0;
	private double  costofleje=0;
	private double  costoOtros=0;
	
	private double  porcentajedescuento=0;
	private double  porcentajeIva=0;
	private double  porcentajeRetencion=0;
	
	private double  descuentoneto=0;
	private double  ivaneto=0;
	private double  importe=0;
	private double importeNeto=0;
	
	private double totalAdicional=0;

	private double seguroBultos=0;
	private double seguroTotal=0;
	private double subtotal =0;

	private double totalIva=0;
	private double totalRetencion=0;

	private String idsevicio;
	private String descripcionsevicio;
	private String cporigen;
	private String cpdestino;
	private String tipoCobro;
	private String generaRetencion;
	private double  pesoVol;
	private double  pesoFisico;
	private int  cantidad_paquetes;


	

	
	
	public ArrayList<String> arr_idsServiciosComplementarios = new ArrayList<String>(); 
	
	/**
	 * Obtiene le subtotal SIN iva
	 * @return this.precioServicio+ this.totalAdicional + this.seguroTotal
	 */
	public double getSubtotal(){
		return this.precioServicio+ this.totalAdicional + getTotalSeguro();
	}
	
	public double getSubtotalNeto(){
		return this.subtotal;
	}
	/** 
	 * Obtiene el total del iva a cobrar si solo si el iva es mayor de cero
	 * @return return subtotal() * getPorcentajeIva();
	 */
	public double getTotalIva(){
		if (getPorcentajeIva()>0){
			return getSubtotal() * getPorcentajeIva();
		}
		return 0;
	}
	/** 
	 * Obtiene el total de retencion si solo si la retencion es mayor de cero
	 * @return return subtotal() * getPorcentajeRetencion();
	 */
	public double getTotalRetencion(){
		if (getPorcentajeRetencion()>0){
			return getSubtotal() * getPorcentajeRetencion();
		}
		return 0;
	}
	public double getTotalRetencionNeto(){
		return this.totalRetencion;
	}
	/**
	 * Obtiene el total de seguro si solo si la getSeguroBultos y 
	 * getCantidad_paquetes es mayor de cero
	 * @return return subtotal() * getPorcentajeRetencion();
	 */
	public double getTotalSeguro(){
		
		if ((getSeguroBultos()>0) && (getCantidad_paquetes()>0)){
			return getSeguroBultos() * getCantidad_paquetes();
		}
		return 0;
	}
	
	/**
	 * Calcula el importe neto
	 * @return subtotal()+totalIva()+totalRetencion()+totalSeguro()
	 */
	public double getImporteTotal(){
		return getSubtotal()+getTotalIva()+ getTotalRetencion()+ getTotalSeguro();
	}
	/**
	 * @return the precioServicio
	 */
	public double getPrecioServicio() {
		return precioServicio;
	}
	/**
	 * @param precioServicio the precioServicio to set
	 */
	public void setPrecioServicio(double precioServicio) {
		this.precioServicio = precioServicio;
	}
	/**
	 * @return the totalAdicional
	 */
	public double getTotalAdicional() {
		return totalAdicional;
	}
	/**
	 * @param totalAdicional the totalAdicional to set
	 */
	public void setTotalAdicional(double totalAdicional) {
		this.totalAdicional = totalAdicional;
	}
	/**
	 * @return the seguro
	 */
	public double getSeguro() {
		return seguro;
	}
	/**
	 * @param seguro the seguro to set
	 */
	public void setSeguro(double seguro) {
		this.seguro = seguro;
	}
	/**
	 * @return the subtotal
	 */
	//public double getSubtotal() {
	//	return subtotal;
	//}
	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	/**
	 * return (this.porcentajeIva/100);
	 * @return the porcentajeIva
	 */
	public double getPorcentajeIva() {
		if (this.porcentajeIva>0){
			return (this.porcentajeIva/100);
		}
		return porcentajeIva;
	}
	public double getPorcentajeIvaNeto() {
		return porcentajeIva;
	}
	/**
	 * @param porcentajeIva the porcentajeIva to set
	 */
	public void setPorcentajeIva(double porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}
	/**
	 * this.porcentajeRetencion/100
	 * 
	 * @return the porcentajeRetencion
	 */
	public double getPorcentajeRetencion() {
		if (this.porcentajeRetencion>0){
			return (this.porcentajeRetencion/100);
		}
		return porcentajeRetencion;
	}
	public double getPorcentajeRetencionNeto() {
		return porcentajeRetencion;
	}
	/**
	 * @param porcentajeRetencion the porcentajeRetencion to set
	 */
	public void setPorcentajeRetencion(double porcentajeRetencion) {
		this.porcentajeRetencion = porcentajeRetencion;
	}
	/**
	 * @return the totalIva
	 */
	//public double getTotalIva() {
	//	return totalIva;
	//}
	/**
	 * @param totalIva the totalIva to set
	 */
	public void setTotalIva(double totalIva) {
		this.totalIva = totalIva;
	}
	/**
	 * @return the totalRetencion
	 */
	//public double getTotalRetencion() {
	//	return totalRetencion;
	//}
	/**
	 * @param totalRetencion the totalRetencion to set
	 */
	public void setTotalRetencion(double totalRetencion) {
		this.totalRetencion = totalRetencion;
	}
	/**
	 * @return the importeNeto
	 */
	public double getImporteNeto() {
		return importeNeto;
	}
	/**
	 * @param importeNeto the importeNeto to set
	 */
	public void setImporteNeto(double importeNeto) {
		this.importeNeto = importeNeto;
	}
	/**
	 * @return the idsevicio
	 */
	public String getIdsevicio() {
		return idsevicio;
	}
	/**
	 * @param idsevicio the idsevicio to set
	 */
	public void setIdsevicio(String idsevicio) {
		this.idsevicio = idsevicio;
	}
	/**
	 * @return the cporigen
	 */
	public String getCporigen() {
		return cporigen;
	}
	/**
	 * @param cporigen the cporigen to set
	 */
	public void setCporigen(String cporigen) {
		this.cporigen = cporigen;
	}
	/**
	 * @return the cpdestino
	 */
	public String getCpdestino() {
		return cpdestino;
	}
	/**
	 * @param cpdestino the cpdestino to set
	 */
	public void setCpdestino(String cpdestino) {
		this.cpdestino = cpdestino;
	}
	/**
	 * @return the tipoCobro
	 */
	public String getTipoCobro() {
		return tipoCobro;
	}
	/**
	 * @param tipoCobro the tipoCobro to set
	 */
	public void setTipoCobro(String tipoCobro) {
		this.tipoCobro = tipoCobro;
	}
	/**
	 * @return the generaRetencion
	 */
	public String getGeneraRetencion() {
		return generaRetencion;
	}
	/**
	 * @param generaRetencion the generaRetencion to set
	 */
	public void setGeneraRetencion(String generaRetencion) {
		this.generaRetencion = generaRetencion;
	}
	/**
	 * @return the pesoVol
	 */
	public double getPesoVol() {
		return pesoVol;
	}
	/**
	 * @param pesoVol the pesoVol to set
	 */
	public void setPesoVol(double pesoVol) {
		this.pesoVol = pesoVol;
	}
	/**
	 * @return the pesoFisico
	 */
	public double getPesoFisico() {
		return pesoFisico;
	}
	/**
	 * @param pesoFisico the pesoFisico to set
	 */
	public void setPesoFisico(double pesoFisico) {
		this.pesoFisico = pesoFisico;
	}
	/**
	 * @return the descripcionsevicio
	 */
	public String getDescripcionsevicio() {
		return descripcionsevicio;
	}
	/**
	 * @param descripcionsevicio the descripcionsevicio to set
	 */
	public void setDescripcionsevicio(String descripcionsevicio) {
		this.descripcionsevicio = descripcionsevicio;
	}
	/**
	 * @return the seguroBultos
	 */
	public double getSeguroBultos() {
		return seguroBultos;
	}
	/**
	 * @param seguroBultos the seguroBultos to set
	 */
	public void setSeguroBultos(double seguroBultos) {
		this.seguroBultos = seguroBultos;
	}
	/**
	 * @return the seguroTotal
	 */
	public double getSeguroTotal() {
		return seguroTotal;
	}
	/**
	 * @param seguroTotal the seguroTotal to set
	 */
	public void setSeguroTotal(double seguroTotal) {
		this.seguroTotal = seguroTotal;
	}
	/**
	 * @return the cantidad_paquetes
	 */
	public int getCantidad_paquetes() {
		return cantidad_paquetes;
	}
	/**
	 * @param cantidad_paquetes the cantidad_paquetes to set
	 */
	public void setCantidad_paquetes(int cantidad_paquetes) {
		this.cantidad_paquetes = cantidad_paquetes;
	}

	/**
	 * @return the costoadicionales
	 */
	public double getCostoadicionales() {
		return costoadicionales;
	}

	/**
	 * @param costoadicionales the costoadicionales to set
	 */
	public void setCostoadicionales(double costoadicionales) {
		this.costoadicionales = costoadicionales;
	}

	/**
	 * @return the costosobrepeso
	 */
	public double getCostosobrepeso() {
		return costosobrepeso;
	}

	/**
	 * @param costosobrepeso the costosobrepeso to set
	 */
	public void setCostosobrepeso(double costosobrepeso) {
		this.costosobrepeso = costosobrepeso;
	}

	/**
	 * @return the costoflete
	 */
	public double getCostoflete() {
		return costoflete;
	}

	/**
	 * @param costoflete the costoflete to set
	 */
	public void setCostoflete(double costoflete) {
		this.costoflete = costoflete;
	}

	/**
	 * @return the costoentregadom
	 */
	public double getCostoentregadom() {
		return costoentregadom;
	}

	/**
	 * @param costoentregadom the costoentregadom to set
	 */
	public void setCostoentregadom(double costoentregadom) {
		this.costoentregadom = costoentregadom;
	}

	/**
	 * @return the costorecoleccion
	 */
	public double getCostorecoleccion() {
		return costorecoleccion;
	}

	/**
	 * @param costorecoleccion the costorecoleccion to set
	 */
	public void setCostorecoleccion(double costorecoleccion) {
		this.costorecoleccion = costorecoleccion;
	}

	/**
	 * @return the costoacuse
	 */
	public double getCostoacuse() {
		return costoacuse;
	}

	/**
	 * @param costoacuse the costoacuse to set
	 */
	public void setCostoacuse(double costoacuse) {
		this.costoacuse = costoacuse;
	}

	/**
	 * @return the costofleje
	 */
	public double getCostofleje() {
		return costofleje;
	}

	/**
	 * @param costofleje the costofleje to set
	 */
	public void setCostofleje(double costofleje) {
		this.costofleje = costofleje;
	}

	/**
	 * @return the porcentajedescuento
	 */
	public double getPorcentajedescuento() {
		return porcentajedescuento;
	}

	/**
	 * @param porcentajedescuento the porcentajedescuento to set
	 */
	public void setPorcentajedescuento(double porcentajedescuento) {
		this.porcentajedescuento = porcentajedescuento;
	}

	/**
	 * @return the descuentoneto
	 */
	public double getDescuentoneto() {
		return descuentoneto;
	}

	/**
	 * @param descuentoneto the descuentoneto to set
	 */
	public void setDescuentoneto(double descuentoneto) {
		this.descuentoneto = descuentoneto;
	}

	/**
	 * @return the ivaneto
	 */
	public double getIvaneto() {
		return ivaneto;
	}

	/**
	 * @param ivaneto the ivaneto to set
	 */
	public void setIvaneto(double ivaneto) {
		this.ivaneto = ivaneto;
	}

	/**
	 * @return the importe
	 */
	public double getImporte() {
		return importe;
	}

	/**
	 * @param importe the importe to set
	 */
	public void setImporte(double importe) {
		this.importe = importe;
	}

	/**
	 * @return the costoOtros
	 */
	public double getCostoOtros() {
		return costoOtros;
	}

	/**
	 * @param costoOtros the costoOtros to set
	 */
	public void setCostoOtros(double costoOtros) {
		this.costoOtros = costoOtros;
	}



}
