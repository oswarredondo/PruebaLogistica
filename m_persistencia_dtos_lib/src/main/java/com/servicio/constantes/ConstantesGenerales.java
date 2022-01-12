/**
 * 
 */
package com.servicio.constantes;



public class ConstantesGenerales {

	public final static String  ESTADO_ACTIVO= "A";
	public final static String  ESTADO_CADUCO= "C";
	public final static String  ESTADO_TEMPORAL= "T";
	
	public final static String  ESTADO_HISTORIA= "H";
	
	public final static int  TIPO_BUSQUEDA_CLIENTE_ALL=0; 
	public final static int   TIPO_BUSQUEDA_CLIENTE_DISTINTO_A_CONSUMO=1; 
	public final static int   TIPO_BUSQUEDA_CLIENTE_CONSUMO=2; 
	

	
	
	public final static String  USER_CTE_SESSION = "CTESESSIONUSER";
	public final static String  USER_SESSION = "ADMINSALESESSIONUSER";
	public final static String  PDV_SESSION = "ADMINSALESESSIONPDV";
	public final static String  ID_APP = "ADMINSALES";
	public final static String  ID_APP_MAIL = "ADMSALESE_EMAIL";
	public final static String  ID_SKY4SOL = "SKY4SOL";
	public final static String  NUM_CTE_APP = "0000000000";
	
	//Tipos de rotulacion dpendiendo del punto donde se realiza
	//Estas sirven para poder realizar la recepcion
	public final static int  TIPO_ROTULACION_CONTADO = 1;
	public final static int  TIPO_ROTULACION_CONTADO_CONVENIO = 2;
	public final static int  TIPO_ROTULACION_AUTODOC = 22;
	public final static int  TIPO_ROTULACION_PDV_AUTODOC = 11;
	public final static int  TIPO_ROTULACION_PREPAGADO = 3;
	public final static int  TIPO_ROTULACION_FXC = 5;
	public final static int  TIPO_ROTULACION_INTERNACIONAL = 4;
	public final static int  TIPO_RECALCULO_PRECIO=60; 
	public final static int  TIPO_SOBRE_PESO=70; 
	public final static int  TIPO_RECEPCION_SIN_SOBREPESO=71; 
	public final static int  TIPO_RECUPERACION_FXC=80; 
	public final static int  TIPO_DOCUMENTACION_CONVENIO = 90;
	

	
	public final static String WALLPAPER_PARAMETRO = "wallpaper.sistema.default";
	public final static String TIPO_MENU= "tipo.menu.sistema";
	
	public final static String WALLPAPER_DEFAULT = "desktop.jpg";
	public final static int ESTATUS_INACTIVA =0;
	public final static int ESTATUS_ACTIVA =1;
	public final static int ESTATUS_TRAFORMADA_A_CONVENIO =2;
	public final static int ESTATUS_CERRADA =3;
	
	public final static String  MANEJO_FOLIOS= "F"; //Folios
	public final static String  MANEJO_CONVENIO= "C"; //Convenios
	
	public final static int  INT_MANEJO_FOLIOS= 0; //Folios
	public final static int  INT_MANEJO_CONVENIO= 1; //Convenios
	
	public final static String FORMATO_ETIQUETA_DEFAUTL= "ETIQUPERSO"; //
	
	public static final String _TIPODOCUMENTO = "ETIQU";
	public static final String _ETIQUMEDIA = "ETIQUMEDIA";
	public static final String _ETIQUPERSO = "ETIQUPERSO";
	public static final String _TIPOIMPRESION= "PERSO";
	
	/*Atributos de caparametrosp*/
	public final static String PATHIREPORTJASPER = "PathiReportJasper";
	public final static String PATLOGOETIQUETAS = "PathLogosEtiqueta";
	public final static String CONSECUTIVO_VENTAGLOBAL ="CONSECUTIVO_VENTAGLOBAL";
	public final static String CONSECUTIVO_VENTAPDV=  "CONSECUTIVO_VENTA"; 
	public final static String PATHDOC_ATTACHMENT = "path.documentos.attachment";
	public final static String MANEJO_POR_FOLIOS_O_CONVENIOS = "manejo.por.folios.o.convenios";
	public final static String MANEJO_POR_FOLIOS_VENTA_ES_GLOBAL = "manejo.folios.venta_global";
	
	
	public final static String ADICIONAL_ZONA_EXTENDIDA = "adicional.zona.extendida";
	public final static String TIPO_CAMBIO_DOLAR = "tipo.cambio.dollar";
	
	public final static String APLICA_ALGORITMO_DV = "aplica.algoritmo.digito.verificar";
	public final static String ALGORITMO_DV_AL_INICIO = "algoritmo.digito.al.inicio";
	
	public final static String LARGO_CONSECUTIVO_PDV = "largo.consecutivo.guia.pdv";
	public final static String LARGO_CONSECUTIVO_AUTODOC = "largo.consecutivo.guia.autodoc";
	public final static String TAMANIO_FILE_EXCEL_ROTULACION = "rotulacion.tamanio.archivo.excel.en.megas";
	public final static String LINEAS_PERMITIDAS_EXCEL_ROTULACION = "rotulacion.numero.lineas.permitidas.archivo";
	
	public final static String PORCENTAJE_VALOR_SEGURO =  "porcentaje.valor.seguro.envio";

	public final static String TELCEL_ENDPOINT = "telcel.endpoint.telescopik";
	public final static String TELCEL_WS_USER_OBTENDATOS = "telcel.user.telescopik";
	public final static String TELCEL_DEBUG = "telcel.telescopik.debug";

	public final static String DirPDFTXTFile = "DirPDFTXTFile";
	public final static String TIPOIMPRESIONETIQUETAS = "tipo.impresion.etiquetas";  //template = itext, jasper=archivo de jasperreport
	public final static String TEMPLATEETIQUETAPDV = "template.etiqueta.pdv";
	
	public final static String SERVICIOS_CODPDV = "servicios.cod.pdv";
	public final static String SERVICIOS_PREPAGADO = "servicios.prepagado.pdv";
	public final static String SERVICIOS_CONTRATO_CONVENIO = "servicios.contrato.convenio.pdv";
	public final static String SERVICIOS_CONTADO = "servicios.contado.pdv";
	
	
	public final static String TARIFA_DEFAULT_RECALCULO_PRECIO = "tarifa.autodoc.pdv.recalculo.precio";
	
	public final static String MODULO_PDV = "PDV";
	public final static String MODULO_AUTODOCWEB = "AUTODOCWEB";
	public final static String MODULO_ADMINISTRACIONVENTA = "ADMINVENTA";
	public final static String MODULO_MONITORWEB = "MONITORWEB";
	
	public final static String TIPO_CONTRATO_CONVENIO_VARIBLE = "VARIABLE";
	public final static String TIPO_CONTRATO_CONVENIO_SUPERVARIBLE = "SUPERVARIABLE";
	
	
	public final static int DEMONIMADOR_CALCULO_PESO_VOLUMEN=5000;
	
	///Errores UPS
	public final static String ERROR_SSL ="HTTP transport error: javax.net.ssl.SSLException: Received fatal alert: protocol_version";
	
	

}
