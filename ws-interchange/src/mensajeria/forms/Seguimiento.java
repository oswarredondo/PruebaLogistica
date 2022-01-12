/* $Id: $
 * Nombre del Proyecto:
 * Nombre del Programa: Historia.java
 * Responsable: Adri�n Morales Ruaro
 * Descripcion: contiene los datos de un registro de historia
 *
 *$Log:$
 */
package mensajeria.forms;

//Imports
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.Serializable;
import java.text.SimpleDateFormat;


/**
 *<CODE>
 * Contiene la historia de un envio
 *</CODE>
 *
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
public class Seguimiento implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String nombreObjeto="Seguimiento";
    public ArrayList lista_cp = new ArrayList();
    public ArrayList lista_colonias = new ArrayList();
    public ArrayList lista_estados = new ArrayList();
    public ArrayList lista_usuarios = new ArrayList();
    
    private String latitud;
    private String longitud;
    
   
    private String  viaje;
    private String  deptodestino;
    private String  cincho;
    private String  numeconomico;
    
   
    /**NUmero de empleado**/
    public String numEmpleado;
    /**Numero de cliente asociado al usuari oque tiene la sesion**/
    public String numCliente;
    
    /**Contiene el path del archivo que contiene la informacion consultada*/
    private String pathFile;
    /**
     * Lista que contiene los datos los envios
     */
    public ArrayList lista = new ArrayList();
    
    /** Encabezados posibles en el manifiesto*/
    public String encabezados;
    
    public String motivo;
    public String quienRechaza;
    /**
     * Contiene el seguimiento
     */
    public ArrayList listaSeguimiento = new ArrayList();
    /**
     * Identificador del envio
     */
    private String idEnvio;
    // Campos
    /** Contiene el identificador del tipo de registro  */
    private String tipoRegistro;
    /** Contiene la fecha del evento*/
    private String fechaEvento;
    /** Contiene la clave de excepcion */
    private String claveExce;
    /** Contiene el identificador de la ruta */
    private String ruta;
    /** Contiene las siglas de la plaza destino */
    private String siglas;
    /** Contiene �as siglas de la plaza que origino el registro*/
    private String origenRegistro;
    /** Contiene la fecha de insercion del registro  */
    private String fechaInsercion;
    /**Referencia*/
    private String referencia;
    
    /**Contiene la fecha de inicio*/
    private String fecinicio;
    
    /**Contiene la fecha de final*/
    private String fecfin;
    
    /**Identificador del carrior(transportista)*/
    private String idCarrier;
    
    /**Identificador de la guia madre cuando es una guia generada despues de una
     * carta de recoleccion*/
    private String guiaMadre;
    
    /**Codigo postal para busquedas*/
    private String  codigopostal;
    
    /**Colonias para busquedas*/
    private String  colonias;
    
    /**
     * Tipo de reporte, por identificador, por rango de fechas, por el
     * ultiumo mes(estos dos ultimos reportes pueden tomar los criterios
     * de busqueda que se estan solicitando)
     *
     */
    private int tiporeporte;
    
    /**
     * Tipo de cacrcteristica del reporte
     */
    private int tipoCaracteristica;
    
    /**
     * Caracteristica utilizada en la b�squeda de reporte
     */
    private int tipoSeleccion;
    
    /**
     * Tipo de busqueda en el seguimiento
     */
    private int tipobusqueda;
    
    /** Contiene los identificadores de las ubicaciones*/
    public String ubicacion;
    /**
     * @return the viaje
     */
    public String getViaje() {
        return viaje;
    }

    /**
     * @param viaje the viaje to set
     */
    public void setViaje(String viaje) {
        this.viaje = viaje;
    }

    /**
     * @return the deptodestino
     */
    public String getDeptodestino() {
        return deptodestino;
    }

    /**
     * @param deptodestino the deptodestino to set
     */
    public void setDeptodestino(String deptodestino) {
        this.deptodestino = deptodestino;
    }



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
    
    /** Guia de casamiento */
    private String idCasamiento;
    
    /**Login del usuario*/
    private String login;
    
    /**identificador del proveedor*/
    private String idProveedor;
    
    private String documento_embarque;
    private String factura;
    private String serie;
    private String placa;
    private int cantidad;
    private String hora_evento;
    
    private String idAlmacen;
    
    
    //Datos de ECOP y SCOP
    private String operador1;
    private String operador2;
    private String contenedor1;
    private String contenedor2;
    private String cartaporte;
    private String manifiesto;
    private String vehiculo;
    
    
    //Sobre peso
    private float pesoKG=0;
    private float alto=0;
    private float ancho=0;
    private float largo=0;

    //Monto
    private float monto=0;
    
    /**
	 * @return the monto
	 */
	public float getMonto() {
		return monto;
	}

	/**
	 * @param pesoKG the pesoKG to set
	 */
	public void setMonto(String monto) {
		
		try{
			this.monto = Float.parseFloat(monto) ;
		}catch(Exception e ){
			this.monto = 0;
		}
		
	}
	
	/**
	 * @param monto the monto to set
	 */
	public void setMonto(float monto) {
		this.monto = monto;
	}

	/**
	 * @return the pesoKG
	 */
	public float getPesoKG() {
		return pesoKG;
	}

	/**
	 * @param pesoKG the pesoKG to set
	 */
	public void setPesoKG(float pesoKG) {
		
		this.pesoKG = pesoKG;
	}
	
	/**
	 * @param pesoKG the pesoKG to set
	 */
	public void setPesoKG(String pesoKG) {
		
		try{
			this.pesoKG = Float.parseFloat(pesoKG) ;
		}catch(Exception e ){
			this.pesoKG = 0;
		}
		
	}
	

	/**
	 * @return the alto
	 */
	public float getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(float alto) {
		this.alto = alto;
	}
	
	/**
	 * @param alto the alto to set
	 */
	public void setAlto(String alto) {
		try{
			this.alto  = Float.parseFloat(alto) ;
		}catch(Exception e ){
			this.alto = 0;
		}
		 
	}
	

	/**
	 * @return the ancho
	 */
	public float getAncho() {
		return ancho;
	}
	
	/**
	 * @param alto the ancho to set
	 */
	public void setAncho(String ancho) {
		try{
			this.ancho  = Float.parseFloat(ancho) ;
		}catch(Exception e ){
			this.ancho = 0;
		}
		 
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	/**
	 * @return the largo
	 */
	public float getLargo() {
		return largo;
	}

	/**
	 * @param largo the largo to set
	 */
	public void setLargo(float largo) {
		this.largo = largo;
	}

	/**
	 * @param alto the ancho to set
	 */
	public void setLargo(String largo) {
		try{
			this.largo  = Float.parseFloat(largo) ;
		}catch(Exception e ){
			this.largo = 0;
		}
		 
	}

	
	/**
	 * @return the guiaMadre
	 */
	public String getGuiaMadre() {
		return guiaMadre;
	}

	/**
	 * @param guiaMadre the guiaMadre to set
	 */
	public void setGuiaMadre(String guiaMadre) {
		this.guiaMadre = guiaMadre;
	}

	/**
	 * @return the operador1
	 */
	public String getOperador1() {
		return operador1;
	}

	/**
	 * @param operador1 the operador1 to set
	 */
	public void setOperador1(String operador1) {
		this.operador1 = operador1;
	}

	/**
	 * @return the operador2
	 */
	public String getOperador2() {
		return operador2;
	}

	/**
	 * @param operador2 the operador2 to set
	 */
	public void setOperador2(String operador2) {
		this.operador2 = operador2;
	}

	/**
	 * @return the contenedor1
	 */
	public String getContenedor1() {
		return contenedor1;
	}

	/**
	 * @param contenedor1 the contenedor1 to set
	 */
	public void setContenedor1(String contenedor1) {
		this.contenedor1 = contenedor1;
	}

	/**
	 * @return the contenedor2
	 */
	public String getContenedor2() {
		return contenedor2;
	}

	/**
	 * @param contenedor2 the contenedor2 to set
	 */
	public void setContenedor2(String contenedor2) {
		this.contenedor2 = contenedor2;
	}

	/**
	 * @return the cartaporte
	 */
	public String getCartaporte() {
		return cartaporte;
	}

	/**
	 * @param cartaporte the cartaporte to set
	 */
	public void setCartaporte(String cartaporte) {
		this.cartaporte = cartaporte;
	}

	/**
	 * @return the manifiesto
	 */
	public String getManifiesto() {
		return manifiesto;
	}

	/**
	 * @param manifiesto the manifiesto to set
	 */
	public void setManifiesto(String manifiesto) {
		this.manifiesto = manifiesto;
	}

	/**
	 * @return the vehiculo
	 */
	public String getVehiculo() {
		return vehiculo;
	}

	/**
	 * @param vehiculo the vehiculo to set
	 */
	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

	/** Devuelve la cantidad de registros resultado de la consulta*/
    public int getCantidadRegistrosConsulta(){
    	if (this.lista == null) return 0;
    	return lista.size();
    }
    
   
    
    /**
     * Holds value of property idProducto.
     */
    private String idProducto;
    
    
    
    
    /**
     * Constructor por default
     */
    public Seguimiento() { ; }
    
    /**
     * Constructor por default con parametros
     *
     */
    public Seguimiento(String tipoRegistro, String fechaEvento, String claveExce,
            String ruta, String siglas, String origenRegistro, String fechaInsercion){
        
        this.tipoRegistro = tipoRegistro;
        this.fechaEvento = fechaEvento;
        this.claveExce = claveExce;
        this.ruta = ruta;
        this.siglas = siglas;
        this.origenRegistro = origenRegistro;
        this.fechaInsercion = fechaInsercion;
      
    }
    
  
    
    public int getShowCreacion(){
    	return getShowEncabezado("A");
    }
    public int getShowTranslado(){
    	return getShowEncabezado("B");
    }
    public int getShowReferencia(){
    	return getShowEncabezado("C");
    }
    public int getShowComentario(){
    	return getShowEncabezado("D");
    }
    public int getShowContenido(){
    	return getShowEncabezado("E");
    }
    public int getShowPeso(){
    	return getShowEncabezado("F");
    }
    public int getShowMonto(){
    	return getShowEncabezado("G");
    }
    public int getShowCantidadAsegurada(){
    	return getShowEncabezado("H");
    } 
    
    public int getShowConfirmacion(){
    	return getShowEncabezado("I");
    } 
    /**
     *  Verifica si el encabezado enviado se va a desplegar 
     **/
    private int getShowEncabezado(String head ){
    	    	
    	if (head==null){
    		return 0;
    	}
    	if (encabezados==null){
    		return 0;
    	}
    	if (this.encabezados.indexOf(head)>=0){
    		return 1;
    	}
    	return 0;
    	
    }
    public int getCantidadRegistros(){
        return lista.size();
    }
    
    public void getResertDatos(){
        setFecinicio(null);
    }
    /**
     * Obtiene el valor de la propiedad de  tipoRegistro.
     * @return Value of property tipoRegistro.
     */
    public java.lang.String getTipoRegistro() {
        if (tipoRegistro!=null)
            return tipoRegistro.toUpperCase();
        
        return tipoRegistro;
    }
    
    public boolean getEncabezadoRemite(){
        if (encabezados==null){
            return false;
        }
        
        //Verifica si el dia seleccionado se enncuentra denntro de la frecuencia
        if (encabezados.indexOf("R")>=0){
            return true;
        }
        return false;
    }
    public boolean getEncabezadoDestino(){
        if (encabezados==null){
            return false;
        }
        
        //Verifica si el dia seleccionado se enncuentra denntro de la frecuencia
        if (encabezados.indexOf("D")>=0){
            return true;
        }
        return false;
    }
    public boolean getEncabezadoRef(){
        if (encabezados==null){
            return false;
        }
        
        //Verifica si el dia seleccionado se enncuentra denntro de la frecuencia
        if (encabezados.indexOf("E")>=0){
            return true;
        }
        return false;
    }
    public boolean getEncabezadoCon(){
        if (encabezados==null){
            return false;
        }
        
        //Verifica si el dia seleccionado se enncuentra denntro de la frecuencia
        if (encabezados.indexOf("C")>=0){
            return true;
        }
        return false;
    }
    public boolean getEncabezadoCdOrigen(){
        if (encabezados==null){
            return false;
        }
        
        //Verifica si el dia seleccionado se enncuentra denntro de la frecuencia
        if (encabezados.indexOf("O")>=0){
            return true;
        }
        return false;
    }
    public boolean getEncabezadoCdDest(){
        if (encabezados==null){
            return false;
        }
        
        //Verifica si el dia seleccionado se enncuentra denntro de la frecuencia
        if (encabezados.indexOf("S")>=0){
            return true;
        }
        return false;
    }
    
    
    /**
     * Ajusta el valor de la propiedad de  tipoRegistro.
     * @param tipoRegistro New value of property tipoRegistro.
     */
    public void setTipoRegistro(java.lang.String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }
    
    /**
     * Obtiene el valor de la propiedad de  fechaEvento.
     * @return Value of property fechaEvento.
     */
    public java.lang.String getFechaEvento() {
        return fechaEvento;
    }
    
    /**
     * Ajusta el valor de la propiedad de  fechaEvento.
     * @param fechaEvento New value of property fechaEvento.
     */
    public void setFechaEvento(java.lang.String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }
    
    /**
     * Obtiene el valor de la propiedad de  claveExce.
     * @return Value of property claveExce.
     */
    public java.lang.String getClaveExce() {
        if (claveExce!=null)
            return claveExce.toUpperCase();
        
        return claveExce;
    }
    
    /**
     * Ajusta el valor de la propiedad de  claveExce.
     * @param claveExce New value of property claveExce.
     */
    public void setClaveExce(java.lang.String claveExce) {
        this.claveExce = claveExce;
    }
    
    /**
     * Obtiene el valor de la propiedad de  ruta.
     * @return Value of property ruta.
     */
    public java.lang.String getRuta() {
        if (ruta!=null)
            return ruta.toUpperCase();
        
        return ruta;
    }
    
    /**
     * Ajusta el valor de la propiedad de  ruta.
     * @param ruta New value of property ruta.
     */
    public void setRuta(java.lang.String ruta) {
        this.ruta = ruta;
    }
    
    /**
     * Obtiene el valor de la propiedad de  siglas.
     * @return Value of property siglas.
     */
    public java.lang.String getSiglas() {
        if (siglas!=null)
            return siglas.toUpperCase();
        
        return siglas;
    }
    
    /**
     * Ajusta el valor de la propiedad de  siglas.
     * @param siglas New value of property siglas.
     */
    public void setSiglas(java.lang.String siglas) {
        this.siglas = siglas;
    }
    
    /**
     * Obtiene el valor de la propiedad de  origenRegistro.
     * @return Value of property origenRegistro.
     */
    public java.lang.String getOrigenRegistro() {
        if (origenRegistro!=null)
            return origenRegistro.toUpperCase();
        
        return origenRegistro;
    }
    
    /**
     * Ajusta el valor de la propiedad de  origenRegistro.
     * @param origenRegistro New value of property origenRegistro.
     */
    public void setOrigenRegistro(java.lang.String origenRegistro) {
        this.origenRegistro = origenRegistro;
    }
    
    /**
     * Obtiene el valor de la propiedad de  fechaInsercion.
     * @return Value of property fechaInsercion.
     */
    public java.lang.String getFechaInsercion() {
        return fechaInsercion;
    }
    
    /**
     * Ajusta el valor de la propiedad de  fechaInsercion.
     * @param fechaInsercion New value of property fechaInsercion.
     */
    public void setFechaInsercion(java.lang.String fechaInsercion) {
        this.fechaInsercion = fechaInsercion;
    }
    
    /** Getter for property tiporeporte.
     * @return Value of property tiporeporte.
     *
     */
    public int getTiporeporte() {
        return tiporeporte;
    }
    
    /** Setter for property tiporeporte.
     * @param tiporeporte New value of property tiporeporte.
     *
     */
    public void setTiporeporte(int tiporeporte) {
        this.tiporeporte = tiporeporte;
    }
    
    /** Getter for property ubicacion.
     * @return Value of property ubicacion.
     *
     */
    public java.lang.String getUbicacion() {
        if (ubicacion!=null)
            return ubicacion.toUpperCase();
        
        return ubicacion;
    }
    
    /** Setter for property ubicacion.
     * @param ubicacion New value of property ubicacion.
     *
     */
    public void setUbicacion(java.lang.String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    /** Getter for property costos.
     * @return Value of property costos.
     *
     */
    public java.lang.String getCostos() {
        if (costos!=null)
            return costos.toUpperCase();
        
        return costos;
    }
    
    /** Setter for property costos.
     * @param costos New value of property costos.
     *
     */
    public void setCostos(java.lang.String costos) {
        this.costos = costos;
    }
    
    /** Getter for property edificio.
     * @return Value of property edificio.
     *
     */
    public java.lang.String getEdificio() {
        if (edificio!=null)
            return edificio.toUpperCase();
        
        return edificio;
    }
    
    /** Setter for property edificio.
     * @param edificio New value of property edificio.
     *
     */
    public void setEdificio(java.lang.String edificio) {
        this.edificio = edificio;
    }
    
    /** Getter for property estados.
     * @return Value of property estados.
     *
     */
    public java.lang.String getEstados() {
        if (estados!=null)
            return estados.toUpperCase();
        
        return estados;
    }
    
    /** Setter for property estados.
     * @param estados New value of property estados.
     *
     */
    public void setEstados(java.lang.String estados) {
        this.estados = estados;
    }
    
    /** Getter for property empresa.
     * @return Value of property empresa.
     *
     */
    public java.lang.String getEmpresa() {
        if (empresa!=null)
            return empresa.toUpperCase();
        
        return empresa;
    }
    
    /** Setter for property empresa.
     * @param empresa New value of property empresa.
     *
     */
    public void setEmpresa(java.lang.String empresa) {
        this.empresa = empresa;
    }
    
    /** Getter for property ar_ubicacion.
     * @return Value of property ar_ubicacion.
     *
     */
    public int[] getAr_ubicacion() {
        return this.ar_ubicacion;
    }
    
    /** Setter for property ar_ubicacion.
     * @param ar_ubicacion New value of property ar_ubicacion.
     *
     */
    public void setAr_ubicacion(int[] ar_ubicacion) {
        this.ar_ubicacion = ar_ubicacion;
    }
    
    /** Getter for property ar_costos.
     * @return Value of property ar_costos.
     *
     */
    public int[] getAr_costos() {
        return this.ar_costos;
    }
    
    /** Setter for property ar_costos.
     * @param ar_costos New value of property ar_costos.
     *
     */
    public void setAr_costos(int[] ar_costos) {
        this.ar_costos = ar_costos;
    }
    
    /** Getter for property ar_edificio.
     * @return Value of property ar_edificio.
     *
     */
    public java.lang.String[] getAr_edificio() {
        return this.ar_edificio;
    }
    
    /** Setter for property ar_edificio.
     * @param ar_edificio New value of property ar_edificio.
     *
     */
    public void setAr_edificio(java.lang.String[] ar_edificio) {
        this.ar_edificio = ar_edificio;
    }
    
    /** Getter for property ar_estados.
     * @return Value of property ar_estados.
     *
     */
    public java.lang.String[] getAr_estados() {
        return this.ar_estados;
    }
    
    /** Setter for property ar_estados.
     * @param ar_estados New value of property ar_estados.
     *
     */
    public void setAr_estados(java.lang.String[] ar_estados) {
        this.ar_estados = ar_estados;
    }
    
    /** Getter for property ar_empresa.
     * @return Value of property ar_empresa.
     *
     */
    public java.lang.String[] getAr_empresa() {
        return this.ar_empresa;
    }
    
    /** Setter for property ar_empresa.
     * @param ar_empresa New value of property ar_empresa.
     *
     */
    public void setAr_empresa(java.lang.String[] ar_empresa) {
        this.ar_empresa = ar_empresa;
    }
    
    /** Getter for property idEnvio.
     * @return Value of property idEnvio.
     *
     */
    public java.lang.String getIdEnvio() {
        if (idEnvio!=null)
            return idEnvio.toUpperCase();
        
        return idEnvio;
    }
    
    /** Setter for property idEnvio.
     * @param idEnvio New value of property idEnvio.
     *
     */
    public void setIdEnvio(java.lang.String idEnvio) {
        this.idEnvio = idEnvio;
    }
    
    /** Getter for property fecini.
     * @return Value of property fecini.
     *
     */
    public java.lang.String getFecinicio() {
        return fecinicio;
    }
    
    /** Setter for property fecini.
     * @param fecini New value of property fecini.
     *
     */
    public void setFecinicio(java.lang.String fecini) {
        this.fecinicio = fecini;
    }
    
    /** Getter for property fecfin.
     * @return Value of property fecfin.
     *
     */
    public java.lang.String getFecfin() {
        return fecfin;
    }
    
    /** Setter for property fecfin.
     * @param fecfin New value of property fecfin.
     *
     */
    public void setFecfin(java.lang.String fecfin) {
        this.fecfin = fecfin;
    }
    
    /** Getter for property lista.
     * @return Value of property lista.
     *
     */
    public java.util.ArrayList getLista() {
        return lista;
    }
    
    /** Setter for property lista.
     * @param lista New value of property lista.
     *
     */
    public void setLista(java.util.ArrayList lista) {
        this.lista = lista;
    }
    
    /** Getter for property pathFile.
     * @return Value of property pathFile.
     *
     */
    public java.lang.String getPathFile() {
        if (pathFile!=null)
            return pathFile;
        return "";
    }
    
    /** Setter for property pathFile.
     * @param pathFile New value of property pathFile.
     *
     */
    public void setPathFile(java.lang.String pathFile) {
        this.pathFile = pathFile;
    }
    
    /**
     * Si el valor es uno devuelve true( busqueda por remitente) si no false
     * destino );
     * @return Value of property tipobusqueda.
     *
     */
    public boolean getTipobusqueda() {
        if (this.tipobusqueda==1){
            return true;
        }else{
            return false;
        }
    }
    
    /** Setter for property tipobusqueda.
     * @param tipobusqueda New value of property tipobusqueda.
     *
     */
    public void setTipobusqueda(int tipobusqueda) {
        this.tipobusqueda = tipobusqueda;
    }
    
    /**
     * Regresa la fecha actual en el formato de DD/MM/AAAA
     */
    public String getHoy(){
        Calendar fecha = Calendar.getInstance();
        //Da formato a la fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fecha.getTime());
    }
    
    /**
     * Getter for property tipoCaracteristica.
     * @return Value of property tipoCaracteristica.
     */
    public int getTipoCaracteristica() {
        return tipoCaracteristica;
    }
    
    /**
     * Setter for property tipoCaracteristica.
     * @param tipoCaracteristica New value of property tipoCaracteristica.
     */
    public void setTipoCaracteristica(int tipoCaracteristica) {
        this.tipoCaracteristica = tipoCaracteristica;
    }
    
    /**
     * Getter for property tipoSeleccion.
     * @return Value of property tipoSeleccion.
     */
    public int getTipoSeleccion() {
        return tipoSeleccion;
    }
    
    /**
     * Setter for property tipoSeleccion.
     * @param tipoSeleccion New value of property tipoSeleccion.
     */
    public void setTipoSeleccion(int tipoSeleccion) {
        this.tipoSeleccion = tipoSeleccion;
    }
    
    /**
     * Getter for property idCasamiento.
     * @return Value of property idCasamiento.
     */
    public java.lang.String getIdCasamiento() {
        return idCasamiento;
    }
    
    /**
     * Setter for property idCasamiento.
     * @param idCasamiento New value of property idCasamiento.
     */
    public void setIdCasamiento(java.lang.String idCasamiento) {
        this.idCasamiento = idCasamiento;
    }
    
    /**
     * Getter for property listaSeguimiento.
     * @return Value of property listaSeguimiento.
     */
    public java.util.ArrayList getListaSeguimiento() {
        return listaSeguimiento;
    }
    
    /**
     * Setter for property listaSeguimiento.
     * @param listaSeguimiento New value of property listaSeguimiento.
     */
    public void setListaSeguimiento(java.util.ArrayList listaSeguimiento) {
        this.listaSeguimiento = listaSeguimiento;
    }
    
    /**
     * Getter for property encabezados.
     * @return Value of property encabezados.
     */
    public java.lang.String getEncabezados() {
        return encabezados;
    }
    
    /**
     * Setter for property encabezados.
     * @param encabezados New value of property encabezados.
     */
    public void setEncabezados(java.lang.String encabezados) {
        this.encabezados = encabezados;
    }
    
    /**
     * Getter for property referencia.
     * @return Value of property referencia.
     */
    public java.lang.String getReferencia() {
        return referencia;
    }
    
    /**
     * Setter for property referencia.
     * @param referencia New value of property referencia.
     */
    public void setReferencia(java.lang.String referencia) {
        this.referencia = referencia;
    }
    
    /**
     * Getter for property idCarrier.
     * @return Value of property idCarrier.
     */
    public java.lang.String getIdCarrier() {
        return idCarrier;
    }
    
    /**
     * Setter for property idCarrier.
     * @param idCarrier New value of property idCarrier.
     */
    public void setIdCarrier(java.lang.String idCarrier) {
        this.idCarrier = idCarrier;
    }
    
    /**
     * Getter for property codigopostal.
     * @return Value of property codigopostal.
     */
    public java.lang.String getCodigopostal() {
        return codigopostal;
    }
    
    /**
     * Setter for property codigopostal.
     * @param codigopostal New value of property codigopostal.
     */
    public void setCodigopostal(java.lang.String codigopostal) {
        this.codigopostal = codigopostal;
    }
    
    /**
     * Getter for property colonias.
     * @return Value of property colonias.
     */
    public java.lang.String getColonias() {
        return colonias;
    }
    
    /**
     * Setter for property colonias.
     * @param colonias New value of property colonias.
     */
    public void setColonias(java.lang.String colonias) {
        this.colonias = colonias;
    }
    
    /**
     * Getter for property lista_cp.
     * @return Value of property lista_cp.
     */
    public java.util.ArrayList getLista_cp() {
        return lista_cp;
    }
    
    /**
     * Setter for property lista_cp.
     * @param lista_cp New value of property lista_cp.
     */
    public void setLista_cp(java.util.ArrayList lista_cp) {
        this.lista_cp = lista_cp;
    }
    
    /**
     * Getter for property lista_colonias.
     * @return Value of property lista_colonias.
     */
    public java.util.ArrayList getLista_colonias() {
        return lista_colonias;
    }
    
    /**
     * Setter for property lista_colonias.
     * @param lista_colonias New value of property lista_colonias.
     */
    public void setLista_colonias(java.util.ArrayList lista_colonias) {
        this.lista_colonias = lista_colonias;
    }
    
    /**
     * Getter for property lista_estados.
     * @return Value of property lista_estados.
     */
    public java.util.ArrayList getLista_estados() {
        return lista_estados;
    }
    
    /**
     * Setter for property lista_estados.
     * @param lista_estados New value of property lista_estados.
     */
    public void setLista_estados(java.util.ArrayList lista_estados) {
        this.lista_estados = lista_estados;
    }
    
    /**
     * Getter for property login.
     * @return Value of property login.
     */
    public java.lang.String getLogin() {
        return login;
    }
    
    /**
     * Setter for property login.
     * @param login New value of property login.
     */
    public void setLogin(java.lang.String login) {
        this.login = login;
    }
    
    /**
     * Getter for property lista_usuarios.
     * @return Value of property lista_usuarios.
     */
    public java.util.ArrayList getLista_usuarios() {
        return lista_usuarios;
    }
    
    /**
     * Setter for property lista_usuarios.
     * @param lista_usuarios New value of property lista_usuarios.
     */
    public void setLista_usuarios(java.util.ArrayList lista_usuarios) {
        this.lista_usuarios = lista_usuarios;
    }
    
    /**
     * Getter for property idProveedor.
     * @return Value of property idProveedor.
     */
    public java.lang.String getIdProveedor() {
        return idProveedor;
    }
    
    /**
     * Setter for property idProveedor.
     * @param idProveedor New value of property idProveedor.
     */
    public void setIdProveedor(java.lang.String idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    /**
     * Getter for property documento_embarque.
     * @return Value of property documento_embarque.
     */
    public java.lang.String getDocumento_embarque() {
        return documento_embarque;
    }
    
    /**
     * Setter for property documento_embarque.
     * @param documento_embarque New value of property documento_embarque.
     */
    public void setDocumento_embarque(java.lang.String documento_embarque) {
        this.documento_embarque = documento_embarque;
    }
    
    /**
     * Getter for property factura.
     * @return Value of property factura.
     */
    public java.lang.String getFactura() {
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
     * Getter for property serie.
     * @return Value of property serie.
     */
    public java.lang.String getSerie() {
        return serie;
    }
    
    /**
     * Setter for property serie.
     * @param serie New value of property serie.
     */
    public void setSerie(java.lang.String serie) {
        this.serie = serie;
    }
    
    /**
     * Getter for property placa.
     * @return Value of property placa.
     */
    public java.lang.String getPlaca() {
        return placa;
    }
    
    /**
     * Setter for property placa.
     * @param placa New value of property placa.
     */
    public void setPlaca(java.lang.String placa) {
        this.placa = placa;
    }
    
    /**
     * Getter for property cantidad.
     * @return Value of property cantidad.
     */
    public int getCantidad() {
        return cantidad;
    }
    
    /**
     * Setter for property cantidad.
     * @param cantidad New value of property cantidad.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    /**
     * Getter for property hora_evento.
     * @return Value of property hora_evento.
     */
    public java.lang.String getHora_evento() {
        return hora_evento;
    }
    
    /**
     * Setter for property hora_evento.
     * @param hora_evento New value of property hora_evento.
     */
    public void setHora_evento(java.lang.String hora_evento) {
        this.hora_evento = hora_evento;
    }
    
    /**
     * Getter for property idAlmacen.
     * @return Value of property idAlmacen.
     */
    public String getIdAlmacen() {
        return this.idAlmacen;
    }
    
    /**
     * Setter for property idAlmacen.
     * @param idAlmacen New value of property idAlmacen.
     */
    public void setIdAlmacen(String idAlmacen) {
        this.idAlmacen = idAlmacen;
    }
    
    
    /**
     * Getter for property idProducto.
     * @return Value of property idProducto.
     */
    public String getIdProducto() {
        return this.idProducto;
    }
    
    /**
     * Setter for property idProducto.
     * @param idProducto New value of property idProducto.
     */
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

	public String getNumCliente() {
		return numCliente;
	}

	public void setNumCliente(String numCliente) {
		this.numCliente = numCliente;
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
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo; 
	}

	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	/**
	 * @return the quienrechaza
	 */
	public String getQuienRechaza() {
		return quienRechaza;
	}

	/**
	 * @param quienrechaza the quienrechaza to set
	 */
	public void setQuienRechaza(String quienrechaza) {
		this.quienRechaza = quienrechaza;
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

	/**
	 * @return the cincho
	 */
	public String getCincho() {
	    return cincho;
	}

	/**
	 * @param cincho the cincho to set
	 */
	public void setCincho(String cincho) {
	    this.cincho = cincho;
	}

	/**
	 * @return the numeconomico
	 */
	public String getNumeconomico() {
	    return numeconomico;
	}

	/**
	 * @param numeconomico the numeconomico to set
	 */
	public void setNumeconomico(String numeconomico) {
	    this.numeconomico = numeconomico;
	}

	public String getNombreObjeto() {
		return nombreObjeto;
	}

	public void setNombreObjeto(String nombreObjeto) {
		this.nombreObjeto = nombreObjeto;
	}
    
} // fin Historia
