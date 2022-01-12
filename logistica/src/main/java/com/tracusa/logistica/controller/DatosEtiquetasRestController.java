package com.tracusa.logistica.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tracusa.logistica.model.DatosEtiqueta;
import com.tracusa.logistica.model.Entrega;
import com.tracusa.logistica.interfase.bo.IDatosEtiquetaBO;

@Controller
@RequestMapping("/rest/datosetiqueta")
public class DatosEtiquetasRestController{
    
    private static final Logger logger = LoggerFactory.getLogger(DatosEtiquetasRestController.class);
    
    @Autowired
    private IDatosEtiquetaBO iDatosEtiquetaBO;
   

    @RequestMapping(value = "/insert")
    public @ResponseBody String insert(@RequestBody DatosEtiqueta obj) {
	
	String response_str= "OK";
	try{
	    logger.info("Datos Entrega:" + obj);
	    
	    iDatosEtiquetaBO.insert(obj);
	   
	}catch(Exception e){
	     e.printStackTrace();
	    logger.info(e.getMessage());
	    response_str = e.getMessage();
	}
        return response_str;
    } 
    
    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<Entrega> listAllMembers()
    {
	List<Entrega> lista = new ArrayList<Entrega>();
        return lista; //memberDao.findAllOrderedByName();
    }
    
 
}
