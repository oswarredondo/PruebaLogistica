/*
 * FormatoNumeros.java
 *
 * Created on 20 de agosto de 2007, 03:33 PM
 */

package com.innovargia.utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author  AMorales
 */
public class FormatoNumeros {
    
      /*Locale[] locales = {
          //new Locale("fr","FR"),
          //new Locale("de","DE"),
          new Locale("en","US")
      };*/
    Locale locales = new Locale("en","US");
    
    
    public String displayNumber(Double amount) {
       
        NumberFormat numberFormatter;
        numberFormatter = NumberFormat.getNumberInstance(locales);
        return numberFormatter.format(amount);
    }
    
    public String displayCurrency(Double currency) {
        
        NumberFormat currencyFormatter;
        String currencyOut;
        
        currencyFormatter = NumberFormat.getCurrencyInstance(locales);
        return currencyFormatter.format(currency);
        
    }
    
    public String displayPercent( Double percent) {
        
        NumberFormat percentFormatter;
        String percentOut;
        
        percentFormatter = NumberFormat.getPercentInstance(locales);
        return percentFormatter.format(percent);
        
    }
    
   
    /** Creates a new instance of FormatoNumeros */
    public FormatoNumeros() {
    }
    
    
}//fin de formmato numeros
