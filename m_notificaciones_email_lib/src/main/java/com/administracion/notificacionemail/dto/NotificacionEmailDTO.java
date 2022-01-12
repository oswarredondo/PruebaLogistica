package com.administracion.notificacionemail.dto;

import java.io.Serializable;

public class NotificacionEmailDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String numcliente ;
	String tipo_notificacion;
	String momento_notificacion;
	String notifica_rem_confirmacion;
	String platilla_notificacion;
	
	String subject;
	String emaill_from;
	
	  
	public String getNumcliente() {
		return numcliente;
	}
	public void setNumcliente(String numcliente) {
		this.numcliente = numcliente;
	}
	public String getTipo_notificacion() {
		return tipo_notificacion;
	}
	public void setTipo_notificacion(String tipo_notificacion) {
		this.tipo_notificacion = tipo_notificacion;
	}
	public String getMomento_notificacion() {
		return momento_notificacion;
	}
	public void setMomento_notificacion(String momento_notificacion) {
		this.momento_notificacion = momento_notificacion;
	}
	public String getNotifica_rem_confirmacion() {
		return notifica_rem_confirmacion;
	}
	public void setNotifica_rem_confirmacion(String notifica_rem_confirmacion) {
		this.notifica_rem_confirmacion = notifica_rem_confirmacion;
	}
	public String getPlatilla_notificacion() {
		return platilla_notificacion;
	}
	public void setPlatilla_notificacion(String platilla_notificacion) {
		this.platilla_notificacion = platilla_notificacion;
	}
	
	/**
	 * Reemplaza los valores de las cadenas en la pantilla que se va a mandar por correo
	 * @param idguia
	 * @param razonsocialrigen
	 * @param atencionorigen
	 * @param razonsocialdes
	 * @param atenciondes
	 */
	public String replaceDatos(String idguia,String razonsocialrigen,
			String atencionorigen,String razonsocialdes,String atenciondes  ){
		idguia =idguia==null?"":idguia;
		razonsocialrigen =razonsocialrigen==null?"":razonsocialrigen;
		atencionorigen =atencionorigen==null?"":atencionorigen;
		razonsocialdes =razonsocialdes==null?"":razonsocialdes;
		atenciondes =atenciondes==null?"":atenciondes;
		String mipantilla= "";
		if (this.platilla_notificacion!=null){
			mipantilla =
					this.platilla_notificacion.replaceAll("@IDGUIA", idguia).
					replaceAll("@RAZONSOCIALORIGEN", razonsocialrigen).
					replaceAll("@ATENCIONORIGEN", atencionorigen).
					replaceAll("@RAZONSOCIALDES", razonsocialdes).
					replaceAll("@ATENCIONDES", atenciondes);
		}
		
		return mipantilla!=null?mipantilla.trim():"";
		
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmaill_from() {
		return emaill_from;
	}
	public void setEmaill_from(String emaill_from) {
		this.emaill_from = emaill_from;
	}
	
	
}
