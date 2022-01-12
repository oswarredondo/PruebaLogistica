package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;

public interface ICotizacionPreConvenioDAO {

	

	/***
	 * Inserta un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract Number insert(ConvenioContratoDTO obj) throws Exception;
	/***
	 * Actualiza un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void update(ConvenioContratoDTO obj) throws Exception;
	/***
	 * Borra un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void delete(ConvenioContratoDTO obj) throws Exception;
	/***
	 * Obtiene los registros deseados
	 * @param obj
	 * @throws Exception
	 */
	public abstract List<ConvenioContratoDTO> getRegistros(BusquedaDTO busqueda) throws Exception;
	
	
	/***
	 * Obtiene los registros deseados
	 * @param obj
	 * @throws Exception
	 */
	public abstract ConvenioContratoDTO get(ConvenioContratoDTO obj) throws Exception;

	/***
	 * Actualiza el estatus de un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void updateEstatus(ConvenioContratoDTO obj) throws Exception;
	
	
	/***
	 * Actualiza el dato del creador del documneto
	 * @param obj
	 * @throws Exception
	 */
	public void updateUsuarioCreador(ConvenioContratoDTO obj) throws Exception;
	
	/***
	 * Actrualiza el tipo de cierre
	 * @param catalogo
	 * @throws Exception
	 */
	public void updateTipoCierre(ConvenioContratoDTO obj) throws Exception;
	
	

}