package com.tracusa.logistica.controller;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

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
import com.tracusa.logistica.model.RegistroDto;
import com.ws.interchange.InterchangeInfoService;
import com.ws.interchange.InterchangeSEI;
import com.tracusa.logistica.interfase.bo.IMovimientoBO;


/**
 * /rest/registro/create
 * @author aruaro
 *
 */

@Controller
@RequestMapping("/rest/registro")
public class RegistrosWSInterchangeRestController {
	
	private final QName SERVICE_NAME = new QName("http://interchange.ws.com/", "InterchangeInfoService");

	private static final Logger logger = LoggerFactory.getLogger(RegistrosWSInterchangeRestController.class);
	@Autowired
	private IMovimientoBO iMovimientoBO;

	IParamsSistemaBO  iParamsSistemaBO;
	

    @RequestMapping(value = "/create")
    public @ResponseBody String createEmployee(@RequestBody RegistroDto registros) {

		try {
			
			if (registros.getLista().size()<=0){
				throw new Exception("Lista vacia. No existen registros que procesar" );
			}
			String llavetransmision="";

			try{
				String endpoint = iParamsSistemaBO.getValorPropiedad(
						"endpoint.infointerchange", "RESTFUL"
						);   
				if ((endpoint == null) || (endpoint.trim().length() <= 0)) {
					throw new Exception("NO ESTA CONFIGURADO EL PARAMETRO "
							+ "endpoint.infointerchange" );
				}

				String urlws = endpoint;
				URL wsdlURL = null;
				try {
					wsdlURL = new URL(urlws);
				} catch (MalformedURLException e) {
					logger.debug("No se puede inicializar wsdl de " + urlws);
					throw new Exception("No se puede inicializar wsdl de " + urlws);

				}

				InterchangeInfoService ss = new InterchangeInfoService(wsdlURL,
						SERVICE_NAME);
				InterchangeSEI port = ss.getInterchangeInfoPort();

				logger.debug("Invoking procesa...");
				java.util.List<java.lang.String> ris = new java.util.ArrayList<java.lang.String>();
				for (RegistroDto registro : registros.getLista()) {
					ris.add(registro.getRi());
				}

				java.util.List<java.lang.String> configuracion = new java.util.ArrayList<java.lang.String>();
				configuracion.add("REST");
				configuracion.add("RESTFUL");
				configuracion.add("0000");
				configuracion.add("restful.ws");
				configuracion.add("TRANSPORTE");

				java.util.List<java.lang.String> _procesa__return = port.procesa(ris, configuracion);
						
						
				logger.debug("procesa.result=" + _procesa__return);

				
				
			}catch(Exception e){
				logger.debug("Error en la replica de la informacion " + e.getMessage());
				logger.debug("Se activaton nuevamente los registros para transmision con llave " + llavetransmision);
			}
			
			 return "00";

		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}
		return null;
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody String lookupMemberById(@PathVariable("id") Long id)
    {
    	logger.debug(id +"");
    	return "AQUI";
    }
}
