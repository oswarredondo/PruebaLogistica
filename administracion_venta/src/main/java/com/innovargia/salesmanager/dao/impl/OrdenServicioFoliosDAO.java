/**
 * 
 */
package com.innovargia.salesmanager.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.OrdenServicioFoliosDTO;
import com.innovargia.salesmanager.idao.IOrdenServicioFoliosDAO;

/**
 * @author aruaro
 * 
 */
@Repository
public class OrdenServicioFoliosDAO extends JdbcDaoSupport implements IOrdenServicioFoliosDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(OrdenServicioFoliosDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public OrdenServicioFoliosDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(OrdenServicioFoliosDTO obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(OrdenServicioFoliosDTO obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(OrdenServicioFoliosDTO obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public  List<OrdenServicioFoliosDTO> getRegistros(OrdenServicioFoliosDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEstatus(OrdenServicioFoliosDTO obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CatalogoDTO get(OrdenServicioFoliosDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
