/* $Id: Moneda.java,v 1.2 2005/01/01 17:20:17 TVIRTUAL#amorales Exp $
 * Nombre del Proyecto: tvirtual.factura
 * Nombre del Programa: Moneda.java
 * Responsable        : Adrian Morales Ruaro
 * Fecha Inicial      : 30/07/2004
 * Fecha Final        :
 * Breve Descripcion  :
 * Establece los metodos comunes para conversiones de formatos de numeros,
 * principalmente para dar formato a cantidades de moneda separados por comas,
 * cantidades en letra, etc.
 */

package com.innovargia.utils;

import java.text.DecimalFormat;


/**
 * Establece los metodos comunes para conversiones de formatos de numeros,
 * principalmente para dar formato a cantidades de moneda separados por comas,
 * cantidades en letra, etc.
 *
 * @author  AMR,Tecnologia Virtual
 * @version $Id: Moneda.java,v 1.2 2005/01/01 17:20:17 TVIRTUAL#amorales Exp $
 */
public class Moneda {
    
    private Moneda(){
    }
    /**
     * Indica que se esta facturando en Pesos Mexicanos
     */
    public static final int PESOS = 0;
    public static final int DOLARES = 1;
    /**
     * Numero de digitos al lado derecho del punto
     */
    
    private static final int DIGITS = 3;
    /**
     * Numero de dígitos para el manejo de exponenciales
     */
    private static final double MAXVAL_EXP = 10000000.0;
    private static final double MINVAL_EXP = 0.001;
    private static final String ZEROS    = " 0.00";
    private static final String EXPONENT = "e";
    
    /**
     * Convierte un objecto a entero
     * @param o Objeto a convertir
     * @return Equivalente entero del objeto
     */
    public static int toInt(Object o) {
        int tmp = 0;
        
        try {
            String s = o.toString();
            Double d = new Double(s);
            tmp = d.intValue();
        } catch (Exception e) {
            return tmp;
        }
        
        return tmp;
    }//fin de toInt
    
    /**
     * Convierte un un double a entero
     * @param s String a convertir
     * @return Equivalente entero del string si no se puede convertir a entero 
     * regresa cero como resultado
     */
    public static int toInt(double s) {
        try {
            Double dobl= new Double(s);
            return  dobl.intValue();
        } catch (Exception e) {
            return 0;
        }
    }//fin de toInt
    
    
    /**
     * Convierte un objecto a double
     * @param o Objeto a convertir
     * @return Equivalente doble del objeto, si no se puede convertgir regresa 0.0
     * como resultado
     */
    public static double toDouble(Object o) {
        double tmp = 0.00;
        
        try {
            String s = o.toString();
            //Verifica si la cadena tiene comas
            while (s.indexOf(",")!=-1){
                if (s.indexOf(",")!=-1){
                    s = s.substring(0,s.indexOf(",")) + s.substring(s.indexOf(",")+1);
                }
            }//fin del while de comas
            
            Double d = new Double(s);
            tmp = d.doubleValue();
            
        } catch (Exception e) {}
        
        return tmp;
    }//fin de toDouble
    
    /**
     * Convierte un objeto a float
     * @param o Objeto a convertir
     * @return Equivalente a float del objeto, si no se puede convertgir regresa 0.0
     * como resultado
     */
    public static float toFloat(Object o) {
        float tmp =0;
        try{
            return Float.parseFloat(o.toString());
        }catch(Exception e){
            System.out.println("Error en la conversion toFloat "  + e.getMessage());
            return 0;
        }
    }//fin de toFloat
    
    
    /**
     * Formatea una cadena que contiene un numero
     * a un numero de decimales
     * @param numStr  cadena que contiene el numero
     * @param digits  numero de digitos depues del punto decimal
     */
    public static String formatDouble(String numStr, int digits) {
      /* con hotjava le pone un punto al final, por eso
       * si esto ocurre hay que quitarselo
       * caso en el que pone un .0
       */
        if(numStr.charAt(numStr.length()-1) == '0' &&
        numStr.charAt(numStr.length()-2) == '.' ) {
            numStr = numStr.substring(0, numStr.length()-2);
        } else if(numStr.charAt(numStr.length()-1) == '.') {
            numStr = numStr.substring(0, numStr.length()-1);
        }
        
        int index = numStr.indexOf(".")+1;
        if(index > 0){  //pos de punto
            if(index+digits <= numStr.length()){
                numStr = numStr.substring(0,index+digits);
            }
        }
        
        // Agregar espacio, para llenar dos espacios
        if(index == 2){
            numStr = " "+numStr;
        }
        
        return numStr;
    }//fin de formatDouble
    

    
    /**
     * Convierte un double a string, con dos decimales.
     * @param cantidad
     * @return la cadena formateada a double con dos decimales
     */
    public static String toString(double cantidad) {
        return toString(cantidad, 2);
    }//fin de toString
    
