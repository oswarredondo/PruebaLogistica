package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.dto.Folios;

@Service
public class AdminFoliosBO  implements com.innovargia.salesmanager.ibo.IAdminFoliosBO {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminFoliosBO.class);


	@Autowired
	com.innovargia.salesmanager.idao.IAdminFoliosDAO iFoliosDAO;
	public AdminFoliosBO(){
		
	}
	@Override
	public void insert(Folios obj) throws Exception {
		iFoliosDAO.insert(obj);
	}
	@Override
	public void increment(Folios obj) throws Exception {
		iFoliosDAO.increment(obj);
	}
	@Override
	public void delete(Folios obj) throws Exception {
		iFoliosDAO.delete(obj);
	}
	@Override
	public List<Folios> getRegistros(Folios folio) throws Exception {
		return iFoliosDAO.getRegistros(folio);
	}
	



}
