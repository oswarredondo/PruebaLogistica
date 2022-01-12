package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.ITerminoPagoBO;
import com.innovargia.salesmanager.idao.ITerminoPagoDAO;

@Service
public class TerminoPagoBO  implements ITerminoPagoBO {

	private static final Logger logger = LoggerFactory
			.getLogger(TerminoPagoBO.class);


	@Autowired
	ITerminoPagoDAO iTerminoPago;
	public TerminoPagoBO(){
		
	}


	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
		iTerminoPago.insert(catalogo);
		
	}


	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
		iTerminoPago.update(catalogo);
		
	}


	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
		iTerminoPago.updateEstatus(catalogo);
		
	}


	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		iTerminoPago.delete(catalogo);
		
	}


	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return iTerminoPago.getRegistros(catalogo);
	}


	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return iTerminoPago.get(catalogo);
	}



}
