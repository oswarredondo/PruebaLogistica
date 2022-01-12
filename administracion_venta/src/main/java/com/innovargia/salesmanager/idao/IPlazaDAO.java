package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.PlazaDTO;

public interface IPlazaDAO {

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#insert(com.innovargia.salesmanager.dtos.PlazaDTO)
	 */
	public abstract void insert(PlazaDTO catalogo) throws Exception;

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#update(com.innovargia.salesmanager.dtos.PlazaDTO)
	 */
	public abstract void update(PlazaDTO catalogo) throws Exception;

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#updateEstatus(com.innovargia.salesmanager.dtos.PlazaDTO)
	 */
	public abstract void updateEstatus(PlazaDTO catalogo) throws Exception;

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#delete(com.innovargia.salesmanager.dtos.PlazaDTO)
	 */
	public abstract void delete(PlazaDTO catalogo) throws Exception;

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#getRegistros(com.innovargia.salesmanager.dtos.PlazaDTO)
	 */
	public abstract List<PlazaDTO> getRegistros(PlazaDTO catalogo)
			throws Exception;

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#get(com.innovargia.salesmanager.dtos.PlazaDTO)
	 */
	public abstract PlazaDTO get(PlazaDTO catalogo) throws Exception;

	
	public CruceCoberturaDTO getCobertura(CruceCoberturaDTO catalogo) throws Exception;
	
}