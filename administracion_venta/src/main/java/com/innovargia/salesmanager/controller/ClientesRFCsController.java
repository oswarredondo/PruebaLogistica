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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ClientesDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IClientesRFCsBO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adri�n
 * 
 */
@RequestMapping("/catalogo/clientesrfc")
@Controller
public class ClientesRFCsController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ClientesRFCsController.class);


	@Autowired 
	IClientesRFCsBO bo;
	/**
	 * 
	 */
	public ClientesRFCsController() {
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
			@RequestParam(value = "tipobusqueda", required = false) String tipobusqueda,
			@RequestParam(value = "patronbusqueda", required = false) String patronbusqueda,
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		BusquedaDTO busqueda = new BusquedaDTO();
		int i_tipobusqueda = (tipobusqueda==null) || (tipobusqueda.trim().length()<=0)?-1:Integer.parseInt(request.getParameter("tipobusqueda"));
		int estatus =  request.getParameter("estatus")==null?-1: Integer.parseInt(request.getParameter("estatus"));
		List<RemDes> lista = new ArrayList<RemDes>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		UtilsRequest.displayParametros(request);
		try {
			
			if (usuario==null){
				throw new Exception(mensaje=ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			

			UtilsRequest.displayParametros(request);
			
			
			busqueda.setTipo(i_tipobusqueda);
			busqueda.setPatron_busqueda(patronbusqueda);
			busqueda.setEstatus(estatus);
			busqueda.setUsuario(usuario);
			lista = bo.getBusquedaRegistros(busqueda) ;

			modelMap.put("success", true);  
			modelMap.put("message", mensaje);
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
			@RequestParam(value = "identificador", required = false) String identificador,
			@RequestParam(value = "rfc", required = false) String rfc,
			@RequestParam(value = "numCliente", required = false) String numcliente,
			@RequestParam(value = "razonSocial", required = false) String razonsocial,
			@RequestParam(value = "atencion", required = false) String atencion,
			@RequestParam(value = "calle", required = false) String calle,
			@RequestParam(value = "colonia", required = false) String colonia,
			@RequestParam(value = "ciudad" , required = false) String ciudad,
			@RequestParam(value = "estado" , required = false) String estado,
			@RequestParam(value = "cp" , required = false) String cp,
			@RequestParam(value = "municipio" , required = false) String municipio,
			@RequestParam(value = "numinterior" , required = false) String numinterior,
			@RequestParam(value = "telefono" , required = false) String telefono,
			@RequestParam(value = "numexterior" , required = false) String numexterior,
			@RequestParam(value = "numcelular" , required = false) String numcelular,
			@RequestParam(value = "extencion" , required = false) String extencion,
			@RequestParam(value = "movil" , required = false) String movil,
			@RequestParam(value = "correoe" , required = false) String correoe,	
			
			@RequestParam(value = "rotula" , required = false) String rotula,	
			HttpServletRequest request)	throws Exception {


		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		RemDes cliente = new RemDes();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		UtilsRequest.displayParametros(request);
		try {
			if (usuario!=null){
				
				cliente.setIdAutonumerico(identificador);
				cliente.setRazonSocial(razonsocial);
				cliente.setNumCliente(numcliente);
				cliente.setRfc(rfc);
				cliente.setAtencion(atencion==null?"":atencion);
				cliente.setCalle(calle);
				cliente.setColonia(colonia);
				cliente.setCiudad( ciudad==null?"":ciudad);
				cliente.setEstado(estado);
				cliente.setCp(cp);
				cliente.setMunicipio(municipio);
				cliente.setNuminterior(numinterior);
				cliente.setNumexterior(numexterior);
				cliente.setTelefono(telefono);
				cliente.setNumcelular(numcelular);
				cliente.setExtencion(extencion);
				cliente.setMovil(movil);
				cliente.setCorreoe(correoe);
				cliente.setRotula(rotula==null||rotula.trim().length()<=0?"SI":rotula);
				bo.insert(cliente);
				
				
				modelMap.put("message", "Registro agregado de forma correcta.");
			}else{
				modelMap.put("message", ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			modelMap.put("success", true);
			
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
			@RequestParam(value = "identificador", required = false) String identificador,
			@RequestParam(value = "rfc", required = false) String rfc,
			@RequestParam(value = "numCliente", required = false) String numcliente,
			@RequestParam(value = "razonSocial", required = false) String razonsocial,
			@RequestParam(value = "atencion", required = false) String atencion,
			@RequestParam(value = "calle", required = false) String calle,
			@RequestParam(value = "colonia", required = false) String colonia,
			@RequestParam(value = "ciudad" , required = false) String ciudad,
			@RequestParam(value = "estado" , required = false) String estado,
			@RequestParam(value = "cp" , required = false) String cp,
			@RequestParam(value = "municipio" , required = false) String municipio,
			@RequestParam(value = "numinterior" , required = false) String numinterior,
			@RequestParam(value = "telefono" , required = false) String telefono,
			@RequestParam(value = "numexterior" , required = false) String numexterior,
			@RequestParam(value = "numcelular" , required = false) String numcelular,
			@RequestParam(value = "extencion" , required = false) String extencion,
			@RequestParam(value = "movil" , required = false) String movil,
			@RequestParam(value = "correoe" , required = false) String correoe,			
			@RequestParam(value = "rotula" , required = false) String rotula,			
			HttpServletRequest request)	throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		RemDes cliente = new RemDes();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		UtilsRequest.displayParametros(request);
		try {
			
			if (usuario!=null){
				cliente.setIdAutonumerico(identificador);
				cliente.setRazonSocial(razonsocial);
				cliente.setNumCliente(numcliente);
				cliente.setRfc(rfc);
				cliente.setAtencion(atencion);
				cliente.setCalle(calle);
				cliente.setColonia(colonia);
				cliente.setCiudad(ciudad);
				cliente.setEstado(estado);
				cliente.setCp(cp);
				cliente.setMunicipio(municipio);
				cliente.setNuminterior(numinterior);
				cliente.setNumexterior(numexterior);
				cliente.setTelefono(telefono);
				cliente.setNumcelular(numcelular);
				cliente.setExtencion(extencion);
				cliente.setMovil(movil);
				cliente.setCorreoe(correoe);
				cliente.setRotula(rotula==null||rotula.trim().length()<=0?"SI":rotula);
				bo.update(cliente);

				modelMap.put("message", "Registro modificado de forma correcta.");
			}else{
				modelMap.put("message", ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			modelMap.put("success", true);
			
			
		} catch (Exception dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}
			modelMap.put("message", mensaje);
		}
		return modelMap;
	}
	
	/***
	 * Bloquea o desbloque los registros
	 * @param idsclientes
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/bloquear")
	public @ResponseBody
	Map<String, ? extends Object> bloquear(
			@RequestParam(value = "idsclientes", required = true) String idsclientes,
			@RequestParam(value = "estatus", required = true) int estatus,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ClientesDTO cliente= null;

		try {
			if (idsclientes!=null){
				String[] arr_idsclientes = idsclientes.trim().split("\\|");
				for (String id : arr_idsclientes) {
					
					cliente = new ClientesDTO();
					try{
						cliente.setIdcliente(Integer.parseInt(id));
						cliente.setEstatus(estatus);
						bo.updateEstatus(cliente);
					}catch(Exception e){
						logger.error("Identificador de cliente invalido:" + id);
					}
					
				}
			}
			modelMap.put("success", true);
			modelMap.put("message", "Registros seleccionados fueron desactivados");
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
	@RequestMapping("/desactivar")
	public @ResponseBody
	Map<String, ? extends Object> desactivar(
			@RequestParam(value = "idsclientes", required = true) String idsclientes,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ClientesDTO cliente= null;

		try {
			if (idsclientes!=null){
				String[] arr_idsclientes = idsclientes.trim().split("\\|");
				for (String id : arr_idsclientes) {
					
					cliente = new ClientesDTO();
					try{
						cliente.setIdcliente(Integer.parseInt(id));
						cliente.setEstatus(0);
						bo.updateEstatus(cliente);
					}catch(Exception e){
						logger.error("Identificador de cliente invalido:" + id);
					}
					
				}
			}
			modelMap.put("success", true);
			modelMap.put("message", "Registros seleccionados fueron desactivados");
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
	@RequestMapping("/activar")
	public @ResponseBody
	Map<String, ? extends Object> activar(
			@RequestParam(value = "idsclientes", required = true) String idsclientes,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		ClientesDTO cliente= null;

		try {
			if (idsclientes!=null){
				String[] arr_idsclientes = idsclientes.trim().split("\\|");
				for (String id : arr_idsclientes) {
					
					cliente = new ClientesDTO();
					try{
						cliente.setIdcliente(Integer.parseInt(id));
						cliente.setEstatus(1);
						bo.updateEstatus(cliente);
					}catch(Exception e){
						logger.error("Identificador de cliente invalido:" + id);
					}
					
				}
			}
			modelMap.put("success", true);
			modelMap.put("message", "Registros seleccionados fueron activados");
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
		}
		return modelMap;
	}
		
	
	
}
