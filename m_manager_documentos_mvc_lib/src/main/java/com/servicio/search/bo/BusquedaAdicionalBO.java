/**
 * 
 */
package com.servicio.search.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.dto.AdicionalDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.servicio.search.ibo.IBusquedaAdicionalBO;
import com.servicio.search.idao.IBusquedaAdicionalDAO;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Service
public class BusquedaAdicionalBO implements IBusquedaAdicionalBO {
	@Autowired
	IBusquedaAdicionalDAO iAdicionalDAO;
	
	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaAdicionalBO.class);
	

	public BusquedaAdicionalBO() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void insert(AdicionalDTO adicional) throws Exception {
		// TODO Auto-generated method stub
		iAdicionalDAO.insert(adicional);
	}


	@Override
	public void delete(AdicionalDTO adicional) throws Exception {
		// TODO Auto-generated method stub
		iAdicionalDAO.delete(adicional);
	}


	@Override
	public List<AdicionalDTO> getRegistrosDisponiblesConvenio(int idconvenio, 
			String uuid, int iddregistrodatos)
			throws Exception {
		// TODO Auto-generated method stub
		return iAdicionalDAO.getRegistrosDisponiblesConvenio(idconvenio, uuid, iddregistrodatos);
	}


	@Override
	public List<AdicionalDTO> getRegistrosDisponiblesFolios(String uuid, int idregistrodatos)
			throws Exception {
		// TODO Auto-generated method stub
		return iAdicionalDAO.getRegistrosDisponiblesFolios(uuid, idregistrodatos);
	}


	@Override
	public List<AdicionalDTO> getRegistrosSeleccionados(String uuid, int iddregistrodatos)
			throws Exception {
		// TODO Auto-generated method stub
		return iAdicionalDAO.getRegistrosSeleccionados(uuid , iddregistrodatos);
	}


	@Override
	public List<AdicionalDTO> getRegistrosSeleccionadosConvenio(int idconvenio)
			throws Exception {
		// TODO Auto-generated method stub
		return iAdicionalDAO.getRegistrosSeleccionadosConvenio(idconvenio);
	}


	@Override
	public AdicionalDTO getRegistroIdAdicionalConvenio(int idadicionaldetalle)
			throws Exception {
		// TODO Auto-generated method stub
		return iAdicionalDAO.getRegistroIdAdicionalConvenio(idadicionaldetalle);
	}


	@Override
	public List<AdicionalDTO> getRegistrosAdicionalesNorequeridos(int tipo)
		throws Exception {
	    // TODO Auto-generated method stub
	    return iAdicionalDAO.getRegistrosAdicionalesNorequeridos(tipo);
	}


	@Override
	public List<AdicionalDTO> getRegistroAdicional(int identificador) throws Exception {
		 return iAdicionalDAO.getRegistroAdicional(identificador);
	}


	@Override
	public List<AdicionalDTO> getRegistroAdicional(String idadicional) throws Exception {
		 return iAdicionalDAO.getRegistroAdicional(idadicional);
	}


	@Override
	public List<AdicionalDTO> getAdicinalesConvenio(int idconvenio) throws Exception {
		// TODO Auto-generated method stub
		return iAdicionalDAO.getAdicinalesConvenio(idconvenio);
	}
	
	@Override
	public void update(AdicionalDTO adicionalDTO) throws Exception{
		
	   iAdicionalDAO.update(adicionalDTO);
	};
	
	@Override
	public void updatePorGuia(AdicionalDTO adicionalDTO) throws Exception{
		
	   iAdicionalDAO.updatePorGuia(adicionalDTO);
	};

	@Override
	public List<AdicionalDTO> getRegistrosSeleccionadosPorGuia(String iddocumento) {
		// TODO Auto-generated method stub
		return iAdicionalDAO.getRegistrosSeleccionadosPorGuia(iddocumento);
	}
}
