package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.IAdicionalesBO;
import com.innovargia.salesmanager.idao.IAdicionalesDAO;

@Service
public class AdicionalesBO  implements IAdicionalesBO {

	private static final Logger logger = LoggerFactory
			.getLogger(AdicionalesBO.class);


	@Autowired
	IAdicionalesDAO adicionalDAO;
	public AdicionalesBO(){
		
	}


	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
		adicionalDAO.insert(catalogo);
		
	}


	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
		adicionalDAO.update(catalogo);
		
	}


	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
		adicionalDAO.updateEstatus(catalogo);
		
	}


	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		adicionalDAO.delete(catalogo);
		
	}


	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return adicionalDAO.getRegistros(catalogo);
	}


	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return adicionalDAO.get(catalogo);
	}


	@Override
	public List<CatalogoDTO> getRegistrosXTipo(CatalogoDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return  adicionalDAO.getRegistrosXTipo(catalogo);
	}


}
