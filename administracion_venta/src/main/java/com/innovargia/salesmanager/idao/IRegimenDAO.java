package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.CatalogoDTO;

public interface IRegimenDAO {

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#insert(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPlazaDAO#insert(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	public abstract void insert(CatalogoDTO catalogo) throws Exception;

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#update(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPlazaDAO#update(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	public abstract void update(CatalogoDTO catalogo) throws Exception;

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#updateEstatus(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPlazaDAO#updateEstatus(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	public abstract void updateEstatus(CatalogoDTO catalogo) throws Exception;

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#delete(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPlazaDAO#delete(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	public abstract void delete(CatalogoDTO catalogo) throws Exception;

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#getRegistros(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPlazaDAO#getRegistros(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	public abstract List<CatalogoDTO> getRegistros(CatalogoDTO catalogo)
			throws Exception;

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#get(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPlazaDAO#get(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	public abstract CatalogoDTO get(CatalogoDTO catalogo) throws Exception;

}