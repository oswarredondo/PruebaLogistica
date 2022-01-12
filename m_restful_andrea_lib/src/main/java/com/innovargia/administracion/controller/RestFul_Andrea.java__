package com.innovargia.administracion.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.andrea.dto.ConsultarTracking;
import com.administracion.andrea.dto.Destinatario;
import com.administracion.andrea.dto.DetalleEnvio;
import com.administracion.andrea.dto.GuiaEmbarque;
import com.administracion.andrea.dto.GuiaEmbarqueResponse;
import com.administracion.andrea.dto.Paquete;
import com.administracion.andrea.dto.TipoMercancia;
import com.administracion.andrea.dto.Tracking;
import com.administracion.dto.CartaFacturaDetalle;
import com.administracion.dto.Folios;
import com.administracion.ibo.ICartaPorteBO;
import com.administracion.ibo.IDocumentoServicioBO;
import com.administracion.ibo.IEtiquetasBO;
import com.administracion.ibo.IFoliosBO;
import com.administracion.ibo.IManifiestoLogisticaBO;
import com.administracion.ibo.IMuestraEtiquetasBO;
import com.administracion.ibo.IParamsSistemaBO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.innovargia.administracion.ibo.IPerfilOpcionUsuarioBO;
import com.innovargia.administracion.ibo.IUsuarioBO;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IRotulacionEtiquetasDatosBO;
import com.innovargia.utils.Fechas;
import com.innovargia.utils.Files;
import com.innovargia.utils.UUIDUniqueCreator;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.UtilsStrings;
import com.servicio.constantes.ConstantesAdminSale;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.DocumentoDTO;
import com.servicio.dtos.ManifiestoDTO;
import com.servicio.search.ibo.IBusquedaCuentasClientesBO;
import com.servicio.search.ibo.IBusquedaFrecuenciasBO;
import com.servicio.search.ibo.IBusquedaOficinasBO;
import com.servicio.search.ibo.IBusquedaWallPaperBO;
import com.innovargia.salesmanager.dtos.CuentasConexionMensajeriaDTO;

@Controller
@RequestMapping("/rest/andrea")
public class RestFul_Andrea {

	private static final Logger logger = LoggerFactory.getLogger(RestFul_Andrea.class);

	@Autowired
	IUsuarioBO iusuarioBO;
	@Autowired
	IPerfilOpcionUsuarioBO iPerfilOpcionUsuarioBO;
	@Autowired
	IBusquedaWallPaperBO iBusquedaWallPaperBO;
	@Autowired
	IFoliosBO iFoliosBO;
	@Autowired
	IParamsSistemaBO iParametrosSistemaBO;

	@Autowired
	IBusquedaOficinasBO iBusquedaOficinasBO;

	@Autowired
	IRotulacionEtiquetasDatosBO iRotulacionEtiquetasDatosBO;

	@Autowired
	IBusquedaCuentasClientesBO iBusquedaCuentasClientesBO;

	@Autowired
	IEtiquetasBO iEtiquetasBO;

	@Autowired
	ICartaPorteBO iCartaPorteBO;

	@Autowired
	IMuestraEtiquetasBO iMuestraEtiquetasBO;

	@Autowired
	IDocumentoServicioBO iDocumentoServicioBO;
	
	@Autowired
	IBusquedaFrecuenciasBO iBusquedaFrecuenciasBO;
	
	
	@Autowired
	IManifiestoLogisticaBO manifiestosBO;
	

