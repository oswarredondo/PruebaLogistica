/* $Id: $
 * Nombre del Proyecto: SGEP
 * Nombre del Programa: User.java
 * Responsable: Adrián Morales Ruaro
 * Descripcion: propiedades de Usuario
 *
 * $Log: $ 
 *
 */
package com.administracion.dto;

//Imports
import java.io.Serializable;
import java.util.ArrayList;



import com.innovargia.salesmanager.dtos.RemDes;

/**
 * Contiene las propiedades que indentifican usuarios del sistema
 *
 * @author Adrian Morales Ruaro
 * @version $Id:  $
 */

public class UsuarioAdminDTO implements Serializable{
	
	private  boolean isAlmacen=false;
	
	public Entidad entidad = new Entidad();
	public Organizacion organizacion = new Organizacion();
	public Cuentas cuenta = new Cuentas();
	
    /**Contiene la informacion general de los datos del cliente al que pertenece el usuario que se 
     *esta logeando*/
    private RemDes clienteUsuario = new RemDes();
    
    public String desUbicacion;
    public String desperfil;
    
    private int seleccionado;
    private String mensaje;
    
    private int idCentroCosto;
    public PerfilOpcionDTO perfil_Dto = new PerfilOpcionDTO();
    
    
    private String password;
    
    private int idEmpresa;
    private String  desEmpresa;
    
    private String numCliente;
    
    /**Indica el rol que juega dentro del sistema*/
    private String role_sys;
    
    private String formatoetimedia;
    private String formatoetiperso;
    
    //PLaza del usuario
    
    /**Indica que tipo de3 interfaz selecciono el usuario para la parte de la 
     aplicación IETWEB, en caso de ser null despliega la hora de estilo por defautl*/
    private String interfaz="o";
    
    public UsuarioAdminDTO(String login, String password,String desEmpresa, int perfil){
        setLogin(login);
        setPassword(password);
        setDesEmpresa(desEmpresa);
        setPerfil(perfil);
        setNombre("PRUEBAS");
    }
    
    
    /**
     * Descripcion del centro de costo
     */
    private String descosto;
    
    /**
     * Cantidad de veces que puede el usuario accesar al sistema, si no captrua los
     * datos correctos solamente tendrá 3 oportunidades
     */
    private int vecesSeguridad;
    
    /**
     * Indica la lista de  usuarios
     */
    public ArrayList usuarios = new ArrayList();
    
    /**
     * COntiene las diferentes ubicaciones donde a las que puede pertenecer
     * un usuario
     */
    public ArrayList ubicaciones = new ArrayList();
    
    /**
     * Contiene los diferentes perfiles a los que puede pertenecer un usuario
     */
    public ArrayList perfiles = new ArrayList();
    
    /**
     *Contiene el identificador del usuario
     */
    private String idUsuario;
    /**
     * Contien el nombre del usuario
     */
    private String nombre;
    
    /**
     * Contiene el Apellido pateno del usuario
     */
    private String ap_paterno;
    
    /**
     * Contiene el apellido Materno del usuario
     */
    private String ap_materno;
   
    private String logo;
    
    
    /**
     * Contiene el registro de numero social del usuario
     */
    private String num_imss;
    
    /**
     * Contiene el email del usuario
     */
    private String email;
    
    /**
     * Contiene el telefono del usuario
     */
    private String telefono;
    
    /**
     * Contiene el perfil del usuario
     */
    private int perfil;
    
    /**
     * identificador de la ubicacion asignada al usuario
     */
    private int idUbicacion;
    /**
     * Estado del usuario que puede ser:<br>
     * (A) Activo<br>
     * (B) Baja<br>
     * Por omisión cuando se crea un registro de usuario deberá activarse su
     * estado como activo<br>
     */
    private String estado;
    
    /**
     * Contiene el login del usuario
     */
    private String login;
    
    /**
     * Contiene el identificador de la ubicación del usuario
     */
    private int ubicacion;
    /**
     * Constructor
     */ 
    public UsuarioAdminDTO() {}
    
    
    /**
     * Siglas de la plaza a la que pertenece
     */
    private String siglasPlaza;
    /** Centro de captura*/
    private String centroCaptura;
    /** Ruta asignada*/
    private String ruta;
    private String idoficina;
    private String numempleado;
    
    /**
     * Constructor
     * @param idUsuario
     * @param estado
     */
    public UsuarioAdminDTO(String idUsuario,String estado ){
        actualizaEnteros(idUsuario,"0","0","0");
        this.estado = estado;
    }
    
