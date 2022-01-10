package com.tracusa.logistica.bo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.administracion.idao.IParamsSistemaDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoTable;
import com.tracusa.logistica.interfaces.bo.ICartaPorteBO;
import com.tracusa.logistica.interfaces.dao.ICartaPorteDAO;
import com.tracusa.logistica.model.AutotransporteFederal;
import com.tracusa.logistica.model.CartaPorte;
import com.tracusa.logistica.model.CartaPorteResumen;
import com.tracusa.logistica.model.Destino;
import com.tracusa.logistica.model.DetalleFactura;
import com.tracusa.logistica.model.DetalleMercancia;
import com.tracusa.logistica.model.Domicilio;
import com.tracusa.logistica.model.FacturaCCP;
import com.tracusa.logistica.model.FiguraTransporte;
import com.tracusa.logistica.model.IdentificacionVehicular;
import com.tracusa.logistica.model.Mercancia;
import com.tracusa.logistica.model.Mercancias;
import com.tracusa.logistica.model.Operador;
import com.tracusa.logistica.model.Operadores;
import com.tracusa.logistica.model.Origen;
import com.tracusa.logistica.model.Remolque;
import com.tracusa.logistica.model.Remolques;
import com.tracusa.logistica.model.SapResult;
import com.tracusa.logistica.model.Ubicacion;
import com.tracusa.logistica.model.Ubicaciones;
import com.tracusa.logistica.model.ViajeFinCarga;
import com.tracusa.logistica.unigis.ccp.CantidadTransporta;
import com.tracusa.logistica.unigis.ccp.ClienteDador;
import com.tracusa.logistica.unigis.ccp.Ubicacione;
import com.tracusa.logistica.unigis.ccp.UnigisCCP;
import com.tracusa.logistica.unigis.ccp.ViajeUnigis;
import com.tracusa.logistica.unigis.ccp.ViajesSAT;

import ar.com.unisolutions.ConsultarViajeResultado;
import ar.com.unisolutions.PArchivoDoc;
import ar.com.unisolutions.PAsociarEntidad;
import ar.com.unisolutions.PDocumento;
import ar.com.unisolutions.PParada;
import ar.com.unisolutions.PViaje;
import ar.com.unisolutions.ServiceLocator;
import ar.com.unisolutions.ServiceSoap;
import me.saro.sap.jco.SapFunction;
import me.saro.sap.jco.SapFunctionResult;
import me.saro.sap.jco.SapManager;
import me.saro.sap.jco.SapManagerBuilderOption;

@Service
public class CartaPorteBO implements ICartaPorteBO {

    @Autowired
    ICartaPorteDAO iCartaPorteDAO;

    RestTemplate restTemplate;

    private String uniServer;

    @Autowired
    IParamsSistemaDAO iParamsSistemaDAO;

