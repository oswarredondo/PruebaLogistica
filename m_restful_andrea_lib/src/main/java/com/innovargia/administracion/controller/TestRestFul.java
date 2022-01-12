package com.innovargia.administracion.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.administracion.andrea.dto.ConsultarTracking;
import com.administracion.andrea.dto.GuiaEmbarque;
import com.administracion.andrea.dto.GuiaEmbarqueResponse;
import com.administracion.andrea.dto.Paquete;
import com.administracion.andrea.dto.Tracking;

public class TestRestFul {
	final static String uri = "http://chazam.dyndns.org:22080/restful_wsestafeta/rest/andrea/";

	static String login = "AUT1234567";
	static String pass = "AUT1234567";

	public static void main(String[] args) {
	//	generaEtiqutas();
//		consultaCobertura() ;
		consultaEntrega();
		//cancelar();
	}
	
	public static void cancelar() {

		String uri_final = uri + "cancelarGuiaEmbarque";

		ConsultarTracking consultaTracking = new ConsultarTracking();
		consultaTracking.setUsuario(login);
		consultaTracking.setContrasena(pass);
		consultaTracking.setGuiasEmbarque("000001252");

		RestTemplate restTemplate = new RestTemplate();
		GuiaEmbarqueResponse result = restTemplate.postForObject(uri_final, consultaTracking,
				GuiaEmbarqueResponse.class);
		 System.out.println("Cancelacion:" + result.getCancelarGuiaEmbarqueResult());
		 
		consultaTracking = new ConsultarTracking();
		consultaTracking.setUsuario(login);
		consultaTracking.setContrasena(pass);
		consultaTracking.setGuiasEmbarque("");

		restTemplate = new RestTemplate();
		 result = restTemplate.postForObject(uri_final, consultaTracking,
				GuiaEmbarqueResponse.class);
		
		
		 System.out.println("Cancelacion:" + result.getCancelarGuiaEmbarqueResult());
	}

	public static void consultaEntrega() {

		String uri_final = uri + "consultarTracking";

		ConsultarTracking consultaTracking = new ConsultarTracking();
		consultaTracking.setUsuario(login);
		consultaTracking.setContrasena(pass);
		consultaTracking.setGuiasEmbarque("0000006203,0000006211");

		RestTemplate restTemplate = new RestTemplate();
		GuiaEmbarqueResponse result = restTemplate.postForObject(uri_final, consultaTracking,
				GuiaEmbarqueResponse.class);
		
		 List<Tracking> trackings = result.getLista_trakings();
		 for (Tracking tracking : trackings) {
			 System.out.println("getEstatusGuia():" + tracking.getEstatusGuia());
			 System.out.println("getFechaMovimiento():" + tracking.getFechaMovimiento());
			 System.out.println("getGuiaEmbarque():" + tracking.getGuiaEmbarque());
			 System.out.println("tracking.getIdentificacionID():" + tracking.getIdentificacionID());
			 System.out.println("getObservaciones():" + tracking.getObservaciones());
			 System.out.println("getPersonaRecibio():" + tracking.getPersonaRecibio());
			 System.out.println("getTipoIdentificacion():" + tracking.getTipoIdentificacion());
			 System.out.println("getUbicacion:" + tracking.getUbicacion());
		}
		
		 System.out.println("result tiene cobertura:" + result.isTieneCobetura());
	}

	
	public static void consultaCobertura() {

		String uri_final = uri + "validarCobertura";

		ConsultarTracking consultaTracking = new ConsultarTracking();
		consultaTracking.setUsuario(login);
		consultaTracking.setContrasena(pass);
		consultaTracking.setCodigoPostal("09230");

		RestTemplate restTemplate = new RestTemplate();
		GuiaEmbarqueResponse result = restTemplate.postForObject(uri_final, consultaTracking,
				GuiaEmbarqueResponse.class);
		
		System.out.println("result tiene cobertura:" + result.isTieneCobetura());

	}

	public static void generaEtiqutas() {
		String uri_final = uri + "generarGuiaEmbarque";
		GuiaEmbarque guiaEmbarque = new GuiaEmbarque();
		guiaEmbarque.setUsuario(login);
		guiaEmbarque.setContrasena(pass);
		guiaEmbarque.setFolioOrdenServicio("1234567");

		com.administracion.andrea.dto.DetalleEnvio detalleEnvioDTO = new com.administracion.andrea.dto.DetalleEnvio();
		com.administracion.andrea.dto.Destinatario destino = new com.administracion.andrea.dto.Destinatario();
		destino.setClaveCliente("222222");
		destino.setConvenio("11");
		destino.setNombre("ADRIAN");
		
		destino.setApellidoMaterno("RUARO");
		destino.setApellidoPaterno("MORALES");
		destino.setTelefono("MI TEL");
		destino.setCalle("MISMA CALLE 22");
		destino.setNumero("1234567");
		destino.setEntreCalles("ENTRE CALLE A y B");
		destino.setReferencia("MI REFERENCIA");
		destino.setCodigoPostal("09230");
		destino.setColonia("ZAPATA");
		destino.setCiudad("MEXICO");
		destino.setEstado("MEXICO");
		destino.setPais("MX");

		List<com.administracion.andrea.dto.Paquete> arr_paquetes = new ArrayList<com.administracion.andrea.dto.Paquete>();

		com.administracion.andrea.dto.Paquete paquete = new Paquete();
		
		paquete.setPaqueteID("IIII");
		paquete.setDescripcionMercancia("MI PAQUETE");
		paquete.setCantidad(1);
		
		paquete.setPeso(2.5f);
		paquete.setTipoMercancia("PAQUETE");
		paquete.setValor(1);
		paquete.setVolumen(3.5f);
		arr_paquetes.add(paquete);
		
		 paquete = new Paquete();
			
			paquete.setPaqueteID("22222");
			paquete.setDescripcionMercancia("MI PAQUETE2");
			paquete.setCantidad(1);
			
			paquete.setPeso(3.5f);
			paquete.setTipoMercancia("PAQUETE");
			paquete.setValor(78);
			paquete.setVolumen(3.5f);
			arr_paquetes.add(paquete);
			

		guiaEmbarque.setDetalleEnvio(detalleEnvioDTO);
		guiaEmbarque.setDestinatario(destino);
		guiaEmbarque.setPaquetes(arr_paquetes);
		guiaEmbarque.setReferenciaGuia("MIREFERFENCIA");

		try{
			RestTemplate restTemplate = new RestTemplate();
			GuiaEmbarqueResponse result = restTemplate.postForObject(uri_final, guiaEmbarque, GuiaEmbarqueResponse.class);

			uri_final = uri + "generarEtiquetaGuia";
			
			ConsultarTracking consultaTracking = new ConsultarTracking();
			consultaTracking.setUsuario(login);
			consultaTracking.setContrasena(pass);
			consultaTracking.setGuiasEmbarque(result.getGuiaReferencia());
			System.out.println("result GUIA:" + result.getGuiaReferencia());
			restTemplate = new RestTemplate();
			result = restTemplate.postForObject(uri_final, consultaTracking, GuiaEmbarqueResponse.class);

			System.out.println("result BYTES:" + result.getGenerarEtiquetaGuiaResult());
		}catch(Exception e){
			System.out.println("Error:" + e.getMessage());
		}
		
	}

}
