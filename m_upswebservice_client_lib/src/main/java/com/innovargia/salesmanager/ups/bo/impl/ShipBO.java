package com.innovargia.salesmanager.ups.bo.impl;

import java.io.FileOutputStream;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.administracion.idao.IParamsSistemaDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.CuentasConexionMensajeriaDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.salesmanager.ups.ibo.IShipBO;
import com.servicio.constantes.ConstantesGenerales;
import com.ups.wsdl.xoltws.ship.v1.ShipConfirmErrorMessage;
import com.ups.wsdl.xoltws.ship.v1.ShipPortType;
import com.ups.wsdl.xoltws.ship.v1.ShipService;
import com.ups.wsdl.xoltws.ship.v1.ShipmentErrorMessage;
import com.ups.xmlschema.xoltws.common.v1.RequestType;
import com.ups.xmlschema.xoltws.common.v1.TransactionReferenceType;
import com.ups.xmlschema.xoltws.error.v1.Errors;
import com.ups.xmlschema.xoltws.ship.v1.BillShipperType;
import com.ups.xmlschema.xoltws.ship.v1.DimensionsType;
import com.ups.xmlschema.xoltws.ship.v1.LabelImageFormatType;
import com.ups.xmlschema.xoltws.ship.v1.LabelSpecificationType;
import com.ups.xmlschema.xoltws.ship.v1.PackageType;
import com.ups.xmlschema.xoltws.ship.v1.PackageWeightType;
import com.ups.xmlschema.xoltws.ship.v1.PackagingType;
import com.ups.xmlschema.xoltws.ship.v1.PaymentInfoType;
import com.ups.xmlschema.xoltws.ship.v1.ServiceType;
import com.ups.xmlschema.xoltws.ship.v1.ShipAddressType;
import com.ups.xmlschema.xoltws.ship.v1.ShipConfirmRequest;
import com.ups.xmlschema.xoltws.ship.v1.ShipConfirmResponse;
import com.ups.xmlschema.xoltws.ship.v1.ShipPhoneType;
import com.ups.xmlschema.xoltws.ship.v1.ShipToAddressType;
import com.ups.xmlschema.xoltws.ship.v1.ShipToType;
import com.ups.xmlschema.xoltws.ship.v1.ShipUnitOfMeasurementType;
import com.ups.xmlschema.xoltws.ship.v1.ShipmentChargeType;
import com.ups.xmlschema.xoltws.ship.v1.ShipmentRequest;
import com.ups.xmlschema.xoltws.ship.v1.ShipmentResponse;
import com.ups.xmlschema.xoltws.ship.v1.ShipmentType;
import com.ups.xmlschema.xoltws.ship.v1.ShipperType;
import com.ups.xmlschema.xoltws.upss.v1.UPSSecurity;
import com.ups.xmlschema.xoltws.upss.v1.UPSSecurity.ServiceAccessToken;
import com.ups.xmlschema.xoltws.upss.v1.UPSSecurity.UsernameToken;

@Service
public class ShipBO implements IShipBO {

	private static final Logger logger = LoggerFactory.getLogger(RateBO.class);

	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;

