/**
 * 
 */
package com.innovargia.administracion.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.administracion.idao.IParamsSistemaDAO;
import com.besmx.www3.ArrayOfObtenerDatos;
import com.besmx.www3.ObtenerDatos;
import com.besmx.www3.WebServicePaqueteria;
import com.besmx.www3.WebServicePaqueteriaSoap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IRotulacionEtiquetasDatosBO;
import com.innovargia.salesmanager.json.EtiquetaRotulacionDTOJSON;
import com.innovargia.utils.ConstantesAutoDoc;
import com.innovargia.utils.Utils;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.UtilsStrings;
import com.innovargia.utils.sql.ExcepcionMessage;
import com.servicio.constantes.ConstantesGenerales;

import ar.com.unisolutions.bo.IDireccioneBO;

/**
 * /rotular_etiquetas_importar/uploadRowsJsonFile
 * 
 * @author Adri�n /rotular_etiquetas_importar/insertLineaImportarJson
 */
@RequestMapping("/rotular_etiquetas_importar")
@Controller
public class RotularImportarEtiquetasController {

	private static final Logger logger = LoggerFactory.getLogger(RotularImportarEtiquetasController.class);

	@Autowired
	IRotulacionEtiquetasDatosBO bo;

	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;

	@Autowired
	IDireccioneBO iDireccioneBO;

