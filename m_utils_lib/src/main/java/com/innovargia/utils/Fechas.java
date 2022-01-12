/*
 * $Id:  $
 * Nombre del Proyecto: Facturaci�n - Web
 * Nombre del Programa: Fechas.java
 * Responsable        : Adrian Morales
 * Descripcion        : funcions de fechas
 **/
package com.innovargia.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *Funciones utilitarias de fechas
 *
 * @author Tecnologia Virtual
 */
public class Fechas {
    
	
	
    
    /** Forma de fecha utilizado para despleagar dd/MM/yyyy*/
    public static final  SimpleDateFormat FORMATO_FRANCES  =
    new SimpleDateFormat("dd/MM/yyyy");
    /** Forma de fecha utilizado para despleagar MM/dd/yyyy*/
    public static final  SimpleDateFormat FORMATO_AMERICANO =
    new SimpleDateFormat("MM/dd/yyyy");
    /** Formato de fecha en formato MM/dd/yyyy **/
    public static final  String FORMATO_AMERICANO_STR ="MM/dd/yyyy";
    /** Formato de fecha en formato dd/MM/yyyy **/
    public static final  String FORMATO_FRANCES_STR ="dd/MM/yyyy";

    /** Formato de fecha en formato MM/dd/yyyy hh:mm:ss**/
    public static final  String FORMATO_AMERICANO_HORA_STR ="MM/dd/yyyy HH:mm:ss";

    /** Formato de fecha en formato dd/MM/yyy HH:mm:ss**/
    public static final  String FORMATO_FRANCES_HORA_STR ="dd/MM/yyy HH:mm:ss";
    
    /** Formato de hora en formato hh:mm:ss **/
    public static final  String HORA_STR ="hh:mm:ss";

    /** Arreglo que contiene los meses del a�o */
    private static int []meses = {0,0,1,2,3,4,5,6,7,8,9,10,11};
	
	    public static final int A_DD_MM_AAAA = 1;
    public static final int A_MM_DD_AAAA = 2;
    
    public static String getNombreMes(int mes){
    	  String []nombreMes = {"", "Enero", "Febrero", "Marzo", "Abril", "Mayo",
    	            "Junio", "Julio", "Agosto", "Septiembre", "Octubre", 
    	            "Noviembre","Diciembre"};

    	  if (mes<=0){
    		  mes=0; 
    	  }
    	  if (mes>12){
    		  mes=0;  
    	  }
    	  
    	  return nombreMes[mes].trim().toUpperCase();
    }
    /**
     * Suma dias,meses o a�os a una instancia de Calendar y regresa una cadena con el
     * formato indicado.<br>
     *
     * Date and Time Pattern Result<br>
     * "yyyy.MM.dd G 'at' HH:mm:ss z"  2001.07.04 AD at 12:08:56 PDT<br>
     * "EEE, MMM d, ''yy"  Wed, Jul 4, '01<br>
     * "h:mm a"  12:08 PM<br>
     * "hh 'o''clock' a, zzzz"  12 o'clock PM, Pacific Daylight Time<br>
     * "K:mm a, z"  0:08 PM, PDT<br>
     * "yyyyy.MMMMM.dd GGG hh:mm aaa"  02001.July.04 AD 12:08 PM<br>
     * "EEE, d MMM yyyy HH:mm:ss Z"  Wed, 4 Jul 2001 12:08:56 -0700<br>
     * "yyMMddHHmmssZ"  010704120856-0700<br>
     * "yyyyMMDDhhmm" 200312180425<br>
     *
     * @paran fecha fecha a convertir
     * @param cantidad que se va agregar a la fecha
     * @param lugar indica a que parte de la fecha se le va agregar la cantidad
     * @retrun regresa el formato de fecha solicitado
     */
    public static String calculaFecha(Calendar calendar, int cantidad,int lugar,String formato){
        
        //Lugar
        switch(lugar){
            case Calendar.DATE:
                calendar.add(calendar.DATE, cantidad);
                break;
            case Calendar.MONTH:
                calendar.add(calendar.MONTH, cantidad);
                break;
            case Calendar.YEAR:
                calendar.add(calendar.YEAR, cantidad);
                break;
        }//fin de switch
        
        //Da formato a la fecha indicada
        return formatoFecha(calendar, formato);
    }//fin de calculaFecha
    
