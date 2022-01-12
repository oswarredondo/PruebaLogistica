/**
 * 
 */
package com.innovargia.administracion.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.xml.rpc.Call;
import javax.xml.rpc.ServiceException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.formula.functions.Address;
import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.ibo.IDocumentoServicioBO;
import com.administracion.idao.IConexionDAOJDBC;
import com.administracion.idao.IParamsSistemaDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.INivelUsuarioBO;
import com.innovargia.salesmanager.ibo.IRotulacionEtiquetasDatosBO;
import com.innovargia.utils.ConstantesAutoDoc;
import com.innovargia.utils.UtilsRequest;
import com.servicio.constantes.ConstantesAdminSale;
import com.servicio.dtos.DocumentoDTO;

import ar.com.unisolutions.*;
import ar.com.unisolutions.bo.IDireccioneBO;
import ar.com.unisolutions.bo.IMercanciaBO;
import ar.com.unisolutions.dto.Direccion;
import ar.com.unisolutions.dto.MercanciaSat;

/**
 * @author Oswaldo Arredondo
 */
@Controller
@RequestMapping("/api_unigis")
public class UnigisController {

	private static final Logger logger = LoggerFactory.getLogger(UnigisController.class);

	final private Properties properties = new Properties();
	@Autowired
	IRotulacionEtiquetasDatosBO iRotulacionEtiquetasDatosUnigisBO;

	@Autowired
	INivelUsuarioBO iNivelUsuarioUnigisBO;

	@Autowired
	IDocumentoServicioBO iDocumentoServicioBO;

	@Autowired
	IMercanciaBO iMercanciaBO;

	@Autowired
	IDireccioneBO iDireccioneBO;

	@Autowired
	IConexionDAOJDBC iReportesDAOJDBC;
	
	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;

