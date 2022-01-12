/**
 * 
 */
package com.innovargia.utils;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





/**
 *   
 * @author Adrian Morales Ruaro
 *
 */
public class UtilsStrings { 
	public static final String SISTEMA_SILOT="silot";
	public static final String SISTEMA_IETWEB="SKY4SOL";
	public static final String SISTEMA_SIEMBAL="siembal";
	
	public static final int INICIO_CADENA=1;
	public static final int FINAL_CADENA=0;
	
	private static final Logger logger = LoggerFactory
			.getLogger(UtilsStrings.class);
	
	public static HashMap map_IdSistemas = new HashMap();
    //LLena los datos de los sistemas
    static {
    	map_IdSistemas.put(SISTEMA_SILOT,SISTEMA_SILOT);
    	map_IdSistemas.put(SISTEMA_IETWEB,SISTEMA_IETWEB);
    	map_IdSistemas.put(SISTEMA_SIEMBAL,SISTEMA_SIEMBAL);
    }
	/**
	 * 
	 */
	public UtilsStrings() {
		// TODO Auto-generated constructor stub
	}
	 /**Obtiene el identificador del sistema, si este no se encientra registrado regresa null*/
    public static String getIdSistema(String id){
    	if (map_IdSistemas.containsKey(id)) return (String)map_IdSistemas.get(id);
    	
    	return null;
    }
    /**
     * Devuelve una cadena vacia en caso de que sea null
     * isVacio
     * */
    public static boolean isVacio(String s){
    	if (s == null) return true;
    	
    	return (s.trim().length()<=0?true:false);
    }
    
    /**Devuelve una cadena vacia en caso de que sea null*/
    public static String nullChange(String s){
    	if (s == null) return "";
    	
    	return s;
    }
    public static String nullChangeToUpperCase(String s){
    	if (s == null) return "";
    	
    	return quitoAcentos(s.trim().toUpperCase());
    }
    
    //public static final String FILE_PATH="/paquetes/Tomcat_Install/jakarta-tomcat-5.0.28/webapps/sgepweb/tmp/";//"/paquetes/importar/";
    
    /**
     * Devuelve el arreglo de cadenas indicando del tipo de separador
     * @param elementos cadena que contiene los elementos
     * @param separador caracter o cadena que se utiliza como separador
     * @return
     */
    public static String[] creaArreglo(String elementos,String separador){
        if (elementos!=null){
            return elementos.split(separador);
            
        }
        return null;
    }
    
    public static String quitoAcentos(String cadena){
    	if (cadena==null) return cadena;
		   cadena = cadena.trim();
				 
			String output = 	Normalizer
				    .normalize(cadena, Normalizer.Form.NFD)
				    .replaceAll("[^\\p{ASCII}]", "");
					
			return output;
        
    }
    
    
    public static String quitaCaracteresEspeciales(String s){
    	if (s==null) return "";
    	String str_tmp = s;
    	str_tmp = str_tmp.replaceAll("#", "");
		
		str_tmp = str_tmp.replaceAll(",", " ");
		str_tmp = str_tmp.replaceAll(";", " ");
		str_tmp = str_tmp.replaceAll("&", " ");
		str_tmp = str_tmp.replaceAll("\"", " ");
		str_tmp = str_tmp.replaceAll("'", " ");
		str_tmp = str_tmp.replaceAll(">", " ");
		str_tmp = str_tmp.replaceAll("<", " ");
		str_tmp = str_tmp.replaceAll("\"", " ");
		
		str_tmp = str_tmp.replaceAll("'", " ");
		str_tmp = str_tmp.replace("\\", "/");
		str_tmp = str_tmp.replaceAll("/", " ");
		str_tmp = str_tmp.replaceAll("null"," ");
        
        return str_tmp;
        
    }
    
    public static boolean isCorrectMinMaxLengthString(String s,int minLength, int maxLength){
    	s = s==null?"":s.trim();
    	boolean returnValue = true;
    	if (s.length()<minLength){
    		//logger.debug(s.trim() + " no cumple con el largo minimo:" + minLength);
    		returnValue=false;
    	}else if (s.length()>maxLength){
    		//logger.debug(s.trim() + " no cumple con el largo maximo:" + maxLength);
    		returnValue=false;
    	}else{
    		//logger.debug(s.trim() + "  cumple con lo requerido.");
    		returnValue=true;      
    	}
    	
    	return returnValue;
    }
    
