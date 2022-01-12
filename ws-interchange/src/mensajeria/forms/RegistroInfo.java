/*
 *Contiene la información del registro que va ser creado, propiedades como, envio, fecha, CO,
 * centro de escane, etc.
 *
 * Created on 19 de septiembre de 2003, 03:37 PM
 */

package mensajeria.forms;

import java.io.Serializable;
import java.util.HashMap;

import com.debug.utils.DebugLog;


/**
 *
 * @author  amorales
 */
public class RegistroInfo implements Serializable {
    
    /** Bandera que indica si el registro es correcto en su estructura*/
    private boolean _isCorrecto=false;
    
    /** Error que determina por que es incorrecto el registro*/
    private String _error;
    
    /**Contiene el identificador del envio*/
    private String _idRegistro;
    
    /**Contiene la descripcion*/
    private String _descripcion;
    
    /**Contiene la estructura del registro*/
    private String _estructura;
    
    
    /**Contiene todos los aributos y su valor*/
    private HashMap _map_Atributos;
    
    /**Indica la plaza que esta enviando el registro*/
    private String _plaza;
    
    /**Indica el servidor del cual se esta invocando el servicio*/
    private String _servidor;
    
    /**Indica el identificador del propietario/numero cliente al que es asociada la información*/
    private String _idpropietario;
    
   /**Indica la cantidad de registros que se estan procesando*/
    private int cantidad=0;
    
    /**Indica el día de procesamiento*/
    private String  diaCarga;
    /**
     * Nombre de la tabla que se afecta
     */
    private String _tabla;
    
    /**Clase encargada de realizar la actuaizacion o proceso de inserción a la DB*/
    private String claseUpdateInsert;
    
    private int largo =0;
    
    /**
     * Manda un mensaje a la bitacora, como debug
     */
    private void debug(String mensaje){
        DebugLog.debug(this.getClass().getName(), mensaje) ;
    }//fin de debug
    
    /**
     *  Contiene los atributos para el mapeo entre el registro y la base de datos.<br>
     *  Teniendo la estructura debe existir una relacion entre cada uno de los campos que se tiene que
     * afectar por ejemplo:<br>
     *
     *  Registro: 1	Recepcion	1|NumGuia|Ruta|CveLog|Fecha|OriReg|Plaza<br>
     *  Registro Mapeo:  1|NumGuia,IdGuia|Ruta,Ruta|CveExc,CveLog|Fecha,FechaCreacion|COP,OriReg|SiglasPlaza,Plaza<br>
     *
     * Se indica el tipo de registro: 1<br>
     * Lo que indica que para el campo IdGuia se tiene el valor que este contenido en la variable de NumGuia y <br>
     * asi sucecivamente.<br>
     *
     * Por lo que la llave seria: Campo Registro, Campo Tabla a Afectar
     */
    private HashMap _map_CampoTablaRegistro = new HashMap();
    
    
    /**
     * Contiene los valores de los campos de la tabla que seran agregados a la base de datos, donde
     * la llave es el nombre del campo
     */
    private HashMap _map_CampoValorTabla = new HashMap();
    
    /** Creates a new instance of TipoRegistro */
    public RegistroInfo() {
    }
    
    /**
     * Creates a new instance of TipoRegistro
     * @param _idRegistro identificador del registro
     * @param _descripcion  descripcion del registro
     * @param _estructura estrucutra del registro
     */
    public RegistroInfo(String _estructura) {
    }//Fin de RegistroInfoVo
    
    /**
     * Agrega el campo de la estructura del registro, en caso de ya existir lo sobre escribe
     * @param campo instancia de CampoInfo que contiene la información del campo
     */
    public void addCampo(CampoInfo campo){
        _map_CampoValorTabla.put(campo.get_idCampo(), campo);
    }//fin de addCampo

    /**
     * Vacia los datos de campos y registros para que sean tomados nuevamente 
     * de la base de datos
     * @param campo nombre del campo que se esta buscando
     * @return una instancia de CampoInfo, en caso de no estar definido el campo regresa null
     */
    public void clearRegCampos(){
    	_map_CampoValorTabla.clear();
    }
    
    /**
     * Obtiene la información de un campo o null en caso de que no exista
     * @param campo nombre del campo que se esta buscando
     * @return una instancia de CampoInfo, en caso de no estar definido el campo regresa null
     */
    private CampoInfo getCampoInfo(String campo){
        try{
            if (_map_CampoValorTabla.containsKey(campo)){
                return (CampoInfo)_map_CampoValorTabla.get(campo);
            }else{
                return null;
            }
        }catch(Exception e ){
            return null;
        }
    }//fin de getCampoInfo
    
