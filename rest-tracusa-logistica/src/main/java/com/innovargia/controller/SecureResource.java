package com.innovargia.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Future;

import javax.imageio.ImageIO;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.rest_tracusa_logistica.api.SecurityKey;
import org.rest_tracusa_logistica.controller.CaDocumentoController;
import org.rest_tracusa_logistica.controller.ShipmentController;
import org.rest_tracusa_logistica.struct.Address;
import org.rest_tracusa_logistica.struct.Guide;
import org.rest_tracusa_logistica.struct.ParcelItem;
import org.rest_tracusa_logistica.struct.UserKey;

import com.administracion.ibo.ICoberturaBO;
import com.administracion.ibo.IDocumentoServicioBO;
import com.administracion.ibo.IEtiquetasBO;
import com.administracion.ibo.IMuestraEtiquetasBO;
import com.administracion.idao.IParamsSistemaDAO;
import com.administracion.idao.IServiciosDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;

import com.innovargia.administracion.ibo.IUsuarioBO;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.model.ViajeFinCarga;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.INivelUsuarioBO;
import com.innovargia.salesmanager.ibo.IRotulacionEtiquetasDatosBO;
import com.innovargia.utils.Constantes;
import com.innovargia.utils.ExceptionTracking;
import com.innovargia.utils.Files;
import com.innovargia.utils.UUIDUniqueCreator;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.ZPLConveter;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.search.ibo.IBusquedaFrecuenciasBO;

import ar.com.unisolutions.ConsultarViajeResultado;
import ar.com.unisolutions.CrearOrdenesPedidoResponse;
import ar.com.unisolutions.ModificarEstadoGuia;
import ar.com.unisolutions.ModificarEstadoGuiaResponse;
import ar.com.unisolutions.PCliente;
import ar.com.unisolutions.PDeposito;
import ar.com.unisolutions.PDomicilio;
import ar.com.unisolutions.PEstadoGuia;
import ar.com.unisolutions.PEstadoOrdenPedido;
import ar.com.unisolutions.POrdenPedido;
import ar.com.unisolutions.POrdenPedidoItem;
import ar.com.unisolutions.PProducto;
import ar.com.unisolutions.ServiceLocator;
import ar.com.unisolutions.ServiceSoap;
import ar.com.unisolutions.bo.IDireccioneBO;
import ar.com.unisolutions.bo.IGuiaBO;
import ar.com.unisolutions.bo.IMercanciaBO;
import ar.com.unisolutions.dto.Direccion;
import ar.com.unisolutions.dto.MercanciaSat;

@Controller
@RequestMapping("/vI/shipment")
public class SecureResource {

    @Autowired
    IUsuarioBO iusuarioBO;

    @Autowired
    IBusquedaFrecuenciasBO iBusquedaFrecuenciasBO;

    @Autowired
    IRotulacionEtiquetasDatosBO iRotulacionEtiquetasDatosBO;

    @Autowired
    IMuestraEtiquetasBO iMuestraEtiquetasBO;

    @Autowired
    IServiciosDao iServiciosDao;

    @Autowired
    IEtiquetasBO iEtiquetasBO;

    @Autowired
    IParamsSistemaDAO iParamsSistemaDAO;

    @Autowired
    IDocumentoServicioBO iDocumentoServicioBO;

    @Autowired
    ICoberturaBO iCoberturaBO;

    @Autowired
    IRotulacionEtiquetasDatosBO iRotulacionEtiquetasDatosUnigisBO;

    @Autowired
    INivelUsuarioBO iNivelUsuarioUnigisBO;

    @Autowired
    IMercanciaBO iMercanciaBO;

    @Autowired
    IGuiaBO iGuiaBO;

    @Autowired
    IDireccioneBO iDireccioneBO;

