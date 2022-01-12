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
import com.innovargia.salesmanager.ibo.IFormaPagoBO;
import com.innovargia.salesmanager.idao.IFormaPagoDAO;

/**
 * @author aruaro
 *
 */
@Service
public class FormaPagoBO  implements IFormaPagoBO {
	private static final Logger logger = LoggerFactory
			.getLogger(AdicionalesBO.class);
	
	@Autowired
	IFormaPagoDAO formaPagoDAO;

	/**
	 * 
	 */
	public FormaPagoBO(){
		
	}
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.ICatalogos#insert(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
		formaPagoDAO.insert(catalogo);

	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.ICatalogos#update(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
		formaPagoDAO.update(catalogo);

	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.ICatalogos#updateEstatus(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
		formaPagoDAO.updateEstatus(catalogo);

	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.ICatalogos#delete(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		formaPagoDAO.delete(catalogo);

	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.ICatalogos#getRegistros(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return formaPagoDAO.getRegistros(catalogo);
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.ICatalogos#get(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return formaPagoDAO.get(catalogo);
	}

}
