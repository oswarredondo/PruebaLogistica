/*
 * CentroOperativoVo.java
 *
 * Created on 19 de septiembre de 2003, 03:46 PM
 */

package mensajeria.forms;

import java.io.Serializable;

/**
 *
 * @author  amorales
 */
public class CentroOperativoVo  implements Serializable {
    
    private String origenRegistro;
    
    private String descripcion;
    
    private String fechaAlta;
    
    /** Creates a new instance of CentroOperativoVo */
    public CentroOperativoVo() {
    }
    
    /** Getter for property descripcion.
     * @return Value of property descripcion.
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }
    
    /** Setter for property descripcion.
     * @param descripcion New value of property descripcion.
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }
    
    /** Getter for property fechaAlta.
     * @return Value of property fechaAlta.
     */
    public java.lang.String getFechaAlta() {
        return fechaAlta;
    }
    
    /** Setter for property fechaAlta.
     * @param fechaAlta New value of property fechaAlta.
     */
    public void setFechaAlta(java.lang.String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    
    /** Getter for property origenRegistro.
     * @return Value of property origenRegistro.
     */
    public java.lang.String getOrigenRegistro() {
        return origenRegistro;
    }
    
    /** Setter for property origenRegistro.
     * @param origenRegistro New value of property origenRegistro.
     */
    public void setOrigenRegistro(java.lang.String origenRegistro) {
        this.origenRegistro = origenRegistro;
    }
    
}
