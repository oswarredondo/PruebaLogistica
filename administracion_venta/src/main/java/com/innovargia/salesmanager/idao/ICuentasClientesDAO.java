package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;

public interface ICuentasClientesDAO {

	/***
	 * Inserta un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void insert(CuentasDTO obj) throws Exception;
	/***
	 * Actualiza un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void update(CuentasDTO obj) throws Exception;
	/***
	 * Borra un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void delete(CuentasDTO obj) throws Exception;
	/***
	 * Obtiene los registros deseados
	 * @param obj
	 * @throws Exception
	 */
	public abstract List<CuentasDTO> getRegistros(BusquedaDTO obj) throws Exception;
	
	public abstract CuentasDTO get(BusquedaDTO obj) throws Exception;
	
	public List<CuentasDTO> getBusquedaRegistros(BusquedaDTO obj) throws Exception;

	/***
	 * Actualiza el estatus de un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void updateEstatus(CuentasDTO obj) throws Exception;
	
	public void updateTipoManejo(CuentasDTO obj) throws Exception;

}