    /**
     * Devuelve una instancia de un objeto de tipo <b>Calendar</b>, solamente
     * indicando la fecha en formato mm/dd/aaaa
     *
     * @param fecha la fecha en formato mm/dd/aaaa
     * @return una instancia de Calendar o null en caso de que no se pueda
     * realizar el proceso
     * @see Calendar
     */
    public static Calendar getCalendar(String fecha){
        //Verifica que la fecha sea correcta
        if ((fecha==null) || (fecha.trim().length()<10)){
            return null;
        }
        //Crea la instancia de fecha actual
        Calendar date = Calendar.getInstance();
        
        //Ajusta la fecha a la manejada por default
        date.set(Integer.parseInt(fecha.substring(6)),
        meses[Integer.parseInt(fecha.substring(0,2))],
        Integer.parseInt(fecha.substring(3,5)));
        
        //Regresa  el formato de fecha indicado
        return date;
    }//fin de getCalendar
    
    /**
     * Devuelve una instancia de un objeto de tipo <b>Calendar</b>, solamente
     * indicando la fecha en formato  mm/dd/aaaa
     *
     * @param fecha la fecha en formato  mm/dd/aaaa
     * @return una instancia de Calendar o null en caso de que no se pueda
     * realizar el proceso
     * @see Calendar
     */
    public static Calendar getCalendarDDMMAAA(String fecha){
        //Verifica que la fecha sea correcta
        if ((fecha==null) || (fecha.trim().length()<10)){
            return null;
        }
        //Crea la instancia de fecha actual
        Calendar date = Calendar.getInstance();
        
        //Ajusta la fecha a la manejada por default
        date.set(Integer.parseInt(fecha.substring(6)),
        meses[Integer.parseInt(fecha.substring(3,5))],
        Integer.parseInt(fecha.substring(0,2)));
        
        //Regresa  el formato de fecha indicado
        return date;
    }//fin de getCalendar
    
    
    /**
     * Obtiene el dia de la semana que se esta consultado de acuerdo a la fecha
     * seleccionada por el usuario.(Do,Lu,Ma,Mi,Ju,Vi)
     * @param fecha la fecha en formato mm/dd/aaaa
     * @return una instancia de Calendar o null en caso de que no se pueda
     * realizar el proceso
     * @see Calendar
     */
    public static String getCalendarDayOfWeek(String fecha){
        //Verifica que la fecha sea correcta
        if ((fecha==null) || (fecha.trim().length()<10)){
            return null;
        }
        //Crea la instancia de fecha actual
        Calendar date = Calendar.getInstance();
        
        //Ajusta la fecha a la manejada por default
        date.set(Integer.parseInt(fecha.substring(6)),
        		(Integer.parseInt(fecha.substring(0,2))-1),
        Integer.parseInt(fecha.substring(3,5)));
        date.get(Calendar.DAY_OF_WEEK);
        
        switch (date.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			return "Do";
		case 2:
			return "Lu";
		case 3:
			return "Ma";
		case 4:
			return "Mi";
		case 5 :
			return "Ju";
		case 6:
			return "Vi";		
		case 7:
			return "Sa";				
		default:
			return null;
		}
    }//fin de getCalendar
    
    
    /**
     * Obtiene la diferencia entre dos fechas
     *
     * Las fechas deberan estar dadas en el formato de mm/dd/aaaa
     *
     * @param fecha inicial
     * @param fecha final
     * @pram la cantidad de dias de diferencia entre las fechas dadas
     */
    public static int getSemanasEntreFechas(String fechaini, String fechafin){
        
        //Crea la instancia de fecha actual
        Calendar dateInicial = Calendar.getInstance();
        Calendar dateFinal = Calendar.getInstance();
        //Ajusta la fecha a la manejada por default
        dateInicial.set(Integer.parseInt(fechaini.substring(6)),
        meses[Integer.parseInt(fechaini.substring(0,2))],
        Integer.parseInt(fechaini.substring(3,5)));
        
        dateFinal.set(Integer.parseInt(fechafin.substring(6)),
        meses[Integer.parseInt(fechafin.substring(0,2))],
        Integer.parseInt(fechafin.substring(3,5)));
        int meses =1;
        String fecha=Fechas.formatoFecha(dateInicial, Fechas.FORMATO_AMERICANO_STR);
        
        dateInicial.add(dateInicial.DATE,6);
        fecha=Fechas.formatoFecha(dateInicial, Fechas.FORMATO_AMERICANO_STR);
        
        while (!fecha.equals(fechafin)){
            meses++;
            dateInicial.add(dateInicial.DATE,7);
            fecha=Fechas.formatoFecha(dateInicial, Fechas.FORMATO_AMERICANO_STR);
            
        }//fin de while
        if (meses<=0){
            return 1;
        }
        return meses;
    }//fin de getDiferenciaFechas
    
