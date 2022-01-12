/*
 * Created on Aug 4, 2009
 *
 * Contiene las propiedades para el envio de un correo
 */
package com.innovargia.mail;

import java.util.ArrayList;
import java.util.HashMap;

import javax.mail.internet.InternetAddress; 

/**
 * @author aruaro
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EmailProperties {

	/**
	 * Constructor pode default
	 */
	public EmailProperties() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**Servidor de correo en salida (smtp).*/
	private String hostSmtp; 
	/**la dirección de correo de la persona que envía el mensaje*/
	private String senderAddress;
	/** la dirección de correo de la persona que recibirá el mensaje*/
	//private String toAddress;
	
	/**Arreglo para direccines destino*/
	public ArrayList<String> arr_To_Address = new ArrayList<String> ();
	
	/**Arreglo para direccines destino copias*/
	public ArrayList<String>  arr_To_AddressCC = new ArrayList<String> ();
	
	/**Arreglo para direccines destino copias ocultas*/
	public ArrayList<String>  arr_To_AddressBCC = new ArrayList<String> ();
	
	/**la dirección de correo de la persona que recibirá el mensaje en copia*/
	private String ccAddress; 
	/**la dirección de correo de la persona que recibirá el mensaje en copia oculta*/
	private String bccAddress;
	/**Titulo del mensaje*/
	private String subject; 
	/**variable booleana que indica si el mensaje es con formato HTML o texto simple, true=HTML, false=Texto*/
	private boolean isHTMLFormat=false; 
	/**cuerpo del mensaje*/
	private String body;
	
	/**Usuario */
	private String user;
	
	/**Usuario cuanta correo*/
	private String userMail;
	
	/**Password */
	private String password;
	
	/**Tipo de servidor de correo*/
	private String tipoServidorCorreo = "smtp";
	
	/**Indica si se debe habilitar el TLS*/
	private boolean startTls=false;
	/**Puerto por donde se da servicio al envio de correos*/
	private String port;
	
	/**indica si se requiere autientificación*/
	private boolean auth=false;
	
	/**indica si se requiere autientificación*/
	private boolean withDebug=false;
	
	private String mail_smtp_starttls_enable;
	private String mail_smtp_auth;
	private String mail_smtp_socketFactory_port;
	private String mail_smtp_socketFactory_class;
	private String mail_smtp_socketFactory_fallbackE;
	private String mail_transport_protocol;
	private String mail_host;
	private String mail_user;
	private String mail_smtp_user;
	private String mail_password;
	private String mail_smtp_port;
	private String  mail_from;
	
	public void setPropiedad(String propiedad, String valor){
		
		if (propiedad.trim().equals("mail.smtp.starttls.enable")){
			this.mail_smtp_starttls_enable = valor;
		}else if (propiedad.trim().equals("mail.smtp.auth")){
			this.mail_smtp_auth = valor;
		}else if (propiedad.trim().equals("mail.smtp.socketFactory.port")){
			this.mail_smtp_socketFactory_port = valor;
		}else if (propiedad.trim().equals("mail.smtp.socketFactory.class")){
			this.mail_smtp_socketFactory_class = valor;
		}else if (propiedad.trim().equals("mail.smtp.socketFactory.fallbackE")){
			this.mail_smtp_socketFactory_fallbackE= valor;
		}else if (propiedad.trim().equals("mail.transport.protocol")){
			this.mail_transport_protocol= valor;
		}else if (propiedad.trim().equals("mail.host")){
			this.mail_host = valor;
		}else if (propiedad.trim().equals("mail.user")){
			this.mail_user = valor;
		}else if (propiedad.trim().equals("mail.password")){
			this.mail_password = valor;
		}else if (propiedad.trim().equals("mail.smtp.port")){
			this.mail_smtp_port = valor;
		}else if (propiedad.trim().equals("mail.from")){
			this.mail_from = valor;
		}else if (propiedad.trim().equals("mail.smtp.user")){
			this.mail_smtp_user = valor;
		}else if (propiedad.trim().equals("mail.debug")){
			if (valor==null){
				this.withDebug=false;
			}else if (!valor.trim().toLowerCase().equals("true")){
				this.withDebug=false;
			}else{
				this.withDebug=true;
			}
			
			
		}
			
		
		
	}
	
	
	/**
	 * Cotniene el hash de variables, el formato de la variable debe ser
	 * vidname donde: vid indica al sistema que es una variable y name, indica
	 * el nombre de la variable esto debe ser precedido por VID: para declararlo en el codigo html.
	 * La llave debe indicar el nombre de la variable como se ha puesto en el body del correo y el valor indica el contenido de tal variable
	 * Para agregar variables a la tabla utilice el método addImage
	 * <p> 
	 *  Esto es un ejemplo solamente VID:videjemplo</p>
	 *  
	 * 
	 * **/
	private HashMap map_Variables = new HashMap();
	
	public HashMap getMap_Imagenes() {
		return map_Imagenes;
	}
	public ArrayList getArr_Attach() {
		return arr_Attach;
	}
	
	public void addTo_Address(String address){
		if (address!=null){
			address.replaceAll(";", ",");
		}
		String[] to = address.split(",");
		for (int i=0; i<to.length;i++){
			if ((to[i]!=null) && (to[i].trim().length()>0)){
				arr_To_Address.add(to[i]);
			}
		
		}

	}
	
	public void addTo_AddressCC(String address){
		if (address!=null){
			address.replaceAll(";", ",");
		}
		String[] to = address.split(",");
		for (int i=0; i<to.length;i++){
			if ((to[i]!=null) && (to[i].trim().length()>0)){
				arr_To_AddressCC.add(to[i]);
			}
			
		}
	}
	
	public void addTo_AddressBCC(String address){
		if (address!=null){
			address.replaceAll(";", ",");
		}
		String[] to = address.split(",");
		for (int i=0; i<to.length;i++){
			if ((to[i]!=null) && (to[i].trim().length()>0)){
				arr_To_AddressBCC.add(to[i]);
			}
			
		}
	}
	
	
	/**
	 * Limpia los arreglos que contienen las cuentas de correo de destinos, copia y ocultas
	 */
	public void clean_Address(){
		arr_To_AddressBCC.clear();
		arr_To_Address.clear();
		arr_To_AddressCC.clear();
	}

	/**
	 * <p>Cotniene el hash de imagenes, contiene los  CID de una imagen. 
	 * Cuando se desea incrustar una imagen en el HTML se debe indicar en el siguiente formato:<b>
	 * <img src="CID:cid_de_la_imagen /></b> 
	 * Donde cid_de_la_imagen es un nombre aleatoria que le das para identificarla. La llave debe indicar
	 * el nombre de la variable como se ha puesto en el body del correo y el valor indica el contenido de tal variable.
	 * 
	 * Para agregar imagenes a la tabla utilice el método addVar </p>
	 * 
	 * <p> Ejemplo:
	 *  <img src="CID:cidimage01" /></p>
	 *  
	 * 
	 * **/
	private HashMap map_Imagenes = new HashMap();
	
	
	/**
	 * <p>Contiene un arreglo con todos los archivos que el usuario desea adjuntar al correo, 
	 * cada registro debe indicar el path de donde se va a tomar el archivo.
	 * </p>
	 * 
	 * <p> Ejemplo:
	 *  /temp/bitacoraconsultarespuestasasar.gif</p>
	 *  
	 * 
	 * **/
	private ArrayList arr_Attach = new ArrayList();
	
	/**
	 * Agrega una imagen a la tabla de imagenes
	 * @param key
	 * @param value
	 */

	public void addImage(String key, String value){
		map_Imagenes.put(key, value);
	}
	/**
	 * @param key
	 * @param value
	 */
	public void addVar(String key, String value){
		addVIDEmail("vid:"+key, value); 
		
	}
	
	/**
	 * Añade al mensaje un vid:name utilizado para reemplazar variables en el
	 * cuerpo de correo a enviar
	 * 
	 * @param vidname
	 *            identificador que se le da a la variable. suele ser un string
	 *            generado aleatoriamente.
	 * @param valor
	 *            indica el contenido cde la variable
	 * @throws Exception
	 *             excepcion levantada en caso de error
	 */
	private void addVIDEmail(String vidname, String valor)  {
		 this.body =  this.body.replaceAll(vidname, valor);
	}
	
	/**
	 * Limpia las listas de variables, imagenes y attach
	 * @param key
	 * @param value
	 */
	public void clear(){
		map_Imagenes.clear();
		map_Variables.clear();
		arr_Attach.clear();
	}
	
	/**
	 * Agrega el path de un archivo a adjuntar 
	 * @param key
	 * @param value
	 */
	public void addAttach(String path_file){
		arr_Attach.add(path_file);
	}

	/**
	 * @return Returns the bccAddress.
	 */
	public String getBccAddress() {
		return bccAddress;
	}
	/**
	 * @param bccAddress The bccAddress to set.
	 */
	public void setBccAddress(String bccAddress) {
		this.bccAddress = bccAddress;
	}
	/**
	 * Obtiene el cuerpo del correo
	 * @return Returns the body.
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body The body to set.
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * @return Returns the ccAddress.
	 */
	public String getCcAddress() {
		return ccAddress;
	}
	/**
	 * @param ccAddress The ccAddress to set.
	 */
	public void setCcAddress(String ccAddress) {
		this.ccAddress = ccAddress;
	}
	/**
	 * @return Returns the debug.
	 */
