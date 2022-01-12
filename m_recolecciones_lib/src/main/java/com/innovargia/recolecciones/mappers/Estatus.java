/**
 * 
 */
package com.innovargia.recolecciones.mappers;

import java.util.HashMap;

/**
 * @author Adrián
 *
 */
public class Estatus {

	public static final String ESTATUS_ACTIVA="A";
	public static final String ESTATUS_CANCELADA="C";
	public static final String ESTATUS_PENDIENTE="P";
	public static final String ESTATUS_DEVUELTA="D";
	public static final String ESTATUS_CONFIRMADA="R";
	
	public static final int RECOL_PROGRAMADA_X_DIA_MSEMANA=1;
	public static final int RECOL_PROGRAMADA_X_DIA_MES=2;
	public static final int RECOL_ESPORADICA=3;
	
	public static final int TIPO_CONSULTA_RECOL_IDSOLICITUD=0;
	public static final int TIPO_CONSULTA_RECOL_NOMBRE_SOLICITANTE=1;
	public static final int TIPO_CONSULTA_RECOL_RANGOFECHAS=2;
	public static final int TIPO_CONSULTA_RECOL_NUMEROCLIENTE=3;
	public static final int TIPO_CONSULTA_RECOL_CONTRATO=4;
	public static final int TIPO_CONSULTA_RECOL_RAZONSOCIALRECO=5;
	public static final int TIPO_CONSULTA_RECOL_ATENCIONRECO=6;
	public static final int TIPO_CONSULTA_RECOL_IDRECOLECCION=7;
	public static final int TIPO_CONSULTA_RECOL_FECHA_INICIO_FIN=8;
	public static final int TIPO_CONSULTA_RECOL_MANIFIESTO=99;
	public static final int TIPO_CONSULTA_RECOL_DIARIA_MANIFIESTO=100;
	public static final int TIPO_CONSULTA_RECOL_DIARIA_RUTA_PLAZA=200;

	public static HashMap<String,String> map_tiposConsulta = new HashMap<String,String> ();
	static{
		map_tiposConsulta.put(TIPO_CONSULTA_RECOL_RANGOFECHAS+"","Rango de fechas");
		map_tiposConsulta.put(TIPO_CONSULTA_RECOL_NOMBRE_SOLICITANTE+"","Nombre del solicitantes");
		map_tiposConsulta.put(TIPO_CONSULTA_RECOL_NUMEROCLIENTE+"","Numero de cliente");
		map_tiposConsulta.put(TIPO_CONSULTA_RECOL_CONTRATO+"","Numero de contrato");
		map_tiposConsulta.put(TIPO_CONSULTA_RECOL_RAZONSOCIALRECO+"","Razón Social de la recolección");
		map_tiposConsulta.put(TIPO_CONSULTA_RECOL_ATENCIONRECO+"","Atención de la recolección");	
		map_tiposConsulta.put(TIPO_CONSULTA_RECOL_IDRECOLECCION+"","Folio de recolección");	
		map_tiposConsulta.put(TIPO_CONSULTA_RECOL_FECHA_INICIO_FIN+"","Fecha de Inicio y Fin");		
	}

}
