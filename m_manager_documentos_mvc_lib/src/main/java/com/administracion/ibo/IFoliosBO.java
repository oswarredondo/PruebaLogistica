package com.administracion.ibo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.administracion.dto.Folios;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface IFoliosBO {

	/**
	 * Obtiene la lista de los rangos de folios asignados a un cliente con folios disponibles
	 *
	 * @param numero de cliente
	 * @return lista con instancias de Folios conteniendo los datos, vacia en caso de no encontrar algun dato
	 */
	public abstract List<Folios> getFolios(String cliente, int identidad,
			int idorganizacion, String login) throws SQLException;//fin de getListaUsuarios
	
	
  	public  List<Folios> getConvenios(String cliente, int identidad, int idorganizacion, String login, String tipo_formulario) throws SQLException ;

	/**
	 * Obtiene el ultimo consecutivo para el tipo de servicio seleccionado, para poder crear un rango
	 * encriptado, de un servicio determinado
	 *
	 * @param numero de cliente
	 * @return lista con instancias de Folios conteniendo los datos, vacia en caso de no encontrar algun dato
	 */
	public abstract int getFoliosPCUltimo(String servicio) throws SQLException;//fin de getListaUsuarios

	/**
	 * Obtiene la lista de los rangos de folios asignados a un cliente con folios disponibles
	 *
	 * @param numero de cliente
	 * @return lista con instancias de Folios conteniendo los datos, vacia en caso de no encontrar algun dato
	 */
	public abstract  List<Folios> getFoliosAdmin(String cliente)
			throws SQLException;//fin de getFoliosAdmin

	/**
	 * Obtiene la lista de los rangos de folios asignados a un cliente con folios disponibles
	 *
	 * @param numero de cliente
	 * @return lista con instancias de Folios conteniendo los datos, vacia en caso de no encontrar algun dato
	 */
	public abstract  List<Folios> getFoliosPC(String cliente) throws SQLException;//fin de getFoliosAdmin

	/**
	 * Aumenta el contador de los envios utilizados, cuando se esta imprimiendo por la web
	 * @param idServicio identificador del servicio
	 * @param cliente identificador del cliente (numero de cliente)
	 * @throws SQLException
	 * @return true si existen a�n envio, false en caso contrario
	 */
	public abstract void updateEnviosDisponibles(int entidad, int organizacion,
			String idServicio, String cliente, int peso, Connection cnx)
			throws SQLException;//fin de getListaUsuarios

	/***
	 * Actualiza los registros de retorno para un cliente
	 * @param entidad
	 * @param organizacion
	 * @param idServicio
	 * @param cliente
	 * @param peso
	 * @param cnx
	 * @throws SQLException
	 */
	public abstract void updateEnviosDisponiblesRetorno(int entidad,
			int organizacion, String idServicio, String cliente, int peso,
			Connection cnx) throws SQLException;//fin de getListaUsuarios

	/**
	 * Verifica si a�n existen envios disponibles dentro del rango seleccionado
	 * @param idServicio identificador del servicio
	 * @param cliente identificador del cliente (numero de cliente)
	 * @throws SQLException
	 * @return true si existen a�n envio, false en caso contrario
	 */
	public abstract boolean isEnviosDisponibles(String idServicio,
			String cliente, int peso) throws SQLException;//fin de getListaUsuarios

	//////
	/**
	 * Verifica si existe un rango de web con los datos seleccionados por el usuario
	 * @param idServicio identificador del servicio
	 * @param cliente identificador del cliente (numero de cliente)
	 * @throws SQLException
	 * @return true si existen a�n envio, false en caso contrario
	 */
	public abstract boolean isExisteRangoWeb(String idServicio, String cliente,
			int peso) throws SQLException;//fin de getListaUsuarios

	/**
	 * Aumenta el contador de los envios utilizados, utilizado en el modulo de administracion
	 * @param idServicio identificador del servicio
	 * @param cliente identificador del cliente (numero de cliente)
	 * @throws SQLException
	 * @return true si existen a�n envio, false en caso contrario
	 */
	public abstract void updateEnviosDisponibles(Folios folios)
			throws SQLException;//fin de updateEnviosDisponibles

	/**
	 * Inicializa a cero el valor de los consecutrivos utilizados por el usuario
	 * @param idServicio identificador del servicio
	 * @param cliente identificador del cliente (numero de cliente)
	 * @throws SQLException
	 * @return true si existen a�n envio, false en caso contrario
	 */
	public abstract void initUtilizadas(Folios folios) throws SQLException;//fin de updateEnviosDisponibles

	/**
	 * Borra el registro de rangos de folios
	 * @param idServicio identificador del servicio
	 * @param cliente identificador del cliente (numero de cliente)
	 * @throws SQLException
	 * @return true si existen a�n envio, false en caso contrario
	 */
	public abstract void deleteRangoFolios(Folios folios) throws SQLException;//fin de updateEnviosDisponibles

	/**
	 * Aumenta el contador de los envios utilizados
	 * @param idServicio identificador del servicio
	 * @param cliente identificador del cliente (numero de cliente)
	 * @throws SQLException
	 * @return true si existen a�n envio, false en caso contrario
	 */
	public abstract void incrementaFoliosWeb(Folios folios) throws SQLException;//fin de getListaUsuarios

	/**
	 * Inserta un registro de Folios en el Web
	 * @param folios datos de un folios de servicios asiganda al Web
	 * @throws SQLException
	 * @return true si existen a�n envio, false en caso contrario
	 */
	public abstract void insertFoliosWeb(Folios folios) throws SQLException;//fin de getListaUsuarios

	/**
	 * Inserta un registro de Folios en el Web
	 * @param folios datos de un folios de servicios asiganda al Web
	 * @throws SQLException
	 * @return true si existen a�n envio, false en caso contrario
	 */
	public abstract void insertLogFoliosWeb(Folios folios, String evento)
			throws SQLException;//fin de getListaUsuarios

	/**
	 * Inserta un registro de Folios para la PC
	 * @param folios datos de un folios de servicios asiganda al Web
	 * @throws SQLException
	 * @return true si existen a�n envio, false en caso contrario
	 */
	public abstract void insertFoliosPC(Folios folios) throws SQLException;//fin de getListaUsuarios

	/**
	 * Obtiene el consecutivo de la guia
	 *
	 * @return el identificador de la guia
	 * @throws SQLException
	 */
	public abstract String getConsecutivo() throws SQLException;

	/**
	 * Obtiene la fecha Maxima del ultimorango insertado en la tabla correspondiente
	 * a un cliente
	 *
	 * @param numero de cliente
	 * @return la fecha Maxima del ultimo rango de un cliente insertado, el formato
	 * es AAAA-MM-DD HH:MM:SS en caso de que no haya registros regresa null
	 */
	public abstract String getMaxFechaFolios(String cliente)
			throws SQLException;//fin de getFoliosAdmin
	
	/**
	 * Obtiene los convenios para los usuarios de PDV
	 * @param usuario
	 * @return
	 * @throws SQLException
	 */
	public  List<Folios> getConveniosAutoDocPDV(UsuarioDTO usuario) throws SQLException;
	
	public Folios getFoliosDisponibles(String idservicio, String numcliente, 
   			int peso_amparado, int identidad, int idorganizacion) throws SQLException;


}