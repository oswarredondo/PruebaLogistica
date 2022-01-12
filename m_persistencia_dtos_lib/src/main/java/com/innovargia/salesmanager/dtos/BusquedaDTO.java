/**
 * 
 */
package com.innovargia.salesmanager.dtos;

import java.io.Serializable;

/**
 * Propiedades de un catalogo formas de pago, metodo de pago, GrupoCliente
 * etc
 * @author aruaro
 *
 */
public class BusquedaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int identificador;
	int identidad;
	int idorganizacion;
	int idregistro;
	int idcliente;
	int idtarifa;
	int mes;
	int idformapago;
	int iddescuento;
	String zona;
	String identificador_str;
	String clave;
	String nombre;
	String descripcion;
	int estatus;
	int tipo;
	String tipo_str; 
	String patron_busqueda;
	String fechainicial;
	String fechafinal;
	String numcliente;
	int nivel;
	UsuarioDTO usuario;
	boolean ispdv=false;
	
	String restringe_datos_a_solo_estatus="";
	
	//tipobusqueda:tipobusqueda,fechainicial:fechainicial,fechafinal:fechafinal,patron:patron
	
	/**
	 * 
	 */
	public BusquedaDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		try{
			this.identificador = Integer.parseInt(identificador);	
		}catch(Exception e){
			
		}
	}
	
	public void setIdentificador(int identificador) {

			this.identificador = identificador;	

	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstatus() {
		return estatus;
	}

	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public void setTipo(String tipo) {
		try{
			this.tipo = Integer.parseInt(tipo);	
		}catch(Exception e){
			
		}
		
	}

	public String getTipo_str() {
		return tipo_str;
	}

	public void setTipo_str(String tipo_str) {
		this.tipo_str = tipo_str;
	}

	public String getPatron_busqueda() {
		return patron_busqueda;
	}

	public void setPatron_busqueda(String patron_busqueda) {
		this.patron_busqueda = patron_busqueda;
	}

	public String getIdentificador_str() {
		return identificador_str;
	}

	public void setIdentificador_str(String identificador_str) {
		this.identificador_str = identificador_str;
	}

	/**
	 * @return the fechainicial
	 */
	public String getFechainicial() {
		return fechainicial;
	}

	/**
	 * @param fechainicial the fechainicial to set
	 */
	public void setFechainicial(String fechainicial) {
		this.fechainicial = fechainicial;
	}

	/**
	 * @return the fechafina
	 */
	public String getFechafinal() {
		return fechafinal;
	}

	/**
	 * @param fechafina the fechafina to set
	 */
	public void setFechafinal(String fechafinal) {
		this.fechafinal = fechafinal;
	}

	/**
	 * @return the idregistro
	 */
	public int getIdregistro() {
		return idregistro;
	}

	/**
	 * @param idregistro the idregistro to set
	 */
	public void setIdregistro(int idregistro) {
		this.idregistro = idregistro;
	}

	/**
	 * @return the idcliente
	 */
	public int getIdcliente() {
		return idcliente;
	}

	/**
	 * @param idcliente the idcliente to set
	 */
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	
	/**
	 * @param idcliente the idtarifa to set
	 */
	public void setIdcliente(String idcliente) {
		try{
			this.idcliente = Integer.parseInt(idcliente);
		}catch(Exception e){
			this.idcliente =-1;
		}
		
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
	
	/**
	 * @param idtarifa the idtarifa to set
	 */
	public void setIdtarifa(String idtarifa) {
		try{
			this.idtarifa = Integer.parseInt(idtarifa);
		}catch(Exception e){
			this.idtarifa =-1;
		}
		
	}

	/**
	 * @return the iddescuento
	 */
	public int getIddescuento() {
		return iddescuento;
	}

	/**
	 * @param iddescuento the iddescuento to set
	 */
	public void setIddescuento(int iddescuento) {
		this.iddescuento = iddescuento;
	}

	
	/**
	 * @param iddescuento the idtarifa to set
	 */
	public void setIddescuento(String iddescuento) {
		try{
			this.iddescuento = Integer.parseInt(iddescuento);
		}catch(Exception e){
			this.iddescuento =-1;
		}
		
	}

	
	/**
	 * @return the zona
	 */
	public String getZona() {
		return zona;
	}

	/**
	 * @param zona the zona to set
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}

	/**
	 * @return the nivel
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getIdentidad() {
		return identidad;
	}

	public void setIdentidad(int identidad) {
		this.identidad = identidad;
	}
	
	public void setIdentidad(String identidad) {
		try{
			this.identidad = Integer.parseInt(identidad);
		}catch(Exception e){
			this.identidad=-1;
		}
		
	}
	

	public int getIdorganizacion() {
		return idorganizacion;
	}

	public void setIdorganizacion(int idorganizacion) {
		this.idorganizacion = idorganizacion;
	}
	
	public void setIdorganizacion(String idorganizacion) {
		try{
			this.idorganizacion = Integer.parseInt(idorganizacion);
		}catch(Exception e){
			this.idorganizacion=-1;
		}
		
	}

	public String getNumcliente() {
		return numcliente;
	}

	public void setNumcliente(String numcliente) {
		this.numcliente = numcliente;
	}

	/**
	 * @return the mes
	 */
	public int getMes() {
		return mes;
	}

	/**
	 * @param mes the mes to set
	 */
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public void setMes(String mes) {
		try{
			this.mes = Integer.parseInt(mes);
		}catch(Exception e){
			this.mes=-1;
		}
		
	}

	/**
	 * @return the usuario
	 */
	public UsuarioDTO getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the ispdv
	 */
	public boolean isIspdv() {
	    return ispdv;
	}

	/**
	 * @param ispdv the ispdv to set
	 */
	public void setIspdv(boolean ispdv) {
	    this.ispdv = ispdv;
	}

	/**
	 * @return the restringe_datos_a_solo_estatus
	 */
	public String getRestringe_datos_a_solo_estatus() {
	    return restringe_datos_a_solo_estatus;
	}

	/**
	 * @param restringe_datos_a_solo_estatus the restringe_datos_a_solo_estatus to set
	 */
	public void setRestringe_datos_a_solo_estatus(
		String restringe_datos_a_solo_estatus) {
	    this.restringe_datos_a_solo_estatus = restringe_datos_a_solo_estatus;
	}

	/**
	 * @return the idformapago
	 */
	public int getIdformapago() {
		return idformapago;
	}

	/**
	 * @param idformapago the idformapago to set
	 */
	public void setIdformapago(int idformapago) {
		this.idformapago = idformapago;
	}

}
