package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.NivelUsuarioDTO;
import com.innovargia.salesmanager.ibo.INivelUsuarioBO;
import com.innovargia.salesmanager.idao.INivelUsuarioDAO;

@Service
public class NivelUsuarioBO  implements INivelUsuarioBO {

	private static final Logger logger = LoggerFactory
			.getLogger(NivelUsuarioBO.class);


	@Autowired
	INivelUsuarioDAO iNivelUsuarioDAO;
	public NivelUsuarioBO(){
		
	}


	@Override
	public void insert(NivelUsuarioDTO catalogo) throws Exception {
		iNivelUsuarioDAO.insert(catalogo);
		
	}


	@Override
	public void update(NivelUsuarioDTO catalogo) throws Exception {
		iNivelUsuarioDAO.update(catalogo);
		
	}


	@Override
	public void updateEstatus(NivelUsuarioDTO catalogo) throws Exception {
		iNivelUsuarioDAO.updateEstatus(catalogo);
		
	}


	@Override
	public void delete(NivelUsuarioDTO catalogo) throws Exception {
		iNivelUsuarioDAO.delete(catalogo);
		
	}


	@Override
	public List<NivelUsuarioDTO> getRegistros(NivelUsuarioDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return iNivelUsuarioDAO.getRegistros(catalogo);
	}


	@Override
	public NivelUsuarioDTO get(int nivel) throws Exception {
		// TODO Auto-generated method stub
		return iNivelUsuarioDAO.get(nivel);
	}


	@Override
	public INivelUsuarioBO getInstance(int tabla) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deletePuestoAgrupamiento(NivelUsuarioDTO catalogo)
			throws Exception {
		iNivelUsuarioDAO.deletePuestoAgrupamiento(catalogo);
		
	}


	@Override
	public void insertPuestoAgrupamiento(NivelUsuarioDTO catalogo)
			throws Exception {
		iNivelUsuarioDAO.insertPuestoAgrupamiento(catalogo);
	}


	@Override
	public List<NivelUsuarioDTO> getRegistrosNivelAgrupamiento(
			NivelUsuarioDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return iNivelUsuarioDAO.getRegistrosNivelAgrupamiento(catalogo);
	}


}
