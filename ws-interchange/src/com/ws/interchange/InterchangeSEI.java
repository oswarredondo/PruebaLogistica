/**
 * Interface que contiene los metodos expuesta por el WS para agregado y solicitud de informacion
 * 
 */
package com.ws.interchange;

import javax.jws.WebService;

@WebService(name = "InterchangeSEI", targetNamespace = "http://interchange.ws.com/")
public interface InterchangeSEI {

	/**
	 * Verifica que el nombre del servidor sea correcto
	 * 
	 * @param servidor
	 *            nombre del servidor al que se tiene que agregar la in
	 * @return
	 */
	public boolean isCorrectServer(String servidorcliente);

	/**
	 * Proceso principal encargado de validar los datos antes de ser agregado o
	 * actualizados en la base de datos
	 * 
	 * @param arreglo
	 *            contiene todos los registros de información que se van a
	 *            procesar
	 * @param nomarchivo
	 *            nombre del archivo del cual se estan obtieniendo los datos
	 * @param siglasplaza
	 *            siglas de la plaza de donde se esta obteniendo la informacion
	 * @return arreglo con todas las lineas de error, en caso de que nos e haya
	 *         podido procesar un un registro por N razon.
	 */
	public String[] procesaPlaza(String[] arreglo, String nomarchivo,
			String siglasplaza);

	/**
	 * Proceso principal encargado de validar los datos antes de ser agregado o
	 * actualizados en la base de datos
	 * 
	 * Este proceso contiene dos arreglos:<br>
	 * 
	 * String[] arreglo: Contiene todos los registos de intercabio a procesar
	 * <br>
	 * String[] configuracion: Contiene la configuración del servidor que esta
	 * procesando la información <br>
	 * los datos del arreglo de configuración deben venir en el siguiente orden:
	 * SiglasPlaza->0, Servidor->1, Numero de Cliente->2,Nombre del archivo
	 * procesado->3, Display
	 * 
	 * @param arreglo
	 *            contiene todos los registros de información que se van a
	 *            procesar
	 * @param configuracion
	 *            onfiguración del servidor que esta procesando la información
	 * @return un arregl arreglo con todas las lineas de error, en caso de que
	 *         nos e haya podido procesar un un registro por N razon.
	 */
	public String[] procesa(String[] arreglo, String[] configuracion);
	
	
	/**
	 * Descarga la informacion solicitada dependiendo del registro solicitado
	 * String[] tabla indica los datos de la tabla o archivo que desea descargar
	 *  - excpciones.dat_<NUM ENTIDAD>    = 01
	 *  - excepciones03.dat_<NUM ENTIDAD> = 02	
	 *  - excepciones04.da_<NUM ENTIDAD>  = 03
	 *  - plazas.dat_<NUM ENTIDAD>	      = 04
	 *  - catalogos.dat_<NUM ENTIDAD>     = 05
	 *  - users.dat_<NUM ENTIDAD>	      = 06
	 *  
	 *  Cada archivo debe tener el sufijo de la entidad a la que pertenece, ellector
	 *  debe estar configurado con la entidad el primer elemento del arreglo de configuracion
	 *  indica el numero de entidad a la que pertenece.
	 *  
	 *  Si existe informacion regresa un arreglo  con la informacion solicitada
	 *  
	 * @param configuracion 
	 * @param arreglo
	 * @return
	 */
	public String[] downloadInfo(String[] configuracion, String[] tabla);

}