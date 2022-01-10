package com.email.tracusa.logistica.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.email.tracusa.logistica.idao.IConexionDAOJDBC;
import com.email.tracusa.logistica.idao.IEmailDAO;

import net.sf.jasperreports.engine.JRException;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;

@Component
public class EmailTask {

	private static final Logger logger = LoggerFactory.getLogger(EmailTask.class);

	final private Properties properties = new Properties();

	@Autowired
	private IConexionDAOJDBC iReportesDAOJDBC;

	@Autowired
	private IEmailDAO iEmailDAO;

	@Value("${mail.smtp.auth}")
	private String auth;

	@Value("${mail.smtp.starttls.enable}")
	private String starttls;

	@Value("${mail.smtp.host}")
	private String host;

	@Value("${mail.smtp.port}")
	private String port;

	@Value("${mail.email}")
	private String email;

	@Value("${mail.password}")
	private String password;

	@Value("${mail.body}")
	private String body;

	@Value("${mail.body.image}")
	private String image;

	@Value("${mail.report.xls.path}")
	private String xlsFile;

	@Value("${mail.report.jasper.path}")
	private String jasperFile;

	@Value("${mail.path}")
	private String emailPath;
	
	//@Scheduled(fixedDelay = 86400000 )
	@Scheduled(cron = "0 0 17 ? * * ")
	public void sendEmailReportePeps() throws Exception {

		logger.info("EMPIEZA REPORTE PEPS");

		properties.put("mail.smtp.auth", auth);

		properties.put("mail.smtp.starttls.enable", starttls);

		properties.put("mail.smtp.host", host);

		properties.put("mail.smtp.port", port);

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});

		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(email, false));

			// Obtenemos todos loc correos del perfil deseado en BD
			List<String> emails = iEmailDAO.getUsuarios("OPER");

			// Separamos los correos por coma
			 String toMails = StringUtils.join(emails, ',');
			//String toMails = "oswaldoarredondo@tracusa.com.mx";

			InternetAddress[] parseMails = InternetAddress.parse(toMails, true);
			message.setRecipients(Message.RecipientType.TO, parseMails);
			message.setSubject("Reporte de Guías Almacén Peps");

			// El HTML se divide en 2 partes. el BODY y las IMEGENES ADJUNTAS
			MimeMultipart multipart = new MimeMultipart("related");

			// Aqui empeiza la primera parte el HTML
			BodyPart messageBodyPart = new MimeBodyPart();
			InputStream html = new FileInputStream(body);
			String content = IOUtils.toString(html);
			content = content.replaceAll("NOMBREREPORTE", "GU&Iacute;AS NO ENTREGADAS");
			content = content.replaceAll("TIEMPO", "3 meses");
			messageBodyPart.setContent(content, "text/html; charset=utf-8");

			// Agregamos la primera parte al correo creado en multiparte
			multipart.addBodyPart(messageBodyPart);

			// Aqui empieza la segunda parte las IMAGENES ADJUTNAS
			messageBodyPart = new MimeBodyPart();
			
			// Se agrega la imagen en JPG, en PNG no funciona bien
			DataSource fds = new FileDataSource(image);
			messageBodyPart.setDataHandler(new DataHandler(fds));
			
			// Aqui asignamos la imagen a el id puesto en el apartado SRC de la
			// etiqueta <IMAGEN> en el HTML
			messageBodyPart.setHeader("Content-ID", "<logoTRSL>");

			// Añadimos la segunda parte
			multipart.addBodyPart(messageBodyPart);

			// Añadimos el archivo adjunto EL REPORTE
			MimeBodyPart attachPart = new MimeBodyPart();

			createReportByJasper("Reporte_Peps");

			attachPart.attachFile(xlsFile.replace("ReportName", "Reporte_Peps"));
			multipart.addBodyPart(attachPart);

			// Mezclamos todo en una parte en el correo
			message.setContent(multipart);

			// Enviamos el correo
			Transport.send(message);

			logger.info("EMPIEZA REPORTE PEPS ENVIADO");

		} catch (MessagingException e) {

			logger.info(e.getMessage());

		}

	}

	@Scheduled(cron = "0 53 11 ? * * ")
	//@Scheduled(fixedDelay = 86400000)
	public void sendEmailAtencionClientes() throws Exception {

		logger.info("EMPIEZA REPORTE ATENCION A CLIENTES");

		properties.put("mail.smtp.auth", auth);

		properties.put("mail.smtp.starttls.enable", starttls);

		properties.put("mail.smtp.host", host);

		properties.put("mail.smtp.port", port);

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});

		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(email, false));

			// Obtenemos todos loc correos del perfil deseado en BD
			List<String> emails = iEmailDAO.getUsuarios("ATC,ATCMTY,ATCGDL,ATCLEN");

			// Separamos los correos por coma
			String toMails = StringUtils.join(emails,',');
			//String toMails = "oswaldoarredondo@tracusa.com.mx";

			InternetAddress[] parseMails = InternetAddress.parse(toMails, true);
			message.setRecipients(Message.RecipientType.TO, parseMails);
			message.setSubject("Reporte de Atención a Clientes");

			// El HTML se divide en 2 partes. el BODY y las IMEGENES ADJUNTAS
			MimeMultipart multipart = new MimeMultipart("related");

			// Aqui empeiza la primera parte el HTML
			BodyPart messageBodyPart = new MimeBodyPart();
			InputStream html = new FileInputStream(body);
			String content = IOUtils.toString(html);
			content = content.replaceAll("NOMBREREPORTE", "REPORTE ATENCI&Oacute;N A CLIENTES");
			content = content.replaceAll("TIEMPO", "45 d&iacute;as");
			messageBodyPart.setContent(content, "text/html; charset=utf-8");

			// Agregamos la primera parte al correo creado en multiparte
			multipart.addBodyPart(messageBodyPart);

			// Aqui empieza la segunda parte las IMAGENES ADJUTNAS
			messageBodyPart = new MimeBodyPart();
			
			// Se agrega la imagen en JPG, en PNG no funciona bien
			DataSource fds = new FileDataSource(image);
			messageBodyPart.setDataHandler(new DataHandler(fds));
			
			// Aqui asignamos la imagen a el id puesto en el apartado SRC de la
			// etiqueta <IMAGEN> en el HTML
			messageBodyPart.setHeader("Content-ID", "<logoTRSL>");

			// Añadimos la segunda parte
			multipart.addBodyPart(messageBodyPart);

			// Añadimos el archivo adjunto EL REPORTE
			MimeBodyPart attachPart = new MimeBodyPart();

			createReportByJasper("R_Atencion_Clientes");

			attachPart.attachFile(xlsFile.replace("ReportName", "R_Atencion_Clientes"));
			multipart.addBodyPart(attachPart);

			// Mezclamos todo en una parte en el correo
			message.setContent(multipart);

			// Enviamos el correo
			Transport.send(message);

			logger.info("REPORTE ATENCION A CLIENTES ENVIADO");

		} catch (MessagingException e) {

			logger.info(e.getMessage());

		}

	}
	
	//@Scheduled(cron = "0 53 11 ? * * ")
	@Scheduled(fixedDelay = 1800000)
	public void sendEmailGuiasErrorUnigis() throws Exception {

		logger.info("EMPIEZA REPORTE GUIAS ERROR UNIGIS");

		properties.put("mail.smtp.auth", auth);

		properties.put("mail.smtp.starttls.enable", starttls);

		properties.put("mail.smtp.host", host);

		properties.put("mail.smtp.port", port);

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});

		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(email, false));

			// Obtenemos todas lac guias con error en BD
			List<String> lstGuias = iEmailDAO.getGuiasError();

			if(lstGuias.isEmpty()) {
				
				
				logger.info("NO HAY GUIAS CON ERROR, REPORTE NO SERA ENVIADO");
				
			}else {
				
				// Separamos los correos por coma
				//String toMails = StringUtils.join(emails,',');
				String toMails = "oswaldoarredondo@tracusa.com.mx,luisleon@tracusa.com.mx"
						+ ",uarteaga@tracusa.com.mx,ivansanchez@tracusa.com.mx,"
						+ "alfonsosanchez@tracusa.com.mx,samanthasalgado@tracusa.com.mx,"
						+ "mauricioperez@tracusa.com.mx,areligarcia@tracusa.com.mx,"
						+ "monserratserrano@tracusa.com.mx";

				InternetAddress[] parseMails = InternetAddress.parse(toMails, true);
				message.setRecipients(Message.RecipientType.TO, parseMails);
				message.setSubject("Reporte de Guias con Error Unigis");

				// El HTML se divide en 2 partes. el BODY y las IMEGENES ADJUNTAS
				MimeMultipart multipart = new MimeMultipart("related");

				// Aqui empeiza la primera parte el HTML
				BodyPart messageBodyPart = new MimeBodyPart();
				InputStream html = new FileInputStream(body);
				String content = IOUtils.toString(html);
				content = content.replaceAll("NOMBREREPORTE", "REPORTE GU&IacuteAS ERROR UNIGIS");
				content = content.replaceAll("TIEMPO", "30 minutos");
				messageBodyPart.setContent(content, "text/html; charset=utf-8");

				// Agregamos la primera parte al correo creado en multiparte
				multipart.addBodyPart(messageBodyPart);

				// Aqui empieza la segunda parte las IMAGENES ADJUTNAS
				messageBodyPart = new MimeBodyPart();
				
				// Se agrega la imagen en JPG, en PNG no funciona bien
				DataSource fds = new FileDataSource(image);
				messageBodyPart.setDataHandler(new DataHandler(fds));
				
				// Aqui asignamos la imagen a el id puesto en el apartado SRC de la
				// etiqueta <IMAGEN> en el HTML
				messageBodyPart.setHeader("Content-ID", "<logoTRSL>");

				// Añadimos la segunda parte
				multipart.addBodyPart(messageBodyPart);

				// Añadimos el archivo adjunto EL REPORTE
				MimeBodyPart attachPart = new MimeBodyPart();

				createReportByJasper("ReporteGuiasErrorUnigis");

				attachPart.attachFile(xlsFile.replace("ReportName", "ReporteGuiasErrorUnigis"));
				multipart.addBodyPart(attachPart);

				// Mezclamos todo en una parte en el correo
				message.setContent(multipart);

				// Enviamos el correo
				Transport.send(message);

				logger.info("REPORTE GUIAS ERROR UNIGIS ENVIADO");
				
			}

		} catch (MessagingException e) {

			logger.info(e.getMessage());

		}

	}
	public void createReportByJasper(String nombre_reporte) throws JRException {

		// String reportSrcFile =
		// "C:/opt/reportejasper/"+nombre_reporte+".jrxml";
		String reportSrcFile = jasperFile.replace("ReportName", nombre_reporte);

		// First, compile jrxml file.
		// JasperReport jasperReport =
		// JasperCompileManager.compileReport(reportSrcFile);
   
		File file = new File(reportSrcFile);

		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(file);

		Connection conn = iReportesDAOJDBC.getConexion();

		// Parameters for report
		Map<String, Object> parameters = new HashMap<String, Object>();

		//JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

		JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(jasperReport, parameters,
				conn);

		// Make sure the output directory exists.
		File outDir = new File(emailPath);
		outDir.mkdirs();

		// PDF Exportor.
		// JRPdfExporter exporter = new JRPdfExporter();
		JRXlsExporter xlsexporter = new JRXlsExporter();

		ExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
		
		// ExporterInput
		// exporter.setExporterInput(exporterInput);
		xlsexporter.setExporterInput(exporterInput);

		// ExporterOutput
		OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
				// "C:/opt/reportejasper/email/ReportePepst.pdf");
				xlsFile.replace("ReportName", nombre_reporte));

		// Output
		xlsexporter.setExporterOutput(exporterOutput);

		// SimplePdfExporterConfiguration configuration = new
		// SimplePdfExporterConfiguration();
		SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
		// configuration.setOnePagePerSheet(true);
		configuration.setDetectCellType(true);
		configuration.setCollapseRowSpan(false);
		configuration.setRemoveEmptySpaceBetweenRows(true);

		xlsexporter.setConfiguration(configuration);
		xlsexporter.exportReport();

	}

}
