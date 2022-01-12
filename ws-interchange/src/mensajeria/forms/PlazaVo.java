/*
 * PlazaVo.java
 *
 * Created on 19 de septiembre de 2003, 03:47 PM
 */

package mensajeria.forms;

import java.io.Serializable;

/**
 *
 * @author  amorales
 */
public class PlazaVo implements Serializable {
    
    private String siglasPlaza;
    
    private String nombre;
    
    /** Creates a new instance of PlazaVo */
    public PlazaVo() {
    }
    
    /** Getter for property nombre.
     * @return Value of property nombre.
     */
    public java.lang.String getNombre() {
        return nombre;
    }
    
    /** Setter for property nombre.
     * @param nombre New value of property nombre.
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }
    
    /** Getter for property siglasPlaza.
     * @return Value of property siglasPlaza.
     */
    public java.lang.String getSiglasPlaza() {
        return siglasPlaza;
    }
    
    /** Setter for property siglasPlaza.
     * @param siglasPlaza New value of property siglasPlaza.
     */
    public void setSiglasPlaza(java.lang.String siglasPlaza) {
        this.siglasPlaza = siglasPlaza;
    }
    
}
