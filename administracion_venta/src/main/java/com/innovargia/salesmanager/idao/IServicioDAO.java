package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.ServicioDTO;

public interface IServicioDAO {

	public abstract void insert(ServicioDTO catalogo) throws Exception;

	public abstract void update(ServicioDTO catalogo) throws Exception;

	public abstract void updateEstatus(ServicioDTO catalogo) throws Exception;

	public abstract void delete(ServicioDTO catalogo) throws Exception;

	public abstract List<ServicioDTO> getRegistros(ServicioDTO catalogo)
			throws Exception;
	
	/***
	 * Obtiene los registros de Servicios disponibles que no esten dados de baja para
	 * que se puedan agregar a una entidad-organizacion
	 * @param catalogo
	 * @return
	 * @throws Exception
	 */
	public List<ServicioDTO> getRegistrosEntidadOrganizacio(ServicioDTO catalogo)
			throws Exception;

	public abstract ServicioDTO get(ServicioDTO catalogo) throws Exception;
	
	public void updateTipoCobro(int identificador, int tipocobro) throws Exception;

}