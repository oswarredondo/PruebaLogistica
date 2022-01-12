/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author aruaro
 *
 */
public class DireccionDTO {
	
	int iddireccion      ;
	int idcliente     ;
	String numcliente         ;
	String descripcion         ;
	String calle         ;
	String numinterior   ;
	String numexterior   ;
	String colonia      ;
	String cp          ;
	String ciudad          ;
	String municipio   ;
	String estado      ;
	String email     ;
	String telefono   ;
	String movil     ;
	String observacion;
	String rfc;
	int dirdefault   ;
	String clasificacion;
	String atencion         ;
	String razonSocial         ;
	String extencion         ;
	String referencia;
	

	/**
	 * 
	 */
	public DireccionDTO() {
		// TODO Auto-generated constructor stub
	}


	public int getIddireccion() {
		return iddireccion;
	}


	public void setIddireccion(int iddireccion) {
		this.iddireccion = iddireccion;
	}

	public void setIddireccion(String iddireccion) {
		try{
			this.iddireccion = Integer.parseInt(iddireccion);
		}catch(Exception e){
			
		}
		
	}

	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
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


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getMovil() {
		return movil;
	}


	public void setMovil(String movil) {
		this.movil = movil;
	}


	public int getDirdefault() {
		return dirdefault;
	}


	public void setDirdefault(int dirdefault) {
		this.dirdefault = dirdefault;
	}
	
	public void setDirdefault(String dirdefault) {
		if (dirdefault==null){
			this.dirdefault = 0;
		}else{
			dirdefault = dirdefault.trim().toLowerCase();
			if (dirdefault.equals("on") || dirdefault.equals("true") || dirdefault.equals("yes")){
				this.dirdefault = 1;
			}else{
				this.dirdefault = 0;
			}
		}
		
	}


	public int getIdcliente() {
		return idcliente;
	}


	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public void setIdcliente(String idcliente) {
		try{
			this.idcliente = Integer.parseInt(idcliente);
		}catch(Exception e){
			
		}
		
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


	public String getClasificacion() {
		return clasificacion;
	}


	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
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
	 * @return the referencia
	 */
	public String getReferencia() {
	    return referencia;
	}


	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
	    this.referencia = referencia;
	}

}