    /**
     * Regresa un string del numero doble formateado
     * @param numStr  cadena que contiene el numero
     * @param digits  numero de digitos depues del punto decimal
     */
    public static String toString(double num, int dec) {
        if(num == 0.0 || Double.isNaN(num) || Double.isInfinite(num)
        // Si el número es menor a 10^(-dec), no tiene valor a
        // visualizar (por ejemplo: si dec=2 (10^-2=0.01) no son
        // visible valores menores a 0.01, por lo tanto visualiza 0.0)
        || num < Math.pow(10, -dec))
            return new String(ZEROS);
        Double d = new Double(num);
        return formatDouble(d.toString(), dec);
    }//fin de toString
    
    /**
     * Da formato a un numero float a una cadena separada por comas.
     * @param numero a convertir
     * @return equivalente del numero en una cadena  ya formateado
     */
    
    /** Da formato a un numero flotante para poder ser deplegado por medio de
     * comas.
     * @param numero numero a convertir
     * @return
     */
    public static String formatNumericFloat(float numero){
        try{
            Float numero_tmp = new Float(numero);
            return formatNumeric(numero_tmp.toString());
        }catch(Exception e){
            return "0.0";
        }
    }//fin de formatNumericFloat
    
    /**
     * Recibe como parametro el string de un numero y regresa el string del
     * numero con formato de separacion con una coma cada tres digitos
     *
     * @param strnum   String del numero sin formato.
     *                 El numero puede tener decimales.
     * @return String  numero formateado
     **/
    public static String formatNumeric(String strNum) {
        
        String number;
        String deci = ".00";
        char[] aux;
        char[] auxinv;
        int pos   = 0;
        int count = 0;
        int size  = 0;
        
        if(strNum.length() >= 3) {
            if(strNum.charAt(strNum.length()-1) == '0' &&
            strNum.charAt(strNum.length()-2) == '.' ) {
                number = strNum.substring(0,strNum.length()-2);
            } else {
                number = strNum;
            }
        } else {
            number = strNum;
        }
        
        // si tiene punto decimal
        if(number.indexOf('.')!=-1) {
            size  = number.length()+
            (int)(number.indexOf('.')/DIGITS)+2;
            aux   = new char [size];
            auxinv= new char [size];
        } else {
            size  = number.length()+
            (int)(number.length()/DIGITS)+2;
            aux   = new char [size];
            auxinv= new char [size];
        }
        
        int i;
        // si tiene punto decimal
        if(number.indexOf('.') != -1) {
            for(i=number.length()-1; i >= number.indexOf('.'); i--) {
                aux[pos] = number.charAt(i);
                pos++;
            }
            for(i=number.indexOf('.')-1; i >= 0; i--) {
                aux[pos] = number.charAt(i);
                pos++;
                count++;
                if(count%DIGITS == 0 && i != 0) {
                    aux[pos] = ',';
                    pos++;
                }
            }
        } else {
            for(i=number.length()-1; i>=0; i--) {
                aux[pos]=number.charAt(i);
                pos++; count++;
                if(count%DIGITS==0 && i!=0) {
                    aux[pos]=',';
                    pos++;
                }
            }
        }
        count= pos;
        pos  = 0;
        for(i = count-1; i >= 0; i--) {
            auxinv[i]=aux[pos];
            pos++;
        }
        try {
         /* en caso de que haya quedado una celda null
          * chaecar que en la version 1.1 pone basura
          */
            for(i = 0; i < size; i++){
                if(auxinv[i] == '\0'){
                    auxinv[i] = ' ';
                }
            }
        } catch (Exception e) { }
        
        String numForm = String.copyValueOf(auxinv);
        //Verifica que el formato no comience con coma
        if ((numForm.startsWith(","))|| (numForm.startsWith("-,"))){
            if (numForm.startsWith(",")){
              numForm = numForm.substring(1); 
            }
            if (numForm.startsWith("-,")){
                numForm = "-"+ numForm.substring(2); 
            }
        }//fin de startsWith
        try {
            if(numForm.charAt(numForm.length()-1) == '0' &&
            numForm.charAt(numForm.length()-2) == '.' ) {
                //return (numForm.substring(0,numForm.length()-2));
                return (numForm.trim()+deci);
            } else {
                if (numForm.indexOf('.') != -1){
                    //Substrae los ultimos caracteres de la cadena
                    String decimales = numForm.substring(numForm.indexOf('.') +1);
                    if (decimales.length() >= 2)
                        return (numForm.trim());
                    else
                        return (numForm.trim()+"0");
                }else{
                    return (numForm.trim()+deci);
                }
            }
        } catch (Exception e2) {
            return (numForm.trim());
        }
    }//fin de formatNumeric
    
