/*
 * Created on Aug 4, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.innovargia.mail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author aruaro
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class HTMLMail {

	/**
	 * Algunos mensajes de error
	 */
	public static String ERROR_01_LOADFILE = "Error al cargar el archivo...";
	public static String ERROR_02_SENDMAIL = "Error al enviar el mail...";

	/**
	 * Constructor por defecto
	 */
	public HTMLMail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private static void debug(String mensaje) {
		System.out.println("HTMLMail:"+ mensaje);
	}// fin de debug

	private Properties props = new Properties();

	/**
	 * Propiedades para el envio del correo
	 */
	private EmailProperties emailProperties = new EmailProperties();

	/**
	 * MultiPart para crear mensajes compuestos
	 */
	MimeMultipart multipart = new MimeMultipart("related");

	/**
	 * Obtiene las propiedades del correo
	 * 
	 * @return Returns the emailProperties.
	 */
	public EmailProperties getEmailProperties() {
		return emailProperties;
	}

	/**
	 * Ajusta las propiedades del correo
	 * 
	 * @param emailProperties
	 *            The emailProperties to set.
	 */
	public void setEmailProperties(EmailProperties emailProperties) {
		this.emailProperties = emailProperties;
	}

	/**
	 * Constructor, inicializa las propiedades
	 * 
	 * @param EmailProperties
	 *            emailProperties contiene las propiedades del email
	 *            configuradas
	 * @param user
	 *            usuario de correo
	 * @param password
	 *            password del usuario
	 */
	public HTMLMail(EmailProperties emailProperties) {
		this.setProperties(emailProperties);
	}

	/**
	 * Inicializa los datos de propiedades del correo, servidor, host,
	 * protocolo, user, pass, etc
	 * 
	 * @param EmailProperties
	 *            emailProperties contiene las propiedades del email
	 *            configuradas
	 * @param user
	 *            usuario de correo
	 * @param password
	 *            password del usuario
	 */
	private void setProperties(EmailProperties emailProperties) {

		this.emailProperties = emailProperties;

		props = new Properties();
		props.setProperty("mail.transport.protocol", emailProperties
				.getMail_transport_protocol());
		props.setProperty("mail.host", emailProperties.getMail_host());
		props.setProperty("mail.user", emailProperties.getMail_user());
		props.setProperty("mail.password", emailProperties.getMail_password());

		if (emailProperties.getMail_smtp_user() != null) {
			props.setProperty("mail.smtp.user", emailProperties
					.getMail_smtp_user());
		}

		// TLS si está disponible
		if (emailProperties.getMail_smtp_starttls_enable() != null) {
			props.setProperty("mail.smtp.starttls.enable", emailProperties
					.getMail_smtp_starttls_enable());
		}
		if (emailProperties.getMail_smtp_auth() != null) {
			props.setProperty("mail.smtp.auth", emailProperties
					.getMail_smtp_auth());
		}

		if (emailProperties.getMail_smtp_socketFactory_class() != null) {
			props.setProperty("mail.smtp.socketFactory.class", emailProperties
					.getMail_smtp_socketFactory_class());
		}
		if (emailProperties.getMail_smtp_socketFactory_fallbackE() != null) {
			props.setProperty("mail.smtp.socketFactory.fallback",
					emailProperties.getMail_smtp_socketFactory_fallbackE());
		}
		if (emailProperties.getMail_smtp_socketFactory_port() != null) {
			props.setProperty("mail.smtp.socketFactory.port", emailProperties
					.getMail_smtp_socketFactory_port());
		}

	}

	/**
	 * Carga el contenido de un fichero de texto HTML en un String
	 * 
	 * @param pathname
	 *            ruta del fichero
	 * @return un String con el contenido del fichero
	 * @throws Exception
	 *             Excepcion levantada en caso de error
	 */
	static public String loadHTMLFile(String pathname) throws Exception {
		String content = "";
		File f = null;
		BufferedReader in = null;
		try {
			f = new File(pathname);
			if (f.exists()) {
				long len_bytes = f.length();
				debug("loadHTMLFile->pathname:" + pathname + ", len:"
						+ len_bytes);
			}
			in = new BufferedReader(new FileReader(f));
			String str;
			while ((str = in.readLine()) != null) {

				str = str.trim();
				content = content + str;
			}
			in.close();
			return content;
		} catch (Exception e) {
			String MENSAJE_ERROR = ERROR_01_LOADFILE + ": ['" + pathname
					+ "'] : " + e.toString();
			throw new Exception(MENSAJE_ERROR);
		} finally {
			if (in != null)
				in.close();
		}
	}

	/**
	 * Añade el contenido base al multipart
	 * 
	 * @throws Exception
	 *             Excepcion levantada en caso de error
	 */
	public void addContentToMultipart() throws Exception {
		// first part (the html)
		BodyPart messageBodyPart = new MimeBodyPart();
		String htmlText = emailProperties.getBody().toString();
		messageBodyPart.setContent(htmlText, "text/html");
		// add it
		this.multipart.addBodyPart(messageBodyPart);
	}

	/**
	 * Añade el contenido base al multipart
	 * 
	 * @param htmlText
	 *            contenido html que se muestra en el mensaje de correo
	 * @throws Exception
	 *             Excepcion levantada en caso de error
	 */
	public void addContent() throws Exception {
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(emailProperties.getBody().toString(),
				"text/html");
		this.multipart.addBodyPart(messageBodyPart);
	}

	/**
	 * Agrega un attachement al mensaje de email
	 * 
	 * @param pathname
	 *            ruta del fichero
	 * @throws Exception
	 *             excepcion levantada en caso de error
	 */
	private void addAttachEmail(String pathname) throws Exception {
	  
	    File file = new File(pathname);
	    if( file.exists() ){
		  BodyPart messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource( pathname );
                messageBodyPart.setDataHandler( new DataHandler(source) );
                messageBodyPart.setFileName( file.getName() );
                this.multipart.addBodyPart(messageBodyPart);
             }
		/*File file = new File(pathname);
		BodyPart messageBodyPart = new MimeBodyPart();

		DataSource ds = new FileDataSource(file);
		messageBodyPart.setDataHandler(new DataHandler(ds));
		messageBodyPart.setFileName(file.getName());
		messageBodyPart.setDisposition(Part.ATTACHMENT);
		messageBodyPart.setText("This is part one of a test multipart e-mail." +
                  "The second part is file as an attachment");
		
		BodyPart bodyText = new MimeBodyPart();
        	bodyText.setText("Este es el cuerpo el correo.");
        
        	this.multipart.addBodyPart(bodyText);
		this.multipart.addBodyPart(messageBodyPart);*/
	    
	}

	/**
	 * Añade al mensaje un cid:name utilizado para guardar las imagenes
	 * referenciadas en el HTML de la forma <img src=cid:name />
	 * 
	 * @param cidname
	 *            identificador que se le da a la imagen. suele ser un string
	 *            generado aleatoriamente.
	 * @param pathname
	 *            ruta del fichero que almacena la imagen
	 * @throws Exception
	 *             excepcion levantada en caso de error
	 */
	public void addCIDEmail(String cidname, String pathname) throws Exception {
		DataSource fds = new FileDataSource(pathname);
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setDataHandler(new DataHandler(fds));
		messageBodyPart.setHeader("Content-ID", "<" + cidname + ">");
		this.multipart.addBodyPart(messageBodyPart);
	}

	/**
	 * Añade al mensaje un cid:name utilizado para guardar las imagenes
	 * referenciadas en el HTML de la forma <img src=cid:name />
	 * 
	 * @param cidname
	 *            identificador que se le da a la imagen. suele ser un string
	 *            generado aleatoriamente.
	 * @param pathname
	 *            ruta del fichero que almacena la imagen
	 * @throws Exception
	 *             excepcion levantada en caso de error
	 */
	public void addCID(String cidname, String pathname) throws Exception {
		// addCIDEmail(cidname, pathname);
		// emailProperties.addImage(cidname, pathname);

	}

	/**
	 * Agrega un attachement al mensaje de email
	 * 
	 * @param pathname
	 *            ruta del fichero
	 * @throws Exception
	 *             excepcion levantada en caso de error
	 */
	public void addAttach(String pathname) throws Exception {
		emailProperties.addAttach(pathname);
	}

	/**
	 * Envia un correo simple de texto sin ningun formato
	 * 
	 * @throws Exception
	 *             Excepcion levantada en caso de error
	 */
	public void send(boolean sendMultipart, boolean withDebug) throws Exception {
		try {
			
			Properties props = new Properties(); 
			props.put("mail.smtp.user", emailProperties.getMail_user());
			props.put("mail.smtp.password", emailProperties.getMail_password());
			props.put("mail.smtp.host", emailProperties.getMail_host());
			props.put("mail.smtp.mail.sender",emailProperties.getMail_from());  
			props.put("mail.smtp.port", emailProperties.getMail_smtp_port());
			props.put("mail.smtp.starttls.enable",  emailProperties.getMail_smtp_starttls_enable() );
			props.put("mail.smtp.auth",emailProperties.getMail_smtp_auth());
			props.put("mail.smtp.debug", withDebug+"");
			props.put("mail.smtp.socketFactory.port", emailProperties.getMail_smtp_socketFactory_port());
			props.put("mail.smtp.socketFactory.class",  emailProperties.getMail_smtp_socketFactory_class());
			props.put("mail.smtp.socketFactory.fallback", emailProperties.getMail_smtp_socketFactory_fallbackE());

			
			Session mailSession = Session.getDefaultInstance(props,null);//this.props, null);
			//mailSession.setDebug(withDebug);
			// Transport transport = mailSession.getTransport();
			Transport transport = mailSession.getTransport(emailProperties
					.getMail_transport_protocol());

			MimeMessage message = new MimeMessage(mailSession);
			message.setSubject(emailProperties.getSubject());
			message
					.setFrom(new InternetAddress(emailProperties.getMail_from(),"Solicitud Revision Documento"));
			// Crea el arreglo de destinatarios, copias y copias ocultas
			message.addRecipients(Message.RecipientType.TO,
					getRecipients(emailProperties.arr_To_Address));
			message.addRecipients(Message.RecipientType.CC,
					getRecipients(emailProperties.arr_To_AddressCC));
			message.addRecipients(Message.RecipientType.BCC,
					getRecipients(emailProperties.arr_To_AddressBCC));

			/*** Agrega las variables al cuerpo ***/
			String clave = null;
			String valor = null;

			// Imagenes
			if (emailProperties.getMap_Imagenes().size() > 0) {
				// Barre el hasmap de imagenes y las agrega a la cadena
				for (Iterator it = emailProperties.getMap_Imagenes().keySet()
						.iterator(); it.hasNext();) {
					clave = (String) it.next();
					valor = (String) emailProperties.getMap_Imagenes().get(
							clave);
					addCIDEmail(clave, valor);
				}
			}

			// Archivos adjuntos
			if (emailProperties.getArr_Attach().size() > 0) {
				// Barre el array
				for (int i = 0; i < emailProperties.getArr_Attach().size(); i++) {
					valor = (String) emailProperties.getArr_Attach().get(i);
					addAttachEmail(valor);
				}
			}
			
			message.setContent(emailProperties.getBody().toString(),
					"text/html");
			
			/***/
			if (sendMultipart) {
				message.setContent(multipart);
			}

			//transport.connect();
			message.saveChanges(); // don't forget this
			transport.connect(emailProperties.getMail_host(),
					emailProperties.getMail_user(),
					emailProperties.getMail_password());
			
			// transport.sendMessage(message, message
			// .getRecipients(Message.RecipientType.TO));
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

		} catch (Exception e) {
			String MENSAJE_ERROR = ERROR_02_SENDMAIL + " : " + e.toString();
			throw new Exception(MENSAJE_ERROR);
		}
	}
	
	/**
	 * Envia un correo simple de texto sin ningun formato
	 * 
	 * @throws Exception
	 *             Excepcion levantada en caso de error
	 */
	public void sendMail(boolean sendMultipart, boolean withDebug, String usuarioenvia) throws Exception {
		try {
			
			Properties props = new Properties(); 
			props.put("mail.smtp.user", emailProperties.getMail_user());
			props.put("mail.smtp.password", emailProperties.getMail_password());
			props.put("mail.smtp.host", emailProperties.getMail_host());
			props.put("mail.smtp.mail.sender",emailProperties.getMail_from());  
			props.put("mail.smtp.port", emailProperties.getMail_smtp_port());
			props.put("mail.smtp.starttls.enable",  emailProperties.getMail_smtp_starttls_enable() );
			props.put("mail.smtp.auth",emailProperties.getMail_smtp_auth());
			props.put("mail.smtp.debug", withDebug+"");
			props.put("mail.smtp.socketFactory.port", emailProperties.getMail_smtp_socketFactory_port());
			props.put("mail.smtp.socketFactory.class",  emailProperties.getMail_smtp_socketFactory_class());
			props.put("mail.smtp.socketFactory.fallback", emailProperties.getMail_smtp_socketFactory_fallbackE());

			
			Session mailSession = Session.getDefaultInstance(props,null);//this.props, null);
			//mailSession.setDebug(withDebug);
			// Transport transport = mailSession.getTransport();
			Transport transport = mailSession.getTransport(emailProperties
					.getMail_transport_protocol());

			MimeMessage message = new MimeMessage(mailSession);
			message.setSubject(emailProperties.getSubject());
			message
					.setFrom(new InternetAddress(emailProperties.getMail_from(),usuarioenvia));
			// Crea el arreglo de destinatarios, copias y copias ocultas
			message.addRecipients(Message.RecipientType.TO,
					getRecipients(emailProperties.arr_To_Address));
			message.addRecipients(Message.RecipientType.CC,
					getRecipients(emailProperties.arr_To_AddressCC));
			message.addRecipients(Message.RecipientType.BCC,
					getRecipients(emailProperties.arr_To_AddressBCC));

			/*** Agrega las variables al cuerpo ***/
			String clave = null;
			String valor = null;

			// Imagenes
			if (emailProperties.getMap_Imagenes().size() > 0) {
				// Barre el hasmap de imagenes y las agrega a la cadena
				for (Iterator it = emailProperties.getMap_Imagenes().keySet()
						.iterator(); it.hasNext();) {
					clave = (String) it.next();
					valor = (String) emailProperties.getMap_Imagenes().get(
							clave);
					addCIDEmail(clave, valor);
				}
			}

			// Archivos adjuntos
			if (emailProperties.getArr_Attach().size() > 0) {
				// Barre el array
				for (int i = 0; i < emailProperties.getArr_Attach().size(); i++) {
					valor = (String) emailProperties.getArr_Attach().get(i);
					addAttachEmail(valor);
				}
			}
			
			message.setContent(emailProperties.getBody().toString(),
					"text/html");
			
			/***/
			if (sendMultipart) {
				message.setContent(multipart);
			}

			//transport.connect();
			message.saveChanges(); // don't forget this
			transport.connect(emailProperties.getMail_host(),
					emailProperties.getMail_user(),
					emailProperties.getMail_password());
			
			// transport.sendMessage(message, message
			// .getRecipients(Message.RecipientType.TO));
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

		} catch (Exception e) {
			String MENSAJE_ERROR = ERROR_02_SENDMAIL + " : " + e.toString();
			throw new Exception(MENSAJE_ERROR);
		}
	}

	private InternetAddress[] getRecipients(ArrayList arr) throws Exception {
		InternetAddress[] arr_address = new InternetAddress[arr.size()];
		for (int i = 0; i < arr.size(); i++) {
			arr_address[i] = new InternetAddress((String) arr.get(i));
		}
		return arr_address;
	}

	/**
	 * @param userName
	 * @param passWord
	 * @param host
	 * @param port
	 * @param starttls
	 * @param auth
	 * @param debug
	 * @param socketFactoryClass
	 * @param fallback
	 * @param to
	 * @param cc
	 * @param bcc
	 * @param subject
	 * @param text
	 * @return
	 */
	public boolean sendMail(String userName, String passWord, String host,
			String port, String starttls, String auth, boolean debug,
			String socketFactoryClass, String fallback, String[] to,
			String[] cc, String[] bcc, String subject, String text, String from) {

		debug("[userName:" +userName+
				",  passWord:"+passWord+
				",  host:"+host+
				",  port:"+port+
				",  starttls:"+starttls+
				",  auth:"+auth+
				",  debug:"+debug+
				",  socketFactoryClass:"+socketFactoryClass+
				",  fallback:"+fallback+
				",  to:"+to+
				",  cc:"+cc+
				",  bcc:"+bcc+
				",  subject:"+subject+
				",  text:"+text+
				",  from:" +from + "]"
				);
		
		
		Properties props = new Properties();

		// Properties props=System.getProperties();
		props.put("mail.smtp.user", userName);
		props.put("mail.smtp.host", host);
		if (!"".equals(port))
			props.put("mail.smtp.port", port);
		
		if (!"".equals(starttls))
			props.put("mail.smtp.starttls.enable", starttls);

		props.put("mail.smtp.auth", auth);
		if (debug) {
			props.put("mail.smtp.debug", "true");
		} else {
			props.put("mail.smtp.debug", "false");
		}
		

		if (!"".equals(port))
			props.put("mail.smtp.socketFactory.port", port);


		if (!"".equals(socketFactoryClass))
			props.put("mail.smtp.socketFactory.class", socketFactoryClass);

		
		if (!"".equals(fallback))
			props.put("mail.smtp.socketFactory.fallback", fallback);

		try {
			Session session = Session.getDefaultInstance(props, null);
			session.setDebug(debug);
			MimeMessage msg = new MimeMessage(session);

			
			
			//msg.setText(text);
			msg.setContent(text, "text/html");
			msg.setSubject(subject);
			msg.setFrom(new InternetAddress(from, "Solicitud Revision Documento"));

			if (to!=null){
				for (int i = 0; i < to.length; i++) {
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
						to[i]));
				}
			}
			if (cc!=null){
				for (int i = 0; i < cc.length; i++) {
					msg.addRecipient(Message.RecipientType.CC, new InternetAddress(
						cc[i]));
				}
			}
			if (bcc!=null){
				for (int i = 0; i < bcc.length; i++) {
					msg.addRecipient(Message.RecipientType.BCC,
						new InternetAddress(bcc[i]));
				}
			}
			msg.saveChanges();

			Transport transport = session.getTransport("smtp");
			transport.connect(host, userName, passWord);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			return true;

		} catch (Exception mex) {

			debug("Exception email: " + mex.getMessage());
			

		}
		return false;
		

	}
	
	public boolean sendMailAttach(String userName,
			String passWord, String host, String port, String starttls,
			String auth, boolean debug, String socketFactoryClass,
			String fallback, String[] to, String[] cc, String[] bcc,
			String subject, String text) {

		Properties props = new Properties();

		// Properties props=System.getProperties();

		props.put("mail.smtp.user", userName);

		props.put("mail.smtp.host", host);

		if (!"".equals(port))

			props.put("mail.smtp.port", port);

		if (!"".equals(starttls))

			props.put("mail.smtp.starttls.enable", starttls);

		props.put("mail.smtp.auth", auth);

		if (debug) {

			props.put("mail.smtp.debug", "true");

		} else {

			props.put("mail.smtp.debug", "false");

		}

		if (!"".equals(port))

			props.put("mail.smtp.socketFactory.port", port);

		if (!"".equals(socketFactoryClass))

			props.put("mail.smtp.socketFactory.class", socketFactoryClass);

		if (!"".equals(fallback))

			props.put("mail.smtp.socketFactory.fallback", fallback);

		try

		{

			Session session = Session.getDefaultInstance(props, null);

			session.setDebug(debug);

			MimeMessage msg = new MimeMessage(session);

			msg.setContent(text, "text/html");
			//msg.setText(text);

			msg.setSubject(subject);

			msg.setFrom(new InternetAddress("ragenet@sistema.com"));

			for (int i = 0; i < to.length; i++) {

				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
						to[i]));

			}

			for (int i = 0; i < cc.length; i++) {

				msg.addRecipient(Message.RecipientType.CC, new InternetAddress(
						cc[i]));

			}

			for (int i = 0; i < bcc.length; i++) {

				msg.addRecipient(Message.RecipientType.BCC,
						new InternetAddress(bcc[i]));

			}

			msg.saveChanges();

			Transport transport = session.getTransport("smtp");

			transport.connect(host, userName, passWord);

			transport.sendMessage(msg, msg.getAllRecipients());

			transport.close();

			return true;

		}

		catch (Exception mex)

		{

			mex.printStackTrace();

			return false;

		}

	}
}
