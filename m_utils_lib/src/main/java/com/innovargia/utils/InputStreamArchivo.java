/*
 * $id$
 * Autor:
 * Nombre del archivo: InputStreamArchivo.java
 * Descripcion: Clase para manipular inputStreams
 *
 */
package com.innovargia.utils;

import java.io.*;
/**
 * Clase que contiene el el inputstream del archivo upload
 * @author 
 * @version $Id:$
 */
public class InputStreamArchivo {
    
    /** InputStream base. */
    private InputStream _in;
    
    /**
     * LARGO MAXIMO DE LA CADENA
     */
    private static int LARGO_MAX=80;
    
    /**
     * Cantidad de caracteres de la cadena a procesar
     */
    
    private static int CANT_CARACTERES_CADENA=500;
    
    /** Si hemos llegado al final de nuestra base, _in. */
    private boolean _eof = false;
    
    /**
     * Crea nueva instancia para desencriptar InputStream dado.
     */
    public InputStreamArchivo(InputStream in) {
        if (in == null) {
            throw new NullPointerException();
        }
        _in = in;
        
    } // fin constructor
    
    /**
     * Si no hemos llegado al final del InputStream original.
     */
    public boolean hasNext() {
        return !_eof;
    }
    
    /**
     * Regresa la proxima linea del InputStream base. En caso de que la linea mida
     * mas del LARGO_MAX, devuelve una cadena vacia
     *
     * @throws IOException si el fin de input ya fue alcanzado.
     */
    public String next() throws IOException {
        
        if (_eof) {
            throw new IOException("Fin de input ya alcanzado.");
        }
        int chInt;
        char ch;
        int tamano = 0;
        
        //Arreglo que contiene los caracteres obtenidos del archivo
        char[] orig;
        String origCadena="";
        
        //Contiene la nueva cadena en bytes desencriptada
        byte[] nueva;
        
        //Almacena el largo real de la cadena
        int largoCadena=0;
        try{
            //barre el  InputStream si ya no existen bytes retorna -1
            while ((chInt = _in.read()) > -1) {
                
                ch = (char) chInt;
                //Verifica hasta que encuentre un fin de linea o retorno de carro
                if ( (ch == '\r') || (ch == '\n')) {
                    //Convierte la cadena a un arreglo de caracteres
                    orig = origCadena.toCharArray();
                    tamano = orig.length;
                    
                    //verifica que el largo de la cadena
                    if (tamano>LARGO_MAX){
                        largoCadena = LARGO_MAX;
                    }else{
                        largoCadena = tamano;
                    }
                    
                    //Convierte el arrgoglo de bytes a cadena
                    return new String(orig);
                } else {
                    // Agregar otro char para la linea
                    //orig[tamano++] = ch;
                    origCadena += ch;
                }//fin del if
                  
            }//fin del while
            
        }catch(IndexOutOfBoundsException iobe){
            return "";
        }
        // Llegamos al fin de archivo
        _eof = true;
        return "";
    } // fin next
    
} // fin InputStreamArchivo
