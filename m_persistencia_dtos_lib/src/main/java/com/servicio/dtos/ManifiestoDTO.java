/**
 * 
 */
package com.servicio.dtos;


/**
 * @author Adrian Morales Ruaro
 *
 */
public class ManifiestoDTO implements java.io.Serializable {
	
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ruta;
	private String fechaini;
	private String fechafin;
	private String preAsigandoPendiente;
	private String tipoDocumento;
	private String empaque_asig;
	private float pesovolumetrico_asig;
	private float pesofisico_asig;
	private float volumen_asig;
	private int   cantidad_asig;
	private String empaque_pend;
	private float pesovolumetrico_pend;
	private float pesofisico_pend;
	private float volumen_pend;
	private int   cantidad_pend;
	private String manifiesto;
	private String tipomanifiesto;   //Distribucion, Entrega
	private String idDocumento;
	private int   pos_manif;
	private String unidadreparto;
	private boolean soloSinManifestar= false;
	private String login;
	private String prefijo_manifiesto="ME";
	private String idoficina;
	private String siglasplaza;
	private String corrida;
	
	 String viaje;
	    String tramo;
	    String supervisor ;
	    String operador1 ;
	    String operador2 ;
	    String economico ;
	    String cincho ;
	    String tipotranslado;
	
	
	private boolean pdv= false;
	/**
	 * @return the tipomanifiesto
	 */
	public String getTipomanifiesto() {
		return tipomanifiesto;
	}

	/**
	 * @param tipomanifiesto the tipomanifiesto to set
	 */
	public void setTipomanifiesto(String tipomanifiesto) {
		this.tipomanifiesto = tipomanifiesto;
	}

	private String fechaManifiesto;
	private String enrutamientoTransportista;

