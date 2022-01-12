/**
 * 
 */
package com.administracion.dto;


/**
 * @author Adrian Morales Ruaro
 *
 */
public class KardexDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idalcakardexalmacen;
	

	private String iddocumento;
	private String fecha;
	private String movimiento;
	private String idproducto;
	private int idalmacen;
	private String codigoubicacion;
	private int idubicacion;
	private float entrada;
	private float salida;
	private float saldo;
	private float costounitario;
	private String observacion;
	private String descripcion_mov;
	private int idorganizacion;
	           
   
	/**
	 * @return the descripcion_mov
	 */
	public String getDescripcion_mov() {
		return descripcion_mov;
	}

	/**
	 * @param descripcion_mov the descripcion_mov to set
	 */
	public void setDescripcion_mov(String descripcion_mov) {
		this.descripcion_mov = descripcion_mov;
	}

	/**
	 * 
	 */
	public KardexDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getIdalcakardexalmacen() {
		return idalcakardexalmacen;
	}


	public void setIdalcakardexalmacen(int idalcakardexalmacen) {
		this.idalcakardexalmacen = idalcakardexalmacen;
	}


	public String getIddocumento() {
		return iddocumento;
	}


	public void setIddocumento(String iddocumento) {
		this.iddocumento = iddocumento;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getMovimiento() {
		return movimiento;
	}


	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}


	public String getIdproducto() {
		return idproducto;
	}


	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}


	public String getCodigoUbicacion() {
		return codigoubicacion;
	}


	public void setCodigoUbicacion(String codigoubicacion) {
		this.codigoubicacion = codigoubicacion;
	}


	public float getEntrada() {
		return entrada;
	}


	public void setEntrada(float entrada) {
		this.entrada = entrada;
	}


	public float getSalida() {
		return salida;
	}


	public void setSalida(float salida) {
		this.salida = salida;
	}


	public float getSaldo() {
		return saldo;
	}


	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}


	public float getCostounitario() {
		return costounitario;
	}


	public void setCostounitario(float costounitario) {
		this.costounitario = costounitario;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public int getIdalmacen() {
		return idalmacen;
	}

	public void setIdalmacen(int idalmacen) {
		this.idalmacen = idalmacen;
	}

	public int getIdubicacion() {
		return idubicacion;
	}

	public void setIdubicacion(int idubicacion) {
		this.idubicacion = idubicacion;
	}

	/**
	 * @return the idorganizacion
	 */
	public int getIdorganizacion() {
		return idorganizacion;
	}

	/**
	 * @param idorganizacion the idorganizacion to set
	 */
	public void setIdorganizacion(int idorganizacion) {
		this.idorganizacion = idorganizacion;
	}

}
