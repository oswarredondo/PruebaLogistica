package com.administracion.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.dto.DocumentoJson;
import com.administracion.ibo.INotificacionEmailBO;
import com.administracion.ibo.IParamsSistemaBO;
import com.administracion.idao.INotificacionesEmailDAO;
import com.administracion.notificacionemail.dto.NotificacionEmailDTO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.mail.EmailProperties;
import com.innovargia.mail.HTMLMail;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.dtos.DocumentoDTO;

@Service
public class NotificacionEmailBO implements INotificacionEmailBO {
	private static final Logger logger = LoggerFactory.getLogger(NotificacionEmailBO.class);

	@Autowired
	INotificacionesEmailDAO iNotificacionesEmailDAO;

	@Autowired
	IParamsSistemaBO iParamsSistemaBO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.administracion.bo.INotificacionEmailBO#sendEnvioNotificacionEmail()
	 */
	@Override
	public void sendEnvioNotificacionEmail() throws Exception {

		HashMap<String, NotificacionEmailDTO> map_clientes = new HashMap<String, NotificacionEmailDTO>();
		EmailProperties email_propiedades = iParamsSistemaBO.getPropiedadesEmail(null, ConstantesGenerales.ID_APP_MAIL);
		List<SistemaDTO> prop_sistema = iParamsSistemaBO.getRegistros(ConstantesGenerales.ID_SKY4SOL);

		List<DocumentoJson> lista = iNotificacionesEmailDAO.getEnviosANotificar();
		logger.debug("Procesando " + lista.size() + " para notificación.");
		NotificacionEmailDTO notificacionEmailDTO = new NotificacionEmailDTO();
		for (DocumentoJson obj_json : lista) {
			Gson gson = new Gson();
			JsonParser parser = new JsonParser();
			JsonArray jArray = parser.parse("[" + obj_json.getJsondata() + "]").getAsJsonArray();
			String iddocumento = obj_json.getIddocumento();
			
			List<Envio> lcs = new ArrayList<Envio>();
			DocumentoDTO documento = new DocumentoDTO();
			String plantilla = "";
			String subject = "";
			for (JsonElement obj : jArray) {
				Envio cse = gson.fromJson(obj, Envio.class);
				documento.datosCarta = cse;
				documento.datosCarta.setIdEnvio(iddocumento);
				logger.debug("Correo a notificar:" + documento.datosCarta.destinatario.getCorreoe() + ", con guia:"
						+ documento.getIdEnvio());
				if ((documento.datosCarta.destinatario.getCorreoe() != null)
						&& (!documento.datosCarta.destinatario.getCorreoe().isEmpty())) {

					if (map_clientes.containsKey(documento.datosCarta.getNumCliente())) {
						notificacionEmailDTO = map_clientes.get(documento.datosCarta.getNumCliente());
					} else {
						notificacionEmailDTO = iNotificacionesEmailDAO
								.getDatosEnvioNotificacionConfiguracion(documento.datosCarta.getNumCliente());
						if (notificacionEmailDTO!=null){
							map_clientes.put(documento.datosCarta.getNumCliente(), notificacionEmailDTO);
						}
						

					}
					// Verifica si se manda el correo
					if (notificacionEmailDTO != null) {
						plantilla = notificacionEmailDTO.replaceDatos(cse.getIdEnvio(),
								documento.datosCarta.remitente.getRazonSocial(),
								documento.datosCarta.remitente.getAtencion(),
								documento.datosCarta.destinatario.getRazonSocial(),
								documento.datosCarta.destinatario.getAtencion());
						notificacionEmailDTO.setSubject(notificacionEmailDTO.getSubject().replaceAll("@IDGUIA", cse.getIdEnvio()));
						if (!plantilla.isEmpty()) {
							enviaCorreo(documento.datosCarta.destinatario.getCorreoe(), plantilla, prop_sistema,
									notificacionEmailDTO, email_propiedades);
							
							// Actualiza el registro para que no sea procesado nuevamente
							iNotificacionesEmailDAO.updateSeEnvioNotificacion(cse.getIdEnvio());
						}
					}
				}else{
					// Actualiza el registro para que no sea procesado nuevamente
					iNotificacionesEmailDAO.updateSeEnvioNotificacion(cse.getIdEnvio());
				}

				

			}

		}

	}

	private void enviaCorreo(String email, String plantilla, List<SistemaDTO> prop_sistema,
			NotificacionEmailDTO notificacionEmailDTO, EmailProperties email_propiedades) {
		try {
			String from_email = notificacionEmailDTO.getEmaill_from();
			String subject_email = notificacionEmailDTO.getSubject();
			email_propiedades.setSubject(subject_email);
			email_propiedades.setMail_from(from_email);

			List<String> lista_email = new ArrayList<String>();
			lista_email.add(email);
			email_propiedades.arr_To_Address.add(email);

			email_propiedades.setBody(plantilla);

			

			final String username = email_propiedades.getMail_user();
			final String password = email_propiedades.getMail_password();

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", email_propiedades.getMail_host());
			props.put("mail.smtp.port", email_propiedades.getMail_smtp_port());

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("notificacion@envios.com"));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				message.setSubject(subject_email);
				message.setContent(plantilla, "text/html");
					

				Transport.send(message);

				logger.debug("Notificacion enviada a :" + email);

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}

		} catch (Exception e){
			logger.debug("Error en el envio de correo:" + e.getMessage());
		}
	}

}
