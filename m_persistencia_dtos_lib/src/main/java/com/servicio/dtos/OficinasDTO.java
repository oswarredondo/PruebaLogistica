/**
 * 
 */
package com.servicio.dtos;


/**
 * @author Adrian Morales Ruaro
 *
 */
public class OficinasDTO {
	
    	private int idregistro; 
	private String idoficina;
	private String nombre;
	private String numero;
	private String zonaciudad;
	private String encargado;
	private String horarios;
	private String presupuestocomision ;
	private String region;
	private String tipolocal;
	private String siglasplaza;
	private String latitud;
	private String longitud;
	

	private String calle;
	private String colonia;
	private String cp;
	private String municipio;
	private String telefono;
	private String entrecalles ;

	private String estado;
	private String pais;
	private String estatus;//A=Activo B=Baja

	private int identidad;
	private int idorganizacion;
	
	//Datos caja
	private int  idcaja ;
	private String descripcion;
	private String fechaapertura;
	private String login;
	private String fechacierre;
	private String logincierre;
	
	//Tipo
	private int tipooficina; //tipooficina=1  PDV, 2= Oficina
	private int esocurre; // esocurre=1 tiene servicio ocurre, 0=notiene servicio ocurre
	 
    
	/**
	 * 
	 */
	public OficinasDTO() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the idoficina
	 */
	public String getIdoficina() {
		return idoficina;
	}


	/**
	 * @param idoficina the idoficina to set
	 */
	public void setIdoficina(String idoficina) {
		this.idoficina = idoficina;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}


	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}


	/**
	 * @return the zonaciudad
	 */
	public String getZonaciudad() {
		return zonaciudad;
	}


	/**
	 * @param zonaciudad the zonaciudad to set
	 */
	public void setZonaciudad(String zonaciudad) {
		this.zonaciudad = zonaciudad;
	}


	/**
	 * @return the encargado
	 */
	public String getEncargado() {
		return encargado;
	}


	/**
	 * @param encargado the encargado to set
	 */
	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}


	/**
	 * @return the horarios
	 */
	public String getHorarios() {
		return horarios;
	}


	/**
	 * @param horarios the horarios to set
	 */
	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}


	/**
	 * @return the presupuestocomision
	 */
	public String getPresupuestocomision() {
		return presupuestocomision;
	}


	/**
	 * @param presupuestocomision the presupuestocomision to set
	 */
	public void setPresupuestocomision(String presupuestocomision) {
		this.presupuestocomision = presupuestocomision;
	}


	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}


	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}


	/**
	 * @return the tipolocal
	 */
	public String getTipolocal() {
		return tipolocal;
	}


	/**
	 * @param tipolocal the tipolocal to set
	 */
	public void setTipolocal(String tipolocal) {
		this.tipolocal = tipolocal;
	}


	/**
	 * @return the siglasplaza
	 */
	public String getSiglasplaza() {
		return siglasplaza;
	}


	/**
	 * @param siglasplaza the siglasplaza to set
	 */
	public void setSiglasplaza(String siglasplaza) {
		this.siglasplaza = siglasplaza;
	}


	/**
	 * @return the latitud
	 */
	public String getLatitud() {
		return latitud;
	}


	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}


	/**
	 * @return the longitud
	 */
	public String getLongitud() {
		return longitud;
	}


	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getColonia() {
		return colonia;
	}


	public void setColonia(String colonia) {
		this.colonia = colonia;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getMunicipio() {
		return municipio;
	}


	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEntrecalles() {
		return entrecalles;
	}


	public void setEntrecalles(String entrecalles) {
		this.entrecalles = entrecalles;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public String getEstatus() {
		return estatus;
	}


	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


	public int getIdentidad() {
		return identidad;
	}


	public void setIdentidad(int identidad) {
		this.identidad = identidad;
	}


	public int getIdorganizacion() {
		return idorganizacion;
	}


	public void setIdorganizacion(int idorganizacion) {
		this.idorganizacion = idorganizacion;
	}


	/**
	 * @return the idcaja
	 */
	public int getIdcaja() {
	    return idcaja;
	}


	/**
	 * @param idcaja the idcaja to set
	 */
	public void setIdcaja(int idcaja) {
	    this.idcaja = idcaja;
	}


	/**
	 * @return the login
	 */
	public String getLogin() {
	    return login;
	}


	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
	    this.login = login;
	}


	/**
	 * @return the logincierre
	 */
	public String getLogincierre() {
	    return logincierre;
	}


	/**
	 * @param logincierre the logincierre to set
	 */
	public void setLogincierre(String logincierre) {
	    this.logincierre = logincierre;
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
	 * @return the fechaapertura
	 */
	public String getFechaapertura() {
	    return fechaapertura;
	}


	/**
	 * @param fechaapertura the fechaapertura to set
	 */
	public void setFechaapertura(String fechaapertura) {
	    this.fechaapertura = fechaapertura;
	}


	/**
	 * @return the fechacierre
	 */
	public String getFechacierre() {
	    return fechacierre;
	}


	/**
	 * @param fechacierre the fechacierre to set
	 */
	public void setFechacierre(String fechacierre) {
	    this.fechacierre = fechacierre;
	}


	/**
	 * @return the tipooficina
	 */
	public int getTipooficina() {
	    return tipooficina;
	}


	/**
	 * @param tipooficina the tipooficina to set
	 */
	public void setTipooficina(int tipooficina) {
	    this.tipooficina = tipooficina;
	}


	/**
	 * @return the esocurre
	 */
	public int getEsocurre() {
	    return esocurre;
	}


	/**
	 * @param esocurre the esocurre to set
	 */
	public void setEsocurre(int esocurre) {
	    this.esocurre = esocurre;
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

}
