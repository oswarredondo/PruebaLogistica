package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.IPoblacionPagoBO;
import com.innovargia.salesmanager.idao.IPoblacionPagoDAO;

@Service
public class PoblacionPagoBO  implements IPoblacionPagoBO{
	
	private static final Logger logger = LoggerFactory
			.getLogger(AdicionalesBO.class);


	@Autowired
	IPoblacionPagoDAO poblacionPagoDAO;
	public PoblacionPagoBO(){}
	
	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
		poblacionPagoDAO.insert(catalogo);

	}

	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
		poblacionPagoDAO.update(catalogo);

	}

	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
		poblacionPagoDAO.updateEstatus(catalogo);

	}

	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		poblacionPagoDAO.delete(catalogo);

	}

	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return poblacionPagoDAO.getRegistros(catalogo);
	}

	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return poblacionPagoDAO.get(catalogo);
	}

}
