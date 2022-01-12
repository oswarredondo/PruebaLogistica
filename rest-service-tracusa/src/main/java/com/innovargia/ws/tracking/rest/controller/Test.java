package com.innovargia.ws.tracking.rest.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.client.RestTemplate;

import com.innovargia.ws.tracking.rest.dto.ConsultaResponse;
import com.innovargia.ws.tracking.rest.dto.ConsultarTrackingRequest;
import com.innovargia.ws.tracking.rest.dto.Envio;

public class Test {

	public static void main(String[] args) {
		String url = "http://localhost:8980/ws-tracking-rest/rest/innovargia/consultarTracking";
		RestTemplate restTemplate = new RestTemplate();
		ConsultarTrackingRequest request = new ConsultarTrackingRequest();
		
		request.setTipobusqueda(1);
		request.setUsuario("PROYECTOCARSO");
		request.setPassword("PROYECTOTELCEL");
		request.setCliente("1115");
		request.setGuias("0011115D000351717");
		request.setReferencia("1234567");
		ConsultaResponse result = restTemplate.postForObject(url, request,
				ConsultaResponse.class);
		
		
		Base64 b = new Base64();
		byte[] imageBytes ;
		String pathnamefile;
		for (Envio envio : result.getEnvios()) {
			if (envio.getEntrega()!=null && envio.getEntrega().getFirma()!=null && 
					envio.getEntrega().getFirma().getImaBase64()!=null){
				imageBytes = b.decode(envio.getEntrega().getFirma().getImaBase64());
				pathnamefile = "/tmp/" + envio.getEntrega().getFirma().getIdfirma();
				FileOutputStream fos;
				try {
					fos = new FileOutputStream(pathnamefile);
					fos.write(imageBytes);
					fos.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
	
		
		System.out.println("acabe");
		
		 

	}

}
