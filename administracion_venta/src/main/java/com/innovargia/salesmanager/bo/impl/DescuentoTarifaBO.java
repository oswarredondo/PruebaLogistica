/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.DescuentoDTO;
import com.innovargia.salesmanager.ibo.IDescuentoTarifaBO;
import com.innovargia.salesmanager.idao.IDescuentoTarifaDAO;

/**
 * @author aruaro
 * 
 */
@Service
public class DescuentoTarifaBO  implements IDescuentoTarifaBO {

	private static final Logger logger = LoggerFactory
			.getLogger(DescuentoTarifaBO.class);

	@Autowired 
	IDescuentoTarifaDAO iDescuentoTarifaDAO;
	
	public DescuentoTarifaBO(){
		
	}

	@Override
	public void insert(DescuentoDTO obj) throws Exception {
		iDescuentoTarifaDAO.insert(obj);
		
	}

	@Override
	public void update(DescuentoDTO obj) throws Exception {
		iDescuentoTarifaDAO.update(obj);
		
	}

	@Override
	public void delete(DescuentoDTO obj) throws Exception {
		iDescuentoTarifaDAO.delete(obj);
		
	}

	@Override
	public List<DescuentoDTO> getRegistros(BusquedaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iDescuentoTarifaDAO.getRegistros(obj);
	}

	@Override
	public DescuentoDTO get(DescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iDescuentoTarifaDAO.get(obj);
	}

	@Override
	public void updateEstatus(DescuentoDTO obj) throws Exception {
		iDescuentoTarifaDAO.updateEstatus(obj);
		
	}
	
	

}
