package com.innovargia.salesmanager.ups.bo.impl;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.ups.cer.CertificadosDown;
import com.innovargia.salesmanager.ups.dto.ServiceAccessToken;
import com.innovargia.salesmanager.ups.dto.UPSRequest;
import com.innovargia.salesmanager.ups.dto.UPSResponse;
import com.innovargia.salesmanager.ups.dto.UPSSecurity;
import com.innovargia.salesmanager.ups.dto.UsernameToken;
import com.innovargia.salesmanager.ups.dto.ship.Address;
import com.innovargia.salesmanager.ups.dto.ship.BillShipper;
import com.innovargia.salesmanager.ups.dto.ship.Dimensions;
import com.innovargia.salesmanager.ups.dto.ship.LabelImageFormat;
import com.innovargia.salesmanager.ups.dto.ship.LabelSpecification;
import com.innovargia.salesmanager.ups.dto.ship.Package;
import com.innovargia.salesmanager.ups.dto.ship.PackageWeight;
import com.innovargia.salesmanager.ups.dto.ship.Packaging;
import com.innovargia.salesmanager.ups.dto.ship.PaymentInformation;
import com.innovargia.salesmanager.ups.dto.ship.Phone;
import com.innovargia.salesmanager.ups.dto.ship.Request;
import com.innovargia.salesmanager.ups.dto.ship.Service;
import com.innovargia.salesmanager.ups.dto.ship.ShipData;
import com.innovargia.salesmanager.ups.dto.ship.Shipment;
import com.innovargia.salesmanager.ups.dto.ship.ShipmentCharge;
import com.innovargia.salesmanager.ups.dto.ship.ShipmentRequest;
import com.innovargia.salesmanager.ups.dto.ship.TransactionReference;
import com.innovargia.salesmanager.ups.dto.ship.UnitOfMeasurement;

public class TestJSON {
	 private static String url = "https://onlinetools.ups.com/rest/Ship";
	  private static final String LICENSE_NUMBER = "1CD95C7871BFA1E5";
	  private static final String ups_shipper_number = "6730V8";
	  private static final String userName = "eb.dominguez";
	  private static final String password = "Envia#14";
	  private static final String ENDPOINT_URL = "https://wwwcie.ups.com/webservices/Ship";
	  private static final String tool_or_webservice_name = "https://wwwcie.ups.com/webservices/Ship";
	  private static String accessKey = "1CD95C7871BFA1E5";
	  private static String out_file_location = "/tmp/out_file_location";
	  private static String contextUPS = "UPS CLIENT JSON";

	  private static String shipmentDescription="CLIENTE JSON";
	  private static String shipmentChargeType = "01";
	  private static String formatCode ="GIF";
	  private static String formatDescription="GIF";
	  private static String hTTPUserAgent="Mozilla/4.5";	
		
	  private static String serviceCode = "01";
	  private static String serviceDescription = "01";
	  
	  
		
		
	public static void main(String[] arguments) throws Exception {
		EtiquetaRotulacionDTO etiqueta =getDatos();
		
		UPSRequest upsRequestShip = new UPSRequest();
		UsernameToken usernameToken = new UsernameToken(userName,password);
		ServiceAccessToken serviceAccessToken = new ServiceAccessToken(accessKey);
		UPSSecurity uPSSecurity = new UPSSecurity(usernameToken, serviceAccessToken);
		upsRequestShip.setUPSSecurity(uPSSecurity);
		
		ShipmentRequest shipmentRequest= new ShipmentRequest();
		Request request = new Request();
		request.setRequestOption( "validate");
		com.innovargia.salesmanager.ups.dto.ship.TransactionReference transactionReference = new TransactionReference();
		transactionReference.setCustomerContext(contextUPS);
		request.setTransactionReference(transactionReference);
		
		LabelSpecification labelSpecification =getLabelSpecification(formatCode, formatDescription, hTTPUserAgent);
		
		
		//Configura el objeto
		Shipment shipment = new Shipment();
		shipment.setDescription(shipmentDescription);
		ShipData shipper = configureShipper(etiqueta, ups_shipper_number);
		ShipData shipTo = configureShipperTo(etiqueta, ups_shipper_number);
		ShipData shipFrom = null;
		PaymentInformation paymentInformation =  getPaymentInformation(shipmentChargeType, ups_shipper_number);
		
		Service service = getService(serviceCode, serviceDescription);
		
		Package package1 = getPackage(etiqueta.getPesofisico() + "", 
				etiqueta.getPesomedida(), UtilsUPS.getMedidaPeso(etiqueta.getPesomedida()), etiqueta);
		
		//Agrega los datos al objeto principal
		shipment.setShipper(shipper);
		shipment.setShipFrom(shipFrom);
		shipment.setShipTo(shipTo);
		shipment.setPaymentInformation(paymentInformation);
		shipment.setService(service);
		shipment.setPackage(package1);
		
		//Agrega la configuracion principal
		shipmentRequest.setLabelSpecification(labelSpecification);
		shipmentRequest.setRequest(request);
		shipmentRequest.setShipment(shipment);

		//Actuliza el objeto principal
		upsRequestShip.setShipmentRequest(shipmentRequest);
		upsRequestShip.setUPSSecurity(uPSSecurity);
		
		
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(upsRequestShip);
		System.out.println("UpsRequestShip:" + jsonString);
		
		
		URL url__ = new URL(url);
		CertificadosDown.doTrustToCertificates();
	    HttpURLConnection conn = null;//(HttpURLConnection)url__.openConnection(); 
	   //  System.out.println("ResponseCoede ="+conn.getResponseCode());
	     for (int i=1;i<=1;i++){
	    	 try{
	    		 conn = (HttpURLConnection)url__.openConnection(); 
	    		 conn.setRequestMethod("POST");
		    	 System.out.println("ResponseCoede ="+conn.getResponseCode()); 
	    	 }catch(Exception e){
	    		 System.out.println("Error ="+e.getMessage()); 
	    	 }
	    	
	     }
	   
	     HttpHeaders requestHeaders=new HttpHeaders();
	     requestHeaders.setContentType(MediaType.APPLICATION_JSON);
	     
	     HttpEntity entity = new HttpEntity(jsonString, requestHeaders);
	     
	   
	    // ResponseEntity<UPSResponse> result = restTemplate.exchange(url, HttpMethod.POST, entity, UPSResponse.class);
		UPSResponse result1 = restTemplate.postForObject(url, upsRequestShip, UPSResponse.class);
		
		mapper = new ObjectMapper();
		jsonString = mapper.writeValueAsString(result1);
		
		System.out.println("UPSResponse:" + jsonString);
		

	}
	
