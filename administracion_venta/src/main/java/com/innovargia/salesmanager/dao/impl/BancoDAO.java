package com.innovargia.salesmanager.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.idao.IBancoDAO;
import com.innovargia.salesmanager.mappers.CatalogoRowMapper;

@Repository
public class BancoDAO extends JdbcDaoSupport implements IBancoDAO {

	final String  sql_ = "SELECT descripcion as clave,descripcion FROM cabanco";

	private static final Logger logger = LoggerFactory
			.getLogger(BancoDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public BancoDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IBancoDAO#insert(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
		
		
	}
	
	
	


	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IBancoDAO#update(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
		
		
	}


	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IBancoDAO#updateEstatus(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
		
		
	}


	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IBancoDAO#delete(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
		
		
	}


	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IBancoDAO#getRegistros()
	 */
	@Override
	public List<CatalogoDTO> getRegistros()
			throws Exception {
		List<CatalogoDTO> lista = new ArrayList<CatalogoDTO>();
		String sql = sql_;
		lista = jdbcTemplate.query(sql,new CatalogoRowMapper());
		return lista;
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IBancoDAO#get(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
		return null;
	}


}
