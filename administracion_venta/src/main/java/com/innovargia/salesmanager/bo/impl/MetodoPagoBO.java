package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.IMetodoPagoBO;
import com.innovargia.salesmanager.idao.IMetodoPagoDAO;

@Service 
public class MetodoPagoBO  implements IMetodoPagoBO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AdicionalesBO.class);
	

	@Autowired
	IMetodoPagoDAO metodoPagoDAO;

	public MetodoPagoBO(){}

	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
		metodoPagoDAO.insert(catalogo);

	}

	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
		metodoPagoDAO.update(catalogo);

	}

	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
		metodoPagoDAO.updateEstatus(catalogo);

	}

	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		metodoPagoDAO.delete(catalogo);

	}

	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return metodoPagoDAO.getRegistros(catalogo);
	}

	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return metodoPagoDAO.get(catalogo);
	}

}
