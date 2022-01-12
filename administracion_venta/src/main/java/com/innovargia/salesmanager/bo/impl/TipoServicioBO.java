package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.ServicioDTO;
import com.innovargia.salesmanager.ibo.ITipoServicioBO;
import com.innovargia.salesmanager.idao.ITipoServicioDAO;

/***
 * Adrministra los servicios que podràn ser vistos cuandp 
 * se ata un un servicio con una entidad, para poder identificar 
 * a que entidad y organizacion se pueden dar de alta determinados 
 * servicios
 * @author Adrián
 *
 */
@Service
public class TipoServicioBO  implements ITipoServicioBO {

	private static final Logger logger = LoggerFactory
			.getLogger(TipoServicioBO.class);


	@Autowired
	ITipoServicioDAO iServicioDAO;
	public TipoServicioBO(){
		
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
	public ServicioDTO get(ServicioDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return iServicioDAO.get(catalogo);
	}


}