    /**
     * Procesa un registro de informacion
     * @param registro una cadena que contiene la informacion del registro a procesar
     */
    public void checkRegistro(String registro){
        
        this._isCorrecto=false;
        //Verifica si el registro es nulo
        if (registro==null){
            this._error ="Registro de informacion no puede ser vacio";
            return;
        }
        
        //debug("Este es el registro:"+registro);
        
        //Arreglo que contiene todos los campos del registro
        String[] campos_registroinfo = registro.split("\\|",-1);
        String[] campos_estructura_registro = this._estructura.split("\\|",-1);
        int cantidad_campos_esperados = getCantidadCamposRegistro();
        
        debug("this._estructura:"+this._estructura);
        debug("campos_estructura_registro.length:"+campos_estructura_registro.length);
        debug("campos_registroinfo.length:"+campos_registroinfo.length);
        debug("cantidad_campos_esperados:"+cantidad_campos_esperados);
        
        if (campos_registroinfo.length!= cantidad_campos_esperados){
            this._error ="Longitud de campos incorrecto obligatorios " + getCantidadCamposRegistro() + " y tiene " + campos_registroinfo.length ;
            return;
        }
        
        //Verifica si los campos del registro son correctos
        CampoInfo campo;
        String valor;
        for (int i=1;i<campos_estructura_registro.length;i++){
            //Obtiene nombre del campo y el valor enviado para validar
            //si es correcto, de acuerdo a la posición del arreglo
            campo = getCampoInfo(campos_estructura_registro[i]);
            if (campo==null){
                this._error ="Campo en la estructura no existe:" +campos_estructura_registro[i] ;
                debug("Error :"+this._error); 
                return;
            }
            
            //Verifica si el valor no es null ni vacio
            valor  = campos_registroinfo[i];
            debug("Campo:"+campo.get_idCampo() +" Valor campo:"+ valor);
            if (!campo.isCorrecto(valor)){
                this._error = campo.get_mensaje_error() + " " +campo.get_validacion() ;
                debug("Error campo:"+this._error); 
                return;
            }
            
            
        }//fin del for
        
        //Si el registro llega a este punto es correcta la validacion
        this._isCorrecto=true;
        //debug("Termine de verificar el regidstro");
        return;
    }//fin de checkRegistro
    
    
    /**
     * Getter for property _estructura.
     * @return Value of property _estructura.
     */
    public java.lang.String get_estructura() {
        return _estructura;
    }
    
    /**
     * Setter for property _estructura.
     * @param _estructura New value of property _estructura.
     */
    public void set_estructura(java.lang.String _estructura) {
        this._estructura = _estructura;
    }
    
    /**
     * Setter for property _estructura.
     * @param _estructura New value of property _estructura.
     */
    public int getCantidadCamposRegistro() {
        if (this._estructura==null) return 0;
        String[] campos = this._estructura.split("\\|",-1);
        
        return campos.length;
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
     * Getter for property _idRegistro.
     * @return Value of property _idRegistro.
     */
    public java.lang.String get_idRegistro() {
        return _idRegistro;
    }
    
    /**
     * Setter for property _idRegistro.
     * @param _idRegistro New value of property _idRegistro.
     */
    public void set_idRegistro(java.lang.String _idRegistro) {
        this._idRegistro = _idRegistro;
    }
    
    /**
     * Getter for property _map_Atributos.
     * @return Value of property _map_Atributos.
     */
    public java.util.HashMap get_map_Atributos() {
        return _map_Atributos;
    }
    
    /**
     * Setter for property _map_Atributos.
     * @param _map_Atributos New value of property _map_Atributos.
     */
    public void set_map_Atributos(java.util.HashMap _map_Atributos) {
        this._map_Atributos = _map_Atributos;
    }
    
    /**
     * Getter for property _tabla.
     * @return Value of property _tabla.
     */
    public java.lang.String get_tabla() {
        return _tabla;
    }
    
    /**
     * Setter for property _tabla.
     * @param _tabla New value of property _tabla.
     */
    public void set_tabla(java.lang.String _tabla) {
        this._tabla = _tabla;
    }
    
    /**
     * Getter for property _isCorrecto.
     * @return Value of property _isCorrecto.
     */
    public boolean is_isCorrecto() {
        return _isCorrecto;
    }
    
    /**
     * Setter for property _isCorrecto.
     * @param _isCorrecto New value of property _isCorrecto.
     */
    public void set_isCorrecto(boolean _isCorrecto) {
        this._isCorrecto = _isCorrecto;
    }
    
    /**
     * Getter for property _error.
     * @return Value of property _error.
     */
    public java.lang.String get_error() {
        return _error;
    }
    
    /**
     * Setter for property _error.
     * @param _error New value of property _error.
     */
    public void set_error(java.lang.String _error) {
        this._error = _error;
    }
    
    
    /**
     * Getter for property claseUpdateInsert.
     * @return Value of property claseUpdateInsert.
     */
    public java.lang.String getClaseUpdateInsert() {
        return claseUpdateInsert;
    }
    
    /**
     * Setter for property claseUpdateInsert.
     * @param claseUpdateInsert New value of property claseUpdateInsert.
     */
    public void setClaseUpdateInsert(java.lang.String claseUpdateInsert) {
    	if (claseUpdateInsert!=null){
    		this.claseUpdateInsert = claseUpdateInsert.trim();
    	}else{
    		this.claseUpdateInsert =claseUpdateInsert;
    	}
        
    }

	public String get_plaza() {
		return _plaza;
	}

	public void set_plaza(String _plaza) {
		this._plaza = _plaza;
	}

	public String get_servidor() {
		return _servidor;
	}

	public void set_servidor(String _servidor) {
		this._servidor = _servidor;
	}

	public String get_idpropietario() {
		return _idpropietario;
	}

	public void set_idpropietario(String _idpropietario) {
		this._idpropietario = _idpropietario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDiaCarga() {
		return diaCarga;
	}

	public void setDiaCarga(String diaCarga) {
		this.diaCarga = diaCarga;
	}

	/**
	 * @return the largo
	 */
	public int getLargo() {
	    return largo;
	}

	/**
	 * @param largo the largo to set
	 */
	public void setLargo(int largo) {
	    this.largo = largo;
	}
    
    //fin de checkCampo
}//Fin de RegistroInfoVo
