package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.PlazaDTO;
import com.innovargia.salesmanager.ibo.IPlazaBO;
import com.innovargia.salesmanager.idao.IPlazaDAO;

@Service
public class PlazaBO  implements IPlazaBO {

	private static final Logger logger = LoggerFactory
			.getLogger(PlazaBO.class);


	@Autowired
	IPlazaDAO iPlazaDAO;
	public PlazaBO(){
		
	}


	@Override
	public void insert(PlazaDTO catalogo) throws Exception {
		iPlazaDAO.insert(catalogo);
		
	}


	@Override
	public void update(PlazaDTO catalogo) throws Exception {
		iPlazaDAO.update(catalogo);
		
	}


	@Override
	public void updateEstatus(PlazaDTO catalogo) throws Exception {
		iPlazaDAO.updateEstatus(catalogo);
		
	}


	@Override
	public void delete(PlazaDTO catalogo) throws Exception {
		iPlazaDAO.delete(catalogo);
		
	}


	@Override
	public List<PlazaDTO> getRegistros(PlazaDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return iPlazaDAO.getRegistros(catalogo);
	}


	@Override
	public PlazaDTO get(PlazaDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return iPlazaDAO.get(catalogo);
	}


	@Override
	public CruceCoberturaDTO getCobertura(CruceCoberturaDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return iPlazaDAO.getCobertura(catalogo);
	}




}
