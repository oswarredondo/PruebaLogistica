/* $Id: $
 * Nombre del Proyecto:
 * Nombre del Programa: Frecuencias.java
 * Responsable: Adri�n Morales Ruaro
 * Descripcion: Contiene datos de frecuencias de entrega, con esto se puede
 * consultar los datos de una frecuencia de entrega indicando un origen y un destino
 *
 *$Log:$
 */
package com.innovargia.documentos.dtos;

//Imports
import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;



//import org.apache.struts.validator.ValidatorForm;

/**
 *<CODE>
 * Datos para el desplegado de frecuencias de entrega
 *</CODE>
 * 
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Frecuencias implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Indica si existe un tranlado entre un cporigen y un cpdestino
	private boolean translado = false;

	String busqueda = "CP";
	String enrutamiento= "";

	public ArrayList lista = new ArrayList();
	/** Codigo postal origen */
	String codOrigen;
	/** Codigo postal destino */
	String codDestino;

	/** Garantia seleccionada para la frecuencia que se busca */
	String decripcionGarantia;
	/**
	 * Identificador de la garantia de entrega, -1 indica que no se tiene una
	 * garantia definida para el CP
	 */
	String idGarantia = "-1";

	/**Indica si un servicio tiene Garantia */
	private String tieneGarantia = "C";
	
	private String tipo;
	

	/** c�DIGO POSTAL */
	private String cp;
	/** Identificador del servicio */
	private String servicio;
	/** Descripcion del servicio */
	private String descripcionServicio;
	/** Identificador CentroOperativo */
	private String centroOperativo;
	/** Identificador Mensajeria */
	private String mensajeria;
	/** Identificador RutaEnt */
	private String rutaEnt;
	/** Identificador EntDomOcu */
	private String entDomOcu;
	/** Identificador Prioridad */
	private int prioridad;
	/** Identificador DiasGar */
	private String diasGar;
	/** Identificador SemanaGar */
	private String semanaGar;
	/** Identificador TiempoEnt */
	private int tiempoEnt;
	/** Comentarios */
	private String comentario;
	/** Estado */
	private String estado;
	
	private String idterminal;
	private String garantiamax;
	private String idzonaventa;
	private String idagrupador;
	private int periodicidad;
	private int ocurre;
	private int reexpedicion_r;
	private int reexpedicion_e;
	private String zonaventa;
	
	private String lunes;
	private String martes;
	private String miercoles;
	private String jueves;
	private String  viernes;
	private String  sabado;
	private String  domingo;
	private String  observacion;
	private int mismodia;
	
	private boolean zona_extendida=false;
	private boolean zona_fronteriza=false;
	


	/** Identificador del d�a LUNES */
	public static String LUNES = "Lu";
	/** Identificador del d�a MARTES */
	public static String MARTES = "Ma";
	/** Identificador del d�a MIERCOLES */
	public static String MIERCOLES = "Mi";
	/** Identificador del d�a JUEVES */
	public static String JUEVES = "Ju";
	/** Identificador del d�a VIERNES */
	public static String VIERNES = "Vi";
	/** Identificador del d�a SABADO */
	public static String SABADO = "Sa";
	/** Identificador del d�a DOMINGO */
	public static String DOMINGO = "Do";

	/** Identificador de la SEMANA_1 */
	public static int SEMANA_1 = 1;

	/** Identificador de la SEMANA_2 */
	public static int SEMANA_2 = 2;

	/** Identificador de la SEMANA_3 */
	public static int SEMANA_3 = 3;

	/** Identificador de la SEMANA_4 */
	public static int SEMANA_4 = 4;

	/** Identificador de la DOMICILIO */
	public static int DOMICILIO = 1;
	/** Identificador de la OCURRE */
	public static int OCURRE = 0;
	
	/**
	 * Contructor por default
	 **/
	public Frecuencias() {
		super();
	}
	
	
	/**
	 * Verifica si existe entrega el dia indicado, de acuerdo a los d�as de la
	 * semana indicados: <b>LUNES</b> <b>MARTES</b> <b>MIERCOLES</b>
	 * <b>JUEVES</b> <b>VIERNES</b> <b>SABADO</b> <b>DOMINGO</b>
	 * 
	 * Si la posici�n del dia indica es igual a CERO = 0; no se realizan
	 * entregas ese dia
	 **/
	public boolean isEntregaEnDia(String dia) {

		if ((this.diasGar == null) || (dia == null)
				|| (this.diasGar.trim().length() < 7))
			return false;

		int posicion = -1;
		if (dia.trim().equals(Frecuencias.LUNES)) {
			posicion = 0;
		} else if (dia.trim().equals(Frecuencias.MARTES)) {
			posicion = 1;
		} else if (dia.trim().equals(Frecuencias.MIERCOLES)) {
			posicion = 2;
		} else if (dia.trim().equals(Frecuencias.JUEVES)) {
			posicion = 3;
		} else if (dia.trim().equals(Frecuencias.VIERNES)) {
			posicion = 4;
		} else if (dia.trim().equals(Frecuencias.SABADO)) {
			posicion = 5;
		} else if (dia.trim().equals(Frecuencias.DOMINGO)) {
			posicion = 6;
		} else {
			return false;
		}

		boolean valor_retornado;
		String dato = null;

		if (posicion == 6) {
			dato = this.diasGar.trim().substring(posicion);
			valor_retornado = this.diasGar.trim().substring(posicion).equals(
					"0") ? false : true;
		} else {
			dato = this.diasGar.trim().substring(posicion, posicion + 1);
			valor_retornado = this.diasGar.trim().substring(posicion,
					posicion + 1).equals("0") ? false : true;
			;
		}
		return valor_retornado;
	}// fin de isEntregaEnDia

	/**
	 * Verifica si existe entrega en la semana del mes indicada <b>SEMANA_1</b>
	 * <b>SEMANA_2</b> <b>SEMANA_3</b> <b>SEMANA_4</b>
	 * 
	 * Si la posici�n de la semana indica es igual a CERO = 0; no se realizan
	 * entregas esa semana
	 **/
	public boolean isEntregaEnSemana(int semana) {

		if ((this.semanaGar == null) || (semana <= 0)
				|| (this.semanaGar.trim().length() < 4))
			return false;

		int posicion = -1;
		if (semana == Frecuencias.SEMANA_1) {
			posicion = 0;
		} else if (semana == Frecuencias.SEMANA_2) {
			posicion = 1;
		} else if (semana == Frecuencias.SEMANA_3) {
			posicion = 2;
		} else if (semana == Frecuencias.SEMANA_4) {
			posicion = 3;
		} else {
			return false;
		}

		boolean valor_retornado;

		if (posicion == 3) {
			valor_retornado = this.semanaGar.trim().substring(posicion).equals(
					"0") ? false : true;
		} else {
			valor_retornado = this.semanaGar.trim().substring(posicion,
					posicion + 1).equals("0") ? false : true;
			;
		}
		return valor_retornado;
	}// fin de isEntregaEnSemana

	/**
	 * Verifica si hay entrega ocurre o a domicilio <b>OCURRE</b>
	 * <b>DOMICILIO</b>
	 * 
	 * La primera posici�n indica entrega a domicilio y la segunda indica
	 * entrega a ocurre
	 **/
	public boolean isEntregaDomicilioOcurre(int semana) {

		if ((this.entDomOcu == null) || (semana <= 0)
				|| (this.entDomOcu.trim().length() < 2))
			return false;

		int posicion = -1;
		if (semana == Frecuencias.DOMICILIO) {
			posicion = 0;
		} else if (semana == Frecuencias.OCURRE) {
			posicion = 1;
		} else {
			return false;
		}

		boolean valor_retornado;

		if (posicion == 1) {
			valor_retornado = this.entDomOcu.trim().substring(posicion).equals(
					"0") ? false : true;
		} else {
			valor_retornado = this.entDomOcu.trim().substring(posicion,
					posicion + 1).equals("0") ? false : true;
			;
		}
		return valor_retornado;
	}// fin de isEntregaEnSemana

	/**
	 * Este conjunto de metgodos GET obtienen true o false si la el dia o semana
	 * esta permitido para este tipo de frecuencia
	 */
	public boolean getIsLunes() {
		return isEntregaEnDia(Frecuencias.LUNES);
	}

	public boolean getIsMartes() {
		return isEntregaEnDia(Frecuencias.MARTES);
	}

	public boolean getIsMiercoles() {
		return isEntregaEnDia(Frecuencias.MIERCOLES);
	}

	public boolean getIsJueves() {
		return isEntregaEnDia(Frecuencias.JUEVES);
	}

	public boolean getIsViernes() {
		return isEntregaEnDia(Frecuencias.VIERNES);
	}

	public boolean getIsSabado() {
		return isEntregaEnDia(Frecuencias.SABADO);
	}

	public boolean getIsDomingo() {
		return isEntregaEnDia(Frecuencias.DOMINGO);
	}

	public boolean getIsDomicilio() {
		return isEntregaDomicilioOcurre(Frecuencias.DOMICILIO);
	}

	public boolean getIsOcurre() {
		return isEntregaDomicilioOcurre(Frecuencias.OCURRE);
	}

	public boolean getIs1raSemana() {
		return isEntregaEnSemana(Frecuencias.SEMANA_1);
	}

	public boolean getIs2daSemana() {
		return isEntregaEnSemana(Frecuencias.SEMANA_2);
	}

	public boolean getIs3raSemana() {
		return isEntregaEnSemana(Frecuencias.SEMANA_3);
	}

	public boolean getIs4taSemana() {
		return isEntregaEnSemana(Frecuencias.SEMANA_4);
	}

	// / FIN DE LOS METODOS QUE INDICAN SI ES ENTREGABLE ESE DIA O SEMANA
	/** Devuelve separados por comas si el tipo de entrega es DOMICILIO , OCURRE */
	public String getTipoEntrega() {
		String entrega = "";
		entrega = isEntregaDomicilioOcurre(Frecuencias.DOMICILIO) ? "DOMICILIO "
				: "";
		if (isEntregaDomicilioOcurre(Frecuencias.OCURRE)) {
			if (entrega.trim().length() > 0) {
				entrega = entrega + "," + " OCURRE";
			} else {
				entrega = "OCURRE";
			}
		}
		return entrega.trim();
	}

	/**
	 * Devuelve una cadena con los d�as en los que se realiza la entrega
	 **/
	public String getDiasEntrega() {
		String dia = "";
		dia = isEntregaEnDia(Frecuencias.LUNES) ? "LUN " : "";
		dia += isEntregaEnDia(Frecuencias.MARTES) ? "MAR " : "";
		dia += isEntregaEnDia(Frecuencias.MIERCOLES) ? "MIE " : "";
		dia += isEntregaEnDia(Frecuencias.JUEVES) ? "JUE " : "";
		dia += isEntregaEnDia(Frecuencias.VIERNES) ? "VIE " : "";
		dia += isEntregaEnDia(Frecuencias.SABADO) ? "SAB " : "";
		dia += isEntregaEnDia(Frecuencias.DOMINGO) ? "DOM " : "";

		return dia.trim();
	}

	/**
	 * Devuelve una cadena con la perioricidad de entrega
	 * 
	 * Indica la semanas de entrega de acuerdo a la ocnfigra�n indicada Ejemplo:
	 * si la confiracion de semanas es 1001 el resultado seria 1ra,4ta.
	 * 
	 **/
	public String getPeriodoEntrega() {

		// Verifica si la semana cae dentro de cada uno de los
		// if (this.semanaGar.trim().equals("1111")) return "DIARIO";
		// if ((this.semanaGar.trim().equals("1000")) ||
		// (this.semanaGar.trim().equals("0001")))
		// return "MENSUAL";
		// if (this.semanaGar.trim().equals("1010")) return "SEMANAL";
		// if (this.semanaGar.trim().equals("1001")) return "QUINCENAL";

		// Si no cae en ninguno de esos se indica la semana del mes que se esta
		// entregado
		// en el mes
		String semana = "";
		if (isEntregaEnSemana(Frecuencias.SEMANA_1)) {
			semana = "1ra ";
		}
		if (isEntregaEnSemana(Frecuencias.SEMANA_2)) {
			semana += "2da ";
		}
		if (isEntregaEnSemana(Frecuencias.SEMANA_3)) {
			semana += "3ra ";
		}
		if (isEntregaEnSemana(Frecuencias.SEMANA_4)) {
			semana += "4ta.";
		}

		return semana;
	}

	/**
	 * Verifica si para el d�a indicado existe entrega
	 **/

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getCentroOperativo() {
		return centroOperativo;
	}

	public void setCentroOperativo(String centroOperativo) {
		this.centroOperativo = centroOperativo;
	}

	public String getMensajeria() {
		return mensajeria;
	}

	public void setMensajeria(String mensajeria) {
		this.mensajeria = mensajeria;
	}

	public String getRutaEnt() {
		return rutaEnt;
	}

	public void setRutaEnt(String rutaEnt) {
		this.rutaEnt = rutaEnt;
	}

	public String getEntDomOcu() {
		return entDomOcu;
	}

	public void setEntDomOcu(String entDomOcu) {
		this.entDomOcu = entDomOcu;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public String getDiasGar() {
		return diasGar;
	}

	public void setDiasGar(String diasGar) {
		this.diasGar = diasGar;
	}

	public String getSemanaGar() {
		return semanaGar;
	}

	public void setSemanaGar(String semanaGar) {
		this.semanaGar = semanaGar;
	}

	public int getTiempoEnt() {
		return tiempoEnt;
	}

	public void setTiempoEnt(int tiempoEnt) {
		this.tiempoEnt = tiempoEnt;
	}

	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	

	// ORIGEN

	/**
	 * Getter for property idGarantia.
	 * 
	 * @return Value of property idGarantia.
	 */
	public String getIdGarantia() {
		return idGarantia;
	}

	/**
	 * Setter for property idGarantia.
	 * 
	 * @param idGarantia
	 *            New value of property idGarantia.
	 */
	public void setIdGarantia(String idGarantia) {
		this.idGarantia = idGarantia;
	}

	/**
	 * Getter for property decripcionGarantia.
	 * 
	 * @return Value of property decripcionGarantia.
	 */
	public java.lang.String getDecripcionGarantia() {
		return decripcionGarantia;
	}

	/**
	 * Setter for property decripcionGarantia.
	 * 
	 * @param decripcionGarantia
	 *            New value of property decripcionGarantia.
	 */
	public void setDecripcionGarantia(java.lang.String decripcionGarantia) {
		this.decripcionGarantia = decripcionGarantia;
	}

	/**
	 * Getter for property codOrigen.
	 * 
	 * @return Value of property codOrigen.
	 */
	public java.lang.String getCodOrigen() {
		return codOrigen;
	}

	/**
	 * Setter for property codOrigen.
	 * 
	 * @param codOrigen
	 *            New value of property codOrigen.
	 */
	public void setCodOrigen(java.lang.String codOrigen) {
		this.codOrigen = codOrigen;
	}

	/**
	 * Getter for property codDestino.
	 * 
	 * @return Value of property codDestino.
	 */
	public java.lang.String getCodDestino() {
		return codDestino;
	}

	/**
	 * Setter for property codDestino.
	 * 
	 * @param codDestino
	 *            New value of property codDestino.
	 */
	public void setCodDestino(java.lang.String codDestino) {
		this.codDestino = codDestino;
	}

	/**
	 * Getter for property busqueda.
	 * 
	 * @return Value of property busqueda.
	 */
	public java.lang.String getBusqueda() {
		return busqueda;
	}

	/**
	 * Setter for property busqueda.
	 * 
	 * @param busqueda
	 *            New value of property busqueda.
	 */
	public void setBusqueda(java.lang.String busqueda) {
		this.busqueda = busqueda;
	}

	/**
	 * Getter for property lista.
	 * 
	 * @return Value of property lista.
	 */
	public java.util.ArrayList getLista() {
		return lista;
	}

	/**
	 * Setter for property lista.
	 * 
	 * @param lista
	 *            New value of property lista.
	 */
	public void setLista(java.util.ArrayList lista) {
		this.lista = lista;
	}

	/**
	 * @return the translado
	 */
	public boolean isTranslado() {
		return translado;
	}


	/**
	 * @param translado the translado to set
	 */
	public void setTranslado(boolean translado) {
		this.translado = translado;
	}


	/**
	 * @return the tieneGarantia
	 */
	public String getTieneGarantia() {
		return tieneGarantia;
	}


	/**
	 * @param tieneGarantia the tieneGarantia to set
	 */
	public void setTieneGarantia(String tieneGarantia) {
		this.tieneGarantia = tieneGarantia;
	}


	/**
	 * @return the garantiamax
	 */
	public String getGarantiamax() {
		return garantiamax;
	}


	/**
	 * @param garantiamax the garantiamax to set
	 */
	public void setGarantiamax(String garantiamax) {
		this.garantiamax = garantiamax;
	}


	/**
	 * @return the idterminal
	 */
	public String getIdterminal() {
		return idterminal;
	}


	/**
	 * @param idterminal the idterminal to set
	 */
	public void setIdterminal(String idterminal) {
		this.idterminal = idterminal;
	}


	/**
	 * @return the idzonaventa
	 */
	public String getIdzonaventa() {
		return idzonaventa;
	}


	/**
	 * @param idzonaventa the idzonaventa to set
	 */
	public void setIdzonaventa(String idzonaventa) {
		this.idzonaventa = idzonaventa;
	}


	/**
	 * @return the idagrupador
	 */
	public String getIdagrupador() {
		return idagrupador;
	}


	/**
	 * @param idagrupador the idagrupador to set
	 */
	public void setIdagrupador(String idagrupador) {
		this.idagrupador = idagrupador;
	}


	/**
	 * @return the periodicidad
	 */
	public int getPeriodicidad() {
		return periodicidad;
	}


	/**
	 * @param periodicidad the periodicidad to set
	 */
	public void setPeriodicidad(int periodicidad) {
		this.periodicidad = periodicidad;
	}


	/**
	 * @return the ocurre
	 */
	public int getOcurre() {
		return ocurre;
	}


	/**
	 * @param ocurre the ocurre to set
	 */
	public void setOcurre(int ocurre) {
		this.ocurre = ocurre;
	}


	/**
	 * @return the reexpedicion_r
	 */
	public int getReexpedicion_r() {
		return reexpedicion_r;
	}


	/**
	 * @param reexpedicion_r the reexpedicion_r to set
	 */
	public void setReexpedicion_r(int reexpedicion_r) {
		this.reexpedicion_r = reexpedicion_r;
	}


	/**
	 * @return the reexpedicion_o
	 */
	public int getReexpedicion_e() {
		return reexpedicion_e;
	}


	/**
	 * @param reexpedicion_o the reexpedicion_o to set
	 */
	public void setReexpedicion_e(int reexpedicion_e) {
		this.reexpedicion_e = reexpedicion_e;
	}

	/**
	 * @return the zonaventa
	 */
	public String getZonaventa() {
		return zonaventa;
	}


	/**
	 * @param zonaventa the zonaventa to set
	 */
	public void setZonaventa(String zonaventa) {
		this.zonaventa = zonaventa;
	}


	/**
	 * @return the lunes
	 */
	public String getLunes() {
		return lunes;
	}


	/**
	 * @param lunes the lunes to set
	 */
	public void setLunes(String lunes) {
		this.lunes = lunes;
	}


	/**
	 * @return the martes
	 */
	public String getMartes() {
		return martes;
	}


	/**
	 * @param martes the martes to set
	 */
	public void setMartes(String martes) {
		this.martes = martes;
	}


	/**
	 * @return the miercoles
	 */
	public String getMiercoles() {
		return miercoles;
	}


	/**
	 * @param miercoles the miercoles to set
	 */
	public void setMiercoles(String miercoles) {
		this.miercoles = miercoles;
	}


	/**
	 * @return the jueves
	 */
	public String getJueves() {
		return jueves;
	}


	/**
	 * @param jueves the jueves to set
	 */
	public void setJueves(String jueves) {
		this.jueves = jueves;
	}


	/**
	 * @return the viernes
	 */
	public String getViernes() {
		return viernes;
	}


	/**
	 * @param viernes the viernes to set
	 */
	public void setViernes(String viernes) {
		this.viernes = viernes;
	}


	/**
	 * @return the sabado
	 */
	public String getSabado() {
		return sabado;
	}


	/**
	 * @param sabado the sabado to set
	 */
	public void setSabado(String sabado) {
		this.sabado = sabado;
	}


	/**
	 * @return the domingo
	 */
	public String getDomingo() {
		return domingo;
	}


	/**
	 * @param domingo the domingo to set
	 */
	public void setDomingo(String domingo) {
		this.domingo = domingo;
	}


	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}


	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	/**
	 * @return the mismodia
	 */
	public int getMismodia() {
		return mismodia;
	}


	/**
	 * @param mismodia the mismodia to set
	 */
	public void setMismodia(int mismodia) {
		this.mismodia = mismodia;
	}


	/**
	 * @return the enrutamiento
	 */
	public String getEnrutamiento() {
		return enrutamiento;
	}


	/**
	 * @param enrutamiento the enrutamiento to set
	 */
	public void setEnrutamiento(String enrutamiento) {
		this.enrutamiento = enrutamiento;
	}


	public boolean isZona_extendida() {
		return zona_extendida;
	}


	public void setZona_extendida(boolean zona_extendida) {
		this.zona_extendida = zona_extendida;
	}


	public boolean isZona_fronteriza() {
		return zona_fronteriza;
	}


	public void setZona_fronteriza(boolean zona_fronteriza) {
		this.zona_fronteriza = zona_fronteriza;
	}

} // fin Frecuencias
