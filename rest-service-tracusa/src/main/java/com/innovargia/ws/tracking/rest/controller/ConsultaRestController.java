
package com.innovargia.ws.tracking.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovargia.model.RequestTracking;
import com.innovargia.model.ResponseTracking;
import com.innovargia.model.ResponseTrackingSign;
import com.innovargia.ws.tracking.rest.utils.Constantes;
import com.innovargia.ws.tracking.rest.utils.ExceptionTracking;

@Controller
@RequestMapping("/rest/")
public class ConsultaRestController {

	private static final Logger logger = LoggerFactory.getLogger(ConsultaRestController.class);

	@Autowired
	com.innovargia.ws.repo.interfase.bo.ITrackingBO iTrackingBO;

	@RequestMapping(value = "consultarTracking", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ResponseTracking consultarTracking(@RequestBody RequestTracking request) {
		ResponseTracking response = new ResponseTracking();
		logger.debug("consultaTracking");
		if (request.getUsuario() == null || request.getNumcliente()==null || request.getContrasena()==null ) {
			response.setCodigo(Constantes.CODIGO_ACCESOINVALIDO);
			response.setMensaje(Constantes.ACCESOINVALIDO_MSG);
			
		}else{
			try {
				response=  iTrackingBO.tracking(request);
			} catch (ExceptionTracking e) {
				logger.debug("Error al ejecutar tracking:" + e.getMessage() );
				response.setCodigo(e.getCodigo());
				response.setMensaje(e.getMessage());
				
			} catch (Exception e) {
				logger.debug("Error al ejecutar tracking:" + e.getMessage() );
				response.setCodigo(Constantes.CODIGO_ERROR_SISTEMA);
				response.setMensaje(Constantes.MSG_ERROR_SERVIDOR);
			}
		}

		
		return response;
	}

	@RequestMapping(value = "consultarFirma", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody ResponseTrackingSign consultarFirma(@RequestBody RequestTracking request) {
		ResponseTrackingSign response = new ResponseTrackingSign();
		logger.debug("consultaTracking");
		if (request.getUsuario() == null || request.getNumcliente()==null || request.getContrasena()==null ) {
			response.setCodigo(Constantes.CODIGO_ACCESOINVALIDO);
			response.setMensaje(Constantes.ACCESOINVALIDO_MSG);
			
		}else{
			try {
				response=  iTrackingBO.sign(request);
			} catch (ExceptionTracking e) {
				logger.debug("Error al ejecutar tracking:" + e.getMessage() );
				response.setCodigo(e.getCodigo());
				response.setMensaje(e.getMessage());
				
			} catch (Exception e) {
				logger.debug("Error al ejecutar tracking:" + e.getMessage() );
				response.setCodigo(Constantes.CODIGO_ERROR_SISTEMA);
				response.setMensaje(Constantes.MSG_ERROR_SERVIDOR);
			}
		}

		
		return response;
	}
}
