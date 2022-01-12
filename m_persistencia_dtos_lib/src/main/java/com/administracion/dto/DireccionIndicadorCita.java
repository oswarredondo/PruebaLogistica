/**
 * 
 */
package com.administracion.dto;

import com.innovargia.documentos.dtos.RemDesEnvio;
import com.innovargia.salesmanager.dtos.RemDes;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class DireccionIndicadorCita extends RemDes {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ruta ;
	  private String typo;
	  private String descripcion;
	  private String poblacion;
	  private String customer;
	  private String descripcion1 ;
	  private String terr;
	  private String ejecutivocuenta;
	  private String telmovilejecutivocuenta;
	  private String gerente;
	  private String telmovilgerente;
	  private String propietariocuenta;
	  private String telmovilpropietario;
	  private String nextel;
	  private String obervacion;
	  private String telefonocliente ;
	  private String fecuencia ;
	  private String diasentrega;
	  private String diasdefactura;
	  private String diasentregalinea1 ;
	  private String rddcliente;
	  private String mad;
	  private String ttxdockcte;
	  private String salidaslinea1;
	  private String ruta1;
	  private String estado;
	  private String opcionxd;
	  private String indicadorcita;

	/**
	 * 
	 */
	public DireccionIndicadorCita() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param identificador
	 */
	public DireccionIndicadorCita(String identificador) {
		super(identificador);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param datos
	 */
	public DireccionIndicadorCita(RemDesEnvio datos) {
		super(datos);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numCliente
	 * @param idRmDes
	 * @param razonSocial
	 * @param atencion
	 * @param direccion
	 * @param colonia
	 * @param ciudad
	 * @param estado
	 * @param cp
	 * @param telefono
	 */
	public DireccionIndicadorCita(String numCliente, String idRmDes,
			String razonSocial, String atencion, String direccion,
			String colonia, String ciudad, String estado, String cp,
			String telefono) {
		super(numCliente, idRmDes, razonSocial, atencion, direccion, colonia,
				ciudad, estado, cp, telefono);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numCliente
	 * @param razonSocial
	 * @param atencion
	 * @param direccion
	 * @param colonia
	 * @param municipio
	 * @param ciudad
	 * @param estado
	 * @param cp
	 * @param telefono
	 * @param correoe
	 */
	public DireccionIndicadorCita(String numCliente, String razonSocial,
			String atencion, String direccion, String colonia,
			String municipio, String ciudad, String estado, String cp,
			String telefono, String correoe) {
		super(numCliente, razonSocial, atencion, direccion, colonia, municipio,
				ciudad, estado, cp, telefono, correoe);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numCliente
	 * @param razonSocial
	 * @param atencion
	 * @param direccion
	 * @param colonia
	 * @param ciudad
	 * @param estado
	 * @param cp
	 * @param telefono
	 */
	public DireccionIndicadorCita(String numCliente, String razonSocial,
			String atencion, String direccion, String colonia, String ciudad,
			String estado, String cp, String telefono) {
		super(numCliente, razonSocial, atencion, direccion, colonia, ciudad,
				estado, cp, telefono);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nombre
	 * @param ap_Paterno
	 * @param ap_Materno
	 * @param oficina
	 * @param piso
	 * @param direccion
	 * @param localidad
	 * @param ciudad
	 * @param estado
	 * @param cp
	 * @param Ubicacion
	 */
	public DireccionIndicadorCita(String nombre, String ap_Paterno,
			String ap_Materno, String oficina, String piso, String direccion,
			String localidad, String ciudad, String estado, String cp,
			int Ubicacion) {
		super(nombre, ap_Paterno, ap_Materno, oficina, piso, direccion,
				localidad, ciudad, estado, cp, Ubicacion);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}

	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * @return the typo
	 */
	public String getTypo() {
		return typo;
	}

	/**
	 * @param typo the typo to set
	 */
	public void setTypo(String typo) {
		this.typo = typo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the poblacion
	 */
	public String getPoblacion() {
		return poblacion;
	}

	/**
	 * @param poblacion the poblacion to set
	 */
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the descripcion1
	 */
	public String getDescripcion1() {
		return descripcion1;
	}

	/**
	 * @param descripcion1 the descripcion1 to set
	 */
	public void setDescripcion1(String descripcion1) {
		this.descripcion1 = descripcion1;
	}

	/**
	 * @return the terr
	 */
	public String getTerr() {
		return terr;
	}

	/**
	 * @param terr the terr to set
	 */
	public void setTerr(String terr) {
		this.terr = terr;
	}

	/**
	 * @return the ejecutivocuenta
	 */
	public String getEjecutivocuenta() {
		return ejecutivocuenta;
	}

	/**
	 * @param ejecutivocuenta the ejecutivocuenta to set
	 */
	public void setEjecutivocuenta(String ejecutivocuenta) {
		this.ejecutivocuenta = ejecutivocuenta;
	}

	/**
	 * @return the telmovilejecutivocuenta
	 */
	public String getTelmovilejecutivocuenta() {
		return telmovilejecutivocuenta;
	}

	/**
	 * @param telmovilejecutivocuenta the telmovilejecutivocuenta to set
	 */
	public void setTelmovilejecutivocuenta(String telmovilejecutivocuenta) {
		this.telmovilejecutivocuenta = telmovilejecutivocuenta;
	}

	/**
	 * @return the gerente
	 */
	public String getGerente() {
		return gerente;
	}

	/**
	 * @param gerente the gerente to set
	 */
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}

	/**
	 * @return the telmovilgerente
	 */
	public String getTelmovilgerente() {
		return telmovilgerente;
	}

	/**
	 * @param telmovilgerente the telmovilgerente to set
	 */
	public void setTelmovilgerente(String telmovilgerente) {
		this.telmovilgerente = telmovilgerente;
	}

	/**
	 * @return the propietariocuenta
	 */
	public String getPropietariocuenta() {
		return propietariocuenta;
	}

	/**
	 * @param propietariocuenta the propietariocuenta to set
	 */
	public void setPropietariocuenta(String propietariocuenta) {
		this.propietariocuenta = propietariocuenta;
	}

	/**
	 * @return the telmovilpropietario
	 */
	public String getTelmovilpropietario() {
		return telmovilpropietario;
	}

	/**
	 * @param telmovilpropietario the telmovilpropietario to set
	 */
	public void setTelmovilpropietario(String telmovilpropietario) {
		this.telmovilpropietario = telmovilpropietario;
	}

	/**
	 * @return the nextel
	 */
	public String getNextel() {
		return nextel;
	}

	/**
	 * @param nextel the nextel to set
	 */
	public void setNextel(String nextel) {
		this.nextel = nextel;
	}

	/**
	 * @return the obervacion
	 */
	public String getObervacion() {
		return obervacion;
	}

	/**
	 * @param obervacion the obervacion to set
	 */
	public void setObervacion(String obervacion) {
		this.obervacion = obervacion;
	}

	/**
	 * @return the telefonocliente
	 */
	public String getTelefonocliente() {
		return telefonocliente;
	}

	/**
	 * @param telefonocliente the telefonocliente to set
	 */
	public void setTelefonocliente(String telefonocliente) {
		this.telefonocliente = telefonocliente;
	}

	/**
	 * @return the fecuencia
	 */
	public String getFecuencia() {
		return fecuencia;
	}

	/**
	 * @param fecuencia the fecuencia to set
	 */
	public void setFecuencia(String fecuencia) {
		this.fecuencia = fecuencia;
	}

	/**
	 * @return the diasentrega
	 */
	public String getDiasentrega() {
		return diasentrega;
	}

	/**
	 * @param diasentrega the diasentrega to set
	 */
	public void setDiasentrega(String diasentrega) {
		this.diasentrega = diasentrega;
	}

	/**
	 * @return the diasdefactura
	 */
	public String getDiasdefactura() {
		return diasdefactura;
	}

	/**
	 * @param diasdefactura the diasdefactura to set
	 */
	public void setDiasdefactura(String diasdefactura) {
		this.diasdefactura = diasdefactura;
	}

	/**
	 * @return the diasentregalinea1
	 */
	public String getDiasentregalinea1() {
		return diasentregalinea1;
	}

	/**
	 * @param diasentregalinea1 the diasentregalinea1 to set
	 */
	public void setDiasentregalinea1(String diasentregalinea1) {
		this.diasentregalinea1 = diasentregalinea1;
	}

	/**
	 * @return the rddcliente
	 */
	public String getRddcliente() {
		return rddcliente;
	}

	/**
	 * @param rddcliente the rddcliente to set
	 */
	public void setRddcliente(String rddcliente) {
		this.rddcliente = rddcliente;
	}

	/**
	 * @return the mad
	 */
	public String getMad() {
		return mad;
	}

	/**
	 * @param mad the mad to set
	 */
	public void setMad(String mad) {
		this.mad = mad;
	}

	/**
	 * @return the ttxdockcte
	 */
	public String getTtxdockcte() {
		return ttxdockcte;
	}

	/**
	 * @param ttxdockcte the ttxdockcte to set
	 */
	public void setTtxdockcte(String ttxdockcte) {
		this.ttxdockcte = ttxdockcte;
	}

	/**
	 * @return the salidaslinea1
	 */
	public String getSalidaslinea1() {
		return salidaslinea1;
	}

	/**
	 * @param salidaslinea1 the salidaslinea1 to set
	 */
	public void setSalidaslinea1(String salidaslinea1) {
		this.salidaslinea1 = salidaslinea1;
	}

	/**
	 * @return the ruta1
	 */
	public String getRuta1() {
		return ruta1;
	}

	/**
	 * @param ruta1 the ruta1 to set
	 */
	public void setRuta1(String ruta1) {
		this.ruta1 = ruta1;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the opcionxd
	 */
	public String getOpcionxd() {
		return opcionxd;
	}

	/**
	 * @param opcionxd the opcionxd to set
	 */
	public void setOpcionxd(String opcionxd) {
		this.opcionxd = opcionxd;
	}

	/**
	 * @return the indicadorcita
	 */
	public String getIndicadorcita() {
		return indicadorcita;
	}

	/**
	 * @param indicadorcita the indicadorcita to set
	 */
	public void setIndicadorcita(String indicadorcita) {
		this.indicadorcita = indicadorcita;
	}



	

}
