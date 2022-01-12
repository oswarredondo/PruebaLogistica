/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.IGrupoClienteBO;
import com.innovargia.salesmanager.idao.IGrupoClienteDAO;

/**
 * @author aruaro
 *
 */
@Service
public class GrupoClienteBO   implements IGrupoClienteBO{
	private static final Logger logger = LoggerFactory
			.getLogger(AdicionalesBO.class);
	

	@Autowired
	IGrupoClienteDAO grupoClienteDAO;
	/**
	 * 
	 */
	public GrupoClienteBO(){
		
	}

	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
		grupoClienteDAO.insert(catalogo);
		
	}

	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
		grupoClienteDAO.update(catalogo);
		
	}

	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
		grupoClienteDAO.updateEstatus(catalogo);
		
	}

	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		grupoClienteDAO.delete(catalogo);
		
	}

	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return grupoClienteDAO.getRegistros(catalogo);
	}

	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return grupoClienteDAO.get(catalogo);
	}

}