    /**
     * Constructor
     * @param idUsuario
     * @param perfil
     * @param ubicacion
     * @param nombre
     * @param ap_paterno
     * @param ap_materno
     * @param num_imss
     * @param telefono
     * @param email
     * @param estado 
     * @param login
     */
    public UsuarioAdminDTO(String idUsuario,int perfil,int ubicacion,String nombre,
    String ap_paterno,String ap_materno, String num_imss,String telefono,
    String email,String estado,String login ){
        
        this.idUsuario=idUsuario;
        this.perfil=perfil;
        this.ubicacion=ubicacion;
        this.idUbicacion=ubicacion;
        this.nombre=nombre;
        this.ap_paterno=ap_paterno;
        this.ap_materno=ap_materno;
        this.num_imss=num_imss;
        this.telefono=telefono;
        this.email=email;
        this.estado=estado;
        this.login=login;
        
    }
    
    /**
     *  Devuelve los datos del usuarios en una sesión para que se pueda
     *  realizar el puente entre los sistemas
     **/
    public String getLlaveSesion(String sistema){
    	//login-password-idsistema-numcliente
    	return this.login +"-"+ this.password + "-" + "-" + sistema + "-" + this.numCliente; 
    }
    
    /**
     * Agrega un usuario a la lista, el idUsuario es el mismo valor de login.
     * @param idUsuario
     * @param nombre
     * @param login
     */
    public UsuarioAdminDTO(String idUsuario,String nombre,String login ){
        
        this.idUsuario=idUsuario;
        this.nombre=nombre;
        this.desEmpresa=nombre;
        this.login=login;
        
    }
    
    /**
     * Constructor
     * @param idUsuario
     * @param perfil
     * @param ubicacion
     * @param nombre
     * @param ap_paterno
     * @param ap_materno
     * @param num_imss
     * @param telefono
     * @param email
     * @param estado
     * @param login
     */
    public UsuarioAdminDTO(String idUsuario,String perfil,String ubicacion,String nombre,
    String ap_paterno,String ap_materno, String num_imss,String telefono,
    String email,String estado,String login ){
        
        actualizaEnteros(idUsuario,perfil,ubicacion,"0");
        this.idUbicacion=this.ubicacion;
        this.nombre=nombre;
        this.ap_paterno=ap_paterno;
        this.ap_materno=ap_materno;
        this.num_imss=num_imss;
        this.telefono=telefono;
        this.email=email;
        this.estado=estado;
        this.login=login;
        
    }
    /**
     * Constructor
     * @param idUsuario1
     * @param perfil1
     * @param ubicacion1
     * @param nombre
     * @param ap_paterno
     * @param ap_materno
     * @param num_imss
     * @param telefono
     * @param email
     * @param estado
     * @param login
     * @param centrocosto1
     */
    public UsuarioAdminDTO(String idUsuario1,String perfil1,String ubicacion1,String nombre,
    String ap_paterno,String ap_materno, String num_imss,String telefono,
    String email,String estado,String login,String centrocosto1 ){
        
        actualizaEnteros(idUsuario1,perfil1,ubicacion1,centrocosto1);
        
        this.nombre=nombre;
        this.idUbicacion=this.ubicacion;
        this.ap_paterno=ap_paterno;
        this.ap_materno=ap_materno;
        this.num_imss=num_imss;
        this.telefono=telefono;
        this.email=email;
        this.estado=estado;
        this.login=login;
        
    }
    
    /**
     * Convierte los datos de estring a numerico
     * @param usu
     * @param perf
     * @param ubica
     * @param ccosto
     */
    private void actualizaEnteros(String usu,String perf,String ubica,String ccosto){
        
        this.idUsuario = usu;
        
        try{
            this.perfil = Integer.parseInt(perf.trim(),10);
        }catch(NumberFormatException nfe){
            System.out.println("Error el convertir los perfil datos-->"+perf + " -->"+ nfe.getMessage());
            this.perfil=-1;
        }
        try{
            this.ubicacion = Integer.parseInt(ubica.trim(),10);
        }catch(NumberFormatException nfe){
            System.out.println("Error el convertir los ubicacion datos-->"+ ubica + " -->"+nfe.getMessage());
            this.ubicacion=-1;
        }
        
        try{
            this.idCentroCosto = Integer.parseInt(ccosto.trim(),10);
        }catch(Exception e){
            System.out.println("Error el convertir los ccosto datos-->"+ ccosto + " -->"+e.getMessage());
            this.idCentroCosto=0;
        }
    }//fin de updateInteger
    