	/**
	 *  
	 */
	public RotularImportarEtiquetasController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Obtiene las lineas que se configuraron para rotular
	 */
	@RequestMapping(value = "/getDatosRegistro", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Map<String, ? extends Object> getDatosRegistro(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiqueta, HttpServletRequest request) throws Exception {

		String mensaje = null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		EtiquetaRotulacionDTOJSON dtoJSON = new EtiquetaRotulacionDTOJSON();
		List<EtiquetaRotulacionDTO> lista = null;
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {

			if (usuario == null) {
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			lista = bo.getRegistrosDatos(etiqueta);
			List<EtiquetaRotulacionDTO> lista_final = new ArrayList<EtiquetaRotulacionDTO>();
			// Valida los datos
			EtiquetaRotulacionDTO eti = new EtiquetaRotulacionDTO();
			for (EtiquetaRotulacionDTO etiquetaRotulacionDTO : lista) {

				if (etiquetaRotulacionDTO.getJson_data() != null) {
					eti = dtoJSON.deserializaJSONtoObject(etiquetaRotulacionDTO.getJson_data());
					eti.setIdregistro(etiquetaRotulacionDTO.getIdregistro());
					eti.setIdregistrodatos(etiquetaRotulacionDTO.getIdregistrodatos());
					lista_final.add(eti);
				}

			}
			// Valida los datos finales
			bo.validaRegistrosImport(lista_final);

			// Agrega un nuevo registro vacio
			/*
			 * eti = new EtiquetaRotulacionDTO(); eti.setIdregistro("99999999");
			 * eti.setIdregistrodatos(999999); eti.setEsvalido(0); lista_final.add(eti);
			 */

			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista_final.size());
			modelMap.put("proxiArray", lista_final);

		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;

	}

	/***
	 * INserta un registro o registros que vienen de un JSON
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/insertLineaImportarJson", method = RequestMethod.POST, headers = {
			"content-type=application/json" })
	public @ResponseBody Map<String, ? extends Object> insertLineaImportarJson(@RequestBody String json,
			HttpServletRequest request) {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<EtiquetaRotulacionDTO> listaregistros = new ArrayList<EtiquetaRotulacionDTO>();
		String mensaje = "";
		EtiquetaRotulacionDTOJSON dtoJSON = new EtiquetaRotulacionDTOJSON();
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		logger.debug("json:" + json);
		UtilsRequest.displayParametros(request);
		try {

			// Trata de machear la lista de registos
			dtoJSON.runJSONParser(json);
			if (dtoJSON.getData().size() == 0) {
				// sustituye data por registro y vuelve hacer el parseo
				json = json.replaceAll("proxiArray", "registro");
				dtoJSON.runJSONParser(json);
				listaregistros.add(dtoJSON.getRegistro());
			} else {
				listaregistros = dtoJSON.getData();
			}
			int idregistro = -1;
			String uuid = request.getParameter("uuid");
			String idservicio = request.getParameter("idservicio");

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jsonOutput = "";
			String manejo_por_folios_o_convenios = iParamsSistemaDAO.getValorPropiedad(
					ConstantesGenerales.MANEJO_POR_FOLIOS_O_CONVENIOS, ConstantesGenerales.ID_SKY4SOL);

			for (EtiquetaRotulacionDTO etiquetaDTO : listaregistros) {
				if (etiquetaDTO.getIdregistro() <= 0) {
					// Crea un registro
					if (usuario == null) {
						throw new Exception(ConstantesAutoDoc.MSG_SESSION_FINISH);
					}

					etiquetaDTO.setUuid(uuid);
					etiquetaDTO.setIdservicio(idservicio);
					etiquetaDTO.setIdtipodocumento("ROTULACION");
					etiquetaDTO.setLogin(usuario.getLogin());
					etiquetaDTO.setIdentidad(usuario.entidad.getIdentidad());
					etiquetaDTO.setTiporotucacion(manejo_por_folios_o_convenios);
					etiquetaDTO.setIdorganizacion(usuario.organizacion.getIdorganizacion());
					etiquetaDTO.setNumcliente(usuario.getNumCliente() == null ? "" : usuario.getNumCliente());

					if (!manejo_por_folios_o_convenios.equals(ConstantesGenerales.MANEJO_FOLIOS)) {
						String[] convenio_tarifa = etiquetaDTO.getIdservicio().split("-");
						if (convenio_tarifa.length > 1) {
							etiquetaDTO.setIdconvenio(convenio_tarifa[0]);
							etiquetaDTO.setIdtarifa(convenio_tarifa[1]);
							etiquetaDTO.setIdconveniodetalle(convenio_tarifa[2]);
							etiquetaDTO.setIdservicio(convenio_tarifa[3]);
						}

					}

					// Obtiene el json del objeto
					jsonOutput = gson.toJson(etiquetaDTO);
					etiquetaDTO.setJson_data(jsonOutput);

					idregistro = bo.insert(etiquetaDTO);
					etiquetaDTO.setIdregistro(idregistro);
				}

			}

			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

		} catch (Exception e) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(e.getMessage());
			if (e.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}
			modelMap.put("message", mensaje);

		}

		dtoJSON.clearData();

		listaregistros.clear();
		return modelMap;
	}

	/***
	 * INserta un registro o registros que vienen de un JSON
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/deleteLineaImportarJson", method = RequestMethod.POST, headers = {
			"content-type=application/json" })
	public @ResponseBody Map<String, ? extends Object> deleteLineaImportarJson(@RequestBody String json,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<EtiquetaRotulacionDTO> listaregistros = new ArrayList<EtiquetaRotulacionDTO>();
		String mensaje = "";
		EtiquetaRotulacionDTOJSON dtoJSON = new EtiquetaRotulacionDTOJSON();
		logger.debug("json:" + json);

		try {
			// Trata de machear la lista de registos
			dtoJSON.runJSONParser(json);
			if (dtoJSON.getData().size() == 0) {
				// sustituye data por registro y vuelve hacer el parseo
				json = json.replaceAll("proxiArray", "registro");
				dtoJSON.runJSONParser(json);
				listaregistros.add(dtoJSON.getRegistro());
			} else {
				listaregistros = dtoJSON.getData();
			}

			for (int i = 0; i < listaregistros.size(); i++) {
				bo.deleteLinea(listaregistros.get(i));
			}
			mensaje = "Se borro el registro con exito";
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(e.getMessage());
			if (e.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}

		}

		dtoJSON.clearData();

		result.put("message", mensaje);
		result.put("mensaje", mensaje);
		listaregistros.clear();
		return result;
	}

	@RequestMapping(value = "/procesarRegistrosCorrectos", method = { RequestMethod.GET,
			RequestMethod.POST }, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody Map<String, ? extends Object> procesarRegistrosCorrectos(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiqueta, HttpServletRequest request) throws Exception {

		String mensaje = null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		EtiquetaRotulacionDTOJSON dtoJSON = new EtiquetaRotulacionDTOJSON();
		List<EtiquetaRotulacionDTO> lista = null;
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {

			if (usuario == null) {
				modelMap.put("message", ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			lista = bo.getRegistrosDatos(etiqueta);
			List<EtiquetaRotulacionDTO> lista_final = new ArrayList<EtiquetaRotulacionDTO>();
			// Valida los datos
			EtiquetaRotulacionDTO eti = new EtiquetaRotulacionDTO();
			for (EtiquetaRotulacionDTO etiquetaRotulacionDTO : lista) {

				if (etiquetaRotulacionDTO.getJson_data() != null) {
					eti = dtoJSON.deserializaJSONtoObject(etiquetaRotulacionDTO.getJson_data());
					eti.setIdregistro(etiquetaRotulacionDTO.getIdregistro());
					eti.setIdregistrodatos(etiquetaRotulacionDTO.getIdregistrodatos());
					// valida y crea el registro para rotulaci�n
					bo.validaRegistro(eti);
					if (eti.getEsvalido() == 0) {
						bo.update(eti);
						// Agrega los registros de volumne-contenido, seguro, observaciones
						for (int i = 0; i < eti.getNumpiezas(); i++) {
							bo.insertLineaVolumenCOD(eti);
						}

					} else {
						// Borra el registro
						// logger.debug("Borrar registro con error id:" + eti.getIdregistrodatos());
						bo.deleteLinea(eti);
					}

				}

			}

			// Agrega un nuevo registro vacio
			/*
			 * eti = new EtiquetaRotulacionDTO(); eti.setIdregistro("99999999");
			 * eti.setIdregistrodatos(999999); eti.setEsvalido(0); lista_final.add(eti);
			 */

			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista_final.size());
			modelMap.put("proxiArray", lista_final);

		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;

	}

