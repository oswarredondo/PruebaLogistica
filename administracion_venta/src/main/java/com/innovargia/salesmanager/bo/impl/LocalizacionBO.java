/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.LocalizacionDTO;
import com.innovargia.salesmanager.ibo.ILocalizacionBO;
import com.innovargia.salesmanager.idao.ILocalizacionDAO;

/**
 * @author aruaro
 * 
 */
@Service
public class LocalizacionBO  implements ILocalizacionBO {

	private static final Logger logger = LoggerFactory
			.getLogger(LocalizacionBO.class);


	@Autowired
	ILocalizacionDAO localizacionDAO;
	
	public LocalizacionBO(){
		
	}

	@Override
	public void insert(LocalizacionDTO obj) throws Exception {
		localizacionDAO.insert(obj);
		
	}

	@Override
	public void update(LocalizacionDTO obj) throws Exception {
		localizacionDAO.update(obj);
		
	}

	@Override
	public void delete(LocalizacionDTO obj) throws Exception {
		localizacionDAO.delete(obj);
		
	}

	@Override
	public List<LocalizacionDTO> getRegistros(LocalizacionDTO obj)
			throws Exception {
		// TODO Auto-generated method stub
		return localizacionDAO.getRegistros(obj);
	}

	@Override
	public LocalizacionDTO get(LocalizacionDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return localizacionDAO.get(obj);
	}

	@Override
	public void updateEstatus(LocalizacionDTO obj) throws Exception {
		localizacionDAO.updateEstatus(obj);
		
	}
	
	

}