    /**
     * Obtiene el d�a de la fecha para poder desplegarlo en la pantalla.
     * Esto si la fecha es lunes 28 de junio, para obtener el martes se pasan
     * como parametros la fecha(lunes 28 de junio) con suma de 1, para que el
     * resultado sea martes 29 de junio.<br>
     *
     * El formato de la fecha a procesar debe tener el formato de MM/DD/AAAA,
     * o la cadena de la fecha es nula, entonces regresa una cadena vacia
     *
     * @param dFecha fecha actual
     * @param iCantidad cantidad que se debe sumar a la
     * para ontener el dia correspondiente de la semana
     * @return no regresa ning�n valor
     */
    public static String obtenDia(String dFecha,int iCantidad, String formato) {
        
        //Verifica que la fecha no sea nula
        if ((dFecha==null) || (dFecha.trim().length()<8)){
            return "";
        }
        
        //Crea la instancia de fecha actual
        Calendar fecha = Calendar.getInstance();
        
        //Obtiene el d�a mes y a�o de la fecha pasada como
        //parametro
        int iMes = meses[Integer.parseInt(dFecha.substring(0,2))];
        int iDia = Integer.parseInt(dFecha.substring(3,5));
        int iAnnio = Integer.parseInt(dFecha.substring(6));
        
        //Ajusta la fecha a la manejada por default
        fecha.set(iAnnio,iMes,iDia);
        
        //Suma la cantidad de dias
        if (iCantidad >0) fecha.add(Calendar.DATE,iCantidad);
        
        //regresa el dia del mes
        return  formatoFecha(fecha,formato);
    } // fin de obtenDia
    
    /** Devuelve la fecha bajo un formato indicado, si se desea una fecha en
     * especifico se debe crear una instancia de Calendar y configurar la fecha,
     * si el parametro fecha es pasado como null se crea una instnacia de la
     * la fecha del d�a actual<br>
     *
     * Ejemplos:<br>
     * <br>
     *  Date and Time Pattern Result<br>
     * "yyyy.MM.dd G 'at' HH:mm:ss z"  2001.07.04 AD at 12:08:56 PDT<br>
     * "EEE, MMM d, ''yy"  Wed, Jul 4, '01<br>
     * "h:mm a"  12:08 PM<br>
     * "hh 'o''clock' a, zzzz"  12 o'clock PM, Pacific Daylight Time<br>
     * "K:mm a, z"  0:08 PM, PDT<br>
     * "yyyyy.MMMMM.dd GGG hh:mm aaa"  02001.July.04 AD 12:08 PM<br>
     * "EEE, d MMM yyyy HH:mm:ss Z"  Wed, 4 Jul 2001 12:08:56 -0700<br>
     * "yyMMddHHmmssZ"  010704120856-0700<br>
     * "yyyyMMDDhhmm" 200312180425<br>
     *
     *Letter 	Date or Time Component 	Presentation 	Examples
     * G 	Era designator 	Text 	AD
     * y 	Year 	Year 	1996; 96
     * M 	Month in year 	Month 	July; Jul; 07
     * w 	Week in year 	Number 	27
     * W 	Week in month 	Number 	2
     * D 	Day in year 	Number 	189
     * d 	Day in month 	Number 	10
     * F 	Day of week in month 	Number 	2
     * E 	Day in week 	Text 	Tuesday; Tue
     * a 	Am/pm marker 	Text 	PM
     * H 	Hour in day (0-23) 	Number 	0
     * k 	Hour in day (1-24) 	Number 	24
     * K 	Hour in am/pm (0-11) 	Number 	0
     * h 	Hour in am/pm (1-12) 	Number 	12
     * m 	Minute in hour 	Number 	30
     * s 	Second in minute 	Number 	55
     * S 	Millisecond 	Number 	978
     * z 	Time zone 	General time zone 	Pacific Standard Time; PST; GMT-08:00
     * Z 	Time zone 	RFC 822 time zone 	-0800
     * 
     * yyDmsS
     * @see SimpleDateFormat
     * @param elFormato
     * @param fecha de la cual se desea el formateo
     * @return una cadena con la fecha formateada 
     */
    public static String formatoFecha(Calendar fecha,String elFormato) {
        StringBuffer sb = new StringBuffer();
        if (fecha==null){
            //Crea la instancia de fecha actual
            fecha = Calendar.getInstance();
        }
        
        //Da formato a la fecha
        SimpleDateFormat formato = new SimpleDateFormat(elFormato);
        sb.append(formato.format(fecha.getTime()));
        
        return sb.toString();
    }//fin de formatoFecha
    
