package com.email.tracusa.logistica.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.email.tracusa.logistica.idao.IEmailDAO;

@Repository
public class UsuarioDAO extends JdbcDaoSupport implements IEmailDAO{

	final String sql_ = "SELECT * FROM caUsuarios ";

	private static final Logger logger = LoggerFactory
			.getLogger(UsuarioDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UsuarioDAO(DataSource dataSource) {
		
		setDataSource(dataSource);
		
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

	public List<String> getUsuarios(String perfil) throws Exception {
		
		try {
			
			List<String> lista = new ArrayList<String>();
			
			//String query = "SELECT email FROM caUsuarios WHERE idperfil = '"+perfil+"' AND email != ''";
			
			String query = "SELECT email FROM caUsuarios WHERE idperfil = ANY(STRING_TO_ARRAY('"+ perfil +"',','))";
			
			lista = jdbcTemplate.queryForList(query, String.class);
			
			return lista;
			
		} catch (Exception e) {
			
			throw new Exception("Erro al obtener los correos electronicos.");
			
		}
		
	}

	@Override
	public List<String> getGuiasError() throws Exception {
		
		try {
			
			List<String> lista = new ArrayList<String>();
			
			//String query = "SELECT email FROM caUsuarios WHERE idperfil = '"+perfil+"' AND email != ''";
			
			String query = "SELECT iddocumento FROM cadocumentos LEFT JOIN caunigiserror ON cadocumentos.unigis_status = caunigiserror.estado\r\n"
					+ "WHERE fechacreacion >= (NOW() - INTERVAL '30 min')AND fechacreacion <= NOW()\r\n"
					+ "AND (cadocumentos.unigis_status IS NULL OR cadocumentos.unigis_status <> 1)";
			
			lista = jdbcTemplate.queryForList(query, String.class);
			
			return lista;
			
		} catch (Exception e) {
			 
			throw new Exception("Erro al obtener los correos electronicos.");
			
		}
		
	}
	
}
