package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.innovargia.salesmanager.dtos.TarifaAdicionalDTO;
import com.innovargia.salesmanager.ibo.ITarifaAdicionalBO;
import com.innovargia.salesmanager.idao.ITarifaAdicionalDAO;

@Repository
public class TarifaAdicionalBO   implements ITarifaAdicionalBO{
	
	private static final Logger logger = LoggerFactory
			.getLogger(AdicionalesBO.class);

	@Autowired
	ITarifaAdicionalDAO tarifaAdicionalDAO;

	public TarifaAdicionalBO(){
		
	}

	@Override
	public void insert(TarifaAdicionalDTO catalogo) throws Exception {
		tarifaAdicionalDAO.insert(catalogo);

	}

	@Override
	public void update(TarifaAdicionalDTO catalogo) throws Exception {
		tarifaAdicionalDAO.update(catalogo);

	}

	@Override
	public void updateEstatus(TarifaAdicionalDTO catalogo) throws Exception {
		tarifaAdicionalDAO.updateEstatus(catalogo);

	}

	@Override
	public void delete(TarifaAdicionalDTO catalogo) throws Exception {
		tarifaAdicionalDAO.delete(catalogo);

	}



	@Override
	public TarifaAdicionalDTO get(TarifaAdicionalDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return tarifaAdicionalDAO.get(catalogo);
	}

	@Override
	public List<TarifaAdicionalDTO> getRegistros(TarifaAdicionalDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return tarifaAdicionalDAO.getRegistros(catalogo);	
	}

}
