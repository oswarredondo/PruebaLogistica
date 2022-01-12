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

import com.innovargia.salesmanager.dtos.ServicioDTO;
import com.innovargia.salesmanager.idao.ITipoServicioDAO;
import com.innovargia.salesmanager.mappers.ServicioRowMapper;

@Repository
public class TipoServicioDAO extends JdbcDaoSupport implements  ITipoServicioDAO {

	final String  sql_ = "SELECT identificador,idservicio ,"
			+ "descripcion,estatus,codigoid,nombre,idorganizacion,"
			+ "identidad,generaretorno,tipocobro FROM catiposervicio";


	private static final Logger logger = LoggerFactory
			.getLogger(TipoServicioDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TipoServicioDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(ServicioDTO catalogo) throws Exception {
		String query = "INSERT INTO catiposervicio(idservicio,descripcion,"
				+ "estatus,codigoid,nombre,idorganizacion,"
			+ "identidad,generaretorno,tipocobro) " +
			       "VALUES(:idservicio,:descripcion,:estatus,:codigoid,:nombre,"
			       + ":idorganizacion,:identidad,:generaretorno,:tipocobro)";
	
		
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				catalogo);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idservicio" });
			
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
	public void update(ServicioDTO catalogo) throws Exception {
		String query = "UPDATE catiposervicio SET idservicio=:idservicio,descripcion=:descripcion,"
				+ "estatus=:estatus,codigoid = :codigoid,nombre = :nombre,"
			       + "idorganizacion= :idorganizacion, identidad = :identidad,"
			       + "generaretorno = :generaretorno,tipocobro =:tipocobro WHERE " +
			       " identificador = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en update: " + dae.getMessage());
		}
		
	}

	@Override
	public void updateEstatus(ServicioDTO catalogo) throws Exception {
		String query = "UPDATE catiposervicio SET estatus= :estatus WHERE " +
			       " idservicio = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void delete(ServicioDTO catalogo) throws Exception {
		String query = "DELETE FROM catiposervicio WHERE " +
			       " identidad = :identidad AND idorganizacion=:idorganizacion AND idservicio=:idservicio";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
		
	}


	@Override
	public List<ServicioDTO> getRegistros(ServicioDTO catalogo)
			throws Exception {
		List<ServicioDTO> lista = new ArrayList<ServicioDTO>();
		String sql = sql_ + " WHERE identidad=" +
		catalogo.getIdentidad()+ " AND idorganizacion=" + catalogo.getIdorganizacion()+ "  AND "
				+ " idservicio IN (SELECT idservicio from catiposervicio WHERE estatus=1)";
		
		lista = jdbcTemplate.query(sql,new ServicioRowMapper());
		return lista;
	}

	@Override
	public ServicioDTO get(ServicioDTO catalogo) throws Exception {
		String sql = sql_ + " WHERE identificador="+ catalogo.getIdentificador();
		try {
			return this.jdbcTemplate.queryForObject(sql,
					new ServicioRowMapper(), catalogo.getIdentificador());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}


}
