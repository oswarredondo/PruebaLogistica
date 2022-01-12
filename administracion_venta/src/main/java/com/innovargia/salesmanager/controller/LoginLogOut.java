/**
 * 
 */
package com.innovargia.salesmanager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.innovargia.salesmanager.dtos.PerfilOpcionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IAdminPasswordBO;
import com.innovargia.salesmanager.ibo.IPerfilOpcionUsuarioBO;
import com.innovargia.salesmanager.ibo.IUsuarioBO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.PasswordValidator;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.UtilsStrings;
import com.servicio.constantes.ConstantesGenerales;

/**
 * @author Adri�n /acceso
 *
 */
@RequestMapping("/acceso")
@Controller
public class LoginLogOut {
	private static final Logger logger = LoggerFactory.getLogger(LoginLogOut.class);

	@Autowired
	IUsuarioBO iusuarioBO;
	@Autowired
	IPerfilOpcionUsuarioBO iPerfilOpcionUsuarioBO;
	@Autowired
	IAdminPasswordBO iAdminPasswordBO;
	
	@Autowired
	IUsuarioBO bo;

	public LoginLogOut() {
	}

	@RequestMapping(value = "/check_sesion")
	public @ResponseBody Map<String, ? extends Object> check_sesion(HttpServletRequest request) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		// UtilsRequest.displayParametros(request);
		try {
			// Verifica sesion del usuario
			if (usuario == null) {

				// Se reconecta el sistema
				UsuarioDTO usuario_tmp = new UsuarioDTO();
				usuario_tmp.setLogin(UtilsStrings.nullChangeToUpperCase(request.getParameter("lo")));
				usuario_tmp.setPassword(request.getParameter("pa"));
				usuario_tmp = iusuarioBO.checkSesoinUsuarioLogin(usuario_tmp);

				boolean existeUsuario = iAdminPasswordBO.existeLoginPass(usuario_tmp.getLogin(),
						usuario_tmp.getPassword());
				if (existeUsuario) {
					usuario_tmp = iusuarioBO.getUsuarioLogin(usuario_tmp);
					if (usuario_tmp == null) {
						logger.debug("check_sesion:" + "Usuario no existe o los datos estan incorrectos");
						modelMap.put("message", "Usuario no existe o los datos estan incorrectos");
						modelMap.put("invalido", true);
					} else {
						if (!usuario_tmp.isActivo()) {
							logger.debug("check_sesion:"
									+ "Usuario esta dado de baja, verifique con el administrador del sistema.");
							modelMap.put("message",
									"Usuario esta dado de baja, verifique con el administrador del sistema.");
							modelMap.put("invalido", true);
						} else {
							logger.debug("check_sesion:" + "Reiniciando sesión");
							usuario_tmp.setPassword(request.getParameter("pa"));
							HttpSession session = request.getSession(true);
							session = request.getSession(true);
							session.setAttribute(ConstantesAdminSale.USER_SESSION, usuario_tmp);
							
							String estado_password= iAdminPasswordBO.estadoLoginPass(usuario_tmp.getLogin(),
									usuario.getPassword());
							
							modelMap.put("estado_pass", estado_password);
							
							modelMap.put("message", "success");
						}
					}
				}
			}
			modelMap.put("success", true);
		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;

	}

