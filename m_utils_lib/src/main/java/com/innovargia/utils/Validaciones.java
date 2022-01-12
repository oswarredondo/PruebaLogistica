/**
 * 
 */
package com.innovargia.utils;




/**
 * @author aruaro
 * 
 */
public class Validaciones {

	
	
	/* M�todo que tiene la funci�n de validar el curp */
	public static boolean validarCurp(String curp) {
		curp = curp.toUpperCase().trim();
		return curp.matches("[A-Z]{4}[0-9]{6}[H,M][A-Z]{5}[0-9]{2}");
	}// Cierra m�todo validarCurp

	/* M�todo que tiene la funci�n de validar el n�mero de credencial */
	public  static boolean validarNumCreden(String numCrede) {
		numCrede = numCrede.toUpperCase().trim();
		return numCrede.matches("[A-Za-z]{6}[0-9]{8}[H,M][0-9]{3}");
	}// Cierra m�todo validarNumCreden

	/***
	 * Valida la estructura del RFC de acuerdo al tipo de persona
	 * MORAL="[A-Z]{3}[0-9]{6}[A-Z0-9]{3}", FISICA ="[A-Z]{4}[0-9]{6}[A-Z0-9]{3}"
	 * 
	 * 
	 * @param rfc
	 * @param tipopersona
	 * @return
	 */
	public  static  boolean validarRfc(String rfc, String tipopersona) {
		String expresion = "[A-Z]{4}[0-9]{6}[A-Z0-9]{3}";
		if (tipopersona.equals("MORAL")){
			expresion = "[A-Z]{3}[0-9]{6}[A-Z0-9]{3}";
		}
		rfc = rfc.toUpperCase().trim();
		return rfc.toUpperCase().matches(expresion);
	}// Cierra m�todo validarRFC
	
	/***
	 * Valida que un RFC tenga una estructura valida ya sea de persona MORAL
	 * o fisica asi como su anio. Si la cadena no tiene la estructura de ninguno de los dos
	 * entonces retorna false.
	 * @param rfc
	 * @return
	 */
	public static boolean validaEstructuraRFC(String rfc){
	    //Valida la estructura
	    if (!validarRfc(rfc, "MORAL")){
		    if (!validarRfc(rfc, "FISICA")){
			 return false;
		    }
		  
	    }
	    //Valida los fecha
	    if (!validarFechaRfc(rfc, "MORAL")){
		 if (!validarFechaRfc(rfc, "FISICA")){
		     return false;
		 }
	    }
	    //Si llega a este punto es que paso ambas validaciones
	    return true;
	}
	
	/***
	 * Valida que la fecha de un RFC sea valida, se debe indicar si 
	 * la persona es MORAL o FISICA para que tome las subcadenas de forma correcta
	 * 
	 * @param rfc
	 * @param tipopersona
	 * @return
	 */
	public  static  boolean validarFechaRfc(String rfc, String tipopersona) {
		//"MORA710305gz9"
		String anio=rfc.substring(4,6);
		String mes=rfc.substring(6,8);
		String dia=rfc.substring(8,10);

		
		try{
			if (tipopersona.equals("MORAL")){
				anio=rfc.substring(3,5);
				mes=rfc.substring(5,7);
				dia=rfc.substring(7,9);
			}
			int ianio = Integer.parseInt(anio);
			int imes = Integer.parseInt(mes);
			int idia = Integer.parseInt(dia);
			
			//System.out.println("ANIO:" +ianio );
			//System.out.println("mes:" + imes);
			//System.out.println("dia:" + idia);
			
			//Realiza las validaciones
			if ((ianio>99) || (imes>12) || (idia>31)){
				//System.out.println("Incorrecto");
				return false;
			}
			
		}catch(Exception e){
			System.out.println("Error Validar RFC:" + e.getMessage());
			return false;
		}
		//Si llega a este punto es correcta
		//System.out.println("Correcto");
		return true;
		
	}// Cierra m�todo validarFechaRFC

}
