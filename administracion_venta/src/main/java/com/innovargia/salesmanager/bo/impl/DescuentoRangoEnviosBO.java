/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.ModalidadDescuentoDTO;
import com.innovargia.salesmanager.ibo.IDescuentoRangoEnviosBO;
import com.innovargia.salesmanager.idao.IDescuentoRangoEnviosDAO;

/**
 * @author aruaro
 * 
 */
@Service
public class DescuentoRangoEnviosBO  implements IDescuentoRangoEnviosBO {

	private static final Logger logger = LoggerFactory
			.getLogger(DescuentoRangoEnviosBO.class);


	@Autowired
	IDescuentoRangoEnviosDAO iDescuentoRangoEnviosDAO;
	
	public DescuentoRangoEnviosBO(){}

	@Override
	public void insert(ModalidadDescuentoDTO obj) throws Exception {
		iDescuentoRangoEnviosDAO.insert(obj);
		
	}

	@Override
	public void update(ModalidadDescuentoDTO obj) throws Exception {
		iDescuentoRangoEnviosDAO.update(obj);
		
	}

	@Override
	public void delete(ModalidadDescuentoDTO obj) throws Exception {
		iDescuentoRangoEnviosDAO.delete(obj);
		
	}

	@Override
	public List<ModalidadDescuentoDTO> getRegistros(ModalidadDescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iDescuentoRangoEnviosDAO.getRegistros(obj);
	}

	@Override
	public ModalidadDescuentoDTO get(ModalidadDescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iDescuentoRangoEnviosDAO.get(obj);
	}

	@Override
	public void updateEstatus(ModalidadDescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		iDescuentoRangoEnviosDAO.updateEstatus(obj);
	}
	
	

}