	public ShipBO() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.salesmanager.ups.bo.impl.IShipBO#ship(com.innovargia.
	 * rotulacion.dtos.EtiquetaRotulacionDTO)
	 */

	public CuentasConexionMensajeriaDTO ship(CuentasConexionMensajeriaDTO cuentaconexion,
			EtiquetaRotulacionDTO etiqueta) throws Exception {

		// 1=Crea etiqueta, 2=Valida
		String guia_internacional = null;
		String statusCode = null;
		String description = null;
		try {
			List<SistemaDTO> propiedad_sistema = iParamsSistemaDAO.getRegistros(ConstantesGenerales.ID_SKY4SOL);
			// String portAddress =
			// cuentaconexion.getPropertiesString("endpoint_creacion");//cuentaconexion.getEndpoint_creacion();
			int accion = cuentaconexion.getAccion();
			String ENDPOINT_URL = cuentaconexion.getPropertiesString("endpoint_creacion");// cuentaconexion.getEndpoint_creacion();
			String LICENSE_NUMBER = cuentaconexion.getPropertiesString("LICENSE_NUMBER");// cuentaconexion.getNumclientearrier();
			String PASSWORD = cuentaconexion.getPropertiesString("PASSWORD");// cuentaconexion.getPassword();
			String USER_NAME = cuentaconexion.getPropertiesString("USER_NAME");// cuentaconexion.getLogin();
			String SHIPPER_NUMBER = cuentaconexion.getPropertiesString("SHIPPER_NUMBER");// cuentaconexion.getSuscriberid();
			String SHIPPER_NAME = cuentaconexion.getPropertiesString("SHIPPER_NAME");// cuentaconexion.getOficina_organizacion();
			String VALIDATE_ADDRESS = cuentaconexion.getPropertiesString("VALIDATE_ADDRESS");// "nonvalidate";//iParamsSistemaDAO.getValorPropiedad(
																								// "ups.validate.address",propiedad_sistema);

			logger.debug("DATOS CONEXION: SHIPPER_NUMBER->" + SHIPPER_NUMBER + "SHIPPER_NAME->" + SHIPPER_NAME
					+ "LICENSE_NUMBER->" + LICENSE_NUMBER + "ENDPOINT_URL->" + ENDPOINT_URL + "LICENSE_NUMBER->"
					+ USER_NAME + "DATOS CONEXION: USER_NAME->" + USER_NAME + "PASSWORD->" + PASSWORD
					+ "ACCION A REALIZAR->" + (accion == 1 ? "CREAR VENTA UPS" : "VALIDAR DATOS"));
			System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
			
			ShipService shipService = new ShipService();
			ShipPortType shipPort = shipService.getShipPort();
			BindingProvider bp = (BindingProvider) shipPort;
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ENDPOINT_URL);

			RequestType requestType = new RequestType();
			TransactionReferenceType transactionReference = new TransactionReferenceType();
			transactionReference.setCustomerContext(cuentaconexion.getPropertiesString("CUSTOMERCONTEXT"));
			requestType.setTransactionReference(transactionReference);
			List<String> requestOption = requestType.getRequestOption();
			requestOption.add(VALIDATE_ADDRESS);

			if (accion == 1) {
				ShipmentRequest shipRequest = new ShipmentRequest();
				shipRequest.setRequest(requestType);

				ShipmentType shpmnt = createShipmentType(etiqueta, SHIPPER_NUMBER,cuentaconexion);

				shipRequest.setShipment(shpmnt);

				/** **********Label Specification ******************** */
				LabelSpecificationType labelSpecType = getLabelSpecificationType();
				shipRequest.setLabelSpecification(labelSpecType);
				/** ***********Label Specification********************* */

				/** ************UPSSE************************** */
				UPSSecurity upsSecurity = getLabelSpecificationType(USER_NAME, PASSWORD, LICENSE_NUMBER);

				/** ************UPSSE***************************** */
				ObjectMapper mapper = new ObjectMapper();
				String jsonString = mapper.writeValueAsString(shipRequest);
				logger.debug("shipRequest:" + jsonString);
				
				ShipmentResponse shipResponse = shipPort.processShipment(shipRequest, upsSecurity);

				guia_internacional = shipResponse.getShipmentResults().getShipmentIdentificationNumber();

				logger.debug("Transaction Status: " + shipResponse.getResponse().getResponseStatus().getDescription());
				logger.debug("Shipment 1Z number: " + guia_internacional);

				statusCode = shipResponse.getResponse().getResponseStatus().getCode();
				description = shipResponse.getResponse().getResponseStatus().getDescription();
				logger.debug("statusCode:" + statusCode + ",description:" + description);

				etiqueta.setIdguiainternacional(guia_internacional);

				String base64_imagen = shipResponse.getShipmentResults().getPackageResults().get(0).getShippingLabel()
						.getGraphicImage();

				// Actualiza datos
				cuentaconexion.setGuis_Generadas(guia_internacional);
				cuentaconexion.setCodigo(0);
				cuentaconexion.setBase64_archivo(base64_imagen);
				cuentaconexion.setNombre_archivo(guia_internacional + ".gif");
				Base64 b = new Base64();
				byte[] imageBytes = b.decode(base64_imagen);
				cuentaconexion.setLabelPDF(imageBytes);
				
				
			} else if (accion == 2) {
				// Solo valida los datos
				ShipConfirmRequest shipRequest = new ShipConfirmRequest();
				ShipmentType shpmnt = createShipmentType(etiqueta, SHIPPER_NUMBER,cuentaconexion);
				shipRequest.setShipment(shpmnt);
				LabelSpecificationType labelSpecType = getLabelSpecificationType();
				shipRequest.setLabelSpecification(labelSpecType);
				/** ***********Label Specification********************* */

				/** ************UPSSE************************** */
				UPSSecurity upsSecurity = getLabelSpecificationType(USER_NAME, PASSWORD, LICENSE_NUMBER);

				/** ************UPSSE***************************** */
				ObjectMapper mapper = new ObjectMapper();
				String jsonString = mapper.writeValueAsString(shipRequest);
				logger.debug("shipRequest:" + jsonString);
				
				ShipConfirmResponse shipResponse = shipPort.processShipConfirm(shipRequest, upsSecurity);

				logger.debug("Transaction Status: " + shipResponse.getResponse().getResponseStatus().getDescription());
				logger.debug(
						"Shipment 1Z number: " + shipResponse.getShipmentResults().getShipmentIdentificationNumber());
				logger.debug(shipResponse.getShipmentResults().getPackageResults().get(0).getShippingLabel()
						.getGraphicImage());

				statusCode = shipResponse.getResponse().getResponseStatus().getCode();
				description = shipResponse.getResponse().getResponseStatus().getDescription();
				logger.debug("statusCode:" + statusCode + ",description:" + description);

				if (!"1".equals(statusCode)) {
					cuentaconexion.setCodigo(900);
					cuentaconexion.setDescripcion(
							"Direccion incorrecta[" + "statusCode:" + statusCode + ",description:" + description + "]");
				} else {
					cuentaconexion.setCodigo(0);
					cuentaconexion.setDescripcion("Direccion correcta");
				}

			}

			return cuentaconexion;

		} catch (Exception e) {

			if (e instanceof ShipmentErrorMessage) {
				ShipmentErrorMessage err = (ShipmentErrorMessage) e;
				Errors faultMessage = err.getFaultInfo();
				description = faultMessage.getErrorDetail().get(0).getPrimaryErrorCode().getDescription();
				statusCode = faultMessage.getErrorDetail().get(0).getPrimaryErrorCode().getCode();

				System.out.println("\nThe Error Response: Code=" + statusCode + " Decription=" + description);
			} else if (e instanceof ShipConfirmErrorMessage) {

				ShipConfirmErrorMessage err = (ShipConfirmErrorMessage) e;
				Errors faultMessage = err.getFaultInfo();
				description = faultMessage.getErrorDetail().get(0).getPrimaryErrorCode().getDescription();
				statusCode = faultMessage.getErrorDetail().get(0).getPrimaryErrorCode().getCode();

				System.out.println("\nThe Error Response: Code=" + statusCode + " Decription=" + description);

			} else {
				statusCode = e.getMessage();
				description = e.toString();

			}
			logger.error("statusCode:" + statusCode + ", description:" + description);
			throw new Exception("Error al obtener la info de UPS:statusCode->" + statusCode + ", " + description);
		}

	}

	@Override
	public String ship(EtiquetaRotulacionDTO etiqueta, int accion) throws Exception {

		// 1=Crea etiqueta, 2=Valida
		String guia_internacional = null;
		String statusCode = null;
		String description = null;
		try {
			List<SistemaDTO> propiedad_sistema = iParamsSistemaDAO.getRegistros(ConstantesGenerales.ID_SKY4SOL);
			String ENDPOINT_URL = iParamsSistemaDAO.getValorPropiedad("ups.endpoint.shipping", propiedad_sistema);
			String LICENSE_NUMBER = iParamsSistemaDAO.getValorPropiedad("ups.license.number", propiedad_sistema);
			String PASSWORD = iParamsSistemaDAO.getValorPropiedad("ups.password", propiedad_sistema);
			String USER_NAME = iParamsSistemaDAO.getValorPropiedad("ups.usuario", propiedad_sistema);
			String SHIPPER_NUMBER = iParamsSistemaDAO.getValorPropiedad("ups.shipper.number", propiedad_sistema);
			String SHIPPER_NAME = iParamsSistemaDAO.getValorPropiedad("ups.shipper.name", propiedad_sistema);
			String PATH_GIF_UPS = iParamsSistemaDAO.getValorPropiedad("ups.path.label.ship", propiedad_sistema);
			String VALIDATE_ADDRESS = null;// iParamsSistemaDAO.getValorPropiedad(
											// "ups.validate.address",propiedad_sistema);

			if ((PATH_GIF_UPS == null) || (PATH_GIF_UPS.trim().length() <= 0)) {
				PATH_GIF_UPS = "/opt/";
			}

			if ((VALIDATE_ADDRESS == null) || (VALIDATE_ADDRESS.trim().length() <= 0)) {
				VALIDATE_ADDRESS = "nonvalidate";
			}

			logger.debug("DATOS CONEXION: SHIPPER_NUMBER->" + SHIPPER_NUMBER + "SHIPPER_NAME->" + SHIPPER_NAME
					+ "PATH_GIF_UPS->" + PATH_GIF_UPS + "VALIDATE_ADDRESS->" + VALIDATE_ADDRESS + "LICENSE_NUMBER->"
					+ LICENSE_NUMBER + "ENDPOINT_URL->" + ENDPOINT_URL + "LICENSE_NUMBER->" + USER_NAME
					+ "DATOS CONEXION: USER_NAME->" + USER_NAME + "PASSWORD->" + PASSWORD + "ACCION A REALIZAR->"
					+ (accion == 1 ? "CREAR VENTA UPS" : "VALIDAR DATOS"));

			ShipService shipService = new ShipService();
			ShipPortType shipPort = shipService.getShipPort();
			BindingProvider bp = (BindingProvider) shipPort;
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ENDPOINT_URL);

			RequestType requestType = new RequestType();
			TransactionReferenceType transactionReference = new TransactionReferenceType();
			transactionReference.setCustomerContext("ENVIA UPS Client");
			requestType.setTransactionReference(transactionReference);
			List<String> requestOption = requestType.getRequestOption();
			requestOption.add(VALIDATE_ADDRESS);

			if (accion == 1) {
				ShipmentRequest shipRequest = new ShipmentRequest();
				shipRequest.setRequest(requestType);

				ShipmentType shpmnt = createShipmentType(etiqueta, SHIPPER_NUMBER,null);

				shipRequest.setShipment(shpmnt);

				/** **********Label Specification ******************** */
				LabelSpecificationType labelSpecType = getLabelSpecificationType();
				shipRequest.setLabelSpecification(labelSpecType);
				/** ***********Label Specification********************* */

				/** ************UPSSE************************** */
				UPSSecurity upsSecurity = getLabelSpecificationType(USER_NAME, PASSWORD, LICENSE_NUMBER);

				/** ************UPSSE***************************** */
				
				ObjectMapper mapper = new ObjectMapper();
				String jsonString = mapper.writeValueAsString(shipRequest);
				logger.debug("shipRequest:" + jsonString);
				
				
				ShipmentResponse shipResponse = shipPort.processShipment(shipRequest, upsSecurity);

				guia_internacional = shipResponse.getShipmentResults().getShipmentIdentificationNumber();

				logger.debug("Transaction Status: " + shipResponse.getResponse().getResponseStatus().getDescription());
				logger.debug("Shipment 1Z number: " + guia_internacional);

				statusCode = shipResponse.getResponse().getResponseStatus().getCode();
				description = shipResponse.getResponse().getResponseStatus().getDescription();
				logger.debug("statusCode:" + statusCode + ",description:" + description);

				etiqueta.setIdguiainternacional(guia_internacional);

				String base64_imagen = shipResponse.getShipmentResults().getPackageResults().get(0).getShippingLabel()
						.getGraphicImage();

				logger.debug("creando gif: " + PATH_GIF_UPS + guia_internacional);
				Base64 b = new Base64();
				byte[] imageBytes = b.decode(base64_imagen);
				FileOutputStream fos = new FileOutputStream(PATH_GIF_UPS + guia_internacional + ".gif");
				fos.write(imageBytes);
				fos.close();

				logger.debug("imagen gif creada: " + PATH_GIF_UPS + guia_internacional);

				return guia_internacional;

			} else if (accion == 2) {
				// Solo valida los datos
				ShipConfirmRequest shipRequest = new ShipConfirmRequest();
				ShipmentType shpmnt = createShipmentType(etiqueta, SHIPPER_NUMBER,null);
				shipRequest.setShipment(shpmnt);
				LabelSpecificationType labelSpecType = getLabelSpecificationType();
				shipRequest.setLabelSpecification(labelSpecType);
				/** ***********Label Specification********************* */

				/** ************UPSSE************************** */
				UPSSecurity upsSecurity = getLabelSpecificationType(USER_NAME, PASSWORD, LICENSE_NUMBER);

				/** ************UPSSE***************************** */
				logger.debug("shipRequest:" + shipRequest.toString());
				ShipConfirmResponse shipResponse = shipPort.processShipConfirm(shipRequest, upsSecurity);

				logger.debug("Transaction Status: " + shipResponse.getResponse().getResponseStatus().getDescription());
				logger.debug(
						"Shipment 1Z number: " + shipResponse.getShipmentResults().getShipmentIdentificationNumber());
				logger.debug(shipResponse.getShipmentResults().getPackageResults().get(0).getShippingLabel()
						.getGraphicImage());

				statusCode = shipResponse.getResponse().getResponseStatus().getCode();
				description = shipResponse.getResponse().getResponseStatus().getDescription();
				logger.debug("statusCode:" + statusCode + ",description:" + description);

				if (!"1".equals(statusCode)) {
					throw new Exception(
							"Direccion incorrecta[" + "statusCode:" + 
					statusCode + ",description:" + description + "]");
				} else {
					throw new Exception("Direccion correcta");
				}

			}

			return "";

		} catch (Exception e) {

			if (e instanceof ShipmentErrorMessage) {
				ShipmentErrorMessage err = (ShipmentErrorMessage) e;
				Errors faultMessage = err.getFaultInfo();
				description = faultMessage.getErrorDetail().get(0).getPrimaryErrorCode().getDescription();
				statusCode = faultMessage.getErrorDetail().get(0).getPrimaryErrorCode().getCode();

				System.out.println("\nThe Error Response: Code=" + statusCode + " Decription=" + description);
			} else if (e instanceof ShipConfirmErrorMessage) {

				ShipConfirmErrorMessage err = (ShipConfirmErrorMessage) e;
				Errors faultMessage = err.getFaultInfo();
				description = faultMessage.getErrorDetail().get(0).getPrimaryErrorCode().getDescription();
				statusCode = faultMessage.getErrorDetail().get(0).getPrimaryErrorCode().getCode();

				System.out.println("\nThe Error Response: Code=" + statusCode + " Decription=" + description);

			} else {
				statusCode = e.getMessage();
				description = e.toString();

			}
			logger.error("statusCode:" + statusCode + ", description:" + description);
			throw new Exception("Error al obtener la info de UPS:statusCode->" + statusCode + ", " + description);
		}

	}

	private ShipmentType createShipmentType(EtiquetaRotulacionDTO etiqueta, String ups_shipper_number,
			CuentasConexionMensajeriaDTO cuentaconexion) {

		ShipmentType shpmnt = new ShipmentType();

		/** *******Shipper******************** */

		ShipperType shipper = getShipperType(etiqueta, ups_shipper_number);
		ShipAddressType shipperAddress = getShipAddressType(etiqueta);
		shipper.setAddress(shipperAddress);
		shpmnt.setShipper(shipper);
		

		/** ******Shipper********************* */

		/** ************ShipTo****************** */
		ShipToType shipTo = getShipToType(etiqueta);
		ShipToAddressType shipToAddress = getShipToAddressType(etiqueta);
		shipTo.setAddress(shipToAddress);
		shpmnt.setShipTo(shipTo);

		/** ***********ShipTo********************* */

		/** ************ShipFrom****************** */
		/** ***********ShipFrom********************* */

		/** *************Payment Information***************** */
		PaymentInfoType payInfo = getPaymentInfoType("01", ups_shipper_number);
		shpmnt.setPaymentInformation(payInfo);
		/** *************Payment Information***************** */

		/** ********Service********************** */
		ServiceType service =null;
		if (cuentaconexion!=null){
			//TOMA LO QUE INDICA DEL SISTEMA
			if (!"CONEXIONMEN".equals(cuentaconexion.getQuienSolicita())){
				service = getServiceType(cuentaconexion.getPropertiesString("SERVICETYPE"),
						cuentaconexion.getPropertiesString("SERVICETYPEDESCRIPTION"));
			}else{
				service = getServiceType(etiqueta.getIdservicio(), etiqueta.getDescripcion_servicio());
			}
		}else{
			service = getServiceType(etiqueta.getIdservicio(), etiqueta.getDescripcion_servicio());
		}
		
		shpmnt.setService(service);
		/** ********Service********************** */

		/** ******************Package***************** */

		PackageType pkg1 = getPackageDimensionsType(etiqueta,cuentaconexion);
		PackageType[] pkgArray = { pkg1 };
		String defaultPesomedida = UtilsUPS.isMedidaPeso(etiqueta.getPesomedida())?etiqueta.getPesomedida(): UtilsUPS.getDefaultMedidaPeso();
		PackageWeightType weight = getPackageWeightType(etiqueta.getPesofisico() + "", 
				defaultPesomedida,
				UtilsUPS.getMedidaPeso(defaultPesomedida));

		pkg1.setPackageWeight(weight);
		List packageList = shpmnt.getPackage();
		packageList.add(pkgArray[0]);

		/** ******************Package***************** */

		shpmnt.setDescription("ENVIA");

		return shpmnt;
	}

	public ShipperType getShipperType(EtiquetaRotulacionDTO etiqueta, String ups_shipper_number) {
		ShipperType shipper = new ShipperType();

		shipper.setShipperNumber(ups_shipper_number);
		shipper.setName(etiqueta.getRazonsocial_rem());
		shipper.setAttentionName(etiqueta.getContacto_rem());

		ShipPhoneType shipperPhone = new ShipPhoneType();
		shipperPhone.setNumber(etiqueta.getTelefono_rem());
		// shipperPhone.setExtension("1");
		shipper.setPhone(shipperPhone);

		return shipper;
	}

	public ShipAddressType getShipAddressType(EtiquetaRotulacionDTO etiqueta) {

		ShipAddressType shipperAddress = new ShipAddressType();
		List<String> addressLineList = shipperAddress.getAddressLine();
		String direccion = etiqueta.getCalle_rem() + " " + 
		(etiqueta.getNumexterior_rem()!=null?etiqueta.getNumexterior_rem():" ")+ " "+ 
		(etiqueta.getNuminterior_rem()!=null?etiqueta.getNuminterior_rem():" ");
		
		addressLineList.add(direccion);
		addressLineList.add(etiqueta.getColonia_rem());
		addressLineList.add(etiqueta.getMunicipio_rem());
		shipperAddress.setCity(etiqueta.getCiudad_rem());
		shipperAddress.setPostalCode(etiqueta.getCp_rem());
		shipperAddress.setStateProvinceCode(etiqueta.getIdestado_rem());
		shipperAddress.setCountryCode(etiqueta.getCodigopais_rem());//"MX");

		return shipperAddress;
	}

	public ShipToType getShipToType(EtiquetaRotulacionDTO etiqueta) {
		ShipToType shipTo = new ShipToType();
		shipTo.setName(etiqueta.getRazonsocial_des());
		shipTo.setAttentionName(etiqueta.getContacto_des());

		ShipPhoneType shipToPhone = new ShipPhoneType();
		shipToPhone.setNumber(etiqueta.getTelefono_des());
		shipTo.setPhone(shipToPhone);

		return shipTo;
	}

	public ShipToAddressType getShipToAddressType(EtiquetaRotulacionDTO etiqueta) {
		ShipToAddressType shipToAddress = new ShipToAddressType();
		List<String> ShipToAddressLineList = shipToAddress.getAddressLine();
		
		String direccion = etiqueta.getCalle_des() + " " + 
				(etiqueta.getNumexterior_des()!=null?etiqueta.getNumexterior_des():" ")+" " +
				(etiqueta.getNuminterior_des()!=null?etiqueta.getNuminterior_des():" ");
		
		ShipToAddressLineList.add(direccion);
		ShipToAddressLineList.add(etiqueta.getColonia_des());
		shipToAddress.setCity(etiqueta.getCiudad_des());
		shipToAddress.setPostalCode(etiqueta.getCp_des());
		shipToAddress.setStateProvinceCode(etiqueta.getIdestado_des());
		shipToAddress.setCountryCode(etiqueta.getCodigopais_des());

		return shipToAddress;
	}

	public PaymentInfoType getPaymentInfoType(String tipopago, String ups_shipper_number) {
		PaymentInfoType payInfo = new PaymentInfoType();
		ShipmentChargeType shpmntCharge = new ShipmentChargeType();
		shpmntCharge.setType(tipopago); // "01");
		
		BillShipperType billShipper = new BillShipperType();
		billShipper.setAccountNumber(ups_shipper_number);
		shpmntCharge.setBillShipper(billShipper);
		
		ShipmentChargeType[] shpmntChargeArray = { shpmntCharge };
		List shipmentChargesList = payInfo.getShipmentCharge();
		shipmentChargesList.add(shpmntChargeArray[0]);

		return payInfo;
	}

	public ServiceType getServiceType(String idservice, String description) {
		ServiceType service = new ServiceType();
		service.setCode(idservice);
		service.setDescription(description);
		return service;

	}

	public PackageType getPackageDimensionsType(EtiquetaRotulacionDTO etiqueta,CuentasConexionMensajeriaDTO cuentaconexion) {
		PackageType pkg1 = new PackageType();
		PackagingType pkgingType = new PackagingType();
		pkgingType.setCode(etiqueta.getTipoempaque() == null ? "00" : etiqueta.getTipoempaque());
		pkgingType.setDescription(UtilsUPS.getTipoEmpaqueUPS(pkgingType.getCode()));
		if (pkgingType.getDescription() == null) {
			pkgingType.setCode("00");
			pkgingType.setDescription(UtilsUPS.getTipoEmpaqueUPS(pkgingType.getCode()));
		}
		pkg1.setPackaging(pkgingType);

		DimensionsType dimensionsType = new DimensionsType();
		ShipUnitOfMeasurementType unitOfMeas = new ShipUnitOfMeasurementType();
		unitOfMeas.setCode(etiqueta.getDimensionmedida()== null?"CM":etiqueta.getDimensionmedida());
		unitOfMeas.setDescription(UtilsUPS.getMedidaDimension(unitOfMeas.getCode()));
		dimensionsType.setUnitOfMeasurement(unitOfMeas);
		dimensionsType.setLength(etiqueta.getLargo() + "");
		dimensionsType.setWidth(etiqueta.getAncho() + "");
		dimensionsType.setHeight(etiqueta.getAlto() + "");
		pkg1.setDimensions(dimensionsType);

		return pkg1;
	}

	public PackageWeightType getPackageWeightType(String weight_value, String measurementCode,
			String measurementDescription) {
		PackageWeightType weight = new PackageWeightType();
		weight.setWeight(weight_value);
		ShipUnitOfMeasurementType shpUnitOfMeas = new ShipUnitOfMeasurementType();
		shpUnitOfMeas.setCode(measurementCode);
		shpUnitOfMeas.setDescription(measurementDescription);
		weight.setUnitOfMeasurement(shpUnitOfMeas);

		return weight;

	}

	public LabelSpecificationType getLabelSpecificationType() {

		LabelSpecificationType labelSpecType = new LabelSpecificationType();
		LabelImageFormatType labelImageFormat = new LabelImageFormatType();
		labelImageFormat.setCode("GIF");
		labelImageFormat.setDescription("GIF");
		labelSpecType.setLabelImageFormat(labelImageFormat);

		labelSpecType.setHTTPUserAgent("Mozilla/4.5");
		
		return labelSpecType;

	}

	public UPSSecurity getLabelSpecificationType(String userName, String password, String accessKey) {
		UPSSecurity upsSecurity = new UPSSecurity();
		UsernameToken usernameToken = new UsernameToken();
		usernameToken.setUsername(userName);
		usernameToken.setPassword(password);
		upsSecurity.setUsernameToken(usernameToken);
		ServiceAccessToken accessToken = new ServiceAccessToken();
		accessToken.setAccessLicenseNumber(accessKey);
		upsSecurity.setServiceAccessToken(accessToken);

		return upsSecurity;
	}

}
