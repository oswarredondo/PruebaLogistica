package com.innovargia.salesmanager.ibo;

import java.util.List;

import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;

public interface IConvenioContratoDetalleBO {

    public void updatePrecio(ConvenioContratoDetalleDTO obj) throws Exception;
    
	/***
	 * Inserta un registro
	 * @param obj
	 * @throws Exception
	 */
	public abstract void insert(ConvenioContratoDetalleDTO obj) throws Exception;
	
	/***
	 * inserta una linea procedente de una Cotizacion a un Convenio, en este 
	 * ya no se necesita realizar validaciones
	 * @param obj
	 * @throws Exception
	 */
	
	public void insertLineaCotizacionAConvenio(ConvenioContratoDetalleDTO obj) throws Exception;
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