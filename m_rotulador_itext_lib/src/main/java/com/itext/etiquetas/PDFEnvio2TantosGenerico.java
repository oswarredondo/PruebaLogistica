/* $Id:  $
 *
 * Nombre del Proyecto:
 * Nombre del Programa: PDFEnvio2Tantos.java
 * Responsable: Adri�n Morales Ruaro
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.innovargia.documentos.dtos.Envio;
import com.innovargia.utils.ArrayElementos;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;

public class PDFEnvio2TantosGenerico extends PDFDocument {
    private static final Logger logger = LoggerFactory
		.getLogger(PDFEnvio2TantosGenerico.class);

	private boolean canvasGuia;
	private PdfContentByte cb;
	private PdfTemplate template;
	private String pathLogo = null;
	private HashMap map_plantilla=new HashMap();

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

	public PDFEnvio2TantosGenerico(Rectangle size, boolean rotacion) throws Exception {
		super(size, rotacion);
		cb = getEscritor().getDirectContent();
		// template = cb.createTemplate(279, 419);
		template = cb.createTemplate(800, 1250);

	}

	public PDFEnvio2TantosGenerico(boolean size) throws Exception {
		super(size);
		canvasGuia = size;
		cb = getEscritor().getDirectContent();
		template = cb.createTemplate(800, 1250);
	}

	public PDFEnvio2TantosGenerico() throws Exception {
		super();
		cb = getEscritor().getDirectContent();
		template = cb.createTemplate(800, 1250);
	}
	
	/**
	 * Crea un documengto indicando ancho y largo de una etiqueta
	 * @param width
	 * @param height
	 * @throws Exception
	 */
	public PDFEnvio2TantosGenerico(float width, float height) throws Exception {
		super();
		cb = getEscritor().getDirectContent();
		template = cb.createTemplate(width, height);
	}

	/** 
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		
		//logger.debug(mensaje);
	}// fin de debug

	/**
	 * Informa si el documento es del tama�o de una guia.
	 * 
	 * @param True
	 *            si el tama�o a usar es el de una guia, falso si el tama�o es
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
	 * Crea una imagen con unas coordenas de acuerdo a una plantilla 
	 * @param cadena
	 * @throws Exception
	 */
	public void createImagen( String cadena) throws Exception {

		
		String[] str_valores = cadena.split("\\|",-1);
		if (str_valores.length<4) return;
		   
		int index=1;   
		String pathlogo = str_valores[index++];
		float x = Float.parseFloat(str_valores[index++]);
		float y = Float.parseFloat(str_valores[index++]); 

		try {
			if (pathlogo == null) {
				return ;
			}
			String file_name = pathlogo.trim();
			File file = new File(pathlogo);
			if (!file.exists()) {
				return ;
			}

			InputStream is = new BufferedInputStream(new FileInputStream(
					file_name));

			logo = Image.getInstance(streamToByteArray(is));
			logo.scalePercent(Percent(logo.getScaledWidth(),
					logo.getScaledHeight()));

			logo.setAbsolutePosition(x, y);
			template.addImage(logo);

		} catch (Exception e) {
			debug("logoInferior->setLogo: " + e.getMessage());
			///e.printStackTrace();
			//throw new Exception(e.getMessage());
		}
		return ;
	}
	/**
	 * Posiciona el logo en el cuadrante indicado obteniendo la imagen del path
	 * solicitado
	 **/
	private boolean setLogo(int cuadrante, String pathlogo) throws Exception {

		boolean bOk = true;

		try {
			if (pathlogo == null) {
				return false;
			}
			String file_name = pathlogo.trim();
			File file = new File(pathlogo);
			if (!file.exists()) {
				return false;
			}

			InputStream is = new BufferedInputStream(new FileInputStream(
					file_name));

			//float heigth = 0;
			//float width = 0;
			float x = 0;
			float y = 0;
			logo = Image.getInstance(streamToByteArray(is));
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

	public boolean generaGuia(HashMap mapTemplate)
			throws Exception {

		// Cada arreglo debe tener 4 etiquetas
		cuadrante( mapTemplate);
		return true;
	}

	/***
	 * Pinta los datos de acuerdo al cuadrante indicadoy de acuerdo a los datos
	 * pasados en el objeto Envio
	 */
	private boolean cuadrante( HashMap mapTemplate) throws Exception {
		
		//Obtiene los datos del MAP
		Iterator itr = mapTemplate.entrySet().iterator();
		String valor = "";
		String[] arr_valor = null;
		while (itr.hasNext()) {
			Map.Entry e = (Map.Entry)itr.next();
			
			//Obtiene el valor del MAP de acuerdo a la llave
			valor = mapTemplate.containsKey(e.getKey())?(String)mapTemplate.get(e.getKey()):null;
			if (valor!=null){
				arr_valor =  valor.split("\\|",-1);
				 logger.debug("clave: "+e.getKey()+", valor:"+e.getValue() + ", Typo:" + arr_valor[0]);

				//Valida el tipo de dato a pintar
				if ("imagen".equals(arr_valor[0])){
					createImagen( valor);
				}else if ("image".equals(arr_valor[0])){
						createImagen( valor);	
					
				}else if ("rectangle".equals(arr_valor[0])){
					creaRectangulo(valor) ;
				}else if ("label".equals(arr_valor[0])){ 
					escribeTexto(valor);
				}else if ("text".equals(arr_valor[0])){ 
					escribeTexto(valor);	
				}else if ("pdf".equals(arr_valor[0])){
					creaPDF417(valor);
				}else if ("cb".equals(arr_valor[0])){
					createCB128(valor,1);
				}else if ("cbabove".equals(arr_valor[0])){
					createCB128(valor,0);
				}
			}
			
		}
		
		
		// Agrega los datos al template finla
		agregaTemplate(0, 0);
			


		return true;
	}

	/**
	 * Agrega el Template al ContentByte.
	 * 
	 * @param x
	 *            Coordenada x de la esquina inferior izquierda (en
	 *            centimetros), donde se colocar� el Template dentro del
	 *            ContetByte.
	 * @param y
	 *            Coordenada y de la esquina inferior izquierda (en
	 *            centimetros), donde se colocar� el Template dentro del
	 *            ContetByte.
	 */
	private boolean agregaTemplate(float x, float y) throws Exception {
		boolean bOk = false;
		try {
			cb.addTemplate(template, x, y);
			bOk = true;
		} catch (Exception e) {
		    logger.debug("agregaTemplate: " + e.getMessage());
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
			//logger.debug("Derechos:");
			tmp_str = "Servicio: " + envio.getDes_servicio() + "   ( "
					+ envio.getNumCliente() + " )";
			escribeTexto(tmp_str, 6, 1.5f, 13.0f, 0, BaseFont.TIMES_BOLD);

			// Garantia
			//logger.debug("Garantia:");
			tmp_str = "Garantia: " + envio.getDes_garantia();
			escribeTexto(tmp_str, 10, 10.0f, 13.0f, 0, BaseFont.TIMES_BOLD);

			// Multiple en caso de que haya
			//logger.debug("Multiples:");
			escribeTexto(envio.getMultiples(), 8, 15.0f, 13.0f, 0,
					BaseFont.TIMES_BOLD);

			// Peso
			//logger.debug("Peso:");
			escribeTexto("Peso: " + envio.getPeso() + " kg.", 7, 17.0f, 13.0f,
					0, BaseFont.TIMES_BOLD);

			// Datos del remitente
			//logger.debug("DATOS REMITENTE:");
			escribeTexto("DATOS REMITENTE", 7, columna_izq, renglon, 0,
					BaseFont.TIMES_BOLDITALIC);

			//logger.debug("remitente.getRazonSocial:");
			escribeTexto(getSubstring(envio.remitente.getRazonSocial(), 58), 7,
					getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 1)), 0,
					BaseFont.TIMES_ROMAN);
			
			//logger.debug("remitente.getAtencion:");
			escribeTexto(getSubstring(envio.remitente.getAtencion(), 58), 7,
					getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 2)), 0,
					BaseFont.TIMES_ROMAN);
			
			//logger.debug("remitente.getDireccion:");
			escribeTexto(getSubstring(envio.remitente.getDireccion(), 58), 7,
					getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 3)), 0,
					BaseFont.TIMES_ROMAN);

			//logger.debug("remitente.getColonia:");
			escribeTexto(getSubstring(envio.remitente.getColonia(), 58), 7,
					getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 4)), 0,
					BaseFont.TIMES_ROMAN);

			//logger.debug("remitente.getCp:");
			escribeTexto(
					"C.P " + envio.remitente.getCp() + "           "
							+ "       DEL/MUN  "
							+ getSubstring(envio.remitente.getMunicipio(), 58),
					7, getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 5)), 0,
					BaseFont.TIMES_ROMAN);

			//logger.debug("remitente.getEstado:");
			escribeTexto(getSubstring(envio.remitente.getEstado(), 58), 7,
					getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 6)), 0,
					BaseFont.TIMES_ROMAN);

			//logger.debug("remitente.getTelefono:");
			escribeTexto(
					"TEL: " + getSubstring(envio.remitente.getTelefono(), 58),
					7, getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 7)), 0,
					BaseFont.TIMES_ROMAN);

			// //// DATOS PARA EL DESTINATARIO
			// ///////////////////////////////
			//logger.debug("DATOS DESTINATARIO");
			escribeTexto("DATOS DESTINATARIO", 7,
					getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_detino), 0,
					BaseFont.TIMES_BOLDITALIC);

			//logger.debug("destinatario.getRazonSocial:");
			escribeTexto(getSubstring(envio.destinatario.getRazonSocial(), 58),
					7, getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_detino - (incrementa * 1)), 0,
					BaseFont.TIMES_BOLD);

			//logger.debug("destinatario.getAtencion:");
			escribeTexto(getSubstring(envio.destinatario.getAtencion(), 58), 7,
					getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_detino - (incrementa * 2)), 0,
					BaseFont.TIMES_BOLD);

			//logger.debug("destinatario.getDireccion:");
			escribeTexto(getSubstring(envio.destinatario.getDireccion(), 58),
					7, getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_detino - (incrementa * 3)), 0,
					BaseFont.TIMES_BOLD);

			//logger.debug("destinatario.getColonia:");
			escribeTexto(getSubstring(envio.destinatario.getColonia(), 58), 7,
					getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_detino - (incrementa * 4)), 0,
					BaseFont.TIMES_BOLD);

			//logger.debug("C.P: DEL/MUN ");
			escribeTexto(
					"C.P "
							+ envio.destinatario.getCp()
							+ "           "
							+ "       DEL/MUN  "
							+ getSubstring(envio.destinatario.getMunicipio(),
									58), 7, getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_detino - (incrementa * 5)), 0,
					BaseFont.TIMES_BOLD);

			
			//logger.debug("destinatario.getEstado: ");
			escribeTexto(getSubstring(envio.destinatario.getEstado(), 58), 7,
					getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_detino - (incrementa * 6)), 0,
					BaseFont.TIMES_BOLD);

			//logger.debug("destinatario.getTelefono: ");
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
				//logger.debug("ACUSE");
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
			
			//logger.debug("ENVIO");
			escribeTexto("envio ", 9, getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 13.5f)), 0,
					BaseFont.TIMES_BOLDITALIC);

			
			escribeTexto(guia_5_caracteres, 18,
					getRow(cuadrante, columna_izq + 1.3f),
					getCol(cuadrante, renglon - (incrementa * 13.5f)), 0,
					BaseFont.TIMES_BOLDITALIC);

			// Comenatrios/Observaciones
			//logger.debug("Observaciones");
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
			//logger.debug("Contenido");
			escribeTexto("Contenido ", 9, getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 18.0f)), 0,
					BaseFont.TIMES_BOLDITALIC);

			escribeTexto(getSubstring(envio.getContenido(), 60), 7,
					getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 18.6f)), 0,
					BaseFont.TIMES_ROMAN);

			// Referencia
			//logger.debug("Referencia");
			escribeTexto("Referencia ", 9, getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 19.7f)), 0,
					BaseFont.TIMES_BOLDITALIC);

			escribeTexto(getSubstring(envio.getReferencia(), 60), 7,
					getRow(cuadrante, columna_izq),
					getCol(cuadrante, renglon - (incrementa * 20.4f)), 0,
					BaseFont.TIMES_ROMAN);

			// Enrutamiento
			float renglon_enruta = 10.0f;
			//logger.debug("Enrutamiento");
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
			//logger.debug("origen");
			escribeTexto("origen:" + envio.getSiglasOrigen(), 7,
					getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_enruta - (incrementa * 11.0f)),
					0, BaseFont.TIMES_BOLD);

			//logger.debug("destino");
			escribeTexto("destino:" + envio.getSiglasDestino(), 11,
					getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_enruta - (incrementa * 12.0f)),
					0, BaseFont.TIMES_BOLD);

			//logger.debug("Ruta entrega");
			escribeTexto("Ruta entrega", 7, getRow(cuadrante, columna_der + 4),
					getCol(cuadrante, renglon_enruta - (incrementa * 13.0f)),
					0, BaseFont.TIMES_BOLD);

			// Seguro
			//logger.debug("SEGURO");
			escribeTexto("S - " + envio.getCantAsegurada(), 7,
					getRow(cuadrante, columna_der),
					getCol(cuadrante, renglon_enruta - (incrementa * 14.8f)),
					0, BaseFont.TIMES_BOLD);
			// Monto
			//logger.debug("Monto");
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
	 * Genera un rectangulo con los datos de una cadena
	 * @param cadena
	 * @throws Exception
	 */
	public void creaRectangulo(String cadena) throws Exception {
		
		
		String[] str_valores = cadena.split("\\|",-1);
		if (str_valores.length<6) return;
		   
		int index=1; 
		float xLower = Float.parseFloat(str_valores[index++]);
		float yLower = Float.parseFloat(str_valores[index++]); 
		float w = Float.parseFloat(str_valores[index++]); 
		float  h = Float.parseFloat(str_valores[index++]); 
		float  border = Float.parseFloat(str_valores[index++]); 
		
		try {
			creaRectangulo( xLower,  yLower,  w, h,  border);
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
	 *            Tama�o de la fuente.
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
	 *            Tama�o de la fuente.
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
			//logger.debug("Coordenadas:" + texto+ "|"+size+ "|"+ x+ "|"+y+ "|"+rotacion+ "|"+font );
			escribe(template, texto, size, x, y, rotacion, font);
			// cb.addTemplate(template, 0, 0);
			return true;
		} catch (Exception e) {
		    logger.debug("Guia.escribeTexto(): " + e.getMessage());
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
	 *            Tama�o de la fuente.
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
			logger.debug("Guia.escribeTexto(): " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * Crea un texto en las coordenadas y con el font indicado
	 * label|valor|size|x|y|rotacion|font
	 * @param texto
	 * @throws Exception
	 */
	public void escribeTexto(String cadena) throws Exception {
		
		//label|valor|size|x|y|rotacion|bold

		String[] str_valores = cadena.split("\\|",-1);
		if (str_valores.length<6) return;
		   
		int index=1; 
		String texto = str_valores[index++];
		int size= Integer.parseInt(str_valores[index++]);
		float x = Float.parseFloat(str_valores[index++]);
		float y = Float.parseFloat(str_valores[index++]); 
		int rotacion= Integer.parseInt(str_valores[index++]);
		String font =str_valores[index++];

		
		try {
			escribe(template, texto, size, x, y, rotacion, font);
		} catch (Exception e) {
			logger.debug("Guia.escribeTexto(): " + e.getMessage());
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
			logger.debug("creaPDF417(): " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * Crea un codigo de barras PDF con las coordenadas de una cadena
	 * guia_valor|x|y|w|h|rotacion
	 * @param cadena
	 * @throws Exception
	 */
	public void creaPDF417(String cadena) throws Exception {
		if (cadena==null) return;
		
		String[] str_valores = cadena.split("\\|",-1);
		if (str_valores.length<6) return;
		   
		int index=1;  
		String valorPDF = str_valores[index++];
		float x = Float.parseFloat(str_valores[index++]);
		float y = Float.parseFloat(str_valores[index++]); 
		float w = Float.parseFloat(str_valores[index++]);
		float h= Float.parseFloat(str_valores[index++]);
		int rotacion= Integer.parseInt(str_valores[index++]);
		try {
			creaPDF417(valorPDF,  x,  y,  w, h,  rotacion);

		} catch (Exception e) {
			logger.debug("Guia.creaPDF417(): " + e.getMessage());
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
			float h, int rotacion, int baseline) throws Exception {
		try {
		template.addImage(generaCode128(valorPDF, cb, x, y, w, h, rotacion,baseline ));
			return true;
		} catch (Exception e) {
			logger.debug("Guia.creaCB128(): " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	
	/**
	 * Contiene las coordenadas del codgio separados por PIPES
	 * guia_valor|x|y|w|h|rotacion
	 * @param cadena
	 * @throws Exception
	 */
	public void createCB128(String cadena, int baseline) throws Exception {
		if (cadena==null) return;
		
		String[] str_valores = cadena.split("\\|",-1);
		if (str_valores.length<6) return;
		   
		int index=1;   
		String valorPDF = str_valores[index++];
		float x = Float.parseFloat(str_valores[index++]);
		float y = Float.parseFloat(str_valores[index++]); 
		float w = Float.parseFloat(str_valores[index++]);
		float h= Float.parseFloat(str_valores[index++]);
		int rotacion= Integer.parseInt(str_valores[index++]);
		
		baseline= ArrayElementos.getInt(str_valores, index++); 
		
		
		
		try {
			creaCB128( valorPDF,  x,  y,  w,h,  rotacion,baseline) ;
		} catch (Exception e) {
			logger.debug("Guia.creaCB128(): " + e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
