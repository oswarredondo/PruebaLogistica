/*
 * Movimiento.java
 *
 * Created on 3 de septiembre de 2003, 12:13
 */

package com.servicio.dtos;

/**
 * Contiene los datos para los tipos de movimientos que ha tenmido un envio.
 * Ademas esta clase es utilizada cuando se realiza la administracion del catalogo
 * de tipos de servicio tomando solamente los datos de tiRegistro y tiDescripcion 
 *
 * @author  AMR, Adrian Morales Ruaro
 */
public class Movimiento implements java.io.Serializable {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    /**
     * Contiene el identificador del tipo de registro generado
     */
    private String tipoRegistro;
    /**
     * Contiene la descripcion del tipo de registro generado
     */
    private String tiDescripcion;
    
    /**
     * Contiene la clave logistica 
     */
    private String claveLogistica;
    
    /**
     * Contiene la clave logistica 
     */
    private String descripcionclave;
    
    /**
     * Contiene las siglas de la plza
     */
    private String siglasPlaza;
    /**
     * Contiene las siglas de la plaza que genera la info.
     */
    private String origenRegistro;
    
    /**
     * Contiene el idnetifiador de la ruta
     */
    private String ruta;
    /**
     * Contiene la fecha en que se genero la informacion
     */
    private String fecha;
    /**
     * Contiene la guia a la que pertenece el movimiento
     */
    private String guia;
    private String idsolicitud;
    private String empleado;
    private String quienrechaza;
    private String motivo;
    
    private String idCasamiento;
    
    private String idCarrier;
    
    
    /** Creates a new instance of Movimiento */
    public Movimiento() {
    }
    
    /**
     * Constructor con parametros.
     * Incializa todos los valores.
     *
     * @param tipo contiene el tipo de movimiento
     * @param clave contiene la clave logistica
     * @param siglas contiene las siglas de la plaza
     * @param origen contienen las siglas de plaza que genera la info.
     * @param ruta contiene la ruta que genra la informacion
     * @param fecha contiene la fecha en que se genero la info.
     */
    public Movimiento(String tipo, String clave, String siglas,
    String origen, String ruta, String fecha) {
        
        setClaveLogistica(clave);
        setFecha(fecha);
        setOrigenRegistro(origen);
        setRuta(ruta);
        setSiglasPlaza(siglas);
        setTipoRegistro(tipo);
        
    }//fin del constructor Movimiento con parametros
    
    /** Getter for property claveLogistica.
     * @return Value of property claveLogistica.
     *
     */
    public java.lang.String getClaveLogistica() {
        return claveLogistica;
    }
    
    /** Setter for property claveLogistica.
     * @param claveLogistica New value of property claveLogistica.
     *
     */
    public void setClaveLogistica(java.lang.String claveLogistica) {
        this.claveLogistica = claveLogistica;
    }
    
    /** Getter for property fecha.
     * @return Value of property fecha.
     *
     */
    public java.lang.String getFecha() {
        return fecha;
    }
    
    /** Setter for property fecha.
     * @param fecha New value of property fecha.
     *
     */
    public void setFecha(java.lang.String fecha) {
        this.fecha = fecha;
    }
    
    /** Getter for property origenRegistro.
     * @return Value of property origenRegistro.
     *
     */
    public java.lang.String getOrigenRegistro() {
        return origenRegistro;
    }
    
    /** Setter for property origenRegistro.
     * @param origenRegistro New value of property origenRegistro.
     *
     */
    public void setOrigenRegistro(java.lang.String origenRegistro) {
        this.origenRegistro = origenRegistro;
    }
    
    /** Getter for property ruta.
     * @return Value of property ruta.
     *
     */
    public java.lang.String getRuta() {
        return ruta;
    }
    
    /** Setter for property ruta.
     * @param ruta New value of property ruta.
     *
     */
    public void setRuta(java.lang.String ruta) {
        this.ruta = ruta;
    }
    
    /** Getter for property siglasPlaza.
     * @return Value of property siglasPlaza.
     *
     */
    public java.lang.String getSiglasPlaza() {
        return siglasPlaza;
    }
    
    /** Setter for property siglasPlaza.
     * @param siglasPlaza New value of property siglasPlaza.
     *
     */
    public void setSiglasPlaza(java.lang.String siglasPlaza) {
        this.siglasPlaza = siglasPlaza;
    }
    
    /** Getter for property tipoRegistro.
     * @return Value of property tipoRegistro.
     *
     */
    public java.lang.String getTipoRegistro() {
        return tipoRegistro;
    }
    
    /** Setter for property tipoRegistro.
     * @param tipoRegistro New value of property tipoRegistro.
     *
     */
    public void setTipoRegistro(java.lang.String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }
    
    /** Getter for property guia.
     * @return Value of property guia.
     *
     */
    public java.lang.String getGuia() {
        return guia;
    }
    
    /** Setter for property guia.
     * @param guia New value of property guia.
     *
     */
    public void setGuia(java.lang.String guia) {
        this.guia = guia;
    }
    
    /** Getter for property tiDescripcion.
     * @return Value of property tiDescripcion.
     *
     */
    public java.lang.String getTiDescripcion() {
        return tiDescripcion;
    }
    
    /** Setter for property tiDescripcion.
     * @param tiDescripcion New value of property tiDescripcion.
     *
     */
    public void setTiDescripcion(java.lang.String tiDescripcion) {
        this.tiDescripcion = tiDescripcion;
    }

	/**
	 * @return the idsolicitud
	 */
	public String getIdsolicitud() {
		return idsolicitud;
	}

	/**
	 * @param idsolicitud the idsolicitud to set
	 */
	public void setIdsolicitud(String idsolicitud) {
		this.idsolicitud = idsolicitud;
	}

	/**
	 * @return the empleado
	 */
	public String getEmpleado() {
		return empleado;
	}

	/**
	 * @param empleado the empleado to set
	 */
	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}

	/**
	 * @return the quienrechaza
	 */
	public String getQuienrechaza() {
		return quienrechaza;
	}

	/**
	 * @param quienrechaza the quienrechaza to set
	 */
	public void setQuienrechaza(String quienrechaza) {
		this.quienrechaza = quienrechaza;
	}

	/**
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}

	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	/**
	 * @return the descripcionclave
	 */
	public String getDescripcionclave() {
		return descripcionclave;
	}

	/**
	 * @param descripcionclave the descripcionclave to set
	 */
	public void setDescripcionclave(String descripcionclave) {
		this.descripcionclave = descripcionclave;
	}

	/**
	 * @return the idCasamiento
	 */
	public String getIdCasamiento() {
		return idCasamiento;
	}

	/**
	 * @param idCasamiento the idCasamiento to set
	 */
	public void setIdCasamiento(String idCasamiento) {
		this.idCasamiento = idCasamiento;
	}

	public String getIdCarrier() {
		return idCarrier;
	}

	public void setIdCarrier(String idCarrier) {
		this.idCarrier = idCarrier;
	}
    
//fin del contructor con parametros
    
}
