/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.ibo.IPDVBO;
import com.innovargia.salesmanager.idao.IPDVDAO;

@Service
public class PDVBO implements IPDVBO {

	private static final Logger logger = LoggerFactory
			.getLogger(PDVBO.class);

	@Autowired
	IPDVDAO iPDVDAO;
	
	public PDVBO(){}

	@Override
	public void insertaOficinaUsuario(String login, String idoficina)
		throws Exception {
	    iPDVDAO.insertaOficinaUsuario(login, idoficina);
	    
	}

	@Override
	public void deleteOficinaDeUsuario(String login) throws Exception {
	    iPDVDAO.deleteOficinaDeUsuario(login);
	    
	}

	@Override
	public void deleteUsuarioDeOficina(String login, String idoficina)
		throws Exception {
	    iPDVDAO.deleteUsuarioDeOficina(login, idoficina);
	    
	}
	
	
	
}
