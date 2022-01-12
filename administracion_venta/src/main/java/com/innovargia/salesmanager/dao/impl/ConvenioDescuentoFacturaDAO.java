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

import com.innovargia.salesmanager.dtos.ConvenioDescuentoFactura;
import com.innovargia.salesmanager.idao.IConvenioDescuentoFacturaDAO;
import com.innovargia.salesmanager.mappers.CatalogoRowMapper;
import com.innovargia.salesmanager.mappers.ConvenioDescuentoFacturaRowMapper;

@Repository
public class ConvenioDescuentoFacturaDAO extends JdbcDaoSupport implements  IConvenioDescuentoFacturaDAO {

	final String  sql_ = "SELECT idconveniodescfact, idconvenio, rangoinicial, rangofinal, descuento, "
		+ "       fechaevento, login"
		+ "  FROM caconveniodescuentofactura";

	private static final Logger logger = LoggerFactory
			.getLogger(ConvenioDescuentoFacturaDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ConvenioDescuentoFacturaDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(ConvenioDescuentoFactura  catalogo) throws Exception {
		String query = "INSERT INTO caconveniodescuentofactura("
			+ "   idconvenio, rangoinicial, rangofinal, descuento, "
			+ "  fechaevento, login)"
			+ "    VALUES (:idconvenio, :rangoinicial, :rangofinal, :descuento, "
			+ "  current_timestamp, :login)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				catalogo);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idconveniodescfact" });
			
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
	public void update(ConvenioDescuentoFactura catalogo) throws Exception {

	    String query = "UPDATE caconveniodescuentofactura"
			+ "   SET  rangoinicial=:rangoinicial, rangofinal=:rangofinal, "
			+ "       descuento=:descuento, fechaevento=current_timestamp, login=:login "
			+ "  WHERE idconveniodescfact=:idconveniodescfact";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void delete(ConvenioDescuentoFactura catalogo) throws Exception {
		String query = "DELETE FROM caconveniodescuentofactura WHERE " +
			       " idconveniodescfact = :idconveniodescfact";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
		
	}

	@Override
	public List<ConvenioDescuentoFactura> getRegistros(ConvenioDescuentoFactura catalogo)
			throws Exception {
		List<ConvenioDescuentoFactura> lista = new ArrayList<ConvenioDescuentoFactura>();
		String sql = sql_ + " WHERE idconvenio=" + catalogo.getIdconvenio();
		
		lista = jdbcTemplate.query(sql,new ConvenioDescuentoFacturaRowMapper());
		return lista;
	}
	
	
	@Override
	public ConvenioDescuentoFactura get(ConvenioDescuentoFactura catalogo) throws Exception {
	    String sql = sql_ + " WHERE idconveniodescfact=" + catalogo.getIdconveniodescfact();
		try {
			return this.jdbcTemplate.queryForObject(sql,new ConvenioDescuentoFacturaRowMapper());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}
	
	@Override
	public void insertRegistrosDescuentoXFacturacion(int de_idcotizacion, int a_idcotizacion) throws Exception {

		String query = "INSERT INTO caconveniodescuentofactura("
			+ "  idconvenio, rangoinicial, rangofinal, descuento, "
			+ " fechaevento, login) "
			+ " SELECT  " +a_idcotizacion+", rangoinicial, rangofinal, descuento,"
			+ " current_timestamp, login FROM caconveniodescuentofactura where idconvenio="+de_idcotizacion;

		try {
			this.jdbcTemplate.update(query);

		} catch (Exception dae) {
			logger.error("error insert:" + dae.getMessage());
			throw new Exception("Registro Duplicado");

		}
		
	}

}