    /**
     * Suma dos cantidad para obtener los decimales correspondientes
     *
     * @param cCantUn cadena correspondiente al número
     * @param cCantUn cadena correspondiente al número
     * return la suma de los números
     */
    public static double sumaCantDec(String cCantUno,String cCantDos){
        //Parte decimal de un número
        double iDecimal = 0;
        //Parte entera del número
        int iEntero = 0;
        
        //Saca la parte decimal de los numeros y los suma
        if (cCantUno.indexOf(".")!=-1){
            iDecimal = iDecimal + toDouble(cCantUno.substring(cCantUno.indexOf(".")));
        }else{
            iDecimal = 0;
        }
        if (cCantDos.indexOf(".")!=-1){
            iDecimal = iDecimal + toDouble(cCantDos.substring(cCantDos.indexOf(".")));
        }
        
        //Saca la parte decimal de los numeros y los suma
        if (cCantUno.indexOf(".")!=-1){
            iEntero = iEntero + toInt(cCantUno.substring(0,cCantUno.indexOf(".")));
        }else{
            iEntero = toInt(cCantUno);
        }
        if (cCantDos.indexOf(".")!=-1){
            iEntero = iEntero + toInt(cCantDos.substring(0,cCantDos.indexOf(".")));
        }else{
            iEntero = iEntero + toInt(cCantDos);
        }
        
        //Suma la parte decimal y entera
        return (iDecimal + iEntero);
        
    }//fin de sumaCantDec
    
