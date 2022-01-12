/* $Id:  $
 * Nombre del Proyecto: tvirtual.utils
 * Nombre del Programa: LogFormatter.java
 * Descripcion: Formato simple para java.util.logging loggers.
 *
 * $Log:  $
 */

package com.innovargia.utils;

import java.io.*;
import java.util.Date;
import java.util.logging.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Formato simple para bitacoras de java.util.logging. 
 *
 * @author AMR
 * @version $Id: $
 */
public class LogFormato extends Formatter {
    /**
     * Formato para fechas y tiempos.  Ver {@link java.text.SimpleDateFormat}
     * para detalles.
     */
    private static final String FORMATO = "dd-MM-yy HH:mm:ss";
    
    /** Nueva linea. */
    private static final String NL = "\n";
    
    /** Seperador de campos. */
    private static final String SEP =": ";
    
    /** Formatizador de fechas y tiempos. */
    private DateFormat formatizador;
    
    /**
     * Crea nueva instancia.
     */
    public LogFormato() {
        formatizador = DateFormat.getDateTimeInstance(DateFormat.SHORT,
                                                      DateFormat.MEDIUM);
        // Intentar cambiar el formato
        // Solo sirve si la fabrica regreso una instancia de SimpleDateFormat,
        // pero siempre (casi) debe de hacer eso.
        try {
            ((SimpleDateFormat) formatizador).applyPattern(FORMATO);
        } catch (Exception e) {
            // Seguimos con el patron por omision
        }
    } // fin LogFormatter
    
    /** Regresa una cadena con el tiempo en el formato local. */
    private String milisToFechaStr(long ms) {
        synchronized (formatizador) {
            return formatizador.format(new Date(ms));
        }
    } // fin milisToFechaStr
    
    /**
     * Convierte el registro a una cadena para una bitacora.<br>
     * El formato es corto, como {@link java.util.logging.SimpleFormatter},
     * pero incluye el stacktrace completo si <code>rec</code> 
     * es Throwable (lanza excepcion).<br>
     * No incluye la clase o metodo de origen.<br>
     * Tiempos y fechas dados con formato "dd-MM-yy HH:mm:ss".  Ver
     * {@link java.text.SimpleDateFormat} para detalles.
     * Algo importante es que los tiempos usan 24 horas (0-23) en lugar
     * de "AM/PM".
     * <p>
     * <b>Formatos</b><br>
     * En todos los casos la cadena termina con una nueva linea.
     * <ul>
     * <li><em>Si incluye un Throwable t:</em>
     *    fecha: msj: t.message \n t.stackTrace
     * <li><em>Si hay otros parametros:</em>
     *    fecha: msj: param1, param2, ..., paramN
     * <li><em>Si nada mas hay un mensaje:</em>
     *    fecha: msj
     * </ul>
     * <p>
     * Nota que no se llama a este metodo directamente.  Se llama por
     * medio de una bitacora.
     *
     * @param rec Registro de logging para convertir
     * @return Una cadena que representa un registro <code>rec</code> en la bitacora.
     */
    public String format(LogRecord rec) {
        long ms         = rec.getMillis();
        String msj      = rec.getMessage();
        Object[] params = rec.getParameters();
        Throwable t     = rec.getThrown();
        
        /* Si hay throwable t esperamos que no hay params.
         * Formato= fecha: msj: t.message \n t.stackTrace */
        // TODO: Manejar caso si hay params tambien
        if (t != null) {
            return milisToFechaStr(ms) + SEP + msj + SEP + t.getMessage();
        } // fin if hay throwable
        
        /* Si hay parametros, imprimelos
         * Formato= fecha: msj: params */
        if (params != null && params.length > 0) {
            StringBuffer paramsBuf = new StringBuffer();
            for (int i = 0; i < params.length; i++) {
                paramsBuf.append(params[i]);
                if ((i + 1) < params.length) { paramsBuf.append(", "); }
            }
            return milisToFechaStr(ms) + SEP + msj + SEP + paramsBuf + NL;
        } // fin if hay parametros
        
        /* No hay throwable ni parametros.
         * Formato= fecha: msj */
        return milisToFechaStr(ms) + SEP + msj + NL;
    } // }}} fin format
    
} // fin LogFormatter
