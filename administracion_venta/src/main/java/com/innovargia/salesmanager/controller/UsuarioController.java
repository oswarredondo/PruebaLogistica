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

import com.administracion.dto.UsuarioConvenioFolio;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.NivelUsuarioDTO;
import com.innovargia.salesmanager.dtos.PerfilOpcionDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IAdminPasswordBO;
import com.innovargia.salesmanager.ibo.INivelUsuarioBO;
import com.innovargia.salesmanager.ibo.IPDVBO;
import com.innovargia.salesmanager.ibo.IUsuarioBO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.PasswordValidator;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.sql.ExcepcionMessage;
import com.servicio.dtos.OficinasDTO;
import com.servicio.search.ibo.IBusquedaOficinasBO;


/**
 * 
 * @author aruaro
 *  /catalogo/usuario/getPDVAsignadosAlUsuario
 */
@RequestMapping("/catalogo/usuario")
@Controller
public class UsuarioController {

	
	private static final Logger logger = LoggerFactory
			.getLogger(UsuarioController.class);
		
	@Autowired
	IUsuarioBO bo;
	@Autowired
	INivelUsuarioBO iNivelUsuarioBO;
	@Autowired
	IUsuarioBO iUsuarioBO;
	@Autowired
	IPDVBO ipdvbo;
	@Autowired
	IBusquedaOficinasBO iBusquedaOficinasBO;

	@Autowired
	IAdminPasswordBO iAdminPasswordBO;
	public UsuarioController() {
		// TODO Auto-generated constructor stub
	}
	