	@RequestMapping(value = "/crearOrdenesPedido", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, ? extends Object> crearOrdenesPedido(
			@RequestParam(value = "uuid", required = true) String uuid, HttpServletRequest request) throws Exception {

		UtilsRequest.displayParametros(request);

		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		CrearOrdenesPedidoResponse crearOrdenesPedidoResponse = new CrearOrdenesPedidoResponse();

		try {

			String error = "";

			if (usuario == null) {

				error = "SESION DE USUARIO ES INVALIDA, VUELVA FIRMARSE.";

			} else if ((uuid == null) || (uuid.trim().length() <= 0)) {

				error = "IDENTIFICADOR DE GUIAS ES INVALIDO, VERIFIQUE CON EL ADMINISTRADOR.";

			} else {

				List<EtiquetaRotulacionDTO> datos = iRotulacionEtiquetasDatosUnigisBO
						.getRegistrosDatosEtiquetasJsonGeneradas(usuario, uuid);

				if ((datos == null) || (datos.size() <= 0)) {

					error = "NO EXISTE INFORMACION DISPONIBLE PARA PROCESAR, VERIFIQUE.";

				} else {

					List<Envio> arr_envios = new ArrayList<Envio>();

					Envio[] myTypes = null;

					// Obtiene todos los registro de Json para el UUID
					for (EtiquetaRotulacionDTO etiquetaEnviada : datos) {

						myTypes = gson.fromJson(etiquetaEnviada.getJson_data(), Envio[].class);

						for (Envio envioAUX : myTypes) {

							arr_envios.add(envioAUX);

						}

					}

					crearOrdenesPedidoResponse = sendOrders(arr_envios, usuario, 1);

				}
			}

			//if (crearOrdenesPedidoResponse.getCrearOrdenesPedidoResult() == 1 && error.equals("")) {
			if (crearOrdenesPedidoResponse.getCrearOrdenesPedidoResult() == 1) {
				modelMap.put("success", true);
				modelMap.put("message", "Correcto");
				modelMap.put("status", crearOrdenesPedidoResponse.getCrearOrdenesPedidoResult());

			} else {

				modelMap.put("success", true);
				modelMap.put("message", error.equals("") ? "Error" : error);
				modelMap.put("status", crearOrdenesPedidoResponse.getCrearOrdenesPedidoResult());

			}

		} catch (Exception dae) {

			logger.debug("ERROR AL CREAR LOS DOCUMENTOS :" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}

		return modelMap;

	}

	@RequestMapping(value = "/reenviaOrdenesPedido", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, ? extends Object> reenviaOrdenesPedido(
			@RequestParam(value = "uuid", required = true) String uuid, HttpServletRequest request) throws Exception {

		UtilsRequest.displayParametros(request);

		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		CrearOrdenesPedidoResponse crearOrdenesPedidoResponse = new CrearOrdenesPedidoResponse();

		try {

			String error = "";

			if (usuario == null) {

				error = "SESION DE USUARIO ES INVALIDA, VUELVA FIRM6ARSE.";

			} else if ((uuid == null) || (uuid.trim().length() <= 0)) {

				error = "IDENTIFICADOR DE GUIA ES INVALIDO, VERIFIQUE CON EL ADMINISTRADOR.";

			} else {

				// String iddocumentomadre = (request.getParameter("iddocumentomadre") == null ?
				// "": request.getParameter("iddocumentomadre"));

				DocumentoDTO datos = null;

				List<DocumentoDTO> etiquetas = new ArrayList<DocumentoDTO>();

				String[] lstdatos = uuid.split(",");

				for (int i = 0; i < lstdatos.length; i++) {

					datos = iDocumentoServicioBO.getInfoDocumentoJson(lstdatos[i]);

					etiquetas.add(datos);

				}
				if ((etiquetas == null) || (etiquetas.size() <= 0)) {

					error = "NO EXISTE INFORMACION DISPONIBLE PARA PROCESAR, VERIFIQUE.";

				} else {

					List<Envio> arr_envios = new ArrayList<Envio>();

					Envio[] myTypes = new Envio[etiquetas.size()];

					// Obtiene todos los registro de Json para el UUID
					for (int i = 0; i < etiquetas.size(); i++) {

						myTypes[i] = etiquetas.get(i).datosCarta;

					}

					for (Envio envio : myTypes) {

						arr_envios.add(envio);

					}

					crearOrdenesPedidoResponse = sendOrders(arr_envios, usuario, 2);

				}
			}

			//if (crearOrdenesPedidoResponse.getCrearOrdenesPedidoResult() == 1 && error.equals("")){
			  if (crearOrdenesPedidoResponse.getCrearOrdenesPedidoResult() == 1){

				modelMap.put("success", true);
				modelMap.put("message", "Correcto");
				modelMap.put("status", crearOrdenesPedidoResponse.getCrearOrdenesPedidoResult());

			} else {

				modelMap.put("success", true);
				modelMap.put("message", error.equals("") ? "Error" : error);
				modelMap.put("status", crearOrdenesPedidoResponse.getCrearOrdenesPedidoResult());

			}

		} catch (Exception dae) {

			logger.debug("ERROR AL CREAR LOS DOCUMENTOS :" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}

		return modelMap;

	}

	@RequestMapping(value = "/getMercanciaSat", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, ? extends Object> getMercanciaSat(HttpServletRequest request) throws Exception {

		UtilsRequest.displayParametros(request);

		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<MercanciaSat> lstMercancia;

		try {

			lstMercancia = iMercanciaBO.getMercancia();

			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lstMercancia.size());
			modelMap.put("proxiArray", lstMercancia);

		} catch (Exception dae) {

			logger.debug("ERROR AL OBTENER LA MERCANCIA :" + dae.getMessage());

			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}

		return modelMap;

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

	public CrearOrdenesPedidoResponse sendOrders(List<Envio> arr_envios, UsuarioDTO usuario, int type)
			throws Exception {

		// Comienza el proceso de invocacion del WS
		java.net.URL portAddress;

		String uniServer = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.server", "UNIGIS");
		//String uniServer = "https://cloudmx.unigis.com/Tracusa/mapi/soap/logistic/service.asmx";
		
		/* URL DEL SERVICIO DE UNIGIS */
		 portAddress = new java.net.URL(uniServer);

		// CONFORME LA DOC DE AXIS 1.4 SEINTANCIA EL LOCATOR
		ServiceLocator locator = new ServiceLocator();

		// CONFORME LA DOC DE AXIS 1.4 SEINTANCIA EL PROXY
		ServiceSoap proxy = locator.getServiceSoap(portAddress);

		// CUALQUIERA SIRVE PARA PRUEBAS
		String apiKey = iParamsSistemaDAO.getValorPropiedad("ar.com.unisolutions.apikey", "UNIGIS");
		String xmlEnviado = "";

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		int multiple = 1;

		Calendar today = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		String data = "";

		String uuid;

		POrdenPedido[] pedidosArray = new POrdenPedido[1];

		POrdenPedido pedidos = new POrdenPedido();

		/* CLIENTE DESTINO */
		PCliente cliente = new PCliente();

		PDomicilio domicilioFiscal = new PDomicilio();

		/* CLIENTE ORIGEN */
		PCliente cliente2 = new PCliente();

		/* DEPOSITO SALIDA (CO INICIAL DE DONDE SALE) */
		PDeposito depositoSalida = new PDeposito();

		/* DEPOSITO LLEGADA (CO AL QUE LLEGA PRA ENVIAR A SU DESTINO) */
		PDeposito depositoLlegada = new PDeposito();

		/* PRODUCTO E ITEM */
		PProducto producto = new PProducto();
		POrdenPedidoItem[] itemsArray = new POrdenPedidoItem[1];
		POrdenPedidoItem items = new POrdenPedidoItem();

		CrearOrdenesPedidoResponse crearOrdenesPedidoResponse = new CrearOrdenesPedidoResponse();

		try {

			// PARA CADA GUIA SE GENERA UN ENVIO A UNIGIS
			for (Envio etiquetaEnviada : arr_envios) {

				data = gson.toJson(etiquetaEnviada);

				if (type == 1) {

					iRotulacionEtiquetasDatosUnigisBO.insertLog(etiquetaEnviada.getNumCliente(),
							etiquetaEnviada.getLogin(), etiquetaEnviada.getIdEnvio(), 1, data, 1);

				}

				/* INICIA BLOQUE DE PEDIDO */
				pedidos.setRefDocumento(etiquetaEnviada.getIdEnvio());
				pedidos.setRefDocumentoAdicional(etiquetaEnviada.getReferencia());

				calendar.setTime(dateFormat.parse("2200-12-31 00:00:00.000000"));
				pedidos.setFecha(calendar);

				if (etiquetaEnviada.destinatario.getIdRmDes() == null
						|| !etiquetaEnviada.destinatario.getIdRmDes().contains("-")) {

					uuid = checKDirectionDes(etiquetaEnviada);

					String[] idremdes = uuid.split("-");

					cliente.setRefCliente(idremdes[4]); // ULTIMOS

				} else {

					uuid = etiquetaEnviada.getIdRmDesDe();

					String[] idremdes = etiquetaEnviada.getIdRmDesDe().split("-");
					// CLIENTE DESTINATARIO
					cliente.setRefCliente(idremdes[4]); // ULTIMOS

				}

				/* INICIA BLOQUE DE CLIENTE DESTINO */
				Direccion direccion = iDireccioneBO
						.getDireccionDescripcion(Integer.parseInt(etiquetaEnviada.destinatario.getCp()));

				String direccionGeo = "";

				if (etiquetaEnviada.getNumCliente().equals("100053")
						&& iDireccioneBO.getSistemaEnvio(etiquetaEnviada.getIdEnvio()).equals("2")) {

					String direccionSplit = etiquetaEnviada.destinatario.getCalle() + " "
							+ etiquetaEnviada.destinatario.getNumexterior();

					cliente.setDireccion(direccionSplit.replace("|", " "));
					cliente.setLocalidad(direccionSplit.replace("|", " "));
					cliente.setCalle(direccionSplit.replace("|", " "));

					domicilioFiscal.setDireccion(direccionSplit.replace("|", " "));
					domicilioFiscal.setLocalidad(direccionSplit.replace("|", " "));

					domicilioFiscal.setCalle(direccionSplit.replace("|", " "));
					direccionGeo = direccionSplit.replace("|", " ");

				} else {

					direccionGeo = etiquetaEnviada.destinatario.getCalle() + " "
							+ etiquetaEnviada.destinatario.getNumexterior() + " "
							+ etiquetaEnviada.destinatario.getColonia() + " " + etiquetaEnviada.destinatario.getCiudad()
							+ " " + direccion.getEstado() + " " + etiquetaEnviada.destinatario.getCp();

					cliente.setLocalidad(etiquetaEnviada.destinatario.getCiudad());
					
					cliente.setCalle(etiquetaEnviada.destinatario.getCalle());
					cliente.setNumeroPuerta(etiquetaEnviada.destinatario.getNumexterior());
					
					domicilioFiscal.setLocalidad(etiquetaEnviada.destinatario.getCiudad());
					domicilioFiscal.setProvincia(direccion.getEstado());
					domicilioFiscal.setCalle(etiquetaEnviada.destinatario.getCalle());
					domicilioFiscal.setNumeroPuerta(etiquetaEnviada.destinatario.getNumexterior());

				}
				
				cliente.setProvincia(direccion.getEstado());
				cliente.setPais(etiquetaEnviada.destinatario.getPais());
				
				domicilioFiscal.setProvincia(direccion.getEstado());
				domicilioFiscal.setPais(etiquetaEnviada.destinatario.getPais());
				
				List<RemDes> lstRemdes = iDireccioneBO.getDireccionRemDes(uuid);

				if (lstRemdes.get(0).getLatitud() == null && lstRemdes.get(0).getLongitud() == null) {

				    
					String latlen = iDireccioneBO.getLatLng(direccionGeo, uuid);

					String[] coordenadas = latlen.split(",");

					cliente.setLatitud(Double.parseDouble(coordenadas[0]));
					cliente.setLongitud(Double.parseDouble(coordenadas[1]));

					domicilioFiscal.setLatitud(Double.parseDouble(coordenadas[0]));
					domicilioFiscal.setLongitud(Double.parseDouble(coordenadas[1]));
					
				    /*
					cliente.setLatitud(0.0);
					cliente.setLongitud(0.0);

					domicilioFiscal.setLatitud(0.0);
					domicilioFiscal.setLongitud(0.0);

					pedidos.setLatitud(0.0);
					pedidos.setLongitud(0.0);
					*/
				} else {

					cliente.setLatitud(Double.parseDouble(lstRemdes.get(0).getLatitud()));
					cliente.setLongitud(Double.parseDouble(lstRemdes.get(0).getLongitud()));

					domicilioFiscal.setLatitud(Double.parseDouble(lstRemdes.get(0).getLatitud()));
					domicilioFiscal.setLongitud(Double.parseDouble(lstRemdes.get(0).getLongitud()));


				}

				cliente.setVarchar1(etiquetaEnviada.destinatario.getRfc() == null ? "XAXX010101000" : etiquetaEnviada.destinatario.getRfc());
				cliente.setRazonSocial(etiquetaEnviada.destinatario.getRazonSocial());
				cliente.setTelefono(etiquetaEnviada.destinatario.getTelefono());
				cliente.setEMail(etiquetaEnviada.destinatario.getCorreoe());
				cliente.setBarrio(etiquetaEnviada.destinatario.getColonia());
				cliente.setDomicilioCodigoPostal(etiquetaEnviada.destinatario.getCp());
				/* Direccion de catalogo de SAT */
				cliente.setPartido(direccion.getMunicipio());
				cliente.setPais("MEX");

				cliente.setDomicilioDescripcion(etiquetaEnviada.destinatario.getRazonSocial());

				domicilioFiscal.setBarrio(etiquetaEnviada.destinatario.getColonia());
				/* Direccion de catalogo de SAT */
				domicilioFiscal.setPartido(direccion.getMunicipio());
				domicilioFiscal.setPais("MEX");

				domicilioFiscal.setCodigoPostal(etiquetaEnviada.destinatario.getCp());
				domicilioFiscal.setEMail(etiquetaEnviada.destinatario.getCorreoe());

				cliente.setDomicilioFiscal(domicilioFiscal);

				cliente.setContacto(etiquetaEnviada.destinatario.getRazonSocial());
				cliente.setCargaExclusiva(false);
				cliente.setCrearDomicilioOrden(true);
				cliente.setActualizarDomicilioOrden(true);
				/* FIN BLOQUE DE CLIENTE DESTINO */
				pedidos.setFechaEntregaOriginal(calendar);
				pedidos.setFechaEntrega(calendar);

				// SE AGREGA EL CLIENTE DESTINO A EL NODO DE PEDIDO
				pedidos.setCliente(cliente);

				/* INICIA BLOQUE DE CLIENTE ORIGEN */
				
				direccion = iDireccioneBO
					.getDireccionDescripcion(Integer.parseInt(etiquetaEnviada.remitente.getCp()));
				
				cliente2.setRefCliente(type == 1 ? usuario.getNumCliente() : etiquetaEnviada.getNumCliente());
				cliente2.setRazonSocial(etiquetaEnviada.remitente.getRazonSocial());
				cliente2.setTelefono(etiquetaEnviada.remitente.getTelefono());
				cliente2.setEMail(etiquetaEnviada.remitente.getCorreoe());
				cliente2.setCalle(etiquetaEnviada.remitente.getCalle());
				cliente2.setBarrio(etiquetaEnviada.remitente.getColonia());
				cliente2.setLocalidad(etiquetaEnviada.remitente.getCiudad());
				
				cliente2.setPartido(direccion.getMunicipio());
				cliente2.setProvincia(direccion.getEstado());
				
				cliente2.setPais(etiquetaEnviada.remitente.getPais());
				cliente2.setNumeroPuerta(etiquetaEnviada.remitente.getNumexterior());
				cliente2.setLatitud(0.00);
				cliente2.setLongitud(0.00);
				cliente2.setDomicilioDescripcion(etiquetaEnviada.remitente.getRazonSocial());
				cliente2.setDomicilioCodigoPostal(etiquetaEnviada.remitente.getCp());

				PDomicilio domicilioFiscal2 = new PDomicilio();

				domicilioFiscal2.setCalle(etiquetaEnviada.remitente.getCalle());
				domicilioFiscal2.setBarrio(etiquetaEnviada.remitente.getColonia());
				
				domicilioFiscal2.setLocalidad(etiquetaEnviada.remitente.getCiudad());
				
				domicilioFiscal2.setPartido(direccion.getMunicipio());
				domicilioFiscal2.setProvincia(direccion.getEstado());
				
				domicilioFiscal2.setPais(etiquetaEnviada.remitente.getPais());
				domicilioFiscal2.setNumeroPuerta(etiquetaEnviada.remitente.getNumexterior());
				domicilioFiscal2.setLatitud(0.00);
				domicilioFiscal2.setLongitud(0.00);
				domicilioFiscal2.setCodigoPostal(etiquetaEnviada.remitente.getCp());
				domicilioFiscal2.setEMail(etiquetaEnviada.remitente.getCorreoe());

				cliente2.setDomicilioFiscal(domicilioFiscal2);

				cliente2.setContacto(etiquetaEnviada.remitente.getRazonSocial());
				cliente2.setCargaExclusiva(false);
				cliente2.setCrearDomicilioOrden(true);
				cliente2.setActualizarDomicilioOrden(true);
				/* FIN BLOQUE DE CLIENTE DESTINO */

				// SE AGREGA EL CLIENTE DESTINO A EL NODO DE PEDIDO
				pedidos.setCliente2(cliente2);

				pedidos.setDescripcion(etiquetaEnviada.getIdEnvio() + " " + etiquetaEnviada.getDes_servicio());
				pedidos.setCodigoSucursal(
						getCodigoCop(iRotulacionEtiquetasDatosUnigisBO.getDeposito(etiquetaEnviada.remitente.getCp())));
				pedidos.setTipoPedido("MEX-DL");
				pedidos.setEstado("REQUIERE AUTORIZACION");
				pedidos.setLatitud(0.00);
				pedidos.setLongitud(0.00);
				pedidos.setObservaciones(etiquetaEnviada.getComentario());
				pedidos.setTipo("D");

				/* INICIO BLOQUE DE CLIENTE DADOR(USUARIO QUE ENVIA) */
				PCliente clienteDador = new PCliente();

				clienteDador.setRefCliente(type == 1 ? usuario.getNumCliente() : etiquetaEnviada.getNumCliente());
				clienteDador.setRazonSocial(type == 1 ? iNivelUsuarioUnigisBO.getRazonSocial(usuario) : etiquetaEnviada.getRazonSocialRem());

				/* FIN BLOQUE DE CLIENTE DADOR(USUARIO QUE ENVIA) */

				// SE AGREGA EL CLIENTE DADOR A EL NODO DE PEDIDO
				pedidos.setClienteDador(clienteDador);

				pedidos.setPrioridad("1");
				pedidos.setCargaExclusiva(false);
				pedidos.setRequiereTurno(false);

				/* INICIO BLOQUE DE DEPOSITO SALIDA (CO INICIAL DE DONDE SALE) */
				depositoSalida.setRefDepositoExterno(
						getCodigoCop(iRotulacionEtiquetasDatosUnigisBO.getDeposito(etiquetaEnviada.remitente.getCp())));
				/* FIN BLOQUE DE DEPOSITO SALIDA (CO INICIAL DE DONDE SALE) */

				// SE AGREGA EL DEPOSITO SALIDA A EL NODO DE PEDIDO
				pedidos.setDepositoSalida(depositoSalida);

				/*
				 * INICIO BLOQUE DE DEPOSITO LLEGADA (CO AL QUE LLEGA PRA ENVIAR A SU DESTINO)
				 */
				depositoLlegada.setRefDepositoExterno(getCodigoCop(
						iRotulacionEtiquetasDatosUnigisBO.getDeposito(etiquetaEnviada.destinatario.getCp())));
				/* FIN BLOQUE DE DEPOSITO LLEGADA (CO AL QUE LLEGA PRA ENVIAR A SU DESTINO) */

				// SE AGREGA EL DEPOSITO LLEGADA A EL NODO DE PEDIDO
				pedidos.setDepositoLlegada(depositoLlegada);

				pedidos.setCodigoOperacion(
						getCodigoCop(iRotulacionEtiquetasDatosUnigisBO.getDeposito(etiquetaEnviada.remitente.getCp())));

				/* INICIO BLOQUE PRODUCTO E ITEMS */
				items.setRefDocumento(etiquetaEnviada.getReferencia());
				items.setRefDocumentoAdicional(etiquetaEnviada.getContenido());

				int alto = (int) etiquetaEnviada.getAlto();
				int ancho = (int) etiquetaEnviada.getAncho();
				int peso = (int) etiquetaEnviada.getPeso();

				producto.setCodigo(etiquetaEnviada.getIdproducto());
				producto.setRefProducto(
						(etiquetaEnviada.getTipo_empaque() == null ? "PAQUETE" : etiquetaEnviada.getTipo_empaque())
								+ "/" + alto + "/" + ancho + "/" + peso);
				producto.setDescripcion(etiquetaEnviada.getContenido());
				producto.setVolumen(
						etiquetaEnviada.getAlto() * etiquetaEnviada.getLargo() * etiquetaEnviada.getAncho());
				producto.setPeso(etiquetaEnviada.getPeso());
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
				/* FIN BLOQUE PRODUCTO E ITEMS */

				// SE AGREGA EL ITEM A EL NODO DE PEDIDO
				pedidos.setItems(itemsArray);
				pedidos.setFechaRecoleccion(today);
				pedidos.setUsarProductos(true);
				pedidos.setSoloInsertarProductos(false);
				pedidos.setAgruparItems(false);
				pedidos.setInicioHorarioRecoleccion1(-1);
				pedidos.setFinHorarioRecoleccion1(-1);
				pedidos.setDatetime1(today);
				pedidos.setValorDeclarado(Double.parseDouble(String.valueOf(etiquetaEnviada.getMonto())));
				
				pedidos.setVarchar2(multiple + "/" + arr_envios.size());

				multiple++;

				if (etiquetaEnviada.getesMadre().equals("n")) {

					pedidos.setVarchar1("");

				} else {

					pedidos.setVarchar1(etiquetaEnviada.getesMadre());

				}

				pedidos.setInt1(iDireccioneBO.getReexpedicion(etiquetaEnviada.destinatario.getCp()));
				
				pedidosArray[0] = pedidos;
				/* FIN BLOQUE DE PEDIDO */

				// SE ENVIAN LOS DATOS Y SE OBTIENE EL CODIGO DE ESTATUS
				crearOrdenesPedidoResponse.setCrearOrdenesPedidoResult(proxy.crearOrdenesPedido(apiKey, pedidosArray));

				// METODO CREADO POR NOSOTROS PARA OBTENER LA ESTRUCTURA XML/SWDL
				xmlEnviado = proxy.getXmlRequest();

				iRotulacionEtiquetasDatosUnigisBO.UpdateDocumentoUnigis(etiquetaEnviada.getIdEnvio(),
						crearOrdenesPedidoResponse.getCrearOrdenesPedidoResult());

				if (type == 1) {

					iRotulacionEtiquetasDatosUnigisBO.insertLog(etiquetaEnviada.getNumCliente(),
							etiquetaEnviada.getLogin(), etiquetaEnviada.getIdEnvio(), 1, xmlEnviado, 2);

				} else {

					iRotulacionEtiquetasDatosUnigisBO.updateLogReenvio(etiquetaEnviada.getIdEnvio());

				}

			}

			return crearOrdenesPedidoResponse;

		} catch (Exception e) {

			throw new Exception("ERROR AL CREAR LOS DOCUMENTOS :" + e.getMessage());

		}
	}

	private String checKDirectionDes(Envio etiquetaRotulacionDTO) {

		String idremdes = "";

		try {

			idremdes = iRotulacionEtiquetasDatosUnigisBO.getDirection(etiquetaRotulacionDTO);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return idremdes;
	}

}