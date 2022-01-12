/**
 * 
 */
package com.servicio.dtos;


/**
 * @author Adrian Morales Ruaro
 *
 */
public class Zona implements java.io.Serializable {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String zona;
	private String responsable;
	private String email;
	private String telefono;
	
	private String descripcion;
	private  double precio;
	private String zonaOrigen;
	private String zonaDestino;
	private String zonaVenta;	
	private String adicional1;
	private String adicional2;
	private String adicional3;
	private double kms;
	private double cantidadIva;
	private String lunes;
	private String martes;
	private String miercoles;
	private String jueves;
	private String viernes;
	private String sabado;
	private String domingo;
	private Ruta ruta = new Ruta();
	private Ruta rutaDestinoEntrega = new Ruta();
	
	private String entrega;
	private String recoleccion;
	private String ocurre;
	private String idservicio;
	private double flete;
	private double iva;
	private double sobtotal;
	private double precioMasIva;
	
	private String idmunicipio;
	private String idestado;
	private int reexpedicion;
	
	private int p_inicial ;
	private int p_final ;
	private double kgadicional;
	
	
	
	public String getIdRuta(){
		if (ruta==null) ruta = new Ruta();
		return ruta.getIdruta();
				
	}
	public void setIdRuta(String idruta){
		if (ruta==null) ruta = new Ruta();
		 ruta.setIdruta(idruta);
				
	}
	public double getPrecioMasIva() {
		return precioMasIva;
	}


	public void setPrecioMasIva(double precioMasIva) {
		this.precioMasIva = precioMasIva;
	}


	/**
	 * Constructor
	 */
	public Zona() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the zona
	 */
	public String getZona() {
		return zona;
	}


	/**
	 * @return the responsable
	 */
	public String getResponsable() {
		return responsable;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}


	/**
	 * @return the zonaOrigen
	 */
	public String getZonaOrigen() {
		return zonaOrigen;
	}


	/**
	 * @return the zonaDestino
	 */
	public String getZonaDestino() {
		return zonaDestino;
	}


	/**
	 * @return the zonaVenta
	 */
	public String getZonaVenta() {
		return zonaVenta;
	}


	/**
	 * @return the adicional1
	 */
	public String getAdicional1() {
		return adicional1;
	}


	/**
	 * @return the adicional2
	 */
	public String getAdicional2() {
		return adicional2;
	}


	/**
	 * @return the adicional3
	 */
	public String getAdicional3() {
		return adicional3;
	}


