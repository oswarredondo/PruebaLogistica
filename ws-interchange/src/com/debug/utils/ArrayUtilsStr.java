package com.debug.utils;

/***
 * ArrayUtilsStr.getValorArreglo(String[] arr, int indice);
 * @author aruaro
 *
 */
public class ArrayUtilsStr {

    /**
     * Regresa el valor del indice indicado o un valor vacio en caso de que no exista
     * @param arr
     * @param indice
     * @return
     */
   public static String getValorArreglo(String[] arr, int indice){
    
       try{
	   if (arr.length>=indice){
		return arr[indice];   
	    }
	   return "";
       }catch(Exception e){
	   return "";
       }
       
       
   }

   /**
    * Corta una cadena con el separador indicado y obtiene el indice
    * @param cadena
    * @param separador
    * @param indice
    * @return
    */
   public static String getValorArreglo(String cadena,String separador, int indice){
       String[] arr = cadena.trim().split(separador,-1);
       try{
	   if (arr.length>=indice){
		return arr[indice];   
	    }
	   return "";
       }catch(Exception e){
	   return "";
       }
       
       
   }
}
