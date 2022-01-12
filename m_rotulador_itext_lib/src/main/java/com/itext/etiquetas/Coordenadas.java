/*
 * Creado el Nov 28, 2008
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package com.itext.etiquetas;

import java.util.Calendar;


/**
 * @author amoralesr
 *
 * TODO Para cambiar la plantilla de este comentario generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
public class Coordenadas {
	
	// ///////////////////// Derechos /////////////////////////////
	public static String derechos = "";

	public static final float dot = 28.34645f;
	public static final float deltaX = 10.0f;
	public static final float deltaY = 15.8f;
	
	public static final float ALTURA_128CODE = 1.0f;
	public static final float BASE_128CODE = 10.3f;
	
	//COORDENADAS DE LA HOJA PDF IMPRESA
	////////////////////|//////////////////
	//					|				 //
	//COOR 1(X,Y)		|COOR2(X,Y)		 //
	//					|				 //
	///////////////////////////////////////
	//					|			     // 
	//COOR 3(X,Y)		|COOR 4(X,Y) 	 //
	//					|				 //	
	///////////////////////////////////////	

	//										X((CUANDO SE HA ROTADO))
	//										|
	//										|
	//										|
	//										|
	//										|
	//(CUANDO NO SE HA ROTADO)Y---------------------------X (CUANDO NO SE HA ROTADO)			
	//										|
	//										|
	//										|
	//										|
	//										|
	//										Y(CUANDO NO SE HA ROTADO)

	//coordenada 1 Codigo 128 X para los cuadrantes 1 y 3
	public static final float X_1_3_CODE128 = 8.5f;
	//coordenada 1 Codigo 128 Y
	public static final float Y1_128_COSTADO = 16.5f;
	//coordenada 3 Codigo 128 
	public static final float Y3_128_COSTADO = 2.5f;
	
	//coordenada 2 Codigo 128 
	public static final float X_2_4_CODE128 = 19.5f;
	//coordenada 2 Codigo 128 
	public static final float Y2_128_COSTADO = 15.5f;
	//coordenada 4 Codigo 128 
	public static final float Y4_128_COSTADO = 2.5f;
	
	
	//
	public static final float ALTURA_CODEPDF = 1.7f;
	public static final float BASE_CODEPDF = 10.3f;
	
	//coordenada X 1 y 3 PDF
	public static final float X_1_3CODEPDF = 1.0f;
	//coordenada Y 1 PDF
	public static final float Y_1_CODEPDF = 25.7f;
	//coordenada Y 3 PDF
	public static final float Y_3_CODEPDF = 13.0f;
	
}//Coordenadas
