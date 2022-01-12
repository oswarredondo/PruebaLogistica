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

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.idao.IAdicionalesDAO;
import com.innovargia.salesmanager.idao.IClavesExcepcionDAO;
import com.innovargia.salesmanager.mappers.CatalogoRowMapper;

@Repository
public class ClavesExcepcionDAO extends JdbcDaoSupport implements  IClavesExcepcionDAO {

	final String  sql_ = "SELECT idexcepcion as clave, descripcion, imputable  FROM caexcepcion";


	private static final Logger logger = LoggerFactory
			.getLogger(ClavesExcepcionDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ClavesExcepcionDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
		int tipo=0;
		if (catalogo.getTipo()!=null){
			try{
				tipo=Integer.parseInt(catalogo.getTipo());
			}catch(Exception e){
				tipo=0;
			}
		}
		String query = "INSERT INTO caexcepcion(idexcepcion, descripcion, imputable) "
				+ " VALUES (:clave, :descripcion,:imputable)";
		
		//KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				catalogo);

		try {
			//this.namedParameterJdbcTemplate.update(query, parameterSource,
			//		keyHolder, new String[] { "idadicional" });
			this.namedParameterJdbcTemplate.update(query, parameterSource);
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
	public void update(CatalogoDTO catalogo) throws Exception {
		int tipo=0;
		if (catalogo.getTipo()!=null){
			try{
				tipo=Integer.parseInt(catalogo.getTipo());
			}catch(Exception e){
				tipo=0;
			}
		}
		
		String query = "UPDATE caexcepcion SET descripcion= :descripcion, "
				+ " imputable= :imputable WHERE  idexcepcion = :clave";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
		String query = "";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		String query = "DELETE FROM caexcepcion WHERE " +
			       " idexcepcion = :clave";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
		
	}

	@Override
	public List<CatalogoDTO> getRegistros(BusquedaDTO busqueda)
			throws Exception {
		List<CatalogoDTO> lista = new ArrayList<CatalogoDTO>();
		String sql = sql_;
		if (busqueda.getTipo()==1){
			//Busca solo las claves con el prefijo indicado
			sql+= " WHERE idexcepcion LIKE ':patron_busqueda%'";
		}
	
		lista = jdbcTemplate.query(sql,new CatalogoRowMapper());
		return lista;
	}
	
	
	

	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		String sql = sql_ + " WHERE idexcepcion=:clave";
		try {
			return this.jdbcTemplate.queryForObject(sql,
					new CatalogoRowMapper(), catalogo.getIdentificador());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}


}
