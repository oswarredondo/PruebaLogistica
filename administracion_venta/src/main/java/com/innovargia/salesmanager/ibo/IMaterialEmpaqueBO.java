package com.innovargia.salesmanager.ibo;

import java.util.List;

import com.innovargia.salesmanager.dtos.CatalogoDTO;

public interface IMaterialEmpaqueBO {

	public abstract void insert(CatalogoDTO catalogo) throws Exception;

	public abstract void update(CatalogoDTO catalogo) throws Exception;

	public abstract void delete(CatalogoDTO catalogo) throws Exception;

	public abstract List<CatalogoDTO> getRegistros(CatalogoDTO catalogo)
			throws Exception;

	public abstract CatalogoDTO get(CatalogoDTO catalogo) throws Exception;


}