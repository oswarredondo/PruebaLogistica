package com.innovargia.utils.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * <p>Title: FileManager</p>
 *
 * <p>Description: Manejo de archivos de texto</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * @author
 * @version 1.0
 */

public class FileManager {
     
    public void FileManager(){}
    
    /**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		
	}// fin de debug
    
    /**
     * El metodo readFile lee un archivo de texto y retorna su contenido en
     * formato de StringBuffer
     * @param filename String
     * @return StringBuffer
     */
    public StringBuffer readFile(String filename){
        StringBuffer sb = new StringBuffer();
        try{
            //
            // Aqui creamos un objeto File que representa el archivo de texto que
            // queremos leer
            //   */
            File file = new File(filename);
            
            //
            // Variable temporal que usaremos para leer cada una de las lineas del
            // archivo de texto
            //
            String line = null;
            
            //
            // BufferReader - Es el encargado de leer el archivo de texto.
            // El constructor recibe como parametro un objeto FileReader, que
            // a s vez recibe el objeto File creado precedentemente.
            //
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            // A traves de este ciclo el BufferReader lee todo el archivo, 
            //y lo va acumulando (sb.append) en un StringBuffer
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            
            // Al final de la lectura cerramos el objeto
            br.close();
            
        } catch (FileNotFoundException fnfe){
            //Si damos un nombre de archivo que no existe el sistema genera
            //automaticamente un error.
            
           sb.append("No ha sido posible encontrar el archivo "+ filename);
        }
        catch (IOException ioe){
            // Se ha producido un error durante lalectura del archivo
            sb.append("Se ha producido un error durante la lectura del archivo "+ filename);
        } 
        return sb; 
    }//fin de readFile
    /**
     * Lee el contenido de un InputStreamReader cuando se
     * trata de un archivbo de texto
     * @param ir
     * @return
     */
    public ArrayList<String> getContenidoFileText(InputStreamReader ir){
    	ArrayList<String> lineas = new ArrayList<String> ();
    	try {
			BufferedReader br = new BufferedReader(ir);
			while (br.ready()) {
				lineas.add(br.readLine());
			}
			br.close();
		} catch (IOException ioe) {
			debug("Error en getContenidoFileText: " + ioe.getMessage());
		}
    	
    	return lineas;
    }

    /**
     * El metodo readFile lee un archivo de texto y retorna su contenido en
     * formato de Arreglo de cadenas o null en caso de que no exista informacion
     * @param filename String
     * @return StringBuffer
     */
    public String[] readFileArray(String filename){
        StringBuffer sb = new StringBuffer();
        ArrayList  arr_Registros = new ArrayList();
        try{
            //
            // Aqui creamos un objeto File que representa el archivo de texto que
            // queremos leer
            //   */
            File file = new File(filename);
            
            //
            // Variable temporal que usaremos para leer cada una de las lineas del
            // archivo de texto
            //
            String line = null;
            
            //
            // BufferReader - Es el encargado de leer el archivo de texto.
            // El constructor recibe como parametro un objeto FileReader, que
            // a s vez recibe el objeto File creado precedentemente.
            //
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            // A traves de este ciclo el BufferReader lee todo el archivo, 
            //y lo va acumulando (sb.append) en un StringBuffer
            while ((line = br.readLine()) != null) {
               arr_Registros.add(line);
            }
            
            // Al final de la lectura cerramos el objeto
            br.close();
            
        } catch (FileNotFoundException fnfe){
            System.out.println("Error:"+fnfe.getMessage());
            return null;
        }
        catch (IOException ioe){
        	debug("Error readFileArray:"+ioe.getMessage());
            return null;
        } 
        //Checa si el arreglo contiene registros para poder enviarlos en el arreglo de 
        //cadenas
        if (arr_Registros.size()>0){
            String[] reg_str = new String[arr_Registros.size()];
          
            for (int i=0;i<arr_Registros.size();i++){
                reg_str[i] = (String)arr_Registros.get(i);
            }
            return reg_str;
        }
        return null; 
    }//fin de readFile
    /**
    * Devuelve la ruta padre del subdirectorio actual
    * @param File --> El archivo del cual se quiere sacar su directorio o directorio padre
    * @return File --> Crea un archivo con la ruta del directorio padre
    */
    public File parent(File f) {

    	String dirname = f.getParent();

    	if (dirname == null ) {

    		return new File(File.separator);

    	}

    	return new File(dirname);

    }

