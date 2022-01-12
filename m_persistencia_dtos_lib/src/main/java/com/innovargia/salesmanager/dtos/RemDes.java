/* $Id: $
 * Nombre del Proyecto:
 * Nombre del Programa: RemDes.java
 * Responsable: Adri�n Morales Ruaro
 * Descripcion: Datos de Cliente que puedxcen ser utilizados en destinos
 * o remitentes
 *
 *$Log:$
 */
package com.innovargia.salesmanager.dtos;

import java.io.Serializable;
//Imports
//import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.innovargia.documentos.dtos.RemDesEnvio;

/**
 *<CODE>
 * Datos de un cliente o un remitente
 *</CODE>
 *
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RemDes implements Serializable {
	
    boolean pdv=false;
	//Identificador padre, es utilizado cuando la direccion es perteneciuente a un conjunto de direcciones
	private String IdDocumentoPadre = null;
	private String idDocumento = null;
	private String IdTipoDocumento = null;
	
	private String latitud = null;
	private String longitud = null;

	  /**Organizacion*/
	private String encargado;

	/**Indica el identificador cuando nun registro esta autonumerico*/
	private int idAutonumerico = 0;
	private int idcliente = 0;
	private int idAutonumericoAlmacen = 0;
	private int idAutonumericoTipoAlmacen = 0;

	public static String TIPO_DIRECCION_ORIGEN_REM = "O";
	public static String TIPO_DIRECCION_DESTINATARIO = "D";
	public static String TIPO_DIRECCION_RECOLECCION = "R";
	public static String TIPO_DIRECCION_FACTURACION = "F";
	
	/**Indica el tipo de direccion de que se trata, O=Origen o remitente,
	D=Destinatario, R=recoleccion, F=facturacion o cualquier otro uso, ejemplo:
	 puede ser utilizadea en pedidos como tipo direccion contacto*/
	private String tipoDireccion;

	/**Identifica un registro de datos como incorrecto cuando se esta importando la informaci�n
	 * para impresi�n con destinos o remitentes o cuando se esta cargando una cartera de clientes
	  *Indica si un registro es correcto o incorrecto cuando se esta
	  *importando la infomacion
	  */
	private boolean estatus = false;
	
	private int estatus_int = 1;
	
	/**Contiene la informacin de una relaci�n de datos*/
    private ArrayList lista = new ArrayList();
    
    /** Identifircador de almacen*/
    private String idAlmacen;
    
    /**Persona que solicita una cotizacion o una recolecci�n*/
    private String solcitaRecol;
    
    private String rotula="SI";
    
    /**Identificador*/
    private String identificador;
    
    /** Tipo de almacen*/
    private String tipoAlmacen;
    
    /**Empresa que remite la carta*/
    private String empresa_remite_carta;
    /**Empresa Recolecta */
    private String empresa_recolecta;
    /**Representante de la empresa que recolecta*/
    private String representate_empresa_recolecta;
    /**Persona que firma la carta*/
    private String vobo_carta;
    
    /** Distribuidor */
    private String distribuidor;
    
    /**Cuenta maestra a la que pertenece el cliente*/
    private String cuentaMaestra;
    
    /**Organizacion*/
    private String organizacion;
    
    /**Organizacion*/
    private String contrato;
    
    /**
	 * @return the cuentaMaestra
	 */
	public String getCuentaMaestra() {
		return cuentaMaestra;
	}

	/**
	 * @param cuentaMaestra the cuentaMaestra to set
	 */
	public void setCuentaMaestra(String cuentaMaestra) {
		this.cuentaMaestra = cuentaMaestra;
	}
	
	/**Mensaje*/
    private String mensaje;
    /** Identificador del cliente usuario de la sesion activa*/
    private String numCliente;
    /** Identificador del registro de RemDes */
    private String idRmDes;
    /**  Razon Social     */
    private String razonSocial;
    /** Contiene la Atenci�n */
    private String atencion;
    /** Contiene la direccion calle y numero */
    private String direccion;
    /** Contiene calle y numero */
    private String calle;
    
    /** Colonia     */
    private String colonia;
    /** Contiene la ciudad*/
    private String ciudad;
    
    /**Indica si el usuario esta activo o dado de baja*/
    private String activo;
    
    /** Contiene el Estado  */
    private String estado;
    /**Municipio o Delegarcion*/
    private String municipio;
    /** Contiene el C�digo Postal del Domicilio */
    private String cp;
    /** Contiene el Tel�fono  */
    private String telefono;
    /** Contiene el Tel�fono secundario  */
    private String telefono2;

	private String entrecalles;
    
    /*** Pais */
	private String pais;
	private String codigopais;
    private boolean clienteActivo=false;
    /**Correo Electronico*/
    private String correoe;
    private String sitiointernet;
    private String numcelular;
    private String numradio;
    private String ubicacion_dir;
    
    private boolean clienteMoroso=false;
    private String banco1;
    private String cuentabanco1;
    private String banco2;
    private String cuentabanco2;
    private String banco3;
    private String cuentabanco3;
    private int diascredito;
    private String tipopago;
    private String idregistro;
    
    /**Datos del contacto*/
    private String idpuesto;
    private String iddepartamento;
    private String idtitulo;
    private String nombre;
    private String telcontacto;
    private String extencion;
    private String movil;
    private String fechanacimiento;
    private String numinterior;
    private String numexterior;
    private String referencia;
    
   /* private String ejecutivocuenta;
    private String telmovilejecutivocuenta;
    private String gerente;
    private String telmovilgerente;
    private String propietariocuenta;	
    private String telmovilpropietario;
    private String nextel;
    private String telefonocliente;
    private String indicadorcita;*/

	/**Venta*/
    private int comisionxventa=0;
    /**
     * Propietario del registro, es el cliente en el cual esta
     * instalado el sistema
     */
    private String idpropietario;
    
    /**Registro Federal de Contribuyentes*/
    private String rfc;
    /**Numero de Fax*/
    private String fax;
    /**Departamento*/
    private String depto;
    /**Notas o observaciones*/
    private String observacion;
    
    /**Tipo indica si el clientes, es prospecto, baja o activo**/
    private int tipoCliente;
    
    /**Clave unica del clienye*/
    private String cveUnica;
    
    /** Folio al que va anexa la carta*/
    private String folio;
    
    /**Indica las descripciones de tipos de clientes existenets*/
    public static final int PROSPECTO=0;
    public static final int BAJA=1;
    public static final int ACTIVO=2;
    
    /**  Ubicacion      */
    private int Ubicacion;
    
    /**  Apellido Paterno     */
    private String ap_Paterno;
    /** * Apellido Materno   */
    private String ap_Materno;
    /** Contiene la oficina */
    private String oficina;
    /** Contiene piso */
    private String piso;
    
    /** Contiene la localidad */
    private String localidad;
    
    /**Contiene el identificador del centro de costo seleccionado al crear el envio*/
    private int idCentroCosto;
    
    /**Referencia para ubicar el domicilio*/
    private String refdomicilio;
    
    /**Zona del CP*/
    private String zona;
    
    private int identidad;
    private int idorganizacion;

    /**  Constructor por default     */
    public RemDes() { ; }
    
    public RemDes(String identificador) {
        this.identificador = identificador;
    }
    
  
	public RemDes(RemDesEnvio datos){
        
        this.razonSocial =  datos.getRemitente().getRazonSocial();
        this.atencion =  datos.getRemitente().getAtencion();
        this.direccion =  datos.getRemitente().getDireccion();
        this.colonia =  datos.getRemitente().getColonia();
        this.ciudad =  datos.getRemitente().getCiudad();
        this.cp =  datos.getRemitente().getCp();
        this.telefono =  datos.getRemitente().getTelefono();
        this.telefono2 =  datos.getRemitente().getTelefono2();
       
        
    }
    
    /** * Constructor por default con parametros       */
    public RemDes(String numCliente,String idRmDes,String razonSocial,
    String atencion,String direccion,String colonia, String ciudad,String estado,String cp,String telefono){
        
        this.numCliente = numCliente;
        this.idRmDes = idRmDes;
        this.razonSocial = razonSocial;
        this.atencion = atencion;
        this.direccion = direccion;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.cp = cp;
        this.telefono=telefono;
    }
    public RemDes(String numCliente,String razonSocial,
    String atencion,String direccion,String colonia, String municipio,
    String ciudad,String estado,String cp,String telefono,String correoe){
        
        this.numCliente = numCliente;
        this.razonSocial = razonSocial;
        this.atencion = atencion;
        this.direccion = direccion;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.cp = cp;
        this.telefono=telefono;
        this.municipio = municipio;
        this.correoe = correoe;
    }
    
    public RemDes(String numCliente,String razonSocial,
    String atencion,String direccion,String colonia, String ciudad,String estado,String cp,String telefono){
        
        this.numCliente = numCliente;
        this.idRmDes = "";
        this.razonSocial = razonSocial;
        this.atencion = atencion;
        this.direccion = direccion;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.cp = cp;
        this.telefono=telefono;
    }
    /** * Constructor por default con parametros       */
    public RemDes(String nombre,String ap_Paterno,String ap_Materno,
    String oficina,String piso,String direccion,String localidad,
    String ciudad,String estado,String cp,int Ubicacion){
        
        this.nombre = nombre;
        this.ap_Paterno = ap_Paterno;
        this.ap_Materno = ap_Materno;
        this.oficina = oficina;
        this.piso = piso;
        this.direccion = direccion;
        this.localidad = localidad;
        this.ciudad = ciudad;
        this.estado = estado;
        this.cp = cp;
        this.Ubicacion=Ubicacion;
    }
    
    /**
     * Regresa una cadena con los datos del registro separados por pipes "|" <br>
     * como:<br>
     * <b>numCliente|idRmDes|razonSocial|atencion|direccion|colonia|ciudad|estado|cp|telefono|<b>
     * @return una cadena
     */
    public String getDataLine(){
        
        return  this.numCliente+"|"+ this.idRmDes+"|"+this.razonSocial+"|"+
        this.atencion+"|"+this.direccion+"|"+this.colonia+"|"+
        this.ciudad+"|"+this.estado+"|"+this.cp+"|"+ this.telefono+"|";
    }
    
    /**
     * Regresa una cadena con el formato Razon Social - Atencion <br>
     * como:<br>
     * @return una cadena
     */
    public String getRSocial_Atencion(){
        return  this.razonSocial+"-"+ this.atencion;
    }
  
    /**
     * Getter for property numCliente.
     * @return Value of property numCliente.
     */
    public java.lang.String getNumCliente() {
        return numCliente;
    }
    
    /**
     * Setter for property numCliente.
     * @param numCliente New value of property numCliente.
     */
    public void setNumCliente(java.lang.String numCliente) {
        this.numCliente = numCliente;
    }
    
    /**
     * Getter for property idRmDes.
     * @return Value of property idRmDes.
     */
    public String getIdRmDes() {
        return idRmDes;
    }
    
    /**
     * Setter for property idRmDes.
     * @param idRmDes New value of property idRmDes.
     */
    public void setIdRmDes(String idRmDes) {
        this.idRmDes = idRmDes;
    }
    
    /**
     * Getter for property razonSocial.
     * @return Value of property razonSocial.
     */
    public java.lang.String getRazonSocial() {
        return razonSocial;
    }
    
    /**
     * Setter for property razonSocial.
     * @param razonSocial New value of property razonSocial.
     */
    public void setRazonSocial(java.lang.String razonSocial) {
        this.razonSocial = upperCase(razonSocial);
    }
    
    /**
     * Getter for property atencion.
     * @return Value of property atencion.
     */
    public java.lang.String getAtencion() {
        return atencion;
    }
    
    /**
     * Setter for property atencion.
     * @param atencion New value of property atencion.
     */
    public void setAtencion(java.lang.String atencion) {
        this.atencion = upperCase(atencion);
    }
    
    /**
     * Getter for property direccion.
     * @return Value of property direccion.
     */
    public java.lang.String getDireccion() {
        return direccion;
    }
    
    /**
     * Setter for property direccion.
     * @param direccion New value of property direccion.
     */
    public void setDireccion(java.lang.String direccion) {
        this.direccion = upperCase(direccion);
    }
    
    /**
     * Getter for property colonia.
     * @return Value of property colonia.
     */
    public java.lang.String getColonia() {
        return colonia;
    }
    
    /**
     * Setter for property colonia.
     * @param colonia New value of property colonia.
     */
    public void setColonia(java.lang.String colonia) {
        
        this.colonia = upperCase(colonia);
    }
    
    /**
     * Getter for property ciudad.
     * @return Value of property ciudad.
     */
    public java.lang.String getCiudad() {
        return ciudad;
    }
    
    /**
     * Setter for property ciudad.
     * @param ciudad New value of property ciudad.
     */
    public void setCiudad(java.lang.String ciudad) {
        this.ciudad = upperCase(ciudad);
    }
    
    /**
     * Getter for property estado.
     * @return Value of property estado.
     */
    public java.lang.String getEstado() {
        return estado;
    }
    
    /**
     * Setter for property estado.
     * @param estado New value of property estado.
     */
    public void setEstado(java.lang.String estado) {
        this.estado =upperCase(estado);
    }
    
    /**
     * Getter for property cp.
     * @return Value of property cp.
     */
    public java.lang.String getCp() {
    	if ( this.cp == null) return "";
   	
    	if (this.cp.trim().equals("Buscar...")){
    		 return "";
    	}else if (this.cp!=null){

        	

        	
            String[] tmp_cad= this.cp.split("\\.");
            this.cp = tmp_cad[0];
            
            while (this.cp.trim().length()<5){
                this.cp="0"+this.cp;
            }
        }
        if (this.cp.trim().equals("00000")) return "";
        
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
     * Getter for property telefono.
     * @return Value of property telefono.
     */
    public java.lang.String getTelefono() {
        return telefono;
    }
    
    /**
     * Setter for property telefono.
     * @param telefono New value of property telefono.
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }
    
    public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	
    /**
     * Getter for property Ubicacion.
     * @return Value of property Ubicacion.
     */
    public int getUbicacion() {
        return Ubicacion;
    }
    
    /**
     * Setter for property Ubicacion.
     * @param Ubicacion New value of property Ubicacion.
     */
    public void setUbicacion(int Ubicacion) {
        this.Ubicacion = Ubicacion;
    }
    
    /**
     * Getter for property oficina.
     * @return Value of property oficina.
     */
    public java.lang.String getOficina() {
        return oficina;
    }
    
    /**
     * Setter for property oficina.
     * @param oficina New value of property oficina.
     */
    public void setOficina(java.lang.String oficina) {
        this.oficina = upperCase(oficina);
    }
    
    /**
     * Getter for property piso.
     * @return Value of property piso.
     */
    public java.lang.String getPiso() {
        return piso;
    }
    
    /**
     * Setter for property piso.
     * @param piso New value of property piso.
     */
    public void setPiso(java.lang.String piso) {
        this.piso = piso;
    }
    
    /**
     * Getter for property municipio.
     * @return Value of property municipio.
     */
    public java.lang.String getMunicipio() {
        return municipio;
    }
    
    /**
     * Setter for property municipio.
     * @param municipio New value of property municipio.
     */
    public void setMunicipio(java.lang.String municipio) {
        this.municipio = upperCase(municipio);
    }
    
    /**
     * Getter for property correoe.
     * @return Value of property correoe.
     */
    public java.lang.String getCorreoe() {
        return correoe;
    }
    
    /**
     * Setter for property correoe.
     * @param correoe New value of property correoe.
     */
    public void setCorreoe(java.lang.String correoe) {
        this.correoe = correoe;
    }
    
    /**
     * Getter for property mensaje.
     * @return Value of property mensaje.
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }
    
    /**
     * Setter for property mensaje.
     * @param mensaje New value of property mensaje.
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
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
     * Getter for property fax.
     * @return Value of property fax.
     */
    public java.lang.String getFax() {
        return fax;
    }
    
    /**
     * Setter for property fax.
     * @param fax New value of property fax.
     */
    public void setFax(java.lang.String fax) {
        this.fax = fax;
    }
    
    /**
     * Getter for property depto.
     * @return Value of property depto.
     */
    public java.lang.String getDepto() {
        return depto;
    }
    
    /**
     * Setter for property depto.
     * @param depto New value of property depto.
     */
    public void setDepto(java.lang.String depto) {
        this.depto = depto;
    }
    
    /**
     * Getter for property observacion.
     * @return Value of property observacion.
     */
    public java.lang.String getObservacion() {
        return observacion;
    }
    
    /**
     * Setter for property observacion.
     * @param observacion New value of property observacion.
     */
    public void setObservacion(java.lang.String observacion) {
        this.observacion = upperCase(observacion);
    }
    
    /**
     * Getter for property rfc.
     * @return Value of property rfc.
     */
    public java.lang.String getRfc() {
        return rfc;
    }
    
    /**
     * Setter for property rfc.
     * @param rfc New value of property rfc.
     */
    public void setRfc(java.lang.String rfc) {
        
        this.rfc = upperCase(rfc);
        if (this.rfc!=null){
            this.rfc = this.rfc.trim();
        }
    }
    
    /**
     * Getter for property cveUnica.
     * @return Value of property cveUnica.
     */
    public java.lang.String getCveUnica() {
        return cveUnica;
    }
    
    /**
     * Setter for property cveUnica.
     * @param cveUnica New value of property cveUnica.
     */
    public void setCveUnica(java.lang.String cveUnica) {
        this.cveUnica = cveUnica;
    }
    
    /**
     * Getter for property activo.
     * @return Value of property activo.
     */
    public java.lang.String getActivo() {
        return activo;
    }
    /**
     * Getter for property activo.
     * @return Value of property activo.
     */
    public java.lang.String getDescriopcionActivo() {
        if (this.activo==null) return "ACTIVO";
        if (this.activo.trim().equals("B")) return "BAJA";
        
        return "ACTIVO";
    }
    /**
     * Setter for property activo.
     * @param activo New value of property activo.
     */
    public void setActivo(java.lang.String activo) {
        this.activo = activo;
    }
    
    /**
     * Getter for property folio.
     * @return Value of property folio.
     */
    public java.lang.String getFolio() {
        return folio;
    }
    
    /**
     * Setter for property folio.
     * @param folio New value of property folio.
     */
    public void setFolio(java.lang.String folio) {

        try{
            Float i = new Float(folio);
            this.folio = i.intValue() + "";
        }catch(Exception e){
            this.folio = folio;
        }

    }
    
    /**
     * Getter for property empresa_remite_carta.
     * @return Value of property empresa_remite_carta.
     */
    public java.lang.String getEmpresa_remite_carta() {
        return empresa_remite_carta;
    }
    
    /**
     * Setter for property empresa_remite_carta.
     * @param empresa_remite_carta New value of property empresa_remite_carta.
     */
    public void setEmpresa_remite_carta(java.lang.String empresa_remite_carta) {
        this.empresa_remite_carta = empresa_remite_carta;
    }
    
    /**
     * Getter for property representate_empresa_recolecta.
     * @return Value of property representate_empresa_recolecta.
     */
    public java.lang.String getRepresentate_empresa_recolecta() {
        return representate_empresa_recolecta;
    }
    
    /**
     * Setter for property representate_empresa_recolecta.
     * @param representate_empresa_recolecta New value of property representate_empresa_recolecta.
     */
    public void setRepresentate_empresa_recolecta(java.lang.String representate_empresa_recolecta) {
        this.representate_empresa_recolecta = representate_empresa_recolecta;
    }
    
    /**
     * Getter for property vobo_carta.
     * @return Value of property vobo_carta.
     */
    public java.lang.String getVobo_carta() {
        return vobo_carta;
    }
    
    /**
     * Setter for property vobo_carta.
     * @param vobo_carta New value of property vobo_carta.
     */
    public void setVobo_carta(java.lang.String vobo_carta) {
        this.vobo_carta = vobo_carta;
    }
    
    /**
     * Getter for property empresa_recolecta.
     * @return Value of property empresa_recolecta.
     */
    public java.lang.String getEmpresa_recolecta() {
        return empresa_recolecta;
    }
    
    /**
     * Setter for property empresa_recolecta.
     * @param empresa_recolecta New value of property empresa_recolecta.
     */
    public void setEmpresa_recolecta(java.lang.String empresa_recolecta) {
        this.empresa_recolecta = empresa_recolecta;
    }
    
    /**
     * Getter for property distribuidor.
     * @return Value of property distribuidor.
     */
    public java.lang.String getDistribuidor() {
        return distribuidor;
    }
    
    /**
     * Setter for property distribuidor.
     * @param distribuidor New value of property distribuidor.
     */
    public void setDistribuidor(java.lang.String distribuidor) {
        this.distribuidor = upperCase(distribuidor);
    }
    
    /**
     * Getter for property idAlmacen.
     * @return Value of property idAlmacen.
     */
    public java.lang.String getIdAlmacen() {
        return idAlmacen;
    }
    
    /**
     * Setter for property idAlmacen.
     * @param idAlmacen New value of property idAlmacen.
     */
    public void setIdAlmacen(java.lang.String idAlmacen) {
        this.idAlmacen = upperCase(idAlmacen);
    }
    
    /**
     * Getter for property identificador.
     * @return Value of property identificador.
     */
    public java.lang.String getIdentificador() {
        return identificador;
    }
    
    /**
     * Setter for property identificador.
     * @param identificador New value of property identificador.
     */
    public void setIdentificador(java.lang.String identificador) {
        this.identificador = upperCase(identificador);
    }
    
    /**
     * Getter for property tipoAlmacen.
     * @return Value of property tipoAlmacen.
     */
    public java.lang.String getTipoAlmacen() {
        return tipoAlmacen;
    }
    
    /**
     * Setter for property tipoAlmacen.
     * @param tipoAlmacen New value of property tipoAlmacen.
     */
    public void setTipoAlmacen(java.lang.String tipoAlmacen) {
        this.tipoAlmacen = tipoAlmacen;
    }
    
   
    
    /**
     * Getter for property sitiointernet.
     * @return Value of property sitiointernet.
     */
    public java.lang.String getSitiointernet() {
        return sitiointernet;
    }
    
    /**
     * Setter for property sitiointernet.
     * @param sitiointernet New value of property sitiointernet.
     */
    public void setSitiointernet(java.lang.String sitiointernet) {
        this.sitiointernet = sitiointernet;
    }
    
    /**
     * Getter for property numcelular.
     * @return Value of property numcelular.
     */
    public java.lang.String getNumcelular() {
        return numcelular;
    }
    
    /**
     * Setter for property numcelular.
     * @param numcelular New value of property numcelular.
     */
    public void setNumcelular(java.lang.String numcelular) {
        this.numcelular = numcelular;
    }
    
    /**
     * Getter for property numradio.
     * @return Value of property numradio.
     */
    public java.lang.String getNumradio() {
        return numradio;
    }
    
    /**
     * Setter for property numradio.
     * @param numradio New value of property numradio.
     */
    public void setNumradio(java.lang.String numradio) {
        this.numradio = numradio;
    }
    
    
    /**
     * Getter for property banco1.
     * @return Value of property banco1.
     */
    public java.lang.String getBanco1() {
        return banco1;
    }
    
    /**
     * Setter for property banco1.
     * @param banco1 New value of property banco1.
     */
    public void setBanco1(java.lang.String banco1) {
        this.banco1 = upperCase(banco1);
    }
    
    /**
     * Getter for property cuentabanco1.
     * @return Value of property cuentabanco1.
     */
    public java.lang.String getCuentabanco1() {
        return cuentabanco1;
    }
    
    /**
     * Setter for property cuentabanco1.
     * @param cuentabanco1 New value of property cuentabanco1.
     */
    public void setCuentabanco1(java.lang.String cuentabanco1) {
        this.cuentabanco1 = upperCase(cuentabanco1);
    }
    
    /**
     * Getter for property banco2.
     * @return Value of property banco2.
     */
    public java.lang.String getBanco2() {
        return banco2;
    }
    
    /**
     * Setter for property banco2.
     * @param banco2 New value of property banco2.
     */
    public void setBanco2(java.lang.String banco2) {
        this.banco2 = upperCase(banco2);
    }
    
    /**
     * Getter for property cuentabanco2.
     * @return Value of property cuentabanco2.
     */
    public java.lang.String getCuentabanco2() {
        return cuentabanco2;
    }
    
    /**
     * Setter for property cuentabanco2.
     * @param cuentabanco2 New value of property cuentabanco2.
     */
    public void setCuentabanco2(java.lang.String cuentabanco2) {
        this.cuentabanco2 = upperCase(cuentabanco2);
    }
    
    /**
     * Getter for property banco3.
     * @return Value of property banco3.
     */
    public java.lang.String getBanco3() {
        return banco3;
    }
    
    /**
     * Setter for property banco3.
     * @param banco3 New value of property banco3.
     */
    public void setBanco3(java.lang.String banco3) {
        this.banco3 = upperCase(banco3);
    }
    
    /**
     * Getter for property cuentabanco3.
     * @return Value of property cuentabanco3.
     */
    public java.lang.String getCuentabanco3() {
        return cuentabanco3;
    }
    
    /**
     * Setter for property cuentabanco3.
     * @param cuentabanco3 New value of property cuentabanco3.
     */
    public void setCuentabanco3(java.lang.String cuentabanco3) {
        this.cuentabanco3 = upperCase(cuentabanco3);
    }
    
    /**
     * Getter for property diascredito.
     * @return Value of property diascredito.
     */
    public int getDiascredito() {
        return diascredito;
    }
    
    /**
     * Setter for property diascredito.
     * @param diascredito New value of property diascredito.
     */
    public void setDiascredito(int diascredito) {
        this.diascredito = diascredito;
    }
    
    /**
     * Getter for property tipopago.
     * @return Value of property tipopago.
     */
    public java.lang.String getTipopago() {
        return tipopago;
    }
    
    /**
     * Setter for property tipopago.
     * @param tipopago New value of property tipopago.
     */
    public void setTipopago(java.lang.String tipopago) {
        this.tipopago = upperCase(tipopago);
    }
    
    /**
     * Getter for property clienteMoroso.
     * @return Value of property clienteMoroso.
     */
    public boolean isClienteMoroso() {
        return clienteMoroso;
    }
    
    /**
     * Setter for property clienteMoroso.
     * @param clienteMoroso New value of property clienteMoroso.
     */
    public void setClienteMoroso(boolean clienteMoroso) {
        this.clienteMoroso = clienteMoroso;
    }
    
    /**
     * Getter for property idregistro.
     * @return Value of property idregistro.
     */
    public java.lang.String getIdregistro() {
        return idregistro;
    }
    
    /**
     * Setter for property idregistro.
     * @param idregistro New value of property idregistro.
     */
    public void setIdregistro(java.lang.String idregistro) {
        this.idregistro = upperCase(idregistro);
    }
    
    /**
     * Getter for property idpropietario.
     * @return Value of property idpropietario.
     */
    public java.lang.String getIdpropietario() {
        return idpropietario;
    }
    
    /**
     * Setter for property idpropietario.
     * @param idpropietario New value of property idpropietario.
     */
    public void setIdpropietario(java.lang.String idpropietario) {
        this.idpropietario = upperCase(idpropietario);
    }
    
    /**
     * Getter for property tipoDireccion.
     * @return Value of property tipoDireccion.
     */
    public java.lang.String getTipoDireccion() {
        return tipoDireccion;
    }
    
    /**
     * Setter for property tipoDireccion.
     * @param tipoDireccion New value of property tipoDireccion.
     */
    public void setTipoDireccion(java.lang.String tipoDireccion) {
        this.tipoDireccion = upperCase(tipoDireccion);
    }
    
    /**
     * Getter for property idpuesto.
     * @return Value of property idpuesto.
     */
    public java.lang.String getIdpuesto() {
        return idpuesto;
    }
    
    /**
     * Setter for property idpuesto.
     * @param idpuesto New value of property idpuesto.
     */
    public void setIdpuesto(java.lang.String idpuesto) {
        this.idpuesto = upperCase(idpuesto);
    }
    
    /**
     * Getter for property iddepartamento.
     * @return Value of property iddepartamento.
     */
    public java.lang.String getIddepartamento() {
        return iddepartamento;
    }
    
    /**
     * Setter for property iddepartamento.
     * @param iddepartamento New value of property iddepartamento.
     */
    public void setIddepartamento(java.lang.String iddepartamento) {
        this.iddepartamento = upperCase(iddepartamento);
    }
    
    /**
     * Getter for property idtitulo.
     * @return Value of property idtitulo.
     */
    public java.lang.String getIdtitulo() {
        return idtitulo;
    }
    
    /**
     * Setter for property idtitulo.
     * @param idtitulo New value of property idtitulo.
     */
    public void setIdtitulo(java.lang.String idtitulo) {
        this.idtitulo = upperCase(idtitulo);
    }
    
    /**
     * Getter for property nombre.
     * @return Value of property nombre.
     */
    public java.lang.String getNombre() {
        return upperCase(nombre);
    }
    
    /**
     * Setter for property nombre.
     * @param nombre New value of property nombre.
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = upperCase(nombre);
    }
    
    /**
     * Getter for property telcontacto.
     * @return Value of property telcontacto.
     */
    public java.lang.String getTelcontacto() {
        return telcontacto;
    }
    
    /**
     * Setter for property telcontacto.
     * @param telcontacto New value of property telcontacto.
     */
    public void setTelcontacto(java.lang.String telcontacto) {
        this.telcontacto = telcontacto;
    }
    
    /**
     * Getter for property extencion.
     * @return Value of property extencion.
     */
    public java.lang.String getExtencion() {
        return extencion;
    }
    
    /**
     * Setter for property extencion.
     * @param extencion New value of property extencion.
     */
    public void setExtencion(java.lang.String extencion) {
        this.extencion = extencion;
    }
    
    /**
     * Getter for property movil.
     * @return Value of property movil.
     */
    public java.lang.String getMovil() {
        return movil;
    }
    
    /**
     * Setter for property movil.
     * @param movil New value of property movil.
     */
    public void setMovil(java.lang.String movil) {
        this.movil = movil;
    }
    
    /**
     * Getter for property fechanacimiento.
     * @return Value of property fechanacimiento.
     */
    public java.lang.String getFechanacimiento() {
        return fechanacimiento;
    }
    
    /**
     * Setter for property fechanacimiento.
     * @param fechanacimiento New value of property fechanacimiento.
     */
    public void setFechanacimiento(java.lang.String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    
    /**
     * Getter for property ubicacion_dir.
     * @return Value of property ubicacion_dir.
     */
    public java.lang.String getUbicacion_dir() {
        return ubicacion_dir;
    }
    
    /**
     * Setter for property ubicacion_dir.
     * @param ubicacion_dir New value of property ubicacion_dir.
     */
    public void setUbicacion_dir(java.lang.String ubicacion_dir) {
        this.ubicacion_dir = upperCase(ubicacion_dir);
    }
    
    /**
     * Getter for property clienteActivo.
     * @return Value of property clienteActivo.
     */
    public boolean isClienteActivo() {
        return clienteActivo;
    }
    
    /**
     * Setter for property clienteActivo.
     * @param clienteActivo New value of property clienteActivo.
     */
    public void setClienteActivo(boolean clienteActivo) {
        this.clienteActivo = clienteActivo;
    }
    
    /**
     * Getter for property comisionxventa.
     * @return Value of property comisionxventa.
     */
    public int getComisionxventa() {
        return comisionxventa;
    }
    
    /**
     * Setter for property comisionxventa.
     * @param comisionxventa New value of property comisionxventa.
     */
    public void setComisionxventa(int comisionxventa) {
        this.comisionxventa = comisionxventa;
    }
    
    private String upperCase(String s){
        if (s!=null) return s.toUpperCase();
        
        return s;
    }
    
    /**
     * Getter for property refdomicilio.
     * @return Value of property refdomicilio.
     */
    public java.lang.String getRefdomicilio() {
        return refdomicilio;
    }
    
    /**
     * Setter for property refdomicilio.
     * @param refdomicilio New value of property refdomicilio.
     */
    public void setRefdomicilio(java.lang.String refdomicilio) {
        this.refdomicilio = upperCase(refdomicilio);
    }

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public String getSolcitaRecol() {
		return solcitaRecol;
	}

	public void setSolcitaRecol(String solcitaRecol) {
		this.solcitaRecol = solcitaRecol;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(int tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getAp_Paterno() {
		return ap_Paterno;
	}

	public void setAp_Paterno(String ap_Paterno) {
		this.ap_Paterno = ap_Paterno;
	}

	public String getAp_Materno() {
		return ap_Materno;
	}

	public void setAp_Materno(String ap_Materno) {
		this.ap_Materno = ap_Materno;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getIdCentroCosto() {
		return idCentroCosto;
	}

	public void setIdCentroCosto(int idCentroCosto) {
		this.idCentroCosto = idCentroCosto;
	}

	public int getIdAutonumerico() {
		return idAutonumerico;
	}

	public void setIdAutonumerico(int idAutonumerico) {
		this.idAutonumerico = idAutonumerico;
	}
	
	public void setIdAutonumerico(String idAutonumerico) {
		try{
			this.idAutonumerico = Integer.parseInt(idAutonumerico);
		}catch(Exception e){
			
		}
		
	}

	public int getIdAutonumericoAlmacen() {
		return idAutonumericoAlmacen;
	}

	/**
	 * @return the organizacion
	 */
	public String getOrganizacion() {
		return organizacion;
	}
	/**
	 * @param organizacion the organizacion to set
	 */
	public void setOrganizacion(String organizacion) {
		this.organizacion = organizacion;
	}
	public void setIdAutonumericoAlmacen(int idAutonumericoAlmacen) {
		this.idAutonumericoAlmacen = idAutonumericoAlmacen;
	}

	public int getIdAutonumericoTipoAlmacen() {
		return idAutonumericoTipoAlmacen;
	}

	public void setIdAutonumericoTipoAlmacen(int idAutonumericoTipoAlmacen) {
		this.idAutonumericoTipoAlmacen = idAutonumericoTipoAlmacen;
	}
	
	

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getIdDocumentoPadre() {
		return IdDocumentoPadre;
	}

	public void setIdDocumentoPadre(String idDocumentoPadre) {
		IdDocumentoPadre = idDocumentoPadre;
	}
	
	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public String getIdTipoDocumento() {
		return IdTipoDocumento;
	}

	public void setIdTipoDocumento(String idTipoDocumento) {
		IdTipoDocumento = idTipoDocumento;
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
	 * @return the identidad
	 */
	public int getIdentidad() {
		return identidad;
	}
	/**
	 * @param identidad the identidad to set
	 */
	public void setIdentidad(int identidad) {
		this.identidad = identidad;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @return the entrecalles
	 */
	public String getEntrecalles() {
		return entrecalles;
	}

	/**
	 * @param entrecalles the entrecalles to set
	 */
	public void setEntrecalles(String entrecalles) {
		this.entrecalles = entrecalles;
	}

	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * @return the numinterior
	 */
	public String getNuminterior() {
		return numinterior;
	}

	/**
	 * @param numinterior the numinterior to set
	 */
	public void setNuminterior(String numinterior) {
		this.numinterior = numinterior;
	}

	/**
	 * @return the numexterior
	 */
	public String getNumexterior() {
		return numexterior;
	}

	/**
	 * @param numexterior the numexterior to set
	 */
	public void setNumexterior(String numexterior) {
		this.numexterior = numexterior;
	}
	
	/**
	 * @return the referencia
	 */
    public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	/**
	 * @return the estatus_int
	 */
	public int getEstatus_int() {
		return estatus_int;
	}

	/**
	 * @param estatus_int the estatus_int to set
	 */
	public void setEstatus_int(int estatus_int) {
		this.estatus_int = estatus_int;
	}

	/**
	 * @return the rotula
	 */
	public String getRotula() {
		return rotula;
	}

	/**
	 * @param rotula the rotula to set
	 */
	public void setRotula(String rotula) {
		this.rotula = rotula;
	}

	/**
	 * @return the idDocumento
	 */
	public String getIdDocumento() {
		return idDocumento;
	}

	/**
	 * @param idDocumento the idDocumento to set
	 */
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}

	/**
	 * @return the pdv
	 */
	public boolean isPdv() {
	    return pdv;
	}

	/**
	 * @param pdv the pdv to set
	 */
	public void setPdv(boolean pdv) {
	    this.pdv = pdv;
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

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	/**
	 * @return the codigopais
	 */
	public String getCodigopais() {
		return codigopais;
	}

	/**
	 * @param codigopais the codigopais to set
	 */
	public void setCodigopais(String codigopais) {
		this.codigopais = codigopais;
	}
    
} // fin RemDes
