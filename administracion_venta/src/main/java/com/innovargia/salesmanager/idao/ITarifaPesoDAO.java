package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;

public interface ITarifaPesoDAO {

	/***
	 * Obtiene la lista de pesos tomando como base la columna de volumen y 
	 * devuelve el primer registro en el que caiga el rango del volumen indicado 
	 * por el usuario.
	 * 
	 * Si no encuentra ninguno dode caiga devuelve el ultimo registro 
	 * @param tarifa
	 * @param obj
	 * @return
	 * @throws Exception
	 */
   // public List<TarifaDTO> getRegistrosVolumenDisponibles(TarifaDTO tarifa,
	//    ConvenioContratoDetalleDTO obj) throws Exception;
    
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
	 * Obtiene la lista de todos los pesos disponibles en un rango de envio, indicando 
	 * su sobre peso
	 * @param tarifa
	 * @return
	 * @throws Exception
	 */
	//public List<TarifaDTO> getRegistrosPesoDisponibles(TarifaDTO tarifa,ConvenioContratoDetalleDTO obj) throws Exception;

	
	/***
	 * Obtiene los registros de un catalogo indicando un criterio de busqueda
	 * @param catalogo
	 * @throws Exception
	 */
	public TarifaDTO get(TarifaDTO tarifa) throws Exception;
	
	/**
	 * calcula el sobre peso para un peso y un rango de envios seleccionado
	 * @param tarifa
	 * @return
	 * @throws Exception
	 */
	//public float getSobrePeso(TarifaDTO tarifa) throws Exception;

}