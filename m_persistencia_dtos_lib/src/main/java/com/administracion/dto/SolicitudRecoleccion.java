/**
 * 
 */
package com.administracion.dto;

import java.io.Serializable;

/**
 * @author aruaro
 *
 */
public class SolicitudRecoleccion implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idregistro;
	private String idsolicitud;
	private String idrecoleccion;
	//Datos del solicitante
	private String numempleado;
	private String quiensolicita;
	private String correosolicita;
	private String telefonosolicita;
	private String celularsolicita;
	private String numoficina;
	
	private String numcliente;
	private String razonsocialcliente;
	private String contrato;
	
	private int idtiporecol;
	private String idempaque;
	private String fechainicio;
	private String fechafin;
	private String fecharecol;
	
	private String razonsocial;
	private String preguntarpor;
	private String departamento;
	private String calle;
	private String cp;
	private String colonia;
	
	private String municipio;
	private String estado;
	private String telefono;
	private String celular;
	private String email;
	
	private int cantidadpzas;
	private float pesokg;
	private float pesototal;
	private float alto;
	private float ancho;
	private float largo;
	private float volumen;

	private String contenido;
	private String observacion;
	private String plaza;
	private String rutaasignada;

//	private String emailrecol;
	private int idorganizacion;
	private int identidad;
	private String estatus;
	private String fechacreacion;
	private String fechacancelacion;
	private String quiencancela;
	private String motivocancelacion;
	private String manifiesto;
	private String idusuariocreador;
	private String cuenta_estatus;
	private String longitud;
	private String latitud;
	public int tipoConsulta = 0;
	private String descripciontiposolicitud;
	private String descripcionempaque;
	/**
	 * 
	 */
	public SolicitudRecoleccion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the tipoConsulta
	 */
	public String getManifiesto() {
		return manifiesto;
	}

	/**
	 * @param tipoConsulta
	 *            the tipoConsulta to set
	 */
	public void setManifiesto(String manifiesto) {
		this.manifiesto = manifiesto;
	}

	/**
	 * @return the tipoConsulta
	 */
	public int getTipoConsulta() {
		return tipoConsulta;
	}

	/**
	 * @param tipoConsulta
	 *            the tipoConsulta to set
	 */
	public void setTipoConsulta(int tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	/**
	 * @param tipoConsulta
	 *            the tipoConsulta to set
	 */
	public void setTipoConsulta(String tipoConsulta) {

		try {
			this.tipoConsulta = Integer.parseInt(tipoConsulta);
		} catch (Exception e) {
		}

	}

	/**
	 * @return the idsolicitud
	 */
	public String getIdsolicitud() {
		return idsolicitud;
	}

	/**
	 * @param idsolicitud
	 *            the idsolicitud to set
	 */
	public void setIdsolicitud(String idsolicitud) {
		this.idsolicitud = idsolicitud;
	}

	/**
	 * @return the numcliente
	 */
	public String getNumcliente() {
		return numcliente;
	}

	/**
	 * @param numcliente
	 *            the numcliente to set
	 */
	public void setNumcliente(String numcliente) {
		this.numcliente = numcliente;
	}

	/**
	 * @return the quiensolicita
	 */
	public String getQuiensolicita() {
		return quiensolicita;
	}

	/**
	 * @param quiensolicita
	 *            the quiensolicita to set
	 */
	public void setQuiensolicita(String quiensolicita) {
		this.quiensolicita = quiensolicita;
	}

	/**
	 * @return the departamento
	 */
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento
	 *            the departamento to set
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	/**
	 * @return the preguntarpor
	 */
	public String getPreguntarpor() {
		return preguntarpor;
	}

	/**
	 * @param preguntarpor
	 *            the preguntarpor to set
	 */
	public void setPreguntarpor(String preguntarpor) {
		this.preguntarpor = preguntarpor;
	}

	/**
	 * @return the cantidadpzas
	 */
	public int getCantidadpzas() {
		return cantidadpzas;
	}

	/**
	 * @param cantidadpzas
	 *            the cantidadpzas to set
	 */
	public void setCantidadpzas(int cantidadpzas) {
		this.cantidadpzas = cantidadpzas;
	}
	/**
	 * @param cantidadpzas
	 *            the cantidadpzas to set
	 */
	public void setCantidadpzas(String cantidadpzas) {
		try{
			this.cantidadpzas = Integer.parseInt(cantidadpzas);
		}catch(Exception e ){
		}
		
	}
	/**
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * @param calle
	 *            the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * @return the colonia
	 */
	public String getColonia() {
		return colonia;
	}

	/**
	 * @param colonia
	 *            the colonia to set
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * @param cp
	 *            the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio
	 *            the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular
	 *            the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus
	 *            the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the idtiporecol
	 */
	public int getIdtiporecol() {
		return idtiporecol;
	}

	/**
	 * @param idtiporecol
	 *            the idtiporecol to set
	 */
	public void setIdtiporecol(int idtiporecol) {
		this.idtiporecol = idtiporecol;
		if (this.idtiporecol==1){
			this.descripciontiposolicitud =  "PROGRAMADA POR DIA SEMANA";
		}else if (this.idtiporecol==2){
			this.descripciontiposolicitud= "PROGRAMADA POR DIA MES";
		}else if (this.idtiporecol==3){
			this.descripciontiposolicitud= "ORDER DE RECOLECCION";
		}else{
			this.descripciontiposolicitud = "";
		}
	}

	/**
	 * @param idtiporecol
	 *            the pesokg to set
	 */
	public void setIdtiporecol(String idtiporecol) {
		try {
			setIdtiporecol(Integer.parseInt(idtiporecol));
		} catch (Exception e) {
		}

	}

	/**
	 * @return the idempaque
	 */
	public String getIdempaque() {
		return idempaque;
	}

	/**
	 * @param idempaque
	 *            the idempaque to set
	 */
	public void setIdempaque(String idempaque) {
		this.idempaque = idempaque;
		if ("1".equals(idempaque)) this.descripcionempaque = "SOBRES";
		if ("2".equals(idempaque)) this.descripcionempaque = "PAQUETES";
		if ("3".equals(idempaque)) this.descripcionempaque = "CAJAS";
		if ("4".equals(idempaque)) this.descripcionempaque = "PALLETS";
		if ("5".equals(idempaque)) this.descripcionempaque = "TUBOS";
		if ("6".equals(idempaque)) this.descripcionempaque = "BULTOS";
		if ("7".equals(idempaque)) this.descripcionempaque = "VALIJAS";

	}

	/**
	 * @return the fechafin
	 */
	public String getFechafin() {
		return fechafin;
	}

	/**
	 * @param fechafin
	 *            the fechafin to set
	 */
	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato
	 *            the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion
	 *            the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the fechainicio
	 */
	public String getFechainicio() {
		return fechainicio;
	}

	/**
	 * @param fechainicio
	 *            the fechainicio to set
	 */
	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	/**
	 * @return the rutaasignada
	 */
	public String getRutaasignada() {
		return rutaasignada;
	}

	/**
	 * @param rutaasignada
	 *            the rutaasignada to set
	 */
	public void setRutaasignada(String rutaasignada) {
		this.rutaasignada = rutaasignada;
	}

	/**
	 * @return the pesokg
	 */
	public float getPesokg() {
		return pesokg;
	}

	/**
	 * @param pesokg
	 *            the pesokg to set
	 */
	public void setPesokg(float pesokg) {
		this.pesokg = pesokg;
	}

	/**
	 * @param pesokg
	 *            the pesokg to set
	 */
	public void setPesokg(String pesokg) {
		try {
			this.pesokg = Float.parseFloat(pesokg);
		} catch (Exception e) {
		}

	}

	/**
	 * @return the pesototal
	 */
	public float getPesototal() {
		return pesototal;
	}

	/**
	 * @param pesototal
	 *            the pesokg to set
	 */
	public void setPesototal(float pesototal) {
		this.pesototal = pesototal;
	}

	/**
	 * @param pesototal
	 *            the pesokg to set
	 */
	public void setPesototal(String pesototal) {
		try {
			this.pesototal = Float.parseFloat(pesototal);
		} catch (Exception e) {
		}

	}

	/**
	 * @return the alto
	 */
	public float getAlto() {
		return alto;
	}

	/**
	 * @param alto
	 *            the alto to set
	 */
	public void setAlto(float alto) {
		this.alto = alto;
	}

	/**
	 * @param alto
	 *            the pesokg to set
	 */
	public void setAlto(String alto) {
		try {
			this.alto = Float.parseFloat(alto);
		} catch (Exception e) {
		}

	}

	/**
	 * @return the ancho
	 */
	public float getAncho() {
		return ancho;
	}

	/**
	 * @param ancho
	 *            the ancho to set
	 */
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	/**
	 * @param ancho
	 *            the pesokg to set
	 */
	public void setAncho(String ancho) {
		try {
			this.ancho = Float.parseFloat(ancho);
		} catch (Exception e) {
		}

	}

	/**
	 * @return the largo
	 */
	public float getLargo() {
		return largo;
	}

	/**
	 * @param largo
	 *            the largo to set
	 */
	public void setLargo(float largo) {
		this.largo = largo;
	}

	/**
	 * @param largo
	 *            the pesokg to set
	 */
	public void setLargo(String largo) {
		try {
			this.largo = Float.parseFloat(largo);
		} catch (Exception e) {
		}

	}

	/**
	 * @return the volumen
	 */
	public float getVolumen() {
		return volumen;
	}

	/**
	 * @param volumen
	 *            the volumen to set
	 */
	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	/**
	 * @param volumen
	 *            the pesokg to set
	 */
	public void setVolumen(String volumen) {
		try {
			this.volumen = Float.parseFloat(volumen);
		} catch (Exception e) {
		}

	}

	/**
	 * @return the idusuartiocreador
	 */
	public String getIdusuariocreador() {
		return idusuariocreador;
	}

	/**
	 * @param idusuartiocreador
	 *            the idusuartiocreador to set
	 */
	public void setIdusuariocreador(String idusuariocreador) {
		this.idusuariocreador = idusuariocreador;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the razonsocial
	 */
	public String getRazonsocial() {
		return razonsocial;
	}

	/**
	 * @param razonsocial
	 *            the razonsocial to set
	 */
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}



	/**
	 * @return the contenido
	 */
	public String getContenido() {
		return contenido;
	}

	/**
	 * @param contenido
	 *            the contenido to set
	 */
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * @return the identidad
	 */
	public int getIdentidad() {
		return identidad;
	}

	/**
	 * @param identidad
	 *            the identidad to set
	 */
	public void setIdentidad(int identidad) {
		this.identidad = identidad;
	}

	/**
	 * @return the idorganizacion
	 */
	public int getIdorganizacion() {
		return idorganizacion;
	}

	/**
	 * @param idorganizacion
	 *            the idorganizacion to set
	 */
	public void setIdorganizacion(int idorganizacion) {
		this.idorganizacion = idorganizacion;
	}

	/**
	 * @return the numempleado
	 */
	public String getNumempleado() {
		return numempleado;
	}

	/**
	 * @param numempleado
	 *            the numempleado to set
	 */
	public void setNumempleado(String numempleado) {
		this.numempleado = numempleado;
	}

	/**
	 * @return the numoficina
	 */
	public String getNumoficina() {
		return numoficina;
	}

	/**
	 * @param numoficina
	 *            the numoficina to set
	 */
	public void setNumoficina(String numoficina) {
		this.numoficina = numoficina;
	}

	/**
	 * @return the idrecoleccion
	 */
	public String getIdrecoleccion() {
		return idrecoleccion;
	}

	/**
	 * @param idrecoleccion
	 *            the idrecoleccion to set
	 */
	public void setIdrecoleccion(String idrecoleccion) {
		this.idrecoleccion = idrecoleccion;
	}

	/**
	 * @return the fecharecol
	 */
	public String getFecharecol() {
		return fecharecol;
	}

	/**
	 * @param fecharecol
	 *            the fecharecol to set
	 */
	public void setFecharecol(String fecharecol) {
		this.fecharecol = fecharecol;
	}

	/**
	 * @return the fechacreacion
	 */
	public String getFechacreacion() {
		return fechacreacion;
	}

	/**
	 * @param fechacreacion
	 *            the fechacreacion to set
	 */
	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	/**
	 * @return the fechacancelacion
	 */
	public String getFechacancelacion() {
		return fechacancelacion;
	}

	/**
	 * @param fechacancelacion
	 *            the fechacancelacion to set
	 */
	public void setFechacancelacion(String fechacancelacion) {
		this.fechacancelacion = fechacancelacion;
	}

	/**
	 * @return the quiencancela
	 */
	public String getQuiencancela() {
		return quiencancela;
	}

	/**
	 * @param quiencancela
	 *            the quiencancela to set
	 */
	public void setQuiencancela(String quiencancela) {
		this.quiencancela = quiencancela;
	}

	/**
	 * @return the motivocancelacion
	 */
	public String getMotivocancelacion() {
		return motivocancelacion;
	}

	/**
	 * @param motivocancelacion
	 *            the motivocancelacion to set
	 */
	public void setMotivocancelacion(String motivocancelacion) {
		this.motivocancelacion = motivocancelacion;
	}

	/**
	 * @return the plaza
	 */
	public String getPlaza() {
		return plaza;
	}

	/**
	 * @param plaza the plaza to set
	 */
	public void setPlaza(String plaza) {
		this.plaza = plaza;
	}

	/**
	 * @return the correosolicita
	 */
	public String getCorreosolicita() {
		return correosolicita;
	}

	/**
	 * @param correosolicita the correosolicita to set
	 */
	public void setCorreosolicita(String correosolicita) {
		this.correosolicita = correosolicita;
	}

	/**
	 * @return the telefonosolicita
	 */
	public String getTelefonosolicita() {
		return telefonosolicita;
	}

	/**
	 * @param telefonosolicita the telefonosolicita to set
	 */
	public void setTelefonosolicita(String telefonosolicita) {
		this.telefonosolicita = telefonosolicita;
	}

	/**
	 * @return the celularsolicita
	 */
	public String getCelularsolicita() {
		return celularsolicita;
	}

	/**
	 * @param celularsolicita the celularsolicita to set
	 */
	public void setCelularsolicita(String celularsolicita) {
		this.celularsolicita = celularsolicita;
	}

	/**
	 * @return the razonsocialcliente
	 */
	public String getRazonsocialcliente() {
		return razonsocialcliente;
	}

	/**
	 * @param razonsocialcliente the razonsocialcliente to set
	 */
	public void setRazonsocialcliente(String razonsocialcliente) {
		this.razonsocialcliente = razonsocialcliente;
	}

	/**
	 * @return the cuenta_estatus
	 */
	public String getCuenta_estatus() {
		return cuenta_estatus;
	}

	/**
	 * @param cuenta_estatus the cuenta_estatus to set
	 */
	public void setCuenta_estatus(String cuenta_estatus) {
		this.cuenta_estatus = cuenta_estatus;
	}

	/**
	 * @return the longitud
	 */
	public String getLongitud() {
		return longitud;
	}

	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	/**
	 * @return the latitud
	 */
	public String getLatitud() {
		return latitud;
	}

	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	/**
	 * @return the descripciontiposolicitud
	 */
	public String getDescripciontiposolicitud() {
		return this.descripciontiposolicitud;
	
	}

	/**
	 * @param descripciontiposolicitud the descripciontiposolicitud to set
	 */
	public void setDescripciontiposolicitud(String descripciontiposolicitud) {
		this.descripciontiposolicitud=descripciontiposolicitud;
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
		this.idregistro =-1;
	    }
		
	}

}
