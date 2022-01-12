/**
 * 
 */
package com.administracion.dto;

/**
 * @author aruaro
 *
 */
public class AdicionalDTO {
	int identificador ;
	  int idregistro ;
	  int iddregistrodatos ;
	  String idregistroadicional;
	  int idadicionaldetalle;
	  /* CAMBIO MANIOBRAS CITA EVIDENCIAS*/
	  int idadicional ;
	  /* FIN CAMBIO */
	  int tipo ;
	  float precio ;
	  float descuento ;
	  int tipoincremento;
	  String uuid ;
	 
	  String descripcion ;
	  String fechacreacion ;   
	  

	/**
	 * 
	 */
	public AdicionalDTO() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the identificador
	 */
	public int getIdentificador() {
		return identificador;
	}


	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
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

	public void setIdregistro(String idregistro) {
		try{
			this.idregistro = Integer.parseInt(idregistro);
		}catch(Exception e){
			
		}
	
	}
	

	/**
	 * @return the iddregistrodatos
	 */
	public int getIddregistrodatos() {
		return iddregistrodatos;
	}


	/**
	 * @param iddregistrodatos the iddregistrodatos to set
	 */
	public void setIddregistrodatos(int iddregistrodatos) {
		this.iddregistrodatos = iddregistrodatos;
	}


	/**
	 * @return the idregistroadicional
	 */
	public String getIdregistroadicional() {
		return idregistroadicional;
	}


	/**
	 * @param idregistroadicional the idregistroadicional to set
	 */
	public void setIdregistroadicional(String idregistroadicional) {
		this.idregistroadicional = idregistroadicional;
	}


	/**
	 * @return the idadicionaldetalle
	 */
	public int getIdadicionaldetalle() {
		return idadicionaldetalle;
	}


	/**
	 * @param idadicionaldetalle the idadicionaldetalle to set
	 */
	public void setIdadicionaldetalle(int idadicionaldetalle) {
		this.idadicionaldetalle = idadicionaldetalle;
	}


	/**
	 * @return the idadicional
	 */
	public int getIdadicional() {
		return idadicional;
	}


	/**
	 * @param idadicional the idadicional to set
	 */
	public void setIdadicional(int idadicional) {
		this.idadicional = idadicional;
	}


	/**
	 * @return the tipo
	 */
	public int getTipo() {
		return tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	

	/**
	 * @return the descuento
	 */
	public float getDescuento() {
		return descuento;
	}


	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}


	/**
	 * @return the tipoincremento
	 */
	public int getTipoincremento() {
		return tipoincremento;
	}


	/**
	 * @param tipoincremento the tipoincremento to set
	 */
	public void setTipoincremento(int tipoincremento) {
		this.tipoincremento = tipoincremento;
	}


	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}


	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}


	/**
	 * @return the decripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * @param decripcion the decripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	/**
	 * @return the fechacreacion
	 */
	public String getFechacreacion() {
		return fechacreacion;
	}


	/**
	 * @param fechacreacion the fechacreacion to set
	 */
	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
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

}
