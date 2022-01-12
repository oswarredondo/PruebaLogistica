/**
 * 
 */
package com.servicio.search.ibo;

import java.util.List;

import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.PlazaDTO;

/**
 * @author aruaro
 *
 */
public interface IBusquedaPlazaBO {
	/***
	 * Inserta un registro en un catalogo donde solamente existen los atributos
	 * de Id, Nombre, Descripcion y Estatus
	 * @param catalogo
	 * @throws Exception
	 */
	public void insert(PlazaDTO catalogo) throws Exception;
	
	/***
	 * Actrualiza un registro en un catalogo donde solamente existen los atributos
	 * de Nombre, Descripcion y Estatus dado su ID
	 * @param catalogo
	 * @throws Exception
	 */
	public void update(PlazaDTO catalogo) throws Exception;
	
	/***
	 * Actrualiza estatus de un registro
	 * @param catalogo
	 * @throws Exception
	 */
	public void updateEstatus(PlazaDTO catalogo) throws Exception;
	
	/***
	 * Borra un registro en un catalogo dado su id
	 * @param catalogo
	 * @throws Exception
	 */
	public void delete(PlazaDTO catalogo) throws Exception;
	
	/***
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public List<PlazaDTO> getRegistros(PlazaDTO catalogo) throws Exception;
	
	/***
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public PlazaDTO get(PlazaDTO catalogo) throws Exception;
	
	/**
	 * Obtiene los datos del cruce de los dos centros operaivos indicados
	 * @param catalogo
	 * @return
	 * @throws Exception
	 */
	public CruceCoberturaDTO getCobertura(CruceCoberturaDTO catalogo) throws Exception;
	
	
	public List<PlazaDTO> getRegistrosPais() throws Exception ;
	

}