    /**
     * Da formato a una cantidad indicando el tipo de monera PESOS o DOLARES.
     * Si la varaible isPesos=false despliega PESOS en caso contrariio despliega
     * DOLARES.
     *
     * @param cantidad a convertir
     * @param isPesos si es false configura la cantidad a pesos, si es true
     * la configura a dolares
     * @return la cantidad configurada en Pesos o Dolares
     */
    public static String pesosDolares(double cantidad,boolean isPesos){
        StringBuffer sb = new StringBuffer();
        //Obtiene la cantidad en letra
        String cCadena = "";
        int iNumeroEntero = 0;
        
        //verifica si la cantidad a convertir es mayor de cero
        if (cantidad > 0){
            
            // Se obtienen los millones de la cantidad
            iNumeroEntero = toInt(cantidad/1000000);
            
            if (iNumeroEntero > 0){
                cCadena = genera(1000000,cantidad,cCadena,true);
                cantidad = modCantidad(1000000,cantidad);
                cCadena = cCadena + "MILLONES ";
            } // fin de 1000000
            
            // Se obtienen los miles de pesos de la cantidad
            iNumeroEntero = toInt(cantidad/1000);
            if (iNumeroEntero > 0 ){
                cCadena = genera(1000,cantidad,cCadena,true);
                cantidad = modCantidad(1000,cantidad);
                cCadena = cCadena + "MIL ";
            } //fin de 1000
            
            // Se obtienen las decenas de la cantidad
            iNumeroEntero = toInt(cantidad);
            
            if (iNumeroEntero > 0){
                cCadena = genera(1,cantidad,cCadena,true);
                cantidad = modCantidad(1,cantidad);
            } //fin de  0
            
        }else{
            cCadena = "CERO ";
        } // fin de verificación de cantidad
        
        //se configura el tipo de moneda utilizado
        if (isPesos){
            cCadena = cCadena + "DOLARES";            
        }else{
            cCadena = cCadena + "PESOS";
        } // fin de tipo de moneda
        
        // Se obtienen los centavos de la cantidad
        iNumeroEntero = toInt(cantidad*100.1);
        if (iNumeroEntero > 0 ){
            cCadena = cCadena + " " + toInt(cantidad * 100.1) +"/100";
        }else{
            cCadena = cCadena + " 00/100";
        } // fin de centavos
        
        if (isPesos){
            cCadena = cCadena + " USD";
        }else{
            cCadena = cCadena + " M.N.";
        }// fin de tipo de moneda
        
        //Retorna la cadena configurada
        return cCadena.trim();
        
    }//fin de pesosDolares
    
   
    /**
     * Convierte una cantidad numerica a su equivalente en en letra, el numero doble 
     * es convertido a entero.
     * @param cantidad a convertir
     * @return el equivalente en letra de la cantidad indicada.
     */
    public static String cantidadLetra(double cantidad){
        StringBuffer sb = new StringBuffer();
        //Obtiene la cantidad en letra
        String cCadena = "";
        int iNumeroEntero = 0;
        
        //verifica si la cantidad a convertir es mayor de cero
        if (cantidad > 0){
            
            // Se obtienen los millones de la cantidad
            iNumeroEntero = toInt(cantidad/1000000);
            
            if (iNumeroEntero > 0){
                cCadena = genera(1000000,cantidad,cCadena,true);
                cantidad = modCantidad(1000000,cantidad);
                cCadena = cCadena + "MILLONES ";
            } // fin de 1000000
            
            // Se obtienen los miles de pesos de la cantidad
            iNumeroEntero = toInt(cantidad/1000);
            if (iNumeroEntero > 0 ){
                cCadena = genera(1000,cantidad,cCadena,true);
                cantidad = modCantidad(1000,cantidad);
                cCadena = cCadena + "MIL ";
            } //fin de 1000
            
            // Se obtienen las decenas de la cantidad
            iNumeroEntero = toInt(cantidad);
            
            if (iNumeroEntero > 0){
                cCadena = genera(1,cantidad,cCadena,false);
                cantidad = modCantidad(1,cantidad);
            } //fin de  0
            
        }else{
            cCadena = "CERO ";
        } // fin de verificación de cantidad
        
        //Retorna la cadena configurada
        return cCadena.trim();
    } //fin cantidadLetra
    
    /** 
     * Genera un número de tres digitos para obtener su respectivo
     * equivalente en cadena de caracteres
     *
     * @param iCeros cifra que indica si son millones, miles o decenas las que se
     * va a procesar
     * @param iCantidad cantidad que se va a convertir
     * @param cCadena cadena que contiene la cifra en letra para que sea actualizada
     * @param isDinero indinca si la cifra que se va a convertir es dinero, esta 
     * sirve para poder indincar las de forma correcta cuando la terminación del numero 
     * es uno, si isDinero=true al desplegar 1=UN, si  isDinero=false 1=UNO
     * @return la cadena que tiene la cifra en letra actualizada
     */
    public static String genera(int iCeros,double iCantidad,String cCadena,boolean isDinero){
        //bandera que indica si existen unidades en la cantida
        boolean Flag = true;
        // cCadena : Contiene la cantidad en letra
        String sCadena = cCadena;
        if (toInt(iCantidad/iCeros) > 99){
            
            if (toInt(iCantidad/iCeros) == 100){
                sCadena  = sCadena  + "CIEN ";
            }else{
                sCadena  = sCadena  + Centenas(toInt(iCantidad/(100*iCeros)));
            }
            iCantidad = iCantidad-(100*iCeros*toInt(iCantidad/(100*iCeros)));
        }
        
        if (toInt(iCantidad/iCeros) > 0){
            if (toInt(iCantidad/iCeros) <= 20){
                sCadena = sCadena + " " + Entre1y20(toInt(iCantidad/iCeros));
                iCantidad = iCantidad - (iCeros*toInt(iCantidad/iCeros));
            }else{
                sCadena  = sCadena  + Decenas(toInt(iCantidad/(10*iCeros)));
                if (toInt(iCantidad/(10*iCeros))==2){ 
                    Flag =false;
                }
                
                iCantidad = iCantidad-(10*iCeros*toInt(iCantidad/(10*iCeros)));
                if (toInt(iCantidad/iCeros)>0){
                    if (Flag){
                        sCadena =sCadena + "Y ";
                    }
                    //Verifica si se desea convertir a dinero
                    if (isDinero){
                         sCadena =sCadena  + Unidades(toInt(iCantidad/iCeros));
                    }else{
                        if (toInt(iCantidad/iCeros)==1){
                            sCadena  = sCadena  + " UNO ";
                        }else{
                             sCadena =sCadena  + Unidades(toInt(iCantidad/iCeros));
                        }
                    }
                    iCantidad=iCantidad-(iCeros*toInt(iCantidad/iCeros));
                }
            }
        }
        return sCadena;
    } // fin de genera
    
