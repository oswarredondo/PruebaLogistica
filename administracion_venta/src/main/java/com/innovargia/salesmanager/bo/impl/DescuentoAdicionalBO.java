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
import com.innovargia.salesmanager.ibo.IDescuentoAdicionalBO;
import com.innovargia.salesmanager.idao.IDescuentoAdicionalDAO;

/**
 * @author aruaro
 * 
 */
@Service
public class DescuentoAdicionalBO implements IDescuentoAdicionalBO {

	private static final Logger logger = LoggerFactory
			.getLogger(DescuentoAdicionalBO.class);


	@Autowired
	IDescuentoAdicionalDAO iIDescuentoAdicionalDAO;
	

	public DescuentoAdicionalBO(){
		
	}

	@Override
	public void insert(ModalidadDescuentoDTO obj) throws Exception {
		iIDescuentoAdicionalDAO.insert(obj);
		
	}

	@Override
	public void update(ModalidadDescuentoDTO obj) throws Exception {
		iIDescuentoAdicionalDAO.update(obj);
		
	}

	@Override
	public void delete(ModalidadDescuentoDTO obj) throws Exception {
		iIDescuentoAdicionalDAO.delete(obj);
		
	}

	@Override
	public List<ModalidadDescuentoDTO> getRegistros(ModalidadDescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iIDescuentoAdicionalDAO.getRegistros(obj);
	}

	@Override
	public ModalidadDescuentoDTO get(ModalidadDescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iIDescuentoAdicionalDAO.get(obj);
	}

	@Override
	public void updateEstatus(ModalidadDescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		iIDescuentoAdicionalDAO.updateEstatus(obj);
	}
	
	

}
