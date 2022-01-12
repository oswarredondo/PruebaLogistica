package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.DireccionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface IDireccionDAO {

	/***
	 * Inserta un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void insert(DireccionDTO obj) throws Exception;
	/***
	 * Actualiza un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void update(DireccionDTO obj) throws Exception;
	/***
	 * Borra un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void delete(DireccionDTO obj) throws Exception;
	/***
	 * Obtiene los registros deseados
	 * @param obj
	 * @throws Exception
	 */
	public abstract List<DireccionDTO> getRegistros(DireccionDTO obj, UsuarioDTO usuario) throws Exception;
	
	public abstract DireccionDTO get(DireccionDTO obj) throws Exception;

	/***
	 * Actualiza el estatus de un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void updateEstatus(DireccionDTO obj) throws Exception;
	
	/***
	 * Verifica si ya existe dada de alta una direccion
	 * @param obj
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public List<DireccionDTO> getVerificaExistencia(DireccionDTO obj, UsuarioDTO usuario,String operacion) throws Exception;
	
	public List<DireccionDTO> getRegistrosClienteFact(DireccionDTO obj, UsuarioDTO usuario) throws Exception;

}