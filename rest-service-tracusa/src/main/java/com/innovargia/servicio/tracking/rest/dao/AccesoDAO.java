/**
 * 
 */
package com.innovargia.servicio.tracking.rest.dao;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.innovargia.ws.repo.interfase.dao.IAccesoDAO;
import com.innovargia.ws.tracking.rest.dto.UsuarioDTO;

/**
 * @author aruaro
 *
 */
@Repository
public class AccesoDAO  extends JdbcDaoSupport implements IAccesoDAO   {
	
	private static Logger logger = Logger.getLogger(AccesoDAO.class);
    
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired	
	public AccesoDAO(DataSource dataSource) {
    	setDataSource(dataSource);
    	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    	this.jdbcTemplate = new JdbcTemplate(dataSource);
    	
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.ws.tracking.rest.dao.impl.IAccesoDAO#getUsuario(com.innovargia.ws.tracking.rest.dto.UsuarioDTO)
	 */
	@Override
	public UsuarioDTO getUsuario(UsuarioDTO usuario) throws Exception {
		return null;
	}

}
