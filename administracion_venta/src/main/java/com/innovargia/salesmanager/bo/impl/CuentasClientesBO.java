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
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.ibo.ICuentasClientesBO;
import com.innovargia.salesmanager.idao.ICuentasClientesDAO;

/**
 * @author aruaro
 * 
 */
@Service
public class CuentasClientesBO  implements ICuentasClientesBO {

	private static final Logger logger = LoggerFactory
			.getLogger(CuentasClientesBO.class);

	
	@Autowired
	ICuentasClientesDAO clientesDAO;
	
	public CuentasClientesBO(){
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#insert(com.innovargia.salesmanager.dtos.CuentasDTO)
	 */
	@Override
	public void insert(CuentasDTO obj) throws Exception{
		clientesDAO.insert(obj);
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#update(com.innovargia.salesmanager.dtos.CuentasDTO)
	 */
	@Override
	public void update(CuentasDTO obj) throws Exception{
		clientesDAO.update(obj);
	}
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#delete(com.innovargia.salesmanager.dtos.CuentasDTO)
	 */
	@Override
	public void delete(CuentasDTO obj) throws Exception{
		clientesDAO.delete(obj);
	}
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#getRegistros(com.innovargia.salesmanager.dtos.CuentasDTO)
	 */
	@Override
	public List<CuentasDTO> getRegistros(BusquedaDTO obj) throws Exception{
		return  clientesDAO.getRegistros(obj);
	}


	@Override
	public void updateEstatus(CuentasDTO obj) throws Exception {
		clientesDAO.updateEstatus(obj);
		
	}
	@Override
	public void updateTipoManejo(CuentasDTO obj) throws Exception{
		clientesDAO.updateTipoManejo(obj);
	}

	@Override
	public CuentasDTO get(BusquedaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return clientesDAO.get(obj);
	}

	@Override
	public List<CuentasDTO> getBusquedaRegistros(BusquedaDTO obj)
			throws Exception {
		// TODO Auto-generated method stub
		return clientesDAO.getBusquedaRegistros(obj);
	}
	



}