	public static LabelSpecification getLabelSpecification(String formatCode, String formatDescription,
			String httpUserAgent){
		LabelSpecification labelSpecification = new LabelSpecification();
		LabelImageFormat labelImageFormat = new LabelImageFormat();
		labelImageFormat.setCode(formatCode);
		labelImageFormat.setDescription(formatDescription);
		labelSpecification.setLabelImageFormat(labelImageFormat);
		labelSpecification.setHTTPUserAgent(httpUserAgent);
		
		return labelSpecification;
	}
		public static EtiquetaRotulacionDTO getDatos(){
			EtiquetaRotulacionDTO etiqueta = new EtiquetaRotulacionDTO();
			//Dimensiones y peso
			etiqueta.setAlto(10);
			etiqueta.setAncho(15);
			etiqueta.setLargo(10);
			etiqueta.setPesofisico(Float.parseFloat("1.5"));
			etiqueta.setPesobase(2);
			etiqueta.setTipoempaque("00");
			
			//Remitente
			etiqueta.setRazonsocial_des("ESTE ES UN EJEMPLO");
			etiqueta.setContacto_rem("ESTE ES UN EJEMPLO");
			etiqueta.setCalle_rem("ANTONIO J TIRADO");
			etiqueta.setNumexterior_rem("2");
			etiqueta.setNuminterior_rem("22");
			etiqueta.setColonia_rem("EJERCITO DE ORIENTE");
			etiqueta.setMunicipio_rem("IZTAPALAPA");
			etiqueta.setEstado_rem("CDMX");
			etiqueta.setCp_rem("09230");
			etiqueta.setPais_rem("MEX");
			
			//DESTINATARIO
			etiqueta.setRazonsocial_des("ESTE ES UN EJEMPLO");
			etiqueta.setContacto_rem("ESTE ES UN EJEMPLO");
			etiqueta.setCalle_rem("ANTONIO J TIRADO");
			etiqueta.setNumexterior_rem("2");
			etiqueta.setNuminterior_rem("22");
			etiqueta.setColonia_rem("EJERCITO DE ORIENTE");
			etiqueta.setMunicipio_rem("IZTAPALAPA");
			etiqueta.setEstado_rem("CDMX");
			etiqueta.setCp_rem("09230");
			etiqueta.setPais_rem("MEX");
			
			return etiqueta;
		}

