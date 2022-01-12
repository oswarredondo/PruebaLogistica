/**
 * 
 */
package com.innovargia.administracion.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.dto.AdicionalDTO;
import com.administracion.dto.DetalleVenta;
import com.administracion.dto.VentaDTO;
import com.administracion.ibo.IAdminConsecutivosBO;
import com.administracion.ibo.IEtiquetasBO;
import com.administracion.ibo.IMuestraEtiquetasBO;
import com.administracion.idao.IParamsSistemaDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IRotulacionEtiquetasDatosBO;
import com.innovargia.utils.ConstantesAutoDoc;
import com.innovargia.utils.Files;
import com.innovargia.utils.MimeTypes;
import com.innovargia.utils.UUIDUniqueCreator;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.UtilsStrings;
import com.servicio.constantes.ConstantesGenerales;

/**
 * @author Adri�n /imprime_etiquetas/viewPDFArchivo
 */
@RequestMapping("/imprime_etiquetas")
@Controller
public class ImprimeEtiquetasController {

	private static final Logger logger = LoggerFactory.getLogger(ImprimeEtiquetasController.class);

	@Autowired
	IRotulacionEtiquetasDatosBO iRotulacionEtiquetasDatosBO;

	@Autowired
	IEtiquetasBO iEtiquetasBO;
	@Autowired
	IMuestraEtiquetasBO iMuestraEtiquetasBO;

	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;

	@Autowired
	IAdminConsecutivosBO iAdminConsecutivosBO;

