package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.IRegimenBO;
import com.innovargia.salesmanager.idao.IRegimenDAO;

@Service
public class RegimenBO  implements IRegimenBO {

	private static final Logger logger = LoggerFactory
			.getLogger(RegimenBO.class);


	@Autowired
	IRegimenDAO iRegimenDAO;
	public RegimenBO(){
		
	}


	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
		iRegimenDAO.insert(catalogo);
		
	}


	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
		iRegimenDAO.update(catalogo);
		
	}


	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
		iRegimenDAO.updateEstatus(catalogo);
		
	}


	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		iRegimenDAO.delete(catalogo);
		
	}


	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return iRegimenDAO.getRegistros(catalogo);
	}


	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return iRegimenDAO.get(catalogo);
	}



}
