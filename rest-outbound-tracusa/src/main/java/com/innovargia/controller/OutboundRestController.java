package com.innovargia.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.dto.Folios;
import com.administracion.ibo.ICartaPorteBO;
import com.administracion.ibo.IDocumentoServicioBO;
import com.administracion.ibo.IEtiquetasBO;
import com.administracion.ibo.IFoliosBO;
import com.administracion.ibo.IMuestraEtiquetasBO;
import com.administracion.idao.IServiciosDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.innovargia.administracion.ibo.IAdminPasswordBO;
import com.innovargia.administracion.ibo.IUsuarioBO;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.model.Direccion;
import com.innovargia.model.GuiaEmbarque;
import com.innovargia.model.OutboundResponse;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CuentasConexionMensajeriaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IRotulacionEtiquetasDatosBO;
import com.innovargia.utils.Constantes;
import com.innovargia.utils.ExceptionTracking;
import com.innovargia.utils.Files;
import com.innovargia.utils.UUIDUniqueCreator;
import com.innovargia.utils.UtilsJson;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.UtilsStrings;

import com.servicio.constantes.ConstantesGenerales;
import com.servicio.search.ibo.IBusquedaCuentasClientesBO;
import com.servicio.search.ibo.IBusquedaFrecuenciasBO;

@Controller
@RequestMapping("/rest/outbound")
public class OutboundRestController {
	private static final Logger logger = LoggerFactory.getLogger(OutboundRestController.class);

	@Autowired
	IServiciosDao iServiciosDao;
	
	@Autowired
	IUsuarioBO iusuarioBO;
	

	@Autowired
	IFoliosBO iFoliosBO;

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
	IAdminPasswordBO iAdminPasswordBO;

