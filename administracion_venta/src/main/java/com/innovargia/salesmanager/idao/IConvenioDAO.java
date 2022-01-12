package com.innovargia.salesmanager.idao;

import org.springframework.dao.DataAccessException;

import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;

public interface IConvenioDAO {

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
	public abstract void insert(ConvenioContratoDTO dto) throws DataAccessException;
	/***
	 * Actualiza un registro de Clientes
	 * @param dto
	 * @throws DataAccessException
	 */
	public abstract void update(ConvenioContratoDTO dto) throws DataAccessException;
	/***
	 * Borra un registro de Clientes
	 * @param dto
	 * @throws DataAccessException
	 */
	public abstract void delete(ConvenioContratoDTO dto) throws DataAccessException;
	/**
	 * Obtiene la informacion de Clientes
	 * @param dto
	 * @throws DataAccessException
	 */
	public abstract void getInformacion(ConvenioContratoDTO dto) throws DataAccessException;

}