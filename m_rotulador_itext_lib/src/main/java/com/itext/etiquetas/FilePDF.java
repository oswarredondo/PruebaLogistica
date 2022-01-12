/*
 * Archivo de control para la generacion de las etiquetas
 */
package com.itext.etiquetas;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.innovargia.documentos.dtos.Envio;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Utilities;


/**
 * @author Adrian Morales Ruaro
 */
public class FilePDF {

	private String pathLogo;
	private ArrayList listaEtiquetas;
	private PDFEnvio etiqueta;
	private PDFEnvio2Tantos etiqueta2TanEnvio;
	private PDFEnvio2TantosGenerico etiquetaGenerica;

	private PDFCartasRecol etiquetaCartaRecol;
	
	private static final Logger logger = LoggerFactory
		.getLogger(FilePDF.class);

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		// DebugLog.debug(this.getClass(), mensaje);
	    logger.debug(mensaje);
	}// fin de debug

	public String getPathLogo() {
		return pathLogo;
	}

	public void setPathLogo(String pathLogo) {
		this.pathLogo = pathLogo;
	}

	/**
	 * Constructor para la carta de Recolección, se obtiene una lista de
	 * instancia de envíos
	 **/
	public FilePDF(ArrayList lista) throws Exception {
		etiqueta = new PDFEnvio();

	}// Fin de FilePDF

	/**
	 * Determina el tipo de documento que va ser creado conforme a los datos
	 * propoircionados por el usuario
	 **/
	public FilePDF(ArrayList lista, int tantos) throws Exception {

		// INdica que se esta realizando una carta de recolección
		if (tantos == 10) {
			etiquetaCartaRecol = new PDFCartasRecol();
		} else {
			if (tantos == 4) {
				etiqueta = new PDFEnvio();
			} else {
				// etiqueta2TanEnvio = new PDFEnvio2Tantos(new
				// Rectangle(490f,350f,0.5f,0.5f), false);
				etiqueta2TanEnvio = new PDFEnvio2Tantos(PageSize.HALFLETTER,
						true);
			}
		}

		// Agrega la lista de envios a configurar
		listaEtiquetas = lista;
	}
	private LabelIETWEB labelIETWEB=null;

	
	/**
	 * Determina el tipo de documento que va ser creado conforme a los datos
	 * propoircionados por el usuario
	 **/
	public FilePDF(ArrayList lista,LabelIETWEB labelProperties) throws Exception {

		// Coordenadas de la etiqueta
		labelIETWEB = labelProperties;
		etiquetaGenerica = new PDFEnvio2TantosGenerico(PageSize.HALFLETTER, true);

		// Agrega la lista de envios a configurar
		listaEtiquetas = lista;
	}
	
	/**
	 * Determina el tipo de documento que va ser creado conforme a los datos
	 * propoircionados por el usuario y el ancho y largo personalizado
	 **/
	public FilePDF(ArrayList lista,LabelIETWEB labelProperties,float width, float height) throws Exception {

		// Coordenadas de la etiqueta
		labelIETWEB = labelProperties;
		//NOTE: las dimensiones son alreves el width pertence al alto y height pertence al ancho
		//Convierte las dimensiones en puntos, el alto y ancho deben venir en milimetros
		width = Utilities.millimetersToPoints(width) ;
		height = Utilities.millimetersToPoints(height) ;
		etiquetaGenerica = new PDFEnvio2TantosGenerico(new Rectangle( width,height),true);

		// Agrega la lista de envios a configurar
		listaEtiquetas = lista;
	}

	/**
	 * Crea el formatato de carta de recolección
	 **/
	public byte[] getFileCartaRecolPDF() throws Exception {
		byte[] archivo = null;
		try {
			ArrayList arreglo_elementos = new ArrayList();
			Envio envio = null;
			int i = 0;
			// debug("Incia proceso de generado ->" + listaEtiquetas.size());
			for (i = 0; i < listaEtiquetas.size(); ++i) {
				// Obtiene el arreglode elementos
				// debug("listaEtiquetas->" + listaEtiquetas);
				// debug("arreglo_elementos->" + arreglo_elementos);

				envio = (Envio) listaEtiquetas.get(i);
				// Crea la carta
				etiquetaCartaRecol.generaGuia(1, envio);
				// Crea ka pagina nueva en el documento
				etiquetaCartaRecol.agregaPagina();
				// Crea el cuadro de resumen
				etiquetaCartaRecol.generaGuia(2, envio);

			}
			etiquetaCartaRecol.cerrarDocumento();
			archivo = etiquetaCartaRecol.toByteArray();
			etiquetaCartaRecol.cerrar();
			// debug("Termine procesamiento getFileCartaRecolPDF ->");
		} catch (Exception e) {
		    logger.debug("Error getFileCartaRecolPDF:" + e.getMessage());
			throw new Exception("getFilePDF->" + e.getMessage());
			
		}
		return archivo;
	}

	/**
	 * Agrega las paginas a la etiqueta de 4 tantos
	 **/
	public byte[] getFilePDF() throws Exception {
		byte[] archivo = null;
		try {
			ArrayList arreglo_elementos = new ArrayList();
			int i = 0;
			// debug("Incia proceso de generado ->" + listaEtiquetas.size());
			for (i = 0; i < listaEtiquetas.size(); ++i) {
				// Obtiene el arreglode elementos
				arreglo_elementos = (ArrayList) listaEtiquetas.get(i);
				etiqueta.generaGuia(0, arreglo_elementos);
				etiqueta.agregaPagina();

			}
			etiqueta.cerrarDocumento();
			archivo = etiqueta.toByteArray();
			etiqueta.cerrar();
			// debug("Termine procesamiento getFilePDF ->");
		} catch (Exception e) {
		    logger.debug("Error getFilePDF:" + e.getMessage());
			throw new Exception("getFilePDF->" + e.getMessage());
		}
		return archivo;
	}

	/**
	 * Agrega las paginas a la etiqueta de 2 tantos
	 **/
	public byte[] getFilePDF2Tantos() throws Exception {
		byte[] archivo = null;
		try {
			ArrayList arreglo_elementos = new ArrayList();
			int i = 0;
			// debug("Incia proceso de generado ->" + listaEtiquetas.size());
			for (i = 0; i < listaEtiquetas.size(); ++i) {
				// Obtiene el arreglode elementos
				arreglo_elementos = (ArrayList) listaEtiquetas.get(i);
				etiqueta2TanEnvio.generaGuia(0, arreglo_elementos);
				etiqueta2TanEnvio.agregaPagina();

			}
			etiqueta2TanEnvio.cerrarDocumento();
			archivo = etiqueta2TanEnvio.toByteArray();
			etiqueta2TanEnvio.cerrar();
			// debug("Termine procesamiento EtiquetasgetFilePDF2Tantos ->");
		} catch (Exception e) {
		    logger.debug("Error getFilePDF2Tantos:" + e.getMessage());
			throw new Exception("getFilePDF2Tantos->" + e.getMessage());
		}
		return archivo;
	}

	/**
	 * Agrega las paginas a la etiqueta de 2 tantos
	 **/
	public byte[] getFilePDFGenerico() throws Exception {
		byte[] archivo = null;
		try {
			HashMap arreglo_elementos = null;
			int i = 0;
			// debug("Incia proceso de generado ->" + listaEtiquetas.size());
			for (i = 0; i < listaEtiquetas.size(); ++i) {
				// Obtiene el arreglode elementos
				arreglo_elementos = (HashMap) listaEtiquetas.get(i);
				etiquetaGenerica.generaGuia(arreglo_elementos);
				etiquetaGenerica.agregaPagina();

			}
			etiquetaGenerica.cerrarDocumento();
			archivo = etiquetaGenerica.toByteArray();
			etiquetaGenerica.cerrar();
			// debug("Termine procesamiento EtiquetasgetFilePDF2Tantos ->");
		} catch (Exception e) {
		    logger.debug("Error getFilePDFGenerico:" + e.getMessage());
			throw new Exception("etiquetaGenerica->" + e.getMessage());
		}
		return archivo;
	}

	/**
	 * @return the etiquetaCartaRecol
	 */
	public PDFCartasRecol getEtiquetaCartaRecol() {
		return etiquetaCartaRecol;
	}

	/**
	 * @param etiquetaCartaRecol
	 *            the etiquetaCartaRecol to set
	 */
	public void setEtiquetaCartaRecol(PDFCartasRecol etiquetaCartaRecol) {
		this.etiquetaCartaRecol = etiquetaCartaRecol;
	}
}
