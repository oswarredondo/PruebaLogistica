/**
 * 
 */
package com.innovargia.salesmanager.ibo;

import java.util.List;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.NivelUsuarioDTO;

/**
 * @author aruaro
 *
 */
public interface INivelUsuarioBO {
	
	public void deletePuestoAgrupamiento(NivelUsuarioDTO catalogo) throws Exception;

	public void insertPuestoAgrupamiento(NivelUsuarioDTO catalogo) throws Exception;
	
	public List<NivelUsuarioDTO> getRegistrosNivelAgrupamiento(NivelUsuarioDTO catalogo)
			throws Exception;
	/***
	 * Inserta un registro en un catalogo donde solamente existen los atributos
	 * de Id, Nombre, Descripcion y Estatus
	 * @param catalogo
	 * @throws Exception
	 */
	public void insert(NivelUsuarioDTO catalogo) throws Exception;
	
	/***
	 * Actrualiza un registro en un catalogo donde solamente existen los atributos
	 * de Nombre, Descripcion y Estatus dado su ID
	 * @param catalogo
	 * @throws Exception
	 */
	public void update(NivelUsuarioDTO catalogo) throws Exception;
	
	/***
	 * Actrualiza estatus de un registro
	 * @param catalogo
	 * @throws Exception
	 */
	public void updateEstatus(NivelUsuarioDTO catalogo) throws Exception;
	
	/***
	 * Borra un registro en un catalogo dado su id
	 * @param catalogo
	 * @throws Exception
	 */
	public void delete(NivelUsuarioDTO catalogo) throws Exception;
	
	/***
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public List<NivelUsuarioDTO> getRegistros(NivelUsuarioDTO catalogo) throws Exception;
	
	/***
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public NivelUsuarioDTO get(int nivel) throws Exception;
	

	/***
	 * Crea una instancia de la tabla que se esta tratando 
	 * @param tabla
	 * @return
	 */
	public INivelUsuarioBO getInstance(int tabla);
}
