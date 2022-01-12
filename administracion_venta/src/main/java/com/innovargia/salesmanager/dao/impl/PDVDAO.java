/**
 * 
 */
package com.innovargia.salesmanager.dao.impl;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.dto.CotizacionTarifa;
import com.innovargia.salesmanager.idao.IPDVDAO;

/**
 * @author aruaro
 * 
 */
@Repository
public class PDVDAO extends JdbcDaoSupport implements IPDVDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(PDVDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	final String  sql_ = "SELECT * FROM calogcambios ";
	
	@Autowired
	public PDVDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPDVDAO#insertaOficinaUsuario(java.lang.String, java.lang.String)
	 */
	@Override
	public void insertaOficinaUsuario(String login, String idoficina) throws Exception {
		String query = "INSERT INTO pdv_usuario( idoficina, login) VALUES ( '" +
			idoficina+ "', '" + login+"');";

		try{
		    this.jdbcTemplate.update(query);
		}catch(Exception dae){
			logger.error("Error en insertaOficinaUsuario: " + dae.getMessage());
		}
		
	}
	

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPDVDAO#deleteOficinaDeUsuario(java.lang.String)
	 */
	@Override
	public void deleteOficinaDeUsuario(String login) throws Exception {
		String query = "DELETE FROM pdv_usuario  WHERE  login='" + login+"'";
		

		try{
		    this.jdbcTemplate.update(query);
		}catch(Exception dae){
			logger.error("Error en deleteOficinaDeUsuario: " + dae.getMessage());
		}
		
	}
	

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPDVDAO#deleteUsuarioDeOficina(java.lang.String, java.lang.String)
	 */
	@Override
	public void deleteUsuarioDeOficina(String login,String idoficina) throws Exception {
		String query = "DELETE FROM pdv_usuario  WHERE  login='" + login+"' AND idoficina='" + idoficina+"'";

		try{
			this.jdbcTemplate.update(query);
		}catch(Exception dae){
			logger.error("Error en deleteUsuarioDeOficina: " + dae.getMessage());
		}
		
		
	}


	@Override
	public void insertLineaCotizacion(CotizacionTarifa obj)
		throws Exception {
	    // TODO Auto-generated method stub
	    
	}
	
	
}
