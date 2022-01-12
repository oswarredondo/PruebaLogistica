package com.tracusa.logistica.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tracusa.logistica.model.RutaUbicacion;
import com.tracusa.logistica.interfase.bo.IRutaUbicacionBO;
import com.tracusa.logistica.interfase.bo.IRutaUbicacionTemperaturaBO;

@Controller
@RequestMapping("/rest/rutaubicacion")
public class RutaUbicacionRestController{
    
    private static final Logger logger = LoggerFactory.getLogger(RutaUbicacionRestController.class);
    
    @Autowired
    private IRutaUbicacionBO iRutaUbicacionBO;

    @Autowired
    private IRutaUbicacionTemperaturaBO iRutaUbicacionTemperaturaBO;
    
    @RequestMapping(value = "/create_rutaubicacion")
    public @ResponseBody String createRutaUbicacion(@RequestBody RutaUbicacion obj) {
	
	try{
	    logger.info("Creando Registro create_rutaubicacion.");
	    iRutaUbicacionBO.insert(obj);
	    
	   
	}catch(Exception e){
	     e.printStackTrace();
	    logger.info(e.getMessage());
	}
        return null;
    } 
    
    
    @RequestMapping(value = "/create_rutaubicacion_temperatura")
    public @ResponseBody String createRutaUbicacionTemperatura(@RequestBody RutaUbicacion obj) {
	
	try{
	    logger.info("Creando Registro create_rutaubicacion.");
	    iRutaUbicacionTemperaturaBO.insert(obj);
	    
	   
	}catch(Exception e){
	     e.printStackTrace();
	    logger.info(e.getMessage());
	}
        return null;
    } 
  
}