    /**
    * Crear un subdirectorio si este no existe
    * @param dir --> El path del archivo (direcci?n + nombre)
    * @return True -> Existe o se ha creado False --> No existe y no se ha podido crear 
    * */
    public boolean makeSureDirectoryExists(File dir) {

    	if (!dir.exists()) {
    		return dir.mkdirs();
    	}
    	return true ;
    }
  
    /**
    * Crear un subdirectorio si este no existe
    * @param dir --> El path del archivo (direcci?n + nombre)
    * @return True -> Existe o se ha creado False --> No existe y no se ha podido crear 
    * */
    public boolean makeSureDirectoryExists(String dir) {
    	File f = new File(dir);
    	return makeSureDirectoryExists(f);
    }



    
    /**
     * Este metodo permite, dada una cadena de caracteres determinada,
     * salvar la misma como un archivo de texto, o agregarla a un archivo ya existente
     *
     * @param filename String
     * @param dataToWrite String
     * @param append boolean
     */ 
    public void saveFile(String filename, String dataToWrite, boolean append) {
        try {
         
            // Creaci?n del objeto FileWriter dado un nombre de archivo determinado
            // El segundo parametro (append) contiene un valore booleano que
            // indica si la informacion recibida debe ser agregada el final del
            // archivo o, en caso contrario, reemplazar la informaci?n ya
            // existente.
            FileWriter fw = new FileWriter(filename, append);
            
            //Escritura de la informacion en el archivo
            fw.write(dataToWrite);
            
            //Se cierra el archivo
            fw.close();
        } catch (IOException ioe) {
            //Se ha producido un error durante la lectura/escritura del archivo
           debug(
            "Se ha producido un error durante la lectura del archivo saveFile:" + ioe.getMessage());
        }
    }//fin de saveFile
    
    
    /**
     * Esta funcion permite, dado un archivo en particular, buscar dentro el mismo
     * determinados valures y cambiarlos por una serie de nuevos valores dados,
     * generando un objeto de tipo String con el resultado
     *
     * @param path String
     * @param valuesToSearch String[] Ejemplo {"NOMRE", "APELLIDO"}
     * @param valuesToReplace String[] Ejemplo {"Fernando Augusto", "Arturi"}
     * @return String
     */
    public String replaceValues(String path, String [] valuesToSearch, String [] valuesToReplace){
        String line;
        StringBuffer textComplete = new StringBuffer();
        String tempText = "";
        
        //Lectura del archivo de texto dado
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null){
                textComplete.append(line);
            }
            br.close();
            
        } catch (FileNotFoundException fnfe){
            //Si damos un nombre de archivo que no existe el sistema
            //genera automaticamente un error.
            debug("No ha sido posible encontrar el archivo replaceValues:"+ path);
        }
        
        catch (IOException ioe) {
            // Se ha producido un error durante la lectura/escritura del archivo
            debug(
            "Se ha producido un error durante la lectura del archivo replaceValues:" + path);
        }
        
        // Una vez completada la fase de lectura del archivo, pasamos a la
        // b?squeda y reemplazo de los valores datos.
        // Para esto generamos un ciclo que recorremos tantas veces como valores
        // que tenemos que procesar.

        for (int i=0; i<valuesToSearch.length; i++){
            int position = textComplete.indexOf(valuesToSearch[i]);
            if (position>0 ){
                tempText = textComplete.substring(0,position);
                //busqueda y reemplazo de la cadena.
                tempText = tempText + valuesToReplace[i] +
                textComplete.substring(position+valuesToSearch[i].length(),textComplete.length());
                textComplete = new StringBuffer(tempText);
            }
        }
        return tempText;
    }//fin de replaceValues
    
}//fin de FileManager