    /**
     * Regresa  la fecha del d�a actual en formato dd.MM.yyyy hh:mm aaa
     * @return
     */
    public static String Fecha() {
        StringBuffer sb = new StringBuffer();
        
        //Crea la instancia de fecha actual
        Calendar fecha = Calendar.getInstance();
        
        //Da formato a la fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd.MM.yyyy hh:mm aaa");
        sb.append(formato.format(fecha.getTime()));
        
        return sb.toString();
    }//fin de Fecha
    
    /**
     * Da formato a la fecha del sistema a la indicada por el usuario
     * Date and Time Pattern Result<br> 
     * "yyyy.MM.dd G 'at' HH:mm:ss z"  2001.07.04 AD at 12:08:56 PDT<br>
     * "EEE, MMM d, ''yy"  Wed, Jul 4, '01<br>
     * "h:mm a"  12:08 PM<br>
     * "hh 'o''clock' a, zzzz"  12 o'clock PM, Pacific Daylight Time<br>
     * "K:mm a, z"  0:08 PM, PDT<br>
     * "yyyyy.MMMMM.dd GGG hh:mm aaa"  02001.July.04 AD 12:08 PM<br>
     * "EEE, d MMM yyyy HH:mm:ss Z"  Wed, 4 Jul 2001 12:08:56 -0700<br>
     * "yyMMddHHmmssZ"  010704120856-0700<br>
     * "yyyyMMDDhhmm" 200312180425<br>
     *
     *Letter 	Date or Time Component 	Presentation 	Examples<br>
     * G 	Era designator 	Text 	AD<br>
     * y 	Year 	Year 	1996; 96<br>
     * M 	Month in year 	Month 	July; Jul; 07<br>
     * w 	Week in year 	Number 	27<br>
     * W 	Week in month 	Number 	2<br>
     * D 	Day in year 	Number 	189<br>
     * d 	Day in month 	Number 	10<br>
     * F 	Day of week in month 	Number 	2<br>
     * E 	Day in week 	Text 	Tuesday; Tue<br>
     * a 	Am/pm marker 	Text 	PM<br>
     * H 	Hour in day (0-23) 	Number 	0<br>
     * k 	Hour in day (1-24) 	Number 	24<br>
     * K 	Hour in am/pm (0-11) 	Number 	0<br>
     * h 	Hour in am/pm (1-12) 	Number 	12<br>
     * m 	Minute in hour 	Number 	30<br>
     * s 	Second in minute 	Number 	55<br>
     * S 	Millisecond 	Number 	978<br>
     * z 	Time zone 	General time zone 	Pacific Standard Time; PST; GMT-08:00<br>
     * Z 	Time zone 	RFC 822 time zone 	-0800<br>
     * @param formatoFecha
     * @return la fecha sel sistema formateada
     */
    public static String getFechaFormato(String formatoFecha) {
        StringBuffer sb = new StringBuffer();
        
        //Crea la instancia de fecha actual
        Calendar fecha = Calendar.getInstance();
        
        //Da formato a la fecha
        SimpleDateFormat formato = new SimpleDateFormat(formatoFecha);
        sb.append(formato.format(fecha.getTime()));
        
        return sb.toString();
    }//fin de formatoFecha
    
