package com.innovargia.salesmanager.ibo;

import java.util.List;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.DireccionDTO;

public interface ICodigosPostalesBO {

	public abstract void insert(DireccionDTO catalogo) throws Exception;

	public abstract void update(DireccionDTO catalogo) throws Exception;

	public abstract void updateEstatus(DireccionDTO catalogo) throws Exception;

	public abstract void delete(DireccionDTO catalogo) throws Exception;

	public abstract List<DireccionDTO> getRegistros(BusquedaDTO catalogo)
			throws Exception;

	public abstract DireccionDTO get(DireccionDTO catalogo) throws Exception;

}