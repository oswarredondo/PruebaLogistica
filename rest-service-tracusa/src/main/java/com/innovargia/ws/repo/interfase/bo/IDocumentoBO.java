package com.innovargia.ws.repo.interfase.bo;

import java.util.List;

import com.innovargia.ws.tracking.rest.dto.ConsultarTrackingRequest;
import com.innovargia.ws.tracking.rest.dto.Envio;

public interface IDocumentoBO {

	
	List<Envio> busquedaArrGuias(ConsultarTrackingRequest request, String tipoDocumento) throws Exception;

}