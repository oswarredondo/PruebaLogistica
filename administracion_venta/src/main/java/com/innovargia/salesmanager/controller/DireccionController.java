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

import com.innovargia.salesmanager.dtos.DireccionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IDireccionBO;
import com.innovargia.salesmanager.json.DireccionDTOJSON;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adrián
 *
 */
@RequestMapping("/catalogo/direccion")
@Controller
public class DireccionController {

	@Autowired 
	IDireccionBO bo;
	/**
	 * 
	 */
	public DireccionController() {
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
		DireccionDTO busqueda = new DireccionDTO();
		busqueda.setIdcliente(i_idcliente);
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<DireccionDTO> lista = new ArrayList<DireccionDTO>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		try {
			if (idcliente!=null){
				lista = bo.getRegistros(busqueda,usuario);
			}
			modelMap.put("success", true);
			modelMap.put("message", "");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
		} catch (DataAccessException dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;
		
	}
	
	/**
	 * Obtiene los datos de direcciones, solo los registros que estan activos, a
	 * diferencia de getDatos esta devuelve la relación de todas las direcciones 
	 * asignadas a un clientes junto con los datos del cliente como numero de cliente
	 * razon social, identificador. Este inicialmente solo se utiliza en cotizaciones.
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getDatosConsulta")
	public @ResponseBody
	Map<String, ? extends Object> getDatosConsulta(
			@RequestParam(value = "idcliente", required = false) String idcliente,
			HttpServletRequest request)throws Exception {
		
		
		
		int i_idcliente = (idcliente==null) || (idcliente.trim().length()<=0)?-1:Integer.parseInt(request.getParameter("idcliente"));
		DireccionDTO busqueda = new DireccionDTO();
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		List<DireccionDTO> lista = new ArrayList<DireccionDTO>();
		UtilsRequest.displayParametros(request);
		
		
		try {
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			//Indica que traiga la combinacion de datos de Clientes y 
			//Direcciones solo de los registros de clientes activos
			busqueda.setDirdefault(90); //Busca solo las direcciones del id de cliente seleccionado
			if (i_idcliente>-1){
				busqueda.setIddireccion(10);
				busqueda.setIdcliente(i_idcliente);
			}else if (request.getParameter("tipobusqueda")!=null){
				busqueda.setIddireccion(request.getParameter("tipobusqueda"));
				busqueda.setDescripcion(request.getParameter("patronbusqueda"));
			}
			
			//Checa que datos debe devolver 
			if (request.getParameter("direccionesatencionfacturacion")!=null){
			    lista = bo.getRegistrosClienteFact(busqueda, usuario);
			}else{
			    lista = bo.getRegistros(busqueda, usuario);
			}
			
			modelMap.put("success", true);
			modelMap.put("message", "");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
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
			
			@RequestParam(value = "iddireccion" , required = false) String iddireccion,
			@RequestParam(value = "idcliente" , required = false) String idcliente,
			@RequestParam(value = "calle" , required = false) String calle,
			@RequestParam(value = "numexterior" , required = false) String numexterior,
			@RequestParam(value = "numinterior" , required = false) String numinterior,
			@RequestParam(value = "cp" , required = false) String cp,
			@RequestParam(value = "colonia" , required = false) String colonia,
			@RequestParam(value = "municipio" , required = false) String municipio,
			@RequestParam(value = "estado" , required = false) String estado,
			@RequestParam(value = "email" , required = false) String email,
			@RequestParam(value = "telefono" , required = false) String telefono,
			@RequestParam(value = "movil" , required = false) String movil,
			@RequestParam(value = "observacion" , required = false) String observacion,
			@RequestParam(value = "direcciondefault" , required = false) String direcciondefault,
			@RequestParam(value = "estatus" , required = false) String estatus,
			@RequestParam(value = "clasificacion" , required = false) String clasificacion,
			
			HttpServletRequest request)	throws Exception {


		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		DireccionDTO direccion = new DireccionDTO();
		
		direccion.setCalle(calle);
		direccion.setNumexterior(numexterior);
		direccion.setNuminterior(numinterior);
		direccion.setCp(cp);
		direccion.setColonia(colonia);
		direccion.setMunicipio(municipio);
		direccion.setEstado(estado);
		direccion.setEmail(email);
		direccion.setTelefono(telefono);
		direccion.setMovil(movil);
		direccion.setDirdefault(direcciondefault);
		direccion.setObservacion(observacion);
		direccion.setClasificacion(clasificacion);
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		UtilsRequest.displayParametros(request);
		   
		try {

			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			if (idcliente != null) {

				List<DireccionDTO> lista = bo.getVerificaExistencia(direccion,usuario, "I");
				direccion.setIdcliente(idcliente);   

				if ((lista!=null) && (lista.size()>0)){
					throw new Exception("Ya existe dada de alta la direccion, verifique");
				}
				
				bo.insert(direccion);
				modelMap.put("success", true);
				modelMap.put("message", "Se agregó correctmente el registro");

			} else {
				modelMap.put("success", true);
				modelMap.put("message", "Numero de cliente invalido");
			}
		} catch (Exception dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
			}
			modelMap.put("message", mensaje);
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
			@RequestParam(value = "iddireccion" , required = true) String iddireccion,
			@RequestParam(value = "idcliente" , required = false) String idcliente,
			@RequestParam(value = "calle" , required = false) String calle,
			@RequestParam(value = "numexterior" , required = false) String numexterior,
			@RequestParam(value = "numinterior" , required = false) String numinterior,
			@RequestParam(value = "cp" , required = false) String cp,
			@RequestParam(value = "colonia" , required = false) String colonia,
			@RequestParam(value = "municipio" , required = false) String municipio,
			@RequestParam(value = "estado" , required = false) String estado,
			@RequestParam(value = "email" , required = false) String email,
			@RequestParam(value = "telefono" , required = false) String telefono,
			@RequestParam(value = "movil" , required = false) String movil,
			@RequestParam(value = "observacion" , required = false) String observacion,
			@RequestParam(value = "direcciondefault" , required = false) String direcciondefault,
			@RequestParam(value = "estatus" , required = false) String estatus,
			@RequestParam(value = "clasificacion" , required = false) String clasificacion,
			HttpServletRequest request
		)	throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		DireccionDTO direccion = new DireccionDTO();
		direccion.setIddireccion(iddireccion);
		direccion.setIdcliente(idcliente);
		direccion.setCalle(calle);
		direccion.setNumexterior(numexterior);
		direccion.setNuminterior(numinterior);
		direccion.setCp(cp);
		direccion.setColonia(colonia);
		direccion.setMunicipio(municipio);
		direccion.setEstado(estado);
		direccion.setEmail(email);
		direccion.setTelefono(telefono);
		direccion.setMovil(movil);
		direccion.setDirdefault(direcciondefault);
		direccion.setObservacion(observacion);
		direccion.setClasificacion(clasificacion);
		UtilsRequest.displayParametros(request);
		
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		try {

			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			if (idcliente != null) {

				
				List<DireccionDTO> lista = bo.getVerificaExistencia(direccion,usuario, "U");
				direccion.setIdcliente(idcliente);
				if ((lista!=null) && (lista.size()>0)){
					throw new Exception("Ya existe dada de alta la direccion, verifique");
				}   
				
				bo.update(direccion);
				modelMap.put("success", true);
				modelMap.put("message", "Se actualizo correctmente el registro");

			} else {
				modelMap.put("success", true);
				modelMap.put("message", "Numero de cliente invalido");
			}
		} catch (Exception dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios serán deshechos, verifique.";
			}
			modelMap.put("message", mensaje);
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
			@RequestParam(value = "identificador", required = true) int identificador,HttpServletRequest request)	throws Exception {

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
		List<DireccionDTO> listaregistros = new ArrayList<DireccionDTO>();
		String mensaje = "";
		DireccionDTOJSON dtoJSON = new DireccionDTOJSON();


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
				bo.insert(listaregistros.get(i));
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
	 * Actualiza un registro o registros que vienen de un JSON
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/updateJson", method = RequestMethod.POST, headers = { "content-type=application/json" })
	public @ResponseBody
	Map<String, ? extends Object> updateJson(@RequestBody String json,HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<DireccionDTO> listaregistros = new ArrayList<DireccionDTO>();
		String mensaje = "";
		DireccionDTOJSON dtoJSON = new DireccionDTOJSON();


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
		List<DireccionDTO> listaregistros = new ArrayList<DireccionDTO>();
		String mensaje = "";
		DireccionDTOJSON dtoJSON = new DireccionDTOJSON();


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
	
	private boolean isEquals(DireccionDTO dir1, DireccionDTO dir2){

		String calle = dir1.getCalle()==null?"":dir1.getCalle().trim().toUpperCase();
		String numexterior = dir1.getNumexterior()==null?"":dir1.getNumexterior().trim().toUpperCase();
		String numinterior = dir1.getNuminterior()==null?"":dir1.getNuminterior().trim().toUpperCase();
		String cp = dir1.getCp()==null?"":dir1.getCp().trim().toUpperCase();
		String colonia = dir1.getColonia()==null?"":dir1.getColonia().trim().toUpperCase();
		String municipio = dir1.getMunicipio()==null?"":dir1.getMunicipio().trim().toUpperCase();
		String estado = dir1.getEstado()==null?"":dir1.getEstado().trim().toUpperCase();

		String cadena1 = calle+numexterior+numinterior+cp+colonia+municipio+estado;
		
		calle = dir2.getCalle()==null?"":dir2.getCalle().trim().toUpperCase();
		numexterior = dir2.getNumexterior()==null?"":dir2.getNumexterior().trim().toUpperCase();
		numinterior = dir2.getNuminterior()==null?"":dir2.getNuminterior().trim().toUpperCase();
		cp = dir2.getCp()==null?"":dir2.getCp().trim().toUpperCase();
		colonia = dir2.getColonia()==null?"":dir2.getColonia().trim().toUpperCase();
		municipio = dir2.getMunicipio()==null?"":dir2.getMunicipio().trim().toUpperCase();
		estado = dir2.getEstado()==null?"":dir2.getEstado().trim().toUpperCase();

		String cadena2 = calle+numexterior+numinterior+cp+colonia+municipio+estado;
		if (cadena1.equals(cadena2)){
			return true;
		}

		
		return false;
	}

}
