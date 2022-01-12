/**
 * 
 */
package com.innovargia.salesmanager.ibo;

import java.util.List;

import com.innovargia.salesmanager.dtos.ServicioDTO;

/**
 * @author aruaro
 *
 */
public interface IServicioBO {
	/***
	 * Inserta un registro en un catalogo donde solamente existen los atributos
	 * de Id, Nombre, Descripcion y Estatus
	 * @param catalogo
	 * @throws Exception
	 */
	public void insert(ServicioDTO catalogo) throws Exception;
	
	/***
	 * Actrualiza un registro en un catalogo donde solamente existen los atributos
	 * de Nombre, Descripcion y Estatus dado su ID
	 * @param catalogo
	 * @throws Exception
	 */
	public void update(ServicioDTO catalogo) throws Exception;
	
	/***
	 * Actrualiza estatus de un registro
	 * @param catalogo
	 * @throws Exception
	 */
	public void updateEstatus(ServicioDTO catalogo) throws Exception;
	
	/***
	 * Borra un registro en un catalogo dado su id
	 * @param catalogo
	 * @throws Exception
	 */
	public void delete(ServicioDTO catalogo) throws Exception;
	
	/***
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public List<ServicioDTO> getRegistros(ServicioDTO catalogo) throws Exception;
	
	/***
	 * Obtiene los registros de Servicios disponibles que no esten dados de baja para
	 * que se puedan agregar a una entidad-organizacion
	 * @param catalogo
	 * @return
	 * @throws Exception
	 */
	public List<ServicioDTO> getRegistrosEntidadOrganizacio(ServicioDTO catalogo)
			throws Exception;
	
	/***
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public ServicioDTO get(ServicioDTO catalogo) throws Exception;
	
	/**
	 * Actualiza el tipo de cobro de un servicio
	 * @param identificador
	 * @param tipocobro
	 * @throws Exception
	 */
	public void updateTipoCobro(int identificador, int tipocobro) throws Exception;
	

}
