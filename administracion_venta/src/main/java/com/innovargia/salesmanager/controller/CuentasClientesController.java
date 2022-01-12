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
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.PerfilOpcionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.ICuentasClientesBO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.sql.ExcepcionMessage;

/**
 * @author Adri�n
 * /catalogo/cuentasclientes/getDatos
 */
@RequestMapping("/catalogo/cuentasclientes")
@Controller
public class CuentasClientesController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CuentasClientesController.class);


	@Autowired 
	ICuentasClientesBO bo;
	
	
	/**
	 * 
	 */
	public CuentasClientesController() {
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
			@RequestParam(value = "identidad", required = false) String identidad,
			@RequestParam(value = "idorganizacion", required = false) String idorganizacion,
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		BusquedaDTO busqueda = new BusquedaDTO();
		int i_tipobusqueda = (tipobusqueda==null) || (tipobusqueda.trim().length()<=0)?-1:Integer.parseInt(request.getParameter("tipobusqueda"));
		int estatus =  request.getParameter("estatus")==null?-1: Integer.parseInt(request.getParameter("estatus"));
		List<CuentasDTO> lista = new ArrayList<CuentasDTO>();
		try {
			busqueda.setIdentidad(identidad);
			busqueda.setIdorganizacion(idorganizacion);
			busqueda.setTipo(i_tipobusqueda);
			busqueda.setPatron_busqueda(patronbusqueda);
			busqueda.setEstatus(estatus);
			lista = bo.getBusquedaRegistros(busqueda);

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
			@RequestParam(value = "cuentaMaestra", required = false) String cuentaMaestra,
			@RequestParam(value = "identidad", required = false) int identidad,
			@RequestParam(value = "idorganizacion", required = false) int idorganizacion,
			@RequestParam(value = "idgrupo", required = false) String idgrupo,
			@RequestParam(value = "numCliente", required = false) String numcliente,
			@RequestParam(value = "descripcion", required = false) String descripcion,
			@RequestParam(value = "razonSocial", required = false) String razonSocial,
			@RequestParam(value = "atencion", required = false) String atencion,
			@RequestParam(value = "referencia", required = false) String referencia,
			@RequestParam(value = "rfc", required = false) String rfc,
			@RequestParam(value = "observacion", required = false) String observacion,
			@RequestParam(value = "estatus" , required = false) String estatus,
			@RequestParam(value = "calle" , required = false) String calle,
			@RequestParam(value = "numexterior" , required = false) String numexterior,
			@RequestParam(value = "numinterior" , required = false) String numinterior,
			@RequestParam(value = "cp" , required = false) String cp,
			@RequestParam(value = "colonia" , required = false) String colonia,
			@RequestParam(value = "municipio" , required = false) String municipio,
			@RequestParam(value = "estado" , required = false) String estado,
			@RequestParam(value = "correoe" , required = false) String correoe,
			@RequestParam(value = "telefono" , required = false) String telefono,
			@RequestParam(value = "movil" , required = false) String movil,
			@RequestParam(value = "direcciondefault" , required = false) String direcciondefault,
			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CuentasDTO cliente = new CuentasDTO();
		UtilsRequest.displayParametros(request);
		
		try {
			cliente.setCuentaMaestra(cuentaMaestra);
			cliente.setIdentidad(identidad);
			cliente.setIdorganizacion(idorganizacion);
			cliente.setNumCliente(numcliente);
			cliente.setAtencion(atencion);
			cliente.setRazonSocial(razonSocial);
			cliente.setRfc(rfc);
			cliente.setCalle(calle);     
			cliente.setColonia(colonia);
			cliente.setMunicipio(municipio);
			cliente.setEstado(estado);
			cliente.setTelefono(telefono);
			cliente.setCp(cp);
			cliente.setRfc(rfc);
			cliente.setCorreoe(correoe);
			cliente.setVertodasdirecciones("S");
			cliente.setObservacion(observacion);
			bo.insert(cliente);
			
			modelMap.put("success", true);
			modelMap.put("message", "Registro agregado de forma correcta.");
		} catch (Exception dae) {
			modelMap.put("success", success);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
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
			@RequestParam(value = "cuentaMaestra", required = false) String cuentaMaestra,
			@RequestParam(value = "identificador", required = false) String identificador,
			@RequestParam(value = "idgrupo", required = false) String idgrupo,
			@RequestParam(value = "numCliente", required = false) String numcliente,
			@RequestParam(value = "descripcion", required = false) String descripcion,
			@RequestParam(value = "razonSocial", required = false) String razonSocial,
			@RequestParam(value = "atencion", required = false) String atencion,
			@RequestParam(value = "referencia", required = false) String referencia,
			@RequestParam(value = "rfc", required = false) String rfc,
			@RequestParam(value = "observacion", required = false) String observacion,
			@RequestParam(value = "estatus" , required = false) String estatus,
			@RequestParam(value = "calle" , required = false) String calle,
			@RequestParam(value = "numexterior" , required = false) String numexterior,
			@RequestParam(value = "numinterior" , required = false) String numinterior,
			@RequestParam(value = "cp" , required = false) String cp,
			@RequestParam(value = "colonia" , required = false) String colonia,
			@RequestParam(value = "municipio" , required = false) String municipio,
			@RequestParam(value = "estado" , required = false) String estado,
			@RequestParam(value = "correoe" , required = false) String correoe,
			@RequestParam(value = "telefono" , required = false) String telefono,
			@RequestParam(value = "movil" , required = false) String movil,
			@RequestParam(value = "direcciondefault" , required = false) String direcciondefault,
			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CuentasDTO cliente = new CuentasDTO();
		UtilsRequest.displayParametros(request);
		
		try {
			cliente.setCuentaMaestra(cuentaMaestra);
			cliente.setIdentificador(identificador);
			cliente.setNumCliente(numcliente);
			cliente.setAtencion(atencion);
			cliente.setRazonSocial(razonSocial);
			cliente.setRfc(rfc);
			cliente.setCalle(calle);     
			cliente.setColonia(colonia);
			cliente.setMunicipio(municipio);
			cliente.setEstado(estado);
			cliente.setTelefono(telefono);
			cliente.setCp(cp);
			cliente.setCorreoe(correoe);
			cliente.setVertodasdirecciones("S");
			cliente.setObservacion(observacion);
			bo.update(cliente);
			
			modelMap.put("success", true);
			modelMap.put("message", "Registro modificado de forma correcta.");
		} catch (Exception dae) {
			modelMap.put("success", success);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
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
			@RequestParam(value = "identificador", required = true) String identificador,
			HttpServletRequest request)	throws Exception {

		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UtilsRequest.displayParametros(request);
		CuentasDTO cliente = new CuentasDTO();
		try {
			cliente.setIdentificador(identificador);
			bo.delete(cliente);
			
			modelMap.put("success", true);
			modelMap.put("message", "Registro borrado de forma correcta.");
		} catch (Exception dae) {
			modelMap.put("success", success);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios ser�n deshechos, verifique.";
			}

		}
		return modelMap;
	}
	
	/**
	 * Desactivan o Activa un registro 
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/cambiarestatus")
	public @ResponseBody
	Map<String, ? extends Object> cambiarestatus(
			@RequestParam(value = "ids", required = true) String ids,
			@RequestParam(value = "estatus", required = true) String estatus,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		PerfilOpcionDTO documento = null;
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			CuentasDTO cliente = new CuentasDTO();
			if (ids != null) {
				String[] arr_idstarifas = ids.trim().split("\\|");
				for (String id : arr_idstarifas) {

					documento = new PerfilOpcionDTO();
					try {
						cliente.setIdentificador(id);
						if (estatus.trim().equals("A")){
							cliente.setEstatus(true);
						}else{
							cliente.setEstatus(false);
						}
						
						bo.updateEstatus(cliente);

					} catch (Exception e) {
						logger.error("Error:" + e.getMessage());
					}

				}
			}
			modelMap.put("success", true);
			modelMap.put("message",
					"Se cambio el estatus de los registros seleccionados.");

		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}
		
			
		
		return modelMap;
	}
	
	@RequestMapping("/cambiartipomanejo")   
	public @ResponseBody
	Map<String, ? extends Object> cambiartipomanejo(
			@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "tipomanejo", required = true) int tipomanejo,
			HttpServletRequest request)	throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			CuentasDTO cliente = new CuentasDTO();
			cliente.setIdentificador(id);
			cliente.setTipofolio(tipomanejo);
			bo.updateTipoManejo(cliente);

			modelMap.put("success", true);
			modelMap.put("message",
					"Se cambio el estatus de los registros seleccionados.");

		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}
		
			
		
		return modelMap;
	}
	
	
}