	@RequestMapping(value = "/login")
	public @ResponseBody Map<String, ? extends Object> login(@RequestParam("login") String login,
			@RequestParam("password") String password, HttpServletRequest request) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		try {

			UsuarioDTO usuario1 = new UsuarioDTO();
			usuario1.setLogin(UtilsStrings.nullChangeToUpperCase(login));
			// usuario.setPassword(UtilsStrings.nullChangeToUpperCase(password));
			usuario1.setPassword(password);
			
			boolean existeUsuario = iAdminPasswordBO.existeLoginPass(usuario1.getLogin(), usuario1.getPassword());
			iAdminPasswordBO.insertBitacoraAcceso(usuario1.getLogin(), ConstantesGenerales.MODULO_ADMINISTRACIONVENTA,password);
			if (existeUsuario) {
				
								
				UsuarioDTO usuario = iusuarioBO.getUsuarioLogin(usuario1);
				
				String mensaje = "Se guardo el registro con exito";
				
				if (usuario == null) {
					modelMap.put("success", true);
					modelMap.put("error", true);
					modelMap.put("message", "Usuario no existe o los datos estan incorrectos");
				} else {
					usuario.setPassword(password);
					if (!usuario.isActivo()) {
						
						modelMap.put("success", true);
						modelMap.put("error", true);
						modelMap.put("message",
								"Usuario esta dado de baja, verifique con el administrador del sistema.");
					} else {
						// Agrega la sesion para el usuario
						HttpSession session = request.getSession(true);
						session = request.getSession(true);
						session.setAttribute(ConstantesAdminSale.USER_SESSION, usuario);
						modelMap.put("success", true);
						modelMap.put("error", false);
						modelMap.put("message", mensaje);
						
						String estado_password= iAdminPasswordBO.estadoLoginPass(usuario.getLogin(),
								usuario.getPassword());
						if (estado_password == null) {
							estado_password = "T";
						}
						modelMap.put("estado_pass", estado_password);
					}
				}
			}else{
				//Checa si el usuario existe con la forma anterior 
				usuario1 = new UsuarioDTO();
				usuario1.setLogin(UtilsStrings.nullChangeToUpperCase(login));
				usuario1.setPassword(UtilsStrings.nullChangeToUpperCase(password));
				usuario1.setEstatus(90000);
				usuario1 = iusuarioBO.getUsuarioLogin(usuario1);
				if (usuario1==null){
					modelMap.put("success", true);
					modelMap.put("error", true);
					modelMap.put("message", "Usuario no existe o los datos estan incorrectos");
					iAdminPasswordBO.insertBitacoraAcceso(login, 
							ConstantesGenerales.MODULO_ADMINISTRACIONVENTA, password);
					
				}else{
					// Agrega la sesion para el usuario
					HttpSession session = request.getSession(true);
					session = request.getSession(true);
					session.setAttribute(ConstantesAdminSale.USER_SESSION, usuario1);
					
					iAdminPasswordBO.insertBitacoraAcceso(login,
							ConstantesGenerales.MODULO_ADMINISTRACIONVENTA, password);
					iAdminPasswordBO.insertHistorial(login, password, ConstantesGenerales.ESTADO_CADUCO);
					
					//Actualiza el password anterior a ACTUALIZADO para saber que ya pasa por el nuevo 
					//proceso de passwords
					usuario1.setPassword("ACTUALIZADO");
					iusuarioBO.updatePassword(usuario1);
					modelMap.put("success", true);
					modelMap.put("message", "Password expiro para el usario " + login);
					modelMap.put("estado_pass", "C");

				}
				
			
			}

		} catch (Exception dae) {
			modelMap.put("success", false);
			modelMap.put("error", true);
			modelMap.put("message", "Ocurrio un error:" + dae.getMessage());
		}
		return modelMap;

	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/menu")
	public String menu(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Iniciando Menu", locale);
		return "menuwin";
	}
	
	@RequestMapping(value = "/reiniciapassword")
	public String reiniciapassword(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Iniciando Menu", locale);
		return "reiniciapassword";
	}
	
