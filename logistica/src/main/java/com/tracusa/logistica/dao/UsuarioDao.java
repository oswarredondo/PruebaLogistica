package com.tracusa.logistica.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.tracusa.logistica.model.Usuario;
import com.tracusa.logistica.interfase.dao.IUsuarioDao;


@Repository
public class UsuarioDao extends JdbcDaoSupport implements IUsuarioDao{

	private static final Logger logger = LoggerFactory.getLogger(UsuarioDao.class);
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UsuarioDao(DataSource dataSource) throws NamingException, SQLException {

		InitialContext ic = new InitialContext();
		
		Context xmlContext = (Context) ic.lookup("java:comp/env");

		dataSource = (DataSource) xmlContext.lookup("jdbc/RestFulAndroid");

		Connection con = dataSource.getConnection();

		con.close();
		
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}
	
	@Override
	public int insert(Usuario usuario) throws Exception {
		
		int isInserted = 0;
		
		try {
		
		String query = "SELECT COUNT(login) AS aux FROM causuario WHERE login = '"+ usuario.getUserName() +"';";
		
		SqlRowSet set = jdbcTemplate.queryForRowSet(query);

		while(set.next()){
			
			isInserted = set.getInt("aux");
			
		}
		
		if(isInserted == 0){
			
			query = "INSERT INTO causuario VALUES (:login,crypt(:password, gen_salt('bf')),'','','','','','','','A','','','','TRACUSA','','F','','1','e','all',:numEmpleado,:telefono)";
			
			MapSqlParameterSource params  = new MapSqlParameterSource();
			
			params.addValue("login", usuario.getUserName());
			params.addValue("password", usuario.getPassword());
			params.addValue("numEmpleado", usuario.getEmployeedNumber());
			params.addValue("telefono", usuario.getPhone());
			
			this.namedParameterJdbcTemplate.update(query, params);
			
		}
	
		} catch (DataAccessException dae) {
			
			logger.debug("error insert:" + dae.getMessage());
			
			throw new Exception(dae.getMessage());
			
		}
		
		return isInserted;
		
	}

	@Override
	public void changePassword(Usuario usuario) throws Exception {
		
		try {
		
			
			String query = "UPDATE causuario SET password = crypt(:password, gen_salt('bf')) WHERE login =:login AND telefono =:telefono AND empleado =:numEmpleado;";
			
			MapSqlParameterSource params  = new MapSqlParameterSource();
			
			params.addValue("login", usuario.getUserName());
			params.addValue("password", usuario.getPassword());
			params.addValue("telefono", usuario.getPhone());
			params.addValue("numEmpleado", usuario.getEmployeedNumber());
			
			this.namedParameterJdbcTemplate.update(query, params);
			
	
		} catch (DataAccessException dae) {
			
			logger.debug("error insert:" + dae.getMessage());
			
			throw new Exception(dae.getMessage());
			
		}
		
	}

	@Override
	public List<Usuario> login(Usuario usuario) throws Exception {
		
		List<Usuario> lstUsuarios = new ArrayList<Usuario>();
		
		Usuario dbUsuario;
		
		String query;
		
		try {
			
			query = "SELECT * FROM causuario WHERE login = '" + usuario.getUserName() + "' AND password = crypt('"+ usuario.getPassword() +"', password);";
			
			SqlRowSet set = jdbcTemplate.queryForRowSet(query);

			while(set.next()){
				
				dbUsuario = new Usuario();
				
				dbUsuario.setUserName(set.getString("login"));
				dbUsuario.setEmployeedNumber(set.getString("empleado"));
				dbUsuario.setPhone(set.getString("telefono"));
				
				lstUsuarios.add(dbUsuario);
				
			}
			
		} catch (DataAccessException dae) {
			
			logger.debug("error login:" + dae.getMessage());
			
			throw new Exception(dae.getMessage());
			
		}
		
		return lstUsuarios;
	}

}
