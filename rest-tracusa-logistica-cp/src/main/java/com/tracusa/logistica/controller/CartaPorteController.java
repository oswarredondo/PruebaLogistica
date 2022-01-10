package com.tracusa.logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tracusa.logistica.interfaces.bo.ICartaPorteBO;
import com.tracusa.logistica.interfaces.bo.IUserKeyBO;
import com.tracusa.logistica.model.DetalleFactura;
import com.tracusa.logistica.model.SapResult;
import com.tracusa.logistica.model.UserKey;
import com.tracusa.logistica.model.ViajeFinCarga;
import com.tracusa.logistica.unigis.ccp.UnigisCCP;

@Controller
@RequestMapping("/tracusa/logistica")
public class CartaPorteController {

    @Autowired
    IUserKeyBO iUserKeyBO;

    @Autowired
    ICartaPorteBO iCartaPorteBO;

    @PostMapping(value = "/putConsignmentNote", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> putConsignmentNote(@RequestBody ViajeFinCarga viaje,
	    @RequestParam(name = "key", required = true) String apikey) throws Exception {

	JsonObject joResult = new JsonObject();

	UnigisCCP unigisccp = null;

	// Valida el acceso a la API
	UserKey userKe = iUserKeyBO.getUserKey("Basic " + apikey);

	unigisccp = iCartaPorteBO.getRestViaje(viaje);

	List<SapResult> lstResult = iCartaPorteBO.getFacturaSap(unigisccp);

	joResult.addProperty("code", 200);
	joResult.addProperty("message", "Cartas porte generadas.");
	joResult.add("Facturas", new Gson().toJsonTree(lstResult));

	return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);

    }

    @PostMapping(value = "/sendFilesLO", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getShipmentsByDates(
	    @RequestHeader(required = false, value = "Authorization") String apiKeyHeader,
	    @RequestBody DetalleFactura detalleFactura) {

	JsonObject joResult = new JsonObject();

	try {

	    // Valida el acceso a la API
	    UserKey userKe = iUserKeyBO.getUserKey(apiKeyHeader);

	    int updateViaje = iCartaPorteBO.updateStatus(detalleFactura);

	    if (updateViaje != 1) {

		throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
			"Error in update travel status, code [" + updateViaje + "]");

	    }

	    if (!detalleFactura.getPdf().trim().equals("")) {

		int creaDocumentro = iCartaPorteBO.crearDocumentos(detalleFactura);

		int modificarViaje = 0;

		if (creaDocumentro == 1) {

		    modificarViaje = iCartaPorteBO.modificarViajeConParadas(detalleFactura);

		    if (modificarViaje == 1) {

			iCartaPorteBO.timbrarMarcaFactura(detalleFactura);

		    }
		}

		joResult.addProperty("code", 200);
		joResult.addProperty("message", "OK");
		joResult.addProperty("creacionDocumento", creaDocumentro);
		joResult.addProperty("modificarViaje", modificarViaje);

	    } else {

		iCartaPorteBO.timbrarMarcaFactura(detalleFactura);

		joResult.addProperty("code", 201);
		joResult.addProperty("message", detalleFactura.getMensaje());
	    }

	    return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);

	} catch (Exception e) {

	    e.printStackTrace();
	    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

	}
    }

}