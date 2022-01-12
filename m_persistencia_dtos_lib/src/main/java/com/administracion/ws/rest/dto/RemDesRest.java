/**
 * 
 */
package com.administracion.ws.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author aruaro
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RemDesRest {

    private String numCliente;
    private String razonSocial;
    private String atencion;
    private String direccion;
    private String calle;
    private String colonia;
    private String ciudad;
    private String activo;
    private String estado;
    private String idestado;
    private String idpais;
    private String municipio;
    private String cp;
    private String telefono;
    
    private String entrecalles;
	private String pais;
	private String correoe;
    private String sitiointernet;
    private String numcelular;
    private String numradio;
    private String ubicacion_dir;
    
    private String banco1;
    private String cuentabanco1;
    private String banco2;
    private String cuentabanco2;
    private String banco3;
    private String cuentabanco3;
    private String tipopago;
    private String idregistro;
    private String idpuesto;
    private String iddepartamento;
    private String idtitulo;
    private String nombre;
    private String telcontacto;
    private String extencion;
    private String movil;
    private String fechanacimiento;
    private String numinterior;
    private String numexterior;
    private String idpropietario;
    private String rfc;
    private String fax;
    private String depto;
    private String observacion;
    private String cveUnica;
    private String folio;
    private int Ubicacion;
    private String ap_Paterno;
    private String ap_Materno;
    private String oficina;
    private String piso;
    
    private String localidad;
    private int idCentroCosto;
    private String refdomicilio;
	private String latitud = null;
	private String longitud = null;
	private String codigoProvinciaEstado;
	private String codigoPais;
	
	/**
	 * @return the numCliente
	 */
	public String getNumCliente() {
		return numCliente;
	}
	/**
	 * @param numCliente the numCliente to set
	 */
	public void setNumCliente(String numCliente) {
		this.numCliente = numCliente;
	}
	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}
	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	/**
	 * @return the atencion
	 */
	public String getAtencion() {
		return atencion;
	}
	/**
	 * @param atencion the atencion to set
	 */
	public void setAtencion(String atencion) {
		this.atencion = atencion;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}
	/**
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}
	/**
	 * @return the colonia
	 */
	public String getColonia() {
		return colonia;
	}
	/**
	 * @param colonia the colonia to set
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * @return the activo
	 */
	public String getActivo() {
		return activo;
	}
	/**
	 * @param activo the activo to set
	 */
	public void setActivo(String activo) {
		this.activo = activo;
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
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}
	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}
	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the entrecalles
	 */
	public String getEntrecalles() {
		return entrecalles;
	}
	/**
	 * @param entrecalles the entrecalles to set
	 */
	public void setEntrecalles(String entrecalles) {
		this.entrecalles = entrecalles;
	}
	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * @return the correoe
	 */
	public String getCorreoe() {
		return correoe;
	}
	/**
	 * @param correoe the correoe to set
	 */
	public void setCorreoe(String correoe) {
		this.correoe = correoe;
	}
	/**
	 * @return the sitiointernet
	 */
	public String getSitiointernet() {
		return sitiointernet;
	}
	/**
	 * @param sitiointernet the sitiointernet to set
	 */
	public void setSitiointernet(String sitiointernet) {
		this.sitiointernet = sitiointernet;
	}
	/**
	 * @return the numcelular
	 */
	public String getNumcelular() {
		return numcelular;
	}
	/**
	 * @param numcelular the numcelular to set
	 */
	public void setNumcelular(String numcelular) {
		this.numcelular = numcelular;
	}
	/**
	 * @return the numradio
	 */
	public String getNumradio() {
		return numradio;
	}
	/**
	 * @param numradio the numradio to set
	 */
	public void setNumradio(String numradio) {
		this.numradio = numradio;
	}
	/**
	 * @return the ubicacion_dir
	 */
	public String getUbicacion_dir() {
		return ubicacion_dir;
	}
	/**
	 * @param ubicacion_dir the ubicacion_dir to set
	 */
	public void setUbicacion_dir(String ubicacion_dir) {
		this.ubicacion_dir = ubicacion_dir;
	}
	/**
	 * @return the banco1
	 */
	public String getBanco1() {
		return banco1;
	}
	/**
	 * @param banco1 the banco1 to set
	 */
	public void setBanco1(String banco1) {
		this.banco1 = banco1;
	}
	/**
	 * @return the cuentabanco1
	 */
	public String getCuentabanco1() {
		return cuentabanco1;
	}
	/**
	 * @param cuentabanco1 the cuentabanco1 to set
	 */
	public void setCuentabanco1(String cuentabanco1) {
		this.cuentabanco1 = cuentabanco1;
	}
	/**
	 * @return the banco2
	 */
	public String getBanco2() {
		return banco2;
	}
	/**
	 * @param banco2 the banco2 to set
	 */
	public void setBanco2(String banco2) {
		this.banco2 = banco2;
	}
	/**
	 * @return the cuentabanco2
	 */
	public String getCuentabanco2() {
		return cuentabanco2;
	}
	/**
	 * @param cuentabanco2 the cuentabanco2 to set
	 */
	public void setCuentabanco2(String cuentabanco2) {
		this.cuentabanco2 = cuentabanco2;
	}
	/**
	 * @return the banco3
	 */
	public String getBanco3() {
		return banco3;
	}
	/**
	 * @param banco3 the banco3 to set
	 */
	public void setBanco3(String banco3) {
		this.banco3 = banco3;
	}
	/**
	 * @return the cuentabanco3
	 */
	public String getCuentabanco3() {
		return cuentabanco3;
	}
	/**
	 * @param cuentabanco3 the cuentabanco3 to set
	 */
	public void setCuentabanco3(String cuentabanco3) {
		this.cuentabanco3 = cuentabanco3;
	}
	/**
	 * @return the tipopago
	 */
	public String getTipopago() {
		return tipopago;
	}
	/**
	 * @param tipopago the tipopago to set
	 */
	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}
	/**
	 * @return the idregistro
	 */
	public String getIdregistro() {
		return idregistro;
	}
	/**
	 * @param idregistro the idregistro to set
	 */
	public void setIdregistro(String idregistro) {
		this.idregistro = idregistro;
	}
	/**
	 * @return the idpuesto
	 */
	public String getIdpuesto() {
		return idpuesto;
	}
	/**
	 * @param idpuesto the idpuesto to set
	 */
	public void setIdpuesto(String idpuesto) {
		this.idpuesto = idpuesto;
	}
	/**
	 * @return the iddepartamento
	 */
	public String getIddepartamento() {
		return iddepartamento;
	}
	/**
	 * @param iddepartamento the iddepartamento to set
	 */
	public void setIddepartamento(String iddepartamento) {
		this.iddepartamento = iddepartamento;
	}
	/**
	 * @return the idtitulo
	 */
	public String getIdtitulo() {
		return idtitulo;
	}
	/**
	 * @param idtitulo the idtitulo to set
	 */
	public void setIdtitulo(String idtitulo) {
		this.idtitulo = idtitulo;
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
	 * @return the telcontacto
	 */
	public String getTelcontacto() {
		return telcontacto;
	}
	/**
	 * @param telcontacto the telcontacto to set
	 */
	public void setTelcontacto(String telcontacto) {
		this.telcontacto = telcontacto;
	}
	/**
	 * @return the extencion
	 */
	public String getExtencion() {
		return extencion;
	}
	/**
	 * @param extencion the extencion to set
	 */
	public void setExtencion(String extencion) {
		this.extencion = extencion;
	}
	/**
	 * @return the movil
	 */
	public String getMovil() {
		return movil;
	}
	/**
	 * @param movil the movil to set
	 */
	public void setMovil(String movil) {
		this.movil = movil;
	}
	/**
	 * @return the fechanacimiento
	 */
	public String getFechanacimiento() {
		return fechanacimiento;
	}
	/**
	 * @param fechanacimiento the fechanacimiento to set
	 */
	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}
	/**
	 * @return the numinterior
	 */
	public String getNuminterior() {
		return numinterior;
	}
	/**
	 * @param numinterior the numinterior to set
	 */
	public void setNuminterior(String numinterior) {
		this.numinterior = numinterior;
	}
	/**
	 * @return the numexterior
	 */
	public String getNumexterior() {
		return numexterior;
	}
	/**
	 * @param numexterior the numexterior to set
	 */
	public void setNumexterior(String numexterior) {
		this.numexterior = numexterior;
	}
	/**
	 * @return the idpropietario
	 */
	public String getIdpropietario() {
		return idpropietario;
	}
	/**
	 * @param idpropietario the idpropietario to set
	 */
	public void setIdpropietario(String idpropietario) {
		this.idpropietario = idpropietario;
	}
	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}
	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * @return the depto
	 */
	public String getDepto() {
		return depto;
	}
	/**
	 * @param depto the depto to set
	 */
	public void setDepto(String depto) {
		this.depto = depto;
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
	 * @return the cveUnica
	 */
	public String getCveUnica() {
		return cveUnica;
	}
	/**
	 * @param cveUnica the cveUnica to set
	 */
	public void setCveUnica(String cveUnica) {
		this.cveUnica = cveUnica;
	}
	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}
	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}
	/**
	 * @return the ubicacion
	 */
	public int getUbicacion() {
		return Ubicacion;
	}
	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(int ubicacion) {
		Ubicacion = ubicacion;
	}
	/**
	 * @return the ap_Paterno
	 */
	public String getAp_Paterno() {
		return ap_Paterno;
	}
	/**
	 * @param ap_Paterno the ap_Paterno to set
	 */
	public void setAp_Paterno(String ap_Paterno) {
		this.ap_Paterno = ap_Paterno;
	}
	/**
	 * @return the ap_Materno
	 */
	public String getAp_Materno() {
		return ap_Materno;
	}
	/**
	 * @param ap_Materno the ap_Materno to set
	 */
	public void setAp_Materno(String ap_Materno) {
		this.ap_Materno = ap_Materno;
	}
	/**
	 * @return the oficina
	 */
	public String getOficina() {
		return oficina;
	}
	/**
	 * @param oficina the oficina to set
	 */
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	/**
	 * @return the piso
	 */
	public String getPiso() {
		return piso;
	}
	/**
	 * @param piso the piso to set
	 */
	public void setPiso(String piso) {
		this.piso = piso;
	}
	/**
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}
	/**
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	/**
	 * @return the idCentroCosto
	 */
	public int getIdCentroCosto() {
		return idCentroCosto;
	}
	/**
	 * @param idCentroCosto the idCentroCosto to set
	 */
	public void setIdCentroCosto(int idCentroCosto) {
		this.idCentroCosto = idCentroCosto;
	}
	/**
	 * @return the refdomicilio
	 */
	public String getRefdomicilio() {
		return refdomicilio;
	}
	/**
	 * @param refdomicilio the refdomicilio to set
	 */
	public void setRefdomicilio(String refdomicilio) {
		this.refdomicilio = refdomicilio;
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
	 * @return the codigoProvinciaEstado
	 */
	public String getCodigoProvinciaEstado() {
		return codigoProvinciaEstado;
	}
	/**
	 * @param codigoProvinciaEstado the codigoProvinciaEstado to set
	 */
	public void setCodigoProvinciaEstado(String codigoProvinciaEstado) {
		this.codigoProvinciaEstado = codigoProvinciaEstado;
	}
	/**
	 * @return the codigoPais
	 */
	public String getCodigoPais() {
		return codigoPais;
	}
	/**
	 * @param codigoPais the codigoPais to set
	 */
	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}
	/**
	 * @return the idestado
	 */
	public String getIdestado() {
		return idestado;
	}
	/**
	 * @return the idpais
	 */
	public String getIdpais() {
		return idpais;
	}
	/**
	 * @param idestado the idestado to set
	 */
	public void setIdestado(String idestado) {
		this.idestado = idestado;
	}
	/**
	 * @param idpais the idpais to set
	 */
	public void setIdpais(String idpais) {
		this.idpais = idpais;
	}
}
