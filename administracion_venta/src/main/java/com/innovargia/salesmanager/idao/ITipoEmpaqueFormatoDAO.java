package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.ServicioDTO;

public interface ITipoEmpaqueFormatoDAO {

	public abstract void insert(CatalogoDTO catalogo) throws Exception;

	public abstract void update(CatalogoDTO catalogo) throws Exception;

	public abstract void updateEstatus(CatalogoDTO catalogo) throws Exception;

	public abstract void delete(CatalogoDTO catalogo) throws Exception;

	/***
	 * Selecciona los servicios que fueron dados de alta en la entidad/organizacion
	 * en catiposervicio  y que estan con estatus activo en caservicios
	 * @param catalogo
	 * @return
	 * @throws Exception
	 */
	public abstract List<CatalogoDTO> getRegistros(CatalogoDTO catalogo)
			throws Exception;

	public abstract CatalogoDTO get(CatalogoDTO catalogo) throws Exception;

}