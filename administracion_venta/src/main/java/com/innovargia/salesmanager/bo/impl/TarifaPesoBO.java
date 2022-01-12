package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.administracion.idao.IReglaTarifaPesoDAO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;
import com.innovargia.salesmanager.ibo.ITarifaPesoBO;
import com.innovargia.salesmanager.idao.ITarifaPesoDAO;

@Service
public class TarifaPesoBO implements ITarifaPesoBO {
	
	private static final Logger logger = LoggerFactory.getLogger(TarifaPesoBO.class);
	@Autowired
	private ITarifaPesoDAO tarifasDAO;
	
	@Autowired
	private IReglaTarifaPesoDAO iReglaTarifaPeso;

	public TarifaPesoBO() {
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITarifasDAO#getTarifas()
	 */
	@Override
	public List<TarifaDTO> getTarifas(TarifaDTO tarifa) throws Exception {
		return null;
	}



	@Override
	@Transactional 
	public int insert(TarifaDTO tarifa) throws Exception {
		Number consecutivo = tarifasDAO.insert(tarifa);
		tarifa.setIdtarifapeso(consecutivo.intValue());
		return consecutivo.intValue();
		
		
	}

	@Override
	public void update(TarifaDTO tarifa) throws Exception {
		tarifasDAO.update(tarifa);
		
	}

	@Override
	public void updateEstatus(TarifaDTO tarifa) throws Exception {
		tarifasDAO.updateEstatus(tarifa);
		
	}

	@Override
	@Transactional
	public void delete(TarifaDTO tarifa) throws Exception {
		tarifasDAO.delete(tarifa);
		
	}

	@Override
	public  List<TarifaDTO> getRegistros(BusquedaDTO tarifa) throws Exception {
		return tarifasDAO.getRegistros(tarifa);
		
	}
	
	@Override
	public TarifaDTO get(TarifaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return tarifasDAO.get(obj);
	}

	@Override
	public List<TarifaDTO> getRegistrosPesoDisponibles(TarifaDTO tarifa,ConvenioContratoDetalleDTO obj)
			throws Exception {
		return iReglaTarifaPeso.getRegistrosPesoDisponibles(tarifa,obj);
	}
	@Override
	public List<TarifaDTO> getRegistrosVolumenDisponibles(TarifaDTO tarifa,ConvenioContratoDetalleDTO obj)
		throws Exception {
	    return iReglaTarifaPeso.getRegistrosVolumenDisponibles(tarifa,obj);
	}

	@Override
	public float getSobrePeso(TarifaDTO tarifa) throws Exception {
		// TODO Auto-generated method stub
		return iReglaTarifaPeso.getSobrePeso(tarifa);
	}
}