    /**
     * Modifica la cantidad para armar la cadena equivalente en cadena de
     * caracteres
     * @param int  iCeros cantidad de ceros que contiene la cantidad
     * @param double iCantidad a convertir
     */
    public static double modCantidad(int iCeros,double iCantidad){
        if (toInt(iCantidad/iCeros) > 99){
            iCantidad = iCantidad-(100*iCeros*toInt(iCantidad/(100*iCeros)));
        }
        
        if (toInt(iCantidad/iCeros) > 0){
            if (toInt(iCantidad/iCeros) <= 20){
                iCantidad = iCantidad - (iCeros*toInt(iCantidad/iCeros));
            }else{
                iCantidad = iCantidad-(10*iCeros*toInt(iCantidad/(10*iCeros)));
                
                if (toInt(iCantidad/iCeros)>0){
                    iCantidad=iCantidad-(iCeros*toInt(iCantidad/iCeros));
                }
            }
        }
        return iCantidad;
    } // fin de genera
    
    /**
     * Traduce a cadena de caracteres los
     * números entre el 1 y el 20
     * equivalente en cadena de caracteres
     * @param int iCantidad a convertir
     */
    private static String Entre1y20(int iCantidad){
        //Regresa : Contiene la cantidad en letra*/
        String cRegresa = "";
        
        switch (iCantidad){
            case 0:
                cRegresa=cRegresa+"CERO";
                break;
            case 1:
                cRegresa=cRegresa+"UN";
                break;
            case 2:
                cRegresa=cRegresa+"DOS";
                break;
            case 3:
                cRegresa=cRegresa+"TRES";
                break;
            case 4:
                cRegresa=cRegresa+"CUATRO";
                break;
            case 5:
                cRegresa=cRegresa+"CINCO";
                break;
            case 6:
                cRegresa=cRegresa+"SEIS";
                break;
            case 7:
                cRegresa=cRegresa+"SIETE";
                break;
            case 8:
                cRegresa=cRegresa+"OCHO";
                break;
            case 9:
                cRegresa=cRegresa+"NUEVE";
                break;
            case 10:
                cRegresa=cRegresa+"DIEZ";
                break;
            case 11:
                cRegresa=cRegresa+"ONCE";
                break;
            case 12:
                cRegresa=cRegresa+"DOCE";
                break;
            case 13:
                cRegresa=cRegresa+"TRECE";
                break;
            case 14:
                cRegresa=cRegresa+"CATORCE";
                break;
            case 15:
                cRegresa=cRegresa+"QUINCE";
                break;
            case 16:
                cRegresa=cRegresa+"DIECISEIS";
                break;
            case 17:
                cRegresa=cRegresa+"DIECISIETE";
                break;
            case 18:
                cRegresa=cRegresa+"DIECIOCHO";
                break;
            case 19:
                cRegresa=cRegresa+"DIECINUEVE";
                break;
            case 20:
                cRegresa=cRegresa+"VEINTE";
                break;
        }//	fin del switch
        //termina de configurar la cadena
        cRegresa = cRegresa + " ";
        return cRegresa;
    } // fin de Entre1y20
    
