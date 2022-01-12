package com.innovargia.administracion.ibo;

import java.sql.SQLException;
import java.util.List;

import com.innovargia.salesmanager.dtos.AgrupamientoDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface IUsuarioBO {



	public abstract List<UsuarioDTO> getRegistros(UsuarioDTO usuario)
			throws Exception;

	public abstract UsuarioCuentaDTO get(UsuarioCuentaDTO usuario) throws Exception;
	
	public abstract UsuarioDTO getUsuarioLogin(UsuarioDTO usuario) throws Exception;
	
	public void updatePassword(UsuarioDTO user) throws Exception ;
	
	public void updateWallPaper(UsuarioDTO user) throws Exception;
	public UsuarioDTO getUsuarioDeCliente(UsuarioDTO usuario) throws Exception;
	/***
	 * Obtiene todos los usuarios pertenecientes al mismo agrupamiento y nivel del usuario, 
	 * de la misma forma checa el nivel del usuario para poder determinar su ambito (entidad, organizacion, cuenta, usuario)
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public List<UsuarioDTO>   getUsuariosDeUnAgrupamientoYNivel(UsuarioDTO usuario) throws Exception ;

	public List<UsuarioCuentaDTO> getRegistrosCuentaCliente(BusquedaDTO busqueda) throws Exception;
	
	/***
	 * Verifica si el usuario de sesion es valido, en este caso no se encripta el pass ya que esta en
	 * sesion encriptado
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public UsuarioDTO checkSesoinUsuarioLogin(UsuarioDTO usuario) throws Exception;
	
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
	
	
	/***
	 * Obtiene los datos de la organizacin, entidad y cuenta a la que esta asociada el usuario 
	 * @param user
	 * @throws SQLException
	 */
	public void getEntidadOrganizacion(UsuarioDTO user) throws SQLException ;
	
	public String getRfc(UsuarioDTO usuario) throws Exception;
}