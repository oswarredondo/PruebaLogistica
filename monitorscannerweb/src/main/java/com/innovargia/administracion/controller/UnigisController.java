package com.innovargia.administracion.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.ibo.IDocumentoServicioBO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.INivelUsuarioBO;
import com.innovargia.salesmanager.ibo.IRotulacionEtiquetasDatosBO;
import com.innovargia.utils.UtilsRequest;
import com.servicio.constantes.ConstantesAdminSale;
import com.servicio.dtos.DocumentoDTO;

import ar.com.unisolutions.*;
import ar.com.unisolutions.bo.IDireccioneBO;
import ar.com.unisolutions.dto.Direccion;

/**
 * @author Oswaldo Arredondo
 */
@Controller
@RequestMapping("/api_unigis")
public class UnigisController {

	private static final Logger logger = LoggerFactory.getLogger(UnigisController.class);

	@Autowired
	IRotulacionEtiquetasDatosBO iRotulacionEtiquetasDatosUnigisBO;

	@Autowired
	INivelUsuarioBO iNivelUsuarioUnigisBO;

	@Autowired
	IDocumentoServicioBO iDocumentoServicioBO;
	
	@Autowired
	IDireccioneBO iDireccioneBO;

	@RequestMapping(value = "/reenviaOrdenesPedido", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, ? extends Object> reenviaOrdenesPedido(
			@RequestParam(value = "uuid", required = true) String ids, HttpServletRequest request) throws Exception {

		UtilsRequest.displayParametros(request);

		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// Comienza el proceso de invocacion del WS
		java.net.URL portAddress;

		/* URL DEL SERVICIO DE UNIGIS */
		//portAddress = new java.net.URL("https://cloudmx.unigis.com/Tracusa/mapi/soap/logistic/service.asmx");
		portAddress = new java.net.URL("https://cloud.unigis.com/Tracusa/mapi/soap/logistic/service.asmx");

		// CONFORME LA DOC DE AXIS 1.4 SEINTANCIA EL LOCATOR
		ServiceLocator locator = new ServiceLocator();

		// CONFORME LA DOC DE AXIS 1.4 SEINTANCIA EL PROXY
		ServiceSoap proxy = locator.getServiceSoap(portAddress);

		// CUALQUIERA SIRVE PARA PRUEBAS
		String apiKey = "123";
		String xmlEnviado = "";

		int multiple = 1;

		Calendar today = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		String data = "";

		CrearOrdenesPedidoResponse crearOrdenesPedidoResponse = new CrearOrdenesPedidoResponse();

		try {

			String error = "";

			if (usuario == null) {

				error = "SESION DE USUARIO ES INVALIDA, VUELVA FIRMARSE.";

			} else if ((ids == null) || (ids.trim().length() <= 0)) {

				error = "IDENTIFICADOR DE GUIAS ES INVALIDO, VERIFIQUE CON EL ADMINISTRADOR.";

			} else {

				DocumentoDTO datos = null;

				List<DocumentoDTO> etiquetas = new ArrayList<DocumentoDTO>();

				String[] lstdatos = ids.split(",");

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

					POrdenPedido[] pedidosArray = new POrdenPedido[1];

					POrdenPedido pedidos = new POrdenPedido();

					/* CLIENTE DESTINO */
					PCliente cliente = new PCliente();

					PDomicilio domicilioFiscal = new PDomicilio();

					/* CLIENTE ORIGEN */
					PCliente cliente2 = new PCliente();

					/* DEPOSITO SALIDA (CO INICIAL DE DONDE SALE) */
					PDeposito depositoSalida = new PDeposito();

					/*
					 * DEPOSITO LLEGADA (CO AL QUE LLEGA PRA ENVIAR A SU
					 * DESTINO)
					 */
					PDeposito depositoLlegada = new PDeposito();

					/* PRODUCTO E ITEM */
					PProducto producto = new PProducto();
					POrdenPedidoItem[] itemsArray = new POrdenPedidoItem[1];
					POrdenPedidoItem items = new POrdenPedidoItem();

					// PARA CADA GUIA SE GENERA UN ENVIO A UNIGIS
					for (Envio etiquetaEnviada : arr_envios) {

						data = gson.toJson(etiquetaEnviada);

						/* INICIA BLOQUE DE PEDIDO */
						pedidos.setRefDocumento(etiquetaEnviada.getIdEnvio());
						pedidos.setRefDocumentoAdicional(etiquetaEnviada.getReferencia());
						calendar.setTime(dateFormat.parse("2200-12-31 00:00:00.000000"));
						pedidos.setFecha(calendar);

						if (etiquetaEnviada.destinatario.getIdRmDes() == null || !etiquetaEnviada.destinatario.getIdRmDes().contains("-")) {
							
							String[] idremdes = checKDirectionDes(etiquetaEnviada).split("-");
							
							cliente.setRefCliente(idremdes[4]); // ULTIMOS

						} else {

							String[] idremdes = etiquetaEnviada.getIdRmDesDe().split("-");
							// CLIENTE DESTINATARIO
							cliente.setRefCliente(idremdes[4]); // ULTIMOS

						}

						/* INICIA BLOQUE DE CLIENTE DESTINO*/
						//Direccion direccion = iDireccioneBO.getDireccionDescripcion(Integer.parseInt(etiquetaEnviada.destinatario.getCp()));
						
						cliente.setRazonSocial(etiquetaEnviada.destinatario.getRazonSocial());
						cliente.setTelefono(etiquetaEnviada.destinatario.getTelefono());
						cliente.setEMail(etiquetaEnviada.destinatario.getCorreoe());
						cliente.setCalle(etiquetaEnviada.destinatario.getCalle());
						cliente.setBarrio(etiquetaEnviada.destinatario.getColonia());
						cliente.setLocalidad(etiquetaEnviada.destinatario.getCiudad());
						/* Direccion de catalogo de SAT */
						cliente.setPartido(etiquetaEnviada.destinatario.getMunicipio());
						cliente.setProvincia(etiquetaEnviada.destinatario.getEstado());
						//cliente.setPais(etiquetaEnviada.destinatario.getPais());
						//cliente.setPartido(direccion.getMunicipio());
						//cliente.setProvincia(direccion.getEstado());
						cliente.setPais("MEX");
						cliente.setNumeroPuerta(etiquetaEnviada.destinatario.getNumexterior());
						cliente.setLatitud(0.00);
						cliente.setLongitud(0.00);
						cliente.setDomicilioDescripcion(etiquetaEnviada.destinatario.getRazonSocial());

						domicilioFiscal.setCalle(etiquetaEnviada.destinatario.getCalle());
						domicilioFiscal.setBarrio(etiquetaEnviada.destinatario.getColonia());
						domicilioFiscal.setLocalidad(etiquetaEnviada.destinatario.getCiudad());
						domicilioFiscal.setPartido(etiquetaEnviada.destinatario.getMunicipio());
						domicilioFiscal.setProvincia(etiquetaEnviada.destinatario.getEstado());
						//domicilioFiscal.setPartido(direccion.getMunicipio());
						//domicilioFiscal.setProvincia(direccion.getEstado());
						domicilioFiscal.setPais(etiquetaEnviada.destinatario.getPais());
						domicilioFiscal.setNumeroPuerta(etiquetaEnviada.destinatario.getNumexterior());
						domicilioFiscal.setLatitud(0.00);
						domicilioFiscal.setLongitud(0.00);
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
						//cliente2.setRefCliente(usuario.getNumCliente());
						cliente2.setRefCliente(etiquetaEnviada.getNumCliente());
						cliente2.setRazonSocial(etiquetaEnviada.remitente.getRazonSocial());
						cliente2.setTelefono(etiquetaEnviada.remitente.getTelefono());
						cliente2.setEMail(etiquetaEnviada.remitente.getCorreoe());
						cliente2.setCalle(etiquetaEnviada.remitente.getCalle());
						cliente2.setBarrio(etiquetaEnviada.remitente.getColonia());
						cliente2.setLocalidad(etiquetaEnviada.remitente.getCiudad());
						cliente2.setPartido(etiquetaEnviada.remitente.getMunicipio());
						cliente2.setProvincia(etiquetaEnviada.remitente.getEstado());
						cliente2.setPais(etiquetaEnviada.remitente.getPais());
						cliente2.setNumeroPuerta(etiquetaEnviada.remitente.getNumexterior());
						cliente2.setLatitud(0.00);
						cliente2.setLongitud(0.00);
						cliente2.setDomicilioDescripcion(etiquetaEnviada.remitente.getRazonSocial());

						PDomicilio domicilioFiscal2 = new PDomicilio();

						domicilioFiscal2.setCalle(etiquetaEnviada.remitente.getCalle());
						domicilioFiscal2.setBarrio(etiquetaEnviada.remitente.getColonia());
						domicilioFiscal2.setLocalidad(etiquetaEnviada.remitente.getCiudad());
						domicilioFiscal2.setPartido(etiquetaEnviada.remitente.getMunicipio());
						domicilioFiscal2.setProvincia(etiquetaEnviada.remitente.getEstado());
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
						// pedidos.setCodigoSucursal(getCodigoCop());
						pedidos.setTipoPedido("MEX-DL");
						pedidos.setEstado("REQUIERE AUTORIZACION");
						pedidos.setLatitud(0.00);
						pedidos.setLongitud(0.00);
						pedidos.setObservaciones(etiquetaEnviada.getComentario());
						pedidos.setTipo("D");

						/* INICIO BLOQUE DE CLIENTE DADOR(USUARIO QUE ENVIA) */
						PCliente clienteDador = new PCliente();

						//clienteDador.setRefCliente(usuario.getNumCliente());
						clienteDador.setRefCliente(etiquetaEnviada.getNumCliente());
						clienteDador.setRazonSocial(iNivelUsuarioUnigisBO.getRazonSocial(usuario));
						/* FIN BLOQUE DE CLIENTE DADOR(USUARIO QUE ENVIA) */

						// SE AGREGA EL CLIENTE DADOR A EL NODO DE PEDIDO
						pedidos.setClienteDador(clienteDador);

						pedidos.setPrioridad("1");
						pedidos.setCargaExclusiva(false);
						pedidos.setRequiereTurno(false);

						/*
						 * INICIO BLOQUE DE DEPOSITO SALIDA (CO INICIAL DE DONDE
						 * SALE)
						 */
						depositoSalida.setRefDepositoExterno(getCodigoCop(
								iRotulacionEtiquetasDatosUnigisBO.getDeposito(etiquetaEnviada.remitente.getCp())));
						/*
						 * FIN BLOQUE DE DEPOSITO SALIDA (CO INICIAL DE DONDE
						 * SALE)
						 */

						// SE AGREGA EL DEPOSITO SALIDA A EL NODO DE PEDIDO
						pedidos.setDepositoSalida(depositoSalida);

						/*
						 * INICIO BLOQUE DE DEPOSITO LLEGADA (CO AL QUE LLEGA
						 * PRA ENVIAR A SU DESTINO)
						 */
						depositoLlegada.setRefDepositoExterno(getCodigoCop(
								iRotulacionEtiquetasDatosUnigisBO.getDeposito(etiquetaEnviada.destinatario.getCp())));
						/*
						 * FIN BLOQUE DE DEPOSITO LLEGADA (CO AL QUE LLEGA PRA
						 * ENVIAR A SU DESTINO)
						 */

						// SE AGREGA EL DEPOSITO LLEGADA A EL NODO DE PEDIDO
						pedidos.setDepositoLlegada(depositoLlegada);

						pedidos.setCodigoSucursal(depositoSalida.getRefDepositoExterno());
						pedidos.setCodigoOperacion(depositoSalida.getRefDepositoExterno());

						/* INICIO BLOQUE PRODUCTO E ITEMS */
						items.setRefDocumento(etiquetaEnviada.getReferencia());
						items.setRefDocumentoAdicional(etiquetaEnviada.getContenido());

						int alto = (int) etiquetaEnviada.getAlto();
						int ancho = (int) etiquetaEnviada.getAncho();
						int peso = (int) etiquetaEnviada.getPeso();

						producto.setRefProducto((etiquetaEnviada.getTipo_empaque() == null ? "PAQUETE" : etiquetaEnviada.getTipo_empaque())  + "/" + alto + "/" + ancho + "/" + peso);
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

						if (etiquetaEnviada.getesMadre().equals("n")) {

							pedidos.setVarchar1("");
							pedidos.setVarchar2(etiquetaEnviada.getMultiples());

						} else {

							pedidos.setVarchar1(etiquetaEnviada.getesMadre());
							pedidos.setVarchar2(multiple + "/" + arr_envios.size());

							multiple++;

						}

						pedidosArray[0] = pedidos;
						/* FIN BLOQUE DE PEDIDO */

						// SE ENVIAN LOS DATOS Y SE OBTIENE EL CODIGO DE ESTATUS
						crearOrdenesPedidoResponse
								.setCrearOrdenesPedidoResult(proxy.crearOrdenesPedido(apiKey, pedidosArray));

						// METODO CREADO POR NOSOTROS PARA OBTENER LA ESTRUCTURA
						// XML/SWDL
						xmlEnviado = proxy.getXmlRequest();

						iRotulacionEtiquetasDatosUnigisBO.UpdateDocumentoUnigis(etiquetaEnviada.getIdEnvio(),
								crearOrdenesPedidoResponse.getCrearOrdenesPedidoResult());

					}

				}
			}

			if (crearOrdenesPedidoResponse.getCrearOrdenesPedidoResult() == 1) {

				modelMap.put("success", true);
				modelMap.put("message", "Correcto");
				modelMap.put("status", crearOrdenesPedidoResponse.getCrearOrdenesPedidoResult());

			} else {

				modelMap.put("success", true);
				modelMap.put("message", "Error");
				modelMap.put("status", crearOrdenesPedidoResponse.getCrearOrdenesPedidoResult());

			}

		} catch (Exception dae) {

			logger.debug("ERROR AL CREAR LOS DOCUMENTOS :" + dae.getMessage());
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