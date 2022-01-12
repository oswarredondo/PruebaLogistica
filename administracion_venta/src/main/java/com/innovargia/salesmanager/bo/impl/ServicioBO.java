package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.ServicioDTO;
import com.innovargia.salesmanager.ibo.IServicioBO;
import com.innovargia.salesmanager.idao.IServicioDAO;

/***
 * Contiene el catalogo de servicios generales
 * posibles a ver en TODO el sistema
 * @author Adrián
 *
 */
@Service
public class ServicioBO  implements IServicioBO {

	private static final Logger logger = LoggerFactory
			.getLogger(ServicioBO.class);


	@Autowired
	IServicioDAO iServicioDAO;
	public ServicioBO(){
		
	}


	@Override
	public void insert(ServicioDTO catalogo) throws Exception {
		iServicioDAO.insert(catalogo);
		
	}


	@Override
	public void update(ServicioDTO catalogo) throws Exception {
		iServicioDAO.update(catalogo);
		
	}


	@Override
	public void updateEstatus(ServicioDTO catalogo) throws Exception {
		iServicioDAO.updateEstatus(catalogo);
		
	}


	@Override
	public void delete(ServicioDTO catalogo) throws Exception {
		iServicioDAO.delete(catalogo);
		
	}


	@Override
	public List<ServicioDTO> getRegistros(ServicioDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return iServicioDAO.getRegistros(catalogo);
	}

	@Override
	public List<ServicioDTO> getRegistrosEntidadOrganizacio(ServicioDTO catalogo)
			throws Exception {
		// TODO Auto-generated method stub
		return iServicioDAO.getRegistrosEntidadOrganizacio(catalogo);
	}
	@Override
	public ServicioDTO get(ServicioDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return iServicioDAO.get(catalogo);
	}


	@Override
	public void updateTipoCobro(int identificador, int tipocobro)
		throws Exception {
	    iServicioDAO.updateTipoCobro(identificador, tipocobro);
	    
	}


}
