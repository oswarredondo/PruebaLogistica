/* $Id:  $
 *
 * Nombre del Proyecto:
 * Nombre del Programa: PDFEnvio.java
 * Responsable: Adrián Morales Ruaro
 * Descripcion: Crea las cartas de recolección
 *
 * $Log:$
 */
package com.itext.etiquetas;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.innovargia.documentos.dtos.Envio;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;

public class PDFCartasRecol extends PDFDocument {

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

	public PDFCartasRecol(boolean size) throws Exception {
		super(size);
		canvasGuia = size;
		cb = getEscritor().getDirectContent();
		template = cb.createTemplate(279, 419);
	}

	public PDFCartasRecol() throws Exception {
		super();
		cb = getEscritor().getDirectContent();
		template = cb.createTemplate(800, 2500);
	}

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		
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
			template = cb.createTemplate(800, 2500);

			bOk = super.agregaPagina();
		} catch (Exception e) {
			debug("AGREGAPAGINA(): " + e.getMessage());
			e.printStackTrace();
		}
		return bOk;
	}

	private static byte[] streamToByteArray(InputStream in) throws Exception {
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
			//debug("streamToByteArray(): " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return data;
	}

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
				debug("setLogo->TIENE UN VALOR NULO->" + pathlogo);
				return false;
			}
			debug("setLogo->" + pathlogo);
			debug("setLogo->" + pathlogo.length());
			debug("setLogo->" + pathlogo.trim().length());

			String file_name = pathlogo.trim();
			debug("file_name->" + file_name);

			File file = new File(pathlogo);
			if (!file.exists()) {
				debug("setLogo->NO ENCONTRADO->" + pathlogo);
				return false;
			}

			debug("Obteniendo datgos de ->" + file_name);
			InputStream is = new BufferedInputStream(new FileInputStream(
					file_name));

			debug("setLogo->path logo->" + file_name);
			debug("setLogo->is->" + is);

			float heigth = 0;
			float width = 0;
			float x = 0;
			float y = 0;
			logo = Image.getInstance(streamToByteArray(is));
			logo.setRotationDegrees(90);
			logo.scalePercent(Percent(logo.getScaledWidth(), logo
					.getScaledHeight()));

			debug("setLogo->logo->" + logo);

			switch (cuadrante) {
			case 1:
				x = getRow(1, (float) (0.96 * Coordenadas.dot));
				y = getCol(1, (float) (24.1 * Coordenadas.dot));

				logo.setAbsolutePosition(x, y);

				template.addImage(logo);
				break;
			case 2:

				logo.setAbsolutePosition(getRow(2,
						(float) (10.70 * Coordenadas.dot)), getCol(2,
						(float) (24.1 * Coordenadas.dot)));

				template.addImage(logo);

				break;
			case 3:
				logo.setAbsolutePosition(getRow(3,
						(float) (0.96 * Coordenadas.dot)), getCol(3,
						(float) (11.3 * Coordenadas.dot)));

				template.addImage(logo);
				break;
			case 4:
				logo.setAbsolutePosition(getRow(4,
						(float) (10.60 * Coordenadas.dot)), getCol(4,
						(float) (11.3 * Coordenadas.dot)));

				template.addImage(logo);
				break;
			default:
				break;
			}

			bOk = true;
		} catch (Exception e) {
			debug("setLogo: " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return bOk;
	}

	/***
	 * Crea la carta de recolección, el tipo de cuadrante =2 indica que se debe
	 * crear la tabla de resumen, con los mismos datos del envio
	 **/
	public boolean generaGuia(int cuadrante, Envio envio)
			throws Exception {

		// Cada arreglo debe tener 4 etiquetas
		//Envio envio = new Envio();
		int cuadrante_int = 1;
		//for (int i = 0; i < arr_guias.size(); i++) {
			//envio = (Envio) arr_guias.get(i);
			setLabelGuia(envio);

			//if (cuadrante_int > 4) {
			//	cuadrante_int = 1;
			//}

			cuadrante(cuadrante_int, envio);

		//}
		return true;
	}

	/***
	 * Pinta los datos de acuerdo al cuadrante indicadoy de acuerdo a los datos
	 * pasados en el objeto Envio
	 */
	private boolean cuadrante(int cuadrante, Envio envio) throws Exception {

		debug("inica cuadrante->" + cuadrante);
		// Ajusta el logo del cuadrante
		 envio.setLogo("C:\\source\\logosusuario\\logoInferior.gif");
		setLogo(cuadrante, envio.getLogo());

		// Da formato ya sea al tipo de carta de recolección o a la tabla de
		// resumen
		if (cuadrante == 2) { //Crea el cuatro de resumen

		} else {
			escribeDatosEtiqueta(cuadrante, envio);
		}
		// Crea el PDF
		//creaPDF417(envio.getInfoEnvio(envio), getRow(cuadrante, 1.9f), getCol(
		//		cuadrante, 23.5f), 21.0f, 30.0f);
		// Crea el codigo 128
		creaCB128(envio.getIdEnvio(), getRow(cuadrante,
				Coordenadas.X_1_3_CODE128), getCol(cuadrante,
				Coordenadas.Y1_128_COSTADO), Coordenadas.BASE_128CODE,
				Coordenadas.ALTURA_128CODE);
		// Agrega los datos al template final
		agregaTemplate(0, 0);

		debug("termina cuadrante->" + cuadrante);
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
	 * Agrega los datos a la carta cada carta crea dos paginas una conteniendo
	 * los datos generales y la otra conteniendo la tabla de resumen
	 * 
	 * 
	 * 
	 * @param cuadrante
	 * @param envio
	 * @return
	 * @throws Exception
	 */
	public boolean escribeDatosEtiqueta(int cuadrante, Envio envio)
			throws Exception {
		boolean bOk = false;
		try {

			// Derechos de autor
			//bOk = escribeTexto(derechos, 3, getRow(cuadrante, 1.0f), getCol(
			//		cuadrante, 15.9f), 90, BaseFont.TIMES_BOLDITALIC);
			
			//Escribe los datos de encabezado
			escribeTexto("Empresa", 5, 40f,10f, 90, BaseFont.TIMES_BOLD);
			
			escribeTexto("A quien corresponda:", 5,50f,10f , 90, BaseFont.TIMES_BOLD);
			
			escribeTexto("RE:", 5,60f,10f , 90, BaseFont.TIMES_BOLD);
			
			escribeTexto("PROVEEDOR:", 5,70f,10f , 90, BaseFont.TIMES_BOLD);
			

		} catch (Exception e) {
			debug("Guia.escribeDestinatarioRemitente(): "
					+ e.getMessage());
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
		case 3:
			return cantidad + 0.5f;
		case 2:
		case 4:
			return (cantidad + 10.5f);
		default:
			return -1;
		}
	}

	private float getCol(int cuadrante, float cantidad) {

		switch (cuadrante) {
		case 1:
		case 2:
			return cantidad - 1;
		case 3:
		case 4:
			return (cantidad - 14.0f);
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
			escribe(template, texto, size, x, y, rotacion, font);
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
			float h) throws Exception {
		try {
			template.addImage(generaPDF417(valorPDF, x, y, w, h, 90));
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
	public boolean creaCB128(String valorPDF, float x, float y, float w, float h)
			throws Exception {
		try {
			template.addImage(generaCode128(valorPDF, cb, x, y, w, h, 90,0));
			// cb.addTemplate(template,0,0);
			return true;
		} catch (Exception e) {
			debug("Guia.creaCB128(): " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
