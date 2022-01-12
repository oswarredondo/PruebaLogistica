package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.DescuentoDTO;

public interface IDescuentoClienteDAO {

	/***
	 * Inserta un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void insert(DescuentoDTO obj) throws Exception;
	/***
	 * Actualiza un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void update(DescuentoDTO obj) throws Exception;
	/***
	 * Borra un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void delete(DescuentoDTO obj) throws Exception;
	/***
	 * Obtiene los registros deseados
	 * @param obj
	 * @throws Exception
	 */
	public abstract List<DescuentoDTO> getRegistros(BusquedaDTO obj) throws Exception;
	
	/***
	 * Obtiene todos los registros que pueden ser asigandos al descuento
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<DescuentoDTO> getRegistrosDisponibles(BusquedaDTO obj) throws Exception;
	
	
	/***
	 * Obtiene los registros deseados
	 * @param obj
	 * @throws Exception
	 */
	public abstract DescuentoDTO get(DescuentoDTO obj) throws Exception;

	/***
	 * Actualiza el estatus de un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void updateEstatus(DescuentoDTO obj) throws Exception;

}