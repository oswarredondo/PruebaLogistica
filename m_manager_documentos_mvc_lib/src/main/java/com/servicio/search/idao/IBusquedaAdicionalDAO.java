package com.servicio.search.idao;

import java.util.List;

import com.administracion.dto.AdicionalDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;

public interface IBusquedaAdicionalDAO {

	public abstract void insert(AdicionalDTO adicional) throws Exception;

	public abstract void delete(AdicionalDTO adicional) throws Exception;

	public abstract List<AdicionalDTO> getRegistrosDisponiblesConvenio(int idconvenio, String uuid, int iddregistrodatos ) throws Exception;;

	public List<AdicionalDTO> getRegistrosDisponiblesFolios(String uuid, int idregistrodatos)
			throws Exception ;

	public abstract List<AdicionalDTO> getRegistrosSeleccionados(String uuid, int iddregistrodatos)
			throws Exception;

	public abstract List<AdicionalDTO> getRegistrosSeleccionadosConvenio(
			int idconvenio) throws Exception;
	
	public AdicionalDTO getRegistroIdAdicionalConvenio(int idadicionaldetalle)
			throws Exception;

	public List<AdicionalDTO> getRegistrosAdicionalesNorequeridos( int tipo)
		throws Exception ;
	
	
	public List<AdicionalDTO> getRegistroAdicional( int identificador)	throws Exception; 
	public List<AdicionalDTO> getRegistroAdicional( String idadicional)	throws Exception;
	
	public List<AdicionalDTO>  getAdicinalesConvenio(int idconvenio) throws Exception;
	
	public void update(AdicionalDTO adicionalDTO) throws Exception;
	
	public void updatePorGuia(AdicionalDTO adicionalDTO) throws Exception;

	public  List<AdicionalDTO> getRegistrosSeleccionadosPorGuia(String iddocumento);
		
}