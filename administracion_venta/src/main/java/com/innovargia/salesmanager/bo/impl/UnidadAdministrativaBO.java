package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.IUnidadAdministrativaBO;
import com.innovargia.salesmanager.idao.IUnidadAdministrativaDAO;

@Service
public class UnidadAdministrativaBO   implements IUnidadAdministrativaBO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AdicionalesBO.class);

	@Autowired
	IUnidadAdministrativaDAO unidadAdminDAO;
	
	public UnidadAdministrativaBO(){}

	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
		unidadAdminDAO.insert(catalogo);

	}

	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
		unidadAdminDAO.update(catalogo);

	}

	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
		unidadAdminDAO.updateEstatus(catalogo);

	}

	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		unidadAdminDAO.delete(catalogo);

	}

	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo) throws Exception {
		return unidadAdminDAO.getRegistros(catalogo);

	}

	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return unidadAdminDAO.get(catalogo);
	}

}
