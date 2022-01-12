package com.tracusa.logistica.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.ibo.IParamsSistemaBO;
import com.tracusa.logistica.model.FirmaFoto;
import com.tracusa.logistica.interfase.bo.IFirmaFotoBO;
import com.servicio.constantes.ConstantesGenerales;

@Controller
@RequestMapping("/rest/firmafoto")
public class FirmaFotoRestController
{
    
    private static final Logger logger = LoggerFactory.getLogger(EntregaRestController.class);
    
    @Autowired
    private IFirmaFotoBO iFirmaFotoBO;
    
    
    IParamsSistemaBO iParamsSistemaBO;
    
    @RequestMapping(value = "/create")
    public @ResponseBody String createEmployee(@RequestBody FirmaFoto obj) {
	
	try{
	    logger.debug("Start create Firma/Foto.");
	    logger.debug("IdGuia:" + obj.getIdguia());
	    logger.debug("getIdtipodocumento:" + obj.getIdtipodocumento());
	    logger.debug("obj.getLatitud():"+ obj.getLatitud());
	    logger.debug("obj.getLongitud():"+ obj.getLongitud());
	    logger.debug("getNota:"+ obj.getNota());
	    long  largo = obj.getImaBase64()!=null?obj.getImaBase64().length():0;
	    logger.debug("obj.getImaBase64:"+ largo);
	    
	    iFirmaFotoBO.insert(obj);
	    
	    //Manda la info al WS de Telcel 
	    String cliente_telcel = iParamsSistemaBO.getValorPropiedad(
			"cliente.telcel",ConstantesGenerales.ID_SKY4SOL);

	    if (cliente_telcel!=null){
		
	    }else{
		 logger.debug("cliente.telcel no esta configurado o no tiene valor asignado.");
	    }
		
	}catch(Exception e){
	     e.printStackTrace();
	    logger.info(e.getMessage());
	}     
        return null;
    } 
    

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody List<FirmaFoto> listAllMembers()
    {
        return null;//memberDao.findAllOrderedByName();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody FirmaFoto lookupMemberById(@PathVariable("id") Long id)
    {
        return null;//memberDao.findById(id);
    }
}
