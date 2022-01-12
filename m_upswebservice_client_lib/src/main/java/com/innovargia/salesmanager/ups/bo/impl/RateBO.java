/**
 * 
 */
package com.innovargia.salesmanager.ups.bo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.dto.CotizacionTarifa;
import com.administracion.idao.IParamsSistemaDAO;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.salesmanager.ups.ibo.IRates;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.search.ibo.IBusquedaCatalogoBO;
import com.ups.wsdl.xoltws.rate.v1.RateErrorMessage;
import com.ups.wsdl.xoltws.rate.v1.RatePortType;
import com.ups.wsdl.xoltws.rate.v1.RateService;
import com.ups.xmlschema.xoltws.common.v1.RequestType;
import com.ups.xmlschema.xoltws.rate.v1.AddressType;
import com.ups.xmlschema.xoltws.rate.v1.ChargesType;
import com.ups.xmlschema.xoltws.rate.v1.CodeDescriptionType;
import com.ups.xmlschema.xoltws.rate.v1.GuaranteedDeliveryType;
import com.ups.xmlschema.xoltws.rate.v1.PackageType;
import com.ups.xmlschema.xoltws.rate.v1.PackageWeightType;
import com.ups.xmlschema.xoltws.rate.v1.RateRequest;
import com.ups.xmlschema.xoltws.rate.v1.RateResponse;
import com.ups.xmlschema.xoltws.rate.v1.RatedShipmentType;
import com.ups.xmlschema.xoltws.rate.v1.ShipFromType;
import com.ups.xmlschema.xoltws.rate.v1.ShipToAddressType;
import com.ups.xmlschema.xoltws.rate.v1.ShipToType;
import com.ups.xmlschema.xoltws.rate.v1.ShipmentType;
import com.ups.xmlschema.xoltws.rate.v1.ShipperType;
import com.ups.xmlschema.xoltws.upss.v1.UPSSecurity;

/**
 * @author aruaro
 * 
 */
@Service
public class RateBO implements IRates {

    private static final Logger logger = LoggerFactory.getLogger(RateBO.class);

    RateService service;
    @Autowired
    IParamsSistemaDAO iParamsSistemaDAO;

    @Autowired
    IBusquedaCatalogoBO iBusquedaCatalogoBO;

    public RateBO() {
    }

