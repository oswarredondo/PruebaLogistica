/*
 * RegistrosLogs.java
 *
 * Created on 17 de marzo de 2006, 04:32 PM
 */

package mx.ws.interchange;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import com.debug.utils.Fechas;
import com.debug.utils.FileManager;
import com.jdbc.interchange.SistemaDao;

/**
 *
 * @author  Meche
 */
public class RegistrosLogs {
	public static final String IDSISTEMA="SKY4SOL";
	
	private String db = null;

	public RegistrosLogs(String db) {
		this.db = db;
	}
    
    /**Contexto para salvar los archvios*/
    public static String COMP_ENV = "java:comp/env";
    /**Contexto para salvar log errores*/
    public static String PATH_ERROR = null;
    public static String PATH_REGISTROS = null;
    
    //Path de registros
    public static String FILE_REGISTROS= fileRegistros();
    
    //Path de registros
    public static String FILE_ERROR= fileError();
    
    /**
     * Manda un mensaje a la bitacora, como debug
     */
    private static void debug(String mensaje){
        //DebugLog.debug(this.getClass(), mensaje);
        System.out.println(mensaje);
    }//fin de debug
    
    private static String fileRegistros(){
        return
        Fechas.formatoFecha(Calendar.getInstance(),"ddd") + "REG" +
        Fechas.formatoFecha(Calendar.getInstance(),"MM") +".A" + Fechas.formatoFecha(Calendar.getInstance(),"yy") ;
    }//fin de fileRegistros
    
    private static String fileError(){
        return
        "Log_Error"+ Fechas.formatoFecha(Calendar.getInstance(),"ddMMyyyy") + ".err";
    }//fin de fileRegistros
    
    public static String fileErrorServer(){
        return
        "Log_Error"+ Fechas.formatoFecha(Calendar.getInstance(),"ddMMyyyy") + ".log";
    }//fin de fileRegistros
    
    
    /** Creates a new instance of Registros */
    private static void iniciaJNDI(String db) {

        try {

        	SistemaDao sistemaDao = new SistemaDao(db);
        	PATH_REGISTROS = sistemaDao.getValorPropiedad(IDSISTEMA,
    				"PathLogAgregado");
        	PATH_ERROR = sistemaDao.getValorPropiedad(IDSISTEMA,
			"PathLogAgregado");;
            
        } catch(Exception e) {
            //manda el error a la bitácora
        	debug("Error al iniciar datos de archivos:" + e.toString());
        }
        
    }
    
    /**Inserta un registro de error para la bitacora de registros procesados */
    public static void insertaError(String error, String db){
        iniciaJNDI(db);
        String path = PATH_ERROR+ File.separator + fileError();
        FileManager manager = new FileManager();
        manager.saveFile(path,error+"\n", true);
        
        
    }//fin de inserta error
    
    /**Inserta un registro de error para la bitacora de registros procesados */
    public static void insertaErrorFile(String error,String path){
        path = path+ File.separator + fileErrorServer();
        FileManager manager = new FileManager();
        manager.saveFile(path,error+"\n", true);
        
        
    }//fin de inserta error
    
    /**Inserta un registro correcto en el log */
    public static void respaldaRegistro(String registro,String db){
        iniciaJNDI(db);
        String path = PATH_REGISTROS+ File.separator + fileRegistros();
        FileManager manager = new FileManager();
        manager.saveFile(path,registro+"\n", true);
        
        
    }//fin de inserta error
    
    /**Obtiene el log de errores*/
   /* public static ArrayList getErroresLog(String db){
        iniciaJNDI(db);
        return getErroresLog(PATH_ERROR+ File.separator + fileError());
    }//fin de getErroresLog
    
    /**Obtiene el log de errores*/
   /* public static ArrayList getFileRegistros(){
        iniciaJNDI();
        return getErroresLog(PATH_REGISTROS+ File.separator + fileRegistros());
    }//fin de getErroresLog
    
    /**Recupera los datos de un archivo y lo agrega el contenido en un arreglo*/
    public static ArrayList getErroresLog(String path){
        
        ArrayList lista = new ArrayList();
        
        StringBuffer sb = new StringBuffer();
        try{
            //
            // Aqui creamos un objeto File que representa el archivo de texto que
            // queremos leer
            //   */
            File file = new File(path);
            
            //
            // Variable temporal que usaremos para leer cada una de las lineas del
            // archivo de texto
            //
            String linea = null;
            
            //
            // BufferReader - Es el encargado de leer el archivo de texto.
            // El constructor recibe como parametro un objeto FileReader, que
            // a s vez recibe el objeto File creado precedentemente.
            //
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            //
            // A traves de este ciclo el BufferReader lee todo el archivo, y lo va acumulando (sb.append) en un StringBuffer
            //
            while ((linea = br.readLine()) != null) {
                lista.add(linea);
                
            }
            
            // Al final de la lectura cerramos el objeto
            br.close();
            
        } catch (FileNotFoundException fnfe){
            //Si damos un nombre de archivo que no existe el sistema genera
            //automaticamente un error.
            
            debug("No ha sido posible encontrar el archivo " + path);
        }
        catch (IOException ioe){
            // Se ha producido un error durante lalectura del archivo
            debug("Se ha producido un error durante la lectura del archivo "+ path);
        }
        return lista;
        
    }//fin de obtener los datos
}//fin de RegistrosLogs