	@RequestMapping(value = "/generarguia", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public @ResponseBody OutboundResponse generarGuiaEmbarque(@RequestBody GuiaEmbarque embarque) throws Exception {

		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setLogin(UtilsStrings.nullChangeToUpperCase(embarque.getLogin()));
		usuario.setPassword(embarque.getPassword());
		OutboundResponse responseOutbound = new OutboundResponse();

		try {
			// Usuarios
			usuario = isValidUser(usuario.getLogin(), usuario.getPassword(), usuario.getNumCliente());
			
			// Realiza la busqueda
			if (usuario == null) {
				new  ExceptionTracking(Constantes.CODIGO_ACCESOINVALIDO,Constantes.MSG_ERROR_DATOS_INVALIDOS );
			}

		
			
			int identidad = usuario.entidad.getIdentidad();
			int idorganizacion = usuario.organizacion.getIdorganizacion();
		
			//Verifica si hay folios
			Folios folio = iFoliosBO.getFoliosDisponibles(embarque.getIdservicio(), usuario.getNumCliente(),
					0, identidad, idorganizacion);

			if (folio == null) {
				throw new Exception("FOLIO NO HA SIDO DEFINIDO EN LA TABLA DE FOLIOS.");
			}
			

			usuario.entidad.setIdentidad(identidad);
			usuario.organizacion.setIdorganizacion(idorganizacion);

			EtiquetaRotulacionDTO etiquetaRotulacionDTO = new EtiquetaRotulacionDTO();
			etiquetaRotulacionDTO.setPesobase(folio.getPeso());
			etiquetaRotulacionDTO.setIdservicio(embarque.getIdservicio());
			etiquetaRotulacionDTO.setServiciotarifa(embarque.getIdservicio());

			// Remitente
			Direccion remite = embarque.getDestinatario();
			String contacto = UtilsStringFechas.convierteCadenaNULL(remite.getContacto(), 50);

			etiquetaRotulacionDTO.setContacto_rem(contacto);
			etiquetaRotulacionDTO.setNumexterior_rem(remite.getNumexterior());
			etiquetaRotulacionDTO.setNuminterior_rem(remite.getNuminterior());
			
			etiquetaRotulacionDTO.setCalle_rem(UtilsStringFechas.convierteCadena(remite.getCalle(), 100));
			etiquetaRotulacionDTO.setColonia_rem(UtilsStringFechas.convierteCadena(remite.getColonia(), 100));
			etiquetaRotulacionDTO.setCp_rem(UtilsStringFechas.convierteCadena(remite.getCodigoPostal(), 5));
			etiquetaRotulacionDTO.setMunicipio_des(UtilsStringFechas.convierteCadena(remite.getCiudad(), 50));
			etiquetaRotulacionDTO.setEstado_rem(UtilsStringFechas.convierteCadena(remite.getEstado(), 50));
			etiquetaRotulacionDTO.setCiudad_rem(UtilsStringFechas.convierteCadena(remite.getCiudad(), 50));
			etiquetaRotulacionDTO.setTelefono_rem(UtilsStringFechas.convierteCadena(remite.getTelefono(), 22));
			etiquetaRotulacionDTO.setPais_rem(UtilsStringFechas.convierteCadena(remite.getPais(), 60));
			etiquetaRotulacionDTO.setRfc_rem("");
			etiquetaRotulacionDTO.setEmail_rem("");
			etiquetaRotulacionDTO.setNacional("NACIONAL");

			// Destino
			Direccion destino = embarque.getDestinatario();

			String tel = destino.getTelefono() == null ? "" : destino.getTelefono();
			String ref = destino.getReferencia() == null ? "" : destino.getReferencia();
			String idconvenio = destino.getConvenio() == null ? "" : destino.getConvenio();

			// Obligatorios opcionales
			destino.setReferencia(ref);
			destino.setTelefono(tel);

			validaRequerido(destino.getCodigoPostal(), "CODIGO POSTAL INVALIDO");
			validaRequerido(destino.getCalle(), "CALLE INVALIDA");
			// validaRequerido(destino.getEntreCalles(), "ENTRE CALLES
			// INVALIDA");
			validaRequerido(destino.getColonia(), "COLONIA INVALIDA");
			validaRequerido(destino.getCiudad(), "CIUDAD INVALIDA");
			validaRequerido(destino.getEstado(), "ESTADO INVALIDO");
			validaRequerido(destino.getPais(), "PAIS INVALIDO");

			String ref_guia = embarque.getReferencia() == null ? "" : embarque.getReferencia();
			etiquetaRotulacionDTO.setReferencia(ref_guia);

			Frecuencias frecuencia_destino = iBusquedaFrecuenciasBO.getFrecuenciasEntregaCP(destino.getCodigoPostal());
			if (frecuencia_destino == null) {
				throw new Exception("NO EXISTE FRECUENCIA DE ENTREGA PARA EL CP " + destino.getCodigoPostal());
			}

			// Destino
			contacto = UtilsStringFechas.convierteCadenaNULL(destino.getContacto(), 50);

			String clave = UtilsStringFechas.convierteCadenaNULL(destino.getClaveCliente(), 10) + " "
					+ UtilsStringFechas.convierteCadenaNULL(idconvenio, 30); // +


			etiquetaRotulacionDTO.setRazonsocial_des(clave);
			etiquetaRotulacionDTO.setContacto_des(contacto);

			
			etiquetaRotulacionDTO.setContacto_rem(contacto);
			etiquetaRotulacionDTO.setNumexterior_rem(destino.getNumexterior());
			etiquetaRotulacionDTO.setNuminterior_rem(destino.getNuminterior());

			etiquetaRotulacionDTO.setCalle_des(UtilsStringFechas.convierteCadena(destino.getCalle(), 100));
			etiquetaRotulacionDTO.setColonia_des(UtilsStringFechas.convierteCadena(destino.getColonia(), 100));
			etiquetaRotulacionDTO.setCp_des(UtilsStringFechas.convierteCadena(destino.getCodigoPostal(), 5));
			etiquetaRotulacionDTO.setMunicipio_des(UtilsStringFechas.convierteCadena(destino.getCiudad(), 50));
			etiquetaRotulacionDTO.setEstado_des(UtilsStringFechas.convierteCadena(destino.getEstado(), 50));
			etiquetaRotulacionDTO.setCiudad_des(UtilsStringFechas.convierteCadena(destino.getCiudad(), 50));
			etiquetaRotulacionDTO.setTelefono_des(UtilsStringFechas.convierteCadena(destino.getTelefono(), 22));

			etiquetaRotulacionDTO.setPais_des(UtilsStringFechas.convierteCadena(destino.getPais(), 60));
			etiquetaRotulacionDTO.setRfc_des("");
			etiquetaRotulacionDTO.setEmail_des("");
			etiquetaRotulacionDTO.setNacional("NACIONAL");


			etiquetaRotulacionDTO
					.setSiglasdestino(frecuencia_destino != null ? frecuencia_destino.getIdterminal() : "");
			etiquetaRotulacionDTO.setObservacion(embarque.getObservaciones());

			// Valida datos
			iRotulacionEtiquetasDatosBO.getArr_Transbordos(etiquetaRotulacionDTO);
			iRotulacionEtiquetasDatosBO.validaRegistro(etiquetaRotulacionDTO);
			if (etiquetaRotulacionDTO.getEsvalido() != 0) {
				throw new Exception(etiquetaRotulacionDTO.getMensajeError());
			}

			etiquetaRotulacionDTO.setCantidad(embarque.getPaquete().getCantidad());
			
			
			
			etiquetaRotulacionDTO.setFactura(embarque.getPaquete().getFactura());
			etiquetaRotulacionDTO.setPesofisico(embarque.getPaquete().getPeso());
				etiquetaRotulacionDTO.setPesomayor(embarque.getPaquete().getPeso()>embarque.getPaquete().getVolumen()?
					embarque.getPaquete().getPeso():embarque.getPaquete().getVolumen());
			etiquetaRotulacionDTO.setValordeclarado(embarque.getPaquete().getValor());
			etiquetaRotulacionDTO.setEs_multiple(embarque.getPaquete().isEsmultiple()?"SI":"NO");
			if (embarque.getPaquete().isAsegurarlo()){
				if (embarque.getPaquete().getValor()<=0){
					throw new Exception("VALOR DEL CONTENIDO DEL ENVIO NO DEBE SER CERO CUANDO SE REQUIERE ASEGURAR.");
				}
				etiquetaRotulacionDTO.setValor_asegurado(embarque.getPaquete().getValor());	
			}else{
				etiquetaRotulacionDTO.setValor_asegurado(0);	
			}
			
			etiquetaRotulacionDTO.setDescripcion_servicio(iServiciosDao.getDesTipoServicio(embarque.getIdservicio()) );
			etiquetaRotulacionDTO.setDescripciongarantia(iServiciosDao.getDesGarantia(embarque.getIdservicio()));
			
			
			String uuid = UUIDUniqueCreator.generateUUID();
			List<EtiquetaRotulacionDTO> lista_registros = new ArrayList<EtiquetaRotulacionDTO>();
			lista_registros.add(etiquetaRotulacionDTO);

			List<Envio> arr_envios = new ArrayList<Envio>();
			iEtiquetasBO.creaEtiquetas(lista_registros, usuario, arr_envios, uuid, 0,
					ConstantesGenerales.MANEJO_FOLIOS);

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json_data = gson.toJson(arr_envios);

			etiquetaRotulacionDTO.setJson_data(json_data);
			
			etiquetaRotulacionDTO.setLogin(usuario.getLogin());
			etiquetaRotulacionDTO.setNacional("NACIONAL");
			
			
			// Genera el id y lo guarda
			iRotulacionEtiquetasDatosBO.insertRotulacionEtiquetasGeneradas(etiquetaRotulacionDTO);
			
			//Checa la cantidad de guias
			String arr_guias = "";
			for (Envio envio : arr_envios) {
				arr_guias = arr_guias + envio.getIdEnvio();
			}
			arr_guias = arr_guias.trim().replace(" ", ",");
			responseOutbound.setGuia(arr_guias);

			// Genera y obtiene el nombre del archivo
			byte[] bytes = null;
			String archivo = iMuestraEtiquetasBO.generaPDFGuia(arr_envios, usuario, ConstantesGenerales._TIPOIMPRESION,
					ConstantesGenerales.ID_SKY4SOL, usuario.getFormatoetiperso());

			File f = new File(archivo);
			bytes = Files.getBytesFromFile(f);
			responseOutbound.setPdf(bytes);
			
			responseOutbound.setCodigo(Constantes.CODIGO_EXITO);
			responseOutbound.setMensaje(Constantes.MSG_EXITO);
			
		} catch (ExceptionTracking e) {
			logger.debug("Error ExceptionTracking:" + e.getMessage());
			responseOutbound.setCodigo(e.getCodigo());
			responseOutbound.setMensaje(e.getMessage());
		} catch (Exception e) {
			logger.debug("Exception generarGuiaEmbarque:" + e.getMessage());
			responseOutbound.setCodigo(Constantes.CODIGO_ERROR_SISTEMA);
			responseOutbound.setMensaje(e.getMessage());
			e.printStackTrace();

		}
		return responseOutbound;
	}

	private String validaRequerido(String dato, String excepcion) throws Exception {
		String cadena = dato == null ? "" : dato.trim().toUpperCase();
		if (cadena.isEmpty()) {
			throw new Exception(excepcion);
		}

		return cadena;
	}

	
	private UsuarioDTO isValidUser(String login, String password, String numcliente) throws Exception {
		
		UsuarioDTO usuario = new UsuarioDTO();
	 	usuario.setLogin(UtilsStrings.nullChangeToUpperCase(login));
	 	usuario.setPassword(password);
		boolean existeUsuario = iAdminPasswordBO.existeLoginPass(usuario.getLogin(), 
				usuario.getPassword());
		
		if (!existeUsuario) {
			throw new ExceptionTracking(Constantes.CODIGO_ACCESOINVALIDO,
					Constantes.ACCESOINVALIDO_MSG);
		}

		com.innovargia.salesmanager.dtos.UsuarioDTO user = iusuarioBO.getUsuarioLogin(usuario); 
		if ("C".equals(user.getEstado())){
			throw new ExceptionTracking(Constantes.CODIGO_ACCESOINVALIDO,
					"USUARIO DADO DE BAJA");
		}

		return user;
	}

}
