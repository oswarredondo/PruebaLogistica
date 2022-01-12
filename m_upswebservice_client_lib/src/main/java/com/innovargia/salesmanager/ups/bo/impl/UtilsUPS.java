/**
 * 
 */
package com.innovargia.salesmanager.ups.bo.impl;

import java.util.HashMap;

import com.ups.xmlschema.xoltws.upss.v1.UPSSecurity;

/**
 * @author aruaro
 *
 */
public class UtilsUPS {

    
    private static HashMap<String, String> hash_tipoEmpaque = new HashMap<String, String>();
	private static HashMap<String, String> hash_tipoMedidaPeso= new HashMap<String, String>();
	private static HashMap<String, String> hash_tipoMedidaDimension= new HashMap<String, String>();
	static{
	    hash_tipoEmpaque.put("00", "Unknown");
	    hash_tipoEmpaque.put("01", "UPS Letter Envelope");
	    hash_tipoEmpaque.put("21", "UPS Express Box");
	    hash_tipoEmpaque.put("03", "UPS Tube");
	    hash_tipoEmpaque.put("25", "UPS Worldwide 10KG Box");
	    hash_tipoEmpaque.put("24", "UPS Worldwide 25KG Box");

	        
	    hash_tipoMedidaPeso.put("LBS", "POUNDS");
	    hash_tipoMedidaPeso.put("KGS", "KILOGRAMS");
	    
	    hash_tipoMedidaDimension.put("IN", "INCHES");
	    hash_tipoMedidaDimension.put("CM", "CENTIMETERS");

	}
	
	public static boolean isTipoEmpaqueUPS(String id){
		return hash_tipoEmpaque.containsKey(id);
	}
	
	public static String getDefaultTipoEmpaqueUPS(){
		return "00";
	}
	
	public static String getTipoEmpaqueUPS(String id){
		if (hash_tipoEmpaque.containsKey(id)){
			 return hash_tipoEmpaque.get(id);
		}else{
			 return hash_tipoEmpaque.get("00");
		}
	   

	}
	public static boolean isMedidaPeso(String id){
		return hash_tipoMedidaPeso.containsKey(id);
	}
	
	public static String getDefaultMedidaPeso(){
		return "KGS";
	}
	
	public static String getMedidaPeso(String id){
		if(hash_tipoMedidaPeso.containsKey(id)){
			return hash_tipoMedidaPeso.get(id);	
		}else{
			return hash_tipoMedidaPeso.get("KGS");	
		}
	    

	}
	
	public static boolean isMedidaDimension(String id){
		return hash_tipoMedidaDimension.containsKey(id);
	}
	public static String getDefaultMedidaDimension(){
		return "CM";
	}
	public static String getMedidaDimension(String id){
		if (hash_tipoMedidaDimension.containsKey(id)){
			 return hash_tipoMedidaDimension.get(id);
		}else{
			 return hash_tipoMedidaDimension.get("CM");
		}
	   

	}
	
	

}