    /**
     * Devuelve la fecha bajo un formato indicado.
     *
     * Ejemplos:<br>
     *<br>
     *  Date and Time Pattern Result<br>
     * "yyyy.MM.dd G 'at' HH:mm:ss z"  2001.07.04 AD at 12:08:56 PDT<br>
     * "EEE, MMM d, ''yy"  Wed, Jul 4, '01<br>
     * "h:mm a"  12:08 PM<br>
     * "hh 'o''clock' a, zzzz"  12 o'clock PM, Pacific Daylight Time<br>
     * "K:mm a, z"  0:08 PM, PDT<br>
     * "yyyyy.MMMMM.dd GGG hh:mm aaa"  02001.July.04 AD 12:08 PM<br>
     * "EEE, d MMM yyyy HH:mm:ss Z"  Wed, 4 Jul 2001 12:08:56 -0700<br>
     * "yyMMddHHmmssZ"  010704120856-0700<br>
     * "yyyyMMddhhmm" 200312180425<br>
     *
     * @param fecha de la cual se desea el formateo
     * @return una cadena con la fecha formateada
     * @see SimpleDateFormat
     */
    public static String formatoFecha(Date fecha,String elFormato) {
    	
    	if (fecha==null){return null;} 
        StringBuffer sb = new StringBuffer();
        
        //Da formato a la fecha
        SimpleDateFormat formato = new SimpleDateFormat(elFormato);
        sb.append(formato.format(fecha));
        
        return sb.toString();
    }//fin de createEncabezado
    
    /**
     * Devuelve la fecha en formato de texto, en espa�ol, si se pasa la fecha de
     * </b>05/08/2004</b> devuelve <b>5 de Agosto del 2004 </b>por ejemplo, si se desea que la
     * fecha se devuelva el ingles la variable isEspanol debe indincarse como
     * false.
     * @param fecha instancia de Calendar que indica la fecha que se desea transformar
     * @param isEspanol indica si la fecha que se desea visualizar es en espanol
     * o ingles. <br> Si isEspanol=false se da formato en ingles
     * @return fechaTexto cadena devuelta en espanol o ingles de acuerdo a la seleccion
     * del usuario
     */
    public static String fechaTexto(Calendar fecha, boolean isEspanol){
        //Formato en espanol
        if (isEspanol){
            //Arreglo que contiene los nombre s en espanool de los meses del a�o
            String []nombreMes = {"Enero", "Febrero", "Marzo", "Abril", "Mayo",
            "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre","Diciembre"};
            //Variable que contiene el valor regresado
            String fechaTexto = " " + fecha.get(fecha.DATE) + " de " +
            nombreMes[fecha.get(fecha.MONTH)] ;
            
            //Verifica si el a�o es mayor de 1999
            if (fecha.get(fecha.YEAR) >= 2000){
                fechaTexto += " del " + fecha.get(fecha.YEAR);
            }else{
                fechaTexto += " de " + fecha.get(fecha.YEAR);
            }
            //retorna la cadena armada
            return fechaTexto;
        }else{
            //Formato en ingles
            return formatoFecha(fecha.getTime(),"dd MMMMM yyyy");
        }
    }//fin de fechaTexto
   public static String fechaHoraTexto(Calendar fecha, boolean isEspanol){
    	
    	String myfecha=  fechaTexto( fecha,  isEspanol);
    	//Agrega la hora
    	String hora =  formatoFecha(fecha,"HH:mm:ss");
    	
    	return myfecha + " " + hora;
    	 
       
    }//fin de fechaTexto
    
