package com.innovargia.salesmanager.ups.bo.impl;
import com.ups.wsdl.xoltws.ship.v1.ShipPortType;
import com.ups.wsdl.xoltws.ship.v1.ShipService;
import com.ups.wsdl.xoltws.ship.v1.ShipmentErrorMessage;
import com.ups.xmlschema.xoltws.common.v1.CodeDescriptionType;
import com.ups.xmlschema.xoltws.common.v1.RequestType;
import com.ups.xmlschema.xoltws.common.v1.ResponseType;
import com.ups.xmlschema.xoltws.common.v1.TransactionReferenceType;
import com.ups.xmlschema.xoltws.error.v1.CodeType;
import com.ups.xmlschema.xoltws.error.v1.ErrorDetailType;
import com.ups.xmlschema.xoltws.error.v1.Errors;
import com.ups.xmlschema.xoltws.ship.v1.BillShipperType;
import com.ups.xmlschema.xoltws.ship.v1.DimensionsType;
import com.ups.xmlschema.xoltws.ship.v1.LabelImageFormatType;
import com.ups.xmlschema.xoltws.ship.v1.LabelSpecificationType;
import com.ups.xmlschema.xoltws.ship.v1.LabelType;
import com.ups.xmlschema.xoltws.ship.v1.PackageResultsType;
import com.ups.xmlschema.xoltws.ship.v1.PackageType;
import com.ups.xmlschema.xoltws.ship.v1.PackageWeightType;
import com.ups.xmlschema.xoltws.ship.v1.PackagingType;
import com.ups.xmlschema.xoltws.ship.v1.PaymentInfoType;
import com.ups.xmlschema.xoltws.ship.v1.ServiceType;
import com.ups.xmlschema.xoltws.ship.v1.ShipAddressType;
import com.ups.xmlschema.xoltws.ship.v1.ShipFromType;
import com.ups.xmlschema.xoltws.ship.v1.ShipPhoneType;
import com.ups.xmlschema.xoltws.ship.v1.ShipToAddressType;
import com.ups.xmlschema.xoltws.ship.v1.ShipToType;
import com.ups.xmlschema.xoltws.ship.v1.ShipUnitOfMeasurementType;
import com.ups.xmlschema.xoltws.ship.v1.ShipmentChargeType;
import com.ups.xmlschema.xoltws.ship.v1.ShipmentRequest;
import com.ups.xmlschema.xoltws.ship.v1.ShipmentResponse;
import com.ups.xmlschema.xoltws.ship.v1.ShipmentResultsType;
import com.ups.xmlschema.xoltws.ship.v1.ShipmentType;
import com.ups.xmlschema.xoltws.ship.v1.ShipperType;
import com.ups.xmlschema.xoltws.upss.v1.UPSSecurity;
import com.ups.xmlschema.xoltws.upss.v1.UPSSecurity.ServiceAccessToken;
import com.ups.xmlschema.xoltws.upss.v1.UPSSecurity.UsernameToken;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import org.apache.commons.codec.binary.Base64;
public class Test {

	 private static String url = "https://onlinetools.ups.com/webservices/Ship";
	  private static final String LICENSE_NUMBER = "1CD95C7871BFA1E5";
	  private static final String ups_shipper_number = "6730V8";
	  private static final String userName = "eb.dominguez";
	  private static final String password = "Envia#14";
	  private static final String ENDPOINT_URL = "https://wwwcie.ups.com/webservices/Ship";
	  private static final String tool_or_webservice_name = "https://wwwcie.ups.com/webservices/Ship";
	  private static String accessKey = "1CD95C7871BFA1E5";
	  private static String out_file_location = "/tmp/out_file_location";
	  private static String statusCode = null;
	  private static String description = null;
	  
	  private static void loadProperties() {}
	  
