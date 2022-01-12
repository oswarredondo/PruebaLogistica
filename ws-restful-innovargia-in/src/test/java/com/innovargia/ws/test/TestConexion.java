package com.innovargia.ws.test;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.client.RestTemplate;

import com.innovargia.ws.test.DatosEtiqueta;
import com.innovargia.ws.test.Direccion;
import com.innovargia.ws.dto.Entrega;
import com.innovargia.ws.dto.FirmaFoto;
import com.innovargia.ws.dto.Movimiento;

public class TestConexion {

    //static String server = "http://chazam.dyndns.org:24080";

    static String server = "http://localhost:8089";
   

    public static void main(String args[]) {
	//entrega(); 
	//datosetiquetas();
	//casamiento();
	//movimiento();
	datosetiquetasexcel();
    }
    
    private static void datosetiquetasexcel() {
	 RestTemplate restTemplate = new RestTemplate();
	try {

	    DatosEtiqueta movimi = new DatosEtiqueta();
	   Direccion remitente = new Direccion();
	   Direccion destinatario = new Direccion();
	   
	
	 movimi.setContenido("CONTENIDO");
	 movimi.setObservacion("OBSERVACION");
	 movimi.setReferencia("");
	 
	remitente.setRazonsocial("REMITENTE ");
	remitente.setContacto("REMITENTE  contacto");
	remitente.setRfc("REMITENTErfc");
	remitente.setCalle("REMITENTE calle");
	remitente.setCelular("REMITENTE celular");
	remitente.setCiudad("REMITENTE ciudad");
	remitente.setColonia("REMITENTE colonia");
	remitente.setCp("09233");
	remitente.setEmail("REMITENTE email");
	remitente.setEstado("REMITENTE estado");
	remitente.setMunicipio("REMITENTE municipio");
	remitente.setNumexterior("REMITENTE numexterior");
	remitente.setNuminterior("REMITENTE numinterior");
	remitente.setTelefono("REMITENTE telefono");
	
	destinatario.setRazonsocial("DESTINATARIO ");
	destinatario.setContacto("DESTINATARIO  contacto");
	destinatario.setRfc("DESTINATARIORFC");
	destinatario.setCalle("DESTINATARIO calle");
	destinatario.setCelular("DESTINATARIO celular");
	destinatario.setCiudad("DESTINATARIO ciudad");
	destinatario.setColonia("DESTINATARIO colonia");
	destinatario.setCp("09230");
	destinatario.setEmail("DESTINATARIO email");
	destinatario.setEstado("DESTINATARIO estado");
	destinatario.setMunicipio("DESTINATARIO municipio");
	destinatario.setNumexterior("DESTINATARIO numexterior");
	destinatario.setNuminterior("DESTINATARIO numinterior");
	destinatario.setTelefono("DESTINATARIO telefono");
	 
	movimi.setRemitente(remitente);
	movimi.setDestinatario(destinatario);

	String response = restTemplate.postForObject(server
		    + "/ws-restful-innovargia-in/rest/datosetiqueta/insert", movimi,
		    String.class);
	  System.out.println("TERMINE:" + response);
	  
	  
	  
	  
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	}

    }

