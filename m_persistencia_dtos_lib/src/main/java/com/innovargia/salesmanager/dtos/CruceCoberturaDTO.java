/**
 * 
 */
package com.innovargia.salesmanager.dtos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aruaro
 *
 */
public class CruceCoberturaDTO {

	  String idcoorigen ;
	  String idcodestino ;
	  String garantiamax ;
	  String enrutamiento ;
	  String zonaventa ;
	  String numcliente;
	  String transbordo;
	  String idservicio;
	  String terminal_ori; 
	  String terminal_des;
	  String transbordo_destino;
	  String dias_entrega_origen_destino;
	  String calculaprecios;
	  String rutaentrega;
	  
	  String tipo_transporte ;
	  String terminal_destino_aux;
	  List<CruceCoberturaDTO> lista_transbordos = new ArrayList<CruceCoberturaDTO>();
	  
	
	  
	  int nivel_reexpedicion_foraneo;
	  int convenio;
	  int tarifa;
	  int tiempo ;
	  int  mismodia ;
	  float kms;
	  float precio;
	  float precio_unitario;
	  /**
	 * 
	 */
	public CruceCoberturaDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the idcoorigen
	 */
	public String getIdcoorigen() {
		return idcoorigen;
	}
	/**
	 * @param idcoorigen the idcoorigen to set
	 */
	public void setIdcoorigen(String idcoorigen) {
		this.idcoorigen = idcoorigen;
	}
	/**
	 * @return the idcodestino
	 */
	public String getIdcodestino() {
		return idcodestino;
	}
	/**
	 * @param idcodestino the idcodestino to set
	 */
	public void setIdcodestino(String idcodestino) {
		this.idcodestino = idcodestino;
	}
	/**
	 * @return the kms
	 */
	public float getKms() {
		return kms;
	}
	/**
	 * @param kms the kms to set
	 */
	public void setKms(float kms) {
		this.kms = kms;
	}
	