	/**
	 * Agrega un nuevo registro para Rotular
	 * 
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/creaDocumengtoEtiqueta", method = { RequestMethod.GET,
			RequestMethod.POST }, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody Map<String, ? extends Object> creaRegistro(
			@RequestParam(value = "idregistro", required = true) String idregistro, HttpServletRequest request)
			throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		CuentasDTO cuentasesion = ConstantesAutoDoc.getSessionCte(request.getSession(true));
		try {

			String esmadre = request.getParameter("esmadre").toLowerCase(); // S si tiene guia madre N si no tiene

			if (usuario == null) {
				throw new Exception(ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			if (cuentasesion == null) {
				throw new Exception(ConstantesAutoDoc.MSG_SESSIONCTE_FINISH);
			}

			if (usuario.isAuto_pdv()) {
				if ((usuario.getLogin_autodoc() == null) || (usuario.getIdoficina() == null)) {
					throw new Exception("SESION DE AUTODOCUMENTACION SOLICITADA"
							+ " POR PDV HA TERMINADO, VULEVA A INTENTAR FIRMARSE.");

				}
			}
			// Para cada Id seleccionado obtiene los registros a procesar
			EtiquetaRotulacionDTO etiqueta = null;
			String[] ids = idregistro.trim().split(",");
			List<EtiquetaRotulacionDTO> lista_registros = null;
			List<EtiquetaRotulacionDTO> lista_temp = null;
			List<Envio> arr_envios = null;

			List<Envio> arr_envios_genrales = new ArrayList<Envio>();
			String uuid = UUIDUniqueCreator.generateUUID();

			DetalleVenta detalleVenta = new DetalleVenta();
			detalleVenta.setLogin(usuario.getLogin());
			detalleVenta.setSiglasplaza(usuario.getSiglasPlaza());
			detalleVenta.setIdoficina(usuario.getIdoficina());

			EtiquetaRotulacionDTO preciosEtiqueta = null;
			String tipo_venta_autodoc = "AUTODOC-" + usuario.getLogin() + "-" + usuario.getLogin_autodoc() + "-"
					+ usuario.getIdoficina();
			// Verifica si el tipo es distinto a AUTODOCWEB
			String tipoenlace = request.getParameter("tipoenlace") == null ? ""
					: request.getParameter("tipoenlace").trim().toUpperCase();
			tipoenlace = (tipoenlace == null || tipoenlace.trim().isEmpty()) ? "AUTODOC"
					: tipoenlace.trim().toUpperCase();
			logger.debug("tipoenlace:" + tipoenlace);

			// Datos para detalle
			float precio_total_servicio = 0;
			double subtotal = 0;
			float precio_total_adicionales = 0;
			int idconveniodetalle = 0;
			int idconvenio = 0;
			int idtarifa = 0;
			int id_generado = 0;
			String idservicio = "";
			String idservicio_linea = "";

			float km_origen_destino = 0;

			// String ids_etiquetas_generadas="";
			String guias_resultantes = "";
			List<DetalleVenta> lista_documentos_detalle_venta = new ArrayList<DetalleVenta>();
			List<EtiquetaRotulacionDTO> lista_datos_linea = null;
			DetalleVenta detalleventa = new DetalleVenta();
			List<Integer> ids_json_generdaso = new ArrayList<Integer>();
			double valor_seguro = 0;
			double valor_declarado = 0;
			double porcentaje_valor_seguro = 0;
			double porcentaje_seguro = 0;
			double deducible = 0;
			String ciaseguro = "";

			List<Envio> arr_envios_acu = new ArrayList<Envio>();
			for (String id : ids) {

				valor_seguro = 0;
				valor_declarado = 0;
				porcentaje_valor_seguro = 0;
				porcentaje_seguro = 0;
				deducible = 0;
				ciaseguro = "";

				etiqueta = new EtiquetaRotulacionDTO();

				etiqueta.setIdregistrodatos(id);

				lista_temp = iRotulacionEtiquetasDatosBO.getRegistrosDatosEtiquetas(etiqueta);

				for (EtiquetaRotulacionDTO etiquetaRotulacionDTO : lista_temp) {

					/*
					 * AQUI SE HACEN CONVERCIONES Y REGLAS DEL SEGURO EN CASO DE QUE TENGA SI NO
					 * TIENE NO ENTRA
					 */
					if ("SI".equals(etiquetaRotulacionDTO.getTiene_seguro())
							&& "NO".equals(etiquetaRotulacionDTO.getEs_multiple())) {

						/* OBTIENE % DEL SEGURO DEL CONVENIO */
						if (valor_seguro == 0.0) {

							List<SistemaDTO> listaSeguro = iParamsSistemaDAO
									.getValorPropiedadFloat(etiquetaRotulacionDTO.getIdconvenio());

							ciaseguro = listaSeguro.get(0).getValor();

							porcentaje_seguro = Float.parseFloat(listaSeguro.get(0).getIdpropertie());

							if (porcentaje_seguro < 100.00) {

								porcentaje_valor_seguro = porcentaje_seguro > 0 ? (porcentaje_seguro / 100) : 0;

							} else {

								porcentaje_seguro = 0;

							}

							if (esmadre == "s" || esmadre.equals("s")) {

								valor_declarado = etiquetaRotulacionDTO.getValordeclarado() / lista_temp.size();

							} else {

								valor_declarado = etiquetaRotulacionDTO.getValordeclarado();

							}

							valor_seguro = valor_declarado * porcentaje_valor_seguro;

						}

					} else if ("SI".equals(etiquetaRotulacionDTO.getTiene_seguro())
							&& "SI".equals(etiquetaRotulacionDTO.getEs_multiple())) {

						/* OBTIENE % DEL SEGURO DEL CONVENIO */
						if (valor_seguro == 0.0) {

							List<SistemaDTO> listaSeguro = iParamsSistemaDAO
									.getValorPropiedadFloat(etiquetaRotulacionDTO.getIdconvenio());

							ciaseguro = listaSeguro.get(0).getValor();

							porcentaje_seguro = Float.parseFloat(listaSeguro.get(0).getIdpropertie());

							if (porcentaje_seguro < 100.00) {

								porcentaje_valor_seguro = porcentaje_seguro > 0 ? (porcentaje_seguro / 100) : 0;

							} else {

								porcentaje_seguro = 0;

							}

							valor_declarado = etiquetaRotulacionDTO.getValordeclarado() / lista_temp.size();

//								valor_declarado = etiquetaRotulacionDTO.getValordeclarado();
//								
//								/* CALCULO PARA SUMA ASEGURADA(CANTIDAD ASEGURADA) */
//								valor_seguro = valor_declarado / porcentaje_valor_seguro;
//								
//								/* CALCULO DE DECUCIBLE */
//								deducible = ((1 - porcentaje_valor_seguro ) * valor_seguro); 

							if (esmadre == "s" || esmadre.equals("s")) {

								valor_seguro = etiquetaRotulacionDTO.getValordeclarado() * porcentaje_valor_seguro;

							} else {

								valor_seguro = valor_declarado * porcentaje_valor_seguro;

							}

						}

					} else if ("NO".equals(etiquetaRotulacionDTO.getTiene_seguro())
							&& "SI".equals(etiquetaRotulacionDTO.getEs_multiple())) {

						if (valor_seguro == 0.0) {

							valor_declarado = etiquetaRotulacionDTO.getValordeclarado() / lista_temp.size();

						}

					} else {

						valor_declarado = etiquetaRotulacionDTO.getValordeclarado();

					}

