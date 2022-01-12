package com.tracusa.logistica.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.tracusa.logistica.model.CasamientoRespuesta;
import com.tracusa.logistica.model.Entrega;
import com.tracusa.logistica.model.RutaRequest;
import com.tracusa.logistica.model.RutaResponse;
import com.tracusa.logistica.interfase.bo.IEntregaBO;

@Controller
@RequestMapping("/rest/entrega")
public class EntregaRestController {

	private static final Logger logger = LoggerFactory.getLogger(EntregaRestController.class);

	@Autowired
	private IEntregaBO iEntregaBO;

	@RequestMapping(value = "/createEntrega", produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody ResponseEntity<String> createEntrega(@RequestBody Entrega obj) {
		
		JsonObject joResult = new JsonObject();
		
		CasamientoRespuesta CasamientoRespuesta = new CasamientoRespuesta();
		 
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try {
			
			logger.info("Start create Entrega.");
			logger.debug("IdGuia:" + obj.getIdguia());
			logger.debug("getEmpleado:" + obj.getEmpleado());
			logger.debug("getLatitud:" + obj.getLatitud());
			logger.debug("obj.getLongitud():" + obj.getLongitud());
			logger.debug("getFecha:" + obj.getFecha());
			logger.debug("getNomRecibe:" + obj.getNomRecibe());
			logger.debug("getNumeroIdentificacion:" + obj.getNumeroIdentificacion());
			logger.debug("getTipoIdentificacion:" + obj.getTipoIdentificacion());
			logger.debug("getOriReg:" + obj.getOriReg());
			logger.debug("getPlaza:" + obj.getPlaza());
			logger.debug("getRuta:" + obj.getRuta());

			if(obj.getTipoGuia().equals("51")){
				
				CasamientoRespuesta = iEntregaBO.insertConfirmacionGuiasManif(obj);
				
			}else{
				
				CasamientoRespuesta = iEntregaBO.insert(obj);
				
			}

		    joResult.addProperty("code", CasamientoRespuesta.getCode());
		    
		    joResult.add("lstErrores", gson.toJsonTree(CasamientoRespuesta.getLstErrores()));
		    
		    return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);
		    
		}catch(Exception e){
			if(e.getMessage() == null){
				joResult.addProperty("code", 400);
				joResult.addProperty("message", "Bad Request");
				return new ResponseEntity<>(joResult.toString(), HttpStatus.BAD_REQUEST);
			}else{
				joResult.addProperty("code", 201);
				joResult.addProperty("message", e.getMessage());
			}
			return new ResponseEntity<>(joResult.toString(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/getRoutes", produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody ResponseEntity<String> getRoutes(@RequestBody RutaRequest ruta) {
		
		JsonObject joResult = new JsonObject();
		
		List<RutaResponse> lstRuta = new ArrayList<>();
		 
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try {
			
			lstRuta = iEntregaBO.getRutas(ruta);
		    
		    joResult.add("lstRoutes", gson.toJsonTree(lstRuta));
		    
		    return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);
		    
		}catch(Exception e){
			if(e.getMessage() == null){
				joResult.addProperty("code", 400);
				joResult.addProperty("message", "Bad Request");
				return new ResponseEntity<>(joResult.toString(), HttpStatus.BAD_REQUEST);
			}else{
				joResult.addProperty("code", 201);
				joResult.addProperty("message", e.getMessage());
			}
			return new ResponseEntity<>(joResult.toString(), HttpStatus.BAD_REQUEST);
		}
	}
}
