/**
 * 
 */
package com.administracion.dto;

import com.innovargia.salesmanager.dtos.RemDes;

/**
 * @author Adrian Morales Ruaro
 *
 */
public class EmpleadoDTO {
	private static final long serialVersionUID = 1L;
	private String curp;
	private String fotografia;
	private String nombre;
	private String fechanacimiento;
	public RemDes direccion = new RemDes();
	private String estadocivil;
	private String nacionalidad;
	private String licenciamanejo;
	private String tipodelicencia;
	private String vigencialicencia;
	private String fechaingreso;
	private String fechaegreso;
	private String departamento;
	private String area;
	private String puesto;
	private String credencialife;
	private String email;
	private String radio;
	private String estatus;
	private String observaciones;

	/**
	 * 
	 */
	public EmpleadoDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getCalle() {
		return direccion.getCalle();
	}

	public void setCalle(String calle) {
		direccion.setCalle(calle);
	}

	public String getColonia() {
		return direccion.getColonia();
	}

	public void setColonia(String colonia) {
		direccion.setColonia(colonia);
	}

	public String getCp() {
		return direccion.getCp();
	}

	public void setCp(String cp) {
		direccion.setCp(cp);
	}

	public String getMunicipio() {
		return direccion.getMunicipio();
	}

	public void setMunicipio(String municipio) {
		direccion.setMunicipio(municipio);
	}

	public String getEstado() {
		return direccion.getEstado();
	}

	public void setEstado(String estado) {
		direccion.setEstado(estado);
	}

	public String getTelefono() {
		return direccion.getTelefono();
	}

	public void setTelefono(String telefono) {
		direccion.setTelefono(telefono);
	}

	public String getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getLicenciamanejo() {
		return licenciamanejo;
	}

	public void setLicenciamanejo(String licenciamanejo) {
		this.licenciamanejo = licenciamanejo;
	}

	public String getTipodelicencia() {
		return tipodelicencia;
	}

	public void setTipodelicencia(String tipodelicencia) {
		this.tipodelicencia = tipodelicencia;
	}

	public String getVigencialicencia() {
		return vigencialicencia;
	}

	public void setVigencialicencia(String vigencialicencia) {
		this.vigencialicencia = vigencialicencia;
	}

	public String getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(String fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public String getFechaegreso() {
		return fechaegreso;
	}

	public void setFechaegreso(String fechaegreso) {
		this.fechaegreso = fechaegreso;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getCredencialife() {
		return credencialife;
	}

	public void setCredencialife(String credencialife) {
		this.credencialife = credencialife;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
