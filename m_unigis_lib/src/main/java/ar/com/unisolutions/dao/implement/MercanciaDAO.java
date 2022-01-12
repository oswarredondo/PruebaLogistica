package ar.com.unisolutions.dao.implement;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import ar.com.unisolutions.dao.IMercanciaDAO;
import ar.com.unisolutions.dto.MercanciaSat;
import ar.com.unisolutions.rowmapper.MercanciaRowMapper;

@Repository
public class MercanciaDAO extends JdbcDaoSupport implements IMercanciaDAO{

	private static final Logger logger = LoggerFactory
			.getLogger(MercanciaDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	private static String  _sql= "SELECT * FROM gbmercancia";
	
	@Autowired
	public MercanciaDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<MercanciaSat> getMercancia() throws Exception {
		
		try {
			
			return this.namedParameterJdbcTemplate.query(_sql, new MercanciaRowMapper());
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String getMercanciaById(String clavemcia) throws Exception {

		try {
			
			String sql = "SELECT descripcionmcia FROM gbmercancia WHERE clavemcia = ?";
			
			return this.jdbcTemplate.queryForObject(sql, new Object[]{clavemcia},String.class);
			
		} catch (Exception e) {
			
			throw new Exception("No se encuentra el valor '"+ clavemcia +"' en el catalogo del SAT.");
		}
		
	}
	
}
