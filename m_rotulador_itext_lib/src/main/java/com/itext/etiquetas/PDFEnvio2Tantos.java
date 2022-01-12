/* $Id:  $
 *
 * Nombre del Proyecto:
 * Nombre del Programa: PDFEnvio2Tantos.java
 * Responsable: Adrián Morales Ruaro
 * Descripcion: crea las etiquetas para una hoja carta, dos por hoja
 *
 * $Log:$
 */
package com.itext.etiquetas;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import com.innovargia.documentos.dtos.Envio;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;

public class PDFEnvio2Tantos extends PDFDocument {

	private boolean canvasGuia;
	private PdfContentByte cb;
	private PdfTemplate template;
	private String pathLogo = null;

	private Image logo;

	// ///////////////////// Derechos /////////////////////////////
	private String derechos = Coordenadas.derechos;

	private Envio mienvio;

	public String getPathLogo() {
		return pathLogo;
	}

	public void setPathLogo(String pathLogo) {
		this.pathLogo = pathLogo;
	}

	public PDFEnvio2Tantos(Rectangle size, boolean rotacion) throws Exception {
		super(size, rotacion);
		cb = getEscritor().getDirectContent();
		// template = cb.createTemplate(279, 419);
		template = cb.createTemplate(800, 1250);

	}

	public PDFEnvio2Tantos(boolean size) throws Exception {
		super(size);
		canvasGuia = size;
		cb = getEscritor().getDirectContent();
		// template = cb.createTemplate(279, 419);
		template = cb.createTemplate(800, 1250);
		// template = cb.createTemplate(500, 200);
		// preparaLogo();
	}

