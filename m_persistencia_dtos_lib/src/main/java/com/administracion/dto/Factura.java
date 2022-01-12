/**
 * 
 */
package com.administracion.dto;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class Factura  implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int idcontrol ;
	 String dia ;
	 String  cliente ;
	 String  login ;
	 String  idcontrolenvio ;
	 String  login_cancela ;
	 String  fecha_cancela;
	 String   factura ;
	 String   fac_nota ;
	 String   fecha_notacredito ;
	 String   login_notacredito ;
	 String   nombreMes ;
	 String   estatus ;
	 
	 String   tipo ;
	 String tipoB;
	 String prctr;
	 
	 String	t_txt_oper;
	 String t_txt_head ;
	 
	 String auart;
	 String vkorg;
	 String vtweg;
	 String werks;
	 String vstel;
	 
	 int  mes ;
	 int  anio ;
	 int  cantidad ;
	 
	 int idformapagofactura;
	 
	 int idconvenio;
	 int idtarifa;
	 
	public int getIdcontrol() {
		return idcontrol;
	}
	public void setIdcontrol(int idcontrol) {
		this.idcontrol = idcontrol;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getIdcontrolenvio() {
		return idcontrolenvio;
	}
	public void setIdcontrolenvio(String idcontrolenvio) {
		this.idcontrolenvio = idcontrolenvio;
	}
	public String getLogin_cancela() {
		return login_cancela;
	}
	public void setLogin_cancela(String login_cancela) {
		this.login_cancela = login_cancela;
	}
	public String getFecha_cancela() {
		return fecha_cancela;
	}
	public void setFecha_cancela(String fecha_cancela) {
		this.fecha_cancela = fecha_cancela;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public String getNombreMes() {
		return nombreMes;
	}
	public void setNombreMes(String nombreMes) {
		this.nombreMes = nombreMes;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getT_txt_oper() {
		return t_txt_oper;
	}
	public void setT_txt_oper(String t_txt_oper) {
		this.t_txt_oper = t_txt_oper;
	}
	public String getT_txt_head() {
		return t_txt_head;
	}
	public void setT_txt_head(String t_txt_head) {
		this.t_txt_head = t_txt_head;
	}
	public String getFac_nota() {
		return fac_nota;
	}
	public void setFac_nota(String fac_nota) {
		this.fac_nota = fac_nota;
	}
	public String getFecha_notacredito() {
		return fecha_notacredito;
	}
	public void setFecha_notacredito(String fecha_notacredito) {
		this.fecha_notacredito = fecha_notacredito;
	}
	public String getLogin_notacredito() {
		return login_notacredito;
	}
	public void setLogin_notacredito(String login_notacredito) {
		this.login_notacredito = login_notacredito;
	}
	/**
	 * @return the idformapagofactura
	 */
	public int getIdformapagofactura() {
		return idformapagofactura;
	}
	/**
	 * @param idformapagofactura the idformapagofactura to set
	 */
	public void setIdformapagofactura(int idformapagofactura) {
		this.idformapagofactura = idformapagofactura;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public String getTipoB() {
		return tipoB;
	}
	public void setTipoB(String tipoB) {
		this.tipoB = tipoB;
	}
	
	public String getPrctr() {
		return prctr;
	}
	public void setPrctr(String prctr) {
		this.prctr = prctr;
	}
	/**
	 * @return the idconvenio
	 */
	public int getIdconvenio() {
		return idconvenio;
	}
	/**
	 * @param idconvenio the idconvenio to set
	 */
	public void setIdconvenio(int idconvenio) {
		this.idconvenio = idconvenio;
	}
	/**
	 * @return the idtarifa
	 */
	public int getIdtarifa() {
		return idtarifa;
	}
	/**
	 * @param idtarifa the idtarifa to set
	 */
	public void setIdtarifa(int idtarifa) {
		this.idtarifa = idtarifa;
	}
	 public String getAuart() {
		return auart;
	}
	public void setAuart(String auart) {
		this.auart = auart;
	}
	public String getVkorg() {
		return vkorg;
	}
	public void setVkorg(String vkorg) {
		this.vkorg = vkorg;
	}
	public String getVtweg() {
		return vtweg;
	}
	public void setVtweg(String vtweg) {
		this.vtweg = vtweg;
	}
	public String getWerks() {
		return werks;
	}
	public void setWerks(String werks) {
		this.werks = werks;
	}
	public String getVstel() {
		return vstel;
	}
	public void setVstel(String vstel) {
		this.vstel = vstel;
	}
	  
}
