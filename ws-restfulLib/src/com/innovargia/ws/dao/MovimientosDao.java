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
import com.innovargia.ws.dto.Movimiento;
import com.innovargia.ws.repo.interfase.dao.IMovimientoDao;

/**
 * @author aruaro
 *
 */
@Repository
public class MovimientosDao  extends JdbcDaoSupport   implements IMovimientoDao {
    
    private static final Logger logger = LoggerFactory
		.getLogger(MovimientosDao.class);
    
    
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	

    /**
     * 
     */
	@Autowired
    public MovimientosDao(DataSource dataSource) {
	
	setDataSource(dataSource);
	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
			dataSource);
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	
}
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IMovimientoDao#insert(com.innovargia.ws.dto.Movimiento)
     */
    @Override
    public int insert(Movimiento obj) throws Exception{
	
	logger.info("MovimientosDao create insert.");
	 
	 String query =  "INSERT INTO movimientos("
	 	+ " idguia, tiregistro, exclave, plsiglasplaza,"
	 	+ " ceorigenregistro, ruta, fechaevento, "
	 	+ "fechainsercion, empleado,latitud,longitud) "
	 	+ " VALUES (:idguia,:tipoMovimiento,:cveLog,:plaza,:oriReg,:ruta,"
	 	+ "'" + obj.getFecha() +"',current_timestamp,:empleado,:latitud,:longitud)";

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
     * @see com.innovargia.ws.repo.interfase.IMovimientoDao#update(com.innovargia.ws.dto.Movimiento)
     */
    @Override
    public int update(Movimiento obj) throws Exception{
	
   	return 0;
       }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IMovimientoDao#delete(com.innovargia.ws.dto.Movimiento)
     */
    @Override
    public int delete(Movimiento obj) throws Exception{
	
   	return 0;
       }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IMovimientoDao#select(com.innovargia.ws.dto.Movimiento)
     */
    @Override
    public List<Movimiento> select(Movimiento obj) throws Exception{
	
   	return new ArrayList<Movimiento>();
       }
    @Override
    public int insertCasamiento(Movimiento obj) throws Exception {
	// TODO Auto-generated method stub
	logger.info("MovimientosDao create insertCasamiento.");
	    
	 String query =  "INSERT INTO casamiento("
	 	+ " idguia, idcasamiento, idcarrier, ceorigenregistro, "
	 	+ " plsiglasplaza, fechaevento, ruta, empleado)"
	 	+ " VALUES (:idguia,:guiaCasamiento,'',:oriReg,:plaza,'" +  obj.getFecha() + "', :ruta,:empleado);";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
			obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (DataAccessException dae) {
			logger.debug("error insertCasamiento:" + dae.getMessage());
		}
		
	return 0;
    }

}
