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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.innovargia.salesmanager.dtos.ModalidadDescuentoDTO;
import com.innovargia.salesmanager.idao.IDescuentoRangoEnviosDAO;
import com.innovargia.salesmanager.mappers.ModalidadDescuentoRowMapper;

/**
 * @author aruaro
 * 
 */
@Repository
public class DescuentoRangoEnviosDAO extends JdbcDaoSupport implements IDescuentoRangoEnviosDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(DescuentoRangoEnviosDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	
	final String  sql_ = "SELECT * FROM cadescuentorangoenvios ";
	
	@Autowired
	public DescuentoRangoEnviosDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(ModalidadDescuentoDTO obj) throws Exception {
		String query = "INSERT INTO cadescuentorangoenvios(idrangoenvios,iddescuento) ) " +
			       "VALUES(:idrangoenvios,:iddescuento)";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void update(ModalidadDescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ModalidadDescuentoDTO obj) throws Exception {
		String query = "DELETE FROM cadescuentorangoenvios  WHERE  idrangoenvios = :idrangoenvios AND iddescuento=:iddescuento ";
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en delete: " + dae.getMessage());
		}
		
	}

	@Override
	public List<ModalidadDescuentoDTO> getRegistros(ModalidadDescuentoDTO obj) throws Exception {
		List<ModalidadDescuentoDTO> lista = new ArrayList<ModalidadDescuentoDTO>();
		String sql = sql_ + " WHERE  iddescuento=:iddescuento";
				
		lista = jdbcTemplate.query(sql,new ModalidadDescuentoRowMapper());
		return lista;
	}

	@Override
	public ModalidadDescuentoDTO get(ModalidadDescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEstatus(ModalidadDescuentoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
