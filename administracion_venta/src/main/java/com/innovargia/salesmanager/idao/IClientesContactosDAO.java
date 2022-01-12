package com.innovargia.salesmanager.idao;

import org.springframework.dao.DataAccessException;

import com.innovargia.salesmanager.dtos.ContactoDTO;

public interface IClientesContactosDAO {

	/***
	 * Obtiene todas las Clientes Cliente
	 * @throws DataAccessException
	 */
	public abstract void getContactos() throws DataAccessException;
	/***
	 * Inserta un registro de Contactos Cliente
	 * @param dto
	 * @throws DataAccessException
	 */
	public abstract void insert(ContactoDTO dto) throws DataAccessException;
	/***
	 * Actualiza un registro de Contactos Cliente
	 * @param dto
	 * @throws DataAccessException
	 */
	public abstract void update(ContactoDTO dto) throws DataAccessException;
	/***
	 * Borra un registro de Contactos Cliente
	 * @param dto
	 * @throws DataAccessException
	 */
	public abstract void delete(ContactoDTO dto) throws DataAccessException;
	/**
	 * Obtiene la informacion de Contactos Cliente
	 * @param dto
	 * @throws DataAccessException
	 */
	public abstract void getInformacion(ContactoDTO dto) throws DataAccessException;

}