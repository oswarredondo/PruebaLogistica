package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.AgrupamientoDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface IUsuarioDAO {

	public abstract void insert(UsuarioCuentaDTO usuario) throws Exception;

	public abstract void update(UsuarioCuentaDTO usuario) throws Exception;

	public abstract void updateEstatus(UsuarioCuentaDTO usuario) throws Exception;

	public abstract void delete(UsuarioCuentaDTO usuario) throws Exception;

	public abstract List<UsuarioDTO> getRegistros(UsuarioDTO usuario)
			throws Exception;

	public abstract UsuarioDTO get(UsuarioCuentaDTO usuario) throws Exception;
	
	public abstract UsuarioDTO getUsuarioLogin(UsuarioDTO usuario) throws Exception;
	
    public void updatePassword(UsuarioDTO user) throws Exception; 
	public void updateWallPaper(UsuarioDTO user) throws Exception;
	public List<UsuarioCuentaDTO> getRegistrosCuentaCliente(BusquedaDTO busqueda) throws Exception ;
	
	/***
	 * Obtiene todos los usuarios con el login indicado
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public List<UsuarioDTO>   getUsuariosConLogin(UsuarioDTO usuario) throws Exception ;
	
	/***
	 * Obtiene todos los usuarios con el nivel indicado
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public List<UsuarioDTO>   getUsuariosConNivel(UsuarioDTO usuario) throws Exception ;
	
	/***
	 * Obtiene todos los usuarios que se encuentran en el grupo indicado
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public List<UsuarioDTO>   getUsuariosConGrupo(UsuarioDTO usuario) throws Exception ;
	
	/***
	 * Obtiene todos los usuarios que se encuentran dados de alta y que estan activos
	 * @param usuario
	 * @param soloActivos
	 * @return
	 * @throws Exception
	 */
	public List<UsuarioDTO>   getTodosLosUsuarios( boolean soloActivos) throws Exception ;
	
	
	/***
	 * Obtiene todas las agrupaciones disponibles para un usuario
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public List<AgrupamientoDTO>   getAgrupaciones(UsuarioDTO usuario) throws Exception ;
	
	
	/***
	 * Agrega agrupamiento para el usurio
	 * @param usuario
	 * @throws Exception
	 */
	public abstract void insertAgrupamiento(AgrupamientoDTO usuario) throws Exception;
	/***
	 * Elimina el registro de agrupamiento para el usuario
	 * @param usuario
	 * @throws Exception
	 */
	public abstract void deleteAgrupamiento(AgrupamientoDTO usuario) throws Exception;
	
	/**
	 * Obtiene los usuarios que tengan el mismo agrupamiento del usuario indicado, para 
	 * esto se obtienen todos los posibles grupos asignados al usuario y de estos de obtiene 
	 * todos los usuarios que esten dados de alta para esos grupos de usuarios encontrados
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public List<UsuarioDTO>   getUsuariosDeUnAgrupamiento(UsuarioDTO usuario) throws Exception ;
	
	
	public void insertConvenioUsuario(UsuarioCuentaDTO obj, int idconvenio) throws Exception;

	

}