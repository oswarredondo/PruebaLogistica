/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.DescuentoDTO;
import com.innovargia.salesmanager.ibo.IDescuentoBO;
import com.innovargia.salesmanager.idao.IDescuentoClienteDAO;
import com.innovargia.salesmanager.idao.IDescuentoDAO;
import com.innovargia.salesmanager.idao.IDescuentoTarifaDAO;
import com.innovargia.salesmanager.idao.IDescuentoZonaDAO;

/**
 * @author aruaro
 * 
 */
@Service
public class DescuentoBO  implements IDescuentoBO {

	private static final Logger logger = LoggerFactory
			.getLogger(DescuentoBO.class);

	
	@Autowired
	IDescuentoDAO iDescuentoDAO;
	@Autowired
	IDescuentoTarifaDAO iDescuentoTarifaDAO;
	@Autowired
	IDescuentoClienteDAO iDescuentoClienteDAO;
	@Autowired
	IDescuentoZonaDAO iDescuentoZonaDAO;
	
	public DescuentoBO(){}

	@Override
	public void insert(DescuentoDTO obj) throws Exception {
		iDescuentoDAO.insert(obj);
		
	}

	@Override
	public void update(DescuentoDTO obj) throws Exception {
		iDescuentoDAO.update(obj);
		
	}

	@Override
	public void delete(DescuentoDTO obj) throws Exception {
		iDescuentoDAO.delete(obj);
		
	}

	@Override
	public List<DescuentoDTO> getRegistros(BusquedaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iDescuentoDAO.getRegistros(obj);
	}

	@Override
	public DescuentoDTO get(DescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iDescuentoDAO.get(obj);
	}

	@Override
	public void updateEstatus(DescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		iDescuentoDAO.updateEstatus(obj);
	}

	

	@Override
	public void deleteDetalle(DescuentoDTO obj) throws Exception {
		switch (obj.getTipo()) {
		case 1://Cliente
			iDescuentoClienteDAO.delete(obj);
			break;
		case 2://Tarifa
			iDescuentoTarifaDAO.delete(obj);
			break;			
		case 3://Zona
			iDescuentoZonaDAO.delete(obj);
			break;	

		default:
			break;
		}
	}

	
	@Override
	public void insertDetalle(DescuentoDTO obj) throws Exception {
		switch (obj.getTipo()) {
		case 1://Cliente
			iDescuentoClienteDAO.insert(obj); 
			break;
		case 2://Tarifa
			iDescuentoTarifaDAO.insert(obj);
			break;			
		case 3://Zona
			iDescuentoZonaDAO.insert(obj);
			break;	
		default:
			break;
		}
	}

	@Override
	public List<DescuentoDTO> getRegistrosDetalle(BusquedaDTO obj)
			throws Exception {
		switch (obj.getTipo()) {
		case 1://Cliente
			return iDescuentoClienteDAO.getRegistros(obj); 
		case 2://Tarifa
			return iDescuentoTarifaDAO.getRegistros(obj);
		case 3://Zona
			return iDescuentoZonaDAO.getRegistros(obj);
		default:
			return new ArrayList<DescuentoDTO>();
		}
	}
	
	@Override
	public List<DescuentoDTO> getRegistrosDisponibles(BusquedaDTO obj) throws Exception {
		switch (obj.getTipo()) {
		case 1://Cliente
			return iDescuentoClienteDAO.getRegistrosDisponibles(obj);
		case 2://Tarifa
			return iDescuentoTarifaDAO.getRegistrosDisponibles(obj);
		case 3://Zona
			return iDescuentoZonaDAO.getRegistrosDisponibles(obj);
		default:
			return new ArrayList<DescuentoDTO>();
		}
	}
}
