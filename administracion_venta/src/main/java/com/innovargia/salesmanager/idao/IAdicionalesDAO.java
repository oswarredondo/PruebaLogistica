package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.CatalogoDTO;

public interface IAdicionalesDAO {

	public abstract void insert(CatalogoDTO catalogo) throws Exception;

	public abstract void update(CatalogoDTO catalogo) throws Exception;

	public abstract void updateEstatus(CatalogoDTO catalogo) throws Exception;

	public abstract void delete(CatalogoDTO catalogo) throws Exception;

	public abstract List<CatalogoDTO> getRegistros(CatalogoDTO catalogo)
			throws Exception;

	public abstract CatalogoDTO get(CatalogoDTO catalogo) throws Exception;
	

	/***
	 * Obtiene los adicionales existentes de acuerdo a su tipo
	 * @param catalogo
	 * @return
	 * @throws Exception
	 */
	public List<CatalogoDTO> getRegistrosXTipo(CatalogoDTO catalogo) throws Exception ;

}