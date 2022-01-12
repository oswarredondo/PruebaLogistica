package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.ServicioDTO;

public interface ITipoServicioDAO {

	public abstract void insert(ServicioDTO catalogo) throws Exception;

	public abstract void update(ServicioDTO catalogo) throws Exception;

	public abstract void updateEstatus(ServicioDTO catalogo) throws Exception;

	public abstract void delete(ServicioDTO catalogo) throws Exception;

	/***
	 * Selecciona los servicios que fueron dados de alta en la entidad/organizacion
	 * en catiposervicio  y que estan con estatus activo en caservicios
	 * @param catalogo
	 * @return
	 * @throws Exception
	 */
	public abstract List<ServicioDTO> getRegistros(ServicioDTO catalogo)
			throws Exception;

	public abstract ServicioDTO get(ServicioDTO catalogo) throws Exception;

}