    /* (non-Javadoc)
     * @see com.innovargia.salesmanager.ups.bo.impl.IRates#rates(com.administracion.dto.CotizacionTarifa, com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO)
     */
    @Override
    public List<CotizacionTarifa> rates(CotizacionTarifa cotiza,EtiquetaRotulacionDTO etiquetaDTO ) throws Exception{
	String statusCode = null;
	String description = null;
	
	
	 List<SistemaDTO> propiedad_sistema =  iParamsSistemaDAO.getRegistros(ConstantesGenerales.ID_SKY4SOL);
	    String ENDPOINT_URL = iParamsSistemaDAO.getValorPropiedad( "ups.endpoint.tarifas",propiedad_sistema);
	    String LICENSE_NUMBER = iParamsSistemaDAO.getValorPropiedad( "ups.license.number",propiedad_sistema); 
	    String PASSWORD = iParamsSistemaDAO.getValorPropiedad( "ups.password",propiedad_sistema); 
	    String USER_NAME = iParamsSistemaDAO.getValorPropiedad( "ups.usuario",propiedad_sistema); 
	    String SHIPPER_NUMBER = iParamsSistemaDAO.getValorPropiedad( "ups.shipper.number",propiedad_sistema); 
	    String SHIPPER_NAME = iParamsSistemaDAO.getValorPropiedad(  "ups.shipper.name",propiedad_sistema); 
	   
	    float TIPO_CAMBIO  = iParamsSistemaDAO.getValorPropiedadFloat("tipo.cambio.dollar",propiedad_sistema);


	List<CotizacionTarifa> lista_precios = new ArrayList<CotizacionTarifa>();

	List<RatedShipmentType> precios = null;

	CotizacionTarifa cotizacionTarifa = null;
	ChargesType cantidad = null;
	GuaranteedDeliveryType guaranteedDeliveryType = null;
	String descripcion = "";
	List<CatalogoDTO> lista_servicio = iBusquedaCatalogoBO
		.getServicioInternacional();
	logger.debug("Cantidd de servicios internaionales:" + lista_servicio.size());
	for (CatalogoDTO catalogoDTO : lista_servicio) {
	    cotiza.setGarantiamaxina(catalogoDTO.getClave());
	    cotiza.setDescripciongarantiamaxima(catalogoDTO.getDescripcion());
	    
	    logger.debug("Servicio:" +  cotiza.getGarantiamaxina() + "-" +cotiza.getDescripciongarantiamaxima()) ;

	    try {
		service = new RateService();
		RatePortType ratePortType = service.getRatePort();

		BindingProvider bp = (BindingProvider) ratePortType;
		bp.getRequestContext()
			.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				ENDPOINT_URL);

		RateResponse rateResponse = ratePortType
			.processRate(
				populateRateRequest(etiquetaDTO, cotiza,
					SHIPPER_NUMBER, SHIPPER_NAME),
				populateUPSSecurity(LICENSE_NUMBER, USER_NAME,
					PASSWORD));

		precios = rateResponse.getRatedShipment();
		cotizacionTarifa = new CotizacionTarifa();

		for (RatedShipmentType ratedShipmentType : precios) {
		    guaranteedDeliveryType = ratedShipmentType
			    .getGuaranteedDelivery();
		    
		 
			cantidad = ratedShipmentType.getTotalCharges();
			  
			    descripcion = cotiza.getDescripciongarantiamaxima();
			    if (guaranteedDeliveryType != null) {
				descripcion = descripcion + " "
					+ guaranteedDeliveryType.getDeliveryByTime();
			    }
			    cotizacionTarifa.setNombre(descripcion);
			    cotizacionTarifa.setCantidadenvios(cotiza
				    .getCantidadenvios());
			    cotizacionTarifa.setGarantia(cotiza.getGarantiamaxina());
			    cotizacionTarifa.setDescripciongarantiamaxima(cotiza
				    .getDescripciongarantiamaxima());
			    cotizacionTarifa.setPesoamparado(etiquetaDTO
				    .getPesofisico());
			    cotizacionTarifa.setTipocambiodolar(TIPO_CAMBIO);
			    cotizacionTarifa.setPreciodolares(cantidad
				    .getMonetaryValue());
			    cotizacionTarifa.setPrecio(TIPO_CAMBIO
				    * cotizacionTarifa.getPreciodolares());
			    cotizacionTarifa.setTotalprecioenvios(cotizacionTarifa
				    .getPrecio() * cotiza.getCantidadenvios());

			    lista_precios.add(cotizacionTarifa);
		    
		    

		}

		statusCode = rateResponse.getResponse().getResponseStatus()
			.getCode();
		description = rateResponse.getResponse().getResponseStatus()
			.getDescription();
	    } catch (Exception e) {
			if (e instanceof RateErrorMessage) {
			    RateErrorMessage rateErrMsg = ((RateErrorMessage) e);
			    statusCode = rateErrMsg.getFaultInfo().getErrorDetail()
				    .get(0).getPrimaryErrorCode().getCode();
			    description = rateErrMsg.getFaultInfo().getErrorDetail()
				    .get(0).getPrimaryErrorCode().getDescription();
	
			} else {
			    statusCode = e.getMessage();
			    description = e.toString();
	
			}
	
			logger.error("statusCode:" + statusCode + ", description:"
				+ description);
			throw new Exception("Error al obtener la info de UPS:statusCode->"+
				statusCode+ ", "+description);
	    }

	}
	
