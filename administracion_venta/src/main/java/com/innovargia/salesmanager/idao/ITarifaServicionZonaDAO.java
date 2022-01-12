package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;

public interface ITarifaServicionZonaDAO {

	
	/***
	 * Inserta un registro de tarifa
	 * @param tarifa
	 * @throws Exception
	 */
	public Number insert(TarifaDTO tarifa) throws Exception;
	
	/***
	 * Actualiza un registro de tarifa
	 * @param tarifa
	 * @throws Exception
	 */
	public void update(TarifaDTO tarifa) throws Exception;
	
	/***
	 * Actualiza estatus de la tarifa
	 * @param tarifa
	 * @throws Exception
	 */
	public void updateEstatus(TarifaDTO tarifa) throws Exception;
	
	/***
	 * Borra un registro 
	 * @param tarifa
	 * @throws Exception
	 */
	public void delete(TarifaDTO tarifa) throws Exception;
	
	/***
	 * Obtiene los registros de tarifas
	 * @param tarifa
	 * @throws Exception
	 */
	public List<TarifaDTO>  getRegistros(BusquedaDTO tarifa) throws Exception;

	
	/***
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public TarifaDTO get(TarifaDTO tarifa) throws Exception;
	
	/***
	 *Obtiene el precio de un envio dada una cobertua
	 * @param catalogo
	 * @throws Exception
	 */
	public TarifaDTO  getPrecio(TarifaDTO tarifa) throws Exception;
	
	public List<TarifaDTO>  getListaPrecioPosibles(TarifaDTO tarifa) throws Exception;


}