package org.rest_tracusa_logistica.db;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

import org.castor.util.Base64Decoder;
import org.glassfish.jersey.internal.util.Base64;
import org.rest_tracusa_logistica.struct.UserKey;

public class UserKeyDB {
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	
	public static UserKey getUserKeyDB(String key, Connect conn) throws Exception{
		UserKey userKey;
		
		try{
			userKey = new UserKey();
			conn.initDbConnection();
			ResultSet rsKey = conn.select("SELECT * FROM userkey WHERE apiKey = '" + key + "';");
			String apiKey = "";
			
			while(rsKey.next()){
				apiKey = rsKey.getString("apiKey");
				userKey.setIdUserKey(Integer.parseInt(rsKey.getString("idUserKey").toString()));
				userKey.setIdClient(rsKey.getString("numCliente"));
				userKey.setLogin(rsKey.getString("login"));
				userKey.setApiKey(rsKey.getString("apiKey"));
				userKey.setEstatus(rsKey.getString("estatus"));
				userKey.setProrroga(rsKey.getString("prorroga"));
			}
			apiKey = apiKey.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			String decodedString = Base64.decodeAsString(apiKey);
			StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
			userKey.setUser(tokenizer.nextToken());
			userKey.setPassword(tokenizer.nextToken());
			
			return userKey;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}finally {
			conn.cerrarConexion();
		}
	}
}
