package mensajeria.forms;

import java.io.Serializable;

public class SeguimientoJSON implements Serializable {
	private static final long serialVersionUID = 1L;
	
	String nombreObjeto="SeguimientoJSON";
	
	Seguimiento seguimiento= new Seguimiento();
	EntregaForm entrega = new EntregaForm();
	public String getNombreObjeto() {
		return nombreObjeto;
	}
	public void setNombreObjeto(String nombreObjeto) {
		this.nombreObjeto = nombreObjeto;
	}
	public Seguimiento getSeguimiento() {
		return seguimiento;
	}
	public void setSeguimiento(Seguimiento seguimiento) {
		this.seguimiento = seguimiento;
	}
	public EntregaForm getEntrega() {
		return entrega;
	}
	public void setEntrega(EntregaForm entrega) {
		this.entrega = entrega;
	}

}
