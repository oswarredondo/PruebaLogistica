package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.AgrupamientoDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface IAgrupamientoJerarquiaDAO {

	public abstract void insert(AgrupamientoDTO catalogo) throws Exception;

	public abstract void update(AgrupamientoDTO catalogo) throws Exception;

	public abstract void updateEstatus(AgrupamientoDTO catalogo) throws Exception;

	public abstract void delete(AgrupamientoDTO catalogo) throws Exception;

	public abstract List<AgrupamientoDTO> getRegistros(BusquedaDTO catalogo)
			throws Exception;

	public abstract AgrupamientoDTO get(AgrupamientoDTO catalogo) throws Exception;
	
	/***
	 * Obtiene los agrupamienstos de un usuario
	 * @param login
	 * @return
	 * @throws Exception
	 */
	public List<AgrupamientoDTO> getRegistrosAgrupamientosUsuario(String login)
			throws Exception ;
	

	/***
	 * Obtiene los adicionales existentes de acuerdo a su tipo
	 * @param catalogo
	 * @return
	 * @throws Exception
	 */
	public List<AgrupamientoDTO> getRegistrosXTipo(CatalogoDTO catalogo) throws Exception ;
	
	/**
	 * Obtiene una lista con los usuarios cuyo nivel es el inmediato superior al del usuario que se indica
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public List<UsuarioCuentaDTO> getNivelSuperiorDelUsuario(UsuarioDTO  usuario) throws Exception;
	
	
	/**
	 * Obtiene todos los usuarios del mismo agrupamimiento del usuario sin importar el nivel
	 * @param usuario
	 * @param nivelsuperior
	 * @return
	 * @throws Exception
	 */
	public List<UsuarioCuentaDTO> getUsuariosDelMismoGrupo(UsuarioDTO  usuario) throws Exception;
	
	/***
	 * Obtiene todos los usuarios del agrupamiento cuyo nivel sea igual al indicado
	 * @param usuario
	 * @param nivelsuperior
	 * @return
	 * @throws Exception
	 */
	public List<UsuarioCuentaDTO> getNivelSuperiorIndicandoElNivel(UsuarioDTO  usuario, 
			int nivelsuperior) throws Exception;
	
	/***
	 * Devuleve todos los usuarios del agrupamiento que tienen un nivel superior al nivel del usuario indicado
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public List<UsuarioCuentaDTO> getNivelSuperiorDelUsuarioTodos(UsuarioDTO  usuario) throws Exception;

	
	
}