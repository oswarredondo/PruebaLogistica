/**
 * 
 */
package com.servicio.search.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;
import com.servicio.search.ibo.IBusquedaConvenioBO;
import com.servicio.search.idao.IConvenioContratoDAO;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Service
public class BusquedaConvenioBO implements IBusquedaConvenioBO {
	@Autowired
	IConvenioContratoDAO iConvenioContratoDAO;
	
	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaConvenioBO.class);
	

	public BusquedaConvenioBO() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public ConvenioContratoDTO get(ConvenioContratoDTO obj)
		throws Exception {
	    // TODO Auto-generated method stub
	    return iConvenioContratoDAO.get(obj);
	}


	
	
}
