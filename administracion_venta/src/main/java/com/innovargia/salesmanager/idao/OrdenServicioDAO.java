package com.innovargia.salesmanager.idao;

import org.springframework.dao.DataAccessException;

import com.innovargia.salesmanager.dtos.ClientesDTO;

public interface OrdenServicioDAO {

	/***
	 * Obtiene todas las Clientes
	 * @throws DataAccessException
	 */
	public abstract void getClientes() throws DataAccessException;
	/***
	 * Inserta un registro de Cliente 
	 * @param dto
	 * @throws DataAccessException
	 */
	public abstract void insert(ClientesDTO dto) throws DataAccessException;
	/***
	 * Actualiza un registro de Clientes
	 * @param dto
	 * @throws DataAccessException
	 */
	public abstract void update(ClientesDTO dto) throws DataAccessException;
	/***
	 * Borra un registro de Clientes
	 * @param dto
	 * @throws DataAccessException
	 */
	public abstract void delete(ClientesDTO dto) throws DataAccessException;
	/**
	 * Obtiene la informacion de Clientes
	 * @param dto
	 * @throws DataAccessException
	 */
	public abstract void getInformacion(ClientesDTO dto) throws DataAccessException;

}