	/**
	 * 
	 */
	public ManifiestoDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}

	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * @return the empaque_asig
	 */
	public String getEmpaque_asig() {
		return empaque_asig;
	}

	/**
	 * @param empaque_asig the empaque_asig to set
	 */
	public void setEmpaque_asig(String empaque_asig) {
		this.empaque_asig = empaque_asig;
	}

	/**
	 * @return the pesovolumetrico_asig
	 */
	public float getPesovolumetrico_asig() {
		return pesovolumetrico_asig;
	}

	/**
	 * @param pesovolumetrico_asig the pesovolumetrico_asig to set
	 */
	public void setPesovolumetrico_asig(float pesovolumetrico_asig) {
		this.pesovolumetrico_asig = pesovolumetrico_asig;
	}

	/**
	 * @return the pesofisico_asig
	 */
	public float getPesofisico_asig() {
		return pesofisico_asig;
	}

	/**
	 * @param pesofisico_asig the pesofisico_asig to set
	 */
	public void setPesofisico_asig(float pesofisico_asig) {
		this.pesofisico_asig = pesofisico_asig;
	}

	/**
	 * @return the volumen_asig
	 */
	public float getVolumen_asig() {
		return volumen_asig;
	}

	/**
	 * @param volumen_asig the volumen_asig to set
	 */
	public void setVolumen_asig(float volumen_asig) {
		this.volumen_asig = volumen_asig;
	}

	/**
	 * @return the cantidad_asig
	 */
	public int getCantidad_asig() {
		return cantidad_asig;
	}

	/**
	 * @param cantidad_asig the cantidad_asig to set
	 */
	public void setCantidad_asig(int cantidad_asig) {
		this.cantidad_asig = cantidad_asig;
	}

	/**
	 * @return the empaque_pend
	 */
	public String getEmpaque_pend() {
		return empaque_pend;
	}

	/**
	 * @param empaque_pend the empaque_pend to set
	 */
	public void setEmpaque_pend(String empaque_pend) {
		this.empaque_pend = empaque_pend;
	}

	/**
	 * @return the pesovolumetrico_pend
	 */
	public float getPesovolumetrico_pend() {
		return pesovolumetrico_pend;
	}

	/**
	 * @param pesovolumetrico_pend the pesovolumetrico_pend to set
	 */
	public void setPesovolumetrico_pend(float pesovolumetrico_pend) {
		this.pesovolumetrico_pend = pesovolumetrico_pend;
	}

	/**
	 * @return the pesofisico_pend
	 */
	public float getPesofisico_pend() {
		return pesofisico_pend;
	}

	/**
	 * @param pesofisico_pend the pesofisico_pend to set
	 */
	public void setPesofisico_pend(float pesofisico_pend) {
		this.pesofisico_pend = pesofisico_pend;
	}

	/**
	 * @return the volumen_pend
	 */
	public float getVolumen_pend() {
		return volumen_pend;
	}

	/**
	 * @param volumen_pend the volumen_pend to set
	 */
	public void setVolumen_pend(float volumen_pend) {
		this.volumen_pend = volumen_pend;
	}

	/**
	 * @return the cantidad_pend
	 */
	public int getCantidad_pend() {
		return cantidad_pend;
	}

	/**
	 * @param cantidad_pend the cantidad_pend to set
	 */
	public void setCantidad_pend(int cantidad_pend) {
		this.cantidad_pend = cantidad_pend;
	}

	/**
	 * @return the fechaini
	 */
	public String getFechaini() {
		return fechaini;
	}

	/**
	 * @param fechaini the fechaini to set
	 */
	public void setFechaini(String fechaini) {
		this.fechaini = fechaini;
	}

	/**
	 * @return the fechafin
	 */
	public String getFechafin() {
		return fechafin;
	}
	


	/**
	 * @param fechafin the fechafin to set
	 */
	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the preAsigandoPendiente
	 */
	public String getPreAsigandoPendiente() {
		return preAsigandoPendiente;
	}

	/**
	 * @param preAsigandoPendiente the preAsigandoPendiente to set
	 */
	public void setPreAsigandoPendiente(String preAsigandoPendiente) {
		this.preAsigandoPendiente = preAsigandoPendiente;
	}

	/**
	 * @return the manifiesto
	 */
	public String getManifiesto() {
		return manifiesto;
	}

	/**
	 * @param manifiesto the manifiesto to set
	 */
	public void setManifiesto(String manifiesto) {
		this.manifiesto = manifiesto;
	}

	/**
	 * @return the fechaManifiesto
	 */
	public String getFechaManifiesto() {
		return fechaManifiesto;
	}

	/**
	 * @param fechaManifiesto the fechaManifiesto to set
	 */
	public void setFechaManifiesto(String fechaManifiesto) {
		this.fechaManifiesto = fechaManifiesto;
	}

	/**
	 * @return the enrutamientoTransportista
	 */
	public String getEnrutamientoTransportista() {
		return enrutamientoTransportista;
	}

	/**
	 * @param enrutamientoTransportista the enrutamientoTransportista to set
	 */
	public void setEnrutamientoTransportista(String enrutamientoTransportista) {
		this.enrutamientoTransportista = enrutamientoTransportista;
	}

	/**
	 * @return the idDocumento
	 */
	public String getIdDocumento() {
		return idDocumento;
	}

	/**
	 * @param idDocumento the idDocumento to set
	 */
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	/**
	 * @return the pos_manif
	 */
	public int getPos_manif() {
		return pos_manif;
	}

	/**
	 * @param pos_manif the pos_manif to set
	 */
	public void setPos_manif(int pos_manif) {
		this.pos_manif = pos_manif;
	}

	public void setPos_manif(String pos_manif) {
		try{
			this.pos_manif = Integer.parseInt(pos_manif);
		}catch(Exception e){
			this.pos_manif =-1;
		}
		
	}
	
	/**
	 * @return the unidadreparto
	 */
	public String getUnidadreparto() {
		return unidadreparto;
	}

	/**
	 * @param unidadreparto the unidadreparto to set
	 */
	public void setUnidadreparto(String unidadreparto) {
		this.unidadreparto = unidadreparto;
	}

	/**
	 * @return the soloSinManifestar
	 */
	public boolean isSoloSinManifestar() {
		return soloSinManifestar;
	}

	/**
	 * @param soloSinManifestar the soloSinManifestar to set
	 */
	public void setSoloSinManifestar(boolean soloSinManifestar) {
		this.soloSinManifestar = soloSinManifestar;
	}
	
	/**
	 * @param soloSinManifestar the soloSinManifestar to set
	 */
	public void setSoloSinManifestar(String soloSinManifestar) {
		this.soloSinManifestar = Boolean.parseBoolean(soloSinManifestar.toLowerCase());
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the pdv
	 */
	public boolean isPdv() {
	    return pdv;
	}

	/**
	 * @param pdv the pdv to set
	 */
	public void setPdv(boolean pdv) {
	    this.pdv = pdv;
	}

	/**
	 * @return the prefijo_manifiesto
	 */
	public String getPrefijo_manifiesto() {
	    return prefijo_manifiesto;
	}

	/**
	 * @param prefijo_manifiesto the prefijo_manifiesto to set
	 */
	public void setPrefijo_manifiesto(String prefijo_manifiesto) {
	    this.prefijo_manifiesto = prefijo_manifiesto;
	}

	/**
	 * @return the idoficina
	 */
	public String getIdoficina() {
	    return idoficina;
	}

	/**
	 * @param idoficina the idoficina to set
	 */
	public void setIdoficina(String idoficina) {
	    this.idoficina = idoficina;
	}

	/**
	 * @return the viaje
	 */
	public String getViaje() {
	    return viaje;
	}

	/**
	 * @param viaje the viaje to set
	 */
	public void setViaje(String viaje) {
	    this.viaje = viaje;
	}

	/**
	 * @return the tramo
	 */
	public String getTramo() {
	    return tramo;
	}

	/**
	 * @param tramo the tramo to set
	 */
	public void setTramo(String tramo) {
	    this.tramo = tramo;
	}

	/**
	 * @return the supervisor
	 */
	public String getSupervisor() {
	    return supervisor;
	}

	/**
	 * @param supervisor the supervisor to set
	 */
	public void setSupervisor(String supervisor) {
	    this.supervisor = supervisor;
	}

	/**
	 * @return the operador1
	 */
	public String getOperador1() {
	    return operador1;
	}

	/**
	 * @param operador1 the operador1 to set
	 */
	public void setOperador1(String operador1) {
	    this.operador1 = operador1;
	}

	/**
	 * @return the operador2
	 */
	public String getOperador2() {
	    return operador2;
	}

	/**
	 * @param operador2 the operador2 to set
	 */
	public void setOperador2(String operador2) {
	    this.operador2 = operador2;
	}

	/**
	 * @return the economico
	 */
	public String getEconomico() {
	    return economico;
	}

	/**
	 * @param economico the economico to set
	 */
	public void setEconomico(String economico) {
	    this.economico = economico;
	}

	/**
	 * @return the cincho
	 */
	public String getCincho() {
	    return cincho;
	}

	/**
	 * @param cincho the cincho to set
	 */
	public void setCincho(String cincho) {
	    this.cincho = cincho;
	}

	/**
	 * @return the tipotranslado
	 */
	public String getTipotranslado() {
	    return tipotranslado;
	}

	/**
	 * @param tipotranslado the tipotranslado to set
	 */
	public void setTipotranslado(String tipotranslado) {
	    this.tipotranslado = tipotranslado;
	}

	/**
	 * @return the siglasplaza
	 */
	public String getSiglasplaza() {
	    return siglasplaza;
	}

	/**
	 * @param siglasplaza the siglasplaza to set
	 */
	public void setSiglasplaza(String siglasplaza) {
	    this.siglasplaza = siglasplaza;
	}

	/**
	 * @return the corrida
	 */
	public String getCorrida() {
	    return corrida;
	}

	/**
	 * @param corrida the corrida to set
	 */
	public void setCorrida(String corrida) {
	    this.corrida = corrida;
	}

}
