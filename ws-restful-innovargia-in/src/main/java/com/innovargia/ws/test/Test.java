package com.innovargia.ws.test;

import org.springframework.web.client.RestTemplate;

import com.innovargia.ws.dto.RegistroDto;
import com.innovargia.ws.dto.Seguimiento;
import com.innovargia.ws.dto.SeguimientoJSON;

public class Test {
	final static String uri = "http://localhost:8089/ws-restful-innovargia-in/rest/mq/";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listaMovimientos();
	}
	
	
	public static void consumer() {

		String uri_final = uri + "consumer";
	}
	
	
	public static void producer() {

		String uri_final = uri + "producer_seguimiento";
		SeguimientoJSON seg_json = new SeguimientoJSON();
		
		Seguimiento seg = new Seguimiento();
		seg.setIdEnvio("0000000000001");
		
		seg_json.setSeguimiento(seg);

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.postForObject(uri_final, seg,
				String.class);
		 System.out.println("Consulta:" + result);
	}
	
	
	public static void listaMovimientos() {

		String uri_final = "http://localhost:8080/ws-restful-innovargia-in/rest/registro/create";
		
		RegistroDto registro = new RegistroDto();
		RegistroDto temp = new RegistroDto();
		for (int i=0;i<10;i++){
			temp = new RegistroDto();
			temp.setRi("20|0010011010D000000691" + i +"|1111111||201309021230|MEX|MEX|11111111111" + i);
			registro.getLista().add(temp);
		}
		
	
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.postForObject(uri_final, registro,
				String.class);
		 System.out.println("Consulta:" + result);
	}

}
