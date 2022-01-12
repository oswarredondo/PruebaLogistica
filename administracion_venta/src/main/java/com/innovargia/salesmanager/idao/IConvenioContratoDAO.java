package com.innovargia.salesmanager.idao;

import java.util.List;

import com.administracion.dto.UsuarioConvenioFolio;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface IConvenioContratoDAO {

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
	 * Actualiza datos de firmas
	 * @param obj
	 * @throws Exception
	 */
	public abstract void updateFirmas(ConvenioContratoDTO obj) throws Exception;
	
	/**
	 * Actualiza los datos de revision
	 * @param obj
	 * @throws Exception
	 */
	public void updateDatosRevision(ConvenioContratoDTO obj) throws Exception;
	
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
	public abstract List<ConvenioContratoDTO> getRegistros(BusquedaDTO obj) throws Exception;
	
	
	/***
	 * Obtiene un registro 
	 * @param obj
	 * @return
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
	 * Actualiza los datos restantes del convenio
	 * @param obj
	 * @throws Exception
	 */
	//public void updateConvenio(ConvenioContratoDTO obj) throws Exception;
	
	/***
	 * Actualiza el dato del creador del documneto
	 * @param obj
	 * @throws Exception
	 */
	public void updateUsuarioCreador(ConvenioContratoDTO obj) throws Exception;
	
	public void deleteUsuarioConvenioFolio(UsuarioConvenioFolio obj) throws Exception;
	public List<UsuarioConvenioFolio> getConveniosUsuario(UsuarioDTO usuario)
		throws Exception;
	
	

}