    /**
     * Regresa la fecha en formato de SYBASE  YYYY-MM-DD HH:MM:SS.
     *
     * @param fecha en formato YYYYMMDDHHMM
     * @return cadena formateada como YYYY-MM-DD HH:MM:SS  o null si no
     * existe tal cadena
     */
    public static String formateaFecha(String fecha) {
        String fechaEvento = null;
        
        // Substrae dia, mes , anio, hora, min, am o pm
        String dia = fecha.substring(6,8);
        String mes = fecha.substring(4,6);
        String anio = fecha.substring(0,4);
        String hora = fecha.substring(8,10);
        String min = fecha.substring(10,12);
        
        
        // Formatea a formato SYBASE MM/DD/YYYY HH:MM
        //fechaEvento = mes + '/' + dia + '/' + anio + " " + hora + ":" + min;
        fechaEvento = anio + '-' + mes + '-' + dia + " " + hora + ":" + min ;
        return (fechaEvento);
        
        
        //return sb.toString();
    }//fin de formateaFecha
    
    
    /**
     * Regresa la fecha en formato de SYBASE  YYYY-MM-DD HH:MM:SS.
     *
     * @param fecha en formato DD/MM/YYYY
     * @param hora  en formato HH:MM
     * @param isDDMMYYYY indinca el formato en el que viene la fecha
     * @return cadena formateada como YYYY-MM-DD HH:MM:SS  o null si alguna de las cadenas es null
     */
    private String formateaFecha(String fecha,String hora,boolean isDDMMYYYY) {
        
        if ((fecha==null) || (hora==null) || (fecha.trim().length()<=0) || (hora.trim().length()<=0)){
            return null;
        }
        String fechaEvento = null;
        
        if (!isDDMMYYYY){
            //formato de la fecha en MM/DD/YYYY
            fechaEvento = fecha + " " + hora;
        }else{
            // Substrae dia, mes , anio, hora del formato de DD/MM/YYYY
            String dia = fecha.substring(0,2);
            String mes = fecha.substring(3,2);
            String anio = fecha.substring(6);
            fechaEvento = mes + '/' + dia + '/' + anio + " " + hora;
            
        }
        
        return fechaEvento;
        
    }//fin de formateaFecha
    
    /**
     * Compara dos fechas en formato MM/dd/yyyy  o dd/MM/yyyy, y devuelve la cantidad en dias de
     * diferencia entre fechaAComparar y fechaComparada.
     * @param fechaAComparar Fecha inciala a comparar
     * @param fechaComparada Fecha final a comparar
     * @param tipoFormato indica el formato de la fecha, puede ser MM/dd/yyyy (FORMATO_AMERICANO_STR)
     * o dd/MM/yyyy ((FORMATO_FRANCES_STR) si no es   de cualquiera de estos devuelve cero
     * @return la cantidad de dias de diferencia entre la primera fecha y la segunda
     */
    public static long getDiferenciaDias(String fechaAComparar, String fechaComparada,String tipoFormato){
        
        //Si no es ninguno de los siguientes formatos devuelve cero
        if (!tipoFormato.equals(FORMATO_AMERICANO_STR) && !tipoFormato.equals(FORMATO_FRANCES_STR)){
            return 0;
        }
        
        Date date_FechaIni;
        Date date_FechaFin;
        Calendar cal_Fecha_Ini;
        Calendar cal_Fecha_Fin;
        //Verifica el tipo de Formato americano sin pipes
        if (tipoFormato.equals(FORMATO_AMERICANO_STR)){
            cal_Fecha_Ini = getCalendar(fechaAComparar);
            cal_Fecha_Fin = getCalendar(fechaComparada);
        }else{
            cal_Fecha_Ini = getCalendarDDMMAAA(fechaAComparar);
            cal_Fecha_Fin = getCalendarDDMMAAA(fechaComparada);
        }
        
        long diferencia;
        try{
            date_FechaIni  = cal_Fecha_Ini.getTime();
            date_FechaFin  = cal_Fecha_Fin.getTime();
            //// 3600 * 24 * 1000 ( dias )
            diferencia = (date_FechaIni.getTime() -  date_FechaFin.getTime())/86400000L;
        }catch(Exception e){
            return 0;
        }
        
        return diferencia;
    }//fin de getDiferenciaDias
    