					preciosEtiqueta = etiquetaRotulacionDTO;
					etiqueta.setUuid(etiquetaRotulacionDTO.getUuid());

					iRotulacionEtiquetasDatosBO.validaRegistro(etiquetaRotulacionDTO);
					iRotulacionEtiquetasDatosBO.validaEnrutamientoRegistro(etiquetaRotulacionDTO);

					if (etiquetaRotulacionDTO.getEsvalido() != 0) {
						throw new Exception("El registro " + etiquetaRotulacionDTO.getRazonsocial_rem() + "-"
								+ etiquetaRotulacionDTO.getRazonsocial_des() + ", es invalido:"
								+ etiquetaRotulacionDTO.getMensajeError());
					}
				}

				// Obtiene los datos del servicio
				lista_datos_linea = iRotulacionEtiquetasDatosBO.getRegistrosDatos(etiqueta);
				for (EtiquetaRotulacionDTO etiquetaRotulacionDTO : lista_datos_linea) {
					if (etiquetaRotulacionDTO.getIdregistrodatos() == etiqueta.getIdregistrodatos()) {
						idservicio_linea = etiquetaRotulacionDTO.getDescripcion_servicio();
					}

				}

				lista_registros = new ArrayList<EtiquetaRotulacionDTO>();
				arr_envios = new ArrayList<Envio>();

				for (EtiquetaRotulacionDTO etiquetaRotulacionDTO : lista_temp) {

					etiquetaRotulacionDTO.setUuid(uuid);

					if (esmadre == "s" || esmadre.equals("s")) {

						String consecutivo_madre = iAdminConsecutivosBO.getConsecutivoDocumento("ETIQUMADRE",
								usuario.entidad.getIdentidad(), usuario.organizacion.getIdorganizacion());

						esmadre = "000000000" + consecutivo_madre;

						etiquetaRotulacionDTO.setEsmadre(String.valueOf(esmadre));
						etiqueta.setEsmadre(String.valueOf(esmadre));

					} else if ((esmadre != "s" && esmadre != "n") || (!esmadre.equals("s") && !esmadre.equals("n"))) {

						etiquetaRotulacionDTO.setEsmadre(esmadre);
						etiqueta.setEsmadre(String.valueOf(esmadre));

					}

					/* DATOS SEGURO */
					etiquetaRotulacionDTO.setCiaseguro(ciaseguro);
					etiquetaRotulacionDTO.setPrecio_seguro(Float.parseFloat(String.valueOf(valor_seguro)));
					etiquetaRotulacionDTO.setCantasegurada(Float.parseFloat(String.valueOf(porcentaje_seguro)));
					etiquetaRotulacionDTO.setValordeclarado(Float.parseFloat(String.valueOf(valor_declarado)));

					etiquetaRotulacionDTO.setTiene_cita(etiquetaRotulacionDTO.getTiene_cita() == null ? "NO"
							: etiquetaRotulacionDTO.getTiene_cita());

					/* CAMBIO UNIGIS IDREMDES */
					Gson gson = new Gson();
					EtiquetaRotulacionDTO json_etiqueta = gson.fromJson(etiquetaRotulacionDTO.getJson_data(),
							EtiquetaRotulacionDTO.class);

					if (json_etiqueta != null) {

						etiquetaRotulacionDTO.setIdRmDes_rem(json_etiqueta.getIdRmDes_rem());
						etiquetaRotulacionDTO.setIdRmDes_des(json_etiqueta.getIdRmDes_des());

					} else {

						etiquetaRotulacionDTO.setIdRmDes_rem("");
						etiquetaRotulacionDTO.setIdRmDes_des("");

					}

					/* CAMBIO UNIGIS */
					etiquetaRotulacionDTO.setSistema(1);
					etiquetaRotulacionDTO.setIdproducto(json_etiqueta.getIdproducto());

					lista_registros.add(etiquetaRotulacionDTO);
					etiqueta.setRemite(etiquetaRotulacionDTO.getRazonsocial_rem());
					etiqueta.setDestino(etiquetaRotulacionDTO.getRazonsocial_des());

					detalleVenta.setIdconvenio(etiquetaRotulacionDTO.getIdconvenio());
					detalleVenta.setIdconveniodetalle(etiquetaRotulacionDTO.getIdconveniodetalle());
					detalleVenta.setIdtarifa(etiquetaRotulacionDTO.getIdtarifa());

					detalleVenta.setValor_declarado(Float.parseFloat(String.valueOf(valor_declarado)));
					detalleVenta.setPrecio_seguro(Float.parseFloat(String.valueOf(valor_seguro * lista_temp.size())));

					idconveniodetalle = etiquetaRotulacionDTO.getIdconveniodetalle();
					idconvenio = etiquetaRotulacionDTO.getIdconvenio();
					idtarifa = etiquetaRotulacionDTO.getIdtarifa();
					idservicio = etiquetaRotulacionDTO.getIdservicio();
					km_origen_destino = etiquetaRotulacionDTO.getKms_origen_destino();

					if (!"AUTODOC".equals(tipoenlace)) {
						// Sale de bucle solo toma la primera linea
						break;
					}

				}
				etiqueta.setCantidad(lista_registros.size());

				// Indica el tipo de impresion de acuerdo a la confiruacionde la
				// la cuanta asignada al usuario
				iEtiquetasBO.setTipomanejoimpresion(cuentasesion.getTipofolio());

				iEtiquetasBO.creaEtiquetas(lista_registros, usuario, arr_envios, uuid, 0);
				if (arr_envios.size() <= 0) {
					throw new Exception(
							"NO EXISTEN DOCUMENTOS QUE IMPRIMIR, VERIFIQUE FOLIOS O CONVENIOS DISPONIBLES.");
				}
				// Para cada etiqueta agrega los registros
				iEtiquetasBO.insertAdicionalesDocumento(lista_registros);

				// Agrega datos de la generacion
				for (Envio envio : arr_envios) {
					guias_resultantes = envio.getIdEnvio() + ",";
					arr_envios_genrales.add(envio);
				}
				guias_resultantes = UtilsStrings.formateaCadenaComillas(guias_resultantes);
				// Genera el GSON Final
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String json_data = gson.toJson(arr_envios);

				etiqueta.setJson_data(json_data);
				etiqueta.setLogin(usuario.getLogin());
				etiqueta.setUuid(uuid);
				etiqueta.setNacional("NACIONAL");
				// Genera el id y lo guarda
				id_generado = iRotulacionEtiquetasDatosBO.insertRotulacionEtiquetasGeneradas(etiqueta);
				ids_json_generdaso.add(id_generado);

				// Crea el registro de venta si es una guia de PDV
				// if (usuario.isAuto_pdv()){
				List<com.administracion.dto.AdicionalDTO> precios = iEtiquetasBO
						.getAdicionalesDocumento(guias_resultantes);
				for (AdicionalDTO adicionalDTO : precios) {
					precio_total_adicionales += adicionalDTO.getPrecio();
				}
				// Precio del servicio
				List<CruceCoberturaDTO> arr_transbordos = preciosEtiqueta.getArr_transbordos();
				for (CruceCoberturaDTO cruceCoberturaDTO : arr_transbordos) {
					preciosEtiqueta.setPrecio_unitario(cruceCoberturaDTO.getPrecio());

				}
				// El precio unitario es el precio del servicio + adicionales
				precio_total_servicio += (preciosEtiqueta.getPrecio_unitario() * lista_registros.size())
						+ (precio_total_adicionales * lista_registros.size());

				// Agrega los documentos
				for (Envio envio : arr_envios) {
					// Datos de los adicionales
					detalleventa = objetoVentaDetalle(etiqueta, null);
					detalleventa.setIdventa(0);
					detalleventa.setCantidad(1);
					detalleventa.setIdproducto("SERVICIO");
					detalleventa.setPrecio_unitario(preciosEtiqueta.getPrecio_unitario() + precio_total_adicionales);
					detalleventa.setDescripcion(idservicio_linea);
					detalleventa.setIdservicio(idservicio);

					detalleventa.setDescuento(0);
					detalleventa.setDestino(envio.getSiglasDestino());
					detalleventa.setIdadicional(etiqueta.getIdadicional());
					detalleventa.setIdpesotarifa(etiqueta.getIdpesotarifa());
					// detalleventa.setIdproducto(etiqueta.getIdproducto());
					detalleventa.setIdrangotarifa(etiqueta.getIdrangotarifa());
					detalleventa.setIdconvenio(idconvenio);
					detalleventa.setIdconveniodetalle(idconveniodetalle);

					ConvenioContratoDetalleDTO detalleConvenio = iRotulacionEtiquetasDatosBO
							.getDetalleConvenioRotulacion(idconveniodetalle);
					detalleventa.setIdzonatarifa(detalleConvenio.getIdserviciotarifazona());
					detalleventa.setIdpesotarifa(detalleConvenio.getIdtarifapeso());
					detalleventa.setIdrangotarifa(detalleConvenio.getIdrangoenvios());

					detalleventa.setIdtarifa(idtarifa);
					// detalleventa.setIdzonatarifa(etiqueta.getIdzonatarifa());
					detalleventa.setKm(km_origen_destino);
					detalleventa.setOrigen(envio.getSiglasOrigen());
					detalleventa.setPesokg(envio.getPeso());
					detalleventa.setPesovol(envio.getPeso_volumetrico() + "");

					detalleventa.setIddocumento(envio.getIdEnvio());
					detalleventa.setIdguiainternacional(etiqueta.getIdguiainternacional());
					detalleventa.setTipocambio(0);
					detalleventa.setTipoventa(tipo_venta_autodoc);

					detalleventa.setValor_declarado(Float.parseFloat(String.valueOf(valor_declarado)));
					detalleventa.setPrecio_seguro(Float.parseFloat(String.valueOf(valor_seguro)));

					// Lo agrega al arreglo
					lista_documentos_detalle_venta.add(detalleventa);

					// Agrega el registro de datos para recepcion
					iEtiquetasBO.insertPesoKmAmpara(envio.getIdEnvio(), envio.getServicio(), detalleventa, 0);

					if (!usuario.isAuto_pdv()) {
						try {
							if (envio.isAcuse()) {
								iEtiquetasBO.insertGuiasACU(envio.getIdEnvio(), detalleVenta.getIdventa(), uuid);
							}
						} catch (Exception e) {

						}
					}

				}
				// Agrega los registros acuse
				for (Envio envio_acu : arr_envios) {
					if (envio_acu.isAcuse()) {
						arr_envios_acu.add(envio_acu);
					}

				}

			}

			// Inserta la venta de todos los registros seleccionados
			int idventa = 0;

			if (usuario.isAuto_pdv()) {
				if (precio_total_servicio > 0) {
					subtotal = precio_total_servicio;
					double iva = (double) ((double) 16 / (double) 100);
					double iva_precio = iva * subtotal;
					double precio_total = subtotal + iva_precio;

					VentaDTO venta = new VentaDTO();
					venta.setBanco_tarjeta("");
					venta.setIdclientefactura("");
					venta.setIdformapago("");
					venta.setNumero_tarjeta("");
					venta.setObservacion("");
					venta.setSolicita_factura("");

					venta.setIva(iva_precio + "");
					venta.setDescuento(0);
					venta.setSubtotal(subtotal + "");
					venta.setTotal(precio_total + "");

					venta.setLogin(usuario.getLogin_autodoc());
					venta.setIdoficina(usuario.getIdoficina());
					venta.setEstatus(1); // 1=Activo, 0=Cancelada
					venta.setNacional("NACIONAL");
					venta.setTipoventa(tipo_venta_autodoc);
					venta.setIdtipoventa(ConstantesGenerales.TIPO_ROTULACION_PDV_AUTODOC);

					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					String json_data = gson.toJson(arr_envios_genrales);

					// Inserta registro
					idventa = iRotulacionEtiquetasDatosBO.insertVentaAutoDoc(venta, lista_documentos_detalle_venta,
							ids_json_generdaso, usuario, json_data, arr_envios_genrales.size());

					// Actualiza el idventa para el uuid agregado
					modelMap.put("idventa", idventa);
				}
			}

			// Agrega los servicios acuse
			for (Envio en : arr_envios_acu) {
				try {

					iEtiquetasBO.insertGuiasACU(en.getIdEnvio(), idventa, uuid);
				} catch (Exception e) {

				}
			}

			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("pdffile", "IMPRIMIR");
			modelMap.put("uuid", uuid);

		} catch (Exception dae) {
			logger.debug("ERROR AL CREAR LOS DOCUMENTOS :" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;

	}

	@RequestMapping(value = "/viewPDFArchivo", method = { RequestMethod.GET, RequestMethod.POST })
	public void viewPDFArchivo(HttpServletRequest request, HttpServletResponse response) {

		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		byte[] bytes = null;
		String archivo = "";
		try {
			String error = "<p>No se pudo crear archivo PDF del documento, verifique con el administrador.<p>";
			String uuid = request.getParameter("uuid");

			if (usuario == null) {
				error = "SESION DE USUARIO ES INVALIDA, VUELVA FIRMARSE.";
			} else if ((uuid == null) || (uuid.trim().length() <= 0)) {
				error = "IDENTIFICADOR DE IMPRESION ES INVALIDO, VERIFIQUE CON EL ADMINISTRADOR.";
			} else {
				List<EtiquetaRotulacionDTO> datos = iRotulacionEtiquetasDatosBO
						.getRegistrosDatosEtiquetasJsonGeneradas(usuario, uuid);
				if ((datos == null) || (datos.size() <= 0)) {
					error = "NO EXISTE INFORMACION DISPONIBLE PARA IMPRESION, VERIFIQUE.";
				} else {
					List<Envio> arr_envios = new ArrayList<Envio>();

					Gson gson = new GsonBuilder().setPrettyPrinting().create();
					Envio[] myTypes = null;

					// CREAMOS UNA OBJETO ENVIO DEAPOYO
					Envio envioMadre = new Envio();

					// Obtiene todos los registro de Json para el UUID
					for (EtiquetaRotulacionDTO jsonetiqueta : datos) {
						myTypes = gson.fromJson(jsonetiqueta.getJson_data(), Envio[].class);

						for (Envio envio : myTypes) {
							arr_envios.add(envio);

							/*
							 * AGREGAMOS EL ULTIMO DATO DEL JSON A NUESTRO OBJETO ESTOCON EL FIN DEOBTENER
							 * CUALQUIER DATO Y CON ESTE VERIFICAREL APARTADO "ESMADRE" YA QUE CONESTE
							 * SABREMOS SI FUE UN ENVIO CON GUIA MADRE O NO
							 */
							envioMadre = envio;
						}
					}

					// OBTENEMOS EL DATO PARA SABER SI ES GUIA MADRE
					String verificaMadre = arr_envios.get(0).getesMadre();

					/*
					 * EN CASO DE QUE EL DATO SEA DIFERENTE DE n QUIERE DECIR QUE SI ES ENVIO CON
					 * GUIA MADRE
					 */
					if (!verificaMadre.equals("n")) {

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

						/* EN CASO DE QUE LA LISTA FINAL TENGA M¿MENOS DE 5 DATOS */
						if (arr_envios.size() <= 5) {

							/*
							 * RECORREMOS LA LISTA Y VAMOS OBTENIENDO LOS DATOS PARA FORMATEARLOS Y METERLOS
							 * EN LA VARIABLE
							 */
							for (int i = 0; i < arr_envios.size(); i++) {

								/* EN CASO DE QUE SEA EL PRIMERO DATO QUE SE AGREGA "datosTabla" */
								if (i == 0) {

									/* CADA DATO LO OBTENEMOS Y VAMOS DANDO FORMATO */
									cantidadS = formatearDato(String.valueOf(arr_envios.get(i).getCantidad()), 10, 1);

									if (arr_envios.get(i).getReferencia().isEmpty()) {

										referenciaS = formatearDato("SINDESCRIP", 4, 2);

									} else {

										referenciaS = formatearDato(String.valueOf(arr_envios.get(i).getReferencia()),
												4, 2);

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

									/* EN CASO DE NO SE REL PRIMER DATO, YA PODEMOS USAR ~ */
								} else {

									/* CADA DATO LO OBTENEMOS Y VAMOS DANDO FORMATO */
									cantidadS = formatearDato(String.valueOf(arr_envios.get(i).getCantidad()), 10, 1);

									if (arr_envios.get(i).getReferencia().isEmpty()) {

										referenciaS = formatearDato("SINDESCRIP", 4, 2);

									} else {

										referenciaS = formatearDato(String.valueOf(arr_envios.get(i).getReferencia()),
												4, 2);

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

							/* A NUESTRO OBJETO DE AYUDA AGREGAMOS EL DATO MADRE */
							envioMadre.setIdEnvio(envioMadre.getesMadre());

							/* EN REFERENCIA AGREGAMOS TODOS LOS DATOS */
							envioMadre.setReferencia(datosTabla);

							/* AL ARRELGO YA LIMPIO LE AGREGAMOS UN DATO YA CON TODO LISTO */
							arr_envios.add(envioMadre);

							/* EN CASO DEQUE LA LISTA FINAL TENGA MAS DE 5 DATOS, REALIZAMOS OTROPROCESO */
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

								/* EN CASO DE QUE SEA EL PRIMERO DATO QUE SE AGREGA "datosTabla" */
								if (i == 0) {

									/* CADA DATO LO OBTENEMOS Y VAMOS DANDO FORMATO */
									cantidadS = formatearDato(String.valueOf(arr_envios.get(i).getCantidad()), 10, 1);

									if (arr_envios.get(i).getReferencia().isEmpty()) {

										referenciaS = formatearDato("SINDESCRIP", 4, 2);

									} else {

										referenciaS = formatearDato(String.valueOf(arr_envios.get(i).getReferencia()),
												4, 2);

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

									/* CADA DATO LO IGUALAMOS A GUINES Y VAMOS DANDO FORMATO */
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

									/* CADA DATO LO IGUALAMOS Y VAMOS DANDO FORMATO */
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

									/* CADA DATO LO OBTENEMOS Y VAMOS DANDO FORMATO */
									cantidadS = formatearDato(String.valueOf(arr_envios.get(i).getCantidad()), 10, 1);

									if (arr_envios.get(i).getReferencia().isEmpty()) {

										referenciaS = formatearDato("SINDESCRIP", 4, 2);

									} else {

										referenciaS = formatearDato(String.valueOf(arr_envios.get(i).getReferencia()),
												4, 2);

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

							/* A NUESTRO OBJETO DE AYUDA AGREGAMOS EL DATO MADRE */
							envioMadre.setIdEnvio(envioMadre.getesMadre());

							/* EN REFERENCIA AGREGAMOS TODOS LOS DATOS */
							envioMadre.setReferencia(datosTabla);

							/* AL ARRELGO YA LIMPIO LE AGREGAMOS UN DATO YA CON TODO LISTO */
							arr_envios.add(envioMadre);

						}

					}

					// Genera y obtiene el nombre del archivo
					archivo = iMuestraEtiquetasBO.generaPDFGuia(arr_envios, usuario, ConstantesGenerales._TIPOIMPRESION,
							ConstantesGenerales.ID_SKY4SOL, usuario.getFormatoetiperso());

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

	@RequestMapping(value = "/impresionesdiarias", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, ? extends Object> impresionesdiarias(HttpServletRequest request) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		List<EtiquetaRotulacionDTO> lista = null;
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {
			String fechaini = UtilsStringFechas.obtenerFechaActual("yyyy-MM-dd") + " 00:00:00";
			String fechafin = UtilsStringFechas.obtenerFechaActual("yyyy-MM-dd") + " 23:59:00";

			lista = iRotulacionEtiquetasDatosBO.getReimpresionRegistrosDatosEtiquetasJsonGeneradas(usuario, fechaini,
					fechafin);

			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);

		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;

	}

	@RequestMapping(value = "/viewPDFArchivoReimpresion", method = { RequestMethod.GET, RequestMethod.POST })
	public void viewPDFArchivoReimpresion(HttpServletRequest request, HttpServletResponse response) {

		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		String idregistro = "";
		String[] ids = null;

		byte[] bytes = null;
		String archivo = "";
		try {
			String error = "<p>No se pudo crear archivo PDF del documento.<p>";

			try {
				idregistro = request.getParameter("idregistro");
				ids = idregistro.trim().split(",");
			} catch (Exception e) {
				idregistro = "";
			}

			if (usuario == null) {
				error = "SESION DE USUARIO ES INVALIDA, VUELVA FIRMARSE.";
			} else if (ids.length < 0) {
				error = "IDENTIFICADOR DE IMPRESION ES INVALIDO, VERIFIQUE CON EL ADMINISTRADOR.";

			} else {
				List<EtiquetaRotulacionDTO> datos = iRotulacionEtiquetasDatosBO
						.getReimpresionRegistrosDatosEtiquetasJsonGeneradas(ids);
				if ((datos == null) || (datos.size() <= 0)) {
					error = "NO EXISTE INFORMACION DISPONIBLE PARA IMPRESION, VERIFIQUE.";
				} else {
					Gson gson = new GsonBuilder().setPrettyPrinting().create();

					Envio[] myTypes = gson.fromJson(datos.get(0).getJson_data(), Envio[].class);

					List<Envio> arr_envios = new ArrayList<Envio>();
					for (Envio envio : myTypes) {
						arr_envios.add(envio);
					}

					for (int i = 0; i < arr_envios.size(); i++) {

						if (!arr_envios.get(i).getesMadre().equals('n') && arr_envios.get(0).getReimpresion() == null) {

							arr_envios.get(i).setReimpresion("REIMPRESION");

						}

					}

					// Genera y obtiene el nombre del archivo
					archivo = iMuestraEtiquetasBO.generaPDFGuia(arr_envios, usuario, ConstantesGenerales._TIPOIMPRESION,
							ConstantesGenerales.ID_SKY4SOL, usuario.getFormatoetiperso());

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

	public DetalleVenta objetoVentaDetalle(EtiquetaRotulacionDTO etiqueta, VentaDTO venta) throws Exception {

		DetalleVenta detalleventa = new DetalleVenta();
		// Mapea los datos de la venta
		detalleventa.setCantidad(etiqueta.getNumpiezas());

		// Indica la descripcion del servicio
		if ("SERVICIO".equals(etiqueta.getIdproducto())) {
			detalleventa.setDescripcion(etiqueta.getDescripcion_servicio());
		} else {
			detalleventa.setDescripcion(etiqueta.getRazonsocial_rem());
		}

		detalleventa.setDescuento(etiqueta.getDescuento());
		detalleventa.setDestino(etiqueta.getDestino());
		detalleventa.setIdadicional(etiqueta.getIdadicional());
		detalleventa.setIdpesotarifa(etiqueta.getIdpesotarifa());
		detalleventa.setIdproducto(etiqueta.getIdproducto());
		detalleventa.setIdrangotarifa(etiqueta.getIdrangotarifa());
		detalleventa.setIdtarifa(etiqueta.getIdtarifa());
		detalleventa.setIdzonatarifa(etiqueta.getIdzonatarifa());
		detalleventa.setKm(etiqueta.getKms_origen_destino());
		detalleventa.setOrigen(etiqueta.getSiglasorigen());
		detalleventa.setPesokg(etiqueta.getPesofisico());
		detalleventa.setPesovol(etiqueta.getPesovolumetrico());
		detalleventa.setPrecio_unitario(etiqueta.getPrecio_unitario());
		detalleventa.setIddocumento(etiqueta.getIddocumento());
		detalleventa.setIdguiainternacional(etiqueta.getIdguiainternacional());

		if (venta != null) {
			detalleventa.setIdventa(venta.getIdventa());
			detalleventa.setTipocambio(venta.getTipocambio());
		}

		// TODO Auto-generated method stub
		return detalleventa;
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

				// SE AGREGAN ESPACIO EN BLANCO A LA IZQUIERA PARA QUE CUMPLA CON 10
				textoFormateado = String.format("%-" + paraDiez + "s", dato);

				// SEAGREGAN LOS ESPACIOS EN BLANCO DEPENDIENDO DEL NUMERO DEFORMATO
				// EN ESTE PUNTO EL DATO YA ES DE 10 CARACTERES Y APARTE SE AGREGANM LOS
				// ESPACIO PARA QUE CUMPLA CON EL FORMATO
				textoFormateado = String.format("%-" + numFormato + "s", textoFormateado);

				/* SI EL DATOES TIENE 10 CARACTERES */
			} else if (tamanoDato == 10) {

				/* SE AGREGAN SOLO LOS ESPACIOS A LA DERECHA PARA QUE CUMPLA CON EL FORMATO */
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

				/* TOMA CONTENIDO YT REFERENCIA Y LOS ALMACENA EN LAS VARIABLES trim */
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
//					if(referenciaS == arr_enviosFinales.get(k).getReferencia() && contenidoS == arr_enviosFinales.get(k).getContenido()){
					if (referenciaS.equals(arr_enviosFinales.get(k).getReferencia())
							&& contenidoS.equals(arr_enviosFinales.get(k).getContenido())) {

						/* AGREGAMOS UN n DE "NO" PARA SABER QUE ESTE DATO YA NO DEBE PROCESARCE */
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
