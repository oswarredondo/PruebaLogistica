package com.tracusa.logistica.bo;

import java.util.StringTokenizer;

import org.glassfish.jersey.internal.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.tracusa.logistica.interfaces.bo.IUserKeyBO;
import com.tracusa.logistica.interfaces.dao.IUserKeyDAO;
import com.tracusa.logistica.model.UserKey;

@Service
public class UserKeyBO implements IUserKeyBO{

	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	
	@Autowired
	IUserKeyDAO iUserKeyDAO;
	
	@Override
	public UserKey getUserKey(String apiKeyHeader) throws Exception {
		
		UserKey userKey;
		
		if (apiKeyHeader != null && apiKeyHeader.length() > 0) {
			
			String authHeader = apiKeyHeader.trim();
			
			if (authHeader.contains(AUTHORIZATION_HEADER_PREFIX)) {
				
				authHeader = authHeader.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				
				String decodedString = Base64.decodeAsString(authHeader);
				
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();

				try {
					
					userKey = iUserKeyDAO.getUserKey(apiKeyHeader);
					
					if (!userKey.getUser().equals(username) && !userKey.getPassword().equals(password)) {
						
						throw new ResponseStatusException( HttpStatus.FORBIDDEN, "User cannot access the resource.");
						
					}
					
				} catch (Exception e) {
					
					throw new ResponseStatusException( HttpStatus.UNAUTHORIZED, "Unable to access the requested resource, authorization failed");
			        
				}
				
			} else {
				
				 throw new ResponseStatusException( HttpStatus.UNAUTHORIZED, "Unable to access the requested resource, authorization failed[Bad ApiKey Format]");
				
			}
			
		} else {
			
			throw new ResponseStatusException( HttpStatus.UNAUTHORIZED, "Unable to access the requested resource, authorization failed[No Apikey]");
			
		}
		
		return userKey;
	}
	
}
