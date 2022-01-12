/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.OrdenServicioFoliosDTO;
import com.innovargia.salesmanager.ibo.IOrdenServicioFoliosBO;
import com.innovargia.salesmanager.idao.IOrdenServicioFoliosDAO;

/**
 * @author aruaro
 * 
 */
@Service
public class OrdenServicioFoliosBO implements IOrdenServicioFoliosBO {

	private static final Logger logger = LoggerFactory
			.getLogger(OrdenServicioFoliosBO.class);


	@Autowired
	IOrdenServicioFoliosDAO ordenServicioDAO;
	
	public OrdenServicioFoliosBO(){}

	@Override
	public void insert(OrdenServicioFoliosDTO obj) throws Exception {
		// TODO Auto-generated method stub
		ordenServicioDAO.insert(obj);
	}

	@Override
	public void update(OrdenServicioFoliosDTO obj) throws Exception {
		// TODO Auto-generated method stub
		ordenServicioDAO.update(obj);
	}

	@Override
	public void delete(OrdenServicioFoliosDTO obj) throws Exception {
		// TODO Auto-generated method stub
		ordenServicioDAO.delete(obj);
	}

	@Override
	public List<OrdenServicioFoliosDTO> getRegistros(OrdenServicioFoliosDTO obj)
			throws Exception {
		// TODO Auto-generated method stub
		return ordenServicioDAO.getRegistros(obj);
	}

	@Override
	public void updateEstatus(OrdenServicioFoliosDTO obj) throws Exception {
		// TODO Auto-generated method stub
		ordenServicioDAO.updateEstatus(obj);
	}

	@Override
	public CatalogoDTO get(OrdenServicioFoliosDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return ordenServicioDAO.get(obj);
	}
	
	

}