	/***
	 * Actualiza el password del usuario
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updatepassword")
	public @ResponseBody
	Map<String, ? extends Object> updatepassword(
			@RequestParam(value = "numcliente", required = false) String numCliente,
			@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "pass", required = false) String password,
			@RequestParam(value = "confirmacionpass", required = false) String confirmacionpass,
			@RequestParam(value = "enviarPassword", required = false) String enviarPassword,
			
			HttpServletRequest request) throws Exception {


		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = new UsuarioDTO();
		
		UtilsRequest.displayParametros(request);

		
		
		UsuarioDTO usuario_session = ConstantesAdminSale.getSession(request.getSession(true));
		try {
			confirmacionpass = confirmacionpass==null?"":confirmacionpass.trim();//.toUpperCase();
			password = password==null?"":password.trim();//.toUpperCase();
			if (password.trim().length()<=0){
				throw new Exception("Password de usuario invalido.");
			}
			if (confirmacionpass.trim().length()<=0){
				throw new Exception("Confirmacion del Password invalido.");
			}
			
			if (!confirmacionpass.trim().equals(password)){
				throw new Exception("Password no coincide con la confirmacion verifique.");
			}
			
			usuario.setLogin(login);
			usuario.setPassword(password);
			usuario.setNumCliente(numCliente);

			
			if (usuario_session!=null){
				PasswordValidator validator = PasswordValidator.buildValidator(
						PasswordValidator.ForceSpecialChar, 
						PasswordValidator.ForceCapitalLetter,PasswordValidator.ForceLowerLetter,
						PasswordValidator.ForceNumber, PasswordValidator.MinLength, PasswordValidator.MaxLength);

				
				if (validator.validatePassword(usuario.getPassword())){
					mensaje="Password debe no cumple con las politicas de seguridad(Debe tener al menos " + PasswordValidator.MinLength +" caracteres "
							+ "y maximo " + PasswordValidator.MaxLength +", debe tener al menos una letra de la a-z, una letra de A-Z , "
							+ "un numero 0-9 y un caracter especial @#$%";
				}else{
					//bo.updatePassword(usuario);
					if (iAdminPasswordBO.existeLoginPass(usuario.getLogin(), usuario.getPassword())){
						mensaje="Password ya fue utilizado anteriormente, por seguridad no es permitido repetirlo";
					}else{
						iAdminPasswordBO.insertHistorial(usuario.getLogin(), 
								usuario.getPassword(), ConstantesAdminSale.ESTADO_ACTIVO);
						mensaje="Se actualizo correctamente el Password del usuario " + login;
					}
					
					
				}
				success = true;
			}else{
				mensaje=ConstantesAdminSale.MSG_SESSION_FINISH;
			}
			
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
		} catch (Exception dae) {
				modelMap.put("success", success);
				modelMap.put("message", dae.getMessage());
		}
		return modelMap;
	}
	
	
	/***
	 * Actualiza el wallpaper del usuario
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/updatewallpaper")
	public @ResponseBody
	Map<String, ? extends Object> updatewallpaper(
			@RequestParam(value = "numcliente", required = false) String numCliente,
			@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "wallpaper", required = false) String wallpaper,
			HttpServletRequest request) throws Exception {


		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = new UsuarioDTO();
		
		UtilsRequest.displayParametros(request);

		
		
		UsuarioDTO usuario_session = ConstantesAdminSale.getSession(request.getSession(true));
		try {
		
			usuario.setLogin(login);
			usuario.setWallpaper(wallpaper);
			usuario.setNumCliente(numCliente);
			bo.updateWallPaper(usuario);
			
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
		} catch (Exception dae) {
				modelMap.put("success", success);
				modelMap.put("message", dae.getMessage());
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
	@RequestMapping("/getUsuariosCuenta")
	public @ResponseBody
	Map<String, ? extends Object> getUsuariosCuenta(
			@RequestParam(value = "identidad", required = false) String identidad,
			@RequestParam(value = "idorganizacion", required = false) String idorganizacion,
			@RequestParam(value = "numCliente", required = false) String numcliente,
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		BusquedaDTO busqueda = new BusquedaDTO();
			List<UsuarioCuentaDTO> lista = new ArrayList<UsuarioCuentaDTO>();
		try {
			UtilsRequest.displayParametros(request);
			busqueda.setIdentidad(identidad);
			busqueda.setIdorganizacion(idorganizacion);
			busqueda.setNumcliente(numcliente);
			
			lista = bo.getRegistrosCuentaCliente(busqueda);

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
	
	
	
	/**
	 * Obtiene los datos del usuarios que pertenescan a alguno de los 
	 * grupos del usuario indicado por el login. Si no se indica un login
	 * se toma el login del usuario de sesion
	 * @param identificador
	 * @param descripcion
	 * @param nombre
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getUsuariosPertenicientesAlAgrupamiento")
	public @ResponseBody
	Map<String, ? extends Object> getUsuariosPertenicientesAlAgrupamiento(
			@RequestParam(value = "login", required = false) String login,
			HttpServletRequest request)throws Exception {

		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		BusquedaDTO busqueda = new BusquedaDTO();
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		
		try {

			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			if ((login==null) || (login.trim().length()<=0)){
				login=usuario.getLogin();
			}
			UtilsRequest.displayParametros(request);
			UsuarioDTO usuario_busqueda = new UsuarioDTO();
			usuario_busqueda.setLogin(login);
			lista = bo.getUsuariosDeUnAgrupamiento(usuario_busqueda);

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
			@RequestParam(value = "idperfil", required = false) String idperfil,
			@RequestParam(value = "identidad", required = false) int identidad,
			@RequestParam(value = "idorganizacion", required = false) int idorganizacion,
			@RequestParam(value = "nivelpuesto", required = false) int nivelpuesto,
			@RequestParam(value = "idoficina", required = false) String idoficina,
			@RequestParam(value = "formatoetiperso", required = false) String formatoetiperso,
			@RequestParam(value = "siglasplaza", required = false) String siglasplaza,
		
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "numempleado", required = false) String numempleado,
			@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "numcliente", required = false) String numcliente,
			@RequestParam(value = "formatoetimedia", required = false) String formatoetimedia,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "idagrupamiento", required = false) String idagrupamiento,
			@RequestParam(value = "visibilidad", required = false) String visibilidad,
			HttpServletRequest request
	)	throws Exception {

		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioCuentaDTO usuario_tmp = new UsuarioCuentaDTO();
		String mensaje;
		try {
			UtilsRequest.displayParametros(request);
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}

			usuario_tmp.setIdentidad(identidad);
			usuario_tmp.setIdorganizacion(idorganizacion);
			usuario_tmp.setNivelpuesto(nivelpuesto);
			usuario_tmp.setIdoficina(idoficina);
			usuario_tmp.setFormatoetimedia(formatoetimedia);
			usuario_tmp.setFormatoetiperso(formatoetiperso);
			usuario_tmp.setSiglasplaza(siglasplaza);
			usuario_tmp.setNumempleado(numempleado);
			usuario_tmp.setLogin(login);
			usuario_tmp.setNumcliente(numcliente);
			usuario_tmp.setNombre(nombre);
			usuario_tmp.setEmail(email);
			usuario_tmp.setIdperfil(idperfil);
			usuario_tmp.setIdagrupamiento(idagrupamiento);
			
			bo.insert(usuario_tmp);
			
			//Se agrega un usuario por default que es el mismo del login en el password
			//y caducidad Temporal 
			usuario_tmp.setPassword(login); 
			//obligando a usuario a cambiar el password cada la primera vez que entre
			iAdminPasswordBO.insertHistorial(usuario_tmp.getLogin(),
					usuario_tmp.getPassword(), 
					ConstantesAdminSale.ESTADO_TEMPORAL);
			modelMap.put("success", true);
			modelMap.put("message", "Registro agregado de forma correcta.");
		} catch (Exception dae) {
			modelMap.put("success", false);
			mensaje = ExcepcionMessage.getMessageExcepcion(dae.getMessage());
			if (dae.getMessage().contains("duplicate key")) {
				mensaje += ". Los cambios seran deshechos, verifique.";
			}
			modelMap.put("message", mensaje);
		}
		return modelMap;
	}
	
	@RequestMapping("/insertUsuarioConvenio")
	public @ResponseBody
	Map<String, ? extends Object> insertUsuarioConvenio(
			@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "idconvenio", required = false) int idconvenio,
			HttpServletRequest request)	throws Exception {

		boolean success = false;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		String mensaje;
		try {
			UtilsRequest.displayParametros(request);
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			UsuarioDTO usuario_existente = new UsuarioDTO();
			usuario_existente.setLogin(login);
			usuario_existente = bo.getUsuarioLogin(usuario_existente);
			
			if (usuario_existente!=null){
			    UsuarioCuentaDTO usuario_cuenta = new UsuarioCuentaDTO();
			    usuario_cuenta.setLogin(login);
			    usuario_cuenta.setIdentidad(usuario_existente.entidad.getIdentidad());
			    usuario_cuenta.setIdorganizacion(
				    usuario_existente.organizacion.getIdorganizacion());
			    bo.insertConvenioUsuario(usuario_cuenta, idconvenio); 
			}
			 
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
	
	/***
	 * update un registro 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/update")
	public @ResponseBody
	Map<String, ? extends Object> update(
			@RequestParam(value = "consecutivo", required = false) int consecutivo,
			@RequestParam(value = "idperfil", required = false) String idperfil,
			@RequestParam(value = "identidad", required = false) int identidad,
			@RequestParam(value = "idorganizacion", required = false) int idorganizacion,
			@RequestParam(value = "nivelpuesto", required = false) int nivelpuesto,
			@RequestParam(value = "idoficina", required = false) String idoficina,
			@RequestParam(value = "formatoetiperso", required = false) String formatoetiperso,
			@RequestParam(value = "siglasplaza", required = false) String siglasplaza,
			@RequestParam(value = "email", required = false) String email,
			
			
			@RequestParam(value = "numempleado", required = false) String numempleado,
			@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "numcliente", required = false) String numcliente,
			@RequestParam(value = "formatoetimedia", required = false) String formatoetimedia,
			@RequestParam(value = "nombre", required = false) String nombre,
			@RequestParam(value = "idagrupamiento", required = false) String idagrupamiento,
			@RequestParam(value = "visibilidad", required = false) String visibilidad,

			HttpServletRequest request
	)	throws Exception {

		boolean success = false;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioCuentaDTO usuario_tmp = new UsuarioCuentaDTO();
		String mensaje;
		try {
			UtilsRequest.displayParametros(request);
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			usuario_tmp.setConsecutivo(consecutivo);
			usuario_tmp.setIdentidad(identidad);
			usuario_tmp.setIdorganizacion(idorganizacion);
			usuario_tmp.setNivelpuesto(nivelpuesto);
			usuario_tmp.setIdoficina(idoficina);
			usuario_tmp.setFormatoetimedia(formatoetimedia);
			usuario_tmp.setFormatoetiperso(formatoetiperso);
			usuario_tmp.setSiglasplaza(siglasplaza);
			usuario_tmp.setNumempleado(numempleado);
			usuario_tmp.setLogin(login);
			usuario_tmp.setNumcliente(numcliente);
			usuario_tmp.setNombre(nombre);
			usuario_tmp.setIdperfil(idperfil);
			usuario_tmp.setEmail(email);
			usuario_tmp.setIdagrupamiento(idagrupamiento);
			usuario_tmp.setVisibilidad(visibilidad);
			bo.update(usuario_tmp);
			 
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
	/***
	 * Obtiene el nivel del usuario en sesion
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getNivelUsuarioSesion")
	public @ResponseBody
	Map<String, ? extends Object> getNivelUsuarioSesion(HttpServletRequest request)	throws Exception {

		boolean success = false;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioCuentaDTO usuario_tmp = new UsuarioCuentaDTO();
		String mensaje;
		try {
			UtilsRequest.displayParametros(request);
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			NivelUsuarioDTO  nivel  = iNivelUsuarioBO.get(usuario.getNivelPuesto());
			 
			modelMap.put("success", true);
			modelMap.put("idnivelusuario", nivel.getIdnivelusuario());
			modelMap.put("descripcion", nivel.getDescripcion());
			modelMap.put("visiblesiempre", nivel.getVisiblesiempre());
			modelMap.put("maxdescadicional", nivel.getMaxdescadicional());
			modelMap.put("maxdesctarifas", nivel.getMaxdesctarifas());
			
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
	/***
	 * Delete un registro 
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delete")
	public @ResponseBody
	Map<String, ? extends Object> delete(
			@RequestParam(value = "consecutivo", required = false) int consecutivo,
			HttpServletRequest request
	)	throws Exception {

		boolean success = false;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioCuentaDTO usuario_tmp = new UsuarioCuentaDTO();
		String mensaje;
		try {
			UtilsRequest.displayParametros(request);
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			
			usuario_tmp.setConsecutivo(consecutivo);
			bo.delete(usuario_tmp);
			 
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
			UsuarioCuentaDTO cliente = new UsuarioCuentaDTO();
			if (ids != null) {
				String[] arr_idstarifas = ids.trim().split("\\|");
				for (String id : arr_idstarifas) {

					documento = new PerfilOpcionDTO();
					try {
						cliente.setConsecutivo(id);
						cliente.setEstatus(estatus);
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
	
	
	
	
	@RequestMapping("/insertUsuarioPDVs")
	public @ResponseBody
	Map<String, ? extends Object> insertUsuarioPDVs(
			@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "numcliente", required = false) String numcliente,
			@RequestParam(value = "identidad", required = false) int identidad,
			@RequestParam(value = "idoficinas", required = false) String idoficinas,
			@RequestParam(value = "idorganizacion", required = false) int idorganizacion,
			HttpServletRequest request)throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		
		List<UsuarioConvenioFolio> lista = new ArrayList<UsuarioConvenioFolio>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		String convenio_noasignados ="";
		try {
			UtilsRequest.displayParametros(request);
			UsuarioCuentaDTO usuario_cuenta = new UsuarioCuentaDTO();
			usuario_cuenta.setNumcliente(numcliente==null?"":numcliente);
			usuario_cuenta.setIdentidad(identidad);
			usuario_cuenta.setIdorganizacion(idorganizacion);
			usuario_cuenta.setLogin(login);
			String[] oficnas = idoficinas.trim().split(","); 
			//ConvenioContratoDTO convenioContratoDTO = new ConvenioContratoDTO();
			
			for (String oficina : oficnas) {
			    try {
				ipdvbo.insertaOficinaUsuario(login, oficina);
				
				
			    } catch (Exception e) {
				logger.error("Error al asignar idoficinas[" + idoficinas
					+"] a usuario:" + e.getMessage());
			    }
			}
			
			
			modelMap.put("success", true);
			if (convenio_noasignados.trim().length()<=0){
			    modelMap.put("message", "Se asignaron los convenios");
			}else{
			    modelMap.put("message", "Se asignaron los convenios. "
			    	+ "Los siguientes convenios [" +  convenio_noasignados.trim()
			    	+" ] no pertenecen al numero de cuenta del usuario seleccionado.");  
			}
			
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());
		}
		return modelMap;
		
	}
	
	@RequestMapping("/desasignaroficinadelusuario")
	public @ResponseBody
	Map<String, ? extends Object> desasignaroficinadelusuario(
			@RequestParam(value = "oficinas", required = true) String oficinas,
			HttpServletRequest request)	throws Exception {

		
		HashMap<String, Object> modelMap = new HashMap<String, Object>();


		try {
		    	UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		    	UsuarioDTO usuario_tmp = new UsuarioDTO();
		    	usuario_tmp.setLogin(request.getParameter("login"));
		    	
		    	if (usuario==null){
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
		    	String[] arr_oficinas = oficinas.split(",");
		    	for (String ofi : arr_oficinas) {
		    	    ipdvbo.deleteUsuarioDeOficina(usuario_tmp.getLogin(), ofi.toUpperCase());
			}
			
			modelMap.put("success", true);
			modelMap.put("message", "Se agregaron de forma correcta las oficinas");
		} catch (Exception dae) {
		    logger.debug("creaRegistro:" + dae.getMessage());
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}

	
	@RequestMapping("/getPDVAsignadosAlUsuario")
	public @ResponseBody
	Map<String, ? extends Object> getPDVAsignadosAlUsuario(HttpServletRequest request)throws Exception {
	
		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		CatalogoDTO objeto = new CatalogoDTO();
		objeto.setEstatus(-1);
		List<OficinasDTO> lista =null;
		try {
		    	UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		    	UsuarioDTO usuario_tmp = new UsuarioDTO();
		    	usuario_tmp.setLogin(request.getParameter("login"));
		    	BusquedaDTO busqueda = new BusquedaDTO();
		    	busqueda.setUsuario(usuario_tmp);
		    	busqueda.setTipo(request.getParameter("tipo"));
		    	busqueda.setPatron_busqueda(request.getParameter("login"));
		    	
			lista  = iBusquedaOficinasBO.getPDVAsignadosAlUsuario(busqueda); 
			success = true;
			modelMap.put("success", success);
			modelMap.put("message", mensaje);
			modelMap.put("totalCount", lista.size());
			modelMap.put("proxiArray", lista);
			
		} catch (DataAccessException dae) {
				modelMap.put("success", false);
				modelMap.put("message", dae.getMessage());
		}
		return modelMap;
		
	}
	

}
