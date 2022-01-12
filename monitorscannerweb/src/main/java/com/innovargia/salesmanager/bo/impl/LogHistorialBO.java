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
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.ibo.ILogHistoriaBO;
import com.innovargia.salesmanager.idao.ILogHistoriaDAO;

/**
 * @author aruaro
 * 
 */
@Service
public class LogHistorialBO implements ILogHistoriaBO {

	private static final Logger logger = LoggerFactory
			.getLogger(LogHistorialBO.class);

	@Autowired
	ILogHistoriaDAO logHistoriaDAO;

	public LogHistorialBO(){}

	@Override
	public void insert(LogHistoriaDTO obj) throws Exception {
		logHistoriaDAO.insert(obj);
		
	}

	@Override
	public void update(LogHistoriaDTO obj) throws Exception {
		logHistoriaDAO.update(obj);
		
	}

	@Override
	public void delete(LogHistoriaDTO obj) throws Exception {
		logHistoriaDAO.delete(obj);
		
	}

	@Override
	public void getRegistros(LogHistoriaDTO obj) throws Exception {
		logHistoriaDAO.getRegistros(obj);
		
	}

	@Override
	public LogHistoriaDTO get(LogHistoriaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return logHistoriaDAO.get(obj);
	}

	@Override
	public void updateEstatus(LogHistoriaDTO obj) throws Exception {
		logHistoriaDAO.updateEstatus(obj);;
		
	}

	@Override
	public List<LogHistoriaDTO> getRegistrosConvenio(BusquedaDTO obj)
			throws Exception {
		// TODO Auto-generated method stub
		return logHistoriaDAO.getRegistrosConvenio(obj);
	}

	@Override
	public void insertHistoriaConvenio(LogHistoriaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		logHistoriaDAO.insertHistoriaConvenio(obj);
	}
	
	
}