   /* private static void datosetiquetas() {
 	 RestTemplate restTemplate = new RestTemplate();
 	try {

 	    DatosEtiqueta movimi = new DatosEtiqueta();
 	   Direccion remitente = new Direccion();
 	   Direccion destinatario = new Direccion();
 	   
 	 movimi.setAlto(1);
 	 movimi.setAncho(1);
 	 movimi.setLargo(1);
 	 movimi.setContenido("CONTENIDO");
 	 movimi.setEs_multiple("NO");  
 	 movimi.setEs_ocurre("NO");
 	 movimi.setNacional("NACIONAL");
 	 movimi.setNumpiezas(1);
 	 movimi.setObservacion("OBSERVACION");
 	 movimi.setPesofisico(1);
 	 movimi.setTiene_seguro("NO");
 	 movimi.setValor_asegurado(0);
 	 movimi.setValordeclarado(0);
 	 
 	remitente.setRazonsocial("REMITENTE ");
 	remitente.setContacto("REMITENTE  contacto");
 	remitente.setRfc("REMITENTErfc");
 	remitente.setCalle("REMITENTE calle");
 	remitente.setCelular("REMITENTE celular");
 	remitente.setCiudad("REMITENTE ciudad");
 	remitente.setColonia("REMITENTE colonia");
 	remitente.setCp("09233");
 	remitente.setEmail("REMITENTE email");
 	remitente.setEstado("REMITENTE estado");
 	remitente.setMunicipio("REMITENTE municipio");
 	remitente.setNumexterior("REMITENTE numexterior");
 	remitente.setNuminterior("REMITENTE numinterior");
 	remitente.setTelefono("REMITENTE telefono");
 	
 	destinatario.setRazonsocial("DESTINATARIO ");
 	destinatario.setContacto("DESTINATARIO  contacto");
 	destinatario.setRfc("DESTINATARIORFC");
 	destinatario.setCalle("DESTINATARIO calle");
 	destinatario.setCelular("DESTINATARIO celular");
 	destinatario.setCiudad("DESTINATARIO ciudad");
 	destinatario.setColonia("DESTINATARIO colonia");
 	destinatario.setCp("09230");
 	destinatario.setEmail("DESTINATARIO email");
 	destinatario.setEstado("DESTINATARIO estado");
 	destinatario.setMunicipio("DESTINATARIO municipio");
 	destinatario.setNumexterior("DESTINATARIO numexterior");
 	destinatario.setNuminterior("DESTINATARIO numinterior");
 	destinatario.setTelefono("DESTINATARIO telefono");
 	 
 	movimi.setRemitente(remitente);
 	movimi.setDestinatario(destinatario);

 	String response = restTemplate.postForObject(server
 		    + "/ws-restful-innovargia-in/rest/datosetiqueta/insert", movimi,
 		    String.class);
 	  System.out.println("TERMINE:" + response);
 	  
 	  
 	  
 	  
 	} catch (Exception e) {
 	    System.out.println(e.getMessage());
 	    e.printStackTrace();
 	}

     }*/
    private static void casamiento() {
  	 RestTemplate restTemplate = new RestTemplate();
  	try {

  	    Movimiento movimi = new Movimiento();
  	    movimi.setTipoMovimiento("04");
  	    movimi.setIdguia("0000000000000004\n0000000000000005\n0000000000000006\n0000000000000007");
  	    movimi.setEmpleado("123456789");
  	    movimi.setFecha("2015-03-28 00:00:00");
  	    movimi.setLatitud("0");
  	    movimi.setLongitud("0");
  	    movimi.setGuiaCasamiento("CASAMIENTO1");
  	    movimi.setOriReg("MEX");
  	    movimi.setPlaza("MEX");
  	    movimi.setRuta("ANDROID");
  	  movimi.setGuiaCasamiento("CASAMIENTO1");

  	    String response = restTemplate.postForObject(server
  		    + "/ws-restful-innovargia-in/rest/movimiento/createcasamiento", movimi,
  		    String.class);
  	  System.out.println("TERMINE");
  	  
  	  
  	  
  	  
  	} catch (Exception e) {
  	    System.out.println(e.getMessage());
  	    e.printStackTrace();
  	}

      }
    
    private static void movimiento() {
	 RestTemplate restTemplate = new RestTemplate();
	try {

	    Movimiento movimi = new Movimiento();
	    movimi.setTipoMovimiento("04");
	    movimi.setIdguia("0000000000000005\n0000000000000006\n0000000000000002\n0000000000000007");
	    movimi.setEmpleado("123456789");
	    movimi.setFecha("2015-03-28 00:00:00");
	    movimi.setLatitud("0");
	    movimi.setLongitud("0");
	    movimi.setGuiaCasamiento("CASAMIENTO1");
	    movimi.setOriReg("MEX");
	    movimi.setPlaza("MEX");
	    movimi.setRuta("ANDROID");

	    System.out.println();
	    String response = restTemplate.postForObject(server
		    + "/ws-restful-innovargia-in/rest/movimiento/createmovimiento", movimi,
		    String.class);

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	}

    }

    private static void entrega() {
	 RestTemplate restTemplate = new RestTemplate();
	try {

	    Entrega entrega = new Entrega();
	    entrega.setIdguia("0000000000000000\n0000000000000001");
	    entrega.setEmpleado("123456789");
	    entrega.setFecha("2015-03-28 00:00:00");
	    //entrega.setImaBase64(ImagenBase46Test.imagen64);
	    entrega.setLatitud("0");
	    entrega.setLongitud("0");
	    entrega.setNomRecibe("PRUEBA ADRIAN ANDROID");
	    entrega.setOriReg("MEX");
	    entrega.setPlaza("MEX");
	    entrega.setRuta("ANDROID");

	    System.out.println();
	    String response = restTemplate.postForObject(server
		    + "/ws-restful-innovargia-in/rest/entrega/create", entrega,
		    String.class);
	    FirmaFoto foto = new FirmaFoto();
	    /*
	     * foto.setIdguia(
	     * "0000000000000000\n0000000000000001\n0000000000000002\n0000000000000003"
	     * ); foto.setIdtipodocumento("ETIQU");
	     * foto.setImaBase64(ImagenBase46Test.imagen64);
	     * foto.setLatitud("0"); foto.setLongitud("0");
	     * foto.setNota("NOTA DE PRUEBA ANDROID"); response =
	     * restTemplate.postForObject
	     * (server+"/ws-restful-innovargia-in/rest/firmafoto/create", foto ,
	     * String.class);
	     */

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	}

    }

}
