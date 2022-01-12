/**
 * 
 */
package com.innovargia.ws.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.innovargia.ws.dto.Entrega;
import com.innovargia.ws.repo.interfase.dao.IEntregaDao;

/**
 * @author aruaro
 *
 */
@Repository
public class EntregaDao extends JdbcDaoSupport  implements IEntregaDao {

    
    private static final Logger logger = LoggerFactory
		.getLogger(EntregaDao.class);

    

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
    /**
     * 
     */
	@Autowired	
    public EntregaDao(DataSource dataSource) {
	
	setDataSource(dataSource);
	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
			dataSource);
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	
}
    
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#insert(com.innovargia.ws.dto.Entrega)
     */
    @Override
    public int insert(Entrega obj) throws Exception{
	 logger.info("EntregaDao create insert.");
	 
	 String query =  "INSERT INTO confirma (idguia,conombre,cofecha,"
			+ "fechainsercion,latitud,longitud, "
			+ "ruta,plsiglasplaza,ceorigenregistro) "
		    	+ "VALUES (:idguia,:nomRecibe,'" + obj.getFecha()+"',"
		    		+ "current_timestamp,:latitud,:longitud,"
		    		+ ":ruta,:plaza,:oriReg) ";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
			obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (DataAccessException dae) {
			logger.debug("error insert:" + dae.getMessage());
		}
		
	return 0;
    }
    
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#update(com.innovargia.ws.dto.Entrega)
     */
    @Override
    public int update(Entrega obj) throws Exception{
	 logger.info("EntregaDao create update.");
	 String query =  "UPDATE confirma SET latitud=:latitud,longitud=:longitud WHERE idguia=:idguia ";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
			obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (DataAccessException dae) {
			logger.debug("error insert:" + dae.getMessage());
		}
		
	return 0;
       }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#delete(com.innovargia.ws.dto.Entrega)
     */
    @Override
    public int delete(Entrega obj) throws Exception{
	
   	return 0;
       }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#select(com.innovargia.ws.dto.Entrega)
     */
    @Override
    public List<Entrega> select(Entrega obj) throws Exception{
	
   	return new ArrayList<Entrega>();
       }

}
