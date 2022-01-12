/*
 * Prueba de creacion de etiquetas
 */
package com.itext.etiquetas;

//import ietwebimpresion.forms.Envio;

/**
 * @author amoralesr
 */
public class Test {

	public static  void main(String[] args) {
		System.out.println("INICIA");
		String archivo = "C:\\source_jboss\\archivosEjemploEtiquetas\\201302330237766-1010.gui";
		LabelIETWEB ietweb = new LabelIETWEB();
		
		ietweb.setMapPlantilla("C:\\source_jboss\\formato_termica\\plantilla_101x149.txt");
		
	
		
		/*ietweb.map_plantilla.put("imagen1", "imagen|/opt/recursos/images_logos/LogotipoAGexpress.gif|250.5|30.73");
		ietweb.map_plantilla.put("rect1", "rectangle|11.0f|7.0f|9.40f|4.5f|1.2f");
		ietweb.map_plantilla.put("derechos", "label|ESTOS SON LOS DETRECHOS|3|10.65f|0.7f|0|Times-BoldItalic");
		ietweb.map_plantilla.put("pdfprin", "pdf|ESTOS SON LOS DETRECHOS|15f|1f|21.0f|30.0f|0");
		ietweb.map_plantilla.put("pdfprin", "cb|ESTOSSONLOSDETRECHOS|11.65f|11.6f|7.5f|1.0|0");*/
		//ietweb.map_plantilla.put("imagen1", "logo=imagen|/opt/recursos/images_logos/LogotipoAGexpress.gif|25.5|30.73");

			
		//2=2 tantos
		//4=4 tantos
		//10= carta recol
		//ietweb.createPDFGenerico(archivo, 2);
		ietweb.createPDFGenerico(archivo, 422,286);
		
		System.out.println("TERMINADO");

		
		
	}
}