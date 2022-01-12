/* $Id:  $
 *
 * Nombre del Proyecto:
 * Nombre del Programa: PDFEnvio.java
 * Responsable: Adrián Morales Ruaro
 * Descripcion: crea las etiquetas para una hoja carta, 4 por hoja
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
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;

public class PDFEnvio extends PDFDocument {

	private boolean canvasGuia;
	private PdfContentByte cb;
	private PdfTemplate template;
	private String pathLogo = null;

	private Image logo;
//	private Image logo1;
//	private Image logo2;
//	private Image logo3;
	
	// ///////////////////// Derechos /////////////////////////////
	private String derechos = Coordenadas.derechos;
	
	private Envio mienvio;

	public String getPathLogo() {
		return pathLogo;
	}

	public void setPathLogo(String pathLogo) {
		this.pathLogo = pathLogo;
	}


	public PDFEnvio(boolean size) throws Exception {
		super(size);
		canvasGuia = size;
		cb = getEscritor().getDirectContent();
		template = cb.createTemplate(279, 419);
		// template = cb.createTemplate(500, 200);
		// preparaLogo();
	}
	
	
	


	public PDFEnvio() throws Exception {
		super();
		// canvasGuia = size;
		cb = getEscritor().getDirectContent();
		// template = cb. createTemplate(279, 419);
		template = cb.createTemplate(800, 2500);
		// template = cb.createTemplate(500, 200);
		// preparaLogo();
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

	/*private float getHeigth(float height){
		if (height>100){
			return 70;
		}
		
		return height;
	}
	private float getWidth(float width){
		if (width>100){
			return 70;
		}
		
		return width;
	}*/
	
	private float Percent(float width,float height){
		if ((width>=250) && (height>=250)){
			return 8.5f;
		}
		
		if ((width>=200) && (height>=100)){
			return 15f;
		}
		
		if ((width>=100) && (height>=600)){
			return 13f;
		}
		
		if ((width>=100) && (height>=200)){
			return 20f;
		}
		
		if ((width>=50) && (height>=200)){
			return 17f;
		}
		if ((width>=50) && (height>=100)){
			return 30f;
		}
		
		if ((width>=50) && (height>=80)){
			return 40f;
		}
		
		if ((width>=50) && (height>=50)){
			return 45f;
		}
		
		if ((width>=30) && (height>=30)){
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
			if (pathlogo==null){
				debug("setLogo->TIENE UN VALOR NULO->" + pathlogo);
				return false;
			}
			debug("setLogo->"+pathlogo);
			debug("setLogo->"+pathlogo.length());
			debug("setLogo->"+pathlogo.trim().length());
			
			String file_name = pathlogo.trim();
			debug("file_name->"+file_name);
			
			File file = new File(pathlogo);
			if (!file.exists()){
				debug("setLogo->NO ENCONTRADO->" + pathlogo);
				return false;
			}

			debug("Obteniendo datgos de ->"+file_name);
			InputStream is = new BufferedInputStream(new FileInputStream(file_name));

			debug("setLogo->path logo->" + file_name);
			debug("setLogo->is->" + is);
			
			
			float heigth = 0; 
			float width = 0;
			float x =0;
			float y=0;
			logo = Image.getInstance(streamToByteArray(is));
			logo.setRotationDegrees(90);
			logo.scalePercent(Percent(logo.getScaledWidth(),logo.getScaledHeight()));
			
			debug("setLogo->logo->" + logo);
			
			switch (cuadrante) {
			case 1:
				x= getRow(1,(float) (0.96 * Coordenadas.dot));
				y= getCol(1,(float) (24.1 * Coordenadas.dot));
						 
				logo.setAbsolutePosition(x, y);
				
				template.addImage(logo);
				break;
			case 2:
				
				/*logo1 = Image.getInstance(streamToByteArray(is));
				debug("setLogo->logo1->" + logo1);
				logo1.scalePercent(90);
				logo1.setRotationDegrees(90);
				
				logo1.scalePercent(Percent(logo1.getScaledWidth(),logo1.getScaledHeight()));
				
				//logo1.scalePercent(getWidth(logo1.getScaledWidth()) ,
				//		getHeigth(logo1.getScaledHeight()));
				*/
				logo.setAbsolutePosition(getRow(2,
						(float) (10.70 * Coordenadas.dot)), getCol(2,
						(float) (24.1 * Coordenadas.dot)));

				template.addImage(logo);
				
				break;
			case 3:
				/*logo2 = Image.getInstance(streamToByteArray(is));
				debug("setLogo->logo2->" + logo2);
				logo2.scalePercent(90);
				logo2.setRotationDegrees(90);
			
				logo2.scalePercent(Percent(logo2.getScaledWidth(),logo2.getScaledHeight()));
				*/
				logo.setAbsolutePosition(getRow(3,
						(float) (0.96 * Coordenadas.dot)), getCol(3,
						(float) (11.3 * Coordenadas.dot)));
				
				template.addImage(logo);
				break;
			case 4:
				/*logo3 = Image.getInstance(streamToByteArray(is));
				debug("setLogo->logo3->" + logo3);
				
				logo3.scalePercent(90);
				logo3.setRotationDegrees(90);
				
				//logo3.scalePercent(getWidth(logo3.getScaledWidth()) ,
				//		getHeigth(logo3.getScaledHeight()));
				
				logo3.scalePercent(Percent(logo3.getScaledWidth(),logo3.getScaledHeight()));
				*/
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

	public boolean generaGuia(int cuadrante, ArrayList arr_guias)
			throws Exception {

		// Cada arreglo debe tener 4 etiquetas
		Envio envio = new Envio();
		int cuadrante_int = 1;
		for (int i = 0; i < arr_guias.size(); i++) {
			envio = (Envio) arr_guias.get(i);
			setLabelGuia(envio);

			if (cuadrante_int > 4) {
				cuadrante_int = 1;
			}
			
			cuadrante(cuadrante_int++, envio);

		}
		return true;
	}

	/***
	 * Pinta los datos de acuerdo al cuadrante indicadoy de acuerdo a los datos
	 * pasados en el objeto Envio
	 */
	private boolean cuadrante(int cuadrante, Envio envio) throws Exception {

		debug("inica cuadrante->"+ cuadrante);
		// Ajusta el logo del cuadrante
		//envio.setLogo("C:\\source\\logosusuario\\logoInferior.gif");
		setLogo(cuadrante, envio.getLogo());


		
		// Ajusta datos que contiene el envio
		escribeDatosEtiqueta(cuadrante, envio);
		// Crea el PDF
		creaPDF417(envio.getInfoEnvio(envio), getRow(cuadrante, 1.9f), getCol(
				cuadrante, 23.5f), 21.0f, 30.0f);
		// Crea el codigo 128
		creaCB128(envio.getIdEnvio(), getRow(cuadrante,
				Coordenadas.X_1_3_CODE128), getCol(cuadrante,
				Coordenadas.Y1_128_COSTADO), Coordenadas.BASE_128CODE,
				Coordenadas.ALTURA_128CODE);
		// Agrega los datos al template finla
		agregaTemplate(0, 0);
		
		debug("termina cuadrante->"+ cuadrante);
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
	 *  Agrega los datos para la eqiqueta de 4 tantos
	 * @param cuadrante
	 * @param envio
	 * @return 
	 * @throws Exception
	 */
	public boolean escribeDatosEtiqueta(int cuadrante, Envio envio)
			throws Exception {
		boolean bOk = false;
		try {

			//Derechos de autor
			bOk = escribeTexto(derechos, 3, getRow(cuadrante, 1.0f), getCol(
					cuadrante, 15.9f), 90, BaseFont.TIMES_BOLDITALIC);

			// ///////////////////// Origen-Destino - Ruta
			// /////////////////////////////
			bOk = escribeTexto("origen", 5, getRow(cuadrante, 4.0f), getCol(
					cuadrante, 23.5f), 90, BaseFont.TIMES_BOLD);
			bOk = escribeTexto(envio.getSiglasOrigen(), 7, getRow(cuadrante,
					4.0f), getCol(cuadrante, 24.36f), 90, BaseFont.TIMES_BOLD);
			bOk = escribeTexto("destino", 5, getRow(cuadrante, 4.3f), getCol(
					cuadrante, 23.5f), 90, BaseFont.TIMES_BOLD);
			bOk = escribeTexto(envio.getSiglasDestino(), 7, getRow(cuadrante,
					4.3f), getCol(cuadrante, 24.36f), 90, BaseFont.TIMES_BOLD);

			bOk = escribeTexto("Ruta entrega", 5, getRow(cuadrante, 4.6f),
					getCol(cuadrante, 23.5f), 90, BaseFont.TIMES_BOLD);
			bOk = escribeTexto(envio.getRuta(), 7, getRow(cuadrante, 4.6f),
					getCol(cuadrante, 25.0f), 90, BaseFont.TIMES_BOLD);

			// ///////////////////// Servicio /////////////////////////////
			bOk = escribeTexto("Servicio", 5, getRow(cuadrante, 5.0f), getCol(
					cuadrante, 23.5f), 90, BaseFont.TIMES_BOLD);
			bOk = escribeTexto(envio.getDes_servicio(), 7, getRow(
					cuadrante, 5.23f), getCol(cuadrante, 23.5f), 90,
					BaseFont.TIMES_BOLD);

			// Peso
			bOk = escribeTexto("Peso ", 5, getRow(cuadrante, 5.6f), getCol(
					cuadrante, 23.5f), 90, BaseFont.TIMES_BOLD);
			bOk = escribeTexto(envio.getPeso() + "", 7,
					getRow(cuadrante, 5.6f), getCol(cuadrante, 24.0f), 90,
					BaseFont.TIMES_BOLD);

			// Seguro
			bOk = escribeTexto("S - ", 5, getRow(cuadrante, 5.6f), getCol(
					cuadrante, 24.75f), 90, BaseFont.TIMES_BOLD);
			bOk = escribeTexto(envio.getCantAsegurada() + "", 7, getRow(
					cuadrante, 5.6f), getCol(cuadrante, 24.96f), 90,
					BaseFont.TIMES_BOLD);

			// Monto
			bOk = escribeTexto("M -", 5, getRow(cuadrante, 5.6f), getCol(
					cuadrante, 25.94f), 90, BaseFont.TIMES_BOLD);
			bOk = escribeTexto(envio.getRound() + "", 7,
					getRow(cuadrante, 5.6f), getCol(cuadrante, 26.2f), 90,
					BaseFont.TIMES_BOLD);

			// Multiple en caso de que haya
			bOk = escribeTexto(envio.getMultiples(), 18,
					getRow(cuadrante, 6.5f), getCol(cuadrante, 25.1f), 90,
					BaseFont.TIMES_BOLD);
			
			bOk = escribeTexto(envio.getObserva1(), 16,
					getRow(cuadrante, 7.6f), getCol(cuadrante, 23.1f), 90,
					BaseFont.TIMES_BOLD);

			// //////////////////////////////// A C U S E
			// /////////////////////////////
			// /////////// LINEA DE FIRMA DE ACUSE EN CASO DE QUE EXISTA
			// //////////////////////
			if (envio.isAcuse()) {
				bOk = escribeTexto("ACUSE", 18, getRow(cuadrante, 7.3f),
						getCol(cuadrante, 24.3f), 90, BaseFont.TIMES_BOLD);

				bOk = escribeTexto(
						"FIRMA y NOMBRE: _____________________________________________",
						6, getRow(cuadrante, 3.6f), getCol(cuadrante, 15.9f),
						90, BaseFont.TIMES_BOLD);
			}

			// RUTA MENSAJERIA PROPUESTA DE ENTREGA 
			//SOLLO CUANDO EXISTEN DATOS SE PINTA EL RECUADRO
			if ((envio.getEnrutadoPor() != null)
					&& (envio.getEnrutadoPor().trim().length()>0)) {
				if (cuadrante == 1) {
					bOk = bOk && creaRectangulo(5.5f, 26.1f, 2.62f, 0.5f, 0.5f);
					bOk = escribeTexto(getSubstring(envio.getEnrutadoPor(), 3),
							16, getRow(cuadrante, 5.7f), getCol(cuadrante,
									27.17f), 0, BaseFont.TIMES_BOLD);
				}
				if (cuadrante == 2) {
					
						creaRectangulo(15.5f, 26.1f, 2.62f, 0.5f, 0.5f);
					bOk = escribeTexto(getSubstring(envio.getEnrutadoPor(), 3),
							16, getRow(cuadrante, 5.7f), getCol(cuadrante,
									27.17f), 0, BaseFont.TIMES_BOLD);
				}
				if (cuadrante == 3) {
					creaRectangulo(5.5f, 13.1f, 2.62f, 0.5f, 0.5f);
					bOk = escribeTexto(getSubstring(envio.getEnrutadoPor(), 3),
							16, getRow(cuadrante, 5.7f), getCol(cuadrante,
									27.17f), 0, BaseFont.TIMES_BOLD);
				}

				if (cuadrante == 4) {
					
						 creaRectangulo(15.5f, 13.1f, 2.62f, 0.5f, 0.5f);
					escribeTexto(getSubstring(envio.getEnrutadoPor(), 3),
							16, getRow(cuadrante, 5.7f), getCol(cuadrante,
									27.17f), 0, BaseFont.TIMES_BOLD);
				}
			}

			// ////////////////////////// Remitente
			// ///////////////////////////////
			escribeTexto("REMITENTE", 6, getRow(cuadrante, 1.3f), getCol(
					cuadrante, 15.9f), 90, BaseFont.TIMES_BOLDITALIC);

			escribeTexto(getSubstring(envio.remitente.getRazonSocial(),
					70), 6, getRow(cuadrante, 1.6f), getCol(cuadrante, 15.9f),
					90, BaseFont.TIMES_ROMAN);

			escribeTexto(getSubstring(envio.remitente.getAtencion(), 70),
					6, getRow(cuadrante, 1.87f), getCol(cuadrante, 15.9f), 90,
					BaseFont.TIMES_ROMAN);

			escribeTexto(
					getSubstring(envio.remitente.getDireccion(), 80), 6,
					getRow(cuadrante, 2.1f), getCol(cuadrante, 15.9f), 90,
					BaseFont.TIMES_ROMAN);

			escribeTexto(getSubstring(envio.remitente.getColonia(), 70),
					6, getRow(cuadrante, 2.35f), getCol(cuadrante, 15.9f), 90,
					BaseFont.TIMES_ROMAN);

			escribeTexto("C.P " + envio.remitente.getCp() + "           "
					+ getSubstring(envio.remitente.getMunicipio(), 70), 6,
					getRow(cuadrante, 2.58f), getCol(cuadrante, 15.9f), 90,
					BaseFont.TIMES_ROMAN);

			escribeTexto(getSubstring(envio.remitente.getEstado(), 70),
					6, getRow(cuadrante, 2.82f), getCol(cuadrante, 15.9f), 90,
					BaseFont.TIMES_ROMAN);

			escribeTexto(getSubstring(envio.remitente.getTelefono(), 70),
					6, getRow(cuadrante, 3.1f), getCol(cuadrante, 15.9f), 90,
					BaseFont.TIMES_ROMAN);

			// escribeTexto("TEL. " + " 3640-8174,5025-5664,5025-5665", 6,
			// getRow(cuadrante, 3.34f), getCol(cuadrante, 15.9f), 90,
			// BaseFont.TIMES_ROMAN

			// ///////////////////////// DATOS DE DESTINATARIO
			// /////////////////////////////////////
			// /////////////////////////Crea recuadro para datos
			// destino///////////////////////////
			// 1
			if (cuadrante == 1) {
				creaRectangulo(4.5f, 14.7f, 2.62f, 7.6f, 0.5f);
			}
			// 2
			if (cuadrante == 2) {
				creaRectangulo(14.5f, 14.7f, 2.62f, 7.6f, 0.5f);
			}
			// 3
			if (cuadrante == 3) {
				creaRectangulo(4.5f, 1.7f, 2.62f, 7.6f, 0.5f);
			}
			// 4
			if (cuadrante == 4) {
				creaRectangulo(14.5f, 1.7f, 2.62f, 7.6f, 0.5f);
			}

			escribeTexto("DESTINATARIO", 6, getRow(cuadrante, 4.3f), getCol(
					cuadrante, 15.9f), 90, BaseFont.TIMES_BOLDITALIC);
			escribeTexto(getSubstring(envio.destinatario.getRazonSocial(), 70),
					6, getRow(cuadrante, 4.6f), getCol(cuadrante, 15.9f), 90,
					BaseFont.TIMES_BOLD);

			escribeTexto(getSubstring(envio.destinatario.getAtencion(), 70), 6,
					getRow(cuadrante, 4.87f), getCol(cuadrante, 15.9f), 90,
					BaseFont.TIMES_BOLD);

			escribeTexto(getSubstring(envio.destinatario.getDireccion(), 80),
					6, getRow(cuadrante, 5.12f), getCol(cuadrante, 15.9f), 90,
					BaseFont.TIMES_BOLD);

			escribeTexto(getSubstring(envio.destinatario.getColonia(), 70), 6,
					getRow(cuadrante, 5.35f), getCol(cuadrante, 15.9f), 90,
					BaseFont.TIMES_BOLD);

			escribeTexto("C.P " + envio.destinatario.getCp() + "            "
					+ getSubstring(envio.destinatario.getMunicipio(), 70), 6,
					getRow(cuadrante, 5.6f), getCol(cuadrante, 15.9f), 90,
					BaseFont.TIMES_BOLD);

			escribeTexto(getSubstring(envio.destinatario.getEstado(), 70), 6,
					getRow(cuadrante, 5.87f), getCol(cuadrante, 15.9f), 90,
					BaseFont.TIMES_BOLD);

			escribeTexto("TEL. "
					+ getSubstring(envio.destinatario.getTelefono(), 70), 6,
					getRow(cuadrante, 6.13f), getCol(cuadrante, 15.9f), 90,
					BaseFont.TIMES_BOLD);
			
			if (envio.isOcurre()){
				
			}

			// escribeTexto("TEL. " + " 3640-8174,5025-5664,5025-5665", 6,
			// getRow(cuadrante, 6.4f), getCol(cuadrante, 15.9f), 90,
			// BaseFont.TIMES_BOLD);

			// //////////////////////// DATOS ADICIONALES
			// ////////////////////////////
			escribeTexto("OBSERVACIONES ", 6, getRow(cuadrante, 6.9f), getCol(
					cuadrante, 15.9f), 90, BaseFont.TIMES_BOLDITALIC);

			if ((envio.getComentario() != null)
					&& (envio.getComentario().trim().length() > 100)) {
				escribeTexto(envio.getComentario().trim().substring(0, 99), 5,
						getRow(cuadrante, 7.14f), getCol(cuadrante, 15.9f), 90,
						BaseFont.TIMES_ROMAN);

				escribeTexto(envio.getComentario().trim().substring(100), 5,
						getRow(cuadrante, 7.4f), getCol(cuadrante, 15.9f), 90,
						BaseFont.TIMES_ROMAN);
			} else {
				escribeTexto(envio.getComentario().trim(), 5, getRow(cuadrante,
						7.14f), getCol(cuadrante, 15.9f), 90,
						BaseFont.TIMES_ROMAN);

			}

			escribeTexto("Contenido ", 6, getRow(cuadrante, 7.8f), getCol(
					cuadrante, 15.9f), 90, BaseFont.TIMES_BOLDITALIC);

			escribeTexto(getSubstring(envio.getContenido(), 60), 5, getRow(
					cuadrante, 8.0f), getCol(cuadrante, 15.9f), 90,
					BaseFont.TIMES_ROMAN);

			escribeTexto("Referencia ", 7, getRow(cuadrante, 7.8f), getCol(
					cuadrante, 20.9f), 90, BaseFont.TIMES_BOLDITALIC);

			escribeTexto(getSubstring(envio.getReferencia(), 40), 7, getRow(
					cuadrante, 8.0f), getCol(cuadrante, 20.9f), 90,
					BaseFont.TIMES_BOLD);

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
