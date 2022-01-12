package com.innovargia.administracion.controller;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.ibo.IDocumentoServicioBO;
import com.administracion.idao.IParamsSistemaDAO;
import com.tracusa.ccp.FacturaCCP;

@Controller
@RequestMapping("/cartaPorte")
public class CartaPorteController {

    @Autowired
    IDocumentoServicioBO iDocumentoServicioBO;

    @Autowired
    IParamsSistemaDAO iParamsSistemaDAO;

    @RequestMapping(value = "/crearCartaPorte", method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Map<String, ? extends Object> crearOrdenesPedido(
	    @RequestParam(value = "viaje", required = true) String viaje,
	    @RequestParam(value = "folio", required = true) String folio, HttpServletRequest request) throws Exception {

	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	CloseableHttpAsyncClient httpClient = HttpAsyncClients.createDefault();

	httpClient.start();

	try {

	    HttpPost httpPost = new HttpPost(iParamsSistemaDAO
		    .getValorPropiedad("ar.com.unisolutions.rest.crearcartaporte.url", "UNIGIS")
		    + iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.rest.crearcartaporte.apikey", "UNIGIS"));

	    JSONObject bodyToSend = new JSONObject();
	    bodyToSend.put("IdViaje", viaje);
	    bodyToSend.put("ReferenciaExterna", folio);

	    StringEntity body = new StringEntity(bodyToSend.toString(), StandardCharsets.UTF_8);

	    body.setContentType(MediaType.APPLICATION_JSON_VALUE);

	    httpPost.setEntity(body);

	    Future<HttpResponse> future = httpClient.execute(httpPost, null);

	    HttpResponse httpResponse = future.get();

	    // httpClient.close();

	    if (httpResponse.getStatusLine().getStatusCode() == 200) {

		modelMap.put("success", true);
		modelMap.put("message", "Creada Correctamente");
		modelMap.put("status", "ok");

	    } else {

		modelMap.put("success", false);
		modelMap.put("message", "Error al consultar viaje");
		modelMap.put("status", "ok");

	    }

	} catch (Exception e) {

	} finally {

	    httpClient.close();

	}

	return modelMap;

    }

    @RequestMapping(value = "/getCCPFacturas", method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Map<String, ? extends Object> crearOrdenesPedido(
	    @RequestParam(value = "viaje", required = false) String viaje, HttpServletRequest request)
	    throws Exception {

	HashMap<String, Object> modelMap = new HashMap<String, Object>();

	List<FacturaCCP> lstFacturas = new ArrayList<FacturaCCP>();

	lstFacturas = iDocumentoServicioBO.getFacturasCCP(viaje);

	modelMap.put("success", true);
	modelMap.put("message", "correcto");
	modelMap.put("totalCount", lstFacturas.size());
	modelMap.put("proxiArray", lstFacturas);

	return modelMap;

    }

}
