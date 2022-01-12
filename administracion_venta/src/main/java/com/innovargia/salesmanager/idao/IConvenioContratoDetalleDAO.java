package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;

public interface IConvenioContratoDetalleDAO {

    public void updatePrecio(ConvenioContratoDetalleDTO obj) throws Exception;
    
	/***
	 * Inserta un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void insert(ConvenioContratoDetalleDTO obj) throws Exception;
	/***
	 * Actualiza un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void update(ConvenioContratoDetalleDTO obj) throws Exception;
	/***
	 * Borra un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void delete(ConvenioContratoDetalleDTO obj) throws Exception;
	/***
	 * Obtiene los registros deseados
	 * @param obj
	 * @throws Exception
	 */
	public abstract List<ConvenioContratoDetalleDTO> getRegistros(ConvenioContratoDetalleDTO obj) throws Exception;
	
	
	/***
	 * Obtiene un registro 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public abstract ConvenioContratoDetalleDTO get(ConvenioContratoDetalleDTO obj) throws Exception;


	/***
	 * Actualiza el estatus de un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void updateEstatus(ConvenioContratoDetalleDTO obj) throws Exception;
	
	

}