package com.innovargia.utils;

public class Modulo11 {
	
	public static final int INICIO_CADENA=1;
	public static final int FINAL_CADENA=0;
	
	 public static String invertirCadena(String cadena) {
	        String cadenaInvertida = "";
	        for (int x = cadena.length() - 1; x >= 0; x--) {
	            cadenaInvertida = cadenaInvertida + cadena.charAt(x);
	        }
	        return cadenaInvertida;
	    }

	    public static int obtenerSumaPorDigitos(String cadena) {
	        int pivote = 2;
	        int longitudCadena = cadena.length();
	        int cantidadTotal = 0;
	        int b = 1;
	        for (int i = 0; i < longitudCadena; i++) {
	            if (pivote == 8) {
	                pivote = 2;
	            }
	            int temporal = Integer.parseInt("" + cadena.substring(i, b));
	            b++;
	            temporal *= pivote;
	            pivote++;
	            cantidadTotal += temporal;
	        }
	        cantidadTotal = 11 - cantidadTotal % 11;
	        if (cantidadTotal==10){
	        	cantidadTotal=1;
	        }else if (cantidadTotal==11){
	        	cantidadTotal=0;
	        }
	        return cantidadTotal;
	    }
	    
	    public static String agregaDigitoVerificador(String cadena, int poneraliniciofin){
	    	if (poneraliniciofin == INICIO_CADENA){
	    		return  obtenerSumaPorDigitos(invertirCadena(cadena)) +cadena ;
	    	}else{
	    		return cadena + obtenerSumaPorDigitos(invertirCadena(cadena));
	    	}
	    	
	    }

	    public static void main(String args[]) throws Exception {
	       // Modulo11 a = new Modulo11();
	       // System.out.println(a.obtenerSumaPorDigitos(a.invertirCadena("41261533")));
	        
	        System.out.println(obtenerSumaPorDigitos(invertirCadena("123456789123412345671234567898956789")));
	        System.out.println(obtenerSumaPorDigitos(invertirCadena("123456788")));
	        System.out.println(obtenerSumaPorDigitos(invertirCadena("123456787")));
	        System.out.println(obtenerSumaPorDigitos(invertirCadena("123456786")));
	        System.out.println(obtenerSumaPorDigitos(invertirCadena("123456785")));
	        System.out.println(obtenerSumaPorDigitos(invertirCadena("123456784")));
	        System.out.println(obtenerSumaPorDigitos(invertirCadena("123456783")));
	        System.out.println(obtenerSumaPorDigitos(invertirCadena("123456782")));
	        System.out.println(obtenerSumaPorDigitos(invertirCadena("123456781")));
	        System.out.println(obtenerSumaPorDigitos(invertirCadena("123456780")));
	        System.out.println(obtenerSumaPorDigitos(invertirCadena("123456776")));
	        
	        
	    }
}
