package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.ITipoConvenioBO;
import com.innovargia.salesmanager.idao.ITipoConvenioDAO;

@Service
public class TipoConvenioBO implements ITipoConvenioBO{
	
	private static final Logger logger = LoggerFactory
			.getLogger(AdicionalesBO.class);


	@Autowired
	ITipoConvenioDAO tipoConvenioDAO;
	public TipoConvenioBO(){}

	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
		tipoConvenioDAO.insert(catalogo);

	}

	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
		tipoConvenioDAO.update(catalogo);

	}

	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
		tipoConvenioDAO.updateEstatus(catalogo);

	}

	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		tipoConvenioDAO.delete(catalogo);

	}

	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return tipoConvenioDAO.getRegistros(catalogo);
	}

	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return tipoConvenioDAO.get(catalogo);
	}

}
