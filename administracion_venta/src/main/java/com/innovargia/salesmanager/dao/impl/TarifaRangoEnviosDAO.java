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
import org.springframework.transaction.annotation.Transactional;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;
import com.innovargia.salesmanager.idao.ITarifaRangoEnviosDAO;
import com.innovargia.salesmanager.mappers.TarifaRowMapper;

/***
 * Contiene la informacion de rangos catarifarangosenvios
 * @author Adrián
 *
 */
@Repository
public class TarifaRangoEnviosDAO extends JdbcDaoSupport implements ITarifaRangoEnviosDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(TarifaRangoEnviosDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	String _sql ="SELECT * FROM catarifarangosenvios ";

	/**
	 * Inseyecta el dataspource
	 * 
	 * @param dataSource
	 */
	@Autowired
	public TarifaRangoEnviosDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}




	@Override
	@Transactional 
	public Number insert(TarifaDTO obj) throws Exception {
		String query = "INSERT INTO catarifarangosenvios( "
				+ "idtarifa,nombre,descripcion,idrangoinicial,idrangofinal,estatus ) "
				+ " VALUES (:idtarifa,:nombre,:descripcion,:idrangoinicial,:idrangofinal,1)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idrangoenvios" });
			 return keyHolder.getKey();
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new RuntimeException("Registro Duplicado");
			} else {
				throw new RuntimeException(dae.getMessage());
			}

		}

	}

	@Override
	public void update(TarifaDTO obj) throws Exception {
		String query = "UPDATE catarifarangosenvios SET "
				+ "descripcion=:descripcion,idrangoinicial=:idrangoinicial,"
				+ "idrangofinal=:idrangofinal,nombre=:nombre "
				+ " WHERE " + " idrangoenvios = :idrangoenvios";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en update: " + dae.getMessage());
		}

	}

	@Override
	public void updateEstatus(TarifaDTO obj) throws Exception {
		String query = "UPDATE catarifarangosenvios SET estatus= :estatus "
				+ " WHERE idrangoenvios = :idrangoenvios";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}

	}

	@Override
	@Transactional
	public void delete(TarifaDTO obj) throws Exception {
		String query = "DELETE FROM catarifarangosenvios  WHERE idrangoenvios = :idrangoenvios";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en delete: " + dae.getMessage());
		}

	}

	@Override
	public List<TarifaDTO> getRegistros(BusquedaDTO busqueda) throws Exception {
		
		List<TarifaDTO> lista = new ArrayList<TarifaDTO>();
		String sql = _sql +  " WHERE idtarifa=:identificador";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(busqueda); 	
		lista =  this.namedParameterJdbcTemplate.query(sql, parameterSource, new TarifaRowMapper());
	
		return lista;

	}
	
	@Override
	public TarifaDTO get(TarifaDTO tarifa) throws Exception {
		String sql = _sql + " WHERE idrangoenvios = ?";
		try {
			return this.jdbcTemplate.queryForObject(sql,
					new TarifaRowMapper(), tarifa.getIdserviciotarifazona());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}

}