	public PDFEnvio2Tantos() throws Exception {
		super();
		// canvasGuia = size;
		cb = getEscritor().getDirectContent();
		// template = cb. createTemplate(279, 419);
		template = cb.createTemplate(800, 1250);
		// template = cb.createTemplate(500, 200);
		// preparaLogo();
	}

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		//DebugLog.debug(this.getClass(), mensaje);
		System.out.println(mensaje);
		
	}// fin de debug

	/**
	 * Informa si el documento es del tamaño de una guia.
	 * 
	 * @param True
	 *            si el tamaño a usar es el de una guia, falso si el tamaño es
	 *            oficio.
	 */
	public boolean isCanvasGuia() {
		return canvasGuia;
	}

	/**
	 * Agrega nueva pagina al ContentByte, con el template inicializado.
	 */
	public boolean agregaPagina() {
		boolean bOk = false;
		try {
			// template = cb.createTemplate(278, 420);
			template = cb.createTemplate(800, 1250);

			bOk = super.agregaPagina();
		} catch (Exception e) {
			debug("AGREGAPAGINA(): " + e.getMessage());
			e.printStackTrace();
		}
		return bOk;
	}

	private byte[] streamToByteArray(InputStream in) throws Exception {
		byte[] data = null;
		try {
			byte[] buffer = new byte[1024];
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int len;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			data = out.toByteArray();
		} catch (Exception e) {
			debug("streamToByteArray(): " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return data;
	}

	/*
	 * private float getHeigth(float height){ if (height>100){ return 70; }
	 * 
	 * return height; } private float getWidth(float width){ if (width>100){
	 * return 70; }
	 * 
	 * return width; }
	 */

	private float Percent(float width, float height) {
		if ((width >= 250) && (height >= 250)) {
			return 8.5f;
		}

		if ((width >= 200) && (height >= 100)) {
			return 15f;
		}

		if ((width >= 100) && (height >= 600)) {
			return 13f;
		}

		if ((width >= 100) && (height >= 200)) {
			return 20f;
		}

		if ((width >= 50) && (height >= 200)) {
			return 17f;
		}
		if ((width >= 50) && (height >= 100)) {
			return 30f;
		}

		if ((width >= 50) && (height >= 80)) {
			return 40f;
		}

		if ((width >= 50) && (height >= 50)) {
			return 45f;
		}

		if ((width >= 30) && (height >= 30)) {
			return 50f;
		}

		return 80f;

	}

	/**
	 * Posiciona el logo en el cuadrante indicado obteniendo la imagen del path
	 * solicitado
	 **/
	private boolean setLogo(int cuadrante, String pathlogo) throws Exception {

		boolean bOk = true;

		try {
			if (pathlogo == null) {
				// debug("setLogo->TIENE UN VALOR NULO->" + pathlogo);
				return false;
			}
			String file_name = pathlogo.trim();

			// debug("setLogo->" + pathlogo);
			// debug("setLogo->" + pathlogo.length());
			// debug("setLogo->" + pathlogo.trim().length());

			// debug("file_name->" + file_name);

			File file = new File(pathlogo);
			if (!file.exists()) {
				// debug("setLogo->NO ENCONTRADO->" + pathlogo);
				return false;
			}

			// debug("Obteniendo datgos de ->" + file_name);
			InputStream is = new BufferedInputStream(new FileInputStream(
					file_name));

			// debug("setLogo->path logo->" + file_name);
			// debug("setLogo->is->" + is);

			float heigth = 0;
			float width = 0;
			float x = 0;
			float y = 0;
			logo = Image.getInstance(streamToByteArray(is));
			// logo.setRotationDegrees(90);
			logo.scalePercent(Percent(logo.getScaledWidth(),
					logo.getScaledHeight()));

			x = (float) (25.5); // * Coordenadas.dot);
			y = (float) (30.73); // * Coordenadas.dot);

			logo.setAbsolutePosition(x, y);
			template.addImage(logo);

			bOk = true;
		} catch (Exception e) {
			debug("setLogo: " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return bOk;
	}

	public boolean generaGuia(int cuadrante, ArrayList arr_guias)
			throws Exception {

		// Cada arreglo debe tener 4 etiquetas
		Envio envio = new Envio();
		int cuadrante_int = 1;
		for (int i = 0; i < arr_guias.size(); i++) {
			envio = (Envio) arr_guias.get(i);
			setLabelGuia(envio);
			cuadrante(cuadrante_int, envio);

		}
		return true;
	}

	/***
	 * Pinta los datos de acuerdo al cuadrante indicadoy de acuerdo a los datos
	 * pasados en el objeto Envio
	 */
	private boolean cuadrante(int cuadrante, Envio envio) throws Exception {

		// debug("inica cuadrante->" + cuadrante);
		// Ajusta el logo del cuadrante
		// envio.setLogo("C:\\source\\logosusuario\\LogoClubGurmet.gif");
		setLogo(cuadrante, envio.getLogo());

		// debug("LOGO->" + envio.getLogo());

		// Ajusta datos que contiene el envio
		escribeDatosEtiqueta(cuadrante, envio);

		// Crea el codigo 128 y PDF
		// if (cuadrante == 1) {
		if ((envio.getInfoEnvio() != null)
				&& (envio.getInfoEnvio().trim().length() > 0)) {
			creaPDF417(envio.getInfoEnvio(envio), 15f, 1f, 21.0f, 30.0f, 0);
		}

		// Codigo superior derecho
		creaCB128(envio.getIdEnvio(), 11.65f, 11.6f, 7.5f,
				Coordenadas.ALTURA_128CODE, 0);

		// Codigo Envio inferior
		creaCB128(envio.getIdEnvio(), 1.65f, 7.5f, 7.5f,
				Coordenadas.ALTURA_128CODE, 0);
		// Codigo ruta
		if ((envio.getRuta() != null) && (envio.getRuta().trim().length() > 0)) {
			creaCB128(envio.getRuta(), 14.0f, 3.3f, 4f, 0.7f, 0);
		}

		// Agrega los datos al template finla
		agregaTemplate(0, 0);

		// debug("termina cuadrante->" + cuadrante);
		// }
		return true;
	}

	/**
	 * Agrega el Template al ContentByte.
	 * 
	 * @param x
	 *            Coordenada x de la esquina inferior izquierda (en
	 *            centimetros), donde se colocará el Template dentro del
	 *            ContetByte.
	 * @param y
	 *            Coordenada y de la esquina inferior izquierda (en
	 *            centimetros), donde se colocará el Template dentro del
	 *            ContetByte.
	 */
	private boolean agregaTemplate(float x, float y) throws Exception {
		boolean bOk = false;
		try {
			cb.addTemplate(template, x, y);
			bOk = true;
		} catch (Exception e) {
			debug("Guia.creaPDF417(): " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return bOk;
	}

	/**
	 * Agrega los datos para la eqiqueta de 4 tantos
	 * 
	 * @param cuadrante
	 * @param envio
	 * @return
	 * @throws Exception
	 */
	public boolean escribeDatosEtiqueta(int cuadrante, Envio envio)
			throws Exception {
		boolean bOk = false;

		String tmp_str = "";
		try {

			// Derechos de autor
			// Row=Columna, Col= Renglon
			for (int i = 0; i <= 500; i++) {
				// escribeTexto("Renglon "+i + "Columna " + i+ " " +derechos, 3,
				// (float)i, (float)i, 0, BaseFont.TIMES_BOLDITALIC);

			}
			System.out.println("Derechos:");
			escribeTexto(derechos, 3, 10.65f, 0.7f, 0,
					BaseFont.TIMES_BOLDITALIC);
			
			
			// Rectangulo Superior
			// creaRectangulo(0.9f, 26.5f, 19.5f, 0.7f, 0.5f);
			// Rectangulo guia y referencia
			// creaRectangulo(0.9f, 24.5f, 10.1f, 2.0f, 0.5f);
			// creaRectangulo(11.0f, 24.5f, 9.40f, 2.0f, 0.5f);

			// Rectangulo Remitente destino
			// creaRectangulo(0.9f, 19.5f, 10.1f, 4.5f, 0.5f);

			creaRectangulo(11.0f, 7.0f, 9.40f, 4.5f, 1.2f);

			// Rectangulo Observaciones, Comentarios y Enrutamiento
			// creaRectangulo(0.9f, 17.0f, 10.1f, 2.5f, 0.5f);
			// creaRectangulo(11.0f, 17.0f, 9.40f, 2.5f, 0.5f);

			// //// DATOS PARA EL REMITENTE
			// ///////////////////////////////
			float renglon = 12.5f;
			float columna_izq = 1.5f;
			float columna_der = 11.2f;
			float incrementa = 0.45f;
			float renglon_detino = 11.0f;

			// ///////////////////// Servicio /////////////////////////////
			System.out.println("Derechos:");
			tmp_str = "Servicio: " + envio.getDes_servicio() + "   ( "
					+ envio.getNumCliente() + " )";
			escribeTexto(tmp_str, 6, 1.5f, 13.0f, 0, BaseFont.TIMES_BOLD);

			// Garantia
			System.out.println("Garantia:");
			tmp_str = "Garantia: " + envio.getDes_garantia();
			escribeTexto(tmp_str, 10, 10.0f, 13.0f, 0, BaseFont.TIMES_BOLD);

			// Multiple en caso de que haya
			System.out.println("Multiples:");
			escribeTexto(envio.getMultiples(), 8, 15.0f, 13.0f, 0,
					BaseFont.TIMES_BOLD);

			// Peso
			System.out.println("Peso:");
			escribeTexto("Peso: " + envio.getPeso() + " kg.", 7, 17.0f, 13.0f,
					0, BaseFont.TIMES_BOLD);

			// Datos del remitente
			System.out.println("DATOS REMITENTE:");
			escribeTexto("DATOS REMITENTE", 7, columna_izq, renglon, 0,
					BaseFont.TIMES_BOLDITALIC);

			System.out.println("remitente.getRazonSocial:");
			escribeTexto(getSubstring(envio.remitente.getRazonSocial(), 58), 7,
					getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 1)), 0,
					BaseFont.TIMES_ROMAN);
			
			System.out.println("remitente.getAtencion:");
			escribeTexto(getSubstring(envio.remitente.getAtencion(), 58), 7,
					getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 2)), 0,
					BaseFont.TIMES_ROMAN);
			
			System.out.println("remitente.getDireccion:");
			escribeTexto(getSubstring(envio.remitente.getDireccion(), 58), 7,
					getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 3)), 0,
					BaseFont.TIMES_ROMAN);

			System.out.println("remitente.getColonia:");
			escribeTexto(getSubstring(envio.remitente.getColonia(), 58), 7,
					getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 4)), 0,
					BaseFont.TIMES_ROMAN);

			System.out.println("remitente.getCp:");
			escribeTexto(
					"C.P " + envio.remitente.getCp() + "           "
							+ "       DEL/MUN  "
							+ getSubstring(envio.remitente.getMunicipio(), 58),
					7, getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 5)), 0,
					BaseFont.TIMES_ROMAN);

			System.out.println("remitente.getEstado:");
			escribeTexto(getSubstring(envio.remitente.getEstado(), 58), 7,
					getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 6)), 0,
					BaseFont.TIMES_ROMAN);

			System.out.println("remitente.getTelefono:");
			escribeTexto(
					"TEL: " + getSubstring(envio.remitente.getTelefono(), 58),
					7, getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 7)), 0,
					BaseFont.TIMES_ROMAN);

			// //// DATOS PARA EL DESTINATARIO
			// ///////////////////////////////
			System.out.println("DATOS DESTINATARIO");
			escribeTexto("DATOS DESTINATARIO", 7,
					getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_detino), 0,
					BaseFont.TIMES_BOLDITALIC);

			System.out.println("destinatario.getRazonSocial:");
			escribeTexto(getSubstring(envio.destinatario.getRazonSocial(), 58),
					7, getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_detino - (incrementa * 1)), 0,
					BaseFont.TIMES_BOLD);

			System.out.println("destinatario.getAtencion:");
			escribeTexto(getSubstring(envio.destinatario.getAtencion(), 58), 7,
					getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_detino - (incrementa * 2)), 0,
					BaseFont.TIMES_BOLD);

			System.out.println("destinatario.getDireccion:");
			escribeTexto(getSubstring(envio.destinatario.getDireccion(), 58),
					7, getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_detino - (incrementa * 3)), 0,
					BaseFont.TIMES_BOLD);

			System.out.println("destinatario.getColonia:");
			escribeTexto(getSubstring(envio.destinatario.getColonia(), 58), 7,
					getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_detino - (incrementa * 4)), 0,
					BaseFont.TIMES_BOLD);

			System.out.println("C.P: DEL/MUN ");
			escribeTexto(
					"C.P "
							+ envio.destinatario.getCp()
							+ "           "
							+ "       DEL/MUN  "
							+ getSubstring(envio.destinatario.getMunicipio(),
									58), 7, getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_detino - (incrementa * 5)), 0,
					BaseFont.TIMES_BOLD);

			
			System.out.println("destinatario.getEstado: ");
			escribeTexto(getSubstring(envio.destinatario.getEstado(), 58), 7,
					getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_detino - (incrementa * 6)), 0,
					BaseFont.TIMES_BOLD);

			System.out.println("destinatario.getTelefono: ");
			escribeTexto(
					"TEL: "
							+ getSubstring(envio.destinatario.getTelefono(), 70),
					7, getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_detino - (incrementa * 7)), 0,
					BaseFont.TIMES_BOLD);

			// //////////////////////////////// A C U S E
			// /////////////////////////////
			// /////////// LINEA DE FIRMA DE ACUSE EN CASO DE QUE EXISTA
			// //////////////////////
			// envio.setAcuse(true);
			if (envio.isAcuse()) {
				System.out.println("ACUSE");
				escribeTexto(
						"ACUSE",
						18,
						getRow(cuadrante, columna_der + 7.0f),
						getCol(cuadrante, renglon_detino - (incrementa * 10.2f)),
						0, BaseFont.TIMES_BOLD);

				escribeTexto(
						"FIRMA y NOMBRE: _____________________________________________",
						6,
						getRow(cuadrante, columna_der),
						getCol(cuadrante, renglon_detino - (incrementa * 11.0f)),
						0, BaseFont.TIMES_BOLD);
			}

			// ESCRIBE LOS ultimos 5 caracteres de la guia
			String guia_5_caracteres = envio.getIdEnvio();
			if (guia_5_caracteres.trim().length() > 5) {
				guia_5_caracteres = guia_5_caracteres
						.substring(guia_5_caracteres.trim().length() - 5);
			}
			
			System.out.println("ENVIO");
			escribeTexto("envio ", 9, getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 13.5f)), 0,
					BaseFont.TIMES_BOLDITALIC);

			
			escribeTexto(guia_5_caracteres, 18,
					getRow(cuadrante, columna_izq + 1.3f),
					getCol(cuadrante, renglon - (incrementa * 13.5f)), 0,
					BaseFont.TIMES_BOLDITALIC);

			// Comenatrios/Observaciones
			System.out.println("Observaciones");
			escribeTexto("Observaciones ", 9, getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 15.2f)), 0,
					BaseFont.TIMES_BOLDITALIC);

			if ((envio.getComentario() != null)
					&& (envio.getComentario().trim().length() > 65)) {

				escribeTexto(envio.getComentario().trim().substring(0, 65), 7,
						getRow(cuadrante, columna_izq),
						getCol(cuadrante, renglon - (incrementa * 15.9f)), 0,
						BaseFont.TIMES_ROMAN);

				escribeTexto(envio.getComentario().trim().substring(65), 7,
						getRow(cuadrante, columna_izq),
						getCol(cuadrante, renglon - (incrementa * 16.6f)), 0,
						BaseFont.TIMES_ROMAN);
			} else {
				escribeTexto(envio.getComentario().trim(), 7,
						getRow(cuadrante, columna_izq),
						getCol(cuadrante, renglon - (incrementa * 15.9f)), 0,
						BaseFont.TIMES_ROMAN);

			}

			// Contenido
			System.out.println("Contenido");
			escribeTexto("Contenido ", 9, getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 18.0f)), 0,
					BaseFont.TIMES_BOLDITALIC);

			escribeTexto(getSubstring(envio.getContenido(), 60), 7,
					getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 18.6f)), 0,
					BaseFont.TIMES_ROMAN);

			// Referencia
			System.out.println("Referencia");
			escribeTexto("Referencia ", 9, getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 19.7f)), 0,
					BaseFont.TIMES_BOLDITALIC);

			escribeTexto(getSubstring(envio.getReferencia(), 60), 7,
					getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 20.4f)), 0,
					BaseFont.TIMES_ROMAN);

			// Enrutamiento
			float renglon_enruta = 10.0f;
			System.out.println("Enrutamiento");
			escribeTexto("Enrutamiento ", 9, getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_enruta - (incrementa * 10.0f)),
					0, BaseFont.TIMES_BOLDITALIC);

			escribeTexto(envio.getObserva1(), 18,
					getRow(cuadrante, columna_der + 3.5f),
					getCol(cuadrante, renglon_enruta - (incrementa * 10.0f)),
					0, BaseFont.TIMES_BOLD);

			// RUTA MENSAJERIA PROPUESTA DE ENTREGA
			// SOLO CUANDO EXISTEN DATOS SE PINTA EL RECUADRO
			// envio.setEnrutadoPor("MKT");
			if ((envio.getEnrutadoPor() != null)
					&& (envio.getEnrutadoPor().trim().length() > 0)) {
				if (cuadrante == 1) {
					creaRectangulo(20.0f, 3.5f, 0.5f, 1.5f, 0.5f);

					escribeTexto(getSubstring(envio.getEnrutadoPor(), 3), 13,
							getRow(cuadrante, 20.4f), getCol(cuadrante, 3.65f),
							90, BaseFont.TIMES_BOLD);
				}
				if (cuadrante == 2) {

					creaRectangulo(15.5f, 26.1f, 2.62f, 0.5f, 0.5f);
					escribeTexto(getSubstring(envio.getEnrutadoPor(), 3), 13,
							getRow(cuadrante, 5.7f), getCol(cuadrante, 27.17f),
							90, BaseFont.TIMES_BOLD);

				}

			}
			// ///////////////////// Origen-Destino - Ruta
			// /////////////////////////////
			System.out.println("origen");
			escribeTexto("origen:" + envio.getSiglasOrigen(), 7,
					getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_enruta - (incrementa * 11.0f)),
					0, BaseFont.TIMES_BOLD);

			System.out.println("destino");
			escribeTexto("destino:" + envio.getSiglasDestino(), 11,
					getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_enruta - (incrementa * 12.0f)),
					0, BaseFont.TIMES_BOLD);

			System.out.println("Ruta entrega");
			escribeTexto("Ruta entrega", 7, getRow(cuadrante, columna_der + 4),
					getCol(cuadrante, renglon_enruta - (incrementa * 13.0f)),
					0, BaseFont.TIMES_BOLD);

			// Seguro
			System.out.println("SEGURO");
			escribeTexto("S - " + envio.getCantAsegurada(), 7,
					getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_enruta - (incrementa * 14.8f)),
					0, BaseFont.TIMES_BOLD);
			// Monto
			System.out.println("Monto");
			escribeTexto("M -" + envio.getRound(), 7,
					getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_enruta - (incrementa * 15.4f)),
					0, BaseFont.TIMES_BOLD);
		} catch (Exception e) {
			debug("Guia.escribeDestinatarioRemitente(): " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return bOk;
	}

	public String getSubstring(String s, int cantidad) {

		if (s == null)
			return "";
		if (s.trim().length() <= cantidad)
			return s.trim();

		return s.trim().substring(0, cantidad);
	}

	private float getRow(int cuadrante, float cantidad) {

		switch (cuadrante) {
		case 1:
			return (cantidad);
		case 2:
			return cantidad;
		default:
			return -1;
		}

	}

	private float getCol(int cuadrante, float cantidad) {
		switch (cuadrante) {
		case 1:
			return cantidad;
		case 2:
			return cantidad;// cantidad + 13.5f);
		default:
			return -1;
		}

	}

	public Envio getLabelGuia() {
		return mienvio;
	}

	public void setLabelGuia(Envio labelGuia) {
		this.mienvio = labelGuia;
	}

	/**
	 * Crea un rectangulo. IMPORTANTE: el elemento sera visible si la coordenada
	 * existe dentro del documento.
	 * 
	 * @param xLower
	 *            Coordenada x de la esquina inferior izquierda (en
	 *            centimetros).
	 * @param yLower
	 *            Coordenada y de la esquina inferior izquierda (en
	 *            centimetros).
	 * @param w
	 *            Base (en centimetros).
	 * @param h
	 *            Altura (en centimetros).
	 * @param border
	 *            Grosor del trazo (en puntos).
	 */
	private boolean creaRectangulo(float xLower, float yLower, float w,
			float h, float border) throws Exception {
		try {
			dibujaRectangulo(template, xLower, yLower, w, h, border);
			// cb.addTemplate(template, 0, 0);
			return true;
		} catch (Exception e) {
			debug("Guia.creaRectangulo(): " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Escribe texto. IMPORTANTE: el elemento sera visible si la coordenada
	 * existe dentro del documento.
	 * 
	 * @param texto
	 *            Texo a escribir.
	 * @param size
	 *            Tamaño de la fuente.
	 * @param x
	 *            Coordenada x donde se comenzara a escribir el texto (x en
	 *            centimetros).
	 * @param y
	 *            Coordenada y donde se comenzara a escribir el texto (y en
	 *            centimetros).
	 * @param rotacion
	 *            Angulo del texto.
	 */
	private boolean escribeTexto(String texto, int size, float x, float y,
			int rotacion) throws Exception {
		try {
			escribe(template, texto, size, x, y, rotacion);
			// cb.addTemplate(template, 0, 0);
			return true;
		} catch (Exception e) {
			debug("Guia.escribeTexto(): " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Escribe texto. IMPORTANTE: el elemento sera visible si la coordenada
	 * existe dentro del documento.
	 * 
	 * @param texto
	 *            Texo a escribir.
	 * @param size
	 *            Tamaño de la fuente.
	 * @param x
	 *            Coordenada x donde se comenzara a escribir el texto (x en
	 *            centimetros).
	 * @param y
	 *            Coordenada y donde se comenzara a escribir el texto (y en
	 *            centimetros).
	 * @param rotacion
	 *            Angulo del texto.
	 * @param indica
	 *            el font deseado, utilice BaseFont para seleccionar el tipo de
	 *            letra
	 */
	private boolean escribeTexto(String texto, int size, float x, float y,
			int rotacion, String font) throws Exception {

		if (texto != null) {
			texto = texto.trim().toUpperCase();
		}
		try {
			System.out.println("Coordenadas:" + texto+ "|"+size+ "|"+ x+ "|"+y+ "|"+rotacion+ "|"+font );

			escribe(template, texto, size, x, y, rotacion, font);
			// cb.addTemplate(template, 0, 0);
			return true;
		} catch (Exception e) {
			debug("Guia.escribeTexto(): " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Escribe texto. IMPORTANTE: el elemento sera visible si la coordenada
	 * existe dentro del documento.
	 * 
	 * @param texto
	 *            Texo a escribir.
	 * @param size
	 *            Tamaño de la fuente.
	 * @param x
	 *            Coordenada x donde se comenzara a escribir el texto (x en
	 *            centimetros).
	 * @param y
	 *            Coordenada y donde se comenzara a escribir el texto (y en
	 *            centimetros).
	 * @param rotacion
	 *            Angulo del texto.
	 * @param bold
	 *            True si la escritura es en negritas.
	 */
	private boolean escribeTexto(String texto, int size, float x, float y,
			int rotacion, boolean bold) throws Exception {
		try {
			if (bold)
				escribe(template, texto, size, x, y, rotacion, bold);
			else
				escribe(template, texto, size, x, y, rotacion);
			// cb.addTemplate(template, 0, 0);
			return true;
		} catch (Exception e) {
			debug("Guia.escribeTexto(): " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Crea un PDF417. IMPORTANTE: el elemento sera visible si la coordenada
	 * existe dentro del documento.
	 * 
	 * @param valorPDF
	 *            el texto del CB PDF417.
	 * @param x
	 *            Coordenada x de la esquina inferior izquierda (en
	 *            centimetros). Coordenada horizontal
	 * @param y
	 *            Coordenada y de la esquina inferior izquierda (en
	 *            centimetros). Coordenada vertical
	 * @param w
	 *            Base (en centimetros).
	 * @param h
	 *            Altura (en centimetros).
	 */
	private boolean creaPDF417(String valorPDF, float x, float y, float w,
			float h, int rotacion) throws Exception {
		try {
			template.addImage(generaPDF417(valorPDF, x, y, w, h, rotacion));
			// cb.addTemplate(template,0,0);
			return true;
		} catch (Exception e) {
			debug("creaPDF417(): " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Crea un CB128. IMPORTANTE: el elemento sera visible si la coordenada
	 * existe dentro del documento.
	 * 
	 * @param valor
	 *            el texto del CB 128.
	 * @param x
	 *            Coordenada x de la esquina inferior izquierda (en
	 *            centimetros).
	 * @param y
	 *            Coordenada y de la esquina inferior izquierda (en
	 *            centimetros).
	 * @param w
	 *            Base (en centimetros).
	 * @param h
	 *            Altura (en centimetros).
	 */
	public boolean creaCB128(String valorPDF, float x, float y, float w,
			float h, int rotacion) throws Exception {
		try {
			template.addImage(generaCode128(valorPDF, cb, x, y, w, h, rotacion,0));
			// cb.addTemplate(template,0,0);
			return true;
		} catch (Exception e) {
			debug("Guia.creaCB128(): " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
