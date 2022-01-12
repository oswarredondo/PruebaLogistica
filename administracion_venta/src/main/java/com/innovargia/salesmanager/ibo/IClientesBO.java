package com.innovargia.salesmanager.ibo;

import java.util.List;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ClientesDTO;

public interface IClientesBO {

	/***
	 * Inserta un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void insert(ClientesDTO obj) throws Exception;
	/***
	 * Actualiza un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void update(ClientesDTO obj) throws Exception;
	/***
	 * Borra un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void delete(ClientesDTO obj) throws Exception;
	/***
	 * Obtiene los registros deseados
	 * @param obj
	 * @throws Exception
	 */
	public abstract List<ClientesDTO> getRegistros(BusquedaDTO obj) throws Exception;
	
	public abstract ClientesDTO get(BusquedaDTO obj) throws Exception;

	/***
	 * Actualiza el estatus de un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void updateEstatus(ClientesDTO obj) throws Exception;
	
	public List<ClientesDTO> getBusquedaRegistros(BusquedaDTO obj) throws Exception;
	
	/***
	 * Ajusta el valor de tipo de cliente
	 * 0= prospecto
	 * 1= cliente
	 * @param obj
	 * @throws Exception
	 */
	public void  setTipoCliente(ClientesDTO obj) throws Exception; 
	
	
	
	/***
	 * Actualiza el usuario creador de un cliente
	 * @param obj
	 * @throws Exception
	 */
	public abstract void updateUsuarioCreador(ClientesDTO obj) throws Exception;

}