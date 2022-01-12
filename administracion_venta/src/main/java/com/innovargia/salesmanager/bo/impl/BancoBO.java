package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.IAdicionalesBO;
import com.innovargia.salesmanager.ibo.IBancoBO;
import com.innovargia.salesmanager.idao.IAdicionalesDAO;
import com.innovargia.salesmanager.idao.IBancoDAO;

@Service
public class BancoBO  implements IBancoBO {

	private static final Logger logger = LoggerFactory
			.getLogger(BancoBO.class);


	@Autowired
	IBancoDAO IBancoDAO;
	public BancoBO(){
		
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
	public List<CatalogoDTO> getRegistros() throws Exception {
	    // TODO Auto-generated method stub
	    return IBancoDAO.getRegistros();
	}
	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
	    // TODO Auto-generated method stub
	    return null;
	}


	

}
