/**
 * 
 */
package com.tracusa.logistica.dao;

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

import com.tracusa.logistica.model.Entrega;
import com.tracusa.logistica.model.RutaUbicacion;
import com.tracusa.logistica.interfase.dao.IEntregaDao;
import com.tracusa.logistica.interfase.dao.IRutaUbicacionDao;

/**
 * @author aruaro
 *
 */
@Repository
public class RutaUbicacionDao extends JdbcDaoSupport  implements IRutaUbicacionDao {

    
    private static final Logger logger = LoggerFactory
		.getLogger(RutaUbicacionDao.class);

    

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
    /**
     * 
     */
	@Autowired	
    public RutaUbicacionDao(DataSource dataSource) {
	
	setDataSource(dataSource);
	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
			dataSource);
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	
}
    
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#insert(com.innovargia.ws.dto.Entrega)
     */
    @Override
    public int insert(RutaUbicacion obj) throws Exception{
	 logger.info("RutaUbicacion create insert.");
	 
	 String query = "INSERT INTO ruta_ubicacion(" +
	            " ruta, imei, empleado, latitud, longitud, fechavento, fechainsercion) " +
	   " VALUES (:ruta, :imei, :empleado, :latitud, :longitud, " + obj.getFechaevento() + 
	   ", current_timestamp)";

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
    public int update(RutaUbicacion obj) throws Exception{
	
		
	return 0;
       }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#delete(com.innovargia.ws.dto.Entrega)
     */
    @Override
    public int delete(RutaUbicacion obj) throws Exception{
	
   	return 0;
       }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IEntregaDao#select(com.innovargia.ws.dto.Entrega)
     */
    @Override
    public List<RutaUbicacion> select(RutaUbicacion obj) throws Exception{
	
   	return new ArrayList<RutaUbicacion>();
       }

}
