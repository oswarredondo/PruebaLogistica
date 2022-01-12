/**
 * 
 */
package com.innovargia.salesmanager.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.idao.ILogHistoriaDAO;
import com.innovargia.salesmanager.mappers.LogHistorialRowMapper;

/**
 * @author aruaro
 * 
 */
@Repository
public class LogHistorialDAO extends JdbcDaoSupport implements ILogHistoriaDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(LogHistorialDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	final String  sql_ = "SELECT * FROM calogcambios ";
	
	@Autowired
	public LogHistorialDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(LogHistoriaDTO obj) throws Exception {
		String query = "INSERT INTO calogcambios(idregistro,tipomovimiento,fecha,registro,quienrealiza) ) " +
			       "VALUES(:idregistro,:tipomovimiento, current_timestamp,:registro,:quienrealiza)";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void update(LogHistoriaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(LogHistoriaDTO obj) throws Exception {
		String query = "DELETE FROM calogcambios  WHERE  fecha < :fecha";
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en delete: " + dae.getMessage());
		}
		
	}

	@Override
	public List<LogHistoriaDTO> getRegistros(LogHistoriaDTO obj) throws Exception {
		List<LogHistoriaDTO> lista = new ArrayList<LogHistoriaDTO>();
		String sql = sql_;
				
		lista = jdbcTemplate.query(sql,new LogHistorialRowMapper());
		return lista;
		
	}

	@Override
	public LogHistoriaDTO get(LogHistoriaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEstatus(LogHistoriaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LogHistoriaDTO> getRegistrosConvenio(BusquedaDTO obj)
			throws Exception {
		String sql = "SELECT iddocumento as idregistro, "
				+ "tipomov as tipomovimiento, fechaevento as fecha, "
				+ "login as login, observacion FROM caconveniohistoria WHERE iddocumento="+
				obj.getIdentificador() + " ORDER BY fechaevento desc";
		
		List<LogHistoriaDTO> lista = new ArrayList<LogHistoriaDTO>();
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj); 	
		lista =  this.namedParameterJdbcTemplate.query(sql, parameterSource, new LogHistorialRowMapper());

		return lista;
	}

	@Override
	public void insertHistoriaConvenio(LogHistoriaDTO obj) throws Exception {
		String query = "INSERT INTO caconveniohistoria(iddocumento,tipomov,fechaevento,login,observacion) "
				+ " VALUES(:idregistro,:tipomovimiento,current_timestamp,:login, :registro)"; 

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new DuplicateKeyException("Registro Duplicado");
			} else {
				throw new DuplicateKeyException(dae.getMessage());
			}

		}
		
	}
	
	
}
