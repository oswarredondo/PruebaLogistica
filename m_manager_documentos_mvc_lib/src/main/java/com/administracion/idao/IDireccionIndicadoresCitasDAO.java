package com.administracion.idao;

import java.sql.SQLException;
import java.util.List;

import com.administracion.dto.DireccionIndicadorCita;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface IDireccionIndicadoresCitasDAO {

	/**
	 * Obtiene el indicar para checar si tiene Cita
	 * 
	 * @param usuario
	 * @param customer
	 * @return
	 * @throws SQLException
	 */
	public abstract DireccionIndicadorCita getIndicadorCitaCuentaCte(
			UsuarioDTO usuario, String customer) throws SQLException;// fin de getIndicadorCitaCuentaCte

	/**
	 * Obtiene una lista de indicadores de una organizacion y una entidad, en caso de no 
	 * enconttrar devuelve una lista vacia.
	 * 
	 * Si se indica el customer solo devuelve el registro que machee con el customer , organizacion i entidad
	 * 
	 * @param usuario
	 * @param customer
	 * @return
	 * @throws SQLException
	 */
	public abstract List<DireccionIndicadorCita> getListaIndicadorCitaCuentaCte(
			UsuarioDTO usuario, String customer) throws SQLException;// fin de getIndicadorCitaCuentaCte

	/**
	 * Obtiene una lista de indicadores de una organizacion y una entidad, en caso de no 
	 * enconttrar devuelve una lista vacia.
	 * 
	 * Si se indica el customer solo devuelve el registro que machee con el customer , organizacion i entidad
	 * 
	 * @param usuario
	 * @param customer
	 * @return
	 * @throws SQLException
	 */
	public abstract List<DireccionIndicadorCita> getListaDirIndicadorCitaBusqueda(
			UsuarioDTO usuario, String dato, int tipo) throws SQLException;// fin de getIndicadorCitaCuentaCte

	/**
	 * Inserta un nuevo registro de direccion de indicador para citas
	 * 
	 * @param datos
	 * @throws SQLException
	 */
	public abstract void insert(DireccionIndicadorCita datos)
			throws SQLException;

	/**
	 * Actualiza los datos de una direccion de indicador de citas
	 * 
	 * @param datos
	 * @throws SQLException
	 */
	public abstract void update(DireccionIndicadorCita datos)
			throws SQLException;

	/**
	 * Borra un registros de direccion de indicador de registro
	 * 
	 * @param datos
	 * @throws SQLException
	 */
	public abstract void delete(DireccionIndicadorCita datos)
			throws SQLException;

}