	  public static void main(String[] arguments)
	    throws Exception
	  {
	    try
	    {
	      loadProperties();
	      ShipService shipService = new ShipService();
	      ShipPortType shipPort = shipService.getShipPort();
	      BindingProvider bp = (BindingProvider)shipPort;
	      bp.getRequestContext().put("javax.xml.ws.service.endpoint.address", url);
	      
	      ShipmentRequest shipRequest = new ShipmentRequest();
	      
	      RequestType requestType = new RequestType();
	      TransactionReferenceType transactionReference = new TransactionReferenceType();
	      transactionReference.setCustomerContext("JAX-WS Test Client");
	      requestType.setTransactionReference(transactionReference);
	      List<String> requestOption = requestType.getRequestOption();
	      requestOption.add("nonvalidate");
	      shipRequest.setRequest(requestType);
	      
	      ShipmentType shpmnt = new ShipmentType();
	      
	      ShipperType shipper = new ShipperType();
	      shipper.setName("AUTOBUSES ESTRELLA BLANCA SA DE CV ");
	      shipper.setAttentionName("CARLOS DOMINGUEZ");
	      
	      ShipPhoneType shipperPhone = new ShipPhoneType();
	      shipperPhone.setNumber("57295131");
	      
	      shipper.setPhone(shipperPhone);
	      
	      shipper.setShipperNumber("6730V8");
	      
	      ShipAddressType shipperAddress = new ShipAddressType();
	      List<String> addressLineList = shipperAddress.getAddressLine();
	      addressLineList.add("PONIENTE 140 NO 859");
	      addressLineList.add("IND VALLEJO");
	      addressLineList.add("AZCAPOTZALCO");
	      
	      shipperAddress.setCity("MEXICO CITY");
	      shipperAddress.setPostalCode("02300");
	      shipperAddress.setStateProvinceCode("DF");
	      shipperAddress.setCountryCode("MX");
	      shipper.setAddress(shipperAddress);
	      
	      shpmnt.setShipper(shipper);
	      
	      ShipToType shipTo = new ShipToType();
	      shipTo.setName("Happy Dog Pet Supply");
	      shipTo.setAttentionName("1160b_74");
	      
	      ShipPhoneType shipToPhone = new ShipPhoneType();
	      shipToPhone.setNumber("1234567898");
	      shipTo.setPhone(shipToPhone);
	      
	      ShipToAddressType shipToAddress = new ShipToAddressType();
	      List<String> ShipToAddressLineList = shipToAddress.getAddressLine();
	      ShipToAddressLineList.add("750-47TH St Edmonton");
	      shipToAddress.setCity("Rosewell");
	      shipToAddress.setStateProvinceCode("GA");
	      shipToAddress.setPostalCode("30004");
	      shipToAddress.setCountryCode("US");
	      shipTo.setAddress(shipToAddress);
	      shpmnt.setShipTo(shipTo);
	      
	      ShipFromType shipFrom = new ShipFromType();
	      shipFrom.setName("ABC Associates");
	      shipFrom.setAttentionName("Mr.ABC");
	      ShipAddressType shipFromAddress = new ShipAddressType();
	      List<String> addressLineList_shipFrom = shipFromAddress.getAddressLine();
	      
	      addressLineList_shipFrom.add("ANTONIO J TIRADO 2");
	      shipFromAddress.setCity("MEXICO CITY");
	      shipFromAddress.setPostalCode("09230");
	      shipFromAddress.setStateProvinceCode("DF");
	      shipFromAddress.setCountryCode("MX");
	      shipFrom.setAddress(shipFromAddress);
	      shpmnt.setShipFrom(shipFrom);
	      
	      PaymentInfoType payInfo = new PaymentInfoType();
	      ShipmentChargeType shpmntCharge = new ShipmentChargeType();
	      shpmntCharge.setType("01");
	      BillShipperType billShipper = new BillShipperType();
	      billShipper.setAccountNumber("6730V8");
	      shpmntCharge.setBillShipper(billShipper);
	      ShipmentChargeType[] shpmntChargeArray = { shpmntCharge };
	      List shipmentChargesList = payInfo.getShipmentCharge();
	      shipmentChargesList.add(shpmntChargeArray[0]);
	      shpmnt.setPaymentInformation(payInfo);
	      
	      ServiceType service = new ServiceType();
	      service.setCode("11");
	      service.setDescription("Standard");
	      shpmnt.setService(service);
	      
	      PackageType pkg1 = new PackageType();
	      PackagingType pkgingType = new PackagingType();
	      pkgingType.setCode("00");
	      pkgingType.setDescription("unknown");
	      pkg1.setPackaging(pkgingType);
	      
	      DimensionsType dimensionsType = new DimensionsType();
	      ShipUnitOfMeasurementType unitOfMeas = new ShipUnitOfMeasurementType();
	      unitOfMeas.setCode("CM");
	      unitOfMeas.setDescription("Centimeters");
	      dimensionsType.setUnitOfMeasurement(unitOfMeas);
	      dimensionsType.setLength("0");
	      dimensionsType.setWidth("0");
	      dimensionsType.setHeight("0");
	      pkg1.setDimensions(dimensionsType);
	      
	      PackageType[] pkgArray = { pkg1 };
	      PackageWeightType weight = new PackageWeightType();
	      weight.setWeight("1");
	      ShipUnitOfMeasurementType shpUnitOfMeas = new ShipUnitOfMeasurementType();
	      shpUnitOfMeas.setCode("KGS");
	      shpUnitOfMeas.setDescription("KILOGRAMS");
	      weight.setUnitOfMeasurement(shpUnitOfMeas);
	      pkg1.setPackageWeight(weight);
	      List packageList = shpmnt.getPackage();
	      packageList.add(pkgArray[0]);
	      
	      LabelSpecificationType labelSpecType = new LabelSpecificationType();
	      LabelImageFormatType labelImageFormat = new LabelImageFormatType();
	      labelImageFormat.setCode("GIF");
	      labelImageFormat.setDescription("GIF");
	      labelSpecType.setLabelImageFormat(labelImageFormat);
	      
	      labelSpecType.setHTTPUserAgent("Mozilla/4.5");
	      shipRequest.setLabelSpecification(labelSpecType);
	      
	      shpmnt.setDescription("Some Goods");
	      shipRequest.setShipment(shpmnt);
	      
	      UPSSecurity upsSecurity = new UPSSecurity();
	      UPSSecurity.UsernameToken usernameToken = new UPSSecurity.UsernameToken();
	      usernameToken.setUsername("eb.dominguez");
	      usernameToken.setPassword("Envia#14");
	      upsSecurity.setUsernameToken(usernameToken);
	      UPSSecurity.ServiceAccessToken accessToken = new UPSSecurity.ServiceAccessToken();
	      accessToken.setAccessLicenseNumber(accessKey);
	      upsSecurity.setServiceAccessToken(accessToken);
	      
	      System.out.println(shipRequest);
	      ShipmentResponse shipResponse = shipPort.processShipment(shipRequest, upsSecurity);
	      
	      System.out.println("Transaction Status: " + shipResponse.getResponse().getResponseStatus().getDescription());
	      
	      System.out.println("Shipment 1Z number: " + shipResponse.getShipmentResults().getShipmentIdentificationNumber());
	      
	      System.out.println(((PackageResultsType)shipResponse.getShipmentResults().getPackageResults().get(0)).getShippingLabel().getGraphicImage());
	      
	      statusCode = shipResponse.getResponse().getResponseStatus().getCode();
	      
	      description = shipResponse.getResponse().getResponseStatus().getDescription();
	      
	      updateResultsToFile(statusCode, description);
	      
	      String cadena = ((PackageResultsType)shipResponse.getShipmentResults().getPackageResults().get(0)).getShippingLabel().getGraphicImage();
	      
	      Base64 b = new Base64();
	      byte[] imageBytes = b.decode(cadena);
	      FileOutputStream fos = new FileOutputStream("C:\\tmp\\" + shipResponse.getShipmentResults().getShipmentIdentificationNumber() + ".gif");
	      
	      fos.write(imageBytes);
	      fos.close();
	    }
	    catch (Exception e)
	    {
	      if ((e instanceof ShipmentErrorMessage))
	      {
	        ShipmentErrorMessage err = (ShipmentErrorMessage)e;
	        Errors faultMessage = err.getFaultInfo();
	        description = ((ErrorDetailType)faultMessage.getErrorDetail().get(0)).getPrimaryErrorCode().getDescription();
	        statusCode = ((ErrorDetailType)faultMessage.getErrorDetail().get(0)).getPrimaryErrorCode().getCode();
	        updateResultsToFile(statusCode, description);
	        System.out.println("\nThe Error Response: Code=" + statusCode + " Decription=" + description);
	      }
	      else
	      {
	        statusCode = e.getMessage();
	        description = e.toString();
	        updateResultsToFile(statusCode, description);
	      }
	    }
	  }
	  
