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
import com.innovargia.salesmanager.idao.ITerminoPagoDAO;
import com.innovargia.salesmanager.mappers.CatalogoRowMapper;

@Repository
public class TerminoPagoDAO  extends JdbcDaoSupport implements ITerminoPagoDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AdicionalesDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TerminoPagoDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	final String  sql_ = "SELECT * FROM caterminopago ";

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#insert(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
		String query = "INSERT INTO caterminopago(nombre,descripcion,estatus) " +
			       "VALUES(:nombre, :descripcion, :estatus)";
	
		
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				catalogo);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idterminopago" });
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

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#update(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
		String query = "UPDATE caterminopago SET  nombre= :nombre, descripcion= :descripcion WHERE " +
			       " idterminopago = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#updateEstatus(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
		String query = "UPDATE caterminopago SET estatus= :estatus WHERE " +
			       " idterminopago = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#delete(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		String query = "DELETE FROM caterminopago WHERE " +
			       " idterminopago = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
		
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#getRegistros(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo)
			throws Exception {
		List<CatalogoDTO> lista = new ArrayList<CatalogoDTO>();
		String sql = sql_;
		//Signidica que debe traer todos los registros
		if (catalogo.getEstatus()>-1){
			sql+= " WHERE estatus="+catalogo.getEstatus();
		}
		
		lista = jdbcTemplate.query(sql,new CatalogoRowMapper());
		return lista;
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#get(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		String sql = sql_ + " WHERE idterminopago="+ catalogo.getIdentificador();
		try {
			return this.jdbcTemplate.queryForObject(sql,
					new CatalogoRowMapper(), catalogo.getIdentificador());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}

}
