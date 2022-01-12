/**
 * 
 */
package com.innovargia.salesmanager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovargia.salesmanager.dtos.ContactoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IContactoBO;
import com.innovargia.salesmanager.json.ContactosDTOJSON;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adrián
 *
 */
@RequestMapping("/catalogo/contacto")
@Controller
public class ContactoController {

	@Autowired 
	IContactoBO bo;
	/**
	 * 
	 */
	public ContactoController() {
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
	Map<String, ? extends Object> getDatos(
			@RequestParam(value = "idcliente", required = false) String idcliente,
			HttpServletRequest request)throws Exception {
		
		
		
		int i_idcliente = (idcliente==null) || (idcliente.trim().length()<=0)?-1:Integer.parseInt(request.getParameter("idcliente"));
		ContactoDTO busqueda = new ContactoDTO();
		busqueda.setIdcliente(i_idcliente);
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<ContactoDTO> lista = new ArrayList<ContactoDTO>();
		UtilsRequest.displayParametros(request);
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		
		try {
			if (usuario!=null){
				busqueda.setLogincreador(usuario.getLogin());
				busqueda.setVisibilidad(usuario.getVisibilidad());
				if (idcliente!=null){
					lista = bo.getRegistros(busqueda);
				}
				modelMap.put("message", "");
				modelMap.put("totalCount", lista.size());
				modelMap.put("proxiArray", lista);
			} else {
				modelMap.put("message", ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			modelMap.put("success", true);
			
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
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
			
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UtilsRequest.displayParametros(request);
		ContactoDTO contacto = new ContactoDTO();
		contacto.setIdcliente(request.getParameter("idcliente"));
		contacto.setIdcontacto( request.getParameter("idcontacto"));
		contacto.setTelefono2(request.getParameter("telefono2"));
		contacto.setExtencion(request.getParameter("extencion"));   
		contacto.setTelefono(request.getParameter("telefono"));
		contacto.setEmail(request.getParameter("email"));
		contacto.setMovil(request.getParameter("movil"));
		contacto.setNombre(request.getParameter("nombre"));
		contacto.setApellido(request.getParameter("apellido"));
		contacto.setComentario(request.getParameter("comentario")  );
		contacto.setPuesto(request.getParameter("puesto") );
		contacto.setClasificacion(request.getParameter("clasificacion"));
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		
		try {
			
			if (usuario != null) {

				if (contacto.getIdcliente() < 0) {
					throw new Exception("Identificador de cliente inválido.");
				}
				contacto.setLogincreador(usuario.getLogin());
				bo.insert(contacto);
				
				modelMap.put("message", "Se Actualizo el registro con exito");
				modelMap.put("mensaje", "Se Actualizo el registro con exito");
			} else {
				modelMap.put("message", ConstantesAdminSale.MSG_SESSION_FINISH);
				modelMap.put("mensaje", ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			modelMap.put("success", true);
			
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
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
	@RequestMapping("/update")
	public @ResponseBody
	Map<String, ? extends Object> update(
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UtilsRequest.displayParametros(request);
		ContactoDTO contacto = new ContactoDTO();
		contacto.setIdcliente(request.getParameter("idcliente"));
		contacto.setIdcontacto( request.getParameter("idcontacto"));
		contacto.setTelefono2(request.getParameter("telefono2"));
		contacto.setTelefono(request.getParameter("telefono"));
		contacto.setExtencion(request.getParameter("extencion"));   
		contacto.setEmail(request.getParameter("email"));
		contacto.setMovil(request.getParameter("movil"));
		contacto.setNombre(request.getParameter("nombre"));
		contacto.setApellido(request.getParameter("apellido"));
		contacto.setComentario(request.getParameter("comentario")  );
		contacto.setPuesto(request.getParameter("puesto") );
		contacto.setClasificacion(request.getParameter("clasificacion"));
		try {
			if (contacto.getIdcliente()<0){
				throw  new Exception("Identificador de cliente inválido.");
			}
			if (contacto.getIdcontacto()<0){
				throw  new Exception("Identificador de contacto inválido.");
			}
			bo.update(contacto);
			modelMap.put("success", true);
			modelMap.put("message", "Se Actualizo el registro con exito");
			modelMap.put("mensaje","Se Actualizo el registro con exito");
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

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
			@RequestParam(value = "identificador", required = true) int identificador,
			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();


		try {
			success = true;
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
		List<ContactoDTO> listaregistros = new ArrayList<ContactoDTO>();
		String mensaje = "";
		ContactosDTOJSON dtoJSON = new ContactosDTOJSON();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));


		try {
			if (usuario != null) {
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
				ContactoDTO contacto = null;
				for (int i = 0; i < listaregistros.size(); i++) {
					contacto = listaregistros.get(i);
					contacto.setLogincreador(usuario.getLogin());
					bo.insert(contacto);
				}
				mensaje = "Se Actualizo el registro con exito";
			} else {
				mensaje =  ConstantesAdminSale.MSG_SESSION_FINISH;
			}
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(e.getMessage());
			if (e.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
			}

		}

		dtoJSON.clearData();

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
		List<ContactoDTO> listaregistros = new ArrayList<ContactoDTO>();
		String mensaje = "";
		ContactosDTOJSON dtoJSON = new ContactosDTOJSON();


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
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(e.getMessage());
			if (e.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
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
		List<ContactoDTO> listaregistros = new ArrayList<ContactoDTO>();
		String mensaje = "";
		ContactosDTOJSON dtoJSON = new ContactosDTOJSON();


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
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(e.getMessage());
			if (e.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
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
