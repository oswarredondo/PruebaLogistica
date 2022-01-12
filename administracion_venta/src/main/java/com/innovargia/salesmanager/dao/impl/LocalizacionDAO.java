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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.innovargia.salesmanager.dtos.LocalizacionDTO;
import com.innovargia.salesmanager.idao.ILocalizacionDAO;
import com.innovargia.salesmanager.mappers.LocalizacionRowMapper;

/**
 * @author aruaro
 * 
 */
@Repository
public class LocalizacionDAO extends JdbcDaoSupport implements ILocalizacionDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(LocalizacionDAO.class);
	
	final String  sql_ = "SELECT * FROM calocalizacion ";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public LocalizacionDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(LocalizacionDTO obj) throws Exception {
		String query = "INSERT INTO calocalizacion(telefono1,telefono,fax, idcliente ) " +
			       "VALUES(:telefono1,:telefono,:fax, :idcliente )";

		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idlocalizacion" });
			//return keyHolder.getKey();
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new DuplicateKeyException("Registro Duplicado");
			} else {
				throw new DuplicateKeyException(dae.getMessage());
			}

		}
		
	}

	@Override
	public void update(LocalizacionDTO obj) throws Exception {
		String query = "UPDATE calocalizacion SET telefono1= :telefono1,"
				+ "telefono= :telefono,fax= :fax"
				+ " WHERE " +
			       " idlocalizacion = :idlocalizacion";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void delete(LocalizacionDTO obj) throws Exception {
		String query = "DELETE FROM calocalizacion  WHERE  idlocalizacion = :idlocalizacion";
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en delete: " + dae.getMessage());
		}
		
	}

	@Override
	public List<LocalizacionDTO> getRegistros(LocalizacionDTO obj)
			throws Exception {
		List<LocalizacionDTO> lista = new ArrayList<LocalizacionDTO>();
		String sql = sql_;
				
		lista = jdbcTemplate.query(sql,new LocalizacionRowMapper());
		return lista;
	}

	@Override
	public LocalizacionDTO get(LocalizacionDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEstatus(LocalizacionDTO obj) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
