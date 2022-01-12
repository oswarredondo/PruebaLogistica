/**
 * 
 */
package com.servicio.consulta.dtos;

import java.io.Serializable;

import com.innovargia.salesmanager.dtos.RemDes;
import com.servicio.dtos.DocumentoConsultaDTO;

/**
 * @author aruaro
 * 
 */
public class ConsultaGridExtJS implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String isexistenota = null;
    private String comentario;
    private String estatus;
    private String referencia;
    private String idDocumento;
    
    private String idDocumentoMadre;

	private String guiainternacional;
    private String idGuiaCasamiento;
    private String idGuiaDevolucion;
    private String es_nacional;

    private int numPiezas = 0;
    private float valorDeclarado;
    private float pesoBruto;
    private String contenidoDeclarado;
    private String observaciones;
    private String numCliente;
    private String quienRecibe;
    private String fechaConfirmacion;
    private String fechaCreacion,descripcio_servicio,fecharecoleccion;
    
    private String idguiamadremultiple;

    private String latitud;
    private String longitud;
    
    private String descripcionError;
    
    private String login;
    
    private String razonsocial;

	// Remitente
    public DireccionConsultaEtiquetasExtJS remitente = new DireccionConsultaEtiquetasExtJS();
    // Datos del Destino
    public DireccionConsultaEtiquetasExtJS destinatario = new DireccionConsultaEtiquetasExtJS();

    /**
     * 
     */
    public ConsultaGridExtJS() {
	// TODO Auto-generated constructor stub
    }

    public ConsultaGridExtJS(DocumentoConsultaDTO documento, RemDes remitente,
	    RemDes destinatario) {

	setRemitente(remitente);
	setDestinatario(destinatario);

	this.isexistenota = documento.getIsexistenota();
	this.comentario = documento.getComentario();
	this.estatus = documento.getEstatus();
	this.referencia = documento.getReferencia();
	this.idDocumento = documento.getIdDocumento();
	
	this.idDocumentoMadre= documento.getIdDocumentoMadre();
	
	this.guiainternacional = documento.getGuiainternacional();
	this.idGuiaCasamiento = documento.getIdGuiaCasamiento();
	this.idGuiaDevolucion = documento.getIdGuiaDevolucion();

	this.numPiezas = documento.getNumPiezas();
	this.valorDeclarado = documento.getValorDeclarado();
	this.pesoBruto = documento.getPesoBruto();
	this.contenidoDeclarado = documento.getContenidoDeclarado();
	this.observaciones = documento.getObservaciones();
	this.numCliente = documento.getNumCliente();
	this.quienRecibe = documento.getQuienRecibe();
	this.fechaConfirmacion = documento.getFechaConfirmacion();
	this.es_nacional = documento.getEs_nacional();
	this.fechaCreacion = documento.getFechaCreacion();
	this.fecharecoleccion = documento.getFecharecoleccion();
	this.descripcio_servicio =  documento.getDescripcio_servicio();
	
	this.latitud = documento.getLatitud();
	this.longitud = documento.getLongitud();
	this.idguiamadremultiple = documento.getIdguiamadremultiple();
	this.descripcionError = documento.getDescripcionError();
	this.login = documento.getLogin();
	this.razonsocial = documento.getRazonsocial();
	
    }
    
    public String getIdDocumentoMadre() {
		return idDocumentoMadre;
	}

	public void setIdDocumentoMadre(String idDocumentoMadre) {
		this.idDocumentoMadre = idDocumentoMadre;
	}

    /**
     * @return the isexistenota
     */
    public String getIsexistenota() {
	return isexistenota;
    }

    /**
     * @param isexistenota
     *            the isexistenota to set
     */
    public void setIsexistenota(String isexistenota) {
	this.isexistenota = isexistenota;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
	return comentario;
    }

    /**
     * @param comentario
     *            the comentario to set
     */
    public void setComentario(String comentario) {
	this.comentario = comentario;
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
     * @return the referencia
     */
    public String getReferencia() {
	return referencia;
    }

    /**
     * @param referencia
     *            the referencia to set
     */
    public void setReferencia(String referencia) {
	this.referencia = referencia;
    }

    /**
     * @return the idDocumento
     */
    public String getIdDocumento() {
	return idDocumento;
    }

    /**
     * @param idDocumento
     *            the idDocumento to set
     */
    public void setIdDocumento(String idDocumento) {
	this.idDocumento = idDocumento;
    }

    /**
     * @return the guiainternacional
     */
    public String getGuiainternacional() {
	return guiainternacional;
    }

    /**
     * @param guiainternacional
     *            the guiainternacional to set
     */
    public void setGuiainternacional(String guiainternacional) {
	this.guiainternacional = guiainternacional;
    }

    /**
     * @return the idGuiaCasamiento
     */
    public String getIdGuiaCasamiento() {
	return idGuiaCasamiento;
    }

    /**
     * @param idGuiaCasamiento
     *            the idGuiaCasamiento to set
     */
    public void setIdGuiaCasamiento(String idGuiaCasamiento) {
	this.idGuiaCasamiento = idGuiaCasamiento;
    }

    /**
     * @return the idGuiaDevolucion
     */
    public String getIdGuiaDevolucion() {
	return idGuiaDevolucion;
    }

    /**
     * @param idGuiaDevolucion
     *            the idGuiaDevolucion to set
     */
    public void setIdGuiaDevolucion(String idGuiaDevolucion) {
	this.idGuiaDevolucion = idGuiaDevolucion;
    }

    /**
     * @return the numPiezas
     */
    public int getNumPiezas() {
	return numPiezas;
    }

    /**
     * @param numPiezas
     *            the numPiezas to set
     */
    public void setNumPiezas(int numPiezas) {
	this.numPiezas = numPiezas;
    }

    /**
     * @return the valorDeclarado
     */
    public float getValorDeclarado() {
	return valorDeclarado;
    }

    /**
     * @param valorDeclarado
     *            the valorDeclarado to set
     */
    public void setValorDeclarado(float valorDeclarado) {
	this.valorDeclarado = valorDeclarado;
    }

    /**
     * @return the pesoBruto
     */
    public float getPesoBruto() {
	return pesoBruto;
    }

    /**
     * @param pesoBruto
     *            the pesoBruto to set
     */
    public void setPesoBruto(float pesoBruto) {
	this.pesoBruto = pesoBruto;
    }

    /**
     * @return the contenidoDeclarado
     */
    public String getContenidoDeclarado() {
	return contenidoDeclarado;
    }

    /**
     * @param contenidoDeclarado
     *            the contenidoDeclarado to set
     */
    public void setContenidoDeclarado(String contenidoDeclarado) {
	this.contenidoDeclarado = contenidoDeclarado;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
	return observaciones;
    }

    /**
     * @param observaciones
     *            the observaciones to set
     */
    public void setObservaciones(String observaciones) {
	this.observaciones = observaciones;
    }

    /**
     * @return the numCliente
     */
    public String getNumCliente() {
	return numCliente;
    }

    /**
     * @param numCliente
     *            the numCliente to set
     */
    public void setNumCliente(String numCliente) {
	this.numCliente = numCliente;
    }

    /**
     * @return the quienRecibe
     */
    public String getQuienRecibe() {
	return quienRecibe;
    }

    /**
     * @param quienRecibe
     *            the quienRecibe to set
     */
    public void setQuienRecibe(String quienRecibe) {
	this.quienRecibe = quienRecibe;
    }

    /**
     * @return the fechaConfirmacion
     */
    public String getFechaConfirmacion() {
	return fechaConfirmacion;
    }

    /**
     * @param fechaConfirmacion
     *            the fechaConfirmacion to set
     */
    public void setFechaConfirmacion(String fechaConfirmacion) {
	this.fechaConfirmacion = fechaConfirmacion;
    }

    /**
     * @return the remitente
     */
    public DireccionConsultaEtiquetasExtJS getRemitente() {
	return remitente;
    }

    /**
     * @param remitente
     *            the remitente to set
     */
    public void setRemitente(DireccionConsultaEtiquetasExtJS remitente) {
	this.remitente = remitente;
    }

    /**
     * @return the destinatario
     */
    public DireccionConsultaEtiquetasExtJS getDestinatario() {
	return destinatario;
    }

    /**
     * @param destinatario
     *            the destinatario to set
     */
    public void setDestinatario(DireccionConsultaEtiquetasExtJS destinatario) {
	this.destinatario = destinatario;
    }

    public void setRemitente(RemDes remitente) {
	this.remitente.setRazonSocial(remitente.getRazonSocial() == null ? ""
		: remitente.getRazonSocial());
	this.remitente.setAtencion(remitente.getAtencion() == null ? ""
		: remitente.getAtencion());
	this.remitente.setDireccion(remitente.getCalle() == null ? ""
		: remitente.getCalle());
	this.remitente.setCalle(remitente.getDireccion() == null ? ""
		: remitente.getDireccion());
	this.remitente.setColonia(remitente.getColonia() == null ? ""
		: remitente.getColonia());
	this.remitente.setCiudad(remitente.getCiudad() == null ? "" : remitente
		.getCiudad());
	this.remitente
		.setCp(remitente.getCp() == null ? "" : remitente.getCp());
	this.remitente.setTelefono(remitente.getTelefono() == null ? ""
		: remitente.getTelefono());

    }

    public void setDestinatario(RemDes destinatario) {

	this.destinatario
		.setRazonSocial(destinatario.getRazonSocial() == null ? ""
			: destinatario.getRazonSocial());
	this.destinatario.setAtencion(destinatario.getAtencion() == null ? ""
		: destinatario.getAtencion());
	this.destinatario.setDireccion(destinatario.getCalle() == null ? ""
		: destinatario.getCalle());
	this.destinatario.setCalle(destinatario.getDireccion() == null ? ""
		: destinatario.getDireccion());
	this.destinatario.setColonia(destinatario.getColonia() == null ? ""
		: destinatario.getColonia());
	this.destinatario.setCiudad(destinatario.getCiudad() == null ? ""
		: destinatario.getCiudad());
	this.destinatario.setCp(destinatario.getCp() == null ? ""
		: destinatario.getCp());
	this.destinatario.setTelefono(destinatario.getTelefono() == null ? ""
		: destinatario.getTelefono());

    }

    /**
     * @return the es_nacional
     */
    public String getEs_nacional() {
	return es_nacional;
    }

    /**
     * @param es_nacional
     *            the es_nacional to set
     */
    public void setEs_nacional(String es_nacional) {
	this.es_nacional = es_nacional;
    }

    /**
     * @return the fechaCreacion
     */
    public String getFechaCreacion() {
	return fechaCreacion;
    }

    /**
     * @param fechaCreacion
     *            the fechaCreacion to set
     */
    public void setFechaCreacion(String fechaCreacion) {
	this.fechaCreacion = fechaCreacion;
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
     * @return the idguiamadremultiple
     */
    public String getIdguiamadremultiple() {
        return idguiamadremultiple;
    }

    /**
     * @param idguiamadremultiple the idguiamadremultiple to set
     */
    public void setIdguiamadremultiple(String idguiamadremultiple) {
        this.idguiamadremultiple = idguiamadremultiple;
    }

	/**
	 * @return the descripcio_servicio
	 */
	public String getDescripcio_servicio() {
		return descripcio_servicio;
	}

	/**
	 * @param descripcio_servicio the descripcio_servicio to set
	 */
	public void setDescripcio_servicio(String descripcio_servicio) {
		this.descripcio_servicio = descripcio_servicio;
	}

	/**
	 * @return the fecharecoleccion
	 */
	public String getFecharecoleccion() {
		return fecharecoleccion;
	}

	/**
	 * @param fecharecoleccion the fecharecoleccion to set
	 */
	public void setFecharecoleccion(String fecharecoleccion) {
		this.fecharecoleccion = fecharecoleccion;
	}
	
    public String getDescripcionError() {
		return descripcionError;
	}

	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}
}
