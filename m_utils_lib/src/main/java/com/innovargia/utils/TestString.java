package com.innovargia.utils;

public class TestString {

	public TestString() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//UtilsStrings.getPosicionesCharLinea("SP3264481    20130517     170007520            02042013       20150402    45B011LPZ,62,71");
		//UtilsStrings.getPosicionesCharLinea("SP1264351    2013051790039   AMEZCUA DE LA TORRE ALFONSO                                           FLOR DE AZHAR  149                           AMAPOLA Y FLOR DE LIZ              QUINTA BUGAMBILIAS                                                    38060GUANAJUATO                         GTO                                   24845     20130517    201307014616154693-0454611501716- 20130517NORMAL0454611501716                    90039");
		//UtilsStrings.getPosicionesCharLinea("SP2264351    2013051790039   AMEZCUA DE LA TORRE ALFONSO                                           FLOR DE AZHAR  149                           AMAPOLA Y FLOR DE LIZ              QUINTA BUGAMBILIAS                 38060GUANAJUATO                         GTO                                   24845     201307014616154693-0454611501716- 20130517NORMAL0454611501716               OLMECAS - METABOLISMO");         

	
		/*Validaciones.validarFechaRfc("MOR991331GZ9A","MORAL");
		Validaciones.validarFechaRfc("MORA991231GZ9","MORAL1");
		
		System.out.println(GeneradorPassword.getPassword(3));
		System.out.println(GeneradorPassword.getLogin("MORA710305GZ9"));
		System.out.println(GeneradorPassword.getLogin("710305GZ9MORA"));
		System.out.println(GeneradorPassword.getLogin("ESTAFETA MEXICANA"));
		*/
	    String sha1 = CheckSumUtility.encryptaPassWordSHA1("ENTADS");
	    
	    System.out.println("sha1:" + sha1);

		String fecha = UtilsStringFechas.formatoStrFecha("3/3/2016 7:17:00 PM",
				"M/d/yyyy hh:mm:ss aaa", "yyyy-MM-dd HH:mm:ss");
		
		 System.out.println("fecha:" + fecha);
	    
	}

}
