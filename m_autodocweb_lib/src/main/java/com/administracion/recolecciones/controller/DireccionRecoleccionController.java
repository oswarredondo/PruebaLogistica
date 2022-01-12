/**
 * 
 */
package com.administracion.recolecciones.controller;

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

import com.innovargia.recolecciones.ibo.IDireccionRecoleccionBO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.ConstantesAutoDoc;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.UtilsStrings;

/**
 * @author Adri�n
 *
 */
@RequestMapping("/direccionrecoleccion")
@Controller
public class DireccionRecoleccionController  {
	
	 public  final String BUSCA_INICIO_CADENA = "1";
	    public  final String BUSCA_FINAL_CADENA = "2";
	    public  final String BUSCA_CUALQUIEN_LUGAR = "3";
	    
	    public  final String CAMPO_BUSCA_RAZONSOCIAL = "rs";
	    public  final String CAMPO_BUSCA_ATENCION = "ate";
	    public  final String CAMPO_BUSCA_RFC = "rfc";
	    
	    public  final int ORDER_X_RAZONSOCIAL = 2;
	    public  final int ORDER_X_IDREMDES = 1;
	    public  final int ORDER_X_ATENCION = 3;
	    
	
	private static final Logger logger = LoggerFactory
			.getLogger(DireccionRecoleccionController.class);
	
	@Autowired
	IDireccionRecoleccionBO iDireccionesRecoleccionBO; 
	@Autowired 
	//ICuentasClientesBO iCuentasClientesBO;

	/**
	 * 
	 */
	public DireccionRecoleccionController() {
		// TODO Auto-generated constructor stub
	}

	