    /**
     * Obtiene los datos del campo indicando las posiciones
     * Cuando el final es -1 entonces se toma de la posicion incial
     * hasta el resto de la cade
     * @param cadena
     * @param inicia
     * @param termina
     * @return
     */
    public static  String getDatoLinea(String cadena, int inicia, int termina) {
		String cadena_tmp = null;
		
		try {
			if (cadena != null) {
				if (termina == -1) {
					if (cadena.length() >= inicia) {
						cadena_tmp = cadena.substring(inicia);
					}

				} else {
					if (cadena.length() > termina) {
						cadena_tmp = cadena.substring(inicia, termina);
					}else if (cadena.length() == termina) {
						cadena_tmp = cadena.substring(inicia, termina-1);
						
					}else{
						cadena_tmp = cadena.substring(inicia);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception getDatoLinea: " + e.getMessage());
		}

		return cadena_tmp;

	}
    
    public static  void getPosicionesCharLinea(String cadena) {
  		String cadena_tmp = null;
  		for (int i=0;i<cadena.length();i++){
  			System.out.println("Char:" + i + "-"+ cadena.charAt(i));
  		}
  	
  	}
    
    //metodo para validar correo electronio
    public static boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;        
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }        
    }
    
    public static  String completa(String original, char caracter, int hasta, int iniciofinal){
    	//INICIO DEL LA CADERNA
    	if (iniciofinal==INICIO_CADENA){  //1
    		while (original.trim().length() < hasta) {
        		original = caracter + original;
    		}
    	}
    	//FINAL DE LA CADENA
    	if (iniciofinal==FINAL_CADENA){
    		while (original.trim().length() < hasta) {
        		original = original + caracter  ;
    		}
    	}
    	return original;

    }
    //

    /***
     * Da formato a una cadena envuelta entre comillas y separada por comas
     * Si entra 123,123 devuelve '123','123'
     * Si entra 123','123 devuelve '123','123'
     * Si entra '123,123' devuelve '123','123'
     * Si entra '123',123' devuelve '123','123'
     * 
     * @param value
     * @return
     */
	public static String formateaCadenaComillas(String value){
	    	
	    	if (value==null || value.isEmpty()){
	    	    return null;
	    	}
	    	
	    	if (",".equals(value.trim())){
	    	    return null;
	    	}else{
	    	    	//En caso de que el ultimo caracter de la cadena 
	    	    	//sea una coma la elimina
        	    	String char_str = value.substring(value.length()-1);
        	    	if (",".equals(char_str)){
        	    	    value = value.substring(0,value.length()-1);
        	    	}
	    	}
	    	
		//Primero a comas paa evitar que se pongan incompletos
		value = value.replaceAll("','", ",");
		if (!value.contains("','")){
			value = value.replaceAll("'", "");
			//Formate correctamente la separaci�n con comillas
			value =value.replace(",", "','");
			
		}
		if (!"'".equals(value.charAt(0)+"")){
			value = "'"+value;
		}
		if (!"'".equals(value.charAt(value.length()-1)+"")){
			value = value+ "'";
		}
		
		return value;  
   
	}
	
	public static String eliminaDuplicados(String cadena, String separador) {
		String[] arr_  = cadena.split(separador);
		arr_ = eliminaDuplicados(arr_);
		
		String cadena_final = formateaCadenaComillas(arr_);
	
		return cadena_final;

	}
	
	public static String[] eliminaDuplicados(String[] arr_) {
		HashMap<String, String> map = new HashMap<String, String>();
		ArrayList<String> arr_final = new ArrayList<String>();
		for (String string : arr_) {
			if (!map.containsKey(string)) {
				arr_final.add(string);
				map.put(string, string);
			}
		}

		String list2[] = new String[arr_final.size()];
		list2 = arr_final.toArray(list2);

		return list2;

	}
	
	public static String formateaCadenaComillas(String[] value){
	    String cadena ="";
	    if ((value!=null) && (value.length>0)){
		   for (String str : value) {
		       cadena= cadena + str+",";
		    }
		   String char_str = cadena.substring(cadena.length()-1);
   	    	   if (",".equals(char_str)){
   	    	       cadena = cadena.substring(0,cadena.length()-1);
   	    	   }
		    return formateaCadenaComillas(cadena.trim());  
	    }
	 
	    return null;
	}
	public static float convierteABytes(float megas){
	    int bytes_en_kb = 1024;
	    int kb_en_megas = 1024;
	    float conversion = (megas*kb_en_megas)*bytes_en_kb;
	    return conversion;
	    
	}
}