	return lista_precios;
    }

    private RateRequest populateRateRequest(EtiquetaRotulacionDTO etiquetaDTO,
	    CotizacionTarifa cotiza, String SHIPPER_NUMBER, String SHIPPER_NAME) {
	RateRequest rateRequest = new RateRequest();
	RequestType request = new RequestType();
	// String[] requestOption = { "rate" };
	// request.setRequestOption(requestOption);
	List<String> requestOptionList = request.getRequestOption();
	requestOptionList.add("rate");
	rateRequest.setRequest(request);

	ShipmentType shpmnt = new ShipmentType();

	/** *******Shipper *********************/
	ShipperType shipper = new ShipperType();
	shipper.setName(SHIPPER_NAME);
	shipper.setShipperNumber(SHIPPER_NUMBER);
	AddressType shipperAddress = new AddressType();

	List<String> addressLine = shipperAddress.getAddressLine();
	addressLine.add(etiquetaDTO.getCalle_rem());
	addressLine.add(etiquetaDTO.getNumexterior_rem());

	shipperAddress.setCity(etiquetaDTO.getCiudad_rem());
	shipperAddress.setPostalCode(etiquetaDTO.getCp_rem());
	shipperAddress.setStateProvinceCode("");
	shipperAddress.setCountryCode(etiquetaDTO.getPais_rem());
	shipper.setAddress(shipperAddress);
	shpmnt.setShipper(shipper);

	/*
	 * ShipperType shipper = new ShipperType();
	 * shipper.setName("XYZ Associates");
	 * shipper.setShipperNumber("222006"); AddressType shipperAddress = new
	 * AddressType();
	 * 
	 * //String[] addressLines = { "Southam Rd", "Apt 3B" };
	 * //shipperAddress.setAddressLine(addressLines); List<String>
	 * addressLine = shipperAddress.getAddressLine();
	 * addressLine.add("Southam Rd"); addressLine.add("Apt 3B");
	 * 
	 * shipperAddress.setCity("TimoniumCity");
	 * shipperAddress.setPostalCode("21093");
	 * shipperAddress.setStateProvinceCode("MD");
	 * shipperAddress.setCountryCode("US");
	 * shipper.setAddress(shipperAddress); shpmnt.setShipper(shipper);
	 */
	/** ******Shipper **********************/

	/** ************ShipFrom *******************/
	ShipFromType shipFrom = new ShipFromType();
	shipFrom.setName(etiquetaDTO.getRazonsocial_rem());
	AddressType shipFromAddress = new AddressType();
	// shipFromAddress.setAddressLine(addressLines);
	List<String> shipFromAddressLine = shipFromAddress.getAddressLine();
	shipFromAddressLine.add(etiquetaDTO.getCalle_rem());
	shipFromAddressLine.add(etiquetaDTO.getNumexterior_rem());

	shipFromAddress.setCity(etiquetaDTO.getCiudad_rem());
	shipFromAddress.setPostalCode(etiquetaDTO.getCp_rem());
	shipFromAddress.setStateProvinceCode("");
	shipFromAddress.setCountryCode(etiquetaDTO.getPais_rem());
	shipFrom.setAddress(shipFromAddress);
	shpmnt.setShipFrom(shipFrom);
	/** ***********ShipFrom **********************/

	/** ************ShipTo *******************/
	ShipToType shipTo = new ShipToType();
	shipTo.setName(etiquetaDTO.getRazonsocial_des());
	ShipToAddressType shipToAddress = new ShipToAddressType();
	// String[] shipToAddressLines = { "SomeUnknownStreet" };
	// shipToAddress.setAddressLine(shipToAddressLines);
	List<String> shipToAddresLine = shipToAddress.getAddressLine();
	shipToAddresLine.add(etiquetaDTO.getCalle_des());
	shipToAddress.setCity(etiquetaDTO.getCiudad_des());
	shipToAddress.setPostalCode(etiquetaDTO.getCp_des());
	shipToAddress.setStateProvinceCode("");
	shipToAddress.setCountryCode(etiquetaDTO.getPais_des());
	shipTo.setAddress(shipToAddress);
	shpmnt.setShipTo(shipTo);
	/** ***********ShipTo **********************/

	/********** Service********************** */
	CodeDescriptionType codeDescriptionType = new CodeDescriptionType();

	codeDescriptionType.setCode(cotiza.getGarantiamaxina());
	codeDescriptionType.setDescription(cotiza
		.getDescripciongarantiamaxima());
	shpmnt.setService(codeDescriptionType);
	/** ********Service ***********************/

	/******************** Package***************** */
	PackageType pkg1 = new PackageType();
	CodeDescriptionType pkgingType = new CodeDescriptionType();
	pkgingType.setCode(etiquetaDTO.getTipoempaque());
	pkgingType.setDescription(UtilsUPS.getTipoEmpaqueUPS(etiquetaDTO
		.getTipoempaque()));
	pkg1.setPackagingType(pkgingType);
	PackageWeightType pkgWeight = new PackageWeightType();
	CodeDescriptionType UOMType = new CodeDescriptionType();
	UOMType.setCode(etiquetaDTO.getPesomedida());
	UOMType.setDescription(UtilsUPS.getMedidaPeso(etiquetaDTO
		.getPesomedida()));
	pkgWeight.setUnitOfMeasurement(UOMType);
	pkgWeight.setWeight(etiquetaDTO.getPesofisico() + "");
	pkg1.setPackageWeight(pkgWeight);
	// PackageType[] pkgArray = { pkg1 };

	// shpmnt.set_package(pkgArray);
	List<PackageType> pTypeList = shpmnt.getPackage();
	pTypeList.add(pkg1);
	/******************** Package ******************/
	rateRequest.setShipment(shpmnt);
	return rateRequest;
    }

    private static UPSSecurity populateUPSSecurity(String LICENSE_NUMBER,
	    String USER_NAME, String PASSWORD) {
	UPSSecurity upss = new UPSSecurity();
	UPSSecurity.ServiceAccessToken upsSvcToken = new UPSSecurity.ServiceAccessToken();
	upsSvcToken.setAccessLicenseNumber(LICENSE_NUMBER);
	upss.setServiceAccessToken(upsSvcToken);
	UPSSecurity.UsernameToken upsSecUsrnameToken = new UPSSecurity.UsernameToken();
	upsSecUsrnameToken.setUsername(USER_NAME);
	upsSecUsrnameToken.setPassword(PASSWORD);
	upss.setUsernameToken(upsSecUsrnameToken);
	return upss;
    }

}