	/**
	 * @param zona the zona to set
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}


	/**
	 * @param responsable the responsable to set
	 */
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}


	/**
	 * @param zonaOrigen the zonaOrigen to set
	 */
	public void setZonaOrigen(String zonaOrigen) {
		this.zonaOrigen = zonaOrigen;
	}


	/**
	 * @param zonaDestino the zonaDestino to set
	 */
	public void setZonaDestino(String zonaDestino) {
		this.zonaDestino = zonaDestino;
	}


	/**
	 * @param zonaVenta the zonaVenta to set
	 */
	public void setZonaVenta(String zonaVenta) {
		this.zonaVenta = zonaVenta;
	}


	/**
	 * @param adicional1 the adicional1 to set
	 */
	public void setAdicional1(String adicional1) {
		this.adicional1 = adicional1;
	}


	/**
	 * @param adicional2 the adicional2 to set
	 */
	public void setAdicional2(String adicional2) {
		this.adicional2 = adicional2;
	}


	/**
	 * @param adicional3 the adicional3 to set
	 */
	public void setAdicional3(String adicional3) {
		this.adicional3 = adicional3;
	}


	/**
	 * @return the kms
	 */
	public double getKms() {
		return kms;
	}


	/**
	 * @param kms the kms to set
	 */
	public void setKms(float kms) {
		this.kms = kms;
	}


	/**
	 * @return the cantidadIva
	 */
	public double getCantidadIva() {
		return cantidadIva;
	}


	/**
	 * @param cantidadIva the cantidadIva to set
	 */
	public void setCantidadIva(double cantidadIva) {
		this.cantidadIva = cantidadIva;
	}


	/**
	 * @return the lunes
	 */
	public String getLunes() {
		return lunes;
	}


	/**
	 * @return the martes
	 */
	public String getMartes() {
		return martes;
	}


	/**
	 * @return the miercoles
	 */
	public String getMiercoles() {
		return miercoles;
	}


	/**
	 * @return the viernes
	 */
	public String getViernes() {
		return viernes;
	}


	/**
	 * @return the sabado
	 */
	public String getSabado() {
		return sabado;
	}


	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}


	/**
	 * @param lunes the lunes to set
	 */
	public void setLunes(String lunes) {
		this.lunes = lunes;
	}


	/**
	 * @param martes the martes to set
	 */
	public void setMartes(String martes) {
		this.martes = martes;
	}


	/**
	 * @param miercoles the miercoles to set
	 */
	public void setMiercoles(String miercoles) {
		this.miercoles = miercoles;
	}
	/**
	 * @return the jueves
	 */
	public String getJueves() {
		return jueves;
	}


	/**
	 * @param jueves the jueves to set
	 */
	public void setJueves(String jueves) {
		this.jueves = jueves;
	}

	/**
	 * @param viernes the viernes to set
	 */
	public void setViernes(String viernes) {
		this.viernes = viernes;
	}


	/**
	 * @param sabado the sabado to set
	 */
	public void setSabado(String sabado) {
		this.sabado = sabado;
	}


	/**
	 * @return the domingo
	 */
	public String getDomingo() {
		return domingo;
	}


	/**
	 * @param domingo the domingo to set
	 */
	public void setDomingo(String domingo) {
		this.domingo = domingo;
	}


	/**
	 * @return the entrega
	 */
	public String getEntrega() {
		return entrega;
	}


	/**
	 * @return the recoleccion
	 */
	public String getRecoleccion() {
		return recoleccion;
	}


	/**
	 * @return the ocurre
	 */
	public String getOcurre() {
		return ocurre;
	}


	/**
	 * @return the idservicio
	 */
	public String getIdservicio() {
		return idservicio;
	}


	/**
	 * @param kms the kms to set
	 */
	public void setKms(double kms) {
		this.kms = kms;
	}


	/**
	 * @param entrega the entrega to set
	 */
	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}


	/**
	 * @param recoleccion the recoleccion to set
	 */
	public void setRecoleccion(String recoleccion) {
		this.recoleccion = recoleccion;
	}


	/**
	 * @param ocurre the ocurre to set
	 */
	public void setOcurre(String ocurre) {
		this.ocurre = ocurre;
	}


	/**
	 * @param idservicio the idservicio to set
	 */
	public void setIdservicio(String idservicio) {
		this.idservicio = idservicio;
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


	public double getFlete() {
		return flete;
	}


	public void setFlete(double flete) {
		this.flete = flete;
	}


	public double getIva() {
		return iva;
	}


	public void setIva(double iva) {
		this.iva = iva;
	}


	public double getSobtotal() {
		return sobtotal;
	}


	public void setSobtotal(double sobtotal) {
		this.sobtotal = sobtotal;
	}


	/**
	 * @return the idRuta
	 */
	public Ruta getRuta() {
		return this.ruta;
	}


	/**
	 * @param idRuta the idRuta to set
	 */
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}


	/**
	 * @return the idmunicipio
	 */
	public String getIdmunicipio() {
		return idmunicipio;
	}


	/**
	 * @param idmunicipio the idmunicipio to set
	 */
	public void setIdmunicipio(String idmunicipio) {
		this.idmunicipio = idmunicipio;
	}


	/**
	 * @return the idestado
	 */
	public String getIdestado() {
		return idestado;
	}


	/**
	 * @param idestado the idestado to set
	 */
	public void setIdestado(String idestado) {
		this.idestado = idestado;
	}


	/**
	 * @return the reexpedicion
	 */
	public int getReexpedicion() {
		return reexpedicion;
	}


	/**
	 * @param reexpedicion the reexpedicion to set
	 */
	public void setReexpedicion(int reexpedicion) {
		this.reexpedicion = reexpedicion;
	}


	/**
	 * @return the p_inicial
	 */
	public int getP_inicial() {
		return p_inicial;
	}


	/**
	 * @param p_inicial the p_inicial to set
	 */
	public void setP_inicial(int p_inicial) {
		this.p_inicial = p_inicial;
	}


	/**
	 * @return the p_final
	 */
	public int getP_final() {
		return p_final;
	}


	/**
	 * @param p_final the p_final to set
	 */
	public void setP_final(int p_final) {
		this.p_final = p_final;
	}


	/**
	 * @return the kgadicional
	 */
	public double getKgadicional() {
		return kgadicional;
	}


	/**
	 * @param kgadicional the kgadicional to set
	 */
	public void setKgadicional(double kgadicional) {
		this.kgadicional = kgadicional;
	}
	/**
	 * @return the rutaDestinoEntrega
	 */
	public Ruta getRutaDestinoEntrega() {
		return rutaDestinoEntrega;
	}
	/**
	 * @param rutaDestinoEntrega the rutaDestinoEntrega to set
	 */
	public void setRutaDestinoEntrega(Ruta rutaDestinoEntrega) {
		this.rutaDestinoEntrega = rutaDestinoEntrega;
	}

}
