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

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.idao.IAdicionalesDAO;
import com.innovargia.salesmanager.idao.IMaterialEmpaqueDAO;
import com.innovargia.salesmanager.mappers.CatalogoRowMapper;

@Repository
public class MaterialEmpaqueDAO extends JdbcDaoSupport implements  IMaterialEmpaqueDAO {

	final String  sql_ = "SELECT idmaterialempaque as identificador,idconvenio AS idtipo,"
			+ " descripcion,precio_unitario as precio,cantidad FROM caconveniomaterialempaque";

	private static final Logger logger = LoggerFactory
			.getLogger(MaterialEmpaqueDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public MaterialEmpaqueDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {

		String query = "INSERT INTO caconveniomaterialempaque(idconvenio, descripcion, precio_unitario,  cantidad) " +
			       "VALUES(:idtipo,:descripcion, :precio,:cantidad)";
	
		
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				catalogo);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idmaterialempaque" });
			
			//return keyHolder.getKey();
		} catch (Exception dae) {
			logger.error("error insert:" + dae.getMessage());
			throw new Exception("Registro Duplicado");

		}
		
	}
	@Override
	public void insertRegistrosContizacionAConvenio(int de_idcotizacion, int a_idcotizacion) throws Exception {

		String query = "INSERT INTO caconveniomaterialempaque("
			+ " idconvenio, descripcion, cantidad, precio_unitario)"
			+ " SELECT " + a_idcotizacion +", descripcion, cantidad, precio_unitario "
			+ " FROM caconveniomaterialempaque WHERE idconvenio="+de_idcotizacion;

		try {
			this.jdbcTemplate.update(query);
			
			//return keyHolder.getKey();
		} catch (Exception dae) {
			logger.error("error insert:" + dae.getMessage());
			throw new Exception("Registro Duplicado");

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
		
		String query = "UPDATE caconveniomaterialempaque SET "
				+ "descripcion= :descripcion,"
				+ "precio_unitario= :precio, cantidad=:cantidad WHERE idmaterialempaque=:identificador" ;
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	

	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		String query = "DELETE FROM caconveniomaterialempaque WHERE " +
			       " idmaterialempaque = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
		
	}

	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo)
			throws Exception {
		List<CatalogoDTO> lista = new ArrayList<CatalogoDTO>();
		String sql = sql_ + " WHERE idconvenio=" + catalogo.getIdtipo();
		lista = jdbcTemplate.query(sql,new CatalogoRowMapper());
		return lista;
	}
	
	
	

	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		String sql = sql_ + " WHERE idmaterialempaque=:identificador";
		try {
			return this.jdbcTemplate.queryForObject(sql,
					new CatalogoRowMapper(), catalogo.getIdentificador());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}


}
