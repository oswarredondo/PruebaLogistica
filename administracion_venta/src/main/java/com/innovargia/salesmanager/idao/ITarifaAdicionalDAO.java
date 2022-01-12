package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.TarifaAdicionalDTO;

public interface ITarifaAdicionalDAO {

	public abstract void insert(TarifaAdicionalDTO catalogo) throws Exception;

	public abstract void update(TarifaAdicionalDTO catalogo) throws Exception;

	public abstract void updateEstatus(TarifaAdicionalDTO catalogo) throws Exception;

	public abstract void delete(TarifaAdicionalDTO catalogo) throws Exception;
	/***
	 * Ob tiene la lista de todos los adicionales agregados a una tarifa, solo obtiene los 
	 * registros de una tarifa indicada y que se encuentre en catarifas y catarifaadicionales
	 * @param catalogo
	 * @return
	 * @throws Exception
	 */
	public List<TarifaAdicionalDTO> getRegistros(TarifaAdicionalDTO catalogo)
			throws Exception ;
	

	public abstract TarifaAdicionalDTO get(TarifaAdicionalDTO catalogo) throws Exception;

}