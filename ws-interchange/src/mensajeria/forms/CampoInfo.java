/*
 *Contiene la información del registro que va ser creado, propiedades como, envio, fecha, CO,
 * centro de escane, etc.
 *
 * Created on 19 de septiembre de 2003, 03:37 PM
 */

package mensajeria.forms;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;


import com.debug.utils.DebugLog;

/**
 *
 * @author  amorales
 */
public class CampoInfo implements Serializable  {
    
    /**Contiene el identificador del envio*/
    private String _idCampo;
    
    /**Contiene la descripcion*/
    private String _descripcion;
    
    /**Contiene la estructura del registro*/
    private String _validacion;
    
    /**Contiene la estructura del registro*/
    private String _mensaje_error;
    /**
     * Manda un mensaje a la bitacora, como debug
     */
    private void debug(String mensaje){
        DebugLog.debug(this.getClass(), mensaje);
    }//fin de debug
    
    /**
     * Verifica si el valor del campo es correcto y machea con el patron
     * indicado por el usuario
     *
     *
     * @return true si todo es correcto , false en caso contrario
     * @param valor valor del campo a checar
     */
    public boolean isCorrecto(String valor){
        
        debug("Este es el campo:"+this._idCampo);
        debug("Valor:"+valor); 
        debug("Validacion:"+_validacion);
        
        //Verifica que el valor, patron  y campo no sean nulos
        if (valor==null){
            return false;
        }
        
        //verifica si el valor machea con el patron configurado por el usuario
        debug("Es Correcto validacion:"+valor.matches(_validacion)); 
        if (!valor.matches(_validacion)){
            return false;
        }
        //Si se llega a es te pundo quiere decir que el valor del campo es
        //correcto
        return true;
        
    }//fin de isCorrecto
    
    
    /**
     * Getter for property _idCampo.
     * @return Value of property _idCampo.
     */
    public java.lang.String get_idCampo() {
        return _idCampo;
    }
    
    /**
     * Setter for property _idCampo.
     * @param _idCampo New value of property _idCampo.
     */
    public void set_idCampo(java.lang.String _idCampo) {
        this._idCampo = _idCampo;
    }
    
    /**
     * Getter for property _descripcion.
     * @return Value of property _descripcion.
     */
    public java.lang.String get_descripcion() {
        return _descripcion;
    }
    
    /**
     * Setter for property _descripcion.
     * @param _descripcion New value of property _descripcion.
     */
    public void set_descripcion(java.lang.String _descripcion) {
        this._descripcion = _descripcion;
    }
    
    /**
     * Getter for property _validacion.
     * @return Value of property _validacion.
     */
    public java.lang.String get_validacion() {
        return _validacion;
    }
    
    /**
     * Setter for property _validacion.
     * @param _validacion New value of property _validacion.
     */
    public void set_validacion(java.lang.String _validacion) {
        this._validacion = _validacion;
    }
    
    /**
     * Getter for property _mensaje_erro.
     * @return Value of property _mensaje_erro.
     */
    public java.lang.String get_mensaje_error() {
        return _mensaje_error;
    }
    
    /**
     * Setter for property _mensaje_erro.
     * @param _mensaje_erro New value of property _mensaje_erro.
     */
    public void set_mensaje_error(java.lang.String _mensaje_erro) {
        this._mensaje_error = _mensaje_erro;
    }
    
}//Fin de RegistroInfoVo
