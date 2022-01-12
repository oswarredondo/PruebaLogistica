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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.tracusa.logistica.model.Caexcepcion;
import com.tracusa.logistica.model.CasamientoRespuesta;
import com.tracusa.logistica.model.Movimiento;
import com.tracusa.logistica.model.MovimientoRespuesta;
import com.tracusa.logistica.interfase.bo.IMovimientoBO;

@Controller
@RequestMapping("/rest/movimiento")
public class MovimientoRestController
{
    private static final Logger logger = LoggerFactory.getLogger(MovimientoRestController.class);
    @Autowired
    private IMovimientoBO iMovimientoBO;

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Movimiento> listAllMembers()
    {
        return null;//memberDao.findAllOrderedByName();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Movimiento lookupMemberById(@PathVariable("id") Long id)
    {
        return null;//memberDao.findById(id);
    }
	
	@RequestMapping(value = "/createcasamiento", produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody ResponseEntity<String> createcasamiento(@RequestBody Movimiento obj) {
		
		JsonObject joResult = new JsonObject();
		
		CasamientoRespuesta CasamientoRespuesta = new CasamientoRespuesta();
		 
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		 
		try{
			
		    logger.info("Start create createcasamiento.");
		    logger.debug("IdGuia:" + obj.getIdguia());
		    logger.debug("tipoMovimiento:" + obj.getTipoMovimiento());
		    logger.debug("ruta:"+ obj.getRuta());
		    logger.debug("fecha:"+ obj.getFecha());
		    logger.debug("oriReg:"+ obj.getOriReg());
		    logger.debug("plaza:"+ obj.getPlaza());
		    logger.debug("empleado:"+ obj.getEmpleado());
		    logger.debug("latitud:"+ obj.getLatitud());
		    logger.debug("longitud:"+ obj.getLongitud());
		    logger.debug("cveLog:"+ obj.getCveLog());
		    logger.debug("guiaCasamiento:"+ obj.getGuiaCasamiento());
		    
		    CasamientoRespuesta = iMovimientoBO.insertCasamiento(obj);

		    joResult.addProperty("code", CasamientoRespuesta.getLstErrores().isEmpty() ? "200" : "201");
		    
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
	 
	 
	 @RequestMapping(value = "/createmovimiento", produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody ResponseEntity<String> createmovimiento(@RequestBody Movimiento obj) {
		
		 JsonObject joResult = new JsonObject();
		 
		 List<MovimientoRespuesta> lstMovimientosRespuesta = new ArrayList<>();
		 
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		 
		try{
			
		    logger.info("Start create createcasamiento.");
		    logger.debug("IdGuia:" + obj.getIdguia());
		    logger.debug("tipoMovimiento:" + obj.getTipoMovimiento());
		    logger.debug("ruta:"+ obj.getRuta());
		    logger.debug("fecha:"+ obj.getFecha());
		    logger.debug("oriReg:"+ obj.getOriReg());
		    logger.debug("plaza:"+ obj.getPlaza());
		    logger.debug("empleado:"+ obj.getEmpleado());
		    logger.debug("latitud:"+ obj.getLatitud());
		    logger.debug("longitud:"+ obj.getLongitud());
		    logger.debug("cveLog:"+ obj.getCveLog());
		    logger.debug("guiaCasamiento:"+ obj.getGuiaCasamiento());
		    logger.debug("tipoGuia:"+ obj.getTipoGuia());
		    
		    lstMovimientosRespuesta = iMovimientoBO.insert(obj);
		    
		    joResult.addProperty("code", lstMovimientosRespuesta.isEmpty() ? "200" : "201");
		    
		    joResult.add("lstGuides", gson.toJsonTree(lstMovimientosRespuesta));
		    
			//joResult.addProperty("message", gson.toJson(lstMovimientosRespuesta));
		    //request = request + Integer.parseInt("cc");
		   // return String.valueOf("{\n \"NextMovement\":" + request + "\n}");			
		    return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);
		   
		}catch(Exception e){
//		    e.printStackTrace();
//		    logger.info(e.getMessage());
//		    return "404 ¬ " + e.getMessage();
			e.printStackTrace();
			//throw new Exception(e.getMessage());
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
	 
	 @RequestMapping(value = "/getExceptions/{movType}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	 public @ResponseBody ResponseEntity<String> viewExceptions(@PathVariable("movType") String movType) {
		
		 JsonObject joResult = new JsonObject();
		 
		try{
		
			List<Caexcepcion> lstExcepciones = iMovimientoBO.select(movType);
			
			//List<Caexcepcion> lstExcepciones = null;
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			gson.toJson(lstExcepciones);
	
		    return new ResponseEntity<>(gson.toJson(lstExcepciones), HttpStatus.OK);
		   
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
