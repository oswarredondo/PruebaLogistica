package com.innovargia.salesmanager.idao;



import java.util.List;

import com.innovargia.salesmanager.dtos.PerfilOpcionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface IPerfilOpcionUsuarioDAO {

	/**
	 * Obtiene los perfiles para una Entidad
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public abstract List<PerfilOpcionDTO> getPerfiles(UsuarioDTO usuario,
			boolean onlyActive) throws Exception;

	/**
	 * Obtiene las  opciones de un perfil de una entidad, isSeleccionados=true indica si 
	 * devuelve las opciones agregadas a un perfil , isSeleccionados=false devuelve 
	 * las opciones que no han sido agregadas a un perfil
	 * 
	 * @param idperfil
	 * @param usuario
	 * @param isSeleccionados
	 * @return ArrayList<PerfilOpcionDTO>
	 * 
	 * @throws Exception
	 */
	public abstract List<PerfilOpcionDTO> getOpcionesPerfil(
			String idperfil, UsuarioDTO usuario, boolean isSeleccionados,
			String idsistema) throws Exception;

	/**
	 * Obtiene todos los perfiles dependiendo del nivel que se indique, si
	 * listaniveles es null regresa todos los perfiles sin importar su nivel.
	 * 
	 * Los niveles deben ir separados por comas y entre comillas, ejemplo
	 * 'O','E'
	 * 
	 * @param usuario
	 * @return PerfilOpcionDTO
	 * @throws Exception
	 */
	public abstract List<PerfilOpcionDTO> getPerfilesXNivel(
			String listaniveles, UsuarioDTO usuario) throws Exception;

	/**
	 * Obtiene el perfil y opciones permitidas para un usuario
	 * 
	 * @param usuario
	 * @param idmodulo indica si la consulta se realiza lo en un mdulo en particular, si el valor
	 * es null regresa todos los modulos
	 * @return PerfilOpcionDTO
	 * @throws Exception
	 */
	public abstract PerfilOpcionDTO  getOpcionesPerfilAcceso(UsuarioDTO usuario,
			String idmodulo) throws Exception;// fin de getOpcionesPerfilAcceso

	/**
	 * Obtiene el perfil y opciones permitidas para un usuario
	 * 
	 * @param usuario
	 * @param idmodulo indica si la consulta se realiza lo en un mdulo en particular, si el valor
	 * es null regresa todos los modulos
	 * @return PerfilOpcionDTO
	 * @throws Exception
	 */
	public abstract PerfilOpcionDTO getOpcionesPerfilAccesoWin(
			UsuarioDTO usuario, String idmodulo) throws Exception;// fin de getOpcionesPerfilAcceso

	/**
	 * Verifica si el usuario tiene permisos para entrar a una opcion en particular
	 * 
	 * @param usuario
	 * @return PerfilOpcionDTO
	 * @throws Exception
	 */
	public abstract PerfilOpcionDTO isOpcionPerfilAcceso(UsuarioDTO usuario,
			String idopcion) throws Exception;// fin de getOpcionesPerfilAcceso

	/**
	 * Agrega un perfil
	 * @param perfil
	 * @throws Exception
	 */
	public abstract void add(PerfilOpcionDTO perfil) throws Exception;

	/**
	 * Borra un perfil
	 * @param perfil
	 * @throws Exception
	 */
	public abstract void delete(PerfilOpcionDTO perfil) throws Exception;

	/**
	 * Actualiza datos del perfil
	 * @param perfil
	 * @throws Exception
	 */
	public abstract void updatePerfil(PerfilOpcionDTO perfil)
			throws Exception;

	/**
	 * Actualiza estado un perfil
	 * @param perfil
	 * @throws Exception
	 */
	public abstract void updateEstado(PerfilOpcionDTO perfil)
			throws Exception;

	/**
	 * Borra una opcion del perfil indicado
	 * @param perfil
	 * @throws Exception
	 */
	public abstract void deleteOpcionPerfil(PerfilOpcionDTO perfil)
			throws Exception;

	/**
	 * Agrega una opcionn al perfil indicado
	 * @param perfil
	 * @throws Exception
	 */
	public abstract void addOpcionPerfil(PerfilOpcionDTO perfil)
			throws Exception;

}