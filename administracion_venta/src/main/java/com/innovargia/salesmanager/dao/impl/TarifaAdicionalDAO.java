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

import com.innovargia.salesmanager.dtos.TarifaAdicionalDTO;
import com.innovargia.salesmanager.idao.ITarifaAdicionalDAO;
import com.innovargia.salesmanager.mappers.TarifaAdicionalRowMapper;

@Repository
public class TarifaAdicionalDAO   extends JdbcDaoSupport implements ITarifaAdicionalDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AdicionalesDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TarifaAdicionalDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(TarifaAdicionalDTO catalogo) throws Exception {
		String query = "INSERT INTO caconvenioadicional(idconvenio, "
				+ " idadicional, descuento, precio, estatus) "
				+ " VALUES (:idconvenio, :idadicional, :descuento, :precio, :estatus)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				catalogo);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idadicionaldetalle" });
			
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
	public void update(TarifaAdicionalDTO catalogo) throws Exception {
		String query = "UPDATE caconvenioadicional"
				+ " SET descuento=:descuento, "
				+ " precio=:precio WHERE idadicionaldetalle=:idadicionaldetalle";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void updateEstatus(TarifaAdicionalDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TarifaAdicionalDTO catalogo) throws Exception {
		String query = "DELETE FROM caconvenioadicional WHERE " +
			       " idadicionaldetalle = :idadicionaldetalle";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
		
	}

	@Override
	public List<TarifaAdicionalDTO> getRegistros(TarifaAdicionalDTO catalogo)
			throws Exception {
		List<TarifaAdicionalDTO> lista = new ArrayList<TarifaAdicionalDTO>();
		//Solo obtiene los registros existente en ambas tablas 
		String sql = "SELECT caconvenioadicional.*,"
				+ "  caadicional.idadicional AS claveadicional,"
				+ "  caadicional.descripcion ,tipoincremento "
				+ "  FROM caconvenioadicional JOIN caadicional ON"
				+ "  caconvenioadicional.idadicional = caadicional.identificador AND "
				+ " caconvenioadicional.idconvenio = " + catalogo.getIdconvenio();
		
		lista = jdbcTemplate.query(sql,new TarifaAdicionalRowMapper());
		return lista;
	}


	@Override
	public TarifaAdicionalDTO get(TarifaAdicionalDTO catalogo) throws Exception {
		List<TarifaAdicionalDTO> lista = new ArrayList<TarifaAdicionalDTO>();
		//Solo obtiene los registros existente en ambas tablas 
		String sql = "SELECT caconvenioadicional.*,"
				+ "  caadicional.idadicional AS claveadicional,"
				+ "  caadicional.descripcion ,tipoincremento "
				+ "  FROM caconvenioadicional JOIN caadicional ON"
				+ "  caconvenioadicional.idadicional = caadicional.identificador AND "
				+ " caconvenioadicional.idconvenio = " + catalogo.getIdconvenio() +
				" WHERE idadicionaldetalle=" + catalogo.getIdadicionaldetalle(); 
				;
		
		lista = jdbcTemplate.query(sql,new TarifaAdicionalRowMapper());
		
		if (lista.size()>0){
			return lista.get(0);
		}
		return null;
	}

	
}
