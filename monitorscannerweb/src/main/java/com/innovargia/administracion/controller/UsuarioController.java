package com.innovargia.administracion.controller;

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

import com.innovargia.administracion.dao.impl.PasswordValidator;
import com.innovargia.administracion.ibo.IAdminPasswordBO;
import com.innovargia.administracion.ibo.IUsuarioBO;
import com.innovargia.constantes.ConstantesUtils;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.NivelUsuarioDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.INivelUsuarioBO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.sql.ExcepcionMessage;


/**
 * 
 * @author aruaro
 * /catalogo/usuario/getUsuariosPertenicientesAlAgrupamiento
 */
@RequestMapping("/catalogo/usuario/")
@Controller
public class UsuarioController {

	
	private static final Logger logger = LoggerFactory
			.getLogger(UsuarioController.class);
		
	@Autowired
	IUsuarioBO bo;
	@Autowired
	INivelUsuarioBO iNivelUsuarioBO;
	
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
								usuario.getPassword(), ConstantesUtils.ESTADO_ACTIVO);
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
	
	@RequestMapping("/getUsuariosDisponiblesAgrupamiento")
	public @ResponseBody
	Map<String, ? extends Object> getUsuariosDisponiblesAgrupamiento(
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

			UtilsRequest.displayParametros(request);
			lista = bo.getUsuariosDeUnAgrupamientoYNivel(usuario);     

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


}
