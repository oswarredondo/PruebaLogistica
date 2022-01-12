/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.ContactoDTO;
import com.innovargia.salesmanager.ibo.IContactoBO;
import com.innovargia.salesmanager.idao.IContactoDAO;

/**
 * @author aruaro
 * 
 */
@Service
public class ContactoBO implements IContactoBO{

	private static final Logger logger = LoggerFactory
			.getLogger(ContactoBO.class);


	@Autowired
	IContactoDAO contactosDAO;
	
	public ContactoBO(){
		
	}

	@Override
	public void insert(ContactoDTO obj) throws Exception {
		contactosDAO.insert(obj);
		
	}

	@Override
	public void update(ContactoDTO obj) throws Exception {
		contactosDAO.update(obj);
		
	}

	@Override
	public void delete(ContactoDTO obj) throws Exception {
		contactosDAO.delete(obj);
		
	}

	@Override
	public List<ContactoDTO> getRegistros(ContactoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return contactosDAO.getRegistros(obj);
	}

	@Override
	public void updateEstatus(ContactoDTO obj) throws Exception {
		contactosDAO.updateEstatus(obj);
		
	}

	@Override
	public ContactoDTO get(ContactoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return contactosDAO.get(obj);
	}
	
	
	

}
