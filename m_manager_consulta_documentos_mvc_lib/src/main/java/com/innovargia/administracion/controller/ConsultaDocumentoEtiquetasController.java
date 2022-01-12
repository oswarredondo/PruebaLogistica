/**
 * 
 */
package com.innovargia.administracion.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.administracion.ibo.IDocumentoServicioBO;
import com.administracion.ibo.IEtiquetasBO;
import com.administracion.ibo.IMuestraEtiquetasBO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ups.ibo.ITrackingBO;
import com.innovargia.utils.Files;
import com.innovargia.utils.MimeTypes;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.UtilsStringFechas;
import com.servicio.constantes.ConstantesAdminSale;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.consulta.dtos.ConsultaGridExtJS;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.DocumentoDTO;

import ar.com.unisolutions.CrearOrdenesPedidoResponse;
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
import ar.com.unisolutions.bo.IGuiaBO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author Adri�n /busqueda_etiquetas/cancelarguia
 */
@RequestMapping("/busqueda_etiquetas")
@Controller
public class ConsultaDocumentoEtiquetasController {

	private static final Logger logger = LoggerFactory.getLogger(ConsultaDocumentoEtiquetasController.class);

	@Autowired
	IDocumentoServicioBO iDocumentoServicioBO;

	@Autowired
	IEtiquetasBO iEtiquetasBO;
	@Autowired
	IMuestraEtiquetasBO iMuestraEtiquetasBO;
	@Autowired
	ITrackingBO iTrackingBO;
	@Autowired
	IGuiaBO iGuiaBO;

	@RequestMapping(value = "/getDatos", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, ? extends Object> getDatos(HttpServletRequest request) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ModelAndView model = new ModelAndView();
		List<DocumentoConsultaDTO> lista = null;
		List<ConsultaGridExtJS> lista_docts = null;
		List<ConsultaGridExtJS> lista_final = null;
		displayParametros(request);

		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		String start = request.getParameter("start") == null ? "0" : request.getParameter("start");
		try {
			String tipoDocumento = ((request.getParameter("tipoDocumento") == null)
					|| (request.getParameter("tipoDocumento").trim().length() <= 0)) ? null
							: request.getParameter("tipoDocumento");

			if (tipoDocumento != null) {
				if (usuario == null) {
					throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
				}

				lista_docts = configuraConsulta(request, usuario);
				PagedListHolder<ConsultaGridExtJS> documentos = new PagedListHolder<ConsultaGridExtJS>(lista_docts);
				documentos.setPageSize(50);
				documentos.setPage(0);
				request.getSession().setAttribute("SearchdDocumentosController_documentos", documentos);
				request.getSession().setAttribute("SearchdDocumentosController_size", lista_docts.size() + "");

				lista_final = documentos.getPageList();
				modelMap.put("success", true);
				modelMap.put("message", "Correcto");
				modelMap.put("totalCount", lista_docts.size());
				modelMap.put("proxiArray", lista_final);
			} else {
				String page = request.getParameter("page");
				PagedListHolder<ConsultaGridExtJS> documentos = (PagedListHolder<ConsultaGridExtJS>) request
						.getSession().getAttribute("SearchdDocumentosController_documentos");
				int tamanio = 0;

				try {
					tamanio = Integer
							.parseInt((String) request.getSession().getAttribute("SearchdDocumentosController_size"));
					documentos.setPage(Integer.parseInt(page));
				} catch (Exception e) {
					documentos.setPage(1);
				}

				lista_final = documentos.getPageList();
				modelMap.put("success", true);
				modelMap.put("message", "Correcto");
				modelMap.put("totalCount", tamanio);
				modelMap.put("proxiArray", lista_final);

			}

		} catch (Exception dae) {
			logger.debug("Error consulta:" + dae.getLocalizedMessage());
			dae.printStackTrace();
			model.addObject("success", false);
			model.addObject("message", dae.getMessage());

		}
		return modelMap;

	}

	@RequestMapping(value = "/getDatosFueraSitio", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, ? extends Object> getDatosFueraSitio(HttpServletRequest request) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ModelAndView model = new ModelAndView();
		List<DocumentoConsultaDTO> lista = null;
		List<ConsultaGridExtJS> lista_docts = null;
		List<ConsultaGridExtJS> lista_final = null;
		displayParametros(request);

		// Indica que es internet la busqueda
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.entidad.setIdentidad(ConstantesAdminSale.CONSULTA_INTERNET);

		String start = request.getParameter("start") == null ? "0" : request.getParameter("start");
		try {

			usuario.setNumCliente(request.getParameter("numcte"));

			String tipoDocumento = ((request.getParameter("tipoDocumento") == null)
					|| (request.getParameter("tipoDocumento").trim().length() <= 0)) ? null
							: request.getParameter("tipoDocumento");

			if (tipoDocumento != null) {

				lista_docts = configuraConsulta(request, usuario);
				PagedListHolder<ConsultaGridExtJS> documentos = new PagedListHolder<ConsultaGridExtJS>(lista_docts);
				documentos.setPageSize(50);
				documentos.setPage(0);
				request.getSession().setAttribute("SearchdDocumentosController_documentos", documentos);
				request.getSession().setAttribute("SearchdDocumentosController_size", lista_docts.size() + "");

				lista_final = documentos.getPageList();
				modelMap.put("success", true);
				modelMap.put("message", "Correcto");
				modelMap.put("totalCount", lista_docts.size());
				modelMap.put("proxiArray", lista_final);
			} else {
				String page = request.getParameter("page");
				PagedListHolder<ConsultaGridExtJS> documentos = (PagedListHolder<ConsultaGridExtJS>) request
						.getSession().getAttribute("SearchdDocumentosController_documentos");
				int tamanio = Integer
						.parseInt((String) request.getSession().getAttribute("SearchdDocumentosController_size"));

				documentos.setPage(Integer.parseInt(page));
				lista_final = documentos.getPageList();
				modelMap.put("success", true);
				modelMap.put("message", "Correcto");
				modelMap.put("totalCount", tamanio);
				modelMap.put("proxiArray", lista_final);

			}

		} catch (Exception dae) {
			model.addObject("success", false);
			model.addObject("message", dae.getMessage());

		}
		return modelMap;

	}

	@RequestMapping(value = "/getUnigisGuidas", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, ? extends Object> getUnigisGuidas(HttpServletRequest request) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ModelAndView model = new ModelAndView();
		List<DocumentoConsultaDTO> lista = null;
		List<ConsultaGridExtJS> lista_docts = null;
		List<ConsultaGridExtJS> lista_final = null;
		displayParametros(request);

		// Indica que es internet la busqueda
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.entidad.setIdentidad(ConstantesAdminSale.CONSULTA_INTERNET);

		String start = request.getParameter("start") == null ? "0" : request.getParameter("start");
		try {

			usuario.setNumCliente(request.getParameter("numcte"));

			String tipoDocumento = ((request.getParameter("tipoDocumento") == null)
					|| (request.getParameter("tipoDocumento").trim().length() <= 0)) ? null
							: request.getParameter("tipoDocumento");

			if (tipoDocumento != null) {

				lista_docts = configuraConsultaUnigis(request, usuario);
				PagedListHolder<ConsultaGridExtJS> documentos = new PagedListHolder<ConsultaGridExtJS>(lista_docts);
				documentos.setPageSize(50);
				documentos.setPage(0);
				request.getSession().setAttribute("SearchdDocumentosController_documentos", documentos);
				request.getSession().setAttribute("SearchdDocumentosController_size", lista_docts.size() + "");

				lista_final = documentos.getPageList();
				modelMap.put("success", true);
				modelMap.put("message", "Correcto");
				modelMap.put("totalCount", lista_docts.size());
				modelMap.put("proxiArray", lista_final);
			} else {
				String page = request.getParameter("page");
				PagedListHolder<ConsultaGridExtJS> documentos = (PagedListHolder<ConsultaGridExtJS>) request
						.getSession().getAttribute("SearchdDocumentosController_documentos");
				int tamanio = Integer
						.parseInt((String) request.getSession().getAttribute("SearchdDocumentosController_size"));

				documentos.setPage(Integer.parseInt(page));
				lista_final = documentos.getPageList();
				modelMap.put("success", true);
				modelMap.put("message", "Correcto");
				modelMap.put("totalCount", tamanio);
				modelMap.put("proxiArray", lista_final);

			}

		} catch (Exception dae) {
			model.addObject("success", false);
			model.addObject("message", dae.getMessage());

		}
		return modelMap;

	}

