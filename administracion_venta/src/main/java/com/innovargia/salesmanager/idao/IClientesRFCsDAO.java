package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ClientesDTO;
import com.innovargia.salesmanager.dtos.RemDes;

public interface IClientesRFCsDAO {

	/***
	 * Inserta un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void insert(RemDes obj) throws Exception;
	/***
	 * Actualiza un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void update(RemDes obj) throws Exception;
	/***
	 * Borra un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void delete(RemDes obj) throws Exception;

	
	public abstract RemDes get(BusquedaDTO obj) throws Exception;
	
	public List<RemDes> getBusquedaRegistros(BusquedaDTO obj) throws Exception;

	
	/***
	 * Actualiza el estatus de un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void updateEstatus(ClientesDTO obj) throws Exception;
	

}