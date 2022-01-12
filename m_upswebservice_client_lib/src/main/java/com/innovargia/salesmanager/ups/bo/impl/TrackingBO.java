package com.innovargia.salesmanager.ups.bo.impl;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.idao.IParamsSistemaDAO;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.CuentasConexionMensajeriaDTO;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.salesmanager.ups.ibo.ITrackingBO;
import com.servicio.constantes.ConstantesGenerales;

import java.io.BufferedWriter;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.xml.ws.BindingProvider;

import com.ups.wsdl.xoltws.track.v2.TrackErrorMessage;
import com.ups.wsdl.xoltws.track.v2.TrackPortType;
import com.ups.wsdl.xoltws.track.v2.TrackService;
import com.ups.xmlschema.xoltws.common.v1.RequestType;
import com.ups.xmlschema.xoltws.track.v2.ActivityType;
import com.ups.xmlschema.xoltws.track.v2.PackageType;
import com.ups.xmlschema.xoltws.track.v2.ShipmentActivityType;
import com.ups.xmlschema.xoltws.track.v2.ShipmentType;
import com.ups.xmlschema.xoltws.track.v2.TrackRequest;
import com.ups.xmlschema.xoltws.track.v2.TrackResponse;
import com.ups.xmlschema.xoltws.upss.v1.UPSSecurity;

@Service
public class TrackingBO implements ITrackingBO {

	private static final Logger logger = LoggerFactory.getLogger(RateBO.class);

	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;

