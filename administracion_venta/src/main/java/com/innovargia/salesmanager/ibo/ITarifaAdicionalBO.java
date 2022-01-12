/**
 * 
 */
package com.innovargia.salesmanager.ibo;

import java.util.List;

import com.innovargia.salesmanager.dtos.TarifaAdicionalDTO;

/**
 * @author aruaro
 *
 */
public interface ITarifaAdicionalBO {
	/***
	 * Inserta un registro en un catalogo donde solamente existen los atributos
	 * de Id, Nombre, Descripcion y Estatus
	 * @param catalogo
	 * @throws Exception
	 */
	public void insert(TarifaAdicionalDTO catalogo) throws Exception;
	
	/***
	 * Actrualiza un registro en un catalogo donde solamente existen los atributos
	 * de Nombre, Descripcion y Estatus dado su ID
	 * @param catalogo
	 * @throws Exception
	 */
	public void update(TarifaAdicionalDTO catalogo) throws Exception;
	
	/***
	 * Actrualiza estatus de un registro
	 * @param catalogo
	 * @throws Exception
	 */
	public void updateEstatus(TarifaAdicionalDTO catalogo) throws Exception;
	
	/***
	 * Borra un registro en un catalogo dado su id
	 * @param catalogo
	 * @throws Exception
	 */
	public void delete(TarifaAdicionalDTO catalogo) throws Exception;
	
	/***
	 * Ob tiene la lista de todos los adicionales agregados a una tarifa, solo obtiene los 
	 * registros de una tarifa indicada y que se encuentre en catarifas y catarifaadicionales
	 * @param catalogo
	 * @return
	 * @throws Exception
	 */
	public List<TarifaAdicionalDTO> getRegistros(TarifaAdicionalDTO catalogo)
			throws Exception ;
	
	/***
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public TarifaAdicionalDTO get(TarifaAdicionalDTO catalogo) throws Exception;
	

}