    /**
     * Convierte la empresa a entero
     */
    public void actualizaEmpresa(String idempresa){
        try{
            this.idEmpresa = Integer.parseInt(idempresa.trim(),10);
        }catch(Exception e){
            System.out.println("Error al convertir la empress-->"+ idempresa + " -->"+e.getMessage());
            this.idEmpresa=0;
        }
    }
    
    
    /**
     * Devuleve la propiedad de  ubicacion.
     * @return Value of property ubicacion.
     */
    public int getUbicacion() {
        return ubicacion;
    }
    
    /**
     * Ajusta el valor de la propiedad ubicacion.
     * @param ubicacion New value of property ubicacion.
     */
    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    /**
     *  Devuleve la propiedad de  perfil.
     * @return Value of property perfil.
     */
    public int getPerfil() {
        return perfil;
    }
    
    /**
     * Ajusta el valor de la propiedad perfil.
     * @param perfil New value of property perfil.
     */
    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }
    
    /**
     * Devuleve la propiedad de  telefono.
     * @return Value of property telefono.
     */
    public java.lang.String getTelefono() {
        if (telefono!=null)
            return telefono.toUpperCase();
        
        return telefono;
    }
    
    /**
     * Ajusta el valor de la propiedad telefono.
     * @param telefono New value of property telefono.
     */
    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Devuleve la propiedad de  email.
     * @return Value of property email.
     */
    public java.lang.String getEmail() {
        return email;
    }
    
    /**
     * Ajusta el valor de la propiedad email.
     * @param email New value of property email.
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }
    
    /**
     * Devuleve la propiedad de  ap_materno.
     * @return Value of property ap_materno.
     */
    public java.lang.String getAp_materno() {
        if (ap_materno!=null)
            return ap_materno.toUpperCase();
        
        return ap_materno;
    }
    
    /**
     * Ajusta el valor de la propiedad ap_materno.
     * @param ap_materno New value of property ap_materno.
     */
    public void setAp_materno(java.lang.String ap_materno) {
        this.ap_materno = ap_materno;
    }
    
    /**
     * Devuleve la propiedad de  ap_paterno.
     * @return Value of property ap_paterno.
     */
    public java.lang.String getAp_paterno() {
        if (ap_paterno!=null)
            return ap_paterno.toUpperCase();
        
        return ap_paterno;
    }
    
    /**
     * Ajusta el valor de la propiedad ap_paterno.
     * @param ap_paterno New value of property ap_paterno.
     */
    public void setAp_paterno(java.lang.String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }
    
    /**
     *Devuleve la propiedad de  perfiles.
     * @return Value of property perfiles.
     */
    public java.util.ArrayList getPerfiles() {
        return perfiles;
    }
    
    /**
     * Ajusta el valor de la propiedad perfiles.
     * @param perfiles New value of property perfiles.
     */
    public void setPerfiles(java.util.ArrayList perfiles) {
        this.perfiles = perfiles;
    }
    
    /**
     * Devuleve la propiedad de  ubicaciones.
     * @return Value of property ubicaciones.
     */
    public java.util.ArrayList getUbicaciones() {
        return ubicaciones;
    }
    
    /**
     * Ajusta el valor de la propiedad ubicaciones.
     * @param ubicaciones New value of property ubicaciones.
     */
    public void setUbicaciones(java.util.ArrayList ubicaciones) {
        this.ubicaciones = ubicaciones;
    }
    
    /**
     * Devuleve la propiedad de  usuarios.
     * @return Value of property usuarios.
     */
    public java.util.ArrayList getUsuarios() {
        return usuarios;
    }
    
    /**
     * Ajusta el valor de la propiedad usuarios.
     * @param usuarios New value of property usuarios.
     */
    public void setUsuarios(java.util.ArrayList usuarios) {
        this.usuarios = usuarios;
    }
    
    /**
     * Obtiene el valor de la propiedad de  nombre.
     * @return Value of property nombre.
     */
    public java.lang.String getNombre() {
        if (nombre!=null)
            return nombre.toUpperCase();
        
        return nombre;
    }
    
    /**
     * Ajusta el valor de la propiedad de  nombre.
     * @param nombre New value of property nombre.
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene el valor de la propiedad de  estado.
     * @return Value of property estado.
     */
    public java.lang.String getEstado() {
        if ((this.estado==null) || (this.estado.equals("A"))){
            this.estado="A";
        }else{
            this.estado="B";
        }
        return estado;
    }
    /**
     * Obtiene el valor de la propiedad de  estado.
     * @return Value of property estado.
     */
    public java.lang.String getDescripcionEstado() {
        if ((this.estado==null) || (this.estado.equals("A"))){
            this.estado="A";
            return "ACTIVO";
        }
        this.estado="B";
        return "BAJA";
    }
    
    /**
     * Ajusta el valor de la propiedad de  estado.
     * @param estado New value of property estado.
     */
    public void setEstado(java.lang.String estado) {
        this.estado = estado;
    }
    
    /**
     * Getter for property idUsuario.
     * @return Value of property idUsuario.
     */
    public String getIdUsuario() {
        return idUsuario;
    }
    
    /**
     * Setter for property idUsuario.
     * @param idUsuario New value of property idUsuario.
     */
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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
     * Regresa el nombre completo del usuario, en el orden de A. Paterno+A. Materno+Nombre
     */
    public String getNombreCompleto(){
        if (this.nombre==null){
            this.nombre="";
        }
        if (this.ap_paterno==null){
            this.ap_paterno="";
        }
        if (this.ap_materno==null){
            this.ap_materno="";
        }
        return  getAp_paterno() + " " + getAp_materno() + " " + getNombre()+" ";
    }
    
    /** Getter for property idUbicacion.
     * @return Value of property idUbicacion.
     *
     */
    public int getIdUbicacion() {
        return idUbicacion;
    }
    
    /** Setter for property idUbicacion.
     * @param idUbicacion New value of property idUbicacion.
     *
     */
    public void setIdUbicacion(int idUbicacion) {
        this.idUbicacion = idUbicacion;
    }
    
    /** Getter for property num_imss.
     * @return Value of property num_imss.
     *
     */
    public java.lang.String getNum_imss() {
        return num_imss;
    }
    
    /** Setter for property num_imss.
     * @param num_imss New value of property num_imss.
     *
     */
    public void setNum_imss(java.lang.String num_imss) {
        this.num_imss = num_imss;
    }
    
    /** Getter for property desUbicacion.
     * @return Value of property desUbicacion.
     *
     */
    public java.lang.String getDesUbicacion() {
        return desUbicacion;
    }
    
    /** Setter for property desUbicacion.
     * @param desUbicacion New value of property desUbicacion.
     *
     */
    public void setDesUbicacion(java.lang.String desUbicacion) {
        this.desUbicacion = desUbicacion;
    }
    
  
    
    /** Setter for property desperfil.
     * @param desperfil New value of property desperfil.
     *
     */
    public void setDesperfil(java.lang.String desperfil) {
        this.desperfil = desperfil;
    }
    
    /** Getter for property seleccionado.
     * @return Value of property seleccionado.
     *
     */
    public int getSeleccionado() {
        return seleccionado;
    }
    
    /** Setter for property seleccionado.
     * @param seleccionado New value of property seleccionado.
     *
     */
    public void setSeleccionado(int seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    /** Getter for property mensaje.
     * @return Value of property mensaje.
     *
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }
    
    /** Setter for property mensaje.
     * @param mensaje New value of property mensaje.
     *
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }
    
    /**
     * Getter for property vecesSeguridad.
     * @return Value of property vecesSeguridad.
     */
    public int getVecesSeguridad() {
        return vecesSeguridad;
    }
    
    /**
     * Setter for property vecesSeguridad.
     * @param vecesSeguridad New value of property vecesSeguridad.
     */
    public void setVecesSeguridad(int vecesSeguridad) {
        this.vecesSeguridad = vecesSeguridad;
    }
    
    /**
     * Getter for property idCentroCosto.
     * @return Value of property idCentroCosto.
     */
    public int getIdCentroCosto() {
        return idCentroCosto;
    }
    
    /**
     * Setter for property idCentroCosto.
     * @param idCentroCosto New value of property idCentroCosto.
     */
    public void setIdCentroCosto(int idCentroCosto) {
        this.idCentroCosto = idCentroCosto;
    }
    
    /** Setter for property descosto.
     * @param descosto New value of property descosto.
     *
     */
    public void setDescosto(java.lang.String descosto) {
        this.descosto = descosto;
    }
    /** Getter for property descosto.
     * @return Value of property descosto.
     *
     */
    public java.lang.String getDescosto() {
        return descosto;
    }
    
    /**
     * Getter for property password.
     * @return Value of property password.
     */
    public java.lang.String getPassword() {
        return password;
    }
    
    /**
     * Setter for property password.
     * @param password New value of property password.
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }
    
    /**
     * Getter for property idEmpresa.
     * @return Value of property idEmpresa.
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }
    
    /**
     * Setter for property idEmpresa.
     * @param idEmpresa New value of property idEmpresa.
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
    /**
     * Getter for property desEmpresa.
     * @return Value of property desEmpresa.
     */
    public String getDesEmpresa() {
        return desEmpresa;
    }
    
    /**
     * Setter for property desEmpresa.
     * @param desEmpresa New value of property desEmpresa.
     */
    public void setDesEmpresa(String desEmpresa) {
        this.desEmpresa = desEmpresa;
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
     * Regresa el nombre del logo que va a mostrar en las etiquetas y pantallas el 
     * sistema
     * Getter for property logo.
     * @return Value of property logo.
     */
    public java.lang.String getLogo() {
    	if ((logo == null) || (logo.trim().length()<=0)) {
			return "logoInferior.gif";
		}
        return logo.trim();
    }
    
    /**
     * Setter for property logo.
     * @param logo New value of property logo.
     */
    public void setLogo(java.lang.String logo) {
        this.logo = logo;
    }
    
    /**
     * Getter for property clienteUsuario.
     * @return Value of property clienteUsuario.
     */
    public RemDes getClienteUsuario() {
        return clienteUsuario;
    }
    
    /**
     * Setter for property clienteUsuario.
     * @param clienteUsuario New value of property clienteUsuario.
     */
    public void setClienteUsuario(RemDes clienteUsuario) {
        this.clienteUsuario = clienteUsuario;
    }
    
    /**
     * Getter for property siglasPlaza.
     * @return Value of property siglasPlaza.
     */
    public java.lang.String getSiglasPlaza() {
    	if (siglasPlaza!=null){
    		return siglasPlaza.trim().toUpperCase();
    	}
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
     * Getter for property centroCaptura.
     * @return Value of property centroCaptura.
     */
    public java.lang.String getCentroCaptura() {
        return centroCaptura;
    }
    
    /**
     * Setter for property centroCaptura.
     * @param centroCaptura New value of property centroCaptura.
     */
    public void setCentroCaptura(java.lang.String centroCaptura) {
        this.centroCaptura = centroCaptura;
    }
    
    /**
     * Getter for property ruta.
     * @return Value of property ruta.
     */
    public java.lang.String getRuta() {
        return ruta;
    }
    
    /**
     * Setter for property ruta.
     * @param ruta New value of property ruta.
     */
    public void setRuta(java.lang.String ruta) {
        this.ruta = ruta;
    }
    
    /**
     * Getter for property role_sys.
     * @return Value of property role_sys.
     */
    public java.lang.String getRole_sys() {
        return role_sys;
    }
    
    /**
     * Setter for property role_sys.
     * @param role_sys New value of property role_sys.
     */
    public void setRole_sys(java.lang.String role_sys) {
        this.role_sys = role_sys;
    }
    
    /**
     * Getter for property interfaz.
     * @return Value of property interfaz.
     */
    public java.lang.String getInterfaz() {
        return interfaz;
    }
    
    /**
     * Setter for property interfaz.
     * @param interfaz New value of property interfaz.
     */
    public void setInterfaz(java.lang.String interfaz) {
        this.interfaz = interfaz;
    }

	/**
	 * @return the idoficina
	 */
	public String getIdoficina() {
		return idoficina;
	}

	/**
	 * @param idoficina the idoficina to set
	 */
	public void setIdoficina(String idoficina) {
		this.idoficina = idoficina;
	}

	/**
	 * @return the numempleado
	 */
	public String getNumempleado() {
		return numempleado;
	}

	/**
	 * @param numempleado the numempleado to set
	 */
	public void setNumempleado(String numempleado) {
		this.numempleado = numempleado;
	}

	/**
	 * @return the isAlmacen
	 */
	public boolean isAlmacen() {
		return isAlmacen;
	}

	/**
	 * @param isAlmacen the isAlmacen to set
	 */
	public void setAlmacen(boolean isAlmacen) {
		this.isAlmacen = isAlmacen;
	}

	
	/**
	 * @return the formatoetiperso
	 */
	public String getFormatoetiperso() {
		return formatoetiperso;
	}

	/**
	 * @param formatoetiperso the formatoetiperso to set
	 */
	public void setFormatoetiperso(String formatoetiperso) {
		this.formatoetiperso = formatoetiperso;
	}

	/**
	 * @return the formatoetimedia
	 */
	public String getFormatoetimedia() {
		return formatoetimedia;
	}

	/**
	 * @param formatoetimedia the formatoetimedia to set
	 */
	public void setFormatoetimedia(String formatoetimedia) {
		this.formatoetimedia = formatoetimedia;
	}

	
	
    
}//fin de User