	@RequestMapping(value = "/caducapassword")
	public String caducapassword(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Iniciando Menu", locale);
		return "caducapassword";
	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/logout")
	public String logout(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Cerrando sesion de usuario", locale);

		// Remueve la session existente
		// Save our logged-in user in the session
		HttpSession sessionTerminada = request.getSession(true);

		if (sessionTerminada != null) {
			sessionTerminada.removeAttribute(ConstantesAdminSale.USER_SESSION);
			sessionTerminada.invalidate();
		}
		// Crea una nueva session para el usuario
		sessionTerminada = request.getSession(true);
		sessionTerminada.setAttribute(ConstantesAdminSale.USER_SESSION, null);

		return "home";
	}

	/**
	 * Obtiene las opciones del menu a las que tiene acceso el usuario
	 */
	@RequestMapping(value = "/opcionesmenu")
	public @ResponseBody Map<String, ? extends Object> opcionesmenu(@RequestParam("permiteModulo") String permiteModulo,
			HttpServletRequest request) {
		logger.info("Obteniendo opciones de usuario");
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		ArrayList<PerfilOpcionDTO> arr_perfiles = new ArrayList<PerfilOpcionDTO>();
		try {
			PerfilOpcionDTO perfil = iPerfilOpcionUsuarioBO.getOpcionesPerfilAccesoWin(usuario, permiteModulo);

			// Obtiene las opciones encontradas

			if (usuario != null) {
				arr_perfiles = perfil.arr_perfiles;
				usuario.setPerfiles(arr_perfiles);
			}
			modelMap.put("message", "success");
		} catch (Exception dae) {
			modelMap.put("message", dae.getMessage());

		}

		modelMap.put("proxiArray", arr_perfiles);
		modelMap.put("totalCount", arr_perfiles.size());
		modelMap.put("success", "true");

		return modelMap;

	}

	/**
	 * Obtiene las opciones del menu a las que tiene acceso el usuario
	 */
	@RequestMapping(value = "/opcionesmenuadministracionventa")
	public @ResponseBody Map<String, ? extends Object> opcionesmenuadministracionventa(
			@RequestParam("permiteModulo") String permiteModulo, HttpServletRequest request) {
		logger.info("Obteniendo opciones de usuario");
		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
		ArrayList<PerfilOpcionDTO> arr_perfiles = new ArrayList<PerfilOpcionDTO>();
		try {
			PerfilOpcionDTO perfil = iPerfilOpcionUsuarioBO.getOpcionesPerfilAccesoWin(usuario,
					ConstantesAdminSale.ID_MODULO);

			// Obtiene las opciones encontradas

			if (usuario != null) {
				arr_perfiles = perfil.arr_perfiles;
				usuario.setPerfiles(arr_perfiles);
			}
			modelMap.put("message", "success");
		} catch (Exception dae) {
			modelMap.put("message", dae.getMessage());

		}

		modelMap.put("proxiArray", arr_perfiles);
		modelMap.put("totalCount", arr_perfiles.size());
		modelMap.put("success", "true");

		return modelMap;

	}
	
	/***
	 * Actualiza el password del usuario
	 * @param nombre
	 * @param descripcion
	 * @param estatus
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value= "/updatepassword", method={RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody
	Map<String, ? extends Object> updatepassword(
			@RequestParam(value = "login", required = false) String login,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "passwordnuevo", required = false) String passwordnuevo,
			HttpServletRequest request) throws Exception {


		boolean success = false;
		String mensaje=null;
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		UsuarioDTO usuario = new UsuarioDTO();
		
		UtilsRequest.displayParametros(request);

		
		
		UsuarioDTO usuario_session = ConstantesAdminSale.getSession(request.getSession(true));
		try {
			/*if (usuario_session==null){
				throw new Exception("Usuario no ha iniciado sesion vuelva a intentar.");
			}*/
			
			if (passwordnuevo.trim().length()<=0){
				throw new Exception("Password de usuario invalido.");
			}
			
			PasswordValidator validator = PasswordValidator.buildValidator(
					PasswordValidator.ForceSpecialChar, 
					PasswordValidator.ForceCapitalLetter,PasswordValidator.ForceLowerLetter,
					PasswordValidator.ForceNumber, PasswordValidator.MinLength, PasswordValidator.MaxLength);

			
			if (validator.validatePassword(passwordnuevo)){
				throw new Exception(PasswordValidator.MENSAJE_ERROR);
			}
			//Actualiza nuevo password
			usuario.setLogin(login);
			usuario.setPassword(passwordnuevo);
			//usuario.setNumCliente(usuario_session.getNumCliente());
			
			//bo.updatePassword(usuario);
			iAdminPasswordBO.insertHistorial(usuario.getLogin(), 
					usuario.getPassword(), ConstantesAdminSale.ESTADO_ACTIVO);
			
			HttpSession sessionTerminada = request.getSession(true);

			if (sessionTerminada != null) {
				sessionTerminada.removeAttribute(ConstantesAdminSale.USER_SESSION);
				sessionTerminada.invalidate();
			}
			// Crea una nueva session para el usuario
			sessionTerminada = request.getSession(true);
			sessionTerminada.setAttribute(ConstantesAdminSale.USER_SESSION, null);
			

			modelMap.put("success", true);
			modelMap.put("message", mensaje);
		} catch (Exception dae) {
				modelMap.put("success", success);
				modelMap.put("message", dae.getMessage());
		}
		return modelMap;
	}

}
