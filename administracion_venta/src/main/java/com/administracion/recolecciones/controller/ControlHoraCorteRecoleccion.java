/**
 * 
 */
package com.administracion.recolecciones.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author aruaro ejemplo
 * 
 */
@RequestMapping("/controlhoracorterecoleccion")
@Controller
public class ControlHoraCorteRecoleccion {

    /**
     * 
     */
    public ControlHoraCorteRecoleccion() {
	// TODO Auto-generated constructor stub
    }


    private String hora_str;
    private int hora_int;
    private String fecha;
    private String horacorte = "14:00 hrs.";

    public int isHoraCorte() {
	Calendar cal = Calendar.getInstance();
	java.util.Date fecha = new Date(cal.getTime().getTime());

	// Da formato a la fecha
	SimpleDateFormat formato = new SimpleDateFormat("HH:mm");
	SimpleDateFormat formato1 = new SimpleDateFormat("HHmm");
	SimpleDateFormat formato_fecha = new SimpleDateFormat(
		"dd-MM-yyyy HH:mm");
	String hora_int = formato1.format(fecha.getTime());
	this.hora_int = Integer.parseInt(hora_int);
	this.hora_str = formato_fecha.format(fecha.getTime());
	this.fecha = formato.format(fecha.getTime());

	if (this.hora_int > 1400) {
	    return 1;
	} else if (this.hora_int == 1400) {
	    return 2;
	} else {
	    return 0;
	}

    }

   

    /**
     * @return the hora_str
     */
    public synchronized String getHora_str() {
	return hora_str;
    }

    /**
     * @param hora_str
     *            the hora_str to set
     */
    public synchronized void setHora_str(String hora_str) {
	this.hora_str = hora_str;
    }

    /**
     * @return the hora_int
     */
    public synchronized int getHora_int() {
	return hora_int;
    }

    /**
     * @param hora_int
     *            the hora_int to set
     */
    public synchronized void setHora_int(int hora_int) {
	this.hora_int = hora_int;
    }

    /**
     * @return the fecha
     */
    public synchronized String getFecha() {
	return fecha;
    }

    /**
     * @param fecha
     *            the fecha to set
     */
    public synchronized void setFecha(String fecha) {
	this.fecha = fecha;
    }

    /**
     * @return the horacorte
     */
    public String getHoracorte() {
	return horacorte;
    }

    /**
     * @param horacorte
     *            the horacorte to set
     */
    public void setHoracorte(String horacorte) {
	this.horacorte = horacorte;
    }

}
