package com.innovargia.recolecciones.ibo;

import java.sql.SQLException;
import java.util.List;

import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface IDireccionRecoleccionBO {

	/***
	 * Obtiene la consulta de acuerdo a los parametros pasados por el usuario
	 * @param identidad
	 * @param idorganizacion
	 * @param numcliente
	 * @param inicial
	 * @param ordernax
	 * @param campoBusqueda
	 * @param entre
	 * @param vertodasdirecciones
	 * @return
	 * @throws SQLException
	 */
	public abstract List<RemDes> getBuscaDireccion(int identidad,
			int idorganizacion, String numcliente, String inicial,
			int ordernax, String campoBusqueda, String entre,
			String vertodasdirecciones) throws SQLException;

	/***
	 * 
	 * @param identidad
	 * @param idorganizacion
	 * @param remdes
	 * @throws SQLException
	 */
	public abstract void insert(int identidad, int idorganizacion, RemDes remdes)
			throws SQLException;

	/***
	 * Actualiza el registro de direccion de recoleccion
	 * @param remdes
	 * @throws SQLException
	 */
	public abstract void update(RemDes remdes) throws SQLException;

	/***
	 * Borra un registro de direccion de recoleccion
	 * @param remdes
	 * @throws SQLException
	 */
	public abstract void delete(RemDes remdes, UsuarioDTO usuario)
			throws SQLException;

}