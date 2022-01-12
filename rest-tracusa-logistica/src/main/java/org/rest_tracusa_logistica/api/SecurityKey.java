package org.rest_tracusa_logistica.api;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.util.Base64;
import org.rest_tracusa_logistica.controller.UserKeyController;
import org.rest_tracusa_logistica.struct.UserKey;

import com.google.gson.JsonObject;

public class SecurityKey {
	
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final JsonObject joResult = new JsonObject();
	
	public UserKey filter(String apiKeyHeader) throws Exception {
		if(apiKeyHeader != null && apiKeyHeader.length() > 0) {
			String authHeader = apiKeyHeader.trim();
			if(authHeader.contains(AUTHORIZATION_HEADER_PREFIX)){
				authHeader = authHeader.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodedString = Base64.decodeAsString(authHeader);
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				
				UserKeyController  sfcontroller;
				try {
					sfcontroller = new UserKeyController();
					UserKey userKey = sfcontroller.getUserKey(apiKeyHeader);
					if(userKey.getUser().equals(username) && userKey.getPassword().equals(password)) {
						return userKey; //Validar Cliente a BD con ApiKey
					}
				} catch (Exception e) {
					joResult.addProperty("code", 401);
					joResult.addProperty("message", "User cannot access the resource.");
				}
			}else{
				joResult.addProperty("code", 402);
				joResult.addProperty("message", "Unable to access the requested resource, authorization failed.");
			}
		}else{
			joResult.addProperty("code", 401);
			joResult.addProperty("message", "User cannot access the resource.");
		}
		
		/*Response unauthorizedStatus = Response
				.status(Response.Status.UNAUTHORIZED)
				.entity(joResult.toString())
				.build();*/
		
		//throw new Exception(unauthorizedStatus.getEntity().toString());
		throw new Exception(joResult.toString());
	}

}