    @Override
    public ConsultarViajeResultado getViaje(ViajeFinCarga viaje) throws Exception {

	CartaPorte cartaPorte = new CartaPorte();

	try {

	    // Comienza el proceso de invocacion del WS
	    java.net.URL portAddress;

	    uniServer = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.server", "UNIGIS");

	    portAddress = new java.net.URL(uniServer);

	    ServiceLocator locator = new ServiceLocator();
	    ServiceSoap proxy = locator.getServiceSoap(portAddress);

	    String apiKey = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.apikey", "UNIGIS");

	    ConsultarViajeResultado consultarViaje = proxy.consultarViaje(apiKey, viaje.getIdViaje());

	    cartaPorte.setVersion("1.0");
	    cartaPorte.setTranspInternac("");

	    Ubicaciones ubicaciones = new Ubicaciones();

	    Ubicacion ubicacion = new Ubicacion();

	    ubicacion.setDistanciaRecorrida(consultarViaje.getKmsPlan().toString());

	    Origen origen = new Origen();

	    origen.setIDOrigen(consultarViaje.getDepositoSalida().getRefDepositoExterno());
	    origen.setRFCRemitente(consultarViaje.getParadas()[0].getClienteDador().getCuit());
	    origen.setNombreRemitente(consultarViaje.getParadas()[0].getClienteDador().getRazonSocial());

	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	    String formatted = format1.format(consultarViaje.getFechaInicioPlan().getTime());

	    origen.setFechaHoraSalida(formatted);

	    Destino destino = new Destino();

	    destino.setIDDestino(consultarViaje.getParadas()[0].getCliente().getInt1().toString());
	    destino.setRFCDestinatario(consultarViaje.getParadas()[0].getCliente().getVarchar1());
	    destino.setNombreDestinatario(consultarViaje.getParadas()[0].getCliente().getRazonSocial());

	    formatted = format1.format(consultarViaje.getParadas()[0].getInicioHorarioPlanificado().getTime());
	    destino.setFechaHoraProgLlegada(formatted);

	    Domicilio domicilio = new Domicilio();

	    domicilio.setCalle(consultarViaje.getParadas()[0].getCliente().getCalle());
	    domicilio.setMunicipio(consultarViaje.getParadas()[0].getCliente().getBarrio());
	    domicilio.setEstado(consultarViaje.getParadas()[0].getCliente().getLocalidad());
	    domicilio.setPais(consultarViaje.getParadas()[0].getCliente().getPais());
	    domicilio.setCodigoPostal(consultarViaje.getParadas()[0].getCliente().getDomicilioCodigoPostal());

	    ubicacion.setOrigen(origen);
	    ubicacion.setDestino(destino);
	    // ubicacion.setDomicilio(domicilio);

	    ubicaciones.setUbicacion(ubicacion);

	    Mercancias mercancias = new Mercancias();

	    Mercancia mercancia = new Mercancia();

	    mercancia.setBienesTransp("");
	    mercancia.setDescripcion("");
	    mercancia.setCantidad("");
	    mercancia.setClaveUnidad("");
	    mercancia.setPesoEnKg(consultarViaje.getParadas()[0].getItems()[0].getPeso().toString());

	    DetalleMercancia detalleMercancia = new DetalleMercancia();

	    detalleMercancia.setUnidadPeso("KGM");
	    detalleMercancia.setPesoBruto(consultarViaje.getParadas()[0].getItems()[0].getPeso().toString());
	    detalleMercancia.setPesoNeto(consultarViaje.getParadas()[0].getItems()[0].getPeso().toString());
	    detalleMercancia.setPesoTara("0");

	    mercancia.setDetalleMercancia(detalleMercancia);

	    AutotransporteFederal autotransporteFederal = new AutotransporteFederal();

	    autotransporteFederal.setPermSCT("");
	    autotransporteFederal.setNumPermisoSCT("");
	    autotransporteFederal.setNombreAseg("");
	    autotransporteFederal.setNumPolizaSeguro("");

	    IdentificacionVehicular identificacionVehicular = new IdentificacionVehicular();

	    identificacionVehicular.setConfigVehicular(consultarViaje.getVehiculo().getVarchar1());
	    identificacionVehicular.setPlacaVM(consultarViaje.getVehiculo().getReferenciaExterna());
	    identificacionVehicular.setAnioModeloVM(consultarViaje.getVehiculo().getModelo());

	    Remolques remolques = new Remolques();

	    Remolque remolque = new Remolque();

	    remolque.setSubTipoRem(""); // VehiculoSecundario>Descripcion
	    remolque.setPlaca(consultarViaje.getVehiculo().getReferenciaExterna());

	    remolques.setRemolque(remolque);

	    identificacionVehicular.setRemolques(remolques);

	    autotransporteFederal.setIdentificacionVehicular(identificacionVehicular);

	    mercancias.setMercancia(mercancia);
	    mercancias.setAutotransporteFederal(autotransporteFederal);

	    FiguraTransporte figuraTransporte = new FiguraTransporte();

	    figuraTransporte.setCveTransporte("01");

	    Operadores operadores = new Operadores();

	    Operador operador = new Operador();

	    operador.setRFCOperador("");
	    operador.setNumLicencia("");
	    operador.setNombreOperador(consultarViaje.getConductor().getApellido());

	    domicilio.setCalle("");
	    domicilio.setMunicipio("");
	    domicilio.setEstado("");
	    domicilio.setPais("");
	    domicilio.setCodigoPostal("");

	    operador.setDomicilio(domicilio);

	    operadores.setOperador(operador);

	    figuraTransporte.setOperadores(operadores);

	    cartaPorte.setUbicaciones(ubicaciones);
	    cartaPorte.setMercancia(mercancia);
	    cartaPorte.setFiguraTransporte(figuraTransporte);

	    return consultarViaje;

	} catch (Exception e) {

	    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
		    "Error can not creating consignment note.");

	}

    }

    @Override
    public ConsultarViajeResultado getViajeToSap(ViajeFinCarga viaje) throws Exception {

	try {

	    // Comienza el proceso de invocacion del WS
	    java.net.URL portAddress;

	    uniServer = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.server", "UNIGIS");

	    portAddress = new java.net.URL(uniServer);

	    ServiceLocator locator = new ServiceLocator();

	    ServiceSoap proxy = locator.getServiceSoap(portAddress);

	    String apiKey = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.apikey", "UNIGIS");

	    ConsultarViajeResultado consultarViajeResultado = proxy.consultarViaje(apiKey, viaje.getIdViaje());

	    return consultarViajeResultado;

	} catch (Exception e) {

	    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
		    "Error can not creating consignment note.");

	}

    }

    // Conexion a SAP QAS
    private SapManager getSapManager() throws Exception {

	return SapManager.builder()
		.set(SapManagerBuilderOption.ASHOST,
			iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.host", "TRACUSA"))
		.set(SapManagerBuilderOption.SYSNR,
			iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.system.number", "TRACUSA")) // system number
		.set(SapManagerBuilderOption.LANG, "ES") // language code
		.set(SapManagerBuilderOption.CLIENT,
			iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.client", "TRACUSA")) // client number
		.set(SapManagerBuilderOption.USER,
			iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.user", "TRACUSA")) // user
		.set(SapManagerBuilderOption.PASSWD,
			iParamsSistemaDAO.getValorPropiedad("tracusa.sap.ws.password", "TRACUSA")) // password
		.build();
    }

    @Override
    public int createMarcaFactura(CartaPorteResumen cartaPorteResumen) throws Exception {

	return iCartaPorteDAO.createMarcaFactura(cartaPorteResumen);

    }

    @Override
    public void marcarGuias(int idControl, String factura, String lstDocumentos) {

	iCartaPorteDAO.marcarGuias(idControl, factura, lstDocumentos);

    }

    @SuppressWarnings("deprecation")
    @Override
    public List<SapResult> getFacturaSap(UnigisCCP unigisccp) throws Exception {

	List<SapResult> lstResult = new ArrayList<SapResult>();

	try {

	    List<FacturaCCP> lstFacturas = iCartaPorteDAO
		    .getClientesViaje(String.valueOf(unigisccp.getViajesSAT()[0].getViajeUnigis().getIDViaje()));

	    List<String> arr = new ArrayList<String>(lstFacturas.size());

	    if (!lstFacturas.isEmpty()) {

		for (FacturaCCP fccp : lstFacturas) {

		    arr.add(fccp.getCliente());

		}

	    }

	    String arrOperacion[] = unigisccp.getViajesSAT()[0].getViajeUnigis().getReferenciaExterna().split("-");

	    String depositoFacturar = arrOperacion[0];

	    int statusUpdate;

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	    SimpleDateFormat output = new SimpleDateFormat("yyyy-MM-dd");

	    SimpleDateFormat outputtime = new SimpleDateFormat("HH:mm:ss");

	    Date date;

	    String fecha;

	    // connect
	    SapManager sap = getSapManager();

	    // load sap function
	    SapFunction function = sap.getFunction("ZSD_VENTAS_LOGISTICA");

	    SapFunctionResult result = null;

	    // set parameters
	    function.getImportParameterList().setValue("P_PROCESO", "G");
	    function.getImportParameterList().setValue("P_TIPO", "F");
	    // function.getImportParameterList().setValue("P_KUNNR", "0000100053");
	    // function.getImportParameterList().setValue("P_BSTKD", "543");
	    function.getImportParameterList().setValue("P_DOCUMENTO", "G");
	    function.getImportParameterList().setValue("P_NUMDOC_LOG", "");
	    function.getImportParameterList().setValue("P_ZTERM", "D006");
	    function.getImportParameterList().setValue("P_CORREO", "ovillalobos@tracusa.com");
	    // function.getImportParameterList().setValue("P_AUART", "ZTA");
	    function.getImportParameterList().setValue("P_VSTEL", "LO01");
	    function.getImportParameterList().setValue("P_CCP", "X");

	    JCoTable T_MOV = function.getImportTableParameter("T_MOV");

	    T_MOV.appendRow();
	    T_MOV.setValue("POSNR", "000010");
	    // T_MOV.setValue("MATNR", "13156");
	    T_MOV.setValue("MATNR", "13173");

	    T_MOV.setValue("ZIEME", "SER");

	    JCoTable T_TXT_HEAD = function.getImportTableParameter("T_TXT_HEAD");

	    T_TXT_HEAD.appendRow();
	    T_TXT_HEAD.setValue("TDFORMAT", "");
	    T_TXT_HEAD.setValue("TDLINE", "");

	    JCoTable T_TXT_OPER = function.getImportTableParameter("T_TXT_OPER");

	    T_TXT_OPER.appendRow();
	    T_TXT_OPER.setValue("TDFORMAT", "");
	    T_TXT_OPER.setValue("TDLINE", "");

	    JCoTable T_OPERADOR = function.getImportTableParameter("T_OPERADOR");

	    com.tracusa.logistica.unigis.ccp.Operador operador = unigisccp.getViajesSAT()[0].getClienteDador()[0]
		    .getComplemento()[0].getAny()[0].getCartaportecartaporte().getFiguraTransporte().getOperadores()[0]
			    .getOperador();

	    T_OPERADOR.appendRow();
	    //T_OPERADOR.setValue("RFC_OPERADOR", operador.getRFCOperador() == "" ? "XAXX010101000" : operador.getRFCOperador());
	    //T_OPERADOR.setValue("NUM_LICENCIA", operador.getNumLicencia() == "" ? "ABC12345" : operador.getNumLicencia());
	    T_OPERADOR.setValue("RFC_OPERADOR", operador.getRFCOperador());
	    T_OPERADOR.setValue("NUM_LICENCIA", operador.getNumLicencia());
	    T_OPERADOR.setValue("NUM_REG_TRIB", operador.getNumRegIDTribOperador());
	    T_OPERADOR.setValue("RESIDENCIAFISCAL", operador.getResidenciaFiscalOperador());
	    /*
	    if(operador.getDomicilio().getMunicipio().equals("") || operador.getDomicilio().getEstado().equals("")) {
		
		    T_OPERADOR.setValue("CALLE", "Av. Zacatecas");
		    T_OPERADOR.setValue("MUNICIPIO", "091");
		    T_OPERADOR.setValue("ESTADO", "MEX");
		    T_OPERADOR.setValue("PAIS", "MEX");
		    T_OPERADOR.setValue("CODIGOPOSTAL", "54770");

		    
	    }else {
	    */
		    T_OPERADOR.setValue("CALLE", operador.getDomicilio().getCalle());
		    T_OPERADOR.setValue("MUNICIPIO", operador.getDomicilio().getMunicipio());
		    T_OPERADOR.setValue("ESTADO", operador.getDomicilio().getEstado());
		    T_OPERADOR.setValue("PAIS", operador.getDomicilio().getPais());
		    T_OPERADOR.setValue("CODIGOPOSTAL", operador.getDomicilio().getCodigoPostal());
		    
	   // }

	    JCoTable T_UNIDAD = function.getImportTableParameter("T_UNIDAD");

	    com.tracusa.logistica.unigis.ccp.AutotransporteFederal unidad = unigisccp.getViajesSAT()[0]
		    .getClienteDador()[0].getComplemento()[0].getAny()[0].getCartaportecartaporte().getMercancias()
			    .getAutotransporteFederal();

	    T_UNIDAD.appendRow();
	    T_UNIDAD.setValue("PERMISO_SCT", unidad.getPermSCT());
	    T_UNIDAD.setValue("NUMPERMIS_SCT", unidad.getNumPermisoSCT());
	    //T_UNIDAD.setValue("ASEGURADORA", unidad.getNombreAseg() == "" ? "Grupo Nacional Provi" : unidad.getNombreAseg());
	    T_UNIDAD.setValue("ASEGURADORA", unidad.getNombreAseg());
	    T_UNIDAD.setValue("POLIZASEGURO", unidad.getNumPolizaSeguro());
	    //T_UNIDAD.setValue("POLIZASEGURO", unidad.getNumPolizaSeguro() == "" ? "465178184" : unidad.getNumPolizaSeguro());
	    T_UNIDAD.setValue("CONFIGVEHICULAR", unidad.getIdentificacionVehicular().getConfigVehicular());
	    //T_UNIDAD.setValue("CONFIGVEHICULAR", "C2");
	    T_UNIDAD.setValue("PLACAVM", unidad.getIdentificacionVehicular().getPlacaVM());
	    //T_UNIDAD.setValue("PLACAVM", unidad.getIdentificacionVehicular().getPlacaVM() == "" ? "LV051" : unidad.getIdentificacionVehicular().getPlacaVM());
	    T_UNIDAD.setValue("ANIOMODELOVM", unidad.getIdentificacionVehicular().getAnioModeloVM());
	    //T_UNIDAD.setValue("ANIOMODELOVM", "2020");
	    T_UNIDAD.setValue("SUBTIPOREM", unidad.getIdentificacionVehicular().getRemolques()[0].getSubTipoRem());
	    T_UNIDAD.setValue("PLACAREM", unidad.getIdentificacionVehicular().getRemolques()[0].getPlaca());
	    //T_UNIDAD.setValue("SUBTIPOREM", "");
	    //T_UNIDAD.setValue("PLACAREM", "");


	    // set table parameters [example table parameter name is param4]
	    JCoTable T_UBICACION = function.getImportTableParameter("T_UBICACION");
	    JCoTable T_MERCANCIAS = function.getImportTableParameter("T_MERCANCIAS");

	    for (int i = 0; i < unigisccp.getViajesSAT()[0].getClienteDador().length; i++) {

		String numCliente = iCartaPorteDAO
			.getClientNumber(unigisccp.getViajesSAT()[0].getClienteDador()[i].getReceptor().getRFC());

		if (!lstFacturas.isEmpty() && !arr.contains(numCliente)) {

		    continue;

		}

		// String numCliente = "100053";

		switch (depositoFacturar) {
		// switch ("1800") {

		case "1800":

		    function.getImportParameterList().setValue("P_VKORG", "1800");
		    function.getImportParameterList().setValue("P_VTWEG", "L1");
		    function.getImportParameterList().setValue("P_SPART", "15");
		    function.getImportParameterList().setValue("P_WERKS", "2200");

		    switch (numCliente) {

		    case "100454":

			T_MOV.setValue("PRCTR", "000980000");

			break;

		    case "100339":

			T_MOV.setValue("PRCTR", "000980008");

			break;

		    case "100398":

			T_MOV.setValue("PRCTR", "000980009");

			break;

		    case "100053":

			T_MOV.setValue("PRCTR", "000984040");

			break;

		    default:

			T_MOV.setValue("PRCTR", "000984005");

			break;
		    }

		    break;

		case "1801":

		    function.getImportParameterList().setValue("P_VKORG", "1801");
		    function.getImportParameterList().setValue("P_VTWEG", "L3");

		    function.getImportParameterList().setValue("P_WERKS", "2500");

		    switch (numCliente) {

		    case "100454":

			function.getImportParameterList().setValue("P_SPART", "15");
			T_MOV.setValue("PRCTR", "000980000");

			break;

		    case "100339":

			function.getImportParameterList().setValue("P_SPART", "15");
			T_MOV.setValue("PRCTR", "000980008");

			break;

		    case "100398":

			function.getImportParameterList().setValue("P_SPART", "15");
			T_MOV.setValue("PRCTR", "000980009");

			break;

		    case "100288":

			function.getImportParameterList().setValue("P_SPART", "11");
			T_MOV.setValue("PRCTR", "000986050");

			break;

		    default:

			function.getImportParameterList().setValue("P_SPART", "15");
			T_MOV.setValue("PRCTR", "000986005");

			break;
		    }

		    break;

		case "1802":

		    function.getImportParameterList().setValue("P_VKORG", "1802");
		    function.getImportParameterList().setValue("P_VTWEG", "L4");

		    function.getImportParameterList().setValue("P_WERKS", "2600");

		    switch (numCliente) {

		    case "100454":

			function.getImportParameterList().setValue("P_SPART", "15");
			T_MOV.setValue("PRCTR", "000980000");

			break;

		    case "100339":

			function.getImportParameterList().setValue("P_SPART", "15");
			T_MOV.setValue("PRCTR", "000980008");

			break;

		    case "100398":

			function.getImportParameterList().setValue("P_SPART", "15");
			T_MOV.setValue("PRCTR", "000980009");

			break;

		    case "100053":

			function.getImportParameterList().setValue("P_SPART", "15");
			T_MOV.setValue("PRCTR", "000980040");

			break;

		    case "100288":

			function.getImportParameterList().setValue("P_SPART", "11");
			T_MOV.setValue("PRCTR", "000980050");

			break;

		    case "100423":

			function.getImportParameterList().setValue("P_SPART", "15");
			T_MOV.setValue("PRCTR", "000980055");

			break;

		    default:

			function.getImportParameterList().setValue("P_SPART", "15");
			T_MOV.setValue("PRCTR", "000980005");

			break;
		    }

		    break;

		case "1803":

		    function.getImportParameterList().setValue("P_VKORG", "1803");
		    function.getImportParameterList().setValue("P_VTWEG", "L5");
		    function.getImportParameterList().setValue("P_SPART", "15");
		    function.getImportParameterList().setValue("P_WERKS", "2700");

		    switch (numCliente) {

		    case "100454":

			T_MOV.setValue("PRCTR", "000980000");

			break;

		    case "100339":

			T_MOV.setValue("PRCTR", "000980008");

			break;

		    case "100398":

			T_MOV.setValue("PRCTR", "000980009");

			break;

		    case "100053":

			T_MOV.setValue("PRCTR", "000982040");

			break;

		    default:

			T_MOV.setValue("PRCTR", "000982005");

			break;
		    }

		    break;
		}

		// String numCliente = iCartaPorteDAO
		// .getClientNumber(unigisccp.getViajesSAT()[0].getClienteDador()[i].getEmisor().getRFC());
		// String numCliente = "100053";

		Ubicacione[] ubicaciones = unigisccp.getViajesSAT()[0].getClienteDador()[i].getComplemento()[0]
			.getAny()[0].getCartaportecartaporte().getUbicaciones();

		List<Ubicacione> lstUbicaciones = new ArrayList<>();

		for (int j = 0; j < ubicaciones.length; j++) {

		    T_UBICACION.appendRow();

		    T_UBICACION.setValue("IDNUM_UBICACION", j + 1);
		    T_UBICACION.setValue("DIST_RECORRIDA", ubicaciones[j].getDistanciaRecorrida());
		    T_UBICACION.setValue("IDORIGEN", ubicaciones[j].getOrigen().getIDOrigen());
		    //T_UBICACION.setValue("RFCREMITENTE", ubicaciones[j].getOrigen().getRFCRemitente() == "" ? "XAXX010101000" : ubicaciones[j].getOrigen().getRFCRemitente());
		    T_UBICACION.setValue("RFCREMITENTE", ubicaciones[j].getOrigen().getRFCRemitente());
		    date = sdf.parse(ubicaciones[j].getOrigen().getFechaHoraSalida());
		    fecha = output.format(date);
		    // fecha = format1.format(ubicaciones[j].getOrigen().getFechaHoraSalida());
		    // fecha = format1.format(ubicaciones[j].getOrigen().getFechaHoraSalida());
		    T_UBICACION.setValue("FECHA_SALIDA", fecha);
		    date = sdf.parse(ubicaciones[j].getOrigen().getFechaHoraSalida());
		    fecha = outputtime.format(date);
		    // fecha = format2.format(ubicaciones[j].getOrigen().getFechaHoraSalida());
		    T_UBICACION.setValue("HORA_SALIDA", fecha);
		    /*
		    if(ubicaciones[j].getOrigen().getDomicilio().getMunicipio().equals("") || ubicaciones[j].getOrigen().getDomicilio().getEstado().equals("")) {
			
			    T_UBICACION.setValue("RCALLE", "CLIENTE FINAL");
			    T_UBICACION.setValue("RMUNICIPIO", "010");
			    T_UBICACION.setValue("RESTADO", "DIF");
			    T_UBICACION.setValue("RPAIS", "MEX");
			    T_UBICACION.setValue("RCODIGOPOSTAL", "01010");

			    
		    }else {
		    */
			    T_UBICACION.setValue("RCALLE", ubicaciones[j].getOrigen().getDomicilio().getCalle());
			    T_UBICACION.setValue("RMUNICIPIO", ubicaciones[j].getOrigen().getDomicilio().getMunicipio());
			    T_UBICACION.setValue("RESTADO", ubicaciones[j].getOrigen().getDomicilio().getEstado());
			    T_UBICACION.setValue("RPAIS", ubicaciones[j].getOrigen().getDomicilio().getPais());
			    T_UBICACION.setValue("RCODIGOPOSTAL", ubicaciones[j].getOrigen().getDomicilio().getCodigoPostal());

			    
		    //}

		    T_UBICACION.setValue("IDDESTINATARIO", ubicaciones[j].getDestino().getIDDestino());
		    //T_UBICACION.setValue("RFCDESTINATARIO", ubicaciones[j].getDestino().getRFCDestinatario() == "" ? "XAXX010101000" : ubicaciones[j].getDestino().getRFCDestinatario());
		    T_UBICACION.setValue("RFCDESTINATARIO", ubicaciones[j].getDestino().getRFCDestinatario());
		    /*
		    if(ubicaciones[j].getDestino().getDomicilio().getMunicipio().equals("") || ubicaciones[j].getDestino().getDomicilio().getEstado().equals("")) {
			
			    T_UBICACION.setValue("DCALLE", "AV. ZACATECAS");
			    T_UBICACION.setValue("DMUNICIPIO", "091");
			    T_UBICACION.setValue("DESTADO", "MEX");
			    T_UBICACION.setValue("DPAIS", "MEX");
			    T_UBICACION.setValue("DCODIGOPOSTAL", "54786");
			    
		    }else {
		    */
			    T_UBICACION.setValue("DCALLE", ubicaciones[j].getDestino().getDomicilio().getCalle());
			    T_UBICACION.setValue("DMUNICIPIO", ubicaciones[j].getDestino().getDomicilio().getMunicipio());
			    T_UBICACION.setValue("DESTADO", ubicaciones[j].getDestino().getDomicilio().getEstado());
			    T_UBICACION.setValue("DPAIS", ubicaciones[j].getDestino().getDomicilio().getPais());
			    T_UBICACION.setValue("DCODIGOPOSTAL", ubicaciones[j].getDestino().getDomicilio().getCodigoPostal());
			
		   // }
		   
		    date = sdf.parse(ubicaciones[j].getDestino().getFechaHoraProgLlegada());
		    fecha = output.format(date);
		    // fecha =
		    // format1.format(ubicaciones[j].getDestino().getFechaHoraProgLlegada());
		    T_UBICACION.setValue("FECHA_LLEGADA", fecha);
		    date = sdf.parse(ubicaciones[j].getDestino().getFechaHoraProgLlegada());
		    fecha = outputtime.format(date);
		    // fecha =
		    // format1.format(ubicaciones[j].getDestino().getFechaHoraProgLlegada());
		    T_UBICACION.setValue("HORA_LLEGADA", fecha);

		    lstUbicaciones.add(ubicaciones[j]);

		}

		// RFCDESTINATARIO

		com.tracusa.logistica.unigis.ccp.Mercancia[] mercancias = unigisccp.getViajesSAT()[0]
			.getClienteDador()[i].getComplemento()[0].getAny()[0].getCartaportecartaporte().getMercancias()
				.getMercancia();

		int index = 1;

		for (int k = 0; k < mercancias.length; k++) {

		    com.tracusa.logistica.unigis.ccp.CantidadTransporta[] cantidadTransporta = unigisccp
			    .getViajesSAT()[0].getClienteDador()[i].getComplemento()[0].getAny()[0]
				    .getCartaportecartaporte().getMercancias().getMercancia()[k]
					    .getCantidadTransporta();

		    for (int u = 0; u < lstUbicaciones.size(); u++) {

			for (int t = 0; t < cantidadTransporta.length; t++) {

			    if (cantidadTransporta[t].getIDOrigen()
				    .equals(lstUbicaciones.get(u).getOrigen().getIDOrigen())
				    && cantidadTransporta[t].getIDDestino()
					    .equals(lstUbicaciones.get(u).getDestino().getIDDestino())) {

				T_MERCANCIAS.appendRow();

				T_MERCANCIAS.setValue("IDNUM_UBICACION", u + 1);

				T_MERCANCIAS.setValue("IDNUM_MCIA", index);
				T_MERCANCIAS.setValue("BIENESTRANSP", mercancias[k].getBienesTransp());
				//T_MERCANCIAS.setValue("BIENESTRANSP", "01010101");
				T_MERCANCIAS.setValue("DESCRIPCION", mercancias[k].getDescripcion());
				//T_MERCANCIAS.setValue("DESCRIPCION", "NO EXISTE EN EL CATÁLOGO");
				T_MERCANCIAS.setValue("CANTIDAD", (int) cantidadTransporta[t].getCantidad());
				T_MERCANCIAS.setValue("CLAVEUNIDAD", "PR");
				T_MERCANCIAS.setValue("PESOENKG", mercancias[k].getPesoEnKg());
				//T_MERCANCIAS.setValue("PESOENKG", "KGM");
				T_MERCANCIAS.setValue("UNIDADPESO", mercancias[k].getClaveUnidad());
				//T_MERCANCIAS.setValue("UNIDADPESO", "KGM");

				index++;
			    }

			}

		    }

		    // T_MERCANCIAS.setValue("UNIDADPESO",
		    // mercancias[i].getDetalleMercancia().getUnidadPeso());
		    // T_MERCANCIAS.setValue("PESOBRUTO",
		    // mercancias[i].getDetalleMercancia().getPesoBruto());
		    // T_MERCANCIAS.setValue("PESONETO",
		    // mercancias[i].getDetalleMercancia().getPesoNeto());
		    // T_MERCANCIAS.setValue("PESOTARA",
		    // mercancias[i].getDetalleMercancia().getPesoTara());

		}

		T_MOV.setValue("ZMENG", String.valueOf(mercancias.length));
		// T_MOV.setValue("NETPR",
		// unigisccp.getViajesSAT()[0].getClienteDador()[i].getConceptos()[0].getImporte());//
		// PRECIO
		// x
		// canGuias
		//T_MOV.setValue("NETPR",
			//unigisccp.getViajesSAT()[0].getClienteDador()[i].getConceptos()[0].getImporte() == "" ? "100" : unigisccp.getViajesSAT()[0].getClienteDador()[i].getConceptos()[0].getImporte());

		T_MOV.setValue("NETPR",
			unigisccp.getViajesSAT()[0].getClienteDador()[i].getConceptos()[0].getImporte());

		// function.getImportParameterList().setValue("P_BSTKD",
		// consultarViaje.getResultado() + "/" + cantGuias + "/" + numCliente);
		CartaPorteResumen cartaPorteResumen = new CartaPorteResumen();

		cartaPorteResumen.setCliente(numCliente);
		cartaPorteResumen.setEstatus("A");
		cartaPorteResumen.setIdViaje((int) unigisccp.getViajesSAT()[0].getViajeUnigis().getIDViaje());
		cartaPorteResumen.setReferencia(unigisccp.getViajesSAT()[0].getViajeUnigis().getReferenciaExterna());

		int idControl = 0;

		if (lstFacturas.isEmpty()) {

		    idControl = iCartaPorteDAO.createMarcaFactura(cartaPorteResumen);

		} else {

		    for (FacturaCCP ccp : lstFacturas) {

			if (ccp.getCliente().equals(numCliente)) {

			    idControl = ccp.getIdControl();

			}

		    }

		}

		function.getImportParameterList().setValue("P_BSTKD", idControl);
		function.getImportParameterList().setValue("P_KUNNR", numCliente);

		// execute
		result = function.execute();

		// iCartaPorteDAO.marcarGuias(idControl,
		// result.getExportParameterList().getString("P_FACTURA"),
		// String.join(",", lstDocumentos));

		System.out.println("=============================================");
		System.out.println("P_RESULTADO : " + result.getExportParameterList().getString("P_RESULTADO") + "\n"
			+ "P_MENSAJE : " + result.getExportParameterList().getString("P_MENSAJE") + "\n" + "P_PEDIDO : "
			+ result.getExportParameterList().getString("P_PEDIDO") + "\n" + "P_FACTURA : "
			+ result.getExportParameterList().getString("P_FACTURA") + "\n" + "P_DOCFI : "
			+ result.getExportParameterList().getString("P_DOCFI") + "\n");

		SapResult sapResult = new SapResult();

		sapResult.setResultado(result.getExportParameterList().getString("P_RESULTADO"));
		sapResult.setMensaje(result.getExportParameterList().getString("P_MENSAJE"));
		sapResult.setPedido(result.getExportParameterList().getString("P_PEDIDO"));
		sapResult.setFactura(result.getExportParameterList().getString("P_FACTURA"));
		sapResult.setDocfi(result.getExportParameterList().getString("P_DOCFI"));

		lstResult.add(sapResult);

		iCartaPorteDAO.updateMarcaFactura(idControl, result.getExportParameterList().getString("P_FACTURA"),
			result.getExportParameterList().getString("P_MENSAJE"));

		/*
		 * if(result.getExportParameterList().getString("P_RESULTADO").equals("X")) {
		 * 
		 * DetalleFactura detalleFactura = new DetalleFactura();
		 * 
		 * detalleFactura.setFolio(""+unigisccp.getViajesSAT()[0].getViajeUnigis().
		 * getIDViaje()); detalleFactura.setDoc_contable("");
		 * detalleFactura.setMensaje(sapResult.getMensaje()); detalleFactura.setPdf("");
		 * 
		 * updateStatus(detalleFactura);
		 * 
		 * }
		 */

	    }

	    return lstResult;

	} catch (Exception e) {

	    /*
	     * DetalleFactura detalleFactura = new DetalleFactura();
	     * 
	     * detalleFactura.setDoc_contable(""+unigisccp.getViajesSAT()[0].getViajeUnigis(
	     * ).getIDViaje()); detalleFactura.setMensaje(e.getMessage());
	     * detalleFactura.setPdf("");
	     * 
	     * updateStatus(detalleFactura);
	     */
	    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
		    "Error can not creating consignment note.");

	}
    }

    @Override
    public int updateStatus(DetalleFactura detalleFactura) throws Exception {

	try {

	    // Comienza el proceso de invocacion del WS
	    java.net.URL portAddress;

	    uniServer = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.server", "UNIGIS");
	    portAddress = new java.net.URL(uniServer);

	    ServiceLocator locator = new ServiceLocator();

	    ServiceSoap proxy = locator.getServiceSoap(portAddress);

	    String apiKey = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.apikey", "UNIGIS");

	    int idViaje = 0;

	    if (detalleFactura.getDoc_contable().equals("")) {

		idViaje = Integer.parseInt(detalleFactura.getFolio());

	    } else {

		idViaje = Integer.parseInt(iCartaPorteDAO.getIdViaje(detalleFactura.getDoc_contable()));

	    }

	    PViaje viaje = new PViaje();

	    viaje.setIdViaje(idViaje);
	    viaje.setFechaCreacion(Calendar.getInstance());
	    viaje.setVarchar3(detalleFactura.getMensaje()); // AQUI VA LA DESCRIPCION DEL ERROR EN CASO DE FALLAR
	    viaje.setEstado(detalleFactura.getPdf().trim().equals("") ? "No Facturado" : "Facturado");

	    int result = proxy.modificarViaje(apiKey, viaje, "false", "true", Calendar.getInstance());

	    return result;

	} catch (Exception e) {

	    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error can not update travel status.");

	}

    }

    @Override
    public UnigisCCP getRestViaje(ViajeFinCarga viaje) throws IOException {

	CloseableHttpAsyncClient httpClient = HttpAsyncClients.createDefault();

	httpClient.start();

	try {

	    HttpPost httpPost = new HttpPost(
		    iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.rest.searchshipmentsat.url", "UNIGIS"));

	    JSONObject bodyToSend = new JSONObject();
	    bodyToSend.put("ApiKey",
		    iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.rest.searchshipmentsat.apikey", "UNIGIS"));
	    bodyToSend.put("tenant", "");
	    bodyToSend.put("token",
		    iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.rest.searchshipmentsat.token", "UNIGIS"));
	    bodyToSend.put("shipment", "" + viaje.getIdViaje());
	    bodyToSend.put("ReferenciaExterna", "" + viaje.getReferenciaExterna());
	    bodyToSend.put("FechaViaje", "");
	    bodyToSend.put("FechaInicio", "");
	    bodyToSend.put("FechaFin", "");

	    StringEntity body = new StringEntity(bodyToSend.toString(), StandardCharsets.UTF_8);

	    body.setContentType(MediaType.APPLICATION_JSON_VALUE);

	    httpPost.setEntity(body);

	    Future<HttpResponse> future = httpClient.execute(httpPost, null);

	    HttpResponse httpResponse = future.get();

	    // httpClient.close();

	    if (httpResponse.getStatusLine().getStatusCode() == 200) {

		BufferedReader reader = new BufferedReader(
			new InputStreamReader(httpResponse.getEntity().getContent()));

		String inputLine;

		StringBuilder builder = new StringBuilder();

		while ((inputLine = reader.readLine()) != null) {

		    builder.append(inputLine);

		}

		reader.close();

		JSONObject jsonObject = new JSONObject(builder.toString());

		if (!jsonObject.getJSONArray("viajesSAT").isNull(0)) {

		    ObjectMapper jsonMapper = new ObjectMapper();

		    UnigisCCP unigisCCP = jsonMapper.readValue(jsonObject.toString(), UnigisCCP.class);

		    // UnigisCCP unigisCCP = jsonMapper.readValue(jsonPruebas, UnigisCCP.class);

		    return unigisCCP;

		} else {

		    throw new ResponseStatusException(HttpStatus.NO_CONTENT,
			    "SearchShipmentSAT by Unigis has not content[shipment:" + viaje.getIdViaje() + "]");
		}

	    } else {

		throw new ResponseStatusException(HttpStatus.NO_CONTENT, "SearchShipmentSAT by Unigis returns "
			+ httpResponse.getStatusLine().getStatusCode() + " status code.");

	    }

	} catch (Exception e) {

	    httpClient.close();

	    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());

	}

    }

    @Override
    public int crearDocumentos(DetalleFactura detalleFactura) {

	try {

	    // Comienza el proceso de invocacion del WS
	    java.net.URL portAddress;

	    uniServer = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.server", "UNIGIS");

	    portAddress = new java.net.URL(uniServer);

	    ServiceLocator locator = new ServiceLocator();
	    ServiceSoap proxy = locator.getServiceSoap(portAddress);

	    String apiKey = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.apikey", "UNIGIS");

	    PDocumento[] documentos = new PDocumento[1];

	    PDocumento pDocumento = new PDocumento();

	    pDocumento.setTipoDocumento("CP");
	    pDocumento.setReferencia("12345");
	    pDocumento.setFechaEmision(Calendar.getInstance());
	    pDocumento.setFechaExpiracion(Calendar.getInstance());
	    pDocumento.setCrearDocumentoRequeridoViaje(false);
	    pDocumento.setIdViaje(-1);
	    pDocumento.setIdParada(-1);
	    pDocumento.setEsDocumentoRequerido(false);

	    // pDocumento.setObservaciones("");

	    documentos[0] = pDocumento;

	    PAsociarEntidad[] asociarEntidads = new PAsociarEntidad[1];

	    PAsociarEntidad asociarEntidad = new PAsociarEntidad();

	    asociarEntidad.setReferenciaViaje(iCartaPorteDAO.getReferenciaViaje(detalleFactura.getDoc_contable()));

	    asociarEntidads[0] = asociarEntidad;

	    documentos[0].setAsociaciones(asociarEntidads[0]);

	    PArchivoDoc[] archivoDocs = new PArchivoDoc[1];

	    PArchivoDoc archivoDoc = new PArchivoDoc();

	    archivoDoc.setDescripcion("CARTA PORTE");
	    archivoDoc.setTipoArchivo("pdf");
	    archivoDoc.setContenido(detalleFactura.getPdf());
	    archivoDoc.setClasificacionArchivo("CartaPorte");

	    archivoDocs[0] = archivoDoc;

	    documentos[0].setArchivosAsociados(archivoDocs);

	    int status = proxy.crearDocumentos("4567", documentos);

	    return status;

	} catch (Exception e) {

	    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error at crearDocumentos");

	}
    }

    @Override
    public int modificarViajeConParadas(DetalleFactura detalleFactura) {

	try {

	    // Comienza el proceso de invocacion del WS
	    java.net.URL portAddress;

	    uniServer = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.server", "UNIGIS");

	    portAddress = new java.net.URL(uniServer);

	    ServiceLocator locator = new ServiceLocator();
	    ServiceSoap proxy = locator.getServiceSoap(portAddress);

	    String apiKey = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.apikey", "UNIGIS");

	    PViaje viaje = new PViaje();

	    viaje.setIdViaje(Integer.parseInt(iCartaPorteDAO.getIdViaje(detalleFactura.getDoc_contable())));

	    // viaje.setIdViaje(21278);

	    viaje.setFechaCreacion(Calendar.getInstance());

	    PParada[] paradas = new PParada[1];

	    PParada pParada = new PParada();

	    pParada.setRefDocumento("");
	    pParada.setVarchar1(detalleFactura.getFolio());

	    paradas[0] = pParada;

	    viaje.setParadas(paradas);

	    int status = proxy.modificarViajeConParadas(apiKey, viaje, Calendar.getInstance());

	    return status;

	} catch (Exception e) {

	    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error at ModificarViajeConParadas");

	}
    }

    @Override
    public void timbrarMarcaFactura(DetalleFactura detalleFactura) {

	iCartaPorteDAO.timbrarMarcaFactura(detalleFactura);
    }

}
