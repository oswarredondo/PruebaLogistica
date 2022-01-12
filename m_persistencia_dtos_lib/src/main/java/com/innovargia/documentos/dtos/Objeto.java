/* $Id:  $
 *
 * Nombre del Proyecto: SGEP
 * Nombre del Programa: Objeto.java
 * Responsable: Adrián Morales Ruaro
 * Descripcion: propiedades generricas para servicios, garantias, formatos, rutas
 * perfiles, etc
 *
 * $Log: $
 *
 */
package com.innovargia.documentos.dtos;

//Imports
import java.io.Serializable;
import java.util.ArrayList;
//import ietwebimpresion.action.BusquedaAction;

/**
 * Contiene las propiedades de diferentes objetos en el sistema
 *
 * @author Adrian Morales Ruaro
 * @version $Id:  $
 */
public class Objeto  implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private float valor;
	 
	
	private int idalmacen;
	private int idorganizacion;
	private int idubicacion;
	private String idproducto;
    
    /**
     * Holds value of property cantidad.
     * 
     * Utilizado en la cantidad de horas para una frecuencia
     */
    private int cantidad;
    
    /**Numero de serie*/
    private String numserie=null;
    
    /**Contiene el numero de embarque, parte, factura a la cual puede pertener un objeto*/
    private String numrelacion=null;
    
    
    /**
     * Indica el tipo de ordenamiento que se desea por omision es por Numero de Cliente en la cartera,
     * tambien es utilizado para realizar busquedas
     */
    private int ordenax;
    /**Patron de busqueda para remitentes o destinos*/
    private String patronBusqueda;
    
    /**
     * Indica la lista de proyectos, horas, etc del usuario
     */
    public ArrayList objetos = new ArrayList();
    
    /**
     * Identificador del objeto tipo entero, este se utliza dependiendo del
     * objeto o forma que se este trabajando.
     */
    private int int_Id;
    
    private int idTabla;
    /**
     * Identificador del objeto tipo cadena, este se utliza dependiendo del
     * objeto o forma que se este trabajando.
     */
    private String str_Id;
    
    /**     Descripción del objeto     */
    private String descripcion;
    
    /**
     * Indica el nombre del patron buscado, id usuario, empresa o cualquier
     * otro uso que se le desea dar
     */
    private String nombre;
    /**
     * Indica el apellido paterno
     */
    private String ap_paterno;
    /*** indica el apellido materno     */
    private String ap_materno;
    
    /** Contiene los identificadores de las ubicaciones*/
    public String ubicacion;
    /** Contiene los identificadores de los centros de costos*/
    public String costos;
    /**Contiene los nombres de los edificios*/
    public String edificio;
    /**Contiene ls nombres de los estados*/
    public String estados;
    /**Contiene los nombres de las empresas*/
    public String empresa;
    
    /** Contiene los identificadores de las ubicaciones*/
    public int[] ar_ubicacion;
    /** Contiene los identificadores de los centros de costos*/
    public int[] ar_costos;
    /**Contiene los nombres de los edificios*/
    public String[] ar_edificio;
    /**Contiene los nombres de los estados*/
    public String[] ar_estados;
    /**Contiene los nombres de las empresas*/
    public String[] ar_empresa;
    
    /**
     * Contiene los identificadores de los destinos en el siguiente formato
     * Id_Usuario_Destino|Formato|Tipo|Servicio|Comentario
     * es utilizado para los servicios que despliegan los combos en el sistema
     * de pedidos para poder indicar Identificador-Descripcion
     */
    private String destinos;
    /**Arreglo con todos los destinos a imprimir*/
    public String[] ar_destinos;
    
    /**
     * Constructor con id numerico
     */
    public Objeto(){
    }
    
    /**
     *  Ajusta el valor de la varible <b>cantidad</b> que es donde 
     *  se almacenan los datos de horas por frecuencias
     **/
    public void setHorasEntrega(int cantidad){
    	this.cantidad = cantidad;
    }
    /**
     *  Devuelve el valor de la varible <b>cantidad</b> que es donde 
     *  se almacenan los datos de horas por frecuencias
     **/
    public int getHorasEntrega(){
    	return this.cantidad;
    }
    /**
     * Constructor con id numerico
     * @param int_Id
     * @param descripcion
     */
    public Objeto(int int_Id,String descripcion){
        setInt_Id(int_Id);
        setDescripcion(descripcion);
    }
    
    /**
     * Constructor con id cadena
     * @param str_Id
     * @param descripcion
     */
    public Objeto(String str_Id,String descripcion){
        setStr_Id(str_Id);
        setDescripcion(descripcion);
    }
  
    
    /**
     * Devuelve el valor de la propiedad de  descripcion.
     * @return Value of property descripcion.
     */
    public java.lang.String getDescripcion() {
        if (descripcion!=null)
            return descripcion.toUpperCase();
        
        return descripcion;
    }
    
    /**
     * Ajusta el valor de la propiedad de  descripcion.
     * @param descripcion New value of property descripcion.
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Devuelve el valor de la propiedad de  str_Id.
     * @return Value of property str_Id.
     */
    public String getStr_Id() {
        if (str_Id!=null)
            return str_Id.toUpperCase();
        
        return str_Id;
    }
    
    /**
     * Ajusta el valor de la propiedad de  str_Id.
     * @param str_Id New value of property str_Id.
     */
    public void setStr_Id(String str_Id) {
        this.str_Id = str_Id;
    }
    
    /**
     * Devuelve el valor de la propiedad de  int_Id.
     * @return Value of property int_Id.
     */
    public int getInt_Id() {
        return int_Id;
    }
    
    /**
     * Ajusta el valor de la propiedad de  int_Id.
     * @param int_Id New value of property int_Id.
     */
    public void setInt_Id(int int_Id) {
        this.int_Id = int_Id;
    }
    
    /**
     * Devuelve el valor de la propiedad de  objetos.
     * @return Value of property objetos.
     */
    public java.util.ArrayList getObjetos() {
        return objetos;
    }
    
    /**
     * Ajusta el valor de la propiedad de  objetos.
     * @param objetos New value of property objetos.
     */
    public void setObjetos(java.util.ArrayList objetos) {
        this.objetos = objetos;
    }
    
    /**
     * Getter for property nombre.
     * @return Value of property nombre.
     */
    public java.lang.String getNombre() {
        if (nombre!=null)
            return nombre.toUpperCase();
        
        return nombre;
    }
    
    /**
     * Setter for property nombre.
     * @param nombre New value of property nombre.
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Getter for property ap_paterno.
     * @return Value of property ap_paterno.
     */
    public java.lang.String getAp_paterno() {
        if (ap_paterno!=null)
            return ap_paterno.toUpperCase();
        
        return ap_paterno;
    }
    
    /**
     * Setter for property ap_paterno.
     * @param ap_paterno New value of property ap_paterno.
     */
    public void setAp_paterno(java.lang.String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }
    
    /**
     * Getter for property ap_materno.
     * @return Value of property ap_materno.
     */
    public java.lang.String getAp_materno() {
        if (ap_materno!=null)
            return ap_materno.toUpperCase();
        
        return ap_materno;
    }
    
    /**
     * Setter for property ap_materno.
     * @param ap_materno New value of property ap_materno.
     */
    public void setAp_materno(java.lang.String ap_materno) {
        this.ap_materno = ap_materno;
    }
    
    /**
     * Devuelve el titulo de la seccion que esta haciendo el usuario
     */
    public String getTituloSeleccion(){
        String titulo="";
       /* switch (this.int_Id){
            case BusquedaAction.BUSQUEDA_ESTADOS:
                titulo = "Estados";
                break;
            case BusquedaAction.BUSQUEDA_CENTROS_COSTO:
                titulo = "Centros de Costo";
                break;
            case BusquedaAction.BUSQUEDA_EDIFICIOS:
                titulo = "Edificios";
                break;
            case BusquedaAction.BUSQUEDA_EMPRESAS:
                titulo = "Empresas";
                break;
            case BusquedaAction.BUSQUEDA_UBICACION:
                titulo = "Ubicaciones";
                break;
            case BusquedaAction.BUSQUEDA_CIUDAD:
                titulo = "Ciudades";
                break;
            case BusquedaAction.BUSQUEDA_USUARIOS:
            case BusquedaAction.BUSQUEDA_PATRON:
                titulo = "Usuarios Destino";
                break;
        
            default:
                titulo="";
        }//fin del switch*/
        
        return titulo.toUpperCase();
    }
    
    
    /**
     * Devuelve el titulo de la seccion que esta haciendo el usuario
     */
    public String getFuncionSeleccion(){
        String titulo="";
       /* switch (this.int_Id){
            case BusquedaAction.BUSQUEDA_ESTADOS:
                titulo = "agregaEstados";
                break;
            case BusquedaAction.BUSQUEDA_CENTROS_COSTO:
                titulo = "agregaCentrosCostos";
                break;
            case BusquedaAction.BUSQUEDA_EDIFICIOS:
                titulo = "agregaEdificio";
                break;
            case BusquedaAction.BUSQUEDA_EMPRESAS:
                titulo = "agregaEmpresas";
                break;
            case BusquedaAction.BUSQUEDA_UBICACION:
                titulo = "agregaUbicacion";
                break;
            case BusquedaAction.BUSQUEDA_CIUDAD:
                titulo = "agregaEdificio";
                break;
            case BusquedaAction.BUSQUEDA_USUARIOS:
            case BusquedaAction.BUSQUEDA_PATRON:
                titulo = "agregaDestinos";
                break;
        
            default:
                titulo="sinHacer";
        }//fin del switch*/
        
        return titulo;
    }
    
    /** Obtiene el valor de la propiedad ubicacion.
     * @return Value of property ubicacion.
     *
     */
    public String getUbicacion() {
        if (ubicacion!=null)
            return ubicacion.toUpperCase();
        
        return this.ubicacion;
    }
    
    /** Ajusta el valor de la propiedad ubicacion.
     * @param ubicacion New value of property ubicacion.
     *
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    /** Obtiene el valor de la propiedad costos.
     * @return Value of property costos.
     *
     */
    public String getCostos() {
        if (costos!=null)
            return costos.toUpperCase();
        
        return this.costos;
    }
    
    /** Ajusta el valor de la propiedad costos.
     * @param costos New value of property costos.
     *
     */
    public void setCostos(String costos) {
        this.costos = costos;
    }
    
    /** Obtiene el valor de la propiedad edificio.
     * @return Value of property edificio.
     *
     */
    public java.lang.String getEdificio() {
        if (edificio!=null)
            return edificio.toUpperCase();
        
        return this.edificio;
    }
    
    /** Ajusta el valor de la propiedad edificio.
     * @param edificio New value of property edificio.
     *
     */
    public void setEdificio(java.lang.String edificio) {
        this.edificio = edificio;
    }
    
    /** Obtiene el valor de la propiedad estados.
     * @return Value of property estados.
     *
     */
    public java.lang.String getEstados() {
        if (estados!=null)
            return estados.toUpperCase();
        
        return this.estados;
    }
    
    /** Ajusta el valor de la propiedad estados.
     * @param estados New value of property estados.
     *
     */
    public void setEstados(java.lang.String estados) {
        this.estados = estados;
    }
    
    /** Obtiene el valor de la propiedad empresa.
     * @return Value of property empresa.
     *
     */
    public java.lang.String getEmpresa() {
        if (empresa!=null)
            return empresa.toUpperCase();
        
        return this.empresa;
    }
    
    /** Ajusta el valor de la propiedad empresa.
     * @param empresa New value of property empresa.
     *
     */
    public void setEmpresa(java.lang.String empresa) {
        this.empresa = empresa;
    }
    
    /** Obtiene el valor de la propiedad destinos.
     * @return Value of property destinos.
     *
     */
    public java.lang.String getDestinos() {
        return this.destinos;
    }
    
    /** Ajusta el valor de la propiedad destinos.
     * @param destinos New value of property destinos.
     *
     */
    public void setDestinos(java.lang.String destinos) {
        this.destinos = destinos;
    }
    
    /**
     * Getter for property patronBusqueda.
     * @return Value of property patronBusqueda.
     */
    public java.lang.String getPatronBusqueda() {
        return patronBusqueda;
    }
    
    /**
     * Setter for property patronBusqueda.
     * @param patronBusqueda New value of property patronBusqueda.
     */
    public void setPatronBusqueda(java.lang.String patronBusqueda) {
        this.patronBusqueda = patronBusqueda;
    }
    
    /**
     * Getter for property ordenax.
     * @return Value of property ordenax.
     */
    public int getOrdenax() {
        return ordenax;
    }
    
    /**
     * Setter for property ordenax.
     * @param ordenax New value of property ordenax.
     */
    public void setOrdenax(int ordenax) {
        this.ordenax = ordenax;
    }
    
    
   
    
    /**
     * Getter for property numserie.
     * @return Value of property numserie.
     */
    public java.lang.String getNumserie() {
        return numserie;
    }
    
    /**
     * Setter for property numserie.
     * @param numserie New value of property numserie.
     */
    public void setNumserie(java.lang.String numserie) {
        this.numserie = numserie;
    }
    
    /**
     * Getter for property numrelacion.
     * @return Value of property numrelacion.
     */
    public java.lang.String getNumrelacion() {
        return numrelacion;
    }
    
    /**
     * Setter for property numrelacion.
     * @param numrelacion New value of property numrelacion.
     */
    public void setNumrelacion(java.lang.String numrelacion) {
        this.numrelacion = numrelacion;
    }
    
    /**
     * Getter for property cantidad.
     * @return Value of property cantidad.
     */
    public int getCantidad() {
        return this.cantidad;
    }
    
    /**
     * Setter for property cantidad.
     * @param cantidad New value of property cantidad.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

	public int getIdTabla() {
		return idTabla;
	}

	public void setIdTabla(int idTabla) {
		this.idTabla = idTabla;
	}

	/**
	 * @return the idalmacen
	 */
	public int getIdalmacen() {
		return idalmacen;
	}

	/**
	 * @param idalmacen the idalmacen to set
	 */
	public void setIdalmacen(int idalmacen) {
		this.idalmacen = idalmacen;
	}

	/**
	 * @return the idorganizacion
	 */
	public int getIdorganizacion() {
		return idorganizacion;
	}

	/**
	 * @param idorganizacion the idorganizacion to set
	 */
	public void setIdorganizacion(int idorganizacion) {
		this.idorganizacion = idorganizacion;
	}

	/**
	 * @return the idubicacion
	 */
	public int getIdubicacion() {
		return idubicacion;
	}

	/**
	 * @param idubicacion the idubicacion to set
	 */
	public void setIdubicacion(int idubicacion) {
		this.idubicacion = idubicacion;
	}

	/**
	 * @return the idproducto
	 */
	public String getIdproducto() {
		return idproducto;
	}

	/**
	 * @param idproducto the idproducto to set
	 */
	public void setIdproducto(String idproducto) {
		this.idproducto = idproducto;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
    
}//fin de Objeto


