package com.innovargia.recolecciones.idao;

import java.sql.SQLException;
import java.util.List;

import com.innovargia.salesmanager.dtos.RemDes;

public interface IDireccionesRecoleccionDAO {

	/** 
	 * Obtiene los registros de Clientes Remitentes Destino de un usuario, solamente se obtiene
	 * los registros de clientes y usuarios activos
	 * @param idUsuario identificador del Cliente o Usuario activo en la sesion
	 * @param inicial solo los clintes cuyo nombre inicia con la letra especificada
	 * @param ordernax tipor de ordenacion que se desea realizar
	 *   1 = Por numero de Cliente, 2= por Razon Social, 3= Por Atencion
	 *
	 * @param campoBusqueda indica el campo por el cual se va a realizar la busqueda<br>
	 * Si es null o el igual <b>rs</b> se realiza la busqueda por, razonSocial rs<br>
	 * Si es igual a ate se realiza la busqueda por Atencion
	 * Si no es igual a ninguno de estos por omision se realiza la busqueda por Razon Social<br>
	 * Solo cuando el patron de busqueda es deiferente a null y vacio
	 *
	 * @param entre indinca en lugar donde se busca el patron, al iniciio, final o en medio
	 * <br>Si entre=1 la busqueda se realiza al inicio de la cadena
	 * <br>Si entre=2 la busqueda se realiza al final de la cadena
	 * <br>Si entre=3 la busqueda se realiza en cualquier lado de la cadena
	 * <br>Si  no es igual a ninguno de estos o es null  por omision se realiza al inicio de la cadena
	 *
	 * @throws SQLException
	 * @return un arreglo con instancias de RemDes contieniendo los datos del cliente o una lista vacia
	 */
	public abstract List<RemDes> buscaClientesRemDes(int identidad,
			int idorganizacion, String numcliente, String inicial,
			int ordernax, String campoBusqueda, String entre,
			boolean vertodasdirecciones) throws SQLException;//fin de getClientesRemDes

	/**
	 * Actualiza los datos del cliente remitente destino
	 * @return la cantidad de registros afectados
	 */
	public abstract void update(RemDes remdes) throws SQLException;//fin de updateEstado

	/**
	 * Borra el cliente RemDes del usuario activo en la sesion
	 * @return la cantidad de registros afectados
	 */
	public abstract void delete(RemDes remdes) throws SQLException;//fin de delete

	/**
	 * Actualiza los datos del cliente remitente destino
	 * @return la cantidad de registros afectados
	 */
	public abstract void insert(int identidad, int idorganizacion, RemDes remdes)
			throws SQLException;//fin de updateEstado

}