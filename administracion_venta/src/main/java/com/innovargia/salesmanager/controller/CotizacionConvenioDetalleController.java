/**
 * 
 */
package com.innovargia.salesmanager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IConvenioContratoDetalleBO;
import com.innovargia.salesmanager.ibo.ILogHistoriaBO;
import com.innovargia.salesmanager.ibo.ITarifaPesoBO;
import com.innovargia.salesmanager.json.ConvenioContratoDetalleDTOJSON;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsRequest;

/**
 * @author Adrián
 * 
 */
@RequestMapping("/cotizacionconveniodetalle")
@Controller
public class CotizacionConvenioDetalleController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CotizacionConvenioDetalleController.class);
	

	@Autowired 
	IConvenioContratoDetalleBO bo;
	@Autowired 
	ILogHistoriaBO iLogHistoriaBO;

	
	/**
	 * 
	 */
	public CotizacionConvenioDetalleController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Obtiene los datos de un catalogo, solo los registros que estan activos
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDatos")
	public @ResponseBody
	Map<String, ? extends Object> getDatos(HttpServletRequest request)throws Exception {
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<ConvenioContratoDetalleDTO> lista = new ArrayList<ConvenioContratoDetalleDTO>();;
		ConvenioContratoDetalleDTO busquedaDTO = new ConvenioContratoDetalleDTO();
		
		try {
		
			if (request.getParameter("idconvenio") !=null){
				busquedaDTO.setIdconvenio(request.getParameter("idconvenio") );
				lista = bo.getRegistros(busquedaDTO);
			}
			
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", success);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
		
	}

	/***
	 * Agrega un registro 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insert")
	public @ResponseBody
	Map<String, ? extends Object> insert(
			@RequestParam(value = "idconvenio", required = false) String idconvenio,
			@RequestParam(value = "siglasori", required = false) String siglasori,
			@RequestParam(value = "siglasdes", required = false) String siglasdes,
			@RequestParam(value = "peso", required = false) String peso,
			@RequestParam(value = "largo", required = false) String largo,
			@RequestParam(value = "alto", required = false) String alto,
			@RequestParam(value = "ancho", required = false) String ancho,
			@RequestParam(value = "coberturakm", required = false) String coberturakm,
			@RequestParam(value = "precio", required = false) String precio,
			@RequestParam(value = "cporigen", required = false) String cporigen,
			@RequestParam(value = "cpdestino", required = false) String cpdestino,
			@RequestParam(value = "comentario", required = false) String comentario,
			HttpServletRequest request) throws Exception {
				 
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		ConvenioContratoDetalleDTO detalle = new ConvenioContratoDetalleDTO();
		detalle.setIdconvenio(idconvenio);
		detalle.setSiglasori(siglasori);
		detalle.setSiglasdes(siglasdes);
		detalle.setPeso(peso);
		detalle.setLargo(largo);
		detalle.setAlto(alto);
		detalle.setAncho(ancho);
		detalle.setCoberturakm(coberturakm);
		detalle.setPrecio(precio);
		detalle.setCpdestino(cpdestino);
		detalle.setCporigen(cporigen);
		detalle.setComentario(comentario);
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		LogHistoriaDTO historia = new LogHistoriaDTO();
		
		try {
			if (usuario!=null){
			    if (!usuario.opcionAsignadaPerfiles("solo.actualiza.numcliente.en.convenio")){
				bo.insert(detalle);
				
				//Agrega la historia
				historia.setIdregistro(detalle.getIdconvenio());
				historia.setTipomovimiento(ConstantesAdminSale.MOV_INSERT);
				historia.setLogin(usuario.getLogin());
				historia.setRegistro("DETALLE:" + siglasori +","+siglasdes+ ", medidas/peso:" +
				alto+","+largo+","+ ancho+ ","+peso+","+ coberturakm);
				iLogHistoriaBO.insertHistoriaConvenio(historia);
				
				success = true;
				mensaje="Se agrega registro correctamente";
			    }else{
				mensaje=ConstantesAdminSale.MSG_OPERACION_UPDATE_RESTRINGIDA;
			    }
				
				
			}else{
				mensaje=ConstantesAdminSale.MSG_SESSION_FINISH;
			}
			
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
		} catch (Exception  dae) {
				modelMap.put("success", success);
				modelMap.put("message", dae.getMessage());
		}
		return modelMap;
	}
	
	/**
	 * Actualiza un registro
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	/***
	 * Agrega un registro 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update")
	public @ResponseBody
	Map<String, ? extends Object> update( 	 
			@RequestParam(value = "idconveniodetalle", required = false) String idconveniodetalle,
			@RequestParam(value = "idconvenio", required = false) String idconvenio,
			@RequestParam(value = "siglasori", required = false) String siglasori,
			@RequestParam(value = "siglasdes", required = false) String siglasdes,
			@RequestParam(value = "peso", required = false) String peso,
			@RequestParam(value = "largo", required = false) String largo,
			@RequestParam(value = "alto", required = false) String alto,
			@RequestParam(value = "ancho=", required = false) String ancho,
			@RequestParam(value = "coberturakm", required = false) String coberturakm,
			@RequestParam(value = "precio", required = false) String precio,
			HttpServletRequest request) throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		
		ConvenioContratoDetalleDTO detalle = new ConvenioContratoDetalleDTO();
		detalle.setIdconveniodetalle(idconveniodetalle);
		detalle.setIdconvenio(idconvenio);
		detalle.setSiglasori(siglasori);
		detalle.setSiglasdes(siglasdes);
		detalle.setPeso(peso);
		detalle.setLargo(largo);
		detalle.setAlto(alto);
		detalle.setAncho(ancho);
		detalle.setCoberturakm(coberturakm);
		detalle.setPrecio(precio);
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		LogHistoriaDTO historia = new LogHistoriaDTO();
		
		try {
			if (usuario!=null){
				
				bo.update(detalle);
				
				//Agrega la historia
				historia.setIdregistro(detalle.getIdconvenio());
				historia.setTipomovimiento(ConstantesAdminSale.MOV_UPDATE);
				historia.setLogin(usuario.getLogin());
				historia.setRegistro("DETALLE:" + siglasori +","+siglasdes+ ", medidas/peso:" +
				alto+","+largo+","+ ancho+ ","+peso+","+ coberturakm);

				iLogHistoriaBO.insertHistoriaConvenio(historia);
				
				success = true;
				mensaje="Se modifico el documento:" + detalle.getIdconvenio() + ".";
				
			}else{
				mensaje=ConstantesAdminSale.MSG_SESSION_FINISH;
			}
			
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", success);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
	}
	/**
	 * Borra un registro
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public @ResponseBody
	Map<String, ? extends Object> delete(
			@RequestParam(value = "idconveniodetalle", required = true) String idconveniodetalle,
			@RequestParam(value = "idconvenio", required = false) String idconvenio,
			HttpServletRequest request)	throws Exception {


		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		UtilsRequest.displayParametros(request);
		
		ConvenioContratoDetalleDTO detalle = new ConvenioContratoDetalleDTO();
		detalle.setIdconveniodetalle(idconveniodetalle);
		detalle.setIdconvenio(idconvenio);

		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		
		try {
			if (usuario!=null){
				
				bo.delete(detalle);
				
		
				success = true;
				mensaje="Se modifico el documento:" + detalle.getIdconvenio() + ".";
				
			}else{
				mensaje=ConstantesAdminSale.MSG_SESSION_FINISH;
			}
			
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
		} catch (DataAccessException dae) {
			if (dae.contains(DuplicateKeyException.class)) {
				modelMap.put("success", success);
				modelMap.put("message", dae.getMessage());
			}

		}
		return modelMap;
	}
	
	/***
	 * INserta un registro o registros que vienen de un JSON
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/insertJson", method = RequestMethod.POST, headers = { "content-type=application/json" })
	public @ResponseBody
	Map<String, ? extends Object> insertJson(@RequestBody String json,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ConvenioContratoDetalleDTO> listaregistros = new ArrayList<ConvenioContratoDetalleDTO>();
		String mensaje = "";
		ConvenioContratoDetalleDTOJSON dtoJSON = new ConvenioContratoDetalleDTOJSON();


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
				bo.update(listaregistros.get(i));
			}
			mensaje = "Se Actualizo el registro con exito";
		} catch (Exception e) {
			String[] arr_err = null;
			mensaje += e.getMessage();
			mensaje = mensaje.substring(0, mensaje.length() - 1);
			if (mensaje.contains("duplicate key")) {
				arr_err = mensaje.split("\\.");
				mensaje = arr_err[arr_err.length - 1];
				mensaje = mensaje
						.replaceAll("The duplicate key value is",
								"Registro duplicado, verifique");
			}

		}

		dtoJSON.clearData();
		
		result.put("success", true);
		result.put("message", mensaje);
		result.put("mensaje", mensaje);
		listaregistros.clear();
		return result;
	}
	
	/***
	 * Actualiza un registro o registros que vienen de un JSON
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/updateJson", method = RequestMethod.POST, headers = { "content-type=application/json" })
	public @ResponseBody
	Map<String, ? extends Object> updateJson(@RequestBody String json,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ConvenioContratoDetalleDTO> listaregistros = new ArrayList<ConvenioContratoDetalleDTO>();
		String mensaje = "";
		ConvenioContratoDetalleDTOJSON dtoJSON = new ConvenioContratoDetalleDTOJSON();

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
				bo.update(listaregistros.get(i));
			}
			mensaje = "Se Actualizo el registro con exito";
		} catch (Exception e) {
			String[] arr_err = null;
			mensaje += e.getMessage();
			mensaje = mensaje.substring(0, mensaje.length() - 1);
			if (mensaje.contains("duplicate key")) {
				arr_err = mensaje.split("\\.");
				mensaje = arr_err[arr_err.length - 1];
				mensaje = mensaje
						.replaceAll("The duplicate key value is",
								"Registro duplicado, verifique");
			}

		}

		dtoJSON.clearData();
		
		result.put("success", true);
		result.put("message", mensaje);
		result.put("mensaje", mensaje);
		listaregistros.clear();
		return result;
	}
	
	/***
	 * Actualiza un registro o registros que vienen de un JSON
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/updatePrecioJson", method = RequestMethod.POST, headers = { "content-type=application/json" })
	public @ResponseBody
	Map<String, ? extends Object> updatePrecioJson(@RequestBody String json,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ConvenioContratoDetalleDTO> listaregistros = new ArrayList<ConvenioContratoDetalleDTO>();
		String mensaje = "";
		ConvenioContratoDetalleDTOJSON dtoJSON = new ConvenioContratoDetalleDTOJSON();

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
				bo.updatePrecio(listaregistros.get(i));
			}
			mensaje = "Se Actualizo el registro con exito";
		} catch (Exception e) {
			String[] arr_err = null;
			mensaje += e.getMessage();
			mensaje = mensaje.substring(0, mensaje.length() - 1);
			if (mensaje.contains("duplicate key")) {
				arr_err = mensaje.split("\\.");
				mensaje = arr_err[arr_err.length - 1];
				mensaje = mensaje
						.replaceAll("The duplicate key value is",
								"Registro duplicado, verifique");
			}

		}

		dtoJSON.clearData();
		
		result.put("success", true);
		result.put("message", mensaje);
		result.put("mensaje", mensaje);
		listaregistros.clear();
		return result;
	}
	
	/***
	 * INserta un registro o registros que vienen de un JSON
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/deleteJson", method = RequestMethod.POST, headers = { "content-type=application/json" })
	public @ResponseBody
	Map<String, ? extends Object> deleteJson(@RequestBody String json,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<ConvenioContratoDetalleDTO> listaregistros = new ArrayList<ConvenioContratoDetalleDTO>();
		String mensaje = "";
		ConvenioContratoDetalleDTOJSON dtoJSON = new ConvenioContratoDetalleDTOJSON();

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
				bo.delete(listaregistros.get(i));
			}
			mensaje = "Se Actualizo el registro con exito";
		} catch (Exception e) {
			String[] arr_err = null;
			mensaje += e.getMessage();
			mensaje = mensaje.substring(0, mensaje.length() - 1);
			if (mensaje.contains("duplicate key")) {
				arr_err = mensaje.split("\\.");
				mensaje = arr_err[arr_err.length - 1];
				mensaje = mensaje
						.replaceAll("The duplicate key value is",
								"Registro duplicado, verifique");
			}

		}

		dtoJSON.clearData();
		
		result.put("success", true);
		result.put("message", mensaje);
		result.put("mensaje", mensaje);
		listaregistros.clear();
		return result;
	}
	
	
	
}