	@RequestMapping(value = "/uploadRowsJsonFile", method = RequestMethod.POST, headers = {
			"content-type=application/json" })
	public @ResponseBody Map<String, ? extends Object> uploadRowsJsonFile(@RequestBody String json,
			HttpServletRequest request) {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UtilsRequest.displayParametros(request);

		String mensaje = "";

		try {

			EtiquetaRotulacionDTOJSON dtoJSON = new EtiquetaRotulacionDTOJSON();
			List<EtiquetaRotulacionDTO> listaregistros = new ArrayList<EtiquetaRotulacionDTO>();
			json = json.replaceAll("datos", "proxiArray");

			int lineas_max_archivo = iParamsSistemaDAO.getValorPropiedadInt(ConstantesGenerales.LINEAS_PERMITIDAS_EXCEL_ROTULACION, ConstantesGenerales.ID_SKY4SOL);

			dtoJSON.runJSONParser(json);
			
			if (dtoJSON.getData().size() >= 0) {
				
				listaregistros = dtoJSON.getData();
				
			} else {
				
				throw new Exception("No existe informacion que exportar.");
				
			}
			
			if (listaregistros.size() > lineas_max_archivo) {
				
				// Solo se toman los primeros lineas_max_archivo registros
				List<EtiquetaRotulacionDTO> listaregistros_tmp = new ArrayList<EtiquetaRotulacionDTO>();
				
				for (EtiquetaRotulacionDTO etiquetaRotulacionDTO : listaregistros) {
					
					if (listaregistros_tmp.size() >= lineas_max_archivo) {
						
						break;
						
					}
					
					listaregistros_tmp.add(etiquetaRotulacionDTO);

				}
				
				listaregistros.clear();
				
				for (EtiquetaRotulacionDTO etiquetaRotulacionDTO : listaregistros_tmp) {
					
					listaregistros.add(etiquetaRotulacionDTO);
					
				}
				
				listaregistros_tmp.clear();

				mensaje = ":Archivo contiene m�s l�neas de las permitidas, se tom�n solo las primeras "
						+ lineas_max_archivo;
			}

			// Agrega el registro

			String uuid = request.getParameter("identificador");
			String idservicio = request.getParameter("idtipodocumento");
			String manejo_por_folios_o_convenios = iParamsSistemaDAO.getValorPropiedad(
					ConstantesGenerales.MANEJO_POR_FOLIOS_O_CONVENIOS, ConstantesGenerales.ID_SKY4SOL);

			UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
			int idregistro = -1;
			EtiquetaRotulacionDTO etiquetaDTO_delete = new EtiquetaRotulacionDTO();
			etiquetaDTO_delete.setUuid(uuid);
			bo.deleteRegistrosUUID(etiquetaDTO_delete);

			// logger.debug("Inicia importacion de archivo");
			// List<EtiquetaRotulacionDTO> lista = bo.importFie(uploadItem);
			// logger.debug("Termina importacion de archivo");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jsonOutput = "";

			for (EtiquetaRotulacionDTO etiquetaDTO : listaregistros) {
				idregistro = -1;
				etiquetaDTO.setUuid(uuid);
				etiquetaDTO.setIdservicio(idservicio);
				etiquetaDTO.setIdtipodocumento("ROTULACION");
				etiquetaDTO.setLogin(usuario.getLogin());
				etiquetaDTO.setIdentidad(usuario.entidad.getIdentidad());
				etiquetaDTO.setTiporotucacion(manejo_por_folios_o_convenios);
				etiquetaDTO.setIdorganizacion(usuario.organizacion.getIdorganizacion());
				etiquetaDTO.setNumcliente(usuario.getNumCliente() == null ? "" : usuario.getNumCliente());

				if (!manejo_por_folios_o_convenios.equals(ConstantesGenerales.MANEJO_FOLIOS)) {
					String[] convenio_tarifa = etiquetaDTO.getIdservicio().split("-");
					if (convenio_tarifa.length > 1) {
						etiquetaDTO.setIdconvenio(convenio_tarifa[0]);
						etiquetaDTO.setIdtarifa(convenio_tarifa[1]);
						etiquetaDTO.setIdconveniodetalle(convenio_tarifa[2]);
						etiquetaDTO.setIdservicio(convenio_tarifa[3]);
					}

				}

				if (UtilsStrings.isVacio(etiquetaDTO.getRfc_des())) {

					etiquetaDTO.setRfc_des("XAXX010101000");

				}

				etiquetaDTO.setIdRmDes_des(iDireccioneBO.getDirection(etiquetaDTO));

				jsonOutput = gson.toJson(etiquetaDTO);
				etiquetaDTO.setJson_data(jsonOutput);

				idregistro = bo.insert(etiquetaDTO);
				etiquetaDTO.setIdregistro(idregistro);

			}

			modelMap.put("success", true);
			modelMap.put("message", "Correcto" + mensaje);

		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("message", ExcepcionMessage.getMessageExcepcion(e.getMessage()));

		}

		return modelMap;
	}