	/***
	 * COnfigura los datos de una solicitud enviados por el request
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	private RemDes getRequest(HttpServletRequest request) {

		RemDes remdes = new RemDes();
		
		remdes.setRazonSocial(UtilsStrings.nullChangeToUpperCase( request.getParameter("razonsocial")));
		remdes.setDireccion(UtilsStrings.nullChangeToUpperCase( request.getParameter("direccion")));
		remdes.setIdRmDes(UtilsStrings.nullChangeToUpperCase( request.getParameter("idremdes")));
		remdes.setTelefono(UtilsStrings.nullChangeToUpperCase( request.getParameter("telefono")));
		remdes.setRfc((UtilsStrings.nullChangeToUpperCase( request.getParameter("rfc"))));
		remdes.setColonia((UtilsStrings.nullChangeToUpperCase( request.getParameter("colonia"))));
		remdes.setAtencion(((UtilsStrings.nullChangeToUpperCase( request.getParameter("atencion")))));
		remdes.setCp((UtilsStrings.nullChangeToUpperCase( request.getParameter("cp"))));
		remdes.setMunicipio((UtilsStrings.nullChangeToUpperCase( request.getParameter("municipio"))));
		remdes.setEstado((UtilsStrings.nullChangeToUpperCase( request.getParameter("estado"))));
		remdes.setCorreoe((UtilsStrings.nullChangeToUpperCase( request.getParameter("email"))));
		remdes.setDepto((UtilsStrings.nullChangeToUpperCase( request.getParameter("departamento"))));
		remdes.setNumcelular((UtilsStrings.nullChangeToUpperCase( request.getParameter("celular"))));
		remdes.setIdregistro(UtilsStrings.nullChangeToUpperCase( request.getParameter("idregistro")) );
		return remdes;
	}
	
	

	@RequestMapping("/saveClientesAgenda")
		public @ResponseBody
			Map<String, ? extends Object> saveClientesAgenda(
					HttpServletRequest request)	throws Exception {		
		
		

		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		
		// Obtiene los datos del registro
		RemDes remdes =getRequest(request);
		

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		try {
			remdes.setNumCliente(usuario.getNumCliente());
			if ((remdes.getIdregistro() == null)
					|| (remdes.getIdregistro().trim().length() <= 0)) {
				iDireccionesRecoleccionBO.insert(usuario.entidad.getIdentidad(),
						usuario.organizacion.getIdorganizacion(),remdes);
			} else {
				// Actualiza registro
				iDireccionesRecoleccionBO.update(remdes);
			}

			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

		} catch (Exception e) {
			modelMap.put("success", true);
			logger.info("Error en el metodo de saveClientesAgenda:" +  e.getMessage());
			modelMap.put("message", "Error en el metodo de saveClientesAgenda");
		}
		
		return modelMap;
	}
	
	

		
	@RequestMapping("/deleteRemDes")
	public @ResponseBody
			Map<String, ? extends Object> deleteRemDes(
					HttpServletRequest request)	throws Exception {		
		
		

		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
	
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		// Obtiene los datos del registro
		String idremdes = request.getParameter("idregistro")==null?"":request.getParameter("idregistro");
		RemDes remdes = new RemDes();
		remdes.setIdregistro(idremdes);;
		remdes.setNumCliente(usuario.getNumCliente());
		
		String deleteall = request.getParameter("deleteall");
		try {
			
			if ((deleteall==null) || (deleteall.trim().length()<=0)){
				iDireccionesRecoleccionBO.delete(remdes, usuario);
				modelMap.put("message", "Se elminino la cuenta seleccionada, actualice datos de consulta");
			}else{
				modelMap.put("message", "Operacion de borrado invalida");
			}
			modelMap.put("success", true);
			
		

		} catch (Exception e) {
			modelMap.put("success", false);
			logger.info("Error en el metodo de deleteRemDes:" +  e.getMessage());
			modelMap.put("message", "Error en el metodo de deleteRemDes");

		}

		return modelMap;
	}
	
	
	@RequestMapping("/depuraRotulacionTemporal")
	public @ResponseBody
		Map<String, ? extends Object> depuraRotulacionTemporal(
				HttpServletRequest request)	throws Exception {	
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		

		modelMap.put("success", true);
		modelMap.put("message", "Correcto");
		return modelMap;
	}
	
	@RequestMapping("/busquedaDireccionRecoleccion")
	public @ResponseBody
		Map<String, ? extends Object> busquedaDireccionRecoleccion(
				HttpServletRequest request)	throws Exception {	
		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		// Verifica si el usuario tiene una sesion valida
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));

		String campo_filtro = request.getParameter("campo_filtro");

		if ((campo_filtro == null)
				|| ("razonsocial".equals(campo_filtro.trim()))) {
			campo_filtro = CAMPO_BUSCA_RAZONSOCIAL;
			;
		} else if ((campo_filtro == null)
				|| ("atencion".equals(campo_filtro.trim()))) {
			campo_filtro = CAMPO_BUSCA_ATENCION;
		} else if ((campo_filtro == null)
				|| ("rfc".equals(campo_filtro.trim()))) {
			campo_filtro = CAMPO_BUSCA_RFC;
		} else {
			return null;
		}

		// Obtiene la variable que indicai la solicitud viene de administracion
		// esto con el fin de controlar si ve todas las direcciones o solo las
		// propias
		String vertodasdirecciones = "N";
		if ((request.getParameter("admnistracion") == null)
				|| (request.getParameter("admnistracion").trim().length() <= 0)) {
			// toma la variable ver todas las idrecciones dependiendo de la
			// configuracion del usuario
			vertodasdirecciones = "N";
		} else {
			vertodasdirecciones = usuario.cuenta.getVertodasdirecciones();
		}
		
		String patron = request.getParameter("patron");
		// Obtiene los registros de usuario
		try{
			List<RemDes> lista = iDireccionesRecoleccionBO.getBuscaDireccion(
					usuario.entidad.getIdentidad(),
					usuario.organizacion.getIdorganizacion(),
					usuario.getNumCliente(), patron, ORDER_X_RAZONSOCIAL,
					campo_filtro, BUSCA_INICIO_CADENA,
					vertodasdirecciones);

			modelMap.put("success", true);
			modelMap.put("message", "Correcto");
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
		}catch(Exception e){
			modelMap.put("success", false);
			logger.info("Error en el metodo de busquedaDireccionRecoleccion:" +  e.getMessage());
			modelMap.put("message", "Error en el metodo de busquedaDireccionRecoleccion");
		}
		


		return modelMap;
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
	@RequestMapping("/getDatosCuentas")
	public @ResponseBody
	Map<String, ? extends Object> getDatosCuentas(
			@RequestParam(value = "tipobusqueda", required = false) String tipobusqueda,
			@RequestParam(value = "patronbusqueda", required = false) String patronbusqueda,
			@RequestParam(value = "identidad", required = false) String identidad,
			@RequestParam(value = "idorganizacion", required = false) String idorganizacion,
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAutoDoc.getSession(request.getSession(true));
		BusquedaDTO busqueda = new BusquedaDTO();
		int i_tipobusqueda = (tipobusqueda==null) || (tipobusqueda.trim().length()<=0)?-1:Integer.parseInt(request.getParameter("tipobusqueda"));
		int estatus =  request.getParameter("estatus")==null?-1: Integer.parseInt(request.getParameter("estatus"));
		List<CuentasDTO> lista = new ArrayList<CuentasDTO>();
		try {
			busqueda.setIdentidad(usuario.entidad.getIdentidad());
			busqueda.setIdorganizacion(usuario.organizacion.getIdorganizacion());
			busqueda.setTipo(i_tipobusqueda);
			busqueda.setPatron_busqueda(patronbusqueda);
			busqueda.setEstatus(estatus);
			//lista = iCuentasClientesBO.getBusquedaRegistros(busqueda);

			modelMap.put("success", true);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
		} catch (DataAccessException e) {
			modelMap.put("success", false);
			logger.info("Error en el metodo de getDatosCuentas:" +  e.getMessage());
			modelMap.put("message", "Error en el metodo de getDatosCuentas");
		}
		return modelMap;
		
	}

}