	public void setKms(String kms) {
	    try{
		this.kms = Float.parseFloat(kms);
	    }catch(Exception e){
		this.kms = 0; 
	    }
		
	}
	/**
	 * @return the garantiamax
	 */
	public String getGarantiamax() {
		return garantiamax;
	}
	/**
	 * @param garantiamax the garantiamax to set
	 */
	public void setGarantiamax(String garantiamax) {
		this.garantiamax = garantiamax;
	}
	/**
	 * @return the mismodia
	 */
	public int getMismodia() {
		return mismodia;
	}
	/**
	 * @param mismodia the mismodia to set
	 */
	public void setMismodia(int mismodia) {
		this.mismodia = mismodia;
	}
	/**
	 * @return the enrutamiento
	 */
	public String getEnrutamiento() {
		return enrutamiento;
	}
	/**
	 * @param enrutamiento the enrutamiento to set
	 */
	public void setEnrutamiento(String enrutamiento) {
		this.enrutamiento = enrutamiento;
	}
	/**
	 * @return the tiempo
	 */
	public int getTiempo() {
		return tiempo;
	}
	/**
	 * @param tiempo the tiempo to set
	 */
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	/**
	 * @return the zonaventa
	 */
	public String getZonaventa() {
		return zonaventa;
	}
	/**
	 * @param zonaventa the zonaventa to set
	 */
	public void setZonaventa(String zonaventa) {
		this.zonaventa = zonaventa;
	}
	/**
	 * @return the convenio
	 */
	public int getConvenio() {
		return convenio;
	}
	/**
	 * @param convenio the convenio to set
	 */
	public void setConvenio(int convenio) {
		this.convenio = convenio;
	}
	/**
	 * @return the tarifa
	 */
	public int getTarifa() {
		return tarifa;
	}
	/**
	 * @param tarifa the tarifa to set
	 */
	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}
	/**
	 * @return the numcliente
	 */
	public String getNumcliente() {
		return numcliente;
	}
	/**
	 * @param numcliente the numcliente to set
	 */
	public void setNumcliente(String numcliente) {
		this.numcliente = numcliente;
	}
	/**
	 * @return the transbordo
	 */
	public String getTransbordo() {
		return transbordo;
	}
	/**
	 * @param transbordo the transbordo to set
	 */
	public void setTransbordo(String transbordo) {
		this.transbordo = transbordo;
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
	 * @return the transbordo_destino
	 */
	public String getTransbordo_destino() {
		return transbordo_destino;
	}
	/**
	 * @param transbordo_destino the transbordo_destino to set
	 */
	public void setTransbordo_destino(String transbordo_destino) {
		this.transbordo_destino = transbordo_destino;
	}
	/**
	 * @return the nivel_reexpedicion_foraneo
	 */
	public int getNivel_reexpedicion_foraneo() {
		return nivel_reexpedicion_foraneo;
	}
	/**
	 * @param nivel_reexpedicion_foraneo the nivel_reexpedicion_foraneo to set
	 */
	public void setNivel_reexpedicion_foraneo(int nivel_reexpedicion_foraneo) {
		this.nivel_reexpedicion_foraneo = nivel_reexpedicion_foraneo;
	}
	/**
	 * @return the dias_entrega_origen_destino
	 */
	public String getDias_entrega_origen_destino() {
		return dias_entrega_origen_destino;
	}
	/**
	 * @param dias_entrega_origen_destino the dias_entrega_origen_destino to set
	 */
	public void setDias_entrega_origen_destino(String dias_entrega_origen_destino) {
		this.dias_entrega_origen_destino = dias_entrega_origen_destino;
	}
	/**
	 * @return the terminal_ori
	 */
	public String getTerminal_ori() {
		return terminal_ori;
	}
	/**
	 * @param terminal_ori the terminal_ori to set
	 */
	public void setTerminal_ori(String terminal_ori) {
		this.terminal_ori = terminal_ori;
	}
	/**
	 * @return the terminal_des
	 */
	public String getTerminal_des() {
		return terminal_des;
	}
	/**
	 * @param terminal_des the terminal_des to set
	 */
	public void setTerminal_des(String terminal_des) {
		this.terminal_des = terminal_des;
	}
	/**
	 * @return the tipo_transporte
	 */
	public String getTipo_transporte() {
		return tipo_transporte;
	}
	/**
	 * @param tipo_transporte the tipo_transporte to set
	 */
	public void setTipo_transporte(String tipo_transporte) {
		this.tipo_transporte = tipo_transporte;
	}
	/**
	 * @return the terminal_destino_aux
	 */
	public String getTerminal_destino_aux() {
		return terminal_destino_aux;
	}
	/**
	 * @param terminal_destino_aux the terminal_destino_aux to set
	 */
	public void setTerminal_destino_aux(String terminal_destino_aux) {
		this.terminal_destino_aux = terminal_destino_aux;
	}
	/**
	 * @return the lista_transbordos
	 */
	public List<CruceCoberturaDTO> getLista_transbordos() {
		return lista_transbordos;
	}
	/**
	 * @param lista_transbordos the lista_transbordos to set
	 */
	public void setLista_transbordos(List<CruceCoberturaDTO> lista_transbordos) {
		this.lista_transbordos = lista_transbordos;
	}
	/**
	 * @return the precio
	 */
	public float getPrecio() {
	    return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
	    this.precio = precio; 
	}
	/**
	 * @return the precio_unitario
	 */
	public float getPrecio_unitario() {
	    return precio_unitario;
	}
	/**
	 * @param precio_unitario the precio_unitario to set
	 */
	public void setPrecio_unitario(float precio_unitario) {
	    this.precio_unitario = precio_unitario;
	}
	/**
	 * @return the calculaprecios
	 */
	public String getCalculaprecios() {
	    return calculaprecios;
	}
	/**
	 * @param calculaprecios the calculaprecios to set
	 */
	public void setCalculaprecios(String calculaprecios) {
	    this.calculaprecios = calculaprecios;
	}
	/**
	 * @return the rutaentrega
	 */
	public String getRutaentrega() {
	    return rutaentrega;
	}
	/**
	 * @param rutaentrega the rutaentrega to set
	 */
	public void setRutaentrega(String rutaentrega) {
	    this.rutaentrega = rutaentrega;
	}

}
