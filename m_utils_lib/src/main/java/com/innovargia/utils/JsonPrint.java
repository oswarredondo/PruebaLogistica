package com.innovargia.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//JsonPrint.show
public class JsonPrint {
	private static final Logger logger = LoggerFactory.getLogger(JsonPrint.class);
	public static void show(Object dato){
		
		 String jsonInString = getJson( dato);
		 logger.debug(jsonInString);
		 
	}
	
	public static String getJson(Object dato){
		 ObjectMapper mapper = new ObjectMapper();
		 String jsonInString="";
		try {
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dato);
			
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonInString;
		 
	}
}