	@RequestMapping(value = "/uploadEnviosExcel", method = RequestMethod.POST)
	public @ResponseBody Map<String, ? extends Object> upload(
			// @RequestParam(value = "file_upload", required = false) FileBean uploadItem,
			@RequestParam(value = "file_upload", required = false) MultipartFile uploadItem,
			// @RequestParam(value = "extenciones_validas", required = false) String
			// extenciones_validas,
			// BindingResult result,
			HttpServletRequest request) {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		try {
			EtiquetaRotulacionDTOJSON dtoJSON = new EtiquetaRotulacionDTOJSON();
			String uuid = request.getParameter("identificador");
			String idservicio = request.getParameter("idtipodocumento");
			String manejo_por_folios_o_convenios = iParamsSistemaDAO.getValorPropiedad(
					ConstantesGenerales.MANEJO_POR_FOLIOS_O_CONVENIOS, ConstantesGenerales.ID_SKY4SOL);

			UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
			int idregistro = -1;
			EtiquetaRotulacionDTO etiquetaDTO_delete = new EtiquetaRotulacionDTO();
			etiquetaDTO_delete.setUuid(uuid);
			bo.delete(etiquetaDTO_delete);

			logger.debug("Inicia importacion de archivo");
			List<EtiquetaRotulacionDTO> lista = bo.importFie(uploadItem);
			logger.debug("Termina importacion de archivo");
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jsonOutput = "";

			for (EtiquetaRotulacionDTO etiquetaDTO : lista) {
				idregistro = -1;
				etiquetaDTO.setUuid(uuid);
				etiquetaDTO.setIdservicio(idservicio);
				etiquetaDTO.setIdtipodocumento("ROTULACION");
				etiquetaDTO.setLogin(usuario.getLogin());
				etiquetaDTO.setIdentidad(usuario.entidad.getIdentidad());
				etiquetaDTO.setTiporotucacion(manejo_por_folios_o_convenios);
				etiquetaDTO.setIdorganizacion(usuario.organizacion.getIdorganizacion());
				etiquetaDTO.setNumcliente(usuario.getNumCliente() == null ? "" : usuario.getNumCliente());

				if (!manejo_por_folios_o_convenios.equals(ConstantesGenerales.MANEJO_FOLIOS)) {
					String[] convenio_tarifa = etiquetaDTO.getIdservicio().split("-");
					if (convenio_tarifa.length > 1) {
						etiquetaDTO.setIdconvenio(convenio_tarifa[0]);
						etiquetaDTO.setIdtarifa(convenio_tarifa[1]);
						etiquetaDTO.setIdconveniodetalle(convenio_tarifa[2]);
						etiquetaDTO.setIdservicio(convenio_tarifa[3]);
					}

				}

				jsonOutput = gson.toJson(etiquetaDTO);
				etiquetaDTO.setJson_data(jsonOutput);

				idregistro = bo.insert(etiquetaDTO);
				etiquetaDTO.setIdregistro(idregistro);

			}

			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("message", ExcepcionMessage.getMessageExcepcion(e.getMessage()));

		}

		return modelMap;
	}

