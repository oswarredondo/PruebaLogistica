package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;

public interface ILogHistoriaDAO {

	/***
	 * Inserta un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void insert(LogHistoriaDTO obj) throws Exception;
	/***
	 * Actualiza un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void update(LogHistoriaDTO obj) throws Exception;
	/***
	 * Borra un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void delete(LogHistoriaDTO obj) throws Exception;
	/***
	 * Obtiene los registros deseados
	 * @param obj
	 * @throws Exception
	 */
	public abstract List<LogHistoriaDTO> getRegistros(LogHistoriaDTO obj) throws Exception;
	
	public abstract LogHistoriaDTO get(LogHistoriaDTO obj) throws Exception;

	/***
	 * Actualiza el estatus de un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void updateEstatus(LogHistoriaDTO obj) throws Exception;
	
	
	/***
	 * Registro de historia de un convenio/cotizacion
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public abstract List<LogHistoriaDTO> getRegistrosConvenio(BusquedaDTO obj) throws Exception;
	
	/***
	 * Inserta un registro de Historia  de un Convenio
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public abstract void insertHistoriaConvenio(LogHistoriaDTO obj) throws Exception;

}