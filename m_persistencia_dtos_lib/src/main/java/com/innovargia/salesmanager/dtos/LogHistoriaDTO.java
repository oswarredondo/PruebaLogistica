/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author aruaro
 *
 */
public class LogHistoriaDTO {
	
	int idregistro     ;
	String iddocumentomadre;
	String cantidad;
	String tipomovimiento  ;
	String descripcion  ;
	String fecha       ;
	String registro    ;
	String quienrealiza ; 
	String observacion ; 
	String login ; 
	String idenvio ; 
	String exclave;
	String siglasplaza;
	String plazaorigina;
	String empleado;
	String ruta;
	String entregadoA;
	//Estos campos hacen referencia al estatus asignado a la combinacion
	//del movimiengto con la excepcion
	String idestatus;
	String descripcion_estatus;
	String imagen_css;
	String latitud ,longitud;
	
	
	String viaje ;
	String numeconomico ;
	String operador;
	String cincho;
	String deptodestino ;
	String manifiesto ;
	String fechaManifiesto;
	float monto;
	
	/*Cambio RUTA MANIFIESTO 06/10/2020*/
	String estado;
	String ciudad;
	String calle;
	String colonia;
	String municipio;
	String numinterior;
	String numexterior;
	String cp;

	/**
	 * 
	 */
	public LogHistoriaDTO() {
		// TODO Auto-generated constructor stub
	}


	public int getIdregistro() {
		return idregistro;
	}


	public void setIdregistro(int idregistro) {
		this.idregistro = idregistro;
	}


	public String getTipomovimiento() {
		return tipomovimiento;
	}


	public void setTipomovimiento(String tipomovimiento) {
		this.tipomovimiento = tipomovimiento;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getRegistro() {
		return registro;
	}


	public void setRegistro(String registro) {
		this.registro = registro;
	}


	public String getQuienrealiza() {
		return quienrealiza;
	}


	public void setQuienrealiza(String quienrealiza) {
		this.quienrealiza = quienrealiza;
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
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}


	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
	 * @return the idenvio
	 */
	public String getIdenvio() {
		return idenvio;
	}


	/**
	 * @param idenvio the idenvio to set
	 */
	public void setIdenvio(String idenvio) {
		this.idenvio = idenvio;
	}


	/**
	 * @return the exclave
	 */
	public String getExclave() {
		return exclave;
	}


	/**
	 * @param exclave the exclave to set
	 */
	public void setExclave(String exclave) {
		this.exclave = exclave;
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
	 * @return the plazaorigina
	 */
	public String getPlazaorigina() {
		return plazaorigina;
	}


	/**
	 * @param plazaorigina the plazaorigina to set
	 */
	public void setPlazaorigina(String plazaorigina) {
		this.plazaorigina = plazaorigina;
	}


	/**
	 * @return the empleado
	 */
	public String getEmpleado() {
		return empleado;
	}


	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(String empleado) {
		this.empleado = empleado;
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
	 * @return the entregadoA
	 */
	public String getEntregadoA() {
	    return entregadoA;
	}


	/**
	 * @param entregadoA the entregadoA to set
	 */
	public void setEntregadoA(String entregadoA) {
	    this.entregadoA = entregadoA;
	}


	/**
	 * @return the idestatus
	 */
	public String getIdestatus() {
	    return idestatus;
	}


	/**
	 * @param idestatus the idestatus to set
	 */
	public void setIdestatus(String idestatus) {
	    this.idestatus = idestatus;
	}


	/**
	 * @return the descripcion_estatus
	 */
	public String getDescripcion_estatus() {
	    return descripcion_estatus;
	}


	/**
	 * @param descripcion_estatus the descripcion_estatus to set
	 */
	public void setDescripcion_estatus(String descripcion_estatus) {
	    this.descripcion_estatus = descripcion_estatus;
	}


	/**
	 * @return the imagen_css
	 */
	public String getImagen_css() {
	    return imagen_css;
	}


	/**
	 * @param imagen_css the imagen_css to set
	 */
	public void setImagen_css(String imagen_css) {
	    this.imagen_css = imagen_css;
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


	/**
	 * @return the viaje
	 */
	public String getViaje() {
	    return viaje;
	}


	/**
	 * @param viaje the viaje to set
	 */
	public void setViaje(String viaje) {
	    this.viaje = viaje;
	}


	/**
	 * @return the numeconomico
	 */
	public String getNumeconomico() {
	    return numeconomico;
	}


	/**
	 * @param numeconomico the numeconomico to set
	 */
	public void setNumeconomico(String numeconomico) {
	    this.numeconomico = numeconomico;
	}


	/**
	 * @return the operador
	 */
	public String getOperador() {
	    return operador;
	}


	/**
	 * @param operador the operador to set
	 */
	public void setOperador(String operador) {
	    this.operador = operador;
	}


	/**
	 * @return the cincho
	 */
	public String getCincho() {
	    return cincho;
	}


	/**
	 * @param cincho the cincho to set
	 */
	public void setCincho(String cincho) {
	    this.cincho = cincho;
	}


	/**
	 * @return the deptodestino
	 */
	public String getDeptodestino() {
	    return deptodestino;
	}


	/**
	 * @param deptodestino the deptodestino to set
	 */
	public void setDeptodestino(String deptodestino) {
	    this.deptodestino = deptodestino;
	}


	/**
	 * @return the manifiesto
	 */
	public String getManifiesto() {
	    return manifiesto;
	}


	/**
	 * @param manifiesto the manifiesto to set
	 */
	public void setManifiesto(String manifiesto) {
	    this.manifiesto = manifiesto;
	}


	/**
	 * @return the fechaManifiesto
	 */
	public String getFechaManifiesto() {
	    return fechaManifiesto;
	}


	/**
	 * @param fechaManifiesto the fechaManifiesto to set
	 */
	public void setFechaManifiesto(String fechaManifiesto) {
	    this.fechaManifiesto = fechaManifiesto;
	}


	/**
	 * @return the monto
	 */
	public float getMonto() {
	    return monto;
	}


	/**
	 * @param monto the monto to set
	 */
	public void setMonto(float monto) {
	    this.monto = monto;
	}
	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getIddocumentomadre() {
		return iddocumentomadre;
	}


	public void setIddocumentomadre(String iddocumentomadre) {
		this.iddocumentomadre = iddocumentomadre;
	}
	
	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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


	public String getMunicipio() {
		return municipio;
	}


	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}


	public String getNuminterior() {
		return numinterior;
	}


	public void setNuminterior(String numinterior) {
		this.numinterior = numinterior;
	}


	public String getNumexterior() {
		return numexterior;
	}


	public void setNumexterior(String numexterior) {
		this.numexterior = numexterior;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}
}
