package com.administracion.andrea.dto;

import java.io.Serializable;
import java.util.List;

public class GuiaEmbarque implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  protected String usuario;
	    protected String contrasena;
	    protected String folioOrdenServicio;
	    protected DetalleEnvio detalleEnvio;
	    protected Destinatario destinatario;
	    protected List<Paquete>  paquetes;
	    protected String referenciaGuia;
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public String getContrasena() {
			return contrasena;
		}
		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}
		public String getFolioOrdenServicio() {
			return folioOrdenServicio;
		}
		public void setFolioOrdenServicio(String folioOrdenServicio) {
			this.folioOrdenServicio = folioOrdenServicio;
		}
		public DetalleEnvio getDetalleEnvio() {
			return detalleEnvio;
		}
		public void setDetalleEnvio(DetalleEnvio detalleEnvio) {
			this.detalleEnvio = detalleEnvio;
		}
		public Destinatario getDestinatario() {
			return destinatario;
		}
		public void setDestinatario(Destinatario destinatario) {
			this.destinatario = destinatario;
		}
		public List<Paquete> getPaquetes() {
			return paquetes;
		}
		public void setPaquetes(List<Paquete> paquetes) {
			this.paquetes = paquetes;
		}
		public String getReferenciaGuia() {
			return referenciaGuia;
		}
		public void setReferenciaGuia(String referenciaGuia) {
			this.referenciaGuia = referenciaGuia;
		}
	
	

}
