package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.DireccionDTO;
import com.innovargia.salesmanager.ibo.ICodigosPostalesBO;
import com.innovargia.salesmanager.idao.ICodigosPostalesDAO;

@Service
public class CodigosPostalesBO  implements ICodigosPostalesBO {

	private static final Logger logger = LoggerFactory
			.getLogger(CodigosPostalesBO.class);


	@Autowired
	ICodigosPostalesDAO iCodigosPostalesDAO;
	public CodigosPostalesBO(){
		
	}


	@Override
	public void insert(DireccionDTO catalogo) throws Exception {
		
		
	}


	@Override
	public void update(DireccionDTO catalogo) throws Exception {
	
		
	}


	@Override
	public void updateEstatus(DireccionDTO catalogo) throws Exception {
		
		
	}


	@Override
	public void delete(DireccionDTO catalogo) throws Exception {
	
		
	}


	@Override
	public List<DireccionDTO> getRegistros(BusquedaDTO obj)
			throws Exception {
		// TODO Auto-generated method stub
		return iCodigosPostalesDAO.getRegistros(obj);
	}


	@Override
	public DireccionDTO get(DireccionDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
