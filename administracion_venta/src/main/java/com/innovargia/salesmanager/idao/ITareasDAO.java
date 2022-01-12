package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.TareaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface ITareasDAO {

	/***
	 * Inserta un registro de una tarea
	 * @param catalogo
	 * @throws Exception
	 */
	public abstract Number insert(TareaDTO catalogo) throws Exception;
	
	public abstract void insertResponsable(TareaDTO catalogo) throws Exception;

	/***
	 * Actualiza los datos de una tarea
	 * @param catalogo
	 * @throws Exception
	 */
	public abstract void update(TareaDTO catalogo) throws Exception;

	/***
	 * Actualiza el estatus de una tarea
	 * @param catalogo
	 * @throws Exception
	 */
	public abstract void updateEstatus(TareaDTO catalogo) throws Exception;

	/***
	 * Borra una tarea indica
	 * @param catalogo
	 * @throws Exception
	 */
	public abstract void delete(TareaDTO catalogo) throws Exception;

	/***
	 * Obtiene todas las tareas asignadas a un usuario como tareas pendientes
	 * obtiene
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public abstract List<TareaDTO> getAsignadasAlUsuario(UsuarioDTO usuario)
			throws Exception;
	
	/***
	 * Obtiene todas las tareas que genero un usuario
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public List<TareaDTO> getCreadasPorElUsuario(UsuarioDTO usuario) throws Exception;
	/***
	 * Obtiene todas las tareas asociadas, es decir si una tarea es
	 * originada por otra tienen una relación por lo que el usuario podria
	 * cerrar todas o comunicar a todos los usuarios que se ha realizado un 
	 * cambio en la tarea final.
	 * 
	 * Es decir si un asesor solicita un descuento a su supervisor pero este no 
	 * tiene privilegios para poder otorgarlo creará una nueva tarea a su director
	 * y este ultimo realizada la asignación del descuento y tendrá la posibilidad
	 * de comunicarlo al supervisor y al asesor si asi lo desea.
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public abstract List<TareaDTO> getTareasAsociadas(TareaDTO tarea)
			throws Exception;


	/***
	 * Obtiene la tarea indicada
	 * @param catalogo
	 * @return
	 * @throws Exception
	 */
	public abstract TareaDTO get(TareaDTO catalogo) throws Exception;
	
	/**
	 * Obtiene todas las tareas existentes
	 * @return
	 * @throws Exception
	 */
	public abstract List<TareaDTO> getExistentes()throws Exception;
	
	/***
	 * Obtiene todas las tareas creadas por el usuario de tipo SOLICITUD
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public List<TareaDTO> getCreadasPorElUsuarioDeUnTipo(UsuarioDTO usuario, String tipo) throws Exception;


}