	@RequestMapping(value = "/generarGuiaEmbarque", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public @ResponseBody GuiaEmbarqueResponse generarGuiaEmbarque(@RequestBody GuiaEmbarque embarque) throws Exception {

		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setLogin(UtilsStrings.nullChangeToUpperCase(embarque.getUsuario()));
		usuario.setPassword(UtilsStrings.nullChangeToUpperCase(embarque.getContrasena()));
		GuiaEmbarqueResponse guiaEmbarqueResponse = new GuiaEmbarqueResponse();

		try {
			// Usuarios
			usuario = iusuarioBO.getUsuarioLogin(usuario);

			// Obtiene los datos del cliente
			BusquedaDTO obj = new BusquedaDTO();
			obj.setNumcliente(usuario.getNumCliente());
			obj.setIdentificador_str(usuario.getNumCliente());

			CuentasDTO cuenta = iBusquedaCuentasClientesBO.getDatosCliente(obj);
			if (cuenta == null) {
				throw new Exception("NO EXISTEN DATOS DEL CLIENTE " + usuario.getNumCliente());
			}
			CuentasConexionMensajeriaDTO cuentaconexion = iBusquedaCuentasClientesBO.getDatosConexionCliente(obj);
			if (cuentaconexion == null) {
				throw new Exception("NO EXISTEN DATOS DE CONEXION DEL CLIENTE " + usuario.getNumCliente());
			}

			if ((cuentaconexion.getManejoporfoliosconvenio() == null)
					|| (cuentaconexion.getManejoporfoliosconvenio().isEmpty())) {
				throw new Exception("CLIENTE NO TIENE DEFINIFO EL TIPO DE MANEJO CONVENIO(C) o FOLIOS(F).");
			}
			int identidad = cuentaconexion.getIdentidad_default_folio() == 0 ? usuario.entidad.getIdentidad()
					: cuentaconexion.getIdentidad_default_folio();
			int idorganizacion = cuentaconexion.getOrganizacion_default_folio() == 0
					? usuario.organizacion.getIdorganizacion() : cuentaconexion.getOrganizacion_default_folio();
			if (ConstantesGenerales.MANEJO_FOLIOS.equals(cuentaconexion.getManejoporfoliosconvenio())) {
				if ((cuentaconexion.getIdservicio() == null) || (cuentaconexion.getIdservicio().isEmpty())) {
					throw new Exception("CLIENTE NO TIENE DEFINIFO EL SERVICIO PARA MENEJO DE FOLIOS.");
				}

				Folios folio = iFoliosBO.getFoliosDisponibles(cuentaconexion.getIdservicio(), usuario.getNumCliente(),
						cuentaconexion.getPeso_ampara_folio(), identidad, idorganizacion);

				if (folio == null) {
					throw new Exception("FOLIO NO HA SIDO DEFINIDO EN LA TABLA DE FOLIOS.");
				}

			} else if (ConstantesGenerales.MANEJO_FOLIOS.equals(cuentaconexion.getManejoporfoliosconvenio())) {
				if (cuentaconexion.getIdconvenio() == 0) {
					throw new Exception("CLIENTE NO TIENE DEFINIFO EL CONVENIO PARA MENEJO DE CONSECUTIVOS.");
				}
			} else {
				throw new Exception("CLIENTE NO TIENE DEFINIDO MANEJO CONVENIO(C) o FOLIOS(F).");
			}

			usuario.entidad.setIdentidad(identidad);
			usuario.organizacion.setIdorganizacion(idorganizacion);

			EtiquetaRotulacionDTO etiquetaRotulacionDTO = new EtiquetaRotulacionDTO();
			
			etiquetaRotulacionDTO.setIdservicio(cuentaconexion.getIdservicio());
			etiquetaRotulacionDTO.setServiciotarifa(cuentaconexion.getIdservicio());
			etiquetaRotulacionDTO.setPesobase(cuentaconexion.getPeso_ampara_folio());
			etiquetaRotulacionDTO.setPesofisico(cuentaconexion.getPeso_ampara_folio());

			// Remitente

			etiquetaRotulacionDTO.setRazonsocial_rem(cuenta.getRazonSocial());
			etiquetaRotulacionDTO.setContacto_rem(cuenta.getAtencion());
			etiquetaRotulacionDTO.setCalle_rem(UtilsStringFechas.convierteCadena(cuenta.getCalle(), 100));
			etiquetaRotulacionDTO.setColonia_rem(UtilsStringFechas.convierteCadena(cuenta.getColonia(), 100));
			etiquetaRotulacionDTO.setCp_rem(UtilsStringFechas.convierteCadena(cuenta.getCp(), 5));
			etiquetaRotulacionDTO.setMunicipio_rem(UtilsStringFechas.convierteCadena(cuenta.getCiudad(), 50));
			etiquetaRotulacionDTO.setEstado_rem(UtilsStringFechas.convierteCadena(cuenta.getEstado(), 50));
			etiquetaRotulacionDTO.setCiudad_rem(UtilsStringFechas.convierteCadena(cuenta.getCiudad(), 50));
			etiquetaRotulacionDTO.setTelefono_rem(UtilsStringFechas.convierteCadena(cuenta.getTelefono(), 22));
			etiquetaRotulacionDTO.setPais_rem(UtilsStringFechas.convierteCadena(cuenta.getPais(), 60));
			etiquetaRotulacionDTO.setRfc_rem(cuenta.getRfc());
			etiquetaRotulacionDTO.setEmail_rem(cuenta.getCorreoe());
			Frecuencias frecuencia_origen = iBusquedaFrecuenciasBO.getFrecuenciasEntregaCP(cuenta.getCp());
			etiquetaRotulacionDTO.setSiglasorigen(frecuencia_origen!=null?frecuencia_origen.getIdterminal():"");
			// Destino
			Destinatario destino = embarque.getDestinatario();
			validaRequerido(destino.getClaveCliente(), "CLAVE CLIENTE INVALIDA");
			//validaRequerido(destino.getConvenio(), "CONVENIO CLIENTE INVALIDO");
			validaRequerido(destino.getNombre(), "NOMBRE DESTINO INVALIDO");
			
			
			//validaRequerido(appaterno, "APELLIDO PATERNO INVALIDO");
			//validaRequerido(apmaterno, "APELLIDO MATERNO INVALIDO");
			//validaRequerido(destino.getTelefono(), "TELEFONO INVALIDO");
			//validaRequerido(destino.getNumero(), "NUMERO CALLE INVALIDO");
			//validaRequerido(destino.getReferencia()==null?"":destino.getReferencia(), "REFERENCIA INVALIDA");
			
			String tel = destino.getTelefono()==null?"":destino.getTelefono();
			String numero = destino.getNumero()==null?"":destino.getNumero();
			String appaterno = destino.getApellidoPaterno()==null?"":destino.getApellidoPaterno();
			String apmaterno = destino.getApellidoMaterno()==null?"":destino.getApellidoMaterno();
			String ref = destino.getReferencia()==null?"":destino.getReferencia();
			String entrecalles = destino.getEntreCalles()==null?"":destino.getEntreCalles();
			String idconvenio = destino.getConvenio()==null?"":destino.getConvenio();
			
			//Obligatorios opcionales
			destino.setReferencia(ref);
			destino.setApellidoMaterno(apmaterno);
			destino.setApellidoPaterno(appaterno);
			destino.setNumero(numero);
			destino.setTelefono(tel);
					
			validaRequerido(destino.getCodigoPostal(), "CODIGO POSTAL INVALIDO");
			validaRequerido(destino.getCalle(), "CALLE INVALIDA");
			//validaRequerido(destino.getEntreCalles(), "ENTRE CALLES INVALIDA");
			validaRequerido(destino.getColonia(), "COLONIA INVALIDA");
			validaRequerido(destino.getCiudad(), "CIUDAD INVALIDA");
			validaRequerido(destino.getEstado(), "ESTADO INVALIDO");
			validaRequerido(destino.getPais(), "PAIS INVALIDO");
			
			String ref_guia = embarque.getReferenciaGuia()==null?"":embarque.getReferenciaGuia();
			etiquetaRotulacionDTO.setReferencia(ref_guia);
			//validaRequerido(embarque.getReferenciaGuia(), "REFERENCIA GUIA INVALIDA");
			//Convenio tambien validar
			
			Frecuencias frecuencia_destino = iBusquedaFrecuenciasBO.getFrecuenciasEntregaCP(destino.getCodigoPostal());
			if (frecuencia_destino==null){
				throw new Exception("NO EXISTE FRECUENCIA DE ENTREGA PARA EL CP "+destino.getCodigoPostal());
			}
			
			String contacto = UtilsStringFechas.convierteCadenaNULL(destino.getNombre()) + " "
					+ UtilsStringFechas.convierteCadenaNULL(destino.getApellidoPaterno()) + " "
					+ UtilsStringFechas.convierteCadenaNULL(destino.getApellidoMaterno());

			contacto = UtilsStringFechas.convierteCadenaNULL(contacto, 50);

			String clave = UtilsStringFechas.convierteCadenaNULL(destino.getClaveCliente(), 10) + " "
					+ UtilsStringFechas.convierteCadenaNULL(idconvenio, 30); //+ " "
					//+ UtilsStringFechas.convierteCadenaNULL(destino.getReferencia(), 50);

			etiquetaRotulacionDTO.setRazonsocial_des(clave);
			etiquetaRotulacionDTO.setContacto_des(contacto);
			String calle = destino.getCalle() + " "  + destino.getNumero() ;
			calle = UtilsStringFechas.convierteCadena(calle, 100);
			
			etiquetaRotulacionDTO.setCalle_des(UtilsStringFechas.convierteCadena(calle, 100));
			etiquetaRotulacionDTO.setColonia_des(UtilsStringFechas.convierteCadena(destino.getColonia(), 100));
			etiquetaRotulacionDTO.setCp_des(UtilsStringFechas.convierteCadena(destino.getCodigoPostal(), 5));
			etiquetaRotulacionDTO.setMunicipio_des(UtilsStringFechas.convierteCadena(destino.getCiudad(), 50));
			etiquetaRotulacionDTO.setEstado_des(UtilsStringFechas.convierteCadena(destino.getEstado(), 50));
			etiquetaRotulacionDTO.setCiudad_des(UtilsStringFechas.convierteCadena(destino.getCiudad(), 50));
			etiquetaRotulacionDTO.setTelefono_des(UtilsStringFechas.convierteCadena(destino.getTelefono(), 22));
			etiquetaRotulacionDTO.setObservacion(UtilsStringFechas.convierteCadena(entrecalles + " " + ref, 150));
			etiquetaRotulacionDTO.setPais_des(UtilsStringFechas.convierteCadena(destino.getPais(), 60));
			etiquetaRotulacionDTO.setRfc_des("");
			etiquetaRotulacionDTO.setEmail_des("");
			etiquetaRotulacionDTO.setNacional("NACIONAL");
			
			
			etiquetaRotulacionDTO.setSiglasdestino(frecuencia_destino!=null?frecuencia_destino.getIdterminal():"");
			

			// Valida datos
			iRotulacionEtiquetasDatosBO.getArr_Transbordos(etiquetaRotulacionDTO);
			iRotulacionEtiquetasDatosBO.validaRegistro(etiquetaRotulacionDTO);
			if (etiquetaRotulacionDTO.getEsvalido() != 1) {
				throw new Exception(etiquetaRotulacionDTO.getMensajeError());
			}

			// Cobertura
			// Mapea los datos de las guias
			float peso = 0;
			float valor = 0;
			DetalleEnvio detalleEnvio = embarque.getDetalleEnvio();
			List<Paquete> paquetes = embarque.getPaquetes();
			for (Paquete paquete : paquetes) {
				validaRequerido(paquete.getPaqueteID(), "PAQUETE ID IVALIDO");
				validaRequerido(paquete.getDescripcionMercancia(), "DESCRIPCION PAQUETE IVALIDA");
				
				if (paquete.getCantidad()<=0) {
					throw new Exception("CANTIDAD MERCANCIA INVALIDA.");
				}
				if (paquete.getPeso()<=0) {
					throw new Exception("PESO MERCANCIA INVALIDA.");
				}
				if (paquete.getValor()<=0) {
					throw new Exception("VALOR MERCANCIA INVALIDA.");
				}
				if (!TipoMercancia.isCorrect(paquete.getTipoMercancia())) {
					throw new Exception("TIPO DE MERCANCIA " + paquete.getTipoMercancia() + ", INVALIDO");
				}
				
				peso = peso +  paquete.getPeso();
				valor = valor  + paquete.getValor();
			}
			if (paquetes.size() > 0) {
				etiquetaRotulacionDTO.setCantidad(paquetes.size());
			} else {
				throw new Exception("NUMERO DE PAQUETES INVALIDO");

			}

			etiquetaRotulacionDTO.setPesofisico(peso);
			etiquetaRotulacionDTO.setPesofisico_total(peso);
			etiquetaRotulacionDTO.setPesomayor(peso);
			etiquetaRotulacionDTO.setValordeclarado(valor);
			

			String uuid = UUIDUniqueCreator.generateUUID();
			List<EtiquetaRotulacionDTO> lista_registros = new ArrayList<EtiquetaRotulacionDTO>();
			lista_registros.add(etiquetaRotulacionDTO);

			List<Envio> arr_envios = new ArrayList<Envio>();
			iEtiquetasBO.creaEtiquetas(lista_registros, usuario, arr_envios, uuid, 0,
					cuentaconexion.getManejoporfoliosconvenio());

			CartaFacturaDetalle cartaFacturaDetalle = new CartaFacturaDetalle();

			cartaFacturaDetalle.setRazonexportacion(clave);
			cartaFacturaDetalle.setNombrecontacto(etiquetaRotulacionDTO.getContacto_des());
			cartaFacturaDetalle.setCallecontacto(etiquetaRotulacionDTO.getCalle_des());
			cartaFacturaDetalle.setColoniacontacto(etiquetaRotulacionDTO.getColonia_des());
			cartaFacturaDetalle.setCpcontacto(etiquetaRotulacionDTO.getCp_des());
			cartaFacturaDetalle.setCiudadcontacto(etiquetaRotulacionDTO.getMunicipio_des());

			// Inserta el registro de carta porte y detalle
			if (arr_envios.size() > 0) {
				for (Envio envio : arr_envios) {
					cartaFacturaDetalle.setIddocumento(envio.getIdEnvio());
					iCartaPorteBO.insertCartaFacturaDocumento(cartaFacturaDetalle);
					for (Paquete paquete : paquetes) {
						cartaFacturaDetalle.setCantidad(paquete.getCantidad());
						cartaFacturaDetalle.setValor_unitario(paquete.getValor());
						cartaFacturaDetalle.setVoumen(paquete.getVolumen());
						cartaFacturaDetalle.setPeso(paquete.getPeso());
						cartaFacturaDetalle.setTipo_mercancia(paquete.getTipoMercancia());
						cartaFacturaDetalle.setDescripcion_mercancia(paquete.getDescripcionMercancia());
						cartaFacturaDetalle.setPaqueteid(paquete.getPaqueteID());
						iCartaPorteBO.insertCartaFacturaDetalleDocumento(cartaFacturaDetalle);
					}
					break;
				}
			}

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json_data = gson.toJson(arr_envios);

			etiquetaRotulacionDTO.setJson_data(json_data);
			etiquetaRotulacionDTO.setLogin(usuario.getLogin());
			etiquetaRotulacionDTO.setUuid(cartaFacturaDetalle.getIddocumento());
			etiquetaRotulacionDTO.setNacional("NACIONAL");
			// Genera el id y lo guarda
			iRotulacionEtiquetasDatosBO.insertRotulacionEtiquetasGeneradas(etiquetaRotulacionDTO);
			// Devuelve la guia creada
			guiaEmbarqueResponse.setGuiaReferencia(cartaFacturaDetalle.getIddocumento());
		} catch (Exception e) {
			logger.debug("Error generarGuiaEmbarque:" + e.getMessage());
			e.printStackTrace();
			guiaEmbarqueResponse.setGuiaReferencia("ERROR " + e.getMessage());
			
		}
		return guiaEmbarqueResponse;
	}
	
	@RequestMapping(value = "/generarEtiquetaGuia", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public @ResponseBody GuiaEmbarqueResponse generarEtiquetaGuia(@RequestBody ConsultarTracking consultarTracking) {
		GuiaEmbarqueResponse obj = new GuiaEmbarqueResponse();
		System.out.println("generarEtiquetaGuia");

		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setLogin(UtilsStrings.nullChangeToUpperCase(consultarTracking.getUsuario()));
		usuario.setPassword(UtilsStrings.nullChangeToUpperCase(consultarTracking.getContrasena()));

		try {
			usuario = iusuarioBO.getUsuarioLogin(usuario);
			DocumentoConsultaDTO documento = iDocumentoServicioBO.getInfoGuia(consultarTracking.getGuiasEmbarque());
			if (documento == null) {
				throw new Exception("GUIA " + consultarTracking.getGuiasEmbarque() + " NO EXISTE.");
			}else{
				String[] arr_estatus = documento.getEstatus().split(",");
				if ("CANCELADA".equals(arr_estatus[0])) {
					throw new Exception("LA GUIA " + consultarTracking.getGuiasEmbarque() + " YA FUE CANCELADA.");
				}

				List<LogHistoriaDTO> historial = iDocumentoServicioBO
						.getHistoriaDocumento(consultarTracking.getGuiasEmbarque(), usuario);
				
				for (LogHistoriaDTO logHistoriaDTO : historial) {
					if ("CL".equals(logHistoriaDTO.getTipomovimiento())){
						throw new Exception("LA GUIA " + consultarTracking.getGuiasEmbarque() + " FUE CANCELADA ANTERIORMENTE.");
					}
				}
				
			}

			byte[] bytes = null;
			String archivo = "";

			List<EtiquetaRotulacionDTO> datos = iRotulacionEtiquetasDatosBO
					.getReimpresionRegistrosDatosEtiquetasJsonGeneradas(consultarTracking.getGuiasEmbarque());
			if ((datos == null) || (datos.size() <= 0)) {
				throw new Exception("GUIA " + consultarTracking.getGuiasEmbarque() + " NO EXISTE.");
			} else {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				Envio[] myTypes = gson.fromJson(datos.get(0).getJson_data(), Envio[].class);
				List<Envio> arr_envios = new ArrayList<Envio>();
				for (Envio envio : myTypes) {
					arr_envios.add(envio);
				}

				// Genera y obtiene el nombre del archivo
				archivo = iMuestraEtiquetasBO.generaPDFGuia(arr_envios, usuario, ConstantesGenerales._TIPOIMPRESION,
						ConstantesGenerales.ID_SKY4SOL, usuario.getFormatoetiperso());

				try {
					File f = new File(archivo);
					bytes = Files.getBytesFromFile(f);
					obj.setGenerarEtiquetaGuiaResult(bytes);
				} catch (Exception e) {
					
					logger.debug("Error al crear el PDF de las etiquetas:" + e.getMessage());
					throw new Exception(" AL crear el PDF de las etiquetas:" + e.getMessage());
				}

			}

		} catch (Exception e) {
			obj.setGenerarGuiaEmbarqueResult("ERROR " +  e.getMessage());
			logger.error("Error:" + e.getMessage());
		}

		return obj;
	}

	@RequestMapping(value = "/cancelarGuiaEmbarque", method = RequestMethod.POST)
	public @ResponseBody GuiaEmbarqueResponse cancelarGuiaEmbarque(@RequestBody ConsultarTracking consultarTracking) {
		GuiaEmbarqueResponse obj = new GuiaEmbarqueResponse();
		logger.debug("cancelarGuiaEmbarque");

		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setLogin(UtilsStrings.nullChangeToUpperCase(consultarTracking.getUsuario()));
		usuario.setPassword(UtilsStrings.nullChangeToUpperCase(consultarTracking.getContrasena()));
		
		try {
			usuario = iusuarioBO.getUsuarioLogin(usuario);
			String guia = consultarTracking.getGuiasEmbarque()==null?"":consultarTracking.getGuiasEmbarque().trim();
			if (guia.isEmpty()){
				throw new Exception(
						"DEBE INDICAR LA GUIA QUE DESEA CANCELAR");
			}
				
		
			DocumentoConsultaDTO documento = iDocumentoServicioBO.getInfoGuia(consultarTracking.getGuiasEmbarque());
			if (documento != null) {
				String[] arr_estatus = documento.getEstatus().split(",");
				if ("CANCELADA".equals(arr_estatus[0])) {
					throw new Exception("LA GUIA " + consultarTracking.getGuiasEmbarque() + " YA FUE CANCELADA.");
				}
				
				String quienrecibe = documento.getQuienRecibe() != null ? documento.getQuienRecibe().trim() : "";
				if (!quienrecibe.trim().isEmpty()) {
					throw new Exception(
							"LA GUIA " + consultarTracking.getGuiasEmbarque() + " SE ENCUENTRA CONFIRMADA DE ENTREGA");
				}
				
				
				List<LogHistoriaDTO> historial = iDocumentoServicioBO
						.getHistoriaDocumento(consultarTracking.getGuiasEmbarque(), usuario);
				
				for (LogHistoriaDTO logHistoriaDTO : historial) {
					if ("CL".equals(logHistoriaDTO.getTipomovimiento())){
						throw new Exception("LA GUIA " + consultarTracking.getGuiasEmbarque() + " FUE CANCELADA ANTERIORMENTE.");
					}
				}
				if (historial.size() > 0) {
					throw new Exception("LA GUIA " + consultarTracking.getGuiasEmbarque()
							+ " SE ENCUENTRA DENTRO DEL PROCESO LOGISTICO DE ENTREGA");
				}
				String foliocancelacion = Fechas.getFechaFormato("yyMMddhhmm");
				
				iDocumentoServicioBO.cancelaDocumento(consultarTracking.getGuiasEmbarque(), usuario, foliocancelacion);
				obj.setCancelarGuiaEmbarqueResult(foliocancelacion);

			}else{
				
				throw new Exception("LA GUIA " + consultarTracking.getGuiasEmbarque()
				+ " NO EXISTE REGISTRADA.");
			}
			
		} catch (Exception e) {
			obj.setCancelarGuiaEmbarqueResult("ERROR " + e.getMessage());
		}

		return obj;
	}
	
	@RequestMapping(value = "/validarCobertura", method = RequestMethod.POST)
	public @ResponseBody GuiaEmbarqueResponse validarCobertura(@RequestBody ConsultarTracking consultarTracking) {
		
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setLogin(UtilsStrings.nullChangeToUpperCase(consultarTracking.getUsuario()));
		usuario.setPassword(UtilsStrings.nullChangeToUpperCase(consultarTracking.getContrasena()));
		GuiaEmbarqueResponse obj = new GuiaEmbarqueResponse();
		
		logger.debug("validarCobertura");
		
		try {
			usuario = iusuarioBO.getUsuarioLogin(usuario);
			BusquedaDTO busquedaDTO = new BusquedaDTO();
			busquedaDTO.setNumcliente(usuario.getNumCliente());
			busquedaDTO.setIdentificador_str(usuario.getNumCliente());
			
			CuentasDTO cuenta = iBusquedaCuentasClientesBO.getDatosCliente(busquedaDTO);
			if (cuenta == null) {
				throw new Exception("NO EXISTEN DATOS DEL CLIENTE " + usuario.getNumCliente());
			}
			CuentasConexionMensajeriaDTO cuentaconexion = iBusquedaCuentasClientesBO.getDatosConexionCliente(busquedaDTO);
			if (cuentaconexion == null) {
				throw new Exception("NO EXISTEN DATOS DE CONEXION DEL CLIENTE " + usuario.getNumCliente());
			}

			if ((consultarTracking.getCodigoPostal() == null) || 
					(consultarTracking.getCodigoPostal().trim().isEmpty())) {
				throw new Exception("INDIQUE EL CODIGO POSTAL A CONSULTAR.");
			}

			
			String garantia = cuentaconexion.getIdservicio()!=null?cuentaconexion.getIdservicio().trim().charAt(0)+"":"";
			List<Frecuencias> lista = iBusquedaFrecuenciasBO.getFrecuenciasCP(consultarTracking.getCodigoPostal(), garantia, null);
			
		
			
			obj.setTieneCobetura(lista.size()>0?true:false);
			 
		}catch(Exception e){
			obj.setGenerarGuiaEmbarqueResult("ERROR " + e.getMessage());
			obj.setTieneCobetura(false);
		}
		
		

		return obj;
	}
	


	@RequestMapping(value = "/consultarTracking", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, headers = "Accept=application/json")
	public @ResponseBody GuiaEmbarqueResponse consultarTracking(@RequestBody ConsultarTracking consultarTracking) {
		
		logger.debug("consultarTracking");
		List<Tracking> arr_tracking = new ArrayList<Tracking>();

		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setLogin(UtilsStrings.nullChangeToUpperCase(consultarTracking.getUsuario()));
		usuario.setPassword(UtilsStrings.nullChangeToUpperCase(consultarTracking.getContrasena()));
		
		GuiaEmbarqueResponse guiaEmbarqueResponse = new GuiaEmbarqueResponse();
		HashMap<String, Tracking> _map = new HashMap<String, Tracking>();
		
		try {
			
			usuario = iusuarioBO.getUsuarioLogin(usuario);
			BusquedaDTO busquedaDTO = new BusquedaDTO();
			busquedaDTO.setNumcliente(usuario.getNumCliente());
			busquedaDTO.setIdentificador_str(usuario.getNumCliente());
			
			CuentasDTO cuenta = iBusquedaCuentasClientesBO.getDatosCliente(busquedaDTO);
			if (cuenta == null) {
				throw new Exception("NO EXISTEN DATOS DEL CLIENTE " + usuario.getNumCliente());
			}
			CuentasConexionMensajeriaDTO cuentaconexion = iBusquedaCuentasClientesBO.getDatosConexionCliente(busquedaDTO);
			if (cuentaconexion == null) {
				throw new Exception("NO EXISTEN DATOS DE CONEXION DEL CLIENTE " + usuario.getNumCliente());
			}
			
			String guiasEmbarque = consultarTracking.getGuiasEmbarque();
			if (guiasEmbarque!=null && !guiasEmbarque.isEmpty()){
				guiasEmbarque = UtilsStrings.eliminaDuplicados(guiasEmbarque, ",");
				guiasEmbarque = UtilsStrings.formateaCadenaComillas(guiasEmbarque);
				String[] arr_guiasEmbarque = guiasEmbarque.split(",");
				
				DocumentoDTO datos = new DocumentoDTO();
				datos.setIdDocumento(guiasEmbarque);
				usuario.entidad.setIdentidad(ConstantesAdminSale.CONSULTA_INTERNET);
				datos.setIdTipoDocumento(ConstantesGenerales._TIPODOCUMENTO);
				List<DocumentoConsultaDTO> lista = iDocumentoServicioBO.consulta(datos, 1, null, null, usuario);
				Tracking tracking = null;
				//Verifica si las guias estan en el orden que se solicitaron
				boolean encontrada = false;
				for (String guia : arr_guiasEmbarque) {
					encontrada = false;
					guia = UtilsStrings.quitaCaracteresEspeciales(guia).trim();

					for (DocumentoConsultaDTO documentoConsultaDTO : lista) {
						if (guia.equals(documentoConsultaDTO.getIdDocumento())){
							if (!usuario.getNumCliente().equals(documentoConsultaDTO.getNumCliente())){
								logger.debug("Guia:" + guia
							+ ",Cliente el usuario:"+usuario.getNumCliente() 
								+ ", Cliente Guia:" +  documentoConsultaDTO.getNumCliente() + " NO PERTENECE A ANDREA.");
								tracking.setEstatusGuia("GUIA NO PERTENECE A ANDREA");
							}else{
								encontrada = true;
								//Entrega
								
								if (documentoConsultaDTO.getQuienRecibe()!=null){
									tracking = new Tracking();
									tracking.setGuiaEmbarque(guia);
									tracking.setEstatusGuia("ENTREGADO");
									tracking.setPersonaRecibio(documentoConsultaDTO.getQuienRecibe());
									tracking.setFechaMovimiento(documentoConsultaDTO.getFechaConfirmacion());
									
									tracking.setTipoIdentificacion("");
									tracking.setIdentificacionID("");
									tracking.setObservaciones("");
									tracking.setUbicacion(documentoConsultaDTO.getPlazaEntrega());
									guiaEmbarqueResponse.getLista_trakings().add(tracking);
								
								}else{
									tracking = new Tracking();
									String[] arr_estatus = documentoConsultaDTO.getEstatus().split(",");
									tracking.setEstatusGuia(arr_estatus[0]);
									tracking.setGuiaEmbarque(guia);
									tracking.setPersonaRecibio("");
									tracking.setFechaMovimiento("");
									
									tracking.setTipoIdentificacion("");
									tracking.setIdentificacionID("");
									tracking.setObservaciones("");
									tracking.setUbicacion("");
									
									guiaEmbarqueResponse.getLista_trakings().add(tracking);
								}
								
								
								
								
								//Agrega la historia
								List<LogHistoriaDTO> historia = iDocumentoServicioBO.getHistoriaDocumento(guia, usuario);
								String hi_est= "";
								for (LogHistoriaDTO his : historia) {
									hi_est = his.getDescripcion_estatus()==null?"":his.getDescripcion_estatus();
									tracking = new Tracking();
									tracking.setEstatusGuia(hi_est.isEmpty()?his.getTipomovimiento():hi_est);
									tracking.setGuiaEmbarque(guia);
									tracking.setUbicacion(his.getPlazaorigina());
									tracking.setFechaMovimiento(his.getFecha());
									tracking.setTipoIdentificacion("");
									tracking.setIdentificacionID("");
									tracking.setPersonaRecibio("");
									tracking.setObservaciones("");
									tracking.setUbicacion("");
									guiaEmbarqueResponse.getLista_trakings().add(tracking);
								}
							}
							
						}
					}
					
					if (!encontrada){
						//Agrega la historia
						List<LogHistoriaDTO> historia = iDocumentoServicioBO.getHistoriaDocumento(guia, usuario);
						if (historia.size()>0){
							for (LogHistoriaDTO his : historia) {
								tracking = new Tracking();
								tracking.setEstatusGuia(his.getDescripcion_estatus());
								tracking.setGuiaEmbarque(guia);
								tracking.setUbicacion(his.getPlazaorigina());
								tracking.setFechaMovimiento(his.getFecha());
								tracking.setTipoIdentificacion("");
								tracking.setIdentificacionID("");
								tracking.setObservaciones("");
								tracking.setUbicacion("");
								guiaEmbarqueResponse.getLista_trakings().add(tracking);
							}
						}else{
							tracking = new Tracking();
							tracking.setEstatusGuia("NO REGISTRADA");
							tracking.setGuiaEmbarque(guia);
							tracking.setPersonaRecibio("");
							tracking.setFechaMovimiento("");
							
							tracking.setTipoIdentificacion("");
							tracking.setIdentificacionID("");
							tracking.setObservaciones("");
							tracking.setUbicacion("");
							guiaEmbarqueResponse.getLista_trakings().add(tracking);
						}
						
						
						
					}
					
					_map.put(guia,  new Tracking());
					
				}
				
				
				
			}
			
		}catch(Exception e){
			logger.debug("consultarTracking ERROR: " + e.getMessage());
		}
	
		return guiaEmbarqueResponse;
	}




	@RequestMapping(value = "/generarManifiestoGuia", method = RequestMethod.POST)
	public @ResponseBody GuiaEmbarqueResponse generarManifiestoGuia(@RequestBody ConsultarTracking consultarTracking) {
		GuiaEmbarqueResponse obj = new GuiaEmbarqueResponse();
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setLogin(UtilsStrings.nullChangeToUpperCase(consultarTracking.getUsuario()));
		usuario.setPassword(UtilsStrings.nullChangeToUpperCase(consultarTracking.getContrasena()));

		
		try {
			
			usuario = iusuarioBO.getUsuarioLogin(usuario);
			BusquedaDTO busquedaDTO = new BusquedaDTO();
			busquedaDTO.setNumcliente(usuario.getNumCliente());
			busquedaDTO.setIdentificador_str(usuario.getNumCliente());
			
			CuentasDTO cuenta = iBusquedaCuentasClientesBO.getDatosCliente(busquedaDTO);
			if (cuenta == null) {
				throw new Exception("NO EXISTEN DATOS DEL CLIENTE " + usuario.getNumCliente());
			}
			CuentasConexionMensajeriaDTO cuentaconexion = iBusquedaCuentasClientesBO.getDatosConexionCliente(busquedaDTO);
			if (cuentaconexion == null) {
				throw new Exception("NO EXISTEN DATOS DE CONEXION DEL CLIENTE " + usuario.getNumCliente());
			}
			
			String guiasEmbarque = consultarTracking.getGuiasEmbarque();
			if (guiasEmbarque!=null && !guiasEmbarque.isEmpty()){
				guiasEmbarque = UtilsStrings.eliminaDuplicados(guiasEmbarque, ",");
				String[] arr_guias = consultarTracking.getGuiasEmbarque().split(",");
				guiasEmbarque = UtilsStrings.formateaCadenaComillas(guiasEmbarque);
				   
				// Obtiene todos los parametros
				String numeroManifiesto = consultarTracking.getNumeroManifiesto()+"";
				Map<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("P_CHOFER", consultarTracking.getChofer());
				parameters.put("P_PLACAS", consultarTracking.getPlacas());
				parameters.put("P_CAMION", consultarTracking.getCamion());
				parameters.put("P_MANIFIESTO", numeroManifiesto );
				parameters.put("P_GUIAS", guiasEmbarque);
				
				
				//Crea los registros de manifiesto
				ManifiestoDTO manifiesto  = new ManifiestoDTO();
				manifiesto.setManifiesto(numeroManifiesto);
				
				//Indica el tipo de documento a afectar
				manifiesto.setTipoDocumento(ConstantesGenerales._TIPODOCUMENTO);   
				manifiestosBO.updateManifiestoRegistrosEtiquetas(
						manifiesto,usuario,arr_guias);
				
				//Indica el tipo de manifiesto	
				manifiesto.setTipoDocumento("MANIFIESTO_ANDREA");   
				
				byte[] bytes = manifiestosBO.generarManifiestoPDF(manifiesto,
						parameters, usuario);

				obj.setGenerarManifiestoGuiaResult(bytes);

				
			}
			
		}catch(Exception e){
			logger.debug("generarManifiestoGuia ERROR: " + e.getMessage());
			obj.setGenerarGuiaEmbarqueResult("ERROR " +  e.getMessage());
		}

		return obj;
		
	}


	@RequestMapping(value = "/validarConvenio", method = RequestMethod.POST)
	public @ResponseBody GuiaEmbarqueResponse validarConvenio(@RequestBody ConsultarTracking consultarTracking) {
		GuiaEmbarqueResponse obj = new GuiaEmbarqueResponse();
		logger.debug("validarConvenio");
		
		//TODO: para indicar error : obj.setGenerarGuiaEmbarqueResult("ERROR " + e.getMessage());
		return obj;
	}
	
	
	private String validaRequerido(String dato, String excepcion) throws Exception{
		String cadena = dato==null?"":dato.trim().toUpperCase();
		if (cadena.isEmpty()){
			throw new Exception(excepcion);
		}
		
		return cadena;
	}

}
