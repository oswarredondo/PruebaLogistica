/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.DireccionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IDireccionBO;
import com.innovargia.salesmanager.idao.IDireccionDAO;

/**
 * @author aruaro
 * 
 */
@Service
public class DireccionBO implements IDireccionBO{

	private static final Logger logger = LoggerFactory
			.getLogger(DireccionBO.class);


	@Autowired
	IDireccionDAO idireccionDao;
	
	public DireccionBO(){
		
	}

	@Override
	public void insert(DireccionDTO obj) throws Exception {
		idireccionDao.insert(obj);
		
	}

	@Override
	public void update(DireccionDTO obj) throws Exception {
		idireccionDao.update(obj);
		
	}

	@Override
	public void delete(DireccionDTO obj) throws Exception {
		idireccionDao.delete(obj);
		
	}

	@Override
	public List<DireccionDTO> getRegistros(DireccionDTO obj, UsuarioDTO usuario) throws Exception {
		// TODO Auto-generated method stub
		
		return idireccionDao.getRegistros(obj, usuario);
	}

	@Override
	public DireccionDTO get(DireccionDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return idireccionDao.get(obj);
	}

	@Override
	public void updateEstatus(DireccionDTO obj) throws Exception {
		// TODO Auto-generated method stub
		idireccionDao.updateEstatus(obj);
	}

	@Override
	public List<DireccionDTO> getVerificaExistencia(DireccionDTO obj,
			UsuarioDTO usuario,String operacion) throws Exception {
		// TODO Auto-generated method stub
		return idireccionDao.getVerificaExistencia(obj, usuario,operacion);
	}
	
	@Override
	public List<DireccionDTO> getRegistrosClienteFact(DireccionDTO obj, UsuarioDTO usuario) throws Exception{
	    return idireccionDao.getRegistrosClienteFact(obj, usuario);
	}
}
