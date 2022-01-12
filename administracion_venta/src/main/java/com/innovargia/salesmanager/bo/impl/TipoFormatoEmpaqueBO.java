package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.ITipoFormatoEmpaqueBO;
import com.innovargia.salesmanager.idao.ITipoEmpaqueFormatoDAO;

@Service
public class TipoFormatoEmpaqueBO  implements ITipoFormatoEmpaqueBO {

	private static final Logger logger = LoggerFactory
			.getLogger(TipoFormatoEmpaqueBO.class);


	@Autowired
	ITipoEmpaqueFormatoDAO iTipoEmpaqueFormatoDAO;
	public TipoFormatoEmpaqueBO(){
		
	}
	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
	    // TODO Auto-generated method stub
	    
	}
	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
	    // TODO Auto-generated method stub
	    
	}
	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
	    // TODO Auto-generated method stub
	    
	}
	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
	    // TODO Auto-generated method stub
	    
	}
	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo)
		throws Exception {
	    // TODO Auto-generated method stub
	    return iTipoEmpaqueFormatoDAO.getRegistros(catalogo);
	}
	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
	    // TODO Auto-generated method stub
	    return null;
	}



}
