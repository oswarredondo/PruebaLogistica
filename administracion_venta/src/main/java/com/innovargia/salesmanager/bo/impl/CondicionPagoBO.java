package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.ICondicionesPagoBO;
import com.innovargia.salesmanager.idao.ICondicionesPagoDAO;

@Service
public class CondicionPagoBO   implements ICondicionesPagoBO {
	private static final Logger logger = LoggerFactory
			.getLogger(AdicionalesBO.class);


	@Autowired
	ICondicionesPagoDAO condicionesPagoDAO;
	
	public CondicionPagoBO(){
		
	}
	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
		condicionesPagoDAO.insert(catalogo);

	}

	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
		condicionesPagoDAO.update(catalogo);

	}

	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
		condicionesPagoDAO.updateEstatus(catalogo);

	}

	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		condicionesPagoDAO.delete(catalogo);

	}

	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return condicionesPagoDAO.getRegistros(catalogo);
	}

	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return condicionesPagoDAO.get(catalogo);
	}

}