    @RequestMapping(value = "/createShipment", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<String> createShipment(
	    @RequestHeader(required = false, value = "Authorization") String apiKeyHeader, @RequestBody Guide joGuide)
	    throws Exception {

	JsonObject joResult = null;

	UsuarioDTO usuario = null;

	CaDocumentoController caDoc = new CaDocumentoController();

	try {

	    joResult = new JsonObject();
	    SecurityKey filter = new SecurityKey();

	    // Valida el acceso a la API
	    UserKey userKey = filter.filter(apiKeyHeader);

	    // Obtiene datos del usuairo
	    usuario = getUser(userKey.getLogin(), userKey.getIdClient());

	    // Inserta LOG.
	    caDoc.setLog(usuario, joGuide, 200);

	    // Valida si es usuario de WALMART.
	    String usuarioWalmart = caDoc.getUsuarioWalmart(userKey.getIdClient(), joGuide.getReference(),
		    joGuide.getObservations());

	    // Valida si es usuario de FLEXI.
	    String usuarioFlexi = caDoc.getUsuarioFlexi(userKey.getIdClient(), joGuide.getReference(),
		    joGuide.getObservations());

	    int idConvenio = 0;

	    int idTarifa = 0;

	    // if(!usuarioWalmart.equals("1")){
	    if (usuarioFlexi.equals("1")) {

		// Valida si ya se inserto una guia con la misma referencia (No.
		// Remesa de FLEXI) y las mismas observaciones (No. Caja).
		String existeGuia = caDoc.getExistDocumentGuia(userKey.getIdClient(), joGuide.getReference(),
			joGuide.getObservations());

		if (existeGuia.length() > 0) {

		    joResult.addProperty("guide", existeGuia);

		    throw new Exception("YA EXISTE UNA GUIA REGISTRADA CON LA MISMA REMESA Y NO. DE CAJA ");

		}

	    } else {

		List<EtiquetaRotulacionDTO> listaAux = caDoc.getConvenioTarifa(userKey.getIdClient(),
			joGuide.getIdService());

		if (listaAux.size() > 0) {

		    idConvenio = listaAux.get(0).getIdconvenio();

		    idTarifa = listaAux.get(0).getIdtarifa();

		}

	    }

	    // //Obtiene datos del usuairo
	    // usuario = getUser(userKey.getLogin(), userKey.getIdClient());

	    // CABEZERA
	    EtiquetaRotulacionDTO etiquetaRotulacionDTO = null;

	    List<EtiquetaRotulacionDTO> lista_registros = new ArrayList<EtiquetaRotulacionDTO>();

	    String uuid = UUIDUniqueCreator.generateUUID();

	    for (int i = 0; i < joGuide.getParcel().getQuantity(); i++) {

		etiquetaRotulacionDTO = new EtiquetaRotulacionDTO();

		etiquetaRotulacionDTO.setPesobase((int) joGuide.getParcel().getWeight());
		etiquetaRotulacionDTO.setIdservicio(joGuide.getIdService());
		etiquetaRotulacionDTO.setServiciotarifa(joGuide.getIdService());
		etiquetaRotulacionDTO.setNacional("NACIONAL");
		etiquetaRotulacionDTO.setEsmadre(String.valueOf("n"));

		/* Agrega tarifa y convenio en caso de ser walmart */
		// if(usuarioWalmart.equals("1")){
		if (!usuarioFlexi.equals("1")) {

		    etiquetaRotulacionDTO.setIdconvenio(idConvenio);
		    etiquetaRotulacionDTO.setIdtarifa(idTarifa);

		}

		// FromAddress
		Address fromAddress = joGuide.getFromAddress();

		etiquetaRotulacionDTO.setContacto_rem(UtilsStringFechas.convierteCadenaNULL(fromAddress.getName(), 50));
		etiquetaRotulacionDTO.setNumexterior_rem(fromAddress.getOutNumber());
		etiquetaRotulacionDTO.setNuminterior_rem(fromAddress.getInNumber());
		etiquetaRotulacionDTO.setCalle_rem(UtilsStringFechas.convierteCadena(fromAddress.getStreet1(), 100));
		etiquetaRotulacionDTO.setColonia_rem(UtilsStringFechas.convierteCadena(fromAddress.getColony(), 100));
		etiquetaRotulacionDTO.setCp_rem(UtilsStringFechas.convierteCadena(fromAddress.getZip(), 5));
		etiquetaRotulacionDTO.setMunicipio_des(UtilsStringFechas.convierteCadena(fromAddress.getCity(), 50));
		etiquetaRotulacionDTO.setEstado_rem(UtilsStringFechas.convierteCadena(fromAddress.getState(), 50));
		etiquetaRotulacionDTO.setCiudad_rem(UtilsStringFechas.convierteCadena(fromAddress.getCity(), 50));
		etiquetaRotulacionDTO.setTelefono_rem(UtilsStringFechas.convierteCadena(fromAddress.getPhone(), 22));
		etiquetaRotulacionDTO.setPais_rem(UtilsStringFechas.convierteCadena(fromAddress.getCountry(), 60));
		etiquetaRotulacionDTO.setRfc_rem("");
		etiquetaRotulacionDTO.setEmail_rem("");
		etiquetaRotulacionDTO.setRazonsocial_rem(fromAddress.getCompany());
		etiquetaRotulacionDTO.setMunicipio_rem(fromAddress.getCity());
		etiquetaRotulacionDTO.setReferencia_rem(fromAddress.getReference());

		etiquetaRotulacionDTO.setTiene_cita(
			etiquetaRotulacionDTO.getTiene_cita() == null ? "NO" : etiquetaRotulacionDTO.getTiene_cita());

		Frecuencias frecuencia_origen = iBusquedaFrecuenciasBO.getFrecuenciasEntregaCP(fromAddress.getZip());

		if (frecuencia_origen == null) {

		    throw new Exception("NO EXISTE FRECUENCIA DE ENTREGA PARA EL CP " + fromAddress.getZip());

		}

		etiquetaRotulacionDTO
			.setSiglasorigen(frecuencia_origen != null ? frecuencia_origen.getIdterminal() : "");

		// ToAddress
		Address toAddress = joGuide.getToAddress();

		// Validar requerimientos para destinatario
		validaRequerido(toAddress.getZip(), "CODIGO POSTAL INVALIDO");
		validaRequerido(toAddress.getStreet1(), "CALLE INVALIDA");
		validaRequerido(toAddress.getColony(), "COLONIA INVALIDA");
		validaRequerido(toAddress.getCity(), "CIUDAD INVALIDA");
		validaRequerido(toAddress.getState(), "ESTADO INVALIDO");
		validaRequerido(toAddress.getCountry(), "PAIS INVALIDO");

		// Obligatorios opcionales
		toAddress.setReference(toAddress.getReference() == null ? "" : toAddress.getReference());
		toAddress.setPhone(toAddress.getPhone() == null ? "" : toAddress.getPhone());
		toAddress.setPhone2(toAddress.getPhone2() == null ? "" : toAddress.getPhone2());

		etiquetaRotulacionDTO
			.setReferencia(joGuide.getReference() == null ? "" : joGuide.getReference().trim());
		etiquetaRotulacionDTO.setFechaEstimada(UtilsStringFechas.convierteCadena(joGuide.getMaxEDD(), 10));
		etiquetaRotulacionDTO.setContacto_des(UtilsStringFechas.convierteCadenaNULL(toAddress.getName(), 50));
		etiquetaRotulacionDTO.setCalle_des(UtilsStringFechas.convierteCadena(toAddress.getStreet1(), 50));
		etiquetaRotulacionDTO.setColonia_des(UtilsStringFechas.convierteCadena(toAddress.getColony(), 100));
		etiquetaRotulacionDTO.setCp_des(UtilsStringFechas.convierteCadena(toAddress.getZip(), 5));
		etiquetaRotulacionDTO.setMunicipio_des(UtilsStringFechas.convierteCadena(toAddress.getCity(), 50));
		etiquetaRotulacionDTO.setEstado_des(UtilsStringFechas.convierteCadena(toAddress.getState(), 50));
		etiquetaRotulacionDTO.setCiudad_des(UtilsStringFechas.convierteCadena(toAddress.getCity(), 50));
		etiquetaRotulacionDTO.setTelefono_des(UtilsStringFechas.convierteCadena(toAddress.getPhone(), 22));
		etiquetaRotulacionDTO.setTelefono_des2(UtilsStringFechas.convierteCadena(toAddress.getPhone2(), 22));
		etiquetaRotulacionDTO.setPais_des(UtilsStringFechas.convierteCadena(toAddress.getCountry(), 60));
		etiquetaRotulacionDTO.setRfc_des("");
		etiquetaRotulacionDTO.setEmail_des(toAddress.getEmail() == null ? "" : toAddress.getEmail());
		etiquetaRotulacionDTO.setMunicipio_des(toAddress.getCity());
		etiquetaRotulacionDTO.setRazonsocial_des(toAddress.getCompany());
		etiquetaRotulacionDTO.setNumexterior_des(toAddress.getOutNumber());
		etiquetaRotulacionDTO.setReferencia_des(toAddress.getReference());

		/* CAMBIO DATOS extIntNumber, neighborhood y municipality WALMART */
		if (usuarioWalmart.equals("1")) {

		    etiquetaRotulacionDTO.setNumexterior_des(toAddress.getStreet2());

		    etiquetaRotulacionDTO
			    .setColonia_des(UtilsStringFechas.convierteCadena(toAddress.getOutNumber(), 100));

		    etiquetaRotulacionDTO
			    .setMunicipio_des(UtilsStringFechas.convierteCadena(toAddress.getColony(), 50));

		}

		Frecuencias frecuencia_destino = iBusquedaFrecuenciasBO.getFrecuenciasEntregaCP(toAddress.getZip());

		if (frecuencia_destino == null) {

		    throw new Exception("NO EXISTE FRECUENCIA DE ENTREGA PARA EL CP " + toAddress.getZip());

		}

		etiquetaRotulacionDTO
			.setSiglasdestino(frecuencia_destino != null ? frecuencia_destino.getIdterminal() : "");

		etiquetaRotulacionDTO
			.setObservacion(joGuide.getObservations() == null ? "" : joGuide.getObservations().trim());
		etiquetaRotulacionDTO.setRemite(UtilsStringFechas.convierteCadenaNULL(fromAddress.getCompany()));
		etiquetaRotulacionDTO.setDestino(UtilsStringFechas.convierteCadenaNULL(toAddress.getCompany()));

		// Parce
		ParcelItem parcel = joGuide.getParcel();

		if (userKey.getProrroga().equals("0")) {

		    if (parcel.getId() == null) {

			throw new Exception(
				"No se encuentra el valor 'key' en la informacion enviada, detalle: key - nula");

		    } else {

			if (parcel.getId().equals("")) {

			    throw new Exception("No ingreso un numero de mercancia, detalle: key = vacia");

			}
		    }

		}

		// if (parcel.getIsMultiple() == true && parcel.getQuantity() == 1) {
		if (parcel.getIsMultiple()) {

		    throw new Exception("Funcion Inhabilitada por el momento, detalle: isMultiple = true");
		    // throw new Exception(
		    // "No es posible generar guias, detalle: Para poder generar guias multiples se
		    // debe tener un valor mayor a '1' en el parametro [Quantity].");

		}

		etiquetaRotulacionDTO.setCantidad(parcel.getQuantity());
		etiquetaRotulacionDTO.setFactura("");
		etiquetaRotulacionDTO.setPesofisico(parcel.getWeight());
		etiquetaRotulacionDTO.setPesomayor(
			parcel.getWeight() > parcel.getVolume() ? parcel.getWeight() : parcel.getVolume());
		etiquetaRotulacionDTO.setValordeclarado(parcel.getValue());
		etiquetaRotulacionDTO.setEs_multiple(parcel.getIsMultiple() ? "SI" : "NO");
		etiquetaRotulacionDTO.setAlto(parcel.getHeight());
		etiquetaRotulacionDTO.setAncho(parcel.getWidth());
		etiquetaRotulacionDTO.setLargo(parcel.getLength());

		// Valida si es asegurado
		if (parcel.getSecure()) {

		    if (parcel.getValue() <= 0) {

			throw new Exception(
				"VALOR DEL CONTENIDO DEL ENVIO NO DEBE SER CERO CUANDO SE REQUIERE ASEGURAR.");

		    }

		    etiquetaRotulacionDTO.setValor_asegurado(parcel.getValue());

		} else {

		    etiquetaRotulacionDTO.setValor_asegurado(0);

		}

		etiquetaRotulacionDTO.setTipoempaque(UtilsStringFechas.convierteCadenaNULL(parcel.getTypePacking()));
		etiquetaRotulacionDTO.setContenido(UtilsStringFechas.convierteCadenaNULL(
			iMercanciaBO.getMercanciaById(parcel.getId() == null ? "01010101" : parcel.getId())));
		etiquetaRotulacionDTO.setDescripcion_servicio(iServiciosDao.getDesTipoServicio(joGuide.getIdService()));
		etiquetaRotulacionDTO.setDescripciongarantia(iServiciosDao.getDesGarantia(joGuide.getIdService()));
		etiquetaRotulacionDTO.setUuid(uuid);

		/* CAMBIO UNIGIS */
		etiquetaRotulacionDTO.setSistema(2);
		etiquetaRotulacionDTO.setLinea_consecutivo(i + 1);
		etiquetaRotulacionDTO.setNumpiezas(parcel.getQuantity());

		// Valida datos
		iRotulacionEtiquetasDatosBO.getArr_Transbordos(etiquetaRotulacionDTO);
		iRotulacionEtiquetasDatosBO.validaRegistro(etiquetaRotulacionDTO);

		if (etiquetaRotulacionDTO.getEsvalido() != 0) {

		    throw new Exception(etiquetaRotulacionDTO.getMensajeError());

		}

		lista_registros.add(etiquetaRotulacionDTO);

	    }

	    /*
	     * int idregistro = iRotulacionEtiquetasDatosBO.insert(etiquetaRotulacionDTO);
	     * etiquetaRotulacionDTO.setIdregistro(idregistro); //Actualiza los datos
	     * generales etiquetaRotulacionDTO.setIdregistrodatos(etiquetaRotulacionDTO.
	     * getIdregistro()); iRotulacionEtiquetasDatosBO.update(etiquetaRotulacionDTO);
	     */

	    String manejo_por_folios_o_convenios = iParamsSistemaDAO.getValorPropiedad(
		    ConstantesGenerales.MANEJO_POR_FOLIOS_O_CONVENIOS, ConstantesGenerales.ID_SKY4SOL);

	    etiquetaRotulacionDTO.setTiporotucacion(manejo_por_folios_o_convenios);

	    List<Envio> arr_envios = new ArrayList<Envio>();

	    iEtiquetasBO.creaEtiquetas(lista_registros, usuario, arr_envios, uuid, 0,
		    etiquetaRotulacionDTO.getTiporotucacion());

	    Gson gson = new GsonBuilder().setPrettyPrinting().create();

	    etiquetaRotulacionDTO.setJson_data(gson.toJson(arr_envios));
	    etiquetaRotulacionDTO.setLogin(usuario.getLogin());
	    // etiquetaRotulacionDTO.setNacional("NACIONAL");

	    // Genera el id y lo guarda
	    iRotulacionEtiquetasDatosBO.insertRotulacionEtiquetasGeneradas(etiquetaRotulacionDTO);

	    // Checa la cantidad de guias
	    String arr_guias = "";

	    for (Envio envio : arr_envios) {

		if (arr_guias.equals("")) {

		    arr_guias = envio.getIdEnvio();

		} else {

		    arr_guias = arr_guias + "," + envio.getIdEnvio();

		}

	    }

	    arr_guias = arr_guias.trim().replace(" ", ",");
	    // responseOutbound.setGuia(arr_guias);

	    // Crear etiqueta PDF
	    byte[] bytes = null;
	    String archivo = iMuestraEtiquetasBO.generaPDFGuia(arr_envios, usuario, ConstantesGenerales._TIPOIMPRESION,
		    ConstantesGenerales.ID_SKY4SOL, usuario.getFormatoetiperso());

	    File f = new File(archivo);
	    bytes = Files.getBytesFromFile(f);
	    String encodedPDFString = Base64Utils.encodeToString(bytes);

	    if (!usuarioWalmart.equals("1")) {

		// Crear etiqueta PNG
		String encodedPNGString = "";
		String fileName = "";
		File png = null;
		PDDocument document = PDDocument.load(f);
		PDFRenderer pdfRenderer = new PDFRenderer(document);

		for (int page = 0; page < document.getNumberOfPages(); ++page) {

		    BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
		    fileName = "/opt/adminsales/tmppngs/" + arr_guias + "-" + userKey.getIdClient() + "-" + page
			    + ".png";
		    // fileName = "/opt/adminsales/tmppngs/" + "image-" + page +
		    // ".png";
		    png = new File(fileName);
		    ImageIOUtil.writeImage(bim, fileName, 300);
		    encodedPNGString = Base64Utils.encodeToString(Files.getBytesFromFile(png));

		}

		document.close();

		// Crear etiqueta PNG ZPL2
		String encodedPNGString_zpl = "";
		String fileName_zpl = "";
		File png_zpl2 = null;
		PDDocument document_zpl = PDDocument.load(f);
		pdfRenderer = new PDFRenderer(document_zpl);

		for (int page = 0; page < document.getNumberOfPages(); ++page) {

		    BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 203, ImageType.RGB);

		    fileName_zpl = "/opt/adminsales/tmpzpl_II/zpl_II.png";

		    // fileName = "/opt/adminsales/tmppngs/" + "image-" + page +
		    // ".png";
		    png_zpl2 = new File(fileName_zpl);
		    ImageIOUtil.writeImage(bim, fileName_zpl, 832);
		    encodedPNGString_zpl = Base64Utils.encodeToString(Files.getBytesFromFile(png_zpl2));

		}

		document_zpl.close();

		// Crear etiqueta ZPL
		String encodedZPLString = "";
		BufferedImage orginalImage = ImageIO.read(png);
		ZPLConveter zp = new ZPLConveter();
		zp.setCompressHex(true);
		zp.setBlacknessLimitPercentage(50);
		encodedZPLString = zp.convertfromImg(orginalImage);

		// Crear etiqueta ZPL 2
		String encodedZPL2String = "";
		orginalImage = ImageIO.read(png_zpl2);
		zp = new ZPLConveter();
		zp.setCompressHex(true);
		zp.setBlacknessLimitPercentage(50);
		encodedZPL2String = zp.convertfromImg(orginalImage);

		// UPDATE LOG.
		caDoc.updateLog(joGuide, etiquetaRotulacionDTO.getIdenvio());

		joResult.addProperty("code", 200);
		joResult.addProperty("message", "OK");
		joResult.addProperty("unigis_code", crearOrdenesPedido(etiquetaRotulacionDTO, usuario));
		joResult.addProperty("guide", arr_guias);
		joResult.addProperty("pdf", encodedPDFString);
		joResult.addProperty("png", encodedPNGString);
		joResult.addProperty("zpl", encodedZPLString);
		joResult.addProperty("zpl_II", encodedZPL2String);

	    } else {

		// UPDATE LOG. caDoc.updateLog(joGuide, etiquetaRotulacionDTO.getIdenvio());

		joResult.addProperty("code", 200);
		joResult.addProperty("message", "OK");
		joResult.addProperty("unigis_code", crearOrdenesPedido(etiquetaRotulacionDTO, usuario));
		joResult.addProperty("guide", arr_guias);
		joResult.addProperty("pdf", encodedPDFString);

	    }

	    // joReturnGuide.addProperty("joGuide", jj.toString());
	    return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);
	    // return
	    // Response.status(Response.Status.OK).entity(joResult.toString()).build();
	} catch (Exception e) {

	    e.printStackTrace();
	    // throw new Exception(e.getMessage());
	    if (e.getMessage() == null) {

		caDoc.setLog(usuario, joGuide, 400);

		joResult.addProperty("code", 400);
		joResult.addProperty("message", "Bad Request");

		return new ResponseEntity<>(joResult.toString(), HttpStatus.BAD_REQUEST);

	    } else {

		caDoc.setLog(usuario, joGuide, 201);

		joResult.addProperty("code", 201);
		joResult.addProperty("message", e.getMessage());

	    }

	    return new ResponseEntity<>(joResult.toString(), HttpStatus.BAD_REQUEST);
	    // return
	    // Response.status(Response.Status.BAD_REQUEST).entity(joResult.toString()).build();
	}
    }

    @RequestMapping(value = "/getShipmentByDate/{fInicio}/{fFin}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> getShipmentsByDates(
	    @RequestHeader(required = false, value = "Authorization") String apiKeyHeader,
	    @PathVariable("fInicio") String fInicio, @PathVariable("fFin") String fFin) {
	JsonObject joResult = new JsonObject();

	try {
	    SecurityKey filter = new SecurityKey();
	    ShipmentController shipmentC = new ShipmentController();
	    ArrayList<Guide> lstGuide = new ArrayList<>();

	    UserKey userKey = filter.filter(apiKeyHeader);
	    lstGuide = shipmentC.getShipmentByDate(fInicio, fFin, userKey.getIdClient());
	    JsonObject jsonObject = new JsonObject();

	    joResult.addProperty("code", 200);
	    joResult.addProperty("message", "OK");
	    joResult.add("shipments", new Gson().toJsonTree(lstGuide));

	    return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);
	} catch (Exception e) {
	    e.printStackTrace();
	    /*
	     * joResult.addProperty("code", 400); joResult .addProperty("Message",
	     * "Bad Request"); joResult .addProperty("Exception", e.getMessage());
	     */
	    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
    }

    @RequestMapping(value = "/getShipment/{idGuide}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> getShipment(
	    @RequestHeader(required = true, value = "Authorization") String apiKeyHeader,
	    @PathVariable("idGuide") String idGuide) {
	JsonObject joResult = new JsonObject();

	try {

	    SecurityKey filter = new SecurityKey();
	    ShipmentController shipmentC = new ShipmentController();
	    ArrayList<ar.com.unisolutions.dto.Guide> lstGuide = new ArrayList<>();
	    ArrayList<ArrayList<ar.com.unisolutions.dto.Guide>> listOfLists = new ArrayList<ArrayList<ar.com.unisolutions.dto.Guide>>();

	    UserKey userKey = filter.filter(apiKeyHeader);

	    ArrayList<String> lstGuias = new ArrayList<>();
	    lstGuias.addAll(Arrays.asList(idGuide.split(",")));

	    if (lstGuias.size() >= 0 && lstGuias.size() <= 200) {
		for (int i = 0; i < lstGuias.size(); i++) {

		    boolean bandera = shipmentC.isNoShipmentClient((String) lstGuias.get(i), userKey);

		    if (userKey.getIdClient().equals("100714") && bandera == false) {

			userKey.setIdClient("100260");

			bandera = shipmentC.isNoShipmentClient((String) lstGuias.get(i), userKey);

		    }

		    if (!bandera) {
			joResult.addProperty("code", Integer.valueOf(400));
			joResult.addProperty("message", (new StringBuilder("La guia ")).append((String) lstGuias.get(i))
				.append(" no pertenece al cliente.").toString());
			throw new Exception(joResult.toString());
		    }
		    lstGuide = iGuiaBO.ConsultarOrdenPedido(lstGuias.get(i).trim());
		    // lstGuide = shipmentC.getShipmentByID(lstGuias.get(i).trim(),
		    // userKey.getIdClient());
		    if (!lstGuide.isEmpty()) {
			listOfLists.add(lstGuide);
		    }
		}
	    }

	    // lstGuide = shipmentC.getShipmentByID(idGuide, userKey.getIdClient());
	    // JsonObject jsonObject = new JsonObject();

	    joResult.addProperty("code", 200);
	    joResult.addProperty("message", "OK");
	    joResult.add("shipments", new Gson().toJsonTree(listOfLists));

	    return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);
	} catch (Exception e) {
	    e.printStackTrace();
	    /*
	     * joResult.addProperty("code", 400); joResult .addProperty("Message",
	     * "Bad Request"); joResult .addProperty("Exception", e.getMessage());
	     */
	    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
    }

    @RequestMapping(value = "/getShipmentTracking/{idGuide}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> getShipmentTracking(
	    @RequestHeader(required = true, value = "Authorization") String apiKeyHeader,
	    @PathVariable("idGuide") String idGuide) {
	JsonObject joResult = new JsonObject();

	try {
	    SecurityKey filter = new SecurityKey();
	    ShipmentController shipmentC = new ShipmentController();
	    ArrayList<ar.com.unisolutions.dto.Guide> lstGuide = new ArrayList<>();

	    UserKey userKey = filter.filter(apiKeyHeader);
	    // Validar
	    // lstGuide = shipmentC.getShipmentTrackingByID(idGuide, userKey);
	    lstGuide = iGuiaBO.getShipmentTracking(idGuide);
	    JsonObject jsonObject = new JsonObject();

	    joResult.addProperty("code", 200);
	    joResult.addProperty("message", "OK");
	    joResult.add("shipments", new Gson().toJsonTree(lstGuide));

	    return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);
	} catch (Exception e) {
	    e.printStackTrace();
	    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
    }

    // getShipmentLabel
    @RequestMapping(value = "/getShipmentLabel/{idGuide}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> getShipmentLabel(
	    @RequestHeader(required = true, value = "Authorization") String apiKeyHeader,
	    @PathVariable("idGuide") String idGuide) {
	JsonObject joResult = new JsonObject();

	try {
	    SecurityKey filter = new SecurityKey();
	    ShipmentController shipmentC = new ShipmentController();
	    ArrayList<Guide> lstGuide = new ArrayList<>();

	    UserKey userKey = filter.filter(apiKeyHeader);

	    // Validar si la guia es del cliente
	    boolean bandera = shipmentC.isNoShipmentClient(idGuide, userKey);

	    if (!bandera) {
		joResult.addProperty("code", 400);
		joResult.addProperty("message", "La guia " + idGuide + " no pertenece al cliente.");
		throw new Exception(joResult.toString());
	    }

	    String dirPDFTXTFile = iParamsSistemaDAO.getValorPropiedad(ConstantesGenerales.DirPDFTXTFile,
		    ConstantesGenerales.ID_SKY4SOL);

	    // String archivo = "/opt/adminsales/tmppdfs/" + idGuide + "-" +
	    // userKey.getIdClient() + "_gui.pdf";
	    String archivo = dirPDFTXTFile + idGuide + "-" + userKey.getIdClient() + "_gui.pdf";

	    byte[] bytes = null;
	    File filePDF = new File(archivo);
	    if (!filePDF.exists()) {
		joResult.addProperty("code", 400);
		joResult.addProperty("message", "El directorio de la guia " + idGuide + " no se encuentra");
		throw new Exception(joResult.toString());
	    }

	    bytes = Files.getBytesFromFile(filePDF);
	    String encodedPDFString = Base64Utils.encodeToString(bytes);

	    // Crear etiqueta PNG
	    String encodedPNGString = "";
	    String filePNG = "";
	    File png = null;
	    PDDocument document = PDDocument.load(filePDF);
	    PDFRenderer pdfRenderer = new PDFRenderer(document);
	    for (int page = 0; page < document.getNumberOfPages(); ++page) {
		BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
		filePNG = "/opt/adminsales/tmppngs/" + idGuide + "-" + userKey.getIdClient() + "-" + page + ".png";
		png = new File(filePNG);
		ImageIOUtil.writeImage(bim, filePNG, 300);
		encodedPNGString = Base64Utils.encodeToString(Files.getBytesFromFile(png));
	    }
	    document.close();

	    // Crear etiqueta ZPL
	    String encodedZPLString = "";
	    BufferedImage orginalImage = ImageIO.read(png);
	    ZPLConveter zp = new ZPLConveter();
	    zp.setCompressHex(true);
	    zp.setBlacknessLimitPercentage(50);
	    encodedZPLString = zp.convertfromImg(orginalImage);

	    joResult.addProperty("code", 200);
	    joResult.addProperty("message", "OK");
	    joResult.addProperty("guide", idGuide);
	    joResult.addProperty("pdf", encodedPDFString);
	    joResult.addProperty("png", encodedPNGString);
	    joResult.addProperty("zpl", encodedZPLString);

	    return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);
	} catch (Exception e) {
	    e.printStackTrace();
	    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
    }

    @RequestMapping(value = "/getShipmentPOD/{idGuide}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> getShipmentPOD(
	    @RequestHeader(required = true, value = "Authorization") String apiKeyHeader,
	    @PathVariable("idGuide") String idGuides) {
	JsonObject joResult = new JsonObject();

	try {
	    SecurityKey filter = new SecurityKey();
	    ShipmentController shipmentC = new ShipmentController();
	    ArrayList<Guide> lstGuide = new ArrayList<>();

	    UserKey userKey = filter.filter(apiKeyHeader);

	    if (idGuides.isEmpty()) {
		joResult.addProperty("code", 400);
		joResult.addProperty("message", "El recurso solicitado se encuentra vacío");
		throw new Exception(joResult.toString());
	    }

	    ArrayList<String> lstGuias = new ArrayList<>();
	    lstGuias.addAll(Arrays.asList(idGuides.split(",")));

	    if (lstGuias.size() >= 0 && lstGuias.size() <= 200) {
		for (int i = 0; i < lstGuias.size(); i++) {
		    Guide guide = shipmentC.getShipmentPOD(lstGuias.get(i).trim(), userKey);
		    if (guide != null)
			lstGuide.add(guide);
		}
	    }

	    joResult.addProperty("code", 200);
	    joResult.addProperty("message", "OK");
	    joResult.add("shipmentsPOD", new Gson().toJsonTree(lstGuide));

	    return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);
	} catch (Exception e) {
	    e.printStackTrace();
	    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
    }

    @RequestMapping(value = "/cotizar", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<String> cotizar(@RequestHeader(required = false, value = "Authorization") String apiKeyHeader,
	    @RequestBody Guide joGuide) {
	JsonObject joResult = null;
	ArrayList<JsonObject> lstJsons = new ArrayList<>();
	UsuarioDTO usuario = null;
	CaDocumentoController caDoc = new CaDocumentoController();
	try {

	    String cotizacion = "";

	    joResult = new JsonObject();

	    SecurityKey filter = new SecurityKey();

	    // Valida el acceso a la API
	    UserKey userKey = filter.filter(apiKeyHeader);

	    // Obtiene datos del usuairo
	    usuario = getUser(userKey.getLogin(), userKey.getIdClient());

	    String cporigen = joGuide.getFromAddress().getZip();
	    String cpdestino = joGuide.getToAddress().getZip();
	    float alto = joGuide.getParcel().getHeight(), largo = joGuide.getParcel().getLength(),
		    ancho = joGuide.getParcel().getWidth(), peso = joGuide.getParcel().getWeight();

	    // AQUI VA EL METODO
	    cotizacion = caDoc.cotizacion(cporigen, cpdestino, usuario);

	    lstJsons = getCotizacion(cotizacion, alto, largo, ancho, peso);

	    joResult.addProperty("code", 200);
	    joResult.addProperty("serviceType 1", "LTL");
	    joResult.add("LTL quotation", lstJsons.get(0));
	    joResult.addProperty("serviceType 2", "PAQUETERIA");
	    joResult.add("PACK quotation", lstJsons.get(1));

	    return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);

	} catch (Exception e) {
	    e.printStackTrace();
	    // throw new Exception(e.getMessage());
	    if (e.getMessage() == null) {
		joResult.addProperty("code", 400);
		joResult.addProperty("message", "Bad Request");
		return new ResponseEntity<>(joResult.toString(), HttpStatus.BAD_REQUEST);
	    } else {
		joResult.addProperty("code", 201);
		joResult.addProperty("message", e.getMessage());
	    }
	    return new ResponseEntity<>(joResult.toString(), HttpStatus.BAD_REQUEST);
	    // return
	    // Response.status(Response.Status.BAD_REQUEST).entity(joResult.toString()).build();
	}
    }

    @RequestMapping(value = "/checkCoverage", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<String> checkCoverage(
	    @RequestHeader(required = false, value = "Authorization") String apiKeyHeader, @RequestBody Guide joGuide)
	    throws Exception {

	JsonObject joResult;
	joResult = null;
	ArrayList lstJsons = new ArrayList();
	UsuarioDTO usuario = null;
	String idservicio;

	try {

	    joResult = new JsonObject();

	    SecurityKey filter = new SecurityKey();

	    UserKey userKey = filter.filter(apiKeyHeader);

	    usuario = getUser(userKey.getLogin(), userKey.getIdClient());

	    if (joGuide.getFromAddress().getZip() == "") {

		throw new Exception("CP Origen vacio / Origin ZIP code is empty");

	    }

	    if (joGuide.getToAddress().getZip() == "") {

		throw new Exception("CP Destino vacio / Destination ZIP code is empty");

	    }

	    idservicio = "";

	    switch (joGuide.getIdService()) {

	    case "10":

		idservicio = joGuide.getIdService();

		break;

	    case "20":

		idservicio = joGuide.getIdService();

		break;

	    case "30":

		idservicio = joGuide.getIdService();

		break;

	    default:

		throw new Exception("Servicio vacio o invalido[10,20,30] / Service is empty or invalid[10,20,30]");
	    }

	    String cporigen = joGuide.getFromAddress().getZip();
	    String cpdestino = joGuide.getToAddress().getZip();

	    if (!validaEnrutaCobetura(cporigen, cpdestino, idservicio)) {
		throw new Exception("No existe cobertura entre remitente y destino seleccionados. / There is no cover"
			+ "age between selected remitent and destinatary.");
	    }
	    joResult.addProperty("code", Integer.valueOf(200));
	    joResult.addProperty("message",
		    "Existe cobertura entre remitente y destino seleccionados. / There is coverage be"
			    + "tween selected remitent and destinatary.");
	    return new ResponseEntity(joResult.toString(), HttpStatus.OK);

	} catch (Exception e) {
	    e.printStackTrace();
	    if (e.getMessage() == null) {
		joResult.addProperty("code", "400");
		joResult.addProperty("message", "Bad Request");
		return new ResponseEntity(joResult.toString(), HttpStatus.BAD_REQUEST);
	    } else {
		joResult.addProperty("code", "201");
		joResult.addProperty("message", e.getMessage());
		return new ResponseEntity(joResult.toString(), HttpStatus.CREATED);
	    }
	}
    }

    @RequestMapping(value = "/cancelShipment/{idGuides}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity cancelShipment(@RequestHeader(required = false, value = "Authorization") String apiKeyHeader,
	    @PathVariable("idGuides") String idGuides) throws Exception {
	JsonObject joResult = new JsonObject();
	SecurityKey filter = new SecurityKey();
	ShipmentController shipmentC = new ShipmentController();
	ArrayList lstGuide = new ArrayList();
	UserKey userKey = filter.filter(apiKeyHeader);

	PEstadoOrdenPedido estadoOrdenPedido;

	Calendar today = Calendar.getInstance();

	try {

	    if (idGuides.isEmpty()) {
		joResult.addProperty("code", Integer.valueOf(400));
		joResult.addProperty("message", "El recurso solicitado se encuentra vacio.");
		throw new Exception(joResult.toString());
	    }
	    ArrayList lstGuias = new ArrayList();
	    lstGuias.addAll(Arrays.asList(idGuides.split(",")));
	    if (lstGuias.size() >= 0 && lstGuias.size() <= 200) {
		for (int i = 0; i < lstGuias.size(); i++) {
		    boolean bandera = shipmentC.isNoShipmentClient((String) lstGuias.get(i), userKey);
		    if (!bandera) {
			joResult.addProperty("code", Integer.valueOf(400));
			joResult.addProperty("message", (new StringBuilder("La guia ")).append((String) lstGuias.get(i))
				.append(" no pertenece al cliente.").toString());
			throw new Exception(joResult.toString());
		    }
		}

	    }
	    UsuarioDTO usuario = new UsuarioDTO();
	    usuario = getUser(userKey.getLogin(), userKey.getIdClient());
	    if (lstGuias.size() >= 0 && lstGuias.size() <= 200) {
		for (int i = 0; i < lstGuias.size(); i++) {

		    estadoOrdenPedido = new PEstadoOrdenPedido();
		    estadoOrdenPedido.setRefDocumento(lstGuias.get(i).toString());
		    estadoOrdenPedido.setEstadoFecha(today);
		    estadoOrdenPedido.setValidarTransicion(true);
		    estadoOrdenPedido.setEstado("ANULADO");
		    int dato = iGuiaBO.cambiarEstadoGuia(estadoOrdenPedido);
		    if (dato > 0) {

			iDocumentoServicioBO.cancelaDocumento((String) lstGuias.get(i), usuario);

		    } else {

			joResult.addProperty("code", Integer.valueOf(400));
			joResult.addProperty("message", "Algunas guias no pudieron se canceladas[UNIGUIS]");
			throw new Exception(joResult.toString());

		    }

		}

	    }
	    JsonObject jsonObject = new JsonObject();
	    joResult.addProperty("code", Integer.valueOf(200));
	    joResult.addProperty("message", (new StringBuilder("Las guias: ")).append(idGuides)
		    .append(" fueron canceladas con exito.").toString());
	    return new ResponseEntity(joResult.toString(), HttpStatus.OK);
	} catch (Exception e) {
	    e.printStackTrace();
	    return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

    }

    @RequestMapping(value = "/putConsignmentNote", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> putConsignmentNote(@RequestBody ViajeFinCarga viaje,
	    @RequestParam(value = "key", required = true) String apikey) throws Exception {

	StringBuilder builder = new StringBuilder();
	
	JSONObject jsonObject = null;

	SecurityKey filter = new SecurityKey();

	UserKey userKey = filter.filter("Basic " + apikey);

	RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(90000).setSocketTimeout(90000)
		.setConnectionRequestTimeout(60000).build();

	// Configurar hilo io
	IOReactorConfig ioReactorConfig = IOReactorConfig.custom()
		.setIoThreadCount(Runtime.getRuntime().availableProcessors()).setSoKeepAlive(true).build();

	// Establecer el tamaño del grupo de conexiones
	ConnectingIOReactor ioReactor = null;

	try {

	    ioReactor = new DefaultConnectingIOReactor(ioReactorConfig);

	} catch (IOReactorException e) {

	    e.printStackTrace();

	}

	PoolingNHttpClientConnectionManager connManager = new PoolingNHttpClientConnectionManager(ioReactor);
	connManager.setMaxTotal(100);
	connManager.setDefaultMaxPerRoute(1000);

	final CloseableHttpAsyncClient httpClient = HttpAsyncClients.custom().setConnectionManager(connManager)
		.setDefaultRequestConfig(requestConfig).build();

	httpClient.start();

	HttpPost httpPost = new HttpPost(iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.rest.crearcartaporte.url", "UNIGIS")
		    + iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.rest.crearcartaporte.apikey", "UNIGIS"));

	JSONObject bodyToSend = new JSONObject();

	bodyToSend.put("IdViaje", viaje.getIdViaje());
	bodyToSend.put("Estadopos", viaje.getEstado());
	bodyToSend.put("ReferenciaExterna", viaje.getReferenciaExterna());
	bodyToSend.put("TipoObjeto", viaje.getTipoObjeto());
	bodyToSend.put("Ambiente", viaje.getAmbiente());

	StringEntity body = new StringEntity(bodyToSend.toString(), StandardCharsets.UTF_8);

	body.setContentType(MediaType.APPLICATION_JSON_VALUE);

	httpPost.setEntity(body);

	Future<HttpResponse> future = httpClient.execute(httpPost, null);

	HttpResponse httpResponse = future.get();

	if (httpResponse.getStatusLine().getStatusCode() == 200) {

	    BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

	    String inputLine;

	    while ((inputLine = reader.readLine()) != null) {

		builder.append(inputLine);

	    }

	    reader.close();

	    jsonObject = new JSONObject(builder.toString());

	    httpClient.close();

	} else {

	    httpClient.close();
	    
	}
	
	return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);

    }

    private String validaRequerido(String dato, String excepcion) throws Exception {
	String cadena = dato == null ? "" : dato.trim().toUpperCase();
	if (cadena.isEmpty()) {
	    throw new Exception(excepcion);
	}
	return cadena;
    }

    private UsuarioDTO getUser(String login, String idClient) throws Exception {
	UsuarioDTO usuario = new UsuarioDTO();
	usuario.setLogin(login.trim().toUpperCase());
	usuario.setPassword("");
	usuario.setNumCliente(idClient);
	com.innovargia.salesmanager.dtos.UsuarioDTO user = iusuarioBO.getUsuarioLogin(usuario);

	if (user == null) {
	    new ExceptionTracking(Constantes.CODIGO_ACCESOINVALIDO, Constantes.MSG_ERROR_DATOS_INVALIDOS);
	}

	if ("C".equals(user.getEstado())) {
	    throw new Exception("Error");
	}

	return user;
    }

    private ArrayList<JsonObject> getCotizacion(String cotizacion, float alto, float largo, float ancho, float peso)
	    throws Exception {

	String origen = "";
	String destino = "";
	String paqueteConvenio = "";
	String paqueteTarifa = "";
	String paqueteConvenioDetalle = "";
	String paquetePrecio = "";
	String ltlConvenio = "";
	String ltlTarifa = "";
	String ltlConvenioDetalle = "";
	String ltlPrecio = "";

	JsonObject joResultLTLBody = null;
	JsonObject joResultPaqueteBody = null;

	try {

	    joResultLTLBody = new JsonObject();

	    joResultPaqueteBody = new JsonObject();

	    ArrayList<String> datos = new ArrayList<>();

	    datos.addAll(Arrays.asList(cotizacion.split(",")));

	    if (datos.size() >= 0) {

		origen = datos.get(0);

		destino = datos.get(1);

		ArrayList<String> datosLTL = new ArrayList<>();

		datosLTL.addAll(Arrays.asList(datos.get(2).split("-")));

		ltlConvenio = datosLTL.get(0);
		ltlTarifa = datosLTL.get(1);
		ltlConvenioDetalle = datosLTL.get(2);
		ltlPrecio = datosLTL.get(3);

		ArrayList<String> datosPaquete = new ArrayList<>();

		datosPaquete.addAll(Arrays.asList(datos.get(3).split("-")));

		paqueteConvenio = datosPaquete.get(0);
		paqueteTarifa = datosPaquete.get(1);
		paqueteConvenioDetalle = datosPaquete.get(2);
		paquetePrecio = datosPaquete.get(3);

	    }

	    joResultLTLBody.addProperty("from", origen);
	    joResultLTLBody.addProperty("to", destino);
	    joResultLTLBody.addProperty("agreement", ltlConvenio);
	    joResultLTLBody.addProperty("tariff", ltlTarifa);
	    joResultLTLBody.addProperty("agreementDetail", ltlConvenioDetalle);
	    joResultLTLBody.addProperty("price", ltlPrecio);

	    joResultPaqueteBody.addProperty("from", origen);
	    joResultPaqueteBody.addProperty("to", destino);
	    joResultPaqueteBody.addProperty("agreement", paqueteConvenio);
	    joResultPaqueteBody.addProperty("tariff", paqueteTarifa);
	    joResultPaqueteBody.addProperty("agreementDetail", paqueteConvenioDetalle);
	    joResultPaqueteBody.addProperty("price",
		    String.valueOf(calcularPrecioPaquete(Float.parseFloat(paquetePrecio), alto, largo, ancho, peso)));

	    ArrayList<JsonObject> lstJsons = new ArrayList<>();

	    lstJsons.add(joResultLTLBody);

	    lstJsons.add(joResultPaqueteBody);

	    return lstJsons;

	} catch (Exception e) {

	    throw new Exception(e);

	}

    }

    /* METODO PARA CALCULAR PRECIO DEPENDIENDO DEL PESO Y MEDIDAS */
    private float calcularPrecioPaquete(float precioPaquete, float largo, float ancho, float alto, float peso)
	    throws Exception {

	/* SE CALCULA EL PRECIO VOLUMETRICO COMO VIENE EN EL PDF */
	float pesoVolumetrico = ((largo * ancho * alto) / 5000);

	/*
	 * LOS REQUERIMENTOS NOS INDICAN QUE SE USARA EL PESO MAS ALTO ENTRE EL
	 * VOLUMETRICO Y EL PESO QUE PONGAN
	 */
	/*
	 * EN CASO DE QUE EL PESO VOLUMETRICO SEA MAYOR QUE EL PESO QUE SE CAPTURA SE
	 * USA EL PESO VOLUMETRICO PARA CALCULAR EL SOBREPESO
	 */
	if (pesoVolumetrico > peso) {

	    /*
	     * SEGUN LOS REQUERIMENTOS SI EL PESO ES MAYOR A 5 KG, SE COBRA CADA KG EXTRA A
	     * 7
	     */
	    if (pesoVolumetrico > 5) {

		/*
		 * AQUI RESTAMOS LOS 5 KG DEL PESO TOTAL ES DECIR, SI NUESTRO PAQUETE PESA 10 KG
		 * ENTONCES RESTAMOS 5 KG INICIALES QUE VAN INCLUIDOS ES DECIR 10 - 5 LO QUE NOS
		 * DA UN RESTANTE DE 5 KG LOS CUALES TENEMOS QUE MULTIPLICAR POR 7 QUE ES EL
		 * PRECIO EXTRA POR CADA KG DE MAS
		 */
		pesoVolumetrico = (pesoVolumetrico - 5);

		/*
		 * SEGUN LOS REQUERIMENTOS DEPENDIENDO DE LA DISTANCIA EN KMS SE COBRA UN PRECIO
		 * EN ESTE CASO SON $70, $85, $95, A ESTE PRECIO SE LE AGREGARA LOS $7 EXTRAS
		 * POR CADA KG DE MAS
		 */
		precioPaquete = (precioPaquete + (pesoVolumetrico * 7));

	    }
	    /*
	     * EN CASO DE QUE EL PESO CAPTURADO SEA MAYOR QUE EL PESO VOLUMETRICO, SE USA EL
	     * PESO CAPTURADO PARA CALCULAR EL SOBREPESO
	     */
	} else {

	    /*
	     * SEGUN LOS REQUERIMENTOS SI EL PESO ES MAYOR A 5 KG, SE COBRA CADA KG EXTRA A
	     * 7
	     */
	    if (peso > 5) {

		/*
		 * AQUI RESTAMOS LOS 5 KG DEL PESO TOTAL ES DECIR, SI NUESTRO PAQUETE PESA 10 KG
		 * ENTONCES RESTAMOS 5 KG INICIALES QUE VAN INCLUIDOS ES DECIR 10 - 5 LO QUE NOS
		 * DA UN RESTANTE DE 5 KG LOS CUALES TENEMOS QUE MULTIPLICAR POR 7 QUE ES EL
		 * PRECIO EXTRA POR CADA KG DE MAS
		 */
		peso = (peso - 5);

		/*
		 * SEGUN LOS REQUERIMENTOS DEPENDIENDO DE LA DISTANCIA EN KMS SE COBRA UN PRECIO
		 * EN ESTE CASO SON $70, $85, $95, A ESTE PRECIO SE LE AGREGARA LOS $7 EXTRAS
		 * POR CADA KG DE MAS
		 */
		precioPaquete = (precioPaquete + (peso * 7));

	    }

	}

	/* SE REGRESA EL PRECIO YA CALCULADO */
	return precioPaquete;

    }

    private boolean validaEnrutaCobetura(String cprem, String cpdes, String idservicio) throws Exception {
	CruceCoberturaDTO cobertura = new CruceCoberturaDTO();
	cobertura.setIdcoorigen(cprem);
	cobertura.setIdcodestino(cpdes);
	cobertura.setGarantiamax(idservicio);
	CruceCoberturaDTO cobe = iCoberturaBO.getCobertura(cobertura);
	return cobe != null && cobe.getLista_transbordos().size() > 0;

    }

    public int crearOrdenesPedido(EtiquetaRotulacionDTO etiquetaEnviada, UsuarioDTO usuario) throws Exception {

	String data = "";

	String direccion = "";

	String uuid;

	try {

	    etiquetaEnviada.setNumcliente(usuario.getNumCliente());

	    uuid = checKDirectionDes(etiquetaEnviada);

	    etiquetaEnviada.setIdRmDes_des(uuid);

	    String[] idremdes = etiquetaEnviada.getIdRmDes_des().split("-");

	    // Comienza el proceso de invocacion del WS
	    java.net.URL portAddress;

	    String uniServer = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.server", "UNIGIS");

	    portAddress = new java.net.URL(uniServer);

	    ServiceLocator locator = new ServiceLocator();
	    ServiceSoap proxy = locator.getServiceSoap(portAddress);

	    String apiKey = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.apikey", "UNIGIS");

	    Calendar today = Calendar.getInstance();

	    CrearOrdenesPedidoResponse crearOrdenesPedidoResponse = new CrearOrdenesPedidoResponse();

	    POrdenPedido[] pedidosArray = new POrdenPedido[1];

	    POrdenPedido pedidos = new POrdenPedido();

	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	    pedidos.setRefDocumento(etiquetaEnviada.getIdenvio());
	    pedidos.setRefDocumentoAdicional(etiquetaEnviada.getReferencia());
	    today.setTime(dateFormat.parse("2200-12-31 00:00:00.000000"));
	    pedidos.setFecha(today);
	    pedidos.setFechaEntregaOriginal(today);
	    pedidos.setFechaEntrega(today);

	    PCliente cliente = new PCliente();

	    PDomicilio domicilioFiscal = new PDomicilio();

	    RemDes destinatario = new RemDes();

	    /* INICIA BLOQUE DE CLIENTE DESTINO */
	    Direccion direccionSAT = iDireccioneBO
		    .getDireccionDescripcion(Integer.parseInt(etiquetaEnviada.getCp_des()));

	    if (usuario.getNumCliente().equals("100053")) {

		direccion = etiquetaEnviada.getCalle_des() + " " + etiquetaEnviada.getNumexterior_des();

		cliente.setRefCliente(idremdes[4]); // ULTIMOS

		String direccionSplit = etiquetaEnviada.getCalle_des() + " " + etiquetaEnviada.getNumexterior_des();

		cliente.setDireccion(direccionSplit.replace("|", " "));
		cliente.setLocalidad(direccionSplit.replace("|", " "));
		cliente.setCalle(direccionSplit.replace("|", " "));

		domicilioFiscal.setDireccion(direccionSplit.replace("|", " "));
		domicilioFiscal.setLocalidad(direccionSplit.replace("|", " "));
		domicilioFiscal.setCalle(direccionSplit.replace("|", " "));

		direccion = direccion.replace("|", " ");

	    } else {

		direccion = etiquetaEnviada.getCalle_des() + " " + etiquetaEnviada.getNumexterior_des() + " "
			+ etiquetaEnviada.getColonia_des() + " " + etiquetaEnviada.getCiudad_des() + " " +
			// direccionSAT.getEstado() + " " +
			etiquetaEnviada.getEstado_des() + " " + etiquetaEnviada.getCp_des();

		cliente.setLocalidad(etiquetaEnviada.getCiudad_des());
		cliente.setCalle(etiquetaEnviada.getCalle_des());
		cliente.setNumeroPuerta(etiquetaEnviada.getNumexterior_des());

		domicilioFiscal.setLocalidad(etiquetaEnviada.getCiudad_des());
		domicilioFiscal.setCalle(etiquetaEnviada.getCalle_des());
		domicilioFiscal.setNumeroPuerta(etiquetaEnviada.getNumexterior_des());

	    }

	    cliente.setProvincia(direccionSAT.getEstado());
	    cliente.setPais(etiquetaEnviada.getPais_des());

	    domicilioFiscal.setProvincia(direccionSAT.getEstado());
	    domicilioFiscal.setPais(etiquetaEnviada.getPais_des());

	    List<RemDes> lstRemdes = iDireccioneBO.getDireccionRemDes(uuid);

	    if (lstRemdes.get(0).getLatitud() == null && lstRemdes.get(0).getLongitud() == null) {

		String latlen = iDireccioneBO.getLatLng(direccion, uuid);

		String[] coordenadas = latlen.split(",");

		cliente.setLatitud(Double.parseDouble(coordenadas[0]));
		cliente.setLongitud(Double.parseDouble(coordenadas[1]));

		domicilioFiscal.setLatitud(Double.parseDouble(coordenadas[0]));
		domicilioFiscal.setLongitud(Double.parseDouble(coordenadas[1]));

		/*
		 * cliente.setLatitud(0.0); cliente.setLongitud(0.0);
		 * 
		 * domicilioFiscal.setLatitud(0.0); domicilioFiscal.setLongitud(0.0);
		 * 
		 * pedidos.setLatitud(0.0); pedidos.setLongitud(0.0);
		 */

	    } else {

		cliente.setLatitud(Double.parseDouble(lstRemdes.get(0).getLatitud()));
		cliente.setLongitud(Double.parseDouble(lstRemdes.get(0).getLongitud()));

		domicilioFiscal.setLatitud(Double.parseDouble(lstRemdes.get(0).getLatitud()));
		domicilioFiscal.setLongitud(Double.parseDouble(lstRemdes.get(0).getLongitud()));

	    }

	    cliente.setVarchar1(
		    etiquetaEnviada.getRfc_des().equals("") ? "XAXX010101000" : etiquetaEnviada.getRfc_des());

	    cliente.setPartido(direccionSAT.getMunicipio());
	    cliente.setDomicilioDescripcion(etiquetaEnviada.getRazonsocial_des());

	    cliente.setRefCliente(idremdes[4]); // ULTIMOS
	    cliente.setRazonSocial(etiquetaEnviada.getRazonsocial_des());
	    cliente.setTelefono(etiquetaEnviada.getTelefono_des());
	    cliente.setEMail(etiquetaEnviada.getEmail_des());
	    cliente.setBarrio(etiquetaEnviada.getColonia_des());
	    cliente.setDomicilioCodigoPostal(etiquetaEnviada.getCp_des());

	    domicilioFiscal.setBarrio(etiquetaEnviada.getColonia_des());
	    domicilioFiscal.setPartido(direccionSAT.getMunicipio());
	    domicilioFiscal.setCodigoPostal(etiquetaEnviada.getCp_des());
	    domicilioFiscal.setEMail(etiquetaEnviada.getEmail_des());
	    domicilioFiscal.setCodigoPostal(etiquetaEnviada.getCp_des());

	    cliente.setDomicilioFiscal(domicilioFiscal);
	    cliente.setContacto(etiquetaEnviada.getRazonsocial_des());
	    cliente.setCargaExclusiva(false);
	    cliente.setCrearDomicilioOrden(true);
	    cliente.setActualizarDomicilioOrden(true);

	    // CLIENTE 1
	    pedidos.setCliente(cliente);

	    // CLIENTE 2
	    PCliente cliente2 = new PCliente();

	    direccionSAT = iDireccioneBO.getDireccionDescripcion(Integer.parseInt(etiquetaEnviada.getCp_rem()));

	    // CLIENTE REMITENTE
	    cliente2.setRefCliente(usuario.getNumCliente());
	    cliente2.setRazonSocial(etiquetaEnviada.getRazonsocial_rem());
	    cliente2.setTelefono(etiquetaEnviada.getTelefono_rem());
	    cliente2.setEMail(etiquetaEnviada.getEmail_rem());
	    cliente2.setCalle(etiquetaEnviada.getCalle_rem());
	    cliente2.setBarrio(etiquetaEnviada.getColonia_rem());

	    cliente2.setLocalidad(etiquetaEnviada.getCiudad_rem());

	    cliente2.setPartido(direccionSAT.getMunicipio());
	    cliente2.setProvincia(direccionSAT.getEstado());

	    cliente2.setPais(etiquetaEnviada.getPais_rem());
	    cliente2.setNumeroPuerta(etiquetaEnviada.getNumexterior_rem());
	    cliente2.setLatitud(0.00);
	    cliente2.setLongitud(0.00);
	    cliente2.setDomicilioDescripcion(etiquetaEnviada.getRazonsocial_rem());
	    cliente2.setDomicilioCodigoPostal(etiquetaEnviada.getCp_rem());

	    PDomicilio domicilioFiscal2 = new PDomicilio();

	    domicilioFiscal2.setCalle(etiquetaEnviada.getCalle_rem());
	    domicilioFiscal2.setBarrio(etiquetaEnviada.getColonia_rem());

	    domicilioFiscal2.setLocalidad(etiquetaEnviada.getCiudad_rem());

	    domicilioFiscal2.setPartido(direccionSAT.getMunicipio());
	    domicilioFiscal2.setProvincia(direccionSAT.getEstado());

	    domicilioFiscal2.setPais(etiquetaEnviada.getPais_rem());
	    domicilioFiscal2.setNumeroPuerta(etiquetaEnviada.getNumexterior_rem());
	    domicilioFiscal2.setLatitud(0.00);
	    domicilioFiscal2.setLongitud(0.00);
	    domicilioFiscal2.setCodigoPostal(etiquetaEnviada.getCp_rem());
	    domicilioFiscal2.setEMail(etiquetaEnviada.getEmail_rem());

	    cliente2.setDomicilioFiscal(domicilioFiscal2);

	    cliente2.setContacto(etiquetaEnviada.getRazonsocial_rem());
	    cliente2.setCargaExclusiva(false);
	    cliente2.setCrearDomicilioOrden(true);
	    cliente2.setActualizarDomicilioOrden(true);

	    pedidos.setCliente2(cliente2);
	    pedidos.setDescripcion(etiquetaEnviada.getIdenvio() + " " + etiquetaEnviada.getDescripcion_servicio());
	    pedidos.setCodigoSucursal(
		    getCodigoCop(iRotulacionEtiquetasDatosUnigisBO.getDeposito(etiquetaEnviada.getCp_rem())));
	    pedidos.setTipoPedido("MEX-DL");
	    pedidos.setEstado("REQUIERE AUTORIZACION");
	    pedidos.setLatitud(0.00);
	    pedidos.setLongitud(0.00);
	    pedidos.setObservaciones(etiquetaEnviada.getObservacion());
	    pedidos.setTipo("D");

	    // CLIENTE DADOR
	    PCliente clienteDador = new PCliente();

	    clienteDador.setRefCliente(usuario.getNumCliente());
	    clienteDador.setRazonSocial(iNivelUsuarioUnigisBO.getRazonSocial(usuario));

	    pedidos.setClienteDador(clienteDador);

	    pedidos.setPrioridad("1");
	    pedidos.setCargaExclusiva(false);
	    pedidos.setRequiereTurno(false);

	    PDeposito depositoSalida = new PDeposito();

	    // depositoSalida.setRefDepositoExterno(
	    // getCodigoCop(iRotulacionEtiquetasDatosUnigisBO.getDeposito(etiquetaEnviada.getCp_rem())));

	    depositoSalida.setRefDepositoExterno(pedidos.getCodigoSucursal());

	    pedidos.setDepositoSalida(depositoSalida);

	    PDeposito depositoLlegada = new PDeposito();

	    depositoLlegada.setRefDepositoExterno(
		    getCodigoCop(iRotulacionEtiquetasDatosUnigisBO.getDeposito(etiquetaEnviada.getCp_des())));

	    pedidos.setDepositoLlegada(depositoLlegada);

	    pedidos.setCodigoOperacion(
		    getCodigoCop(iRotulacionEtiquetasDatosUnigisBO.getDeposito(etiquetaEnviada.getCp_rem())));

	    // ITEMS
	    POrdenPedidoItem[] itemsArray = new POrdenPedidoItem[1];
	    POrdenPedidoItem items = new POrdenPedidoItem();

	    items.setRefDocumento(etiquetaEnviada.getReferencia());
	    items.setRefDocumentoAdicional(etiquetaEnviada.getContenido());

	    PProducto producto = new PProducto();

	    int alto = (int) etiquetaEnviada.getAlto();
	    int ancho = (int) etiquetaEnviada.getAncho();
	    int peso = (int) etiquetaEnviada.getPesofisico();

	    producto.setRefProducto(etiquetaEnviada.getTipoempaque() + "/" + alto + "/" + ancho + "/" + peso);
	    producto.setDescripcion(etiquetaEnviada.getContenido());
	    producto.setVolumen(etiquetaEnviada.getAlto() * etiquetaEnviada.getLargo() * etiquetaEnviada.getAncho());
	    producto.setPeso(etiquetaEnviada.getPesofisico());
	    producto.setBultos(1);
	    producto.setAlto(etiquetaEnviada.getAlto());
	    producto.setAncho(etiquetaEnviada.getAncho());
	    producto.setProfundidad(etiquetaEnviada.getLargo());
	    producto.setApilable(1);
	    producto.setRotacion("VH");

	    items.setProducto(producto);

	    items.setCantidad(1);
	    items.setVolumen(producto.getVolumen());
	    items.setPeso(producto.getPeso());
	    items.setBulto(producto.getBultos());

	    itemsArray[0] = items;

	    pedidos.setItems(itemsArray);

	    pedidos.setFechaRecoleccion(today);
	    pedidos.setUsarProductos(true);
	    pedidos.setSoloInsertarProductos(false);
	    pedidos.setAgruparItems(false);
	    pedidos.setInicioHorarioRecoleccion1(-1);
	    pedidos.setFinHorarioRecoleccion1(-1);
	    pedidos.setDatetime1(today);
	    pedidos.setValorDeclarado(Double.parseDouble(String.valueOf(etiquetaEnviada.getValordeclarado())));

	    pedidos.setInt1(iDireccioneBO.getReexpedicion(etiquetaEnviada.getCp_des()));

	    pedidos.setVarchar2("1/1");

	    pedidosArray[0] = pedidos;

	    crearOrdenesPedidoResponse.setCrearOrdenesPedidoResult(proxy.crearOrdenesPedido(apiKey, pedidosArray));

	    iRotulacionEtiquetasDatosUnigisBO.UpdateDocumentoUnigis(etiquetaEnviada.getIdenvio(),
		    crearOrdenesPedidoResponse.getCrearOrdenesPedidoResult());

	    // METODO CREADO POR NOSOTROS PARA OBTENER LA ESTRUCTURA XML/SWDL
	    // QUE GENERAMOS Y ENVIAMOS EN TODO EL PROCESO ANTERIOR
	    data = proxy.getXmlRequest();

	    // XStream xstream = new XStream();
	    // data = xstream.toXML(pedidosArray);

	    iRotulacionEtiquetasDatosUnigisBO.insertLog(usuario.getNumCliente(), etiquetaEnviada.getLogin(),
		    etiquetaEnviada.getIdenvio(), 2, data, 2);

	    return crearOrdenesPedidoResponse.getCrearOrdenesPedidoResult();

	} catch (Exception e) {

	    throw new Exception(e.getMessage());

	}

    }

    private String checKDirectionDes(EtiquetaRotulacionDTO etiquetaRotulacionDTO) {

	String idremdes = "";

	CaDocumentoController caDocumentoController = new CaDocumentoController();

	try {

	    idremdes = caDocumentoController.getDirection(etiquetaRotulacionDTO);

	} catch (Exception e) {

	    e.printStackTrace();

	}

	return idremdes;

    }

    @RequestMapping(value = "/getParcelSAT", produces = "application/hal+json;charset=utf8", method = RequestMethod.GET)
    public ResponseEntity<String> getParcelSAT(
	    @RequestHeader(required = false, value = "Authorization") String apiKeyHeader) throws Exception {

	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	SecurityKey filter = new SecurityKey();

	JsonObject joResult = new JsonObject();

	try {

	    // Valida el acceso a la API
	    UserKey userKey = filter.filter(apiKeyHeader);

	    List<MercanciaSat> lstMercancia = new ArrayList<>();

	    lstMercancia = iMercanciaBO.getMercancia();

	    joResult.addProperty("code", 200);
	    joResult.addProperty("message", "OK");
	    joResult.add("parcels_sat", gson.toJsonTree(lstMercancia));

	    return new ResponseEntity<>(joResult.toString(), HttpStatus.OK);

	} catch (Exception e) {

	    e.printStackTrace();

	    if (e.getMessage() == null) {

		joResult.addProperty("code", 400);
		joResult.addProperty("message", "Bad Request");

		return new ResponseEntity<>(joResult.toString(), HttpStatus.BAD_REQUEST);

	    }

	    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

	}
    }

    public String getCodigoCop(String codigo) {

	String codigo_cop = "";

	switch (codigo) {

	case "MEX":

	    codigo_cop = "1800";

	    break;

	case "MTY":

	    codigo_cop = "1803";

	    break;

	case "LEN":

	    codigo_cop = "1801";

	    break;

	case "GDL":

	    codigo_cop = "1802";

	    break;

	}

	return codigo_cop;

    }

}
