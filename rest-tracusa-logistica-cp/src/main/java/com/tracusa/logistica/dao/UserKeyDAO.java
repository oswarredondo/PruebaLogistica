package com.tracusa.logistica.dao;

import java.util.StringTokenizer;

import javax.sql.DataSource;

import org.glassfish.jersey.internal.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.google.gson.JsonObject;
import com.tracusa.logistica.interfaces.dao.IUserKeyDAO;
import com.tracusa.logistica.model.UserKey;
import com.tracusa.logistica.rowmapper.UserKeyRowMapper;

@Repository
public class UserKeyDAO extends JdbcDaoSupport implements IUserKeyDAO {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	
	@Autowired
	public UserKeyDAO(DataSource dataSource) {

		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}
	
	@Override
	public UserKey getUserKey(String key) throws Exception {
		
		JsonObject joResult = new JsonObject();
		
		UserKey userKey = new UserKey();
		
		try {
					
			String query = "SELECT * FROM userkey WHERE apiKey = ?";
			
		    userKey = this.jdbcTemplate.queryForObject(query, new Object[]{key}, new UserKeyRowMapper());
		    
			userKey.setApikey(userKey.getApikey().replaceFirst(AUTHORIZATION_HEADER_PREFIX, ""));
			
			String decodedString = Base64.decodeAsString(userKey.getApikey());
			
			StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
			
			userKey.setUser(tokenizer.nextToken());
			
			userKey.setPassword(tokenizer.nextToken());
			
			return userKey;
			
	    }catch(EmptyResultDataAccessException e) {
	    	
	        throw new ResponseStatusException( HttpStatus.UNAUTHORIZED, "Unable to access the requested resource, authorization failed[No User Registred]");
	        
	    }

	}

}