	@RequestMapping(value = "/exportaInfoExcel", method = { RequestMethod.GET,
			RequestMethod.POST }, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public ModelAndView exportaInfoExcel(ModelAndView modelAndView,
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiqueta, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		List<EtiquetaRotulacionDTO> lista_final = new ArrayList<EtiquetaRotulacionDTO>();
		try {

			if (usuario == null) {
				throw new Exception(ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			EtiquetaRotulacionDTOJSON dtoJSON = new EtiquetaRotulacionDTOJSON();

			List<EtiquetaRotulacionDTO> lista = bo.getRegistrosDatos(etiqueta);
			EtiquetaRotulacionDTO eti = new EtiquetaRotulacionDTO();
			for (EtiquetaRotulacionDTO etiquetaRotulacionDTO : lista) {

				if (etiquetaRotulacionDTO.getJson_data() != null) {
					eti = dtoJSON.deserializaJSONtoObject(etiquetaRotulacionDTO.getJson_data());
					eti.setIdregistro(etiquetaRotulacionDTO.getIdregistro());
					eti.setIdregistrodatos(etiquetaRotulacionDTO.getIdregistrodatos());
					lista_final.add(eti);
				}

			}
			// Valida los datos finales
			bo.validaRegistro(lista_final);

			modelAndView = new ModelAndView("ExportExcelEtiquetasImportadasView", "lista", lista_final);
			String nombrearchivo = UtilsStringFechas.getNombreArchivo(usuario.getLogin(), "importar_info", "xls");
			response.setHeader("Content-type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + nombrearchivo + "\"");
		} catch (Exception dae) {
			logger.debug("Error en reportes:" + dae.getMessage());
		}

		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("ExportExcelEtiquetasImportadasView", "lista", lista_final);

	}

	/**
	 * Obtiene las lineas que se configuraron para rotular
	 */
	@RequestMapping(value = "/depuraImportados", method = { RequestMethod.GET,
			RequestMethod.POST }, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody Map<String, ? extends Object> depuraImportados(
			@ModelAttribute("etiqueta") EtiquetaRotulacionDTO etiqueta, HttpServletRequest request) throws Exception {

		String mensaje = null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		try {

			if (usuario == null) {
				throw new Exception(ConstantesAutoDoc.MSG_SESSION_FINISH);
			}
			bo.depuraUUID(etiqueta);
			List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);

		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
			logger.debug("Error al obtener los datos:" + dae.getMessage());

		}
		return modelMap;

	}

	@RequestMapping(value = "/importarDatosTelcel", method = { RequestMethod.GET,
			RequestMethod.POST }, consumes = "application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody Map<String, ? extends Object> importarDatosTelcel(HttpServletRequest request) {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		try {
			EtiquetaRotulacionDTOJSON dtoJSON = new EtiquetaRotulacionDTOJSON();
			String uuid = request.getParameter("uuid");
			String idservicio = request.getParameter("idtipodocumento");

			String TELCEL_ENDPOINT = iParamsSistemaDAO.getValorPropiedad(ConstantesGenerales.TELCEL_ENDPOINT,
					ConstantesGenerales.ID_SKY4SOL);
			String TELCEL_WS_USER_OBTENDATOS = iParamsSistemaDAO
					.getValorPropiedad(ConstantesGenerales.TELCEL_WS_USER_OBTENDATOS, ConstantesGenerales.ID_SKY4SOL);

			String manejo_por_folios_o_convenios = iParamsSistemaDAO.getValorPropiedad(
					ConstantesGenerales.MANEJO_POR_FOLIOS_O_CONVENIOS, ConstantesGenerales.ID_SKY4SOL);

			String TELCEL_DEBUG = iParamsSistemaDAO.getValorPropiedad(ConstantesGenerales.TELCEL_DEBUG,
					ConstantesGenerales.ID_SKY4SOL);
			TELCEL_DEBUG = (TELCEL_DEBUG == null ? "true" : TELCEL_DEBUG);
			boolean isdebug = Boolean.parseBoolean(TELCEL_DEBUG);

			int lineas_max_archivo = iParamsSistemaDAO.getValorPropiedadInt(
					ConstantesGenerales.LINEAS_PERMITIDAS_EXCEL_ROTULACION, ConstantesGenerales.ID_SKY4SOL);

			if ((uuid == null) || (uuid.trim().length() <= 0)) {
				throw new WebServiceException("Identificador de datos UUID inv�lido.");
			}

			if ((idservicio == null) || (idservicio.trim().length() <= 0)) {
				throw new WebServiceException("Identificador del servicio inv�lido.");
			}

			URL url = null;
			try {
				url = new URL(TELCEL_ENDPOINT);
			} catch (MalformedURLException ex) {
				throw new WebServiceException(ex);
			}

			WebServicePaqueteria ws = new WebServicePaqueteria(url);
			WebServicePaqueteriaSoap wssoap = ws.getWebServicePaqueteriaSoap();
			logger.debug("Invocando servicio de Telcel para obtener datos");
			ArrayOfObtenerDatos arr = wssoap.obtenerDatosEntrega(TELCEL_WS_USER_OBTENDATOS);

			List<ObtenerDatos> arr_ObtenerDatosb = arr.getObtenerDatos();
			logger.debug("Cantidad de registros obtenidos de Telcel:" + arr_ObtenerDatosb.size());
			List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();

			UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
			int idregistro = -1;
			EtiquetaRotulacionDTO etiquetaDTO_delete = new EtiquetaRotulacionDTO();
			etiquetaDTO_delete.setUuid(uuid);
			bo.deleteRegistrosUUID(etiquetaDTO_delete);

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String jsonOutput = "";

			// Verificar largo de cada campo
			EtiquetaRotulacionDTO etiqueta = null;
			logger.debug("Creando objetos de etiquetas con datos de TELCEL");
			int canitdad_procesadas = 1;
			for (ObtenerDatos obj : arr_ObtenerDatosb) {

				// Solo lo indicado para importar
				if (canitdad_procesadas > lineas_max_archivo) {
					break;
				}
				canitdad_procesadas++;

				if ("sindatos".equals(obj.getIdEntrega())) {
					break;
				}

				etiqueta = new EtiquetaRotulacionDTO();

				etiqueta.setUuid(uuid);
				etiqueta.setIdservicio(idservicio);
				etiqueta.setIdtipodocumento("ROTULACION");
				etiqueta.setLogin(usuario.getLogin());
				etiqueta.setIdentidad(usuario.entidad.getIdentidad());
				etiqueta.setTiporotucacion(manejo_por_folios_o_convenios);
				etiqueta.setIdorganizacion(usuario.organizacion.getIdorganizacion());
				etiqueta.setNumcliente(usuario.getNumCliente() == null ? "" : usuario.getNumCliente());

				// Datos de remitente
				etiqueta.setRazonsocial_rem("TELCEL");

				etiqueta.setContacto_rem("ENCARGADO DE DISTRIBUCION");

				etiqueta.setCalle_rem("Calle 18");

				etiqueta.setNuminterior_rem("");
				etiqueta.setNumexterior_rem("27B");
				etiqueta.setColonia_rem("SAN PEDRO DE LOS PINOS");
				etiqueta.setCp_rem("03800");
				etiqueta.setMunicipio_rem("BENITO JUAREZ");
				etiqueta.setCiudad_rem("D.F");
				etiqueta.setTelefono_rem("");
				etiqueta.setCelular_rem("");

				// Datos importados del Registro de TELCEL Destino

				etiqueta.setReferencia(UtilsStringFechas.convierteCadena(obj.getIdEntrega()));
				etiqueta.setRazonsocial_des(UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getNumCel())) + " "
						+ UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getTramite())));

				etiqueta.setContacto_des(UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getNombre())) + " "
						+ UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getApellido1())) + " "
						+ UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getApellido2())));

				etiqueta.setCalle_des(UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getCalle())));

				etiqueta.setNuminterior_des(UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getNumInt())));
				etiqueta.setNumexterior_des(UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getNumExt())));
				etiqueta.setColonia_des(UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getColonia())));
				etiqueta.setCp_des(UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getCodigoPostal())));
				etiqueta.setMunicipio_des(UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getDelMun())));
				etiqueta.setCiudad_des(UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getCiudad())));
				etiqueta.setTelefono_des(UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getNumContacto1())));
				etiqueta.setCelular_des(UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getNumContacto2())));

				etiqueta.setContenido(UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getFechaProgramada()))
						+ " " + UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getHoraProgramada())) + " "
						+ UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getEquipo())));
				etiqueta.setObservacion(UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getIEMI())) + " "
						+ UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getICCID())) + " "
						+ UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getPromocional()))
						+ UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getReferencia())) + " "
						+ UtilsStringFechas.convierteCadena(Utils.nullChange(obj.getTPV())));

				// Datos compplementarios
				if (!manejo_por_folios_o_convenios.equals(ConstantesGenerales.MANEJO_FOLIOS)) {
					String[] convenio_tarifa = etiqueta.getIdservicio().split("-");
					if (convenio_tarifa.length > 1) {
						etiqueta.setIdconvenio(convenio_tarifa[0]);
						etiqueta.setIdtarifa(convenio_tarifa[1]);
						etiqueta.setIdconveniodetalle(convenio_tarifa[2]);
						etiqueta.setIdservicio(convenio_tarifa[3]);
					}

				}

				jsonOutput = gson.toJson(etiqueta);
				etiqueta.setJson_data(jsonOutput);

				try {
					idregistro = bo.insert(etiqueta);
					bo.update(etiqueta);
					etiqueta.setIdregistro(idregistro);

					// Informa a Telcel que ya se obtuvo la informacion
					if (!isdebug) {
						// Solo los marca cuando no esta en modo debug
						wssoap.actualizarRegistro("" + obj.getIdEntrega(), "15");
					}

				} catch (Exception e) {
					logger.debug("Error al agregara registro TELCEL:" + e.getMessage());
					logger.debug("Datos de registro:" + jsonOutput);
				}

			}
			logger.debug("Termina proceso de importacion de Telcel");
			String mensaje_excede_lineas = "Registros importados de TELCEL:" + arr_ObtenerDatosb.size();
			if (arr_ObtenerDatosb.size() >= lineas_max_archivo) {
				mensaje_excede_lineas = "Se importaron " + lineas_max_archivo + " de " + arr_ObtenerDatosb.size()
						+ ", procese los registros y una vez terminada la impresi�n importe los registros restantes.";
			}
			modelMap.put("success", true);
			modelMap.put("message", mensaje_excede_lineas);
			modelMap.put("cantidad", arr_ObtenerDatosb.size());

		} catch (Exception e) {
			modelMap.put("success", false);
			modelMap.put("message", ExcepcionMessage.getMessageExcepcion(e.getMessage()));

		}

		return modelMap;
	}

}