	private DocumentoDTO configuraDatosConsulta(HttpServletRequest request, UsuarioDTO usuario) {
		String tipoDocumento = ((request.getParameter("tipoDocumento") == null)
				|| (request.getParameter("tipoDocumento").trim().length() <= 0)) ? null
						: request.getParameter("tipoDocumento");

		String iddatoabuscar = (request.getParameter("iddatoabuscar") == null ? ""
				: request.getParameter("iddatoabuscar"));

		boolean soloConCita = (request.getParameter("soloConCita") == null ? false
				: Boolean.parseBoolean(request.getParameter("soloConCita")));

		DocumentoDTO datos = new DocumentoDTO();
		try {
			datos.setConsecutivo(request.getParameter("rastreo"));
		} catch (Exception e) {
			datos.setConsecutivo(-1);
		}

		datos.setIdTipoDocumento(tipoDocumento);
		datos.setRazonSocialDestino(iddatoabuscar);
		datos.setReferencia(iddatoabuscar);
		datos.entidad.setIdentidad(usuario.entidad.getIdentidad());
		datos.organizacion.setIdorganizacion(usuario.organizacion.getIdorganizacion());
		datos.setContenidoDeclarado(iddatoabuscar);
		datos.setTelefonoQuienSolicita(iddatoabuscar);
		if (iddatoabuscar.contains("%")) {
			datos.setIdDocumento(iddatoabuscar);
		} else {
			int tipobusqueda = (request.getParameter("tipobusqueda") == null ? -1
					: Integer.parseInt(request.getParameter("tipobusqueda")));

			if (tipobusqueda == 18) {
				// Busqueda por consecutivo
				datos.setIdDocumento("" + iddatoabuscar);
			} else {
				datos.setIdDocumento(iddatoabuscar);
				/*
				 * if (iddatoabuscar.contains(",")) { String guias = "'" +
				 * iddatoabuscar.replace(",", "','") + "'"; datos.setIdDocumento(guias);
				 * logger.debug("Guias:" + guias); } else { datos.setIdDocumento("'" +
				 * iddatoabuscar + "'"); }
				 */
			}

		}

		datos.setEmbarque(iddatoabuscar);
		datos.setDelivery(iddatoabuscar);
		datos.setFactura(iddatoabuscar);
		datos.setSoloConCita(soloConCita);
		return datos;
	}

