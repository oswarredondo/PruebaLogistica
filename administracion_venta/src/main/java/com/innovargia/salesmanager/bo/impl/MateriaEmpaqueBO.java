package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.ibo.IMaterialEmpaqueBO;
import com.innovargia.salesmanager.idao.IMaterialEmpaqueDAO;

@Service
public class MateriaEmpaqueBO  implements IMaterialEmpaqueBO {

	private static final Logger logger = LoggerFactory
			.getLogger(MateriaEmpaqueBO.class);


	@Autowired
	IMaterialEmpaqueDAO iMaterialEmpaqueDAO;
	public MateriaEmpaqueBO(){
		
	}


	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
	    iMaterialEmpaqueDAO.insert(catalogo);
		
	}


	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
	    iMaterialEmpaqueDAO.update(catalogo);
		
	}


	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
	    iMaterialEmpaqueDAO.delete(catalogo);
		
	}


	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return iMaterialEmpaqueDAO.getRegistros(catalogo);
	}


	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return iMaterialEmpaqueDAO.get(catalogo);
	}




}