//	public boolean isDebug() {
//		//return debug;
//	}
	/**
	 * @param debug The debug to set.
//	 */
//	public void setDebug(boolean debug) {
//		//this.debug = debug;
//	}
	/**
	 * @return Returns the hostSmtp.
	 */
	public String getHostSmtp() {
		return hostSmtp;
	}
	/**
	 * @param hostSmtp The hostSmtp to set.
	 */
	public void setHostSmtp(String hostSmtp) {
		this.hostSmtp = hostSmtp;
	}
	/**
	 * @return Returns the isHTMLFormat.
	 */
	public boolean isHTMLFormat() {
		return isHTMLFormat;
	}
	/**
	 * @param isHTMLFormat The isHTMLFormat to set.
	 */
	public void setHTMLFormat(boolean isHTMLFormat) {
		this.isHTMLFormat = isHTMLFormat;
	}
	/**
	 * @return Returns the senderAddress.
	 */
	public String getSenderAddress() {
		return senderAddress;
	}
	/**
	 * @param senderAddress The senderAddress to set.
	 */
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}
	/**
	 * @return Returns the subject.
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject The subject to set.
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return Returns the toAddress.
	 */
//	public String getToAddress() {
//		return toAddress;
//	}
	/**
	 * @param toAddress The toAddress to set.
	 */
	public void setToAddress(String toAddress) {
		arr_To_Address.clear();
		arr_To_Address.add(toAddress);
		//this.toAddress = toAddress;
	}
	
	
	/**
	 * Envia el correo configurado y devuelve el mensaje el estatus
	 * del envio
	 **/
	public void sendMail(){
		
	}
	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return Returns the tipoServidorCorreo.
	 */
	public String getTipoServidorCorreo() {
		return tipoServidorCorreo;
	}
	/**
	 * @param tipoServidorCorreo The tipoServidorCorreo to set.
	 */
	//public void setTipoServidorCorreo(String tipoServidorCorreo) {
	//	this.tipoServidorCorreo = tipoServidorCorreo;
	//}
	/**
	 * @return Returns the user.
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user The user to set.
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return Returns the auth.
	 */
	public boolean isAuth() {
		return auth;
	}
	/**
	 * @param auth The auth to set.
	 */
	public void setAuth(boolean auth) {
		this.auth = auth;
	}
	/**
	 * @return Returns the port.
	 */
	public String getPort() {
		return port;
	}
	/**
	 * @param port The port to set.
	 */
	public void setPort(String port) {
		this.port = port;
	}
	/**
	 * @return Returns the startTls.
	 */
	public boolean isStartTls() {
		return startTls;
	}
	/**
	 * @param startTls The startTls to set.
	 */
	public void setStartTls(boolean startTls) {
		this.startTls = startTls;
	}
	/**
	 * @return Returns the userMail.
	 */
	public String getUserMail() {
		return userMail;
	}
	/**
	 * @param userMail The userMail to set.
	 */
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	/**
	 * @return the mail_smtp_starttls_enable
	 */
	public String getMail_smtp_starttls_enable() {
		return mail_smtp_starttls_enable;
	}
	/**
	 * @return the mail_smtp_auth
	 */
	public String getMail_smtp_auth() {
		return mail_smtp_auth;
	}
	/**
	 * @return the mail_smtp_socketFactory_port
	 */
	public String getMail_smtp_socketFactory_port() {
		return mail_smtp_socketFactory_port;
	}
	/**
	 * @return the mail_smtp_socketFactory_class
	 */
	public String getMail_smtp_socketFactory_class() {
		return mail_smtp_socketFactory_class;
	}
	/**
	 * @return the mail_smtp_socketFactory_fallbackE
	 */
	public String getMail_smtp_socketFactory_fallbackE() {
		return mail_smtp_socketFactory_fallbackE;
	}
	/**
	 * @return the mail_transport_protocol
	 */
	public String getMail_transport_protocol() {
		return mail_transport_protocol;
	}
	/**
	 * @return the mail_host
	 */
	public String getMail_host() {
		return mail_host;
	}
	/**
	 * @return the mail_user
	 */
	public String getMail_user() {
		return mail_user;
	}
	/**
	 * @return the mail_smtp_user
	 */
	public String getMail_smtp_user() {
		return mail_smtp_user;
	}
	/**
	 * @return the mail_password
	 */
	public String getMail_password() {
		return mail_password;
	}
	/**
	 * @return the mail_smtp_port
	 */
	public String getMail_smtp_port() {
		return mail_smtp_port;
	}
	/**
	 * @param mailSmtpStarttlsEnable the mail_smtp_starttls_enable to set
	 */
	public void setMail_smtp_starttls_enable(String mailSmtpStarttlsEnable) {
		mail_smtp_starttls_enable = mailSmtpStarttlsEnable;
	}
	/**
	 * @param mailSmtpAuth the mail_smtp_auth to set
	 */
	public void setMail_smtp_auth(String mailSmtpAuth) {
		mail_smtp_auth = mailSmtpAuth;
	}
	/**
	 * @param mailSmtpSocketFactoryPort the mail_smtp_socketFactory_port to set
	 */
	public void setMail_smtp_socketFactory_port(String mailSmtpSocketFactoryPort) {
		mail_smtp_socketFactory_port = mailSmtpSocketFactoryPort;
	}
	/**
	 * @param mailSmtpSocketFactoryClass the mail_smtp_socketFactory_class to set
	 */
	public void setMail_smtp_socketFactory_class(String mailSmtpSocketFactoryClass) {
		mail_smtp_socketFactory_class = mailSmtpSocketFactoryClass;
	}
	/**
	 * @param mailSmtpSocketFactoryFallbackE the mail_smtp_socketFactory_fallbackE to set
	 */
	public void setMail_smtp_socketFactory_fallbackE(
			String mailSmtpSocketFactoryFallbackE) {
		mail_smtp_socketFactory_fallbackE = mailSmtpSocketFactoryFallbackE;
	}
	/**
	 * @param mailTransportProtocol the mail_transport_protocol to set
	 */
	public void setMail_transport_protocol(String mailTransportProtocol) {
		mail_transport_protocol = mailTransportProtocol;
	}
	/**
	 * @param mailHost the mail_host to set
	 */
	public void setMail_host(String mailHost) {
		mail_host = mailHost;
	}
	/**
	 * @param mailUser the mail_user to set
	 */
	public void setMail_user(String mailUser) {
		mail_user = mailUser;
	}
	/**
	 * @param mailSmtpUser the mail_smtp_user to set
	 */
	public void setMail_smtp_user(String mailSmtpUser) {
		mail_smtp_user = mailSmtpUser;
	}
	/**
	 * @param mailPassword the mail_password to set
	 */
	public void setMail_password(String mailPassword) {
		mail_password = mailPassword;
	}
	/**
	 * @param mailSmtpPort the mail_smtp_port to set
	 */
	public void setMail_smtp_port(String mailSmtpPort) {
		mail_smtp_port = mailSmtpPort;
	}
	/**
	 * @return the mail_from
	 */
	public String getMail_from() {
		return mail_from;
	}
	/**
	 * @param mailFrom the mail_from to set
	 */
	public void setMail_from(String mailFrom) {
		mail_from = mailFrom;
	}
	/**
	 * @return the withDebug
	 */
	public boolean isWithDebug() {
		return withDebug;
	}
	/**
	 * @param withDebug the withDebug to set
	 */
	public void setWithDebug(boolean withDebug) {
		this.withDebug = withDebug;
	}
}//fin de la clase