	private List<ConsultaGridExtJS> configuraConsulta(HttpServletRequest request, UsuarioDTO usuario) throws Exception {

		DocumentoDTO datos = configuraDatosConsulta(request, usuario);

		int tipobusqueda = (request.getParameter("tipobusqueda") == null ? -1
				: Integer.parseInt(request.getParameter("tipobusqueda")));

		String fechaini = (request.getParameter("fechaini") == null ? "" : request.getParameter("fechaini"));
		String fechafin = (request.getParameter("fechafin") == null ? "" : request.getParameter("fechafin"));

		if (fechaini.trim().length() > 0) {
			fechaini = UtilsStringFechas.formatoStrFecha(fechaini, "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
		}
		if (fechafin.trim().length() > 0) {
			fechafin = UtilsStringFechas.formatoStrFecha(fechafin, "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
		}

		if (tipobusqueda >= 0) {
			List<DocumentoConsultaDTO> lista_docs = iDocumentoServicioBO.consulta(datos, tipobusqueda, fechaini,
					fechafin, usuario);

			List<ConsultaGridExtJS> lista_final = new ArrayList<ConsultaGridExtJS>();

			for (DocumentoConsultaDTO documentoConsultaDTO : lista_docs) {
				lista_final.add(new ConsultaGridExtJS(documentoConsultaDTO, documentoConsultaDTO.getRemitente(),
						documentoConsultaDTO.getDestinatario()));
			}

			return lista_final;

		} else {
			return new ArrayList<ConsultaGridExtJS>();
		}

	}

	private List<ConsultaGridExtJS> configuraConsultaUnigis(HttpServletRequest request, UsuarioDTO usuario)
			throws Exception {

		DocumentoDTO datos = configuraDatosConsulta(request, usuario);

		int tipobusqueda = (request.getParameter("tipobusqueda") == null ? -1
				: Integer.parseInt(request.getParameter("tipobusqueda")));

		String fechaini = (request.getParameter("fechaini") == null ? "" : request.getParameter("fechaini"));
		String fechafin = (request.getParameter("fechafin") == null ? "" : request.getParameter("fechafin"));

		if (fechaini.trim().length() > 0) {
			fechaini = UtilsStringFechas.formatoStrFecha(fechaini, "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
		}
		if (fechafin.trim().length() > 0) {
			fechafin = UtilsStringFechas.formatoStrFecha(fechafin, "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
		}

		if (tipobusqueda >= 0) {
			
			List<DocumentoConsultaDTO> lista_docs = iDocumentoServicioBO.consultaEtiquetasUnigis(datos, tipobusqueda,
					fechaini, fechafin, usuario);

			List<ConsultaGridExtJS> lista_final = new ArrayList<ConsultaGridExtJS>();

			for (DocumentoConsultaDTO documentoConsultaDTO : lista_docs) {
				lista_final.add(new ConsultaGridExtJS(documentoConsultaDTO, documentoConsultaDTO.getRemitente(),
						documentoConsultaDTO.getDestinatario()));
			}

			return lista_final;

		} else {
			return new ArrayList<ConsultaGridExtJS>();
		}

	}

	@RequestMapping(value = "/getHistoria", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, ? extends Object> getHistoria(HttpServletRequest request) throws Exception {

		String mensaje = null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		displayParametros(request);
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			String mensajeria = request.getParameter("mensajeria") == null
					|| request.getParameter("mensajeria").trim().isEmpty() ? "AUTODOC"
							: request.getParameter("mensajeria");

			String iddocumento = (request.getParameter("iddocumento") == null ? ""
					: request.getParameter("iddocumento"));

			String idguiainternacional = (request.getParameter("idguiainternacional") == null ? ""
					: request.getParameter("idguiainternacional"));

			String buscarHistoriaUps = (request.getParameter("buscarHistoriaUps") == null ? "false"
					: request.getParameter("buscarHistoriaUps"));

			if (!"AUTODOC".equals(mensajeria)) {
				buscarHistoriaUps = "true";
			}
			EtiquetaRotulacionDTO etiqueta = new EtiquetaRotulacionDTO();
			etiqueta.setIddocumento(iddocumento);
			etiqueta.setIdguiainternacional(idguiainternacional);
			List<LogHistoriaDTO> lista = null;
			if ("true".equals(buscarHistoriaUps)) {
				// Busca historia de mensajeria
				return getHistoriaUPS(request);
			} else {
				// busca la historia normal
				lista = iDocumentoServicioBO.getHistoriaDocumento(iddocumento, usuario);
			}

			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);

		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("message", e.getMessage());
		}

		return modelMap;
	}

	@RequestMapping(value = "/getHistoriaUPS", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, ? extends Object> getHistoriaUPS(HttpServletRequest request) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		displayParametros(request);
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			String iddocumento = (request.getParameter("iddocumento") == null ? ""
					: request.getParameter("iddocumento"));

			String idguiainternacional = (request.getParameter("idguiainternacional") == null ? ""
					: request.getParameter("idguiainternacional"));

			String mensajeria = (request.getParameter("mensajeria") == null ? "" : request.getParameter("mensajeria"));

			EtiquetaRotulacionDTO etiqueta = new EtiquetaRotulacionDTO();

			etiqueta.setIddocumento(iddocumento);
			etiqueta.setIdguiainternacional(idguiainternacional);

			// List<LogHistoriaDTO>lista =
			// iEnlaceMensajeriaBO.consultaEnlaceMensajeria(mensajeria,
			// etiqueta, usuario);

			List<LogHistoriaDTO> lista = iTrackingBO.tracking(etiqueta, 0);
			/*
			 * Entrega entrega = null; for (LogHistoriaDTO logHistoriaDTO : lista) {
			 * 
			 * logHistoriaDTO.setFecha(UtilsStringFechas.formatoStrFecha(
			 * logHistoriaDTO.getFecha(), "yyyyMMddhhmmss", "yyyy-MM-dd hh:mm:ss"));
			 * 
			 * // Confirma la guia if ("D".equals(logHistoriaDTO.getTipomovimiento()) &&
			 * (logHistoriaDTO.getEntregadoA() != null)) { // Agrega la confirmacion de
			 * entrega entrega = new Entrega();
			 * entrega.setRecibe(logHistoriaDTO.getEntregadoA());
			 * entrega.setGuia(iddocumento); entrega.setFecha(logHistoriaDTO.getFecha());
			 * iDocumentoServicioBO.insertConfirmaEntregaEnvio(entrega); break; } }
			 */

			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);

		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("message", e.getMessage());
		}

		return modelMap;
	}

	@RequestMapping(value = "/cancelarguia", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, ? extends Object> cancelarguia(HttpServletRequest request) throws Exception {

		String mensaje = null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		displayParametros(request);
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		PEstadoOrdenPedido estadoOrdenPedido;

		Calendar today = Calendar.getInstance();

		Boolean success = true;
		String message = "Correcto";

		try {
			String documentos = (request.getParameter("documentos") == null ? "" : request.getParameter("documentos"));

			String[] envios = documentos.split(",");

			for (String iddocumento : envios) {

				estadoOrdenPedido = new PEstadoOrdenPedido();
				estadoOrdenPedido.setRefDocumento(iddocumento);
				estadoOrdenPedido.setEstadoFecha(today);
				estadoOrdenPedido.setValidarTransicion(true);
				estadoOrdenPedido.setEstado("ANULADO");

				if (iGuiaBO.cambiarEstadoGuia(estadoOrdenPedido) > 0) {

					iDocumentoServicioBO.cancelaDocumento(iddocumento, usuario);

				} else {

					success = false;
					message = "Algunas guias no pudieron se canceladas[UNIGUIS]";

				}

			}
			modelMap.put("success", success);
			modelMap.put("message", message);
		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("message", e.getMessage());
		}

		return modelMap;
	}

	@RequestMapping(value = "/viewPDFEnvio", method = { RequestMethod.GET, RequestMethod.POST })
	public void viewPDFEnvio(HttpServletRequest request, HttpServletResponse response) {

		displayParametros(request);
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		byte[] bytes = null;
		String archivo = "";
		try {
			String error = "<p>No se pudo crear archivo PDF del documento.<p>";

			String iddocumento = (request.getParameter("iddocumento") == null ? ""
					: request.getParameter("iddocumento"));
			DocumentoDTO datos = null;
			try {
				datos = iDocumentoServicioBO.getInfoDocumentoJson(iddocumento);
			} catch (Exception e) {
				logger.debug("Error al crear la PDF etiqueta:" + e.getMessage());
			}

			if (usuario == null) {
				error = "SESION DE USUARIO ES INVALIDA, VUELVA FIRMARSE.";
			} else {

				if ((datos == null) || (datos.datosCarta == null)) {
					error = "NO EXISTE INFORMACION DISPONIBLE PARA IMPRESION(JSON), VERIFIQUE.";
				} else {

					List<Envio> arr_envios = new ArrayList<Envio>();
					datos.datosCarta.setReimpresion("REIMPRESION DE ETIQUETA");
					arr_envios.add(datos.datosCarta);

					// Genera y obtiene el nombre del archivo
					archivo = iMuestraEtiquetasBO.generaPDFGuia(arr_envios, usuario, ConstantesGenerales._TIPOIMPRESION,
							ConstantesGenerales.ID_SKY4SOL, usuario.getFormatoetiperso());

					// archivo =iMuestraEtiquetasBO.muestrarPDFGuia(arr_envios,
					// usuario,
					// ConstantesGenerales._TIPOIMPRESION,
					// ConstantesGenerales.ID_SKY4SOL);

					try {
						File f = new File(archivo);
						bytes = Files.getBytesFromFile(f);
					} catch (Exception e) {
						logger.debug("Error al crear el PDF de las etiquetas:" + e.getMessage());
						error = "<p>No se pudo crear archivo PDF del documento.<p>";
					}

				}

			}

			// Arroja los datos al stream
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ServletOutputStream out = response.getOutputStream();

			// Verifica el tipo de documento a desplegar
			if (bytes != null) {
				response.setContentType(MimeTypes.getMimeType("*.pdf"));
			} else {
				response.setContentType(MimeTypes.getMimeType("*.html"));
				bytes = error.getBytes();
			}

			bos.write(bytes);

			response.setContentLength(bos.size());
			out.write(bos.toByteArray());
			out.flush();
			bos.close();
			out.close();
			response.flushBuffer();

		} catch (Exception e) {
			logger.error("Error:", e);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/viewPDFEnvioMadre", method = { RequestMethod.GET, RequestMethod.POST })
	public void viewPDFEnvioMadre(HttpServletRequest request, HttpServletResponse response) {

		displayParametros(request);

		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		byte[] bytes = null;

		String archivo = "";

		try {

			String error = "<p>No se pudo crear archivo PDF del documento.<p>";

			String iddocumentomadre = (request.getParameter("iddocumentomadre") == null ? ""
					: request.getParameter("iddocumentomadre"));

			// String iddocumentomadre = "0000000000000647";
			DocumentoDTO datos = null;

			List<DocumentoDTO> etiquetas = new ArrayList<DocumentoDTO>();

			List<DocumentoDTO> lstdatos = null;

			try {

				lstdatos = iDocumentoServicioBO.getInfoDocumentoMadre(iddocumentomadre);

				for (int i = 0; i < lstdatos.size(); i++) {

					datos = iDocumentoServicioBO.getInfoDocumentoJson(lstdatos.get(i).getIdDocumento());

					etiquetas.add(datos);

				}

			} catch (Exception e) {

				logger.debug("Error al crear la PDF etiqueta:" + e.getMessage());

			}

			if (usuario == null) {

				error = "SESION DE USUARIO ES INVALIDA, VUELVA FIRMARSE.";

			} else {

				// if ((lstdatos == null) || (datos.datosCarta == null)) {
				if ((lstdatos == null) || (lstdatos.size() <= 0)) {

					error = "NO EXISTE INFORMACION DISPONIBLE PARA IMPRESION(JSON), VERIFIQUE.";

				} else {

					List<Envio> arr_envios = new ArrayList<Envio>();

					Envio[] myTypes = new Envio[etiquetas.size()];

					// CREAMOS UNA OBJETO ENVIO DEAPOYO
					Envio envioMadre = new Envio();

					// Obtiene todos los registro de Json para el UUID
					for (int i = 0; i < etiquetas.size(); i++) {

						// etiquetas.get(i).datosCarta.setReimpresion("REIMPRESION DE ETIQUETA");

						myTypes[i] = etiquetas.get(i).datosCarta;

					}

					for (Envio envio : myTypes) {

						arr_envios.add(envio);

						/*
						 * AGREGAMOS EL ULTIMO DATO DEL JSON A NUESTRO OBJETO ESTOCON EL FIN DEOBTENER
						 * CUALQUIER DATO Y CON ESTE VERIFICAREL APARTADO "ESMADRE" YA QUE CONESTE
						 * SABREMOS SI FUE UN ENVIO CON GUIA MADRE O NO
						 */
						envioMadre = envio;

					}

					// OBTENEMOS EL DATO PARA SABER SI ES GUIA MADRE
					// String verificaMadre = arr_envios.get(0).getesMadre();

					// ESTE DATO NOS AYUDARA A JUNTAR TODOS LOS DATOS
					String datosTabla = "";

					int cant = 0;

					int peso = 0;

					String cantidadS = "";
					String referenciaS = "";
					String contenidoS = "";
					String pesoS = "";

					/*
					 * IGUALAMOS EL ARREGLO ALARREGLO FINAL YA CON TODOS LOS DATOS AGRUPADOS
					 */
					arr_envios = crearListaFinal(arr_envios);

					/*
					 * EN CASO DE QUE LA LISTA FINAL TENGA M¿MENOS DE 5 DATOS
					 */
					if (arr_envios.size() <= 5) {

						/*
						 * RECORREMOS LA LISTA Y VAMOS OBTENIENDO LOS DATOS PARA FORMATEARLOS Y METERLOS
						 * EN LA VARIABLE
						 */
						for (int i = 0; i < arr_envios.size(); i++) {

							/*
							 * EN CASO DE QUE SEA EL PRIMERO DATO QUE SE AGREGA "datosTabla"
							 */
							if (i == 0) {

								/*
								 * CADA DATO LO OBTENEMOS Y VAMOS DANDO FORMATO
								 */
								cantidadS = formatearDato(String.valueOf(arr_envios.get(i).getCantidad()), 10, 1);

								if (arr_envios.get(i).getReferencia().isEmpty()) {

									referenciaS = formatearDato("SINDESCRIP", 4, 2);

								} else {

									referenciaS = formatearDato(String.valueOf(arr_envios.get(i).getReferencia()), 4,
											2);

								}

								contenidoS = formatearDato(String.valueOf(arr_envios.get(i).getContenido()), 7, 2);
								pesoS = formatearDato(String.valueOf(arr_envios.get(i).getPeso()), 5, 0);

								/*
								 * TERMINANDO DE FORMATEAR LOS DATOS AGREGAMOS A NUETRA VARIABLE TODOS LOS DATOS
								 * YA FORMATEADOS, SE HIZO LA VADILACION DE i=0 PARA SABER QUE ES EL PRIMER DATO
								 * Y NOAGREGAR UN ~ CON EL FIN DE NO ROMPER EL FORMATO YA QUE MAS ADELANTE
								 * SPLITEAMOS CON ~
								 */
								datosTabla = datosTabla + cantidadS + referenciaS + contenidoS + pesoS;

								/*
								 * EN CASO DE NO SE REL PRIMER DATO, YA PODEMOS USAR ~
								 */
							} else {

								/*
								 * CADA DATO LO OBTENEMOS Y VAMOS DANDO FORMATO
								 */
								cantidadS = formatearDato(String.valueOf(arr_envios.get(i).getCantidad()), 10, 1);

								if (arr_envios.get(i).getReferencia().isEmpty()) {

									referenciaS = formatearDato("SINDESCRIP", 4, 2);

								} else {

									referenciaS = formatearDato(String.valueOf(arr_envios.get(i).getReferencia()), 4,
											2);

								}

								contenidoS = formatearDato(String.valueOf(arr_envios.get(i).getContenido()), 7, 2);
								pesoS = formatearDato(String.valueOf(arr_envios.get(i).getPeso()), 5, 0);

								/*
								 * TERMINANDO DE FORMATEAR LOS DATOS AGREGAMOS A NUETRA VARIABLE TODOS LOS DATOS
								 * YA FORMATEADOS, DEBIDO A QUE YANO ES EL PRIMER DATO SABEMOS QUE LA VARIABLE
								 * YA TIENE UNREGISTRO POR LO CUAL YA PODEMOS USAR ~ PARA SEPARARLOS REGISTROS
								 */
								datosTabla = datosTabla + "~" + cantidadS + referenciaS + contenidoS + pesoS;
							}

						}
						/*
						 * SE LIMPIA LA LISTA DE ENVIOS CON EL FIN DESOLO AGREGAR UN DATO
						 */
						arr_envios.clear();

						/*
						 * A NUESTRO OBJETO DE AYUDA AGREGAMOS EL DATO MADRE
						 */
						envioMadre.setIdEnvio(envioMadre.getesMadre());

						/* EN REFERENCIA AGREGAMOS TODOS LOS DATOS */
						envioMadre.setReferencia(datosTabla);

						/*
						 * AL ARRELGO YA LIMPIO LE AGREGAMOS UN DATO YA CON TODO LISTO
						 */
						arr_envios.add(envioMadre);

						/*
						 * EN CASO DEQUE LA LISTA FINAL TENGA MAS DE 5 DATOS, REALIZAMOS OTROPROCESO
						 */
					} else {

						/*
						 * SE VALIDA ESTODEBIDO AQUE EL TAMAÑO EN LA ETIQUETA Y PONES M,AS DE 5 DATOS
						 * HARIA QUE SE SALGA DEL FORMATO
						 */

						/*
						 * HACEMOS UN RECORRIDO LIMITADO A 5 DEBIDO AQUE ES EL MAXIMO DE DATOS QUE
						 * PODEMOSPONER EN LA ETIQUETA
						 */
						for (int i = 0; i < 5; i++) {

							/*
							 * EN CASO DE QUE SEA EL PRIMERO DATO QUE SE AGREGA "datosTabla"
							 */
							if (i == 0) {

								/*
								 * CADA DATO LO OBTENEMOS Y VAMOS DANDO FORMATO
								 */
								cantidadS = formatearDato(String.valueOf(arr_envios.get(i).getCantidad()), 10, 1);

								if (arr_envios.get(i).getReferencia().isEmpty()) {

									referenciaS = formatearDato("SINDESCRIP", 4, 2);

								} else {

									referenciaS = formatearDato(String.valueOf(arr_envios.get(i).getReferencia()), 4,
											2);

								}

								contenidoS = formatearDato(String.valueOf(arr_envios.get(i).getContenido()), 7, 2);
								pesoS = formatearDato(String.valueOf(arr_envios.get(i).getPeso()), 5, 0);

								/*
								 * TERMINANDO DE FORMATEAR LOS DATOS AGREGAMOS A NUETRA VARIABLE TODOS LOS DATOS
								 * YA FORMATEADOS, SE HIZO LA VADILACION DE i=0 PARA SABER QUE ES EL PRIMER DATO
								 * Y NOAGREGAR UN ~ CON EL FIN DE NO ROMPER EL FORMATO YA QUE MAS ADELANTE
								 * SPLITEAMOS CON ~
								 */
								datosTabla = datosTabla + cantidadS + referenciaS + contenidoS + pesoS;

								/*
								 * VALIDAMOS QUE NOS ENCONTREMOS EN LA TERCERA POSICION ESTO NOS INDICA QUE ES
								 * EL PENULTIMO DATO Y CON ESTO EN MENTE AGREGAMOS EN ÑA PENULTIMA LINEA DATOS
								 * CON SOLO GUIONES PARA DAR UN ESTILO DIFERENTE A LA ETIQUETA
								 */
							} else if (i == 3) {

								/*
								 * CADA DATO LO IGUALAMOS A GUINES Y VAMOS DANDO FORMATO
								 */
								cantidadS = formatearDato("----", 10, 1);
								referenciaS = formatearDato("----------", 4, 2);
								contenidoS = formatearDato("----------", 7, 2);
								pesoS = formatearDato("----", 5, 0);

								/*
								 * TERMINANDO DE FORMATEAR LOS DATOS AGREGAMOS A NUETRA VARIABLE TODOS LOS DATOS
								 * YA FORMATEADOS, DEBIDO A QUE YANO ES EL PRIMER DATO SABEMOS QUE LA VARIABLE
								 * YA TIENE UNREGISTRO POR LO CUAL YA PODEMOS USAR ~ PARA SEPARARLOS REGISTROS
								 */
								datosTabla = datosTabla + "~" + cantidadS + referenciaS + contenidoS + pesoS;

								/*
								 * VALIDAMOS QUE NOS ENCONTREMOS EN LA CUARTA Y ULTIMA POSICION ESTO NOS INDICA
								 * QUE ES EL ULTIMO DATO Y CON ESTO EN MENTE AGREGAMOS LA LINEA FINAL CON LA
								 * SUMATORIA DE CANTIDAD Y PESO DE TODOS LOS DATOS QUE SE MUESTRAN Y NOSE
								 * MUESTRAN EN LA ETIQUETA PARA QUE LAS PEROSNAS TENGAN UNA REFERENCIA
								 */
							} else if (i == 4) {

								/*
								 * ESTE FOR ES PARA SUMAR TODAS LAS CANTIDADES Y PESOS PARA MOSTRARLOS EN LA
								 * ULTIMA LINEA COMO SUMATORIA TOTAL
								 */
								for (int o = 0; o < arr_envios.size(); o++) {

									cant = cant + arr_envios.get(o).getCantidad();

									peso = peso + arr_envios.get(o).getPeso();

								}

								/*
								 * CADA DATO LO IGUALAMOS Y VAMOS DANDO FORMATO
								 */
								cantidadS = formatearDato(String.valueOf(cant), 10, 1);
								referenciaS = formatearDato("Varios", 4, 2);
								contenidoS = formatearDato("Varios", 7, 2);
								pesoS = formatearDato(String.valueOf(peso), 5, 0);

								/*
								 * TERMINANDO DE FORMATEAR LOS DATOS AGREGAMOS A NUETRA VARIABLE TODOS LOS DATOS
								 * YA FORMATEADOS, DEBIDO A QUE YA NO ES EL PRIMER DATO SABEMOS QUE LA VARIABLE
								 * YA TIENE UNREGISTRO POR LO CUAL YA PODEMOS USAR ~ PARA SEPARARLOS REGISTROS
								 */
								datosTabla = datosTabla + "~" + cantidadS + referenciaS + contenidoS + pesoS;

								/* EN CASO DE SER i = 1 O 2 */
							} else {

								/*
								 * CADA DATO LO OBTENEMOS Y VAMOS DANDO FORMATO
								 */
								cantidadS = formatearDato(String.valueOf(arr_envios.get(i).getCantidad()), 10, 1);

								if (arr_envios.get(i).getReferencia().isEmpty()) {

									referenciaS = formatearDato("SINDESCRIP", 4, 2);

								} else {

									referenciaS = formatearDato(String.valueOf(arr_envios.get(i).getReferencia()), 4,
											2);

								}

								contenidoS = formatearDato(String.valueOf(arr_envios.get(i).getContenido()), 7, 2);
								pesoS = formatearDato(String.valueOf(arr_envios.get(i).getPeso()), 5, 0);

								/*
								 * TERMINANDO DE FORMATEAR LOS DATOS AGREGAMOS A NUETRA VARIABLE TODOS LOS DATOS
								 * YA FORMATEADOS, DEBIDO A QUE YA NO ES EL PRIMER DATO SABEMOS QUE LA VARIABLE
								 * YA TIENE UNREGISTRO POR LO CUAL YA PODEMOS USAR ~ PARA SEPARARLOS REGISTROS
								 */
								datosTabla = datosTabla + "~" + cantidadS + referenciaS + contenidoS + pesoS;
							}

						}

						/*
						 * SE LIMPIA LA LISTA DE ENVIOS CON EL FIN DESOLO AGREGAR UN DATO
						 */
						arr_envios.clear();

						/*
						 * A NUESTRO OBJETO DE AYUDA AGREGAMOS EL DATO MADRE
						 */
						envioMadre.setIdEnvio(envioMadre.getesMadre());

						/* EN REFERENCIA AGREGAMOS TODOS LOS DATOS */
						envioMadre.setReferencia(datosTabla);

						/*
						 * AL ARRELGO YA LIMPIO LE AGREGAMOS UN DATO YA CON TODO LISTO
						 */
						arr_envios.add(envioMadre);

					}

					// Genera y obtiene el nombre del archivo
					archivo = iMuestraEtiquetasBO.generaPDFGuia(arr_envios, usuario, ConstantesGenerales._TIPOIMPRESION,
							ConstantesGenerales.ID_SKY4SOL, usuario.getFormatoetiperso());

					// archivo =iMuestraEtiquetasBO.muestrarPDFGuia(arr_envios,
					// usuario,
					// ConstantesGenerales._TIPOIMPRESION,
					// ConstantesGenerales.ID_SKY4SOL);

					try {
						File f = new File(archivo);
						bytes = Files.getBytesFromFile(f);
					} catch (Exception e) {
						logger.debug("Error al crear el PDF de las etiquetas:" + e.getMessage());
						error = "<p>No se pudo crear archivo PDF del documento.<p>";
					}

				}

			}

			// Arroja los datos al stream
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ServletOutputStream out = response.getOutputStream();

			// Verifica el tipo de documento a desplegar
			if (bytes != null) {
				response.setContentType(MimeTypes.getMimeType("*.pdf"));
			} else {
				response.setContentType(MimeTypes.getMimeType("*.html"));
				bytes = error.getBytes();
			}

			bos.write(bytes);

			response.setContentLength(bos.size());
			out.write(bos.toByteArray());
			out.flush();
			bos.close();
			out.close();
			response.flushBuffer();

		} catch (Exception e) {
			logger.error("Error:", e);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/exportaConsultaEtiquetasExcel", method = { RequestMethod.GET, RequestMethod.POST })
	// public ModelAndView exportaConsultaEtiquetasExcel(HttpServletRequest
	// request)
	public ModelAndView exportaConsultaEtiquetasExcel(ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<DocumentoConsultaDTO> lista = null;
		displayParametros(request);
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {

			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			int tipobusqueda = (request.getParameter("tipobusqueda") == null ? -1
					: Integer.parseInt(request.getParameter("tipobusqueda")));

			String fechaini = (request.getParameter("fechaini") == null ? "" : request.getParameter("fechaini"));
			String fechafin = (request.getParameter("fechafin") == null ? "" : request.getParameter("fechafin"));

			if (fechaini.trim().length() > 0) {
				fechaini = UtilsStringFechas.formatoStrFecha(fechaini, "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
			}
			if (fechafin.trim().length() > 0) {
				fechafin = UtilsStringFechas.formatoStrFecha(fechafin, "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
			}

			DocumentoDTO datos = configuraDatosConsulta(request, usuario);
			if (tipobusqueda >= 0) {
				lista = iDocumentoServicioBO.consulta(datos, tipobusqueda, fechaini, fechafin, usuario);

			}

			modelAndView = new ModelAndView("ExcelReportCPsNuevosView", "lista", lista);
			String nombrearchivo = UtilsStringFechas.getNombreArchivo(usuario.getLogin(), "consulta_etiquetas", "xls");
			response.setHeader("Content-type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + nombrearchivo + "\"");
		} catch (Exception dae) {
			logger.debug("Error en reportes:" + dae.getMessage());
		}

		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("ExportExcelConsultaEtiquetasView", "lista", lista);

	}

	@RequestMapping(value = "/exportaConsultaEtiquetasExcelFueraDeSitio", method = { RequestMethod.GET,
			RequestMethod.POST })
	// public ModelAndView exportaConsultaEtiquetasExcel(HttpServletRequest
	// request)
	public ModelAndView exportaConsultaEtiquetasExcelFueraDeSitio(ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<DocumentoConsultaDTO> lista = null;
		displayParametros(request);

		// Indica que es internet la busqueda
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.entidad.setIdentidad(ConstantesAdminSale.CONSULTA_INTERNET);

		try {

			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			int tipobusqueda = (request.getParameter("tipobusqueda") == null ? -1
					: Integer.parseInt(request.getParameter("tipobusqueda")));

			String fechaini = (request.getParameter("fechaini") == null ? "" : request.getParameter("fechaini"));
			String fechafin = (request.getParameter("fechafin") == null ? "" : request.getParameter("fechafin"));

			if (fechaini.trim().length() > 0) {
				fechaini = UtilsStringFechas.formatoStrFecha(fechaini, "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
			}
			if (fechafin.trim().length() > 0) {
				fechafin = UtilsStringFechas.formatoStrFecha(fechafin, "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
			}

			DocumentoDTO datos = configuraDatosConsulta(request, usuario);
			if (tipobusqueda >= 0) {
				lista = iDocumentoServicioBO.consulta(datos, tipobusqueda, fechaini, fechafin, usuario);

			}

			modelAndView = new ModelAndView("ExcelReportCPsNuevosView", "lista", lista);
			String nombrearchivo = UtilsStringFechas.getNombreArchivo(usuario.getLogin(), "consulta_etiquetas", "xls");
			response.setHeader("Content-type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + nombrearchivo + "\"");
		} catch (Exception dae) {
			logger.debug("Error en reportes:" + dae.getMessage());
		}

		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("ExportExcelConsultaEtiquetasView", "lista", lista);

	}

	@RequestMapping(value = "/exportaConsultaEtiquetasExcelUnigis", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView exportaConsultaEtiquetasExcelUnigis(ModelAndView modelAndView, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<DocumentoConsultaDTO> lista = null;
		displayParametros(request);

		// Indica que es internet la busqueda
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.entidad.setIdentidad(ConstantesAdminSale.CONSULTA_INTERNET);

		try {

			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			int tipobusqueda = (request.getParameter("tipobusqueda") == null ? -1
					: Integer.parseInt(request.getParameter("tipobusqueda")));

			String fechaini = (request.getParameter("fechaini") == null ? "" : request.getParameter("fechaini"));
			String fechafin = (request.getParameter("fechafin") == null ? "" : request.getParameter("fechafin"));

			if (fechaini.trim().length() > 0) {
				fechaini = UtilsStringFechas.formatoStrFecha(fechaini, "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
			}
			if (fechafin.trim().length() > 0) {
				fechafin = UtilsStringFechas.formatoStrFecha(fechafin, "dd/MM/yyyy HH:mm:ss", "yyyy-MM-dd HH:mm:ss");
			}

			DocumentoDTO datos = configuraDatosConsulta(request, usuario);
			if (tipobusqueda >= 0) {
				lista = iDocumentoServicioBO.consultaEtiquetasUnigis(datos, tipobusqueda, fechaini, fechafin, usuario);

			}

			modelAndView = new ModelAndView("ExcelReportCPsNuevosView", "lista", lista);
			String nombrearchivo = UtilsStringFechas.getNombreArchivo(usuario.getLogin(), "consulta_etiquetas", "xls");
			response.setHeader("Content-type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + nombrearchivo + "\"");
		} catch (Exception dae) {
			logger.debug("Error en reportes:" + dae.getMessage());
		}

		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("ExportExcelConsultaEtiquetasView", "lista", lista);

	}

	private void displayParametros(HttpServletRequest request) {

		Enumeration enumera = request.getParameterNames();

		while (enumera.hasMoreElements()) {
			String attribute = (String) enumera.nextElement();
			logger.info("" + attribute + "=" + request.getParameter(attribute));
		}

	}

	public String formatearDato(String dato, int numFormato, int aux) {

		// VARIABLE DONDE SE ALMACENA EL DATO YA CONFIGURADO
		String textoFormateado = "";

		/* 1 EN CASO DE SER EL PRIMER DATO OSEA LA CANTIDAD */
		if (aux == 1) {

			// AGREGAMOS CEROSA LA IZQUIERDA
			dato = String.format("%4s", dato).replace(" ", "0");

			// AGREGAMOSLOS ESPACIOS
			textoFormateado = String.format("%-" + numFormato + "s", dato);

			/*
			 * EN CASO DE SER 0 ES EL ULTIMODATOOSEA EL PESO A ESTE DATO NO SE LE AGREGAN
			 * ESPACIOS A LA DERECHA SOLO CEROS A LA IZQUIERDA
			 */
		} else if (aux == 0) {

			// AGREGAMOS CEROSA LA IZQUIERDA
			textoFormateado = String.format("%4s", dato).replace(" ", "0");

			/* EN CASO DE SER CANTIDAD Y DESCRIPCION */
		} else {

			// SE QUITAN LOS ESPACIOS PARATENER MAS TEXTO
			dato = dato.replaceAll("\\s", "");

			// SE SACAEL TAMAÑO DE EL TEXTO
			int tamanoDato = dato.length();

			/*
			 * A QUI SE SUMA EL NUMERO DE FORMATO CON LA LONGITUD DEL TEXTO DADO A QUE SI EL
			 * FORMATO ES 10 DEBEN PONERSE 10 ESPACIOS A LA DERECHA PERO SI EL TEXTO YA TRAE
			 * 10 DE LONGITUD O MENOS LO COMPENSARA EJEMPLO ABC******* AQUI SERIAN LOS 10
			 * PERO LO QUE BUSCAMOS ES QUE APARTE DE EL TEXTO SE SUMEN 10 ESPACIO A LA
			 * DERECHA
			 */
			numFormato = (numFormato + 10);

			// SI NUESTRO DATO TIENE MENOS DE 10 CARACTERES
			if (tamanoDato < 10) {

				/*
				 * CON ESTO SABREMOS CUANTOS CARACTERES LE FALTAN PARA SER 10 SEHACE CON EL FIN
				 * DE SIEMPRE TENER DATOS DE 10 CARACTERES Y MANTENER EL FORMATO ALINEADO EN LA
				 * ETIQUETA
				 */
				int paraDiez = (10 - tamanoDato);

				// SE AGREGAN ESPACIO EN BLANCO A LA IZQUIERA PARA QUE CUMPLA
				// CON 10
				textoFormateado = String.format("%-" + paraDiez + "s", dato);

				// SEAGREGAN LOS ESPACIOS EN BLANCO DEPENDIENDO DEL NUMERO
				// DEFORMATO
				// EN ESTE PUNTO EL DATO YA ES DE 10 CARACTERES Y APARTE SE
				// AGREGANM LOS
				// ESPACIO PARA QUE CUMPLA CON EL FORMATO
				textoFormateado = String.format("%-" + numFormato + "s", textoFormateado);

				/* SI EL DATOES TIENE 10 CARACTERES */
			} else if (tamanoDato == 10) {

				/*
				 * SE AGREGAN SOLO LOS ESPACIOS A LA DERECHA PARA QUE CUMPLA CON EL FORMATO
				 */
				textoFormateado = dato;
				textoFormateado = String.format("%-" + numFormato + "s", textoFormateado);

				/* SI DATO TIENE MAS DE 10 CARACTERES */
			} else {

				/*
				 * SE CORTA EN 10 CARACTERESY DEPSUES SE LE AGREGAN LOS ESPACIOS A LA DERECHA
				 * SEGUN EL FORMATO
				 */
				textoFormateado = dato.substring(0, 10);
				textoFormateado = String.format("%-" + numFormato + "s", textoFormateado);

			}

		}

		/* REGRESA EL DATO YA FORMATEADO */
		return textoFormateado;
	}

	public List<Envio> crearListaFinal(List<Envio> arr_envios) {

		int cantidadI = 0;
		String referenciaS = "";
		String contenidoS = "";
		int pesoI = 0;

		/* SE CREA LA LISTA QUE IRA DE REGRESO */
		List<Envio> arr_enviosFinales = new ArrayList<Envio>();

		/* RECORREMOS LA LISTA DE ENVIOS DONDE ESTAN TODOS LOS DATOS */
		for (int i = 0; i < arr_envios.size(); i++) {

			/*
			 * TOMAMOS LA CANTIDAD DE ETIQUETAS Y EL PESO PARA SUMAR LOS DATOS Y AGRUPARLOS
			 */
			cantidadI = arr_envios.get(i).getCantidad();
			pesoI = arr_envios.get(i).getPeso();

			/*
			 * SI ELCONTENIDO Y LA REFERENCIA ESTAN SOLOS INDICA QUE ES LA PRIMERA VEZ DEL
			 * RECORRIDO
			 */
			if (contenidoS.equals("") && referenciaS.equals("")) {

				/*
				 * TOMA CONTENIDO YT REFERENCIA Y LOS ALMACENA EN LAS VARIABLES trim
				 */
				contenidoS = arr_envios.get(i).getContenido();
				referenciaS = arr_envios.get(i).getReferencia();

				/*
				 * CREAMOS OTRO RECORRIDO PARA IR BUSCANDO EN LA MISMA LISTA DATOS IGUALES
				 * CONFORME AL CONTENIDO Y REFERENCIA Y ASI PODERLOS AGRUPAR EN UN SOLO DATO
				 */
				for (int j = 0; j < arr_envios.size(); j++) {

					/*
					 * PARA EVITAR TOMAR EN CUENTA NUSTRO DATO DEL PRIMER RECORIDDO USAMOS EL ID DEL
					 * ENVIO ESTO QUIERE DECIR QUE SI NUESTROS ID DE ENVIO SON IGUALES, ESTAMOS
					 * TOMANDO EL MISMO REGISTRO POR LO CUAL DEBEMOS IGNORARLO Y SOLO BUSCAR OTROS
					 * IGUALES PARA ESTO DECIMOS QUE SI NO SON IGUALES CONTINUE CON EL PROCESO
					 */
					if (arr_envios.get(i).getIdEnvio() != arr_envios.get(j).getIdEnvio()) {

						/*
						 * UNA VEZ QUE NOS SERCIORAMOS QUE NO SON EL MISMO DATO, DEBEMOS VALIDAR QUE EL
						 * CONTENIDO Y REFERENCIA SEAN IGUALES ENTRE SI ESTO NOS INDICA QUE HAY MAS
						 * DATOS IGUALES Y SON LOS QUE DEBEMOS TOMAR EN CUENTA PARA HACER LA SUMATORIA
						 * DE LA CANTIDAD DE ETIQUETAS Y PESO POR REGISTRO trim
						 */
						if (referenciaS.equals(arr_envios.get(j).getReferencia())
								&& contenidoS.equals(arr_envios.get(j).getContenido())) {

							/*
							 * UNA VEZ CUMPLIDAS LAS CONDICIONES SABEMOS QUE ESTE DATO TIENE LA MISMA
							 * REFERENCIA Y CONTENIDO Y QUE NO ES EL MISMO DATO CON EL QUE LO ESTAMOS
							 * COMPARANDO ENTONCES SABEMOS QUE DEBEMOS AGRUPARLOS ASI QUE TOMAMOS LA
							 * CANTIDAD Y EL PESO Y LO VAMOS SUMANDE DEPENDIENDO DE LAS VECES QUE ENCUENTRE
							 * DATOS SIMILARES CON EL FIN DE AGRUPAR TODO EN UN SOLO DATO
							 */
							cantidadI = cantidadI + arr_envios.get(j).getCantidad();

							pesoI = pesoI + arr_envios.get(j).getPeso();

						}

					}

				}

				/*
				 * UNA VEZ TERMINADO EL RECORRIDO EDITAMOS LA CANTIDAD Y PESO DEL PRIMER
				 * RECORRIDO Y PONEMOS LA SUMATORIA DE TODOS LOS QUE ENCONTRO PARA SABER ASI
				 * CUANTOS HAY Y QUE PESO TIENEN TODOS SUMADOS Y AGREGAMOS EL REGISTRO EN
				 * NUESTRA NUEVA LISTA A REGRESAR CON EL OBJETIVO DE SI TENEMOS 8 DATOS
				 * SIMILARES LA NUEVA LISTA TENGA UN SOLO REGISTRO DE ESOS 8 Y NO 8 REGISTROS
				 * SIMILARES
				 */
				arr_envios.get(i).setContenido(contenidoS);
				arr_envios.get(i).setReferencia(referenciaS);
				arr_envios.get(i).setCantidad(cantidadI);
				arr_envios.get(i).setPeso(pesoI);

				arr_enviosFinales.add(arr_envios.get(i));

				/*
				 * EN CASO DE QUE CONTENIDO Y REFERENCIA NO ESTEN VACIOS, NOS INDICA QUE YA
				 * FUERON USADOS POR LO CUAL VALIDAMOS QUE LA LISTA EN LAPOSICION i YA NO SEAN
				 * LOS MISMOS DEBIDO A QUE YA LOS AGRUPAMKOS E INSERTAMOS EN LA LISTA NUEVA trim
				 */
			} else if ((!contenidoS.equals(arr_envios.get(i).getContenido())
					&& !referenciaS.equals(arr_envios.get(i).getReferencia()))
					|| (!contenidoS.equals(arr_envios.get(i).getContenido())
							&& referenciaS.equals(arr_envios.get(i).getReferencia()))
					|| (contenidoS.equals(arr_envios.get(i).getContenido())
							&& !referenciaS.equals(arr_envios.get(i).getReferencia()))) {

				/*
				 * TOMAMOS EL NUEVO CONTENIDO Y REFERENCIA PARA AHORA HACER EL MISMO PROCESO
				 * PERO CON OTRO DATOQUE NOSE ENCUENTRE YA INSERTADO trim
				 */
				contenidoS = arr_envios.get(i).getContenido();
				referenciaS = arr_envios.get(i).getReferencia();

				/*
				 * MUCHAS VECES LOS DATOS NO VIENEN ORDENADO POR LO CUAL VALIDAMOS ESTO CON LA
				 * AYUDA DE ESTA VARIABLE
				 */
				String aux = "";

				/*
				 * RECORREMOS LA LISTA QUE VAMOS A REGRESAR PARA VALIDARQUE EN EFECTO EL DATOQUE
				 * TOMAMOS NO SE ENCUENTRE YA REGISTRADO EN LA LISTA FINAL, ESTO OCN EL FIN DE
				 * QUE LOS DATOS NO SE SUMEN MAL
				 */
				for (int k = 0; k < arr_enviosFinales.size(); k++) {

					/*
					 * SI ENCONTRAMOS LOS DATOS EN NUESTRA LISTA FINAL QUIERE DECIR QUE YA LOS
					 * SUMAMOS Y PROCESAMOS ENTONCES LA POSICION EL DATO EN LA POSICION EN LA QUE
					 * ESTAMOS YA NO DEBE SERPROCESADO trim
					 */
					// if(referenciaS ==
					// arr_enviosFinales.get(k).getReferencia() && contenidoS ==
					// arr_enviosFinales.get(k).getContenido()){
					if (referenciaS.equals(arr_enviosFinales.get(k).getReferencia())
							&& contenidoS.equals(arr_enviosFinales.get(k).getContenido())) {

						/*
						 * AGREGAMOS UN n DE "NO" PARA SABER QUE ESTE DATO YA NO DEBE PROCESARCE
						 */
						aux = "n";

					}

				}

				/*
				 * VERIFICAMOS QUE EL AUX NO TENGA n PARA SABER QUE LOS DATOS EN LA POSICION i
				 * QUE ESTAMOS SISE DEBEN PROCESAR
				 */
				if (!aux.equals("n")) {

					/*
					 * CREAMOS OTRO RECORRIDO PARA IR BUSCANDO EN LA MISMA LISTA DATOS IGUALES
					 * CONFORME AL CONTENIDO Y REFERENCIA Y ASI PODERLOS AGRUPAR EN UN SOLO DATO
					 */
					for (int j = 0; j < arr_envios.size(); j++) {

						/*
						 * PARA EVITAR TOMAR EN CUENTA NUSTRO DATO DEL PRIMER RECORIDDO USAMOS EL ID DEL
						 * ENVIO ESTO QUIERE DECIR QUE SI NUESTROS ID DE ENVIO SON IGUALES, ESTAMOS
						 * TOMANDO EL MISMO REGISTRO POR LO CUAL DEBEMOS IGNORARLO Y SOLO BUSCAR OTROS
						 * IGUALES PARA ESTO DECIMOS QUE SI NO SON IGUALES CONTINUE CON EL PROCESO
						 */
						if (arr_envios.get(i).getIdEnvio() != arr_envios.get(j).getIdEnvio()) {

							/*
							 * UNA VEZ QUE NOS SERCIORAMOS QUE NO SON EL MISMO DATO, DEBEMOS VALIDAR QUE EL
							 * CONTENIDO Y REFERENCIA SEAN IGUALES ENTRE SI ESTO NOS INDICA QUE HAY MAS
							 * DATOS IGUALES Y SON LOS QUE DEBEMOS TOMAR EN CUENTA PARA HACER LA SUMATORIA
							 * DE LA CANTIDAD DE ETIQUETAS Y PESO POR REGISTRO trim
							 */
							if (referenciaS.equals(arr_envios.get(j).getReferencia())
									&& contenidoS.equals(arr_envios.get(j).getContenido())) {

								/*
								 * UNA VEZ CUMPLIDAS LAS CONDICIONES SABEMOS QUE ESTE DATO TIENE LA MISMA
								 * REFERENCIA Y CONTENIDO Y QUE NO ES EL MISMO DATO CON EL QUE LO ESTAMOS
								 * COMPARANDO ENTONCES SABEMOS QUE DEBEMOS AGRUPARLOS ASI QUE TOMAMOS LA
								 * CANTIDAD Y EL PESO Y LO VAMOS SUMANDE DEPENDIENDO DE LAS VECES QUE ENCUENTRE
								 * DATOS SIMILARES CON EL FIN DE AGRUPAR TODO EN UN SOLO DATO
								 */
								cantidadI = cantidadI + arr_envios.get(j).getCantidad();

								pesoI = pesoI + arr_envios.get(j).getPeso();

							}

						}

					}

					/*
					 * UNA VEZ TERMINADO EL RECORRIDO EDITAMOS LA CANTIDAD Y PESO DEL PRIMER
					 * RECORRIDO Y PONEMOS LA SUMATORIA DE TODOS LOS QUE ENCONTRO PARA SABER ASI
					 * CUANTOS HAY Y QUE PESO TIENEN TODOS SUMADOS Y AGREGAMOS EL REGISTRO EN
					 * NUESTRA NUEVA LISTA A REGRESAR CON EL OBJETIVO DE SI TENEMOS 8 DATOS
					 * SIMILARES LA NUEVA LISTA TENGA UN SOLO REGISTRO DE ESOS 8 Y NO 8 REGISTROS
					 * SIMILARES
					 */
					arr_envios.get(i).setContenido(contenidoS);
					arr_envios.get(i).setReferencia(referenciaS);
					arr_envios.get(i).setCantidad(cantidadI);
					arr_envios.get(i).setPeso(pesoI);

					arr_enviosFinales.add(arr_envios.get(i));

				}

			}

		}

		/* REGRESAMOS LA LISTA FINAL YA CON LOS DATOS AGRUPADOS */
		return arr_enviosFinales;

	}
}
