/*
 * ServicioVo.java
 *
 * Created on 19 de septiembre de 2003, 03:45 PM
 */

package mensajeria.forms;

import java.io.Serializable;

/**
 *
 * @author  amorales
 */
public class ServicioVo implements Serializable  {
    
    private String numero;
    
    private String nombre;
    
    private String fechaAlta;
    
    private String fechaObsolesencia;
    
    private String folio;
    
    /** Creates a new instance of ServicioVo */
    public ServicioVo() {
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
    
    /** Getter for property fechaObsolesencia.
     * @return Value of property fechaObsolesencia.
     */
    public java.lang.String getFechaObsole() {
        return fechaObsolesencia;
    }
    
    /** Setter for property fechaObsolesencia.
     * @param fechaObsolesencia New value of property fechaObsolesencia.
     */
    public void setFechaObsole(java.lang.String fechaObsolesencia) {
        this.fechaObsolesencia = fechaObsolesencia;
    }
    
    /** Getter for property folio.
     * @return Value of property folio.
     */
    public String getFolio() {
        return folio;
    }
    
    /** Setter for property folio.
     * @param folio New value of property folio.
     */
    public void setFolio(String folio) {
        this.folio = folio;
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
    
    /** Getter for property numero.
     * @return Value of property numero.
     */
    public java.lang.String getNumero() {
        return numero;
    }
    
    /** Setter for property numero.
     * @param numero New value of property numero.
     */
    public void setNumero(java.lang.String numero) {
        this.numero = numero;
    }
    
}
