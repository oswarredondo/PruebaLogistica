/**
 * 
 */
package com.innovargia.salesmanager.dtos;

/**
 * @author aruaro
 *
 */
public class DescuentoDTO {
	
	int iddescuento   ;   
	int idagrupamiento;
	    
 
	String nombre         ;
	
	String descuentofijo;       
	String zona;       
	float porcentaje    ;      
	int tipo   ; //1=cliente, 2=tarifa, 3=zona, 
	String fechaactivacion;
	String fechaalta;  

	String fechatermino; 
	int estatus; // 0:desactivado,1:Activo, 3:caduco, 9:inactivo (no ha llegado su fecha de activación)
	
	//Estos datos son utilizados para los tipos de descuentos
	int idcliente;
	int idadicional;
	int idrangoenvios;
	int idtarifa;
	int idserviciotarifa;
	//Se toma la serie 100 ya que en SKY ya existen niveles de usuarios definidos
	//100=Asesor/Ejecutivo de Cuenta, 101=Gerente/Gerente Comercial. , 102=Director/Dirección de ENVÍA,103: Director General
	//•	Otorgado por el Ejecutivo de Cuenta. Hasta un máximo del 5% en el servicio base y en un máximo de 2 servicios adicionales.
	//•	Otorgado por el Gerente Comercial. Hasta un máximo de un 10% en el servicio base y en un máximo de 3 servicios adicionales.
	//•	Otorgados por la Dirección de ENVÍA. Hasta un máximo del 15% en el servicio base y en un máximo de 5 servicios adicionales.

	int nivel; //Indica el nivel de acuerdo a los empleados que lo pueden ver nivel=1, nivel=2, etc 

	String descripcionCliente;
	String descripcionAdicional;
	String descripcionRangoenvios;
	String descripcionTarifa;
	String descripcionServiciotarifa;
	
	//Campos utilizados para detalle de desceuntos
	String identificador;  
	String descripcion     ;  

	/**
	 * 
	 */
	public DescuentoDTO() {
		// TODO Auto-generated constructor stub
	}


	public int getIddescuento() {
		return iddescuento;
	}


	public void setIddescuento(int iddescuento) {
		this.iddescuento = iddescuento;
	}

	public void setIddescuento(String iddescuento) {
		try{
			this.iddescuento = Integer.parseInt(iddescuento) ;
		}catch(Exception e){
			this.iddescuento = 0;
		}
		
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


	public String getDescuentofijo() {
		return descuentofijo;
	}


	public void setDescuentofijo(String descuentofijo) {
		this.descuentofijo = descuentofijo;
	}


	public float getPorcentaje() {
		return porcentaje;
	}


	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	public void setPorcentaje(String porcentaje) {
		try{
			this.porcentaje = Float.parseFloat(porcentaje) ;
		}catch(Exception e){
			this.porcentaje = 0;
		}
		
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setTipo(String tipo) {
		try{
			this.tipo = Integer.parseInt(tipo) ;
		}catch(Exception e){
			this.tipo = 0;
		}
		
	}


	public int getIdadicional() {
		return idadicional;
	}


	public void setIdadicional(int idadicional) {
		this.idadicional = idadicional;
	}


	public int getIdrangoenvios() {
		return idrangoenvios;
	}


	public void setIdrangoenvios(int idrangoenvios) {
		this.idrangoenvios = idrangoenvios;
	}


	public int getIdtarifa() {
		return idtarifa;
	}


	public void setIdtarifa(int idtarifa) {
		this.idtarifa = idtarifa;
	}
	
	public void setIdtarifa(String idtarifa) {
		try{
			this.idtarifa = Integer.parseInt(idtarifa) ;
		}catch(Exception e){
			this.idtarifa = 0;
		}
	}


	public int getIdserviciotarifa() {
		return idserviciotarifa;
	}


	public void setIdserviciotarifa(int idserviciotarifa) {
		this.idserviciotarifa = idserviciotarifa;
	}




	public String getDescripcionAdicional() {
		return descripcionAdicional;
	}


	public void setDescripcionAdicional(String descripcionAdicional) {
		this.descripcionAdicional = descripcionAdicional;
	}


	public String getDescripcionRangoenvios() {
		return descripcionRangoenvios;
	}


	public void setDescripcionRangoenvios(String descripcionRangoenvios) {
		this.descripcionRangoenvios = descripcionRangoenvios;
	}


	public String getDescripcionTarifa() {
		return descripcionTarifa;
	}


	public void setDescripcionTarifa(String descripcionTarifa) {
		this.descripcionTarifa = descripcionTarifa;
	}


	public String getDescripcionServiciotarifa() {
		return descripcionServiciotarifa;
	}


	public void setDescripcionServiciotarifa(String descripcionServiciotarifa) {
		this.descripcionServiciotarifa = descripcionServiciotarifa;
	}


	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(String idcliente) {
		try{
			this.idcliente = Integer.parseInt(idcliente) ;
		}catch(Exception e){
			this.idcliente = 0;
		}
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}


	public String getDescripcionCliente() {
		return descripcionCliente;
	}


	public void setDescripcionCliente(String descripcionCliente) {
		this.descripcionCliente = descripcionCliente;
	}


	public String getFechaactivacion() {
		return fechaactivacion;
	}


	public void setFechaactivacion(String fechaactivacion) {
		this.fechaactivacion = fechaactivacion;
	}

	public int getEstatus() {
		return estatus;
	}


	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}


	/**
	 * @return the fechaalta
	 */
	public String getFechaalta() {
		return fechaalta;
	}


	/**
	 * @param fechaalta the fechaalta to set
	 */
	public void setFechaalta(String fechaalta) {
		this.fechaalta = fechaalta;
	}


	/**
	 * @return the fechatermino
	 */
	public String getFechatermino() {
		return fechatermino;
	}


	/**
	 * @param fechatermino the fechatermino to set
	 */
	public void setFechatermino(String fechatermino) {
		this.fechatermino = fechatermino;
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
	
	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(String nivel) {
		try{
			this.nivel = Integer.parseInt(nivel) ;
		}catch(Exception e){
			this.nivel = 0;
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
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}


	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	/**
	 * @param idagrupamiento the idagrupamiento to set
	 */
	public void setIdagrupamiento(int idagrupamiento) {
		this.idagrupamiento = idagrupamiento;
	}
	 
	public void setIdagrupamiento(String idagrupamiento) {
		try{
			this.idagrupamiento = Integer.parseInt(idagrupamiento);
		}catch(Exception e){
			
		}
		
	
	}
	
	public int getIdagrupamiento() {
		return idagrupamiento;
	}


}