	public TrackingBO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<LogHistoriaDTO> trackingS(CuentasConexionMensajeriaDTO cuentaconexion, EtiquetaRotulacionDTO etiqueta)
			throws Exception {

		List<LogHistoriaDTO> ar_historia = new ArrayList<LogHistoriaDTO>();
		LogHistoriaDTO historia = null;
		try {
			//List<SistemaDTO> propiedad_sistema = iParamsSistemaDAO.getRegistros(ConstantesGenerales.ID_SKY4SOL);
			String ENDPOINT_URL = cuentaconexion.getPropertiesString("endpoint_consulta");// cuentaconexion.getEndpoint_creacion();
			String LICENSE_NUMBER = cuentaconexion.getPropertiesString("LICENSE_NUMBER");// cuentaconexion.getNumclientearrier();
			String PASSWORD = cuentaconexion.getPropertiesString("PASSWORD");// cuentaconexion.getPassword();
			String USER_NAME = cuentaconexion.getPropertiesString("USER_NAME");// cuentaconexion.getLogin();
			String SHIPPER_NUMBER = cuentaconexion.getPropertiesString("SHIPPER_NUMBER");// cuentaconexion.getSuscriberid();
			String SHIPPER_NAME = cuentaconexion.getPropertiesString("SHIPPER_NAME");// cuentaconexion.getOficina_organizacion();
			String VALIDATE_ADDRESS = cuentaconexion.getPropertiesString("VALIDATE_ADDRESS");// "nonvalidate";//iParamsSistemaDAO.getValorPropiedad(
																								// "ups.validate.address",propiedad_sistema);

			logger.debug("DATOS CONEXION: SHIPPER_NUMBER->" + SHIPPER_NUMBER + "SHIPPER_NAME->" + SHIPPER_NAME
					+ "VALIDATE_ADDRESS->" + VALIDATE_ADDRESS + "LICENSE_NUMBER->"
					+ LICENSE_NUMBER + "ENDPOINT_URL->" + ENDPOINT_URL + "LICENSE_NUMBER->" + USER_NAME
					+ "DATOS CONEXION: USER_NAME->" + USER_NAME + "PASSWORD->" + PASSWORD + "ACCION A REALIZAR->"
				);

			TrackService service = new TrackService();
			TrackPortType trackPortType = service.getTrackPort();

			BindingProvider bp = (BindingProvider) trackPortType;
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ENDPOINT_URL);

			TrackResponse trackResponse = trackPortType.processTrack(
					populateTrackRequest(etiqueta.getIdguiainternacional()),
					populateUPSSecurity(USER_NAME, PASSWORD, LICENSE_NUMBER));

			List<ShipmentType> shipments = trackResponse.getShipment();

			List<ShipmentActivityType> activities = null;
			List<ActivityType> package_activities = null;
			for (ShipmentType shipment : shipments) {
				activities = shipment.getActivity();
				List<PackageType> packages = shipment.getPackage();
				for (PackageType aPackage : packages) {
					package_activities = aPackage.getActivity();
					for (ActivityType activity : package_activities) {
						historia = new LogHistoriaDTO();
						historia.setDescripcion(activity.getStatus().getDescription());
						historia.setRegistro(activity.getStatus().getType());
						historia.setTipomovimiento(activity.getStatus().getType());
						historia.setFecha(activity.getDate() + activity.getTime());
						historia.setExclave(activity.getActivityLocation().getSignedForByName());
						historia.setEntregadoA(activity.getActivityLocation().getSignedForByName());
						ar_historia.add(historia);


					}
				}

			}

		} catch (Exception e) {
			logger.debug("Errror al invocar el tracking: " + e.getMessage());
			e.printStackTrace();
		}
		return ar_historia;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.salesmanager.ups.bo.impl.IShipBO#ship(com.innovargia.
	 * rotulacion.dtos.EtiquetaRotulacionDTO)
	 */
	@Override
	public List<LogHistoriaDTO> tracking(EtiquetaRotulacionDTO etiqueta, int accion) throws Exception {

		List<LogHistoriaDTO> ar_historia = new ArrayList<LogHistoriaDTO>();
		LogHistoriaDTO historia = null;
		try {
			List<SistemaDTO> propiedad_sistema = iParamsSistemaDAO.getRegistros(ConstantesGenerales.ID_SKY4SOL);
			String ENDPOINT_URL = iParamsSistemaDAO.getValorPropiedad("ups.endpoint.tracking", propiedad_sistema);
			String LICENSE_NUMBER = iParamsSistemaDAO.getValorPropiedad("ups.license.number", propiedad_sistema);
			String PASSWORD = iParamsSistemaDAO.getValorPropiedad("ups.password", propiedad_sistema);
			String USER_NAME = iParamsSistemaDAO.getValorPropiedad("ups.usuario", propiedad_sistema);
			String SHIPPER_NUMBER = iParamsSistemaDAO.getValorPropiedad("ups.shipper.number", propiedad_sistema);
			String SHIPPER_NAME = iParamsSistemaDAO.getValorPropiedad("ups.shipper.name", propiedad_sistema);
			String PATH_GIF_UPS = iParamsSistemaDAO.getValorPropiedad("ups.path.label.ship", propiedad_sistema);
			String VALIDATE_ADDRESS = null;// iParamsSistemaDAO.getValorPropiedad(
											// "ups.validate.address",propiedad_sistema);

			logger.debug("DATOS CONEXION: SHIPPER_NUMBER->" + SHIPPER_NUMBER + "SHIPPER_NAME->" + SHIPPER_NAME
					+ "PATH_GIF_UPS->" + PATH_GIF_UPS + "VALIDATE_ADDRESS->" + VALIDATE_ADDRESS + "LICENSE_NUMBER->"
					+ LICENSE_NUMBER + "ENDPOINT_URL->" + ENDPOINT_URL + "LICENSE_NUMBER->" + USER_NAME
					+ "DATOS CONEXION: USER_NAME->" + USER_NAME + "PASSWORD->" + PASSWORD + "ACCION A REALIZAR->"
					+ (accion == 1 ? "CREAR VENTA UPS" : "VALIDAR DATOS"));

			TrackService service = new TrackService();
			TrackPortType trackPortType = service.getTrackPort();

			BindingProvider bp = (BindingProvider) trackPortType;
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, ENDPOINT_URL);

			TrackResponse trackResponse = trackPortType.processTrack(
					populateTrackRequest(etiqueta.getIdguiainternacional()),
					populateUPSSecurity(USER_NAME, PASSWORD, LICENSE_NUMBER));

			List<ShipmentType> shipments = trackResponse.getShipment();

			List<ShipmentActivityType> activities = null;
			List<ActivityType> package_activities = null;
			for (ShipmentType shipment : shipments) {
				activities = shipment.getActivity();
				List<PackageType> packages = shipment.getPackage();
				for (PackageType aPackage : packages) {
					package_activities = aPackage.getActivity();
					for (ActivityType activity : package_activities) {
						historia = new LogHistoriaDTO();
						historia.setDescripcion(activity.getStatus().getDescription());
						historia.setRegistro(activity.getStatus().getType());
						historia.setTipomovimiento(activity.getStatus().getType());
						historia.setFecha(activity.getDate() + activity.getTime());
						historia.setExclave(activity.getActivityLocation().getSignedForByName());
						historia.setEntregadoA(activity.getActivityLocation().getSignedForByName());
						ar_historia.add(historia);

						/*
						 * logger.debug( "SignedForByName:"
						 * +activity.getActivityLocation().getSignedForByName()+
						 * ","+ "Estatus:" +activity.getStatus().getType() + ","
						 * + activity.getStatus().getCode()+","+
						 * activity.getStatus().getDescription() + "," + "Time:"
						 * +activity.getTime()+","+ "Date:"
						 * +activity.getDate());
						 */

					}
				}

			}

		} catch (Exception e) {
			logger.debug("Errror al invocar el tracking: " + e.getMessage());
			e.printStackTrace();
		}
		return ar_historia;
	}

	private TrackRequest populateTrackRequest(String guiainternacional) {

		TrackRequest trackRequest = new TrackRequest();
		RequestType request = new RequestType();

		List<String> requestOption = request.getRequestOption();
		requestOption.add("1");
		requestOption.add("15");
		requestOption.add("2");
		requestOption.add("3");
		requestOption.add("5");
		requestOption.add("8");
		requestOption.add("8");

		trackRequest.setRequest(request);
		trackRequest.setInquiryNumber(guiainternacional);
		trackRequest.setTrackingOption("02");
		return trackRequest;
	}

	public UPSSecurity populateUPSSecurity(String userName, String password, String accessKey) {

		UPSSecurity upss = new UPSSecurity();
		UPSSecurity.ServiceAccessToken upsSvcToken = new UPSSecurity.ServiceAccessToken();
		upsSvcToken.setAccessLicenseNumber(accessKey);
		upss.setServiceAccessToken(upsSvcToken);
		UPSSecurity.UsernameToken upsSecUsrnameToken = new UPSSecurity.UsernameToken();
		upsSecUsrnameToken.setUsername(userName);
		upsSecUsrnameToken.setPassword(password);
		upss.setUsernameToken(upsSecUsrnameToken);

		return upss;
	}

}
