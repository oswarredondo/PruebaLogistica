package com.innovargia.salesmanager.ibo;

import org.springframework.dao.DataAccessException;

import com.innovargia.salesmanager.dtos.ClientesDTO;

public interface OrdenServicioBO {

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