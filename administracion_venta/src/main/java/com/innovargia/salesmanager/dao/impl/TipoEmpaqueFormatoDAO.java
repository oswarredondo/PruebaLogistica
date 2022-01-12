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
import com.innovargia.salesmanager.idao.ITipoEmpaqueFormatoDAO;
import com.innovargia.salesmanager.mappers.CatalogoRowMapper;

@Repository
public class TipoEmpaqueFormatoDAO extends JdbcDaoSupport implements  ITipoEmpaqueFormatoDAO {

	final String  sql_ = "SELECT descripcion AS clave, descripcion"
		+ " FROM catipoformato";

	private static final Logger logger = LoggerFactory
			.getLogger(TipoEmpaqueFormatoDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TipoEmpaqueFormatoDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(CatalogoDTO catalogo) throws Exception {
	    // TODO Auto-generated method stub
	    
	}

	@Override
	public void update(CatalogoDTO catalogo) throws Exception {
	    // TODO Auto-generated method stub
	    
	}

	@Override
	public void updateEstatus(CatalogoDTO catalogo) throws Exception {
	    // TODO Auto-generated method stub
	    
	}

	@Override
	public void delete(CatalogoDTO catalogo) throws Exception {
	    // TODO Auto-generated method stub
	    
	}

	@Override
	public List<CatalogoDTO> getRegistros(CatalogoDTO catalogo)
		throws Exception {
	    List<CatalogoDTO> lista = new ArrayList<CatalogoDTO>();
		String sql = sql_;
		
		lista = jdbcTemplate.query(sql,new CatalogoRowMapper());
		return lista;
	}

	@Override
	public CatalogoDTO get(CatalogoDTO catalogo) throws Exception {
	    // TODO Auto-generated method stub
	    return null;
	}

	

}
