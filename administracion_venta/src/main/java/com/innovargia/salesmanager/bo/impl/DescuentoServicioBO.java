/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.DescuentoDTO;
import com.innovargia.salesmanager.ibo.IDescuentoServicioBO;
import com.innovargia.salesmanager.idao.IDescuentoZonaDAO;

/**
 * @author aruaro
 * 
 */
@Service
public class DescuentoServicioBO implements IDescuentoServicioBO {

	private static final Logger logger = LoggerFactory
			.getLogger(DescuentoServicioBO.class);


	@Autowired
	IDescuentoZonaDAO iDescuentoServicioDAO;
	
	public DescuentoServicioBO(){
		
	}

	@Override
	public void insert(DescuentoDTO obj) throws Exception {
		iDescuentoServicioDAO.insert(obj);
		
	}

	@Override
	public void update(DescuentoDTO obj) throws Exception {
		iDescuentoServicioDAO.update(obj);
		
	}

	@Override
	public void delete(DescuentoDTO obj) throws Exception {
		iDescuentoServicioDAO.delete(obj);
		
	}

	@Override
	public List<DescuentoDTO> getRegistros(BusquedaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iDescuentoServicioDAO.getRegistros(obj);
	}

	@Override
	public DescuentoDTO get(DescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iDescuentoServicioDAO.get(obj);
	}

	@Override
	public void updateEstatus(DescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		iDescuentoServicioDAO.updateEstatus(obj);
	}
	
	

}
