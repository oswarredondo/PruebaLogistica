/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author aruaro
 *
 */
public class ContactoDTO {

	int idcliente     ;
	int idcontacto    ; 
	String nombre     ; 
	String apellido   ;  
	String email      ; 
	String telefono   ;  
	String telefono2   ;  
	String puesto;
	String comentario;
	int iddireccion;
	int utilizadircliente ;  
	
	String calle         ;
	String numinterior   ;
	String numexterior   ;
	String colonia      ;
	String cp          ;
	String municipio   ;
	String estado      ;
	String movil     ;
	String clasificacion;
	String logincreador;
	//Usado para consulta se actualiza con la visibilidad del usuario de sesion
	int visibilidad;
	String extencion;
	
	/**
	 * 
	 */
	public ContactoDTO() {
		// TODO Auto-generated constructor stub
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
			this.idcliente =-1;
		}
		
	}

	
	public int getIdcontacto() {
		return idcontacto;
	}

	public void setIdcontacto(int idcontacto) {
		this.idcontacto = idcontacto;
	}
	
	public void setIdcontacto(String idcontacto) {
		try{
			this.idcontacto = Integer.parseInt(idcontacto);
		}catch(Exception e){
			this.idcontacto =-1;
		}
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public int getUtilizadircliente() {
		return utilizadircliente;
	}

	public void setUtilizadircliente(int utilizadircliente) {
		this.utilizadircliente = utilizadircliente;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getIddireccion() {
		return iddireccion;
	}

	public void setIddireccion(int iddireccion) {
		this.iddireccion = iddireccion;
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

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public String getLogincreador() {
		return logincreador;
	}

	public void setLogincreador(String logincreador) {
		this.logincreador = logincreador;
	}

	public int getVisibilidad() {
		return visibilidad;
	}

	public void setVisibilidad(int visibilidad) {
		this.visibilidad = visibilidad;
	}

	public String getExtencion() {
		return extencion;
	}

	public void setExtencion(String extencion) {
		this.extencion = extencion;
	}


}
