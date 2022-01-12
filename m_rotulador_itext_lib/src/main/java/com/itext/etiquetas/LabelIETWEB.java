package com.itext.etiquetas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.administracion.dto.ITextObjeto;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.utils.Fechas;
import com.innovargia.utils.file.FileManager;

public class LabelIETWEB {
	
    private static final Logger logger = LoggerFactory
		.getLogger(LabelIETWEB.class);

    
	public HashMap map_plantilla = new HashMap(); 
	
	/*** 
	 * Si el valor es true indica que se solo se imprime una etiqueta
	 * con la leyenda ACUSE
	 * 
	 * Si el valor es false indica que se agregue una segunda etiqueta
	 * para que el usuario pudeda firmar
	 * ***/
	private boolean acuseSoloLeyenda = true;
	

	/**
	 * @return the acuseSoloLeyenda
	 */
	public boolean isAcuseSoloLeyenda() {
		return acuseSoloLeyenda;
	}


	/**
	 * @param acuseSoloLeyenda the acuseSoloLeyenda to set
	 */
	public void setAcuseSoloLeyenda(boolean acuseSoloLeyenda) {
		this.acuseSoloLeyenda = acuseSoloLeyenda;
	}


	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		
	}// fin de debug

	
	/**
	 * Ajusta la plantilla que se debe crear para el PDF, toma cada renglo 
	 * del archivo y lo parte como llave=valor el renglon no debe comenzar con #
	 * @param path
	 */
	public void setMapPlantilla(String filename){
		  try{
	            File file = new File(filename);
	            String linea = null;
	            BufferedReader br = new BufferedReader(new FileReader(file));
	            
	            // A traves de este ciclo el BufferReader lee todo el archivo, 
	            //y lo va acumulando (sb.append) en un StringBuffer
	            String[] arr_renglon = null;
	            while ((linea = br.readLine()) != null) {
	            	//Parte la cadena por el signo igual y el primer elemento es la llave el segundo el valor
	            	if ((linea!=null) && (!linea.startsWith("#"))){
	            		arr_renglon = linea.split("=");
	            		if (arr_renglon.length>1){
	            			map_plantilla.put(arr_renglon[0], arr_renglon[1]);
	            		}
	            	}
	            }
	            
	            // Al final de la lectura cerramos el objeto
	            br.close();
	            
	        } catch (FileNotFoundException fnfe){
	            System.out.println("Error:"+fnfe.getMessage());
	        }
	        catch (IOException ioe){
	            System.out.println("Error:"+ioe.getMessage());
	        } 
	}
	
	public void setMapPlantilla(List<ITextObjeto> lista_detalle){
		try {
			String[] arr_renglon = null;
			String linea = null;
			for (ITextObjeto iTextObjeto : lista_detalle) {
				// Parte la cadena por el signo igual y el primer elemento es la
				// llave el segundo el valor
				linea = iTextObjeto.getLineaplnatilla();
				if ((linea != null) && (!linea.startsWith("#"))) {
					arr_renglon = linea.split("=");
					if (arr_renglon.length > 1) {
						map_plantilla.put(arr_renglon[0], arr_renglon[1]);
					}
				}
			}

		} catch (Exception fnfe) {
			System.out.println("Error:" + fnfe.getMessage());
		} 
	}
	
	/**
	 * Crea un arreglo de arreglos de 4 elementos con instancias de Envio para
	 * poder generar las etiquetas
	 */
	public ArrayList getArreglo4Cuadrantes(ArrayList lista) {
		ArrayList etiquetas = new ArrayList();
		ArrayList arr_elementos = new ArrayList();

		int elementos = 1;
		Envio envio = new Envio();
		// Envio envio_acuse = new Envio();
		boolean agregado = false;
		for (int index = 0; index < lista.size(); index++) {
			envio = (Envio) lista.get(index);

			// Inicia el proceso de agregado de datos
			if (envio != null) {
				// Obtiene el valor de acuse
				if (elementos == 4) {
					etiquetas.add(envio);
					arr_elementos.add(etiquetas);
					etiquetas = new ArrayList();
					elementos = 1;
					agregado = true;
				} else {
					etiquetas.add(envio);
					elementos++;
					agregado = false;
				}
			}

		}// fin del for
		if (!agregado) {
			arr_elementos.add(etiquetas);
		}

		return arr_elementos;
	}

	/**
	 * Crea un arreglo de arreglos de 2 elementos con instancias de Envio para
	 * poder generar las etiquetas
	 */
	public ArrayList getArreglo2Cuadrantes(ArrayList lista) {
		ArrayList etiquetas = new ArrayList();
		ArrayList arr_elementos = new ArrayList();

		Envio envio = new Envio();
		for (int index = 0; index < lista.size(); index++) {
			envio = (Envio) lista.get(index);

			// Inicia el proceso de agregado de datos
			if (envio != null) {
				etiquetas.add(envio);
				arr_elementos.add(etiquetas);
				etiquetas = new ArrayList();

			}

		}// fin del for

		return arr_elementos;
	}

	/**
	 * Crea un arreglo con datos para cada uno de los renglones del archivo
	 * encontrados
	 */
	public ArrayList getArreglo(ArrayList lista) {
		ArrayList etiquetas = new ArrayList();

		Envio envio = new Envio();
		for (int index = 0; index < lista.size(); index++) {
			envio = (Envio) lista.get(index);

			// Inicia el proceso de agregado de datos
			if (envio != null) {
				etiquetas.add(envio);
			}

		}// fin del for

		return etiquetas;
	}

	/**
	 * Crea el PDF a partir de los datos agregados en el archivo generado al
	 * realizar la importaci�n o rotulado de envios
	 * 
	 * @param path
	 *            indica el path donde se va a guardar el archivo
	 * @param tantos
	 *            indica cuantas etiquetas ser�n impresas por hoja 4= 4 por hoja
	 *            2= dos por hoja
	 * @return
	 */
	public String createPDF(String path, int tantos) {

		try {
			String pathPDF = path + ".pdf";

			//debug("INICIO PDF->" + pathPDF);

			ArrayList lista_guias = getEtiqueta(path);
			if (tantos == 4) {
				lista_guias = getArreglo4Cuadrantes(lista_guias);
			} else if (tantos == 2) {
				lista_guias = getArreglo2Cuadrantes(lista_guias);
			} else if (tantos == 10) {
				// Carta de recolecci�n
				lista_guias = getArreglo(lista_guias);
			}

			FilePDF archivoPDF = new FilePDF(lista_guias, tantos);
			byte[] guiasByteArrayPDF = null;
			if (tantos == 4) {
				guiasByteArrayPDF = archivoPDF.getFilePDF();
			} else if (tantos == 2) {
				guiasByteArrayPDF = archivoPDF.getFilePDF2Tantos();
			} else if (tantos == 10) {
				// Carta de recolecci�n
				guiasByteArrayPDF = archivoPDF.getFileCartaRecolPDF();
			}

			//debug("INICIO PDF->" + path);

			// Reemplaza todos los puntos del noombre del archivo por guines y
			// crea el nombre del
			// archivo PDF
			pathPDF = path.replace('.', '_') + ".pdf";
			File someFile = new File(pathPDF);
			FileOutputStream fos = new FileOutputStream(someFile);
			fos.write(guiasByteArrayPDF);

			fos.flush();
			fos.close();

			//debug("TERMINO PDF->");
			return pathPDF;

		} catch (Exception e) {
			debug("Error->" + e.getMessage());
		}

		return null;
	}
	
	/**
	 * Crea el PDF a partir de los datos agregados en el archivo generado al
	 * realizar la importaci�n o rotulado de envios
	 * 
	 * @param path
	 *            indica el path donde se va a guardar el archivo
	 * @param tantos
	 *            indica cuantas etiquetas ser�n impresas por hoja 4= 4 por hoja
	 *            2= dos por hoja
	 * @return
	 */
	public String createPDFGenerico(List<Envio> ar_envios,String path, float width, float height) {

		try {
			String pathPDF = path + ".pdf";
			ArrayList lista_guias = getEtiquetasMap(path,ar_envios);
						
			FilePDF archivoPDF = new FilePDF(lista_guias, this,width,height);
			byte[] guiasByteArrayPDF =archivoPDF.getFilePDFGenerico();

			// Reemplaza todos los puntos del noombre del archivo por guines y
			// crea el nombre del
			// archivo PDF
			pathPDF = path.replace('.', '_') + ".pdf";
			File someFile = new File(pathPDF);
			FileOutputStream fos = new FileOutputStream(someFile);
			fos.write(guiasByteArrayPDF);

			fos.flush();
			fos.close();

			return pathPDF;

		} catch (Exception e) {
			debug("Error->" + e.getMessage());
		}
		return null;
	}
	
	/**
	 * Crea el PDF a partir de los datos agregados en el archivo generado al
	 * realizar la importaci�n o rotulado de envios
	 * 
	 * @param path
	 *            indica el path donde se va a guardar el archivo
	 * @param tantos
	 *            indica cuantas etiquetas ser�n impresas por hoja 4= 4 por hoja
	 *            2= dos por hoja
	 * @return
	 */
	public String createPDFGenerico(List<Envio> ar_envios,String path, int tantos) {

		try {
			String pathPDF = path + ".pdf";
			ArrayList lista_guias = getEtiquetasMap(path,ar_envios);
						
			FilePDF archivoPDF = new FilePDF(lista_guias, this);
			byte[] guiasByteArrayPDF =  archivoPDF.getFilePDFGenerico();

			// Reemplaza todos los puntos del noombre del archivo por guines y
			// crea el nombre del
			// archivo PDF
			pathPDF = path.replace('.', '_') + ".pdf";
			File someFile = new File(pathPDF);
			FileOutputStream fos = new FileOutputStream(someFile);
			fos.write(guiasByteArrayPDF);

			fos.flush();
			fos.close();

			return pathPDF;

		} catch (Exception e) {
			debug("Error->" + e.getMessage());
		}

		return null;
	}
	
	/**
	 * Crea el PDF a partir de los datos agregados en el archivo generado al
	 * realizar la importaci�n o rotulado de envios
	 * 
	 * @param path
	 *            indica el path donde se va a guardar el archivo
	 * @param indica el tama�o de la etiqueta
	 * @return
	 */
	public String createPDFGenerico(String path,float width, float height) {

		try {
			String pathPDF = path + ".pdf";
			ArrayList lista_guias = getEtiquetasMap(path);
						
			FilePDF archivoPDF = new FilePDF(lista_guias, this,width,height);
			byte[] guiasByteArrayPDF = archivoPDF.getFilePDFGenerico();

			// Reemplaza todos los puntos del noombre del archivo por guines y
			// crea el nombre del
			// archivo PDF
			pathPDF = path.replace('.', '_') + ".pdf";
			File someFile = new File(pathPDF);
			FileOutputStream fos = new FileOutputStream(someFile);
			fos.write(guiasByteArrayPDF);

			fos.flush();
			fos.close();

			return pathPDF;

		} catch (Exception e) {
			debug("Error->" + e.getMessage());
		}

		return null;
	}
	
	
	/**
	 * Barre todos los atributos de una plantilla y busca una todas las coincidencias con 
	 * los atributos para agregarlos al MAP del envio
	 * @param mapenvio
	 * @param atributo
	 * @param valor
	 */
	public void setAtributoMapEnvio(HashMap mapenvio, String atributo,String valor){
	    
		//Elimina todos los PIPES de la cadena para evitar problemas al 
	    	//dar formato a al etiqueta
	    	valor = (valor==null)?"":valor.trim().replace("|", "-");
	    
		if (atributo==null) return;
		Iterator itr = map_plantilla.entrySet().iterator();
		String valor_renglon_map = "";
		String llave = "";
		String[] arr_valor = null;
		while (itr.hasNext()) {
			Map.Entry e = (Map.Entry)itr.next();

			//Verifica si el atributo ya esta en el MAP del envio toma el valor ya actualizado para verificar
			//si existen otros campos dentro de la cadena ya actualizada
			//Si no existe toma el registros del map_plantilla 
			valor_renglon_map = mapenvio.containsKey(e.getKey())?(String)mapenvio.get(e.getKey()):null;
			if (valor_renglon_map==null){
				valor_renglon_map = map_plantilla.containsKey(e.getKey())?(String)map_plantilla.get(e.getKey()):null;
			}

			//Verifica si el atributo buscado se encuentra dentro del valor 
			if (valor_renglon_map.contains(atributo)){
				//Cambia el valor en la cadena por el valor indicado y lo agrega al MAP
				valor_renglon_map =valor_renglon_map.replaceAll(atributo, valor);

				mapenvio.put(e.getKey(), valor_renglon_map);

			}
		}

	}
	/**
	 * Agrega todos los rectangulos a la plantillla
	 * @param mapenvio
	 */
	public void setAtributoMapRectangulos(HashMap mapenvio){
		Iterator itr = map_plantilla.entrySet().iterator();
		String valor_renglon_map = "";
		while (itr.hasNext()) {
			Map.Entry e = (Map.Entry)itr.next();
			valor_renglon_map = map_plantilla.containsKey(e.getKey())?(String)map_plantilla.get(e.getKey()):null;
			if (valor_renglon_map.contains("rectangle")){
				mapenvio.put(e.getKey(), valor_renglon_map);
			}
		}
	}
	
	/**
	 * Abre el archivo que contiene la informaci�n y para cada registro
	 * crea un MAP que contiene toda la plantilla a imprimir para despues agregarlo
	 * a un arreglo el cual sera devuelto 
	 * @param pathfile
	 * @return un arreglo de Maps contieniendo todos los mapeos paa las etiquetas deseadas
	 */
	private ArrayList getEtiquetasMap(String pathfile) {
		ArrayList arr_registros = new ArrayList();
		Envio envio = new Envio();
		Envio envio_acuse = new Envio();
		
		FileManager fileManager = new FileManager();

		String[] split_envio = null;
		String[] registros = fileManager.readFileArray(pathfile);
		 HashMap map_plantilla_envio =null;
		 
		try {
			for (int i = 0; i < registros.length; i++) {

				//Solo toma los datos validos
				if ((registros[i] == null)
						|| (registros[i].trim().length() < 20)) {
					continue;
				}
				//Crea el MAP del envio
				map_plantilla_envio = new HashMap();
				
				split_envio = registros[i].split("\\|", -1);
				//Mapea los elementos de las cadenas
				setElementoMap(split_envio,map_plantilla_envio,false);
				arr_registros.add(map_plantilla_envio);
				
				// Si el registro es acuse se agrega un nuevo registro con los
				// mismos datos pero con la bandera acuese, siendo el original no acuse
				envio.setAcuse(split_envio[28]);
				
				if (envio.isAcuse()) {
					if (!this.acuseSoloLeyenda){
						//Imprime otra eqieuta
						map_plantilla_envio = new HashMap();
						setElementoMap(split_envio,map_plantilla_envio,true);
						arr_registros.add(map_plantilla_envio);
					}else{
						//Imprime solo leyenda
						if (split_envio.length>27){
							setAtributoMapEnvio(map_plantilla_envio,"acuse","ACUSE");	
						}
						
					}
				} 

			}
		} catch (Exception e) {

		}
		return arr_registros;
	}

	private ArrayList getEtiquetasMap(String pathfile,List<Envio> ar_envios) {
		ArrayList arr_registros = new ArrayList();
		//Envio envio = new Envio();
		//Envio envio_acuse = new Envio();
		
		//FileManager fileManager = new FileManager();

		//String[] split_envio = null;
		//String[] registros = fileManager.readFileArray(pathfile);
		HashMap map_plantilla_envio =null;
		 
		try {
			for (Envio mienvio : ar_envios) {

				//Crea el MAP del envio
				map_plantilla_envio = new HashMap();
				//Mapea los elementos de las cadenas
				setElementoMap(mienvio,map_plantilla_envio,false);
				arr_registros.add(map_plantilla_envio);
				
				// Si el registro es acuse se agrega un nuevo registro con los
				// mismos datos pero con la bandera acuese, siendo el original no acuse
				//envio.setAcuse();
				if (mienvio.isAcuse()) {
					if (!this.acuseSoloLeyenda){
						//Imprime nueva eqtiqueta
						map_plantilla_envio = new HashMap();
						setElementoMap(mienvio,map_plantilla_envio,true);
						arr_registros.add(map_plantilla_envio);
					}else{
						//Imprime solo etiqueta
						setAtributoMapEnvio(map_plantilla_envio,"acuse","ACUSE");	
					}
					

				} 

			}
		} catch (Exception e) {
			debug("Error en getEtiquetasMap:" + e.getMessage());
		}
		return arr_registros;
	}
	/**
	 * Mapea todos los elementos de la pantilla por registro del archivo
	 * @param split_envio
	 * @param map_plantilla_envio
	 * @param isAcuse
	 */
	private void setElementoMap(String[] split_envio,HashMap map_plantilla_envio,boolean isAcuse){
		try{
			//Agrega la etiquetas de derechos
			String fechaimpresion = Fechas.fechaTexto(Calendar.getInstance(), true);
			String fechahoraimpresion = Fechas.fechaHoraTexto(Calendar.getInstance(), true);

			setAtributoMapEnvio(map_plantilla_envio,"fechaimpresion",fechaimpresion);
			setAtributoMapEnvio(map_plantilla_envio,"fechaimpresionhora",fechahoraimpresion);
			setAtributoMapEnvio(map_plantilla_envio,"derresevados","");
			
			
			//Agrega todos los rectangulos e imagenes
			setAtributoMapRectangulos(map_plantilla_envio);
			
			//Agrega la etiquetas de datos guia , remitente ydestin
			setAtributoMapEnvio(map_plantilla_envio,"idenvio",split_envio[0]);
			setAtributoMapEnvio(map_plantilla_envio,"rutaentrega",split_envio[1]);
			//setAtributoMapEnvio(map_plantilla_envio,"enruta",split_envio[1]);
			setAtributoMapEnvio(map_plantilla_envio,"descservicio",split_envio[2]);

			setAtributoMapEnvio(map_plantilla_envio,"empresarem",split_envio[3]);
			setAtributoMapEnvio(map_plantilla_envio,"atencionrem",split_envio[4]);
			setAtributoMapEnvio(map_plantilla_envio,"direccionrem",split_envio[5]);
			setAtributoMapEnvio(map_plantilla_envio,"coloniarem",split_envio[6]);
			setAtributoMapEnvio(map_plantilla_envio,"municipiorem",split_envio[7]);
			setAtributoMapEnvio(map_plantilla_envio,"estadorem",split_envio[8]);
			setAtributoMapEnvio(map_plantilla_envio,"cprem",split_envio[9]);
			setAtributoMapEnvio(map_plantilla_envio,"telefonorem",split_envio[10]);
			
			setAtributoMapEnvio(map_plantilla_envio,"empresades",split_envio[11]);
			setAtributoMapEnvio(map_plantilla_envio,"atenciondes",split_envio[12]);
			setAtributoMapEnvio(map_plantilla_envio,"direcciondes",split_envio[13]);
			setAtributoMapEnvio(map_plantilla_envio,"coloniades",split_envio[14]);
			setAtributoMapEnvio(map_plantilla_envio,"municipiodes",split_envio[15]);
			setAtributoMapEnvio(map_plantilla_envio,"estadodes",split_envio[16]);
			setAtributoMapEnvio(map_plantilla_envio,"cpdes",split_envio[17]);
			setAtributoMapEnvio(map_plantilla_envio,"telefonodes",split_envio[18]);

			
			setAtributoMapEnvio(map_plantilla_envio,"contenido",split_envio[19]);
			setAtributoMapEnvio(map_plantilla_envio,"peso",split_envio[20]);
			setAtributoMapEnvio(map_plantilla_envio,"observacion",split_envio[21]);
			setAtributoMapEnvio(map_plantilla_envio,"multiples",split_envio[22]);
			String multiples_str = getStringArray(split_envio,22);
			//Cambia la cadena de multiples de 1/1  a 1 DE 1 y se puede referenciar
			//con la variable multiplede
			if (multiples_str!=null){
				multiples_str = multiples_str.replaceAll("/", " DE ");
			}
			setAtributoMapEnvio(map_plantilla_envio,"multiplede",multiples_str);
			setAtributoMapEnvio(map_plantilla_envio,"referencia",split_envio[24]);  
			setAtributoMapEnvio(map_plantilla_envio,"monto",split_envio[25]);

			setAtributoMapEnvio(map_plantilla_envio,"seguro",split_envio[26]);

			//envio.setMultiples(split_envio[22]); // 22.-MULTIPLES
			//envio.setCantidad(split_envio[23]); // 23.-CANTIDAD
			
			
			try {
				if (split_envio[27]!=null){
					setAtributoMapEnvio(map_plantilla_envio,"enruta",split_envio[27]);
				}
				
			} catch (Exception e) {

			}
			try {
				if (isAcuse){
					setAtributoMapEnvio(map_plantilla_envio,"acuse",split_envio[28]);	
				}
				
				// ACUSE
			} catch (Exception e) {

			}

			if (split_envio.length > 29) {
				setAtributoMapEnvio(map_plantilla_envio,"origen",split_envio[29]);	
				setAtributoMapEnvio(map_plantilla_envio,"destino",split_envio[30]);	
				setAtributoMapEnvio(map_plantilla_envio,"logo",split_envio[31]);	
				
			}

			if (split_envio.length >= 33) {
				setAtributoMapEnvio(map_plantilla_envio,"desgarantia",split_envio[32]); 	
				setAtributoMapEnvio(map_plantilla_envio,"numcliente",split_envio[33]); 	
			}

			if (split_envio.length >= 34) {
				setAtributoMapEnvio(map_plantilla_envio,"singarantia",split_envio[34]); 
				setAtributoMapEnvio(map_plantilla_envio,"ocurre",split_envio[35]); 
				setAtributoMapEnvio(map_plantilla_envio,"enruta",split_envio[27]); 	
			}
			//Alto, ancho, largo
			setAtributoMapEnvio(map_plantilla_envio,"ancho",getStringArray(split_envio,36)); 	
			setAtributoMapEnvio(map_plantilla_envio,"largo",getStringArray(split_envio,37)); 	
			setAtributoMapEnvio(map_plantilla_envio,"alto", getStringArray(split_envio,38)); 	
			
			
			//Obtiene todos los atributos del envio
			String guia_5_caracteres = split_envio[0].substring(split_envio[0].trim().length() - 5);
			setAtributoMapEnvio(map_plantilla_envio,"guiarapida",guia_5_caracteres); 
			
			Envio envio = maperaEnvio(split_envio);
			String datosEnvio = envio.getInfoEnvio().replaceAll("\\|", "~");
			setAtributoMapEnvio(map_plantilla_envio,"infoenvio",datosEnvio); 
			
			//Etiquetas paqueteria
			setAtributoMapEnvio(map_plantilla_envio,"paqueteria", getStringArray(split_envio,38)); 	
			
			//Agrega la ruta entrega
		}catch(Exception e){
			debug("Error en setElementoMap:" + e.getMessage());
			e.printStackTrace();
			
		}
	}
	
	private void setElementoMap(Envio envio,HashMap map_plantilla_envio,boolean isAcuse){
		try{
			//Agrega la etiquetas de derechos
			String fechaimpresion = Fechas.fechaTexto(Calendar.getInstance(), true);
			String fechahoraimpresion = Fechas.fechaHoraTexto(Calendar.getInstance(), true);

			setAtributoMapEnvio(map_plantilla_envio,"fechaimpresion",fechaimpresion);
			setAtributoMapEnvio(map_plantilla_envio,"fechahoraimpresion",fechahoraimpresion);
			setAtributoMapEnvio(map_plantilla_envio,"derresevados","");
			
			
			//Agrega todos los rectangulos e imagenes
			setAtributoMapRectangulos(map_plantilla_envio);
			
			//Agrega la etiquetas de datos guia , remitente ydestin
			setAtributoMapEnvio(map_plantilla_envio,"reimpresion",envio.getReimpresion());
			setAtributoMapEnvio(map_plantilla_envio,"idenvio",envio.getIdEnvio());
			setAtributoMapEnvio(map_plantilla_envio,"fuerzaventas",envio.getFuerzaventas());
			setAtributoMapEnvio(map_plantilla_envio,"ciclo",envio.getCiclo());
	
			setAtributoMapEnvio(map_plantilla_envio,"rutaentrega",envio.getRuta());
			setAtributoMapEnvio(map_plantilla_envio,"descservicio",envio.getDes_servicio());

			setAtributoMapEnvio(map_plantilla_envio,"empresarem",envio.remitente.getRazonSocial());
			setAtributoMapEnvio(map_plantilla_envio,"atencionrem",envio.remitente.getAtencion());
			setAtributoMapEnvio(map_plantilla_envio,"direccionrem",envio.remitente.getDireccion());
			setAtributoMapEnvio(map_plantilla_envio,"callerem",envio.remitente.getCalle());
			setAtributoMapEnvio(map_plantilla_envio,"coloniarem",envio.remitente.getColonia());
			setAtributoMapEnvio(map_plantilla_envio,"municipiorem",envio.remitente.getMunicipio());
			setAtributoMapEnvio(map_plantilla_envio,"estadorem",envio.remitente.getEstado());
			setAtributoMapEnvio(map_plantilla_envio,"cprem",envio.remitente.getCp());
			setAtributoMapEnvio(map_plantilla_envio,"telefonorem",envio.remitente.getTelefono());
			setAtributoMapEnvio(map_plantilla_envio,"paisrem",envio.remitente.getPais());
			
			setAtributoMapEnvio(map_plantilla_envio,"numinteriorrem",envio.remitente.getNuminterior());
			setAtributoMapEnvio(map_plantilla_envio,"numexteriorrem",envio.remitente.getNumexterior());
			
			setAtributoMapEnvio(map_plantilla_envio,"numinteriordes",envio.destinatario.getNuminterior());
			setAtributoMapEnvio(map_plantilla_envio,"numexteriordes",envio.destinatario.getNumexterior());

			
			setAtributoMapEnvio(map_plantilla_envio,"empresades",envio.destinatario.getRazonSocial());
			setAtributoMapEnvio(map_plantilla_envio,"atenciondes",envio.destinatario.getAtencion());
			setAtributoMapEnvio(map_plantilla_envio,"direcciondes",envio.destinatario.getDireccion());
			setAtributoMapEnvio(map_plantilla_envio,"calledes",envio.destinatario.getCalle());
			setAtributoMapEnvio(map_plantilla_envio,"coloniades",envio.destinatario.getColonia());
			setAtributoMapEnvio(map_plantilla_envio,"municipiodes",envio.destinatario.getMunicipio());
			setAtributoMapEnvio(map_plantilla_envio,"estadodes",envio.destinatario.getEstado());
			setAtributoMapEnvio(map_plantilla_envio,"cpdes",envio.destinatario.getCp());
			setAtributoMapEnvio(map_plantilla_envio,"telefonodes2",envio.destinatario.getTelefono2());
			setAtributoMapEnvio(map_plantilla_envio,"telefonodes",envio.destinatario.getTelefono());
			setAtributoMapEnvio(map_plantilla_envio,"paisdes",envio.destinatario.getPais());
			setAtributoMapEnvio(map_plantilla_envio,"ciudaddes",envio.destinatario.getCiudad());
			
			setAtributoMapEnvio(map_plantilla_envio,"referenciades",envio.destinatario.getReferencia());

			setAtributoMapEnvio(map_plantilla_envio,"contenido",envio.getContenido());
//			setAtributoMapEnvio(map_plantilla_envio,"peso",envio.getPeso()+"");
			setAtributoMapEnvio(map_plantilla_envio,"observacion",envio.getComentario());
			setAtributoMapEnvio(map_plantilla_envio,"guiainternacional",envio.getIdguiainternacional());
			setAtributoMapEnvio(map_plantilla_envio,"guiainternacional",envio.getIdguiainternacional());
			
			if(!envio.getMultiples().equals("1/1")){
				
				setAtributoMapEnvio(map_plantilla_envio,"multiples",envio.getMultiples());
				setAtributoMapEnvio(map_plantilla_envio,"mult","MULT");
			}
			
//			setAtributoMapEnvio(map_plantilla_envio,"multiples",envio.getMultiples());
			setAtributoMapEnvio(map_plantilla_envio,"remesa",envio.getIdguiamadremultiple());
			
			setAtributoMapEnvio(map_plantilla_envio,"alto",String.valueOf(envio.getAlto()));
			setAtributoMapEnvio(map_plantilla_envio,"largo",String.valueOf(envio.getLargo()));
			setAtributoMapEnvio(map_plantilla_envio,"ancho",String.valueOf(envio.getAncho()));
			String pv = "";
			if(envio.getPeso_volumetrico() != 0.0){
				
				DecimalFormat df = new DecimalFormat("#.000");
				
				pv = String.valueOf(df.format(envio.getPeso_volumetrico()));
				 
			}
			setAtributoMapEnvio(map_plantilla_envio,"peso",pv);

			setAtributoMapEnvio(map_plantilla_envio,"referencia",envio.getReferencia());  
			List<CruceCoberturaDTO> cobertura = envio.getArr_transbordos();
			String terminal_ori="";
			String terminal_des="";
			String precio="";
			int indice=1;
			if (cobertura!=null && cobertura.size()>0){
				for (CruceCoberturaDTO cruceCoberturaDTO : cobertura) {
					   
				    terminal_ori="terminal_ori"+indice;
				    terminal_des="terminal_des"+indice;
				    precio="precio"+indice;
				    indice++;
				   
				    setAtributoMapEnvio(map_plantilla_envio,terminal_ori, cruceCoberturaDTO.getTerminal_ori());
				    setAtributoMapEnvio(map_plantilla_envio,terminal_des, cruceCoberturaDTO.getTerminal_des());
				    setAtributoMapEnvio(map_plantilla_envio,precio, cruceCoberturaDTO.getPrecio()+"");
				    
				    
				}
				//Inicializa los valores siguientes 
				for (int i = indice; i < 15; i++) {
					 terminal_ori="terminal_ori"+i;
					 terminal_des="terminal_des"+i;
					 precio="precio"+i;
				
					 setAtributoMapEnvio(map_plantilla_envio,terminal_ori, "");
					 setAtributoMapEnvio(map_plantilla_envio,terminal_des, "");
					 setAtributoMapEnvio(map_plantilla_envio,precio, "");
				}
			}else{
				//Inicializa vacios
				for (int i = 0; i < 15; i++) {
					 terminal_ori="terminal_ori"+i;
					 terminal_des="terminal_des"+i;
					 precio="precio"+i;
					    
					 setAtributoMapEnvio(map_plantilla_envio,terminal_ori, "");
					 setAtributoMapEnvio(map_plantilla_envio,terminal_des, "");
					 setAtributoMapEnvio(map_plantilla_envio,precio, "");
				}
			}
			
			
			if (envio.getLineaenruta1()!=null){
				setAtributoMapEnvio(map_plantilla_envio,"lineaenruta1", envio.getLineaenruta1());
			}else{
				setAtributoMapEnvio(map_plantilla_envio,"lineaenruta1", "");
			}
			if (envio.getLineaenruta2()!=null){
				setAtributoMapEnvio(map_plantilla_envio,"lineaenruta2", envio.getLineaenruta2());
			}else{
				setAtributoMapEnvio(map_plantilla_envio,"lineaenruta2", "");
			}
			if (envio.getLineaenruta3()!=null){
				setAtributoMapEnvio(map_plantilla_envio,"lineaenruta3", envio.getLineaenruta3());
			}else{
				setAtributoMapEnvio(map_plantilla_envio,"lineaenruta3", "");
			}
			if (envio.getLineaenruta4()!=null){
				setAtributoMapEnvio(map_plantilla_envio,"lineaenruta4", envio.getLineaenruta4());
			}else{
				setAtributoMapEnvio(map_plantilla_envio,"lineaenruta4", "");
			}
			
			
			setAtributoMapEnvio(map_plantilla_envio,"oficinacontrol", envio.getOficinacontrol());
			setAtributoMapEnvio(map_plantilla_envio,"descripcionfolioconvenio", envio.getDescripcionfolioconvenio());
			setAtributoMapEnvio(map_plantilla_envio,"adicional", envio.getAdicional());
			
			//setAtributoMapEnvio(map_plantilla_envio,"enruta",envio.getEnrutadoPor());
			if (isAcuse){
				setAtributoMapEnvio(map_plantilla_envio,"acuse","ACUSE");	
			}else{
				setAtributoMapEnvio(map_plantilla_envio,"acuse","");	
			}
			
		
			setAtributoMapEnvio(map_plantilla_envio,"origen",envio.getSiglasOrigen());	
			setAtributoMapEnvio(map_plantilla_envio,"destino",envio.getSiglasDestino());	
			setAtributoMapEnvio(map_plantilla_envio,"logo",envio.getLogo());	
			setAtributoMapEnvio(map_plantilla_envio,"desgarantia",envio.getDes_garantia()); 	
			setAtributoMapEnvio(map_plantilla_envio,"numcliente",envio.getNumCliente()); 
			
			setAtributoMapEnvio(map_plantilla_envio,"singarantia",""); 
			setAtributoMapEnvio(map_plantilla_envio,"ocurre",envio.isOcurre()?"OCURRE":""); 
			//if(envio.isOcurre()){
				setAtributoMapEnvio(map_plantilla_envio,"tipoentrega",envio.isOcurre()?"OCURRE":"DOMICILIO"); 	
			//}
			setAtributoMapEnvio(map_plantilla_envio,"login",envio.getLogin()); 
			setAtributoMapEnvio(map_plantilla_envio,"idoficina",envio.getIdOficina()); 
			setAtributoMapEnvio(map_plantilla_envio,"usuarioimprime",envio.getUsuarioimprime()); 
			
			//Alto, ancho, largo
			setAtributoMapEnvio(map_plantilla_envio,"ancho",envio.getAncho()+""); 	
			setAtributoMapEnvio(map_plantilla_envio,"largo",envio.getLargo()+""); 	
			setAtributoMapEnvio(map_plantilla_envio,"alto", envio.getAlto()+""); 	
			
			//Etiquetas paqueteria
			setAtributoMapEnvio(map_plantilla_envio,"paqueteria", envio.getEnrutadoPor()); 	
			
			
			//Obtiene todos los atributos del envio
			String guia_5_caracteres = envio.getIdEnvio().substring(envio.getIdEnvio().trim().length() - 8);
			setAtributoMapEnvio(map_plantilla_envio,"guiarapida",guia_5_caracteres); 
			
			//Envio envio = maperaEnvio(split_envio);
			String datosEnvio = envio.getInfoEnvio().replaceAll("\\|", "~");
			setAtributoMapEnvio(map_plantilla_envio,"infoenvio",datosEnvio); 
			
			setAtributoMapEnvio(map_plantilla_envio,"seguro", envio.getS_monto()+""); 	
			setAtributoMapEnvio(map_plantilla_envio,"monto", envio.getMonto()+""); 	
		
			/* PASA EL LOGO DEL SEGURO */
			if ("SI".equals(envio.getTiene_seguro())){
					
				setAtributoMapEnvio(map_plantilla_envio,"asegura","/opt/reportejasper/logos/seguroX128.png");
					
			}
			
			/* PASA EL LOGO DE LA CITA */
			if ("S".equals(envio.getTiene_cita())){
					
				setAtributoMapEnvio(map_plantilla_envio,"cita","/opt/reportejasper/logos/cita.png");
					
			}
			
			/*FECHA ESTIMADA ENTREGA WALMART*/
			setAtributoMapEnvio(map_plantilla_envio,"maxedd",envio.getMaxEDD());
			
			//Agrega la ruta entrega
		}catch(Exception e){
			debug("Error en setElementoMap:" + e.getMessage());
			e.printStackTrace();
			
		}
	}
	
	private String getStringArray(String[] arr_str,int indice){
		try{
			return arr_str[indice];
		}catch(Exception e){
			return "";
		}
		
	}

	/**
	 * Abre el archivo que contiene la informaci�n y la agrega a un ArrayList
	 * con instancias de Envio
	 **/
	private ArrayList getEtiqueta(String pathfile) {

		ArrayList arr_registros = new ArrayList();
		Envio envio = new Envio();
		Envio envio_acuse = new Envio();
		// Archivos archivos = new Archivos();

		FileManager fileManager = new FileManager();

		String[] split_envio = null;
		String[] registros = fileManager.readFileArray(pathfile);

		try {
			for (int i = 0; i < registros.length; i++) {

				// Solo toma los datos validos
				if ((registros[i] == null)
						|| (registros[i].trim().length() < 20)) {
					continue;
				}

				split_envio = registros[i].split("\\|", -1);
				envio = maperaEnvio(split_envio);

				/*envio.setIdEnvio(split_envio[0]); // 0.-GUIA
				envio.setRuta(split_envio[1]); // 1.-RUTA
				envio.setDes_servicio(split_envio[2]); // 2.-SERVICIO
				envio.remitente.setRazonSocial(split_envio[3]); // 3.-EMPRESA_RE
				envio.remitente.setAtencion(split_envio[4]); // 4.-ATENCION_RE
				envio.remitente.setDireccion(split_envio[5]); // 5.-DIRECCION_RE
				envio.remitente.setColonia(split_envio[6]); // 6.-COLONIA_RE
				envio.remitente.setMunicipio(split_envio[7]); // 7.-MUNICIPIO_RE
				envio.remitente.setEstado(split_envio[8]); // 8.-ESTADO_RE
				envio.remitente.setCp(split_envio[9]); // 9.-CP_RE

				envio.remitente.setTelefono(split_envio[10]); // 10.-TELEFONO_RE
				envio.destinatario.setRazonSocial(split_envio[11]); // 11.-
																	// EMPRESA_DE
				envio.destinatario.setAtencion(split_envio[12]); // 12.-
																	// ATENCION_DE
				envio.destinatario.setDireccion(split_envio[13]); // 13.-
																	// DIRECCION_DE
				envio.destinatario.setColonia(split_envio[14]); //14.-COLONIA_DE
				envio.destinatario.setMunicipio(split_envio[15]); // 15.-
																	// MUNICIPIO_DE
				envio.destinatario.setEstado(split_envio[16]); // 16.-ESTADO_DE
				envio.destinatario.setCp(split_envio[17]); // 17.-CP_DE
				envio.destinatario.setTelefono(split_envio[18]); // 18.-
																	// TELEFONO_DE

				envio.setContenido(split_envio[19]); // 19.-CONTENIDO
				envio.setPeso(split_envio[20]); // 20.-PESO
				envio.setComentario(split_envio[21]); // 21.-COMENTARIO
				envio.setMultiples(split_envio[22]); // 22.-MULTIPLES
				envio.setCantidad(split_envio[23]); // 23.-CANTIDAD
				envio.setReferencia(split_envio[24]); // 24.-REFERENCIA
				envio.setMonto(split_envio[25]); // 25.-MONTO

				envio.setCantAsegurada(split_envio[26]); // 26.-SEGURO
				envio.setFactura("");
				try {
					envio.setEnrutadoPor(split_envio[27]); // 27.-RUTA DE
															// TRANSPORTE
				} catch (Exception e) {

				}
				try {
					envio.setAcuse(split_envio[28]);// 28.iNDICA SI EL REGISTRO
													// ES
					// ACUSE
				} catch (Exception e) {

				}

				if (split_envio.length > 29) {
					envio.setSiglasOrigen(split_envio[29]);// 29.SIGLAS DE
															// ORIGEN
					envio.setSiglasDestino(split_envio[30]);// 30.SIGLAS DE
															// DESTINO
					envio.setLogo(split_envio[31]);// 31.-RUTA DEL LOGO
				}

				if (split_envio.length >= 33) {
					envio.setDes_garantia(split_envio[32]);// 32.-Descripcion de
															// la
					// garantia
					envio.setNumCliente(split_envio[33]);// 33.-Razon Social o
					// numero de cliente que
					// origina la etiqueta
				}

				if (split_envio.length >= 34) {
					envio.setObserva1(split_envio[34]);// 34.- Leyenda de sin
														// garantia
					envio.setOcurre(split_envio[35]);
				}*/

				// Si el registro es acuse se agrega un nuevo registro con los
				// mismos datos
				// pero con la bandera acuese, siendo el original no acuse
				if (envio.isAcuse()) {
					envio.setAcuse(false);
					arr_registros.add(envio);
					// El segundo registo lo pone a true para que ponga los
					// datos
					envio_acuse = getEnvioCopy(envio);
					envio_acuse.setAcuse(true);
					arr_registros.add(envio_acuse);

				} else {
					arr_registros.add(envio);
				}

				//debug(envio.toJSONObject().toString());
			}
		} catch (Exception e) {

		}

		return arr_registros;
	}
	
	/**
	 * Regresa un envio mapeado
	 * @param split_envio
	 * @return
	 */
	private Envio maperaEnvio(String[] split_envio){
		Envio envio = new Envio();

		envio.setIdEnvio(split_envio[0]); // 0.-GUIA
		envio.setRuta(split_envio[1]); // 1.-RUTA
		envio.setDes_servicio(split_envio[2]); // 2.-SERVICIO
		envio.remitente.setRazonSocial(split_envio[3]); // 3.-EMPRESA_RE
		envio.remitente.setAtencion(split_envio[4]); // 4.-ATENCION_RE
		envio.remitente.setDireccion(split_envio[5]); // 5.-DIRECCION_RE
		envio.remitente.setColonia(split_envio[6]); // 6.-COLONIA_RE
		envio.remitente.setMunicipio(split_envio[7]); // 7.-MUNICIPIO_RE
		envio.remitente.setEstado(split_envio[8]); // 8.-ESTADO_RE
		envio.remitente.setCp(split_envio[9]); // 9.-CP_RE

		envio.remitente.setTelefono(split_envio[10]); // 10.-TELEFONO_RE
		envio.destinatario.setRazonSocial(split_envio[11]); // 11.-
															// EMPRESA_DE
		envio.destinatario.setAtencion(split_envio[12]); // 12.-
															// ATENCION_DE
		envio.destinatario.setDireccion(split_envio[13]); // 13.-
															// DIRECCION_DE
		envio.destinatario.setColonia(split_envio[14]); //14.-COLONIA_DE
		envio.destinatario.setMunicipio(split_envio[15]); // 15.-
															// MUNICIPIO_DE
		envio.destinatario.setEstado(split_envio[16]); // 16.-ESTADO_DE
		envio.destinatario.setCp(split_envio[17]); // 17.-CP_DE
		envio.destinatario.setTelefono(split_envio[18]); // 18.-
															// TELEFONO_DE

		envio.setContenido(split_envio[19]); // 19.-CONTENIDO
		envio.setPeso(split_envio[20]); // 20.-PESO
		envio.setComentario(split_envio[21]); // 21.-COMENTARIO
		envio.setMultiples(split_envio[22]); // 22.-MULTIPLES
		envio.setCantidad(split_envio[23]); // 23.-CANTIDAD
		envio.setReferencia(split_envio[24]); // 24.-REFERENCIA
		envio.setMonto(split_envio[25]); // 25.-MONTO

		envio.setCantAsegurada(split_envio[26]); // 26.-SEGURO
		envio.setFactura("");
		try {
			envio.setEnrutadoPor(split_envio[27]); // 27.-RUTA DE
													// TRANSPORTE
		} catch (Exception e) {

		}
		try {
			envio.setAcuse(split_envio[28]);// 28.iNDICA SI EL REGISTRO
											// ES
			// ACUSE
		} catch (Exception e) {

		}

		if (split_envio.length > 29) {
			envio.setSiglasOrigen(split_envio[29]);// 29.SIGLAS DE
													// ORIGEN
			envio.setSiglasDestino(split_envio[30]);// 30.SIGLAS DE
													// DESTINO
			envio.setLogo(split_envio[31]);// 31.-RUTA DEL LOGO
		}

		if (split_envio.length >= 33) {
			envio.setDes_garantia(split_envio[32]);// 32.-Descripcion de
													// la
			// garantia
			envio.setNumCliente(split_envio[33]);// 33.-Razon Social o
			// numero de cliente que
			// origina la etiqueta
		}

		if (split_envio.length >= 34) {
			envio.setObserva1(split_envio[34]);// 34.- Leyenda de sin
												// garantia
			envio.setOcurre(split_envio[35]);
			envio.setEnrutadoPor(split_envio[27]); //Enrutamiento
		}

		return envio;

	}

	/** Devuelve un objeto de tipo Envio con todos los datos del envio actual */
	public Envio getEnvioCopy(Envio envioM) {
		Envio multiple = new Envio();

		multiple.setIdEnvio(envioM.getIdEnvio());
		multiple.destinatario = envioM.destinatario;
		multiple.remitente = envioM.remitente;
		multiple.confirmacion = envioM.confirmacion;
		multiple.pagare = envioM.pagare;

		// Obtiene los datos del envio
		multiple.setCrea_Pagare(envioM.isCrea_Pagare());
		multiple.setCantidad(envioM.getCantidad());
		multiple.setComentario(envioM.getComentario());

		multiple.setReferencia(envioM.getReferencia());
		multiple.setContenido(envioM.getContenido());

		multiple.setAdicional(envioM.getAdicional());
		multiple.setServicio(envioM.getServicio());

		multiple.setMultiples(envioM.getMultiples());
		multiple.setGarantia(envioM.getGarantia());

		// multiple.setDes_adicional(envioM.getDes_adicional());
		multiple.setDes_formato(envioM.getDes_formato());
		multiple.setDes_garantia(envioM.getDes_garantia());

		multiple.setDes_servicio(envioM.getDes_servicio());
		multiple.setRutaRemitente(envioM.getRutaRemitente());

		multiple.setRuta(envioM.getRuta());
		multiple.setPeso(envioM.getPeso());
		multiple.setEnrutadoPor(envioM.getEnrutadoPor());
		multiple.setAcuse(envioM.isAcuse());

		multiple.setNumCliente(envioM.getNumCliente());

		multiple.setSiglasOrigen(envioM.getSiglasOrigen());// 28.SIGLAS DE
		// ORIGEN
		multiple.setSiglasDestino(envioM.getSiglasDestino());// 29.SIGLAS DE
		// DESTINO
		multiple.setLogo(envioM.getLogo());// 30.-RUTA DEL LOGO

		return multiple;
	}// fin de getEnvioMultiple
}// LabelIETWEB
