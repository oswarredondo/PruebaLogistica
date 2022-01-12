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

import com.innovargia.salesmanager.dtos.WallPaperDTO;
import com.innovargia.salesmanager.idao.IWallPaperDAO;
import com.innovargia.salesmanager.mappers.WallPaperRowMapper;

@Repository
public class WallPaperDAO extends JdbcDaoSupport implements  IWallPaperDAO {

	final String  sql_ = "SELECT * FROM caWallPaper ";

	private static final Logger logger = LoggerFactory
			.getLogger(WallPaperDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public WallPaperDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}



	@Override
	public void insert(WallPaperDTO wallpaper) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(WallPaperDTO wallpaper) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEstatus(WallPaperDTO wallpaper) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(WallPaperDTO wallpaper) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<WallPaperDTO> getRegistros(WallPaperDTO wallpaper)
			throws Exception {
		List<WallPaperDTO> lista = new ArrayList<WallPaperDTO>();
		String sql = "SELECT * FROM caWallPaper WHERE idaplicacion='" + wallpaper.getIdaplicacion() +
				"' AND image IS NOT NULL AND image !=''";
		try{
			lista = jdbcTemplate.query(sql,new WallPaperRowMapper());
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
		return lista;
	}

	@Override
	public WallPaperDTO get(WallPaperDTO wallpaper) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