	  private static void updateResultsToFile(String statusCode, String description)
	  {
	    BufferedWriter bw = null;
	    try
	    {
	      File outFile = new File(out_file_location);
	      System.out.println("Output file deletion status: " + outFile.delete());
	      
	      outFile.createNewFile();
	      System.out.println("Output file location: " + outFile.getCanonicalPath());
	      
	      bw = new BufferedWriter(new FileWriter(outFile));
	      StringBuffer strBuf = new StringBuffer();
	      strBuf.append("<ExecutionAt>");
	      strBuf.append(Calendar.getInstance().getTime());
	      strBuf.append("</ExecutionAt>\n");
	      strBuf.append("<ToolOrWebServiceName>");
	      strBuf.append("https://wwwcie.ups.com/webservices/Ship");
	      strBuf.append("</ToolOrWebServiceName>\n");
	      strBuf.append("\n");
	      strBuf.append("<ResponseStatus>\n");
	      strBuf.append("\t<Code>");
	      strBuf.append(statusCode);
	      strBuf.append("</Code>\n");
	      strBuf.append("\t<Description>");
	      strBuf.append(description);
	      strBuf.append("</Description>\n");
	      strBuf.append("</ResponseStatus>");
	      bw.write(strBuf.toString());
	      bw.close(); return;
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    finally
	    {
	      try
	      {
	        if (bw != null)
	        {
	          bw.close();
	          bw = null;
	        }
	      }
	      catch (Exception e)
	      {
	        e.printStackTrace();
	      }
	    }
	  }

}