		public static Package getPackage(String weight_value, String measurementCode,
				String measurementDescription,
				EtiquetaRotulacionDTO etiqueta){
			
			Package package1 = new Package();
			package1.setDescription("PESO Y DIMENSIONES");
			
			Packaging packaging = new Packaging();
			packaging.setCode(etiqueta.getTipoempaque() == null ? "00" : etiqueta.getTipoempaque());
			packaging.setDescription(UtilsUPS.getTipoEmpaqueUPS(packaging.getCode()));
			package1.setPackaging(packaging);
			
			Dimensions dimensions = new Dimensions();
			dimensions.setLength(etiqueta.getLargo() + "");
			dimensions.setWidth(etiqueta.getAncho() + "");
			dimensions.setHeight(etiqueta.getAlto() + "");
			
			UnitOfMeasurement unitOfMeasurement = new UnitOfMeasurement();
			unitOfMeasurement.setCode(etiqueta.getDimensionmedida());
			unitOfMeasurement.setDescription(UtilsUPS.getMedidaDimension(unitOfMeasurement.getCode()));
			dimensions.setUnitOfMeasurement(unitOfMeasurement);

			package1.setDimensions(dimensions);
			
			PackageWeight packageWeight = new PackageWeight();
			UnitOfMeasurement unitOfMeasurementPackageWeight = new UnitOfMeasurement();
			unitOfMeasurementPackageWeight.setCode(measurementCode);
			unitOfMeasurementPackageWeight.setDescription(measurementDescription);
			packageWeight.setWeight(weight_value);
			packageWeight.setUnitOfMeasurement(unitOfMeasurementPackageWeight);
			
			package1.setPackageWeight(packageWeight);
			
		
			return package1;
			
		}
				
		public static Service getService(String idservice, String description){
			Service service = new Service();
			service.setCode(idservice);
			service.setDescription(description);
			
			return service;
		}
				
		public static PaymentInformation getPaymentInformation(String tipopago, String ups_shipper_number){
			PaymentInformation paymentInformation = new PaymentInformation();
			
			ShipmentCharge shipmentCharge = new ShipmentCharge();
			shipmentCharge.setType(tipopago);

			BillShipper billShipper = new BillShipper();
			billShipper.setAccountNumber(ups_shipper_number);
			shipmentCharge.setBillShipper(billShipper);
			
			paymentInformation.setShipmentCharge(shipmentCharge);
			
			return paymentInformation;
		}
		public static ShipData configureShipper(EtiquetaRotulacionDTO etiqueta,
				String ups_shipper_number){
			
			ShipData ship = new ShipData();
			ship.setShipperNumber(ups_shipper_number);
			ship.setName(etiqueta.getRazonsocial_rem());
			ship.setAttentionName(etiqueta.getContacto_rem());
			
			Phone phone = new Phone();
			phone.setNumber(etiqueta.getTelefono_rem());
			phone.setExtension(etiqueta.getCelular_rem());
			ship.setPhone(phone);
			
			String addressLine = etiqueta.getCalle_rem() + " " + 
					(etiqueta.getNumexterior_rem()!=null?etiqueta.getNumexterior_rem():" ")+
					(etiqueta.getNuminterior_rem()!=null?etiqueta.getNuminterior_rem():" ");
			String city = etiqueta.getCiudad_rem()==null || etiqueta.getCiudad_rem().trim().isEmpty()?
					etiqueta.getMunicipio_rem():etiqueta.getCiudad_rem();
					
			String countryCode = etiqueta.getCiudad_rem()==null || etiqueta.getCiudad_rem().trim().isEmpty()?
					"MX":etiqueta.getCodigopais_rem();
					
			Address address = new Address();
			address.setAddressLine(addressLine);
			address.setCity(city);
			address.setStateProvinceCode(etiqueta.getEstado_rem());
			address.setPostalCode(etiqueta.getCp_rem());
			address.setCountryCode(countryCode);
			 
			ship.setAddress(address);
			ship.setPhone(phone);
			
			return ship;
			
		}
		
		public static ShipData configureShipperTo(EtiquetaRotulacionDTO etiqueta,
				String ups_shipper_number){
			
			ShipData ship = new ShipData();
			ship.setName(etiqueta.getRazonsocial_des());
			ship.setAttentionName(etiqueta.getContacto_des());
			
			Phone phone = new Phone();
			phone.setNumber(etiqueta.getTelefono_des());
			phone.setExtension(etiqueta.getCelular_des());
			ship.setPhone(phone);
			
			String addressLine = etiqueta.getCalle_des() + " " + 
					(etiqueta.getNumexterior_des()!=null?etiqueta.getNumexterior_des():" ")+
					(etiqueta.getNuminterior_des()!=null?etiqueta.getNuminterior_des():" ");
			
			String city = etiqueta.getCiudad_des()==null || etiqueta.getCiudad_des().trim().isEmpty()?
					etiqueta.getMunicipio_des():etiqueta.getCiudad_des();
					
			String countryCode = etiqueta.getCiudad_des()==null || etiqueta.getCiudad_des().trim().isEmpty()?
					"MX":etiqueta.getCodigopais_des();
					
			Address address = new Address();
			address.setAddressLine(addressLine);
			address.setCity(city);
			address.setStateProvinceCode(etiqueta.getEstado_des());
			address.setPostalCode(etiqueta.getCp_des());
			address.setCountryCode(countryCode);
			 
			ship.setAddress(address);
			ship.setPhone(phone);
			
			return ship;
			
		}
}

