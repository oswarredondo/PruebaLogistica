package com.administracion.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;

public interface IReglaTarifaPesoDAO {

	List<TarifaDTO> getRegistrosPesoDisponibles(TarifaDTO tarifa, ConvenioContratoDetalleDTO obj) throws Exception;

	List<TarifaDTO> getRegistrosVolumenDisponibles(TarifaDTO tarifa, ConvenioContratoDetalleDTO obj) throws Exception;

	float getSobrePeso(TarifaDTO tarifa) throws Exception;
	public List<TarifaDTO> getListaPrecioPosibles(TarifaDTO tarifa)
			throws Exception;
	
	public List<TarifaDTO> getRegistrosRangosDisponibles(TarifaDTO tarifa) throws Exception;
	
	public List<TarifaDTO> getRangosDisponiblesId(TarifaDTO tarifa) throws Exception;

}