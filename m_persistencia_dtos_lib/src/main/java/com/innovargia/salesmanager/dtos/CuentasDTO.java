/**
 * 
 */
package com.innovargia.salesmanager.dtos;



import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Adrian Morales Ruaro
 *
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CuentasDTO extends RemDes{ 

	//private int idorganizacion;
	//private int identidad;
	//Bandera que indica si la cuenta puede ver todas las direcciones 
	//de la organiuzacion y entidad o solo las propias
	private String vertodasdirecciones;
	private String tipoCuentaCliente;
	private int tipofolio;//1=Convenio 0=Folios
	public ArrayList<UsuarioDTO> arr_usuario= new ArrayList<UsuarioDTO>(); 
	
	//Datos para crear etquetas
	private String login;
	private String password;
	private String suscriberid;
	private String numclientearrier;
	private String idserviciocarrier;
	
	//Datos para consulta etiquetas
	private String loginconsultacarrier;
	private String passwordconsultacarrier;
	

	private String numclienteconsultacarrier;
	private String suscriberidconsultacarrier;
	
	//Datos para verificar folios o conveios 
	//En el sistema principal
	private String manejoporfoliosconvenio;
	private int idconvenio ;
	private String idservicio ;
	
	private int peso_ampara_folio;
	private int identidad_default_folio;
	private int organizacion_default_folio;
	  
	
	private String endpoint_creacion;
	private String endpoint_consulta;
	
	private String oficina_organizacion;
	  
	/**
	 * 
	 */
	public CuentasDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the vertodasdirecciones
	 */
	public String getVertodasdirecciones() {
		return vertodasdirecciones;
	}
	/**
	 * @param vertodasdirecciones the vertodasdirecciones to set
	 */
	public void setVertodasdirecciones(String vertodasdirecciones) {
		this.vertodasdirecciones = vertodasdirecciones;
	}
	/**
	 * @return the tipoCuentaCliente
	 */
	public String getTipoCuentaCliente() {
		return tipoCuentaCliente;
	}
	/**
	 * @param tipoCuentaCliente the tipoCuentaCliente to set
	 */
	public void setTipoCuentaCliente(String tipoCuentaCliente) {
		this.tipoCuentaCliente = tipoCuentaCliente;
	}

	public int getTipofolio() {
		return tipofolio;
	}

	public void setTipofolio(int tipofolio) {
		this.tipofolio = tipofolio;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSuscriberid() {
		return suscriberid;
	}

	public void setSuscriberid(String suscriberid) {
		this.suscriberid = suscriberid;
	}

	public String getNumclientearrier() {
		return numclientearrier;
	}

	public void setNumclientearrier(String numclientearrier) {
		this.numclientearrier = numclientearrier;
	}

	public String getManejoporfoliosconvenio() {
		return manejoporfoliosconvenio;
	}

	public void setManejoporfoliosconvenio(String manejoporfoliosconvenio) {
		this.manejoporfoliosconvenio = manejoporfoliosconvenio;
	}

	public int getIdconvenio() {
		return idconvenio;
	}

	public void setIdconvenio(int idconvenio) {
		this.idconvenio = idconvenio;
	}

	public String getIdservicio() {
		return idservicio;
	}

	public void setIdservicio(String idservicio) {
		this.idservicio = idservicio;
	}

	public int getPeso_ampara_folio() {
		return peso_ampara_folio;
	}

	public void setPeso_ampara_folio(int peso_ampara_folio) {
		this.peso_ampara_folio = peso_ampara_folio;
	}

	public int getIdentidad_default_folio() {
		return identidad_default_folio;
	}

	public void setIdentidad_default_folio(int identidad_default_folio) {
		this.identidad_default_folio = identidad_default_folio;
	}

	public int getOrganizacion_default_folio() {
		return organizacion_default_folio;
	}

	public void setOrganizacion_default_folio(int organizacion_default_folio) {
		this.organizacion_default_folio = organizacion_default_folio;
	}
	
	public String getIdserviciocarrier() {
		return idserviciocarrier;
	}

	public void setIdserviciocarrier(String idserviciocarrier) {
		this.idserviciocarrier = idserviciocarrier;
	}

	public String getLoginconsultacarrier() {
		return loginconsultacarrier;
	}

	public void setLoginconsultacarrier(String loginconsultacarrier) {
		this.loginconsultacarrier = loginconsultacarrier;
	}

	public String getPasswordconsultacarrier() {
		return passwordconsultacarrier;
	}

	public void setPasswordconsultacarrier(String passwordconsultacarrier) {
		this.passwordconsultacarrier = passwordconsultacarrier;
	}

	public String getNumclienteconsultacarrier() {
		return numclienteconsultacarrier;
	}

	public void setNumclienteconsultacarrier(String numclienteconsultacarrier) {
		this.numclienteconsultacarrier = numclienteconsultacarrier;
	}

	public String getSuscriberidconsultacarrier() {
		return suscriberidconsultacarrier;
	}

	public void setSuscriberidconsultacarrier(String suscriberidconsultacarrier) {
		this.suscriberidconsultacarrier = suscriberidconsultacarrier;
	}

	public String getEndpoint_creacion() {
		return endpoint_creacion;
	}

	public void setEndpoint_creacion(String endpoint_creacion) {
		this.endpoint_creacion = endpoint_creacion;
	}

	public String getEndpoint_consulta() {
		return endpoint_consulta;
	}

	public void setEndpoint_consulta(String endpoint_consulta) {
		this.endpoint_consulta = endpoint_consulta;
	}

	public String getOficina_organizacion() {
		return oficina_organizacion;
	}

	public void setOficina_organizacion(String oficina_organizacion) {
		this.oficina_organizacion = oficina_organizacion;
	}

}
