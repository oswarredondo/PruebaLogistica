/* $Id: $
 * Nombre del Proyecto:
 * Nombre del Programa: CPs.java
 * Responsable: Adri�n Morales Ruaro
 * Descripcion: contiene los datos que pueden estar contenidos en los codigos
 * postales
 *
 *$Log:$
 */
package com.innovargia.documentos.dtos;

//Imports
import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *<CODE>
 * Datos de codigos postales
 *</CODE>
 *
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CPs implements Serializable {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** id municipio*/
    private String idMunicipio;
    /** id estado*/
    private String idEstado;
    
    /** Codigo Postal*/
    private String cp;
    /** municipio*/
    private String municipio;
    /** estado*/
    private String estado;
    /** Colonia*/
    private String colonia;
    /** ruta local asiganda para entrega o recoleccion*/
    private String rutaLocal;
    /** ruta foranea*/
    private String rutaForanea;
    /** Transportista*/
    private String transportista;
    /** Servicios otorgados al CP*/
    private String servicios;
    /** Posibles servicios adicionales*/
    private String adicionales;
    /** Frecuencias de entrega L=lunes,M=martes, etc*/
    private String frecuencias;
    /** Contiene las garantias posibles para el CP*/
    private String garantias;
    
    /** Regional*/
    private int  regional=-1;
    
	/** Ciudad*/
    private String ciudad;
    
    /**Contiene las siglas del centro operativo*/
    private String centroOperativo;
    
    /**Dias que tarda un transportista en entregar un envia cuando no es COBEX quien lo transporta*/
    private int diasEntrega;
    
    /** Siglas Estado */
    private String siglasEst;
    
    /** Siglas Municipio */
    private String siglasMuni;
    
    /** Reexpredicion */
    private int reexpedicion;
    
    /** Siglas de las Zona a la que corresponde el CP */
    private String zona;
    
    /**Obtiene todas las frecuencias atadas a ese codigo postal destinos*/
    ArrayList listFrecuencias = new ArrayList();
    
    /**Contiene datos de enrutamiento*/
    public Regional enrutamiento = new Regional(); 
    
    /**Registro Frecuencia contenido en el registro de CP*/
    public Frecuencias frecuencia = new Frecuencias();
    
    /**
     * Constructor por default
     */
    public CPs() {  }
    
    public CPs(String cp,String colonia){
        this.cp = cp;
        this.colonia = colonia;
    }
    
    /**
     * Constructor parametros
     */
    public CPs(String cp,String siglasEst,String estado,String siglasMuni,String municipio,String colonia,String garantias,
    String frecuencias,String adicionales,String transportista,String rutaLocal,String servicios) {
        
        this.cp = cp;
        this.siglasEst =siglasEst;
        this.estado = estado;
        this.siglasMuni =siglasMuni;
        this.municipio = municipio;
        this.colonia = colonia;
        this.garantias =garantias;
        this.frecuencias =frecuencias;
        this.transportista =transportista;
        this.rutaLocal =rutaLocal;
        this.servicios =servicios;
        this.adicionales = adicionales;
        
    }//fin de CPs 
    
     /**
     * Constructor parametros
     */
    public CPs(String cp,String estado,String municipio,String colonia) {
        
        this.cp = cp;
        this.estado = estado;
        this.municipio = municipio;
        this.colonia = colonia;
        
    }//fin de CPs
    
    /**
	 * @return the regional
	 */
	public int getRegional() {
		return regional;
	}

	/**
	 * @param regional the regional to set
	 */
	public void setRegional(int regional) {
		this.regional = regional;
	}
    
     /**
     * Constructor parametros
     */
    public CPs(String cp,String siglasEst,String estado,String municipio,String colonia) {
        
        this.cp = cp;
        this.siglasEst = siglasEst;
        this.estado = estado;
        this.municipio = municipio;
        this.colonia = colonia;
        
    }//fin de CPs
    
    
    /**
     * Constructor parametros
     */
    public CPs(String cp,String siglasEst,String estado,String siglasMuni,String municipio,String colonia,String garantias,
    String frecuencias,String adicionales,String transportista,String rutaLocal,String servicios,String centroOperativo) {
        
        this.cp = cp;
        this.siglasEst =siglasEst;
        this.estado = estado;
        this.siglasMuni =siglasMuni;
        this.municipio = municipio;
        this.colonia = colonia;
        this.garantias =garantias;
        this.frecuencias =frecuencias;
        this.transportista =transportista;
        this.rutaLocal =rutaLocal;
        this.servicios =servicios;
        this.centroOperativo =centroOperativo;
        this.adicionales = adicionales;
        
    }//fin de CPs
    
    /**
     * Constructor parametros
     */
    public CPs(String cp,String siglasEst,String siglasMuni,String garantias,
    String frecuencias,String adicionales,String transportista,String rutaLocal,
    String servicios,String centroOperativo) {
        
        this.cp = cp;
        this.siglasEst =siglasEst;
        this.municipio =siglasMuni;
        this.garantias =garantias;
        this.frecuencias =frecuencias;
        this.transportista =transportista;
        this.rutaLocal =rutaLocal;
        this.servicios =servicios;
        this.centroOperativo =centroOperativo;
        this.adicionales = adicionales;
        
    }//fin de CPs
    
    public CPs(String cp){
        this.cp = cp;
    }
    
    /**
     * Configura los datos del cliente dependiendo de los datos que el
     * usuario desea configurar
     *
     * @param nombre del campo a actualizar
     */
    public void setValorCampo(String campo,String valor){
        // System.out.println("Campo-->"+campo+ " Valor-->"+valor);
        if (campo==null){
            return;
        }
        //System.out.println("Campo-->"+campo+ " Valor-->"+valor);
        if (campo.trim().equals("CP")){
            this.cp = valor;
        }else if (campo.trim().equals("MUNICIPIO")){
            this.municipio = valor;
        }else if (campo.trim().equals("ESTADO")){
            //System.out.println("Entrega DIRECCION_RE");
            this.estado = valor;
        }else if (campo.trim().equals("COLONIA")){
            //System.out.println("Entrega COLONIA_RE");
            this.colonia = valor;
        }else if (campo.trim().equals("RUTALOCAL")){
            this.rutaLocal = valor;
        }else if (campo.trim().equals("RUTAFORANEA")){
            this.rutaForanea = valor;
        }else if (campo.trim().equals("SERVICIOS")){
            this.servicios = valor;
        }else if (campo.trim().equals("ADICIONALES")){
            this.adicionales = valor;
        }
    }//fin de setValorCampo
    
    /**
     * Verifica si un servicio es otorgado al cp selecionado
     */
    public boolean isOtorgaServicio(String servicio){
        if (servicio!=null){
            //verifica si la cadena especificada esta dentro de los servicios
            //especificados
            return ((this.servicios.indexOf(servicio)>0)?true:false);
        }
        return false;
    }
    
    /**
     * verifica si existen registros adicionales para la plaza
     */
    public boolean isOtorgaAdicional(String adicional){
        if (adicional!=null){
            //verifica si la cadena especificada esta dentro de los servicios
            //especificados
            return ((this.adicionales.indexOf(adicional)>0)?true:false);
        }
        return false;
    }
    
    /**
     * Getter for property cp.
     * @return Value of property cp.
     */
    public java.lang.String getCp() {
        return cp;
    }
    
    /**
     * Setter for property cp.
     * @param cp New value of property cp.
     */
    public void setCp(java.lang.String cp) {
        this.cp = cp;
    }
    
    /**
     * Getter for property municipio.
     * @return Value of property municipio.
     */
    public java.lang.String getMunicipio() {
      	if (this.municipio != null) return this.municipio.trim().toUpperCase();      	
        return municipio;
    }
    
    /**
     * Setter for property municipio.
     * @param municipio New value of property municipio.
     */
    public void setMunicipio(java.lang.String municipio) {
        this.municipio = municipio;
    }
    
    /**
     * Getter for property estado.
     * @return Value of property estado.
     */
    public java.lang.String getEstado() {
      	if (this.estado != null) return this.estado.trim().toUpperCase();       	
        return estado;
    }
    
    /**
     * Setter for property estado.
     * @param estado New value of property estado.
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }
    
    /**
     * Getter for property colonia.
     * @return Value of property colonia.
     */
    public java.lang.String getColonia() {
      	if (this.colonia != null) return this.colonia.trim().toUpperCase();   
        return colonia;
    }
    
    /**
     * Setter for property colonia.
     * @param colonia New value of property colonia.
     */
    public void setColonia(java.lang.String colonia) {
 	
        this.colonia = colonia;
    }
    
    /**
     * Getter for property rutaLocal.
     * @return Value of property rutaLocal.
     */
    public java.lang.String getRutaLocal() {
        return rutaLocal;
    }
    
    /**
     * Setter for property rutaLocal.
     * @param rutaLocal New value of property rutaLocal.
     */
    public void setRutaLocal(java.lang.String rutaLocal) {
        this.rutaLocal = rutaLocal;
    }
    
    /**
     * Getter for property rutaForanea.
     * @return Value of property rutaForanea.
     */
    public java.lang.String getRutaForanea() {
        return rutaForanea;
    }
    
    /**
     * Setter for property rutaForanea.
     * @param rutaForanea New value of property rutaForanea.
     */
    public void setRutaForanea(java.lang.String rutaForanea) {
        this.rutaForanea = rutaForanea;
    }
    
    /**
     * Getter for property servicios.
     * @return Value of property servicios.
     */
    public java.lang.String getServicios() {
        return servicios;
    }
    
    /**
     * Setter for property servicios.
     * @param servicios New value of property servicios.
     */
    public void setServicios(java.lang.String servicios) {
        this.servicios = servicios;
    }
    
    /**
     * Getter for property adicionales.
     * @return Value of property adicionales.
     */
    public java.lang.String getAdicionales() {
        return adicionales;
    }
    
    /**
     * Setter for property adicionales.
     * @param adicionales New value of property adicionales.
     */
    public void setAdicionales(java.lang.String adicionales) {
        this.adicionales = adicionales;
    }
    
    /**
     * Getter for property frecuencias.
     * @return Value of property frecuencias.
     */
    public java.lang.String getFrecuencias() {
        return frecuencias;
    }
    
    /**
     * Setter for property frecuencias.
     * @param frecuencias New value of property frecuencias.
     */
    public void setFrecuencias(java.lang.String frecuencias) {
        this.frecuencias = frecuencias;
    }
    /**
     *Verifica si el tipo de frecuencua es incluida en las frecuencias del
     * Envio
     **/
    public boolean isFrecuencia(String frec){
        
        if ((frecuencias==null) || (frec==null))
            return false;
        
        if (frecuencias.indexOf(frec)>0){
            return true;
        }
        return false;
    }
    
    /**
     * verifica si el codigo postal tiene el tipo se servicio seleccionado
     **/
    public boolean isServicio(String serv){
        
        if ((servicios==null) || (serv==null))
            return false;
        
        if (servicios.indexOf(serv)>0){
            return true;
        }
        return false;
    }
    
    /**
     * Getter for property transportista.
     * @return Value of property transportista.
     */
    public java.lang.String getTransportista() {
        return transportista;
    }
    
    /**
     * Setter for property transportista.
     * @param transportista New value of property transportista.
     */
    public void setTransportista(java.lang.String transportista) {
        this.transportista = transportista;
    }
    
    /**
     * Getter for property garantias.
     * @return Value of property garantias.
     */
    public java.lang.String getGarantias() {
        return garantias;
    }
    
    /**
     * Setter for property garantias.
     * @param garantias New value of property garantias.
     */
    public void setGarantias(java.lang.String garantias) {
        this.garantias = garantias;
    }
    
    /**
     * Verifica si el CP contiene las garantias seleccionadas
     **/
    public boolean isGarantia(String gar){
        
        if ((garantias==null) || (gar==null))
            return false;
        
        if (garantias.indexOf(gar)>0){
            return true;
        }
        return false;
    }
    
    /**
     * Getter for property siglasEst.
     * @return Value of property siglasEst.
     */
    public java.lang.String getSiglasEst() {
      	if (this.siglasEst != null) return this.siglasEst.trim().toUpperCase();
        return siglasEst;
    }
    
    /**
     * Setter for property siglasEst.
     * @param siglasEst New value of property siglasEst.
     */
    public void setSiglasEst(java.lang.String siglasEst) {
        this.siglasEst = siglasEst;
    }
    
    /**
     * Getter for property siglasMuni.
     * @return Value of property siglasMuni.
     */
    public java.lang.String getSiglasMuni() {
      	if (this.siglasMuni != null) return this.siglasMuni.trim().toUpperCase();
        return siglasMuni;
    }
    
    /**
     * Setter for property siglasMuni.
     * @param siglasMuni New value of property siglasMuni.
     */
    public void setSiglasMuni(java.lang.String siglasMuni) {
        this.siglasMuni = siglasMuni;
    }
    
    /**
     * Getter for property centroOperativo.
     * @return Value of property centroOperativo.
     */
    public java.lang.String getCentroOperativo() {
      	if (this.centroOperativo != null) return this.centroOperativo.trim().toUpperCase();
        return centroOperativo;
    }
    
    /**
     * Setter for property centroOperativo.
     * @param centroOperativo New value of property centroOperativo.
     */
    public void setCentroOperativo(java.lang.String centroOperativo) {
        this.centroOperativo = centroOperativo;
    }
    
    /**
     * Getter for property diasEntrega.
     * @return Value of property diasEntrega.
     */
    public int getDiasEntrega() {
        return diasEntrega;
    }
    
    /**
     * Setter for property diasEntrega.
     * @param diasEntrega New value of property diasEntrega.
     */
    public void setDiasEntrega(int diasEntrega) {
        this.diasEntrega = diasEntrega;
    }
    
    /**
     * Regresa el nombre de la imagen gif una paloma cuando el dia de entrega se
     * encuentra dentro de las fecuencias de entrega y una imagen transparente
     * cuando no esta, esto sirve para poder ser desplegada dentro de las frecuencias
     * en la cunsulta de un CP.
     */
    public String getGifFrecuencia(String dia,String frecuencias){
        
        if ((dia==null) || (frecuencias==null)){
            return "blanco";
        }
        
        //Verifica si el dia seleccionado se enncuentra denntro de la frecuencia
        if (frecuencias.indexOf(dia)>=0){
            return "paloma";
        }else{
            return "blanco";
        }
    }//fin de getGifFrecuencia
    /**
     * Regresa el nombre de la imagen gif una paloma cuando el dia de entrega se
     * encuentra dentro de las fecuencias de entrega y una imagen transparente
     * cuando no esta, esto sirve para poder ser desplegada dentro de las frecuencias
     * en la cunsulta de un CP.
     */
    public String getGifOpcional(String adicional){
        if (adicional==null){
            return "blanco";
        }
        if (this.adicionales==null){
            return "blanco";
        }
        
        System.out.println("Adicionales-->"+this.adicionales);
        System.out.println("Busca adicional-->"+adicional);
        if (this.adicionales.indexOf(adicional)>=0){
            //Verifica si el dia seleccionado se enncuentra denntro de la frecuencia
            if (adicional.equals("E")){
                return "entrega";
            }else if (adicional.equals("R")){
                return "recoleccion";
            }else if (adicional.equals("O")){
                return "ocurre";
            }else{
                return "blanco";
            }
        }
        return "blanco";
    }//fin de getGifOpcional
    
    /**
     * Regresa el nombre de la imagen cuando el servicio adicional disponible puede ser ocurre
     */
    public String getGifOcurre(){
        return getGifOpcional("O");
    }//fin de getGifOpcional
    
    /**
     * Regresa el nombre de la imagen cuando el servicio adicional disponible puede ser entrega
     */
    public String getGifEntrega(){
        return getGifOpcional("E");
    }//fin de getGifOpcional
    /**
     * Regresa el nombre de la imagen cuando el servicio adicional disponible puede ser recoleccion
     */
    public String getGifRecoleccion(){
        return getGifOpcional("R");
    }//fin de getGifOpcional
    /**
     * Regresa el nombre de la imagen para el el dia lunes solo en caso de que se
     * encuentre dentro de las frecuencias de entrega para un CP en destino
     */
    public String getFrecLunes(){
        return getGifFrecuencia("L",this.frecuencias);
    }//fin de getFrecLunes
    /**
     * Regresa el nombre de la imagen para el el dia martes solo en caso de que se
     * encuentre dentro de las frecuencias de entrega para un CP en destino
     */
    public String getFrecMartes(){
        return getGifFrecuencia("M",this.frecuencias);
    }//fin de getFrecLunes
    /**
     * Regresa el nombre de la imagen para el el dia miercoles solo en caso de que se
     * encuentre dentro de las frecuencias de entrega para un CP en destino
     */
    public String getFrecMiercoles(){
        return getGifFrecuencia("I",this.frecuencias);
    }//fin de getFrecLunes
    /**
     * Regresa el nombre de la imagen para el el dia jueves solo en caso de que se
     * encuentre dentro de las frecuencias de entrega para un CP en destino
     */
    public String getFrecJueves(){
        return getGifFrecuencia("J",this.frecuencias);
    }//fin de getFrecLunes
    /**
     * Regresa el nombre de la imagen para el el dia viernes solo en caso de que se
     * encuentre dentro de las frecuencias de entrega para un CP en destino
     */
    public String getFrecViernes(){
        return getGifFrecuencia("V",frecuencias);
    }//fin de getFrecLunes
    /**
     * Regresa el nombre de la imagen para el el dia sabado solo en caso de que se
     * encuentre dentro de las frecuencias de entrega para un CP en destino
     */
    public String getFrecSabado(){
        return getGifFrecuencia("S",this.frecuencias);
    }//fin de getFrecLunes
    /**
     * Regresa el nombre de la imagen para el el dia domingo solo en caso de que se
     * encuentre dentro de las frecuencias de entrega para un CP en destino
     */
    public String getFrecDomingo(){
        return getGifFrecuencia("D",this.frecuencias);
    }
    
    /**
     * Getter for property ciudad.
     * @return Value of property ciudad.
     */
    public java.lang.String getCiudad() {
    	if (this.ciudad != null) return this.ciudad.trim().toUpperCase();
        return ciudad;
    }
    
    /**
     * Setter for property ciudad.
     * @param ciudad New value of property ciudad.
     */
    public void setCiudad(java.lang.String ciudad) {
        this.ciudad = ciudad;
    }

	/**
	 * @return the zona
	 */
	public String getZona() {
		return zona;
	}

	/**
	 * @param zona the zona to set
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}

	/**
	 * @return the idMunicipio
	 */
	public String getIdMunicipio() {
		return idMunicipio;
	}

	/**
	 * @return the idEstado
	 */
	public String getIdEstado() {
		return idEstado;
	}

	/**
	 * @param idMunicipio the idMunicipio to set
	 */
	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	/**
	 * @param idEstado the idEstado to set
	 */
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	/**
	 * @return the reexpredicion
	 */
	public int getReexpedicion() {
		return reexpedicion;
	}

	/**
	 * @param reexpredicion the reexpredicion to set
	 */
	public void setReexpedicion(int reexpredicion) {
		reexpedicion = reexpredicion;
	}

}  //fin RemDesEnvio
