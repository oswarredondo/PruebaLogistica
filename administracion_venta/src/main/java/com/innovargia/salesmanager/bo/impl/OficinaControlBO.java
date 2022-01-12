package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.IOficinaControlBO;
import com.innovargia.salesmanager.idao.IOficinaControlDAO;

@Service
public class OficinaControlBO   implements IOficinaControlBO {
	private static final Logger logger = LoggerFactory
			.getLogger(AdicionalesBO.class);
	@Autowired
	IOficinaControlDAO oficinaControlDAO;

	
	public OficinaControlBO(){}


	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
		oficinaControlDAO.insert(catalogo);
		
	}


	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
		oficinaControlDAO.update(catalogo);
		
	}


	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
		oficinaControlDAO.updateEstatus(catalogo);
		
	}


	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		oficinaControlDAO.delete(catalogo);
		
	}


	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return oficinaControlDAO.getRegistros(catalogo);
	}




}
