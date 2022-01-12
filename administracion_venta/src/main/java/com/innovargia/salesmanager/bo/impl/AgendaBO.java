package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.dto.AgendaOR;
import com.innovargia.salesmanager.ibo.IAgendaBO;
import com.innovargia.salesmanager.idao.IAgendaDAO;

@Service
public class AgendaBO  implements IAgendaBO {

	private static final Logger logger = LoggerFactory
			.getLogger(AgendaBO.class);

 
	@Autowired
	IAgendaDAO iAgendaDAO;
	public AgendaBO(){
		
	}
	@Override
	public int insert(AgendaOR catalogo) throws Exception {
	    // TODO Auto-generated method stub
	    Number consecutivo = iAgendaDAO.insert(catalogo);
	    return consecutivo.intValue();
	}
	@Override
	public void updateAsignadoAtiende(AgendaOR catalogo) throws Exception{
	    iAgendaDAO.updateAsignadoAtiende(catalogo);
	}
	@Override
	public void update(AgendaOR catalogo) throws Exception {
	    iAgendaDAO.update(catalogo);
	    
	}
	@Override
	public void updateEstatus(AgendaOR catalogo) throws Exception {
	    iAgendaDAO.updateEstatus(catalogo);
	    
	}
	@Override
	public void delete(AgendaOR catalogo) throws Exception {
	    iAgendaDAO.delete(catalogo);
	    
	}
	@Override
	public List<AgendaOR> getRegistros(AgendaOR catalogo) throws Exception {
	    // TODO Auto-generated method stub
	    return iAgendaDAO.getRegistros(catalogo);
	}
	@Override
	public AgendaOR get(AgendaOR catalogo) throws Exception {
	    // TODO Auto-generated method stub
	    return iAgendaDAO.get(catalogo);
	}
	@Override
	public void updateDatosCierre(AgendaOR catalogo) throws Exception {
	    iAgendaDAO.updateDatosCierre(catalogo);
	    
	}


	

}
