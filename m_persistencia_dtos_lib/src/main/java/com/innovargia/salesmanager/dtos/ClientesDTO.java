package com.innovargia.salesmanager.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClientesDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int idcliente  ;
	int idgrupo    ;
	String numcliente  ;
	String descripcion  ;
	String referencia  ;
	String rfc   ;
	int estatus  ;
	int creditolimite  ;
	int creditousado ;
	String cuentabancaria  ;
	int idformapago   ;
	int idterminopago ;
	int idrepventas   ;
	int idimpuesto   ;
	int iddireccion  ;
	int idplaza     ;
	int idprogramafactura ;
	int tipo   ;
	int regimen  ;
	String observacion   ;
	String tipopersona   ;
	String razonsocial   ;
	String clasificacion;
	
	String descripcionGrupoCliente      ;
	String descripcionFormapago       ;
	String descripcionTerminoPago  ;
	String descripcionRepresentanteVentas   ;
	
	String descripcionImpuesto     ;
	String descripcionPlaza         ;
	String descripcionPoblacionpago   ;
	String descripcionProgramaFactura   ;
	String descripcionRegimen    ;
	String descripcionTipoPesona    ;
	String clavegrupo;
	String logincreador; //indica el login del usuario que creo el registro , esto puede servir para los agrupamientos
	
	int tipocliente=0; //0=prospecto, 1=cliente
	
	UsuarioDTO usuario;
	

	public UsuarioDTO getUsuario() {
		return usuario;
	}


	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}


	public ClientesDTO() {
		// TODO Auto-generated constructor stub
	}


	public int getIdcliente() {
		return idcliente;
	}


	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}


	public int getIdgrupo() {
		return idgrupo;
	}


	public void setIdgrupo(int idgrupo) {
		this.idgrupo = idgrupo;
	}


	public String getNumcliente() {
		return numcliente;
	}


	public void setNumcliente(String numcliente) {
		this.numcliente = numcliente;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}


	public String getRfc() {
		return rfc;
	}


	public void setRfc(String rfc) {
		this.rfc = rfc;
	}


	public int getEstatus() {
		return estatus;
	}


	public void setEstatus(int estatus) {
		this.estatus = estatus;
	}


	public int getCreditolimite() {
		return creditolimite;
	}


	public void setCreditolimite(int creditolimite) {
		this.creditolimite = creditolimite;
	}


	public int getCreditousado() {
		return creditousado;
	}


	public void setCreditousado(int creditousado) {
		this.creditousado = creditousado;
	}


	public String getCuentabancaria() {
		return cuentabancaria;
	}


	public void setCuentabancaria(String cuentabancaria) {
		this.cuentabancaria = cuentabancaria;
	}


	public int getIdformapago() {
		return idformapago;
	}


	public void setIdformapago(int idformapago) {
		this.idformapago = idformapago;
	}


	public int getIdterminopago() {
		return idterminopago;
	}


	public void setIdterminopago(int idterminopago) {
		this.idterminopago = idterminopago;
	}


	public int getIdrepventas() {
		return idrepventas;
	}


	public void setIdrepventas(int idrepventas) {
		this.idrepventas = idrepventas;
	}


	public int getIdimpuesto() {
		return idimpuesto;
	}


	public String getDescripcionTipoPesona() {
		return descripcionTipoPesona;
	}


	public void setDescripcionTipoPesona(String descripcionTipoPesona) {
		this.descripcionTipoPesona = descripcionTipoPesona;
	}


	public void setIdimpuesto(int idimpuesto) {
		this.idimpuesto = idimpuesto;
	}


	public int getIddireccion() {
		return iddireccion;
	}


	public void setIddireccion(int iddireccion) {
		this.iddireccion = iddireccion;
	}


	public int getIdplaza() {
		return idplaza;
	}


	public void setIdplaza(int idplaza) {
		this.idplaza = idplaza;
	}


	public int getIdprogramafactura() {
		return idprogramafactura;
	}


	public void setIdprogramafactura(int idprogramafactura) {
		this.idprogramafactura = idprogramafactura;
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}


	public int getRegimen() {
		return regimen;
	}


	public void setRegimen(int regimen) {
		this.regimen = regimen;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public String getDescripcionFormapago() {
		return descripcionFormapago;
	}


	public void setDescripcionFormapago(String descripcionFormapago) {
		this.descripcionFormapago = descripcionFormapago;
	}


	public String getDescripcionTerminoPago() {
		return descripcionTerminoPago;
	}


	public void setDescripcionTerminoPago(String descripcionTerminoPago) {
		this.descripcionTerminoPago = descripcionTerminoPago;
	}


	public String getDescripcionRepresentanteVentas() {
		return descripcionRepresentanteVentas;
	}


	public void setDescripcionRepresentanteVentas(
			String descripcionRepresentanteVentas) {
		this.descripcionRepresentanteVentas = descripcionRepresentanteVentas;
	}


	public String getDescripcionImpuesto() {
		return descripcionImpuesto;
	}


	public void setDescripcionImpuesto(String descripcionImpuesto) {
		this.descripcionImpuesto = descripcionImpuesto;
	}


	public String getDescripcionPlaza() {
		return descripcionPlaza;
	}


	public void setDescripcionPlaza(String descripcionPlaza) {
		this.descripcionPlaza = descripcionPlaza;
	}


	public String getDescripcionPoblacionpago() {
		return descripcionPoblacionpago;
	}


	public void setDescripcionPoblacionpago(String descripcionPoblacionpago) {
		this.descripcionPoblacionpago = descripcionPoblacionpago;
	}


	public String getDescripcionProgramaFactura() {
		return descripcionProgramaFactura;
	}


	public void setDescripcionProgramaFactura(String descripcionProgramaFactura) {
		this.descripcionProgramaFactura = descripcionProgramaFactura;
	}


	public String getDescripcionRegimen() {
		return descripcionRegimen;
	}


	public void setDescripcionRegimen(String descripcionRegimen) {
		this.descripcionRegimen = descripcionRegimen;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getRazonsocial() {
		return razonsocial;
	}


	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}


	public String getDescripcionGrupoCliente() {
		return descripcionGrupoCliente;
	}


	public void setDescripcionGrupoCliente(String descripcionGrupoCliente) {
		this.descripcionGrupoCliente = descripcionGrupoCliente;
	}


	public String getClavegrupo() {
		return clavegrupo;
	}


	public void setClavegrupo(String clavegrupo) {
		this.clavegrupo = clavegrupo;
	}


	/**
	 * @return the tipopersona
	 */
	public String getTipopersona() {
		return tipopersona;
	}


	/**
	 * @param tipopersona the tipopersona to set
	 */
	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}


	/**
	 * @return the tipocliente
	 */
	public int getTipocliente() {
		return tipocliente;
	}


	/**
	 * @param tipocliente the tipocliente to set
	 */
	public void setTipocliente(int tipocliente) {
		this.tipocliente = tipocliente;
	}
	
	/**
	 * @param tipocliente the tipocliente to set
	 */
	public void setTipocliente(String tipocliente) {
		try{
			this.tipocliente = Integer.parseInt(tipocliente);
		}catch(Exception e){
			
		}
		
	}


	/**
	 * @return the logincreador
	 */
	public String getLogincreador() {
		return logincreador;
	}


	/**
	 * @param logincreador the logincreador to set
	 */
	public void setLogincreador(String logincreador) {
		this.logincreador = logincreador;
	}


	public String getClasificacion() {
		return clasificacion;
	}


	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

}
