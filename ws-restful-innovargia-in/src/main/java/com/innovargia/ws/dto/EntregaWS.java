/* $Id:  $
 *
 * Nombre del Proyecto:  Captura de Confirmaciones
 * Nombre del Programa: EntregaForm.java
 * Responsable: Adri�n Morales Ruaro
 * Descripcion:  controla los datos de la forma de confirmaciones
 *
 * $Log: $
 */
package com.innovargia.ws.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Contiene las propiedades de la forma de entregas
 * @author amorales
 * @version
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntregaWS   implements Serializable   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombreObjeto="EntregaForm";
	   /**NUmero de empleado**/
    public String numEmpleado;
    /**NUmero de empleado**/
    public String idFirma;
    

	/***/
    private boolean isRegistro = false;
    
    /**Indica que se incluye  solo la cabecera de la guia  en la forma de captura*/
    public static int CABECERA_GUIA = 0;
    /**Indica que se incluye  solo la cabecera de enlace  en la forma de captura*/
    public static int CABECERA_GUIA_ENLACE = 1;
    /**Indica que se incluyen ambas cabeceras GUIA y GUIA ENLACE en la forma de captura  */
    public static int CABECERA_AMBAS = 2;
    /**Lista que contiene la lista de confirmaciones a capturar*/
    ArrayList lista = new ArrayList();
    /**Contiene las siglas de la plaza donde se origina la informacion*/
    private String  siglasPlaza;
    /**Siglas de la plaza origen del envio*/ 
    private String  origen;
    /**Indnca el nombre de la persona que recibe*/
    private String quienRecibe;
    /**Indica la fecha de salida a ruta */
    private String fecha;
     
    /**Fecha final de consulta*/
    private String fechafin;
    
    /**Indica la hora en que se recibio el envio*/
    private int hora;
    /**Indica el identificador del envio entregado*/
    private String idGuia;
    /**Guia de enlace de una mensajeria externa*/
    private String idGuiaEnlace;
    /**Indica los minutos en la hora*/
    private  int minutos;
    /**Contiene el identificador de la ruta*/
    private String idRuta;
    /**Contiene de la fecha de las confirmaciones a buscar*/
    private String fechaConfirmaciones;
    /**Destino de  los envios*/
    private String destino;
    /**Centro operativo de captura*/
    private String cencap;
    /**usuario*/
    private String usuario;
    /**Accion que se esta realizando*/
    private String accion;
    
    
    private String latitud;
    private String longitud;
    
    
    /**La cabecera por omision es la de la guia*/
    private int cabecera_incluye;
    
    /**Contador de registros*/
    private int contador_registros=0;
    /** bandera para verificar cuando se deben cargar los datos a la lista
     * cuando son capturas solas
     */
    private boolean cargaDatos = false;
    
    /**
     * Contiene el numero de factura que se le va asignar al envio
     */
    private String factura;
    
    /** Creates a new instance of Entrega */
    public EntregaWS() {
    }
    /**
     * Constructor con parametros
     * @param idGuia Ideiticador de la guia
     * @param quienRecibe Persona que recibe el envio
     * @param fecha fecha en que se recibe
     * @param hora hora en que se recibe
     */
    public EntregaWS(String idRuta,String origen) {
        setIdRuta(idRuta);
        setOrigen(origen);
    }
    
    /**
     * Se establecen solamente los datos de la guia y la fecha y hora dee la salida a ruta
     * @param idGuia identificador del envio
     * @param fecha fecha de la salida a ruta
     * @param hora hora de la salida a ruta
     */
    public EntregaWS(String idGuia,String fecha,int hora, int minutos){
        setIdGuia(idGuia);
        setFecha(fecha);
        setHora(hora);
        setMinutos(minutos);
    }
    /**
     * Constructor con parametros
     * @param idGuia Ideiticador de la guia
     * @param quienRecibe Persona que recibe el envio
     * @param fecha fecha en que se recibe
     * @param hora hora en que se recibe
     */
    public EntregaWS(String idGuia,String quienRecibe,String fecha,int hora,int minutos) {
        setIdGuia(idGuia);
        setQuienRecibe(quienRecibe);
        setFecha(fecha);
        setHora(hora);
        setMinutos(minutos);
    }
    
   
    
    /**
     * Verifica si una cadena es null o vacia, devuelve true si la cadena es
     * vacia o nula, en caso contrario devuelve false.
     * @param cadena cadena que se va a verificar
     * @return true si la cadena es nula a vacia, false en caso contrario
     */
    public boolean isNULLVACIA(String cadena){
        //Verifica si la cadena es nula
        if (cadena==null){
            return true;
        }
        //Verifica si la cadena es vacia
        if (cadena.trim().length()<=0){
            return true;
        }
        
        //Retorna false si la cadena no es nula o su largo es mayor de cero
        return false;
    }
    
    /**
     * Da formato a la fecha pra poder insertarla en la base de datos de Sybase,
     * tomando los datos de hora , minutos y fecha  capturados por el usuarios,
     * si los datos de la fecha son vacios o nulos entoinces regresa null
     * @return cadena que contiene la fecha para insertala en la DB MM/DD/YYYY HH:MM
     */
    public String getFechaConfirmacion() {
        
        //Da formato a la fecha
        if (this.fecha!=null){
            
            String[] fecha_elem = this.fecha.split("/");
            if (fecha_elem.length<3) return null;
            
            String min = this.minutos+"";
            while (min.length()<2){
                min="0"+min;
            }
            String formato_sybase = fecha_elem[1] + "/" + fecha_elem[0] +
            "/" + fecha_elem[2];
            return  formato_sybase  + " " + this.hora + ":" + min;
        }
        return null;
    }
    
   
    
    /**
     * Getter for property quienRecibe.
     * @return Value of property quienRecibe.
     */
    public java.lang.String getQuienRecibe() {
        return quienRecibe;
    }
    
    /**
     * Setter for property quienRecibe.
     * @param quienRecibe New value of property quienRecibe.
     */
    public void setQuienRecibe(java.lang.String quienRecibe) {
        this.quienRecibe = quienRecibe;
    }
    
    /**
     * Getter for property fecha.
     * @return Value of property fecha.
     */
    public java.lang.String getFecha() {
        return fecha;
    }
    
    /**
     * Setter for property fecha.
     * @param fecha New value of property fecha.
     */
    public void setFecha(java.lang.String fecha) {
        this.fecha = fecha;
    }
    
    /**
     * Getter for property hora.
     * @return Value of property hora.
     */
    public int getHora() {
        return hora;
    }
    
    /**
     * Setter for property hora.
     * @param hora New value of property hora.
     */
    public void setHora(int hora) {
        this.hora = hora;
    }
    
    /**
     * Ajusta los datos de Hora y Minutos
     * @param hora y minutos de la entrega
     */
    public void setHoraMinutos(String hora) {
        
        if (hora==null){
            setHora("00");
            setMinutos("00");
        }else{
            
            if ((hora==null) || hora.trim().length()<=0){
                return;
            }
            String[] hora_minutos = hora.split(":");
            
            try{
                if (hora_minutos.length>1){
                    setHora(hora_minutos[0]);
                    setMinutos(hora_minutos[1]);
                }else{
                    int hora_int;
                    try{
                        hora_int = Integer.parseInt(hora);;
                        //Si no existe exepcion completa la cadena a 4 caracteres
                        while (hora.length()<4){
                            hora+="0";
                        }
                        //Obtiene los dos primeros numeros para la hora
                        setHora(hora.substring(0,1));
                        setMinutos(hora.substring(2));
                    }catch(Exception ee){
                        //En caso de que no pueda inicializa los atos a las cero
                        //horas
                        setHora("00");
                        setMinutos("00");
                    }
                }
            }catch(Exception e){
                
            }
        }
    }
    
    /**
     * Setter for property hora.
     * @param minutos New value of property minutos.
     */
    public void setHora(String hora) {
        try{
            this.hora = Integer.parseInt(hora);
        }catch(NumberFormatException nfe){
            this.hora=0;
        }
    }
    
    /**
     * Getter for property idGuia.
     * @return Value of property idGuia.
     */
    public java.lang.String getIdGuia() {
        if (idGuia!=null){
            return idGuia.toUpperCase();
        }
        return idGuia;
    }
    
    /**
     * Setter for property idGuia.
     * @param idGuia New value of property idGuia.
     */
    public void setIdGuia(java.lang.String idGuia) {
        this.idGuia = idGuia;
    }
    
    /**
     * Getter for property siglasPlaza.
     * @return Value of property siglasPlaza.
     */
    public java.lang.String getSiglasPlaza() {
        return siglasPlaza;
    }
    
    /**
     * Setter for property siglasPlaza.
     * @param siglasPlaza New value of property siglasPlaza.
     */
    public void setSiglasPlaza(java.lang.String siglasPlaza) {
        this.siglasPlaza = siglasPlaza;
    }
    
    /**
     * Getter for property origen.
     * @return Value of property origen.
     */
    public java.lang.String getOrigen() {
        return origen;
    }
    
    /**
     * Setter for property origen.
     * @param origen New value of property origen.
     */
    public void setOrigen(java.lang.String origen) {
        this.origen = origen;
    }
    
    /**
     * Getter for property idRuta.
     * @return Value of property idRuta.
     */
    public java.lang.String getIdRuta() {
        if (idRuta!=null){
            return idRuta.toUpperCase();
        }
        return idRuta;
    }
    
    /**
     * Setter for property idRuta.
     * @param idRuta New value of property idRuta.
     */
    public void setIdRuta(java.lang.String idRuta) {
        this.idRuta = idRuta;
    }
    
    /**
     * Getter for property fechaConfirmaciones.
     * @return Value of property fechaConfirmaciones.
     */
    public java.lang.String getFechaConfirmaciones() {
        return fechaConfirmaciones;
    }
    
    /**
     * Setter for property fechaConfirmaciones.
     * @param fechaConfirmaciones New value of property fechaConfirmaciones.
     */
    public void setFechaConfirmaciones(java.lang.String fechaConfirmaciones) {
        this.fechaConfirmaciones = fechaConfirmaciones;
    }
    
    /**
     * Getter for property minutos.
     * @return Value of property minutos.
     */
    public int getMinutos() {
        return minutos;
    }
    
    /**
     * Setter for property minutos.
     * @param minutos New value of property minutos.
     */
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    
    /**
     * Setter for property minutos.
     * @param minutos New value of property minutos.
     */
    public void setMinutos(String minutos) {
        try{
            this.minutos = Integer.parseInt(minutos);
        }catch(NumberFormatException nfe){
            this.minutos=0;
        }
    }
    
    /**
     * Devuelve la cantidad de registros a confirmar
     */
    public int getCantidadRegistros(){
        if (lista!=null){
            if ( lista.size()>0){
                //Agrega uno a la cantidad en la lista que representa la guia de
                //Casamiento, esto para que no quede pendiente
                return lista.size()+1;
            }
            return lista.size();
        }
        return 0;
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
     * Getter for property destino.
     * @return Value of property destino.
     */
    public java.lang.String getDestino() {
        return destino;
    }
    
    /**
     * Setter for property destino.
     * @param destino New value of property destino.
     */
    public void setDestino(java.lang.String destino) {
        this.destino = destino;
    }
    
    /**
     * Getter for property accion.
     * @return Value of property accion.
     */
    public java.lang.String getAccion() {
        return accion;
    }
    
    /**
     * Setter for property accion.
     * @param accion New value of property accion.
     */
    public void setAccion(java.lang.String accion) {
        this.accion = accion;
    }
    
    /**
     * Getter for property usuario.
     * @return Value of property usuario.
     */
    public java.lang.String getUsuario() {
        return usuario;
    }
    
    /**
     * Setter for property usuario.
     * @param usuario New value of property usuario.
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }
    
    /**
     * Getter for property cencap.
     * @return Value of property cencap.
     */
    public java.lang.String getCencap() {
        return cencap;
    }
    
    /**
     * Setter for property cencap.
     * @param cencap New value of property cencap.
     */
    public void setCencap(java.lang.String cencap) {
        this.cencap = cencap;
    }
    
    /**
     * Obtiene el consecutivo siguiente de registros
     */
    public String getInicia(){
        contador_registros=0;
        return "";
    }
    /**
     * Obtiene el consecutivo siguiente de registros
     */
    public int getSiguiente(){
        return contador_registros++;
    }
    
    /**
     * Getter for property isCargaDatos.
     * @return Value of property isCargaDatos.
     */
    public boolean isCargaDatos() {
        return cargaDatos;
    }
    
    /**
     * Setter for property isCargaDatos.
     * @param isCargaDatos New value of property isCargaDatos.
     */
    public void setCargaDatos(boolean isCargaDatos) {
        this.cargaDatos = isCargaDatos;
    }
    
    public void updateLista(){
        ArrayList nuevo = new ArrayList();
        
        for (int indice = 0; indice<this.lista.size();indice++){
            
            Object o = this.lista.get(indice);
            if (o!=null){
                nuevo.add(o);
            }
        }
        
        //Actualiza la lista con los nuevos datos
        setLista(nuevo);
    }
    
    /**
     * Getter for property cabecera_incluye.
     * @return Value of property cabecera_incluye.
     */
    public int getCabecera_incluye() {
        return cabecera_incluye;
    }
    
    /**
     * Setter for property cabecera_incluye.
     * @param cabecera_incluye New value of property cabecera_incluye.
     */
    public void setCabecera_incluye(int cabecera_incluye) {
        this.cabecera_incluye = cabecera_incluye;
    }
    
    /**
     * Getter for property idGuiaEnlace.
     * @return Value of property idGuiaEnlace.
     */
    public java.lang.String getIdGuiaEnlace() {
        if (idGuiaEnlace!=null){
            return idGuiaEnlace.toUpperCase();
        }
        return idGuiaEnlace;
    }
    
    /**
     * Setter for property idGuiaEnlace.
     * @param idGuiaEnlace New value of property idGuiaEnlace.
     */
    public void setIdGuiaEnlace(java.lang.String idGuiaEnlace) {
        this.idGuiaEnlace = idGuiaEnlace;
    }
    
    /**
     * Getter for property factura.
     * @return Value of property factura.
     */
    public java.lang.String getFactura() {
    	if (factura!= null) return  factura.trim();
    	
        return factura;
    }
    
    /**
     * Setter for property factura.
     * @param factura New value of property factura.
     */
    public void setFactura(java.lang.String factura) {
        this.factura = factura;
    }
    
    /**
     * Getter for property contador_registros.
     * @return Value of property contador_registros.
     */
    public int getContador_registros() {
        return contador_registros;
    }
    
    /**
     * Setter for property contador_registros.
     * @param contador_registros New value of property contador_registros.
     */
    public void setContador_registros(int contador_registros) {
        this.contador_registros = contador_registros;
    }
    
    /**
     * Getter for property isRegistro.
     * @return Value of property isRegistro.
     */
    public boolean isRegistro() {
        return isRegistro;
    }
    
    /**
     * Setter for property isRegistro.
     * @param isRegistro New value of property isRegistro.
     */
    public void setIsRegistro(boolean isRegistro) {
        this.isRegistro = isRegistro;
    }
    
    /**
     * Getter for property fechafin.
     * @return Value of property fechafin.
     */
    public java.lang.String getFechafin() {
        return fechafin;
    }
    
    /**
     * Setter for property fechafin.
     * @param fechafin New value of property fechafin.
     */
    public void setFechafin(java.lang.String fechafin) {
        this.fechafin = fechafin;
    }
	/**
	 * @return the numEmpleado
	 */
	public String getNumEmpleado() {
		return numEmpleado;
	}
	/**
	 * @param numEmpleado the numEmpleado to set
	 */
	public void setNumEmpleado(String numEmpleado) {
		this.numEmpleado = numEmpleado;
	}
	
    /**
	 * @return the idFirma
	 */
	public String getIdFirma() {
		return idFirma;
	}
	/**
	 * @param idFirma the idFirma to set
	 */
	public void setIdFirma(String idFirma) {
		this.idFirma = idFirma;
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
	public String getNombreObjeto() {
		return nombreObjeto;
	}
	public void setNombreObjeto(String nombreObjeto) {
		this.nombreObjeto = nombreObjeto;
	}
    
    //fin de setListaEnvios
}//fin de Entrega
