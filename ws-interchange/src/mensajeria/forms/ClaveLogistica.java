/*
 * ClaveLogistica.java
 *
 * Created on 19 de septiembre de 2003, 03:48 PM
 */

package mensajeria.forms;

import java.io.Serializable;

/**
 *
 * @author  amorales
 */
public class ClaveLogistica implements Serializable {
    
    private String Clave;
    
    private String descripcion;
    
    private String permiso;
    
    /** Creates a new instance of ClaveLogistica */
    public ClaveLogistica() {
    }
    
    /** Getter for property Clave.
     * @return Value of property Clave.
     */
    public java.lang.String getClave() {
        return Clave;
    }
    
    /** Setter for property Clave.
     * @param Clave New value of property Clave.
     */
    public void setClave(java.lang.String Clave) {
        this.Clave = Clave;
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
    
    /** Getter for property permiso.
     * @return Value of property permiso.
     */
    public java.lang.String getPermiso() {
        return permiso;
    }
    
    /** Setter for property permiso.
     * @param permiso New value of property permiso.
     */
    public void setPermiso(java.lang.String permiso) {
        this.permiso = permiso;
    }
    
}