    /**
     * Traduce a cadena de caracteres las centenas
     * equivalente en cadena de caracteres
     * @param iCantidad
     * @return la cantidad de Centenas correspondiente a la cantidad indicada
     */
    private static String Centenas(int iCantidad){
        // cRegresa : Contiene la cantidad en letra*/
        String cRegresa = "";
        switch (iCantidad){
            case 1:
                cRegresa=cRegresa+"CIENTO";
                break;
            case 2:
                cRegresa=cRegresa+"DOSCIENTOS";
                break;
            case 3:
                cRegresa=cRegresa+"TRESCIENTOS";
                break;
            case 4:
                cRegresa=cRegresa+"CUATROCIENTOS";
                break;
            case 5:
                cRegresa=cRegresa+"QUINIENTOS";
                break;
            case 6:
                cRegresa=cRegresa+"SEISCIENTOS";
                break;
            case 7:
                cRegresa=cRegresa+"SETECIENTOS";
                break;
            case 8:
                cRegresa=cRegresa+"OCHOCIENTOS";
                break;
            case 9:
                cRegresa=cRegresa+"NOVECIENTOS";
                break;
        } //fin del case
        //termina de configurar las centenas
        cRegresa = cRegresa + " ";
        return cRegresa;
    } //finde centenas
    
    /**
     * Traduce a cadena de caracteres los a decenas
     * equivalente en cadena de caracteres
     * @param iCantidad
     * @return la cantidad de Decenas correspondientes
     */
    private static String Decenas(int iCantidad){
        // cRegresa : Contiene la cantidad en letra*/
        String cRegresa = "";
        
        switch (iCantidad){
            case 2:
                cRegresa=cRegresa+"VEINTI";
                break;
            case 3:
                cRegresa=cRegresa+"TREINTA ";
                break;
            case 4:
                cRegresa=cRegresa+"CUARENTA ";
                break;
            case 5:
                cRegresa=cRegresa+"CINCUENTA ";
                break;
            case 6:
                cRegresa=cRegresa+"SESENTA ";
                break;
            case 7:
                cRegresa=cRegresa+"SETENTA ";
                break;
            case 8:
                cRegresa=cRegresa+"OCHENTA ";
                break;
            case 9:
                cRegresa=cRegresa+"NOVENTA ";
                break;
        } // fin del switch
        return cRegresa;
    } //fin de decenas
    
    /**
     * Traduce a cadena de caracteres los a unidades
     * equivalente en cadena de caracteres
     * @param int iCantidad a convertir
     */
    private static String Unidades(int iCantidad){
        // cRegresa : Contiene la cantidad en letra*/
        String cRegresa = "";
        
        switch (iCantidad){
            case 0:
                cRegresa=cRegresa+"CERO";
                break;
            case 1:
                cRegresa=cRegresa+"UN";
                break;
            case 2:
                cRegresa=cRegresa+"DOS";
                break;
            case 3:
                cRegresa=cRegresa+"TRES";
                break;
            case 4:
                cRegresa=cRegresa+"CUATRO";
                break;
            case 5:
                cRegresa=cRegresa+"CINCO";
                break;
            case 6:
                cRegresa=cRegresa+"SEIS";
                break;
            case 7:
                cRegresa=cRegresa+"SIETE";
                break;
            case 8:
                cRegresa=cRegresa+"OCHO";
                break;
            case 9:
                cRegresa=cRegresa+"NUEVE";
                break;
        }//fin del switch 
        cRegresa=cRegresa+" ";
        return cRegresa;
    } //fin de Unidades
    
    public static String formatoNumero(float fNumero){
    	if (fNumero<=0){
    		return "0.00";
    	}
    	   // aplicamos un formateador para definir la precisión y formato de los números
        DecimalFormat formateador = new DecimalFormat("###,##0.00");
        System.out.println("El valor del Float formateado es: " + formateador.format(fNumero));

        return formateador.format(fNumero);
    }
    
    public static String formatoNumero(int fNumero){

    	// aplicamos un formateador para definir la precisión y formato de los números
        DecimalFormat formateador = new DecimalFormat("###,##0");
        System.out.println("El valor del Float formateado es: " + formateador.format(fNumero));

        return formateador.format(fNumero);
    }
    
} //End of class Convertions
