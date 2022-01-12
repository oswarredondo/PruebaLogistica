/* $Id:  $
 *
 * Nombre del Proyecto:  Administracion
 * Nombre del Programa:  GeneralForm.java
 * Responsable:  Adrián Morales Ruaro
 * Descripcion:   contiene datos generales para la administracion, como servicios, tipos registros,
 * centros operativos, etc
 *
 * $Log: $
 */

package mensajeria.forms;  

import javax.servlet.http.HttpServletRequest;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author  amorales
 */
public class GeneralForm    implements Serializable  {
    
    private String idRegistro;
    
    private String descripcion;
    
    private String fechaAlta;
    
    private String fechaBaja;
    
    private String pesoBase;
    private String tipocobro;
    private String generaretorno;
    
    private ArrayList lista = new ArrayList();
    
    /** Creates a new instance of CentroOperativoVo */
    public GeneralForm() {
    }
    
    /** Inicializa los datos del identificador y descripcion*/
    public GeneralForm(String idRegistro,String descripcion) {
        setIdRegistro(idRegistro);
        setDescripcion(descripcion);
    }
    
    
    /**
     * Getter for property idRegistro.
     * @return Value of property idRegistro.
     */
    public java.lang.String getIdRegistro() {
        return idRegistro;
    }
    
    /**
     * Setter for property idRegistro.
     * @param idRegistro New value of property idRegistro.
     */
    public void setIdRegistro(java.lang.String idRegistro) {
        this.idRegistro = idRegistro;
    }
    
    /**
     * Getter for property descripcion.
     * @return Value of property descripcion.
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Setter for property descripcion.
     * @param descripcion New value of property descripcion.
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Getter for property fechaAlta.
     * @return Value of property fechaAlta.
     */
    public java.lang.String getFechaAlta() {
        return fechaAlta;
    }
    
    /**
     * Setter for property fechaAlta.
     * @param fechaAlta New value of property fechaAlta.
     */
    public void setFechaAlta(java.lang.String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    /**
     * Getter for property fechaBaja.
     * @return Value of property fechaBaja.
     */
    public java.lang.String getFechaBaja() {
        return fechaBaja;
    }
    
    /**
     * Setter for property fechaBaja.
     * @param fechaBaja New value of property fechaBaja.
     */
    public void setFechaBaja(java.lang.String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    
    /**
     * Getter for property pesoBase.
     * @return Value of property pesoBase.
     */
    public java.lang.String getPesoBase() {
        return pesoBase;
    }
    
    /**
     * Setter for property pesoBase.
     * @param pesoBase New value of property pesoBase.
     */
    public void setPesoBase(java.lang.String pesoBase) {
        this.pesoBase = pesoBase;
    }
    
    /**
     * Getter for property lista.
     * @return Value of property lista.
     */
    public java.util.ArrayList getLista() {
        return lista;
    }
    
    /**
     * Setter for property lista.
     * @param lista New value of property lista.
     */
    public void setLista(java.util.ArrayList lista) {
        this.lista = lista;
    }

	/**
	 * @return the tipocobro
	 */
	public String getTipocobro() {
		return tipocobro;
	}

	/**
	 * @param tipocobro the tipocobro to set
	 */
	public void setTipocobro(String tipocobro) {
		this.tipocobro = tipocobro;
	}

	/**
	 * @return the generaretorno
	 */
	public String getGeneraretorno() {
		return generaretorno;
	}

	/**
	 * @param generaretorno the generaretorno to set
	 */
	public void setGeneraretorno(String generaretorno) {
		this.generaretorno = generaretorno;
	}
    
    //fin de reset
    
    
}
