/*
 * TipoRegistroVo.java
 *
 * Created on 19 de septiembre de 2003, 03:37 PM
 */

package mensajeria.forms;

import java.io.Serializable;

/**
 *
 * @author  amorales
 */
public class TipoRegistroVo implements Serializable {
    
    private String idRegistro;
    
    private String descripcion;
    
    /** Creates a new instance of TipoRegistro */
    public TipoRegistroVo() {
    }
    /**
     *  Creates a new instance of TipoRegistro
     */
    public TipoRegistroVo(String registro, String descripcion) {
        this.idRegistro = registro;
        this.descripcion = descripcion;
    }
    
    /** Getter for property descripcion.
     * @return Value of property descripcion.
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /** Setter for property descripcion.
     * @param descripcion New value of property descripcion.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /** Getter for property idRegistro.
     * @return Value of property idRegistro.
     */
    public String getIdRegistro() {
        return idRegistro;
    }
    
    /** Setter for property idRegistro.
     * @param idRegistro New value of property idRegistro.
     */
    public void setIdRegistro(String idRegistro) {
        this.idRegistro = idRegistro;
    }
    
}
