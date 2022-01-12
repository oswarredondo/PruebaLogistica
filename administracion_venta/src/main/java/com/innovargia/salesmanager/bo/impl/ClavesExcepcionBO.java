package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.IAdicionalesBO;
import com.innovargia.salesmanager.ibo.IClavesExcepcionBO;
import com.innovargia.salesmanager.idao.IAdicionalesDAO;
import com.innovargia.salesmanager.idao.IClavesExcepcionDAO;

@Service
public class ClavesExcepcionBO  implements IClavesExcepcionBO {

	private static final Logger logger = LoggerFactory
			.getLogger(ClavesExcepcionBO.class);


	@Autowired
	IClavesExcepcionDAO iClavesExcepcionDAO;
	public ClavesExcepcionBO(){
		
	}


	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
		iClavesExcepcionDAO.insert(catalogo);
		
	}


	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
		iClavesExcepcionDAO.update(catalogo);
		
	}


	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
		iClavesExcepcionDAO.updateEstatus(catalogo);
		
	}


	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		iClavesExcepcionDAO.delete(catalogo);
		
	}


	@Override
	public List<CatalogoDTO> getRegistros(BusquedaDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return iClavesExcepcionDAO.getRegistros(catalogo);
	}


	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return iClavesExcepcionDAO.get(catalogo);
	}





}
