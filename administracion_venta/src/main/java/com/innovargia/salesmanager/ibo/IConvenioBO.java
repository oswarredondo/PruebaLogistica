package com.innovargia.salesmanager.ibo;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.administracion.dto.UsuarioConvenioFolio;
import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface IConvenioBO {

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
	
	/***
	 * Obtiene el convenio indicando
	 * @param dto
	 * @throws DataAccessException
	 */
	public ConvenioContratoDTO  get(int idconvenio) throws Exception;
	
	public void delete(UsuarioConvenioFolio obj) throws Exception;
	public List<UsuarioConvenioFolio> getConveniosUsuario(UsuarioDTO usuario)
		throws Exception;

}