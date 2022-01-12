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
import com.innovargia.salesmanager.ibo.IDescuentoClienteBO;
import com.innovargia.salesmanager.idao.IDescuentoClienteDAO;

/**
 * @author aruaro
 * 
 */
@Service
public class DescuentoClienteBO implements IDescuentoClienteBO{

	private static final Logger logger = LoggerFactory
			.getLogger(DescuentoClienteBO.class);


	@Autowired
	IDescuentoClienteDAO iDescuentoClienteDAO;
	
	public DescuentoClienteBO(){
		
	}

	@Override
	public void insert(DescuentoDTO obj) throws Exception {
		iDescuentoClienteDAO.insert(obj);
		
	}

	@Override
	public void update(DescuentoDTO obj) throws Exception {
		iDescuentoClienteDAO.update(obj);
		
	}

	@Override
	public void delete(DescuentoDTO obj) throws Exception {
		iDescuentoClienteDAO.delete(obj);
		
	}

	@Override
	public List<DescuentoDTO> getRegistros(BusquedaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iDescuentoClienteDAO.getRegistros(obj);
	}

	@Override
	public DescuentoDTO get(DescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iDescuentoClienteDAO.get(obj);
	}

	@Override
	public void updateEstatus(DescuentoDTO obj) throws Exception {
		iDescuentoClienteDAO.updateEstatus(obj);
		
	}
	
	

}