    /**
     * Compara dos fechas y verifica si la primera fecha es mayor que la segunda
     * @param fechainicial
     * @param fechafinal
     * @param formato indica el formato de la fecha, puede ser MM/dd/yyyy (FORMATO_AMERICANO_STR)
     * o dd/MM/yyyy ((FORMATO_FRANCES_STR) si no es   de cualquiera de estos devuelve cero
     * @return devuelve true si la fecha inicial es mayor que la fecha final, false en caso contrario, en caso
     *de que no sea ninguno de los dos formatos indicados devielve false
     */
    public static boolean isMayor(String fechainicial, String fechafinal,String formato){
        //Si no es ninguno de los siguientes formatos devuelve cero
        if (!formato.equals(FORMATO_AMERICANO_STR) && !formato.equals(FORMATO_FRANCES_STR)){
            return false;
        }
        if (getDiferenciaDias(fechainicial, fechafinal,formato)>0){
            return true;
        }
        return false;
    }//fin de isMayor
    
    /**
     * Compara dos horas en formato HH:MM y devuelve la diferencia en minutos entre ellas, el usuario
     * debe verifidar que la primera hora sea mayor que la segunda , en caso contrario el resultado sera
     *negativo , lo que indinca que la primera hora es menor que la segunda, esto es
     * si horaInicial = 11:30 y horaFinal = 12:30 la cantidad la cantidad resultante sera
     * @param horaInicial
     * @param horaFinal
     * @return regresa  cantidad en minutos de diferencia entrega ambas horas, si cualquiera de las
     * horas no nesta en el formato indicado devuelve cero
     */
    public static long getDiferenciaHora(String horaFinal , String horaInicial){
        
        if ((horaFinal==null) || (horaInicial==null)){ return 0;  }
        
        String[] hora1 = horaFinal.split(":");
        String[] hora2 = horaInicial.split(":");
        
        //Verifica que el formato de la fecha sea correcto
        if ((hora1.length<2) || (hora2.length<2)){ return 0;  }
        
        try{
            Calendar inicial =  Calendar.getInstance();
            Calendar fin =  Calendar.getInstance();
            //Actualiza las fechas de cada una los objetos
            inicial.set(Calendar.HOUR,Integer.parseInt(hora1[0]));
            inicial.set(Calendar.MINUTE,Integer.parseInt(hora1[1]));
            
            fin.set(Calendar.HOUR,Integer.parseInt(hora1[0]));
            fin.set(Calendar.MINUTE,Integer.parseInt(hora1[1]));
            
            //Obtiene la diferencia de cada uno de los datos y devuelve
            //la cantidad de horas ente ellas
            long horas = (inicial.getTimeInMillis() - fin.getTimeInMillis())/3600000;
            return horas;
            
        }catch(NumberFormatException nfe){
            return 0;
        }
        
    }//fin de getDiferenciaHora
       /**
     * Regresa la fecha en formato DD/MM/AAAA o MM/DD/AAAA, dependiendo del formato
     * deseado, Si el selecciona DD/MM/AAAA  debe indincar la fecha en formato MM/DD/AAAA
     * si el usuario selecciona MM/DD/AAAA debe indicar la fecha en formato DD/MM/AAAA
     *
     * @param fechaOriginal fecha que se va a convertir
     * @param formato al que se desea convertir
     * @return cadena con el formato deseado, null en caso de error
     */
   public static String cambiaFormatoFecha(String fechaOriginal,int convertirA) {
    	
        
        if (fechaOriginal==null){
            return null;
        }
        if (fechaOriginal.trim().length()<10){
            return null;
        }
        if (convertirA== A_DD_MM_AAAA){//la fecha esta en formato MM/DD/YYYY
            //formato de la fecha en 
            return fechaOriginal.substring(0,2)+ '/' + fechaOriginal.substring(3,5) + '/' + fechaOriginal.substring(6);
        }else{ //la fecha esta en formato DD/MM/YYYY
            return fechaOriginal.substring(3,5) + '/' + fechaOriginal.substring(0,2) + '/' + fechaOriginal.substring(6) ;
            
        }
    }//fin de formateaFecha
   
   
   public static XMLGregorianCalendar convertStringToXmlGregorian(String dateString)
   {
         try {
        	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        	
        	 
               Date date = sdf.parse(dateString);
               GregorianCalendar gc = (GregorianCalendar) GregorianCalendar.getInstance();
               gc.setTime(date);
               return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
           } catch (Exception e) {
               // Optimize exception handling
               System.out.print(e.getMessage());
               return null;
           } 

   }
    
} //Fin Fechas